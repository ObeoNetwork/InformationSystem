-- ==============================================================
--  Table : EMPLOYEES                                    
-- ==============================================================
ALTER TABLE EMPLOYEES ADD LASTNAME_RENAMED VARCHAR2(20) NOT NULL;

ALTER TABLE EMPLOYEES DROP COLUMN LASTNAME;
