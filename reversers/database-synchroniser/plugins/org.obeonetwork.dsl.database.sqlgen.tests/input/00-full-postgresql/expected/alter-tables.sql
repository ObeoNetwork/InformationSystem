-- ==============================================================
--  Table : TABLE1                                    
-- ==============================================================
ALTER TABLE DEMO.TABLE1 DROP COLUMN colSupprimee;

-- ==============================================================
--  Table : TABLE10                                    
-- ==============================================================

-- ==============================================================
--  Table : TABLE11                                    
-- ==============================================================

-- ==============================================================
--  Table : TABLE12                                    
-- ==============================================================

-- ==============================================================
--  Table : TABLE14                                    
-- ==============================================================

-- ==============================================================
--  Table : TABLE15                                    
-- ==============================================================

-- ==============================================================
--  Table : TABLE2                                    
-- ==============================================================
ALTER TABLE DEMO.TABLE2 RENAME TO TABLE2RENOMMEE;

COMMENT ON TABLE DEMO.TABLE2RENOMMEE IS 'Comments updated on Table2';

ALTER TABLE DEMO.TABLE2RENOMMEE ALTER COLUMN col2_3 SET DATA TYPE NUMERIC(10, 2);
ALTER TABLE DEMO.TABLE2RENOMMEE ALTER COLUMN col2_3 DROP NOT NULL;
ALTER TABLE DEMO.TABLE2RENOMMEE ALTER COLUMN col2_3 DROP DEFAULT;

ALTER TABLE DEMO.TABLE2RENOMMEE ALTER COLUMN col2_3 SET DATA TYPE NUMERIC(10, 2);
ALTER TABLE DEMO.TABLE2RENOMMEE ALTER COLUMN col2_3 DROP NOT NULL;
ALTER TABLE DEMO.TABLE2RENOMMEE ALTER COLUMN col2_3 DROP DEFAULT;

ALTER TABLE DEMO.TABLE2RENOMMEE RENAME COLUMN col2_2 TO col2_2_Renommee;

COMMENT ON COLUMN DEMO.TABLE2RENOMMEE.col2_3 IS 'Comments col2_3 updated';

ALTER TABLE DEMO.TABLE2RENOMMEE ADD col2_4 CHAR(4);
ALTER TABLE DEMO.TABLE2RENOMMEE ALTER COLUMN col2_4 DROP NOT NULL;

-- ==============================================================
--  Table : TABLE3                                    
-- ==============================================================
ALTER TABLE DEMO.TABLE3 ADD col3_2 NUMERIC(12, 5);
ALTER TABLE DEMO.TABLE3 ALTER COLUMN col3_2 SET NOT NULL;

ALTER TABLE DEMO.TABLE3 RENAME COLUMN col3_1 TO col3_1_renommee;

COMMENT ON COLUMN DEMO.TABLE3.col3_1_renommee IS 'Comments on col3_1_renommee';

-- ==============================================================
--  Table : TABLE4                                    
-- ==============================================================
ALTER TABLE DEMO.TABLE4 DROP COLUMN col4_2_supprimee;

ALTER TABLE DEMO.TABLE4 RENAME TO TABLE4RENOMMEE;

-- ==============================================================
--  Table : TABLE5                                    
-- ==============================================================

-- ==============================================================
--  Table : TABLE6                                    
-- ==============================================================

-- ==============================================================
--  Table : TABLE7                                    
-- ==============================================================
ALTER TABLE DEMO.TABLE7 ADD col8_1 INTEGER;
ALTER TABLE DEMO.TABLE7 ALTER COLUMN col8_1 SET NOT NULL;

-- ==============================================================
--  Table : TABLE8                                    
-- ==============================================================

-- ==============================================================
--  Table : TABLE9                                    
-- ==============================================================

