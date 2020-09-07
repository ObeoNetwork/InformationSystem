-- ==============================================================
--  Foreign Key : ADRESSE_PERSONNE_ID_FK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ADRESSE 
	ADD CONSTRAINT ADRESSE_PERSONNE_ID_FK FOREIGN KEY(PERSONNE_ID) 
	REFERENCES PUBLIC.AW_PERSONNE(PERSONNE_ID);

-- ==============================================================
--  Foreign Key : COMPETENCE_ID_COMPETENCE_FK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_COMPETENCE_ID 
	ADD CONSTRAINT COMPETENCE_ID_COMPETENCE_FK FOREIGN KEY(COMPETENCE_ID) 
	REFERENCES PUBLIC.AW_COMPETENCE(COMPETENCE_ID);

-- ==============================================================
--  Foreign Key : COMPETENCE_ID_PERSONNE_FK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_COMPETENCE_ID 
	ADD CONSTRAINT COMPETENCE_ID_PERSONNE_FK FOREIGN KEY(PERSONNE_ID) 
	REFERENCES PUBLIC.AW_PERSONNE(PERSONNE_ID);

-- ==============================================================
--  Foreign Key : MAIL_PERSONNE_FK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_MAIL 
	ADD CONSTRAINT MAIL_PERSONNE_FK FOREIGN KEY(PERSONNE_ID) 
	REFERENCES PUBLIC.AW_PERSONNE(PERSONNE_ID);

-- ==============================================================
--  Foreign Key : PERSONNE_N_CO_COMPETENCEPER_FK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_PERSONNE_N_COMPETENCE_PERSO 
	ADD CONSTRAINT PERSONNE_N_CO_COMPETENCEPER_FK FOREIGN KEY(COMPETENCEPERSO_ID) 
	REFERENCES PUBLIC.AW_COMPETENCE_PERSO(COMPETENCE_PERSO_ID);

-- ==============================================================
--  Foreign Key : PERSONNE_N_CO_PERSONNE_FK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_PERSONNE_N_COMPETENCE_PERSO 
	ADD CONSTRAINT PERSONNE_N_CO_PERSONNE_FK FOREIGN KEY(PERSONNE_ID) 
	REFERENCES PUBLIC.AW_PERSONNE(PERSONNE_ID);

-- ==============================================================
--  Foreign Key : ROLEPERMISSIO_PERMISSION_FK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ROLEPERMISSION 
	ADD CONSTRAINT ROLEPERMISSIO_PERMISSION_FK FOREIGN KEY(PERMISSION_ID) 
	REFERENCES PUBLIC.AW_PERMISSION(PERMISSION_ID);

-- ==============================================================
--  Foreign Key : ROLEPERMISSIO_ROLE_FK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ROLEPERMISSION 
	ADD CONSTRAINT ROLEPERMISSIO_ROLE_FK FOREIGN KEY(ROLE_ID) 
	REFERENCES PUBLIC.AW_ROLE(ROLE_ID);

-- ==============================================================
--  Foreign Key : ROLE_UTILISAT_ROLE_FK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ROLE_UTILISATEUR 
	ADD CONSTRAINT ROLE_UTILISAT_ROLE_FK FOREIGN KEY(ROLE_ID) 
	REFERENCES PUBLIC.AW_ROLE(ROLE_ID);

-- ==============================================================
--  Foreign Key : ROLE_UTILISAT_UTILISATEUR_FK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ROLE_UTILISATEUR 
	ADD CONSTRAINT ROLE_UTILISAT_UTILISATEUR_FK FOREIGN KEY(UTILISATEUR_ID) 
	REFERENCES PUBLIC.AW_UTILISATEUR(UTILISATEUR_ID);

-- ==============================================================
--  Foreign Key : TELEPHONE_PERSONNE_FK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_TELEPHONE 
	ADD CONSTRAINT TELEPHONE_PERSONNE_FK FOREIGN KEY(PERSONNE_ID) 
	REFERENCES PUBLIC.AW_PERSONNE(PERSONNE_ID);

