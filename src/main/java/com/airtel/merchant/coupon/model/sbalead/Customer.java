
package com.airtel.merchant.coupon.model.sbalead;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "firstName",
    "middleName",
    "lastName",
    "natlId",
    "aadhaar",
    "additionalDetails"
})
public class Customer {

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("natlId")
    private String natlId;
    @JsonProperty("aadhaar")
    private String aadhaar;
    @JsonProperty("additionalDetails")
    private String additionalDetails;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Customer() {
    }

    /**
     * 
     * @param middleName
     * @param natlId
     * @param lastName
     * @param additionalDetails
     * @param aadhaar
     * @param firstName
     */
    public Customer(String firstName, String middleName, String lastName, String natlId, String aadhaar, String additionalDetails) {
        super();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.natlId = natlId;
        this.aadhaar = aadhaar;
        this.additionalDetails = additionalDetails;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("middleName")
    public String getMiddleName() {
        return middleName;
    }

    @JsonProperty("middleName")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("natlId")
    public String getNatlId() {
        return natlId;
    }

    @JsonProperty("natlId")
    public void setNatlId(String natlId) {
        this.natlId = natlId;
    }

    @JsonProperty("aadhaar")
    public String getAadhaar() {
        return aadhaar;
    }

    @JsonProperty("aadhaar")
    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    @JsonProperty("additionalDetails")
    public String getAdditionalDetails() {
        return additionalDetails;
    }

    @JsonProperty("additionalDetails")
    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
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
        return new ToStringBuilder(this).append("firstName", firstName).append("middleName", middleName).append("lastName", lastName).append("natlId", natlId).append("aadhaar", aadhaar).append("additionalDetails", additionalDetails).append("additionalProperties", additionalProperties).toString();
    }

}
