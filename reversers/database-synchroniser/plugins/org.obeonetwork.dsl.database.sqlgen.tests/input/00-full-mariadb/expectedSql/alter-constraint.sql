-- ==============================================================
--  Constraint : Constraint6_2                                    
-- ==============================================================
ALTER TABLE TABLE6 DROP CONSTRAINT Constraint6_2;
ALTER TABLE TABLE6 ADD CONSTRAINT Constraint6_2 
	CHECK(Expression constraint 6_2 modifiee);

