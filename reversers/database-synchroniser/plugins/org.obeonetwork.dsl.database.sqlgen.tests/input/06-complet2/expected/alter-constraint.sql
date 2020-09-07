-- ==============================================================
--  Constraint : CHK2Update                                    
-- ==============================================================
ALTER TABLE ALTERSCHEMA.T1 DROP CONSTRAINT CHK2Update;
ALTER TABLE ALTERSCHEMARENAMED.T1 ADD CONSTRAINT CHK2Update 
	CHECK(modified expression);

