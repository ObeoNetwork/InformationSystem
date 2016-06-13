-- ==============================================================
--  Foreign Key : T1_2_FK                                    
-- ==============================================================
ALTER TABLE T1_1 DROP CONSTRAINT T1_2_FK;
ALTER TABLE T1_1 
	ADD (CONSTRAINT T1_2_FK FOREIGN KEY(T1_2_FK, T1_2_FK2) 
	REFERENCES T1_3(C12, C22));

-- ==============================================================
--  Foreign Key : T1_2_FK_Renamed                                    
-- ==============================================================
ALTER TABLE T1_1 DROP CONSTRAINT T1_2_FK;
ALTER TABLE T1_1 
	ADD (CONSTRAINT T1_2_FK_Renamed FOREIGN KEY(T1_2_FK, T1_2_FK2) 
	REFERENCES T1_2(C1, C3));

-- ==============================================================
--  Foreign Key : T1_2_FK                                    
-- ==============================================================
ALTER TABLE T1_1 DROP CONSTRAINT T1_2_FK;
ALTER TABLE T1_1 
	ADD (CONSTRAINT T1_2_FK FOREIGN KEY(T1_2_FK) 
	REFERENCES T1_2(C1));

-- ==============================================================
--  Foreign Key : T1_2_FK                                    
-- ==============================================================
ALTER TABLE T1_1 DROP CONSTRAINT T1_2_FK;
ALTER TABLE T1_1 
	ADD (CONSTRAINT T1_2_FK FOREIGN KEY(T1_2_FK, T1_2_FK2) 
	REFERENCES T1_2(C1, C2));

