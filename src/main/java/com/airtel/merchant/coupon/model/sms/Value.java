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
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//    "ucId",
//    "externalRefNo",
//    "type",
//    "mode",
//    "langId",
//    "max",
//    "frequency",
//    "startDate",
//    "endDate",
//    "blackOutStartTime",
//    "blackOutEndTime",
//    "applicationCode",
//    "applicationKey",
//    "category",
//    "sender",
//    "recipient",
//    "templateCode",
//    "tamplateDataModel",
//    "customClassName",
//    "subject",
//    "content",
//    "attachment",
//    "maskingRequired",
//    "maskingRegex",
//    "deliveryReportRequired",
//    "maxRetryCount",
//    "ref1",
//    "ref2",
//    "ref3",
//    "ref4",
//    "ref5"
//})
//public class Value {
//
//    @JsonProperty("ucId")
//    private String ucId;
//    @JsonProperty("externalRefNo")
//    private String externalRefNo;
//    @JsonProperty("type")
//    private String type;
//    @JsonProperty("mode")
//    private String mode;
//    @JsonProperty("langId")
//    private String langId;
//    @JsonProperty("max")
//    private String max;
//    @JsonProperty("frequency")
//    private String frequency;
//    @JsonProperty("startDate")
//    private String startDate;
//    @JsonProperty("endDate")
//    private String endDate;
//    @JsonProperty("blackOutStartTime")
//    private String blackOutStartTime;
//    @JsonProperty("blackOutEndTime")
//    private String blackOutEndTime;
//    @JsonProperty("applicationCode")
//    private String applicationCode;
//    @JsonProperty("applicationKey")
//    private String applicationKey;
//    @JsonProperty("category")
//    private String category;
//    @JsonProperty("sender")
//    private String sender;
//    @JsonProperty("recipient")
//    private List<String> recipient = null;
//    @JsonProperty("templateCode")
//    private String templateCode;
//    @JsonProperty("tamplateDataModel")
//    private String tamplateDataModel;
//    @JsonProperty("customClassName")
//    private String customClassName;
//    @JsonProperty("subject")
//    private String subject;
//    @JsonProperty("content")
//    private String content;
//    @JsonProperty("attachment")
//    private String attachment;
//    @JsonProperty("maskingRequired")
//    private Boolean maskingRequired;
//    @JsonProperty("maskingRegex")
//    private String maskingRegex;
//    @JsonProperty("deliveryReportRequired")
//    private Boolean deliveryReportRequired;
//    @JsonProperty("maxRetryCount")
//    private Integer maxRetryCount;
//    @JsonProperty("ref1")
//    private Object ref1;
//    @JsonProperty("ref2")
//    private Object ref2;
//    @JsonProperty("ref3")
//    private Object ref3;
//    @JsonProperty("ref4")
//    private Object ref4;
//    @JsonProperty("ref5")
//    private Object ref5;
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//    /**
//     * No args constructor for use in serialization
//     * 
//     */
//    public Value() {
//    }
//
//    /**
//     * 
//     * @param startDate
//     * @param maskingRequired
//     * @param subject
//     * @param endDate
//     * @param frequency
//     * @param type
//     * @param ucId
//     * @param deliveryReportRequired
//     * @param recipient
//     * @param mode
//     * @param sender
//     * @param externalRefNo
//     * @param blackOutEndTime
//     * @param max
//     * @param maskingRegex
//     * @param maxRetryCount
//     * @param templateCode
//     * @param attachment
//     * @param blackOutStartTime
//     * @param ref4
//     * @param content
//     * @param ref3
//     * @param category
//     * @param ref5
//     * @param applicationCode
//     * @param customClassName
//     * @param ref2
//     * @param ref1
//     * @param applicationKey
//     * @param langId
//     * @param tamplateDataModel
//     */
//    public Value(String ucId, String externalRefNo, String type, String mode, String langId, String max, String frequency, String startDate, String endDate, String blackOutStartTime, String blackOutEndTime, String applicationCode, String applicationKey, String category, String sender, List<String> recipient, String templateCode, String tamplateDataModel, String customClassName, String subject, String content, String attachment, Boolean maskingRequired, String maskingRegex, Boolean deliveryReportRequired, Integer maxRetryCount, Object ref1, Object ref2, Object ref3, Object ref4, Object ref5) {
//        super();
//        this.ucId = ucId;
//        this.externalRefNo = externalRefNo;
//        this.type = type;
//        this.mode = mode;
//        this.langId = langId;
//        this.max = max;
//        this.frequency = frequency;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.blackOutStartTime = blackOutStartTime;
//        this.blackOutEndTime = blackOutEndTime;
//        this.applicationCode = applicationCode;
//        this.applicationKey = applicationKey;
//        this.category = category;
//        this.sender = sender;
//        this.recipient = recipient;
//        this.templateCode = templateCode;
//        this.tamplateDataModel = tamplateDataModel;
//        this.customClassName = customClassName;
//        this.subject = subject;
//        this.content = content;
//        this.attachment = attachment;
//        this.maskingRequired = maskingRequired;
//        this.maskingRegex = maskingRegex;
//        this.deliveryReportRequired = deliveryReportRequired;
//        this.maxRetryCount = maxRetryCount;
//        this.ref1 = ref1;
//        this.ref2 = ref2;
//        this.ref3 = ref3;
//        this.ref4 = ref4;
//        this.ref5 = ref5;
//    }
//
//    @JsonProperty("ucId")
//    public String getUcId() {
//        return ucId;
//    }
//
//    @JsonProperty("ucId")
//    public void setUcId(String ucId) {
//        this.ucId = ucId;
//    }
//
//    @JsonProperty("externalRefNo")
//    public String getExternalRefNo() {
//        return externalRefNo;
//    }
//
//    @JsonProperty("externalRefNo")
//    public void setExternalRefNo(String externalRefNo) {
//        this.externalRefNo = externalRefNo;
//    }
//
//    @JsonProperty("type")
//    public String getType() {
//        return type;
//    }
//
//    @JsonProperty("type")
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    @JsonProperty("mode")
//    public String getMode() {
//        return mode;
//    }
//
//    @JsonProperty("mode")
//    public void setMode(String mode) {
//        this.mode = mode;
//    }
//
//    @JsonProperty("langId")
//    public String getLangId() {
//        return langId;
//    }
//
//    @JsonProperty("langId")
//    public void setLangId(String langId) {
//        this.langId = langId;
//    }
//
//    @JsonProperty("max")
//    public String getMax() {
//        return max;
//    }
//
//    @JsonProperty("max")
//    public void setMax(String max) {
//        this.max = max;
//    }
//
//    @JsonProperty("frequency")
//    public String getFrequency() {
//        return frequency;
//    }
//
//    @JsonProperty("frequency")
//    public void setFrequency(String frequency) {
//        this.frequency = frequency;
//    }
//
//    @JsonProperty("startDate")
//    public String getStartDate() {
//        return startDate;
//    }
//
//    @JsonProperty("startDate")
//    public void setStartDate(String startDate) {
//        this.startDate = startDate;
//    }
//
//    @JsonProperty("endDate")
//    public String getEndDate() {
//        return endDate;
//    }
//
//    @JsonProperty("endDate")
//    public void setEndDate(String endDate) {
//        this.endDate = endDate;
//    }
//
//    @JsonProperty("blackOutStartTime")
//    public String getBlackOutStartTime() {
//        return blackOutStartTime;
//    }
//
//    @JsonProperty("blackOutStartTime")
//    public void setBlackOutStartTime(String blackOutStartTime) {
//        this.blackOutStartTime = blackOutStartTime;
//    }
//
//    @JsonProperty("blackOutEndTime")
//    public String getBlackOutEndTime() {
//        return blackOutEndTime;
//    }
//
//    @JsonProperty("blackOutEndTime")
//    public void setBlackOutEndTime(String blackOutEndTime) {
//        this.blackOutEndTime = blackOutEndTime;
//    }
//
//    @JsonProperty("applicationCode")
//    public String getApplicationCode() {
//        return applicationCode;
//    }
//
//    @JsonProperty("applicationCode")
//    public void setApplicationCode(String applicationCode) {
//        this.applicationCode = applicationCode;
//    }
//
//    @JsonProperty("applicationKey")
//    public String getApplicationKey() {
//        return applicationKey;
//    }
//
//    @JsonProperty("applicationKey")
//    public void setApplicationKey(String applicationKey) {
//        this.applicationKey = applicationKey;
//    }
//
//    @JsonProperty("category")
//    public String getCategory() {
//        return category;
//    }
//
//    @JsonProperty("category")
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    @JsonProperty("sender")
//    public String getSender() {
//        return sender;
//    }
//
//    @JsonProperty("sender")
//    public void setSender(String sender) {
//        this.sender = sender;
//    }
//
//    @JsonProperty("recipient")
//    public List<String> getRecipient() {
//        return recipient;
//    }
//
//    @JsonProperty("recipient")
//    public void setRecipient(List<String> recipient) {
//        this.recipient = recipient;
//    }
//
//    @JsonProperty("templateCode")
//    public String getTemplateCode() {
//        return templateCode;
//    }
//
//    @JsonProperty("templateCode")
//    public void setTemplateCode(String templateCode) {
//        this.templateCode = templateCode;
//    }
//
//    @JsonProperty("tamplateDataModel")
//    public String getTamplateDataModel() {
//        return tamplateDataModel;
//    }
//
//    @JsonProperty("tamplateDataModel")
//    public void setTamplateDataModel(String tamplateDataModel) {
//        this.tamplateDataModel = tamplateDataModel;
//    }
//
//    @JsonProperty("customClassName")
//    public String getCustomClassName() {
//        return customClassName;
//    }
//
//    @JsonProperty("customClassName")
//    public void setCustomClassName(String customClassName) {
//        this.customClassName = customClassName;
//    }
//
//    @JsonProperty("subject")
//    public String getSubject() {
//        return subject;
//    }
//
//    @JsonProperty("subject")
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    @JsonProperty("content")
//    public String getContent() {
//        return content;
//    }
//
//    @JsonProperty("content")
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    @JsonProperty("attachment")
//    public String getAttachment() {
//        return attachment;
//    }
//
//    @JsonProperty("attachment")
//    public void setAttachment(String attachment) {
//        this.attachment = attachment;
//    }
//
//    @JsonProperty("maskingRequired")
//    public Boolean getMaskingRequired() {
//        return maskingRequired;
//    }
//
//    @JsonProperty("maskingRequired")
//    public void setMaskingRequired(Boolean maskingRequired) {
//        this.maskingRequired = maskingRequired;
//    }
//
//    @JsonProperty("maskingRegex")
//    public String getMaskingRegex() {
//        return maskingRegex;
//    }
//
//    @JsonProperty("maskingRegex")
//    public void setMaskingRegex(String maskingRegex) {
//        this.maskingRegex = maskingRegex;
//    }
//
//    @JsonProperty("deliveryReportRequired")
//    public Boolean getDeliveryReportRequired() {
//        return deliveryReportRequired;
//    }
//
//    @JsonProperty("deliveryReportRequired")
//    public void setDeliveryReportRequired(Boolean deliveryReportRequired) {
//        this.deliveryReportRequired = deliveryReportRequired;
//    }
//
//    @JsonProperty("maxRetryCount")
//    public Integer getMaxRetryCount() {
//        return maxRetryCount;
//    }
//
//    @JsonProperty("maxRetryCount")
//    public void setMaxRetryCount(Integer maxRetryCount) {
//        this.maxRetryCount = maxRetryCount;
//    }
//
//    @JsonProperty("ref1")
//    public Object getRef1() {
//        return ref1;
//    }
//
//    @JsonProperty("ref1")
//    public void setRef1(Object ref1) {
//        this.ref1 = ref1;
//    }
//
//    @JsonProperty("ref2")
//    public Object getRef2() {
//        return ref2;
//    }
//
//    @JsonProperty("ref2")
//    public void setRef2(Object ref2) {
//        this.ref2 = ref2;
//    }
//
//    @JsonProperty("ref3")
//    public Object getRef3() {
//        return ref3;
//    }
//
//    @JsonProperty("ref3")
//    public void setRef3(Object ref3) {
//        this.ref3 = ref3;
//    }
//
//    @JsonProperty("ref4")
//    public Object getRef4() {
//        return ref4;
//    }
//
//    @JsonProperty("ref4")
//    public void setRef4(Object ref4) {
//        this.ref4 = ref4;
//    }
//
//    @JsonProperty("ref5")
//    public Object getRef5() {
//        return ref5;
//    }
//
//    @JsonProperty("ref5")
//    public void setRef5(Object ref5) {
//        this.ref5 = ref5;
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
//        return new ToStringBuilder(this).append("ucId", ucId).append("externalRefNo", externalRefNo).append("type", type).append("mode", mode).append("langId", langId).append("max", max).append("frequency", frequency).append("startDate", startDate).append("endDate", endDate).append("blackOutStartTime", blackOutStartTime).append("blackOutEndTime", blackOutEndTime).append("applicationCode", applicationCode).append("applicationKey", applicationKey).append("category", category).append("sender", sender).append("recipient", recipient).append("templateCode", templateCode).append("tamplateDataModel", tamplateDataModel).append("customClassName", customClassName).append("subject", subject).append("content", content).append("attachment", attachment).append("maskingRequired", maskingRequired).append("maskingRegex", maskingRegex).append("deliveryReportRequired", deliveryReportRequired).append("maxRetryCount", maxRetryCount).append("ref1", ref1).append("ref2", ref2).append("ref3", ref3).append("ref4", ref4).append("ref5", ref5).append("additionalProperties", additionalProperties).toString();
//    }
//
//}
