-- ==============================================================
--  Primary Key : T1_PK                                    
-- ==============================================================
ALTER TABLE ALTERSCHEMA.T1 DROP CONSTRAINT T1_PK1_1;
CREATE UNIQUE INDEX T1_PK1_1 ON ALTERSCHEMARENAMED.T1(C1, C2);
ALTER TABLE ALTERSCHEMARENAMED.T1 ADD CONSTRAINT T1_PK1_1 PRIMARY KEY(C1, C2);

-- ==============================================================
--  Primary Key : T3_PK_RENAMED                                    
-- ==============================================================
ALTER TABLE ALTERSCHEMA.T3 DROP CONSTRAINT T3_PK1_1;
CREATE UNIQUE INDEX T3_PK1_1 ON ALTERSCHEMARENAMED.T3(C1);
ALTER TABLE ALTERSCHEMARENAMED.T3 ADD CONSTRAINT T3_PK1_1 PRIMARY KEY(C1);

