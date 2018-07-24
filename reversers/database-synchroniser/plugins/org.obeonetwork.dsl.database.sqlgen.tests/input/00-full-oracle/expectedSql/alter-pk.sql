-- ==============================================================
--  Primary Key : Table5_PK_Renommee                                    
-- ==============================================================
ALTER TABLE DEMO.TABLE5 DROP CONSTRAINT Table5_PK;
CREATE UNIQUE INDEX Table5_PK_Renommee ON DEMO.TABLE5(col5_1);
ALTER TABLE DEMO.TABLE5 ADD CONSTRAINT Table5_PK_Renommee PRIMARY KEY(col5_1);

