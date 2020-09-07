-- ==============================================================
--  Foreign Key : FK_7_1                                    
-- ==============================================================
ALTER TABLE TABLE7 
	ADD CONSTRAINT FK_7_1 FOREIGN KEY(col8_1) 
	REFERENCES TABLE8(col8_1);

