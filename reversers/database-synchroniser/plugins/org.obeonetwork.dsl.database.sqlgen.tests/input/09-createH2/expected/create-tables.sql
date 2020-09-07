-- ==============================================================
--  Table : AW_ADRESSE                                    
-- ==============================================================

DROP TABLE PUBLIC.AW_ADRESSE;
CREATE TABLE PUBLIC.AW_ADRESSE(
    ADRESSE_ID DECIMAL(19, 0) NOT NULL,
    RUE VARCHAR(100) NOT NULL,
    CODEPOSTAL DECIMAL(5, 0) NOT NULL,
    VILLE VARCHAR(100) NOT NULL,
    PERSONNE_ID DECIMAL(19, 0) NOT NULL,
    XDMAJ TIMESTAMP NULL,
    XTOPSUP DECIMAL(1, 0) DEFAULT 0 NOT NULL
);

COMMENT ON TABLE PUBLIC.AW_ADRESSE IS 'une adresse de personne';
COMMENT ON COLUMN PUBLIC.AW_ADRESSE.RUE IS 'la rue de l''adresse';

COMMENT ON COLUMN PUBLIC.AW_ADRESSE.VILLE IS 'la ville de l''adresse';

-- ==============================================================
--  Table : AW_COMPETENCE                                    
-- ==============================================================

DROP TABLE PUBLIC.AW_COMPETENCE;
CREATE TABLE PUBLIC.AW_COMPETENCE(
    COMPETENCE_ID DECIMAL(19, 0) NOT NULL,
    LIBELLE VARCHAR(100) NOT NULL,
    XDMAJ TIMESTAMP NULL,
    XTOPSUP DECIMAL(1, 0) DEFAULT 0 NOT NULL
);

COMMENT ON TABLE PUBLIC.AW_COMPETENCE IS 'une compétence';
COMMENT ON COLUMN PUBLIC.AW_COMPETENCE.LIBELLE IS 'le libellé de la compétence';

-- ==============================================================
--  Table : AW_COMPETENCE_ID                                    
-- ==============================================================

DROP TABLE PUBLIC.AW_COMPETENCE_ID;
CREATE TABLE PUBLIC.AW_COMPETENCE_ID(
    PERSONNE_ID DECIMAL(19, 0) NOT NULL,
    COMPETENCE_ID DECIMAL(19, 0) NOT NULL
);

-- ==============================================================
--  Table : AW_COMPETENCE_PERSO                                    
-- ==============================================================

DROP TABLE PUBLIC.AW_COMPETENCE_PERSO;
CREATE TABLE PUBLIC.AW_COMPETENCE_PERSO(
    COMPETENCE_PERSO_ID DECIMAL(19, 0) NOT NULL,
    LIBELLE VARCHAR(100) NULL,
    XDMAJ TIMESTAMP NULL,
    XTOPSUP DECIMAL(1, 0) DEFAULT 0 NOT NULL
);

-- ==============================================================
--  Table : AW_MAIL                                    
-- ==============================================================

DROP TABLE PUBLIC.AW_MAIL;
CREATE TABLE PUBLIC.AW_MAIL(
    MAIL_ID DECIMAL(19, 0) NOT NULL,
    PRO DECIMAL(1, 0) NOT NULL,
    MAIL VARCHAR(100) NOT NULL,
    PERSONNE_ID DECIMAL(19, 0) NOT NULL,
    XDMAJ TIMESTAMP NULL,
    XTOPSUP DECIMAL(1, 0) DEFAULT 0 NOT NULL
);

-- ==============================================================
--  Table : AW_PERMISSION                                    
-- ==============================================================

DROP TABLE PUBLIC.AW_PERMISSION;
CREATE TABLE PUBLIC.AW_PERMISSION(
    PERMISSION_ID DECIMAL(19, 0) NOT NULL,
    NOMPERMISSION VARCHAR(100) NOT NULL,
    XDMAJ TIMESTAMP NULL,
    XTOPSUP DECIMAL(1, 0) DEFAULT 0 NOT NULL
);


COMMENT ON COLUMN PUBLIC.AW_PERMISSION.NOMPERMISSION IS 'le nom de la permission';

-- ==============================================================
--  Table : AW_PERSONNE                                    
-- ==============================================================

DROP TABLE PUBLIC.AW_PERSONNE;
CREATE TABLE PUBLIC.AW_PERSONNE(
    PERSONNE_ID DECIMAL(19, 0) NOT NULL,
    NOM VARCHAR(100) NOT NULL,
    PRENOM VARCHAR(100) NULL,
    CIVIL DECIMAL(1, 0) NOT NULL,
    DATE_NAISSANCE TIMESTAMP NULL,
    SALAIRE DECIMAL(14, 2) NULL,
    VERSION TIMESTAMP NOT NULL,
    GRADE_ID DECIMAL(19, 0) NULL,
    XDMAJ TIMESTAMP NULL,
    XTOPSUP DECIMAL(1, 0) DEFAULT 0 NOT NULL
);

