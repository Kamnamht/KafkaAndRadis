package com.airtel.merchant.coupon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.airtel.merchant.coupon.dto.KafkaUnProcessedMessage;

@Repository
public interface KafkaUnProcessedMessageRepository extends CrudRepository<KafkaUnProcessedMessage, Long> {

}
