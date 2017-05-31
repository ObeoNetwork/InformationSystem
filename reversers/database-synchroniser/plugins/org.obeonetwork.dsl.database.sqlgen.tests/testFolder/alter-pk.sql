-- ==============================================================
--  Primary Key : PRIMARY2                                    
-- ==============================================================
ALTER TABLE EMPLOYEES DROP CONSTRAINT PRIMARY;
CREATE UNIQUE INDEX PRIMARY2 ON EMPLOYEES(EMPLOYEEID, HIREDATE);
ALTER TABLE EMPLOYEES ADD (CONSTRAINT PRIMARY2 PRIMARY KEY(EMPLOYEEID, HIREDATE));

