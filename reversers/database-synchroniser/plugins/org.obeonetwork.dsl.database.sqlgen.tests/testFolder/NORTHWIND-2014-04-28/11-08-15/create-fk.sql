-- ==============================================================
--  Foreign Key : FK_EMPLOYEES_EMPLOYEES                                    
-- ==============================================================
ALTER TABLE EMPLOYEES2 
	ADD (CONSTRAINT FK_EMPLOYEES_EMPLOYEES FOREIGN KEY(REPORTSTO) 
	REFERENCES EMPLOYEES2(EMPLOYEEID));

