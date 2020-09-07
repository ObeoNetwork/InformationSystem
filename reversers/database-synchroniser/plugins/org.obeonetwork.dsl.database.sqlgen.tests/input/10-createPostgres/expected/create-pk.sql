-- ==============================================================
--  Primary Key : aw_adresse_pk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ADRESSE ADD CONSTRAINT aw_adresse_PK1_1 PRIMARY KEY(adresse_id);

-- ==============================================================
--  Primary Key : aw_competence_pk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_COMPETENCE ADD CONSTRAINT aw_competence_PK1_1 PRIMARY KEY(competence_id);

-- ==============================================================
--  Primary Key : aw_competence_id_pk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_COMPETENCE_ID ADD CONSTRAINT aw_competence_id_PK1_1 PRIMARY KEY(personne_id, competence_id);

-- ==============================================================
--  Primary Key : aw_competence_perso_pk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_COMPETENCE_PERSO ADD CONSTRAINT aw_competence_perso_PK1_1 PRIMARY KEY(competence_perso_id);

-- ==============================================================
--  Primary Key : aw_mail_pk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_MAIL ADD CONSTRAINT aw_mail_PK1_1 PRIMARY KEY(mail_id);

-- ==============================================================
--  Primary Key : aw_permission_pk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_PERMISSION ADD CONSTRAINT aw_permission_PK1_1 PRIMARY KEY(permission_id);

-- ==============================================================
--  Primary Key : aw_personne_pk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_PERSONNE ADD CONSTRAINT aw_personne_PK1_1 PRIMARY KEY(personne_id);

-- ==============================================================
--  Primary Key : aw_personne_n_competence_pe_pk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_PERSONNE_N_COMPETENCE_PERSO ADD CONSTRAINT aw_personne_n_competence_perso_PK1_1 PRIMARY KEY(personne_n_competence_perso_id);

-- ==============================================================
--  Primary Key : aw_role_pk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ROLE ADD CONSTRAINT aw_role_PK1_1 PRIMARY KEY(role_id);

-- ==============================================================
--  Primary Key : aw_role_utilisateur_pk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ROLE_UTILISATEUR ADD CONSTRAINT aw_role_utilisateur_PK1_1 PRIMARY KEY(utilisateur_id, role_id);

-- ==============================================================
--  Primary Key : aw_rolepermission_pk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ROLEPERMISSION ADD CONSTRAINT aw_rolepermission_PK1_1 PRIMARY KEY(role_id, permission_id);

-- ==============================================================
--  Primary Key : aw_telephone_pk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_TELEPHONE ADD CONSTRAINT aw_telephone_PK1_1 PRIMARY KEY(telephone_id);

-- ==============================================================
--  Primary Key : aw_utilisateur_pk                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_UTILISATEUR ADD CONSTRAINT aw_utilisateur_PK1_1 PRIMARY KEY(utilisateur_id);

