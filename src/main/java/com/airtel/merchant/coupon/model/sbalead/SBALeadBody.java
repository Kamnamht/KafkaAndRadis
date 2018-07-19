package com.airtel.merchant.coupon.model.sbalead;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by A1BRCQQX 29/03/2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accountOpeningSROS"
})
public class SBALeadBody {

    @JsonProperty("accountOpeningSROS")
    private List<AccountOpeningSRO> accountOpeningSROS = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SBALeadBody() {
    }

    /**
     * 
     * @param accountOpeningSROS
     */
    public SBALeadBody(List<AccountOpeningSRO> accountOpeningSROS) {
        super();
        this.accountOpeningSROS = accountOpeningSROS;
    }

    @JsonProperty("accountOpeningSROS")
    public List<AccountOpeningSRO> getAccountOpeningSROS() {
        return accountOpeningSROS;
    }

    @JsonProperty("accountOpeningSROS")
    public void setAccountOpeningSROS(List<AccountOpeningSRO> accountOpeningSROS) {
        this.accountOpeningSROS = accountOpeningSROS;
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
        return new ToStringBuilder(this).append("accountOpeningSROS", accountOpeningSROS).append("additionalProperties", additionalProperties).toString();
    }

}

