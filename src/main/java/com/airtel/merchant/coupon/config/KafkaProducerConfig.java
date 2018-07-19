package com.airtel.merchant.coupon.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.airtel.merchant.coupon.model.loadcash.LoadCashErrorPayload;
import com.airtel.merchant.coupon.model.sbalead.SBALeadResponse;


/**
 * Created by b0200901 on 1/9/2018
 */
@Configuration
public class KafkaProducerConfig {
	
	@Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;  
    
    @Bean
    public ProducerFactory<String, SBALeadResponse> sbaProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    
    @Bean
    public KafkaTemplate<String, SBALeadResponse> accountOpeningKafkaTemplate() {
        return new KafkaTemplate<>(sbaProducerFactory());
    }
    
    @Bean
    public ProducerFactory<String, LoadCashErrorPayload> loadcashErrorProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    
    @Bean
    public KafkaTemplate<String, LoadCashErrorPayload> loadCashErrorKafkaTemplate() {
        return new KafkaTemplate<>(loadcashErrorProducerFactory());
    }
}
