-- ==============================================================
--  Table : GS_SERIE                                    
-- ==============================================================
ALTER TABLE GS.GS_SERIE ALTER COLUMN GS_SERIE_TITRE SET DATA TYPE TEXT;
ALTER TABLE GS.GS_SERIE ALTER COLUMN GS_SERIE_TITRE SET NOT NULL;
ALTER TABLE GS.GS_SERIE ALTER COLUMN GS_SERIE_TITRE DROP DEFAULT;

