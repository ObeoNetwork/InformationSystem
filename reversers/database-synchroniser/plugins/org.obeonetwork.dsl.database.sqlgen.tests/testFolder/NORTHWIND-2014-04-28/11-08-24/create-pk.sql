-- ==============================================================
--  Primary Key : PRIMARY2                                    
-- ==============================================================
CREATE UNIQUE INDEX EMPLOYEES_PK1_1 ON EMPLOYEES(EMPLOYEEID, HIREDATE);
ALTER TABLE EMPLOYEES ADD (CONSTRAINT EMPLOYEES_PK1_1 PRIMARY KEY(EMPLOYEEID, HIREDATE));

