package com.airtel.merchant.coupon.model.loadcash;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SBAModel {
	@JsonProperty("COD_CUST_NATL_ID")
	private String	cod_cust_natl_id;

	private String errorMsg;
	
	public SBAModel() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCod_cust_natl_id() {
		return cod_cust_natl_id;
	}

	public void setCod_cust_natl_id(String cod_cust_natl_id) {
		this.cod_cust_natl_id = cod_cust_natl_id;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	// Intentionally commented. To be used if needed in future.
	/*@JsonProperty("COD_CUST_ID")
	private String	cod_cust_id;

	@JsonProperty("DAT_CUST_OPEN")
	private String	dat_cust_open;

	@JsonProperty("COD_BANK_CARD")
	private String	cod_bank_card;

	@JsonProperty("FLG_CUST_TYP")
	private String	flg_cust_typ;

	@JsonProperty("CIF_TYPE")
	private String	cif_type;

	@JsonProperty("FLG_STAFF")
	private String	flg_staff;

	@JsonProperty("FLG_LOC_GLOB")
	private String	flg_loc_glob;

	@JsonProperty("COD_CC_HOMEBRN")
	private String	cod_cc_homebrn;

	@JsonProperty("COD_OFFICR_ID")
	private String	cod_officr_id;

	@JsonProperty("NAM_CUST_SHRT")
	private String	nam_cust_shrt;

	@JsonProperty("TXT_CUST_PREFIX")
	private String	txt_cust_prefix;

	@JsonProperty("NAM_CUST_FULL")
	private String	nam_cust_full;

	@JsonProperty("NAM_CUST_LAST")
	private String	nam_cust_last;

	@JsonProperty("NAM_CUST_MID")
	private String	nam_cust_mid;

	@JsonProperty("NAM_CUST_FIRST")
	private String	nam_cust_first;

	@JsonProperty("COD_CUST_PHONETIC")
	private String	cod_cust_phonetic;

	@JsonProperty("COD_MID_PHONETIC")
	private String	cod_mid_phonetic;

	@JsonProperty("COD_FIRST_PHONETIC")
	private String	cod_first_phonetic;

	@JsonProperty("FLG_MEMBER")
	private String	flg_member;

	@JsonProperty("COD_MEMBER_NO")
	private String	cod_member_no;

	@JsonProperty("COD_CUST_STAT")
	private String	cod_cust_stat;

	@JsonProperty("TXT_CUST_DESGN")
	private String	txt_cust_desgn;

	@JsonProperty("FLG_IC_TYP")
	private String	flg_ic_typ;

	@JsonProperty("COD_CUST_NATL_ID")
	private String	cod_cust_natl_id;

	@JsonProperty("COD_NATL_ID_OLD")
	private String	cod_natl_id_old;

	@JsonProperty("COD_CUST_LANG")
	private String	cod_cust_lang;

	@JsonProperty("COD_INCOME_CAT")
	private String	cod_income_cat;

	@JsonProperty("COD_SIGN_TYP")
	private String	cod_sign_typ;

	@JsonProperty("TXT_PROFESS_CAT")
	private String	txt_profess_cat;

	@JsonProperty("COD_TDS")
	private String	cod_tds;

	@JsonProperty("REF_CUST_IT_NUM")
	private String	ref_cust_it_num;

	@JsonProperty("TXT_CUSTADR_ADD1")
	private String	txt_custadr_add1;

	@JsonProperty("TXT_CUSTADR_ADD2")
	private String	txt_custadr_add2;

	@JsonProperty("TXT_CUSTADR_ADD3")
	private String	txt_custadr_add3;

	@JsonProperty("NAM_CUSTADR_CITY")
	private String	nam_custadr_city;

	@JsonProperty("NAM_CUSTADR_STATE")
	private String	nam_custadr_state;

	@JsonProperty("NAM_CUSTADR_CNTRY")
	private String	nam_custadr_cntry;

	@JsonProperty("TXT_CUSTADR_ZIP")
	private String	txt_custadr_zip;

	@JsonProperty("REF_CUST_PHONE")
	private String	ref_cust_phone;

	@JsonProperty("REF_CUST_PHONE_OFF")
	private String	ref_cust_phone_off;

	@JsonProperty("REF_CUST_FAX")
	private String	ref_cust_fax;

	@JsonProperty("REF_CUST_TELEX")
	private String	ref_cust_telex;

	@JsonProperty("REF_CUST_EMAIL")
	private String	ref_cust_email;

	@JsonProperty("TXT_PERMADR_ADD1")
	private String	txt_permadr_add1;

	@JsonProperty("TXT_PERMADR_ADD2")
	private String	txt_permadr_add2;

	@JsonProperty("TXT_PERMADR_ADD3")
	private String	txt_permadr_add3;

	@JsonProperty("NAM_PERMADR_CITY")
	private String	nam_permadr_city;

	@JsonProperty("NAM_PERMADR_CNTRY")
	private String	nam_permadr_cntry;

	@JsonProperty("NAM_PERMADR_STATE")
	private String	nam_permadr_state;

	@JsonProperty("TXT_PERMADR_ZIP")
	private String	txt_permadr_zip;

	@JsonProperty("DAT_BIRTH_CUST")
	private String	dat_birth_cust;

	@JsonProperty("TXT_CUST_SEX")
	private String	txt_cust_sex;

	@JsonProperty("COD_CUST_MARSTAT")
	private String	cod_cust_marstat;

	@JsonProperty("CTR_CUST_SPOUSES")
	private String	ctr_cust_spouses;

	@JsonProperty("NAM_CUST_SPOUSE")
	private String	nam_cust_spouse;

	@JsonProperty("TXT_SPOUSE_OCCPN")
	private String	txt_spouse_occpn;

	@JsonProperty("CTR_DPNDT_CHLDRN")
	private String	ctr_dpndt_chldrn;

	@JsonProperty("CTR_DPNDT_OTHRS")
	private String	ctr_dpndt_othrs;

	@JsonProperty("COD_TYP_ACCOM")
	private String	cod_typ_accom;

	@JsonProperty("TXT_LGL_RSDNC_STAT")
	private String	txt_lgl_rsdnc_stat;

	@JsonProperty("TXT_ETHNIC_ORIGIN")
	private String	txt_ethnic_origin;

	@JsonProperty("TXT_CUST_NATNLTY")
	private String	txt_cust_natnlty;

	@JsonProperty("COD_CUST_BLDGRP")
	private String	cod_cust_bldgrp;

	@JsonProperty("TXT_CUST_EDUCN")
	private String	txt_cust_educn;

	@JsonProperty("FLG_CUST_MEMO")
	private String	flg_cust_memo;

	@JsonProperty("DAT_INCORPORATED")
	private String	dat_incorporated;

	@JsonProperty("NAM_CNTRY_INCORP")
	private String	nam_cntry_incorp;

	@JsonProperty("COD_BUSINESS_REGNO")
	private String	cod_business_regno;

	@JsonProperty("COD_BUSINESS_CAT")
	private String	cod_business_cat;

	@JsonProperty("TXT_BUSINESS_TYP")
	private String	txt_business_typ;

	@JsonProperty("NAM_SIGNATORY1")
	private String	nam_signatory1;

	@JsonProperty("NAM_SIGNATORY2")
	private String	nam_signatory2;

	@JsonProperty("NAM_SIGNATORY3")
	private String	nam_signatory3;

	@JsonProperty("NAM_SIGNATORY4")
	private String	nam_signatory4;

	@JsonProperty("NAM_SIGNATORY5")
	private String	nam_signatory5;

	@JsonProperty("TXT_DESGN_SIGNTRY1")
	private String	txt_desgn_signtry1;

	@JsonProperty("TXT_DESGN_SIGNTRY2")
	private String	txt_desgn_signtry2;

	@JsonProperty("TXT_DESGN_SIGNTRY3")
	private String	txt_desgn_signtry3;

	@JsonProperty("TXT_DESGN_SIGNTRY4")
	private String	txt_desgn_signtry4;

	@JsonProperty("TXT_DESGN_SIGNTRY5")
	private String	txt_desgn_signtry5;

	@JsonProperty("NAM_DIRECTOR1")
	private String	nam_director1;

	@JsonProperty("NAM_DIRECTOR2")
	private String	nam_director2;

	@JsonProperty("NAM_DIRECTOR3")
	private String	nam_director3;

	@JsonProperty("NAM_DIRECTOR4")
	private String	nam_director4;

	@JsonProperty("NAM_DIRECTOR5")
	private String	nam_director5;

	@JsonProperty("COD_REPORT1")
	private String	cod_report1;

	@JsonProperty("COD_REPORT2")
	private String	cod_report2;

	@JsonProperty("COD_REPORT3")
	private String	cod_report3;

	@JsonProperty("FLG_MNT_STATUS")
	private String	flg_mnt_status;

	@JsonProperty("COD_MNT_ACTION")
	private String	cod_mnt_action;

	@JsonProperty("COD_LAST_MNT_MAKERID")
	private String	cod_last_mnt_makerid;

	@JsonProperty("COD_LAST_MNT_CHKRID")
	private String	cod_last_mnt_chkrid;

	@JsonProperty("DAT_LAST_MNT")
	private String	dat_last_mnt;

	@JsonProperty("CTR_UPDAT_SRLNO")
	private String	ctr_updat_srlno;

	@JsonProperty("FLG_KEY_CHG")
	private String	flg_key_chg;

	@JsonProperty("FLG_CUST_STATUS")
	private String	flg_cust_status;

	@JsonProperty("FLG_REPLICATE")
	private String	flg_replicate;

	@JsonProperty("COD_LIAB_NO")
	private String	cod_liab_no;

	@JsonProperty("CREDIT_RATING")
	private String	credit_rating;

	@JsonProperty("DAT_REVISION")
	private String	dat_revision;

	@JsonProperty("FX_CUST_CLEAN_RISK_LIMIT")
	private String	fx_cust_clean_risk_limit;

	@JsonProperty("FX_CLEAN_RISK_LIMIT")
	private String	fx_clean_risk_limit;

	@JsonProperty("AMT_LIMIT_TOT")
	private String	amt_limit_tot;

	@JsonProperty("COD_CCY_LIMIT")
	private String	cod_ccy_limit;

	@JsonProperty("SEC_CUST_CLEAN_RISK_LIMIT")
	private String	sec_cust_clean_risk_limit;

	@JsonProperty("SEC_CLEAN_RISK_LIMIT")
	private String	sec_clean_risk_limit;

	@JsonProperty("SEC_CUST_PSTL_RISK_LIMIT")
	private String	sec_cust_pstl_risk_limit;

	@JsonProperty("SEC_PSTL_RISK_LIMIT")
	private String	sec_pstl_risk_limit;

	@JsonProperty("DAT_CIF_TYPE_CHANGE")
	private String	dat_cif_type_change;

	@JsonProperty("FLG_REST_CUST")
	private String	flg_rest_cust;

	@JsonProperty("FLG_LOCK_FAC")
	private String	flg_lock_fac;

	@JsonProperty("TXT_MOB_EMAIL_ADD")
	private String	txt_mob_email_add;

	@JsonProperty("COD_VERIFIED_REASON")
	private String	cod_verified_reason;

	@JsonProperty("FX_CUST_CAT")
	private String	fx_cust_cat;

	@JsonProperty("COD_ACCT_NO_SALARY")
	private String	cod_acct_no_salary;

	@JsonProperty("COD_STREAM_ID")
	private String	cod_stream_id;

	@JsonProperty("COD_STMT_DISPATCH_MODE")
	private String	cod_stmt_dispatch_mode;

	@JsonProperty("COD_KYC_STATUS")
	private String	cod_kyc_status;

	@JsonProperty("COD_KYC_RISK_CATEGORY")
	private String	cod_kyc_risk_category;

	@JsonProperty("TXT_REASON_RISK_CATEGORY_CHNG")
	private String	txt_reason_risk_category_chng;

	@JsonProperty("DAT_KYC_RISK_CATEGORY_REVIEW")
	private String	dat_kyc_risk_category_review;

	@JsonProperty("COD_CUST_INTRODUCER_ID")
	private String	cod_cust_introducer_id;

	@JsonProperty("COD_EMPLOYEE_ID")
	private String	cod_employee_id;

	@JsonProperty("CTR_MIS_CODES")
	private String	ctr_mis_codes;

	@JsonProperty("COD_MIS_CUST_CODE_1")
	private String	cod_mis_cust_code_1;

	@JsonProperty("COD_MIS_CUST_CODE_2")
	private String	cod_mis_cust_code_2;

	@JsonProperty("COD_MIS_CUST_CODE_3")
	private String	cod_mis_cust_code_3;

	@JsonProperty("COD_MIS_CUST_CODE_4")
	private String	cod_mis_cust_code_4;

	@JsonProperty("COD_MIS_CUST_CODE_5")
	private String	cod_mis_cust_code_5;

	@JsonProperty("COD_MIS_CUST_CODE_6")
	private String	cod_mis_cust_code_6;

	@JsonProperty("COD_MIS_CUST_CODE_7")
	private String	cod_mis_cust_code_7;

	@JsonProperty("COD_MIS_CUST_CODE_8")
	private String	cod_mis_cust_code_8;

	@JsonProperty("COD_MIS_CUST_CODE_9")
	private String	cod_mis_cust_code_9;

	@JsonProperty("COD_MIS_CUST_CODE_10")
	private String	cod_mis_cust_code_10;

	@JsonProperty("COD_MIS_COMP_CODE_1")
	private String	cod_mis_comp_code_1;

	@JsonProperty("COD_MIS_COMP_CODE_2")
	private String	cod_mis_comp_code_2;

	@JsonProperty("COD_MIS_COMP_CODE_3")
	private String	cod_mis_comp_code_3;

	@JsonProperty("COD_MIS_COMP_CODE_4")
	private String	cod_mis_comp_code_4;

	@JsonProperty("COD_MIS_COMP_CODE_5")
	private String	cod_mis_comp_code_5;

	@JsonProperty("COD_MIS_COMP_CODE_6")
	private String	cod_mis_comp_code_6;

	@JsonProperty("COD_MIS_COMP_CODE_7")
	private String	cod_mis_comp_code_7;

	@JsonProperty("COD_MIS_COMP_CODE_8")
	private String	cod_mis_comp_code_8;

	@JsonProperty("COD_MIS_COMP_CODE_9")
	private String	cod_mis_comp_code_9;

	@JsonProperty("COD_MIS_COMP_CODE_10")
	private String	cod_mis_comp_code_10;

	@JsonProperty("FLG_MINOR")
	private String	flg_minor;

	@JsonProperty("COD_GUARDIAN_TYPE")
	private String	cod_guardian_type;

	@JsonProperty("COD_ACCT_NO_DEFAULT")
	private String	cod_acct_no_default;

	@JsonProperty("TXT_CUST_RESIDENCE")
	private String	txt_cust_residence;

	@JsonProperty("AFL_ISSUE_DATE")
	private String	afl_issue_date;

	@JsonProperty("AFL_EXPIRY_DATE")
	private String	afl_expiry_date;

	@JsonProperty("AFL_EFFECTIVE_DATE")
	private String	afl_effective_date;

	@JsonProperty("LAST_RENEW_DATE")
	private String	last_renew_date;

	@JsonProperty("FLG_UNADV")
	private String	flg_unadv;

	@JsonProperty("FLG_DOC_COMPLETE")
	private String	flg_doc_complete;

	@JsonProperty("FLG_KIO")
	private String	flg_kio;

	@JsonProperty("TXT_HOLDADR_ADD1")
	private String	txt_holdadr_add1;

	@JsonProperty("TXT_HOLDADR_ADD2")
	private String	txt_holdadr_add2;

	@JsonProperty("TXT_HOLDADR_ADD3")
	private String	txt_holdadr_add3;

	@JsonProperty("NAM_HOLDADR_CITY")
	private String	nam_holdadr_city;

	@JsonProperty("NAM_HOLDADR_STATE")
	private String	nam_holdadr_state;

	@JsonProperty("NAM_HOLDADR_CNTRY")
	private String	nam_holdadr_cntry;

	@JsonProperty("TXT_HOLDADR_ZIP")
	private String	txt_holdadr_zip;

	@JsonProperty("REF_HOLD_PHONE")
	private String	ref_hold_phone;

	@JsonProperty("REF_HOLD_PHONE_OFF")
	private String	ref_hold_phone_off;

	@JsonProperty("REF_HOLD_FAX")
	private String	ref_hold_fax;

	@JsonProperty("REF_HOLD_TELEX")
	private String	ref_hold_telex;

	@JsonProperty("REF_HOLD_EMAIL")
	private String	ref_hold_email;

	@JsonProperty("COD_CUST_STATUS")
	private String	cod_cust_status;

	@JsonProperty("COD_TDS_2")
	private String	cod_tds_2;

	@JsonProperty("REF_RES_PHONE_COUNTRY")
	private String	ref_res_phone_country;

	@JsonProperty("REF_RES_PHONE_AREA")
	private String	ref_res_phone_area;

	@JsonProperty("REF_RES_PHONE_EXTN")
	private String	ref_res_phone_extn;

	@JsonProperty("REF_PHONE_MOBILE")
	private String	ref_phone_mobile;

	@JsonProperty("REF_OFFICE_PHONE_COUNTRY")
	private String	ref_office_phone_country;

	@JsonProperty("REF_OFFICE_PHONE_AREA")
	private String	ref_office_phone_area;

	@JsonProperty("REF_OFFICE_PHONE_EXTN")
	private String	ref_office_phone_extn;

	@JsonProperty("FLG_BLOCKED")
	private String	flg_blocked;

	@JsonProperty("COD_BLOCK_REASON")
	private String	cod_block_reason;

	@JsonProperty("FLG_VERIFIED_STAT")
	private String	flg_verified_stat;

	@JsonProperty("DAT_VERIFIED")
	private String	dat_verified;

	@JsonProperty("COD_SECRECY_LVL")
	private String	cod_secrecy_lvl;

	@JsonProperty("COD_CRIF_CONSENT_LVL")
	private String	cod_crif_consent_lvl;

	@JsonProperty("FLG_SPL_CUST")
	private String	flg_spl_cust;

	@JsonProperty("COD_UTL_COMP")
	private String	cod_utl_comp;

	@JsonProperty("NAM_MOTHER_MAIDEN")
	private String	nam_mother_maiden;

	@JsonProperty("TXT_CONTRY_INIT_RISK")
	private String	txt_contry_init_risk;

	@JsonProperty("TXT_CONTRY_ULT_RISK")
	private String	txt_contry_ult_risk;

	@JsonProperty("DAT_ADDR_CHANGE")
	private String	dat_addr_change;

	@JsonProperty("COD_AADHAAR_NO")
	private String	cod_aadhaar_no;

	@JsonProperty("DAT_AADHAAR_UPDATED_ON")
	private String	dat_aadhaar_updated_on;

	@JsonProperty("COD_AADHAAR_LINK_ACCT")
	private String	cod_aadhaar_link_acct;

	@JsonProperty("FLG_SPEND_ANALYSIS")
	private String	flg_spend_analysis;

	@JsonProperty("EXPOSURE_CATEGORY")
	private String	exposure_category;

	@JsonProperty("CIF_STATUS")
	private String	cif_status;

	@JsonProperty("EEFC_PERCENT")
	private String	eefc_percent;

	@JsonProperty("BILL_MARGIN")
	private String	bill_margin;

	@JsonProperty("IFSC_CODE")
	private String	ifsc_code;

	@JsonProperty("LOCATION")
	private String	location;

	@JsonProperty("MEDIA")
	private String	media;

	@JsonProperty("MSG_TYPE")
	private String	msg_type;

	@JsonProperty("MODULE")
	private String	module;

	@JsonProperty("BRANCH")
	private String	branch;

	@JsonProperty("CUST_AC_NO")
	private String	cust_ac_no;

	@JsonProperty("PRIMARY_ADDRESS")
	private String	primary_address;

	@JsonProperty("NO_OF_COPIES")
	private String	no_of_copies;

	@JsonProperty("FORMAT")
	private String	format;

	@JsonProperty("ANSWERBACK")
	private String	answerback;

	@JsonProperty("TEST_REQUIRED")
	private String	test_required;

	@JsonProperty("TEST_KEYWORD")
	private String	test_keyword;

	@JsonProperty("TOBE_EMAILED")
	private String	tobe_emailed;

	@JsonProperty("DELIVERY_BY")
	private String	delivery_by;

	@JsonProperty("CUSTOMER_NO_EXT")
	private String	customer_no_ext;

	@JsonProperty("CIF_STATUS_SINCE")
	private String	cif_status_since;

	@JsonProperty("ELCM_CUSTOMER_NO")
	private String	elcm_customer_no;*/	
	

	/*public String getCod_cust_id() {
		return cod_cust_id;
	}

	public void setCod_cust_id(String cod_cust_id) {
		this.cod_cust_id = cod_cust_id;
	}

	public String getDat_cust_open() {
		return dat_cust_open;
	}

	public void setDat_cust_open(String dat_cust_open) {
		this.dat_cust_open = dat_cust_open;
	}

	public String getCod_bank_card() {
		return cod_bank_card;
	}

	public void setCod_bank_card(String cod_bank_card) {
		this.cod_bank_card = cod_bank_card;
	}

	public String getFlg_cust_typ() {
		return flg_cust_typ;
	}

	public void setFlg_cust_typ(String flg_cust_typ) {
		this.flg_cust_typ = flg_cust_typ;
	}

	public String getCif_type() {
		return cif_type;
	}

	public void setCif_type(String cif_type) {
		this.cif_type = cif_type;
	}

	public String getFlg_staff() {
		return flg_staff;
	}

	public void setFlg_staff(String flg_staff) {
		this.flg_staff = flg_staff;
	}

	public String getFlg_loc_glob() {
		return flg_loc_glob;
	}

	public void setFlg_loc_glob(String flg_loc_glob) {
		this.flg_loc_glob = flg_loc_glob;
	}

	public String getCod_cc_homebrn() {
		return cod_cc_homebrn;
	}

	public void setCod_cc_homebrn(String cod_cc_homebrn) {
		this.cod_cc_homebrn = cod_cc_homebrn;
	}

	public String getCod_officr_id() {
		return cod_officr_id;
	}

	public void setCod_officr_id(String cod_officr_id) {
		this.cod_officr_id = cod_officr_id;
	}

	public String getNam_cust_shrt() {
		return nam_cust_shrt;
	}

	public void setNam_cust_shrt(String nam_cust_shrt) {
		this.nam_cust_shrt = nam_cust_shrt;
	}

	public String getTxt_cust_prefix() {
		return txt_cust_prefix;
	}

	public void setTxt_cust_prefix(String txt_cust_prefix) {
		this.txt_cust_prefix = txt_cust_prefix;
	}

	public String getNam_cust_full() {
		return nam_cust_full;
	}

	public void setNam_cust_full(String nam_cust_full) {
		this.nam_cust_full = nam_cust_full;
	}

	public String getNam_cust_last() {
		return nam_cust_last;
	}

	public void setNam_cust_last(String nam_cust_last) {
		this.nam_cust_last = nam_cust_last;
	}

	public String getNam_cust_mid() {
		return nam_cust_mid;
	}

	public void setNam_cust_mid(String nam_cust_mid) {
		this.nam_cust_mid = nam_cust_mid;
	}

	public String getNam_cust_first() {
		return nam_cust_first;
	}

	public void setNam_cust_first(String nam_cust_first) {
		this.nam_cust_first = nam_cust_first;
	}

	public String getCod_cust_phonetic() {
		return cod_cust_phonetic;
	}

	public void setCod_cust_phonetic(String cod_cust_phonetic) {
		this.cod_cust_phonetic = cod_cust_phonetic;
	}

	public String getCod_mid_phonetic() {
		return cod_mid_phonetic;
	}

	public void setCod_mid_phonetic(String cod_mid_phonetic) {
		this.cod_mid_phonetic = cod_mid_phonetic;
	}

	public String getCod_first_phonetic() {
		return cod_first_phonetic;
	}

	public void setCod_first_phonetic(String cod_first_phonetic) {
		this.cod_first_phonetic = cod_first_phonetic;
	}

	public String getFlg_member() {
		return flg_member;
	}

	public void setFlg_member(String flg_member) {
		this.flg_member = flg_member;
	}

	public String getCod_member_no() {
		return cod_member_no;
	}

	public void setCod_member_no(String cod_member_no) {
		this.cod_member_no = cod_member_no;
	}

	public String getCod_cust_stat() {
		return cod_cust_stat;
	}

	public void setCod_cust_stat(String cod_cust_stat) {
		this.cod_cust_stat = cod_cust_stat;
	}

	public String getTxt_cust_desgn() {
		return txt_cust_desgn;
	}

	public void setTxt_cust_desgn(String txt_cust_desgn) {
		this.txt_cust_desgn = txt_cust_desgn;
	}

	public String getFlg_ic_typ() {
		return flg_ic_typ;
	}

	public void setFlg_ic_typ(String flg_ic_typ) {
		this.flg_ic_typ = flg_ic_typ;
	}

	public String getCod_cust_natl_id() {
		return cod_cust_natl_id;
	}

	public void setCod_cust_natl_id(String cod_cust_natl_id) {
		this.cod_cust_natl_id = cod_cust_natl_id;
	}

	public String getCod_natl_id_old() {
		return cod_natl_id_old;
	}

	public void setCod_natl_id_old(String cod_natl_id_old) {
		this.cod_natl_id_old = cod_natl_id_old;
	}

	public String getCod_cust_lang() {
		return cod_cust_lang;
	}

	public void setCod_cust_lang(String cod_cust_lang) {
		this.cod_cust_lang = cod_cust_lang;
	}

	public String getCod_income_cat() {
		return cod_income_cat;
	}

	public void setCod_income_cat(String cod_income_cat) {
		this.cod_income_cat = cod_income_cat;
	}

	public String getCod_sign_typ() {
		return cod_sign_typ;
	}

	public void setCod_sign_typ(String cod_sign_typ) {
		this.cod_sign_typ = cod_sign_typ;
	}

	public String getTxt_profess_cat() {
		return txt_profess_cat;
	}

	public void setTxt_profess_cat(String txt_profess_cat) {
		this.txt_profess_cat = txt_profess_cat;
	}

	public String getCod_tds() {
		return cod_tds;
	}

	public void setCod_tds(String cod_tds) {
		this.cod_tds = cod_tds;
	}

	public String getRef_cust_it_num() {
		return ref_cust_it_num;
	}

	public void setRef_cust_it_num(String ref_cust_it_num) {
		this.ref_cust_it_num = ref_cust_it_num;
	}

	public String getTxt_custadr_add1() {
		return txt_custadr_add1;
	}

	public void setTxt_custadr_add1(String txt_custadr_add1) {
		this.txt_custadr_add1 = txt_custadr_add1;
	}

	public String getTxt_custadr_add2() {
		return txt_custadr_add2;
	}

	public void setTxt_custadr_add2(String txt_custadr_add2) {
		this.txt_custadr_add2 = txt_custadr_add2;
	}

	public String getTxt_custadr_add3() {
		return txt_custadr_add3;
	}

	public void setTxt_custadr_add3(String txt_custadr_add3) {
		this.txt_custadr_add3 = txt_custadr_add3;
	}

	public String getNam_custadr_city() {
		return nam_custadr_city;
	}

	public void setNam_custadr_city(String nam_custadr_city) {
		this.nam_custadr_city = nam_custadr_city;
	}

	public String getNam_custadr_state() {
		return nam_custadr_state;
	}

	public void setNam_custadr_state(String nam_custadr_state) {
		this.nam_custadr_state = nam_custadr_state;
	}

	public String getNam_custadr_cntry() {
		return nam_custadr_cntry;
	}

	public void setNam_custadr_cntry(String nam_custadr_cntry) {
		this.nam_custadr_cntry = nam_custadr_cntry;
	}

	public String getTxt_custadr_zip() {
		return txt_custadr_zip;
	}

	public void setTxt_custadr_zip(String txt_custadr_zip) {
		this.txt_custadr_zip = txt_custadr_zip;
	}

	public String getRef_cust_phone() {
		return ref_cust_phone;
	}

	public void setRef_cust_phone(String ref_cust_phone) {
		this.ref_cust_phone = ref_cust_phone;
	}

	public String getRef_cust_phone_off() {
		return ref_cust_phone_off;
	}

	public void setRef_cust_phone_off(String ref_cust_phone_off) {
		this.ref_cust_phone_off = ref_cust_phone_off;
	}

	public String getRef_cust_fax() {
		return ref_cust_fax;
	}

	public void setRef_cust_fax(String ref_cust_fax) {
		this.ref_cust_fax = ref_cust_fax;
	}

	public String getRef_cust_telex() {
		return ref_cust_telex;
	}

	public void setRef_cust_telex(String ref_cust_telex) {
		this.ref_cust_telex = ref_cust_telex;
	}

	public String getRef_cust_email() {
		return ref_cust_email;
	}

	public void setRef_cust_email(String ref_cust_email) {
		this.ref_cust_email = ref_cust_email;
	}

	public String getTxt_permadr_add1() {
		return txt_permadr_add1;
	}

	public void setTxt_permadr_add1(String txt_permadr_add1) {
		this.txt_permadr_add1 = txt_permadr_add1;
	}

	public String getTxt_permadr_add2() {
		return txt_permadr_add2;
	}

	public void setTxt_permadr_add2(String txt_permadr_add2) {
		this.txt_permadr_add2 = txt_permadr_add2;
	}

	public String getTxt_permadr_add3() {
		return txt_permadr_add3;
	}

	public void setTxt_permadr_add3(String txt_permadr_add3) {
		this.txt_permadr_add3 = txt_permadr_add3;
	}

	public String getNam_permadr_city() {
		return nam_permadr_city;
	}

	public void setNam_permadr_city(String nam_permadr_city) {
		this.nam_permadr_city = nam_permadr_city;
	}

	public String getNam_permadr_cntry() {
		return nam_permadr_cntry;
	}

	public void setNam_permadr_cntry(String nam_permadr_cntry) {
		this.nam_permadr_cntry = nam_permadr_cntry;
	}

	public String getNam_permadr_state() {
		return nam_permadr_state;
	}

	public void setNam_permadr_state(String nam_permadr_state) {
		this.nam_permadr_state = nam_permadr_state;
	}

	public String getTxt_permadr_zip() {
		return txt_permadr_zip;
	}

	public void setTxt_permadr_zip(String txt_permadr_zip) {
		this.txt_permadr_zip = txt_permadr_zip;
	}

	public String getDat_birth_cust() {
		return dat_birth_cust;
	}

	public void setDat_birth_cust(String dat_birth_cust) {
		this.dat_birth_cust = dat_birth_cust;
	}

	public String getTxt_cust_sex() {
		return txt_cust_sex;
	}

	public void setTxt_cust_sex(String txt_cust_sex) {
		this.txt_cust_sex = txt_cust_sex;
	}

	public String getCod_cust_marstat() {
		return cod_cust_marstat;
	}

	public void setCod_cust_marstat(String cod_cust_marstat) {
		this.cod_cust_marstat = cod_cust_marstat;
	}

	public String getCtr_cust_spouses() {
		return ctr_cust_spouses;
	}

	public void setCtr_cust_spouses(String ctr_cust_spouses) {
		this.ctr_cust_spouses = ctr_cust_spouses;
	}

	public String getNam_cust_spouse() {
		return nam_cust_spouse;
	}

	public void setNam_cust_spouse(String nam_cust_spouse) {
		this.nam_cust_spouse = nam_cust_spouse;
	}

	public String getTxt_spouse_occpn() {
		return txt_spouse_occpn;
	}

	public void setTxt_spouse_occpn(String txt_spouse_occpn) {
		this.txt_spouse_occpn = txt_spouse_occpn;
	}

	public String getCtr_dpndt_chldrn() {
		return ctr_dpndt_chldrn;
	}

	public void setCtr_dpndt_chldrn(String ctr_dpndt_chldrn) {
		this.ctr_dpndt_chldrn = ctr_dpndt_chldrn;
	}

	public String getCtr_dpndt_othrs() {
		return ctr_dpndt_othrs;
	}

	public void setCtr_dpndt_othrs(String ctr_dpndt_othrs) {
		this.ctr_dpndt_othrs = ctr_dpndt_othrs;
	}

	public String getCod_typ_accom() {
		return cod_typ_accom;
	}

	public void setCod_typ_accom(String cod_typ_accom) {
		this.cod_typ_accom = cod_typ_accom;
	}

	public String getTxt_lgl_rsdnc_stat() {
		return txt_lgl_rsdnc_stat;
	}

	public void setTxt_lgl_rsdnc_stat(String txt_lgl_rsdnc_stat) {
		this.txt_lgl_rsdnc_stat = txt_lgl_rsdnc_stat;
	}

	public String getTxt_ethnic_origin() {
		return txt_ethnic_origin;
	}

	public void setTxt_ethnic_origin(String txt_ethnic_origin) {
		this.txt_ethnic_origin = txt_ethnic_origin;
	}

	public String getTxt_cust_natnlty() {
		return txt_cust_natnlty;
	}

	public void setTxt_cust_natnlty(String txt_cust_natnlty) {
		this.txt_cust_natnlty = txt_cust_natnlty;
	}

	public String getCod_cust_bldgrp() {
		return cod_cust_bldgrp;
	}

	public void setCod_cust_bldgrp(String cod_cust_bldgrp) {
		this.cod_cust_bldgrp = cod_cust_bldgrp;
	}

	public String getTxt_cust_educn() {
		return txt_cust_educn;
	}

	public void setTxt_cust_educn(String txt_cust_educn) {
		this.txt_cust_educn = txt_cust_educn;
	}

	public String getFlg_cust_memo() {
		return flg_cust_memo;
	}

	public void setFlg_cust_memo(String flg_cust_memo) {
		this.flg_cust_memo = flg_cust_memo;
	}

	public String getDat_incorporated() {
		return dat_incorporated;
	}

	public void setDat_incorporated(String dat_incorporated) {
		this.dat_incorporated = dat_incorporated;
	}

	public String getNam_cntry_incorp() {
		return nam_cntry_incorp;
	}

	public void setNam_cntry_incorp(String nam_cntry_incorp) {
		this.nam_cntry_incorp = nam_cntry_incorp;
	}

	public String getCod_business_regno() {
		return cod_business_regno;
	}

	public void setCod_business_regno(String cod_business_regno) {
		this.cod_business_regno = cod_business_regno;
	}

	public String getCod_business_cat() {
		return cod_business_cat;
	}

	public void setCod_business_cat(String cod_business_cat) {
		this.cod_business_cat = cod_business_cat;
	}

	public String getTxt_business_typ() {
		return txt_business_typ;
	}

	public void setTxt_business_typ(String txt_business_typ) {
		this.txt_business_typ = txt_business_typ;
	}

	public String getNam_signatory1() {
		return nam_signatory1;
	}

	public void setNam_signatory1(String nam_signatory1) {
		this.nam_signatory1 = nam_signatory1;
	}

	public String getNam_signatory2() {
		return nam_signatory2;
	}

	public void setNam_signatory2(String nam_signatory2) {
		this.nam_signatory2 = nam_signatory2;
	}

	public String getNam_signatory3() {
		return nam_signatory3;
	}

	public void setNam_signatory3(String nam_signatory3) {
		this.nam_signatory3 = nam_signatory3;
	}

	public String getNam_signatory4() {
		return nam_signatory4;
	}

	public void setNam_signatory4(String nam_signatory4) {
		this.nam_signatory4 = nam_signatory4;
	}

	public String getNam_signatory5() {
		return nam_signatory5;
	}

	public void setNam_signatory5(String nam_signatory5) {
		this.nam_signatory5 = nam_signatory5;
	}

	public String getTxt_desgn_signtry1() {
		return txt_desgn_signtry1;
	}

	public void setTxt_desgn_signtry1(String txt_desgn_signtry1) {
		this.txt_desgn_signtry1 = txt_desgn_signtry1;
	}

	public String getTxt_desgn_signtry2() {
		return txt_desgn_signtry2;
	}

	public void setTxt_desgn_signtry2(String txt_desgn_signtry2) {
		this.txt_desgn_signtry2 = txt_desgn_signtry2;
	}

	public String getTxt_desgn_signtry3() {
		return txt_desgn_signtry3;
	}

	public void setTxt_desgn_signtry3(String txt_desgn_signtry3) {
		this.txt_desgn_signtry3 = txt_desgn_signtry3;
	}

	public String getTxt_desgn_signtry4() {
		return txt_desgn_signtry4;
	}

	public void setTxt_desgn_signtry4(String txt_desgn_signtry4) {
		this.txt_desgn_signtry4 = txt_desgn_signtry4;
	}

	public String getTxt_desgn_signtry5() {
		return txt_desgn_signtry5;
	}

	public void setTxt_desgn_signtry5(String txt_desgn_signtry5) {
		this.txt_desgn_signtry5 = txt_desgn_signtry5;
	}

	public String getNam_director1() {
		return nam_director1;
	}

	public void setNam_director1(String nam_director1) {
		this.nam_director1 = nam_director1;
	}

	public String getNam_director2() {
		return nam_director2;
	}

	public void setNam_director2(String nam_director2) {
		this.nam_director2 = nam_director2;
	}

	public String getNam_director3() {
		return nam_director3;
	}

	public void setNam_director3(String nam_director3) {
		this.nam_director3 = nam_director3;
	}

	public String getNam_director4() {
		return nam_director4;
	}

	public void setNam_director4(String nam_director4) {
		this.nam_director4 = nam_director4;
	}

	public String getNam_director5() {
		return nam_director5;
	}

	public void setNam_director5(String nam_director5) {
		this.nam_director5 = nam_director5;
	}

	public String getCod_report1() {
		return cod_report1;
	}

	public void setCod_report1(String cod_report1) {
		this.cod_report1 = cod_report1;
	}

	public String getCod_report2() {
		return cod_report2;
	}

	public void setCod_report2(String cod_report2) {
		this.cod_report2 = cod_report2;
	}

	public String getCod_report3() {
		return cod_report3;
	}

	public void setCod_report3(String cod_report3) {
		this.cod_report3 = cod_report3;
	}

	public String getFlg_mnt_status() {
		return flg_mnt_status;
	}

	public void setFlg_mnt_status(String flg_mnt_status) {
		this.flg_mnt_status = flg_mnt_status;
	}

	public String getCod_mnt_action() {
		return cod_mnt_action;
	}

	public void setCod_mnt_action(String cod_mnt_action) {
		this.cod_mnt_action = cod_mnt_action;
	}

	public String getCod_last_mnt_makerid() {
		return cod_last_mnt_makerid;
	}

	public void setCod_last_mnt_makerid(String cod_last_mnt_makerid) {
		this.cod_last_mnt_makerid = cod_last_mnt_makerid;
	}

	public String getCod_last_mnt_chkrid() {
		return cod_last_mnt_chkrid;
	}

	public void setCod_last_mnt_chkrid(String cod_last_mnt_chkrid) {
		this.cod_last_mnt_chkrid = cod_last_mnt_chkrid;
	}

	public String getDat_last_mnt() {
		return dat_last_mnt;
	}

	public void setDat_last_mnt(String dat_last_mnt) {
		this.dat_last_mnt = dat_last_mnt;
	}

	public String getCtr_updat_srlno() {
		return ctr_updat_srlno;
	}

	public void setCtr_updat_srlno(String ctr_updat_srlno) {
		this.ctr_updat_srlno = ctr_updat_srlno;
	}

	public String getFlg_key_chg() {
		return flg_key_chg;
	}

	public void setFlg_key_chg(String flg_key_chg) {
		this.flg_key_chg = flg_key_chg;
	}

	public String getFlg_cust_status() {
		return flg_cust_status;
	}

	public void setFlg_cust_status(String flg_cust_status) {
		this.flg_cust_status = flg_cust_status;
	}

	public String getFlg_replicate() {
		return flg_replicate;
	}

	public void setFlg_replicate(String flg_replicate) {
		this.flg_replicate = flg_replicate;
	}

	public String getCod_liab_no() {
		return cod_liab_no;
	}

	public void setCod_liab_no(String cod_liab_no) {
		this.cod_liab_no = cod_liab_no;
	}

	public String getCredit_rating() {
		return credit_rating;
	}

	public void setCredit_rating(String credit_rating) {
		this.credit_rating = credit_rating;
	}

	public String getDat_revision() {
		return dat_revision;
	}

	public void setDat_revision(String dat_revision) {
		this.dat_revision = dat_revision;
	}

	public String getFx_cust_clean_risk_limit() {
		return fx_cust_clean_risk_limit;
	}

	public void setFx_cust_clean_risk_limit(String fx_cust_clean_risk_limit) {
		this.fx_cust_clean_risk_limit = fx_cust_clean_risk_limit;
	}

	public String getFx_clean_risk_limit() {
		return fx_clean_risk_limit;
	}

	public void setFx_clean_risk_limit(String fx_clean_risk_limit) {
		this.fx_clean_risk_limit = fx_clean_risk_limit;
	}

	public String getAmt_limit_tot() {
		return amt_limit_tot;
	}

	public void setAmt_limit_tot(String amt_limit_tot) {
		this.amt_limit_tot = amt_limit_tot;
	}

	public String getCod_ccy_limit() {
		return cod_ccy_limit;
	}

	public void setCod_ccy_limit(String cod_ccy_limit) {
		this.cod_ccy_limit = cod_ccy_limit;
	}

	public String getSec_cust_clean_risk_limit() {
		return sec_cust_clean_risk_limit;
	}

	public void setSec_cust_clean_risk_limit(String sec_cust_clean_risk_limit) {
		this.sec_cust_clean_risk_limit = sec_cust_clean_risk_limit;
	}

	public String getSec_clean_risk_limit() {
		return sec_clean_risk_limit;
	}

	public void setSec_clean_risk_limit(String sec_clean_risk_limit) {
		this.sec_clean_risk_limit = sec_clean_risk_limit;
	}

	public String getSec_cust_pstl_risk_limit() {
		return sec_cust_pstl_risk_limit;
	}

	public void setSec_cust_pstl_risk_limit(String sec_cust_pstl_risk_limit) {
		this.sec_cust_pstl_risk_limit = sec_cust_pstl_risk_limit;
	}

	public String getSec_pstl_risk_limit() {
		return sec_pstl_risk_limit;
	}

	public void setSec_pstl_risk_limit(String sec_pstl_risk_limit) {
		this.sec_pstl_risk_limit = sec_pstl_risk_limit;
	}

	public String getDat_cif_type_change() {
		return dat_cif_type_change;
	}

	public void setDat_cif_type_change(String dat_cif_type_change) {
		this.dat_cif_type_change = dat_cif_type_change;
	}

	public String getFlg_rest_cust() {
		return flg_rest_cust;
	}

	public void setFlg_rest_cust(String flg_rest_cust) {
		this.flg_rest_cust = flg_rest_cust;
	}

	public String getFlg_lock_fac() {
		return flg_lock_fac;
	}

	public void setFlg_lock_fac(String flg_lock_fac) {
		this.flg_lock_fac = flg_lock_fac;
	}

	public String getTxt_mob_email_add() {
		return txt_mob_email_add;
	}

	public void setTxt_mob_email_add(String txt_mob_email_add) {
		this.txt_mob_email_add = txt_mob_email_add;
	}

	public String getCod_verified_reason() {
		return cod_verified_reason;
	}

	public void setCod_verified_reason(String cod_verified_reason) {
		this.cod_verified_reason = cod_verified_reason;
	}

	public String getFx_cust_cat() {
		return fx_cust_cat;
	}

	public void setFx_cust_cat(String fx_cust_cat) {
		this.fx_cust_cat = fx_cust_cat;
	}

	public String getCod_acct_no_salary() {
		return cod_acct_no_salary;
	}

	public void setCod_acct_no_salary(String cod_acct_no_salary) {
		this.cod_acct_no_salary = cod_acct_no_salary;
	}

	public String getCod_stream_id() {
		return cod_stream_id;
	}

	public void setCod_stream_id(String cod_stream_id) {
		this.cod_stream_id = cod_stream_id;
	}

	public String getCod_stmt_dispatch_mode() {
		return cod_stmt_dispatch_mode;
	}

	public void setCod_stmt_dispatch_mode(String cod_stmt_dispatch_mode) {
		this.cod_stmt_dispatch_mode = cod_stmt_dispatch_mode;
	}

	public String getCod_kyc_status() {
		return cod_kyc_status;
	}

	public void setCod_kyc_status(String cod_kyc_status) {
		this.cod_kyc_status = cod_kyc_status;
	}

	public String getCod_kyc_risk_category() {
		return cod_kyc_risk_category;
	}

	public void setCod_kyc_risk_category(String cod_kyc_risk_category) {
		this.cod_kyc_risk_category = cod_kyc_risk_category;
	}

	public String getTxt_reason_risk_category_chng() {
		return txt_reason_risk_category_chng;
	}

	public void setTxt_reason_risk_category_chng(String txt_reason_risk_category_chng) {
		this.txt_reason_risk_category_chng = txt_reason_risk_category_chng;
	}

	public String getDat_kyc_risk_category_review() {
		return dat_kyc_risk_category_review;
	}

	public void setDat_kyc_risk_category_review(String dat_kyc_risk_category_review) {
		this.dat_kyc_risk_category_review = dat_kyc_risk_category_review;
	}

	public String getCod_cust_introducer_id() {
		return cod_cust_introducer_id;
	}

	public void setCod_cust_introducer_id(String cod_cust_introducer_id) {
		this.cod_cust_introducer_id = cod_cust_introducer_id;
	}

	public String getCod_employee_id() {
		return cod_employee_id;
	}

	public void setCod_employee_id(String cod_employee_id) {
		this.cod_employee_id = cod_employee_id;
	}

	public String getCtr_mis_codes() {
		return ctr_mis_codes;
	}

	public void setCtr_mis_codes(String ctr_mis_codes) {
		this.ctr_mis_codes = ctr_mis_codes;
	}

	public String getCod_mis_cust_code_1() {
		return cod_mis_cust_code_1;
	}

	public void setCod_mis_cust_code_1(String cod_mis_cust_code_1) {
		this.cod_mis_cust_code_1 = cod_mis_cust_code_1;
	}

	public String getCod_mis_cust_code_2() {
		return cod_mis_cust_code_2;
	}

	public void setCod_mis_cust_code_2(String cod_mis_cust_code_2) {
		this.cod_mis_cust_code_2 = cod_mis_cust_code_2;
	}

	public String getCod_mis_cust_code_3() {
		return cod_mis_cust_code_3;
	}

	public void setCod_mis_cust_code_3(String cod_mis_cust_code_3) {
		this.cod_mis_cust_code_3 = cod_mis_cust_code_3;
	}

	public String getCod_mis_cust_code_4() {
		return cod_mis_cust_code_4;
	}

	public void setCod_mis_cust_code_4(String cod_mis_cust_code_4) {
		this.cod_mis_cust_code_4 = cod_mis_cust_code_4;
	}

	public String getCod_mis_cust_code_5() {
		return cod_mis_cust_code_5;
	}

	public void setCod_mis_cust_code_5(String cod_mis_cust_code_5) {
		this.cod_mis_cust_code_5 = cod_mis_cust_code_5;
	}

	public String getCod_mis_cust_code_6() {
		return cod_mis_cust_code_6;
	}

	public void setCod_mis_cust_code_6(String cod_mis_cust_code_6) {
		this.cod_mis_cust_code_6 = cod_mis_cust_code_6;
	}

	public String getCod_mis_cust_code_7() {
		return cod_mis_cust_code_7;
	}

	public void setCod_mis_cust_code_7(String cod_mis_cust_code_7) {
		this.cod_mis_cust_code_7 = cod_mis_cust_code_7;
	}

	public String getCod_mis_cust_code_8() {
		return cod_mis_cust_code_8;
	}

	public void setCod_mis_cust_code_8(String cod_mis_cust_code_8) {
		this.cod_mis_cust_code_8 = cod_mis_cust_code_8;
	}

	public String getCod_mis_cust_code_9() {
		return cod_mis_cust_code_9;
	}

	public void setCod_mis_cust_code_9(String cod_mis_cust_code_9) {
		this.cod_mis_cust_code_9 = cod_mis_cust_code_9;
	}

	public String getCod_mis_cust_code_10() {
		return cod_mis_cust_code_10;
	}

	public void setCod_mis_cust_code_10(String cod_mis_cust_code_10) {
		this.cod_mis_cust_code_10 = cod_mis_cust_code_10;
	}

	public String getCod_mis_comp_code_1() {
		return cod_mis_comp_code_1;
	}

	public void setCod_mis_comp_code_1(String cod_mis_comp_code_1) {
		this.cod_mis_comp_code_1 = cod_mis_comp_code_1;
	}

	public String getCod_mis_comp_code_2() {
		return cod_mis_comp_code_2;
	}

	public void setCod_mis_comp_code_2(String cod_mis_comp_code_2) {
		this.cod_mis_comp_code_2 = cod_mis_comp_code_2;
	}

	public String getCod_mis_comp_code_3() {
		return cod_mis_comp_code_3;
	}

	public void setCod_mis_comp_code_3(String cod_mis_comp_code_3) {
		this.cod_mis_comp_code_3 = cod_mis_comp_code_3;
	}

	public String getCod_mis_comp_code_4() {
		return cod_mis_comp_code_4;
	}

	public void setCod_mis_comp_code_4(String cod_mis_comp_code_4) {
		this.cod_mis_comp_code_4 = cod_mis_comp_code_4;
	}

	public String getCod_mis_comp_code_5() {
		return cod_mis_comp_code_5;
	}

	public void setCod_mis_comp_code_5(String cod_mis_comp_code_5) {
		this.cod_mis_comp_code_5 = cod_mis_comp_code_5;
	}

	public String getCod_mis_comp_code_6() {
		return cod_mis_comp_code_6;
	}

	public void setCod_mis_comp_code_6(String cod_mis_comp_code_6) {
		this.cod_mis_comp_code_6 = cod_mis_comp_code_6;
	}

	public String getCod_mis_comp_code_7() {
		return cod_mis_comp_code_7;
	}

	public void setCod_mis_comp_code_7(String cod_mis_comp_code_7) {
		this.cod_mis_comp_code_7 = cod_mis_comp_code_7;
	}

	public String getCod_mis_comp_code_8() {
		return cod_mis_comp_code_8;
	}

	public void setCod_mis_comp_code_8(String cod_mis_comp_code_8) {
		this.cod_mis_comp_code_8 = cod_mis_comp_code_8;
	}

	public String getCod_mis_comp_code_9() {
		return cod_mis_comp_code_9;
	}

	public void setCod_mis_comp_code_9(String cod_mis_comp_code_9) {
		this.cod_mis_comp_code_9 = cod_mis_comp_code_9;
	}

	public String getCod_mis_comp_code_10() {
		return cod_mis_comp_code_10;
	}

	public void setCod_mis_comp_code_10(String cod_mis_comp_code_10) {
		this.cod_mis_comp_code_10 = cod_mis_comp_code_10;
	}

	public String getFlg_minor() {
		return flg_minor;
	}

	public void setFlg_minor(String flg_minor) {
		this.flg_minor = flg_minor;
	}

	public String getCod_guardian_type() {
		return cod_guardian_type;
	}

	public void setCod_guardian_type(String cod_guardian_type) {
		this.cod_guardian_type = cod_guardian_type;
	}

	public String getCod_acct_no_default() {
		return cod_acct_no_default;
	}

	public void setCod_acct_no_default(String cod_acct_no_default) {
		this.cod_acct_no_default = cod_acct_no_default;
	}

	public String getTxt_cust_residence() {
		return txt_cust_residence;
	}

	public void setTxt_cust_residence(String txt_cust_residence) {
		this.txt_cust_residence = txt_cust_residence;
	}

	public String getAfl_issue_date() {
		return afl_issue_date;
	}

	public void setAfl_issue_date(String afl_issue_date) {
		this.afl_issue_date = afl_issue_date;
	}

	public String getAfl_expiry_date() {
		return afl_expiry_date;
	}

	public void setAfl_expiry_date(String afl_expiry_date) {
		this.afl_expiry_date = afl_expiry_date;
	}

	public String getAfl_effective_date() {
		return afl_effective_date;
	}

	public void setAfl_effective_date(String afl_effective_date) {
		this.afl_effective_date = afl_effective_date;
	}

	public String getLast_renew_date() {
		return last_renew_date;
	}

	public void setLast_renew_date(String last_renew_date) {
		this.last_renew_date = last_renew_date;
	}

	public String getFlg_unadv() {
		return flg_unadv;
	}

	public void setFlg_unadv(String flg_unadv) {
		this.flg_unadv = flg_unadv;
	}

	public String getFlg_doc_complete() {
		return flg_doc_complete;
	}

	public void setFlg_doc_complete(String flg_doc_complete) {
		this.flg_doc_complete = flg_doc_complete;
	}

	public String getFlg_kio() {
		return flg_kio;
	}

	public void setFlg_kio(String flg_kio) {
		this.flg_kio = flg_kio;
	}

	public String getTxt_holdadr_add1() {
		return txt_holdadr_add1;
	}

	public void setTxt_holdadr_add1(String txt_holdadr_add1) {
		this.txt_holdadr_add1 = txt_holdadr_add1;
	}

	public String getTxt_holdadr_add2() {
		return txt_holdadr_add2;
	}

	public void setTxt_holdadr_add2(String txt_holdadr_add2) {
		this.txt_holdadr_add2 = txt_holdadr_add2;
	}

	public String getTxt_holdadr_add3() {
		return txt_holdadr_add3;
	}

	public void setTxt_holdadr_add3(String txt_holdadr_add3) {
		this.txt_holdadr_add3 = txt_holdadr_add3;
	}

	public String getNam_holdadr_city() {
		return nam_holdadr_city;
	}

	public void setNam_holdadr_city(String nam_holdadr_city) {
		this.nam_holdadr_city = nam_holdadr_city;
	}

	public String getNam_holdadr_state() {
		return nam_holdadr_state;
	}

	public void setNam_holdadr_state(String nam_holdadr_state) {
		this.nam_holdadr_state = nam_holdadr_state;
	}

	public String getNam_holdadr_cntry() {
		return nam_holdadr_cntry;
	}

	public void setNam_holdadr_cntry(String nam_holdadr_cntry) {
		this.nam_holdadr_cntry = nam_holdadr_cntry;
	}

	public String getTxt_holdadr_zip() {
		return txt_holdadr_zip;
	}

	public void setTxt_holdadr_zip(String txt_holdadr_zip) {
		this.txt_holdadr_zip = txt_holdadr_zip;
	}

	public String getRef_hold_phone() {
		return ref_hold_phone;
	}

	public void setRef_hold_phone(String ref_hold_phone) {
		this.ref_hold_phone = ref_hold_phone;
	}

	public String getRef_hold_phone_off() {
		return ref_hold_phone_off;
	}

	public void setRef_hold_phone_off(String ref_hold_phone_off) {
		this.ref_hold_phone_off = ref_hold_phone_off;
	}

	public String getRef_hold_fax() {
		return ref_hold_fax;
	}

	public void setRef_hold_fax(String ref_hold_fax) {
		this.ref_hold_fax = ref_hold_fax;
	}

	public String getRef_hold_telex() {
		return ref_hold_telex;
	}

	public void setRef_hold_telex(String ref_hold_telex) {
		this.ref_hold_telex = ref_hold_telex;
	}

	public String getRef_hold_email() {
		return ref_hold_email;
	}

	public void setRef_hold_email(String ref_hold_email) {
		this.ref_hold_email = ref_hold_email;
	}

	public String getCod_cust_status() {
		return cod_cust_status;
	}

	public void setCod_cust_status(String cod_cust_status) {
		this.cod_cust_status = cod_cust_status;
	}

	public String getCod_tds_2() {
		return cod_tds_2;
	}

	public void setCod_tds_2(String cod_tds_2) {
		this.cod_tds_2 = cod_tds_2;
	}

	public String getRef_res_phone_country() {
		return ref_res_phone_country;
	}

	public void setRef_res_phone_country(String ref_res_phone_country) {
		this.ref_res_phone_country = ref_res_phone_country;
	}

	public String getRef_res_phone_area() {
		return ref_res_phone_area;
	}

	public void setRef_res_phone_area(String ref_res_phone_area) {
		this.ref_res_phone_area = ref_res_phone_area;
	}

	public String getRef_res_phone_extn() {
		return ref_res_phone_extn;
	}

	public void setRef_res_phone_extn(String ref_res_phone_extn) {
		this.ref_res_phone_extn = ref_res_phone_extn;
	}

	public String getRef_phone_mobile() {
		return ref_phone_mobile;
	}

	public void setRef_phone_mobile(String ref_phone_mobile) {
		this.ref_phone_mobile = ref_phone_mobile;
	}

	public String getRef_office_phone_country() {
		return ref_office_phone_country;
	}

	public void setRef_office_phone_country(String ref_office_phone_country) {
		this.ref_office_phone_country = ref_office_phone_country;
	}

	public String getRef_office_phone_area() {
		return ref_office_phone_area;
	}

	public void setRef_office_phone_area(String ref_office_phone_area) {
		this.ref_office_phone_area = ref_office_phone_area;
	}

	public String getRef_office_phone_extn() {
		return ref_office_phone_extn;
	}

	public void setRef_office_phone_extn(String ref_office_phone_extn) {
		this.ref_office_phone_extn = ref_office_phone_extn;
	}

	public String getFlg_blocked() {
		return flg_blocked;
	}

	public void setFlg_blocked(String flg_blocked) {
		this.flg_blocked = flg_blocked;
	}

	public String getCod_block_reason() {
		return cod_block_reason;
	}

	public void setCod_block_reason(String cod_block_reason) {
		this.cod_block_reason = cod_block_reason;
	}

	public String getFlg_verified_stat() {
		return flg_verified_stat;
	}

	public void setFlg_verified_stat(String flg_verified_stat) {
		this.flg_verified_stat = flg_verified_stat;
	}

	public String getDat_verified() {
		return dat_verified;
	}

	public void setDat_verified(String dat_verified) {
		this.dat_verified = dat_verified;
	}

	public String getCod_secrecy_lvl() {
		return cod_secrecy_lvl;
	}

	public void setCod_secrecy_lvl(String cod_secrecy_lvl) {
		this.cod_secrecy_lvl = cod_secrecy_lvl;
	}

	public String getCod_crif_consent_lvl() {
		return cod_crif_consent_lvl;
	}

	public void setCod_crif_consent_lvl(String cod_crif_consent_lvl) {
		this.cod_crif_consent_lvl = cod_crif_consent_lvl;
	}

	public String getFlg_spl_cust() {
		return flg_spl_cust;
	}

	public void setFlg_spl_cust(String flg_spl_cust) {
		this.flg_spl_cust = flg_spl_cust;
	}

	public String getCod_utl_comp() {
		return cod_utl_comp;
	}

	public void setCod_utl_comp(String cod_utl_comp) {
		this.cod_utl_comp = cod_utl_comp;
	}

	public String getNam_mother_maiden() {
		return nam_mother_maiden;
	}

	public void setNam_mother_maiden(String nam_mother_maiden) {
		this.nam_mother_maiden = nam_mother_maiden;
	}

	public String getTxt_contry_init_risk() {
		return txt_contry_init_risk;
	}

	public void setTxt_contry_init_risk(String txt_contry_init_risk) {
		this.txt_contry_init_risk = txt_contry_init_risk;
	}

	public String getTxt_contry_ult_risk() {
		return txt_contry_ult_risk;
	}

	public void setTxt_contry_ult_risk(String txt_contry_ult_risk) {
		this.txt_contry_ult_risk = txt_contry_ult_risk;
	}

	public String getDat_addr_change() {
		return dat_addr_change;
	}

	public void setDat_addr_change(String dat_addr_change) {
		this.dat_addr_change = dat_addr_change;
	}

	public String getCod_aadhaar_no() {
		return cod_aadhaar_no;
	}

	public void setCod_aadhaar_no(String cod_aadhaar_no) {
		this.cod_aadhaar_no = cod_aadhaar_no;
	}

	public String getDat_aadhaar_updated_on() {
		return dat_aadhaar_updated_on;
	}

	public void setDat_aadhaar_updated_on(String dat_aadhaar_updated_on) {
		this.dat_aadhaar_updated_on = dat_aadhaar_updated_on;
	}

	public String getCod_aadhaar_link_acct() {
		return cod_aadhaar_link_acct;
	}

	public void setCod_aadhaar_link_acct(String cod_aadhaar_link_acct) {
		this.cod_aadhaar_link_acct = cod_aadhaar_link_acct;
	}

	public String getFlg_spend_analysis() {
		return flg_spend_analysis;
	}

	public void setFlg_spend_analysis(String flg_spend_analysis) {
		this.flg_spend_analysis = flg_spend_analysis;
	}

	public String getExposure_category() {
		return exposure_category;
	}

	public void setExposure_category(String exposure_category) {
		this.exposure_category = exposure_category;
	}

	public String getCif_status() {
		return cif_status;
	}

	public void setCif_status(String cif_status) {
		this.cif_status = cif_status;
	}

	public String getEefc_percent() {
		return eefc_percent;
	}

	public void setEefc_percent(String eefc_percent) {
		this.eefc_percent = eefc_percent;
	}

	public String getBill_margin() {
		return bill_margin;
	}

	public void setBill_margin(String bill_margin) {
		this.bill_margin = bill_margin;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getMsg_type() {
		return msg_type;
	}

	public void setMsg_type(String msg_type) {
		this.msg_type = msg_type;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCust_ac_no() {
		return cust_ac_no;
	}

	public void setCust_ac_no(String cust_ac_no) {
		this.cust_ac_no = cust_ac_no;
	}

	public String getPrimary_address() {
		return primary_address;
	}

	public void setPrimary_address(String primary_address) {
		this.primary_address = primary_address;
	}

	public String getNo_of_copies() {
		return no_of_copies;
	}

	public void setNo_of_copies(String no_of_copies) {
		this.no_of_copies = no_of_copies;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getAnswerback() {
		return answerback;
	}

	public void setAnswerback(String answerback) {
		this.answerback = answerback;
	}

	public String getTest_required() {
		return test_required;
	}

	public void setTest_required(String test_required) {
		this.test_required = test_required;
	}

	public String getTest_keyword() {
		return test_keyword;
	}

	public void setTest_keyword(String test_keyword) {
		this.test_keyword = test_keyword;
	}

	public String getTobe_emailed() {
		return tobe_emailed;
	}

	public void setTobe_emailed(String tobe_emailed) {
		this.tobe_emailed = tobe_emailed;
	}

	public String getDelivery_by() {
		return delivery_by;
	}

	public void setDelivery_by(String delivery_by) {
		this.delivery_by = delivery_by;
	}

	public String getCustomer_no_ext() {
		return customer_no_ext;
	}

	public void setCustomer_no_ext(String customer_no_ext) {
		this.customer_no_ext = customer_no_ext;
	}

	public String getCif_status_since() {
		return cif_status_since;
	}

	public void setCif_status_since(String cif_status_since) {
		this.cif_status_since = cif_status_since;
	}

	public String getElcm_customer_no() {
		return elcm_customer_no;
	}

	public void setElcm_customer_no(String elcm_customer_no) {
		this.elcm_customer_no = elcm_customer_no;
	}*/

}


