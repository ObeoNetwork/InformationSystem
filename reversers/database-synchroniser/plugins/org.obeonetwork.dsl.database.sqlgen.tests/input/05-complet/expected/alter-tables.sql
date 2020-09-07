-- ==============================================================
--  Table : C                                    
-- ==============================================================
ALTER TABLE C RENAME COLUMN nomInitial TO nomModifie;

-- ==============================================================
--  Table : T2DSQD                                    
-- ==============================================================
ALTER TABLE T2DSQD DROP COLUMN ColonneSupprimée;

ALTER TABLE T2DSQD ADD NouvelleColonne Décimal(10, 0) NOT NULL;

ALTER TABLE T2DSQD MODIFY ColTypeChange Booléen NOT NULL;

-- ==============================================================
--  Table : TABLEAVECPKCHANGEANTDECOLONNE                                    
-- ==============================================================

