-- ==============================================================
--  Foreign Key : T1_2_FK                                    
-- ==============================================================
ALTER TABLE S4.T1_1 DROP CONSTRAINT T1_2_FK;
ALTER TABLE S4.T1_1 
	ADD CONSTRAINT T1_2_FK FOREIGN KEY(T1_2_FK, T1_2_FK2) 
	REFERENCES S4.T1_2(C1, C2);

-- ==============================================================
--  Foreign Key : T1_2_FK                                    
-- ==============================================================
ALTER TABLE S5.T1_1 DROP CONSTRAINT T1_2_FK;
ALTER TABLE S5.T1_1 
	ADD CONSTRAINT T1_2_FK FOREIGN KEY(T1_2_FK) 
	REFERENCES S5.T1_2(C1);

-- ==============================================================
--  Foreign Key : T1_2_FK_Renamed                                    
-- ==============================================================
ALTER TABLE S6.T1_1 DROP CONSTRAINT T1_2_FK;
ALTER TABLE S6.T1_1 
	ADD CONSTRAINT T1_2_FK_Renamed FOREIGN KEY(T1_2_FK, T1_2_FK2) 
	REFERENCES S6.T1_2(C1, C3);

-- ==============================================================
--  Foreign Key : T1_2_FK                                    
-- ==============================================================
ALTER TABLE S8.T1_1 DROP CONSTRAINT T1_2_FK;
ALTER TABLE S8.T1_1 
	ADD CONSTRAINT T1_2_FK FOREIGN KEY(T1_2_FK, T1_2_FK2) 
	REFERENCES S8.T1_3(C12, C22);

