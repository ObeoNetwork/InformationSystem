-- ==============================================================
--  Table : TABLE1                                    
-- ==============================================================
ALTER TABLE TABLE1 DROP COLUMN colSupprimee;

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
--  Table : TABLE2                                    
-- ==============================================================
ALTER TABLE TABLE2 RENAME TO TABLE2RENOMMEE;

ALTER TABLE TABLE2RENOMMEE COMMENT 'Comments updated on Table2';

ALTER TABLE TABLE2RENOMMEE MODIFY col2_3 numeric(10, 2) NULL;

ALTER TABLE TABLE2RENOMMEE MODIFY col2_3 numeric(10, 2) NULL;

ALTER TABLE TABLE2RENOMMEE RENAME COLUMN col2_2 TO col2_2_Renommee;

ALTER TABLE TABLE2RENOMMEE MODIFY col2_3 numeric(10, 2) NULL COMMENT 'Comments col2_3 updated';

ALTER TABLE TABLE2RENOMMEE ADD col2_4 char(4) NULL;

-- ==============================================================
--  Table : TABLE3                                    
-- ==============================================================
ALTER TABLE TABLE3 ADD col3_2 numeric(12, 5) NOT NULL AUTO_INCREMENT;

ALTER TABLE TABLE3 RENAME COLUMN col3_1 TO col3_1_renommee;

ALTER TABLE TABLE3 MODIFY col3_1_renommee varchar(255) NOT NULL COMMENT 'Comments on col3_1_renommee';

-- ==============================================================
--  Table : TABLE4                                    
-- ==============================================================
ALTER TABLE TABLE4 DROP COLUMN col4_2_supprimee;

ALTER TABLE TABLE4 RENAME TO TABLE4RENOMMEE;

-- ==============================================================
--  Table : TABLE5                                    
-- ==============================================================

-- ==============================================================
--  Table : TABLE6                                    
-- ==============================================================

-- ==============================================================
--  Table : TABLE7                                    
-- ==============================================================
ALTER TABLE TABLE7 ADD col8_1 text NOT NULL;

-- ==============================================================
--  Table : TABLE8                                    
-- ==============================================================

-- ==============================================================
--  Table : TABLE9                                    
-- ==============================================================

