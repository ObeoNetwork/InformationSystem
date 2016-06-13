-- ==============================================================
--  Table : NOUVELLE                                    
-- ==============================================================


DROP TABLE NOUVELLE;
CREATE TABLE NOUVELLE(
    id Numérique(20, 2) NOT NULL,
    FK_column Décimal(10, 0) NOT NULL
)
;



COMMENT ON TABLE Nouvelle IS 'nouvelle table';

