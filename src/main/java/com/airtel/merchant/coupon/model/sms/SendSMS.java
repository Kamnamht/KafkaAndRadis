
package com.airtel.merchant.coupon.model.sms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "communicationList"
})
public class SendSMS {

    @JsonProperty("communicationList")
    private List<CommunicationList> communicationList = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SendSMS() {
    }

    /**
     * 
     * @param communicationList
     */
    public SendSMS(List<CommunicationList> communicationList) {
        super();
        this.communicationList = communicationList;
    }

    @JsonProperty("communicationList")
    public List<CommunicationList> getCommunicationList() {
        return communicationList;
    }

    @JsonProperty("communicationList")
    public void setCommunicationList(List<CommunicationList> communicationList) {
        this.communicationList = communicationList;
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
        return new ToStringBuilder(this).append("communicationList", communicationList).append("additionalProperties", additionalProperties).toString();
    }

}
