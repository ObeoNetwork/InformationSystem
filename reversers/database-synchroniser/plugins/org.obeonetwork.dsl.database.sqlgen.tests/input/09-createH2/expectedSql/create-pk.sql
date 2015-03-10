-- ==============================================================
--  Primary Key : AW_TELEPHONE_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX AW_TELEPHONE_PK1_1 ON AW_TELEPHONE(TELEPHONE_ID);
ALTER TABLE AW_TELEPHONE ADD (CONSTRAINT AW_TELEPHONE_PK1_1 PRIMARY KEY(TELEPHONE_ID));

-- ==============================================================
--  Primary Key : AW_ROLE_UTILISATEUR_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX AW_ROLE_UTILISATEUR_PK1_1 ON AW_ROLE_UTILISATEUR(ROLE_ID, UTILISATEUR_ID);
ALTER TABLE AW_ROLE_UTILISATEUR ADD (CONSTRAINT AW_ROLE_UTILISATEUR_PK1_1 PRIMARY KEY(ROLE_ID, UTILISATEUR_ID));

-- ==============================================================
--  Primary Key : AW_ROLEPERMISSION_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX AW_ROLEPERMISSION_PK1_1 ON AW_ROLEPERMISSION(PERMISSION_ID, ROLE_ID);
ALTER TABLE AW_ROLEPERMISSION ADD (CONSTRAINT AW_ROLEPERMISSION_PK1_1 PRIMARY KEY(PERMISSION_ID, ROLE_ID));

-- ==============================================================
--  Primary Key : AW_PERSONNE_N_COMPETENCE_PE_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX AW_PERSONNE_N_COMPETENCE_PERSO_PK1_1 ON AW_PERSONNE_N_COMPETENCE_PERSO(PERSONNE_N_COMPETENCE_PERSO_ID);
ALTER TABLE AW_PERSONNE_N_COMPETENCE_PERSO ADD (CONSTRAINT AW_PERSONNE_N_COMPETENCE_PERSO_PK1_1 PRIMARY KEY(PERSONNE_N_COMPETENCE_PERSO_ID));

-- ==============================================================
--  Primary Key : AW_MAIL_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX AW_MAIL_PK1_1 ON AW_MAIL(MAIL_ID);
ALTER TABLE AW_MAIL ADD (CONSTRAINT AW_MAIL_PK1_1 PRIMARY KEY(MAIL_ID));

-- ==============================================================
--  Primary Key : AW_COMPETENCE_ID_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX AW_COMPETENCE_ID_PK1_1 ON AW_COMPETENCE_ID(COMPETENCE_ID, PERSONNE_ID);
ALTER TABLE AW_COMPETENCE_ID ADD (CONSTRAINT AW_COMPETENCE_ID_PK1_1 PRIMARY KEY(COMPETENCE_ID, PERSONNE_ID));

-- ==============================================================
--  Primary Key : AW_ADRESSE_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX AW_ADRESSE_PK1_1 ON AW_ADRESSE(ADRESSE_ID);
ALTER TABLE AW_ADRESSE ADD (CONSTRAINT AW_ADRESSE_PK1_1 PRIMARY KEY(ADRESSE_ID));

-- ==============================================================
--  Primary Key : AW_UTILISATEUR_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX AW_UTILISATEUR_PK1_1 ON AW_UTILISATEUR(UTILISATEUR_ID);
ALTER TABLE AW_UTILISATEUR ADD (CONSTRAINT AW_UTILISATEUR_PK1_1 PRIMARY KEY(UTILISATEUR_ID));

-- ==============================================================
--  Primary Key : AW_ROLE_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX AW_ROLE_PK1_1 ON AW_ROLE(ROLE_ID);
ALTER TABLE AW_ROLE ADD (CONSTRAINT AW_ROLE_PK1_1 PRIMARY KEY(ROLE_ID));

-- ==============================================================
--  Primary Key : AW_PERSONNE_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX AW_PERSONNE_PK1_1 ON AW_PERSONNE(PERSONNE_ID);
ALTER TABLE AW_PERSONNE ADD (CONSTRAINT AW_PERSONNE_PK1_1 PRIMARY KEY(PERSONNE_ID));

-- ==============================================================
--  Primary Key : AW_PERMISSION_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX AW_PERMISSION_PK1_1 ON AW_PERMISSION(PERMISSION_ID);
ALTER TABLE AW_PERMISSION ADD (CONSTRAINT AW_PERMISSION_PK1_1 PRIMARY KEY(PERMISSION_ID));

-- ==============================================================
--  Primary Key : AW_COMPETENCE_PERSO_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX AW_COMPETENCE_PERSO_PK1_1 ON AW_COMPETENCE_PERSO(COMPETENCE_PERSO_ID);
ALTER TABLE AW_COMPETENCE_PERSO ADD (CONSTRAINT AW_COMPETENCE_PERSO_PK1_1 PRIMARY KEY(COMPETENCE_PERSO_ID));

-- ==============================================================
--  Primary Key : AW_COMPETENCE_PK                                    
-- ==============================================================
CREATE UNIQUE INDEX AW_COMPETENCE_PK1_1 ON AW_COMPETENCE(COMPETENCE_ID);
ALTER TABLE AW_COMPETENCE ADD (CONSTRAINT AW_COMPETENCE_PK1_1 PRIMARY KEY(COMPETENCE_ID));

