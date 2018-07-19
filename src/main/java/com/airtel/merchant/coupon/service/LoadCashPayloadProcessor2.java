package com.airtel.merchant.coupon.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.RestClientException;

import com.airtel.merchant.coupon.dto.CouponDTO;
import com.airtel.merchant.coupon.dto.CustomerIdRefTxnIfId;
import com.airtel.merchant.coupon.dto.PartnerTextMessageAndEnableRetry;
import com.airtel.merchant.coupon.exceptions.DBAccessException;
import com.airtel.merchant.coupon.exceptions.ProcessingException;
import com.airtel.merchant.coupon.helper.VOHelper;
import com.airtel.merchant.coupon.model.loadcash.LoadCashErrorPayload;
import com.airtel.merchant.coupon.model.logger.LoggerModel;
import com.airtel.merchant.coupon.model.sbalead.SBALeadBody;
import com.airtel.merchant.coupon.model.sms.SendSMS;
import com.airtel.merchant.coupon.repository.CouponRespository;
import com.airtel.merchant.coupon.util.AppUtil;
import com.airtel.merchant.coupon.util.PartnerConfiguration;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class LoadCashPayloadProcessor2 {

	private static final Logger logger = LoggerFactory.getLogger(LoadCashPayloadProcessor2.class);

	private @Value("${loadcash_retry_topic}") String loadcashRetryTopic;

	private @Value("${LoadCashPayloadProcessor}") String loadCashPayloadProcessorServiceId;

	private @Autowired KafkaProducer producer;
	private @Autowired CouponRespository couponRepository;
	private @Autowired VOHelper voHelper;
	private @Autowired AppUtil appUtil;

	private @Value("${successful.response.code}") String successResponseCode;
	private @Value("${sba.ucid}") String sbaUcId;
	private @Value("${error.response.code}") String errorResponseCode;
	private @Value("${timeout.code}") String timeoutResponseCode;

	private @Value("${no_profile_error.code}") String no_profile_errorCode;
	private @Value("${lead.creation.endpoint}") String leadCreationEndpoint;
	private @Value("${sms.sending.endpoint}") String smsSendingEndpoint;
	private @Value("${sms_sent}") String smsSentStatus;
	private @Value("${lead_registered}") String leadRegistered;
	private @Value("${txn_initiated}") String txnInitiated;
	private @Value("${payment_success}") String payment_success;
	private @Autowired PartnerConfiguration partnerConfiguration;
	private static SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");

	public void processLoadCashPaylod(LoadCashErrorPayload payload, String payloadString) {
		logger.info(loadCashPayloadProcessorServiceId + ": inside processLoadCashPaylod with payload " + payload);
		long startTime = System.currentTimeMillis();
		LoggerModel loggerModel = new LoggerModel();
		loggerModel.setStartTime(startTime);
		try {
			if (payload != null) {
				String partnerId = payload.getRequest().getPartnerId();
				String refTxnId = payload.getRequest().getPartnerTxnRefNo();
				String voltRefTxnId = payload.getResponse().getData().getBankTxnId();
				String customerId = payload.getRequest().getBeneficiaryDetail().getBeneficiaryMobileNumber();
				String errorCode = payload.getResponse().getMeta().getErrors().get(0).getCode();
				String loadcashResponseTimestamp = payload.getResponse().getData().getResponseTimeStamp();
				String amount = payload.getRequest().getBeneficiaryDetail().getTxnAmount();
				String requestTimeStamp = payload.getRequest().getRequestTimeStamp();
				loggerModel.setPartnerId(partnerId);
				loggerModel.setPayload(payloadString);
				loggerModel.setRefTxnId(refTxnId);
				try {
					DATE_TIME_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
					long loadcashResponseTimestampInMillis = DATE_TIME_FORMAT.parse(loadcashResponseTimestamp)
							.getTime();
					long loadcashrequestTimeStampInMillis = DATE_TIME_FORMAT.parse(requestTimeStamp).getTime();
					// check whether entry for partnerId and refTxnId is already
					// exists or not
					CustomerIdRefTxnIfId customerIdRefTxnId = new CustomerIdRefTxnIfId(customerId, refTxnId,
							new Timestamp(loadcashrequestTimeStampInMillis));
					CouponDTO existingCouponDTO = couponRepository.findOne(customerIdRefTxnId);
					if (existingCouponDTO != null) {
						// its older entry, so except original request time update every column in DB
						// and then will process it

						CouponDTO couponDTO = new CouponDTO();
						CustomerIdRefTxnIfId customerIdRefTxnIfId = new CustomerIdRefTxnIfId();
						customerIdRefTxnIfId.setCustomerId(customerId);
						customerIdRefTxnIfId.setRefTxnId(refTxnId);
						customerIdRefTxnIfId.setCreatedAt(existingCouponDTO.getCustomerIdRefTxnIfId().getCreatedAt());

						couponDTO.setCustomerIdRefTxnIfId(customerIdRefTxnIfId);
						couponDTO.setPartnerId(partnerId);
						couponDTO.setVoltRefTxnId(voltRefTxnId);
						couponDTO.setResponseData(payloadString);

						couponDTO.setErrorCode(errorCode);
						couponDTO.setAmount(amount);
						couponDTO.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));
						couponDTO.setLoadcashResponseTimestamp(
								new Timestamp(Long.valueOf(loadcashResponseTimestampInMillis)));

						// check statusCode if its not success then invoke doProcess otherwise
						// do nothing

						String statusCode = existingCouponDTO.getStatusCode();
						if (!payment_success.equalsIgnoreCase(statusCode)) {
							couponDTO.setStatusCode(txnInitiated);
							doProcess(payload, couponDTO, payload.getResponse().getMeta().getErrors(), loggerModel);
						}
					} else {
						// prepare couponDTO from request and response data
						CouponDTO couponDTO = new CouponDTO();
						CustomerIdRefTxnIfId customerIdRefTxnIfId = new CustomerIdRefTxnIfId();
						customerIdRefTxnIfId.setCustomerId(customerId);
						customerIdRefTxnIfId.setRefTxnId(refTxnId);
						customerIdRefTxnIfId.setCreatedAt(new Timestamp(loadcashrequestTimeStampInMillis));

						couponDTO.setCustomerIdRefTxnIfId(customerIdRefTxnIfId);
						couponDTO.setPartnerId(partnerId);
						couponDTO.setVoltRefTxnId(voltRefTxnId);
						couponDTO.setResponseData(payloadString);
						couponDTO.setErrorCode(errorCode);
						couponDTO.setStatusCode(txnInitiated);
						couponDTO.setAmount(amount);
						couponDTO.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));
						couponDTO.setLoadcashResponseTimestamp(
								new Timestamp(Long.valueOf(loadcashResponseTimestampInMillis)));
						doProcess(payload, couponDTO, payload.getResponse().getMeta().getErrors(), loggerModel);
					}
				} catch (ParseException e) {
					appUtil.addEntryToLoggerModel(loggerModel, e);

					logger.error(loadCashPayloadProcessorServiceId + ":" + errorResponseCode
							+ ": Error parsing loadcashResponseTimestamp to long : {}. Root cause : {}. Error message : {}",
							ExceptionUtils.getRootCause(e), ExceptionUtils.getMessage(e));
				}
			} else {
				logger.error(loadCashPayloadProcessorServiceId + ":" + errorResponseCode + ": Payload is null!!");
			}
		} finally {
			logger.info(loadCashPayloadProcessorServiceId + ":" + successResponseCode + " " + loggerModel.getPartnerId()
					+ ": Total time taken by processLoadCashPaylod for pyaload " + payload + " - "
					+ (System.currentTimeMillis() - startTime) + " milliseconds.");
			logger.warn(appUtil.convertLoggerModelToString(loggerModel));
		}
	}

	private void sendToLoadcashRetryTopic(LoadCashErrorPayload payload) {
		logger.info(loadCashPayloadProcessorServiceId + ":" + successResponseCode
				+ ": inside sendToErrorTopic with payload " + payload);
		ListenableFuture<SendResult<String, LoadCashErrorPayload>> future = producer.send(loadcashRetryTopic, payload);
		future.addCallback(new ListenableFutureCallback<SendResult<String, LoadCashErrorPayload>>() {
			@Override
			public void onSuccess(SendResult<String, LoadCashErrorPayload> result) {
				logger.info(loadCashPayloadProcessorServiceId + ":" + successResponseCode
						+ ": Successfully sent record to ERROR topic : " + result.getProducerRecord().topic());
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.error(
						loadCashPayloadProcessorServiceId + ":" + errorResponseCode
								+ ": Failed to send record to topic. Root cause : {}. Error message : {}",
						ExceptionUtils.getRootCause(ex), ExceptionUtils.getMessage(ex));
			}
		});
	}

	private void doProcess(LoadCashErrorPayload payload, CouponDTO couponDTO,
			List<com.airtel.merchant.coupon.model.loadcash.Error> errors, LoggerModel loggerModel) {
		try {
			couponRepository.save(couponDTO);
			logger.info(loadCashPayloadProcessorServiceId + ": entry saved into DB");

			boolean noAccountFoundStatus = false;
			for (com.airtel.merchant.coupon.model.loadcash.Error error : errors) {

				try {
					PartnerTextMessageAndEnableRetry partnerTextMessageAndEnableRetry = partnerConfiguration
							.getPartnerTextMessageMappings()
							.get(couponDTO.getPartnerId() + "_" + couponDTO.getErrorCode());
					if (partnerTextMessageAndEnableRetry != null) {
						if (partnerTextMessageAndEnableRetry.isEnableRetry()) {
							// prepare SendSMS body
							SendSMS sendSMSBody = voHelper.prepareSendSMSObject(couponDTO,
									partnerTextMessageAndEnableRetry);
							// create entity by setting body data and headers
							// and hit url
							logger.info(loadCashPayloadProcessorServiceId + ": invoking invokePostURL of AppUtil with "
									+ smsSendingEndpoint + " and data  " + sendSMSBody);

							String response = appUtil.invokePostURL(smsSendingEndpoint, sendSMSBody);

							logger.info(loadCashPayloadProcessorServiceId + ": response " + response
									+ " received after hitting " + smsSendingEndpoint);

							// after sending sms, check if its not "Customer Not registered" then send that
							// message to retryTopic.
							if (error.getCode().equalsIgnoreCase(no_profile_errorCode)) {
								noAccountFoundStatus = true;
							} else {
								sendToLoadcashRetryTopic(payload);
							}
							try {
								couponDTO.setStatusCode(smsSentStatus);
								couponDTO.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));
								logger.info(loadCashPayloadProcessorServiceId + ":" + successResponseCode
										+ ": Now, updating DB with latest status code " + couponDTO);
								couponRepository.save(couponDTO);
								logger.info(loadCashPayloadProcessorServiceId + ":" + successResponseCode + ": entry "
										+ couponDTO + " saved into DB");
							} catch (DataAccessException se) {
								logger.error(loadCashPayloadProcessorServiceId + ":" + errorResponseCode
										+ ": Error Occurred while updating entry in DB. Root cause : {}. Error message : {}",
										ExceptionUtils.getRootCause(se), ExceptionUtils.getMessage(se));
								appUtil.addEntryToLoggerModel(loggerModel, se);
							}
						} else {
							logger.info("Retry not implemented for merchantId " + couponDTO.getPartnerId()
									+ " error Code " + couponDTO.getErrorCode());
							if (error.getCode().equalsIgnoreCase(no_profile_errorCode)) {
								noAccountFoundStatus = true;
							}
						}
					} else {
						logger.info("Merchant Configuration not found for merchantId " + couponDTO.getPartnerId()
								+ " and errorCode " + couponDTO.getErrorCode());
						// sendToLoadcashRetryTopic(payload);
					}
				} catch (RestClientException | JsonProcessingException | ProcessingException rae) {
					logger.error(loadCashPayloadProcessorServiceId + ":" + errorResponseCode
							+ ": Error Occurred while hitting smsSendingEndpoint : {}. Root cause : {}. Error message : {}",
							smsSendingEndpoint, ExceptionUtils.getRootCause(rae), ExceptionUtils.getMessage(rae));
					appUtil.addEntryToLoggerModel(loggerModel, rae);
				}
			}

			if (noAccountFoundStatus) {
				// hit SBA lead api
				SBALeadBody sbaLeadBody = voHelper.prepareSBALeadBody(
						couponDTO.getCustomerIdRefTxnIfId().getCustomerId(), couponDTO.getPartnerId(),
						couponDTO.getCustomerIdRefTxnIfId().getRefTxnId());
				logger.info(loadCashPayloadProcessorServiceId + ":" + successResponseCode + ": sbaLeadBody created "
						+ sbaLeadBody);
				if (sbaLeadBody != null) {
					try {
						String leadCreationEndpointNew = leadCreationEndpoint.replace("ucId", sbaUcId);
						logger.info("invoking invokePostURL of AppUtil with " + leadCreationEndpointNew + " and data  "
								+ sbaLeadBody);
						String response = appUtil.invokePostURL(leadCreationEndpointNew, sbaLeadBody);
						logger.info(loadCashPayloadProcessorServiceId + ":" + successResponseCode
								+ ":response received after hitting url ", response, leadCreationEndpoint);
						couponDTO.setStatusCode(leadRegistered);
						couponDTO.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));
						try {
							logger.info(loadCashPayloadProcessorServiceId + ":" + successResponseCode
									+ ": Now, updating DB with latest status code " + couponDTO);
							couponRepository.save(couponDTO);
							logger.info(loadCashPayloadProcessorServiceId + ":" + successResponseCode + ": entry "
									+ couponDTO + " saved into DB");
						} catch (DataAccessException se) {
							logger.error(loadCashPayloadProcessorServiceId + ":" + errorResponseCode
									+ ": Error Occurred while updating entry in DB. Root cause : {}. Error message : {}",
									ExceptionUtils.getRootCause(se), ExceptionUtils.getMessage(se));
							appUtil.addEntryToLoggerModel(loggerModel, se);
						}
					} catch (RestClientException | JsonProcessingException re) {
						logger.error(loadCashPayloadProcessorServiceId + ":" + errorResponseCode
								+ ": Error Occurred while hitting leadCreationEndpoint : {}. Root cause : {}. Error message : {}",
								leadCreationEndpoint, ExceptionUtils.getRootCause(re), ExceptionUtils.getMessage(re));

						appUtil.addEntryToLoggerModel(loggerModel, re);
					}
				} else {
					logger.error(loadCashPayloadProcessorServiceId + ":" + errorResponseCode
							+ ": Couldn't prepare SBALeadEndpoint request body for customerId "
							+ couponDTO.getCustomerIdRefTxnIfId().getCustomerId());
					appUtil.addEntryToLoggerModel(loggerModel,
							new Exception("Couldn't prepare SBALeadEndpoint request body for customerId "
									+ couponDTO.getCustomerIdRefTxnIfId().getCustomerId()));
				}
			}
		} catch (DataAccessException se) {
			logger.error(loadCashPayloadProcessorServiceId + ":" + errorResponseCode
					+ ": Error Occurred while hitting leadCreationEndpoint : {}. Root cause : {}. Error message : {}",
					leadCreationEndpoint, ExceptionUtils.getRootCause(se), ExceptionUtils.getMessage(se));
			appUtil.addEntryToLoggerModel(loggerModel, se);
			throw new DBAccessException("Error Occurred while updating entry in DB " + se.getMessage());
		}
	}
}
