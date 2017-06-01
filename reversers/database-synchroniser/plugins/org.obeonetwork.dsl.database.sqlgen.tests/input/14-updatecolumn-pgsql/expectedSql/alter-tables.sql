-- ==============================================================
--  Table : TABLE1                                    
-- ==============================================================
ALTER TABLE DEMO.TABLE1 alter column column2_type_change set data type BOOLEAN;
ALTER TABLE DEMO.TABLE1 alter column column2_type_change set not null;
ALTER TABLE DEMO.TABLE1 alter column column2_type_change drop default;

ALTER TABLE DEMO.TABLE1 RENAME COLUMN column3_renommee_new_name TO column3_renommee;

