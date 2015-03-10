-- ==============================================================
--  Primary Key : PK_EMPLOYEES                                    
-- ==============================================================
CREATE UNIQUE INDEX EMPLOYEES2_PK1_1 ON EMPLOYEES2(EMPLOYEEID);
ALTER TABLE EMPLOYEES2 ADD (CONSTRAINT EMPLOYEES2_PK1_1 PRIMARY KEY(EMPLOYEEID));

