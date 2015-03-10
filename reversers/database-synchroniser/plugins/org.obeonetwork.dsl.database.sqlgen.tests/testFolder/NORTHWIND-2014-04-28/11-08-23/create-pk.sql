-- ==============================================================
--  Primary Key : PRIMARY                                    
-- ==============================================================
CREATE UNIQUE INDEX EMPLOYEES_PK1_1 ON EMPLOYEES(EMPLOYEEID);
ALTER TABLE EMPLOYEES ADD (CONSTRAINT EMPLOYEES_PK1_1 PRIMARY KEY(EMPLOYEEID));

