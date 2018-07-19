Delete * from PARTNER_CONFIGURATION_MAPPING where PARTNER_ID = '1000003122';
 
Insert into PARTNER_TEXT_MESSAGE_MAPPING (PARTNER_ID,ERROR_CODE,TEXT_MESSAGE,ENABLE_RETRY) values ('1000003122','APB_019','Congratulations you have received Rs ${amount} as benefit for Netree. To redeem the benefit open Airtel Payments Bank Wallet. http://bit.ly/2usrExY',1);
Insert into PARTNER_TEXT_MESSAGE_MAPPING (PARTNER_ID,ERROR_CODE,TEXT_MESSAGE,ENABLE_RETRY) values ('1000003122','APB_001','Insufficient_Balance...',0);
Insert into PARTNER_TEXT_MESSAGE_MAPPING (PARTNER_ID,ERROR_CODE,TEXT_MESSAGE,ENABLE_RETRY) values ('1000003122','APB_007','Server Problem...!!!',0);
Insert into PARTNER_TEXT_MESSAGE_MAPPING (PARTNER_ID,ERROR_CODE,TEXT_MESSAGE,ENABLE_RETRY) values ('1000003122','APB_004','Amount cannot be credited as account exceeds maximum balance limit.',0);
Insert into PARTNER_TEXT_MESSAGE_MAPPING (PARTNER_ID,ERROR_CODE,TEXT_MESSAGE,ENABLE_RETRY) values ('1000003122','APB_006','Your account is on Credit freeze. Kindly connect to our call center 400',0);
Insert into PARTNER_TEXT_MESSAGE_MAPPING (PARTNER_ID,ERROR_CODE,TEXT_MESSAGE,ENABLE_RETRY) values ('1000003122','APB_003','Account balance cannot exceed 10K. Kindly connect to our call center 400',0);
Insert into PARTNER_TEXT_MESSAGE_MAPPING (PARTNER_ID,ERROR_CODE,TEXT_MESSAGE,ENABLE_RETRY) values ('1000003122','APB_011','Your account is locked . Kindly connect to our call center 400',0);