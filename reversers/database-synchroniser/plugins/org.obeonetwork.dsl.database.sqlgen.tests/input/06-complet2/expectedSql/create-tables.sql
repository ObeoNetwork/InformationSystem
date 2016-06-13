-- ==============================================================
--  Table : T1                                    
-- ==============================================================
DROP PUBLIC SYNONYM T1;

DROP TABLE T1;
CREATE TABLE T1(
    C1 INT NOT NULL,
    C2 INT NOT NULL,
    C3_C1 INT NOT NULL
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
tablespace TS_DATA_ADDSCHEMA;

CREATE PUBLIC SYNONYM T1 FOR ADDSCHEMA.T1;

-- ==============================================================
--  Table : T2                                    
-- ==============================================================
DROP PUBLIC SYNONYM T2;

DROP TABLE T2;
CREATE TABLE T2(
    C1 INT NOT NULL
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
tablespace TS_DATA_ADDSCHEMA;

CREATE PUBLIC SYNONYM T2 FOR ADDSCHEMA.T2;

-- ==============================================================
--  Table : ADDTABLE                                    
-- ==============================================================


DROP TABLE ADDTABLE;
CREATE TABLE ADDTABLE(
    AddColumn INTEGER NOT NULL
)
;

