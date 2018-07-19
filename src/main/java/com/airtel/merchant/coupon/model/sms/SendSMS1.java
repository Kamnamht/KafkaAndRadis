package com.airtel.merchant.coupon.model.sms;
//
//package com.airtel.merchant.coupon.model.sms;
//
//import java.util.HashMap;
//import java.util.List;
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
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//    "records"
//})
//public class SendSMS {
//
//    @JsonProperty("records")
//    private List<Record> records = null;
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//    /**
//     * No args constructor for use in serialization
//     * 
//     */
//    public SendSMS() {
//    }
//
//    /**
//     * 
//     * @param records
//     */
//    public SendSMS(List<Record> records) {
//        super();
//        this.records = records;
//    }
//
//    @JsonProperty("records")
//    public List<Record> getRecords() {
//        return records;
//    }
//
//    @JsonProperty("records")
//    public void setRecords(List<Record> records) {
//        this.records = records;
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
//        return new ToStringBuilder(this).append("records", records).append("additionalProperties", additionalProperties).toString();
//    }
//
//}
