package com.airtel.merchant.coupon.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PartnerIdErroCode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1626882296671156502L;
	@NotNull
	private String partnerId;
	@NotNull
	private String errorCode;
}
