
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
    "startDate",
    "endDate",
    "langId",
    "templateCode",
    "frequency",
    "customClassName",
    "maskingRegex",
    "subject",
    "category",
    "index",
    "content",
    "maxRetryCount",
    "attachment",
    "blackOutEndTime",
    "type",
    "tamplateDataModel",
    "ref1",
    "max",
    "ref3",
    "ref2",
    "ref5",
    "ref4",
    "recipient",
    "sender",
    "applicationKey",
    "deliveryReportRequired",
    "externalRefNo",
    "mode",
    "blackOutStartTime",
    "applicationCode",
    "maskingRequired"
})
public class CommunicationList {

    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("langId")
    private String langId;
    @JsonProperty("templateCode")
    private String templateCode;
    @JsonProperty("frequency")
    private String frequency;
    @JsonProperty("customClassName")
    private String customClassName;
    @JsonProperty("maskingRegex")
    private String maskingRegex;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("category")
    private String category;
    @JsonProperty("index")
    private Integer index;
    @JsonProperty("content")
    private String content;
    @JsonProperty("maxRetryCount")
    private Integer maxRetryCount;
    @JsonProperty("attachment")
    private String attachment;
    @JsonProperty("blackOutEndTime")
    private Object blackOutEndTime;
    @JsonProperty("type")
    private String type;
    @JsonProperty("tamplateDataModel")
    private String tamplateDataModel;
    @JsonProperty("ref1")
    private Object ref1;
    @JsonProperty("max")
    private String max;
    @JsonProperty("ref3")
    private Object ref3;
    @JsonProperty("ref2")
    private Object ref2;
    @JsonProperty("ref5")
    private Object ref5;
    @JsonProperty("ref4")
    private Object ref4;
    @JsonProperty("recipient")
    private List<String> recipient = null;
    @JsonProperty("sender")
    private String sender;
    @JsonProperty("applicationKey")
    private String applicationKey;
    @JsonProperty("deliveryReportRequired")
    private Boolean deliveryReportRequired;
    @JsonProperty("externalRefNo")
    private String externalRefNo;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("blackOutStartTime")
    private Object blackOutStartTime;
    @JsonProperty("applicationCode")
    private String applicationCode;
    @JsonProperty("maskingRequired")
    private Boolean maskingRequired;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CommunicationList() {
    }

    /**
     * 
     * @param startDate
     * @param maskingRequired
     * @param subject
     * @param endDate
     * @param frequency
     * @param type
     * @param deliveryReportRequired
     * @param recipient
     * @param mode
     * @param sender
     * @param externalRefNo
     * @param index
     * @param blackOutEndTime
     * @param maskingRegex
     * @param max
     * @param maxRetryCount
     * @param templateCode
     * @param attachment
     * @param blackOutStartTime
     * @param content
     * @param ref4
     * @param ref3
     * @param category
     * @param ref5
     * @param applicationCode
     * @param customClassName
     * @param ref2
     * @param applicationKey
     * @param ref1
     * @param langId
     * @param tamplateDataModel
     */
//    public CommunicationList(String startDate, String endDate, String langId, String templateCode, String frequency, String customClassName, String maskingRegex, String subject, String category, Integer index, String content, Integer maxRetryCount, String attachment, Object blackOutEndTime, String type, String tamplateDataModel, Object ref1, String max, Object ref3, Object ref2, Object ref5, Object ref4, List<String> recipient, String sender, String applicationKey, Boolean deliveryReportRequired, String externalRefNo, String mode, Object blackOutStartTime, String applicationCode, Boolean maskingRequired) {
//        super();
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.langId = langId;
//        this.templateCode = templateCode;
//        this.frequency = frequency;
//        this.customClassName = customClassName;
//        this.maskingRegex = maskingRegex;
//        this.subject = subject;
//        this.category = category;
//        this.index = index;
//        this.content = content;
//        this.maxRetryCount = maxRetryCount;
//        this.attachment = attachment;
//        this.blackOutEndTime = blackOutEndTime;
//        this.type = type;
//        this.tamplateDataModel = tamplateDataModel;
//        this.ref1 = ref1;
//        this.max = max;
//        this.ref3 = ref3;
//        this.ref2 = ref2;
//        this.ref5 = ref5;
//        this.ref4 = ref4;
//        this.recipient = recipient;
//        this.sender = sender;
//        this.applicationKey = applicationKey;
//        this.deliveryReportRequired = deliveryReportRequired;
//        this.externalRefNo = externalRefNo;
//        this.mode = mode;
//        this.blackOutStartTime = blackOutStartTime;
//        this.applicationCode = applicationCode;
//        this.maskingRequired = maskingRequired;
//    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("langId")
    public String getLangId() {
        return langId;
    }

    @JsonProperty("langId")
    public void setLangId(String langId) {
        this.langId = langId;
    }

    @JsonProperty("templateCode")
    public String getTemplateCode() {
        return templateCode;
    }

    @JsonProperty("templateCode")
    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    @JsonProperty("frequency")
    public String getFrequency() {
        return frequency;
    }

    @JsonProperty("frequency")
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @JsonProperty("customClassName")
    public String getCustomClassName() {
        return customClassName;
    }

    @JsonProperty("customClassName")
    public void setCustomClassName(String customClassName) {
        this.customClassName = customClassName;
    }

