-- ==============================================================
--  Table : TABLEAJOUTEE                                    
-- ==============================================================

DROP TABLE IF EXISTS TABLEAJOUTEE;
CREATE TABLE TABLEAJOUTEE(
    col1 float(12, 3) NULL AUTO_INCREMENT,
	PRIMARY KEY (col1)
);

ALTER TABLE TABLEAJOUTEE COMMENT 'Comments TableAjoutee';
ALTER TABLE TABLEAJOUTEE MODIFY col1 float(12, 3) NULL AUTO_INCREMENT COMMENT 'Comments col1';

