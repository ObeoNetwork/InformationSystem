-- ==============================================================
--  Primary Key : AW_ADRESSE_PK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ADRESSE ADD CONSTRAINT AW_ADRESSE_PK1_1 PRIMARY KEY(ADRESSE_ID);

-- ==============================================================
--  Primary Key : AW_COMPETENCE_PK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_COMPETENCE ADD CONSTRAINT AW_COMPETENCE_PK1_1 PRIMARY KEY(COMPETENCE_ID);

-- ==============================================================
--  Primary Key : AW_COMPETENCE_ID_PK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_COMPETENCE_ID ADD CONSTRAINT AW_COMPETENCE_ID_PK1_1 PRIMARY KEY(COMPETENCE_ID, PERSONNE_ID);

-- ==============================================================
--  Primary Key : AW_COMPETENCE_PERSO_PK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_COMPETENCE_PERSO ADD CONSTRAINT AW_COMPETENCE_PERSO_PK1_1 PRIMARY KEY(COMPETENCE_PERSO_ID);

-- ==============================================================
--  Primary Key : AW_MAIL_PK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_MAIL ADD CONSTRAINT AW_MAIL_PK1_1 PRIMARY KEY(MAIL_ID);

-- ==============================================================
--  Primary Key : AW_PERMISSION_PK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_PERMISSION ADD CONSTRAINT AW_PERMISSION_PK1_1 PRIMARY KEY(PERMISSION_ID);

-- ==============================================================
--  Primary Key : AW_PERSONNE_PK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_PERSONNE ADD CONSTRAINT AW_PERSONNE_PK1_1 PRIMARY KEY(PERSONNE_ID);

-- ==============================================================
--  Primary Key : AW_PERSONNE_N_COMPETENCE_PE_PK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_PERSONNE_N_COMPETENCE_PERSO ADD CONSTRAINT AW_PERSONNE_N_COMPETENCE_PERSO_PK1_1 PRIMARY KEY(PERSONNE_N_COMPETENCE_PERSO_ID);

-- ==============================================================
--  Primary Key : AW_ROLE_PK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ROLE ADD CONSTRAINT AW_ROLE_PK1_1 PRIMARY KEY(ROLE_ID);

-- ==============================================================
--  Primary Key : AW_ROLEPERMISSION_PK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ROLEPERMISSION ADD CONSTRAINT AW_ROLEPERMISSION_PK1_1 PRIMARY KEY(PERMISSION_ID, ROLE_ID);

-- ==============================================================
--  Primary Key : AW_ROLE_UTILISATEUR_PK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_ROLE_UTILISATEUR ADD CONSTRAINT AW_ROLE_UTILISATEUR_PK1_1 PRIMARY KEY(ROLE_ID, UTILISATEUR_ID);

-- ==============================================================
--  Primary Key : AW_TELEPHONE_PK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_TELEPHONE ADD CONSTRAINT AW_TELEPHONE_PK1_1 PRIMARY KEY(TELEPHONE_ID);

-- ==============================================================
--  Primary Key : AW_UTILISATEUR_PK                                    
-- ==============================================================
ALTER TABLE PUBLIC.AW_UTILISATEUR ADD CONSTRAINT AW_UTILISATEUR_PK1_1 PRIMARY KEY(UTILISATEUR_ID);

