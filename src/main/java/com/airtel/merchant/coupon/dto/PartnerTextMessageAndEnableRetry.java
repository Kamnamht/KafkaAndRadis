package com.airtel.merchant.coupon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerTextMessageAndEnableRetry {
	private String textMessage;
	private boolean enableRetry;
}
