-- ==============================================================
--  Foreign Key : FK1                                    
-- ==============================================================
ALTER TABLE ADDSCHEMA.T1 
	ADD CONSTRAINT FK1 FOREIGN KEY(C3_C1) 
	REFERENCES ADDSCHEMA.T2(C1);

-- ==============================================================
--  Foreign Key : T2_FK                                    
-- ==============================================================
ALTER TABLE ALTERSCHEMARENAMED.T1 
	ADD CONSTRAINT T2_FK FOREIGN KEY(T5_ID) 
	REFERENCES ALTERSCHEMARENAMED.T5(C1);

