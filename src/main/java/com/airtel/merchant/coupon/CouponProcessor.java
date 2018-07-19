package com.airtel.merchant.coupon;

import java.util.HashMap;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.airtel.merchant.coupon.dto.PartnerTextMessageAndEnableRetry;
import com.airtel.merchant.coupon.dto.Partner_Configuration_Mapping;
import com.airtel.merchant.coupon.dto.Partner_TextMessage_Mapping;
import com.airtel.merchant.coupon.repository.Partner_Configuration_MappingRepository;
import com.airtel.merchant.coupon.repository.Partner_TextMessage_MappingRepository;
import com.airtel.merchant.coupon.util.PartnerConfiguration;

@EnableScheduling
@EnableKafka
@Configuration
public class CouponProcessor {
	private static final Logger logger = LoggerFactory.getLogger(CouponProcessor.class);

	private @Autowired Partner_Configuration_MappingRepository partnerConfigurationMappingRepository;
	private @Autowired Partner_TextMessage_MappingRepository partnerTextMessageMappingRepository;
	private @Autowired PartnerConfiguration partnerConfiguration;
	private @Value("${CouponProcessor}") String couponProcessorServiceId;

	@Bean
	public PartnerConfiguration getPartnerConfiguration() {
		return new PartnerConfiguration();
	}

	@Scheduled(fixedDelay = 15 * 60 * 1000)
	public void loadPartnerConfigurations() {
		logger.info(couponProcessorServiceId + ": refreshing configurations data for partners");
		HashMap<String, String> partnerConfigurationMappings = new HashMap<>();
		try {
			Iterable<Partner_Configuration_Mapping> partnerConfigurationMappingList = partnerConfigurationMappingRepository
					.findAll();
			for (Partner_Configuration_Mapping partnerConfigurationMapping : partnerConfigurationMappingList) {
				partnerConfigurationMappings.put(partnerConfigurationMapping.getPartnerId(),
						partnerConfigurationMapping.getCouponExpiryPeriodInDays());
			}
			partnerConfiguration.setPartnerConfigurationMappings(partnerConfigurationMappings);
		} catch (DataAccessException dae) {
			logger.error(couponProcessorServiceId
					+ ": Exception occured while invoking loadPartnerConfigurations. Root cause : {}. Error message : {}",
					ExceptionUtils.getRootCause(dae), ExceptionUtils.getMessage(dae));
		}

		HashMap<String, PartnerTextMessageAndEnableRetry> partnerTextMessageMappings = new HashMap<>();
		try {
			Iterable<Partner_TextMessage_Mapping> partnerTextMessageMappingList = partnerTextMessageMappingRepository
					.findAll();
			for (Partner_TextMessage_Mapping partnerTextMessageMapping : partnerTextMessageMappingList) {
				boolean enableRetry = false;
				int sendSMSFlagInt = partnerTextMessageMapping.getEnableRetry();
				if (sendSMSFlagInt == 1) {
					enableRetry = true;
				}
				PartnerTextMessageAndEnableRetry partnerTextMessageAndEnableRetry = new PartnerTextMessageAndEnableRetry(
						partnerTextMessageMapping.getTextMessage(), enableRetry);
				partnerTextMessageMappings.put(
						partnerTextMessageMapping.getPartnerIdErrorCode().getPartnerId() + "_"
								+ partnerTextMessageMapping.getPartnerIdErrorCode().getErrorCode(),
						partnerTextMessageAndEnableRetry);
			}
		} catch (DataAccessException dae) {
			logger.error(couponProcessorServiceId
					+ ": Exception occured while invoking loadPartnerConfigurations. Root cause : {}. Error message : {}",
					ExceptionUtils.getRootCause(dae), ExceptionUtils.getMessage(dae));
		}

		partnerConfiguration.setPartnerTextMessageMappings(partnerTextMessageMappings);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
