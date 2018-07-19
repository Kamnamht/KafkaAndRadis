package com.airtel.merchant.coupon.util;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.airtel.merchant.coupon.dto.PartnerTextMessageAndEnableRetry;

@Component
public class PartnerConfiguration {
	private HashMap<String, String> partnerConfigurationMappings;
	private HashMap<String, PartnerTextMessageAndEnableRetry> partnerTextMessageMappings;
	public HashMap<String, String> getPartnerConfigurationMappings() {
		return partnerConfigurationMappings;
	}
	public void setPartnerConfigurationMappings(HashMap<String, String> partnerConfigurationMappings) {
		this.partnerConfigurationMappings = partnerConfigurationMappings;
	}
	public HashMap<String, PartnerTextMessageAndEnableRetry> getPartnerTextMessageMappings() {
		return partnerTextMessageMappings;
	}
	public void setPartnerTextMessageMappings(HashMap<String, PartnerTextMessageAndEnableRetry> partnerTextMessageMappings) {
		this.partnerTextMessageMappings = partnerTextMessageMappings;
	}
	
	
}
