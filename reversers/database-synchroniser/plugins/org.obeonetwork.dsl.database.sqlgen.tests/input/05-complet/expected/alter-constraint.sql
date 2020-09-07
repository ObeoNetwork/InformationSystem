-- ==============================================================
--  Constraint : A_CHK                                    
-- ==============================================================
ALTER TABLE T2DSQD DROP CONSTRAINT A_CHK;
ALTER TABLE T2DSQD ADD CONSTRAINT A_CHK 
	CHECK(expression modifiée);

