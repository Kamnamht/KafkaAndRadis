package com.airtel.merchant.coupon.model.sbalead;

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
@JsonPropertyOrder({ "id", "ucId", "refTxnNo", "partnerId", "custFname", "custMname", "custLname", "custNatlId",
		"custAadharNo", "custDetails", "counterPartyId", "counterPartyDetails", "leadCompleteTimestamp", "delFlag",
		"channel" })
public class SBALeadResponse {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("ucId")
	private String ucId;
	@JsonProperty("refTxnNo")
	private String refTxnNo;
	@JsonProperty("partnerId")
	private String partnerId;
	@JsonProperty("custFname")
	private String custFname;
	@JsonProperty("custMname")
	private String custMname;
	@JsonProperty("custLname")
	private String custLname;
	@JsonProperty("custNatlId")
	private String custNatlId;
	@JsonProperty("custAadharNo")
	private String custAadharNo;
	@JsonProperty("custDetails")
	private Object custDetails;
	@JsonProperty("counterPartyId")
	private String counterPartyId;
	@JsonProperty("counterPartyDetails")
	private Object counterPartyDetails;
	@JsonProperty("leadCompleteTimestamp")
	private String leadCompleteTimestamp;
	@JsonProperty("delFlag")
	private Integer delFlag;
	@JsonProperty("channel")
	private String channel;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public SBALeadResponse() {
	}

	/**
	 * 
	 * @param leadCompleteTimestamp
	 * @param refTxnNo
	 * @param partnerId
	 * @param ucId
	 * @param custAadharNo
	 * @param custDetails
	 * @param id
	 * @param custNatlId
	 * @param counterPartyDetails
	 * @param custMname
	 * @param counterPartyId
	 * @param channel
	 * @param custFname
	 * @param custLname
	 * @param delFlag
	 */
	public SBALeadResponse(Integer id, String ucId, String refTxnNo, String partnerId, String custFname,
			String custMname, String custLname, String custNatlId, String custAadharNo, Object custDetails,
			String counterPartyId, Object counterPartyDetails, String leadCompleteTimestamp, Integer delFlag,
			String channel) {
		super();
		this.id = id;
		this.ucId = ucId;
		this.refTxnNo = refTxnNo;
		this.partnerId = partnerId;
		this.custFname = custFname;
		this.custMname = custMname;
		this.custLname = custLname;
		this.custNatlId = custNatlId;
		this.custAadharNo = custAadharNo;
		this.custDetails = custDetails;
		this.counterPartyId = counterPartyId;
		this.counterPartyDetails = counterPartyDetails;
		this.leadCompleteTimestamp = leadCompleteTimestamp;
		this.delFlag = delFlag;
		this.channel = channel;
	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("ucId")
	public String getUcId() {
		return ucId;
	}

	@JsonProperty("ucId")
	public void setUcId(String ucId) {
		this.ucId = ucId;
	}

	@JsonProperty("refTxnNo")
	public String getRefTxnNo() {
		return refTxnNo;
	}

	@JsonProperty("refTxnNo")
	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	@JsonProperty("partnerId")
	public String getPartnerId() {
		return partnerId;
	}

	@JsonProperty("partnerId")
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	@JsonProperty("custFname")
	public String getCustFname() {
		return custFname;
	}

	@JsonProperty("custFname")
	public void setCustFname(String custFname) {
		this.custFname = custFname;
	}

	@JsonProperty("custMname")
	public String getCustMname() {
		return custMname;
	}

	@JsonProperty("custMname")
	public void setCustMname(String custMname) {
		this.custMname = custMname;
	}

	@JsonProperty("custLname")
	public String getCustLname() {
		return custLname;
	}

	@JsonProperty("custLname")
	public void setCustLname(String custLname) {
		this.custLname = custLname;
	}

	@JsonProperty("custNatlId")
	public String getCustNatlId() {
		return custNatlId;
	}

	@JsonProperty("custNatlId")
	public void setCustNatlId(String custNatlId) {
		this.custNatlId = custNatlId;
	}

	@JsonProperty("custAadharNo")
	public String getCustAadharNo() {
		return custAadharNo;
	}

	@JsonProperty("custAadharNo")
	public void setCustAadharNo(String custAadharNo) {
		this.custAadharNo = custAadharNo;
	}

	@JsonProperty("custDetails")
	public Object getCustDetails() {
		return custDetails;
	}

	@JsonProperty("custDetails")
	public void setCustDetails(Object custDetails) {
		this.custDetails = custDetails;
	}

	@JsonProperty("counterPartyId")
	public String getCounterPartyId() {
		return counterPartyId;
	}

	@JsonProperty("counterPartyId")
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	@JsonProperty("counterPartyDetails")
	public Object getCounterPartyDetails() {
		return counterPartyDetails;
	}

	@JsonProperty("counterPartyDetails")
	public void setCounterPartyDetails(Object counterPartyDetails) {
		this.counterPartyDetails = counterPartyDetails;
	}

	@JsonProperty("leadCompleteTimestamp")
	public String getLeadCompleteTimestamp() {
		return leadCompleteTimestamp;
	}

	@JsonProperty("leadCompleteTimestamp")
	public void setLeadCompleteTimestamp(String leadCompleteTimestamp) {
		this.leadCompleteTimestamp = leadCompleteTimestamp;
	}

	@JsonProperty("delFlag")
	public Integer getDelFlag() {
		return delFlag;
	}

	@JsonProperty("delFlag")
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	@JsonProperty("channel")
	public String getChannel() {
		return channel;
	}

	@JsonProperty("channel")
	public void setChannel(String channel) {
		this.channel = channel;
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
		return new ToStringBuilder(this).append("id", id).append("ucId", ucId).append("refTxnNo", refTxnNo)
				.append("partnerId", partnerId).append("custFname", custFname).append("custMname", custMname)
				.append("custLname", custLname).append("custNatlId", custNatlId).append("custAadharNo", custAadharNo)
				.append("custDetails", custDetails).append("counterPartyId", counterPartyId)
				.append("counterPartyDetails", counterPartyDetails)
				.append("leadCompleteTimestamp", leadCompleteTimestamp).append("delFlag", delFlag)
				.append("channel", channel).append("additionalProperties", additionalProperties).toString();
	}

}
