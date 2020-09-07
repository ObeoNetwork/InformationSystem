-- ==============================================================
--  Table : TABLE1                                    
-- ==============================================================
ALTER TABLE DEMO.TABLE1 ALTER COLUMN column2_type_change SET DATA TYPE BOOLEAN;
ALTER TABLE DEMO.TABLE1 ALTER COLUMN column2_type_change SET NOT NULL;
ALTER TABLE DEMO.TABLE1 ALTER COLUMN column2_type_change DROP DEFAULT;

ALTER TABLE DEMO.TABLE1 ALTER COLUMN column4_null_to_not_null SET DATA TYPE BOOLEAN;
ALTER TABLE DEMO.TABLE1 ALTER COLUMN column4_null_to_not_null DROP NOT NULL;
ALTER TABLE DEMO.TABLE1 ALTER COLUMN column4_null_to_not_null DROP DEFAULT;

ALTER TABLE DEMO.TABLE1 ALTER COLUMN column5_not_null_to_null SET DATA TYPE BOOLEAN;
ALTER TABLE DEMO.TABLE1 ALTER COLUMN column5_not_null_to_null SET NOT NULL;
ALTER TABLE DEMO.TABLE1 ALTER COLUMN column5_not_null_to_null DROP DEFAULT;

ALTER TABLE DEMO.TABLE1 ALTER COLUMN column6_no_default_to_default SET DATA TYPE VARCHAR();
ALTER TABLE DEMO.TABLE1 ALTER COLUMN column6_no_default_to_default SET NOT NULL;
ALTER TABLE DEMO.TABLE1 ALTER COLUMN column6_no_default_to_default DROP DEFAULT;

ALTER TABLE DEMO.TABLE1 ALTER COLUMN column7_default_to_other_default SET DATA TYPE VARCHAR();
ALTER TABLE DEMO.TABLE1 ALTER COLUMN column7_default_to_other_default SET NOT NULL;
ALTER TABLE DEMO.TABLE1 ALTER COLUMN column7_default_to_other_default SET DEFAULT VALUE1
;

ALTER TABLE DEMO.TABLE1 ALTER COLUMN column8_default_to_no_default SET DATA TYPE VARCHAR();
ALTER TABLE DEMO.TABLE1 ALTER COLUMN column8_default_to_no_default SET NOT NULL;
ALTER TABLE DEMO.TABLE1 ALTER COLUMN column8_default_to_no_default SET DEFAULT VALUE1
;

ALTER TABLE DEMO.TABLE1 RENAME COLUMN column3_renommee_new_name TO column3_renommee;

