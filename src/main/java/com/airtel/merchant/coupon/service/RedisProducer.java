package com.airtel.merchant.coupon.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.airtel.merchant.coupon.config.RedisConfig;
import com.airtel.merchant.coupon.dto.CouponDTO;
import com.airtel.merchant.coupon.util.PartnerConfiguration;

import redis.clients.jedis.Jedis;

@Component
public class RedisProducer {

	private static final Logger logger = LoggerFactory.getLogger(RedisProducer.class);
	private @Autowired PartnerConfiguration partnerConfiguration;
	private @Value("${zadd.set.name}") String zaddSet;
	private @Value("${zadd.retry.period.in.hrs}") String retryPeriodInHrs;

	public void addEntryToZadd(CouponDTO couponDTO) {
		Jedis jedis = RedisConfig.getInstance().getJedis();
		String value = couponDTO.getCustomerIdRefTxnIfId().getCustomerId() + ":"
				+ couponDTO.getCustomerIdRefTxnIfId().getRefTxnId() + ":"
				+ couponDTO.getCustomerIdRefTxnIfId().getCreatedAt();
		long score = System.currentTimeMillis() + (long)(Double.parseDouble(retryPeriodInHrs) * 60 * 60 * 1000);
		logger.info("Storing value "+value+" with score "+score+" in zaddSet "+zaddSet);
		jedis.zadd(zaddSet, score, value);
		logger.info("Stored value "+value+" with score "+score+" in zaddSet "+zaddSet);
		//add entry to redis hash set
		addEntryToRedisHset(couponDTO);
	}

	public void addEntryToRedisHset(CouponDTO couponDTO) {
		Jedis jedis = RedisConfig.getInstance().getJedis();
		String setName = couponDTO.getCustomerIdRefTxnIfId().getCustomerId() + ":"
				+ couponDTO.getCustomerIdRefTxnIfId().getRefTxnId() + ":"
				+ couponDTO.getCustomerIdRefTxnIfId().getCreatedAt();
		String couponExpiryPeriodInDays = partnerConfiguration.getPartnerConfigurationMappings()
				.get(couponDTO.getPartnerId());
		long expiry = couponDTO.getCustomerIdRefTxnIfId().getCreatedAt().getTime()
				+ (long) (Double.parseDouble(couponExpiryPeriodInDays) * 24 * 60 * 60 * 1000);
		int expiryInSeconds = (int) (expiry / 1000);
		logger.info("Storing value "+couponDTO.getResponseData()+" in redis set "+setName);
		jedis.hset(setName, "value", couponDTO.getResponseData());
		logger.info("Stored value "+couponDTO.getResponseData()+" in redis set "+setName);
		jedis.expire(setName, expiryInSeconds);
		logger.info("Set expiry of set "+setName+" in seconds "+expiryInSeconds);
	}

	public void removeEntryFromZadd(CouponDTO couponDTO) {
		Jedis jedis = RedisConfig.getInstance().getJedisPool().getResource();
		String value = couponDTO.getCustomerIdRefTxnIfId().getCustomerId() + ":"
				+ couponDTO.getCustomerIdRefTxnIfId().getRefTxnId() + ":"
				+ couponDTO.getCustomerIdRefTxnIfId().getCreatedAt();
		logger.info("removing value " + value + " from " + zaddSet);
		jedis.zrem(zaddSet, value);
		logger.info("removed value " + value + " from " + zaddSet);
	}

	public void removeEntryFromRedisHashSet(CouponDTO couponDTO) {
		Jedis jedis = RedisConfig.getInstance().getJedisPool().getResource();
		String setName = couponDTO.getCustomerIdRefTxnIfId().getCustomerId() + ":"
				+ couponDTO.getCustomerIdRefTxnIfId().getRefTxnId() + ":"
				+ couponDTO.getCustomerIdRefTxnIfId().getCreatedAt();
		jedis.hdel(setName, "value");
	}
}
