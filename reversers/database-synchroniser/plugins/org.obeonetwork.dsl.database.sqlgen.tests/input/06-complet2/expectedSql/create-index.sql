-- ==============================================================
--  Index : IDX1                                    
-- ==============================================================
CREATE UNIQUE INDEX IDX1 ON T1(C2)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_ADDSCHEMA
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
CREATE INDEX IDX1 ON T7_2(C3)
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

