package com.airtel.merchant.coupon.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.airtel.merchant.coupon.model.loadcash.LoadCashErrorPayload;
import com.airtel.merchant.coupon.model.sbalead.SBALeadResponse;

/**
 * Created by b0200901 on 1/9/2018
 */
@Component
public class KafkaProducer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<String, LoadCashErrorPayload> kafkaTemplate;

	@Autowired

	private KafkaTemplate<String, SBALeadResponse> sbaKafkaTemplate;

	public ListenableFuture<SendResult<String, LoadCashErrorPayload>> send(String topic, LoadCashErrorPayload payload) {
		logger.info("publishing payload " + payload + " to kafka topic " + topic);
		return kafkaTemplate.send(topic, payload);
	}

	public ListenableFuture<SendResult<String, SBALeadResponse>> send(String topic, SBALeadResponse payload) {
		logger.info("publishing payload " + payload + " to kafka topic " + topic);
		return sbaKafkaTemplate.send(topic, payload);
	}
}
