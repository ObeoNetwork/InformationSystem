-- ==============================================================
--  Primary Key : Nouvelle_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX Nouvelle_PK1_1 ON NOUVELLE(id);
ALTER TABLE NOUVELLE ADD CONSTRAINT Nouvelle_PK1_1 PRIMARY KEY(id);

-- ==============================================================
--  Primary Key : T2dsqd_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX T2dsqd_PK1_1 ON T2DSQD(NouvelleColonne);
ALTER TABLE T2DSQD ADD CONSTRAINT T2dsqd_PK1_1 PRIMARY KEY(NouvelleColonne);

