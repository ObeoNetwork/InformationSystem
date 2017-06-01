-- ==============================================================
--  Index : Table12_UNIQUE_INDEX                                    
-- ==============================================================
ALTER TABLE TABLE12 DROP INDEX Table12_UNIQUE_INDEX;
CREATE INDEX Table12_UNIQUE_INDEX ON DEMO.TABLE12(col12_1);

