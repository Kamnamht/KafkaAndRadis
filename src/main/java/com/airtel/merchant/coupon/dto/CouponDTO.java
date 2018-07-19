package com.airtel.merchant.coupon.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COUPON_DATA")
public class CouponDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerIdRefTxnIfId customerIdRefTxnIfId;
	
	private String partnerId;
	
	@Lob
	@Column(columnDefinition = "CLOB")
	private String responseData;

	private String voltRefTxnId;
	private String statusCode;
	private String errorCode;
	private Timestamp lastUpdatedAt;
	private Timestamp loadcashResponseTimestamp;
	
	private String amount;

}