package com.airtel.merchant.coupon.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class RedisConfig {

	private static String redisHost;
	private static RedisConfig redisConfig;
	private static JedisPool jedisPool = null;
	private static Jedis jedis = null;

	public static RedisConfig getInstance() {
		if (redisConfig == null) {
			redisConfig = new RedisConfig();
			JedisPoolConfig poolConfig = buildPoolConfig();
			jedisPool = new JedisPool(poolConfig, redisHost, 6379);
			jedis = jedisPool.getResource();
		}
		return redisConfig;
	}
	
	@Value("${spring.redis.host}")
    public void setDatabase(String redisHost) {
		RedisConfig.redisHost = redisHost;
    }


	public JedisPool getJedisPool() {
		return jedisPool;
	}
	
	public Jedis getJedis() {
		return jedis;
	}

	private static JedisPoolConfig buildPoolConfig() {
		final JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(128);
		poolConfig.setMaxIdle(128);
		poolConfig.setMinIdle(16);
		poolConfig.setTestOnBorrow(true);
		poolConfig.setTestOnReturn(true);
		poolConfig.setTestWhileIdle(true);
		poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
		poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
		poolConfig.setNumTestsPerEvictionRun(3);
		poolConfig.setBlockWhenExhausted(true);
		return poolConfig;
	}
}
