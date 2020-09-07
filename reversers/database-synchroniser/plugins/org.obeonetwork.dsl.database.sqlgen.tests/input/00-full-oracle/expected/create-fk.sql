-- ==============================================================
--  Foreign Key : FK_7_1                                    
-- ==============================================================
ALTER TABLE DEMO.TABLE7 
	ADD CONSTRAINT FK_7_1 FOREIGN KEY(col8_1) 
	REFERENCES DEMO.TABLE8(col8_1);

