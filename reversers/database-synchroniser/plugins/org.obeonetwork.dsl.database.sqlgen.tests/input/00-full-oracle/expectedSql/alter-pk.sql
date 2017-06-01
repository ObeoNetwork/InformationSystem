-- ==============================================================
--  Primary Key : Table5_PK_Renommee                                    
-- ==============================================================
ALTER TABLE DEMO.TABLE5 DROP CONSTRAINT Table5_PK1_1;
CREATE UNIQUE INDEX Table5_PK1_1 ON DEMO.TABLE5(col5_1);
ALTER TABLE DEMO.TABLE5 ADD CONSTRAINT Table5_PK1_1 PRIMARY KEY(col5_1);

