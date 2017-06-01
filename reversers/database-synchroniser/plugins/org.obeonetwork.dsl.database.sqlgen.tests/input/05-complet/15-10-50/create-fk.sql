-- ==============================================================
--  Foreign Key : FK_vers_T2                                    
-- ==============================================================
ALTER TABLE NOUVELLE 
	ADD CONSTRAINT FK_vers_T2 FOREIGN KEY(FK_column) 
	REFERENCES T2DSQD(NouvelleColonne);

