-- ==============================================================
--  Foreign Key : FK1                                    
-- ==============================================================
ALTER TABLE T1 
	ADD (CONSTRAINT FK1 FOREIGN KEY(C3_C1) 
	REFERENCES T2(C1));

-- ==============================================================
--  Foreign Key : T2_FK                                    
-- ==============================================================
ALTER TABLE T1 
	ADD (CONSTRAINT T2_FK FOREIGN KEY(T5_ID) 
	REFERENCES T5(C1));

