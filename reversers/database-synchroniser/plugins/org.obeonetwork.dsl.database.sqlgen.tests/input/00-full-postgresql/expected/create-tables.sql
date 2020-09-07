-- ==============================================================
--  Table : TABLEAJOUTEE                                    
-- ==============================================================

DROP TABLE IF EXISTS DEMO.TABLEAJOUTEE CASCADE;
CREATE TABLE DEMO.TABLEAJOUTEE(
    col1 NUMERIC(12, 3) DEFAULT defaultValue NULL
);

COMMENT ON TABLE DEMO.TABLEAJOUTEE IS 'Comments TableAjoutee';
COMMENT ON COLUMN DEMO.TABLEAJOUTEE.col1 IS 'Comments col1';

