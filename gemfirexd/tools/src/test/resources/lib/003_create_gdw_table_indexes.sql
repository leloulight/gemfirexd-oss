CREATE INDEX REPL_RTR_REPORT_DATA_HASH_ID ON RTR_REPORT_DATA (CUSTOMER_HASH_ID);
CREATE INDEX REPL_RTR_REPORT_DATA_ORD_NUM ON RTR_REPORT_DATA (ORD_NUM);
CREATE INDEX REPL_RTR_REPORT_DATA_RPTG_DT_WID ON RTR_REPORT_DATA (RPTG_DT_WID);
CREATE INDEX REPL_RTR_REPORT_DATA_PROD_CUR_WID ON RTR_REPORT_DATA (PROD_CUR_WID);
create index RTR_REPORT_DATA_BUCKET on RTR_REPORT_DATA(BUCKET); 
create index RTR_REPORT_DATA_RCD_STUS on RTR_REPORT_DATA(RECORD_STATUS);
CREATE INDEX REPL_RTR_REPORT_DATA_OPP_NO ON RTR_REPORT_DATA (OPP_NO);
CREATE INDEX REPL_RTR_REPORT_DATA_QTE_NUM ON RTR_REPORT_DATA (QTE_NUM);

CREATE INDEX REPL_SALES_CREDITS_DISTRICT_ID ON SALES_CREDITS (DISTRICT_ID);
CREATE INDEX REPL_SALES_CREDITS_SALESREP_ID ON SALES_CREDITS (SALESREP_ID);
CREATE INDEX REPL_SALES_CREDITS_SO_NUMBER ON SALES_CREDITS (SO_NUMBER);
CREATE INDEX SALES_CREDITS_THTR  ON SALES_CREDITS(THEATER);
create index SALES_CREDITS_EFCT_END_DATE on SALES_CREDITS(EFFECTIVE_END_DATE);
