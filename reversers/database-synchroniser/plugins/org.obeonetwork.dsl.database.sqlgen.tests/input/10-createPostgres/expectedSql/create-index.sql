-- ==============================================================
--  Index : aw_adresse_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_adresse_pk ON PUBLIC.AW_ADRESSE(adresse_id);

-- ==============================================================
--  Index : aw_competence_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_competence_pk ON PUBLIC.AW_COMPETENCE(competence_id);

-- ==============================================================
--  Index : aw_competence_id_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_competence_id_pk ON PUBLIC.AW_COMPETENCE_ID(personne_id, competence_id);

-- ==============================================================
--  Index : aw_competence_perso_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_competence_perso_pk ON PUBLIC.AW_COMPETENCE_PERSO(competence_perso_id);

-- ==============================================================
--  Index : aw_mail_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_mail_pk ON PUBLIC.AW_MAIL(mail_id);

-- ==============================================================
--  Index : aw_permission_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_permission_pk ON PUBLIC.AW_PERMISSION(permission_id);

-- ==============================================================
--  Index : aw_personne_grade_idx                                    
-- ==============================================================
CREATE INDEX aw_personne_grade_idx ON PUBLIC.AW_PERSONNE(grade_id);

-- ==============================================================
--  Index : aw_personne_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_personne_pk ON PUBLIC.AW_PERSONNE(personne_id);

-- ==============================================================
--  Index : aw_personne_n_competence_pe_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_personne_n_competence_pe_pk ON PUBLIC.AW_PERSONNE_N_COMPETENCE_PERSO(personne_n_competence_perso_id);

-- ==============================================================
--  Index : aw_role_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_role_pk ON PUBLIC.AW_ROLE(role_id);

-- ==============================================================
--  Index : aw_role_utilisateur_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_role_utilisateur_pk ON PUBLIC.AW_ROLE_UTILISATEUR(utilisateur_id, role_id);

-- ==============================================================
--  Index : aw_rolepermission_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_rolepermission_pk ON PUBLIC.AW_ROLEPERMISSION(role_id, permission_id);

-- ==============================================================
--  Index : aw_telephone_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_telephone_pk ON PUBLIC.AW_TELEPHONE(telephone_id);

-- ==============================================================
--  Index : aw_utilisateur_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_utilisateur_pk ON PUBLIC.AW_UTILISATEUR(utilisateur_id);

