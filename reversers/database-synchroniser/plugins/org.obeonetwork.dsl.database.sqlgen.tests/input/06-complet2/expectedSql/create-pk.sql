-- ==============================================================
--  Primary Key : T1_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX T1_PK ON ADDSCHEMA.T1(C1);
ALTER TABLE ADDSCHEMA.T1 ADD CONSTRAINT T1_PK PRIMARY KEY(C1);

-- ==============================================================
--  Primary Key : T2_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX T2_PK ON ADDSCHEMA.T2(C1);
ALTER TABLE ADDSCHEMA.T2 ADD CONSTRAINT T2_PK PRIMARY KEY(C1);

-- ==============================================================
--  Primary Key : T4_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX T4_PK ON ALTERSCHEMARENAMED.T4(C1);
ALTER TABLE ALTERSCHEMARENAMED.T4 ADD CONSTRAINT T4_PK PRIMARY KEY(C1);

