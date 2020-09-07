-- ==============================================================
--  Table : AW_ADRESSE                                    
-- ==============================================================

DROP TABLE IF EXISTS PUBLIC.AW_ADRESSE CASCADE;
CREATE TABLE PUBLIC.AW_ADRESSE(
    adresse_id INT8 NOT NULL,
    rue VARCHAR(100) NOT NULL,
    codepostal <undefined> NOT NULL,
    ville VARCHAR(100) NOT NULL,
    personne_id INT8 NOT NULL,
    xdmaj TIMESTAMP NULL,
    xtopsup BOOL NOT NULL
);

COMMENT ON TABLE PUBLIC.AW_ADRESSE IS 'une adresse de personne';
COMMENT ON COLUMN PUBLIC.AW_ADRESSE.rue IS 'la rue de l''adresse';

COMMENT ON COLUMN PUBLIC.AW_ADRESSE.ville IS 'la ville de l''adresse';

-- ==============================================================
--  Table : AW_COMPETENCE                                    
-- ==============================================================

DROP TABLE IF EXISTS PUBLIC.AW_COMPETENCE CASCADE;
CREATE TABLE PUBLIC.AW_COMPETENCE(
    competence_id INT8 NOT NULL,
    libelle VARCHAR(100) NOT NULL,
    xdmaj TIMESTAMP NULL,
    xtopsup BOOL NOT NULL
);

COMMENT ON TABLE PUBLIC.AW_COMPETENCE IS 'une comp‚tence';
COMMENT ON COLUMN PUBLIC.AW_COMPETENCE.libelle IS 'le libell‚ de la comp‚tence';

-- ==============================================================
--  Table : AW_COMPETENCE_ID                                    
-- ==============================================================

DROP TABLE IF EXISTS PUBLIC.AW_COMPETENCE_ID CASCADE;
CREATE TABLE PUBLIC.AW_COMPETENCE_ID(
    personne_id INT8 NOT NULL,
    competence_id INT8 NOT NULL
);

-- ==============================================================
--  Table : AW_COMPETENCE_PERSO                                    
-- ==============================================================

DROP TABLE IF EXISTS PUBLIC.AW_COMPETENCE_PERSO CASCADE;
CREATE TABLE PUBLIC.AW_COMPETENCE_PERSO(
    competence_perso_id INT8 NOT NULL,
    libelle VARCHAR(100) NULL,
    xdmaj TIMESTAMP NULL,
    xtopsup BOOL NOT NULL
);

-- ==============================================================
--  Table : AW_MAIL                                    
-- ==============================================================

DROP TABLE IF EXISTS PUBLIC.AW_MAIL CASCADE;
CREATE TABLE PUBLIC.AW_MAIL(
    mail_id INT8 NOT NULL,
    pro BOOL NOT NULL,
    mail VARCHAR(100) NOT NULL,
    personne_id INT8 NOT NULL,
    xdmaj TIMESTAMP NULL,
    xtopsup BOOL NOT NULL
);

-- ==============================================================
--  Table : AW_PERMISSION                                    
-- ==============================================================

DROP TABLE IF EXISTS PUBLIC.AW_PERMISSION CASCADE;
CREATE TABLE PUBLIC.AW_PERMISSION(
    permission_id INT8 NOT NULL,
    nompermission VARCHAR(100) NOT NULL,
    xdmaj TIMESTAMP NULL,
    xtopsup BOOL NOT NULL
);


COMMENT ON COLUMN PUBLIC.AW_PERMISSION.nompermission IS 'le nom de la permission';

-- ==============================================================
--  Table : AW_PERSONNE                                    
-- ==============================================================

DROP TABLE IF EXISTS PUBLIC.AW_PERSONNE CASCADE;
CREATE TABLE PUBLIC.AW_PERSONNE(
    personne_id INT8 NOT NULL,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NULL,
    civil BOOL NOT NULL,
    date_naissance TIMESTAMP NULL,
    salaire NUMERIC(14, 2) NULL,
    version TIMESTAMP NOT NULL,
    grade_id INT8 NULL,
    xdmaj TIMESTAMP NULL,
    xtopsup BOOL NOT NULL
);

