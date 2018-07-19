package com.airtel.merchant.coupon.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by A1BRCQQX on 29/03/2018
 */
@Configuration
public class KafkaConsumerConfig {

	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	@Value(value = "${newAccount.group.id}")
	private String newAccountGroupId;

	@Value(value = "${loadcasherror.group.id}")
	private String loadcashErrorGroupId;
	
	@Value(value = "${retry.group.id}")
	private String retryGroupId;

	@Value(value = "${kafka.numOfKafkaListeners}")
	private int numOfKafkaListeners;

	/*** New SBA Consumer config starts ***/
	@Bean
	public AsyncListenableTaskExecutor getTaskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(numOfKafkaListeners);
		return taskExecutor;
	}

	public ConsumerFactory<String, String> sbaConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, newAccountGroupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(props);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> newAccountKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(sbaConsumerFactory());
		factory.setConcurrency(numOfKafkaListeners);
		factory.getContainerProperties().setConsumerTaskExecutor(getTaskExecutor());
		return factory;
	}

	/*** New SBA Consumer config ends ***/

	/*** Unregistered Customer config starts ***/
	@Bean
	public AsyncListenableTaskExecutor getTaskExecutorForUnRegisteredCustomers() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(numOfKafkaListeners);
		return taskExecutor;
	}

	public ConsumerFactory<String, String> unregisteredCustomerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, loadcashErrorGroupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(props);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> unregisteredKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(unregisteredCustomerFactory());
		factory.setConcurrency(numOfKafkaListeners);
		factory.getContainerProperties().setConsumerTaskExecutor(getTaskExecutorForUnRegisteredCustomers());
		return factory;
	}
	/*** Unregistered Customer config ends ***/

	/*** Retry Topic config starts ***/
	@Bean
	public AsyncListenableTaskExecutor getTaskExecutorForRetryTopic() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(numOfKafkaListeners);
		return taskExecutor;
	}

	public ConsumerFactory<String, String> retryTopicConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, retryGroupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(props);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> retryTopicKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(retryTopicConsumerFactory());
		factory.setConcurrency(numOfKafkaListeners);
		factory.getContainerProperties().setConsumerTaskExecutor(getTaskExecutorForRetryTopic());
		return factory;
	}
	/*** Retry Topic config ends ***/
}
