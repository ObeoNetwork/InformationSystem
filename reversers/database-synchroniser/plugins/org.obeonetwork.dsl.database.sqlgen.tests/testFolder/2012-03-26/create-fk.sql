-- ==============================================================
--  Foreign Key : AD_ACQ_FK1_1                                    
-- ==============================================================
ALTER TABLE AD_ACQ 
	ADD (CONSTRAINT AD_ACQ_FK1_1 FOREIGN KEY(AD_OPEDOM_ID) 
	REFERENCES AD_OPEDOM(AD_OPEDOM_ID));

