package com.airtel.merchant.coupon.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.text.StringSubstitutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.airtel.merchant.coupon.dto.CouponDTO;
import com.airtel.merchant.coupon.dto.PartnerTextMessageAndEnableRetry;
import com.airtel.merchant.coupon.exceptions.ProcessingException;
import com.airtel.merchant.coupon.model.sbalead.AccountOpeningSRO;
import com.airtel.merchant.coupon.model.sbalead.CounterParty;
import com.airtel.merchant.coupon.model.sbalead.Customer;
import com.airtel.merchant.coupon.model.sbalead.SBALeadBody;
import com.airtel.merchant.coupon.model.sms.CommunicationList;
import com.airtel.merchant.coupon.model.sms.SendSMS;
import com.fasterxml.jackson.databind.ObjectMapper;;

/**
 * Created by A1BRCQQX 29/03/2018
 */
@Component
public class VOHelper {

	private static final Logger logger = LoggerFactory.getLogger(VOHelper.class);

	private @org.springframework.beans.factory.annotation.Value("${sba.channel}") String sbaChannel;
	private @org.springframework.beans.factory.annotation.Value("${sba.ucid}") String sbaUcId;
	private @org.springframework.beans.factory.annotation.Value("${sender.name}") String senderName;
	private @org.springframework.beans.factory.annotation.Value("${VoHelper}") String voHelperServiceId;
	private @org.springframework.beans.factory.annotation.Value("${successful.response.code}") String successResponseCode;
	private @org.springframework.beans.factory.annotation.Value("${error.response.code}") String errorResponseCode;
	private @org.springframework.beans.factory.annotation.Value("${timeout.code}") String timeoutResponseCode;

	private @Autowired ObjectMapper objectMapper;

	public SendSMS prepareSendSMSObject(CouponDTO couponDTO, PartnerTextMessageAndEnableRetry partnerTextMessageAndEnableRetry) {
		CommunicationList communication = new CommunicationList();
		communication.setType("SMS");
		communication.setMode("I");
		communication.setLangId("1");
		
		String textMessageTemplate = partnerTextMessageAndEnableRetry.getTextMessage();
		if (StringUtils.isEmpty(textMessageTemplate)) {
			logger.error(voHelperServiceId+":"+errorResponseCode+ ": No TextMessage Format found for " + couponDTO.getPartnerId() + "_" + couponDTO.getErrorCode());
			throw new ProcessingException("No TextMessage Format found for " + couponDTO.getPartnerId() + "_" + couponDTO.getErrorCode());
		} else {
			try	{
				Map<String, String> valuesMap = getCouponDTOMap(couponDTO);
				logger.info(
						voHelperServiceId + ":" + successResponseCode
								+ ": Converted CouponDTO : {} to valuesMap : {}  ",couponDTO,valuesMap);
	
				StringSubstitutor sub = new StringSubstitutor(valuesMap);
				String textMessage = sub.replace(textMessageTemplate);
	
				communication.setContent(textMessage);
	
				List<String> recipients = new ArrayList<String>();
				recipients.add(couponDTO.getCustomerIdRefTxnIfId().getCustomerId());
				communication.setRecipient(recipients);
				communication.setSender(senderName);
				communication.setSubject("SMS");
				communication.setCategory("transaction");
				communication.setExternalRefNo(couponDTO.getCustomerIdRefTxnIfId().getRefTxnId());
				
				List<CommunicationList> communicationList = new ArrayList<>();
				communicationList.add(communication);
				SendSMS sendSMSBody = new SendSMS();
				sendSMSBody.setCommunicationList(communicationList);
				return sendSMSBody;
			}	catch(IllegalArgumentException iae)	{
				logger.error(voHelperServiceId+":"+errorResponseCode+ ": Exception occurred while converting CouponDTO : {} to valuesMap. Root cause : {}. Error message : {}",
					couponDTO, ExceptionUtils.getRootCause(iae), ExceptionUtils.getMessage(iae));
				throw new ProcessingException("Error Occurred while converting CouponDTO "+couponDTO+" to ValuesMap ");
			}
		}
	}

	public SBALeadBody prepareSBALeadBody(String customerId, String partnerId, String refTxnId) {
		SBALeadBody sbaLeadBody = null;
		try {
			Customer customer = new Customer();
			customer.setAdditionalDetails("NA");
			customer.setNatlId(customerId);
			CounterParty counterParty = new CounterParty();
			counterParty.setId(partnerId);
			counterParty.setAdditionalDetails("NA");
			AccountOpeningSRO accountOpeningSRO = new AccountOpeningSRO();
			accountOpeningSRO.setChannel(sbaChannel);
			accountOpeningSRO.setCustomer(customer);
			accountOpeningSRO.setPartnerId(partnerId);
			accountOpeningSRO.setRefTxnNo(refTxnId);
			accountOpeningSRO.setUcId(sbaUcId);
			accountOpeningSRO.setCounterParty(counterParty);
			List<AccountOpeningSRO> accountOpeningSROS = new ArrayList<AccountOpeningSRO>();
			accountOpeningSROS.add(accountOpeningSRO);
			sbaLeadBody = new SBALeadBody();
			sbaLeadBody.setAccountOpeningSROS(accountOpeningSROS);
		} catch (NumberFormatException pe) {
			logger.error(
					voHelperServiceId + ":" + timeoutResponseCode
							+ ": Exception occurred while creating SBALead Body. Root cause : {}. Error message : {}",
					ExceptionUtils.getRootCause(pe), ExceptionUtils.getMessage(pe));
		}

		return sbaLeadBody;
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, String> getCouponDTOMap(CouponDTO couponDTO)	{
		Map<String, String> valuesMap = new HashMap<String, String>();
		valuesMap = objectMapper.convertValue(couponDTO, valuesMap.getClass());
        valuesMap.put("customerId", couponDTO.getCustomerIdRefTxnIfId().getCustomerId());
        valuesMap.put("refTxnId", couponDTO.getCustomerIdRefTxnIfId().getRefTxnId());
        return valuesMap;
	}
}
