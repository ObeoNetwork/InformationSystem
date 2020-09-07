-- ==============================================================
--  Constraint : CHK1                                    
-- ==============================================================
ALTER TABLE ADDSCHEMA.T1 ADD CONSTRAINT CHK1 
	CHECK(expression);

-- ==============================================================
--  Constraint : CHK1Add                                    
-- ==============================================================
ALTER TABLE ALTERSCHEMARENAMED.T1 ADD CONSTRAINT CHK1Add 
	CHECK(expression);

