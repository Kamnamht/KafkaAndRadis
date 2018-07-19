package com.airtel.merchant.coupon.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.airtel.merchant.coupon.config.RedisConfig;
import com.airtel.merchant.coupon.dto.CouponDTO;
import com.airtel.merchant.coupon.model.loadcash.LoadCashErrorPayload;
import com.airtel.merchant.coupon.model.logger.LoggerModel;
import com.airtel.merchant.coupon.repository.CouponRespository;
import com.airtel.merchant.coupon.util.AppUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

@Component
@EnableScheduling
public class RedisConsumer {

	private static final Logger logger = LoggerFactory.getLogger(RedisConsumer.class);
	private @Value("${zadd.set.name}") String zaddSet;
	private @Autowired ObjectMapper objectMapper;
	private @Autowired CouponRespository couponRepository;
	private @Autowired SBAPayloadProcessor sbaPayloadProcessor;
	private @Autowired AppUtil appUtil;
	private @Autowired RedisProducer redisProducer;
	private static SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");

	@Scheduled(fixedDelay = 10000)
	public void consume() {
		Jedis jedis = RedisConfig.getInstance().getJedis();
		Set<Tuple> tupleSet = jedis.zrangeByScoreWithScores(zaddSet, 0, System.currentTimeMillis());
		for (Tuple tuple : tupleSet) {
			logger.info("Score " + tuple.getScore() + " Element " + tuple.getElement());
			String value = tuple.getElement();
			String responseData = jedis.hget(value, "value");
			if (responseData != null) {
				LoggerModel loggerModel = new LoggerModel();
				try {
					loggerModel.setStartTime(System.currentTimeMillis());
					LoadCashErrorPayload loadCashErrorPayload = objectMapper.readValue(responseData,
							LoadCashErrorPayload.class);
					logger.info("loadCashErrorPayload created for "+responseData);
					loggerModel.setPartnerId(loadCashErrorPayload.getRequest().getPartnerId());
					loggerModel.setPayload(responseData);
					loggerModel.setRefTxnId(loadCashErrorPayload.getRequest().getPartnerTxnRefNo());

					DATE_TIME_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
					long loadcashrequestTimeStampInMillis = DATE_TIME_FORMAT
							.parse(loadCashErrorPayload.getRequest().getRequestTimeStamp()).getTime();

					CouponDTO couponDTO = couponRepository.findByCustomerIdAndRefTxnIdAndRequestCreatedAt(
							loadCashErrorPayload.getRequest().getBeneficiaryDetail().getBeneficiaryMobileNumber(),
							loadCashErrorPayload.getRequest().getPartnerTxnRefNo(),
							new Timestamp(loadcashrequestTimeStampInMillis));
					logger.info("Invoking doProcessLoadCash for "+couponDTO);
					sbaPayloadProcessor.doProcessLoadCash(couponDTO, loggerModel);
				} catch (IOException | ParseException e) {
					appUtil.addEntryToLoggerModel(loggerModel, e);
					logger.error("Exception occurred while processing " + responseData + " for value " + value);
				}  finally {
					logger.warn(appUtil.convertLoggerModelToString(loggerModel));
				}
			}	else		{
				logger.info("Response Data for value "+value+" is null in Redis HashSet");
				//delete entry from Zadd
//				redisProducer.removeEntryFromZadd(couponDTO);
			}

		}
	}
}
