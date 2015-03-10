-- ==============================================================
--  Primary Key : T1_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX T1_PK1_1 ON T1(C1);
ALTER TABLE T1 ADD (CONSTRAINT T1_PK1_1 PRIMARY KEY(C1));

-- ==============================================================
--  Primary Key : T2_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX T2_PK1_1 ON T2(C1);
ALTER TABLE T2 ADD (CONSTRAINT T2_PK1_1 PRIMARY KEY(C1));

-- ==============================================================
--  Primary Key : T4_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX T4_PK1_1 ON T4(C1);
ALTER TABLE T4 ADD (CONSTRAINT T4_PK1_1 PRIMARY KEY(C1));

