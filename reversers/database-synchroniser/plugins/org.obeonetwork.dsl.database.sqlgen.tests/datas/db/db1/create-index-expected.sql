-- ==============================================================
--  Index : AD_ACQ_PK1_1                                    
-- ==============================================================
CREATE INDEX AD_ACQ_PK1_1 ON AD_ACQ(AD_ACQ_ID)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_G2D
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : AD_ACQ_FK1_1                                    
-- ==============================================================
CREATE INDEX AD_ACQ_FK1_1 ON AD_ACQ(AD_OPEDOM_ID)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_G2D
  logging
  nosort
  noparallel
  parallel
  (
       1
  );