COMMENT ON TABLE PUBLIC.AW_PERSONNE IS 'Une personne';
COMMENT ON COLUMN PUBLIC.AW_PERSONNE.NOM IS 'le nom de la personne';
COMMENT ON COLUMN PUBLIC.AW_PERSONNE.PRENOM IS 'le prénom de la personne';
COMMENT ON COLUMN PUBLIC.AW_PERSONNE.CIVIL IS 'indicateur si la personne est civile ou non';
COMMENT ON COLUMN PUBLIC.AW_PERSONNE.DATE_NAISSANCE IS 'la date de naissance de la personne';

-- ==============================================================
--  Table : AW_PERSONNE_N_COMPETENCE_PERSO                                    
-- ==============================================================

DROP TABLE PUBLIC.AW_PERSONNE_N_COMPETENCE_PERSO;
CREATE TABLE PUBLIC.AW_PERSONNE_N_COMPETENCE_PERSO(
    PERSONNE_N_COMPETENCE_PERSO_ID DECIMAL(19, 0) NOT NULL AUTO_INCREMENT,
    COMPETENCEPERSO_ID DECIMAL(19, 0) NOT NULL,
    PERSONNE_ID DECIMAL(19, 0) NOT NULL,
    XDMAJ TIMESTAMP NULL,
    XTOPSUP DECIMAL(1, 0) DEFAULT 0 NOT NULL
);

-- ==============================================================
--  Table : AW_ROLE                                    
-- ==============================================================

DROP TABLE PUBLIC.AW_ROLE;
CREATE TABLE PUBLIC.AW_ROLE(
    ROLE_ID DECIMAL(19, 0) NOT NULL,
    NOM_ROLE VARCHAR(100) NOT NULL,
    XDMAJ TIMESTAMP NULL,
    XTOPSUP DECIMAL(1, 0) DEFAULT 0 NOT NULL
);


COMMENT ON COLUMN PUBLIC.AW_ROLE.NOM_ROLE IS 'le nom du rôle';

-- ==============================================================
--  Table : AW_ROLEPERMISSION                                    
-- ==============================================================

DROP TABLE PUBLIC.AW_ROLEPERMISSION;
CREATE TABLE PUBLIC.AW_ROLEPERMISSION(
    ROLE_ID DECIMAL(19, 0) NOT NULL,
    PERMISSION_ID DECIMAL(19, 0) NOT NULL
);

-- ==============================================================
--  Table : AW_ROLE_UTILISATEUR                                    
-- ==============================================================

DROP TABLE PUBLIC.AW_ROLE_UTILISATEUR;
CREATE TABLE PUBLIC.AW_ROLE_UTILISATEUR(
    UTILISATEUR_ID DECIMAL(19, 0) NOT NULL,
    ROLE_ID DECIMAL(19, 0) NOT NULL
);

-- ==============================================================
--  Table : AW_TELEPHONE                                    
-- ==============================================================

DROP TABLE PUBLIC.AW_TELEPHONE;
CREATE TABLE PUBLIC.AW_TELEPHONE(
    TELEPHONE_ID DECIMAL(19, 0) NOT NULL,
    PRO DECIMAL(1, 0) NOT NULL,
    NUMERO VARCHAR(100) NOT NULL,
    PERSONNE_ID DECIMAL(19, 0) NOT NULL,
    XDMAJ TIMESTAMP NULL,
    XTOPSUP DECIMAL(1, 0) DEFAULT 0 NOT NULL
);

COMMENT ON TABLE PUBLIC.AW_TELEPHONE IS 'Contact téléphonique';

-- ==============================================================
--  Table : AW_UTILISATEUR                                    
-- ==============================================================

DROP TABLE PUBLIC.AW_UTILISATEUR;
CREATE TABLE PUBLIC.AW_UTILISATEUR(
    UTILISATEUR_ID DECIMAL(19, 0) NOT NULL,
    IDENTIFIANT VARCHAR(100) NOT NULL,
    MDP VARCHAR(100) NOT NULL,
    NOM VARCHAR(100) NOT NULL,
    PRENOM VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    MDPH VARCHAR(100) NOT NULL,
    XDMAJ TIMESTAMP NULL,
    XTOPSUP DECIMAL(1, 0) DEFAULT 0 NOT NULL
);


COMMENT ON COLUMN PUBLIC.AW_UTILISATEUR.IDENTIFIANT IS 'l''identifiant de connexion de l''utilisateur';
COMMENT ON COLUMN PUBLIC.AW_UTILISATEUR.MDP IS 'le mot de passe de connexion de l''utilisateur';
COMMENT ON COLUMN PUBLIC.AW_UTILISATEUR.NOM IS 'le nom de l''utilisateur';
COMMENT ON COLUMN PUBLIC.AW_UTILISATEUR.PRENOM IS 'le prénom de l''utilisateur';
COMMENT ON COLUMN PUBLIC.AW_UTILISATEUR.EMAIL IS 'l''adresse email de l''utilisateur';

