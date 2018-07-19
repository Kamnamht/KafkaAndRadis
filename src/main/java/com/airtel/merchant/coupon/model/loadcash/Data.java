
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
@JsonPropertyOrder({
    "responseTimestamp",
    "bankTxnId",
    "partnerTxnRefNo",
    "txnAmount",
    "accountBalance"
})
public class Data {

    @JsonProperty("responseTimestamp")
    private String responseTimeStamp;
    @JsonProperty("bankTxnId")
    private String bankTxnId;
    @JsonProperty("partnerTxnRefNo")
    private String partnerTxnRefNo;
    @JsonProperty("txnAmount")
    private String txnAmount;
    @JsonProperty("accountBalance")
    private Object accountBalance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param partnerTxnRefNo
     * @param accountBalance
     * @param responseTimestamp
     * @param txnAmount
     * @param bankTxnId
     */
    public Data(String responseTimeStamp, String bankTxnId, String partnerTxnRefNo, String txnAmount, Object accountBalance) {
        super();
        this.responseTimeStamp = responseTimeStamp;
        this.bankTxnId = bankTxnId;
        this.partnerTxnRefNo = partnerTxnRefNo;
        this.txnAmount = txnAmount;
        this.accountBalance = accountBalance;
    }

    @JsonProperty("responseTimestamp")
    public String getResponseTimeStamp() {
        return responseTimeStamp;
    }

    @JsonProperty("responseTimestamp")
    public void setResponseTimeStamp(String responseTimeStamp) {
        this.responseTimeStamp = responseTimeStamp;
    }

    @JsonProperty("bankTxnId")
    public String getBankTxnId() {
        return bankTxnId;
    }

    @JsonProperty("bankTxnId")
    public void setBankTxnId(String bankTxnId) {
        this.bankTxnId = bankTxnId;
    }

    @JsonProperty("partnerTxnRefNo")
    public String getPartnerTxnRefNo() {
        return partnerTxnRefNo;
    }

    @JsonProperty("partnerTxnRefNo")
    public void setPartnerTxnRefNo(String partnerTxnRefNo) {
        this.partnerTxnRefNo = partnerTxnRefNo;
    }

    @JsonProperty("txnAmount")
    public String getTxnAmount() {
        return txnAmount;
    }

    @JsonProperty("txnAmount")
    public void setTxnAmount(String txnAmount) {
        this.txnAmount = txnAmount;
    }

    @JsonProperty("accountBalance")
    public Object getAccountBalance() {
        return accountBalance;
    }

    @JsonProperty("accountBalance")
    public void setAccountBalance(Object accountBalance) {
        this.accountBalance = accountBalance;
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
        return new ToStringBuilder(this).append("responseTimeStamp", responseTimeStamp).append("bankTxnId", bankTxnId).append("partnerTxnRefNo", partnerTxnRefNo).append("txnAmount", txnAmount).append("accountBalance", accountBalance).append("additionalProperties", additionalProperties).toString();
    }

}
