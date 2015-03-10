-- ==============================================================
--  Constraint : UnitPriceGreaterThanZero                                    
-- ==============================================================
ALTER TABLE PRODUCTS ADD CONSTRAINT UnitPriceGreaterThanZero 
	CHECK(UNITPRICE>0);