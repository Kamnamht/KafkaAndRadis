package com.airtel.merchant.coupon.dto;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Partner_TextMessage_Mapping")
public class Partner_TextMessage_Mapping implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PartnerIdErroCode partnerIdErrorCode;

	@NotNull
	private String textMessage;
	
	private int enableRetry;
}
