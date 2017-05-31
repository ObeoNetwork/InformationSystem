-- ==============================================================
--  Foreign Key : FK_EMPLOYEES_EMPLOYEES                                    
-- ==============================================================
ALTER TABLE EMPLOYEES 
	ADD (CONSTRAINT FK_EMPLOYEES_EMPLOYEES FOREIGN KEY(REPORTSTO) 
	REFERENCES EMPLOYEES(EMPLOYEEID));

