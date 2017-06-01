-- ==============================================================
--  Constraint : A_cHK                                    
-- ==============================================================
ALTER TABLE NOUVELLE ADD CONSTRAINT A_cHK 
	CHECK(nouveau
);

-- ==============================================================
--  Constraint : B_CHK                                    
-- ==============================================================
ALTER TABLE T2DSQD ADD CONSTRAINT B_CHK 
	CHECK(nouveau);

