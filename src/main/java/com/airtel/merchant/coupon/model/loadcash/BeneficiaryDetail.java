
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
    "beneficiaryMobileNumber",
    "beneficiaryfreeField1",
    "beneficiaryfreeField2",
    "txnAmount"
})
public class BeneficiaryDetail {

    @JsonProperty("beneficiaryMobileNumber")
    private String beneficiaryMobileNumber;
    @JsonProperty("beneficiaryfreeField1")
    private Object beneficiaryfreeField1;
    @JsonProperty("beneficiaryfreeField2")
    private Object beneficiaryfreeField2;
    @JsonProperty("txnAmount")
    private String txnAmount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BeneficiaryDetail() {
    }

    /**
     * 
     * @param beneficiaryMobileNumber
     * @param beneficiaryfreeField2
     * @param beneficiaryfreeField1
     * @param txnAmount
     */
    public BeneficiaryDetail(String beneficiaryMobileNumber, Object beneficiaryfreeField1, Object beneficiaryfreeField2, String txnAmount) {
        super();
        this.beneficiaryMobileNumber = beneficiaryMobileNumber;
        this.beneficiaryfreeField1 = beneficiaryfreeField1;
        this.beneficiaryfreeField2 = beneficiaryfreeField2;
        this.txnAmount = txnAmount;
    }

    @JsonProperty("beneficiaryMobileNumber")
    public String getBeneficiaryMobileNumber() {
        return beneficiaryMobileNumber;
    }

    @JsonProperty("beneficiaryMobileNumber")
    public void setBeneficiaryMobileNumber(String beneficiaryMobileNumber) {
        this.beneficiaryMobileNumber = beneficiaryMobileNumber;
    }

    @JsonProperty("beneficiaryfreeField1")
    public Object getBeneficiaryfreeField1() {
        return beneficiaryfreeField1;
    }

    @JsonProperty("beneficiaryfreeField1")
    public void setBeneficiaryfreeField1(Object beneficiaryfreeField1) {
        this.beneficiaryfreeField1 = beneficiaryfreeField1;
    }

    @JsonProperty("beneficiaryfreeField2")
    public Object getBeneficiaryfreeField2() {
        return beneficiaryfreeField2;
    }

    @JsonProperty("beneficiaryfreeField2")
    public void setBeneficiaryfreeField2(Object beneficiaryfreeField2) {
        this.beneficiaryfreeField2 = beneficiaryfreeField2;
    }

    @JsonProperty("txnAmount")
    public String getTxnAmount() {
        return txnAmount;
    }

    @JsonProperty("txnAmount")
    public void setTxnAmount(String txnAmount) {
        this.txnAmount = txnAmount;
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
        return new ToStringBuilder(this).append("beneficiaryMobileNumber", beneficiaryMobileNumber).append("beneficiaryfreeField1", beneficiaryfreeField1).append("beneficiaryfreeField2", beneficiaryfreeField2).append("txnAmount", txnAmount).append("additionalProperties", additionalProperties).toString();
    }

}
