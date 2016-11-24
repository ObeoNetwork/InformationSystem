-- ==============================================================
--  Primary Key : T1_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX T1_PK1_1 ON ADDSCHEMA.T1(C1);
ALTER TABLE ADDSCHEMA.T1 ADD CONSTRAINT T1_PK1_1 PRIMARY KEY(C1);

-- ==============================================================
--  Primary Key : T2_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX T2_PK1_1 ON ADDSCHEMA.T2(C1);
ALTER TABLE ADDSCHEMA.T2 ADD CONSTRAINT T2_PK1_1 PRIMARY KEY(C1);

-- ==============================================================
--  Primary Key : T4_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX T4_PK1_1 ON ALTERSCHEMARENAMED.T4(C1);
ALTER TABLE ALTERSCHEMARENAMED.T4 ADD CONSTRAINT T4_PK1_1 PRIMARY KEY(C1);

