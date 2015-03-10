-- ==============================================================
--  Foreign Key : FK_ORDERS_EMPLOYEES                                    
-- ==============================================================
ALTER TABLE ORDERS DROP CONSTRAINT FK_ORDERS_EMPLOYEES;
ALTER TABLE ORDERS 
	ADD (CONSTRAINT FK_ORDERS_EMPLOYEES FOREIGN KEY(EMPLOYEEID) 
	REFERENCES EMPLOYEES2(EMPLOYEEID));