COMMENT ON TABLE PUBLIC.AW_PERSONNE IS 'Une personne';
COMMENT ON COLUMN PUBLIC.AW_PERSONNE.nom IS 'le nom de la personne';
COMMENT ON COLUMN PUBLIC.AW_PERSONNE.prenom IS 'le pr‚nom de la personne';
COMMENT ON COLUMN PUBLIC.AW_PERSONNE.civil IS 'indicateur si la personne est civile ou non';
COMMENT ON COLUMN PUBLIC.AW_PERSONNE.date_naissance IS 'la date de naissance de la personne';

-- ==============================================================
--  Table : AW_PERSONNE_N_COMPETENCE_PERSO                                    
-- ==============================================================

DROP TABLE IF EXISTS PUBLIC.AW_PERSONNE_N_COMPETENCE_PERSO CASCADE;
CREATE TABLE PUBLIC.AW_PERSONNE_N_COMPETENCE_PERSO(
    personne_n_competence_perso_id INT8 NOT NULL,
    competenceperso_id INT8 NOT NULL,
    personne_id INT8 NOT NULL,
    xdmaj TIMESTAMP NULL,
    xtopsup BOOL NOT NULL
);

-- ==============================================================
--  Table : AW_ROLE                                    
-- ==============================================================

DROP TABLE IF EXISTS PUBLIC.AW_ROLE CASCADE;
CREATE TABLE PUBLIC.AW_ROLE(
    role_id INT8 NOT NULL,
    nom_role VARCHAR(100) NOT NULL,
    xdmaj TIMESTAMP NULL,
    xtopsup BOOL NOT NULL
);


COMMENT ON COLUMN PUBLIC.AW_ROLE.nom_role IS 'le nom du r“le';

-- ==============================================================
--  Table : AW_ROLE_UTILISATEUR                                    
-- ==============================================================

DROP TABLE IF EXISTS PUBLIC.AW_ROLE_UTILISATEUR CASCADE;
CREATE TABLE PUBLIC.AW_ROLE_UTILISATEUR(
    utilisateur_id INT8 NOT NULL,
    role_id INT8 NOT NULL
);

-- ==============================================================
--  Table : AW_ROLEPERMISSION                                    
-- ==============================================================

DROP TABLE IF EXISTS PUBLIC.AW_ROLEPERMISSION CASCADE;
CREATE TABLE PUBLIC.AW_ROLEPERMISSION(
    role_id INT8 NOT NULL,
    permission_id INT8 NOT NULL
);

-- ==============================================================
--  Table : AW_TELEPHONE                                    
-- ==============================================================

DROP TABLE IF EXISTS PUBLIC.AW_TELEPHONE CASCADE;
CREATE TABLE PUBLIC.AW_TELEPHONE(
    telephone_id INT8 NOT NULL,
    pro BOOL NOT NULL,
    numero VARCHAR(100) NOT NULL,
    personne_id INT8 NOT NULL,
    xdmaj TIMESTAMP NULL,
    xtopsup BOOL NOT NULL
);

COMMENT ON TABLE PUBLIC.AW_TELEPHONE IS 'Contact t‚l‚phonique';

-- ==============================================================
--  Table : AW_UTILISATEUR                                    
-- ==============================================================

DROP TABLE IF EXISTS PUBLIC.AW_UTILISATEUR CASCADE;
CREATE TABLE PUBLIC.AW_UTILISATEUR(
    utilisateur_id INT8 NOT NULL,
    identifiant VARCHAR(100) NOT NULL,
    mdp VARCHAR(100) NOT NULL,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    mdph VARCHAR(100) NOT NULL,
    xdmaj TIMESTAMP NULL,
    xtopsup BOOL NOT NULL
);


COMMENT ON COLUMN PUBLIC.AW_UTILISATEUR.identifiant IS 'l''identifiant de connexion de l''utilisateur';
COMMENT ON COLUMN PUBLIC.AW_UTILISATEUR.mdp IS 'le mot de passe de connexion de l''utilisateur';
COMMENT ON COLUMN PUBLIC.AW_UTILISATEUR.nom IS 'le nom de l''utilisateur';
COMMENT ON COLUMN PUBLIC.AW_UTILISATEUR.prenom IS 'le pr‚nom de l''utilisateur';
COMMENT ON COLUMN PUBLIC.AW_UTILISATEUR.email IS 'l''adresse email de l''utilisateur';

