-- ==============================================================
--  Table : ADDTABLE                                    
-- ==============================================================

DROP TABLE ADDTABLE;
CREATE TABLE ADDTABLE(
    AddColumn LONG NOT NULL
);

-- ==============================================================
--  Table : T1                                    
-- ==============================================================
DROP PUBLIC SYNONYM T1;
DROP TABLE ADDSCHEMA.T1;
CREATE TABLE ADDSCHEMA.T1(
    C1 INTEGER NOT NULL,
    C2 INTEGER NOT NULL,
    C3_C1 INTEGER NOT NULL
);
CREATE PUBLIC SYNONYM T1 FOR ADDSCHEMA.T1;

-- ==============================================================
--  Table : T2                                    
-- ==============================================================
DROP PUBLIC SYNONYM T2;
DROP TABLE ADDSCHEMA.T2;
CREATE TABLE ADDSCHEMA.T2(
    C1 INTEGER NOT NULL
);
CREATE PUBLIC SYNONYM T2 FOR ADDSCHEMA.T2;

