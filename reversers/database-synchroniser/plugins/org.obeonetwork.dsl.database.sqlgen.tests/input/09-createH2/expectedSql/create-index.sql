-- ==============================================================
--  Index : PRIMARY_KEY_9D                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_9D ON AW_TELEPHONE(TELEPHONE_ID)
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
--  Index : AW_TELEPHONE_PERSONNE_IDX                                    
-- ==============================================================
CREATE INDEX AW_TELEPHONE_PERSONNE_IDX ON AW_TELEPHONE(PERSONNE_ID)
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
--  Index : PRIMARY_KEY_7                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_7 ON AW_ROLE_UTILISATEUR(UTILISATEUR_ID, ROLE_ID)
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
--  Index : ROLE_UTILISAT_ROLE_FK_INDEX_7                                    
-- ==============================================================
CREATE INDEX ROLE_UTILISAT_ROLE_FK_INDEX_7 ON AW_ROLE_UTILISATEUR(ROLE_ID)
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
--  Index : ROLE_UTILISAT_UTILISATEUR_FK_INDEX_7                                    
-- ==============================================================
CREATE INDEX ROLE_UTILISAT_UTILISATEUR_FK_INDEX_7 ON AW_ROLE_UTILISATEUR(UTILISATEUR_ID)
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
--  Index : PRIMARY_KEY_D8                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_D8 ON AW_ROLEPERMISSION(ROLE_ID, PERMISSION_ID)
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
--  Index : ROLEPERMISSIO_PERMISSION_FK_INDEX_D                                    
-- ==============================================================
CREATE INDEX ROLEPERMISSIO_PERMISSION_FK_INDEX_D ON AW_ROLEPERMISSION(PERMISSION_ID)
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
--  Index : ROLEPERMISSIO_ROLE_FK_INDEX_D                                    
-- ==============================================================
CREATE INDEX ROLEPERMISSIO_ROLE_FK_INDEX_D ON AW_ROLEPERMISSION(ROLE_ID)
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
--  Index : PRIMARY_KEY_9                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_9 ON AW_PERSONNE_N_COMPETENCE_PERSO(PERSONNE_N_COMPETENCE_PERSO_ID)
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
--  Index : AW_PERSONNE_N_COMPETENCEPE_IDX                                    
-- ==============================================================
CREATE INDEX AW_PERSONNE_N_COMPETENCEPE_IDX ON AW_PERSONNE_N_COMPETENCE_PERSO(COMPETENCEPERSO_ID)
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
--  Index : AW_PERSONNE_N_PERSONNE_IDX                                    
-- ==============================================================
CREATE INDEX AW_PERSONNE_N_PERSONNE_IDX ON AW_PERSONNE_N_COMPETENCE_PERSO(PERSONNE_ID)
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
--  Index : PRIMARY_KEY_8                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_8 ON AW_MAIL(MAIL_ID)
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
--  Index : AW_MAIL_PERSONNE_IDX                                    
-- ==============================================================
CREATE INDEX AW_MAIL_PERSONNE_IDX ON AW_MAIL(PERSONNE_ID)
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
--  Index : PRIMARY_KEY_6                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_6 ON AW_COMPETENCE_ID(PERSONNE_ID, COMPETENCE_ID)
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
--  Index : COMPETENCE_ID_COMPETENCE_FK_INDEX_6                                    
-- ==============================================================
CREATE INDEX COMPETENCE_ID_COMPETENCE_FK_INDEX_6 ON AW_COMPETENCE_ID(COMPETENCE_ID)
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
--  Index : COMPETENCE_ID_PERSONNE_FK_INDEX_6                                    
-- ==============================================================
CREATE INDEX COMPETENCE_ID_PERSONNE_FK_INDEX_6 ON AW_COMPETENCE_ID(PERSONNE_ID)
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
--  Index : PRIMARY_KEY_D                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_D ON AW_ADRESSE(ADRESSE_ID)
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
--  Index : AW_ADRESSE_PERSONNE_ID_IDX                                    
-- ==============================================================
CREATE INDEX AW_ADRESSE_PERSONNE_ID_IDX ON AW_ADRESSE(PERSONNE_ID)
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
--  Index : PRIMARY_KEY_A                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_A ON AW_UTILISATEUR(UTILISATEUR_ID)
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
--  Index : PRIMARY_KEY_84                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_84 ON AW_ROLE(ROLE_ID)
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
--  Index : PRIMARY_KEY_2                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_2 ON AW_PERSONNE(PERSONNE_ID)
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
--  Index : AW_PERSONNE_GRADE_IDX                                    
-- ==============================================================
CREATE INDEX AW_PERSONNE_GRADE_IDX ON AW_PERSONNE(GRADE_ID)
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
--  Index : AW_PERSONNE_NOM_IDX                                    
-- ==============================================================
CREATE INDEX AW_PERSONNE_NOM_IDX ON AW_PERSONNE(NOM)
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
--  Index : PRIMARY_KEY_6B                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_6B ON AW_PERMISSION(PERMISSION_ID)
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
--  Index : PRIMARY_KEY_3                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_3 ON AW_COMPETENCE_PERSO(COMPETENCE_PERSO_ID)
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
--  Index : PRIMARY_KEY_5                                    
-- ==============================================================
CREATE UNIQUE INDEX PRIMARY_KEY_5 ON AW_COMPETENCE(COMPETENCE_ID)
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

