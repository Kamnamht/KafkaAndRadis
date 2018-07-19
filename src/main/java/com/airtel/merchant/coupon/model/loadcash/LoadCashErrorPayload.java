
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
@JsonPropertyOrder({ "request", "response" })
public class LoadCashErrorPayload {

	@JsonProperty("request")
	private Request request;
	@JsonProperty("response")
	private Response response;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public LoadCashErrorPayload() {
	}

	/**
	 * 
	 * @param response
	 * @param request
	 */
	public LoadCashErrorPayload(Request request, Response response) {
		super();
		this.request = request;
		this.response = response;
	}

	@JsonProperty("request")
	public Request getRequest() {
		return request;
	}

	@JsonProperty("request")
	public void setRequest(Request request) {
		this.request = request;
	}

	@JsonProperty("response")
	public Response getResponse() {
		return response;
	}

	@JsonProperty("response")
	public void setResponse(Response response) {
		this.response = response;
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
		return new ToStringBuilder(this).append("request", request).append("response", response)
				.append("additionalProperties", additionalProperties).toString();
	}

}
