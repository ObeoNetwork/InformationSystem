-- ==============================================================
--  Constraint : UnitPriceGreaterThanZero                                    
-- ==============================================================
ALTER TABLE PRODUCTS DROP CONSTRAINT UnitPriceGreaterThanZero;
ALTER TABLE PRODUCTS ADD CONSTRAINT UnitPriceGreaterThanZero 
	CHECK(UNITPRICE>10);