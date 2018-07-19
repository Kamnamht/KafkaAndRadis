package com.airtel.merchant.coupon.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CustomerIdRefTxnIfId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1777029315946374110L;

	@NotNull
	private String customerId;
	@NotNull
	private String refTxnId;
	@NotNull
	private Timestamp createdAt;
}
