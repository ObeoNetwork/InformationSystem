-- ==============================================================
--  Index : aw_telephone_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_telephone_pk ON AW_TELEPHONE(telephone_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_telephone_personne_idx                                    
-- ==============================================================
CREATE INDEX aw_telephone_personne_idx ON AW_TELEPHONE(personne_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_rolepermission_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_rolepermission_pk ON AW_ROLEPERMISSION(role_id, permission_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_role_utilisateur_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_role_utilisateur_pk ON AW_ROLE_UTILISATEUR(utilisateur_id, role_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_personne_n_competence_pe_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_personne_n_competence_pe_pk ON AW_PERSONNE_N_COMPETENCE_PERSO(personne_n_competence_perso_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_personne_n_competencepe_idx                                    
-- ==============================================================
CREATE INDEX aw_personne_n_competencepe_idx ON AW_PERSONNE_N_COMPETENCE_PERSO(competenceperso_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_personne_n_personne_idx                                    
-- ==============================================================
CREATE INDEX aw_personne_n_personne_idx ON AW_PERSONNE_N_COMPETENCE_PERSO(personne_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_mail_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_mail_pk ON AW_MAIL(mail_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_mail_personne_idx                                    
-- ==============================================================
CREATE INDEX aw_mail_personne_idx ON AW_MAIL(personne_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_competence_id_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_competence_id_pk ON AW_COMPETENCE_ID(personne_id, competence_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_adresse_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_adresse_pk ON AW_ADRESSE(adresse_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_adresse_personne_id_idx                                    
-- ==============================================================
CREATE INDEX aw_adresse_personne_id_idx ON AW_ADRESSE(personne_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_utilisateur_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_utilisateur_pk ON AW_UTILISATEUR(utilisateur_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_role_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_role_pk ON AW_ROLE(role_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_personne_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_personne_pk ON AW_PERSONNE(personne_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_personne_grade_idx                                    
-- ==============================================================
CREATE INDEX aw_personne_grade_idx ON AW_PERSONNE(grade_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_permission_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_permission_pk ON AW_PERMISSION(permission_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_competence_perso_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_competence_perso_pk ON AW_COMPETENCE_PERSO(competence_perso_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : aw_competence_pk                                    
-- ==============================================================
CREATE UNIQUE INDEX aw_competence_pk ON AW_COMPETENCE(competence_id)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_PUBLIC
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

