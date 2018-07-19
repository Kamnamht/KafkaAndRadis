
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
@JsonPropertyOrder({
    "customer",
    "counterParty",
    "partnerId",
    "refTxnNo",
    "ucId",
    "channel"
})
public class AccountOpeningSRO {

    @JsonProperty("customer")
    private Customer customer;
    @JsonProperty("counterParty")
    private CounterParty counterParty;
    @JsonProperty("partnerId")
    private String partnerId;
    @JsonProperty("refTxnNo")
    private String refTxnNo;
    @JsonProperty("ucId")
    private String ucId;
    @JsonProperty("channel")
    private String channel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AccountOpeningSRO() {
    }

    /**
     * 
     * @param counterParty
     * @param refTxnNo
     * @param partnerId
     * @param ucId
     * @param customer
     * @param channel
     */
    public AccountOpeningSRO(Customer customer, CounterParty counterParty, String partnerId, String refTxnNo, String ucId, String channel) {
        super();
        this.customer = customer;
        this.counterParty = counterParty;
        this.partnerId = partnerId;
        this.refTxnNo = refTxnNo;
        this.ucId = ucId;
        this.channel = channel;
    }

    @JsonProperty("customer")
    public Customer getCustomer() {
        return customer;
    }

    @JsonProperty("customer")
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @JsonProperty("counterParty")
    public CounterParty getCounterParty() {
        return counterParty;
    }

    @JsonProperty("counterParty")
    public void setCounterParty(CounterParty counterParty) {
        this.counterParty = counterParty;
    }

    @JsonProperty("partnerId")
    public String getPartnerId() {
        return partnerId;
    }

    @JsonProperty("partnerId")
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    @JsonProperty("refTxnNo")
    public String getRefTxnNo() {
        return refTxnNo;
    }

    @JsonProperty("refTxnNo")
    public void setRefTxnNo(String refTxnNo) {
        this.refTxnNo = refTxnNo;
    }

    @JsonProperty("ucId")
    public String getUcId() {
        return ucId;
    }

    @JsonProperty("ucId")
    public void setUcId(String ucId) {
        this.ucId = ucId;
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
        return new ToStringBuilder(this).append("customer", customer).append("counterParty", counterParty).append("partnerId", partnerId).append("refTxnNo", refTxnNo).append("ucId", ucId).append("channel", channel).append("additionalProperties", additionalProperties).toString();
    }

}
