-- ==============================================================
--  Foreign Key : adresse_personne_id_fk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ADRESSE 
	ADD CONSTRAINT adresse_personne_id_fk FOREIGN KEY(personne_id) 
	REFERENCES PUBLIC.AW_PERSONNE(personne_id);

-- ==============================================================
--  Foreign Key : competence_id_competence_fk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_COMPETENCE_ID 
	ADD CONSTRAINT competence_id_competence_fk FOREIGN KEY(competence_id) 
	REFERENCES PUBLIC.AW_COMPETENCE(competence_id);

-- ==============================================================
--  Foreign Key : competence_id_personne_fk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_COMPETENCE_ID 
	ADD CONSTRAINT competence_id_personne_fk FOREIGN KEY(personne_id) 
	REFERENCES PUBLIC.AW_PERSONNE(personne_id);

-- ==============================================================
--  Foreign Key : mail_personne_fk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_MAIL 
	ADD CONSTRAINT mail_personne_fk FOREIGN KEY(personne_id) 
	REFERENCES PUBLIC.AW_PERSONNE(personne_id);

-- ==============================================================
--  Foreign Key : personne_n_co_competenceper_fk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_PERSONNE_N_COMPETENCE_PERSO 
	ADD CONSTRAINT personne_n_co_competenceper_fk FOREIGN KEY(competenceperso_id) 
	REFERENCES PUBLIC.AW_COMPETENCE_PERSO(competence_perso_id);

-- ==============================================================
--  Foreign Key : personne_n_co_personne_fk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_PERSONNE_N_COMPETENCE_PERSO 
	ADD CONSTRAINT personne_n_co_personne_fk FOREIGN KEY(personne_id) 
	REFERENCES PUBLIC.AW_PERSONNE(personne_id);

-- ==============================================================
--  Foreign Key : role_utilisat_role_fk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ROLE_UTILISATEUR 
	ADD CONSTRAINT role_utilisat_role_fk FOREIGN KEY(role_id) 
	REFERENCES PUBLIC.AW_ROLE(role_id);

-- ==============================================================
--  Foreign Key : role_utilisat_utilisateur_fk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ROLE_UTILISATEUR 
	ADD CONSTRAINT role_utilisat_utilisateur_fk FOREIGN KEY(utilisateur_id) 
	REFERENCES PUBLIC.AW_UTILISATEUR(utilisateur_id);

-- ==============================================================
--  Foreign Key : rolepermissio_permission_fk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ROLEPERMISSION 
	ADD CONSTRAINT rolepermissio_permission_fk FOREIGN KEY(permission_id) 
	REFERENCES PUBLIC.AW_PERMISSION(permission_id);

-- ==============================================================
--  Foreign Key : rolepermissio_role_fk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ROLEPERMISSION 
	ADD CONSTRAINT rolepermissio_role_fk FOREIGN KEY(role_id) 
	REFERENCES PUBLIC.AW_ROLE(role_id);

-- ==============================================================
--  Foreign Key : telephone_personne_fk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_TELEPHONE 
	ADD CONSTRAINT telephone_personne_fk FOREIGN KEY(personne_id) 
	REFERENCES PUBLIC.AW_PERSONNE(personne_id);

