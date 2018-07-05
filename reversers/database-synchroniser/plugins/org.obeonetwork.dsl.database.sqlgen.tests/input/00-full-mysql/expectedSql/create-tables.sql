-- ==============================================================
--  Table : TABLEAJOUTEE                                    
-- ==============================================================

DROP TABLE TABLEAJOUTEE CASCADE;
CREATE TABLE TABLEAJOUTEE(
    col1 numeric(12, 3) DEFAULT defaultValue NULL AUTO_INCREMENT,
	PRIMARY KEY (col1)
);

COMMENT ON TABLE TABLEAJOUTEE IS 'Comments TableAjoutee';
COMMENT ON COLUMN TABLEAJOUTEE.col1 IS 'Comments col1';

