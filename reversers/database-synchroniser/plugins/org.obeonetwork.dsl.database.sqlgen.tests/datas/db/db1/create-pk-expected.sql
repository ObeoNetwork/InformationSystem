-- ==============================================================
--  Primary Key : AD_ACQ_PK1_1                                    
-- ==============================================================
CREATE UNIQUE INDEX AD_ACQ_PK1_1 ON AD_ACQ(AD_ACQ_ID);
ALTER TABLE AD_ACQ ADD (CONSTRAINT AD_ACQ_PK1_1 PRIMARY KEY(AD_ACQ_ID));