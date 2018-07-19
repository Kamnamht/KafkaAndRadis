
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
    "errorCode",
    "errorDescription"
})
public class Error {

    @JsonProperty("errorCode")
    private String code;
    @JsonProperty("errorDescription")
    private String desc;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Error() {
    }

    /**
     * 
     * @param desc
     * @param errorCode
     */
    public Error(String code, String desc) {
        super();
        this.code = code;
        this.desc = desc;
    }

    @JsonProperty("errorCode")
    public String getCode() {
        return code;
    }

    @JsonProperty("errorCode")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("errorDescription")
    public String getDesc() {
        return desc;
    }

    @JsonProperty("errorDescription")
    public void setDesc(String desc) {
        this.desc = desc;
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
        return new ToStringBuilder(this).append("errorCode", code).append("errorDescription", desc).append("additionalProperties", additionalProperties).toString();
    }

}
