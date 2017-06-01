-- ==============================================================
--  Table : T1                                    
-- ==============================================================
DROP PUBLIC SYNONYM T1;
DROP TABLE S1.T1 CASCADE;
CREATE TABLE S1.T1(

);
CREATE PUBLIC SYNONYM T1 FOR S1.T1;

