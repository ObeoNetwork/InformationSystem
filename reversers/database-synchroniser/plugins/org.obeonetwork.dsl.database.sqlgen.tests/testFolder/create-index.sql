-- ==============================================================
--  Index : IX_EMPLOYEES_LASTNAME                                    
-- ==============================================================
CREATE UNIQUE INDEX IX_EMPLOYEES_LASTNAME ON EMPLOYEES(LASTNAME)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_NORTHWIND
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

