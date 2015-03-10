-- ==============================================================
--  Index : IDX1                                    
-- ==============================================================
ALTER TABLE T7_7 DROP INDEX IDX1;
CREATE INDEX IDX1 ON T7_7(C2)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_S7
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : IDX1                                    
-- ==============================================================
ALTER TABLE T7_6 DROP INDEX IDX1;
CREATE INDEX IDX1 ON T7_6(C1)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_S7
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : IDX1                                    
-- ==============================================================
ALTER TABLE T7_5 DROP INDEX IDX1;
CREATE INDEX IDX1 ON T7_5()
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_S7
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : IDX1                                    
-- ==============================================================
ALTER TABLE T7_4 DROP INDEX IDX1;
CREATE INDEX IDX1 ON T7_4(C1)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_S7
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : IDX1Renamed                                    
-- ==============================================================
ALTER TABLE T7_3 DROP INDEX IDX1;
CREATE UNIQUE INDEX IDX1Renamed ON T7_3(C1)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_S7
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

