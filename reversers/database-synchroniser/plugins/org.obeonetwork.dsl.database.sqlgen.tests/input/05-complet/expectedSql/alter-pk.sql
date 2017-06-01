-- ==============================================================
--  Primary Key : TableAvecPKChangeantDeColonne_PK                                    
-- ==============================================================
ALTER TABLE TABLEAVECPKCHANGEANTDECOLONNE DROP CONSTRAINT TableAvecPKChangeantDeColonne_PK1_1;
CREATE UNIQUE INDEX TableAvecPKChangeantDeColonne_PK1_1 ON TABLEAVECPKCHANGEANTDECOLONNE(B);
ALTER TABLE TABLEAVECPKCHANGEANTDECOLONNE ADD CONSTRAINT TableAvecPKChangeantDeColonne_PK1_1 PRIMARY KEY(B);

