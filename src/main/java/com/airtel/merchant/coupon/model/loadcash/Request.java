
package com.airtel.merchant.coupon.model.loadcash;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "partnerId", "partnerTxnRefNo", "channel", "mode", "requestTimestamp", "beneficiaryDetail",
		"additionalSMSData", "crNarrative", "freeField1", "freeField2", "freeField3" })
public class Request {

	@JsonProperty("partnerId")
	private String partnerId;
	@JsonProperty("partnerTxnRefNo")
	private String partnerTxnRefNo;
	@JsonProperty("channel")
	private String channel;
	@JsonProperty("mode")
	private String mode;
	@JsonProperty("requestTimestamp")
	private String requestTimeStamp;
	@JsonProperty("beneficiaryDetail")
	private BeneficiaryDetail beneficiaryDetail;
	@JsonProperty("additionalSMSData")
	private String additionalSMSData;
	@JsonProperty("crNarrative")
	private String crNarrative;
	@JsonProperty("freeField1")
	private String freeField1;
	@JsonProperty("freeField2")
	private String freeField2;
	@JsonProperty("freeField3")
	private String freeField3;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Request() {
	}

	/**
	 * 
	 * @param beneficiaryDetail
	 * @param requestTimestamp
	 * @param freeField1
	 * @param partnerTxnRefNo
	 * @param freeField3
	 * @param freeField2
	 * @param crNarrative
	 * @param channel
	 * @param additionalSMSData
	 * @param mode
	 */
	public Request(String partnerId, String partnerTxnRefNo, String channel, String mode, String requestTimeStamp,
			BeneficiaryDetail beneficiaryDetail, String additionalSMSData, String crNarrative, String freeField1,
			String freeField2, String freeField3) {
		super();
		this.partnerId = partnerId;
		this.partnerTxnRefNo = partnerTxnRefNo;
		this.channel = channel;
		this.mode = mode;
		this.requestTimeStamp = requestTimeStamp;
		this.beneficiaryDetail = beneficiaryDetail;
		this.additionalSMSData = additionalSMSData;
		this.crNarrative = crNarrative;
		this.freeField1 = freeField1;
		this.freeField2 = freeField2;
		this.freeField3 = freeField3;
	}
	
	@JsonProperty("partnerId")
	public String getPartnerId() {
		return partnerId;
	}

	@JsonProperty("partnerId")
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	@JsonProperty("partnerTxnRefNo")
	public String getPartnerTxnRefNo() {
		return partnerTxnRefNo;
	}

	@JsonProperty("partnerTxnRefNo")
	public void setPartnerTxnRefNo(String partnerTxnRefNo) {
		this.partnerTxnRefNo = partnerTxnRefNo;
	}

	@JsonProperty("channel")
	public String getChannel() {
		return channel;
	}

	@JsonProperty("channel")
	public void setChannel(String channel) {
		this.channel = channel;
	}

	@JsonProperty("mode")
	public String getMode() {
		return mode;
	}

	@JsonProperty("mode")
	public void setMode(String mode) {
		this.mode = mode;
	}

	@JsonProperty("requestTimestamp")
	public String getRequestTimeStamp() {
		return requestTimeStamp;
	}

	@JsonProperty("requestTimestamp")
	public void setRequestTimeStamp(String requestTimeStamp) {
		this.requestTimeStamp = requestTimeStamp;
	}

	@JsonProperty("beneficiaryDetail")
	public BeneficiaryDetail getBeneficiaryDetail() {
		return beneficiaryDetail;
	}

	@JsonProperty("beneficiaryDetail")
	public void setBeneficiaryDetail(BeneficiaryDetail beneficiaryDetail) {
		this.beneficiaryDetail = beneficiaryDetail;
	}

	@JsonProperty("additionalSMSData")
	public String getAdditionalSMSData() {
		return additionalSMSData;
	}

	@JsonProperty("additionalSMSData")
	public void setAdditionalSMSData(String additionalSMSData) {
		this.additionalSMSData = additionalSMSData;
	}

	@JsonProperty("crNarrative")
	public String getCrNarrative() {
		return crNarrative;
	}

	@JsonProperty("crNarrative")
	public void setCrNarrative(String crNarrative) {
		this.crNarrative = crNarrative;
	}

	@JsonProperty("freeField1")
	public String getFreeField1() {
		return freeField1;
	}

	@JsonProperty("freeField1")
	public void setFreeField1(String freeField1) {
		this.freeField1 = freeField1;
	}

	@JsonProperty("freeField2")
	public String getFreeField2() {
		return freeField2;
	}

	@JsonProperty("freeField2")
	public void setFreeField2(String freeField2) {
		this.freeField2 = freeField2;
	}

	@JsonProperty("freeField3")
	public String getFreeField3() {
		return freeField3;
	}

	@JsonProperty("freeField3")
	public void setFreeField3(String freeField3) {
		this.freeField3 = freeField3;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("partnerId", partnerId).append("partnerTxnRefNo", partnerTxnRefNo)
				.append("channel", channel).append("mode", mode).append("requestTimeStamp", requestTimeStamp)
				.append("beneficiaryDetail", beneficiaryDetail).append("additionalSMSData", additionalSMSData)
				.append("crNarrative", crNarrative).append("freeField1", freeField1).append("freeField2", freeField2)
				.append("freeField3", freeField3).append("additionalProperties", additionalProperties).toString();
	}

}
