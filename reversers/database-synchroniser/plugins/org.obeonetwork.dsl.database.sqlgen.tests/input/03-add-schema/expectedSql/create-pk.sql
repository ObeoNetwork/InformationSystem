-- ==============================================================
--  Primary Key : T1_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX T1_PK1_1 ON T1(C1);
ALTER TABLE T1 ADD (CONSTRAINT T1_PK1_1 PRIMARY KEY(C1));

