-- ==============================================================
--  Primary Key : aw_telephone_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_telephone_PK1_1 ON AW_TELEPHONE(telephone_id);
ALTER TABLE AW_TELEPHONE ADD (CONSTRAINT aw_telephone_PK1_1 PRIMARY KEY(telephone_id));

-- ==============================================================
--  Primary Key : aw_rolepermission_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_rolepermission_PK1_1 ON AW_ROLEPERMISSION(role_id, permission_id);
ALTER TABLE AW_ROLEPERMISSION ADD (CONSTRAINT aw_rolepermission_PK1_1 PRIMARY KEY(role_id, permission_id));

-- ==============================================================
--  Primary Key : aw_role_utilisateur_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_role_utilisateur_PK1_1 ON AW_ROLE_UTILISATEUR(utilisateur_id, role_id);
ALTER TABLE AW_ROLE_UTILISATEUR ADD (CONSTRAINT aw_role_utilisateur_PK1_1 PRIMARY KEY(utilisateur_id, role_id));

-- ==============================================================
--  Primary Key : aw_personne_n_competence_pe_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_personne_n_competence_perso_PK1_1 ON AW_PERSONNE_N_COMPETENCE_PERSO(personne_n_competence_perso_id);
ALTER TABLE AW_PERSONNE_N_COMPETENCE_PERSO ADD (CONSTRAINT aw_personne_n_competence_perso_PK1_1 PRIMARY KEY(personne_n_competence_perso_id));

-- ==============================================================
--  Primary Key : aw_mail_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_mail_PK1_1 ON AW_MAIL(mail_id);
ALTER TABLE AW_MAIL ADD (CONSTRAINT aw_mail_PK1_1 PRIMARY KEY(mail_id));

-- ==============================================================
--  Primary Key : aw_competence_id_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_competence_id_PK1_1 ON AW_COMPETENCE_ID(personne_id, competence_id);
ALTER TABLE AW_COMPETENCE_ID ADD (CONSTRAINT aw_competence_id_PK1_1 PRIMARY KEY(personne_id, competence_id));

-- ==============================================================
--  Primary Key : aw_adresse_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_adresse_PK1_1 ON AW_ADRESSE(adresse_id);
ALTER TABLE AW_ADRESSE ADD (CONSTRAINT aw_adresse_PK1_1 PRIMARY KEY(adresse_id));

-- ==============================================================
--  Primary Key : aw_utilisateur_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_utilisateur_PK1_1 ON AW_UTILISATEUR(utilisateur_id);
ALTER TABLE AW_UTILISATEUR ADD (CONSTRAINT aw_utilisateur_PK1_1 PRIMARY KEY(utilisateur_id));

-- ==============================================================
--  Primary Key : aw_role_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_role_PK1_1 ON AW_ROLE(role_id);
ALTER TABLE AW_ROLE ADD (CONSTRAINT aw_role_PK1_1 PRIMARY KEY(role_id));

-- ==============================================================
--  Primary Key : aw_personne_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_personne_PK1_1 ON AW_PERSONNE(personne_id);
ALTER TABLE AW_PERSONNE ADD (CONSTRAINT aw_personne_PK1_1 PRIMARY KEY(personne_id));

-- ==============================================================
--  Primary Key : aw_permission_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_permission_PK1_1 ON AW_PERMISSION(permission_id);
ALTER TABLE AW_PERMISSION ADD (CONSTRAINT aw_permission_PK1_1 PRIMARY KEY(permission_id));

-- ==============================================================
--  Primary Key : aw_competence_perso_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_competence_perso_PK1_1 ON AW_COMPETENCE_PERSO(competence_perso_id);
ALTER TABLE AW_COMPETENCE_PERSO ADD (CONSTRAINT aw_competence_perso_PK1_1 PRIMARY KEY(competence_perso_id));

-- ==============================================================
--  Primary Key : aw_competence_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_competence_PK1_1 ON AW_COMPETENCE(competence_id);
ALTER TABLE AW_COMPETENCE ADD (CONSTRAINT aw_competence_PK1_1 PRIMARY KEY(competence_id));

