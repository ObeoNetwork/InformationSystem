-- ==============================================================
--  Foreign Key : FK_EMPLOYEES_EMPLOYEES2                                    
-- ==============================================================
ALTER TABLE EMPLOYEES DROP CONSTRAINT FK_EMPLOYEES_EMPLOYEES;
ALTER TABLE EMPLOYEES 
	ADD (CONSTRAINT FK_EMPLOYEES_EMPLOYEES2 FOREIGN KEY(HIREBY) 
	REFERENCES EMPLOYEES(EMPLOYEEID));