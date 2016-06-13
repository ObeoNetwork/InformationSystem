-- ==============================================================
--  Constraint : CHK2Update                                    
-- ==============================================================
ALTER TABLE T1 DROP CONSTRAINT CHK2Update;
ALTER TABLE T1 ADD CONSTRAINT CHK2Update 
	CHECK(modified expression);