    @JsonProperty("maskingRegex")
    public String getMaskingRegex() {
        return maskingRegex;
    }

    @JsonProperty("maskingRegex")
    public void setMaskingRegex(String maskingRegex) {
        this.maskingRegex = maskingRegex;
    }

    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("index")
    public Integer getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(Integer index) {
        this.index = index;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("maxRetryCount")
    public Integer getMaxRetryCount() {
        return maxRetryCount;
    }

    @JsonProperty("maxRetryCount")
    public void setMaxRetryCount(Integer maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
    }

    @JsonProperty("attachment")
    public String getAttachment() {
        return attachment;
    }

    @JsonProperty("attachment")
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @JsonProperty("blackOutEndTime")
    public Object getBlackOutEndTime() {
        return blackOutEndTime;
    }

    @JsonProperty("blackOutEndTime")
    public void setBlackOutEndTime(Object blackOutEndTime) {
        this.blackOutEndTime = blackOutEndTime;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("tamplateDataModel")
    public String getTamplateDataModel() {
        return tamplateDataModel;
    }

    @JsonProperty("tamplateDataModel")
    public void setTamplateDataModel(String tamplateDataModel) {
        this.tamplateDataModel = tamplateDataModel;
    }

    @JsonProperty("ref1")
    public Object getRef1() {
        return ref1;
    }

    @JsonProperty("ref1")
    public void setRef1(Object ref1) {
        this.ref1 = ref1;
    }

    @JsonProperty("max")
    public String getMax() {
        return max;
    }

    @JsonProperty("max")
    public void setMax(String max) {
        this.max = max;
    }

    @JsonProperty("ref3")
    public Object getRef3() {
        return ref3;
    }

    @JsonProperty("ref3")
    public void setRef3(Object ref3) {
        this.ref3 = ref3;
    }

    @JsonProperty("ref2")
    public Object getRef2() {
        return ref2;
    }

    @JsonProperty("ref2")
    public void setRef2(Object ref2) {
        this.ref2 = ref2;
    }

    @JsonProperty("ref5")
    public Object getRef5() {
        return ref5;
    }

    @JsonProperty("ref5")
    public void setRef5(Object ref5) {
        this.ref5 = ref5;
    }

    @JsonProperty("ref4")
    public Object getRef4() {
        return ref4;
    }

    @JsonProperty("ref4")
    public void setRef4(Object ref4) {
        this.ref4 = ref4;
    }

    @JsonProperty("recipient")
    public List<String> getRecipient() {
        return recipient;
    }

    @JsonProperty("recipient")
    public void setRecipient(List<String> recipient) {
        this.recipient = recipient;
    }

    @JsonProperty("sender")
    public String getSender() {
        return sender;
    }

    @JsonProperty("sender")
    public void setSender(String sender) {
        this.sender = sender;
    }

    @JsonProperty("applicationKey")
    public String getApplicationKey() {
        return applicationKey;
    }

    @JsonProperty("applicationKey")
    public void setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey;
    }

    @JsonProperty("deliveryReportRequired")
    public Boolean getDeliveryReportRequired() {
        return deliveryReportRequired;
    }

    @JsonProperty("deliveryReportRequired")
    public void setDeliveryReportRequired(Boolean deliveryReportRequired) {
        this.deliveryReportRequired = deliveryReportRequired;
    }

    @JsonProperty("externalRefNo")
    public String getExternalRefNo() {
        return externalRefNo;
    }

    @JsonProperty("externalRefNo")
    public void setExternalRefNo(String externalRefNo) {
        this.externalRefNo = externalRefNo;
    }

    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonProperty("blackOutStartTime")
    public Object getBlackOutStartTime() {
        return blackOutStartTime;
    }

    @JsonProperty("blackOutStartTime")
    public void setBlackOutStartTime(Object blackOutStartTime) {
        this.blackOutStartTime = blackOutStartTime;
    }

    @JsonProperty("applicationCode")
    public String getApplicationCode() {
        return applicationCode;
    }

    @JsonProperty("applicationCode")
    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode;
    }

    @JsonProperty("maskingRequired")
    public Boolean getMaskingRequired() {
        return maskingRequired;
    }

    @JsonProperty("maskingRequired")
    public void setMaskingRequired(Boolean maskingRequired) {
        this.maskingRequired = maskingRequired;
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
        return new ToStringBuilder(this).append("startDate", startDate).append("endDate", endDate).append("langId", langId).append("templateCode", templateCode).append("frequency", frequency).append("customClassName", customClassName).append("maskingRegex", maskingRegex).append("subject", subject).append("category", category).append("index", index).append("content", content).append("maxRetryCount", maxRetryCount).append("attachment", attachment).append("blackOutEndTime", blackOutEndTime).append("type", type).append("tamplateDataModel", tamplateDataModel).append("ref1", ref1).append("max", max).append("ref3", ref3).append("ref2", ref2).append("ref5", ref5).append("ref4", ref4).append("recipient", recipient).append("sender", sender).append("applicationKey", applicationKey).append("deliveryReportRequired", deliveryReportRequired).append("externalRefNo", externalRefNo).append("mode", mode).append("blackOutStartTime", blackOutStartTime).append("applicationCode", applicationCode).append("maskingRequired", maskingRequired).append("additionalProperties", additionalProperties).toString();
    }

}
