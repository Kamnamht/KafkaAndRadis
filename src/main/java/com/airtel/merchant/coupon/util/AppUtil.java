package com.airtel.merchant.coupon.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.airtel.merchant.coupon.model.logger.LoggerModel;
import com.airtel.merchant.coupon.model.logger.LoggerModel.LoggerError;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AppUtil {

	private static final Logger logger = LoggerFactory.getLogger(AppUtil.class);

	private @Autowired RestTemplate restTemplate;
	private @Autowired ObjectMapper mapper;
	private @Value("${couponprocessor.serviceId}") String couponprocessorServiceId;

	public String invokePostURL(String endpoint, Object requestBody) throws JsonProcessingException {
		logger.info("Hitting endpoint " + endpoint + " with requestBody " + requestBody);
		long startTime = System.currentTimeMillis();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String response = "";
		HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(requestBody), headers);
		ResponseEntity<String> responseBody = restTemplate.exchange(endpoint, HttpMethod.POST, entity, String.class);
		logger.info("responseBody " + responseBody + " received after hitting " + endpoint);
		if (responseBody != null) {
			response = responseBody.getBody();
		}
		logger.info("Total Time taken for hitting url : {} , {} " + endpoint,
				(System.currentTimeMillis() - startTime) + " milliseconds.");
		return response;
	}

	public String convertLoggerModelToString(LoggerModel loggerModel) {
		StringBuilder builder = new StringBuilder();
		int errorCode = 0;
		builder.append(couponprocessorServiceId + " | ");

		if (!CollectionUtils.isEmpty(loggerModel.getErrors())) {
			errorCode = 1;
		}
		builder.append(errorCode + " | ");
		builder.append(loggerModel.getPartnerId() + " | ");
		builder.append(loggerModel.getRefTxnId() + " | ");
		builder.append(loggerModel.getPayload() + " | ");

		if (errorCode == 1) {
			for (int i = 0; i < loggerModel.getErrors().size(); i++) {
				if (i != 0)
					builder.append("-");
				builder.append(loggerModel.getErrors().get(i).getErrorCode() + ","
						+ loggerModel.getErrors().get(i).getErrorDescription());
			}
		}

		long endTime = System.currentTimeMillis();
		long time = (endTime - loggerModel.getStartTime());

		// for (int i = 0; i < loggerModel.getMethods().size(); i++) {
		// if (i == 0)
		// builder.append(" | ");
		// if (i != 0)
		// builder.append("-");
		// builder.append(loggerModel.getMethods().get(i).getMethodName() + ","
		// + loggerModel.getMethods().get(i).getMethodTime());
		// }
		// if (CollectionUtils.isEmpty(loggerModel.getMethods()))
		// builder.append(" | ");
		builder.append(" | ");
		builder.append(time);
		return builder.toString();
	}

	public void addEntryToLoggerModel(LoggerModel loggerModel, Exception e) {
		LoggerError error = new LoggerError();
		error.setErrorCode("1");
		error.setErrorDescription(e.getMessage());
		if (loggerModel.getErrors() != null) {
			List<LoggerError> errors = loggerModel.getErrors();
			errors.add(error);
			loggerModel.setErrors(errors);
		} else {
			List<LoggerError> errors = new ArrayList<LoggerError>();
			errors.add(error);
			loggerModel.setErrors(errors);
		}
	}
}
