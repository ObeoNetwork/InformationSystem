-- ==============================================================
--  Index : IX_EMPLOYEES_FIRSTNAME_LASTNAME                                    
-- ==============================================================
CREATE INDEX IX_EMPLOYEES_FIRSTNAME_LASTNAME ON EMPLOYEES(FIRSTNAME, LASTNAME)
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

