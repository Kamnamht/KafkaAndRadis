package com.airtel.merchant.coupon.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.airtel.merchant.coupon.dto.CouponDTO;
import com.airtel.merchant.coupon.dto.KafkaUnProcessedMessage;
import com.airtel.merchant.coupon.model.loadcash.LoadCashErrorPayload;
import com.airtel.merchant.coupon.model.logger.LoggerModel;
import com.airtel.merchant.coupon.model.logger.LoggerModel.LoggerError;
import com.airtel.merchant.coupon.model.sbalead.SBALeadResponse;
import com.airtel.merchant.coupon.repository.CouponRespository;
import com.airtel.merchant.coupon.repository.KafkaUnProcessedMessageRepository;
import com.airtel.merchant.coupon.util.AppUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by A1BRCQQX 29/03/2018
 */
@EnableRetry
@Component
public class KafkaConsumer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

	private @Autowired KafkaUnProcessedMessageRepository kafkaUnProcessedMessageRepository;
	private @Autowired LoadCashPayloadProcessor2 loadCashPayloadProcessor;
	private @Autowired SBAPayloadProcessor sbaPayloadProcessor;
	private @Autowired RedisProducer redisProducer;
	private @Autowired CouponRespository couponRepository;
	private @Autowired ObjectMapper mapper;
	private @Autowired AppUtil appUtil;
	private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");

	@KafkaListener(topics = "${loadcasherror.topic.name}", containerFactory = "unregisteredKafkaListenerContainerFactory")
	public void loadCashApiListener(String payload) {
		logger.info("Received loadcasherror message: " + payload);
		// if payload is not empty then convert it into model, if not converted then
		// dump it into UnprocessedMessage Repo
		if (!StringUtils.isEmpty(payload)) {
			try {
				LoadCashErrorPayload loadCashErrorPayload = mapper.readValue(payload, LoadCashErrorPayload.class);
				loadCashPayloadProcessor.processLoadCashPaylod(loadCashErrorPayload, payload);
			} catch (IOException e) {
				LoggerModel loggerModel = new LoggerModel();
				loggerModel.setPayload(payload);
				LoggerError error = new LoggerError();
				error.setErrorCode("1");
				error.setErrorDescription(e.getMessage());
				loggerModel.getErrors().add(error);
				try {
					// store unprocessed payload to DB
					kafkaUnProcessedMessageRepository
							.save(new KafkaUnProcessedMessage(System.currentTimeMillis(), payload));
					logger.error("Cannot process payload : {}. Root cause : {}. Error message : {}", payload,
							ExceptionUtils.getRootCause(e), ExceptionUtils.getMessage(e));
				} catch (DataAccessException se) {
					logger.error(
							"Exception occured while saving unprocessed message to DB. Root cause : {}. Error message : {}",
							ExceptionUtils.getRootCause(e), ExceptionUtils.getMessage(e));
					LoggerError error1 = new LoggerError();
					error1.setErrorCode("1");
					error1.setErrorDescription(se.getMessage());
					loggerModel.getErrors().add(error1);
				} finally {
					logger.warn(appUtil.convertLoggerModelToString(loggerModel));
				}
			}
		}
	}

	@KafkaListener(topics = "${newAccount.topic.name}", containerFactory = "newAccountKafkaListenerContainerFactory")
	// @Retryable(value = { DataAccessException.class,
	// ProcessingException.class }, backoff = @Backoff(delay = 20000, multiplier =
	// 3))
	public void newSBAPartitionListener(String payload) {
		logger.info("Recieved sba message: " + payload);
		if (!StringUtils.isEmpty(payload)) {
			try {
				SBALeadResponse payloadModel = mapper.readValue(payload, SBALeadResponse.class);
				sbaPayloadProcessor.processSBAPayload(payloadModel, payload);
			} catch (IOException e) {
				LoggerModel loggerModel = new LoggerModel();
				loggerModel.setPayload(payload);
				LoggerError error = new LoggerError();
				error.setErrorCode("1");
				error.setErrorDescription(e.getMessage());
				loggerModel.getErrors().add(error);
				try {
					// store unprocessed payload to DB
					kafkaUnProcessedMessageRepository
							.save(new KafkaUnProcessedMessage(System.currentTimeMillis(), payload));
					logger.error("Cannot process payload : {}. Root cause : {}. Error message : {}", payload,
							ExceptionUtils.getRootCause(e), ExceptionUtils.getMessage(e));
				} catch (DataAccessException se) {
					logger.error(
							"Exception occured while saving unprocessed message to DB. Root cause : {}. Error message : {}",
							ExceptionUtils.getRootCause(e), ExceptionUtils.getMessage(e));
					LoggerError error1 = new LoggerError();
					error1.setErrorCode("1");
					error1.setErrorDescription(se.getMessage());
					loggerModel.getErrors().add(error1);
				} finally {
					logger.warn(appUtil.convertLoggerModelToString(loggerModel));
				}
			}
		}
	}

	@KafkaListener(topics = "${loadcash_retry_topic}", containerFactory = "retryTopicKafkaListenerContainerFactory")
	public void newRetryTopicListener(String payload) {
		logger.info("Recieved retry message: " + payload);
		if (!StringUtils.isEmpty(payload)) {
			try {
				LoadCashErrorPayload loadCashErrorPayload = mapper.readValue(payload, LoadCashErrorPayload.class);

				DATE_TIME_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
				long loadcashrequestTimeStampInMillis = DATE_TIME_FORMAT
						.parse(loadCashErrorPayload.getRequest().getRequestTimeStamp()).getTime();

				CouponDTO couponDTO = couponRepository.findByCustomerIdAndRefTxnIdAndRequestCreatedAt(
						loadCashErrorPayload.getRequest().getBeneficiaryDetail().getBeneficiaryMobileNumber(),
						loadCashErrorPayload.getRequest().getPartnerTxnRefNo(),
						new Timestamp(loadcashrequestTimeStampInMillis));
				redisProducer.addEntryToZadd(couponDTO);
			} catch (IOException | ParseException e) {
				LoggerModel loggerModel = new LoggerModel();
				loggerModel.setPayload(payload);
				try {
					LoggerError error = new LoggerError();
					error.setErrorCode("1");
					error.setErrorDescription(e.getMessage());
					loggerModel.getErrors().add(error);

					logger.error("Cannot process payload : {}. Root cause : {}. Error message : {}", payload,
							ExceptionUtils.getRootCause(e), ExceptionUtils.getMessage(e));
				} finally {
					logger.warn(appUtil.convertLoggerModelToString(loggerModel));
				}
			}
		}
	}
}
