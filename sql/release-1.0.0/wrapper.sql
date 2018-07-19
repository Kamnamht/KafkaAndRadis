CREATE TABLE "COUPON_DATA" 
(	"CUSTOMER_ID" VARCHAR2(255 BYTE), 
"REF_TXN_ID" VARCHAR2(255 BYTE), 
	"PARTNER_ID" VARCHAR2(255 BYTE), 
	"RESPONSE_DATA" CLOB, 
	"VOLT_REF_TXN_ID" VARCHAR2(255 BYTE), 
	"STATUS_CODE" VARCHAR2(255 BYTE), 
	"ERROR_CODE" VARCHAR2(255 BYTE), 
	"LAST_UPDATED_AT" TIMESTAMP (6), 
	"LOADCASH_RESPONSE_TIMESTAMP" TIMESTAMP (6), 
	"AMOUNT" VARCHAR2(255 BYTE), 
	"CREATED_AT" TIMESTAMP (6), 
	 CONSTRAINT "CUSTOMER_ID_REF_TXN_ID" PRIMARY KEY ("CUSTOMER_ID", "REF_TXN_ID", "CREATED_AT"));
	 
 CREATE TABLE KAFKA_UNPROCESSED_MESSAGES 
   (	"ID" TIMESTAMP (6), 
	"UNPROCESSED_MESSAGE" CLOB, 
	 CONSTRAINT "ID" PRIMARY KEY ("ID"));
	 
CREATE TABLE PARTNER_CONFIGURATION_MAPPING
   ("PARTNER_ID" VARCHAR2(255 BYTE) NOT NULL ENABLE, 
	"COUPON_EXPIRY_PERIOD_IN_DAYS" NUMBER(19,0) NOT NULL ENABLE, 
	 CONSTRAINT "PARTNER_CONFIGURATION_MAPP_PK" PRIMARY KEY ("PARTNER_ID"));
	 
CREATE TABLE PARTNER_TEXTMESSAGE_MAPPING
   ("PARTNER_ID" VARCHAR2(255 BYTE) NOT NULL ENABLE, 
	"ERROR_CODE" VARCHAR2(255 BYTE) NOT NULL ENABLE, 
	"TEXT_MESSAGE" VARCHAR2(255 BYTE), 
    "ENABLE_RETRY" NUMBER(1,0) DEFAULT 0, 
	 CONSTRAINT "PARTNER_TEXTMESSAGE_MAPPIN_PK" PRIMARY KEY ("PARTNER_ID", "ERROR_CODE"));

