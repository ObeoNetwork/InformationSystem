-- ==============================================================
--  Primary Key : PRIMARY                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY ON EMPLOYEES(EMPLOYEEID);
ALTER TABLE EMPLOYEES ADD (CONSTRAINT PRIMARY PRIMARY KEY(EMPLOYEEID));