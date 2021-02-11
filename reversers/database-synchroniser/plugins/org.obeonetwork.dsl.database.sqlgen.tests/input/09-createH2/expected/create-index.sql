-- ==============================================================
--  Index : AW_ADRESSE_PERSONNE_ID_IDX                                    
-- ==============================================================
CREATE INDEX AW_ADRESSE_PERSONNE_ID_IDX ON PUBLIC.AW_ADRESSE(PERSONNE_ID);

-- ==============================================================
--  Index : PRIMARY_KEY_D                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_D ON PUBLIC.AW_ADRESSE(ADRESSE_ID);

-- ==============================================================
--  Index : PRIMARY_KEY_5                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_5 ON PUBLIC.AW_COMPETENCE(COMPETENCE_ID);

-- ==============================================================
--  Index : COMPETENCE_ID_COMPETENCE_FK_INDEX_6                                    
-- ==============================================================
CREATE INDEX COMPETENCE_ID_COMPETENCE_FK_INDEX_6 ON PUBLIC.AW_COMPETENCE_ID(COMPETENCE_ID);

-- ==============================================================
--  Index : COMPETENCE_ID_PERSONNE_FK_INDEX_6                                    
-- ==============================================================
CREATE INDEX COMPETENCE_ID_PERSONNE_FK_INDEX_6 ON PUBLIC.AW_COMPETENCE_ID(PERSONNE_ID);

-- ==============================================================
--  Index : PRIMARY_KEY_6                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_6 ON PUBLIC.AW_COMPETENCE_ID(PERSONNE_ID, COMPETENCE_ID);

-- ==============================================================
--  Index : PRIMARY_KEY_3                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_3 ON PUBLIC.AW_COMPETENCE_PERSO(COMPETENCE_PERSO_ID);

-- ==============================================================
--  Index : AW_MAIL_PERSONNE_IDX                                    
-- ==============================================================
CREATE INDEX AW_MAIL_PERSONNE_IDX ON PUBLIC.AW_MAIL(PERSONNE_ID);

-- ==============================================================
--  Index : PRIMARY_KEY_8                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_8 ON PUBLIC.AW_MAIL(MAIL_ID);

-- ==============================================================
--  Index : PRIMARY_KEY_6B                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_6B ON PUBLIC.AW_PERMISSION(PERMISSION_ID);

-- ==============================================================
--  Index : AW_PERSONNE_GRADE_IDX                                    
-- ==============================================================
CREATE INDEX AW_PERSONNE_GRADE_IDX ON PUBLIC.AW_PERSONNE(GRADE_ID);

-- ==============================================================
--  Index : AW_PERSONNE_NOM_IDX                                    
-- ==============================================================
CREATE INDEX AW_PERSONNE_NOM_IDX ON PUBLIC.AW_PERSONNE(NOM);

-- ==============================================================
--  Index : PRIMARY_KEY_2                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_2 ON PUBLIC.AW_PERSONNE(PERSONNE_ID);

-- ==============================================================
--  Index : AW_PERSONNE_N_COMPETENCEPE_IDX                                    
-- ==============================================================
CREATE INDEX AW_PERSONNE_N_COMPETENCEPE_IDX ON PUBLIC.AW_PERSONNE_N_COMPETENCE_PERSO(COMPETENCEPERSO_ID);

-- ==============================================================
--  Index : AW_PERSONNE_N_PERSONNE_IDX                                    
-- ==============================================================
CREATE INDEX AW_PERSONNE_N_PERSONNE_IDX ON PUBLIC.AW_PERSONNE_N_COMPETENCE_PERSO(PERSONNE_ID);

-- ==============================================================
--  Index : PRIMARY_KEY_9                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_9 ON PUBLIC.AW_PERSONNE_N_COMPETENCE_PERSO(PERSONNE_N_COMPETENCE_PERSO_ID);

-- ==============================================================
--  Index : PRIMARY_KEY_84                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_84 ON PUBLIC.AW_ROLE(ROLE_ID);

-- ==============================================================
--  Index : PRIMARY_KEY_D8                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_D8 ON PUBLIC.AW_ROLEPERMISSION(ROLE_ID, PERMISSION_ID);

-- ==============================================================
--  Index : ROLEPERMISSIO_PERMISSION_FK_INDEX_D                                    
-- ==============================================================
CREATE INDEX ROLEPERMISSIO_PERMISSION_FK_INDEX_D ON PUBLIC.AW_ROLEPERMISSION(PERMISSION_ID);

-- ==============================================================
--  Index : ROLEPERMISSIO_ROLE_FK_INDEX_D                                    
-- ==============================================================
CREATE INDEX ROLEPERMISSIO_ROLE_FK_INDEX_D ON PUBLIC.AW_ROLEPERMISSION(ROLE_ID);

-- ==============================================================
--  Index : PRIMARY_KEY_7                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_7 ON PUBLIC.AW_ROLE_UTILISATEUR(UTILISATEUR_ID, ROLE_ID);

-- ==============================================================
--  Index : ROLE_UTILISAT_ROLE_FK_INDEX_7                                    
-- ==============================================================
CREATE INDEX ROLE_UTILISAT_ROLE_FK_INDEX_7 ON PUBLIC.AW_ROLE_UTILISATEUR(ROLE_ID);

-- ==============================================================
--  Index : ROLE_UTILISAT_UTILISATEUR_FK_INDEX_7                                    
-- ==============================================================
CREATE INDEX ROLE_UTILISAT_UTILISATEUR_FK_INDEX_7 ON PUBLIC.AW_ROLE_UTILISATEUR(UTILISATEUR_ID);

-- ==============================================================
--  Index : AW_TELEPHONE_PERSONNE_IDX                                    
-- ==============================================================
CREATE INDEX AW_TELEPHONE_PERSONNE_IDX ON PUBLIC.AW_TELEPHONE(PERSONNE_ID);

-- ==============================================================
--  Index : PRIMARY_KEY_9D                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_9D ON PUBLIC.AW_TELEPHONE(TELEPHONE_ID);

-- ==============================================================
--  Index : PRIMARY_KEY_A                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_A ON PUBLIC.AW_UTILISATEUR(UTILISATEUR_ID);

