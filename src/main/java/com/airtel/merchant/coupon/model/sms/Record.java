//
//package com.airtel.merchant.coupon.model.sms;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.commons.lang3.builder.ToStringBuilder;
//
//import com.fasterxml.jackson.annotation.JsonAnyGetter;
//import com.fasterxml.jackson.annotation.JsonAnySetter;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//    "value"
//})
//public class Record {
//
//    @JsonProperty("value")
//    private Value value;
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//    /**
//     * No args constructor for use in serialization
//     * 
//     */
//    public Record() {
//    }
//
//    /**
//     * 
//     * @param value
//     */
//    public Record(Value value) {
//        super();
//        this.value = value;
//    }
//
//    @JsonProperty("value")
//    public Value getValue() {
//        return value;
//    }
//
//    @JsonProperty("value")
//    public void setValue(Value value) {
//        this.value = value;
//    }
//
//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("value", value).append("additionalProperties", additionalProperties).toString();
//    }
//
//}
