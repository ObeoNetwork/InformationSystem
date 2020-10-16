-- ==============================================================
--  Index : IDX1Renamed                                    
-- ==============================================================
ALTER TABLE T7_3 DROP INDEX IDX1;
CREATE UNIQUE INDEX IDX1Renamed ON S7.T7_3(C1);

-- ==============================================================
--  Index : IDX1                                    
-- ==============================================================
ALTER TABLE T7_4 DROP INDEX IDX1;
CREATE INDEX IDX1 ON S7.T7_4(C1);

-- ==============================================================
--  Index : IDX1                                    
-- ==============================================================
ALTER TABLE T7_5 DROP INDEX IDX1;
CREATE INDEX IDX1 ON S7.T7_5();

-- ==============================================================
--  Index : IDX1                                    
-- ==============================================================
ALTER TABLE T7_6 DROP INDEX IDX1;
CREATE INDEX IDX1 ON S7.T7_6(C1);

-- ==============================================================
--  Index : IDX1                                    
-- ==============================================================
ALTER TABLE T7_7 DROP INDEX IDX1;
CREATE INDEX IDX1 ON S7.T7_7(C2);
