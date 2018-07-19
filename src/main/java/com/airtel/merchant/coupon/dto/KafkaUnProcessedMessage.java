package com.airtel.merchant.coupon.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "KAFKA_UNPROCESSED_MESSAGES")
public class KafkaUnProcessedMessage implements Serializable	{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2029632913088935650L;
	
	@Id 
	private long id;
	
	@Lob
	@Column(columnDefinition = "CLOB")
	private String unprocessedMessage;
}
