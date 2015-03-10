-- ==============================================================
--  Table : T1                                    
-- ==============================================================
DROP PUBLIC SYNONYM T1;

DROP TABLE T1;
CREATE TABLE T1(

)
storage
(
    initial 10K
    next 10K
    minextents 1
    maxextents unlimited
    pctincrease 50
    freelists 1
    freelist groups 1
    optimal NULL
    buffer_pool default
)
tablespace TS_DATA_S1;

CREATE PUBLIC SYNONYM T1 FOR S1.T1;

