-- ==============================================================
--  Table : EMPLOYEES                                    
-- ==============================================================
ALTER TABLE EMPLOYEES ADD NewColumn VARCHAR(20) NOT NULL;
COMMENT ON COLUMN EMPLOYEES.NewColumn IS 'A Comment';

