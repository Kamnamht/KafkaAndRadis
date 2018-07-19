package com.airtel.merchant.coupon.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;

import com.airtel.merchant.coupon.dto.CouponDTO;
import com.airtel.merchant.coupon.dto.PartnerTextMessageAndEnableRetry;
import com.airtel.merchant.coupon.exceptions.ProcessingException;
import com.airtel.merchant.coupon.model.loadcash.LoadCashErrorPayload;
import com.airtel.merchant.coupon.model.loadcash.LoadCashRequestBody;
import com.airtel.merchant.coupon.model.loadcash.Response;
import com.airtel.merchant.coupon.model.logger.LoggerModel;
import com.airtel.merchant.coupon.model.sbalead.SBALeadResponse;
import com.airtel.merchant.coupon.repository.CouponRespository;
import com.airtel.merchant.coupon.util.AppUtil;
import com.airtel.merchant.coupon.util.PartnerConfiguration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SBAPayloadProcessor {

	private static final Logger logger = LoggerFactory.getLogger(SBAPayloadProcessor.class);

	private @Value("${newAccount_retry_topic}") String newAccountRetryTopic;
	private @Value("${loadcash_retry_topic}") String loadcashRetryTopic;
	private @Autowired KafkaProducer producer;
	private @Autowired CouponRespository couponRepository;
	private @Autowired AppUtil appUtil;
	private @Autowired ObjectMapper mapper;
	private @Autowired RedisProducer redisProducer;

	private @Value("${SBAPayloadProcessor}") String sbaPayloadProcessorServiceId;
	private @Value("${successful.response.code}") String successResponseCode;
	private @Value("${error.response.code}") String errorResponseCode;
	private @Value("${timeout.code}") String timeoutResponseCode;

	private @Value("${loadcash.api.endpoint}") String loadcashApiEndpoint;
	private @Value("${loadcash.inquiry.api.endpoint}") String loadcashInquiryApiEndpoint;
	private @Value("${loadcash_api_invoked}") String ladcashApiInvoked;
	private @Value("${sba_wallet_created}") String sba_Wallet_Created;
	private @Value("${loadcash_api_failure}") String loadcash_api_failure;
	private @Value("${loadcash_api_timeout}") String loadcash_api_timeout;
	private @Value("${loadcash_api_invokation_failure}") String loadcash_api_invokation_failure;
	private @Value("${coupon_expired}") String coupon_expired;
	private @Value("${payment_success}") String payment_success;
	private @Value("${loadcash.real.mode}") String paymentRealMode;
	private @Value("${loadcash.inquiry.mode}") String paymentInquiryMode;
	private @Value("${lead_registered}") String leadRegistered;
	private @Value("${no_profile_error.code}") String no_profile_errorCode;

	private @Autowired PartnerConfiguration partnerConfiguration;

	public void processSBAPayload(SBALeadResponse payload, String payloadString) {
		logger.info(sbaPayloadProcessorServiceId + ": inside processLoadCashPaylod with payload " + payload);
		if (payload != null) {
			// do the processing
			String customerId = payload.getCustNatlId();
			logger.info(sbaPayloadProcessorServiceId + ": SBA/Wallet opended for customerId " + customerId);
			// get the details of customer for whom errorCode in DB is "LEADREGISTERED" and
			// invoke loadcash api for their requests

			logger.info(sbaPayloadProcessorServiceId + ": Fetching Customer's " + customerId + " data from DB");
			List<CouponDTO> couponDTOList = couponRepository.findByCustomerIdAndStatusCodes(customerId, leadRegistered,
					sba_Wallet_Created);
			logger.info(sbaPayloadProcessorServiceId + ": received Customer data from DB " + couponDTOList);
			if (!CollectionUtils.isEmpty(couponDTOList)) {
				for (CouponDTO couponDTO : couponDTOList) {
					long startTime = System.currentTimeMillis();
					LoggerModel loggerModel = new LoggerModel();
					loggerModel.setStartTime(startTime);
					loggerModel.setPartnerId(couponDTO.getPartnerId());
					loggerModel.setPayload(payloadString);
					loggerModel.setRefTxnId(couponDTO.getCustomerIdRefTxnIfId().getRefTxnId());
					try {
						couponDTO.setStatusCode(sba_Wallet_Created);
						couponDTO.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));
						logger.info(sbaPayloadProcessorServiceId + ": Now, updating DB with latest status code "
								+ couponDTO);
						couponRepository.save(couponDTO);
						logger.info(sbaPayloadProcessorServiceId + ": entry saved into DB");

						// check whether coupon is expired or not
						long loadcashResponseTimestamp = couponDTO.getLoadcashResponseTimestamp().getTime();
						String couponExpiryPeriodInDays = partnerConfiguration.getPartnerConfigurationMappings()
								.get(couponDTO.getPartnerId());
						if (StringUtils.isEmpty(couponExpiryPeriodInDays)) {
							logger.error(sbaPayloadProcessorServiceId + ":" + errorResponseCode
									+ ": couponExpiryPeriodInDays is not availble for partner "
									+ couponDTO.getPartnerId());
							// sendToRetryTopic(payload);
						} else {
							if (loadcashResponseTimestamp
									+ (Double.parseDouble(couponExpiryPeriodInDays) * 24 * 60 * 60 * 1000) >= System
											.currentTimeMillis()) {

								doProcessLoadCash(couponDTO, payload, loggerModel);

							} else {
								logger.error(sbaPayloadProcessorServiceId + ":" + errorResponseCode
										+ ": Coupon Expired for Customer "
										+ couponDTO.getCustomerIdRefTxnIfId().getCustomerId());
								try {
									couponDTO.setStatusCode(coupon_expired);
									couponDTO.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));
									logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode
											+ ": Now, updating DB with latest status code " + couponDTO);
									couponRepository.save(couponDTO);
									logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode
											+ ": entry saved into DB");
								} catch (DataAccessException se) {
									logger.error(sbaPayloadProcessorServiceId + ":" + errorResponseCode
											+ ": Error Occurred while updating entry in DB. Root cause : {}. Error message : {}",
											ExceptionUtils.getRootCause(se), ExceptionUtils.getMessage(se));
									appUtil.addEntryToLoggerModel(loggerModel, se);
								}
							}
						}
					} catch (Exception se) {
						logger.error(sbaPayloadProcessorServiceId + ":" + errorResponseCode
								+ ": Error Occurred while updating entry in DB. Root cause : {}. Error message : {}",
								ExceptionUtils.getRootCause(se), ExceptionUtils.getMessage(se));
						appUtil.addEntryToLoggerModel(loggerModel, se);

						String responseData = couponDTO.getResponseData();
						try {
							LoadCashErrorPayload loadCashErrorPayload = mapper.readValue(responseData,
									LoadCashErrorPayload.class);
							sendToLoadcashRetryTopic(loadCashErrorPayload);
						} catch (Exception e) {
							logger.error("Error Occurred while converting request data for customer "
									+ couponDTO.getCustomerIdRefTxnIfId().getCustomerId() + " and ref txn Id "
									+ couponDTO.getCustomerIdRefTxnIfId().getRefTxnId() + " Partner Id "
									+ couponDTO.getPartnerId());
						}
					} finally {
						logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode
								+ ": Total time taken by processSBAPayload for pyaload " + payload + " - "
								+ (System.currentTimeMillis() - startTime) + " milliseconds.");
						logger.warn(appUtil.convertLoggerModelToString(loggerModel));
					}
				}
			} else {
				logger.error(sbaPayloadProcessorServiceId + ":" + errorResponseCode
						+ ": SBAPayloadProcessor No Customer Found with given Customer NatlID " + customerId);
			}
		} else {
			logger.error(
					sbaPayloadProcessorServiceId + ":" + errorResponseCode + ": SBAPayloadProcessor Payload is null!!");
		}
	}

	private void sendToLoadcashRetryTopic(LoadCashErrorPayload payload) {
		logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode + ": inside sendToErrorTopic with payload "
				+ payload);
		ListenableFuture<SendResult<String, LoadCashErrorPayload>> future = producer.send(loadcashRetryTopic, payload);
		future.addCallback(new ListenableFutureCallback<SendResult<String, LoadCashErrorPayload>>() {
			@Override
			public void onSuccess(SendResult<String, LoadCashErrorPayload> result) {
				logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode
						+ ": Successfully sent record to ERROR topic : " + result.getProducerRecord().topic());
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.error(
						sbaPayloadProcessorServiceId + ":" + errorResponseCode
								+ ": Failed to send record to topic. Root cause : {}. Error message : {}",
						ExceptionUtils.getRootCause(ex), ExceptionUtils.getMessage(ex));
			}
		});
	}

	private void sendToRetryTopic(SBALeadResponse model) {
		logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode + ": inside sendToErrorTopic with payload "
				+ model);
		ListenableFuture<SendResult<String, SBALeadResponse>> future = producer.send(newAccountRetryTopic, model);
		future.addCallback(new ListenableFutureCallback<SendResult<String, SBALeadResponse>>() {
			@Override
			public void onSuccess(SendResult<String, SBALeadResponse> result) {
				logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode
						+ ": Successfully sent record to ERROR topic : " + result.getProducerRecord().topic());
			}

			@Override
			public void onFailure(Throwable e) {
				logger.error(
						sbaPayloadProcessorServiceId + ":" + errorResponseCode
								+ ": Failed to send record to topic. Root cause : : {}. Error message : {}",
						ExceptionUtils.getRootCause(e), ExceptionUtils.getMessage(e));
			}
		});
	}

	public void doProcessLoadCash(CouponDTO couponDTO, LoggerModel loggerModel) {
		// check txn status first. if success then update in db otherwise hit loadcash
		// api
		Map<String, String> responseCodeMessageMap = checkTxnStatus(couponDTO);
		if (responseCodeMessageMap.containsKey(successResponseCode)) {
			// success
			try {
				couponDTO.setStatusCode(payment_success);
				couponDTO.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));
				logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode
						+ ": Now, updating DB with latest status code " + couponDTO);
				couponRepository.save(couponDTO);
				logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode + ": entry saved into DB");
				// remove entries from Redis

				redisProducer.removeEntryFromZadd(couponDTO);
				redisProducer.removeEntryFromRedisHashSet(couponDTO);
			} catch (DataAccessException se) {
				logger.error(
						sbaPayloadProcessorServiceId + ":" + errorResponseCode
								+ ": Error Occurred while updating entry in DB. Root cause : {}. Error message : {}",
						ExceptionUtils.getRootCause(se), ExceptionUtils.getMessage(se));
				appUtil.addEntryToLoggerModel(loggerModel, se);
				redisProducer.addEntryToZadd(couponDTO);
			}
		} else if (responseCodeMessageMap.containsKey(errorResponseCode)) {
			try {
				hitLoadcashAPI(couponDTO, loggerModel);
			} catch (ProcessingException pe) {
				logger.error(
						sbaPayloadProcessorServiceId + ":" + errorResponseCode
								+ ": Error Occurred invoking loadcash api. Root cause : {}. Error message : {}",
						ExceptionUtils.getRootCause(pe), ExceptionUtils.getMessage(pe));
				appUtil.addEntryToLoggerModel(loggerModel, pe);
				redisProducer.addEntryToZadd(couponDTO);
			}
		} else {
			redisProducer.addEntryToZadd(couponDTO);
		}
	}

	private void doProcessLoadCash(CouponDTO couponDTO, SBALeadResponse payload, LoggerModel loggerModel) {
		PartnerTextMessageAndEnableRetry partnerTextMessageAndEnableRetry = partnerConfiguration
				.getPartnerTextMessageMappings().get(couponDTO.getPartnerId() + "_" + couponDTO.getErrorCode());
		if (partnerTextMessageAndEnableRetry != null) {
			if (partnerTextMessageAndEnableRetry.isEnableRetry()) {

				// check txn status first. if success then update in db otherwise hit loadcash
				// api
				Map<String, String> responseCodeMessageMap = checkTxnStatus(couponDTO);
				if (responseCodeMessageMap.containsKey(successResponseCode)) {
					// success
					try {
						couponDTO.setStatusCode(payment_success);
						couponDTO.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));
						logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode
								+ ": Now, updating DB with latest status code " + couponDTO);
						couponRepository.save(couponDTO);
						logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode + ": entry saved into DB");
					} catch (DataAccessException se) {
						logger.error(sbaPayloadProcessorServiceId + ":" + errorResponseCode
								+ ": Error Occurred while updating entry in DB. Root cause : {}. Error message : {}",
								ExceptionUtils.getRootCause(se), ExceptionUtils.getMessage(se));
						appUtil.addEntryToLoggerModel(loggerModel, se);
					}
				} else if (responseCodeMessageMap.containsKey(errorResponseCode)) {
					hitLoadcashAPI(couponDTO, loggerModel);
				} else {
					// retry logic
					sendToRetryTopic(payload);
				}
			}
		}
	}

	private Map<String, String> checkTxnStatus(CouponDTO couponDTO) {
		Map<String, String> responseCodeMessageMap = new HashMap<String, String>();
		try {
			String newloadcashInquiryApiEndpoint = loadcashInquiryApiEndpoint.replace("<partnerId>",
					couponDTO.getPartnerId());

			LoadCashErrorPayload loadCashErrorPayload = mapper.readValue(couponDTO.getResponseData(),
					LoadCashErrorPayload.class);

			LoadCashRequestBody requestBody = new LoadCashRequestBody(
					loadCashErrorPayload.getRequest().getPartnerTxnRefNo(),
					loadCashErrorPayload.getRequest().getChannel(), paymentInquiryMode,
					loadCashErrorPayload.getRequest().getRequestTimeStamp(),
					loadCashErrorPayload.getRequest().getBeneficiaryDetail(),
					loadCashErrorPayload.getRequest().getAdditionalSMSData(),
					loadCashErrorPayload.getRequest().getCrNarrative(),
					loadCashErrorPayload.getRequest().getFreeField1(),
					loadCashErrorPayload.getRequest().getFreeField2(),
					loadCashErrorPayload.getRequest().getFreeField3());

			logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode
					+ ": invoking invokePostURL of AppUtil with " + newloadcashInquiryApiEndpoint + " and data  "
					+ requestBody);

			String response = appUtil.invokePostURL(newloadcashInquiryApiEndpoint, requestBody);
			logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode + ": response "
					+ newloadcashInquiryApiEndpoint + " received after hitting url ", response);

			if (!StringUtils.isEmpty(response)) {
				try {
					Response responseJSON = mapper.readValue(response, Response.class);
					String stringCode = responseJSON.getMeta().getCode();
					// int responseCode = Integer.parseInt(stringCode);
					if (stringCode.equalsIgnoreCase(successResponseCode)) {
						responseCodeMessageMap.put(successResponseCode, payment_success);
						return responseCodeMessageMap;
					} else if (stringCode.equalsIgnoreCase(errorResponseCode)) {
						String errorCode = responseJSON.getMeta().getErrors().get(0).getCode();
						responseCodeMessageMap.put(errorResponseCode, errorCode);
						return responseCodeMessageMap;
					}
				} catch (Exception pe) {
					logger.error(sbaPayloadProcessorServiceId + ":" + errorResponseCode
							+ ": Error Occurred while parsing responseCode to integer. Root cause : {}. Error message : {}",
							ExceptionUtils.getRootCause(pe), ExceptionUtils.getMessage(pe));
					responseCodeMessageMap.put(timeoutResponseCode, "exception occurred");
					return responseCodeMessageMap;
				}
			}
		} catch (HttpStatusCodeException e) {
			try {
				String responseString = e.getResponseBodyAsString();
				Response responseJSON = mapper.readValue(responseString, Response.class);
				String stringCode = responseJSON.getMeta().getCode();
				if (stringCode.equalsIgnoreCase(errorResponseCode)) {
					String errorCode = responseJSON.getMeta().getErrors().get(0).getCode();
					responseCodeMessageMap.put(errorResponseCode, errorCode);
					return responseCodeMessageMap;
				} else {
					responseCodeMessageMap.put(timeoutResponseCode, loadcash_api_timeout);
					return responseCodeMessageMap;
				}
			} catch (Exception e1) {
				responseCodeMessageMap.put(timeoutResponseCode, "exception occurred");
				return responseCodeMessageMap;
			}
		} catch (IOException | RestClientException e1) {
			logger.error(sbaPayloadProcessorServiceId + ":" + errorResponseCode
					+ ": Error occurred while hitting loadcash inquiry api . Root cause : {}. Error message : {}",
					ExceptionUtils.getRootCause(e1), ExceptionUtils.getMessage(e1));
			responseCodeMessageMap.put(timeoutResponseCode, "exception occurred");
			return responseCodeMessageMap;
		}
		responseCodeMessageMap.put(timeoutResponseCode, "exception occurred");
		return responseCodeMessageMap;
	}

	private void hitLoadcashAPI(CouponDTO couponDTO, LoggerModel loggerModel) {
		// hit loadcash api
		String newLoadcashApiEndpoint = loadcashApiEndpoint.replace("<partnerId>", couponDTO.getPartnerId());

		try {
			LoadCashErrorPayload loadCashErrorPayload = mapper.readValue(couponDTO.getResponseData(),
					LoadCashErrorPayload.class);

			LoadCashRequestBody requestBody = new LoadCashRequestBody(
					loadCashErrorPayload.getRequest().getPartnerTxnRefNo(),
					loadCashErrorPayload.getRequest().getChannel(), paymentRealMode,
					loadCashErrorPayload.getRequest().getRequestTimeStamp(),
					loadCashErrorPayload.getRequest().getBeneficiaryDetail(),
					loadCashErrorPayload.getRequest().getAdditionalSMSData(),
					loadCashErrorPayload.getRequest().getCrNarrative(),
					loadCashErrorPayload.getRequest().getFreeField1(),
					loadCashErrorPayload.getRequest().getFreeField2(),
					loadCashErrorPayload.getRequest().getFreeField3());

			logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode
					+ ": invoking invokePostURL of AppUtil with " + newLoadcashApiEndpoint + " and data  "
					+ requestBody);

			try {
				String response = appUtil.invokePostURL(newLoadcashApiEndpoint, requestBody);
				logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode + ": response "
						+ newLoadcashApiEndpoint + " received after hitting url ", response);

				if (!StringUtils.isEmpty(response)) {
					Response responseJSON = mapper.readValue(response, Response.class);
					if (responseJSON.getMeta().getCode().equalsIgnoreCase(successResponseCode)) {

						try {
							couponDTO.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));
							couponDTO.setStatusCode(payment_success);
							logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode
									+ ": Now, updating DB with latest status code " + couponDTO);
							couponRepository.save(couponDTO);

							logger.info(
									sbaPayloadProcessorServiceId + ":" + successResponseCode + ": entry saved into DB");
						} catch (DataAccessException se) {
							logger.error(sbaPayloadProcessorServiceId + ":" + errorResponseCode
									+ ": Error Occurred while updating entry in DB. Root cause : {}. Error message : {}",
									ExceptionUtils.getRootCause(se), ExceptionUtils.getMessage(se));
							appUtil.addEntryToLoggerModel(loggerModel, se);
						}
					}
				}

			} catch (ResourceAccessException rae) {
				logger.error(
						sbaPayloadProcessorServiceId + ":" + timeoutResponseCode
								+ ": LoadCash API timed out. Root cause : {}. Error message : {}",
						ExceptionUtils.getRootCause(rae), ExceptionUtils.getMessage(rae));
				try {
					couponDTO.setStatusCode(loadcash_api_timeout);
					couponDTO.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));
					logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode
							+ ": Now, updating DB with latest status code " + couponDTO);
					couponRepository.save(couponDTO);
					logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode + ": entry saved into DB");
				} catch (DataAccessException se) {
					logger.error(sbaPayloadProcessorServiceId + ":" + errorResponseCode
							+ ": Error Occurred while updating entry in DB. Root cause : {}. Error message : {}",
							ExceptionUtils.getRootCause(se), ExceptionUtils.getMessage(se));
					appUtil.addEntryToLoggerModel(loggerModel, se);
				}
				appUtil.addEntryToLoggerModel(loggerModel, rae);
				throw new ProcessingException("SBAPayloadProcessor LoadCash API timed out " + rae.getMessage());
			} catch (RestClientException | JsonProcessingException rce) {
				try {
					couponDTO.setStatusCode(loadcash_api_invokation_failure);
					couponDTO.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));
					logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode
							+ ": Now, updating DB with latest status code " + couponDTO);
					couponRepository.save(couponDTO);
					logger.info(sbaPayloadProcessorServiceId + ":" + successResponseCode + ": entry saved into DB");
				} catch (DataAccessException se) {
					logger.error(sbaPayloadProcessorServiceId + ":" + errorResponseCode
							+ ": Error Occurred while updating entry in DB. Root cause : {}. Error message : {}",
							ExceptionUtils.getRootCause(se), ExceptionUtils.getMessage(se));
				}
				appUtil.addEntryToLoggerModel(loggerModel, rce);
				throw new ProcessingException(
						"SBAPayloadProcessor " + "Error occurred while hitting loadcash api " + rce.getMessage());
			}
		} catch (IOException e) {
			logger.error(sbaPayloadProcessorServiceId + ":" + errorResponseCode
					+ ": SBAPayloadProcessor Loadcash api couldn't be invoked " + e.getMessage());
			appUtil.addEntryToLoggerModel(loggerModel, e);
		}
	}
}
