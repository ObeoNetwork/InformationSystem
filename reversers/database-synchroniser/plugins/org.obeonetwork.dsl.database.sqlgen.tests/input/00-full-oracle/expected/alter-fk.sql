-- ==============================================================
--  Foreign Key : FK_8_1                                    
-- ==============================================================
ALTER TABLE DEMO.TABLE8 DROP CONSTRAINT FK_8_1;
ALTER TABLE DEMO.TABLE8 
	ADD CONSTRAINT FK_8_1 FOREIGN KEY(col9_1) 
	REFERENCES DEMO.TABLE9(col9_1);

