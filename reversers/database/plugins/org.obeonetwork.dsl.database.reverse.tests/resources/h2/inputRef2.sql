-- https://code.google.com/p/spi4j/
-- https://drive.google.com/file/d/0B_CIqBpjpa16R3RMZE05MFpsS0k/edit?pli=1
-- /appwhite1/appwhite1-server/src/main/sql

-- Script ecrit à la main pour la creation d'indexes specifiques (indexes uniques et indexes pour les performances des recherches)

-- index pour recherches par nom
create index AW_PERSONNE_NOM_IDX on AW_PERSONNE (NOM);