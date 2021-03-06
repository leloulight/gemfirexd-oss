CREATE TABLE TD_INSTRUMENT_SCD 
  (	INSM_ID NUMERIC(21,0) NOT NULL, 
	STRT_EFF_DT DATE, 
	END_EFF_DT DATE, 
	CURR_IND NUMERIC(1,0) NOT NULL, 
	SCR_FI_CD NUMERIC(21,0) NOT NULL, 
	CUSIP_CD VARCHAR(30) NOT NULL, 
	CUSIP_SRC_CD VARCHAR(10) NOT NULL, 
	CUSIP_DESC VARCHAR(50) NOT NULL, 
	UNDL_CUSIP_CD VARCHAR(30), 
	INSM_MAT_DT DATE, 
	COUP_RT NUMERIC(31,19), 
	UNIT_OF_PRC NUMERIC(31,8), 
	UNIT_OF_TRD NUMERIC(31,8), 
	CURR_RT NUMERIC(31,19), 
	NO_OF_CON_RT NUMERIC(31,19), 
	STRK_PRC NUMERIC(31,8), 
	FIT_CD VARCHAR(3), 
	FIT_DESC VARCHAR(42), 
	GCT_CD VARCHAR(5), 
	GCT_DESC VARCHAR(255), 
	PUT_CALL_IND VARCHAR(1), 
	SCR_NO_CD VARCHAR(30) NOT NULL, 
	SCR_IND_CD VARCHAR(7), 
	SCR_TYP_CD VARCHAR(10), 
	SCR_TYP_DESC VARCHAR(42), 
	SCR_SUB_TYP_CD VARCHAR(10), 
	SCR_TICKR_CD VARCHAR(40), 
	SCR_OFFR_CD VARCHAR(1), 
	SCR_CLAS_DESC VARCHAR(42), 
	BNCHMARK_CUSIP_CD VARCHAR(30), 
	BNCHMARK_DESC VARCHAR(50), 
	BNCHMARK_MAT_DT DATE, 
	BNCHMARK_SPRD_AMT NUMERIC(31,8), 
	PROD_CLAS_CD VARCHAR(30), 
	QUICK_CD VARCHAR(9), 
	CDS_PROD_CD VARCHAR(10), 
	LON_PROD_CD VARCHAR(3), 
	TRESTEL_PROD_CD VARCHAR(4), 
	EXPR_DT DATE, 
	CUSIP_DEAL_TRAN_CD VARCHAR(30), 
	TRAN_ID NUMERIC(21,0) NOT NULL, 
	DEAL_CD VARCHAR(30) NOT NULL, 
	CORPUS_ID NUMERIC(21,0) NOT NULL, 
	OTC_CUSIP_CD VARCHAR(30), 
	REC_STA_CD VARCHAR(1), 
	REC_MDFY_USER_ID VARCHAR(16), 
	REC_MDFY_DTM TIMESTAMP, 
	REC_MDFY_METH_DESC VARCHAR(30), 
	PROC_LOG_ID NUMERIC(21,0) NOT NULL, 
	ERR_ID NUMERIC(21,0) NOT NULL, 
	CON_CD VARCHAR(6), 
	VER_NO NUMERIC(21,0), 
	EXCH_CD VARCHAR(6), 
	GEO_CLAS_CD VARCHAR(8), 
	GEO_CLAS_DESC VARCHAR(35), 
	POOL_NO VARCHAR(16), 
	MDY_RTNG VARCHAR(8), 
	SNP_RTNG VARCHAR(8), 
	SCR_OFFR_DESC VARCHAR(42), 
	CCY_CD VARCHAR(3) DEFAULT 'N/A', 
	RIC_CD VARCHAR(40) DEFAULT 'N/A', 
	ISIN_CD VARCHAR(40) DEFAULT 'N/A', 
	OCC_CD VARCHAR(40) DEFAULT 'N/A', 
	ISS_ISIN_CD VARCHAR(40) DEFAULT 'N/A', 
	MSD_CUSIP_CD VARCHAR(40) DEFAULT 'N/A', 
	SEDOL_CD VARCHAR(40) DEFAULT 'N/A', 
	MSD_TAX_CD VARCHAR(8) DEFAULT 'N/A' 

   ) REPLICATE  PERSISTENT;
