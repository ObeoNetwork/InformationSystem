-- ==============================================================
--  Table : TABLEAJOUTEE                                    
-- ==============================================================
DROP PUBLIC SYNONYM TABLEAJOUTEE;
DROP TABLE DEMO.TABLEAJOUTEE;
CREATE TABLE DEMO.TABLEAJOUTEE(
    col1 NUMBER(12, 3) DEFAULT defaultValue NULL
);
CREATE PUBLIC SYNONYM TABLEAJOUTEE FOR DEMO.TABLEAJOUTEE;
COMMENT ON TABLE DEMO.TABLEAJOUTEE IS 'Comments TableAjoutee';
COMMENT ON COLUMN DEMO.TABLEAJOUTEE.col1 IS 'Comments col1';

