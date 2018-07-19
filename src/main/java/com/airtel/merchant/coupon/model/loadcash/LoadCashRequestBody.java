
package com.airtel.merchant.coupon.model.loadcash;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoadCashRequestBody {


	private String partnerTxnRefNo;
	private String channel;
	private String mode;
	private String requestTimestamp;
	private BeneficiaryDetail beneficiaryDetail;
	private String additionalSMSData;
	private String crNarrative;
	private String freeField1;
	private String freeField2;
	private String freeField3;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public LoadCashRequestBody() {
	}

	public LoadCashRequestBody(String partnerTxnRefNo, String channel, String mode, String requestTimestamp,
			BeneficiaryDetail beneficiaryDetail, String additionalSMSData, String crNarrative, String freeField1,
			String freeField2, String freeField3) {
		super();
		this.partnerTxnRefNo = partnerTxnRefNo;
		this.channel = channel;
		this.mode = mode;
		this.requestTimestamp = requestTimestamp;
		this.beneficiaryDetail = beneficiaryDetail;
		this.additionalSMSData = additionalSMSData;
		this.crNarrative = crNarrative;
		this.freeField1 = freeField1;
		this.freeField2 = freeField2;
		this.freeField3 = freeField3;
	}

	public String getPartnerTxnRefNo() {
		return partnerTxnRefNo;
	}

	public void setPartnerTxnRefNo(String partnerTxnRefNo) {
		this.partnerTxnRefNo = partnerTxnRefNo;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getRequestTimestamp() {
		return requestTimestamp;
	}

	public void setRequestTimestamp(String requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}

	public BeneficiaryDetail getBeneficiaryDetail() {
		return beneficiaryDetail;
	}

	public void setBeneficiaryDetail(BeneficiaryDetail beneficiaryDetail) {
		this.beneficiaryDetail = beneficiaryDetail;
	}

	public String getAdditionalSMSData() {
		return additionalSMSData;
	}

	public void setAdditionalSMSData(String additionalSMSData) {
		this.additionalSMSData = additionalSMSData;
	}

	public String getCrNarrative() {
		return crNarrative;
	}

	public void setCrNarrative(String crNarrative) {
		this.crNarrative = crNarrative;
	}

	public String getFreeField1() {
		return freeField1;
	}

	public void setFreeField1(String freeField1) {
		this.freeField1 = freeField1;
	}

	public String getFreeField2() {
		return freeField2;
	}

	public void setFreeField2(String freeField2) {
		this.freeField2 = freeField2;
	}

	public String getFreeField3() {
		return freeField3;
	}

	@JsonProperty("freeField3")
	public void setFreeField3(String freeField3) {
		this.freeField3 = freeField3;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("partnerTxnRefNo", partnerTxnRefNo)
				.append("channel", channel).append("mode", mode).append("requestTimestamp", requestTimestamp)
				.append("beneficiaryDetail", beneficiaryDetail).append("additionalSMSData", additionalSMSData)
				.append("crNarrative", crNarrative).append("freeField1", freeField1).append("freeField2", freeField2)
				.append("freeField3", freeField3).toString();
	}

}
