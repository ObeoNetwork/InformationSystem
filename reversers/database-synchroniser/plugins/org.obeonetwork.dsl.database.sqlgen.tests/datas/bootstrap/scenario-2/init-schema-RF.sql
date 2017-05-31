/*
sqlplus sys/oracle as SYSDBA
CREATE USER "RF" PROFILE "DEFAULT" IDENTIFIED BY "rf" ACCOUNT UNLOCK;
GRANT "CONNECT" TO "RF";
GRANT ALL PRIVILEGES TO "RF";
connect rf/rf;

select table_name from user_tables;
select synonym_name from user_synonyms;

@/home/oracle/scripts/erase-schema-RF.sql
@/home/oracle/scripts/init-schema-RF.sql

*/
/*==============================================================*/
/* Table : RF_ACTI                                              */
/*==============================================================*/
create table RF_ACTI  (
   RF_ACTI_ID           INTEGER                         not null,
   RF_ACTI_AREA         VARCHAR2(4)                     not null,
   RF_ACTI_REFPRG       VARCHAR2(24)                    not null,
   RF_ACTI_FP_TYPE      VARCHAR2(4),
   RF_ACTI_TRFONC       VARCHAR2(24),
   RF_ACTI_DATEFROM     VARCHAR2(15),
   RF_ACTI_DATETO       VARCHAR2(15),
   RF_ACTI_DATEX        VARCHAR2(15),
   RF_ACTI_DEST         VARCHAR2(16),
   RF_ACTI_RECDEP       VARCHAR2(1),
   RF_ACTI_ETXTSH       VARCHAR2(20),
   RF_ACTI_ETXTLG       VARCHAR2(60),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_ACTI is
'Table des programmes de financement CHORUS.';

comment on column RF_ACTI.RF_ACTI_ID is
'ID du programme de financement CHORUS.';

comment on column RF_ACTI.RF_ACTI_AREA is
'Perimetre financier du programme de financement CHORUS.';

comment on column RF_ACTI.RF_ACTI_REFPRG is
'Programme, activite du programme de financement CHORUS.';

comment on column RF_ACTI.RF_ACTI_FP_TYPE is
'Type du programme de financement CHORUS.';

comment on column RF_ACTI.RF_ACTI_TRFONC is
'Tranche fonctionnelle du programme de financement CHORUS.';

comment on column RF_ACTI.RF_ACTI_DATEFROM is
'Debut de validite du programme de financement CHORUS.';

comment on column RF_ACTI.RF_ACTI_DATETO is
'Fin de validite du programme de financement CHORUS.';

comment on column RF_ACTI.RF_ACTI_DATEX is
'Date d''expiration du programme de financement CHORUS.';

comment on column RF_ACTI.RF_ACTI_DEST is
'Destination du programme de financement CHORUS.';

comment on column RF_ACTI.RF_ACTI_RECDEP is
'Indicateur de recette-depense du programme de financement CHORUS.';

comment on column RF_ACTI.RF_ACTI_ETXTSH is
'Description courte du programme de financement CHORUS.';

comment on column RF_ACTI.RF_ACTI_ETXTLG is
'Description longue du programme de financement CHORUS.';

comment on column RF_ACTI.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_ACTI.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_ACTI
   add constraint RF_ACTI_PK1_1 primary key (RF_ACTI_ID);

alter table RF_ACTI
   add constraint RF_ACTI_UN2_1 unique (RF_ACTI_AREA, RF_ACTI_REFPRG);

grant SELECT on RF_ACTI to PUBLIC;

grant REFERENCES on RF_ACTI to PUBLIC;

grant REFERENCES on RF_ACTI to PUBLIC;

grant SELECT on RF_ACTI to PUBLIC;

/*==============================================================*/
/* Table : RF_ACTIVITE                                          */
/*==============================================================*/
create table RF_ACTIVITE  (
   RF_ACTIVITE_ID       INTEGER                         not null,
   RF_ACTIVITE_COD      VARCHAR2(15)                    not null,
   RF_ACTIVITE_LIB      VARCHAR2(300)                   not null,
   RF_ACTIVITE_LIBA     VARCHAR2(100)                   not null,
   RF_CODMIN_ID         INTEGER                         not null,
   RF_PROG_ID           INTEGER                         not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ACTIVITE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ACTIVITE is
'Table contenant les activites issues du referentiel CHORUS.';

comment on column RF_ACTIVITE.RF_ACTIVITE_ID is
'Identifiant de l''activite';

comment on column RF_ACTIVITE.RF_ACTIVITE_COD is
'Code de l''activite';

comment on column RF_ACTIVITE.RF_ACTIVITE_LIB is
'Libelle de l''activite';

comment on column RF_ACTIVITE.RF_ACTIVITE_LIBA is
'Libelle abrege de l''activite';

comment on column RF_ACTIVITE.RF_CODMIN_ID is
'Identifiant du Code Ministere';

comment on column RF_ACTIVITE.RF_PROG_ID is
'Identifiant du Programme';

comment on column RF_ACTIVITE.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_ACTIVITE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ACTIVITE
   add constraint RF_ACTIVITE_PK1_1 primary key (RF_ACTIVITE_ID);

/*==============================================================*/
/* Index : RF_ACTIVITE_FK1_1                                    */
/*==============================================================*/
create index RF_ACTIVITE_FK1_1 on RF_ACTIVITE (
   RF_CODMIN_ID ASC
);

/*==============================================================*/
/* Index : RF_ACTIVITE_FK1_2                                    */
/*==============================================================*/
create index RF_ACTIVITE_FK1_2 on RF_ACTIVITE (
   RF_PROG_ID ASC
);

grant SELECT on RF_ACTIVITE to PUBLIC;

grant REFERENCES on RF_ACTIVITE to PUBLIC;

grant REFERENCES on RF_ACTIVITE to PUBLIC;

grant SELECT on RF_ACTIVITE to PUBLIC;

/*==============================================================*/
/* Table : RF_ACVT                                              */
/*==============================================================*/
create table RF_ACVT  (
   RF_ACVT_COD          VARCHAR2(1)                     not null,
   RF_ACVT_LIB          VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ACVT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ACVT is
'Activite';

comment on column RF_ACVT.RF_ACVT_COD is
'Code Activite';

comment on column RF_ACVT.RF_ACVT_LIB is
'Libelle Activite';

comment on column RF_ACVT.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_ACVT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ACVT
   add constraint RF_ACVT_PK1_1 primary key (RF_ACVT_COD);

grant SELECT on RF_ACVT to PUBLIC;

grant REFERENCES on RF_ACVT to PUBLIC;

grant REFERENCES on RF_ACVT to PUBLIC;

grant SELECT on RF_ACVT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_AFFAERO                                           */
/*==============================================================*/
create table RF_AFFAERO  (
   RF_AFFAERO_ID        INTEGER                         not null,
   RF_AFFAERO_COD       VARCHAR2(1)                     not null,
   RF_AFFAERO_LIB       VARCHAR2(54)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_AFFAERO_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_AFFAERO is
'Affectation aeronautique';

comment on column RF_AFFAERO.RF_AFFAERO_ID is
'Identifiant de l''affectation aeronautique';

comment on column RF_AFFAERO.RF_AFFAERO_COD is
'Code de l''affectation aeronautique';

comment on column RF_AFFAERO.RF_AFFAERO_LIB is
'Libelle de l''affectation aeronautique';

comment on column RF_AFFAERO.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_AFFAERO.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_AFFAERO
   add constraint RF_AFFAERO_PK1_1 primary key (RF_AFFAERO_ID);

/*==============================================================*/
/* Index : RF_AFFAERO_UN2_1                                     */
/*==============================================================*/
create unique index RF_AFFAERO_UN2_1 on RF_AFFAERO (
   RF_AFFAERO_COD ASC,
   RF_XTOPSUP ASC
);

grant SELECT on RF_AFFAERO to PUBLIC;

grant REFERENCES on RF_AFFAERO to PUBLIC;

grant REFERENCES on RF_AFFAERO to PUBLIC;

grant SELECT on RF_AFFAERO to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_AFFECT                                            */
/*==============================================================*/
create table RF_AFFECT  (
   RF_AFFECT_ID         INTEGER                         not null,
   RF_AFFECT_COD        VARCHAR2(2)                     not null,
   RF_AFFECT_LIB        VARCHAR2(100),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_AFFECT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_AFFECT is
'Affectataire';

comment on column RF_AFFECT.RF_AFFECT_ID is
'Identifiant affectataire';

comment on column RF_AFFECT.RF_AFFECT_COD is
'Code affectataire';

comment on column RF_AFFECT.RF_AFFECT_LIB is
'Libelle affectataire';

comment on column RF_AFFECT.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_AFFECT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_AFFECT
   add constraint RF_AFFECT_PK1_1 primary key (RF_AFFECT_ID);

/*==============================================================*/
/* Index : RF_AFFECT_UN1_1                                      */
/*==============================================================*/
create unique index RF_AFFECT_UN1_1 on RF_AFFECT (
   RF_AFFECT_COD ASC
);

grant SELECT on RF_AFFECT to PUBLIC;

grant REFERENCES on RF_AFFECT to PUBLIC;

grant REFERENCES on RF_AFFECT to PUBLIC;

grant SELECT on RF_AFFECT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_AFFSJCT                                           */
/*==============================================================*/
create table RF_AFFSJCT  (
   RF_AFFSJCT_ID        INTEGER                         not null,
   RF_AFFSJCT_LIB       VARCHAR2(30)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_AFFSJCT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_AFFSJCT is
'Contient:
Defense
Aviation civile';

comment on column RF_AFFSJCT.RF_AFFSJCT_ID is
'Identifiant de l''affectataire sous jacent';

comment on column RF_AFFSJCT.RF_AFFSJCT_LIB is
'Libelle affectataire sous jacent';

comment on column RF_AFFSJCT.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_AFFSJCT.RF_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

alter table RF_AFFSJCT
   add constraint RF_AFFSJCT_PK1_1 primary key (RF_AFFSJCT_ID);

grant SELECT on RF_AFFSJCT to PUBLIC;

grant REFERENCES on RF_AFFSJCT to PUBLIC;

grant REFERENCES on RF_AFFSJCT to PUBLIC;

grant SELECT on RF_AFFSJCT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ANGE                                              */
/*==============================================================*/
create table RF_ANGE  (
   RF_ANGE_ANNEE        VARCHAR2(4)                     not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ANGE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ANGE is
'Annee de gestion';

comment on column RF_ANGE.RF_ANGE_ANNEE is
'Annee de gestion N';

comment on column RF_ANGE.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_ANGE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ANGE
   add constraint RF_ANGE_PK1_1 primary key (RF_ANGE_ANNEE);

grant SELECT on RF_ANGE to PUBLIC;

grant REFERENCES on RF_ANGE to PUBLIC;

grant REFERENCES on RF_ANGE to PUBLIC;

grant SELECT on RF_ANGE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ANT                                               */
/*==============================================================*/
create table RF_ANT  (
   RF_ANT_ID            INTEGER                         not null,
   RF_BDD_ID            INTEGER,
   RF_ANT_COD           VARCHAR2(10)                    not null,
   RF_ANT_LIB           VARCHAR2(150)                   not null,
   RF_ANT_NIVEAU        INTEGER,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ANT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ANT is
'Table des antennes';

comment on column RF_ANT.RF_ANT_ID is
'Identifiant de l''antenne';

comment on column RF_ANT.RF_BDD_ID is
'Base de defense intermediaire de l''antenne';

comment on column RF_ANT.RF_ANT_COD is
'Code de l''antenne';

comment on column RF_ANT.RF_ANT_LIB is
'Libelle de l''antenne';

comment on column RF_ANT.RF_ANT_NIVEAU is
'Niveau hierarchique de l''antenne';

comment on column RF_ANT.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_ANT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ANT
   add constraint RF_ANT_PK1_1 primary key (RF_ANT_ID);

grant SELECT on RF_ANT to PUBLIC;

grant SELECT on RF_ANT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_APE                                               */
/*==============================================================*/
create table RF_APE  (
   RF_APE_COD           VARCHAR2(5)                     not null,
   RF_APE_LIB           VARCHAR2(80)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_APE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_APE is
'Code activite principale exercee';

comment on column RF_APE.RF_APE_COD is
'Code d''activite principale exercee';

comment on column RF_APE.RF_APE_LIB is
'Clair d''activite principale exercee';

comment on column RF_APE.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_APE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_APE
   add constraint RF_APE_PK1_1 primary key (RF_APE_COD);

grant SELECT on RF_APE to PUBLIC;

grant REFERENCES on RF_APE to PUBLIC;

grant REFERENCES on RF_APE to PUBLIC;

grant SELECT on RF_APE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ARE                                               */
/*==============================================================*/
create table RF_ARE  (
   RF_ARE_ID            INTEGER                         not null,
   RF_AFFECT_ID         INTEGER                         not null,
   RF_ARE_COD           VARCHAR2(5)                     not null,
   RF_ARE_LIB           VARCHAR2(200)                   not null,
   RF_ARE_LIBA          VARCHAR2(50),
   RF_ARE_TYPE          VARCHAR2(5),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ARE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_ARE_MPA           VARCHAR2(50)
);

comment on table RF_ARE is
'Table de reference
Les 2 premiers caracteres du code identifient le ministere d''appartenance

Modif le 20/02/2007 feretdi longueur lib passe de 20 a 100 afin de pouvoir charge les donnees venant du TGPE';

comment on column RF_ARE.RF_ARE_ID is
'Identifiant de l''attributaire';

comment on column RF_ARE.RF_AFFECT_ID is
'Identifiant affectataire';

comment on column RF_ARE.RF_ARE_COD is
'Code attrributaire';

comment on column RF_ARE.RF_ARE_LIB is
'Libelle attributaire';

comment on column RF_ARE.RF_ARE_LIBA is
'Libelle abrege';

comment on column RF_ARE.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_ARE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_ARE.RF_ARE_MPA is
'Code MPA';

alter table RF_ARE
   add constraint RF_ARE_PK1_1 primary key (RF_ARE_ID);

/*==============================================================*/
/* Index : RF_ARE_UN1_1                                         */
/*==============================================================*/
create unique index RF_ARE_UN1_1 on RF_ARE (
   RF_ARE_COD ASC
);

/*==============================================================*/
/* Index : RF_ARE_FK1_1                                         */
/*==============================================================*/
create index RF_ARE_FK1_1 on RF_ARE (
   RF_AFFECT_ID ASC
);

grant SELECT on RF_ARE to PUBLIC;

grant REFERENCES on RF_ARE to PUBLIC;

grant REFERENCES on RF_ARE to PUBLIC;

grant SELECT on RF_ARE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ARME                                              */
/*==============================================================*/
create table RF_ARME  (
   RF_ARME_ID           INTEGER                         not null,
   RF_ARMEE_ID          INTEGER                         not null,
   RF_ARME_COD          VARCHAR2(5)                     not null,
   RF_ARME_LIB          VARCHAR2(80),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ARME_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ARME is
'Table des armes, concerne les PM';

comment on column RF_ARME.RF_ARME_ID is
'Identifiant de l''arme';

comment on column RF_ARME.RF_ARMEE_ID is
'Identifiant de l''armee';

comment on column RF_ARME.RF_ARME_COD is
'Abreviation de l''arme ou service';

comment on column RF_ARME.RF_ARME_LIB is
'Libelle de l''arme';

comment on column RF_ARME.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_ARME.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ARME
   add constraint RF_ARME_PK1_1 primary key (RF_ARME_ID);

/*==============================================================*/
/* Index : RF_ARME_FK1_1                                        */
/*==============================================================*/
create index RF_ARME_FK1_1 on RF_ARME (
   RF_ARMEE_ID ASC
);

/*==============================================================*/
/* Index : RF_ARME_UN1_1                                        */
/*==============================================================*/
create unique index RF_ARME_UN1_1 on RF_ARME (
   RF_ARME_COD ASC
);

grant SELECT on RF_ARME to PUBLIC;

grant REFERENCES on RF_ARME to PUBLIC;

grant REFERENCES on RF_ARME to PUBLIC;

grant SELECT on RF_ARME to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ARMEE                                             */
/*==============================================================*/
create table RF_ARMEE  (
   RF_ARMEE_ID          INTEGER                         not null,
   RF_ARMEE_COD         VARCHAR2(2)                     not null,
   RF_ARMEE_LIB         VARCHAR2(60),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ARMEE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ARMEE is
'Table des Armees';

comment on column RF_ARMEE.RF_ARMEE_ID is
'Identifiant de l''armee';

comment on column RF_ARMEE.RF_ARMEE_COD is
'Code de l''armee';

comment on column RF_ARMEE.RF_ARMEE_LIB is
'Libelle de l''armee';

comment on column RF_ARMEE.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_ARMEE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ARMEE
   add constraint RF_ARMEE_PK1_1 primary key (RF_ARMEE_ID);

/*==============================================================*/
/* Index : RF_ARMEE_UN1_1                                       */
/*==============================================================*/
create unique index RF_ARMEE_UN1_1 on RF_ARMEE (
   RF_ARMEE_COD ASC
);

grant SELECT on RF_ARMEE to PUBLIC;

grant REFERENCES on RF_ARMEE to PUBLIC;

grant REFERENCES on RF_ARMEE to PUBLIC;

grant SELECT on RF_ARMEE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_AVANC                                             */
/*==============================================================*/
create table RF_AVANC  (
   RF_AVANC_ID          INTEGER                         not null,
   RF_AVANC_COD         VARCHAR2(2)                     not null,
   RF_AVANC_LIB         VARCHAR2(20),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_AVANC_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_AVANC is
'Etre inscrit sur une Liste d''Aptitude ou Tableau d''Avancement';

comment on column RF_AVANC.RF_AVANC_ID is
'Identifiant de l''avancement';

comment on column RF_AVANC.RF_AVANC_COD is
'Code avancement';

comment on column RF_AVANC.RF_AVANC_LIB is
'Libelle avancement';

comment on column RF_AVANC.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_AVANC.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_AVANC
   add constraint RF_AVANC_PK1_1 primary key (RF_AVANC_ID);

/*==============================================================*/
/* Index : RF_AVANC_UN1_1                                       */
/*==============================================================*/
create unique index RF_AVANC_UN1_1 on RF_AVANC (
   RF_AVANC_COD ASC
);

grant SELECT on RF_AVANC to PUBLIC;

grant REFERENCES on RF_AVANC to PUBLIC;

grant REFERENCES on RF_AVANC to PUBLIC;

grant SELECT on RF_AVANC to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_AXE1                                              */
/*==============================================================*/
create table RF_AXE1  (
   RF_AXE1_ID           INTEGER                         not null,
   RF_AXE1_MIN1         VARCHAR2(22)                    not null,
   RF_AXE1_CODMIN       VARCHAR2(5),
   RF_AXE1_ETXTMD       VARCHAR2(40),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_AXE1 is
'Referentiel CHORUS de l''axe libre 1 CHORUS.';

comment on column RF_AXE1.RF_AXE1_ID is
'ID de l''axe.';

comment on column RF_AXE1.RF_AXE1_MIN1 is
'Axe ministeriel 1.';

comment on column RF_AXE1.RF_AXE1_CODMIN is
'Ministere.';

comment on column RF_AXE1.RF_AXE1_ETXTMD is
'Designation.';

comment on column RF_AXE1.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_AXE1.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_AXE1
   add constraint RF_AXE1_PK1_1 primary key (RF_AXE1_ID);

alter table RF_AXE1
   add constraint RF_AXE1_UN1_1 unique (RF_AXE1_MIN1);

grant SELECT on RF_AXE1 to PUBLIC;

grant REFERENCES on RF_AXE1 to PUBLIC;

grant REFERENCES on RF_AXE1 to PUBLIC;

grant SELECT on RF_AXE1 to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_BASE                                              */
/*==============================================================*/
create table RF_BASE  (
   RF_BASE_ID           INTEGER                         not null,
   RF_BASE_COD          VARCHAR2(3)                     not null,
   RF_BASE_LIB          VARCHAR2(25)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_BASE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_BASE is
'Rattachement base aerienne';

comment on column RF_BASE.RF_BASE_ID is
'Identifiant de la base aerienne';

comment on column RF_BASE.RF_BASE_COD is
'Code de la base aerienne';

comment on column RF_BASE.RF_BASE_LIB is
'Libelle de la base aerienne';

comment on column RF_BASE.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_BASE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_BASE
   add constraint RF_BASE_PK1_1 primary key (RF_BASE_ID);

/*==============================================================*/
/* Index : RF_BASE_UN1_1                                        */
/*==============================================================*/
create unique index RF_BASE_UN1_1 on RF_BASE (
   RF_BASE_COD ASC
);

grant SELECT on RF_BASE to PUBLIC;

grant REFERENCES on RF_BASE to PUBLIC;

grant REFERENCES on RF_BASE to PUBLIC;

grant REFERENCES on RF_BASE to PUBLIC;

grant SELECT on RF_BASE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_BDD                                               */
/*==============================================================*/
create table RF_BDD  (
   RF_BDD_ID            INTEGER                         not null,
   RF_ZD_ID             INTEGER                         not null,
   RF_BDD_COD           varchar2(10)                    not null,
   RF_BDD_LIB           VARCHAR2(150)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_BDD_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_BDD_NIVEAU        INTEGER,
   RF_ORGANISME_ID      INTEGER
);

comment on table RF_BDD is
'Table des bases de defenses';

comment on column RF_BDD.RF_BDD_ID is
'Identifiant de la BDD';

comment on column RF_BDD.RF_ZD_ID is
'Identifiant de la ZD';

comment on column RF_BDD.RF_BDD_COD is
'Code de la BDD';

comment on column RF_BDD.RF_BDD_LIB is
'Libelle de la BDD';

comment on column RF_BDD.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_BDD.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_BDD.RF_BDD_NIVEAU is
'Niveau hierarchique de la BDD';

comment on column RF_BDD.RF_ORGANISME_ID is
'Organisme intermediaire de la bdd';

alter table RF_BDD
   add constraint RF_BDD_PK1_1 primary key (RF_BDD_ID);

grant SELECT on RF_BDD to PUBLIC;

grant REFERENCES on RF_BDD to PUBLIC;

grant REFERENCES on RF_BDD to PUBLIC;

grant SELECT on RF_BDD to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_BENAMO                                            */
/*==============================================================*/
create table RF_BENAMO  (
   RF_BENAMO_ID         INTEGER                         not null,
   RF_BENAMO_COD        VARCHAR2(2)                     not null,
   RF_BENAMO_LIB        VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_BENAMO_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_BENAMO is
'Categorie de beneficiaire d''une amodiation';

comment on column RF_BENAMO.RF_BENAMO_ID is
'Identifiant de la categorie de beneficiaire';

comment on column RF_BENAMO.RF_BENAMO_COD is
'Code de la categorie de beneficiaire';

comment on column RF_BENAMO.RF_BENAMO_LIB is
'Libelle de la categorie de beneficiaire';

comment on column RF_BENAMO.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_BENAMO.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_BENAMO
   add constraint RF_BENAMO_PK1_1 primary key (RF_BENAMO_ID);

/*==============================================================*/
/* Index : RF_BENAMO_UN1_1                                      */
/*==============================================================*/
create unique index RF_BENAMO_UN1_1 on RF_BENAMO (
   RF_BENAMO_COD ASC
);

grant SELECT on RF_BENAMO to PUBLIC;

grant REFERENCES on RF_BENAMO to PUBLIC;

grant REFERENCES on RF_BENAMO to PUBLIC;

grant SELECT on RF_BENAMO to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_BOP                                               */
/*==============================================================*/
create table RF_BOP  (
   RF_BOP_ID            INTEGER                         not null,
   RF_BOP_COD           VARCHAR2(6)                     not null,
   RF_BOP_LIB           VARCHAR2(150)                   not null,
   RF_BOP_RBOP          VARCHAR2(150)                   not null,
   RF_TETAD_COD         VARCHAR2(1)                     not null,
   RF_IMPG_COD          VARCHAR2(6)                     not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_BOP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_BOP is
'Table des codes Budget Operation Programme';

comment on column RF_BOP.RF_BOP_ID is
'Identifiant du code type du beneficiaire de l''operation';

comment on column RF_BOP.RF_BOP_COD is
'Code Budget Operation Programme (ou OBI-BOP)';

comment on column RF_BOP.RF_BOP_LIB is
'Libelle  Budget Operation Programme';

comment on column RF_BOP.RF_BOP_RBOP is
'Libelle du repsonsable du Budget Operation Programme';

comment on column RF_BOP.RF_TETAD_COD is
'Code type etat D';

comment on column RF_BOP.RF_IMPG_COD is
'Code imputation de gestion';

comment on column RF_BOP.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_BOP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_BOP
   add constraint RF_BOP_PK1_1 primary key (RF_BOP_ID);

/*==============================================================*/
/* Index : RF_BOP_FK2_1                                         */
/*==============================================================*/
create index RF_BOP_FK2_1 on RF_BOP (
   RF_TETAD_COD ASC,
   RF_IMPG_COD ASC
);

/*==============================================================*/
/* Index : RF_BOP_UN3_1                                         */
/*==============================================================*/
create unique index RF_BOP_UN3_1 on RF_BOP (
   RF_BOP_COD ASC,
   RF_TETAD_COD ASC,
   RF_IMPG_COD ASC
);

grant SELECT on RF_BOP to PUBLIC;

grant REFERENCES on RF_BOP to PUBLIC;

grant REFERENCES on RF_BOP to PUBLIC;

grant SELECT on RF_BOP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_BOP_CH                                            */
/*==============================================================*/
create table RF_BOP_CH  (
   RF_BOP_ID            INTEGER                         not null,
   RF_PROG_ID           INTEGER,
   RF_BOP_COD           VARCHAR2(4),
   RF_BOP_LIB           VARCHAR2(300),
   RF_XDMAJ             VARCHAR2(15),
   RF_XTOPSUP           VARCHAR2(1)
);

alter table RF_BOP_CH
   add constraint RF_BOP_CH_PK1_1 primary key (RF_BOP_ID);

alter table RF_BOP_CH
   add constraint RF_BOP_CH_UN2_1 unique (RF_PROG_ID, RF_BOP_COD);

grant SELECT on RF_BOP_CH to PUBLIC;

grant REFERENCES on RF_BOP_CH to PUBLIC;

grant REFERENCES on RF_BOP_CH to PUBLIC;

grant SELECT on RF_BOP_CH to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CA                                                */
/*==============================================================*/
create table RF_CA  (
   RF_CA_COD            VARCHAR2(3)                     not null,
   RF_TPYR_COD          VARCHAR2(1)                     not null,
   RF_DEPT_ID           INTEGER,
   RF_PAYS_COD          VARCHAR2(5)                     not null,
   RF_CA_LIB            VARCHAR2(120)                   not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CA_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CA is
'Comptable assignataire';

comment on column RF_CA.RF_CA_COD is
'Code comptable assignataire';

comment on column RF_CA.RF_TPYR_COD is
'Type de Payeur';

comment on column RF_CA.RF_DEPT_ID is
'Identifiant du departement';

comment on column RF_CA.RF_PAYS_COD is
'Code du pays';

comment on column RF_CA.RF_CA_LIB is
'Clair comptable assignataire';

comment on column RF_CA.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_CA.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CA
   add constraint RF_CA_PK1_1 primary key (RF_CA_COD);

/*==============================================================*/
/* Index : RF_CA_FK1_1                                          */
/*==============================================================*/
create index RF_CA_FK1_1 on RF_CA (
   RF_TPYR_COD ASC
);

/*==============================================================*/
/* Index : RF_CA_FK1_2                                          */
/*==============================================================*/
create index RF_CA_FK1_2 on RF_CA (
   RF_DEPT_ID ASC
);

/*==============================================================*/
/* Index : RF_CA_FK1_3                                          */
/*==============================================================*/
create index RF_CA_FK1_3 on RF_CA (
   RF_PAYS_COD ASC
);

grant SELECT on RF_CA to PUBLIC;

grant REFERENCES on RF_CA to PUBLIC;

grant REFERENCES on RF_CA to PUBLIC;

grant SELECT on RF_CA to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CAL                                               */
/*==============================================================*/
create table RF_CAL  (
   RF_CAL_ID            NUMBER(9)                       not null,
   RF_CAL_JOUR_JULIEN   NUMBER(9),
   RF_CAL_FORMATDATE    VARCHAR2(15),
   RF_CAL_YYYYMMDD      VARCHAR2(8),
   RF_CAL_DT_LIBELLE    VARCHAR2(25),
   RF_CAL_ANNEE         VARCHAR2(5),
   RF_CAL_TRIMESTRE     VARCHAR2(5),
   RF_CAL_MOIS_CHIFFRE  VARCHAR2(5),
   RF_CAL_MOIS_LIBELLE  VARCHAR2(25),
   RF_CAL_JOUR_ANNEE    VARCHAR2(5),
   RF_CAL_JOUR_MOIS     VARCHAR2(5),
   RF_CAL_JOUR_SEMAINE_CHIFFRE VARCHAR2(5),
   RF_CAL_JOUR_SEMAINE_LIBELLE VARCHAR2(25),
   RF_CAL_NUMERO_SEMAINE VARCHAR2(5),
   RF_CAL_JOUR_OUVRE    VARCHAR2(1),
   RF_XDTDEBVAL         VARCHAR2(15),
   RF_XDTFINVAL         VARCHAR2(15)
);

comment on table RF_CAL is
'Calendrier';

comment on column RF_CAL.RF_CAL_ID is
'Identifiant calendrier';

comment on column RF_CAL.RF_CAL_JOUR_JULIEN is
'Jour Julien';

comment on column RF_CAL.RF_CAL_FORMATDATE is
'Date complete';

comment on column RF_CAL.RF_CAL_YYYYMMDD is
'Date yyyymmdd';

comment on column RF_CAL.RF_CAL_DT_LIBELLE is
'Date libelle';

comment on column RF_CAL.RF_CAL_ANNEE is
'Annee libelle';

comment on column RF_CAL.RF_CAL_TRIMESTRE is
'Trimestre format caractere';

comment on column RF_CAL.RF_CAL_MOIS_CHIFFRE is
'Mois chiffre en chiffre format caractere';

comment on column RF_CAL.RF_CAL_MOIS_LIBELLE is
'Mois libelle';

comment on column RF_CAL.RF_CAL_JOUR_ANNEE is
'Jour annee format caractere';

comment on column RF_CAL.RF_CAL_JOUR_MOIS is
'Jour mois en chiffre format caractere';

comment on column RF_CAL.RF_CAL_JOUR_SEMAINE_CHIFFRE is
'Jour semaine chiffre format caractere';

comment on column RF_CAL.RF_CAL_JOUR_SEMAINE_LIBELLE is
'Jour semaine libelle';

comment on column RF_CAL.RF_CAL_NUMERO_SEMAINE is
'Numero de la semaine format caractere
';

comment on column RF_CAL.RF_CAL_JOUR_OUVRE is
'Jour ouvre';

comment on column RF_CAL.RF_XDTDEBVAL is
'Date de debut de validite
';

comment on column RF_CAL.RF_XDTFINVAL is
'Date de fin de validite
';

alter table RF_CAL
   add constraint RF_CAL_PK1_1 primary key (RF_CAL_ID);

/*==============================================================*/
/* Index : RF_CAL_PK1_1                                         */
/*==============================================================*/
create unique index RF_CAL_PK1_1 on RF_CAL (
   RF_CAL_ID ASC
);

grant SELECT on RF_CAL to PUBLIC;

grant REFERENCES on RF_CAL to PUBLIC;

grant REFERENCES on RF_CAL to PUBLIC;

grant SELECT on RF_CAL to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CATDEP                                            */
/*==============================================================*/
create table RF_CATDEP  (
   RF_CATDEP_ID         INTEGER                         not null,
   RF_CATDEP_COD        VARCHAR2(2)                     not null,
   RF_CATDEP_LIB        VARCHAR2(100)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CATDEP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CATDEP is
'Table des categories de depense ';

comment on column RF_CATDEP.RF_CATDEP_ID is
'Identifiant de la categorie de la depense';

comment on column RF_CATDEP.RF_CATDEP_COD is
'Code categorie de la depense';

comment on column RF_CATDEP.RF_CATDEP_LIB is
'Libelle categorie de la depense';

comment on column RF_CATDEP.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_CATDEP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CATDEP
   add constraint RF_CATDEP_PK1_1 primary key (RF_CATDEP_ID);

/*==============================================================*/
/* Index : RF_CATDEP_UN1_1                                      */
/*==============================================================*/
create unique index RF_CATDEP_UN1_1 on RF_CATDEP (
   RF_CATDEP_COD ASC
);

grant SELECT on RF_CATDEP to PUBLIC;

grant REFERENCES on RF_CATDEP to PUBLIC;

grant REFERENCES on RF_CATDEP to PUBLIC;

grant SELECT on RF_CATDEP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CATOPE                                            */
/*==============================================================*/
create table RF_CATOPE  (
   RF_CATOPE_ID         INTEGER                         not null,
   RF_CATOPE_COD        VARCHAR2(2)                     not null,
   RF_CATOPE_LIB        VARCHAR2(100),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_CATOPE is
'Table des categories d''operations';

comment on column RF_CATOPE.RF_CATOPE_ID is
'ID de la categorie d''operation';

comment on column RF_CATOPE.RF_CATOPE_COD is
'Code de la categorie d''operation';

comment on column RF_CATOPE.RF_CATOPE_LIB is
'Libelle de la categorie d''operation';

comment on column RF_CATOPE.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_CATOPE.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_CATOPE
   add constraint RF_CATOPE_PK1_1 primary key (RF_CATOPE_ID);

grant SELECT on RF_CATOPE to PUBLIC;

grant SELECT on RF_CATOPE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CATORIDRO                                         */
/*==============================================================*/
create table RF_CATORIDRO  (
   RF_CATORIDRO_ID      INTEGER                         not null,
   RF_CATORIDRO_LIB     VARCHAR2(150)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CATORIDRO_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CATORIDRO is
'Categorie de l''Origine des droits de l''etat
Table Sagri IMM13:
1er ecran de l''aide en ligne';

comment on column RF_CATORIDRO.RF_CATORIDRO_ID is
'Identifiant de la categorie de l''origine des droits';

comment on column RF_CATORIDRO.RF_CATORIDRO_LIB is
'Libelle de la categorie de l''origine des droits';

comment on column RF_CATORIDRO.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_CATORIDRO.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CATORIDRO
   add constraint RF_CATORIDRO_PK1_1 primary key (RF_CATORIDRO_ID);

grant SELECT on RF_CATORIDRO to PUBLIC;

grant REFERENCES on RF_CATORIDRO to PUBLIC;

grant REFERENCES on RF_CATORIDRO to PUBLIC;

grant SELECT on RF_CATORIDRO to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CBUD                                              */
/*==============================================================*/
create table RF_CBUD  (
   RF_CBUD_ID           INTEGER                         not null,
   RF_CBUD_CMMT_ITEM    VARCHAR2(24)                    not null,
   RF_CBUD_FM_AREA      VARCHAR2(4)                     not null,
   RF_CBUD_DATETO       VARCHAR2(15)                    not null,
   RF_CBUD_DATEFROM     VARCHAR2(15),
   RF_CBUD_CFMFPART     VARCHAR2(3),
   RF_CBUD_CFMSTATS     VARCHAR2(1),
   RF_CBUD_TXTSH        VARCHAR2(20),
   RF_CBUD_TXTMD        VARCHAR2(40),
   RF_CBUD_TXTLG        VARCHAR2(60),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_CBUD is
'Table des comptes budgetaires CHORUS.';

comment on column RF_CBUD.RF_CBUD_ID is
'ID compte budgetaire CHORUS.';

comment on column RF_CBUD.RF_CBUD_CMMT_ITEM is
'Compte budgetaire CHORUS.';

comment on column RF_CBUD.RF_CBUD_FM_AREA is
'Perimetre financier compte budgetaire CHORUS.';

comment on column RF_CBUD.RF_CBUD_DATETO is
'Fin de validite compte budgetaire CHORUS.';

comment on column RF_CBUD.RF_CBUD_DATEFROM is
'Debut de validite compte budgetaire CHORUS.';

comment on column RF_CBUD.RF_CBUD_CFMFPART is
'Type de compte budgetaire CHORUS.';

comment on column RF_CBUD.RF_CBUD_CFMSTATS is
'Compte statistique compte budgetaire CHORUS.';

comment on column RF_CBUD.RF_CBUD_TXTSH is
'Description synthetique compte budgetaire CHORUS.';

comment on column RF_CBUD.RF_CBUD_TXTMD is
'Description moyenne compte budgetaire CHORUS.';

comment on column RF_CBUD.RF_CBUD_TXTLG is
'Description longue compte budgetaire CHORUS.';

comment on column RF_CBUD.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_CBUD.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_CBUD
   add constraint RF_CBUD_PK1_1 primary key (RF_CBUD_ID);

alter table RF_CBUD
   add constraint RF_CBUD_UN3_1 unique (RF_CBUD_CMMT_ITEM, RF_CBUD_FM_AREA, RF_CBUD_DATETO);

grant SELECT on RF_CBUD to PUBLIC;

grant REFERENCES on RF_CBUD to PUBLIC;

grant REFERENCES on RF_CBUD to PUBLIC;

grant SELECT on RF_CBUD to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CCOU                                              */
/*==============================================================*/
create table RF_CCOU  (
   RF_CCOU_ID           INTEGER                         not null,
   RF_STE_CHORUS_ID     INTEGER,
   RF_CPFT_ID           INTEGER,
   RF_DACT_ID           INTEGER,
   RF_CCOU_CO_AREA      VARCHAR2(4)                     not null,
   RF_CCOU_COSTCENTER   VARCHAR2(10)                    not null,
   RF_CCOU_DATETO       VARCHAR2(15)                    not null,
   RF_CCOU_DATEFROM     VARCHAR2(15),
   RF_CCOU_ETXTSH       VARCHAR2(20),
   RF_CCOU_ETXTMD       VARCHAR2(40),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_CCOU is
'Table des centres de couts.';

comment on column RF_CCOU.RF_CCOU_ID is
'ID centre de couts.';

comment on column RF_CCOU.RF_CPFT_ID is
'ID du centre de profits.';

comment on column RF_CCOU.RF_DACT_ID is
'ID domaine d''activite.';

comment on column RF_CCOU.RF_CCOU_CO_AREA is
'Perimetre analytique.';

comment on column RF_CCOU.RF_CCOU_COSTCENTER is
'Centre de cout.';

comment on column RF_CCOU.RF_CCOU_DATETO is
'Date de fin de validite du centre de couts.';

comment on column RF_CCOU.RF_CCOU_DATEFROM is
'Date de debut de validite du centre de couts.';

comment on column RF_CCOU.RF_CCOU_ETXTSH is
'Designation (libelle court) du centre de couts.';

comment on column RF_CCOU.RF_CCOU_ETXTMD is
'Descriptif (libelle long) du centre de couts.';

comment on column RF_CCOU.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_CCOU.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_CCOU
   add constraint RF_CCOU_PK1_1 primary key (RF_CCOU_ID);

alter table RF_CCOU
   add constraint RF_CCOU_UN3_1 unique (RF_CCOU_CO_AREA, RF_CCOU_COSTCENTER, RF_CCOU_DATETO);

/*==============================================================*/
/* Index : RF_CCOU_FK1_1                                        */
/*==============================================================*/
create index RF_CCOU_FK1_1 on RF_CCOU (
   RF_STE_CHORUS_ID ASC
);

/*==============================================================*/
/* Index : RF_CCOU_FK1_2                                        */
/*==============================================================*/
create index RF_CCOU_FK1_2 on RF_CCOU (
   RF_DACT_ID ASC
);

/*==============================================================*/
/* Index : RF_CCOU_FK1_3                                        */
/*==============================================================*/
create index RF_CCOU_FK1_3 on RF_CCOU (
   RF_CPFT_ID ASC
);

grant SELECT on RF_CCOU to PUBLIC;

grant REFERENCES on RF_CCOU to PUBLIC;

grant REFERENCES on RF_CCOU to PUBLIC;

grant SELECT on RF_CCOU to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CDMB                                              */
/*==============================================================*/
create table RF_CDMB  (
   RF_CDMB_COD          VARCHAR2(3)                     not null,
   RF_CDMB_LIB          VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CDMB_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_CDMB_SECTION_COD  VARCHAR2(2)                     not null
);

comment on table RF_CDMB is
'Ministere';

comment on column RF_CDMB.RF_CDMB_COD is
'Code ministere budget';

comment on column RF_CDMB.RF_CDMB_LIB is
'Clair ministere';

comment on column RF_CDMB.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_CDMB.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_CDMB.RF_CDMB_SECTION_COD is
'Code section du CDMB';

alter table RF_CDMB
   add constraint RF_CDMB_PK1_1 primary key (RF_CDMB_COD);

grant SELECT on RF_CDMB to PUBLIC;

grant REFERENCES on RF_CDMB to PUBLIC;

grant REFERENCES on RF_CDMB to PUBLIC;

grant SELECT on RF_CDMB to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CDSTAT                                            */
/*==============================================================*/
create table RF_CDSTAT  (
   RF_CDSTAT_COD        VARCHAR2(3)                     not null,
   RF_TSTAT_COD         VARCHAR2(2)                     not null,
   RF_FCTN_COD          VARCHAR2(1),
   RF_LIGMER_COD        VARCHAR2(6),
   RF_TOPV_COD          VARCHAR2(2)                     not null,
   RF_CDSTAT_LIB        VARCHAR2(50)                    not null,
   RF_CDSTAT_DURAM      INTEGER,
   RF_CDSTAT_TOPU       VARCHAR2(1)                    
      constraint RF_CDSTAT_CK1_1 check (RF_CDSTAT_TOPU is null or (RF_CDSTAT_TOPU in ('C'))),
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CDSTAT_CK1_2 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CDSTAT is
'Code statistique';

comment on column RF_CDSTAT.RF_CDSTAT_COD is
'Code Statistique';

comment on column RF_CDSTAT.RF_TSTAT_COD is
'Type Code Stat';

comment on column RF_CDSTAT.RF_FCTN_COD is
'Code Fonction';

comment on column RF_CDSTAT.RF_LIGMER_COD is
'Code Ligne Mercure';

comment on column RF_CDSTAT.RF_TOPV_COD is
'Top valide';

comment on column RF_CDSTAT.RF_CDSTAT_LIB is
'Libelle Code Statistique';

comment on column RF_CDSTAT.RF_CDSTAT_DURAM is
'Duree d''amortissement en mois';

comment on column RF_CDSTAT.RF_CDSTAT_TOPU is
'Top utilisation du code statistique dans CANA';

comment on column RF_CDSTAT.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_CDSTAT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CDSTAT
   add constraint RF_CDSTAT_PK1_1 primary key (RF_CDSTAT_COD);

/*==============================================================*/
/* Index : RF_CDSTAT_FK1_1                                      */
/*==============================================================*/
create index RF_CDSTAT_FK1_1 on RF_CDSTAT (
   RF_TSTAT_COD ASC
);

/*==============================================================*/
/* Index : RF_CDSTAT_FK1_3                                      */
/*==============================================================*/
create index RF_CDSTAT_FK1_3 on RF_CDSTAT (
   RF_FCTN_COD ASC
);

/*==============================================================*/
/* Index : RF_CDSTAT_FK1_2                                      */
/*==============================================================*/
create index RF_CDSTAT_FK1_2 on RF_CDSTAT (
   RF_LIGMER_COD ASC
);

/*==============================================================*/
/* Index : RF_CDSTAT_FK1_4                                      */
/*==============================================================*/
create index RF_CDSTAT_FK1_4 on RF_CDSTAT (
   RF_TOPV_COD ASC
);

grant SELECT on RF_CDSTAT to PUBLIC;

grant REFERENCES on RF_CDSTAT to PUBLIC;

grant REFERENCES on RF_CDSTAT to PUBLIC;

grant SELECT on RF_CDSTAT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CFIN                                              */
/*==============================================================*/
create table RF_CFIN  (
   RF_CFIN_ID           INTEGER                         not null,
   RF_PROG_ID           INTEGER,
   RF_BOP_ID            INTEGER,
   RF_CFIN_FM_AREA      VARCHAR2(4)                     not null,
   RF_CFIN_CENTREFI     VARCHAR2(16)                    not null,
   RF_CFIN_DATETO       VARCHAR2(15)                    not null,
   RF_CFIN_COD          VARCHAR2(4),
   RF_CFIN_LIB          VARCHAR2(300),
   RF_CFIN_LIBA         VARCHAR2(100),
   RF_CFIN_DATEFROM     VARCHAR2(15),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_CFIN is
'Table des Centres Financiers CHORUS.';

comment on column RF_CFIN.RF_CFIN_ID is
'ID Centre financier CHORUS.';

comment on column RF_CFIN.RF_PROG_ID is
'Identifiant du programme';

comment on column RF_CFIN.RF_CFIN_FM_AREA is
'Perimetre financier Centre financier CHORUS.';

comment on column RF_CFIN.RF_CFIN_CENTREFI is
'Centre financier.';

comment on column RF_CFIN.RF_CFIN_DATETO is
'Fin de validite Centre financier CHORUS.';

comment on column RF_CFIN.RF_CFIN_COD is
'Code Centre financier CHORUS.';

comment on column RF_CFIN.RF_CFIN_LIB is
'Designation longue Centre financier CHORUS.';

comment on column RF_CFIN.RF_CFIN_LIBA is
'Designation courte Centre financier CHORUS.';

comment on column RF_CFIN.RF_CFIN_DATEFROM is
'Debut de validite Centre financier CHORUS.';

comment on column RF_CFIN.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_CFIN.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_CFIN
   add constraint RF_CFIN_PK1_1 primary key (RF_CFIN_ID);

alter table RF_CFIN
   add constraint RF_CFIN_UN1_1 unique (RF_CFIN_FM_AREA, RF_CFIN_CENTREFI, RF_CFIN_DATETO);

/*==============================================================*/
/* Index : RF_CFIN_FK1_1                                        */
/*==============================================================*/
create index RF_CFIN_FK1_1 on RF_CFIN (
   RF_PROG_ID ASC
);

/*==============================================================*/
/* Index : RF_CFIN_FK1_2                                        */
/*==============================================================*/
create index RF_CFIN_FK1_2 on RF_CFIN (
   RF_BOP_ID ASC
);

grant SELECT on RF_CFIN to PUBLIC;

grant REFERENCES on RF_CFIN to PUBLIC;

grant REFERENCES on RF_CFIN to PUBLIC;

grant SELECT on RF_CFIN to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CIMO                                              */
/*==============================================================*/
create table RF_CIMO  (
   RF_CIMO_ID           INTEGER                         not null,
   RF_CIMO_EASSETCTG    VARCHAR2(8)                     not null,
   RF_CIMO_ETXTSH       VARCHAR2(20),
   RF_CIMO_ETXTLG       VARCHAR2(60),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_CIMO is
'Table des categories d''immobilisations CHORUS.';

comment on column RF_CIMO.RF_CIMO_ID is
'ID de la categorie d''immobilisation.';

comment on column RF_CIMO.RF_CIMO_EASSETCTG is
'Code categorie d''immobilisation.';

comment on column RF_CIMO.RF_CIMO_ETXTSH is
'Description synthetique de la categorie d''immobilisation.';

comment on column RF_CIMO.RF_CIMO_ETXTLG is
'Designation categorie d''immobilisation.';

comment on column RF_CIMO.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_CIMO.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_CIMO
   add constraint RF_CIMO_PK1_1 primary key (RF_CIMO_ID);

alter table RF_CIMO
   add constraint RF_CIMO_UN1_1 unique (RF_CIMO_EASSETCTG);

grant SELECT on RF_CIMO to PUBLIC;

grant REFERENCES on RF_CIMO to PUBLIC;

grant REFERENCES on RF_CIMO to PUBLIC;

grant SELECT on RF_CIMO to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CLAUTIL                                           */
/*==============================================================*/
create table RF_CLAUTIL  (
   RF_CLAUTIL_ID        INTEGER                         not null,
   RF_CLAUTIL_COD       VARCHAR2(5)                     not null,
   RF_CLAUTIL_CAT1      VARCHAR2(2)                     not null,
   RF_CLAUTIL_CAT2      VARCHAR2(50)                    not null,
   RF_CLAUTIL_SCAT      VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CLAUTIL_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CLAUTIL is
'Classe d''utilisation d''un immeuble';

comment on column RF_CLAUTIL.RF_CLAUTIL_ID is
'Identifiant de la classe d''utilisation';

comment on column RF_CLAUTIL.RF_CLAUTIL_COD is
'Code de la classe d''utilisation d''un immeuble';

comment on column RF_CLAUTIL.RF_CLAUTIL_CAT1 is
'Code categorie';

comment on column RF_CLAUTIL.RF_CLAUTIL_CAT2 is
'Libelle de la categorie';

comment on column RF_CLAUTIL.RF_CLAUTIL_SCAT is
'Libelle de la sous-categorie';

comment on column RF_CLAUTIL.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_CLAUTIL.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CLAUTIL
   add constraint RF_CLAUTIL_PK1_1 primary key (RF_CLAUTIL_ID);

/*==============================================================*/
/* Index : RF_CLAUTIL_UN1_1                                     */
/*==============================================================*/
create unique index RF_CLAUTIL_UN1_1 on RF_CLAUTIL (
   RF_CLAUTIL_COD ASC
);

grant SELECT on RF_CLAUTIL to PUBLIC;

grant REFERENCES on RF_CLAUTIL to PUBLIC;

grant REFERENCES on RF_CLAUTIL to PUBLIC;

grant SELECT on RF_CLAUTIL to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CLINV                                             */
/*==============================================================*/
create table RF_CLINV  (
   RF_CLINV_ID          INTEGER                         not null,
   RF_CLINV_COD         VARCHAR2(10)                    not null,
   RF_CLINV_LIB         VARCHAR2(200)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CLINV_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CLINV is
'Classe d''investissement';

comment on column RF_CLINV.RF_CLINV_ID is
'Identifiant de la classe d''investissement';

comment on column RF_CLINV.RF_CLINV_COD is
'Code de la classe d''investissement';

comment on column RF_CLINV.RF_CLINV_LIB is
'Libelle de la classe d''investissement';

comment on column RF_CLINV.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_CLINV.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CLINV
   add constraint RF_CLINV_PK1_1 primary key (RF_CLINV_ID);

grant SELECT on RF_CLINV to PUBLIC;

grant SELECT on RF_CLINV to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CMD                                               */
/*==============================================================*/
create table RF_CMD  (
   RF_CMD_COD           VARCHAR2(2)                     not null,
   RF_CMD_LIB           VARCHAR2(50),
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CMD_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CMD is
'CMD
Circonscription Militaire de Defense';

comment on column RF_CMD.RF_CMD_COD is
'Code CMD';

comment on column RF_CMD.RF_CMD_LIB is
'Libelle CMD';

comment on column RF_CMD.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_CMD.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CMD
   add constraint RF_CMD_PK1_1 primary key (RF_CMD_COD);

grant SELECT on RF_CMD to PUBLIC;

grant REFERENCES on RF_CMD to PUBLIC;

grant REFERENCES on RF_CMD to PUBLIC;

grant SELECT on RF_CMD to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CNOP                                              */
/*==============================================================*/
create table RF_CNOP  (
   RF_CNOP_ID           INTEGER                         not null,
   RF_CNOP_COD          VARCHAR2(1)                     not null,
   RF_CNOP_LIB          VARCHAR2(90)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CNOP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CNOP is
'Table des natures d’operations';

comment on column RF_CNOP.RF_CNOP_ID is
'Identifiant du code de la nature de l''operation';

comment on column RF_CNOP.RF_CNOP_COD is
'Code de la nature de l''operation';

comment on column RF_CNOP.RF_CNOP_LIB is
'Libelle  du code de la nature de l''operation';

comment on column RF_CNOP.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_CNOP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CNOP
   add constraint RF_CNOP_PK1_1 primary key (RF_CNOP_ID);

/*==============================================================*/
/* Index : RF_CNOP_UN1_1                                        */
/*==============================================================*/
create unique index RF_CNOP_UN1_1 on RF_CNOP (
   RF_CNOP_COD ASC
);

grant SELECT on RF_CNOP to PUBLIC;

grant REFERENCES on RF_CNOP to PUBLIC;

grant REFERENCES on RF_CNOP to PUBLIC;

grant SELECT on RF_CNOP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CODMIN                                            */
/*==============================================================*/
create table RF_CODMIN  (
   RF_CODMIN_ID         INTEGER                         not null,
   RF_CODMIN_COD        VARCHAR2(5)                     not null,
   RF_CODMIN_LIB        VARCHAR2(300)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CODMIN_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CODMIN is
'Table des codes ministere issus du referentiel CHORUS';

comment on column RF_CODMIN.RF_CODMIN_ID is
'Identifiant du code ministere';

comment on column RF_CODMIN.RF_CODMIN_COD is
'Code du code ministere';

comment on column RF_CODMIN.RF_CODMIN_LIB is
'Libelle du code ministere';

comment on column RF_CODMIN.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_CODMIN.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CODMIN
   add constraint RF_CODMIN_PK1_1 primary key (RF_CODMIN_ID);

grant SELECT on RF_CODMIN to PUBLIC;

grant REFERENCES on RF_CODMIN to PUBLIC;

grant REFERENCES on RF_CODMIN to PUBLIC;

grant SELECT on RF_CODMIN to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CODNIV                                            */
/*==============================================================*/
create table RF_CODNIV  (
   RF_CODNIV_COD        VARCHAR2(1)                     not null,
   RF_CODNIV_LIB        VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CODNIV_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CODNIV is
'Code niveau structure';

comment on column RF_CODNIV.RF_CODNIV_COD is
'Code niveau structure';

comment on column RF_CODNIV.RF_CODNIV_LIB is
'Clair niveau structure';

comment on column RF_CODNIV.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_CODNIV.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CODNIV
   add constraint RF_CODNIV_PK1_1 primary key (RF_CODNIV_COD);

grant SELECT on RF_CODNIV to PUBLIC;

grant REFERENCES on RF_CODNIV to PUBLIC;

grant REFERENCES on RF_CODNIV to PUBLIC;

grant SELECT on RF_CODNIV to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_COEFFENT                                          */
/*==============================================================*/
create table RF_COEFFENT  (
   RF_COEFFENT_ID       INTEGER                         not null,
   RF_ETATENT_ID        INTEGER                         not null,
   RF_COEFFENT_LIB      VARCHAR2(50)                    not null,
   RF_COEFFENT_COEFF    NUMBER(9,2)                     not null,
   RF_XDMAJ             VARCHAR2(15),
   RF_XTOPSUP           VARCHAR2(1)
);

comment on table RF_COEFFENT is
'Table des coefficients d''entretien des composants Chorus';

comment on column RF_COEFFENT.RF_COEFFENT_ID is
'Code Activite';

comment on column RF_COEFFENT.RF_ETATENT_ID is
'Libelle Activite';

comment on column RF_COEFFENT.RF_COEFFENT_LIB is
'Date de Mise a Jour';

comment on column RF_COEFFENT.RF_COEFFENT_COEFF is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_COEFFENT
   add constraint RF_COEFFENT_PK1_1 primary key (RF_COEFFENT_ID);

grant SELECT on RF_COEFFENT to PUBLIC;

grant REFERENCES on RF_COEFFENT to PUBLIC;

grant REFERENCES on RF_COEFFENT to PUBLIC;

grant SELECT on RF_COEFFENT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_COMIMP                                            */
/*==============================================================*/
create table RF_COMIMP  (
   RF_COMIMP_ID         INTEGER                         not null,
   RF_IMMEUBLE_ID       INTEGER                         not null,
   RF_COMM_ID           INTEGER                         not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_COMIMP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_COMIMP is
'Indicateur com/cpt initialise a 1 a la creation du lien';

comment on column RF_COMIMP.RF_COMIMP_ID is
'Identifiant de la commune d''implantation';

comment on column RF_COMIMP.RF_IMMEUBLE_ID is
'Identifiant de l''immeuble';

comment on column RF_COMIMP.RF_COMM_ID is
'Identifiant de la commune';

comment on column RF_COMIMP.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_COMIMP.RF_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

alter table RF_COMIMP
   add constraint RF_COMIMP_PK1_1 primary key (RF_COMIMP_ID);

/*==============================================================*/
/* Index : RF_COMIMP_FK1_1                                      */
/*==============================================================*/
create index RF_COMIMP_FK1_1 on RF_COMIMP (
   RF_IMMEUBLE_ID ASC
);

/*==============================================================*/
/* Index : RF_COMIMP_UN2_1                                      */
/*==============================================================*/
create unique index RF_COMIMP_UN2_1 on RF_COMIMP (
   RF_IMMEUBLE_ID ASC,
   RF_COMM_ID ASC
);

/*==============================================================*/
/* Index : RF_COMIMP_FK1_2                                      */
/*==============================================================*/
create index RF_COMIMP_FK1_2 on RF_COMIMP (
   RF_COMM_ID ASC
);

grant SELECT on RF_COMIMP to PUBLIC;

grant REFERENCES on RF_COMIMP to PUBLIC;

grant REFERENCES on RF_COMIMP to PUBLIC;

grant SELECT on RF_COMIMP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_COMM                                              */
/*==============================================================*/
create table RF_COMM  (
   RF_COMM_ID           INTEGER                         not null,
   RF_DEPT_ID           INTEGER                         not null,
   RF_COMM_COD          VARCHAR2(3)                     not null,
   RF_COMM_LIB          VARCHAR2(40),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_COMM_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_COMM_INSEE_COD    VARCHAR2(6),
   RF_COMM_INSEE_LIB    VARCHAR2(50)
);

comment on table RF_COMM is
'Commune adresse';

comment on column RF_COMM.RF_COMM_ID is
'Identifiant de la commune';

comment on column RF_COMM.RF_DEPT_ID is
'Identifiant du departement';

comment on column RF_COMM.RF_COMM_COD is
'Numero commune';

comment on column RF_COMM.RF_COMM_LIB is
'Clair commune';

comment on column RF_COMM.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_COMM.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_COMM
   add constraint RF_COMM_PK1_1 primary key (RF_COMM_ID);

/*==============================================================*/
/* Index : RF_COMM_FK1_1                                        */
/*==============================================================*/
create index RF_COMM_FK1_1 on RF_COMM (
   RF_DEPT_ID ASC
);

/*==============================================================*/
/* Index : RF_COMM_FK1_2                                        */
/*==============================================================*/
create unique index RF_COMM_FK1_2 on RF_COMM (
   RF_DEPT_ID ASC
);

/*==============================================================*/
/* Index : RF_COMM_UN2_1                                        */
/*==============================================================*/
create unique index RF_COMM_UN2_1 on RF_COMM (
   RF_DEPT_ID ASC,
   RF_COMM_COD ASC
);

grant SELECT on RF_COMM to PUBLIC;

grant REFERENCES on RF_COMM to PUBLIC;

grant REFERENCES on RF_COMM to PUBLIC;

grant SELECT on RF_COMM to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_COMMCP                                            */
/*==============================================================*/
create table RF_COMMCP  (
   RF_COMMCP_ID         INTEGER                         not null,
   RF_CP_ID             INTEGER                         not null,
   RF_COMM_ID           INTEGER                         not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_COMMCP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_COMMCP is
'Table de jointure entre le Code postal et la commune';

comment on column RF_COMMCP.RF_COMMCP_ID is
'Identifiant du code postal';

comment on column RF_COMMCP.RF_CP_ID is
'Identifiant du code postal';

comment on column RF_COMMCP.RF_COMM_ID is
'Identifiant de la commune';

comment on column RF_COMMCP.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_COMMCP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_COMMCP
   add constraint RF_COMMCP_PK1_1 primary key (RF_COMMCP_ID);

/*==============================================================*/
/* Index : RF_COMMCP_FK1_1                                      */
/*==============================================================*/
create index RF_COMMCP_FK1_1 on RF_COMMCP (
   RF_COMM_ID ASC
);

/*==============================================================*/
/* Index : RF_COMMCP_FK1_2                                      */
/*==============================================================*/
create index RF_COMMCP_FK1_2 on RF_COMMCP (
   RF_CP_ID ASC
);

/*==============================================================*/
/* Index : RF_COMMCP_UN2_1                                      */
/*==============================================================*/
create unique index RF_COMMCP_UN2_1 on RF_COMMCP (
   RF_CP_ID ASC,
   RF_COMM_ID ASC
);

grant SELECT on RF_COMMCP to PUBLIC;

grant REFERENCES on RF_COMMCP to PUBLIC;

grant REFERENCES on RF_COMMCP to PUBLIC;

grant SELECT on RF_COMMCP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CORGRD                                            */
/*==============================================================*/
create table RF_CORGRD  (
   RF_CORGRD_ID         INTEGER                         not null,
   RF_CORPS_ID          INTEGER                         not null,
   RF_GRD_COD           VARCHAR2(6)                     not null,
   RF_CORGRD_LIMITEAGE  INTEGER,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CORGRD_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CORGRD is
'Table de liaison entre le corps, et le grade';

comment on column RF_CORGRD.RF_CORGRD_ID is
'Identifiant de Corps Grade Armee';

comment on column RF_CORGRD.RF_CORPS_ID is
'Identifiant de Corps';

comment on column RF_CORGRD.RF_GRD_COD is
'Code grade';

comment on column RF_CORGRD.RF_CORGRD_LIMITEAGE is
'Limite d''age';

comment on column RF_CORGRD.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_CORGRD.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CORGRD
   add constraint RF_CORGRD_PK1_1 primary key (RF_CORGRD_ID);

/*==============================================================*/
/* Index : RF_CORGRD_FK1_1                                      */
/*==============================================================*/
create index RF_CORGRD_FK1_1 on RF_CORGRD (
   RF_GRD_COD ASC
);

/*==============================================================*/
/* Index : RF_CORGRD_FK1_2                                      */
/*==============================================================*/
create index RF_CORGRD_FK1_2 on RF_CORGRD (
   RF_CORPS_ID ASC
);

/*==============================================================*/
/* Index : RF_CORGRD_UN2_1                                      */
/*==============================================================*/
create unique index RF_CORGRD_UN2_1 on RF_CORGRD (
   RF_CORPS_ID ASC,
   RF_GRD_COD ASC
);

grant SELECT on RF_CORGRD to PUBLIC;

grant REFERENCES on RF_CORGRD to PUBLIC;

grant REFERENCES on RF_CORGRD to PUBLIC;

grant SELECT on RF_CORGRD to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CORPS                                             */
/*==============================================================*/
create table RF_CORPS  (
   RF_CORPS_ID          INTEGER                         not null,
   RF_ARMEE_ID          INTEGER                         not null,
   RF_CORPS_COD         VARCHAR2(5)                     not null,
   RF_CORPS_LIB         VARCHAR2(100),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CORPS_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CORPS is
'Corps pour les PC : IEF - TSEF - Ouvrier - ....
Corps pour les PM : CCTA - CMAJ - CMDR ....';

comment on column RF_CORPS.RF_CORPS_ID is
'Identifiant de Corps';

comment on column RF_CORPS.RF_ARMEE_ID is
'Identifiant de l''armee';

comment on column RF_CORPS.RF_CORPS_COD is
'Code abrege du corps';

comment on column RF_CORPS.RF_CORPS_LIB is
'Libelle corps ';

comment on column RF_CORPS.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_CORPS.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CORPS
   add constraint RF_CORPS_PK1_1 primary key (RF_CORPS_ID);

/*==============================================================*/
/* Index : RF_CORPS_UN1_1                                       */
/*==============================================================*/
create unique index RF_CORPS_UN1_1 on RF_CORPS (
   RF_CORPS_COD ASC
);

/*==============================================================*/
/* Index : RF_CORPS_FK1_1                                       */
/*==============================================================*/
create index RF_CORPS_FK1_1 on RF_CORPS (
   RF_ARMEE_ID ASC
);

grant SELECT on RF_CORPS to PUBLIC;

grant REFERENCES on RF_CORPS to PUBLIC;

grant REFERENCES on RF_CORPS to PUBLIC;

grant SELECT on RF_CORPS to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CP                                                */
/*==============================================================*/
create table RF_CP  (
   RF_CP_ID             INTEGER                         not null,
   RF_CP_COD            VARCHAR2(5)                     not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CP is
'Code postal';

comment on column RF_CP.RF_CP_ID is
'Identifiant du code postal';

comment on column RF_CP.RF_CP_COD is
'Code postal';

comment on column RF_CP.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_CP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CP
   add constraint RF_CP_PK1_1 primary key (RF_CP_ID);

/*==============================================================*/
/* Index : RF_CP_UN1_1                                          */
/*==============================================================*/
create unique index RF_CP_UN1_1 on RF_CP (
   RF_CP_COD ASC
);

grant SELECT on RF_CP to PUBLIC;

grant REFERENCES on RF_CP to PUBLIC;

grant REFERENCES on RF_CP to PUBLIC;

grant SELECT on RF_CP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CPCE                                              */
/*==============================================================*/
create table RF_CPCE  (
   RF_CPCE_ID           INTEGER                         not null,
   RF_PARAG_NUM         VARCHAR2(2)                     not null,
   RF_CPCE_SEUIL        NUMBER(14,2),
   RF_CPCE_COD          VARCHAR2(8),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CPCE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CPCE is
'Table des Seuils de comptes du PCE';

comment on column RF_CPCE.RF_CPCE_ID is
'Identifiant du compte du PCE';

comment on column RF_CPCE.RF_PARAG_NUM is
'Numero de Paragraphe';

comment on column RF_CPCE.RF_CPCE_SEUIL is
'Montant du Seuil';

comment on column RF_CPCE.RF_CPCE_COD is
'Numero clair de Compte';

comment on column RF_CPCE.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_CPCE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CPCE
   add constraint RF_CPCE_PK1_1 primary key (RF_CPCE_ID);

/*==============================================================*/
/* Index : RF_CPCE_UN1_1                                        */
/*==============================================================*/
create unique index RF_CPCE_UN1_1 on RF_CPCE (
   RF_PARAG_NUM ASC
);

grant SELECT on RF_CPCE to PUBLIC;

grant REFERENCES on RF_CPCE to PUBLIC;

grant REFERENCES on RF_CPCE to PUBLIC;

grant SELECT on RF_CPCE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CPCE_NG                                           */
/*==============================================================*/
create table RF_CPCE_NG  (
   RF_CPCE_ID           INTEGER                         not null,
   RF_CPCE_CHRT_ACCTS   VARCHAR2(4)                     not null,
   RF_CPCE_GL_ACCOUNT   VARCHAR2(10)                    not null,
   RF_CPCE_BAL_FLAG     VARCHAR2(1),
   RF_CPCE_INCST_FLAG   VARCHAR2(2),
   RF_CPCE_CFMCPTSUP    VARCHAR2(1),
   RF_CPCE_CFMCPTCRE    VARCHAR2(1),
   RF_CPCE_CFMCPTAB     VARCHAR2(1),
   RF_CPCE_CFMPREBUD    VARCHAR2(1),
   RF_CPCE_ETXTSH       VARCHAR2(20),
   RF_CPCE_ETXTLG       VARCHAR2(60),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_CPCE_NG is
'Table des comptes PCE CHORUS.';

comment on column RF_CPCE_NG.RF_CPCE_ID is
'ID comptes PCE CHORUS.';

comment on column RF_CPCE_NG.RF_CPCE_CHRT_ACCTS is
'Plan comptable comptes PCE CHORUS.';

comment on column RF_CPCE_NG.RF_CPCE_GL_ACCOUNT is
'Compte general comptes PCE CHORUS.';

comment on column RF_CPCE_NG.RF_CPCE_BAL_FLAG is
'Code compte de bilan comptes PCE CHORUS.';

comment on column RF_CPCE_NG.RF_CPCE_INCST_FLAG is
'Type de compte resultat comptes PCE CHORUS.';

comment on column RF_CPCE_NG.RF_CPCE_CFMCPTSUP is
'Code compte marque pour suppression comptes PCE CHORUS.';

comment on column RF_CPCE_NG.RF_CPCE_CFMCPTCRE is
'Code compte bloque pour creation comptes PCE CHORUS.';

comment on column RF_CPCE_NG.RF_CPCE_CFMCPTAB is
'Code compte bloque pour comptabilisation comptes PCE CHORUS.';

comment on column RF_CPCE_NG.RF_CPCE_CFMPREBUD is
'Code colmpte bloque pour pre-budget comptes PCE CHORUS.';

comment on column RF_CPCE_NG.RF_CPCE_ETXTSH is
'Description courte comptes PCE CHORUS.';

comment on column RF_CPCE_NG.RF_CPCE_ETXTLG is
'Description longue comptes PCE CHORUS.';

comment on column RF_CPCE_NG.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_CPCE_NG.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_CPCE_NG
   add constraint RF_CPCED_PK1_1 primary key (RF_CPCE_ID);

alter table RF_CPCE_NG
   add constraint RF_CPCED_UN2_1 unique (RF_CPCE_CHRT_ACCTS, RF_CPCE_GL_ACCOUNT);

grant SELECT on RF_CPCE_NG to PUBLIC;

grant REFERENCES on RF_CPCE_NG to PUBLIC;

grant REFERENCES on RF_CPCE_NG to PUBLIC;

grant SELECT on RF_CPCE_NG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CPER                                              */
/*==============================================================*/
create table RF_CPER  (
   RF_CPER_ID           INTEGER                         not null,
   RF_CPER_CPER         VARCHAR2(15)                    not null,
   RF_CPER_TXTSH        VARCHAR2(20),
   RF_CPER_TXTMD        VARCHAR2(40),
   RF_CPER_TXTLG        VARCHAR2(60),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_CPER is
'Table des CPER.';

comment on column RF_CPER.RF_CPER_ID is
'ID du CPER.';

comment on column RF_CPER.RF_CPER_CPER is
'Code du CPER.';

comment on column RF_CPER.RF_CPER_TXTSH is
'Description synthetique du CPER.';

comment on column RF_CPER.RF_CPER_TXTMD is
'Description moyenne du CPER.';

comment on column RF_CPER.RF_CPER_TXTLG is
'Description longue du CPER.';

comment on column RF_CPER.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_CPER.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_CPER
   add constraint RF_CPER_PK1_1 primary key (RF_CPER_ID);

alter table RF_CPER
   add constraint RF_CPER_UN1_1 unique (RF_CPER_CPER);

grant SELECT on RF_CPER to PUBLIC;

grant REFERENCES on RF_CPER to PUBLIC;

grant REFERENCES on RF_CPER to PUBLIC;

grant SELECT on RF_CPER to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CPFT                                              */
/*==============================================================*/
create table RF_CPFT  (
   RF_CPFT_ID           INTEGER                         not null,
   RF_CPFT_CO_AREA      VARCHAR2(4)                     not null,
   RF_CPFT_PROFIT_CTR   VARCHAR2(10)                    not null,
   RF_CPFT_DATETO       VARCHAR2(15)                    not null,
   RF_CPFT_DATEFROM     VARCHAR2(15),
   RF_CPFT_RESP_PERS    VARCHAR2(20),
   RF_CPFT_TXTSH        VARCHAR2(20),
   RF_CPFT_TXTMD        VARCHAR2(40),
   RF_CPFT_TXTLG        VARCHAR2(60),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_CPFT is
'Table des centres de profits CHORUS.';

comment on column RF_CPFT.RF_CPFT_ID is
'ID du centre de profits.';

comment on column RF_CPFT.RF_CPFT_CO_AREA is
'Perimetre analytique du centre de profit.';

comment on column RF_CPFT.RF_CPFT_PROFIT_CTR is
'Code du centre de profit.';

comment on column RF_CPFT.RF_CPFT_DATETO is
'Date de fin de validite du centre de profit.';

comment on column RF_CPFT.RF_CPFT_DATEFROM is
'Date de debut de validite du centre de profit.';

comment on column RF_CPFT.RF_CPFT_RESP_PERS is
'Responsable du centre de profit.';

comment on column RF_CPFT.RF_CPFT_TXTSH is
'Description synthetique du centre de profit.';

comment on column RF_CPFT.RF_CPFT_TXTMD is
'Description moyenne du centre de profit.';

comment on column RF_CPFT.RF_CPFT_TXTLG is
'Description longue du centre de profit.';

comment on column RF_CPFT.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_CPFT.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_CPFT
   add constraint RF_CPFT_PK1_1 primary key (RF_CPFT_ID);

alter table RF_CPFT
   add constraint RF_CPFT_UN3_1 unique (RF_CPFT_CO_AREA, RF_CPFT_PROFIT_CTR, RF_CPFT_DATETO);

grant SELECT on RF_CPFT to PUBLIC;

grant REFERENCES on RF_CPFT to PUBLIC;

grant REFERENCES on RF_CPFT to PUBLIC;

grant SELECT on RF_CPFT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CPMTD                                             */
/*==============================================================*/
create table RF_CPMTD  (
   RF_CPMTD_ID          INTEGER                         not null,
   RF_CPMTD_ERL_CONDP   VARCHAR2(4)                     not null,
   RF_CPMTD_TXTLG       VARCHAR2(60),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_CPMTD is
'Table des conditions de paiement.';

comment on column RF_CPMTD.RF_CPMTD_ID is
'ID des conditions de paiement.';

comment on column RF_CPMTD.RF_CPMTD_ERL_CONDP is
'Cle des conditions de paiement.';

comment on column RF_CPMTD.RF_CPMTD_TXTLG is
'Libelle des conditions de paiement.';

comment on column RF_CPMTD.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_CPMTD.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_CPMTD
   add constraint RF_CPMTD_PK1_1 primary key (RF_CPMTD_ID);

alter table RF_CPMTD
   add constraint RF_CPMTD_UN1_1 unique (RF_CPMTD_ERL_CONDP);

grant SELECT on RF_CPMTD to PUBLIC;

grant REFERENCES on RF_CPMTD to PUBLIC;

grant REFERENCES on RF_CPMTD to PUBLIC;

grant SELECT on RF_CPMTD to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CPT                                               */
/*==============================================================*/
create table RF_CPT  (
   RF_CPT_ID            INTEGER                         not null,
   RF_CPT_COD           INTEGER                         not null,
   RF_IMMEUBLE_ID       INTEGER                         not null,
   RF_COMIMP_ID         INTEGER                         not null,
   RF_TCOMPO_ID         INTEGER                         not null,
   RF_CPT_DEN           VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_CPT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CPT is
'Composant';

comment on column RF_CPT.RF_CPT_ID is
'Identifiant du composant';

comment on column RF_CPT.RF_CPT_COD is
'Code composant';

comment on column RF_CPT.RF_IMMEUBLE_ID is
'Identifiant de l''immeuble';

comment on column RF_CPT.RF_COMIMP_ID is
'Identifiant de la commune d''implantation';

comment on column RF_CPT.RF_TCOMPO_ID is
'Identifiant du type de composant';

comment on column RF_CPT.RF_CPT_DEN is
'Denomination composant';

comment on column RF_CPT.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_CPT.RF_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

alter table RF_CPT
   add constraint RF_CPT_PK1_1 primary key (RF_CPT_ID);

/*==============================================================*/
/* Index : RF_CPT_FK1_1                                         */
/*==============================================================*/
create index RF_CPT_FK1_1 on RF_CPT (
   RF_IMMEUBLE_ID ASC
);

/*==============================================================*/
/* Index : RF_CPT_FK1_2                                         */
/*==============================================================*/
create index RF_CPT_FK1_2 on RF_CPT (
   RF_TCOMPO_ID ASC
);

/*==============================================================*/
/* Index : RF_CPT_FK1_3                                         */
/*==============================================================*/
create index RF_CPT_FK1_3 on RF_CPT (
   RF_COMIMP_ID ASC
);

/*==============================================================*/
/* Index : RF_CPT_UN2_1                                         */
/*==============================================================*/
create unique index RF_CPT_UN2_1 on RF_CPT (
   RF_CPT_COD ASC,
   RF_IMMEUBLE_ID ASC
);

grant SELECT on RF_CPT to PUBLIC;

grant REFERENCES on RF_CPT to PUBLIC;

grant REFERENCES on RF_CPT to PUBLIC;

grant SELECT on RF_CPT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CPTCLAUTIL                                        */
/*==============================================================*/
create table RF_CPTCLAUTIL  (
   RF_CPTCLAUTIL_ID     INTEGER                         not null,
   RF_CPTCLAUTIL_COD    VARCHAR2(3)                     not null,
   RF_CPTCLAUTIL_LIB    VARCHAR2(50),
   RF_CPTCLAUTIL_LIBA   VARCHAR2(3),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CPTCLAUTIL_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CPTCLAUTIL is
'Classe utilisation composant';

comment on column RF_CPTCLAUTIL.RF_CPTCLAUTIL_ID is
'RF_CPTCLAUTIL_ID';

comment on column RF_CPTCLAUTIL.RF_CPTCLAUTIL_COD is
'Code';

comment on column RF_CPTCLAUTIL.RF_CPTCLAUTIL_LIB is
'Libelle';

comment on column RF_CPTCLAUTIL.RF_CPTCLAUTIL_LIBA is
'Libelle abrege';

comment on column RF_CPTCLAUTIL.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_CPTCLAUTIL.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CPTCLAUTIL
   add constraint RF_CPTCLAUTIL_PK1_1 primary key (RF_CPTCLAUTIL_ID);

/*==============================================================*/
/* Index : RF_CPTCLAUTIL_UN1_1                                  */
/*==============================================================*/
create unique index RF_CPTCLAUTIL_UN1_1 on RF_CPTCLAUTIL (
   RF_CPTCLAUTIL_COD ASC
);

grant SELECT on RF_CPTCLAUTIL to PUBLIC;

grant REFERENCES on RF_CPTCLAUTIL to PUBLIC;

grant REFERENCES on RF_CPTCLAUTIL to PUBLIC;

grant SELECT on RF_CPTCLAUTIL to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CPTCOM                                            */
/*==============================================================*/
create table RF_CPTCOM  (
   RF_CPTCOM_COD        VARCHAR2(5)                     not null,
   RF_CDMB_COD          VARCHAR2(3)                     not null,
   RF_CPTCOM_LIB        VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CPTCOM_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CPTCOM is
'Compte de commerce';

comment on column RF_CPTCOM.RF_CPTCOM_COD is
'Code compte de commerce';

comment on column RF_CPTCOM.RF_CDMB_COD is
'Code ministere budget';

comment on column RF_CPTCOM.RF_CPTCOM_LIB is
'Clair compte de commerce';

comment on column RF_CPTCOM.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_CPTCOM.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CPTCOM
   add constraint RF_CPTCOM_PK1_1 primary key (RF_CPTCOM_COD);

/*==============================================================*/
/* Index : RF_CPTCOM_FK1_1                                      */
/*==============================================================*/
create index RF_CPTCOM_FK1_1 on RF_CPTCOM (
   RF_CDMB_COD ASC
);

grant SELECT on RF_CPTCOM to PUBLIC;

grant REFERENCES on RF_CPTCOM to PUBLIC;

grant REFERENCES on RF_CPTCOM to PUBLIC;

grant SELECT on RF_CPTCOM to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CPTIND                                            */
/*==============================================================*/
create table RF_CPTIND  (
   RF_CPTIND_ID         INTEGER                         not null,
   RF_CPTIND_COD        NUMBER(1)                       not null,
   RF_CPTIND_LIB        VARCHAR2(10)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint CKC_RF_XTOPSUP_RF_CPTIN check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

alter table RF_CPTIND
   add constraint PK_RF_CPTIND primary key (RF_CPTIND_ID);

/*==============================================================*/
/* Index : RF_CPTIND_UN1_1                                      */
/*==============================================================*/
create unique index RF_CPTIND_UN1_1 on RF_CPTIND (
   RF_CPTIND_COD ASC
);

grant SELECT on RF_CPTIND to PUBLIC;

grant REFERENCES on RF_CPTIND to PUBLIC;

grant REFERENCES on RF_CPTIND to PUBLIC;

grant SELECT on RF_CPTIND to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CPYR                                              */
/*==============================================================*/
create table RF_CPYR  (
   RF_CPYR_ID           INTEGER                         not null,
   RF_TPERS_ID          INTEGER                         not null,
   RF_CPYR_COD          VARCHAR2(10)                    not null,
   RF_CPYR_LIB          VARCHAR2(100)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CPYR_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CPYR is
'Etablissement qui paye les frais de deplacement
(CAAT, CTAC, REGIE...)
';

comment on column RF_CPYR.RF_CPYR_ID is
'Identifiant de la table MI_PAYEUR';

comment on column RF_CPYR.RF_TPERS_ID is
'Identifiant du type personnel';

comment on column RF_CPYR.RF_CPYR_LIB is
'Libelle de l''etablissment payeur';

comment on column RF_CPYR.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CPYR
   add constraint RF_CPYR_PK1_1 primary key (RF_CPYR_ID);

/*==============================================================*/
/* Index : RF_CPYR_UN2_1                                        */
/*==============================================================*/
create unique index RF_CPYR_UN2_1 on RF_CPYR (
   RF_TPERS_ID ASC,
   RF_CPYR_COD ASC
);

grant SELECT on RF_CPYR to PUBLIC;

grant REFERENCES on RF_CPYR to PUBLIC;

grant REFERENCES on RF_CPYR to PUBLIC;

grant SELECT on RF_CPYR to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CTACHAT                                           */
/*==============================================================*/
create table RF_CTACHAT  (
   RF_CTACHAT_COD       VARCHAR2(1)                     not null,
   RF_CTACHAT_LIB       VARCHAR2(30)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CTACHAT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CTACHAT is
'Table des categories d''achat';

comment on column RF_CTACHAT.RF_CTACHAT_COD is
'Categorie d''achat';

comment on column RF_CTACHAT.RF_CTACHAT_LIB is
'Libelle de la categorie d''achat';

comment on column RF_CTACHAT.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_CTACHAT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CTACHAT
   add constraint RF_CTACHAT_PK1_1 primary key (RF_CTACHAT_COD);

grant SELECT on RF_CTACHAT to PUBLIC;

grant REFERENCES on RF_CTACHAT to PUBLIC;

grant REFERENCES on RF_CTACHAT to PUBLIC;

grant SELECT on RF_CTACHAT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CTBOP                                             */
/*==============================================================*/
create table RF_CTBOP  (
   RF_CTBOP_ID          INTEGER                         not null,
   RF_CTBOP_COD         VARCHAR2(2)                     not null,
   RF_CTBOP_LIB         VARCHAR2(150)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CTBOP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CTBOP is
'Table des codes type de beneficiaire de l''operation';

comment on column RF_CTBOP.RF_CTBOP_ID is
'Identifiant du code type du beneficiaire de l''operation';

comment on column RF_CTBOP.RF_CTBOP_COD is
'Code type du beneficiaire de l''operation';

comment on column RF_CTBOP.RF_CTBOP_LIB is
'Libelle du code type du beneficiaire de l''operation';

comment on column RF_CTBOP.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_CTBOP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CTBOP
   add constraint RF_CTBOP_PK1_1 primary key (RF_CTBOP_ID);

/*==============================================================*/
/* Index : RF_CTBOP_UN1_1                                       */
/*==============================================================*/
create unique index RF_CTBOP_UN1_1 on RF_CTBOP (
   RF_CTBOP_COD ASC
);

grant SELECT on RF_CTBOP to PUBLIC;

grant REFERENCES on RF_CTBOP to PUBLIC;

grant REFERENCES on RF_CTBOP to PUBLIC;

grant SELECT on RF_CTBOP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CTENG                                             */
/*==============================================================*/
create table RF_CTENG  (
   RF_CTENG_COD         VARCHAR2(1)                     not null,
   RF_CTENG_LIB         VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CTENG_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CTENG is
'Categorie d''engagement';

comment on column RF_CTENG.RF_CTENG_COD is
'Code categorie d''engagement';

comment on column RF_CTENG.RF_CTENG_LIB is
'Clair categorie d''engagement';

comment on column RF_CTENG.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_CTENG.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CTENG
   add constraint RF_CTENG_PK1_1 primary key (RF_CTENG_COD);

grant SELECT on RF_CTENG to PUBLIC;

grant REFERENCES on RF_CTENG to PUBLIC;

grant REFERENCES on RF_CTENG to PUBLIC;

grant SELECT on RF_CTENG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CTGRD                                             */
/*==============================================================*/
create table RF_CTGRD  (
   RF_CTGRD_COD         VARCHAR2(1)                     not null,
   RF_CDSTAT_COD        VARCHAR2(3)                     not null,
   RF_CTGRD_LIB         VARCHAR2(50)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CTGRD_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_CTGRD_LIBA        VARCHAR2(4)
);

comment on table RF_CTGRD is
'Categorie des grades';

comment on column RF_CTGRD.RF_CTGRD_COD is
'Code categorie grade';

comment on column RF_CTGRD.RF_CDSTAT_COD is
'Code Statistique';

comment on column RF_CTGRD.RF_CTGRD_LIB is
'Clair categorie grade';

comment on column RF_CTGRD.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_CTGRD.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_CTGRD.RF_CTGRD_LIBA is
'Libelle abrege';

alter table RF_CTGRD
   add constraint RF_CTGRD_PK1_1 primary key (RF_CTGRD_COD);

/*==============================================================*/
/* Index : RF_CTGRD_FK1_1                                       */
/*==============================================================*/
create index RF_CTGRD_FK1_1 on RF_CTGRD (
   RF_CDSTAT_COD ASC
);

grant SELECT on RF_CTGRD to PUBLIC;

grant REFERENCES on RF_CTGRD to PUBLIC;

grant REFERENCES on RF_CTGRD to PUBLIC;

grant SELECT on RF_CTGRD to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CTLOP                                             */
/*==============================================================*/
create table RF_CTLOP  (
   RF_CTLOP_ID          INTEGER                         not null,
   RF_CTLOP_COD         VARCHAR2(1)                     not null,
   RF_CTLOP_LIB         VARCHAR2(150)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CTLOP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CTLOP is
'Table des codes des types de localisation de l''operation';

comment on column RF_CTLOP.RF_CTLOP_ID is
'Identifiant du code type localisation de l''operation';

comment on column RF_CTLOP.RF_CTLOP_COD is
'Code du type de localisation de l''operation';

comment on column RF_CTLOP.RF_CTLOP_LIB is
'Libelle du code du type de localisation de l''operation';

comment on column RF_CTLOP.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_CTLOP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CTLOP
   add constraint RF_CTLOP_PK1_1 primary key (RF_CTLOP_ID);

/*==============================================================*/
/* Index : RF_CTLOP_UN1_1                                       */
/*==============================================================*/
create unique index RF_CTLOP_UN1_1 on RF_CTLOP (
   RF_CTLOP_COD ASC
);

grant SELECT on RF_CTLOP to PUBLIC;

grant REFERENCES on RF_CTLOP to PUBLIC;

grant REFERENCES on RF_CTLOP to PUBLIC;

grant SELECT on RF_CTLOP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CTOB                                              */
/*==============================================================*/
create table RF_CTOB  (
   RF_CTOB_COD          VARCHAR2(1)                     not null,
   RF_CTOB_LIB          VARCHAR2(40)                    not null,
   RF_CTOB_LIBNDL       VARCHAR2(2)                     not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CTOB_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CTOB is
'Categorie d''OBI';

comment on column RF_CTOB.RF_CTOB_COD is
'Code categorie OBI';

comment on column RF_CTOB.RF_CTOB_LIB is
'Clair categorie OBI';

comment on column RF_CTOB.RF_CTOB_LIBNDL is
'Clair categorie OBI NDL';

comment on column RF_CTOB.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_CTOB.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CTOB
   add constraint RF_CTOB_PK1_1 primary key (RF_CTOB_COD);

grant SELECT on RF_CTOB to PUBLIC;

grant REFERENCES on RF_CTOB to PUBLIC;

grant REFERENCES on RF_CTOB to PUBLIC;

grant SELECT on RF_CTOB to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CTSTORCOR                                         */
/*==============================================================*/
create table RF_CTSTORCOR  (
   RF_CTSTORCOR_ID      INTEGER                         not null,
   RF_ORDRE_ID          INTEGER                         not null,
   RF_CTGRD_COD         VARCHAR2(1)                     not null,
   RF_STATUT_ID         INTEGER                         not null,
   RF_CORPS_ID          INTEGER                         not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CTSTORCOR_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CTSTORCOR is
'Table de jointure entre RF_ORDRE, RF_CTGRD, RF_STATUT, RF_CORPS
';

comment on column RF_CTSTORCOR.RF_CTSTORCOR_ID is
'Identifiant de ORDRE';

comment on column RF_CTSTORCOR.RF_ORDRE_ID is
'Identifiant de ORDRE';

comment on column RF_CTSTORCOR.RF_CTGRD_COD is
'Code categorie grade';

comment on column RF_CTSTORCOR.RF_STATUT_ID is
'Identifiant du statut';

comment on column RF_CTSTORCOR.RF_CORPS_ID is
'Identifiant de Corps';

comment on column RF_CTSTORCOR.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_CTSTORCOR.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CTSTORCOR
   add constraint RF_CTSTORCOR_PK1_1 primary key (RF_CTSTORCOR_ID);

/*==============================================================*/
/* Index : RF_CTSTORCOR_FK1_1                                   */
/*==============================================================*/
create index RF_CTSTORCOR_FK1_1 on RF_CTSTORCOR (
   RF_CTGRD_COD ASC
);

/*==============================================================*/
/* Index : RF_CTSTORCOR_FK1_2                                   */
/*==============================================================*/
create index RF_CTSTORCOR_FK1_2 on RF_CTSTORCOR (
   RF_ORDRE_ID ASC
);

/*==============================================================*/
/* Index : RF_CTSTORCOR_FK1_3                                   */
/*==============================================================*/
create index RF_CTSTORCOR_FK1_3 on RF_CTSTORCOR (
   RF_STATUT_ID ASC
);

/*==============================================================*/
/* Index : RF_CTSTORCOR_FK1_4                                   */
/*==============================================================*/
create index RF_CTSTORCOR_FK1_4 on RF_CTSTORCOR (
   RF_CORPS_ID ASC
);

/*==============================================================*/
/* Index : RF_CTSTORCOR_UN4_1                                   */
/*==============================================================*/
create unique index RF_CTSTORCOR_UN4_1 on RF_CTSTORCOR (
   RF_ORDRE_ID ASC,
   RF_CTGRD_COD ASC,
   RF_STATUT_ID ASC,
   RF_CORPS_ID ASC
);

grant SELECT on RF_CTSTORCOR to PUBLIC;

grant REFERENCES on RF_CTSTORCOR to PUBLIC;

grant REFERENCES on RF_CTSTORCOR to PUBLIC;

grant SELECT on RF_CTSTORCOR to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_CTUTIL                                            */
/*==============================================================*/
create table RF_CTUTIL  (
   RF_CTUTIL_ID         INTEGER                         not null,
   RF_IMMCLAUTIL_ID     INTEGER,
   RF_CTUTIL_COD        VARCHAR2(2)                     not null,
   RF_CTUTIL_LIB        VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CTUTIL_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_CTUTIL is
'Contient RF_CLAUTIL_CAT1 et RF_CLAUTIL_CAT2';

comment on column RF_CTUTIL.RF_CTUTIL_ID is
'Identifiant de la categorie d''utilisation';

comment on column RF_CTUTIL.RF_IMMCLAUTIL_ID is
'Identifiant de la classe d''utilisation';

comment on column RF_CTUTIL.RF_CTUTIL_COD is
'Code categorie classe utilisation';

comment on column RF_CTUTIL.RF_CTUTIL_LIB is
'Libelle categorie classe utilisation';

comment on column RF_CTUTIL.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_CTUTIL.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_CTUTIL
   add constraint RF_CTUTIL_PK1_1 primary key (RF_CTUTIL_ID);

/*==============================================================*/
/* Index : RF_CTUTIL_FK1_1                                      */
/*==============================================================*/
create index RF_CTUTIL_FK1_1 on RF_CTUTIL (
   RF_IMMCLAUTIL_ID ASC
);

grant SELECT on RF_CTUTIL to PUBLIC;

grant REFERENCES on RF_CTUTIL to PUBLIC;

grant REFERENCES on RF_CTUTIL to PUBLIC;

grant SELECT on RF_CTUTIL to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_DACT                                              */
/*==============================================================*/
create table RF_DACT  (
   RF_DACT_ID           INTEGER                         not null,
   RF_DACT_AREA         VARCHAR2(4)                     not null,
   RF_DACT_ETXTMD       VARCHAR2(40),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_DACT is
'Table des domaines d''activites CHORUS. Correspond aux differents TPG.';

comment on column RF_DACT.RF_DACT_ID is
'ID domaine d''activite.';

comment on column RF_DACT.RF_DACT_AREA is
'Code domaine d''activite.';

comment on column RF_DACT.RF_DACT_ETXTMD is
'Description (libelle) du domaine d''activite.';

comment on column RF_DACT.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_DACT.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_DACT
   add constraint RF_DACT_PK1_1 primary key (RF_DACT_ID);

alter table RF_DACT
   add constraint RF_DACT_UN1_1 unique (RF_DACT_AREA);

grant SELECT on RF_DACT to PUBLIC;

grant REFERENCES on RF_DACT to PUBLIC;

grant REFERENCES on RF_DACT to PUBLIC;

grant SELECT on RF_DACT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_DEPT                                              */
/*==============================================================*/
create table RF_DEPT  (
   RF_DEPT_ID           INTEGER                         not null,
   RF_DEPT_COD          VARCHAR2(3)                     not null,
   RF_CMD_COD           VARCHAR2(2)                     not null,
   RF_DEPT_LIB          VARCHAR2(25),
   RF_REG_RT_ID         INTEGER                         not null,
   RF_REG_RA_ID         INTEGER                         not null,
   RF_REG_RM_ID         INTEGER                         not null,
   RF_REG_GND_ID        INTEGER                         not null,
   RF_REGECO_ID         INTEGER                         not null,
   RF_ORGEN_SAGRI_COD   VARCHAR2(4),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_DEPT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_DEPT_ZONE         VARCHAR2(15)
);

comment on table RF_DEPT is
'Departement';

comment on column RF_DEPT.RF_DEPT_ID is
'Identifiant du departement';

comment on column RF_DEPT.RF_DEPT_COD is
'Numero departement';

comment on column RF_DEPT.RF_CMD_COD is
'Code CMD';

comment on column RF_DEPT.RF_DEPT_LIB is
'Libelle departement';

comment on column RF_DEPT.RF_REG_RT_ID is
'Region militaire terre';

comment on column RF_DEPT.RF_REG_RA_ID is
'Region aerienne';

comment on column RF_DEPT.RF_REG_RM_ID is
'Region maritime';

comment on column RF_DEPT.RF_REG_GND_ID is
'Region gendarmerie';

comment on column RF_DEPT.RF_REGECO_ID is
'Region economique';

comment on column RF_DEPT.RF_ORGEN_SAGRI_COD is
'Code SAGRI';

comment on column RF_DEPT.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_DEPT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_DEPT.RF_DEPT_ZONE is
'Chaque departement est dans une zone : Paris, Province, FFSA, OUTRE MER
Chaque departement est dans une zone : 
';

alter table RF_DEPT
   add constraint RF_DEPT_PK1_1 primary key (RF_DEPT_ID);

/*==============================================================*/
/* Index : RF_DEPT_FK1_1                                        */
/*==============================================================*/
create index RF_DEPT_FK1_1 on RF_DEPT (
   RF_CMD_COD ASC
);

/*==============================================================*/
/* Index : RF_DEPT_FK1_2                                        */
/*==============================================================*/
create index RF_DEPT_FK1_2 on RF_DEPT (
   RF_REG_RA_ID ASC
);

/*==============================================================*/
/* Index : RF_DEPT_FK1_3                                        */
/*==============================================================*/
create index RF_DEPT_FK1_3 on RF_DEPT (
   RF_REG_RM_ID ASC
);

/*==============================================================*/
/* Index : RF_DEPT_FK1_4                                        */
/*==============================================================*/
create index RF_DEPT_FK1_4 on RF_DEPT (
   RF_REG_GND_ID ASC
);

/*==============================================================*/
/* Index : RF_DEPT_FK1_5                                        */
/*==============================================================*/
create index RF_DEPT_FK1_5 on RF_DEPT (
   RF_REG_RT_ID ASC
);

/*==============================================================*/
/* Index : RF_DEPT_FK1_6                                        */
/*==============================================================*/
create index RF_DEPT_FK1_6 on RF_DEPT (
   RF_REGECO_ID ASC
);

/*==============================================================*/
/* Index : RF_DEPT_UN1_1                                        */
/*==============================================================*/
create unique index RF_DEPT_UN1_1 on RF_DEPT (
   RF_DEPT_COD ASC
);

grant SELECT on RF_DEPT to PUBLIC;

grant REFERENCES on RF_DEPT to PUBLIC;

grant REFERENCES on RF_DEPT to PUBLIC;

grant SELECT on RF_DEPT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_DEVI                                              */
/*==============================================================*/
create table RF_DEVI  (
   RF_DEVI_COD          VARCHAR2(3)                     not null,
   RF_DEVI_LIB          VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_DEVI_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_DEVI is
'Devise';

comment on column RF_DEVI.RF_DEVI_COD is
'Code de la devise';

comment on column RF_DEVI.RF_DEVI_LIB is
'Clair de la devise';

comment on column RF_DEVI.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_DEVI.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_DEVI
   add constraint RF_DEVI_PK1_1 primary key (RF_DEVI_COD);

grant SELECT on RF_DEVI to PUBLIC;

grant REFERENCES on RF_DEVI to PUBLIC;

grant REFERENCES on RF_DEVI to PUBLIC;

grant SELECT on RF_DEVI to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_DEVI_NG                                           */
/*==============================================================*/
create table RF_DEVI_NG  (
   RF_DEVI_ID           INTEGER                         not null,
   RF_DEVI_CURR1        VARCHAR2(5)                     not null,
   RF_DEVI_ETXTMD       VARCHAR2(40),
   RF_DEVI_ETXTSH       VARCHAR2(20),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_DEVI_NG is
'Table des devises CHORUS.';

comment on column RF_DEVI_NG.RF_DEVI_ID is
'ID devise CHORUS.';

comment on column RF_DEVI_NG.RF_DEVI_CURR1 is
'Cle devise CHORUS.';

comment on column RF_DEVI_NG.RF_DEVI_ETXTMD is
'Texte descriptif devise CHORUS.';

comment on column RF_DEVI_NG.RF_DEVI_ETXTSH is
'Designation devise CHORUS.';

comment on column RF_DEVI_NG.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_DEVI_NG.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_DEVI_NG
   add constraint RF_DEVI_NG_PK1_1 primary key (RF_DEVI_ID);

alter table RF_DEVI_NG
   add constraint RF_DEVI_NG_UN1_1 unique (RF_DEVI_CURR1);

grant SELECT on RF_DEVI_NG to PUBLIC;

grant REFERENCES on RF_DEVI_NG to PUBLIC;

grant REFERENCES on RF_DEVI_NG to PUBLIC;

grant SELECT on RF_DEVI_NG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_DEVPAY                                            */
/*==============================================================*/
create table RF_DEVPAY  (
   RF_DEVI_COD          VARCHAR2(3)                     not null,
   RF_PAYS_COD          VARCHAR2(5)                     not null,
   RF_DEVPAY_TX         NUMBER(15,10)                   not null,
   RF_DEVPAY_DTTX       DATE,
   RF_DEVPAY_TOPEURO    NUMBER(1)                       not null
      constraint RF_DEVPAY_CK1_2 check (RF_DEVPAY_TOPEURO in (0,1)),
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_DEVPAY_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on column RF_DEVPAY.RF_DEVI_COD is
'Code de la devise';

comment on column RF_DEVPAY.RF_PAYS_COD is
'Code du pays';

comment on column RF_DEVPAY.RF_DEVPAY_TX is
'Taux de chancellerie';

comment on column RF_DEVPAY.RF_DEVPAY_DTTX is
'Date du taux de chancellerie';

comment on column RF_DEVPAY.RF_DEVPAY_TOPEURO is
'Indicateur pour savoir si le pays fait partie de la zone Euro';

comment on column RF_DEVPAY.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_DEVPAY.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_DEVPAY
   add constraint RF_DEVPAY_PK2_1 primary key (RF_DEVI_COD, RF_PAYS_COD);

/*==============================================================*/
/* Index : RF_DEVPAY_FK1_2                                      */
/*==============================================================*/
create index RF_DEVPAY_FK1_2 on RF_DEVPAY (
   RF_DEVI_COD ASC
);

/*==============================================================*/
/* Index : RF_DEVPAY_FK1_1                                      */
/*==============================================================*/
create index RF_DEVPAY_FK1_1 on RF_DEVPAY (
   RF_PAYS_COD ASC
);

grant SELECT on RF_DEVPAY to PUBLIC;

grant REFERENCES on RF_DEVPAY to PUBLIC;

grant REFERENCES on RF_DEVPAY to PUBLIC;

grant SELECT on RF_DEVPAY to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_DFON                                              */
/*==============================================================*/
create table RF_DFON  (
   RF_DFON_ID           INTEGER                         not null,
   RF_DFON_FUNC_AREA    VARCHAR2(16)                    not null,
   RF_DFON_DATETO       VARCHAR2(8),
   RF_DFON_DATEFROM     VARCHAR2(8),
   RF_DFON_FMDATEXP     VARCHAR2(8),
   RF_DFON_ETXTMD       VARCHAR2(40),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_DFON is
'Table des domaines fonctionnels CHORUS.';

comment on column RF_DFON.RF_DFON_ID is
'ID du domaines fonctionnels CHORUS.';

comment on column RF_DFON.RF_DFON_FUNC_AREA is
'Code du domaine fonctionnel CHORUS.';

comment on column RF_DFON.RF_DFON_DATETO is
'Fin de validite du domaine fonctionnel CHORUS.';

comment on column RF_DFON.RF_DFON_DATEFROM is
'Date de debut de validite du domaine fonctionnel CHORUS.';

comment on column RF_DFON.RF_DFON_FMDATEXP is
'Date d''expiration du domaine fonctionnel CHORUS.';

comment on column RF_DFON.RF_DFON_ETXTMD is
'Description du domaine fonctionnel CHORUS.';

comment on column RF_DFON.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_DFON.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_DFON
   add constraint RF_DFON_PK1_1 primary key (RF_DFON_ID);

alter table RF_DFON
   add constraint RF_DFON_UN1_1 unique (RF_DFON_FUNC_AREA);

grant SELECT on RF_DFON to PUBLIC;

grant REFERENCES on RF_DFON to PUBLIC;

grant REFERENCES on RF_DFON to PUBLIC;

grant SELECT on RF_DFON to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_DIPHDEF                                           */
/*==============================================================*/
create table RF_DIPHDEF  (
   RF_DIPHDEF_ID        INTEGER                         not null,
   RF_DIPHDEF_COD       VARCHAR2(10)                    not null,
   RF_HOMOLDIP_ID       INTEGER                         not null,
   RF_DIPHDEF_LIB       VARCHAR2(80),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_DIPHDEF_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_DIPHDEF is
'Table des diplomes hors defense';

comment on column RF_DIPHDEF.RF_DIPHDEF_ID is
'Identifiant du diplome hors defense';

comment on column RF_DIPHDEF.RF_DIPHDEF_COD is
'Abrege du diplome obtenu hors defense';

comment on column RF_DIPHDEF.RF_HOMOLDIP_ID is
'Identifiant du niveau homologation';

comment on column RF_DIPHDEF.RF_DIPHDEF_LIB is
'Libelle du diplome de l''education nationale';

comment on column RF_DIPHDEF.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_DIPHDEF.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_DIPHDEF
   add constraint RF_DIPHDEF_PK1_1 primary key (RF_DIPHDEF_ID);

/*==============================================================*/
/* Index : RF_DIPHDEF_FK1_1                                     */
/*==============================================================*/
create index RF_DIPHDEF_FK1_1 on RF_DIPHDEF (
   RF_HOMOLDIP_ID ASC
);

/*==============================================================*/
/* Index : RF_DIPHDEF_UN1_1                                     */
/*==============================================================*/
create unique index RF_DIPHDEF_UN1_1 on RF_DIPHDEF (
   RF_DIPHDEF_COD ASC
);

grant SELECT on RF_DIPHDEF to PUBLIC;

grant REFERENCES on RF_DIPHDEF to PUBLIC;

grant REFERENCES on RF_DIPHDEF to PUBLIC;

grant SELECT on RF_DIPHDEF to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_DIPTTA                                            */
/*==============================================================*/
create table RF_DIPTTA  (
   RF_DIPTTA_ID         INTEGER                         not null,
   RF_HOMOLDIP_ID       INTEGER                         not null,
   RF_DIPTTA_COD        VARCHAR2(4)                     not null,
   RF_DIPTTA_LIB        VARCHAR2(50),
   RF_DIPTTA_LIBA       VARCHAR2(30),
   RF_DIPTTA_TYP        VARCHAR2(4),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_DIPTTA_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_DIPTTA is
'Table des diplomes du TTA 129 (Diplome le plus haut)';

comment on column RF_DIPTTA.RF_DIPTTA_ID is
'Identifiant du diplome TTA 129';

comment on column RF_DIPTTA.RF_HOMOLDIP_ID is
'Identifiant du niveau homologation';

comment on column RF_DIPTTA.RF_DIPTTA_COD is
'Code abrege du diplome';

comment on column RF_DIPTTA.RF_DIPTTA_LIB is
'Libelle diplome TTA';

comment on column RF_DIPTTA.RF_DIPTTA_LIBA is
'Libelle abrege du diplome TTA';

comment on column RF_DIPTTA.RF_DIPTTA_TYP is
'Type diplome TTA';

comment on column RF_DIPTTA.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_DIPTTA.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_DIPTTA
   add constraint RF_DIPTTA_PK1_1 primary key (RF_DIPTTA_ID);

/*==============================================================*/
/* Index : RF_DIPTTA_FK1_1                                      */
/*==============================================================*/
create index RF_DIPTTA_FK1_1 on RF_DIPTTA (
   RF_HOMOLDIP_ID ASC
);

/*==============================================================*/
/* Index : RF_DIPTTA_UN1_1                                      */
/*==============================================================*/
create unique index RF_DIPTTA_UN1_1 on RF_DIPTTA (
   RF_DIPTTA_COD ASC
);

grant SELECT on RF_DIPTTA to PUBLIC;

grant REFERENCES on RF_DIPTTA to PUBLIC;

grant REFERENCES on RF_DIPTTA to PUBLIC;

grant SELECT on RF_DIPTTA to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_DIVI                                              */
/*==============================================================*/
create table RF_DIVI  (
   RF_DIVI_ID           INTEGER                         not null,
   RF_OACH_ID           INTEGER,
   RF_STE_CHORUS_ID     INTEGER,
   RF_DIVI_PLAN         VARCHAR2(4)                     not null,
   RF_DIVI_ETXTMD       VARCHAR2(40),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_DIVI is
'Tables des divisions';

comment on column RF_DIVI.RF_DIVI_ID is
'ID de la division';

comment on column RF_DIVI.RF_OACH_ID is
'ID de l''organisation d''achat de CHORUS.';

comment on column RF_DIVI.RF_DIVI_PLAN is
'division';

comment on column RF_DIVI.RF_DIVI_ETXTMD is
'Description de la division.';

comment on column RF_DIVI.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_DIVI.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_DIVI
   add constraint RF_DIVI_PK1_1 primary key (RF_DIVI_ID);

alter table RF_DIVI
   add constraint RF_DIVI_UN1_1 unique (RF_DIVI_PLAN);

grant SELECT on RF_DIVI to PUBLIC;

grant REFERENCES,SELECT on RF_DIVI to PUBLIC;

grant REFERENCES,SELECT on RF_DIVI to PUBLIC;

grant SELECT on RF_DIVI to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_DOM                                               */
/*==============================================================*/
create table RF_DOM  (
   RF_DOM_ID            INTEGER                         not null,
   RF_DOM_COD           VARCHAR2(4)                     not null,
   RF_DOM_LIB           VARCHAR2(60)                    not null,
   RF_DOM_EXPLES        VARCHAR2(200),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_DOM_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_DOM is
'Table des domaines d''investissement';

comment on column RF_DOM.RF_DOM_ID is
'Identifiant du domaine d''investissement';

comment on column RF_DOM.RF_DOM_COD is
'Code du domaine d''investissement';

comment on column RF_DOM.RF_DOM_LIB is
'Libelle du domaine d''investissement';

comment on column RF_DOM.RF_DOM_EXPLES is
'Exemples de domaine d''investissement';

comment on column RF_DOM.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_DOM.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_DOM
   add constraint RF_DOM_PK1_1 primary key (RF_DOM_ID);

/*==============================================================*/
/* Index : RF_DOM_UN1_1                                         */
/*==============================================================*/
create unique index RF_DOM_UN1_1 on RF_DOM (
   RF_DOM_COD ASC
);

grant SELECT on RF_DOM to PUBLIC;

grant REFERENCES on RF_DOM to PUBLIC;

grant REFERENCES on RF_DOM to PUBLIC;

grant SELECT on RF_DOM to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_DOMFONC                                           */
/*==============================================================*/
create table RF_DOMFONC  (
   RF_DOMFONC_ID        INTEGER                         not null,
   RF_PROG_ID           INTEGER                         not null,
   RF_DOMFONC_COD       VARCHAR2(10)                    not null,
   RF_DOMFONC_LIB       VARCHAR2(250)                   not null,
   RF_DOMFONC_LIBA      VARCHAR2(100)                   not null,
   RF_DOMFONC_ACTION    VARCHAR2(2)                     not null,
   RF_DOMFONC_SACTION   VARCHAR2(2)                     not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_DOMFONC_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_DOMFONC is
'Listes des domaines fonctionnels issus de CHORUS';

comment on column RF_DOMFONC.RF_PROG_ID is
'Identifiant du programme';

comment on column RF_DOMFONC.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_DOMFONC.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_DOMFONC
   add constraint RF_DOMFONC_PK1_1 primary key (RF_DOMFONC_ID);

/*==============================================================*/
/* Index : RF_DOMFONC_FK1_1                                     */
/*==============================================================*/
create index RF_DOMFONC_FK1_1 on RF_DOMFONC (
   RF_PROG_ID ASC
);

grant SELECT on RF_DOMFONC to PUBLIC;

grant REFERENCES on RF_DOMFONC to PUBLIC;

grant REFERENCES on RF_DOMFONC to PUBLIC;

grant SELECT on RF_DOMFONC to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_DOMTTA                                            */
/*==============================================================*/
create table RF_DOMTTA  (
   RF_DOMTTA_ID         INTEGER                         not null,
   RF_DOMTTA_COD        VARCHAR2(2)                     not null,
   RF_DOMTTA_LIB        VARCHAR2(50),
   RF_DOMTTA_LIBA       VARCHAR2(25),
   RF_DOMTTA_TYP        VARCHAR2(1),
   RF_DOMTTA_TRIGRAM    VARCHAR2(3),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_DOMTTA_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_DOMTTA is
'Table des domaines du TTA 129';

comment on column RF_DOMTTA.RF_DOMTTA_ID is
'Identifiant du domaine TTA 129';

comment on column RF_DOMTTA.RF_DOMTTA_COD is
'Code du domaine TTA 129';

comment on column RF_DOMTTA.RF_DOMTTA_LIB is
'Libelle du domaine TTA 129';

comment on column RF_DOMTTA.RF_DOMTTA_LIBA is
'Libelle abrege du domaine TTA 129';

comment on column RF_DOMTTA.RF_DOMTTA_TYP is
'Type de domaine TTA';

comment on column RF_DOMTTA.RF_DOMTTA_TRIGRAM is
'Trigramme du domaine TTA';

comment on column RF_DOMTTA.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_DOMTTA.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_DOMTTA
   add constraint RF_DOMTTA_PK1_1 primary key (RF_DOMTTA_ID);

/*==============================================================*/
/* Index : RF_DOMTTA_UN2_1                                      */
/*==============================================================*/
create unique index RF_DOMTTA_UN2_1 on RF_DOMTTA (
   RF_DOMTTA_COD ASC,
   RF_XTOPSUP ASC
);

grant SELECT on RF_DOMTTA to PUBLIC;

grant REFERENCES on RF_DOMTTA to PUBLIC;

grant REFERENCES on RF_DOMTTA to PUBLIC;

grant SELECT on RF_DOMTTA to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_DPSA                                              */
/*==============================================================*/
create table RF_DPSA  (
   RF_DPSA_ID           INTEGER                         not null,
   RF_DPSA_COD          VARCHAR2(2)                     not null,
   RF_DPSA_LIB          VARCHAR2(170)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_DPSA_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_DPSA is
'Decision au priofit d''un service attributaire';

comment on column RF_DPSA.RF_DPSA_ID is
'Identifiant de la decision';

comment on column RF_DPSA.RF_DPSA_COD is
'Code de la decision';

comment on column RF_DPSA.RF_DPSA_LIB is
'Libelle de la decision';

comment on column RF_DPSA.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_DPSA.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_DPSA
   add constraint RF_DPSA_PK1_1 primary key (RF_DPSA_ID);

/*==============================================================*/
/* Index : RF_DPSA_UN1_1                                        */
/*==============================================================*/
create unique index RF_DPSA_UN1_1 on RF_DPSA (
   RF_DPSA_COD ASC
);

grant SELECT on RF_DPSA to PUBLIC;

grant REFERENCES on RF_DPSA to PUBLIC;

grant REFERENCES on RF_DPSA to PUBLIC;

grant SELECT on RF_DPSA to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ECDV                                              */
/*==============================================================*/
create table RF_ECDV  (
   RF_ECDV_ID           INTEGER                         not null,
   RF_ECDV_COD          VARCHAR2(10)                    not null,
   RF_ECDV_LIB          VARCHAR2(200)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ECV_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ECDV is
'Echelon Central de Validation';

comment on column RF_ECDV.RF_ECDV_ID is
'Identifiant de l''echelon central de validation';

comment on column RF_ECDV.RF_ECDV_COD is
'Code de l''echelon central de validation';

comment on column RF_ECDV.RF_ECDV_LIB is
'Libelle de l''echelon central de validation';

comment on column RF_ECDV.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_ECDV.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ECDV
   add constraint RF_ECDV_PK1_1 primary key (RF_ECDV_ID);

grant SELECT on RF_ECDV to PUBLIC;

grant SELECT on RF_ECDV to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ECHELON                                           */
/*==============================================================*/
create table RF_ECHELON  (
   RF_ECHELON_ID        INTEGER                         not null,
   RF_ECHELON_NUM       INTEGER                         not null,
   RF_ECHELON_LIB       VARCHAR2(20),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ECHELON_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ECHELON is
'Table des echelons';

comment on column RF_ECHELON.RF_ECHELON_ID is
'Identifiant de ECHELON';

comment on column RF_ECHELON.RF_ECHELON_NUM is
'Numero d''echelon ';

comment on column RF_ECHELON.RF_ECHELON_LIB is
'Libelle de l''echelon';

comment on column RF_ECHELON.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_ECHELON.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ECHELON
   add constraint RF_ECHELON_PK1_1 primary key (RF_ECHELON_ID);

/*==============================================================*/
/* Index : RF_ECHELON_UN1_1                                     */
/*==============================================================*/
create unique index RF_ECHELON_UN1_1 on RF_ECHELON (
   RF_ECHELON_NUM ASC
);

grant SELECT on RF_ECHELON to PUBLIC;

grant REFERENCES on RF_ECHELON to PUBLIC;

grant REFERENCES on RF_ECHELON to PUBLIC;

grant SELECT on RF_ECHELON to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_EIDV                                              */
/*==============================================================*/
create table RF_EIDV  (
   RF_EIDV_ID           INTEGER                         not null,
   RF_EIDV_COD          VARCHAR2(10)                    not null,
   RF_EIDV_LIB          VARCHAR2(200)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_EIDV_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_EIDV is
'Echelon Intermediaire de Validation';

comment on column RF_EIDV.RF_EIDV_ID is
'Identifiant de l''echelon Intermediaire de Validation';

comment on column RF_EIDV.RF_EIDV_COD is
'Code de l''echelon Intermediaire de Validation';

comment on column RF_EIDV.RF_EIDV_LIB is
'Libelle de l''echelon Intermediaire de Validation';

comment on column RF_EIDV.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_EIDV.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_EIDV
   add constraint RF_EIDV_PK1_1 primary key (RF_EIDV_ID);

grant SELECT on RF_EIDV to PUBLIC;

grant SELECT on RF_EIDV to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ENGCENGJ                                          */
/*==============================================================*/
create table RF_ENGCENGJ  (
   RF_TMVT_COD          VARCHAR2(2)                     not null,
   RF_TENGC_COD         VARCHAR2(2)                     not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ENGCENGJ_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on column RF_ENGCENGJ.RF_TMVT_COD is
'Code Type mouvement';

comment on column RF_ENGCENGJ.RF_TENGC_COD is
'Type Engagement Comptable CFD';

comment on column RF_ENGCENGJ.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_ENGCENGJ.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ENGCENGJ
   add constraint RF_ENGCENGJ_PK2_1 primary key (RF_TMVT_COD, RF_TENGC_COD);

/*==============================================================*/
/* Index : RF_ENGCENGJ_FK1_2                                    */
/*==============================================================*/
create index RF_ENGCENGJ_FK1_2 on RF_ENGCENGJ (
   RF_TMVT_COD ASC
);

/*==============================================================*/
/* Index : RF_ENGCENGJ_FK1_1                                    */
/*==============================================================*/
create index RF_ENGCENGJ_FK1_1 on RF_ENGCENGJ (
   RF_TENGC_COD ASC
);

grant SELECT on RF_ENGCENGJ to PUBLIC;

grant REFERENCES on RF_ENGCENGJ to PUBLIC;

grant REFERENCES on RF_ENGCENGJ to PUBLIC;

grant SELECT on RF_ENGCENGJ to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_EOTP                                              */
/*==============================================================*/
create table RF_EOTP  (
   RF_EOTP_ID           INTEGER                         not null,
   RF_EOTP_EWBSELEMNT   VARCHAR2(24)                    not null,
   RF_EOTP_ERF_S_SYS    VARCHAR2(5),
   RF_EOTP_ERFBOLIMP    VARCHAR2(1),
   RF_EOTP_ERFBOLFAC    VARCHAR2(1),
   RF_EOTP_TXTSH        VARCHAR2(20),
   RF_EOTP_TXTLG        VARCHAR2(60),
   RF_EOTP_TXTMD        VARCHAR2(40),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_EOTP is
'Table des elements d''OTP de CHORUS.';

comment on column RF_EOTP.RF_EOTP_ID is
'ID de l''element d''OTP de CHORUS.';

comment on column RF_EOTP.RF_EOTP_EWBSELEMNT is
'Code de l''element d''OTP de CHORUS.';

comment on column RF_EOTP.RF_EOTP_ERF_S_SYS is
'Statut systeme de l''element d''OTP de CHORUS.';

comment on column RF_EOTP.RF_EOTP_ERFBOLIMP is
'Element d''imputation de l''element d''OTP de CHORUS.';

comment on column RF_EOTP.RF_EOTP_ERFBOLFAC is
'2lement de facturation de l''element d''OTP de CHORUS.';

comment on column RF_EOTP.RF_EOTP_TXTSH is
'Description synthetique de l''element d''OTP de CHORUS.';

comment on column RF_EOTP.RF_EOTP_TXTLG is
'Description longue de l''element d''OTP de CHORUS.';

comment on column RF_EOTP.RF_EOTP_TXTMD is
'Description moyenne de l''element d''OTP de CHORUS.';

comment on column RF_EOTP.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_EOTP.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_EOTP
   add constraint RF_EOTP_PK1_1 primary key (RF_EOTP_ID);

alter table RF_EOTP
   add constraint RF_EOTP_UN1_1 unique (RF_EOTP_EWBSELEMNT);

grant SELECT on RF_EOTP to PUBLIC;

grant REFERENCES on RF_EOTP to PUBLIC;

grant REFERENCES on RF_EOTP to PUBLIC;

grant SELECT on RF_EOTP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ETAN                                              */
/*==============================================================*/
create table RF_ETAN  (
   RF_ETAN_COD          VARCHAR2(2)                     not null,
   RF_ETAN_LIB          VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ETAN_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ETAN is
'Etat NDL';

comment on column RF_ETAN.RF_ETAN_COD is
'Code etat NDL';

comment on column RF_ETAN.RF_ETAN_LIB is
'Code etat NDL';

comment on column RF_ETAN.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_ETAN.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ETAN
   add constraint RF_ETAN_PK1_1 primary key (RF_ETAN_COD);

grant SELECT on RF_ETAN to PUBLIC;

grant REFERENCES on RF_ETAN to PUBLIC;

grant REFERENCES on RF_ETAN to PUBLIC;

grant SELECT on RF_ETAN to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ETATENT                                           */
/*==============================================================*/
create table RF_ETATENT  (
   RF_ETATENT_ID        INTEGER                         not null,
   RF_ETATENT_COD       VARCHAR2(3)                     not null,
   RF_ETATENT_LIB       VARCHAR2(50),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ETAENT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ETATENT is
'Etat entretien';

comment on column RF_ETATENT.RF_ETATENT_ID is
'RF_ETATENT_ID';

comment on column RF_ETATENT.RF_ETATENT_COD is
'Code';

comment on column RF_ETATENT.RF_ETATENT_LIB is
'Libelle';

comment on column RF_ETATENT.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_ETATENT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ETATENT
   add constraint RF_ETATENT_PK1_1 primary key (RF_ETATENT_ID);

/*==============================================================*/
/* Index : RF_ETATENT_UN1_1                                     */
/*==============================================================*/
create unique index RF_ETATENT_UN1_1 on RF_ETATENT (
   RF_ETATENT_COD ASC
);

grant SELECT on RF_ETATENT to PUBLIC;

grant REFERENCES on RF_ETATENT to PUBLIC;

grant REFERENCES on RF_ETATENT to PUBLIC;

grant SELECT on RF_ETATENT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ETATOPE                                           */
/*==============================================================*/
create table RF_ETATOPE  (
   RF_ETATOPE_ID        INTEGER                         not null,
   RF_ETATOPE_LIB       VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ETATOPE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ETATOPE is
'Table contenant la liste des etats des operations - issue de PLIMAT';

comment on column RF_ETATOPE.RF_ETATOPE_ID is
'Identifiant de l''etat des operations';

comment on column RF_ETATOPE.RF_ETATOPE_LIB is
'Libelle de l''etat des operations';

comment on column RF_ETATOPE.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_ETATOPE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ETATOPE
   add constraint RF_ETATOPE_PK1_1 primary key (RF_ETATOPE_ID);

grant SELECT on RF_ETATOPE to PUBLIC;

grant REFERENCES on RF_ETATOPE to PUBLIC;

grant REFERENCES on RF_ETATOPE to PUBLIC;

grant SELECT on RF_ETATOPE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_FCTCPT                                            */
/*==============================================================*/
create table RF_FCTCPT  (
   RF_FCTCPT_ID         INTEGER                         not null,
   RF_FCTCPT_DES        VARCHAR2(80),
   RF_FCTCPT_CODRE      VARCHAR2(3),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

alter table RF_FCTCPT
   add constraint RF_FCTCPT_PK1_1 primary key (RF_FCTCPT_ID);

/*==============================================================*/
/* Index : RF_FCTCPT_PK1_1                                      */
/*==============================================================*/
create unique index RF_FCTCPT_PK1_1 on RF_FCTCPT (
   RF_FCTCPT_ID ASC
);

grant SELECT on RF_FCTCPT to PUBLIC;

grant REFERENCES on RF_FCTCPT to PUBLIC;

grant REFERENCES on RF_FCTCPT to PUBLIC;

grant SELECT on RF_FCTCPT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_FCTN                                              */
/*==============================================================*/
create table RF_FCTN  (
   RF_FCTN_COD          VARCHAR2(1)                     not null,
   RF_FCTN_LIB          VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_FCTN_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_FCTN is
'Fonction';

comment on column RF_FCTN.RF_FCTN_COD is
'Code Fonction';

comment on column RF_FCTN.RF_FCTN_LIB is
'Clair Fonction';

comment on column RF_FCTN.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_FCTN.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_FCTN
   add constraint RF_FCTN_PK1_1 primary key (RF_FCTN_COD);

grant SELECT on RF_FCTN to PUBLIC;

grant REFERENCES on RF_FCTN to PUBLIC;

grant REFERENCES on RF_FCTN to PUBLIC;

grant SELECT on RF_FCTN to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_FCTRPR                                            */
/*==============================================================*/
create table RF_FCTRPR  (
   RF_FCTN_COD          VARCHAR2(1)                     not null,
   RF_PROD_COD          VARCHAR2(6)                     not null,
   RF_TRAN_COD          VARCHAR2(2)                     not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_FCTRPR_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on column RF_FCTRPR.RF_FCTN_COD is
'Code Fonction';

comment on column RF_FCTRPR.RF_PROD_COD is
'Code Ligne Produit';

comment on column RF_FCTRPR.RF_TRAN_COD is
'Code Tranche';

comment on column RF_FCTRPR.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_FCTRPR.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_FCTRPR
   add constraint RF_FCTRPR_PK3_1 primary key (RF_FCTN_COD, RF_PROD_COD, RF_TRAN_COD);

/*==============================================================*/
/* Index : RF_FCTRPR_PK3_1                                      */
/*==============================================================*/
create unique index RF_FCTRPR_PK3_1 on RF_FCTRPR (
   RF_PROD_COD ASC,
   RF_FCTN_COD ASC,
   RF_TRAN_COD ASC
);

/*==============================================================*/
/* Index : RF_FCTRPR_FK1_3                                      */
/*==============================================================*/
create index RF_FCTRPR_FK1_3 on RF_FCTRPR (
   RF_FCTN_COD ASC
);

/*==============================================================*/
/* Index : RF_FCTRPR_FK1_2                                      */
/*==============================================================*/
create index RF_FCTRPR_FK1_2 on RF_FCTRPR (
   RF_PROD_COD ASC
);

/*==============================================================*/
/* Index : RF_FCTRPR_FK1_1                                      */
/*==============================================================*/
create index RF_FCTRPR_FK1_1 on RF_FCTRPR (
   RF_TRAN_COD ASC
);

grant SELECT on RF_FCTRPR to PUBLIC;

grant REFERENCES on RF_FCTRPR to PUBLIC;

grant REFERENCES on RF_FCTRPR to PUBLIC;

grant SELECT on RF_FCTRPR to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_FCTSITE                                           */
/*==============================================================*/
create table RF_FCTSITE  (
   RF_FCTSITE_ID        INTEGER                         not null,
   RF_CTUTIL_ID         INTEGER,
   RF_FCTSITE_DES       VARCHAR2(80),
   RF_FCTSITE_CODRE     VARCHAR2(4),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

alter table RF_FCTSITE
   add constraint RF_FCTSITE_PK1_1 primary key (RF_FCTSITE_ID);

/*==============================================================*/
/* Index : RF_FCTSITE_PK1_1                                     */
/*==============================================================*/
create unique index RF_FCTSITE_PK1_1 on RF_FCTSITE (
   RF_FCTSITE_ID ASC
);

/*==============================================================*/
/* Index : RF_FCTSITE_FK1_1                                     */
/*==============================================================*/
create index RF_FCTSITE_FK1_1 on RF_FCTSITE (
   RF_CTUTIL_ID ASC
);

grant SELECT on RF_FCTSITE to PUBLIC;

grant REFERENCES on RF_FCTSITE to PUBLIC;

grant REFERENCES on RF_FCTSITE to PUBLIC;

grant SELECT on RF_FCTSITE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_FCTTTA                                            */
/*==============================================================*/
create table RF_FCTTTA  (
   RF_FCTTTA_ID         INTEGER                         not null,
   RF_FCTTTA_COD        VARCHAR2(4)                     not null,
   RF_DOMTTA_ID         INTEGER                         not null,
   RF_HOMOLDIP_ID       INTEGER,
   RF_ORDRE_ID          INTEGER,
   RF_FCTTTA_LIB        VARCHAR2(60),
   RF_FCTTTA_NR         VARCHAR2(2)                     not null,
   RF_FCTTTA_LIBA       VARCHAR2(25)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_FCTTTA_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_FCTTTA is
'Table des fonctions du TTA129';

comment on column RF_FCTTTA.RF_FCTTTA_ID is
'Identifiant fonction TTA';

comment on column RF_FCTTTA.RF_FCTTTA_COD is
'Code fonction TTA';

comment on column RF_FCTTTA.RF_DOMTTA_ID is
'Identifiant du domaine TTA 129';

comment on column RF_FCTTTA.RF_HOMOLDIP_ID is
'Identifiant du niveau homologation';

comment on column RF_FCTTTA.RF_ORDRE_ID is
'Identifiant de ORDRE';

comment on column RF_FCTTTA.RF_FCTTTA_LIB is
'Libelle fonction TTA 129';

comment on column RF_FCTTTA.RF_FCTTTA_NR is
'Niveau de responsabilite de la fonction TTA';

comment on column RF_FCTTTA.RF_FCTTTA_LIBA is
'Libelle abrege de la fonction TTA';

comment on column RF_FCTTTA.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_FCTTTA.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_FCTTTA
   add constraint RF_FCTTTA_PK1_1 primary key (RF_FCTTTA_ID);

/*==============================================================*/
/* Index : RF_FCTTTA_FK1_1                                      */
/*==============================================================*/
create index RF_FCTTTA_FK1_1 on RF_FCTTTA (
   RF_DOMTTA_ID ASC
);

/*==============================================================*/
/* Index : RF_FCTTTA_FK1_2                                      */
/*==============================================================*/
create index RF_FCTTTA_FK1_2 on RF_FCTTTA (
   RF_HOMOLDIP_ID ASC
);

/*==============================================================*/
/* Index : RF_FCTTTA_UN1_1                                      */
/*==============================================================*/
create unique index RF_FCTTTA_UN1_1 on RF_FCTTTA (
   RF_FCTTTA_COD ASC
);

/*==============================================================*/
/* Index : RF_FCTTTA_FK1_3                                      */
/*==============================================================*/
create index RF_FCTTTA_FK1_3 on RF_FCTTTA (
   RF_ORDRE_ID ASC
);

grant SELECT on RF_FCTTTA to PUBLIC;

grant REFERENCES on RF_FCTTTA to PUBLIC;

grant REFERENCES on RF_FCTTTA to PUBLIC;

grant SELECT on RF_FCTTTA to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_FIMO                                              */
/*==============================================================*/
create table RF_FIMO  (
   RF_FIMO_ID           INTEGER                         not null,
   RF_STE_CHORUS_ID     INTEGER,
   RF_EOTP_ID           INTEGER,
   RF_CFIN_ID           INTEGER,
   RF_CIMO_ID           INTEGER,
   RF_DACT_ID           INTEGER,
   RF_FOND_ID           INTEGER,
   RF_DFON_ID           INTEGER,
   RF_CCOU_ID           INTEGER,
   RF_FIMO_EASSET       VARCHAR2(4)                     not null,
   RF_FIMO_ASSET_MAIN   VARCHAR2(12)                    not null,
   RF_FIMO_DATETO       VARCHAR2(15)                    not null,
   RF_FIMO_DATEFROM     VARCHAR2(15),
   RF_FIMO_INVENT_NO    VARCHAR2(25),
   RF_FIMO_ERF_IMMA     VARCHAR2(15),
   RF_FIMO_CAPIT_DATE   VARCHAR2(15),
   RF_FIMO_ACQ_PER      INTEGER,
   RF_FIMO_ACQ_YEAR     INTEGER,
   RF_FIMO_FIRSTAQ      VARCHAR2(15),
   RF_FIMO_PL_RTMT_DT   VARCHAR2(15),
   RF_FIMO_ERFDATEHS    VARCHAR2(15),
   RF_FIMO_PP_LOCAT     VARCHAR2(10),
   RF_FIMO_APO_MRKDEL   VARCHAR2(1),
   RF_FIMO_FM_AREA      VARCHAR2(4),
   RF_FIMO_TXTSH        VARCHAR2(20),
   RF_FIMO_TXTMD        VARCHAR2(40),
   RF_FIMO_TXTLG        VARCHAR2(60),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_FIMO is
'Table des fiches d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_ID is
'ID de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_EOTP_ID is
'ID de l''element d''OTP de CHORUS.';

comment on column RF_FIMO.RF_CFIN_ID is
'ID Centre financier CHORUS.';

comment on column RF_FIMO.RF_CIMO_ID is
'ID de la categorie d''immobilisation.';

comment on column RF_FIMO.RF_DACT_ID is
'ID domaine d''activite.';

comment on column RF_FIMO.RF_FOND_ID is
'ID du fonds CHORUS.';

comment on column RF_FIMO.RF_DFON_ID is
'ID du domaines fonctionnels CHORUS.';

comment on column RF_FIMO.RF_CCOU_ID is
'ID centre de couts.';

comment on column RF_FIMO.RF_FIMO_EASSET is
'N° de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_ASSET_MAIN is
'N° principal de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_DATETO is
'Fin de validite de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_DATEFROM is
'Debut de validite de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_INVENT_NO is
'N° d''inventaire de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_ERF_IMMA is
'N° d''immatriculation de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_CAPIT_DATE is
'Date de mise en service de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_ACQ_PER is
'Periode de la premiere ecriture d''entree de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_ACQ_YEAR is
'Exercice de la premiere imputation d''entree de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_FIRSTAQ is
'Date de reference de la premiere ecriture de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_PL_RTMT_DT is
'Date de sortie previsionnelle de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_ERFDATEHS is
'Date de mise hors service de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_PP_LOCAT is
'Localisation de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_APO_MRKDEL is
'Temoin de suppression de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_FM_AREA is
'Perimetre financier de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_TXTSH is
'Description synthetique de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_TXTMD is
'Description moyenne de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_FIMO_TXTLG is
'Description longue de la fiche d''immobilisation CHORUS.';

comment on column RF_FIMO.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_FIMO.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_FIMO
   add constraint RF_FIMO_PK1_1 primary key (RF_FIMO_ID);

alter table RF_FIMO
   add constraint RF_FIMO_UN4_1 unique (RF_FIMO_EASSET, RF_FIMO_ASSET_MAIN, RF_FIMO_DATETO, RF_STE_CHORUS_ID);

/*==============================================================*/
/* Index : RF_FIMO_FK1_1                                        */
/*==============================================================*/
create index RF_FIMO_FK1_1 on RF_FIMO (
   RF_CIMO_ID ASC
);

/*==============================================================*/
/* Index : RF_FIMO_FK1_2                                        */
/*==============================================================*/
create index RF_FIMO_FK1_2 on RF_FIMO (
   RF_CCOU_ID ASC
);

/*==============================================================*/
/* Index : RF_FIMO_FK1_3                                        */
/*==============================================================*/
create index RF_FIMO_FK1_3 on RF_FIMO (
   RF_CFIN_ID ASC
);

/*==============================================================*/
/* Index : RF_FIMO_FK1_4                                        */
/*==============================================================*/
create index RF_FIMO_FK1_4 on RF_FIMO (
   RF_DACT_ID ASC
);

/*==============================================================*/
/* Index : RF_FIMO_FK1_5                                        */
/*==============================================================*/
create index RF_FIMO_FK1_5 on RF_FIMO (
   RF_DFON_ID ASC
);

/*==============================================================*/
/* Index : RF_FIMO_FK1_6                                        */
/*==============================================================*/
create index RF_FIMO_FK1_6 on RF_FIMO (
   RF_EOTP_ID ASC
);

/*==============================================================*/
/* Index : RF_FIMO_FK1_7                                        */
/*==============================================================*/
create index RF_FIMO_FK1_7 on RF_FIMO (
   RF_FOND_ID ASC
);

/*==============================================================*/
/* Index : RF_FIMO_FK1_8                                        */
/*==============================================================*/
create index RF_FIMO_FK1_8 on RF_FIMO (
   RF_STE_CHORUS_ID ASC
);

grant SELECT on RF_FIMO to PUBLIC;

grant REFERENCES on RF_FIMO to PUBLIC;

grant REFERENCES on RF_FIMO to PUBLIC;

grant SELECT on RF_FIMO to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_FJE                                               */
/*==============================================================*/
create table RF_FJE  (
   RF_FJE_COD           VARCHAR2(4)                     not null,
   RF_FJE_LIB           VARCHAR2(80)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_FJE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_FJE is
'Forme juridique d''entreprise';

comment on column RF_FJE.RF_FJE_COD is
'Code abrege a envoyer dans NDL';

comment on column RF_FJE.RF_FJE_LIB is
'Clair forme juridique d''entreprise';

comment on column RF_FJE.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_FJE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_FJE
   add constraint RF_FJE_PK1_1 primary key (RF_FJE_COD);

grant SELECT on RF_FJE to PUBLIC;

grant REFERENCES on RF_FJE to PUBLIC;

grant REFERENCES on RF_FJE to PUBLIC;

grant SELECT on RF_FJE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_FOND                                              */
/*==============================================================*/
create table RF_FOND  (
   RF_FOND_ID           INTEGER                         not null,
   RF_FOND_FUND         VARCHAR2(10)                    not null,
   RF_FOND_AREA         VARCHAR2(4)                     not null,
   RF_FOND_DATETO       VARCHAR2(15)                    not null,
   RF_FOND_DATEFROM     VARCHAR2(15),
   RF_FOND_FUNDTYPE     VARCHAR2(6),
   RF_FOND_DATEX        VARCHAR2(15),
   RF_FOND_DATAN        VARCHAR2(15),
   RF_FOND_TXTSH        VARCHAR2(20),
   RF_FOND_TXTMD        VARCHAR2(40),
   RF_FOND_TXTLG        VARCHAR2(60),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_FOND is
'Table des fonds CHORUS.';

comment on column RF_FOND.RF_FOND_ID is
'ID du fonds CHORUS.';

comment on column RF_FOND.RF_FOND_FUND is
'Code du fonds CHORUS.';

comment on column RF_FOND.RF_FOND_AREA is
'Perimetre financier du fonds CHORUS.';

comment on column RF_FOND.RF_FOND_DATETO is
'Date de fin de validite du fonds CHORUS.';

comment on column RF_FOND.RF_FOND_DATEFROM is
'Date de debut de validite du fonds CHORUS.';

comment on column RF_FOND.RF_FOND_FUNDTYPE is
'Type de fonds du fonds CHORUS.';

comment on column RF_FOND.RF_FOND_DATEX is
'Date d''expiration du fonds CHORUS.';

comment on column RF_FOND.RF_FOND_DATAN is
'Date d''annulation du fonds CHORUS.';

comment on column RF_FOND.RF_FOND_TXTSH is
'Description synthetique du fonds CHORUS.';

comment on column RF_FOND.RF_FOND_TXTMD is
'Description moyenne du fonds CHORUS.';

comment on column RF_FOND.RF_FOND_TXTLG is
'Description longue du fonds CHORUS.';

comment on column RF_FOND.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_FOND.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_FOND
   add constraint RF_FOND_PK1_1 primary key (RF_FOND_ID);

alter table RF_FOND
   add constraint RF_FOND_UN3_1 unique (RF_FOND_FUND, RF_FOND_AREA, RF_FOND_DATETO);

grant SELECT on RF_FOND to PUBLIC;

grant REFERENCES on RF_FOND to PUBLIC;

grant REFERENCES on RF_FOND to PUBLIC;

grant SELECT on RF_FOND to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_FORM                                              */
/*==============================================================*/
create table RF_FORM  (
   RF_FORM_COD          VARCHAR2(7)                     not null,
   RF_FORM_COD_REF      VARCHAR2(7),
   RF_FORM_CODFIL       VARCHAR2(120),
   RF_FORM_LIB          VARCHAR2(120)                   not null,
   RF_FORM_NUMREG       VARCHAR2(3),
   RF_FORM_CODETA       NUMBER(1)                       not null
      constraint RF_FORM_CK1_1 check (RF_FORM_CODETA in (0,1,2)),
   RF_FORM_VILL         VARCHAR2(40)                    not null,
   RF_FORM_DTDISS       DATE,
   RF_FORM_BENEF        VARCHAR2(5),
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_FORM_CK1_2 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_FORM is
'Formation';

comment on column RF_FORM.RF_FORM_COD is
'Code Credo';

comment on column RF_FORM.RF_FORM_COD_REF is
'Code Credo';

comment on column RF_FORM.RF_FORM_CODFIL is
'Formation Fille';

comment on column RF_FORM.RF_FORM_LIB is
'Clair Formation';

comment on column RF_FORM.RF_FORM_NUMREG is
'Num Regiment';

comment on column RF_FORM.RF_FORM_CODETA is
'Etat existant ou Futur';

comment on column RF_FORM.RF_FORM_VILL is
'Ville Implantation';

comment on column RF_FORM.RF_FORM_DTDISS is
'Date de dissolution de la formation';

comment on column RF_FORM.RF_FORM_BENEF is
'Beneficiaire de formation';

comment on column RF_FORM.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_FORM.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_FORM
   add constraint RF_FORM_PK1_1 primary key (RF_FORM_COD);

/*==============================================================*/
/* Index : RF_FORM_FK1_1                                        */
/*==============================================================*/
create index RF_FORM_FK1_1 on RF_FORM (
   RF_FORM_COD_REF ASC
);

grant SELECT on RF_FORM to PUBLIC;

grant REFERENCES on RF_FORM to PUBLIC;

grant REFERENCES on RF_FORM to PUBLIC;

grant SELECT on RF_FORM to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_FORMPRI                                           */
/*==============================================================*/
create table RF_FORMPRI  (
   RF_FORMPRI_COD       VARCHAR2(1)                     not null,
   RF_FORMPRI_LIB       VARCHAR2(30)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_FORMPRI_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_FORMPRI is
'Forme de prix';

comment on column RF_FORMPRI.RF_FORMPRI_COD is
'Code de la forme de prix';

comment on column RF_FORMPRI.RF_FORMPRI_LIB is
'Clair de la forme de prix';

comment on column RF_FORMPRI.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_FORMPRI.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_FORMPRI
   add constraint RF_FORMPRI_PK1_1 primary key (RF_FORMPRI_COD);

grant SELECT on RF_FORMPRI to PUBLIC;

grant REFERENCES on RF_FORMPRI to PUBLIC;

grant REFERENCES on RF_FORMPRI to PUBLIC;

grant SELECT on RF_FORMPRI to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_GACH                                              */
/*==============================================================*/
create table RF_GACH  (
   RF_GACH_ID           INTEGER                         not null,
   RF_GACH_PUR_GROUP    VARCHAR2(3)                     not null,
   RF_GACH_ETXSH        VARCHAR2(20),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_GACH is
'Table des groupes d''acheteurs CHORUS.';

comment on column RF_GACH.RF_GACH_ID is
'ID du groupe d''acheteurs CHORUS.';

comment on column RF_GACH.RF_GACH_PUR_GROUP is
'Code du groupe d''acheteurs CHORUS.';

comment on column RF_GACH.RF_GACH_ETXSH is
'Description du groupe d''acheteurs CHORUS.';

comment on column RF_GACH.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_GACH.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_GACH
   add constraint RF_GACH_PK1_1 primary key (RF_GACH_ID);

alter table RF_GACH
   add constraint RF_GACH_UN1_1 unique (RF_GACH_PUR_GROUP);

grant SELECT on RF_GACH to PUBLIC;

grant REFERENCES on RF_GACH to PUBLIC;

grant REFERENCES on RF_GACH to PUBLIC;

grant SELECT on RF_GACH to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_GCC                                               */
/*==============================================================*/
create table RF_GCC  (
   RF_GCC_COD           VARCHAR2(2)                     not null,
   RF_GCC_LIB           VARCHAR2(25)                    not null,
   RF_GCC_LIBA          VARCHAR2(15)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_GCC_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_GCC is
'Gouverneur de credit';

comment on column RF_GCC.RF_GCC_COD is
'Code gouverneur de credit';

comment on column RF_GCC.RF_GCC_LIB is
'Libelle du gouverneur de credit';

comment on column RF_GCC.RF_GCC_LIBA is
'Libelle court du gouverneur de credit';

comment on column RF_GCC.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_GCC.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_GCC
   add constraint RF_GCC_PK1_1 primary key (RF_GCC_COD);

grant SELECT on RF_GCC to PUBLIC;

grant REFERENCES on RF_GCC to PUBLIC;

grant REFERENCES on RF_GCC to PUBLIC;

grant SELECT on RF_GCC to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_GCC_NG                                            */
/*==============================================================*/
create table RF_GCC_NG  (
   RF_GCC_ID            INTEGER                         not null,
   RF_GCC_COD           VARCHAR2(2)                     not null,
   RF_GCC_LIB           VARCHAR2(100)                   not null,
   RF_GCC_LIBA          VARCHAR2(15)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_GCC_CK1_2 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_GCC_NG is
'Gouverneur de credit - table avec nouvelle structure';

comment on column RF_GCC_NG.RF_GCC_ID is
'Identifiant du gouverneur de credit';

comment on column RF_GCC_NG.RF_GCC_COD is
'Code gouverneur de credit';

comment on column RF_GCC_NG.RF_GCC_LIB is
'Libelle du gouverneur de credit';

comment on column RF_GCC_NG.RF_GCC_LIBA is
'Libelle court du gouverneur de credit';

comment on column RF_GCC_NG.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_GCC_NG.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_GCC_NG
   add constraint RF_GCC_NG_PK1_1 primary key (RF_GCC_ID);

/*==============================================================*/
/* Index : RF_GCC_NG_UN1_1                                      */
/*==============================================================*/
create unique index RF_GCC_NG_UN1_1 on RF_GCC_NG (
   RF_GCC_COD ASC
);

grant SELECT on RF_GCC_NG to PUBLIC;

grant REFERENCES on RF_GCC_NG to PUBLIC;

grant REFERENCES on RF_GCC_NG to PUBLIC;

grant SELECT on RF_GCC_NG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_GCD                                               */
/*==============================================================*/
create table RF_GCD  (
   RF_GCC_COD           VARCHAR2(2)                     not null,
   RF_GCD_COD           VARCHAR2(2)                     not null,
   RF_GCD_LIB           VARCHAR2(50)                    not null,
   RF_GCD_RGLEMP        VARCHAR2(1)                     not null
      constraint RF_GCD_CK1_1 check (RF_GCD_RGLEMP in ('I','F','M')),
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_GCD_CK1_2 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_GCD is
'Gouverneur de credit deconcentre';

comment on column RF_GCD.RF_GCC_COD is
'Code gouverneur de credit';

comment on column RF_GCD.RF_GCD_COD is
'Identifiant gouverneur de credit deconcentre';

comment on column RF_GCD.RF_GCD_LIB is
'Libelle du gouverneur de credit deconcentre';

comment on column RF_GCD.RF_GCD_RGLEMP is
'Regle d''emploi des credits';

comment on column RF_GCD.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_GCD.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_GCD
   add constraint RF_GCD_PK2_1 primary key (RF_GCC_COD, RF_GCD_COD);

/*==============================================================*/
/* Index : RF_GCD_FK1_1                                         */
/*==============================================================*/
create index RF_GCD_FK1_1 on RF_GCD (
   RF_GCC_COD ASC
);

grant SELECT on RF_GCD to PUBLIC;

grant REFERENCES on RF_GCD to PUBLIC;

grant REFERENCES on RF_GCD to PUBLIC;

grant SELECT on RF_GCD to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_GES                                               */
/*==============================================================*/
create table RF_GES  (
   RF_GES_ID            INTEGER                         not null,
   RF_GES_NUM           VARCHAR2(1),
   RF_GES_LIB           VARCHAR2(50),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_GES_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_GES is
'SERVICE GESTIONNAIRE';

comment on column RF_GES.RF_GES_ID is
'Identifiant du service gestionnaire';

comment on column RF_GES.RF_GES_NUM is
'Code du service';

comment on column RF_GES.RF_GES_LIB is
'Libelle du service';

comment on column RF_GES.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_GES.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_GES
   add constraint RF_GES_PK1_1 primary key (RF_GES_ID);

/*==============================================================*/
/* Index : RF_GES_UN1_1                                         */
/*==============================================================*/
create unique index RF_GES_UN1_1 on RF_GES (
   RF_GES_NUM ASC
);

grant SELECT on RF_GES to PUBLIC;

grant REFERENCES on RF_GES to PUBLIC;

grant REFERENCES on RF_GES to PUBLIC;

grant SELECT on RF_GES to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_GMDS                                              */
/*==============================================================*/
create table RF_GMDS  (
   RF_GMDS_ID           INTEGER                         not null,
   RF_GMDS_MATL_GROUP   VARCHAR2(9)                     not null,
   RF_GMDS_ETXTSH       VARCHAR2(20),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_GMDS is
'Table des groupes de marchandises CHORUS.';

comment on column RF_GMDS.RF_GMDS_ID is
'ID du groupe de marchandises CHORUS.';

comment on column RF_GMDS.RF_GMDS_MATL_GROUP is
'Code du groupe de marchandises CHORUS.';

comment on column RF_GMDS.RF_GMDS_ETXTSH is
'Description du groupe de marchandises CHORUS.';

comment on column RF_GMDS.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_GMDS.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_GMDS
   add constraint RF_GMDS_PK1_1 primary key (RF_GMDS_ID);

alter table RF_GMDS
   add constraint RF_GMDS_UN1_1 unique (RF_GMDS_MATL_GROUP);

grant SELECT on RF_GMDS to PUBLIC;

grant REFERENCES on RF_GMDS to PUBLIC;

grant REFERENCES on RF_GMDS to PUBLIC;

grant SELECT on RF_GMDS to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_GRD                                               */
/*==============================================================*/
create table RF_GRD  (
   RF_GRD_COD           VARCHAR2(6)                     not null,
   RF_CTGRD_COD         VARCHAR2(1)                     not null,
   RF_GRD_CODA          VARCHAR2(4)                     not null,
   RF_GRD_LIB           VARCHAR2(50)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_GRD_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_GRD_LIBA          VARCHAR2(6),
   RF_GRD_TOPREF        INTEGER                        default 0 not null
      constraint RF_GRD_CK1_2 check (RF_GRD_TOPREF in (0,1)),
   RF_GRD_TOPCMOY       INTEGER                        default 0 not null
      constraint RF_GRD_CK1_3 check (RF_GRD_TOPCMOY in (0,1)),
   RF_GRD_CODMISS       NUMBER(2),
   RF_GRD_GRP           NUMBER(1)                       not null,
   RF_GRD_GRPFFSA       INTEGER
);

comment on table RF_GRD is
'Grade';

comment on column RF_GRD.RF_GRD_COD is
'Code grade';

comment on column RF_GRD.RF_CTGRD_COD is
'Code categorie grade';

comment on column RF_GRD.RF_GRD_CODA is
'Code grade abrege';

comment on column RF_GRD.RF_GRD_LIB is
'Clair grade';

comment on column RF_GRD.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_GRD.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_GRD.RF_GRD_LIBA is
'Libelle abrege du grade';

comment on column RF_GRD.RF_GRD_TOPREF is
'Top du grade de Reference';

comment on column RF_GRD.RF_GRD_TOPCMOY is
'Top du cout Moyen';

comment on column RF_GRD.RF_GRD_CODMISS is
'Code mission';

comment on column RF_GRD.RF_GRD_GRP is
'Chaque grade(militaire) a un groupe (1 ou 2)';

comment on column RF_GRD.RF_GRD_GRPFFSA is
'Groupe pour les FFSA (FraiDep)';

alter table RF_GRD
   add constraint RF_GRD_PK1_1 primary key (RF_GRD_COD);

/*==============================================================*/
/* Index : RF_GRD_FK1_1                                         */
/*==============================================================*/
create index RF_GRD_FK1_1 on RF_GRD (
   RF_CTGRD_COD ASC
);

grant SELECT on RF_GRD to PUBLIC;

grant REFERENCES on RF_GRD to PUBLIC;

grant REFERENCES on RF_GRD to PUBLIC;

grant SELECT on RF_GRD to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_GRDCMP                                            */
/*==============================================================*/
create table RF_GRDCMP  (
   RF_GRDCMP_ID         INTEGER                         not null,
   RF_GRDCMP_COD        VARCHAR2(3)                     not null,
   RF_GRDCMP_LIB        VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_GRDCMP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_GRDCMP is
'Rattachement aux grands camps nationaux';

comment on column RF_GRDCMP.RF_GRDCMP_ID is
'Identifiant du grand camp national';

comment on column RF_GRDCMP.RF_GRDCMP_COD is
'Code du grand camp national';

comment on column RF_GRDCMP.RF_GRDCMP_LIB is
'Libelle du grand camp national';

comment on column RF_GRDCMP.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_GRDCMP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_GRDCMP
   add constraint RF_GRDCMP_PK1_1 primary key (RF_GRDCMP_ID);

/*==============================================================*/
/* Index : RF_GRDCMP_UN1_1                                      */
/*==============================================================*/
create unique index RF_GRDCMP_UN1_1 on RF_GRDCMP (
   RF_GRDCMP_COD ASC
);

grant SELECT on RF_GRDCMP to PUBLIC;

grant REFERENCES on RF_GRDCMP to PUBLIC;

grant REFERENCES on RF_GRDCMP to PUBLIC;

grant SELECT on RF_GRDCMP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_GRDECH                                            */
/*==============================================================*/
create table RF_GRDECH  (
   RF_GRDECH_ID         INTEGER                         not null,
   RF_GRD_COD           VARCHAR2(6)                     not null,
   RF_ECHELON_ID        INTEGER                         not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_GRDECH_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_GRDECH is
'Table de liaison entre grade et echelon';

comment on column RF_GRDECH.RF_GRDECH_ID is
'Identifiant de Grade - Echelon';

comment on column RF_GRDECH.RF_GRD_COD is
'Code grade';

comment on column RF_GRDECH.RF_ECHELON_ID is
'Identifiant de ECHELON';

comment on column RF_GRDECH.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_GRDECH.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_GRDECH
   add constraint RF_GRDECH_PK1_1 primary key (RF_GRDECH_ID);

/*==============================================================*/
/* Index : RF_GRDECH_FK1_1                                      */
/*==============================================================*/
create index RF_GRDECH_FK1_1 on RF_GRDECH (
   RF_GRD_COD ASC
);

/*==============================================================*/
/* Index : RF_GRDECH_FK1_2                                      */
/*==============================================================*/
create index RF_GRDECH_FK1_2 on RF_GRDECH (
   RF_ECHELON_ID ASC
);

/*==============================================================*/
/* Index : RF_GRDECH_UN2_1                                      */
/*==============================================================*/
create unique index RF_GRDECH_UN2_1 on RF_GRDECH (
   RF_GRD_COD ASC,
   RF_ECHELON_ID ASC
);

grant SELECT on RF_GRDECH to PUBLIC;

grant REFERENCES on RF_GRDECH to PUBLIC;

grant REFERENCES on RF_GRDECH to PUBLIC;

grant SELECT on RF_GRDECH to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_GRIM                                              */
/*==============================================================*/
create table RF_GRIM  (
   RF_GRIM_ID           INTEGER                         not null,
   RF_ORGANISME_ID      INTEGER,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_GRIM_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_GRIM is
'gestionnaire du referentiel immobilier ministeriel';

comment on column RF_GRIM.RF_GRIM_ID is
'Identifiant du gestionnaire';

comment on column RF_GRIM.RF_ORGANISME_ID is
'Identifiant de l''organisme';

comment on column RF_GRIM.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_GRIM.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_GRIM
   add constraint RF_GRIM_PK1_1 primary key (RF_GRIM_ID);

/*==============================================================*/
/* Index : RF_GRIM_FK1_1                                        */
/*==============================================================*/
create index RF_GRIM_FK1_1 on RF_GRIM (
   RF_ORGANISME_ID ASC
);

grant SELECT on RF_GRIM to PUBLIC;

grant REFERENCES on RF_GRIM to PUBLIC;

grant REFERENCES on RF_GRIM to PUBLIC;

grant SELECT on RF_GRIM to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_HOMOLDIP                                          */
/*==============================================================*/
create table RF_HOMOLDIP  (
   RF_HOMOLDIP_ID       INTEGER                         not null,
   RF_HOMOLDIP_COD      VARCHAR2(3)                     not null,
   RF_HOMOLDIP_LIB      VARCHAR2(40),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_HOMOLDIP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_HOMOLDIP is
'Table des homologations des diplomes';

comment on column RF_HOMOLDIP.RF_HOMOLDIP_ID is
'Identifiant du niveau homologation';

comment on column RF_HOMOLDIP.RF_HOMOLDIP_COD is
'Nom niveau homologation';

comment on column RF_HOMOLDIP.RF_HOMOLDIP_LIB is
'Libelle niveau homologation';

comment on column RF_HOMOLDIP.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_HOMOLDIP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_HOMOLDIP
   add constraint RF_HOMOLDIP_PK1_1 primary key (RF_HOMOLDIP_ID);

/*==============================================================*/
/* Index : RF_HOMOLDIP_UN1_1                                    */
/*==============================================================*/
create unique index RF_HOMOLDIP_UN1_1 on RF_HOMOLDIP (
   RF_HOMOLDIP_COD ASC
);

grant SELECT on RF_HOMOLDIP to PUBLIC;

grant REFERENCES on RF_HOMOLDIP to PUBLIC;

grant REFERENCES on RF_HOMOLDIP to PUBLIC;

grant SELECT on RF_HOMOLDIP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_IMM                                               */
/*==============================================================*/
create table RF_IMM  (
   RF_IMM_COD           VARCHAR2(10)                    not null,
   RF_ORGEN_CODETN      VARCHAR2(4)                     not null,
   RF_ORGEN_CODETN_COMP VARCHAR2(4)                     not null,
   RF_ORGANISME_ID      INTEGER,
   RF_IMMIND_ID         INTEGER,
   RF_IMM_IDE           VARCHAR2(9)                     not null,
   RF_IMM_CLE           VARCHAR2(1)                     not null,
   RF_IMM_DEN           VARCHAR2(40),
   RF_IMM_AFF           VARCHAR2(1),
   RF_IMM_MIL           VARCHAR2(2),
   RF_IMM_FIS           VARCHAR2(3),
   RF_IMM_SIT           VARCHAR2(1),
   RF_IMM_DOM           VARCHAR2(3),
   RF_IMM_IND           VARCHAR2(1),
   RF_IMM_INF           VARCHAR2(5),
   RF_IMM_SUP           VARCHAR2(5),
   RF_IMM_VOI           VARCHAR2(4),
   RF_IMM_DES           VARCHAR2(30),
   RF_IMM_GA_DIS        VARCHAR2(3),
   RF_IMM_AE_DEN        VARCHAR2(35),
   RF_IMM_AE_DIS        VARCHAR2(3),
   RF_IMM_PO_DEN        VARCHAR2(35),
   RF_IMM_PO_DIS        VARCHAR2(3),
   RF_IMM_RO_DEN        VARCHAR2(35),
   RF_IMM_RO_DIS        VARCHAR2(3),
   RF_IMM_VF_DEN        VARCHAR2(35),
   RF_IMM_VF_DIS        VARCHAR2(3),
   RF_IMM_PED           VARCHAR2(1),
   RF_IMM_GESP          VARCHAR2(1),
   RF_IMM_STOT          INTEGER,
   RF_IMM_SHOD          INTEGER,
   RF_IMM_SDPU          INTEGER,
   RF_IMM_SDPR          INTEGER,
   RF_IMM_SNDO          INTEGER,
   RF_IMM_SAME          INTEGER,
   RF_IMM_SBAT          INTEGER,
   RF_IMM_SNCO          INTEGER,
   RF_IMM_SONF          INTEGER,
   RF_IMM_SIGESA        INTEGER,
   RF_IMM_SREM          INTEGER,
   RF_IMM_LCLO          VARCHAR2(3),
   RF_IMM_LVF           VARCHAR2(3),
   RF_IMM_LROU          VARCHAR2(3),
   RF_IMM_LPIS          VARCHAR2(3),
   RF_IMM_ESVE          VARCHAR2(6),
   RF_IMM_VRES          VARCHAR2(5),
   RF_IMM_VPIS          VARCHAR2(5),
   RF_IMM_UTM           VARCHAR2(11),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_IMM_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_IMM is
'Immeuble';

comment on column RF_IMM.RF_IMM_COD is
'Numero d''immeuble';

comment on column RF_IMM.RF_ORGEN_CODETN is
'Identification definitive des organismes';

comment on column RF_IMM.RF_ORGEN_CODETN_COMP is
'Identification definitive des organismes';

comment on column RF_IMM.RF_ORGANISME_ID is
'Identifiant de l''organisme';

comment on column RF_IMM.RF_IMMIND_ID is
'Identifiant de l''indicateur immeuble';

comment on column RF_IMM.RF_IMM_IDE is
'Identifiant Immeuble';

comment on column RF_IMM.RF_IMM_CLE is
'N° IMM Cle de calcul';

comment on column RF_IMM.RF_IMM_DEN is
'Denomination de l''immeuble';

comment on column RF_IMM.RF_IMM_AFF is
'Ministere affectataire';

comment on column RF_IMM.RF_IMM_MIL is
'Rattachement militaire';

comment on column RF_IMM.RF_IMM_FIS is
'Rattachement fiscal';

comment on column RF_IMM.RF_IMM_SIT is
'Zone de situation';

comment on column RF_IMM.RF_IMM_DOM is
'Domanialite preponderante';

comment on column RF_IMM.RF_IMM_IND is
'Indicateur immeuble';

comment on column RF_IMM.RF_IMM_INF is
'Numero de la voie inferieure';

comment on column RF_IMM.RF_IMM_SUP is
'Numero de la voie superieure';

comment on column RF_IMM.RF_IMM_VOI is
'Nature de la voie';

comment on column RF_IMM.RF_IMM_DES is
'Nom de la voie';

comment on column RF_IMM.RF_IMM_GA_DIS is
'Distance immeuble de la garnison';

comment on column RF_IMM.RF_IMM_AE_DEN is
'Aerodrome le plus proche';

comment on column RF_IMM.RF_IMM_AE_DIS is
'Distance aerodrome';

comment on column RF_IMM.RF_IMM_PO_DEN is
'Port le plus proche';

comment on column RF_IMM.RF_IMM_PO_DIS is
'Distance du port';

comment on column RF_IMM.RF_IMM_RO_DEN is
'Route a grande circulation';

comment on column RF_IMM.RF_IMM_RO_DIS is
'Distance de la route';

comment on column RF_IMM.RF_IMM_VF_DEN is
'Gare la plus proche';

comment on column RF_IMM.RF_IMM_VF_DIS is
'Distance de la gare';

comment on column RF_IMM.RF_IMM_PED is
'Categorie au PED';

comment on column RF_IMM.RF_IMM_GESP is
'Gestion speciale';

comment on column RF_IMM.RF_IMM_STOT is
'Emprise SAGRI de l''immeuble';

comment on column RF_IMM.RF_IMM_SHOD is
'SHOD Sagri de l''immeuble';

comment on column RF_IMM.RF_IMM_SDPU is
'Emprise domaine public';

comment on column RF_IMM.RF_IMM_SDPR is
'Emprise domaine prive';

comment on column RF_IMM.RF_IMM_SNDO is
'Emprise non domanial';

comment on column RF_IMM.RF_IMM_SAME is
'Surface amenagee de l''immeuble';

comment on column RF_IMM.RF_IMM_SBAT is
'Surface batie de l''immeuble';

comment on column RF_IMM.RF_IMM_SNCO is
'Surf non construite de l''immeuble';

comment on column RF_IMM.RF_IMM_SONF is
'Emprise geree par ONF';

comment on column RF_IMM.RF_IMM_SIGESA is
'Emprise geree par IGESA';

comment on column RF_IMM.RF_IMM_SREM is
'Emprise remise au domaine';

comment on column RF_IMM.RF_IMM_LCLO is
'Longueur cloturee';

comment on column RF_IMM.RF_IMM_LVF is
'Longueur voie ferree';

comment on column RF_IMM.RF_IMM_LROU is
'Longueur routes';

comment on column RF_IMM.RF_IMM_LPIS is
'Longueur pistes';

comment on column RF_IMM.RF_IMM_ESVE is
'Surfaces espaces verts';

comment on column RF_IMM.RF_IMM_VRES is
'Volume reserves eau';

comment on column RF_IMM.RF_IMM_VPIS is
'Volume des piscines';

comment on column RF_IMM.RF_IMM_UTM is
'Coordonnees UTM';

comment on column RF_IMM.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_IMM.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_IMM
   add constraint RF_IMM_PK1_1 primary key (RF_IMM_COD);

/*==============================================================*/
/* Index : RF_IMM_FK1_1                                         */
/*==============================================================*/
create index RF_IMM_FK1_1 on RF_IMM (
   RF_ORGEN_CODETN ASC
);

/*==============================================================*/
/* Index : RF_IMM_FK1_2                                         */
/*==============================================================*/
create index RF_IMM_FK1_2 on RF_IMM (
   RF_ORGEN_CODETN_COMP ASC
);

grant SELECT on RF_IMM to PUBLIC;

grant REFERENCES on RF_IMM to PUBLIC;

grant REFERENCES on RF_IMM to PUBLIC;

grant SELECT on RF_IMM to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_IMMCLAUTIL                                        */
/*==============================================================*/
create table RF_IMMCLAUTIL  (
   RF_IMMCLAUTIL_ID     INTEGER                         not null,
   RF_IMMCLAUTIL_COD    VARCHAR2(1)                     not null,
   RF_IMMCLAUTIL_LIB    VARCHAR2(100)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_CTAUTILIMM_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_IMMCLAUTIL is
'Classe d''utilisation d''un immeuble
1ere lettre de RF_CLAUTIL_CAT1
Remplace RF_CLAUTIL que l''on decompose en trois tables : RF_CLATILIMM, RF_CTUTIL et RF_SCTUTIL.';

comment on column RF_IMMCLAUTIL.RF_IMMCLAUTIL_ID is
'Identifiant de la classe d''utilisation';

comment on column RF_IMMCLAUTIL.RF_IMMCLAUTIL_COD is
'Code classe utilisation';

comment on column RF_IMMCLAUTIL.RF_IMMCLAUTIL_LIB is
'Libelle classe utilisation';

comment on column RF_IMMCLAUTIL.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_IMMCLAUTIL.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_IMMCLAUTIL
   add constraint RF_CLAUTILIMM_PK1_1 primary key (RF_IMMCLAUTIL_ID);

/*==============================================================*/
/* Index : RF_IMMCALUTIL_UN1_1                                  */
/*==============================================================*/
create unique index RF_IMMCALUTIL_UN1_1 on RF_IMMCLAUTIL (
   RF_IMMCLAUTIL_COD ASC
);

grant SELECT on RF_IMMCLAUTIL to PUBLIC;

grant REFERENCES on RF_IMMCLAUTIL to PUBLIC;

grant REFERENCES on RF_IMMCLAUTIL to PUBLIC;

grant SELECT on RF_IMMCLAUTIL to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_IMMEUBLE                                          */
/*==============================================================*/
create table RF_IMMEUBLE  (
   RF_IMMEUBLE_ID       INTEGER                         not null,
   RF_IMMIND_ID         INTEGER                         not null,
   RF_NATVOI_ID         INTEGER,
   RF_ORGANISME_ID      INTEGER,
   RF_COMMGAR_ID        INTEGER,
   RF_COMMADR_ID        INTEGER,
   RF_IMMEUBLE_COD      VARCHAR2(10)                    not null,
   RF_IMMEUBLE_DEN      VARCHAR2(40)                    not null,
   RF_IMMEUBLE_INFL     VARCHAR2(5),
   RF_IMMEUBLE_INFN     INTEGER,
   RF_IMMEUBLE_SUPN     INTEGER,
   RF_IMMEUBLE_SUPL     VARCHAR2(5),
   RF_IMMEUBLE_DES      VARCHAR2(200)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_IMM_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_IMMEUBLE is
'Immeuble';

comment on column RF_IMMEUBLE.RF_IMMEUBLE_ID is
'Identifiant de l''immeuble';

comment on column RF_IMMEUBLE.RF_IMMIND_ID is
'Identifiant de l''indicateur immeuble';

comment on column RF_IMMEUBLE.RF_NATVOI_ID is
'Identifiant de la nature de la voie';

comment on column RF_IMMEUBLE.RF_ORGANISME_ID is
'Identifiant de l''organisme';

comment on column RF_IMMEUBLE.RF_COMMGAR_ID is
'Identifiant de la commune de garnison';

comment on column RF_IMMEUBLE.RF_COMMADR_ID is
'Identifiant de la commune adresse';

comment on column RF_IMMEUBLE.RF_IMMEUBLE_COD is
'Code immeuble';

comment on column RF_IMMEUBLE.RF_IMMEUBLE_DEN is
'Denomination immeuble';

comment on column RF_IMMEUBLE.RF_IMMEUBLE_INFL is
'Lettre inferieur';

comment on column RF_IMMEUBLE.RF_IMMEUBLE_INFN is
'Numero inferieur';

comment on column RF_IMMEUBLE.RF_IMMEUBLE_SUPN is
'Numero superieur';

comment on column RF_IMMEUBLE.RF_IMMEUBLE_SUPL is
'Lettre superieur';

comment on column RF_IMMEUBLE.RF_IMMEUBLE_DES is
'Designation voie ou lieu dit';

comment on column RF_IMMEUBLE.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_IMMEUBLE.RF_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

alter table RF_IMMEUBLE
   add constraint RF_IMMEUBLE_PK1_1 primary key (RF_IMMEUBLE_ID);

/*==============================================================*/
/* Index : RF_IMMEUBLE_FK1_1                                    */
/*==============================================================*/
create index RF_IMMEUBLE_FK1_1 on RF_IMMEUBLE (
   RF_NATVOI_ID ASC
);

/*==============================================================*/
/* Index : RF_IMMEUBLE_FK1_2                                    */
/*==============================================================*/
create index RF_IMMEUBLE_FK1_2 on RF_IMMEUBLE (
   RF_ORGANISME_ID ASC
);

/*==============================================================*/
/* Index : RF_IMMEUBLE_FK1_3                                    */
/*==============================================================*/
create index RF_IMMEUBLE_FK1_3 on RF_IMMEUBLE (
   RF_COMMADR_ID ASC
);

/*==============================================================*/
/* Index : RF_IMMEUBLE_FK1_4                                    */
/*==============================================================*/
create index RF_IMMEUBLE_FK1_4 on RF_IMMEUBLE (
   RF_COMMGAR_ID ASC
);

/*==============================================================*/
/* Index : RF_IMMEUBLE_FK1_5                                    */
/*==============================================================*/
create index RF_IMMEUBLE_FK1_5 on RF_IMMEUBLE (
   RF_IMMIND_ID ASC
);

/*==============================================================*/
/* Index : RF_IMMEUBLE_UN1_1                                    */
/*==============================================================*/
create unique index RF_IMMEUBLE_UN1_1 on RF_IMMEUBLE (
   RF_IMMEUBLE_COD ASC
);

grant SELECT on RF_IMMEUBLE to PUBLIC;

grant REFERENCES on RF_IMMEUBLE to PUBLIC;

grant REFERENCES on RF_IMMEUBLE to PUBLIC;

grant SELECT on RF_IMMEUBLE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_IMMIND                                            */
/*==============================================================*/
create table RF_IMMIND  (
   RF_IMMIND_ID         INTEGER                         not null,
   RF_IMMIND_COD        INTEGER                         not null,
   RF_IMMIND_LIB        VARCHAR2(100)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_INDICIMM_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_IMMIND is
'Indicateur immeuble';

comment on column RF_IMMIND.RF_IMMIND_ID is
'Identifiant de l''indicateur immeuble';

comment on column RF_IMMIND.RF_IMMIND_COD is
'Code indicateur de recensement';

comment on column RF_IMMIND.RF_IMMIND_LIB is
'Denomination indicateur de recensement';

comment on column RF_IMMIND.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_IMMIND.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_IMMIND
   add constraint RF_IMMIND_PK1_1 primary key (RF_IMMIND_ID);

/*==============================================================*/
/* Index : RF_IMMIND_UN1_1                                      */
/*==============================================================*/
create unique index RF_IMMIND_UN1_1 on RF_IMMIND (
   RF_IMMIND_COD ASC
);

grant SELECT on RF_IMMIND to PUBLIC;

grant REFERENCES on RF_IMMIND to PUBLIC;

grant REFERENCES on RF_IMMIND to PUBLIC;

grant SELECT on RF_IMMIND to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_IMPE                                              */
/*==============================================================*/
create table RF_IMPE  (
   RF_IMPE_COD          VARCHAR2(6)                     not null,
   RF_TETAD_COD         VARCHAR2(1)                     not null,
   RF_IMPG_COD          VARCHAR2(6)                     not null,
   RF_IMPE_LIB          VARCHAR2(120)                   not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_IMPE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_IMPE is
'Imputation d''execution';

comment on column RF_IMPE.RF_IMPE_COD is
'Code imputation d''execution';

comment on column RF_IMPE.RF_TETAD_COD is
'Code type etat D';

comment on column RF_IMPE.RF_IMPG_COD is
'Code imputation de gestion';

comment on column RF_IMPE.RF_IMPE_LIB is
'Libelle Imputation Budgetaire';

comment on column RF_IMPE.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_IMPE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_IMPE
   add constraint RF_IMPE_PK1_1 primary key (RF_IMPE_COD);

/*==============================================================*/
/* Index : RF_IMPE_FK2_1                                        */
/*==============================================================*/
create index RF_IMPE_FK2_1 on RF_IMPE (
   RF_TETAD_COD ASC,
   RF_IMPG_COD ASC
);

grant SELECT on RF_IMPE to PUBLIC;

grant REFERENCES on RF_IMPE to PUBLIC;

grant REFERENCES on RF_IMPE to PUBLIC;

grant SELECT on RF_IMPE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_IMPE_NG                                           */
/*==============================================================*/
create table RF_IMPE_NG  (
   RF_IMPE_ID           INTEGER                         not null,
   RF_IMPG_ID           INTEGER,
   RF_IMPE_COD          VARCHAR2(6)                     not null,
   RF_IMPE_LIB          VARCHAR2(120)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_IMPE_CK1_2 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_IMPE_NG is
'Imputation d''execution - table avec nouvelle structure';

comment on column RF_IMPE_NG.RF_IMPE_ID is
'Identifiant de l''imputation d''execution';

comment on column RF_IMPE_NG.RF_IMPG_ID is
'Identifiant d el''imputation de gestion';

comment on column RF_IMPE_NG.RF_IMPE_COD is
'Code imputation d''execution';

comment on column RF_IMPE_NG.RF_IMPE_LIB is
'Libelle Imputation Budgetaire';

comment on column RF_IMPE_NG.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_IMPE_NG.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_IMPE_NG
   add constraint RF_IMPE_PK1_2 primary key (RF_IMPE_ID);

/*==============================================================*/
/* Index : RF_IMPE_NG_UN1_1                                     */
/*==============================================================*/
create unique index RF_IMPE_NG_UN1_1 on RF_IMPE_NG (
   RF_IMPE_COD ASC
);

grant SELECT on RF_IMPE_NG to PUBLIC;

grant REFERENCES on RF_IMPE_NG to PUBLIC;

grant REFERENCES on RF_IMPE_NG to PUBLIC;

grant SELECT on RF_IMPE_NG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_IMPG                                              */
/*==============================================================*/
create table RF_IMPG  (
   RF_TETAD_COD         VARCHAR2(1)                     not null,
   RF_IMPG_COD          VARCHAR2(6)                     not null,
   RF_TITR_COD          VARCHAR2(1)                     not null,
   RF_CDMB_COD          VARCHAR2(3)                     not null,
   RF_CPTCOM_COD        VARCHAR2(5),
   RF_SGC_COD           VARCHAR2(2),
   RF_GCC_COD           VARCHAR2(2)                     not null,
   RF_TPYR_COD          VARCHAR2(1)                     not null,
   RF_TIMPN_COD         VARCHAR2(1)                     not null,
   RF_IMPG_LIB          VARCHAR2(120)                   not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_IMPG_CK1_2 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_IMPG_TPYR_OLD     VARCHAR2(1)
);

comment on table RF_IMPG is
'Imputation de gestion';

comment on column RF_IMPG.RF_TETAD_COD is
'Code type etat D';

comment on column RF_IMPG.RF_IMPG_COD is
'Code imputation de gestion';

comment on column RF_IMPG.RF_TITR_COD is
'Code titre';

comment on column RF_IMPG.RF_CDMB_COD is
'Code ministere budget';

comment on column RF_IMPG.RF_CPTCOM_COD is
'Code compte de commerce';

comment on column RF_IMPG.RF_SGC_COD is
'Code Service Gestionnaire de credit';

comment on column RF_IMPG.RF_GCC_COD is
'Code gouverneur de credit';

comment on column RF_IMPG.RF_TPYR_COD is
'Type de Payeur';

comment on column RF_IMPG.RF_TIMPN_COD is
'Code type d''imputation budgetaire';

comment on column RF_IMPG.RF_IMPG_LIB is
'Libelle Imputation Budgetaire d''Execution';

comment on column RF_IMPG.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_IMPG.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_IMPG.RF_IMPG_TPYR_OLD is
'Ancien code du type de payeur';

alter table RF_IMPG
   add constraint RF_IMPG_PK2_1 primary key (RF_TETAD_COD, RF_IMPG_COD);

/*==============================================================*/
/* Index : RF_IMPG_FK1_1                                        */
/*==============================================================*/
create index RF_IMPG_FK1_1 on RF_IMPG (
   RF_TITR_COD ASC
);

/*==============================================================*/
/* Index : RF_IMPG_FK1_4                                        */
/*==============================================================*/
create index RF_IMPG_FK1_4 on RF_IMPG (
   RF_CDMB_COD ASC
);

/*==============================================================*/
/* Index : RF_IMPG_FK1_8                                        */
/*==============================================================*/
create index RF_IMPG_FK1_8 on RF_IMPG (
   RF_CPTCOM_COD ASC
);

/*==============================================================*/
/* Index : RF_IMPG_FK1_5                                        */
/*==============================================================*/
create index RF_IMPG_FK1_5 on RF_IMPG (
   RF_SGC_COD ASC
);

/*==============================================================*/
/* Index : RF_IMPG_FK1_3                                        */
/*==============================================================*/
create index RF_IMPG_FK1_3 on RF_IMPG (
   RF_GCC_COD ASC
);

/*==============================================================*/
/* Index : RF_IMPG_FK1_6                                        */
/*==============================================================*/
create index RF_IMPG_FK1_6 on RF_IMPG (
   RF_TPYR_COD ASC
);

/*==============================================================*/
/* Index : RF_IMPG_FK1_2                                        */
/*==============================================================*/
create index RF_IMPG_FK1_2 on RF_IMPG (
   RF_TIMPN_COD ASC
);

/*==============================================================*/
/* Index : RF_IMPG_FK1_7                                        */
/*==============================================================*/
create index RF_IMPG_FK1_7 on RF_IMPG (
   RF_TETAD_COD ASC
);

grant SELECT on RF_IMPG to PUBLIC;

grant REFERENCES on RF_IMPG to PUBLIC;

grant REFERENCES on RF_IMPG to PUBLIC;

grant SELECT on RF_IMPG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_IMPG_NG                                           */
/*==============================================================*/
create table RF_IMPG_NG  (
   RF_IMPG_ID           INTEGER                         not null,
   RF_GCC_ID            INTEGER,
   RF_TETAD_COD         VARCHAR2(1)                     not null,
   RF_IMPG_COD          VARCHAR2(6)                     not null,
   RF_TITR_COD          VARCHAR2(1)                     not null,
   RF_CDMB_COD          VARCHAR2(3)                     not null,
   RF_CPTCOM_COD        VARCHAR2(5),
   RF_SGC_COD           VARCHAR2(2),
   RF_TPYR_COD          VARCHAR2(1)                     not null,
   RF_TIMPN_COD         VARCHAR2(1)                     not null,
   RF_IMPG_LIB          VARCHAR2(120)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_IMPG_CK1_3 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_IMPG_TPYR_OLD     VARCHAR2(1)
);

comment on table RF_IMPG_NG is
'Imputation de gestion - Table avec nouvelle structure';

comment on column RF_IMPG_NG.RF_IMPG_ID is
'Identifiant d el''imputation de gestion';

comment on column RF_IMPG_NG.RF_GCC_ID is
'Identifiant du gouverneur de credit';

comment on column RF_IMPG_NG.RF_TETAD_COD is
'Code type etat D';

comment on column RF_IMPG_NG.RF_IMPG_COD is
'Code imputation de gestion';

comment on column RF_IMPG_NG.RF_TITR_COD is
'Code titre';

comment on column RF_IMPG_NG.RF_CDMB_COD is
'Code ministere budget';

comment on column RF_IMPG_NG.RF_CPTCOM_COD is
'Code compte de commerce';

comment on column RF_IMPG_NG.RF_SGC_COD is
'Code Service Gestionnaire de credit';

comment on column RF_IMPG_NG.RF_TPYR_COD is
'Type de Payeur';

comment on column RF_IMPG_NG.RF_TIMPN_COD is
'Code type d''imputation budgetaire';

comment on column RF_IMPG_NG.RF_IMPG_LIB is
'Libelle Imputation Budgetaire d''Execution';

comment on column RF_IMPG_NG.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_IMPG_NG.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_IMPG_NG.RF_IMPG_TPYR_OLD is
'Ancien code du type de payeur';

alter table RF_IMPG_NG
   add constraint RF_IMPG_PK1_1 primary key (RF_IMPG_ID);

/*==============================================================*/
/* Index : RF_IMPG_NG_FK1_1                                     */
/*==============================================================*/
create index RF_IMPG_NG_FK1_1 on RF_IMPG_NG (
   RF_TITR_COD ASC
);

/*==============================================================*/
/* Index : RF_IMPG_NG_FK1_4                                     */
/*==============================================================*/
create index RF_IMPG_NG_FK1_4 on RF_IMPG_NG (
   RF_CDMB_COD ASC
);

/*==============================================================*/
/* Index : RF_IMPG_NG_FK1_8                                     */
/*==============================================================*/
create index RF_IMPG_NG_FK1_8 on RF_IMPG_NG (
   RF_CPTCOM_COD ASC
);

/*==============================================================*/
/* Index : RF_IMPG_NG_FK1_5                                     */
/*==============================================================*/
create index RF_IMPG_NG_FK1_5 on RF_IMPG_NG (
   RF_SGC_COD ASC
);

/*==============================================================*/
/* Index : RF_IMPG_NG_FK1_6                                     */
/*==============================================================*/
create index RF_IMPG_NG_FK1_6 on RF_IMPG_NG (
   RF_TPYR_COD ASC
);

/*==============================================================*/
/* Index : RF_IMPG_NG_FK1_2                                     */
/*==============================================================*/
create index RF_IMPG_NG_FK1_2 on RF_IMPG_NG (
   RF_TIMPN_COD ASC
);

/*==============================================================*/
/* Index : RF_IMPG_NG_FK1_7                                     */
/*==============================================================*/
create index RF_IMPG_NG_FK1_7 on RF_IMPG_NG (
   RF_TETAD_COD ASC
);

/*==============================================================*/
/* Index : RF_IMPG_NG_UN2_1                                     */
/*==============================================================*/
create unique index RF_IMPG_NG_UN2_1 on RF_IMPG_NG (
   RF_TETAD_COD ASC,
   RF_IMPG_COD ASC
);

grant SELECT on RF_IMPG_NG to PUBLIC;

grant REFERENCES on RF_IMPG_NG to PUBLIC;

grant REFERENCES on RF_IMPG_NG to PUBLIC;

grant SELECT on RF_IMPG_NG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_INDM                                              */
/*==============================================================*/
create table RF_INDM  (
   RF_INDM_COD          VARCHAR2(1)                     not null,
   RF_INDM_LIB          VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_INDM_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_INDM is
'Indicateur marche';

comment on column RF_INDM.RF_INDM_COD is
'Code indicateur marche';

comment on column RF_INDM.RF_INDM_LIB is
'Clair indicateur marche';

comment on column RF_INDM.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_INDM.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_INDM
   add constraint RF_INDM_PK1_1 primary key (RF_INDM_COD);

grant SELECT on RF_INDM to PUBLIC;

grant REFERENCES on RF_INDM to PUBLIC;

grant REFERENCES on RF_INDM to PUBLIC;

grant SELECT on RF_INDM to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_LCLCATUTIL                                        */
/*==============================================================*/
create table RF_LCLCATUTIL  (
   RF_LCLCATUTIL_ID     INTEGER                         not null,
   RF_LCLCATUTIL_COD    VARCHAR2(2)                     not null,
   RF_LCLCATUTIL_LIB    VARCHAR2(100),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_LCLCATUTIL_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_LCLCATUTIL is
'Categorie classe utilisation local';

comment on column RF_LCLCATUTIL.RF_LCLCATUTIL_ID is
'RF_LCLCATUTIL_ID';

comment on column RF_LCLCATUTIL.RF_LCLCATUTIL_COD is
'Code';

comment on column RF_LCLCATUTIL.RF_LCLCATUTIL_LIB is
'Libelle';

comment on column RF_LCLCATUTIL.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_LCLCATUTIL.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_LCLCATUTIL
   add constraint RF_LCLCATUTIL_PK1_1 primary key (RF_LCLCATUTIL_ID);

/*==============================================================*/
/* Index : RF_LCLCATUTIL_UN1_1                                  */
/*==============================================================*/
create unique index RF_LCLCATUTIL_UN1_1 on RF_LCLCATUTIL (
   RF_LCLCATUTIL_COD ASC
);

grant SELECT on RF_LCLCATUTIL to PUBLIC;

grant REFERENCES on RF_LCLCATUTIL to PUBLIC;

grant REFERENCES on RF_LCLCATUTIL to PUBLIC;

grant SELECT on RF_LCLCATUTIL to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_LCLCLAUTIL                                        */
/*==============================================================*/
create table RF_LCLCLAUTIL  (
   RF_LCLCLAUTIL_ID     INTEGER                         not null,
   RF_LCLCATUTIL_ID     INTEGER                         not null,
   RF_LCLCLAUTIL_COD    VARCHAR2(3)                     not null,
   RF_LCLCLAUTIL_LIB    VARCHAR2(100),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_LCLCLAUTIL_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_LCLCLAUTIL is
'Classe utilisation local';

comment on column RF_LCLCLAUTIL.RF_LCLCLAUTIL_ID is
'RF_CLUTLOC_ID';

comment on column RF_LCLCLAUTIL.RF_LCLCATUTIL_ID is
'RF_LCLCATUTIL_ID';

comment on column RF_LCLCLAUTIL.RF_LCLCLAUTIL_COD is
'Code';

comment on column RF_LCLCLAUTIL.RF_LCLCLAUTIL_LIB is
'Libelle';

comment on column RF_LCLCLAUTIL.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_LCLCLAUTIL.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_PK1_1 primary key (RF_LCLCLAUTIL_ID);

/*==============================================================*/
/* Index : RF_LCLCLAUTIL_FK1_1                                  */
/*==============================================================*/
create index RF_LCLCLAUTIL_FK1_1 on RF_LCLCLAUTIL (
   RF_LCLCATUTIL_ID ASC
);

/*==============================================================*/
/* Index : RF_LCLCLAUTIL_UN2_1                                  */
/*==============================================================*/
create unique index RF_LCLCLAUTIL_UN2_1 on RF_LCLCLAUTIL (
   RF_LCLCATUTIL_ID ASC,
   RF_LCLCLAUTIL_COD ASC
);

grant SELECT on RF_LCLCLAUTIL to PUBLIC;

grant REFERENCES on RF_LCLCLAUTIL to PUBLIC;

grant REFERENCES on RF_LCLCLAUTIL to PUBLIC;

grant SELECT on RF_LCLCLAUTIL to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_LIGMER                                            */
/*==============================================================*/
create table RF_LIGMER  (
   RF_LIGMER_COD        VARCHAR2(6)                     not null,
   RF_TLIG_COD          VARCHAR2(1)                     not null,
   RF_LIGMER_LIB        VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_LIGMER_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_LIGMER is
'Ligne Mercure';

comment on column RF_LIGMER.RF_LIGMER_COD is
'Code Ligne Mercure';

comment on column RF_LIGMER.RF_TLIG_COD is
'Code Type Ligne Mercure';

comment on column RF_LIGMER.RF_LIGMER_LIB is
'Libelle Ligne Mercure';

comment on column RF_LIGMER.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_LIGMER.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_LIGMER
   add constraint RF_LIGMER_PK1_1 primary key (RF_LIGMER_COD);

/*==============================================================*/
/* Index : RF_LIGMER_FK1_1                                      */
/*==============================================================*/
create index RF_LIGMER_FK1_1 on RF_LIGMER (
   RF_TLIG_COD ASC
);

grant SELECT on RF_LIGMER to PUBLIC;

grant REFERENCES on RF_LIGMER to PUBLIC;

grant REFERENCES on RF_LIGMER to PUBLIC;

grant SELECT on RF_LIGMER to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_LOCI                                              */
/*==============================================================*/
create table RF_LOCI  (
   RF_LOCI_ID           INTEGER                         not null,
   RF_LOCI_LOCINT       VARCHAR2(8)                     not null,
   RF_LOCI_ETXTLG       VARCHAR2(60),
   RF_LOCI_REGION       VARCHAR2(30),
   RF_LOCI_NIVEAU       VARCHAR2(12),
   RF_LOCI_DEP          VARCHAR2(3),
   RF_LOCI_TXTDEP       VARCHAR2(25),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_LOCI is
'Table des localisations interministerielles de CHORUS.';

comment on column RF_LOCI.RF_LOCI_ID is
'ID de la localisation interministerielle de CHORUS.';

comment on column RF_LOCI.RF_LOCI_LOCINT is
'Code de la localisation interministerielle de CHORUS.';

comment on column RF_LOCI.RF_LOCI_ETXTLG is
'Description de la localisation interministerielle de CHORUS.';

comment on column RF_LOCI.RF_LOCI_REGION is
'Region de la localisation interministerielle de CHORUS.';

comment on column RF_LOCI.RF_LOCI_NIVEAU is
'Niveau de la localisation interministerielle de CHORUS.';

comment on column RF_LOCI.RF_LOCI_DEP is
'Departement de la localisation interministerielle de CHORUS.';

comment on column RF_LOCI.RF_LOCI_TXTDEP is
'Libelle departement de la localisation interministerielle de CHORUS.';

comment on column RF_LOCI.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_LOCI.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_LOCI
   add constraint RF_LOCI_PK1_1 primary key (RF_LOCI_ID);

alter table RF_LOCI
   add constraint RF_LOCI_UN1_1 unique (RF_LOCI_LOCINT);

grant SELECT on RF_LOCI to PUBLIC;

grant REFERENCES on RF_LOCI to PUBLIC;

grant REFERENCES on RF_LOCI to PUBLIC;

grant SELECT on RF_LOCI to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_LOCM                                              */
/*==============================================================*/
create table RF_LOCM  (
   RF_LOCM_ID           INTEGER                         not null,
   RF_LOCM_LOCMIN       VARCHAR2(22)                    not null,
   RF_LOCM_ETXTMD       VARCHAR2(40),
   RF_LOCM_CODMIN       VARCHAR2(5),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_LOCM is
'Table des localisations ministerielles de CHORUS.';

comment on column RF_LOCM.RF_LOCM_ID is
'ID de la localisation ministerielle de CHORUS.';

comment on column RF_LOCM.RF_LOCM_LOCMIN is
'Code de la localisation ministerielle de CHORUS.';

comment on column RF_LOCM.RF_LOCM_ETXTMD is
'Description de la localisation ministerielle de CHORUS.';

comment on column RF_LOCM.RF_LOCM_CODMIN is
'Code ministere de la localisation ministerielle de CHORUS.';

comment on column RF_LOCM.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_LOCM.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_LOCM
   add constraint RF_LOCM_PK1_1 primary key (RF_LOCM_ID);

alter table RF_LOCM
   add constraint RF_LOCM_UN1_1 unique (RF_LOCM_LOCMIN);

grant SELECT on RF_LOCM to PUBLIC;

grant REFERENCES on RF_LOCM to PUBLIC;

grant REFERENCES on RF_LOCM to PUBLIC;

grant SELECT on RF_LOCM to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_MACCES                                            */
/*==============================================================*/
create table RF_MACCES  (
   RF_MACCES_ID         INTEGER                         not null,
   RF_MACCES_COD        VARCHAR2(6)                     not null,
   RF_TACCES_ID         INTEGER                         not null,
   RF_MACCES_LIB        VARCHAR2(60)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_MACCES_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_MACCES is
'Definit les differents modes d''acces au corps ou au grade';

comment on column RF_MACCES.RF_MACCES_ID is
'Identifiant du mode d''acces';

comment on column RF_MACCES.RF_MACCES_COD is
'Abreviation du mode d''acces';

comment on column RF_MACCES.RF_TACCES_ID is
'Identifiant du type d''acces';

comment on column RF_MACCES.RF_MACCES_LIB is
'Libelle du mode d''acces ';

comment on column RF_MACCES.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_MACCES.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_MACCES
   add constraint RF_MACCES_PK1_1 primary key (RF_MACCES_ID);

/*==============================================================*/
/* Index : RF_MACCES_FK1_1                                      */
/*==============================================================*/
create index RF_MACCES_FK1_1 on RF_MACCES (
   RF_TACCES_ID ASC
);

/*==============================================================*/
/* Index : RF_MACCES_UN2_1                                      */
/*==============================================================*/
create unique index RF_MACCES_UN2_1 on RF_MACCES (
   RF_MACCES_COD ASC,
   RF_TACCES_ID ASC
);

grant SELECT on RF_MACCES to PUBLIC;

grant REFERENCES on RF_MACCES to PUBLIC;

grant REFERENCES on RF_MACCES to PUBLIC;

grant SELECT on RF_MACCES to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_MACCOR                                            */
/*==============================================================*/
create table RF_MACCOR  (
   RF_MACCOR_ID         INTEGER                         not null,
   RF_CORPS_ID          INTEGER                         not null,
   RF_MACCES_ID         INTEGER                         not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_MACCOR_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_MACCOR is
'Table de jointure entre MACCES et CORPS';

comment on column RF_MACCOR.RF_MACCOR_ID is
'Mode acces au corps';

comment on column RF_MACCOR.RF_CORPS_ID is
'Identifiant du corps';

comment on column RF_MACCOR.RF_MACCES_ID is
'Mode acces';

comment on column RF_MACCOR.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_MACCOR.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_MACCOR
   add constraint RF_MACCOR_PK1_1 primary key (RF_MACCOR_ID);

/*==============================================================*/
/* Index : RF_MACCOR_FK1_1                                      */
/*==============================================================*/
create index RF_MACCOR_FK1_1 on RF_MACCOR (
   RF_MACCES_ID ASC
);

/*==============================================================*/
/* Index : RF_MACCOR_FK1_2                                      */
/*==============================================================*/
create index RF_MACCOR_FK1_2 on RF_MACCOR (
   RF_CORPS_ID ASC
);

/*==============================================================*/
/* Index : RF_MACCOR_UN2_1                                      */
/*==============================================================*/
create unique index RF_MACCOR_UN2_1 on RF_MACCOR (
   RF_CORPS_ID ASC,
   RF_MACCES_ID ASC
);

grant SELECT on RF_MACCOR to PUBLIC;

grant REFERENCES on RF_MACCOR to PUBLIC;

grant REFERENCES on RF_MACCOR to PUBLIC;

grant SELECT on RF_MACCOR to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_MACGRD                                            */
/*==============================================================*/
create table RF_MACGRD  (
   RF_MACGRD_ID         INTEGER                         not null,
   RF_MACCES_ID         INTEGER                         not null,
   RF_GRD_COD           VARCHAR2(6)                     not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_MACGRD_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_MACGRD is
'Table de jointure entre MACCES et GRD';

comment on column RF_MACGRD.RF_MACGRD_ID is
'Mode acces au grade';

comment on column RF_MACGRD.RF_MACCES_ID is
'Mode acces';

comment on column RF_MACGRD.RF_GRD_COD is
'Code du grade';

comment on column RF_MACGRD.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_MACGRD.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_MACGRD
   add constraint RF_MACGRD_PK1_1 primary key (RF_MACGRD_ID);

/*==============================================================*/
/* Index : RF_MACGRD_FK1_1                                      */
/*==============================================================*/
create index RF_MACGRD_FK1_1 on RF_MACGRD (
   RF_MACCES_ID ASC
);

/*==============================================================*/
/* Index : RF_MACGRD_FK2_1                                      */
/*==============================================================*/
create unique index RF_MACGRD_FK2_1 on RF_MACGRD (
   RF_GRD_COD ASC
);

/*==============================================================*/
/* Index : RF_MACGRD_UN2_1                                      */
/*==============================================================*/
create unique index RF_MACGRD_UN2_1 on RF_MACGRD (
   RF_MACCES_ID ASC,
   RF_GRD_COD ASC
);

grant SELECT on RF_MACGRD to PUBLIC;

grant REFERENCES on RF_MACGRD to PUBLIC;

grant REFERENCES on RF_MACGRD to PUBLIC;

grant SELECT on RF_MACGRD to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_MAJ                                               */
/*==============================================================*/
create table RF_MAJ  (
   RF_MAJ_ID            INTEGER                         not null,
   RF_GES_ID            INTEGER                         not null,
   RF_RTORG_ID          INTEGER                         not null,
   RF_MAJ_NUM           VARCHAR2(3),
   RF_MAJ_LIB           VARCHAR2(50),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_MAJ_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_MAJ is
'SERVICE LOCAL CHARGE DE LA MISE A JOUR DES IMMEUBLES';

comment on column RF_MAJ.RF_MAJ_ID is
'Identifiant de la mise a jour';

comment on column RF_MAJ.RF_GES_ID is
'Service gestionnaire';

comment on column RF_MAJ.RF_RTORG_ID is
'Organisme';

comment on column RF_MAJ.RF_MAJ_NUM is
'Code du service de mise a jour';

comment on column RF_MAJ.RF_MAJ_LIB is
'Libelle du service de mise a jour';

comment on column RF_MAJ.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_MAJ.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_MAJ
   add constraint RF_MAJ_PK1_1 primary key (RF_MAJ_ID);

/*==============================================================*/
/* Index : RF_MAJ_FK1_1                                         */
/*==============================================================*/
create index RF_MAJ_FK1_1 on RF_MAJ (
   RF_RTORG_ID ASC
);

/*==============================================================*/
/* Index : RF_MAJ_FK1_2                                         */
/*==============================================================*/
create index RF_MAJ_FK1_2 on RF_MAJ (
   RF_GES_ID ASC
);

/*==============================================================*/
/* Index : RF_MAJ_UN1_1                                         */
/*==============================================================*/
create unique index RF_MAJ_UN1_1 on RF_MAJ (
   RF_MAJ_NUM ASC
);

grant SELECT on RF_MAJ to PUBLIC;

grant REFERENCES on RF_MAJ to PUBLIC;

grant REFERENCES on RF_MAJ to PUBLIC;

grant SELECT on RF_MAJ to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_MDRG                                              */
/*==============================================================*/
create table RF_MDRG  (
   RF_MDRG_COD          VARCHAR2(2)                     not null,
   RF_MDRG_LIB          VARCHAR2(36)                    not null,
   RF_MDRG_COD_NDL      VARCHAR2(2)                     not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_MDRG_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_MDRG is
'Mode de reglement';

comment on column RF_MDRG.RF_MDRG_COD is
'Code mode de reglement';

comment on column RF_MDRG.RF_MDRG_LIB is
'Libelle mode de reglement';

comment on column RF_MDRG.RF_MDRG_COD_NDL is
'Code du mode de reglement NDL';

comment on column RF_MDRG.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_MDRG.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_MDRG
   add constraint RF_MDRG_PK1_1 primary key (RF_MDRG_COD);

grant SELECT on RF_MDRG to PUBLIC;

grant REFERENCES on RF_MDRG to PUBLIC;

grant REFERENCES on RF_MDRG to PUBLIC;

grant SELECT on RF_MDRG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_MDVI                                              */
/*==============================================================*/
create table RF_MDVI  (
   RF_MDVI_ID           INTEGER                         not null,
   RF_MDVI_COD          VARCHAR2(1)                     not null,
   RF_MDVI_LIB          VARCHAR2(52)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_MDVI_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_MDVI is
'Mode de determination de la valeur d''un immeuble';

comment on column RF_MDVI.RF_MDVI_ID is
'Identifiant du mode de determination';

comment on column RF_MDVI.RF_MDVI_COD is
'Code du mode de determination';

comment on column RF_MDVI.RF_MDVI_LIB is
'Libelle du mode de determination';

comment on column RF_MDVI.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_MDVI.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_MDVI
   add constraint RF_MDVI_PK1_1 primary key (RF_MDVI_ID);

/*==============================================================*/
/* Index : RF_MDVI_UN1_1                                        */
/*==============================================================*/
create unique index RF_MDVI_UN1_1 on RF_MDVI (
   RF_MDVI_COD ASC
);

grant SELECT on RF_MDVI to PUBLIC;

grant REFERENCES on RF_MDVI to PUBLIC;

grant REFERENCES on RF_MDVI to PUBLIC;

grant SELECT on RF_MDVI to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_MINAFF                                            */
/*==============================================================*/
create table RF_MINAFF  (
   RF_MINAFF_ID         INTEGER                         not null,
   RF_MINAFF_COD        VARCHAR2(1)                     not null,
   RF_MINAFF_LIB        VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_MINAFF_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_MINAFF is
'Ministere affectataire';

comment on column RF_MINAFF.RF_MINAFF_ID is
'Identifiant du ministere affectataire';

comment on column RF_MINAFF.RF_MINAFF_COD is
'Code du ministere affectataire';

comment on column RF_MINAFF.RF_MINAFF_LIB is
'Libelle du ministere affectataire';

comment on column RF_MINAFF.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_MINAFF.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_MINAFF
   add constraint RF_MINAFF_PK1_1 primary key (RF_MINAFF_ID);

/*==============================================================*/
/* Index : RF_MINAFF_UN1_1                                      */
/*==============================================================*/
create unique index RF_MINAFF_UN1_1 on RF_MINAFF (
   RF_MINAFF_COD ASC
);

grant SELECT on RF_MINAFF to PUBLIC;

grant REFERENCES on RF_MINAFF to PUBLIC;

grant REFERENCES on RF_MINAFF to PUBLIC;

grant SELECT on RF_MINAFF to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_MOA                                               */
/*==============================================================*/
create table RF_MOA  (
   RF_MOA_ID            INTEGER                         not null,
   RF_MOA_COD           VARCHAR2(2)                     not null,
   RF_MOA_LIB           VARCHAR2(100)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_MOA_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_MOA is
'Table des maitres d’ouvrage ';

comment on column RF_MOA.RF_MOA_ID is
'Identifiant du maitre d''ouvrage';

comment on column RF_MOA.RF_MOA_COD is
'Code maitre d''ouvrage';

comment on column RF_MOA.RF_MOA_LIB is
'Libelle maitre d''ouvrage';

comment on column RF_MOA.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_MOA.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_MOA
   add constraint RF_MOA_PK1_1 primary key (RF_MOA_ID);

/*==============================================================*/
/* Index : RF_MOA_UN1_1                                         */
/*==============================================================*/
create unique index RF_MOA_UN1_1 on RF_MOA (
   RF_MOA_COD ASC
);

grant SELECT on RF_MOA to PUBLIC;

grant REFERENCES on RF_MOA to PUBLIC;

grant REFERENCES on RF_MOA to PUBLIC;

grant SELECT on RF_MOA to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_MPMT                                              */
/*==============================================================*/
create table RF_MPMT  (
   RF_MPMT_ID           INTEGER                         not null,
   RF_MPMT_MET          VARCHAR2(1)                     not null,
   RF_MPMT_COUNTRY      VARCHAR2(3)                     not null,
   RF_MPMT_TXTMD        VARCHAR2(40),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_MPMT is
'Table des modes de paiement CHORUS.';

comment on column RF_MPMT.RF_MPMT_ID is
'ID du mode de paiement CHORUS.';

comment on column RF_MPMT.RF_MPMT_MET is
'Code du mode de paiement CHORUS.';

comment on column RF_MPMT.RF_MPMT_COUNTRY is
'Cle de pays du mode de paiement CHORUS.';

comment on column RF_MPMT.RF_MPMT_TXTMD is
'Description du mode de paiement CHORUS.';

comment on column RF_MPMT.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_MPMT.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_MPMT
   add constraint RF_MPMT_PK1_1 primary key (RF_MPMT_ID);

alter table RF_MPMT
   add constraint RF_MPMT_UN2_1 unique (RF_MPMT_MET, RF_MPMT_COUNTRY);

grant SELECT on RF_MPMT to PUBLIC;

grant REFERENCES on RF_MPMT to PUBLIC;

grant REFERENCES on RF_MPMT to PUBLIC;

grant SELECT on RF_MPMT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_MSORT                                             */
/*==============================================================*/
create table RF_MSORT  (
   RF_MSORT_ID          INTEGER                         not null,
   RF_MSORT_COD         VARCHAR2(2)                     not null,
   RF_MSORT_LIB         VARCHAR2(150)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_MSORT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_MSORT is
'Motif de sortie';

comment on column RF_MSORT.RF_MSORT_ID is
'Identifiant du motif de sortie';

comment on column RF_MSORT.RF_MSORT_COD is
'Code du motif de sortie';

comment on column RF_MSORT.RF_MSORT_LIB is
'Libelle du motif de sortie';

comment on column RF_MSORT.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_MSORT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_MSORT
   add constraint RF_MSORT_PK1_1 primary key (RF_MSORT_ID);

/*==============================================================*/
/* Index : RF_MSORT_UN1_1                                       */
/*==============================================================*/
create unique index RF_MSORT_UN1_1 on RF_MSORT (
   RF_MSORT_COD ASC
);

grant SELECT on RF_MSORT to PUBLIC;

grant REFERENCES on RF_MSORT to PUBLIC;

grant REFERENCES on RF_MSORT to PUBLIC;

grant SELECT on RF_MSORT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_MVTMVT                                            */
/*==============================================================*/
create table RF_MVTMVT  (
   RF_TMVT_COD          VARCHAR2(2)                     not null,
   RF_TMVT_COD_COMP     VARCHAR2(2)                     not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_MVTMVT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on column RF_MVTMVT.RF_TMVT_COD is
'Code Type mouvement';

comment on column RF_MVTMVT.RF_TMVT_COD_COMP is
'Code Type mouvement';

comment on column RF_MVTMVT.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_MVTMVT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_MVTMVT
   add constraint RF_MVTMVT_PK2_1 primary key (RF_TMVT_COD, RF_TMVT_COD_COMP);

/*==============================================================*/
/* Index : RF_MVTMVT_FK1_2                                      */
/*==============================================================*/
create index RF_MVTMVT_FK1_2 on RF_MVTMVT (
   RF_TMVT_COD ASC
);

/*==============================================================*/
/* Index : RF_MVTMVT_FK1_1                                      */
/*==============================================================*/
create index RF_MVTMVT_FK1_1 on RF_MVTMVT (
   RF_TMVT_COD_COMP ASC
);

grant SELECT on RF_MVTMVT to PUBLIC;

grant REFERENCES on RF_MVTMVT to PUBLIC;

grant REFERENCES on RF_MVTMVT to PUBLIC;

grant SELECT on RF_MVTMVT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_NAT                                               */
/*==============================================================*/
create table RF_NAT  (
   RF_NAT_ID            INTEGER                         not null,
   RF_NAT_COD           VARCHAR2(2)                     not null,
   RF_NAT_LIB           VARCHAR2(40)                    not null,
   RF_NAT_DEF           VARCHAR2(200),
   RF_NAT_OBS           VARCHAR2(200),
   RF_NAT_CATEG_BERCY   VARCHAR2(20),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_NAT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_NAT is
'Table des natures d''operations';

comment on column RF_NAT.RF_NAT_ID is
'Identifiant de la nature d''operations';

comment on column RF_NAT.RF_NAT_COD is
'Code de la nature d''opeartion';

comment on column RF_NAT.RF_NAT_LIB is
'Libelle de la nature d''operation';

comment on column RF_NAT.RF_NAT_DEF is
'Definition de la nature d''operation';

comment on column RF_NAT.RF_NAT_OBS is
'Observations concernant la nature d''operation';

comment on column RF_NAT.RF_NAT_CATEG_BERCY is
'Categorie Bercy a laquelle appartient la nature d''operation';

comment on column RF_NAT.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_NAT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_NAT
   add constraint RF_NAT_PK1_1 primary key (RF_NAT_ID);

/*==============================================================*/
/* Index : RF_NAT_UN1_1                                         */
/*==============================================================*/
create unique index RF_NAT_UN1_1 on RF_NAT (
   RF_NAT_COD ASC
);

grant SELECT on RF_NAT to PUBLIC;

grant REFERENCES on RF_NAT to PUBLIC;

grant REFERENCES on RF_NAT to PUBLIC;

grant SELECT on RF_NAT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_NATD                                              */
/*==============================================================*/
create table RF_NATD  (
   RF_NATD_ID           INTEGER                         not null,
   RF_NATD_NATMIN       VARCHAR2(11)                    not null,
   RF_NATD_ETXTMD       VARCHAR2(40),
   RF_NATD_CODMIN       VARCHAR2(5),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_NATD is
'Table des natures detaillees de CHORUS.';

comment on column RF_NATD.RF_NATD_ID is
'ID de la nature detaillee de CHORUS.';

comment on column RF_NATD.RF_NATD_NATMIN is
'Code de la nature detaillee de CHORUS.';

comment on column RF_NATD.RF_NATD_ETXTMD is
'Description de la nature detaillee de CHORUS.';

comment on column RF_NATD.RF_NATD_CODMIN is
'Code ministere de la nature detaillee de CHORUS.';

comment on column RF_NATD.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_NATD.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_NATD
   add constraint RF_NATD_PK1_1 primary key (RF_NATD_ID);

alter table RF_NATD
   add constraint RF_NATD_UN1_1 unique (RF_NATD_NATMIN);

grant SELECT on RF_NATD to PUBLIC;

grant REFERENCES on RF_NATD to PUBLIC;

grant REFERENCES on RF_NATD to PUBLIC;

grant SELECT on RF_NATD to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_NATDECPRO                                         */
/*==============================================================*/
create table RF_NATDECPRO  (
   RF_NATDECPRO_ID      INTEGER                         not null,
   RF_NATDECPRO_COD     VARCHAR2(2)                     not null,
   RF_NATDECPRO_LIB     VARCHAR2(255)                   not null,
   RF_NATDECPRO_LIBA    VARCHAR2(50),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_NATDEC_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_NATDECPRO is
'Nature decision au profit de l''attributaire';

comment on column RF_NATDECPRO.RF_NATDECPRO_ID is
'Identifiant de la nature de decisio';

comment on column RF_NATDECPRO.RF_NATDECPRO_COD is
'Code nature decision';

comment on column RF_NATDECPRO.RF_NATDECPRO_LIB is
'Nature decision au profit attributaire';

comment on column RF_NATDECPRO.RF_NATDECPRO_LIBA is
'Libelle Abrege';

comment on column RF_NATDECPRO.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_NATDECPRO.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_NATDECPRO
   add constraint RF_NATDECPRO_PK1_1 primary key (RF_NATDECPRO_ID);

/*==============================================================*/
/* Index : RF_NATDECPRO_UN1_1                                   */
/*==============================================================*/
create unique index RF_NATDECPRO_UN1_1 on RF_NATDECPRO (
   RF_NATDECPRO_COD ASC
);

grant SELECT on RF_NATDECPRO to PUBLIC;

grant REFERENCES on RF_NATDECPRO to PUBLIC;

grant REFERENCES on RF_NATDECPRO to PUBLIC;

grant SELECT on RF_NATDECPRO to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_NATDEP                                            */
/*==============================================================*/
create table RF_NATDEP  (
   RF_NATDEP_ID         INTEGER                         not null,
   RF_NATDEP_COD        VARCHAR2(1)                     not null,
   RF_NATDEP_LIB        VARCHAR2(25)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_NATDEP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_NATDEP is
'Nature des dependances';

comment on column RF_NATDEP.RF_NATDEP_ID is
'Identifiant de la nature de dependance';

comment on column RF_NATDEP.RF_NATDEP_COD is
'Code de la nature de dependance';

comment on column RF_NATDEP.RF_NATDEP_LIB is
'Libelle de la nature de dependance';

comment on column RF_NATDEP.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_NATDEP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_NATDEP
   add constraint RF_NATDEP_PK1_1 primary key (RF_NATDEP_ID);

/*==============================================================*/
/* Index : RF_NATDEP_UN1_1                                      */
/*==============================================================*/
create unique index RF_NATDEP_UN1_1 on RF_NATDEP (
   RF_NATDEP_COD ASC
);

grant SELECT on RF_NATDEP to PUBLIC;

grant REFERENCES on RF_NATDEP to PUBLIC;

grant REFERENCES on RF_NATDEP to PUBLIC;

grant SELECT on RF_NATDEP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_NATDRO                                            */
/*==============================================================*/
create table RF_NATDRO  (
   RF_NATDRO_ID         INTEGER                         not null,
   RF_NATDRO_COD        VARCHAR2(2)                     not null,
   RF_NATDRO_LIB        VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_NATDRO_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_NATDRO is
'Nature des droits de l''etat';

comment on column RF_NATDRO.RF_NATDRO_ID is
'Identifiant de l''origine des droits';

comment on column RF_NATDRO.RF_NATDRO_COD is
'Code de l''origine des droits';

comment on column RF_NATDRO.RF_NATDRO_LIB is
'Libelle de l''origine des droits';

comment on column RF_NATDRO.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_NATDRO.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_NATDRO
   add constraint RF_NATDRO_PK1_1 primary key (RF_NATDRO_ID);

/*==============================================================*/
/* Index : RF_NATDRO_UN1_1                                      */
/*==============================================================*/
create unique index RF_NATDRO_UN1_1 on RF_NATDRO (
   RF_NATDRO_COD ASC
);

grant SELECT on RF_NATDRO to PUBLIC;

grant REFERENCES on RF_NATDRO to PUBLIC;

grant REFERENCES on RF_NATDRO to PUBLIC;

grant SELECT on RF_NATDRO to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_NATIMM                                            */
/*==============================================================*/
create table RF_NATIMM  (
   RF_NATIMM_ID         INTEGER                         not null,
   RF_NATIMM_COD        VARCHAR2(4)                     not null,
   RF_NATIMM_LIB        VARCHAR2(20)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_NATIMM_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_NATIMM is
'Nature d''un immeuble';

comment on column RF_NATIMM.RF_NATIMM_ID is
'Identifiant de la nature de l''immeuble';

comment on column RF_NATIMM.RF_NATIMM_COD is
'Code de la nature de l''immeuble';

comment on column RF_NATIMM.RF_NATIMM_LIB is
'Libelle de la nature de l''immeuble';

comment on column RF_NATIMM.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_NATIMM.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_NATIMM
   add constraint RF_NATIMM_PK1_1 primary key (RF_NATIMM_ID);

/*==============================================================*/
/* Index : RF_NATIMM_UN1_1                                      */
/*==============================================================*/
create unique index RF_NATIMM_UN1_1 on RF_NATIMM (
   RF_NATIMM_COD ASC
);

grant SELECT on RF_NATIMM to PUBLIC;

grant REFERENCES on RF_NATIMM to PUBLIC;

grant REFERENCES on RF_NATIMM to PUBLIC;

grant SELECT on RF_NATIMM to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_NATTXT                                            */
/*==============================================================*/
create table RF_NATTXT  (
   RF_NATTXT_ID         INTEGER                         not null,
   RF_NATTXT_COD        VARCHAR2(5),
   RF_NATTXT_LIB        VARCHAR2(50),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_NTTRTXT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_NATTXT is
'Decret, arrete, decret 78...';

comment on column RF_NATTXT.RF_NATTXT_ID is
'Identifiant de la nature de texte';

comment on column RF_NATTXT.RF_NATTXT_COD is
'Code de la nature de texte';

comment on column RF_NATTXT.RF_NATTXT_LIB is
'Libelle de la nature de texte';

comment on column RF_NATTXT.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_NATTXT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_NATTXT
   add constraint RF_NATTXT_PK1_1 primary key (RF_NATTXT_ID);

/*==============================================================*/
/* Index : RF_NATTXT_UN1_1                                      */
/*==============================================================*/
create unique index RF_NATTXT_UN1_1 on RF_NATTXT (
   RF_NATTXT_COD ASC
);

grant SELECT on RF_NATTXT to PUBLIC;

grant REFERENCES on RF_NATTXT to PUBLIC;

grant REFERENCES on RF_NATTXT to PUBLIC;

grant SELECT on RF_NATTXT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_NATVOI                                            */
/*==============================================================*/
create table RF_NATVOI  (
   RF_NATVOI_ID         INTEGER                         not null,
   RF_NATVOI_COD        VARCHAR2(4)                     not null,
   RF_NATVOI_LIB        VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_NATVOI_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_NATVOI is
'Nature de la voie';

comment on column RF_NATVOI.RF_NATVOI_ID is
'Identifiant de la nature de la voie';

comment on column RF_NATVOI.RF_NATVOI_COD is
'Code de la nature de la voie';

comment on column RF_NATVOI.RF_NATVOI_LIB is
'Libelle de la nature de la voie';

comment on column RF_NATVOI.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_NATVOI.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_NATVOI
   add constraint RF_NATVOI_PK1_1 primary key (RF_NATVOI_ID);

/*==============================================================*/
/* Index : RF_NATVOI_UN1_1                                      */
/*==============================================================*/
create unique index RF_NATVOI_UN1_1 on RF_NATVOI (
   RF_NATVOI_COD ASC
);

grant SELECT on RF_NATVOI to PUBLIC;

grant REFERENCES on RF_NATVOI to PUBLIC;

grant REFERENCES on RF_NATVOI to PUBLIC;

grant SELECT on RF_NATVOI to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_NBI                                               */
/*==============================================================*/
create table RF_NBI  (
   RF_NBI_ID            INTEGER                         not null,
   RF_NBI_TAUX          INTEGER                         not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_NBI_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_NBI is
'Table des NBI (Nombre de points de la Nouvelle Bonification Indiciaire)';

comment on column RF_NBI.RF_NBI_ID is
'Identifiant du taux NBI';

comment on column RF_NBI.RF_NBI_TAUX is
'Taux NBI';

comment on column RF_NBI.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_NBI.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_NBI
   add constraint RF_NBI_PK1_1 primary key (RF_NBI_ID);

/*==============================================================*/
/* Index : RF_NBI_UN1_1                                         */
/*==============================================================*/
create unique index RF_NBI_UN1_1 on RF_NBI (
   RF_NBI_TAUX ASC
);

grant SELECT on RF_NBI to PUBLIC;

grant REFERENCES on RF_NBI to PUBLIC;

grant REFERENCES on RF_NBI to PUBLIC;

grant SELECT on RF_NBI to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_NIVRESP                                           */
/*==============================================================*/
create table RF_NIVRESP  (
   RF_NIVRESP_ID        INTEGER                         not null,
   RF_NIVRESP_COD       VARCHAR2(2)                     not null,
   RF_NIVRESP_LIB       VARCHAR2(40),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_NIVRESP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_NIVRESP is
'Niveau de responsabilite (En 2003 : depend de la categorie (A,B,C, Ouvriers,Off,S/Off,MDR))';

comment on column RF_NIVRESP.RF_NIVRESP_ID is
'Identifiant du Niveau de responsabilite';

comment on column RF_NIVRESP.RF_NIVRESP_COD is
'Code du niveau de responsabilite';

comment on column RF_NIVRESP.RF_NIVRESP_LIB is
'Libelle du niveau de responsabilite';

comment on column RF_NIVRESP.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_NIVRESP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_NIVRESP
   add constraint RF_NIVRESP_PK1_1 primary key (RF_NIVRESP_ID);

/*==============================================================*/
/* Index : RF_NIVRESP_UN1_1                                     */
/*==============================================================*/
create unique index RF_NIVRESP_UN1_1 on RF_NIVRESP (
   RF_NIVRESP_COD ASC
);

grant SELECT on RF_NIVRESP to PUBLIC;

grant REFERENCES on RF_NIVRESP to PUBLIC;

grant REFERENCES on RF_NIVRESP to PUBLIC;

grant SELECT on RF_NIVRESP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_NIVSUPP                                           */
/*==============================================================*/
create table RF_NIVSUPP  (
   RF_NIVSUPP_ID        INTEGER                         not null,
   RF_NIVSUPP_COD       VARCHAR2(1)                     not null,
   RF_NIVSUPP_LIB       VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_NIVSUPP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_NIVSUPP is
'Niveau d''elaboration d''une servitude d''utilite publique au profit';

comment on column RF_NIVSUPP.RF_NIVSUPP_ID is
'Identifiant du niveau d''elaboration ';

comment on column RF_NIVSUPP.RF_NIVSUPP_COD is
'Code du niveau d''elaboration ';

comment on column RF_NIVSUPP.RF_NIVSUPP_LIB is
'Libelle du niveau d''elaboration ';

comment on column RF_NIVSUPP.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_NIVSUPP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_NIVSUPP
   add constraint RF_NIVSUPP_PK1_1 primary key (RF_NIVSUPP_ID);

/*==============================================================*/
/* Index : RF_NIVSUPP_UN1_1                                     */
/*==============================================================*/
create unique index RF_NIVSUPP_UN1_1 on RF_NIVSUPP (
   RF_NIVSUPP_COD ASC
);

grant SELECT on RF_NIVSUPP to PUBLIC;

grant REFERENCES on RF_NIVSUPP to PUBLIC;

grant REFERENCES on RF_NIVSUPP to PUBLIC;

grant SELECT on RF_NIVSUPP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_NOMENCPROD                                        */
/*==============================================================*/
create table RF_NOMENCPROD  (
   RF_NOMENCPROD_COD    VARCHAR2(4)                     not null,
   RF_NOMENCPROD_LIB    VARCHAR2(80)                    not null,
   RF_TACHAT_COD        VARCHAR2(2)                     not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_NOMENCPROD_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_NOMENCPROD is
'Table de nomenclature des fournitures et services';

comment on column RF_NOMENCPROD.RF_NOMENCPROD_COD is
'Code du produit dans la nomenclature';

comment on column RF_NOMENCPROD.RF_NOMENCPROD_LIB is
'Libelle du produit dans la nomenclature';

comment on column RF_NOMENCPROD.RF_TACHAT_COD is
'Code du type d''achat';

comment on column RF_NOMENCPROD.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_NOMENCPROD.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_NOMENCPROD
   add constraint RF_NOMENCPROD_PK2_1 primary key (RF_NOMENCPROD_COD, RF_TACHAT_COD);

/*==============================================================*/
/* Index : RF_NOMENCPROD_FK1_1                                  */
/*==============================================================*/
create index RF_NOMENCPROD_FK1_1 on RF_NOMENCPROD (
   RF_TACHAT_COD ASC
);

grant SELECT on RF_NOMENCPROD to PUBLIC;

grant REFERENCES on RF_NOMENCPROD to PUBLIC;

grant REFERENCES on RF_NOMENCPROD to PUBLIC;

grant SELECT on RF_NOMENCPROD to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_NRCTGRD                                           */
/*==============================================================*/
create table RF_NRCTGRD  (
   RF_NRCTGRD_ID        INTEGER                         not null,
   RF_CTGRD_COD         VARCHAR2(1)                     not null,
   RF_NIVRESP_ID        INTEGER                         not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_NIVCTGRD_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_NRCTGRD is
'Table d''association des categories de grade et des niveaux de responsabilite';

comment on column RF_NRCTGRD.RF_NRCTGRD_ID is
'Identifiant de la categorie de grade liee a un niveau de responsabilite';

comment on column RF_NRCTGRD.RF_CTGRD_COD is
'Code categorie grade';

comment on column RF_NRCTGRD.RF_NIVRESP_ID is
'Identifiant du Niveau de responsabilite';

comment on column RF_NRCTGRD.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_NRCTGRD.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_NRCTGRD
   add constraint RF_NRCTGRD_PK1_1 primary key (RF_NRCTGRD_ID);

/*==============================================================*/
/* Index : RF_NRCTGRD_FK1_1                                     */
/*==============================================================*/
create index RF_NRCTGRD_FK1_1 on RF_NRCTGRD (
   RF_NIVRESP_ID ASC
);

/*==============================================================*/
/* Index : RF_NRCTGRD_FK1_2                                     */
/*==============================================================*/
create index RF_NRCTGRD_FK1_2 on RF_NRCTGRD (
   RF_CTGRD_COD ASC
);

/*==============================================================*/
/* Index : RF_NRCTGRD_UN2_1                                     */
/*==============================================================*/
create unique index RF_NRCTGRD_UN2_1 on RF_NRCTGRD (
   RF_CTGRD_COD ASC,
   RF_NIVRESP_ID ASC
);

grant SELECT on RF_NRCTGRD to PUBLIC;

grant REFERENCES on RF_NRCTGRD to PUBLIC;

grant REFERENCES on RF_NRCTGRD to PUBLIC;

grant SELECT on RF_NRCTGRD to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_NTTR                                              */
/*==============================================================*/
create table RF_NTTR  (
   RF_NTTR_COD          VARCHAR2(2)                     not null,
   RF_LIGMER_COD        VARCHAR2(6),
   RF_PROD_COD          VARCHAR2(6),
   RF_NTTR_LIB          VARCHAR2(50)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_NTTR_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_NTTR is
'Nature de travaux';

comment on column RF_NTTR.RF_NTTR_COD is
'Identifiant Nature Travaux';

comment on column RF_NTTR.RF_LIGMER_COD is
'Code Ligne Mercure';

comment on column RF_NTTR.RF_PROD_COD is
'Code Ligne Produit';

comment on column RF_NTTR.RF_NTTR_LIB is
'Libelle Nature Travaux';

comment on column RF_NTTR.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_NTTR.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_NTTR
   add constraint RF_NTTR_PK1_1 primary key (RF_NTTR_COD);

/*==============================================================*/
/* Index : RF_NTTR_FK1_1                                        */
/*==============================================================*/
create index RF_NTTR_FK1_1 on RF_NTTR (
   RF_LIGMER_COD ASC
);

/*==============================================================*/
/* Index : RF_NTTR_FK1_2                                        */
/*==============================================================*/
create index RF_NTTR_FK1_2 on RF_NTTR (
   RF_PROD_COD ASC
);

grant SELECT on RF_NTTR to PUBLIC;

grant REFERENCES on RF_NTTR to PUBLIC;

grant REFERENCES on RF_NTTR to PUBLIC;

grant SELECT on RF_NTTR to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_NTTR_STGPE                                        */
/*==============================================================*/
create table RF_NTTR_STGPE  (
   RF_NTTR_STGPE_ID     INTEGER                         not null,
   RF_NTTR_COD          VARCHAR2(2)                     not null,
   RF_NTTR_STGPE_COD    VARCHAR2(1)                     not null,
   RF_NTTR_STGPE_LIB    VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_NTTR_STGPE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_NTTR_STGPE is
'Table des natures de travaux STGPE';

comment on column RF_NTTR_STGPE.RF_NTTR_STGPE_ID is
'Identifiant de la nature de travaux STGPE';

comment on column RF_NTTR_STGPE.RF_NTTR_COD is
'Identifiant Nature Travaux';

comment on column RF_NTTR_STGPE.RF_NTTR_STGPE_COD is
'Code de la nature de travaux STGPE';

comment on column RF_NTTR_STGPE.RF_NTTR_STGPE_LIB is
'Libelle de la nature de travaux STGPE';

comment on column RF_NTTR_STGPE.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_NTTR_STGPE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_NTTR_STGPE
   add constraint RF_NTTR_STGPE_PK1_1 primary key (RF_NTTR_STGPE_ID);

/*==============================================================*/
/* Index : RF_NTTR_STGPE_FK1_1                                  */
/*==============================================================*/
create index RF_NTTR_STGPE_FK1_1 on RF_NTTR_STGPE (
   RF_NTTR_COD ASC
);

/*==============================================================*/
/* Index : RF_NTTR_STGPE_UN2_1                                  */
/*==============================================================*/
create unique index RF_NTTR_STGPE_UN2_1 on RF_NTTR_STGPE (
   RF_NTTR_COD ASC,
   RF_NTTR_STGPE_COD ASC
);

grant SELECT on RF_NTTR_STGPE to PUBLIC;

grant REFERENCES on RF_NTTR_STGPE to PUBLIC;

grant REFERENCES on RF_NTTR_STGPE to PUBLIC;

grant SELECT on RF_NTTR_STGPE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_NUMOSIRIS                                         */
/*==============================================================*/
create table RF_NUMOSIRIS  (
   RF_NUMOSIRIS_ID      INTEGER                         not null,
   RF_NUMOSIRIS_COD     VARCHAR2(10)                    not null,
   RF_NUMOSIRIS_LIB     VARCHAR2(200)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_NUMOSIRIS_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_NUMOSIRIS is
'Numero OSIRIS';

comment on column RF_NUMOSIRIS.RF_NUMOSIRIS_ID is
'Identifiant du numero OSIRIS';

comment on column RF_NUMOSIRIS.RF_NUMOSIRIS_COD is
'Code du numero OSIRIS';

comment on column RF_NUMOSIRIS.RF_NUMOSIRIS_LIB is
'Libelle du numero OSIRIS';

comment on column RF_NUMOSIRIS.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_NUMOSIRIS.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_NUMOSIRIS
   add constraint RF_NUMOSIRIS_PK1_1 primary key (RF_NUMOSIRIS_ID);

grant SELECT on RF_NUMOSIRIS to PUBLIC;

grant SELECT on RF_NUMOSIRIS to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_OACH                                              */
/*==============================================================*/
create table RF_OACH  (
   RF_OACH_ID           INTEGER                         not null,
   RF_OACH_ORG          VARCHAR2(4)                     not null,
   RF_OACH_TXTSH        VARCHAR2(20),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_OACH is
'Tables des organisations d''achat de CHORUS.';

comment on column RF_OACH.RF_OACH_ID is
'ID de l''organisation d''achat de CHORUS.';

comment on column RF_OACH.RF_OACH_ORG is
'Code de l''organisation d''achat de CHORUS.';

comment on column RF_OACH.RF_OACH_TXTSH is
'Description de l''organisation d''achat de CHORUS.';

comment on column RF_OACH.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_OACH.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_OACH
   add constraint RF_OACH_PK1_1 primary key (RF_OACH_ID);

alter table RF_OACH
   add constraint RF_OACH_UN1_1 unique (RF_OACH_ORG);

grant SELECT on RF_OACH to PUBLIC;

grant REFERENCES on RF_OACH to PUBLIC;

grant REFERENCES on RF_OACH to PUBLIC;

grant SELECT on RF_OACH to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_OBI                                               */
/*==============================================================*/
create table RF_OBI  (
   RF_TETAD_COD         VARCHAR2(1)                     not null,
   RF_IMPG_COD          VARCHAR2(6)                     not null,
   RF_OBI_COD           VARCHAR2(6)                     not null,
   RF_CTOB_COD          VARCHAR2(1)                     not null,
   RF_OBI_LIB           VARCHAR2(60)                    not null,
   RF_OBI_MILL          VARCHAR2(4)                     not null,
   RF_OBI_NUMFICH       VARCHAR2(4)                     not null,
   RF_OBI_NUMVISA       VARCHAR2(6)                     not null,
   RF_OBI_DTVISCFC      DATE                            not null,
   RF_OBI_SUICFD        VARCHAR2(1)                     not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_OBI_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_CTOB_COD_OLD      VARCHAR2(1),
   RF_CNOP_ID           INTEGER
);

comment on table RF_OBI is
'OBI';

comment on column RF_OBI.RF_TETAD_COD is
'Code type etat D';

comment on column RF_OBI.RF_IMPG_COD is
'Code imputation de gestion';

comment on column RF_OBI.RF_OBI_COD is
'Code OBI';

comment on column RF_OBI.RF_CTOB_COD is
'Code categorie OBI';

comment on column RF_OBI.RF_OBI_LIB is
'Libelle Operation Catalogue';

comment on column RF_OBI.RF_OBI_MILL is
'Millesime OBI';

comment on column RF_OBI.RF_OBI_NUMFICH is
'Numero de fiche primaire pour les OBI de type FAP et FE';

comment on column RF_OBI.RF_OBI_NUMVISA is
'Numero du visa CFC';

comment on column RF_OBI.RF_OBI_DTVISCFC is
'Date du visa CFC';

comment on column RF_OBI.RF_OBI_SUICFD is
'Suivi CFD';

comment on column RF_OBI.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_OBI.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_OBI.RF_CTOB_COD_OLD is
'Ancien code categorie OBI';

comment on column RF_OBI.RF_CNOP_ID is
'Identifiant du code de la nature de l''operation';

alter table RF_OBI
   add constraint RF_OBI_PK3_1 primary key (RF_TETAD_COD, RF_IMPG_COD, RF_OBI_COD);

/*==============================================================*/
/* Index : RF_OBI_FK2_1                                         */
/*==============================================================*/
create index RF_OBI_FK2_1 on RF_OBI (
   RF_TETAD_COD ASC,
   RF_IMPG_COD ASC
);

/*==============================================================*/
/* Index : RF_OBI_FK1_2                                         */
/*==============================================================*/
create index RF_OBI_FK1_2 on RF_OBI (
   RF_CTOB_COD ASC
);

/*==============================================================*/
/* Index : RF_OBI_FK1_3                                         */
/*==============================================================*/
create index RF_OBI_FK1_3 on RF_OBI (
   RF_CNOP_ID ASC
);

grant SELECT on RF_OBI to PUBLIC;

grant REFERENCES on RF_OBI to PUBLIC;

grant REFERENCES on RF_OBI to PUBLIC;

grant SELECT on RF_OBI to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_OBI_NG                                            */
/*==============================================================*/
create table RF_OBI_NG  (
   RF_OBI_ID            INTEGER                         not null,
   RF_IMPG_ID           INTEGER,
   RF_OBI_COD           VARCHAR2(6)                     not null,
   RF_CTOB_COD          VARCHAR2(1)                     not null,
   RF_OBI_LIB           VARCHAR2(60)                    not null,
   RF_OBI_MILL          VARCHAR2(4)                     not null,
   RF_OBI_NUMFICH       VARCHAR2(4)                     not null,
   RF_OBI_NUMVISA       VARCHAR2(6)                     not null,
   RF_OBI_DTVISCFC      VARCHAR2(15)                    not null,
   RF_OBI_SUICFD        VARCHAR2(1)                     not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_OBI_CK1_2 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_CTOB_COD_OLD      VARCHAR2(1),
   RF_CNOP_ID           INTEGER
);

comment on table RF_OBI_NG is
'OBI - table avec nouvelle structure';

comment on column RF_OBI_NG.RF_OBI_ID is
'Identifiant de l''OBI';

comment on column RF_OBI_NG.RF_IMPG_ID is
'Identifiant d el''imputation de gestion';

comment on column RF_OBI_NG.RF_OBI_COD is
'Code OBI';

comment on column RF_OBI_NG.RF_CTOB_COD is
'Code categorie OBI';

comment on column RF_OBI_NG.RF_OBI_LIB is
'Libelle Operation Catalogue';

comment on column RF_OBI_NG.RF_OBI_MILL is
'Millesime OBI';

comment on column RF_OBI_NG.RF_OBI_NUMFICH is
'Numero de fiche primaire pour les OBI de type FAP et FE';

comment on column RF_OBI_NG.RF_OBI_NUMVISA is
'Numero du visa CFC';

comment on column RF_OBI_NG.RF_OBI_DTVISCFC is
'Date du visa CFC';

comment on column RF_OBI_NG.RF_OBI_SUICFD is
'Suivi CFD';

comment on column RF_OBI_NG.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_OBI_NG.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_OBI_NG.RF_CTOB_COD_OLD is
'Ancien code categorie OBI';

comment on column RF_OBI_NG.RF_CNOP_ID is
'Identifiant du code de la nature de l''operation';

alter table RF_OBI_NG
   add constraint RF_OBI_NG_PK1_1 primary key (RF_OBI_ID);

/*==============================================================*/
/* Index : RF_OBI_NG_FK1_2                                      */
/*==============================================================*/
create index RF_OBI_NG_FK1_2 on RF_OBI_NG (
   RF_CTOB_COD ASC
);

/*==============================================================*/
/* Index : RF_OBI_NG_FK1_3                                      */
/*==============================================================*/
create index RF_OBI_NG_FK1_3 on RF_OBI_NG (
   RF_CNOP_ID ASC
);

/*==============================================================*/
/* Index : RF_OBI_NG_UN2_1                                      */
/*==============================================================*/
create unique index RF_OBI_NG_UN2_1 on RF_OBI_NG (
   RF_IMPG_ID ASC,
   RF_OBI_COD ASC
);

/*==============================================================*/
/* Index : RF_OBI_NG_FK1_1                                      */
/*==============================================================*/
create index RF_OBI_NG_FK1_1 on RF_OBI_NG (
   RF_IMPG_ID ASC
);

grant SELECT on RF_OBI_NG to PUBLIC;

grant REFERENCES on RF_OBI_NG to PUBLIC;

grant REFERENCES on RF_OBI_NG to PUBLIC;

grant SELECT on RF_OBI_NG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_OBJTXT                                            */
/*==============================================================*/
create table RF_OBJTXT  (
   RF_OBJTXT_ID         INTEGER                         not null,
   RF_OBJTXT_COD        VARCHAR2(1)                     not null,
   RF_OBJTXT_LIB        VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_OBJTXT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_OBJTXT is
'Objet du texte de reference d''une servitude d''utilite publique au profit';

comment on column RF_OBJTXT.RF_OBJTXT_ID is
'Identifiant de l''objet du texte de reference';

comment on column RF_OBJTXT.RF_OBJTXT_COD is
'Code de l''objet du texte de reference';

comment on column RF_OBJTXT.RF_OBJTXT_LIB is
'Libelle de l''objet du texte de reference';

comment on column RF_OBJTXT.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_OBJTXT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_OBJTXT
   add constraint RF_OBJTXT_PK1_1 primary key (RF_OBJTXT_ID);

/*==============================================================*/
/* Index : RF_OBJTXT_UN1_1                                      */
/*==============================================================*/
create unique index RF_OBJTXT_UN1_1 on RF_OBJTXT (
   RF_OBJTXT_COD ASC
);

grant SELECT on RF_OBJTXT to PUBLIC;

grant REFERENCES on RF_OBJTXT to PUBLIC;

grant REFERENCES on RF_OBJTXT to PUBLIC;

grant SELECT on RF_OBJTXT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_OCC                                               */
/*==============================================================*/
create table RF_OCC  (
   RF_OCC_ID            INTEGER                         not null,
   RF_OCC_COD           VARCHAR2(7)                     not null,
   RF_OCC_LIB           VARCHAR2(100),
   RF_OCC_PROVENANCE    VARCHAR2(1)                     not null
      constraint RF_OCC_CK1_2 check (RF_OCC_PROVENANCE in ('A','G','M','T')),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_OCCUPANT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_OCC_VILLE         VARCHAR2(100)
);

comment on table RF_OCC is
'Table de reference de tous les occupants defense

RF_OCC_PROVENANCE indique quelle est la source de la donnee: credo, Marine...
Liste de valeur pour provenance:
Terre, Air,Mer,Gendarmerie
';

comment on column RF_OCC.RF_OCC_ID is
'RF_OCC_ID';

comment on column RF_OCC.RF_OCC_COD is
'Code';

comment on column RF_OCC.RF_OCC_LIB is
'Libelle';

comment on column RF_OCC.RF_OCC_PROVENANCE is
'Provenance de l''Occupant';

comment on column RF_OCC.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_OCC.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_OCC.RF_OCC_VILLE is
'Ville';

alter table RF_OCC
   add constraint RF_OCC_PK1_1 primary key (RF_OCC_ID);

/*==============================================================*/
/* Index : RF_OCC_UN1_1                                         */
/*==============================================================*/
create unique index RF_OCC_UN1_1 on RF_OCC (
   RF_OCC_COD ASC
);

grant SELECT on RF_OCC to PUBLIC;

grant REFERENCES on RF_OCC to PUBLIC;

grant REFERENCES on RF_OCC to PUBLIC;

grant SELECT on RF_OCC to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_OPEPLIMAT                                         */
/*==============================================================*/
create table RF_OPEPLIMAT  (
   RF_OPEPLIMAT_ID      INTEGER                         not null,
   RF_OPEPLIMAT_COD     VARCHAR2(17)                    not null,
   RF_OPEPLIMAT_LIB     VARCHAR2(200)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_OPEPLIMAT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_OPEPLIMAT is
'Operation Plimat';

comment on column RF_OPEPLIMAT.RF_OPEPLIMAT_ID is
'Identifiant de l''operation Plimat';

comment on column RF_OPEPLIMAT.RF_OPEPLIMAT_COD is
'Code de l''operation Plimat';

comment on column RF_OPEPLIMAT.RF_OPEPLIMAT_LIB is
'Libelle de l''ioperation Plimat';

comment on column RF_OPEPLIMAT.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_OPEPLIMAT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_OPEPLIMAT
   add constraint RF_OPEPLIMAT_PK1_1 primary key (RF_OPEPLIMAT_ID);

grant SELECT on RF_OPEPLIMAT to PUBLIC;

grant SELECT on RF_OPEPLIMAT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ORDRE                                             */
/*==============================================================*/
create table RF_ORDRE  (
   RF_ORDRE_ID          INTEGER                         not null,
   RF_ORDRE_COD         VARCHAR2(5)                     not null,
   RF_ORDRE_LIB         VARCHAR2(30)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ORDRE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ORDRE is
'Table des ordres
';

comment on column RF_ORDRE.RF_ORDRE_ID is
'Identifiant de ORDRE';

comment on column RF_ORDRE.RF_ORDRE_COD is
'Code abrege de l''ordre';

comment on column RF_ORDRE.RF_ORDRE_LIB is
'Libelle de l''ordre';

comment on column RF_ORDRE.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_ORDRE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ORDRE
   add constraint RF_ORDRE_PK1_1 primary key (RF_ORDRE_ID);

/*==============================================================*/
/* Index : RF_ORDRE_UN1_1                                       */
/*==============================================================*/
create unique index RF_ORDRE_UN1_1 on RF_ORDRE (
   RF_ORDRE_COD ASC
);

grant SELECT on RF_ORDRE to PUBLIC;

grant REFERENCES on RF_ORDRE to PUBLIC;

grant REFERENCES on RF_ORDRE to PUBLIC;

grant SELECT on RF_ORDRE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ORDS                                              */
/*==============================================================*/
create table RF_ORDS  (
   RF_CA_COD            VARCHAR2(3)                     not null,
   RF_ORDS_COD          VARCHAR2(4)                     not null,
   RF_ORGEN_CODETN      VARCHAR2(4),
   RF_ORDS_LIB          VARCHAR2(120)                   not null,
   RF_ORDS_CCOMPT       VARCHAR2(6),
   RF_ORDS_SORDO        VARCHAR2(3),
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ORDS_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ORDS is
'Ordonnateur secondaire';

comment on column RF_ORDS.RF_CA_COD is
'Code comptable assignataire';

comment on column RF_ORDS.RF_ORDS_COD is
'Numero de payeur';

comment on column RF_ORDS.RF_ORGEN_CODETN is
'Identification definitive des organismes';

comment on column RF_ORDS.RF_ORDS_LIB is
'Libelle Autre Ordonnateur Secondaire';

comment on column RF_ORDS.RF_ORDS_CCOMPT is
'Code comptable assignataire NDL';

comment on column RF_ORDS.RF_ORDS_SORDO is
'Numero ordonnateur secondaire NDL';

comment on column RF_ORDS.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_ORDS.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ORDS
   add constraint RF_ORDS_PK2_1 primary key (RF_CA_COD, RF_ORDS_COD);

/*==============================================================*/
/* Index : RF_ORDS_FK1_2                                        */
/*==============================================================*/
create index RF_ORDS_FK1_2 on RF_ORDS (
   RF_CA_COD ASC
);

/*==============================================================*/
/* Index : RF_ORDS_FK1_1                                        */
/*==============================================================*/
create index RF_ORDS_FK1_1 on RF_ORDS (
   RF_ORGEN_CODETN ASC
);

grant SELECT on RF_ORDS to PUBLIC;

grant REFERENCES on RF_ORDS to PUBLIC;

grant REFERENCES on RF_ORDS to PUBLIC;

grant SELECT on RF_ORDS to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ORDS_NG                                           */
/*==============================================================*/
create table RF_ORDS_NG  (
   RF_ORDS_ID           NUMBER(9)                       not null,
   RF_CA_COD            VARCHAR2(3),
   RF_ORDS_COD          VARCHAR2(4),
   RF_ORDS_LIB          VARCHAR2(120)                   not null,
   RF_ORDS_LIBA         VARCHAR2(25),
   RF_ORDS_ACCORD_COD   VARCHAR2(6),
   RF_CA_ACCORD_COD     VARCHAR2(6),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_IMM_CK1_2 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ORDS_NG is
'Ordonnateur secondaire nouvelle generation';

comment on column RF_ORDS_NG.RF_ORDS_ID is
'Identifiant de l''ordonnateur secondaire
';

comment on column RF_ORDS_NG.RF_CA_COD is
'Code comptable assignataire
';

comment on column RF_ORDS_NG.RF_ORDS_COD is
'Numero de payeur (ordonnateur secondaire)
';

comment on column RF_ORDS_NG.RF_ORDS_LIB is
'Libelle Autre Ordonnateur Secondaire';

comment on column RF_ORDS_NG.RF_ORDS_LIBA is
'Libelle abrege Ordonnateur Secondaire';

comment on column RF_ORDS_NG.RF_ORDS_ACCORD_COD is
'Code Ordonnateur secondaire ACCORD';

comment on column RF_ORDS_NG.RF_CA_ACCORD_COD is
'Code comptable assignataire ACCORD';

comment on column RF_ORDS_NG.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_ORDS_NG.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ORDS_NG
   add constraint RF_ORDS_NG_PK1_1 primary key (RF_ORDS_ID);

/*==============================================================*/
/* Index : RF_ORDS_NG_UN4_1                                     */
/*==============================================================*/
create unique index RF_ORDS_NG_UN4_1 on RF_ORDS_NG (
   RF_ORDS_ACCORD_COD ASC,
   RF_CA_ACCORD_COD ASC,
   RF_CA_COD ASC,
   RF_ORDS_COD ASC
);

grant SELECT on RF_ORDS_NG to PUBLIC;

grant REFERENCES on RF_ORDS_NG to PUBLIC;

grant REFERENCES on RF_ORDS_NG to PUBLIC;

grant SELECT on RF_ORDS_NG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ORGANISME                                         */
/*==============================================================*/
create table RF_ORGANISME  (
   RF_ORGANISME_ID      INTEGER                         not null,
   RF_ORGANISME_PERE_ID INTEGER,
   RF_ORGANISME_COD     VARCHAR2(10)                    not null,
   RF_ORGANISME_LIB     VARCHAR2(80),
   RF_ORGANISME_LIBA    VARCHAR2(30),
   RF_ORGANISME_ADGEO   VARCHAR2(100),
   RF_ORGANISME_ADPOS   VARCHAR2(100),
   RF_TORG_COD          VARCHAR2(1)                     not null,
   RF_COMMCP_ID         INTEGER                         not null,
   RF_ORGANISME_ZONE    VARCHAR2(1)                     not null
      constraint CKC_RF_ORGANISME_ZONE_RF_ORGAN check (RF_ORGANISME_ZONE in ('M','O','A')),
   RF_ORGANISME_CODAUT  VARCHAR2(5),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ORGANISME_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_ORGANISME_ABREV   VARCHAR2(9),
   RF_ORGANISME_NIVEAU  INTEGER
);

comment on table RF_ORGANISME is
'Contient la liste de tous les organismes du SID';

comment on column RF_ORGANISME.RF_ORGANISME_ID is
'Identifiant de l''organisme';

comment on column RF_ORGANISME.RF_ORGANISME_PERE_ID is
'Identifiant Pere';

comment on column RF_ORGANISME.RF_ORGANISME_COD is
'Code organisme';

comment on column RF_ORGANISME.RF_ORGANISME_LIB is
'Libelle';

comment on column RF_ORGANISME.RF_ORGANISME_LIBA is
'Libelle Abrege';

comment on column RF_ORGANISME.RF_ORGANISME_ADGEO is
'Adresse geographique';

comment on column RF_ORGANISME.RF_ORGANISME_ADPOS is
'Adresse Postale';

comment on column RF_ORGANISME.RF_TORG_COD is
'Identifiant Type Organisme';

comment on column RF_ORGANISME.RF_COMMCP_ID is
'Identifiant du code postal';

comment on column RF_ORGANISME.RF_ORGANISME_ZONE is
'zone de l''organisme';

comment on column RF_ORGANISME.RF_ORGANISME_CODAUT is
'Code Autorite';

comment on column RF_ORGANISME.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_ORGANISME.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_ORGANISME.RF_ORGANISME_ABREV is
'Abreviation de l''organisme';

comment on column RF_ORGANISME.RF_ORGANISME_NIVEAU is
'Niveau hierarchique';

alter table RF_ORGANISME
   add constraint RF_ORGANISME_PK1_1 primary key (RF_ORGANISME_ID);

/*==============================================================*/
/* Index : RF_ORGANISME_FK1_1                                   */
/*==============================================================*/
create index RF_ORGANISME_FK1_1 on RF_ORGANISME (
   RF_ORGANISME_PERE_ID ASC
);

/*==============================================================*/
/* Index : RF_ORGANISME_FK1_2                                   */
/*==============================================================*/
create index RF_ORGANISME_FK1_2 on RF_ORGANISME (
   RF_COMMCP_ID ASC
);

/*==============================================================*/
/* Index : RF_ORGANISME_FK1_3                                   */
/*==============================================================*/
create index RF_ORGANISME_FK1_3 on RF_ORGANISME (
   RF_TORG_COD ASC
);

/*==============================================================*/
/* Index : RF_ORGANISME_UN2_1                                   */
/*==============================================================*/
create unique index RF_ORGANISME_UN2_1 on RF_ORGANISME (
   RF_ORGANISME_COD ASC,
   RF_TORG_COD ASC
);

grant SELECT on RF_ORGANISME to PUBLIC;

grant REFERENCES on RF_ORGANISME to PUBLIC;

grant REFERENCES on RF_ORGANISME to PUBLIC;

grant SELECT on RF_ORGANISME to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ORGANISMEARMEE                                    */
/*==============================================================*/
create table RF_ORGANISMEARMEE  (
   RF_ORGANISMEARMEE_ID INTEGER                         not null,
   RF_ORGANISME_ID      INTEGER                         not null,
   RF_ARMEE_ID          INTEGER                         not null,
   RF_ORGANISMEARMEE_COD VARCHAR2(15)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ORGANISMEARMEE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ORGANISMEARMEE is
'Table de jointure entre organisme et armee';

comment on column RF_ORGANISMEARMEE.RF_ORGANISMEARMEE_ID is
'Identifiant de l''armee de l''organisme';

comment on column RF_ORGANISMEARMEE.RF_ORGANISME_ID is
'Identifiant de l''organisme';

comment on column RF_ORGANISMEARMEE.RF_ARMEE_ID is
'Identifiant de l''armee';

comment on column RF_ORGANISMEARMEE.RF_ORGANISMEARMEE_COD is
'Code';

comment on column RF_ORGANISMEARMEE.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_ORGANISMEARMEE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ORGANISMEARMEE
   add constraint RF_ORGANISMEARMEE_PK1_1 primary key (RF_ORGANISMEARMEE_ID);

/*==============================================================*/
/* Index : RF_ORGANISMEARMEE_FK1_1                              */
/*==============================================================*/
create index RF_ORGANISMEARMEE_FK1_1 on RF_ORGANISMEARMEE (
   RF_ORGANISME_ID ASC
);

/*==============================================================*/
/* Index : RF_ORGANISMEARMEE_FK1_2                              */
/*==============================================================*/
create index RF_ORGANISMEARMEE_FK1_2 on RF_ORGANISMEARMEE (
   RF_ARMEE_ID ASC
);

/*==============================================================*/
/* Index : RF_ORGANISMEARMEE_UN1_1                              */
/*==============================================================*/
create unique index RF_ORGANISMEARMEE_UN1_1 on RF_ORGANISMEARMEE (
   RF_ORGANISME_ID ASC
);

grant SELECT on RF_ORGANISMEARMEE to PUBLIC;

grant REFERENCES on RF_ORGANISMEARMEE to PUBLIC;

grant REFERENCES on RF_ORGANISMEARMEE to PUBLIC;

grant SELECT on RF_ORGANISMEARMEE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ORGEN                                             */
/*==============================================================*/
create table RF_ORGEN  (
   RF_ORGEN_CODETN      VARCHAR2(4)                     not null,
   RF_ORGEN_CODETN_REF  VARCHAR2(4),
   RF_TORG_COD          VARCHAR2(1)                     not null,
   RF_FORM_COD          VARCHAR2(7)                     not null,
   RF_ZONE_COD          VARCHAR2(2)                     not null,
   RF_CMD_COD           VARCHAR2(2),
   RF_REG_ID            INTEGER,
   RF_ORGEN_CODA        VARCHAR2(2),
   RF_ORGEN_SIRET       VARCHAR2(14),
   RF_ORGEN_LIB         VARCHAR2(50)                    not null,
   RF_ORGEN_LIBA        VARCHAR2(15),
   RF_ORGEN_AD1         VARCHAR2(25),
   RF_ORGEN_AD2         VARCHAR2(25),
   RF_ORGEN_AD3         VARCHAR2(25),
   RF_ORGEN_ADT         VARCHAR2(20),
   RF_ORGEN_CP          VARCHAR2(5),
   RF_ORGEN_TELO        VARCHAR2(15),
   RF_ORGEN_TELR        VARCHAR2(15),
   RF_ORGEN_FAX         VARCHAR2(15),
   RF_ORGEN_VILL        VARCHAR2(30),
   RF_ORGEN_CODETBAV    VARCHAR2(2),
   RF_ORGEN_INDAVAP     VARCHAR2(2)                    
      constraint RF_ORGEN_CK1_1 check (RF_ORGEN_INDAVAP is null or (RF_ORGEN_INDAVAP in ('AV','AP'))),
   RF_ORGEN_CODEG       VARCHAR2(1),
   RF_ORGEN_PRM_COD     VARCHAR2(2),
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ORGEN_CK1_2 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_MAJ_ID            INTEGER                         not null
);

comment on table RF_ORGEN is
'Organisme du Genie';

comment on column RF_ORGEN.RF_ORGEN_CODETN is
'Identification definitive des organismes';

comment on column RF_ORGEN.RF_ORGEN_CODETN_REF is
'Identification definitive des organismes';

comment on column RF_ORGEN.RF_TORG_COD is
'Identifiant Type Organisme';

comment on column RF_ORGEN.RF_FORM_COD is
'Code Credo';

comment on column RF_ORGEN.RF_ZONE_COD is
'Code Zone';

comment on column RF_ORGEN.RF_CMD_COD is
'Code CMD';

comment on column RF_ORGEN.RF_REG_ID is
'Region';

comment on column RF_ORGEN.RF_ORGEN_CODA is
'Abrege definitif des organismes';

comment on column RF_ORGEN.RF_ORGEN_SIRET is
'Numero SIRET de l''organisme';

comment on column RF_ORGEN.RF_ORGEN_LIB is
'Libelle Long Organisme';

comment on column RF_ORGEN.RF_ORGEN_LIBA is
'Libelle Court Organisme';

comment on column RF_ORGEN.RF_ORGEN_AD1 is
'Libelle Adresse 1';

comment on column RF_ORGEN.RF_ORGEN_AD2 is
'Libelle Adresse 2';

comment on column RF_ORGEN.RF_ORGEN_AD3 is
'Libelle Adresse 3';

comment on column RF_ORGEN.RF_ORGEN_ADT is
'Nom trans Organisme';

comment on column RF_ORGEN.RF_ORGEN_CP is
'Code Postal';

comment on column RF_ORGEN.RF_ORGEN_TELO is
'Tph de l''Organisme';

comment on column RF_ORGEN.RF_ORGEN_TELR is
'Ritter de l''Organisme';

comment on column RF_ORGEN.RF_ORGEN_FAX is
'Fax de l''Organisme';

comment on column RF_ORGEN.RF_ORGEN_VILL is
'Ville de l''Organisme';

comment on column RF_ORGEN.RF_ORGEN_CODETBAV is
'Code de l''etablissement actuel avt';

comment on column RF_ORGEN.RF_ORGEN_INDAVAP is
'Indicateur avant apres';

comment on column RF_ORGEN.RF_ORGEN_CODEG is
'Code EG utilisable dans les codes internes';

comment on column RF_ORGEN.RF_ORGEN_PRM_COD is
'Code Personne Responsable du Marche';

comment on column RF_ORGEN.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_ORGEN.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_ORGEN.RF_MAJ_ID is
'Code SAGRI';

alter table RF_ORGEN
   add constraint RF_ORGEN_PK1_1 primary key (RF_ORGEN_CODETN);

/*==============================================================*/
/* Index : RF_ORGEN_FK1_4                                       */
/*==============================================================*/
create index RF_ORGEN_FK1_4 on RF_ORGEN (
   RF_TORG_COD ASC
);

/*==============================================================*/
/* Index : RF_ORGEN_FK1_1                                       */
/*==============================================================*/
create index RF_ORGEN_FK1_1 on RF_ORGEN (
   RF_ORGEN_CODETN_REF ASC
);

/*==============================================================*/
/* Index : RF_ORGEN_FK1_2                                       */
/*==============================================================*/
create index RF_ORGEN_FK1_2 on RF_ORGEN (
   RF_FORM_COD ASC
);

/*==============================================================*/
/* Index : RF_ORGEN_FK1_3                                       */
/*==============================================================*/
create index RF_ORGEN_FK1_3 on RF_ORGEN (
   RF_ZONE_COD ASC
);

/*==============================================================*/
/* Index : RF_ORGEN_FK2_5                                       */
/*==============================================================*/
create index RF_ORGEN_FK2_5 on RF_ORGEN (
   RF_REG_ID ASC
);

/*==============================================================*/
/* Index : RF_ORGEN_FK1_6                                       */
/*==============================================================*/
create index RF_ORGEN_FK1_6 on RF_ORGEN (
   RF_CMD_COD ASC
);

/*==============================================================*/
/* Index : RF_ORGEN_FK1_7                                       */
/*==============================================================*/
create index RF_ORGEN_FK1_7 on RF_ORGEN (
   RF_MAJ_ID ASC
);

grant SELECT on RF_ORGEN to PUBLIC;

grant REFERENCES on RF_ORGEN to PUBLIC;

grant REFERENCES on RF_ORGEN to PUBLIC;

grant SELECT on RF_ORGEN to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ORGRAT                                            */
/*==============================================================*/
create table RF_ORGRAT  (
   RF_ORGRAT_ID         INTEGER                         not null,
   RF_ORGRAT_COD        VARCHAR2(20)                    not null,
   RF_ORGRAT_LIB        VARCHAR2(300)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ORGRAT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ORGRAT is
'Table des organismes de rattachement';

comment on column RF_ORGRAT.RF_ORGRAT_ID is
'Identifiant de l''organisme de rattachement';

comment on column RF_ORGRAT.RF_ORGRAT_COD is
'Code de l''organisme de rattachement';

comment on column RF_ORGRAT.RF_ORGRAT_LIB is
'Libelle de l''organisme de rattachement';

comment on column RF_ORGRAT.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_ORGRAT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ORGRAT
   add constraint RF_ORGRAT_PK1_1 primary key (RF_ORGRAT_ID);

grant SELECT on RF_ORGRAT to PUBLIC;

grant REFERENCES on RF_ORGRAT to PUBLIC;

grant REFERENCES on RF_ORGRAT to PUBLIC;

grant SELECT on RF_ORGRAT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ORIDRO                                            */
/*==============================================================*/
create table RF_ORIDRO  (
   RF_ORIDRO_ID         INTEGER                         not null,
   RF_CATORIDRO_ID      INTEGER                         not null,
   RF_ORIDRO_COD        VARCHAR2(2)                     not null,
   RF_ORIDRO_LIB        VARCHAR2(255)                   not null,
   RF_ORIDRO_LIBA       VARCHAR2(65),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ORIDRO_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ORIDRO is
'Origine des droits de l''etat
Renseigne quand on fait une entree dans le domaine
lien facultatif pour les changements d''affectation, 
lien inexistant sur tous les mouvements en sortie (alienation, , remise aux domaines, remise d''usufruits, transfert de gestion, autres modes de cession)

Table Sagri IMM13';

comment on column RF_ORIDRO.RF_ORIDRO_ID is
'Identifiant de l''origine des droits';

comment on column RF_ORIDRO.RF_CATORIDRO_ID is
'Identifiant de l''origine des droits';

comment on column RF_ORIDRO.RF_ORIDRO_COD is
'Code de l''origine des droits';

comment on column RF_ORIDRO.RF_ORIDRO_LIB is
'Libelle de l''origine des droits';

comment on column RF_ORIDRO.RF_ORIDRO_LIBA is
'Libelle abrege de l''origine des droits';

comment on column RF_ORIDRO.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_ORIDRO.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ORIDRO
   add constraint RF_ORIDRO_PK1_1 primary key (RF_ORIDRO_ID);

/*==============================================================*/
/* Index : RF_ORIDRO_FK1_1                                      */
/*==============================================================*/
create index RF_ORIDRO_FK1_1 on RF_ORIDRO (
   RF_CATORIDRO_ID ASC
);

grant SELECT on RF_ORIDRO to PUBLIC;

grant REFERENCES on RF_ORIDRO to PUBLIC;

grant REFERENCES on RF_ORIDRO to PUBLIC;

grant SELECT on RF_ORIDRO to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ORIGINE                                           */
/*==============================================================*/
create table RF_ORIGINE  (
   RF_ORIGINE_ID        INTEGER                         not null,
   RF_ORIGINE_COD       VARCHAR2(10)                    not null,
   RF_ORIGINE_LIB       VARCHAR2(100),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ORIGINE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ORIGINE is
'Origine du recrutement (concerne les PM).
';

comment on column RF_ORIGINE.RF_ORIGINE_ID is
'Identifiant de l''origine';

comment on column RF_ORIGINE.RF_ORIGINE_COD is
'Code abrege de l''origine';

comment on column RF_ORIGINE.RF_ORIGINE_LIB is
'Libelle de l''origine du recrutement';

comment on column RF_ORIGINE.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_ORIGINE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ORIGINE
   add constraint RF_ORIGINE_PK1_1 primary key (RF_ORIGINE_ID);

/*==============================================================*/
/* Index : RF_ORIGINE_UN1_1                                     */
/*==============================================================*/
create unique index RF_ORIGINE_UN1_1 on RF_ORIGINE (
   RF_ORIGINE_COD ASC
);

grant SELECT on RF_ORIGINE to PUBLIC;

grant REFERENCES on RF_ORIGINE to PUBLIC;

grant REFERENCES on RF_ORIGINE to PUBLIC;

grant SELECT on RF_ORIGINE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ORISNUP                                           */
/*==============================================================*/
create table RF_ORISNUP  (
   RF_ORISNUP_ID        INTEGER                         not null,
   RF_ORISNUP_COD       VARCHAR2(1)                     not null,
   RF_ORISNUP_LIB       VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ORISNUP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ORISNUP is
'Origine d''une servitude non d''utiliste publique';

comment on column RF_ORISNUP.RF_ORISNUP_ID is
'Identifiant de l''origine d''une S.N.U.P.';

comment on column RF_ORISNUP.RF_ORISNUP_COD is
'Code de l''origine d''une S.N.U.P.';

comment on column RF_ORISNUP.RF_ORISNUP_LIB is
'Libelle de l''origine d''une S.N.U.P.';

comment on column RF_ORISNUP.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_ORISNUP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ORISNUP
   add constraint RF_ORISNUP_PK1_1 primary key (RF_ORISNUP_ID);

/*==============================================================*/
/* Index : RF_ORISNUP_UN1_1                                     */
/*==============================================================*/
create unique index RF_ORISNUP_UN1_1 on RF_ORISNUP (
   RF_ORISNUP_COD ASC
);

grant SELECT on RF_ORISNUP to PUBLIC;

grant REFERENCES on RF_ORISNUP to PUBLIC;

grant REFERENCES on RF_ORISNUP to PUBLIC;

grant SELECT on RF_ORISNUP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_PARAG                                             */
/*==============================================================*/
create table RF_PARAG  (
   RF_IMPE_COD          VARCHAR2(6)                     not null,
   RF_PARAG_NUM         VARCHAR2(2)                     not null,
   RF_PARAG_LIB         VARCHAR2(200)                   not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_PARAG_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_PARAG is
'Paragraphe';

comment on column RF_PARAG.RF_IMPE_COD is
'Code imputation d''execution';

comment on column RF_PARAG.RF_PARAG_NUM is
'Numero de Paragraphe';

comment on column RF_PARAG.RF_PARAG_LIB is
'Libelle du Paragraphe';

comment on column RF_PARAG.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_PARAG.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_PARAG
   add constraint RF_PARAG_PK2_1 primary key (RF_IMPE_COD, RF_PARAG_NUM);

/*==============================================================*/
/* Index : RF_PARAG_FK1_1                                       */
/*==============================================================*/
create index RF_PARAG_FK1_1 on RF_PARAG (
   RF_IMPE_COD ASC
);

grant SELECT on RF_PARAG to PUBLIC;

grant REFERENCES on RF_PARAG to PUBLIC;

grant REFERENCES on RF_PARAG to PUBLIC;

grant SELECT on RF_PARAG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_PAYS                                              */
/*==============================================================*/
create table RF_PAYS  (
   RF_PAYS_COD          VARCHAR2(5)                     not null,
   RF_PAYS_LIB          VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_PAYS_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_PAYS is
'Pays';

comment on column RF_PAYS.RF_PAYS_COD is
'Code du pays';

comment on column RF_PAYS.RF_PAYS_LIB is
'Clair du pays';

comment on column RF_PAYS.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_PAYS.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_PAYS
   add constraint RF_PAYS_PK1_1 primary key (RF_PAYS_COD);

grant SELECT on RF_PAYS to PUBLIC;

grant REFERENCES on RF_PAYS to PUBLIC;

grant REFERENCES on RF_PAYS to PUBLIC;

grant SELECT on RF_PAYS to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_PAYS_NG                                           */
/*==============================================================*/
create table RF_PAYS_NG  (
   RF_PAYS_ID           INTEGER                         not null,
   RF_PAYS_COUNTRY      VARCHAR2(3)                     not null,
   RF_PAYS_TXTSH        VARCHAR2(20),
   RF_PAYS_TXTMD        VARCHAR2(40),
   RF_PAYS_TXTLG        VARCHAR2(60),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_PAYS_NG is
'Table des codes pays CHORUS.';

comment on column RF_PAYS_NG.RF_PAYS_ID is
'ID code pays CHORUS.';

comment on column RF_PAYS_NG.RF_PAYS_COUNTRY is
'Cle code pays CHORUS.';

comment on column RF_PAYS_NG.RF_PAYS_TXTSH is
'Description synthetique code pays CHORUS.';

comment on column RF_PAYS_NG.RF_PAYS_TXTMD is
'Description moyenne code pays CHORUS.';

comment on column RF_PAYS_NG.RF_PAYS_TXTLG is
'Description longue code pays CHORUS.';

comment on column RF_PAYS_NG.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_PAYS_NG.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_PAYS_NG
   add constraint RF_PAYS_NG_PK1_1 primary key (RF_PAYS_ID);

alter table RF_PAYS_NG
   add constraint RF_PAYS_NG_UN1_1 unique (RF_PAYS_COUNTRY);

grant SELECT on RF_PAYS_NG to PUBLIC;

grant REFERENCES on RF_PAYS_NG to PUBLIC;

grant REFERENCES on RF_PAYS_NG to PUBLIC;

grant SELECT on RF_PAYS_NG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_PHASE                                             */
/*==============================================================*/
create table RF_PHASE  (
   RF_PHASE_ID          INTEGER                         not null,
   RF_PHASE_NUM         INTEGER                         not null,
   RF_PHASE_LIB         VARCHAR2(80)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_PHASE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_PHASE is
'Table des phases';

comment on column RF_PHASE.RF_PHASE_ID is
'Identifiant de la phase';

comment on column RF_PHASE.RF_PHASE_NUM is
'Numero de la phase';

comment on column RF_PHASE.RF_PHASE_LIB is
'Libelle de la phase';

comment on column RF_PHASE.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_PHASE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_PHASE
   add constraint RF_PHASE_PK1_1 primary key (RF_PHASE_ID);

/*==============================================================*/
/* Index : RF_PHASE_UN1_1                                       */
/*==============================================================*/
create unique index RF_PHASE_UN1_1 on RF_PHASE (
   RF_PHASE_NUM ASC
);

grant SELECT on RF_PHASE to PUBLIC;

grant REFERENCES on RF_PHASE to PUBLIC;

grant REFERENCES on RF_PHASE to PUBLIC;

grant SELECT on RF_PHASE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_POSSTAT                                           */
/*==============================================================*/
create table RF_POSSTAT  (
   RF_POSSTAT_ID        INTEGER                         not null,
   RF_TPERS_ID          INTEGER                         not null,
   RF_POSSTAT_COD       VARCHAR2(15)                    not null,
   RF_POSSTAT_LIB       VARCHAR2(60),
   RF_POSSTAT_VAL       INTEGER                         not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_POSSTAT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_POSSTAT is
'table des positions statutaires';

comment on column RF_POSSTAT.RF_POSSTAT_ID is
'Identifiant de position statutaire';

comment on column RF_POSSTAT.RF_TPERS_ID is
'Identifiant du type personnel';

comment on column RF_POSSTAT.RF_POSSTAT_COD is
'Code position statutaire';

comment on column RF_POSSTAT.RF_POSSTAT_LIB is
'Libelle position statutaire';

comment on column RF_POSSTAT.RF_POSSTAT_VAL is
'Position Statutaire';

comment on column RF_POSSTAT.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_POSSTAT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_POSSTAT
   add constraint RF_POSSTAT_PK1_1 primary key (RF_POSSTAT_ID);

/*==============================================================*/
/* Index : RF_POSSTAT_UN2_1                                     */
/*==============================================================*/
create unique index RF_POSSTAT_UN2_1 on RF_POSSTAT (
   RF_TPERS_ID ASC,
   RF_POSSTAT_COD ASC
);

/*==============================================================*/
/* Index : RF_POSSTAT_FK1_1                                     */
/*==============================================================*/
create index RF_POSSTAT_FK1_1 on RF_POSSTAT (
   RF_TPERS_ID ASC
);

grant SELECT on RF_POSSTAT to PUBLIC;

grant REFERENCES on RF_POSSTAT to PUBLIC;

grant REFERENCES on RF_POSSTAT to PUBLIC;

grant SELECT on RF_POSSTAT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_POSTPS                                            */
/*==============================================================*/
create table RF_POSTPS  (
   RF_POSTPS_ID         INTEGER                         not null,
   RF_POSSTAT_ID        INTEGER                         not null,
   RF_TPSTRAV_ID        INTEGER                         not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_POSTPS_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_POSTPS is
'Table de liaison entre rf_postat (position statutaire) et rf_tpstrav (temps de trvail).';

comment on column RF_POSTPS.RF_POSTPS_ID is
'Identifiant de la table de liaison entre postat et tpstrav';

comment on column RF_POSTPS.RF_POSSTAT_ID is
'Identifiant de position statutaire';

comment on column RF_POSTPS.RF_TPSTRAV_ID is
'Identifiant temps de travail';

comment on column RF_POSTPS.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_POSTPS.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_POSTPS
   add constraint RF_POSTPS_PK1_1 primary key (RF_POSTPS_ID);

/*==============================================================*/
/* Index : RF_POSTPS_FK1_1                                      */
/*==============================================================*/
create index RF_POSTPS_FK1_1 on RF_POSTPS (
   RF_POSSTAT_ID ASC
);

/*==============================================================*/
/* Index : RF_POSTPS_FK1_2                                      */
/*==============================================================*/
create index RF_POSTPS_FK1_2 on RF_POSTPS (
   RF_TPSTRAV_ID ASC
);

/*==============================================================*/
/* Index : RF_POSTPS_UN2_1                                      */
/*==============================================================*/
create unique index RF_POSTPS_UN2_1 on RF_POSTPS (
   RF_POSSTAT_ID ASC,
   RF_TPSTRAV_ID ASC
);

grant SELECT on RF_POSTPS to PUBLIC;

grant REFERENCES on RF_POSTPS to PUBLIC;

grant REFERENCES on RF_POSTPS to PUBLIC;

grant SELECT on RF_POSTPS to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_PROD                                              */
/*==============================================================*/
create table RF_PROD  (
   RF_PROD_COD          VARCHAR2(6)                     not null,
   RF_LIGMER_COD        VARCHAR2(6),
   RF_ACVT_COD          VARCHAR2(1),
   RF_PROD_LIB          VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_PROD_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_PROD is
'Produit';

comment on column RF_PROD.RF_PROD_COD is
'Code Ligne Produit';

comment on column RF_PROD.RF_LIGMER_COD is
'Code Ligne Mercure';

comment on column RF_PROD.RF_ACVT_COD is
'Code Activite';

comment on column RF_PROD.RF_PROD_LIB is
'Libelle Ligne Produit';

comment on column RF_PROD.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_PROD.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_PROD
   add constraint RF_PROD_PK1_1 primary key (RF_PROD_COD);

/*==============================================================*/
/* Index : RF_PROD_FK1_1                                        */
/*==============================================================*/
create index RF_PROD_FK1_1 on RF_PROD (
   RF_LIGMER_COD ASC
);

/*==============================================================*/
/* Index : RF_PROD_FK1_2                                        */
/*==============================================================*/
create index RF_PROD_FK1_2 on RF_PROD (
   RF_ACVT_COD ASC
);

grant SELECT on RF_PROD to PUBLIC;

grant REFERENCES on RF_PROD to PUBLIC;

grant REFERENCES on RF_PROD to PUBLIC;

grant SELECT on RF_PROD to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_PROG                                              */
/*==============================================================*/
create table RF_PROG  (
   RF_PROG_ID           INTEGER                         not null,
   RF_PROG_COD          VARCHAR2(4)                     not null,
   RF_PROG_LIB          VARCHAR2(300)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_PROG_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_PROG is
'Table des programmes issus du referentiel CHORUS.
';

comment on column RF_PROG.RF_PROG_ID is
'Identifiant du programme';

comment on column RF_PROG.RF_PROG_COD is
'Code du programme';

comment on column RF_PROG.RF_PROG_LIB is
'Libelle du programme';

comment on column RF_PROG.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_PROG.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_PROG
   add constraint RF_PROG_PK1_1 primary key (RF_PROG_ID);

grant SELECT on RF_PROG to PUBLIC;

grant REFERENCES on RF_PROG to PUBLIC;

grant REFERENCES on RF_PROG to PUBLIC;

grant SELECT on RF_PROG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_PROJ                                              */
/*==============================================================*/
create table RF_PROJ  (
   RF_PROJ_ID           INTEGER                         not null,
   RF_PROJ_ANAMIN       VARCHAR2(22)                    not null,
   RF_PROJ_ETXTMD       VARCHAR2(40),
   RF_PROJ_CODMIN       VARCHAR2(5),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_PROJ is
'Table des projets analytiques de CHORUS.';

comment on column RF_PROJ.RF_PROJ_ID is
'ID du projet analytique de CHORUS.';

comment on column RF_PROJ.RF_PROJ_ANAMIN is
'Code du projet analytique de CHORUS.';

comment on column RF_PROJ.RF_PROJ_ETXTMD is
'Description du projet analytique de CHORUS.';

comment on column RF_PROJ.RF_PROJ_CODMIN is
'Code ministere du projet analytique de CHORUS.';

comment on column RF_PROJ.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_PROJ.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_PROJ
   add constraint RF_PROJ_PK1_1 primary key (RF_PROJ_ID);

alter table RF_PROJ
   add constraint RF_PROJ_UN1_1 unique (RF_PROJ_ANAMIN);

grant SELECT on RF_PROJ to PUBLIC;

grant REFERENCES on RF_PROJ to PUBLIC;

grant REFERENCES on RF_PROJ to PUBLIC;

grant SELECT on RF_PROJ to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_PROPRICPT                                         */
/*==============================================================*/
create table RF_PROPRICPT  (
   RF_PROPRICPT_ID      INTEGER                         not null,
   RF_TPRO_ID           INTEGER                         not null,
   RF_PROPRICPT_COD     VARCHAR2(2),
   RF_PROPRICPT_CODRE   VARCHAR2(2),
   RF_PROPRICPT_DES     VARCHAR2(80),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

alter table RF_PROPRICPT
   add constraint RF_PROPRICPT_PK1_1 primary key (RF_PROPRICPT_ID);

/*==============================================================*/
/* Index : RF_PROPRICPT_FK1_1                                   */
/*==============================================================*/
create index RF_PROPRICPT_FK1_1 on RF_PROPRICPT (
   RF_TPRO_ID ASC
);

/*==============================================================*/
/* Index : RF_PROPRICPT_PK1_1                                   */
/*==============================================================*/
create unique index RF_PROPRICPT_PK1_1 on RF_PROPRICPT (
   RF_PROPRICPT_ID ASC
);

grant SELECT on RF_PROPRICPT to PUBLIC;

grant REFERENCES on RF_PROPRICPT to PUBLIC;

grant REFERENCES on RF_PROPRICPT to PUBLIC;

grant SELECT on RF_PROPRICPT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_RATFIS                                            */
/*==============================================================*/
create table RF_RATFIS  (
   RF_RATFIS_ID         INTEGER                         not null,
   RF_DEPT_ID           INTEGER                         not null,
   RF_RATFIS_COD        VARCHAR2(3)                     not null,
   RF_RATFIS_LIB        VARCHAR2(35)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_RATFIS_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_RATFIS is
'Table des rattachements aux services fiscaux departementaux';

comment on column RF_RATFIS.RF_RATFIS_ID is
'Identifiant du rattachement fiscal';

comment on column RF_RATFIS.RF_DEPT_ID is
'Identifiant du departement';

comment on column RF_RATFIS.RF_RATFIS_COD is
'Code du rattachement fiscal';

comment on column RF_RATFIS.RF_RATFIS_LIB is
'Libelle du rattachement fiscal';

comment on column RF_RATFIS.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_RATFIS.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_RATFIS
   add constraint RF_RATFIS_PK1_1 primary key (RF_RATFIS_ID);

/*==============================================================*/
/* Index : RF_RATFIS_FK1_1                                      */
/*==============================================================*/
create index RF_RATFIS_FK1_1 on RF_RATFIS (
   RF_DEPT_ID ASC
);

/*==============================================================*/
/* Index : RF_RATFIS_UN2_1                                      */
/*==============================================================*/
create unique index RF_RATFIS_UN2_1 on RF_RATFIS (
   RF_DEPT_ID ASC,
   RF_RATFIS_COD ASC
);

grant SELECT on RF_RATFIS to PUBLIC;

grant REFERENCES on RF_RATFIS to PUBLIC;

grant REFERENCES on RF_RATFIS to PUBLIC;

grant SELECT on RF_RATFIS to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_REFCAPA                                           */
/*==============================================================*/
create table RF_REFCAPA  (
   RF_REFCAPA_ID        INTEGER                         not null,
   RF_REFCAPA_COD       VARCHAR2(10)                    not null,
   RF_REFCAPA_LIB       VARCHAR2(200)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_REFCAPA_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_REFCAPA is
'Referentiel Capacitaire';

comment on column RF_REFCAPA.RF_REFCAPA_ID is
'Identifiant de la reference capacitaire';

comment on column RF_REFCAPA.RF_REFCAPA_COD is
'Code de la reference capacitaire';

comment on column RF_REFCAPA.RF_REFCAPA_LIB is
'Libelle de la reference capacitaire';

comment on column RF_REFCAPA.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_REFCAPA.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_REFCAPA
   add constraint RF_REFCAPA_PK1_1 primary key (RF_REFCAPA_ID);

grant SELECT on RF_REFCAPA to PUBLIC;

grant SELECT on RF_REFCAPA to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_REG                                               */
/*==============================================================*/
create table RF_REG  (
   RF_REG_ID            INTEGER                         not null,
   RF_TREG_COD          VARCHAR2(1)                     not null,
   RF_REG_COD           VARCHAR2(1)                     not null,
   RF_REG_SAGRI_NUM     VARCHAR2(2)                     not null,
   RF_REG_LIB           VARCHAR2(100)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_REG_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_REG_LIBA          VARCHAR2(10)
);

comment on table RF_REG is
'Region';

comment on column RF_REG.RF_REG_ID is
'Identifiant de la region';

comment on column RF_REG.RF_TREG_COD is
'Code type de region';

comment on column RF_REG.RF_REG_COD is
'Code region';

comment on column RF_REG.RF_REG_SAGRI_NUM is
'Concatenation de RF_TREG_COD et RF_REG_COD.';

comment on column RF_REG.RF_REG_LIB is
'Libelle region';

comment on column RF_REG.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_REG.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_REG.RF_REG_LIBA is
'Libelle abrege de la region';

alter table RF_REG
   add constraint RF_REG_PK1_1 primary key (RF_REG_ID);

/*==============================================================*/
/* Index : RF_REG_FK1_1                                         */
/*==============================================================*/
create index RF_REG_FK1_1 on RF_REG (
   RF_TREG_COD ASC
);

/*==============================================================*/
/* Index : RF_REG_UN2_1                                         */
/*==============================================================*/
create unique index RF_REG_UN2_1 on RF_REG (
   RF_TREG_COD ASC,
   RF_REG_COD ASC
);

grant SELECT on RF_REG to PUBLIC;

grant REFERENCES on RF_REG to PUBLIC;

grant REFERENCES on RF_REG to PUBLIC;

grant SELECT on RF_REG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_REGDPT                                            */
/*==============================================================*/
create table RF_REGDPT  (
   RF_REGDPT_ID         INTEGER                         not null,
   RF_DEPT_ID           INTEGER                         not null,
   RF_REG_ID            INTEGER                         not null,
   RF_TREG_COD          VARCHAR2(1)                     not null,
   RF_REG_COD           VARCHAR2(1)                     not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_REGDPT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on column RF_REGDPT.RF_REGDPT_ID is
'Identifiant';

comment on column RF_REGDPT.RF_DEPT_ID is
'Identifiant du departement';

comment on column RF_REGDPT.RF_REG_ID is
'Region';

comment on column RF_REGDPT.RF_TREG_COD is
'Code type de region';

comment on column RF_REGDPT.RF_REG_COD is
'Code region';

comment on column RF_REGDPT.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_REGDPT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_REGDPT
   add constraint RF_REGDPT_PK1_1 primary key (RF_REGDPT_ID);

/*==============================================================*/
/* Index : RF_REGDPT_FK2_2                                      */
/*==============================================================*/
create index RF_REGDPT_FK2_2 on RF_REGDPT (
   RF_REG_ID ASC
);

/*==============================================================*/
/* Index : RF_REGDPT_FK1_1                                      */
/*==============================================================*/
create index RF_REGDPT_FK1_1 on RF_REGDPT (
   RF_DEPT_ID ASC
);

/*==============================================================*/
/* Index : RF_REGDPT_UN2_1                                      */
/*==============================================================*/
create unique index RF_REGDPT_UN2_1 on RF_REGDPT (
   RF_DEPT_ID ASC,
   RF_REG_ID ASC
);

grant SELECT on RF_REGDPT to PUBLIC;

grant REFERENCES on RF_REGDPT to PUBLIC;

grant REFERENCES on RF_REGDPT to PUBLIC;

grant SELECT on RF_REGDPT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_REGECO                                            */
/*==============================================================*/
create table RF_REGECO  (
   RF_REGECO_ID         INTEGER                         not null,
   RF_STE_CHORUS_ID     INTEGER,
   RF_REGECO_COD        VARCHAR2(2)                     not null,
   RF_REGECO_LIB        VARCHAR2(30)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_REGECO_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_REGECO is
'Table des regions economiques';

comment on column RF_REGECO.RF_REGECO_ID is
'Cle primaire de la region economique';

comment on column RF_REGECO.RF_REGECO_COD is
'Code de la region economique';

comment on column RF_REGECO.RF_REGECO_LIB is
'Libelle de la region economique';

comment on column RF_REGECO.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_REGECO.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_REGECO
   add constraint RF_REGECO_PK1_1 primary key (RF_REGECO_ID);

/*==============================================================*/
/* Index : RF_REGECO_UN1_1                                      */
/*==============================================================*/
create unique index RF_REGECO_UN1_1 on RF_REGECO (
   RF_REGECO_COD ASC
);

grant SELECT on RF_REGECO to PUBLIC;

grant REFERENCES on RF_REGECO to PUBLIC;

grant REFERENCES on RF_REGECO to PUBLIC;

grant SELECT on RF_REGECO to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_REGION                                            */
/*==============================================================*/
create table RF_REGION  (
   RF_REGION_ID         INTEGER                         not null,
   RF_PAYS_ID           INTEGER                         not null,
   RF_REGION_COD        VARCHAR2(3)                     not null,
   RF_REGION_TXTSH      VARCHAR2(20),
   RF_REGION_TXTMD      VARCHAR2(40),
   RF_REGION_TXTLG      VARCHAR2(60),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_REGION is
'Table des regions CHORUS.';

comment on column RF_REGION.RF_REGION_ID is
'ID region CHORUS.';

comment on column RF_REGION.RF_PAYS_ID is
'ID code pays CHORUS.';

comment on column RF_REGION.RF_REGION_COD is
'Code region CHORUS.';

comment on column RF_REGION.RF_REGION_TXTSH is
'Description synthetique region CHORUS.';

comment on column RF_REGION.RF_REGION_TXTMD is
'Description moyenne region CHORUS.';

comment on column RF_REGION.RF_REGION_TXTLG is
'Description longue region CHORUS.';

comment on column RF_REGION.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_REGION.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_REGION
   add constraint RF_REGION_PK1_1 primary key (RF_REGION_ID);

alter table RF_REGION
   add constraint RF_REGION_UN2_1 unique (RF_REGION_COD, RF_PAYS_ID);

/*==============================================================*/
/* Index : RF_REGION_FK1_1                                      */
/*==============================================================*/
create index RF_REGION_FK1_1 on RF_REGION (
   RF_PAYS_ID ASC
);

grant SELECT on RF_REGION to PUBLIC;

grant REFERENCES on RF_REGION to PUBLIC;

grant REFERENCES on RF_REGION to PUBLIC;

grant SELECT on RF_REGION to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_REGSTAT                                           */
/*==============================================================*/
create table RF_REGSTAT  (
   RF_REGSTAT_ID        INTEGER                         not null,
   RF_REGSTAT_COD       VARCHAR2(6)                     not null,
   RF_STATUT_ID         INTEGER                         not null,
   RF_REGSTAT_LIB       VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_REGSTAT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_REGSTAT is
'Table des regimes statutaires.
Concerne les PC';

comment on column RF_REGSTAT.RF_REGSTAT_ID is
'Identifiant du regime statutaire';

comment on column RF_REGSTAT.RF_REGSTAT_COD is
'Code du regime statutaire';

comment on column RF_REGSTAT.RF_STATUT_ID is
'Identifiant du statut';

comment on column RF_REGSTAT.RF_REGSTAT_LIB is
'Libelle du regime statutaire';

comment on column RF_REGSTAT.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_REGSTAT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_REGSTAT
   add constraint RF_REGSTAT_PK1_1 primary key (RF_REGSTAT_ID);

/*==============================================================*/
/* Index : RF_REGSTAT_FK1_1                                     */
/*==============================================================*/
create index RF_REGSTAT_FK1_1 on RF_REGSTAT (
   RF_STATUT_ID ASC
);

/*==============================================================*/
/* Index : RF_REGSTAT_UN1_1                                     */
/*==============================================================*/
create unique index RF_REGSTAT_UN1_1 on RF_REGSTAT (
   RF_REGSTAT_COD ASC
);

grant SELECT on RF_REGSTAT to PUBLIC;

grant REFERENCES on RF_REGSTAT to PUBLIC;

grant REFERENCES on RF_REGSTAT to PUBLIC;

grant SELECT on RF_REGSTAT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_RTORG2                                            */
/*==============================================================*/
create table RF_RTORG2  (
   RF_RTORG_ID          INTEGER                         not null,
   RF_ORGEN_CODETN      VARCHAR2(4)                     not null,
   RF_ORGANISME_ID      INTEGER                         not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_RTORG_CK1_1 check (RF_XTOPSUP in ('0','1','9','2','3','M'))
);

comment on table RF_RTORG2 is
'Table de correspondance des organismes avec un identifiant numerique unique';

comment on column RF_RTORG2.RF_ORGEN_CODETN is
'Identification definitive des organismes';

comment on column RF_RTORG2.RF_ORGANISME_ID is
'Identifiant de l''organisme';

comment on column RF_RTORG2.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_RTORG2.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_RTORG2
   add constraint RF_RTORG_PK1_1 primary key (RF_RTORG_ID);

/*==============================================================*/
/* Index : RF_RTORG_FK1_1                                       */
/*==============================================================*/
create index RF_RTORG_FK1_1 on RF_RTORG2 (
   RF_ORGEN_CODETN ASC
);

/*==============================================================*/
/* Index : RF_RTORG_FK1_2                                       */
/*==============================================================*/
create index RF_RTORG_FK1_2 on RF_RTORG2 (
   RF_ORGANISME_ID ASC
);

grant SELECT on RF_RTORG2 to PUBLIC;

grant REFERENCES on RF_RTORG2 to PUBLIC;

grant REFERENCES on RF_RTORG2 to PUBLIC;

grant SELECT on RF_RTORG2 to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_SB                                                */
/*==============================================================*/
create table RF_SB  (
   RF_SB_ID             INTEGER                         not null,
   RF_SB_COD            VARCHAR2(15)                    not null,
   RF_SB_LIB            VARCHAR2(300)                   not null,
   RF_SB_LIBA           VARCHAR2(100)                   not null,
   RF_CODMIN_ID         INTEGER                         not null,
   RF_ORGRAT_ID         INTEGER                         not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_SB_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_SB is
'Table des services beneficiaires issus du referentiel CHORUS';

comment on column RF_SB.RF_SB_ID is
'Identifiant du Service Beneficiaire';

comment on column RF_SB.RF_SB_COD is
'Code du Service Beneficiaire';

comment on column RF_SB.RF_SB_LIB is
'Libelle du Service Beneficiaire';

comment on column RF_SB.RF_SB_LIBA is
'Libelle abrege du Service Beneficiaire';

comment on column RF_SB.RF_CODMIN_ID is
'Identifiant du code ministere';

comment on column RF_SB.RF_ORGRAT_ID is
'Identifiant de l''organisme d''appartenance';

comment on column RF_SB.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_SB.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_SB
   add constraint RF_SB_PK1_1 primary key (RF_SB_ID);

/*==============================================================*/
/* Index : RF_SB_FK1_2                                          */
/*==============================================================*/
create index RF_SB_FK1_2 on RF_SB (
   RF_CODMIN_ID ASC
);

/*==============================================================*/
/* Index : RF_SB_FK1_1                                          */
/*==============================================================*/
create index RF_SB_FK1_1 on RF_SB (
   RF_ORGRAT_ID ASC
);

grant SELECT on RF_SB to PUBLIC;

grant REFERENCES on RF_SB to PUBLIC;

grant REFERENCES on RF_SB to PUBLIC;

grant SELECT on RF_SB to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_SCTPAIE                                           */
/*==============================================================*/
create table RF_SCTPAIE  (
   RF_SCTPAIE_COD       VARCHAR2(3)                     not null,
   RF_SCTPAIE_LIB       VARCHAR2(80)                    not null,
   RF_SCTPAIE_SEUIL     VARCHAR2(1)                     not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_SCTPAIE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_SCTPAIE_TYP       VARCHAR2(1)                    
      constraint RF_SCTPAIE_CK1_2 check (RF_SCTPAIE_TYP is null or (RF_SCTPAIE_TYP in ('A','M','F','N','R')))
);

comment on table RF_SCTPAIE is
'Table des codes de type de paiement';

comment on column RF_SCTPAIE.RF_SCTPAIE_COD is
'Code du type de paiement';

comment on column RF_SCTPAIE.RF_SCTPAIE_LIB is
'Libelle du code type de paiement';

comment on column RF_SCTPAIE.RF_SCTPAIE_SEUIL is
'Suivi du seuil (O ou N)';

comment on column RF_SCTPAIE.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_SCTPAIE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_SCTPAIE.RF_SCTPAIE_TYP is
'Type de paiement';

alter table RF_SCTPAIE
   add constraint RF_SCTPAIE_PK1_1 primary key (RF_SCTPAIE_COD);

grant SELECT on RF_SCTPAIE to PUBLIC;

grant REFERENCES on RF_SCTPAIE to PUBLIC;

grant REFERENCES on RF_SCTPAIE to PUBLIC;

grant SELECT on RF_SCTPAIE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_SCTUTIL                                           */
/*==============================================================*/
create table RF_SCTUTIL  (
   RF_SCTUTIL_ID        INTEGER                         not null,
   RF_CTUTIL_ID         INTEGER                         not null,
   RF_SCTUTIL_COD       VARCHAR2(5)                     not null,
   RF_SCTUTIL_LIB       VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_SCTUTIL_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_SCTUTIL is
'Contient RF_CLAUTIL_COD et RF_CLAUTIL_SCAT';

comment on column RF_SCTUTIL.RF_SCTUTIL_ID is
'Identifiant de la sous categorie';

comment on column RF_SCTUTIL.RF_CTUTIL_ID is
'Identifiant de la categorie d''utilisation';

comment on column RF_SCTUTIL.RF_SCTUTIL_COD is
'Code sous categorie classe utilisation';

comment on column RF_SCTUTIL.RF_SCTUTIL_LIB is
'Libelle sous categorie clautil';

comment on column RF_SCTUTIL.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_SCTUTIL.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_SCTUTIL
   add constraint RF_SCTUTIL_PK1_1 primary key (RF_SCTUTIL_ID);

/*==============================================================*/
/* Index : RF_SCTUTIL_FK1_1                                     */
/*==============================================================*/
create index RF_SCTUTIL_FK1_1 on RF_SCTUTIL (
   RF_CTUTIL_ID ASC
);

/*==============================================================*/
/* Index : RF_SCTUTIL_UN2_1                                     */
/*==============================================================*/
create unique index RF_SCTUTIL_UN2_1 on RF_SCTUTIL (
   RF_CTUTIL_ID ASC,
   RF_SCTUTIL_COD ASC
);

grant SELECT on RF_SCTUTIL to PUBLIC;

grant REFERENCES on RF_SCTUTIL to PUBLIC;

grant REFERENCES on RF_SCTUTIL to PUBLIC;

grant SELECT on RF_SCTUTIL to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_SE                                                */
/*==============================================================*/
create table RF_SE  (
   RF_SE_ID             INTEGER                         not null,
   RF_ORGRAT_ID         INTEGER                         not null,
   RF_CODMIN_ID         INTEGER                         not null,
   RF_SE_COD            VARCHAR2(10)                    not null,
   RF_SE_LIB            VARCHAR2(300)                   not null,
   RF_SE_ACHETEUR       VARCHAR2(3),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_SE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_SE is
'Table des services executants. Donnees issues du referentiel Chorus.';

comment on column RF_SE.RF_SE_ID is
'Identifiant du Service Executant';

comment on column RF_SE.RF_ORGRAT_ID is
'Identifiant de l''organisme de rattachement';

comment on column RF_SE.RF_CODMIN_ID is
'Identifiant du code ministere';

comment on column RF_SE.RF_SE_COD is
'Code du Service Executant';

comment on column RF_SE.RF_SE_LIB is
'Libelle du Service Executant';

comment on column RF_SE.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_SE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_SE
   add constraint RF_SE_PK1_1 primary key (RF_SE_ID);

/*==============================================================*/
/* Index : RF_SE_FK1_1                                          */
/*==============================================================*/
create index RF_SE_FK1_1 on RF_SE (
   RF_ORGRAT_ID ASC
);

/*==============================================================*/
/* Index : RF_SE_FK1_2                                          */
/*==============================================================*/
create index RF_SE_FK1_2 on RF_SE (
   RF_CODMIN_ID ASC
);

grant SELECT on RF_SE to PUBLIC;

grant REFERENCES on RF_SE to PUBLIC;

grant REFERENCES on RF_SE to PUBLIC;

grant SELECT on RF_SE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_SEEX                                              */
/*==============================================================*/
create table RF_SEEX  (
   RF_SEEX_ID           INTEGER                         not null,
   RF_SEEX_CO_AREA      VARCHAR2(4)                     not null,
   RF_SEEX_COSTCENTER   VARCHAR2(10)                    not null,
   RF_SEEX_DATEFROM     VARCHAR2(15),
   RF_SEEX_ETXTSH       VARCHAR2(20),
   RF_SEEX_ETXTMD       VARCHAR2(40),
   RF_SEEX_DATETO       VARCHAR2(15)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_SEEX is
'Table des services executants CHORUS.';

comment on column RF_SEEX.RF_SEEX_ID is
'ID centre de couts.';

comment on column RF_SEEX.RF_SEEX_CO_AREA is
'Perimetre analytique.';

comment on column RF_SEEX.RF_SEEX_COSTCENTER is
'Centre de cout.';

comment on column RF_SEEX.RF_SEEX_DATETO is
'Date de fin de validite du centre de couts.';

comment on column RF_SEEX.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_SEEX.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_SEEX
   add constraint RF_SEEX_PK1_1 primary key (RF_SEEX_ID);

alter table RF_SEEX
   add constraint RF_SEEX_UN3_1 unique (RF_SEEX_CO_AREA, RF_SEEX_COSTCENTER, RF_SEEX_DATETO);

grant SELECT on RF_SEEX to PUBLIC;

grant REFERENCES on RF_SEEX to PUBLIC;

grant REFERENCES on RF_SEEX to PUBLIC;

grant SELECT on RF_SEEX to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_SEGPAT                                            */
/*==============================================================*/
create table RF_SEGPAT  (
   RF_SEGPAT_ID         INTEGER                         not null,
   RF_SEGPAT_COD        VARCHAR2(10)                    not null,
   RF_SEGPAT_LIB        VARCHAR2(100)                   not null,
   RF_SEGPAT_LIBA       VARCHAR2(70)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_SEGPATRI_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_SEGPAT is
'Segmentation du patrimoine';

comment on column RF_SEGPAT.RF_SEGPAT_ID is
'Identifiant de la segmentation du patrimoine';

comment on column RF_SEGPAT.RF_SEGPAT_COD is
'Code segmentation du patrimoine';

comment on column RF_SEGPAT.RF_SEGPAT_LIB is
'Libelle segmentation du patrimoine';

comment on column RF_SEGPAT.RF_SEGPAT_LIBA is
'Libelle court';

comment on column RF_SEGPAT.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_SEGPAT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_SEGPAT
   add constraint RF_SEGPAT_PK1_1 primary key (RF_SEGPAT_ID);

/*==============================================================*/
/* Index : RF_SEGPAT_UN1_1                                      */
/*==============================================================*/
create unique index RF_SEGPAT_UN1_1 on RF_SEGPAT (
   RF_SEGPAT_COD ASC
);

grant SELECT on RF_SEGPAT to PUBLIC;

grant REFERENCES on RF_SEGPAT to PUBLIC;

grant REFERENCES on RF_SEGPAT to PUBLIC;

grant SELECT on RF_SEGPAT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_SFCT                                              */
/*==============================================================*/
create table RF_SFCT  (
   RF_SFCT_ID           INTEGER                         not null,
   RF_SFCT_COD          VARCHAR2(4)                     not null,
   RF_ZFCT_ID           INTEGER                         not null,
   RF_SFCT_LIB          VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_SFCT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_SFCT is
'Table des sous-fonctions';

comment on column RF_SFCT.RF_SFCT_ID is
'Identifiant de la sous-fonction';

comment on column RF_SFCT.RF_SFCT_COD is
'Code de la sous-fonction';

comment on column RF_SFCT.RF_ZFCT_ID is
'Identifiant de la zone fonctionnelle';

comment on column RF_SFCT.RF_SFCT_LIB is
'Libelle de la sous-fonction';

comment on column RF_SFCT.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_SFCT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_SFCT
   add constraint RF_SFCT_PK1_1 primary key (RF_SFCT_ID);

/*==============================================================*/
/* Index : RF_SFCT_FK1_1                                        */
/*==============================================================*/
create index RF_SFCT_FK1_1 on RF_SFCT (
   RF_ZFCT_ID ASC
);

/*==============================================================*/
/* Index : RF_SFCT_UN2_1                                        */
/*==============================================================*/
create unique index RF_SFCT_UN2_1 on RF_SFCT (
   RF_SFCT_COD ASC,
   RF_ZFCT_ID ASC
);

grant SELECT on RF_SFCT to PUBLIC;

grant REFERENCES on RF_SFCT to PUBLIC;

grant REFERENCES on RF_SFCT to PUBLIC;

grant SELECT on RF_SFCT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_SFCTCLAUTIL                                       */
/*==============================================================*/
create table RF_SFCTCLAUTIL  (
   RF_SFCTCLAUTIL_ID    INTEGER                         not null,
   RF_SFCTCPT_ID        INTEGER                         not null,
   RF_LCLCLAUTIL_ID     INTEGER                         not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

alter table RF_SFCTCLAUTIL
   add constraint RF_SFCTCLAUTIL_PK1_1 primary key (RF_SFCTCLAUTIL_ID);

/*==============================================================*/
/* Index : RF_SFCTCLAUTIL_PK1_1                                 */
/*==============================================================*/
create unique index RF_SFCTCLAUTIL_PK1_1 on RF_SFCTCLAUTIL (
   RF_SFCTCLAUTIL_ID ASC
);

/*==============================================================*/
/* Index : RF_SFCTCLAUTIL_FK1_2                                 */
/*==============================================================*/
create index RF_SFCTCLAUTIL_FK1_2 on RF_SFCTCLAUTIL (
   RF_LCLCLAUTIL_ID ASC
);

/*==============================================================*/
/* Index : RF_SFCTCLAUTIL_FK1_1                                 */
/*==============================================================*/
create index RF_SFCTCLAUTIL_FK1_1 on RF_SFCTCLAUTIL (
   RF_SFCTCPT_ID ASC
);

grant SELECT on RF_SFCTCLAUTIL to PUBLIC;

grant REFERENCES on RF_SFCTCLAUTIL to PUBLIC;

grant REFERENCES on RF_SFCTCLAUTIL to PUBLIC;

grant SELECT on RF_SFCTCLAUTIL to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_SFCTCPT                                           */
/*==============================================================*/
create table RF_SFCTCPT  (
   RF_SFCTCPT_ID        INTEGER                         not null,
   RF_SFCTCPT_COD       VARCHAR2(4),
   RF_SFCTCPT_DES       VARCHAR2(100),
   RF_FCTCPT_ID         INTEGER                         not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

alter table RF_SFCTCPT
   add constraint RF_SFCTCPT_PK1_1 primary key (RF_SFCTCPT_ID);

/*==============================================================*/
/* Index : RF_SFCTCPT_PK1_1                                     */
/*==============================================================*/
create unique index RF_SFCTCPT_PK1_1 on RF_SFCTCPT (
   RF_SFCTCPT_ID ASC
);

/*==============================================================*/
/* Index : RF_SFCTCPT_FK1_1                                     */
/*==============================================================*/
create index RF_SFCTCPT_FK1_1 on RF_SFCTCPT (
   RF_FCTCPT_ID ASC
);

grant SELECT on RF_SFCTCPT to PUBLIC;

grant REFERENCES on RF_SFCTCPT to PUBLIC;

grant REFERENCES on RF_SFCTCPT to PUBLIC;

grant SELECT on RF_SFCTCPT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_SGC                                               */
/*==============================================================*/
create table RF_SGC  (
   RF_SGC_COD           VARCHAR2(2)                     not null,
   RF_SGC_LIB           VARCHAR2(15)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_SGC_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_SGC_LIBLONG       VARCHAR2(500)
);

comment on table RF_SGC is
'Service gestionnaire de credit';

comment on column RF_SGC.RF_SGC_COD is
'Code Service Gestionnaire de credit';

comment on column RF_SGC.RF_SGC_LIB is
'Libelle Service Gestionnaire de credit';

comment on column RF_SGC.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_SGC.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_SGC.RF_SGC_LIBLONG is
'Libelle Long';

alter table RF_SGC
   add constraint RF_SGC_PK1_1 primary key (RF_SGC_COD);

grant SELECT on RF_SGC to PUBLIC;

grant REFERENCES on RF_SGC to PUBLIC;

grant REFERENCES on RF_SGC to PUBLIC;

grant SELECT on RF_SGC to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_SITMAR                                            */
/*==============================================================*/
create table RF_SITMAR  (
   RF_SITMAR_ID         INTEGER                         not null,
   RF_SITMAR_COD        VARCHAR2(1)                     not null,
   RF_SITMAR_LIB        VARCHAR2(20)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_SITMAR_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_SITMAR is
'Table des situations maritales';

comment on column RF_SITMAR.RF_SITMAR_ID is
'Identifiant de situation maritale';

comment on column RF_SITMAR.RF_SITMAR_COD is
'Code sitiation maritale';

comment on column RF_SITMAR.RF_SITMAR_LIB is
'Libelle situation maritale';

comment on column RF_SITMAR.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_SITMAR.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_SITMAR
   add constraint RF_SITMAR_PK1_1 primary key (RF_SITMAR_ID);

/*==============================================================*/
/* Index : RF_SITMAR_UN1_1                                      */
/*==============================================================*/
create unique index RF_SITMAR_UN1_1 on RF_SITMAR (
   RF_SITMAR_COD ASC
);

grant SELECT on RF_SITMAR to PUBLIC;

grant REFERENCES on RF_SITMAR to PUBLIC;

grant REFERENCES on RF_SITMAR to PUBLIC;

grant SELECT on RF_SITMAR to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_SOBI                                              */
/*==============================================================*/
create table RF_SOBI  (
   RF_TETAD_COD         VARCHAR2(1)                     not null,
   RF_IMPG_COD          VARCHAR2(6)                     not null,
   RF_OBI_COD           VARCHAR2(6)                     not null,
   RF_SOBI_COD          VARCHAR2(4)                     not null,
   RF_SOBI_LIB          VARCHAR2(50)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_SOBI_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_SOBI is
'Sous operation budgetaire d''investissement';

comment on column RF_SOBI.RF_TETAD_COD is
'Code type etat D';

comment on column RF_SOBI.RF_IMPG_COD is
'Code imputation de gestion';

comment on column RF_SOBI.RF_OBI_COD is
'Code OBI';

comment on column RF_SOBI.RF_SOBI_COD is
'Code sous OBI';

comment on column RF_SOBI.RF_SOBI_LIB is
'Clair sous OBI';

comment on column RF_SOBI.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_SOBI.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_SOBI
   add constraint RF_SOBI_PK4_1 primary key (RF_TETAD_COD, RF_IMPG_COD, RF_OBI_COD, RF_SOBI_COD);

/*==============================================================*/
/* Index : RF_SOBI_PK4_1                                        */
/*==============================================================*/
create unique index RF_SOBI_PK4_1 on RF_SOBI (
   RF_SOBI_COD ASC,
   RF_IMPG_COD ASC,
   RF_OBI_COD ASC,
   RF_TETAD_COD ASC
);

/*==============================================================*/
/* Index : RF_SOBI_FK3_1                                        */
/*==============================================================*/
create index RF_SOBI_FK3_1 on RF_SOBI (
   RF_TETAD_COD ASC,
   RF_IMPG_COD ASC,
   RF_OBI_COD ASC
);

grant SELECT on RF_SOBI to PUBLIC;

grant REFERENCES on RF_SOBI to PUBLIC;

grant REFERENCES on RF_SOBI to PUBLIC;

grant SELECT on RF_SOBI to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_STATRA                                            */
/*==============================================================*/
create table RF_STATRA  (
   RF_NTTR_COD          VARCHAR2(2)                     not null,
   RF_CDSTAT_COD        VARCHAR2(3)                     not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_STATRA_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on column RF_STATRA.RF_NTTR_COD is
'Identifiant Nature Travaux';

comment on column RF_STATRA.RF_CDSTAT_COD is
'Code Statistique';

comment on column RF_STATRA.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_STATRA.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_STATRA
   add constraint RF_STATRA_PK2_1 primary key (RF_NTTR_COD, RF_CDSTAT_COD);

/*==============================================================*/
/* Index : RF_STATRA_FK1_2                                      */
/*==============================================================*/
create index RF_STATRA_FK1_2 on RF_STATRA (
   RF_NTTR_COD ASC
);

/*==============================================================*/
/* Index : RF_STATRA_FK1_1                                      */
/*==============================================================*/
create index RF_STATRA_FK1_1 on RF_STATRA (
   RF_CDSTAT_COD ASC
);

grant SELECT on RF_STATRA to PUBLIC;

grant REFERENCES on RF_STATRA to PUBLIC;

grant REFERENCES on RF_STATRA to PUBLIC;

grant SELECT on RF_STATRA to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_STATUA                                            */
/*==============================================================*/
create table RF_STATUA  (
   RF_STATUA_ID         INTEGER                         not null,
   RF_STATUA_COD        VARCHAR2(2)                     not null,
   RF_STATUA_DEN        VARCHAR2(100)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_STATUA_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_STATUA is
'Statut UA';

comment on column RF_STATUA.RF_STATUA_ID is
'Identifiant du code statut UA';

comment on column RF_STATUA.RF_STATUA_COD is
'Code statut UA';

comment on column RF_STATUA.RF_STATUA_DEN is
'Denomination statut UA';

comment on column RF_STATUA.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_STATUA.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_STATUA
   add constraint RF_STATUA_PK1_1 primary key (RF_STATUA_ID);

/*==============================================================*/
/* Index : RF_STATUA_UN1_1                                      */
/*==============================================================*/
create unique index RF_STATUA_UN1_1 on RF_STATUA (
   RF_STATUA_COD ASC
);

grant SELECT on RF_STATUA to PUBLIC;

grant REFERENCES on RF_STATUA to PUBLIC;

grant REFERENCES on RF_STATUA to PUBLIC;

grant SELECT on RF_STATUA to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_STATUT                                            */
/*==============================================================*/
create table RF_STATUT  (
   RF_STATUT_ID         INTEGER                         not null,
   RF_STATUT_COD        VARCHAR2(1)                     not null,
   RF_TPERS_ID          INTEGER                         not null,
   RF_STATUT_LIB        VARCHAR2(20),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_STATUT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_STATUT is
'Table des statuts';

comment on column RF_STATUT.RF_STATUT_ID is
'Identifiant du statut';

comment on column RF_STATUT.RF_STATUT_COD is
'Abreviation identifiant le statut';

comment on column RF_STATUT.RF_TPERS_ID is
'Identifiant du type personnel';

comment on column RF_STATUT.RF_STATUT_LIB is
'Libelle du statut ';

comment on column RF_STATUT.RF_XDMAJ is
'Date de mise a jour de l''enregsitrement';

comment on column RF_STATUT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_STATUT
   add constraint RF_STATUT_PK1_1 primary key (RF_STATUT_ID);

/*==============================================================*/
/* Index : RF_STATUT_FK1_1                                      */
/*==============================================================*/
create index RF_STATUT_FK1_1 on RF_STATUT (
   RF_TPERS_ID ASC
);

/*==============================================================*/
/* Index : RF_STATUT_UN1_1                                      */
/*==============================================================*/
create unique index RF_STATUT_UN1_1 on RF_STATUT (
   RF_STATUT_COD ASC
);

grant SELECT on RF_STATUT to PUBLIC;

grant REFERENCES on RF_STATUT to PUBLIC;

grant REFERENCES on RF_STATUT to PUBLIC;

grant SELECT on RF_STATUT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_STE_CHORUS                                        */
/*==============================================================*/
create table RF_STE_CHORUS  (
   RF_STE_CHORUS_ID     INTEGER                         not null,
   RF_STE_CHORUS_COD    VARCHAR2(4),
   RF_STE_CHORUS_LIB    VARCHAR2(80),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_STE_CHORUS is
'societe chorus';

alter table RF_STE_CHORUS
   add constraint RF_STE_CHORUS_PK1_1 primary key (RF_STE_CHORUS_ID);

grant SELECT on RF_STE_CHORUS to PUBLIC;

grant REFERENCES on RF_STE_CHORUS to PUBLIC;

grant REFERENCES on RF_STE_CHORUS to PUBLIC;

grant SELECT on RF_STE_CHORUS to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_STRC                                              */
/*==============================================================*/
create table RF_STRC  (
   RF_STRC_CODETN       VARCHAR2(9)                     not null,
   RF_TORG_COD          VARCHAR2(1)                     not null,
   RF_CODNIV_COD        VARCHAR2(1)                     not null,
   RF_STRC_CODSOU       VARCHAR2(2),
   RF_STRC_CODBUR       VARCHAR2(1),
   RF_STRC_CODSEC       VARCHAR2(2),
   RF_STRC_CODCEL       VARCHAR2(2),
   RF_STRC_CODPOS       VARCHAR2(2),
   RF_STRC_LIB          VARCHAR2(100),
   RF_STRC_COM1         VARCHAR2(40),
   RF_STRC_COM2         VARCHAR2(40),
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_STRC_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_TINDIC_ID         INTEGER                         not null,
   RF_STRC_LIBA         VARCHAR2(4),
   RF_STRC_MOA          VARCHAR2(3)
);

comment on table RF_STRC is
'Structure des organismes';

comment on column RF_STRC.RF_STRC_CODETN is
'Identifiant concatene structure';

comment on column RF_STRC.RF_TORG_COD is
'Identifiant Type Organisme';

comment on column RF_STRC.RF_CODNIV_COD is
'Code niveau structure';

comment on column RF_STRC.RF_STRC_CODSOU is
'Identification des sous structures d''organismes';

comment on column RF_STRC.RF_STRC_CODBUR is
'Identification des bureaux de chacune des sous-structures';

comment on column RF_STRC.RF_STRC_CODSEC is
'Identification des sections de bureau';

comment on column RF_STRC.RF_STRC_CODCEL is
'Identifcation des cellules de section';

comment on column RF_STRC.RF_STRC_CODPOS is
'Identification des fonctions elementaires des structures';

comment on column RF_STRC.RF_STRC_LIB is
'Libelle de la structure';

comment on column RF_STRC.RF_STRC_COM1 is
'Commentaire';

comment on column RF_STRC.RF_STRC_COM2 is
'Commentaire';

comment on column RF_STRC.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_STRC.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_STRC.RF_TINDIC_ID is
'Identifiant de l''indicateur';

comment on column RF_STRC.RF_STRC_LIBA is
'Libelle abrege de la structure';

comment on column RF_STRC.RF_STRC_MOA is
'Maitrise Ouvrage';

alter table RF_STRC
   add constraint RF_STRC_PK1_1 primary key (RF_STRC_CODETN);

/*==============================================================*/
/* Index : RF_STRC_FK1_1                                        */
/*==============================================================*/
create index RF_STRC_FK1_1 on RF_STRC (
   RF_TORG_COD ASC
);

/*==============================================================*/
/* Index : RF_STRC_FK1_2                                        */
/*==============================================================*/
create index RF_STRC_FK1_2 on RF_STRC (
   RF_CODNIV_COD ASC
);

/*==============================================================*/
/* Index : RF_STRC_FK1_3                                        */
/*==============================================================*/
create index RF_STRC_FK1_3 on RF_STRC (
   RF_TINDIC_ID ASC
);

grant SELECT on RF_STRC to PUBLIC;

grant REFERENCES on RF_STRC to PUBLIC;

grant REFERENCES on RF_STRC to PUBLIC;

grant SELECT on RF_STRC to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TACCES                                            */
/*==============================================================*/
create table RF_TACCES  (
   RF_TACCES_ID         INTEGER                         not null,
   RF_TACCES_COD        VARCHAR2(2)                     not null,
   RF_TACCES_LIB        VARCHAR2(20)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TACCES_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TACCES is
'Permet d''identifier s''il s''agit d''un acces au grade ou un acces au corps.';

comment on column RF_TACCES.RF_TACCES_ID is
'Identifiant du type d''acces';

comment on column RF_TACCES.RF_TACCES_COD is
'Code type d''acces';

comment on column RF_TACCES.RF_TACCES_LIB is
'Identifie un mode d''acces (corps ou  grade)';

comment on column RF_TACCES.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TACCES.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TACCES
   add constraint RF_TACCES_PK1_1 primary key (RF_TACCES_ID);

/*==============================================================*/
/* Index : RF_TACCES_UN1_1                                      */
/*==============================================================*/
create unique index RF_TACCES_UN1_1 on RF_TACCES (
   RF_TACCES_COD ASC
);

grant SELECT on RF_TACCES to PUBLIC;

grant REFERENCES on RF_TACCES to PUBLIC;

grant REFERENCES on RF_TACCES to PUBLIC;

grant SELECT on RF_TACCES to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TACHAT                                            */
/*==============================================================*/
create table RF_TACHAT  (
   RF_TACHAT_COD        VARCHAR2(2)                     not null,
   RF_TACHAT_LIB        VARCHAR2(80)                    not null,
   RF_CTACHAT_COD       VARCHAR2(1)                     not null,
   RF_TACHAT_NOMENC     VARCHAR2(1)                     not null,
   RF_TACHAT_NUM        VARCHAR2(1)                     not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TACHAT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TACHAT is
'Table des types d''achat';

comment on column RF_TACHAT.RF_TACHAT_COD is
'Code du type d''achat';

comment on column RF_TACHAT.RF_TACHAT_LIB is
'Libelle du type d''achat';

comment on column RF_TACHAT.RF_CTACHAT_COD is
'Categorie d''achat';

comment on column RF_TACHAT.RF_TACHAT_NOMENC is
'Nomenclature de l''achat';

comment on column RF_TACHAT.RF_TACHAT_NUM is
'Numero de l''achat';

comment on column RF_TACHAT.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TACHAT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TACHAT
   add constraint RF_TACHAT_PK1_1 primary key (RF_TACHAT_COD);

/*==============================================================*/
/* Index : RF_TACHAT_FK1_1                                      */
/*==============================================================*/
create index RF_TACHAT_FK1_1 on RF_TACHAT (
   RF_CTACHAT_COD ASC
);

grant SELECT on RF_TACHAT to PUBLIC;

grant REFERENCES on RF_TACHAT to PUBLIC;

grant REFERENCES on RF_TACHAT to PUBLIC;

grant SELECT on RF_TACHAT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TACHEFCT                                          */
/*==============================================================*/
create table RF_TACHEFCT  (
   RF_TACHEFCT_ID       INTEGER                         not null,
   RF_TACHEFCT_COD      VARCHAR2(5)                     not null,
   RF_TACHEFCT_LIB      VARCHAR2(80)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TACHEFCT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TACHEFCT is
'Table des fonctions de tache';

comment on column RF_TACHEFCT.RF_TACHEFCT_ID is
'Identifiant de la fonction de la tache';

comment on column RF_TACHEFCT.RF_TACHEFCT_COD is
'Code de la fonction de la tache';

comment on column RF_TACHEFCT.RF_TACHEFCT_LIB is
'Libelle de la fonction de la tache';

comment on column RF_TACHEFCT.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TACHEFCT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TACHEFCT
   add constraint RF_TACHEFCT_PK1_1 primary key (RF_TACHEFCT_ID);

/*==============================================================*/
/* Index : RF_TACHEFCT_UN1_1                                    */
/*==============================================================*/
create unique index RF_TACHEFCT_UN1_1 on RF_TACHEFCT (
   RF_TACHEFCT_COD ASC
);

grant SELECT on RF_TACHEFCT to PUBLIC;

grant REFERENCES on RF_TACHEFCT to PUBLIC;

grant REFERENCES on RF_TACHEFCT to PUBLIC;

grant SELECT on RF_TACHEFCT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TACHENAT                                          */
/*==============================================================*/
create table RF_TACHENAT  (
   RF_TACHENAT_ID       INTEGER                         not null,
   RF_TACHENAT_COD      VARCHAR2(5)                     not null,
   RF_TACHENAT_LIB      VARCHAR2(80)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TACHEFCT_CK1_2 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TACHENAT is
'Table des natures de tache';

comment on column RF_TACHENAT.RF_TACHENAT_ID is
'Identifiant de la nature de la tache';

comment on column RF_TACHENAT.RF_TACHENAT_COD is
'Code de la nature de la tache';

comment on column RF_TACHENAT.RF_TACHENAT_LIB is
'Libelle de la nature de la tache';

comment on column RF_TACHENAT.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TACHENAT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TACHENAT
   add constraint RF_TACHENAT_PK1_1 primary key (RF_TACHENAT_ID);

/*==============================================================*/
/* Index : RF_TACHENAT_UN1_1                                    */
/*==============================================================*/
create unique index RF_TACHENAT_UN1_1 on RF_TACHENAT (
   RF_TACHENAT_COD ASC
);

grant SELECT on RF_TACHENAT to PUBLIC;

grant REFERENCES on RF_TACHENAT to PUBLIC;

grant REFERENCES on RF_TACHENAT to PUBLIC;

grant SELECT on RF_TACHENAT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TAFF                                              */
/*==============================================================*/
create table RF_TAFF  (
   RF_TAFF_ID           INTEGER                         not null,
   RF_TAFF_COD          VARCHAR2(1)                     not null,
   RF_TAFF_LIB          VARCHAR2(45)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TAFF_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TAFF is
'Type de changement d''affectation';

comment on column RF_TAFF.RF_TAFF_ID is
'Identifiant du type de changement d''affectation';

comment on column RF_TAFF.RF_TAFF_COD is
'Code du type de changement d''affectation';

comment on column RF_TAFF.RF_TAFF_LIB is
'Libelle du type de changement d''affectation';

comment on column RF_TAFF.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TAFF.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TAFF
   add constraint RF_TAFF_PK1_1 primary key (RF_TAFF_ID);

/*==============================================================*/
/* Index : RF_TAFF_UN1_1                                        */
/*==============================================================*/
create unique index RF_TAFF_UN1_1 on RF_TAFF (
   RF_TAFF_COD ASC
);

grant SELECT on RF_TAFF to PUBLIC;

grant REFERENCES on RF_TAFF to PUBLIC;

grant REFERENCES on RF_TAFF to PUBLIC;

grant SELECT on RF_TAFF to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TAMO                                              */
/*==============================================================*/
create table RF_TAMO  (
   RF_TAMO_ID           INTEGER                         not null,
   RF_TAMO_COD          VARCHAR2(2)                     not null,
   RF_TAMO_LIB          VARCHAR2(25)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TAMO_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TAMO is
'Type d''amodiation';

comment on column RF_TAMO.RF_TAMO_ID is
'Identifiant du type d''amodiation';

comment on column RF_TAMO.RF_TAMO_COD is
'Code du type d''amodiation';

comment on column RF_TAMO.RF_TAMO_LIB is
'Libelle du type d''amodiation';

comment on column RF_TAMO.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TAMO.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TAMO
   add constraint RF_TAMO_PK1_1 primary key (RF_TAMO_ID);

/*==============================================================*/
/* Index : RF_TAMO_UN1_1                                        */
/*==============================================================*/
create unique index RF_TAMO_UN1_1 on RF_TAMO (
   RF_TAMO_COD ASC
);

grant SELECT on RF_TAMO to PUBLIC;

grant REFERENCES on RF_TAMO to PUBLIC;

grant REFERENCES on RF_TAMO to PUBLIC;

grant SELECT on RF_TAMO to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TBENECH                                           */
/*==============================================================*/
create table RF_TBENECH  (
   RF_TBENECH_ID        INTEGER                         not null,
   RF_TBENECH_COD       VARCHAR2(2)                     not null,
   RF_TBENECH_LIB       VARCHAR2(30)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TBENECH_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TBENECH is
'Type de beneficiaire d''un echange compense';

comment on column RF_TBENECH.RF_TBENECH_ID is
'Identifiant du type de beneficiaire';

comment on column RF_TBENECH.RF_TBENECH_COD is
'Code du type de beneficiaire';

comment on column RF_TBENECH.RF_TBENECH_LIB is
'Libelle du type de beneficiaire';

comment on column RF_TBENECH.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TBENECH.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TBENECH
   add constraint RF_TBENECH_PK1_1 primary key (RF_TBENECH_ID);

/*==============================================================*/
/* Index : RF_TBENECH_UN1_1                                     */
/*==============================================================*/
create unique index RF_TBENECH_UN1_1 on RF_TBENECH (
   RF_TBENECH_COD ASC
);

grant SELECT on RF_TBENECH to PUBLIC;

grant REFERENCES on RF_TBENECH to PUBLIC;

grant REFERENCES on RF_TBENECH to PUBLIC;

grant SELECT on RF_TBENECH to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TCOMPO                                            */
/*==============================================================*/
create table RF_TCOMPO  (
   RF_TCOMPO_ID         INTEGER                         not null,
   RF_TCOMPO_COD        VARCHAR2(3)                     not null,
   RF_TCOMPO_LIB        VARCHAR2(40)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TCOMPO_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TCOMPO is
'Type de composant';

comment on column RF_TCOMPO.RF_TCOMPO_ID is
'Identifiant du type de composant';

comment on column RF_TCOMPO.RF_TCOMPO_COD is
'Code du type de composant';

comment on column RF_TCOMPO.RF_TCOMPO_LIB is
'Libelle du type de composant';

comment on column RF_TCOMPO.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TCOMPO.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TCOMPO
   add constraint RF_TCOMPO_PK1_1 primary key (RF_TCOMPO_ID);

/*==============================================================*/
/* Index : RF_TCOMPO_UN1_1                                      */
/*==============================================================*/
create unique index RF_TCOMPO_UN1_1 on RF_TCOMPO (
   RF_TCOMPO_COD ASC
);

grant SELECT on RF_TCOMPO to PUBLIC;

grant REFERENCES on RF_TCOMPO to PUBLIC;

grant REFERENCES on RF_TCOMPO to PUBLIC;

grant SELECT on RF_TCOMPO to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TCONS                                             */
/*==============================================================*/
create table RF_TCONS  (
   RF_TCONS_ID          INTEGER                         not null,
   RF_TCONS_COD         VARCHAR2(2)                     not null,
   RF_TCONS_LIB         VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TCONS_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TCONS is
'Type de construction';

comment on column RF_TCONS.RF_TCONS_ID is
'Identifiant du type de construction';

comment on column RF_TCONS.RF_TCONS_COD is
'Code du type de construction';

comment on column RF_TCONS.RF_TCONS_LIB is
'Libelle du type de construction';

comment on column RF_TCONS.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TCONS.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TCONS
   add constraint RF_TCONS_PK1_1 primary key (RF_TCONS_ID);

/*==============================================================*/
/* Index : RF_TCONS_UN1_1                                       */
/*==============================================================*/
create unique index RF_TCONS_UN1_1 on RF_TCONS (
   RF_TCONS_COD ASC
);

grant SELECT on RF_TCONS to PUBLIC;

grant REFERENCES on RF_TCONS to PUBLIC;

grant REFERENCES on RF_TCONS to PUBLIC;

grant SELECT on RF_TCONS to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TCPT                                              */
/*==============================================================*/
create table RF_TCPT  (
   RF_TCPT_ID           INTEGER                         not null,
   RF_TCPT_COD          VARCHAR2(3)                     not null,
   RF_TCPT_LIB          VARCHAR2(50),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TCPT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TCPT is
'Type composant';

comment on column RF_TCPT.RF_TCPT_ID is
'RF_TCPT_ID';

comment on column RF_TCPT.RF_TCPT_COD is
'Code';

comment on column RF_TCPT.RF_TCPT_LIB is
'Libelle';

comment on column RF_TCPT.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TCPT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TCPT
   add constraint RF_TCPT_PK1_1 primary key (RF_TCPT_ID);

/*==============================================================*/
/* Index : RF_TCPT_UN1_1                                        */
/*==============================================================*/
create unique index RF_TCPT_UN1_1 on RF_TCPT (
   RF_TCPT_COD ASC
);

grant SELECT on RF_TCPT to PUBLIC;

grant REFERENCES on RF_TCPT to PUBLIC;

grant REFERENCES on RF_TCPT to PUBLIC;

grant SELECT on RF_TCPT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TDEL                                              */
/*==============================================================*/
create table RF_TDEL  (
   RF_TDEL_COD          VARCHAR2(1)                     not null,
   RF_CTOB_COD          VARCHAR2(1),
   RF_TDEL_LIB          VARCHAR2(100)                   not null,
   RF_TDEL_LIBA         VARCHAR2(10)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TDEL_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TDEL is
'Type de delegation';

comment on column RF_TDEL.RF_TDEL_COD is
'Code type de delegation';

comment on column RF_TDEL.RF_CTOB_COD is
'Code categorie OBI';

comment on column RF_TDEL.RF_TDEL_LIB is
'Clair type de delegation';

comment on column RF_TDEL.RF_TDEL_LIBA is
'Clair court type de delegation';

comment on column RF_TDEL.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TDEL.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TDEL
   add constraint RF_TDEL_PK1_1 primary key (RF_TDEL_COD);

/*==============================================================*/
/* Index : RF_TDEL_FK1_1                                        */
/*==============================================================*/
create index RF_TDEL_FK1_1 on RF_TDEL (
   RF_CTOB_COD ASC
);

grant SELECT on RF_TDEL to PUBLIC;

grant REFERENCES on RF_TDEL to PUBLIC;

grant REFERENCES on RF_TDEL to PUBLIC;

grant SELECT on RF_TDEL to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TDOC                                              */
/*==============================================================*/
create table RF_TDOC  (
   RF_TDOC_ID           INTEGER                         not null,
   RF_TDOC_LIB          VARCHAR2(50),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TDOC_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TDOC is
'Type operation domaniale                      Type document
acquisition, alienation, prise a bail           acte
rem, usufruit, transert gestion                   PV
changement affectation                           arrete prefectoral
changement affectation                           arrete interministeriel';

comment on column RF_TDOC.RF_TDOC_ID is
'identifiant ';

comment on column RF_TDOC.RF_TDOC_LIB is
'Libelle type document';

comment on column RF_TDOC.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TDOC.RF_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

alter table RF_TDOC
   add constraint RF_TDOC_PK1_1 primary key (RF_TDOC_ID);

grant SELECT on RF_TDOC to PUBLIC;

grant REFERENCES on RF_TDOC to PUBLIC;

grant REFERENCES on RF_TDOC to PUBLIC;

grant SELECT on RF_TDOC to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TDOCTOPEDOM                                       */
/*==============================================================*/
create table RF_TDOCTOPEDOM  (
   RF_TDOCTOPEDOM_ID    INTEGER                         not null,
   RF_TDOC_ID           INTEGER                         not null,
   RF_TOPEDOM_ID        INTEGER,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TDOCTOPEDOM_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TDOCTOPEDOM is
'Table de jointure entre RF_TDOC et RF_TOPEDOM';

comment on column RF_TDOCTOPEDOM.RF_TDOCTOPEDOM_ID is
'identifiant ';

comment on column RF_TDOCTOPEDOM.RF_TDOC_ID is
'identifiant AD_TDOC';

comment on column RF_TDOCTOPEDOM.RF_TOPEDOM_ID is
'Identifiant type op. dom.';

comment on column RF_TDOCTOPEDOM.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TDOCTOPEDOM.RF_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

alter table RF_TDOCTOPEDOM
   add constraint RF_TDOCTOPEDOM_PK1_1 primary key (RF_TDOCTOPEDOM_ID);

/*==============================================================*/
/* Index : RF_TDOCTOPEDOM_FK1_1                                 */
/*==============================================================*/
create index RF_TDOCTOPEDOM_FK1_1 on RF_TDOCTOPEDOM (
   RF_TOPEDOM_ID ASC
);

/*==============================================================*/
/* Index : RF_TDOCTOPEDOM_FK1_2                                 */
/*==============================================================*/
create index RF_TDOCTOPEDOM_FK1_2 on RF_TDOCTOPEDOM (
   RF_TDOC_ID ASC
);

/*==============================================================*/
/* Index : RF_TDOCTOPEDOM_UN2_1                                 */
/*==============================================================*/
create unique index RF_TDOCTOPEDOM_UN2_1 on RF_TDOCTOPEDOM (
   RF_TDOC_ID ASC,
   RF_TOPEDOM_ID ASC
);

grant SELECT on RF_TDOCTOPEDOM to PUBLIC;

grant REFERENCES on RF_TDOCTOPEDOM to PUBLIC;

grant REFERENCES on RF_TDOCTOPEDOM to PUBLIC;

grant SELECT on RF_TDOCTOPEDOM to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TDOM                                              */
/*==============================================================*/
create table RF_TDOM  (
   RF_TDOM_ID           INTEGER                         not null,
   RF_TDOM_COD          VARCHAR2(3)                     not null,
   RF_TDOM_LIB          VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TDOM_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TDOM is
'Domanialite';

comment on column RF_TDOM.RF_TDOM_ID is
'Identifiant de la domanialite';

comment on column RF_TDOM.RF_TDOM_COD is
'Code de la domanialite';

comment on column RF_TDOM.RF_TDOM_LIB is
'Libelle de la domanialite';

comment on column RF_TDOM.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TDOM.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TDOM
   add constraint RF_TDOM_PK1_1 primary key (RF_TDOM_ID);

/*==============================================================*/
/* Index : RF_TDOM_UN1_1                                        */
/*==============================================================*/
create unique index RF_TDOM_UN1_1 on RF_TDOM (
   RF_TDOM_COD ASC
);

grant SELECT on RF_TDOM to PUBLIC;

grant REFERENCES on RF_TDOM to PUBLIC;

grant REFERENCES on RF_TDOM to PUBLIC;

grant SELECT on RF_TDOM to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TDUREE                                            */
/*==============================================================*/
create table RF_TDUREE  (
   RF_TDUREE_ID         INTEGER                         not null,
   RF_TDUREE_COD        VARCHAR2(5)                     not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TDUREE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TDUREE is
'Table des types de duree';

comment on column RF_TDUREE.RF_TDUREE_ID is
'Identifiant du type de duree';

comment on column RF_TDUREE.RF_TDUREE_COD is
'Code du type de duree';

comment on column RF_TDUREE.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TDUREE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TDUREE
   add constraint RF_TDUREE_PK1_1 primary key (RF_TDUREE_ID);

/*==============================================================*/
/* Index : RF_TDUREE_UN1_1                                      */
/*==============================================================*/
create unique index RF_TDUREE_UN1_1 on RF_TDUREE (
   RF_TDUREE_COD ASC
);

grant SELECT on RF_TDUREE to PUBLIC;

grant REFERENCES on RF_TDUREE to PUBLIC;

grant REFERENCES on RF_TDUREE to PUBLIC;

grant SELECT on RF_TDUREE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TENGC                                             */
/*==============================================================*/
create table RF_TENGC  (
   RF_TENGC_COD         VARCHAR2(2)                     not null,
   RF_TENGC_LIB         VARCHAR2(90)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TENGC_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TENGC is
'Type d''engagement comptable CFD';

comment on column RF_TENGC.RF_TENGC_COD is
'Type Engagement Comptable CFD';

comment on column RF_TENGC.RF_TENGC_LIB is
'Libelle Type Engagement Comptable CFD';

comment on column RF_TENGC.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TENGC.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TENGC
   add constraint RF_TENGC_PK1_1 primary key (RF_TENGC_COD);

grant SELECT on RF_TENGC to PUBLIC;

grant REFERENCES on RF_TENGC to PUBLIC;

grant REFERENCES on RF_TENGC to PUBLIC;

grant SELECT on RF_TENGC to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TETAD                                             */
/*==============================================================*/
create table RF_TETAD  (
   RF_TETAD_COD         VARCHAR2(1)                     not null,
   RF_TETAD_LIB         VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TETAD_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TETAD is
'Type etat D';

comment on column RF_TETAD.RF_TETAD_COD is
'Code type etat D';

comment on column RF_TETAD.RF_TETAD_LIB is
'Clair type d''imputation';

comment on column RF_TETAD.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TETAD.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TETAD
   add constraint RF_TETAD_PK1_1 primary key (RF_TETAD_COD);

grant SELECT on RF_TETAD to PUBLIC;

grant REFERENCES on RF_TETAD to PUBLIC;

grant REFERENCES on RF_TETAD to PUBLIC;

grant SELECT on RF_TETAD to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TETAO                                             */
/*==============================================================*/
create table RF_TETAO  (
   RF_TETAO_COD         VARCHAR2(1)                     not null,
   RF_TETAO_LIB         VARCHAR2(50)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TETAO_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TETAO is
'Type d''etat de l''operation csi cso';

comment on column RF_TETAO.RF_TETAO_COD is
'Code type de l''etat de l''operation csi cso';

comment on column RF_TETAO.RF_TETAO_LIB is
'Clair type de l''etat de l''operation csi cso';

comment on column RF_TETAO.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TETAO.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TETAO
   add constraint RF_TETAO_PK1_1 primary key (RF_TETAO_COD);

grant SELECT on RF_TETAO to PUBLIC;

grant REFERENCES on RF_TETAO to PUBLIC;

grant REFERENCES on RF_TETAO to PUBLIC;

grant SELECT on RF_TETAO to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TF                                                */
/*==============================================================*/
create table RF_TF  (
   RF_TF_ID             INTEGER                         not null,
   RF_TF_COD            VARCHAR2(10)                    not null,
   RF_TF_LIB            VARCHAR2(300)                   not null,
   RF_TF_LIBA           VARCHAR2(100)                   not null,
   RF_TTF_ID            INTEGER                         not null,
   RF_UO_ID             INTEGER                         not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TF_CK1_2 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TF is
'Table contenant les tranches fonctionnelles issues du referentiel CHORUS.';

comment on column RF_TF.RF_TF_ID is
'Identifiant de la tranche fonctionnelle';

comment on column RF_TF.RF_TF_COD is
'Code de la tranche fonctionnelle';

comment on column RF_TF.RF_TF_LIB is
'Libelle de la tranche fonctionnelle';

comment on column RF_TF.RF_TF_LIBA is
'Libelle abrege de la tranche fonctionnelle';

comment on column RF_TF.RF_TTF_ID is
'Type de la tranche fonctionnelle';

comment on column RF_TF.RF_UO_ID is
'Identifiant de l''UO';

comment on column RF_TF.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TF.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TF
   add constraint RF_TF_PK1_1 primary key (RF_TF_ID);

/*==============================================================*/
/* Index : RF_TF_FK1_1                                          */
/*==============================================================*/
create index RF_TF_FK1_1 on RF_TF (
   RF_TTF_ID ASC
);

/*==============================================================*/
/* Index : RF_TF_FK1_2                                          */
/*==============================================================*/
create index RF_TF_FK1_2 on RF_TF (
   RF_UO_ID ASC
);

grant SELECT on RF_TF to PUBLIC;

grant REFERENCES on RF_TF to PUBLIC;

grant REFERENCES on RF_TF to PUBLIC;

grant SELECT on RF_TF to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TFICHIER                                          */
/*==============================================================*/
create table RF_TFICHIER  (
   RF_TFICHIER_ID       INTEGER                         not null,
   RF_TFICHIER_LIB      VARCHAR2(100)                   not null,
   RF_TFICHIER_TMIME    VARCHAR2(50)                    not null,
   RF_TFICHIER_IMAGE    VARCHAR2(50)                    not null,
   RF_TFICHIER_EXTENSION VARCHAR2(20),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TFICHIER_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TFICHIER is
'Type de Fichier';

comment on column RF_TFICHIER.RF_TFICHIER_ID is
'Identifiant du type de fichier';

comment on column RF_TFICHIER.RF_TFICHIER_LIB is
'Libelle du type de fichier';

comment on column RF_TFICHIER.RF_TFICHIER_TMIME is
'Type MIME';

comment on column RF_TFICHIER.RF_TFICHIER_IMAGE is
'Nom de l''image associe au type de fichier';

comment on column RF_TFICHIER.RF_TFICHIER_EXTENSION is
'Extension du fichier';

comment on column RF_TFICHIER.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TFICHIER.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TFICHIER
   add constraint RF_TFICHIER_PK1_1 primary key (RF_TFICHIER_ID);

grant SELECT on RF_TFICHIER to PUBLIC;

grant REFERENCES on RF_TFICHIER to PUBLIC;

grant REFERENCES on RF_TFICHIER to PUBLIC;

grant SELECT on RF_TFICHIER to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TFON                                              */
/*==============================================================*/
create table RF_TFON  (
   RF_TFON_ID           INTEGER                         not null,
   RF_CFIN_ID           INTEGER,
   RF_TFON_AREA         VARCHAR2(4)                     not null,
   RF_TFON_TRFONC       VARCHAR2(24)                    not null,
   RF_TFON_DATEFROM     VARCHAR2(15),
   RF_TFON_DATETO       VARCHAR2(15),
   RF_TFON_DATEX        VARCHAR2(15),
   RF_TFON_ETXTSH       VARCHAR2(20),
   RF_TFON_ETXTLG       VARCHAR2(60),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_TFON is
'Table des tranches fonctionnelles de CHORUS.';

comment on column RF_TFON.RF_TFON_ID is
'Table des tranches fonctionnelles de CHORUS.';

comment on column RF_TFON.RF_TFON_AREA is
'Perimetre financier de la tranche fonctionnelle de CHORUS.';

comment on column RF_TFON.RF_TFON_TRFONC is
'Code de la tranche fonctionnelle de CHORUS.';

comment on column RF_TFON.RF_TFON_DATEFROM is
'Debut de validite de la tranche fonctionnelle de CHORUS.';

comment on column RF_TFON.RF_TFON_DATETO is
'Fin de validite de la tranche fonctionnelle de CHORUS.';

comment on column RF_TFON.RF_TFON_DATEX is
'Date d''expiration de la tranche fonctionnelle de CHORUS.';

comment on column RF_TFON.RF_TFON_ETXTSH is
'Description courte de la tranche fonctionnelle de CHORUS.';

comment on column RF_TFON.RF_TFON_ETXTLG is
'Description longue de la tranche fonctionnelle de CHORUS.';

comment on column RF_TFON.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_TFON.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_TFON
   add constraint RF_TFON_PK1_1 primary key (RF_TFON_ID);

alter table RF_TFON
   add constraint RF_TFON_UN3_1 unique (RF_TFON_AREA, RF_TFON_TRFONC, RF_TFON_DATETO);

/*==============================================================*/
/* Index : RF_TFON_FK1_1                                        */
/*==============================================================*/
create index RF_TFON_FK1_1 on RF_TFON (
   RF_CFIN_ID ASC
);

grant SELECT on RF_TFON to PUBLIC;

grant REFERENCES on RF_TFON to PUBLIC;

grant REFERENCES on RF_TFON to PUBLIC;

grant SELECT on RF_TFON to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TIMP                                              */
/*==============================================================*/
create table RF_TIMP  (
   RF_TIMP_ID           INTEGER                         not null,
   RF_TIMP_TIMP         VARCHAR2(1)                     not null,
   RF_TIMP_TXTMD        VARCHAR2(40),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_TIMP is
'Table des types d''imputation de CHORUS.';

comment on column RF_TIMP.RF_TIMP_ID is
'ID du type d''imputation de CHORUS.';

comment on column RF_TIMP.RF_TIMP_TIMP is
'Code du type d''imputation de CHORUS.';

comment on column RF_TIMP.RF_TIMP_TXTMD is
'Description moyenne du type d''imputation de CHORUS.';

comment on column RF_TIMP.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_TIMP.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_TIMP
   add constraint RF_TIMP_PK1_1 primary key (RF_TIMP_ID);

alter table RF_TIMP
   add constraint RF_TIMP_UN1_1 unique (RF_TIMP_TIMP);

grant SELECT on RF_TIMP to PUBLIC;

grant REFERENCES on RF_TIMP to PUBLIC;

grant REFERENCES on RF_TIMP to PUBLIC;

grant SELECT on RF_TIMP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TIMPN                                             */
/*==============================================================*/
create table RF_TIMPN  (
   RF_TIMPN_COD         VARCHAR2(1)                     not null,
   RF_TIMPN_LIB         VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TIMPN_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TIMPN is
'Type d''imputation budgetaire';

comment on column RF_TIMPN.RF_TIMPN_COD is
'Code type d''imputation budgetaire';

comment on column RF_TIMPN.RF_TIMPN_LIB is
'Clair type d''imputation budgetaire';

comment on column RF_TIMPN.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TIMPN.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TIMPN
   add constraint RF_TIMPN_PK1_1 primary key (RF_TIMPN_COD);

grant SELECT on RF_TIMPN to PUBLIC;

grant REFERENCES on RF_TIMPN to PUBLIC;

grant REFERENCES on RF_TIMPN to PUBLIC;

grant SELECT on RF_TIMPN to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TINDIC                                            */
/*==============================================================*/
create table RF_TINDIC  (
   RF_TINDIC_ID         INTEGER                         not null,
   RF_TINDIC_LIBA       VARCHAR2(10)                    not null,
   RF_TINDIC_LIB        VARCHAR2(50)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TINDIC_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TINDIC is
'Table contenant les types d''indicateurs.';

comment on column RF_TINDIC.RF_TINDIC_ID is
'Identifiant de l''indicateur';

comment on column RF_TINDIC.RF_TINDIC_LIBA is
'Libelle abrege de l''indicateur';

comment on column RF_TINDIC.RF_TINDIC_LIB is
'Libelle long de l''indicateur';

comment on column RF_TINDIC.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TINDIC.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TINDIC
   add constraint RF_TINDIC_PK1_1 primary key (RF_TINDIC_ID);

grant SELECT on RF_TINDIC to PUBLIC;

grant REFERENCES on RF_TINDIC to PUBLIC;

grant REFERENCES on RF_TINDIC to PUBLIC;

grant SELECT on RF_TINDIC to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TINDMAJ                                           */
/*==============================================================*/
create table RF_TINDMAJ  (
   RF_TINDMAJ_COD       VARCHAR2(1)                     not null,
   RF_TINDMAJ_LIB       VARCHAR2(15)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TINDMAJ_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TINDMAJ is
'Indicateur de mise a jour pour NDL';

comment on column RF_TINDMAJ.RF_TINDMAJ_COD is
'Code de l''indicateur mise a jour pour NDL';

comment on column RF_TINDMAJ.RF_TINDMAJ_LIB is
'Code de l''indicateur mise a jour pour NDL';

comment on column RF_TINDMAJ.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TINDMAJ.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TINDMAJ
   add constraint RF_TINDMAJ_PK1_1 primary key (RF_TINDMAJ_COD);

grant SELECT on RF_TINDMAJ to PUBLIC;

grant REFERENCES on RF_TINDMAJ to PUBLIC;

grant REFERENCES on RF_TINDMAJ to PUBLIC;

grant SELECT on RF_TINDMAJ to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TINTF                                             */
/*==============================================================*/
create table RF_TINTF  (
   RF_TINTF_COD         VARCHAR2(3)                     not null,
   RF_TINTF_LIB         VARCHAR2(70)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TINTF_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TINTF is
'Type d''interface';

comment on column RF_TINTF.RF_TINTF_COD is
'Code type interface';

comment on column RF_TINTF.RF_TINTF_LIB is
'Clair type interface';

comment on column RF_TINTF.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TINTF.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TINTF
   add constraint RF_TINTF_PK1_1 primary key (RF_TINTF_COD);

grant SELECT on RF_TINTF to PUBLIC;

grant REFERENCES on RF_TINTF to PUBLIC;

grant REFERENCES on RF_TINTF to PUBLIC;

grant SELECT on RF_TINTF to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TINTV                                             */
/*==============================================================*/
create table RF_TINTV  (
   RF_TINTV_COD         VARCHAR2(1)                     not null,
   RF_TINTV_LIB         VARCHAR2(40)                    not null,
   RF_TINTV_CODNDL      VARCHAR2(2)                     not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TINTV_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TINTV is
'Type d''intervenant';

comment on column RF_TINTV.RF_TINTV_COD is
'Code du type d''intervenant';

comment on column RF_TINTV.RF_TINTV_LIB is
'Clair du type d''intervenant';

comment on column RF_TINTV.RF_TINTV_CODNDL is
'Code type intervenant NDL';

comment on column RF_TINTV.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TINTV.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TINTV
   add constraint RF_TINTV_PK1_1 primary key (RF_TINTV_COD);

grant SELECT on RF_TINTV to PUBLIC;

grant REFERENCES on RF_TINTV to PUBLIC;

grant REFERENCES on RF_TINTV to PUBLIC;

grant SELECT on RF_TINTV to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TITR                                              */
/*==============================================================*/
create table RF_TITR  (
   RF_TITR_COD          VARCHAR2(1)                     not null,
   RF_TITR_LIB          VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TITR_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TITR is
'Titre';

comment on column RF_TITR.RF_TITR_COD is
'Code titre';

comment on column RF_TITR.RF_TITR_LIB is
'Clair titre';

comment on column RF_TITR.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TITR.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TITR
   add constraint RF_TITR_PK1_1 primary key (RF_TITR_COD);

grant SELECT on RF_TITR to PUBLIC;

grant REFERENCES on RF_TITR to PUBLIC;

grant REFERENCES on RF_TITR to PUBLIC;

grant SELECT on RF_TITR to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TLIG                                              */
/*==============================================================*/
create table RF_TLIG  (
   RF_TLIG_COD          VARCHAR2(1)                     not null,
   RF_TLIG_LIB          VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TLIG_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TLIG is
'Type de ligne';

comment on column RF_TLIG.RF_TLIG_COD is
'Code Type Ligne Mercure';

comment on column RF_TLIG.RF_TLIG_LIB is
'Libelle Type Ligne Mercure';

comment on column RF_TLIG.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TLIG.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TLIG
   add constraint RF_TLIG_PK1_1 primary key (RF_TLIG_COD);

grant SELECT on RF_TLIG to PUBLIC;

grant REFERENCES on RF_TLIG to PUBLIC;

grant REFERENCES on RF_TLIG to PUBLIC;

grant SELECT on RF_TLIG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TLOC                                              */
/*==============================================================*/
create table RF_TLOC  (
   RF_TLOC_ID           INTEGER                         not null,
   RF_TLOC_COD          VARCHAR2(2)                     not null,
   RF_TLOC_LIB          VARCHAR2(22)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TLOC_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TLOC is
'Type de location (etat preneur)';

comment on column RF_TLOC.RF_TLOC_ID is
'Identifiant du type de location';

comment on column RF_TLOC.RF_TLOC_COD is
'Code du type de location';

comment on column RF_TLOC.RF_TLOC_LIB is
'Libelle du type de location';

comment on column RF_TLOC.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TLOC.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TLOC
   add constraint RF_TLOC_PK1_1 primary key (RF_TLOC_ID);

/*==============================================================*/
/* Index : RF_TLOC_UN1_1                                        */
/*==============================================================*/
create unique index RF_TLOC_UN1_1 on RF_TLOC (
   RF_TLOC_COD ASC
);

grant SELECT on RF_TLOC to PUBLIC;

grant REFERENCES on RF_TLOC to PUBLIC;

grant REFERENCES on RF_TLOC to PUBLIC;

grant SELECT on RF_TLOC to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TMAJOPE                                           */
/*==============================================================*/
create table RF_TMAJOPE  (
   RF_TMAJOPE_COD       VARCHAR2(2)                     not null,
   RF_TMAJOPE_LIB       VARCHAR2(30)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TMAJOPE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TMAJOPE is
'Type de mise a jour de l''operation CSI, structure';

comment on column RF_TMAJOPE.RF_TMAJOPE_COD is
'Code type de mise a jour de l''operation';

comment on column RF_TMAJOPE.RF_TMAJOPE_LIB is
'Clair type de mise a jour de l''operation';

comment on column RF_TMAJOPE.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TMAJOPE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TMAJOPE
   add constraint RF_TMAJOPE_PK1_1 primary key (RF_TMAJOPE_COD);

grant SELECT on RF_TMAJOPE to PUBLIC;

grant REFERENCES on RF_TMAJOPE to PUBLIC;

grant REFERENCES on RF_TMAJOPE to PUBLIC;

grant SELECT on RF_TMAJOPE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TMAN                                              */
/*==============================================================*/
create table RF_TMAN  (
   RF_TMAN_COD          VARCHAR2(2)                     not null,
   RF_INDM_COD          VARCHAR2(1)                     not null,
   RF_TMAN_LIB          VARCHAR2(100)                   not null,
   RF_TMAN_LIBA         VARCHAR2(5)                     not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TMAN_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TMAN is
'Type de mandat';

comment on column RF_TMAN.RF_TMAN_COD is
'Code Type Mandat';

comment on column RF_TMAN.RF_INDM_COD is
'Code indicateur marche';

comment on column RF_TMAN.RF_TMAN_LIB is
'Libelle Type Mandat';

comment on column RF_TMAN.RF_TMAN_LIBA is
'Abreviation Type Mandat';

comment on column RF_TMAN.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TMAN.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TMAN
   add constraint RF_TMAN_PK1_1 primary key (RF_TMAN_COD);

/*==============================================================*/
/* Index : RF_TMAN_FK1_1                                        */
/*==============================================================*/
create index RF_TMAN_FK1_1 on RF_TMAN (
   RF_INDM_COD ASC
);

grant SELECT on RF_TMAN to PUBLIC;

grant REFERENCES on RF_TMAN to PUBLIC;

grant REFERENCES on RF_TMAN to PUBLIC;

grant SELECT on RF_TMAN to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TMAR                                              */
/*==============================================================*/
create table RF_TMAR  (
   RF_TMAR_COD          VARCHAR2(2)                     not null,
   RF_TMAR_LIB          VARCHAR2(50)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TMAR_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TMAR is
'Type de marche';

comment on column RF_TMAR.RF_TMAR_COD is
'Code type de marche';

comment on column RF_TMAR.RF_TMAR_LIB is
'Libelle du type de Marche';

comment on column RF_TMAR.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TMAR.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TMAR
   add constraint RF_TMAR_PK1_1 primary key (RF_TMAR_COD);

grant SELECT on RF_TMAR to PUBLIC;

grant REFERENCES on RF_TMAR to PUBLIC;

grant REFERENCES on RF_TMAR to PUBLIC;

grant SELECT on RF_TMAR to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TMEMO                                             */
/*==============================================================*/
create table RF_TMEMO  (
   RF_TMEMO_ID          INTEGER                         not null,
   RF_TMEMO_LIBA        VARCHAR2(40),
   RF_TMEMO_OPE_TOP     INTEGER,
   RF_TMEMO_AFF_TOP     INTEGER,
   RF_TMEMO_SITE_TOP    INTEGER,
   RF_TMEMO_EXPORT_TOP  INTEGER,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TMEMO_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TMEMO is
'Type de Memos';

comment on column RF_TMEMO.RF_TMEMO_ID is
'Identifiant du type de Memos';

comment on column RF_TMEMO.RF_TMEMO_LIBA is
'Libelle abrege du type de Memos';

comment on column RF_TMEMO.RF_TMEMO_OPE_TOP is
'Top operation';

comment on column RF_TMEMO.RF_TMEMO_AFF_TOP is
'Top affaire';

comment on column RF_TMEMO.RF_TMEMO_SITE_TOP is
'Top site';

comment on column RF_TMEMO.RF_TMEMO_EXPORT_TOP is
'Top export';

comment on column RF_TMEMO.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TMEMO.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TMEMO
   add constraint RF_TMEMO_PK1_1 primary key (RF_TMEMO_ID);

grant SELECT on RF_TMEMO to PUBLIC;

grant REFERENCES on RF_TMEMO to PUBLIC;

grant REFERENCES on RF_TMEMO to PUBLIC;

grant SELECT on RF_TMEMO to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TMNT                                              */
/*==============================================================*/
create table RF_TMNT  (
   RF_TMNT_ID           INTEGER                         not null,
   RF_TMNT_COD          VARCHAR2(10)                    not null,
   RF_TMNT_LIB          VARCHAR2(80)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TACHEFCT_CK1_3 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TMNT is
'Table des Types de montants';

comment on column RF_TMNT.RF_TMNT_ID is
'Identifiant du type de montant';

comment on column RF_TMNT.RF_TMNT_COD is
'Code du type de montant';

comment on column RF_TMNT.RF_TMNT_LIB is
'Libelle du type de montant';

comment on column RF_TMNT.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TMNT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TMNT
   add constraint RF_TMNT_PK1_1 primary key (RF_TMNT_ID);

/*==============================================================*/
/* Index : RF_TMNT_UN1_1                                        */
/*==============================================================*/
create unique index RF_TMNT_UN1_1 on RF_TMNT (
   RF_TMNT_COD ASC
);

grant SELECT on RF_TMNT to PUBLIC;

grant REFERENCES on RF_TMNT to PUBLIC;

grant REFERENCES on RF_TMNT to PUBLIC;

grant SELECT on RF_TMNT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TMVT                                              */
/*==============================================================*/
create table RF_TMVT  (
   RF_TMVT_COD          VARCHAR2(2)                     not null,
   RF_INDM_COD          VARCHAR2(1),
   RF_TMVT_COD_REF1     VARCHAR2(2),
   RF_TMVT_COD_REF2     VARCHAR2(2),
   RF_TMVT_LIB          VARCHAR2(50)                    not null,
   RF_TMVT_LIBNAT       VARCHAR2(5),
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TMVT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TMVT is
'Type de mouvement';

comment on column RF_TMVT.RF_TMVT_COD is
'Code Type mouvement';

comment on column RF_TMVT.RF_INDM_COD is
'Code indicateur marche';

comment on column RF_TMVT.RF_TMVT_COD_REF1 is
'Code Type mouvement';

comment on column RF_TMVT.RF_TMVT_COD_REF2 is
'Code Type mouvement';

comment on column RF_TMVT.RF_TMVT_LIB is
'Libelle Type mouvement';

comment on column RF_TMVT.RF_TMVT_LIBNAT is
'Clair nature mouvement';

comment on column RF_TMVT.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TMVT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TMVT
   add constraint RF_TMVT_PK1_1 primary key (RF_TMVT_COD);

/*==============================================================*/
/* Index : RF_TMVT_FK1_2                                        */
/*==============================================================*/
create index RF_TMVT_FK1_2 on RF_TMVT (
   RF_INDM_COD ASC
);

/*==============================================================*/
/* Index : RF_TMVT_FK1_1                                        */
/*==============================================================*/
create index RF_TMVT_FK1_1 on RF_TMVT (
   RF_TMVT_COD_REF2 ASC
);

/*==============================================================*/
/* Index : RF_TMVT_FK1_3                                        */
/*==============================================================*/
create index RF_TMVT_FK1_3 on RF_TMVT (
   RF_TMVT_COD_REF1 ASC
);

grant SELECT on RF_TMVT to PUBLIC;

grant REFERENCES on RF_TMVT to PUBLIC;

grant REFERENCES on RF_TMVT to PUBLIC;

grant SELECT on RF_TMVT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TNIV                                              */
/*==============================================================*/
create table RF_TNIV  (
   RF_TNIV_ID           INTEGER                         not null,
   RF_TNIV_COD          VARCHAR2(5)                     not null,
   RF_TNIV_LIB          VARCHAR2(25)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TNIV_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TNIV is
'Table des types de niveaux';

comment on column RF_TNIV.RF_TNIV_ID is
'Identifiant du type de niveau';

comment on column RF_TNIV.RF_TNIV_COD is
'Code du type de niveau';

comment on column RF_TNIV.RF_TNIV_LIB is
'Libelle du type de niveau';

comment on column RF_TNIV.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TNIV.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TNIV
   add constraint RF_TNIV_PK1_1 primary key (RF_TNIV_ID);

/*==============================================================*/
/* Index : RF_TNIV_UN1_1                                        */
/*==============================================================*/
create unique index RF_TNIV_UN1_1 on RF_TNIV (
   RF_TNIV_COD ASC
);

grant SELECT on RF_TNIV to PUBLIC;

grant REFERENCES on RF_TNIV to PUBLIC;

grant REFERENCES on RF_TNIV to PUBLIC;

grant SELECT on RF_TNIV to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TOPE                                              */
/*==============================================================*/
create table RF_TOPE  (
   RF_TOPE_ID           INTEGER                         not null,
   RF_TOPE_TYPE         VARCHAR2(4)                     not null,
   RF_TOPE_TXTSH        VARCHAR2(20),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_TOPE is
'Table des types d''operation (type EJ) CHORUS.';

comment on column RF_TOPE.RF_TOPE_TYPE is
'Code du type d''operation CHORUS.';

comment on column RF_TOPE.RF_TOPE_TXTSH is
'Description courte du type d''operation CHORUS.';

comment on column RF_TOPE.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_TOPE.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_TOPE
   add constraint RF_TOPE_PK1_1 primary key (RF_TOPE_ID);

alter table RF_TOPE
   add constraint RF_TOPE_UN1_1 unique (RF_TOPE_TYPE);

grant SELECT on RF_TOPE to PUBLIC;

grant REFERENCES on RF_TOPE to PUBLIC;

grant REFERENCES on RF_TOPE to PUBLIC;

grant SELECT on RF_TOPE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TOPEDOM                                           */
/*==============================================================*/
create table RF_TOPEDOM  (
   RF_TOPEDOM_ID        INTEGER                         not null,
   RF_TOPEDOM_COD       VARCHAR2(5)                     not null,
   RF_TOPEDOM_LIB       VARCHAR2(50)                    not null,
   RF_TOPEDOM_LIBMNT    VARCHAR2(50)                    not null,
   RF_TOPEDOM_ECHCP     VARCHAR2(1),
   RF_TOPEDOM_REEL      VARCHAR2(1),
   RF_TOPEDOM_SENS      VARCHAR2(2)                    
      constraint CKC_RF_TOPEDOM_SENS_RF_TOPED check (RF_TOPEDOM_SENS is null or (RF_TOPEDOM_SENS in ('E','S','ES',null))),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TOPEDOM_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TOPEDOM is
'Type d''operation                                                  Libelle document                                           Libelle montant
Acquisition                                                            Acte                                                              Montant operation domaniale
Prise a bail                                                            Acte                                                              Montant loyer annuel
Remise aux domaines                                           Proces verbal de remise aux domaines         Montant de l''estimation
Alienation precdee remise aux domaines               Acte                                                              Prix de vente
Remise d''usufruit                                                   Proces verbal de remise d''usufruit                 Montant indemnite
Changement d''affectation                                      Arrete prefectoral ou interministeriel               Montant indemnite
Transfert de gestion                                              Proces verbal de transfert de gestion             Montant indemnite
Autres modes de cession                                      Acte                                                                Prix de la cession
';

comment on column RF_TOPEDOM.RF_TOPEDOM_ID is
'Identifiant type op. dom.';

comment on column RF_TOPEDOM.RF_TOPEDOM_COD is
'Code Type Opedom';

comment on column RF_TOPEDOM.RF_TOPEDOM_LIB is
'Libelle type op. dom.';

comment on column RF_TOPEDOM.RF_TOPEDOM_LIBMNT is
'Libelle montant op. dom';

comment on column RF_TOPEDOM.RF_TOPEDOM_ECHCP is
'Top echange compense';

comment on column RF_TOPEDOM.RF_TOPEDOM_REEL is
'Top reelle opedom';

comment on column RF_TOPEDOM.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TOPEDOM.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TOPEDOM
   add constraint RF_TOPEDOM_PK1_1 primary key (RF_TOPEDOM_ID);

/*==============================================================*/
/* Index : RF_TOPEDOM_UN1_1                                     */
/*==============================================================*/
create unique index RF_TOPEDOM_UN1_1 on RF_TOPEDOM (
   RF_TOPEDOM_COD ASC
);

grant SELECT on RF_TOPEDOM to PUBLIC;

grant REFERENCES on RF_TOPEDOM to PUBLIC;

grant REFERENCES on RF_TOPEDOM to PUBLIC;

grant SELECT on RF_TOPEDOM to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TOPLIQ                                            */
/*==============================================================*/
create table RF_TOPLIQ  (
   RF_TOPLIQ_TOP        VARCHAR2(1)                     not null,
   RF_TOPLIQ_LIB        VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TOPLIQ_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TOPLIQ is
'Top liquidation';

comment on column RF_TOPLIQ.RF_TOPLIQ_TOP is
'Code du top_liquidation';

comment on column RF_TOPLIQ.RF_TOPLIQ_LIB is
'Clair du top liq';

comment on column RF_TOPLIQ.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TOPLIQ.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TOPLIQ
   add constraint RF_TOPLIQ_PK1_1 primary key (RF_TOPLIQ_TOP);

grant SELECT on RF_TOPLIQ to PUBLIC;

grant REFERENCES on RF_TOPLIQ to PUBLIC;

grant REFERENCES on RF_TOPLIQ to PUBLIC;

grant SELECT on RF_TOPLIQ to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TOPV                                              */
/*==============================================================*/
create table RF_TOPV  (
   RF_TOPV_COD          VARCHAR2(2)                     not null,
   RF_TOPV_LIB          VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TOPV_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on column RF_TOPV.RF_TOPV_COD is
'Top valide';

comment on column RF_TOPV.RF_TOPV_LIB is
'Clair top valide';

comment on column RF_TOPV.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TOPV.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TOPV
   add constraint RF_TOPV_PK1_1 primary key (RF_TOPV_COD);

grant SELECT on RF_TOPV to PUBLIC;

grant REFERENCES on RF_TOPV to PUBLIC;

grant REFERENCES on RF_TOPV to PUBLIC;

grant SELECT on RF_TOPV to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TORG                                              */
/*==============================================================*/
create table RF_TORG  (
   RF_TORG_COD          VARCHAR2(1)                     not null,
   RF_TORG_LIB          VARCHAR2(25)                    not null,
   RF_TORG_LIBA         VARCHAR2(10)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TORG_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TORG is
'Type d''organisme';

comment on column RF_TORG.RF_TORG_COD is
'Identifiant Type Organisme';

comment on column RF_TORG.RF_TORG_LIB is
'Libelle Type Organisme';

comment on column RF_TORG.RF_TORG_LIBA is
'Libelle abrege Type Organisme';

comment on column RF_TORG.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TORG.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TORG
   add constraint RF_TORG_PK1_1 primary key (RF_TORG_COD);

grant SELECT on RF_TORG to PUBLIC;

grant REFERENCES on RF_TORG to PUBLIC;

grant REFERENCES on RF_TORG to PUBLIC;

grant SELECT on RF_TORG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TOUV                                              */
/*==============================================================*/
create table RF_TOUV  (
   RF_TOUV_ID           INTEGER                         not null,
   RF_TOUV_COD          VARCHAR2(3)                     not null,
   RF_SFCT_ID           INTEGER                         not null,
   RF_CPTCLAUTIL_ID     INTEGER,
   RF_TOUV_LIB          VARCHAR2(100)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TOUV_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TOUV is
'Table des types d''ouvrage';

comment on column RF_TOUV.RF_TOUV_ID is
'Identifiant du type d''ouvrage';

comment on column RF_TOUV.RF_TOUV_COD is
'Code du type d''ouvrage';

comment on column RF_TOUV.RF_SFCT_ID is
'Identifiant de la sous-fonction';

comment on column RF_TOUV.RF_CPTCLAUTIL_ID is
'RF_CPTCLAUTIL_ID';

comment on column RF_TOUV.RF_TOUV_LIB is
'Libelle du type d''ouvrage';

comment on column RF_TOUV.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TOUV.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TOUV
   add constraint RF_TOUV_PK1_1 primary key (RF_TOUV_ID);

/*==============================================================*/
/* Index : RF_TOUV_FK1_1                                        */
/*==============================================================*/
create index RF_TOUV_FK1_1 on RF_TOUV (
   RF_SFCT_ID ASC
);

/*==============================================================*/
/* Index : RF_TOUV_UN2_1                                        */
/*==============================================================*/
create unique index RF_TOUV_UN2_1 on RF_TOUV (
   RF_TOUV_COD ASC,
   RF_SFCT_ID ASC
);

/*==============================================================*/
/* Index : RF_TOUV_FK1_2                                        */
/*==============================================================*/
create index RF_TOUV_FK1_2 on RF_TOUV (
   RF_CPTCLAUTIL_ID ASC
);

grant SELECT on RF_TOUV to PUBLIC;

grant REFERENCES on RF_TOUV to PUBLIC;

grant REFERENCES on RF_TOUV to PUBLIC;

grant SELECT on RF_TOUV to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TPAIDIR                                           */
/*==============================================================*/
create table RF_TPAIDIR  (
   RF_TPAIDIR_COD       VARCHAR2(1)                     not null,
   RF_TPAIDIR_LIB       VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TPAIDIR_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TPAIDIR is
'Type de paiement direct';

comment on column RF_TPAIDIR.RF_TPAIDIR_COD is
'Code type de paiement direct';

comment on column RF_TPAIDIR.RF_TPAIDIR_LIB is
'Clair type de paiement direct';

comment on column RF_TPAIDIR.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TPAIDIR.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TPAIDIR
   add constraint RF_TPAIDIR_PK1_1 primary key (RF_TPAIDIR_COD);

grant SELECT on RF_TPAIDIR to PUBLIC;

grant REFERENCES on RF_TPAIDIR to PUBLIC;

grant REFERENCES on RF_TPAIDIR to PUBLIC;

grant SELECT on RF_TPAIDIR to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TPERS                                             */
/*==============================================================*/
create table RF_TPERS  (
   RF_TPERS_ID          INTEGER                         not null,
   RF_TPERS_COD         VARCHAR2(1)                     not null,
   RF_TPERS_LIB         VARCHAR2(20)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TPERS_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TPERS is
'Table des types de personnel (Civil - Militaire)';

comment on column RF_TPERS.RF_TPERS_ID is
'Identifiant du type personnel';

comment on column RF_TPERS.RF_TPERS_COD is
'Code type personnel ';

comment on column RF_TPERS.RF_TPERS_LIB is
'Libelle type personnel';

comment on column RF_TPERS.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TPERS.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TPERS
   add constraint RF_TPERS_PK1_1 primary key (RF_TPERS_ID);

/*==============================================================*/
/* Index : RF_TPERS_UN1_1                                       */
/*==============================================================*/
create unique index RF_TPERS_UN1_1 on RF_TPERS (
   RF_TPERS_COD ASC
);

grant SELECT on RF_TPERS to PUBLIC;

grant REFERENCES on RF_TPERS to PUBLIC;

grant REFERENCES on RF_TPERS to PUBLIC;

grant SELECT on RF_TPERS to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TPIE                                              */
/*==============================================================*/
create table RF_TPIE  (
   RF_TPIE_ID           INTEGER                         not null,
   RF_TPIE_TYPE         VARCHAR2(2)                     not null,
   RF_TPIE_TXTSH        VARCHAR2(20),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_TPIE is
'Table des types de pieces CHORUS.';

comment on column RF_TPIE.RF_TPIE_ID is
'ID du type de piece CHORUS.';

comment on column RF_TPIE.RF_TPIE_TYPE is
'Code du type de piece CHORUS.';

comment on column RF_TPIE.RF_TPIE_TXTSH is
'Description du type de piece CHORUS.';

comment on column RF_TPIE.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_TPIE.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_TPIE
   add constraint RF_TPIE_PK1_1 primary key (RF_TPIE_ID);

alter table RF_TPIE
   add constraint RF_TPIE_UN1_1 unique (RF_TPIE_TYPE);

grant SELECT on RF_TPIE to PUBLIC;

grant REFERENCES on RF_TPIE to PUBLIC;

grant REFERENCES on RF_TPIE to PUBLIC;

grant SELECT on RF_TPIE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TPOP                                              */
/*==============================================================*/
create table RF_TPOP  (
   RF_TPOP_ID           INTEGER                         not null,
   RF_TPERS_ID          INTEGER                         not null,
   RF_TPOP_COD          VARCHAR2(5)                     not null,
   RF_TPOP_LIB          VARCHAR2(50),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TPOP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TPOP is
'Table des types de population';

comment on column RF_TPOP.RF_TPOP_ID is
'Identifiant du type de population';

comment on column RF_TPOP.RF_TPERS_ID is
'Identifiant du type personnel';

comment on column RF_TPOP.RF_TPOP_COD is
'Abreviation du gestionnaire en terme d''effectif';

comment on column RF_TPOP.RF_TPOP_LIB is
'Libelle type population';

comment on column RF_TPOP.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TPOP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TPOP
   add constraint RF_TPOP_PK1_1 primary key (RF_TPOP_ID);

/*==============================================================*/
/* Index : RF_TPOP_FK1_1                                        */
/*==============================================================*/
create index RF_TPOP_FK1_1 on RF_TPOP (
   RF_TPERS_ID ASC
);

/*==============================================================*/
/* Index : RF_TPOP_UN2_1                                        */
/*==============================================================*/
create unique index RF_TPOP_UN2_1 on RF_TPOP (
   RF_TPERS_ID ASC,
   RF_TPOP_COD ASC
);

grant SELECT on RF_TPOP to PUBLIC;

grant REFERENCES on RF_TPOP to PUBLIC;

grant REFERENCES on RF_TPOP to PUBLIC;

grant SELECT on RF_TPOP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TPOS                                              */
/*==============================================================*/
create table RF_TPOS  (
   RF_TPOS_ID           INTEGER                         not null,
   RF_TPOS_COD          VARCHAR2(5)                     not null,
   RF_TPOS_LIB          VARCHAR2(20),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TPOS_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TPOS is
'Table des types de position au DUO';

comment on column RF_TPOS.RF_TPOS_ID is
'Identifiant du type de position au DO';

comment on column RF_TPOS.RF_TPOS_COD is
'Code du type de position au DO';

comment on column RF_TPOS.RF_TPOS_LIB is
'Libelle du type de position au DO';

comment on column RF_TPOS.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TPOS.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TPOS
   add constraint RF_TPOS_PK1_1 primary key (RF_TPOS_ID);

/*==============================================================*/
/* Index : RF_TPOS_UN1_1                                        */
/*==============================================================*/
create unique index RF_TPOS_UN1_1 on RF_TPOS (
   RF_TPOS_COD ASC
);

grant SELECT on RF_TPOS to PUBLIC;

grant REFERENCES on RF_TPOS to PUBLIC;

grant REFERENCES on RF_TPOS to PUBLIC;

grant SELECT on RF_TPOS to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TPRE                                              */
/*==============================================================*/
create table RF_TPRE  (
   RF_TPRE_COD          VARCHAR2(9)                     not null,
   RF_FCTN_COD          VARCHAR2(1)                     not null,
   RF_TPRE_LIB          VARCHAR2(30)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TPRE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TPRE is
'Type de prestation';

comment on column RF_TPRE.RF_TPRE_COD is
'Identifiant Type Prest';

comment on column RF_TPRE.RF_FCTN_COD is
'Code Fonction';

comment on column RF_TPRE.RF_TPRE_LIB is
'Libelle Type Prest';

comment on column RF_TPRE.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TPRE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TPRE
   add constraint RF_TPRE_PK1_1 primary key (RF_TPRE_COD);

/*==============================================================*/
/* Index : RF_TPRE_FK1_1                                        */
/*==============================================================*/
create index RF_TPRE_FK1_1 on RF_TPRE (
   RF_FCTN_COD ASC
);

grant SELECT on RF_TPRE to PUBLIC;

grant REFERENCES on RF_TPRE to PUBLIC;

grant REFERENCES on RF_TPRE to PUBLIC;

grant SELECT on RF_TPRE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TPRO                                              */
/*==============================================================*/
create table RF_TPRO  (
   RF_TPRO_ID           INTEGER                         not null,
   RF_TPRO_COD          VARCHAR2(2)                     not null,
   RF_TPRO_LIB          VARCHAR2(60)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TPRO_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TPRO is
'Table des types de proprietaire';

comment on column RF_TPRO.RF_TPRO_ID is
'Identifiant du type de prorietaire';

comment on column RF_TPRO.RF_TPRO_COD is
'Code du type de proprietaire';

comment on column RF_TPRO.RF_TPRO_LIB is
'Libelle du type de proprietaire';

comment on column RF_TPRO.RF_XDMAJ is
'Date de mise a jour de l''enregsitrement';

comment on column RF_TPRO.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TPRO
   add constraint RF_TPRO_PK1_1 primary key (RF_TPRO_ID);

/*==============================================================*/
/* Index : RF_TPRO_UN1_1                                        */
/*==============================================================*/
create unique index RF_TPRO_UN1_1 on RF_TPRO (
   RF_TPRO_COD ASC
);

grant SELECT on RF_TPRO to PUBLIC;

grant REFERENCES on RF_TPRO to PUBLIC;

grant REFERENCES on RF_TPRO to PUBLIC;

grant SELECT on RF_TPRO to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TPROTECT                                          */
/*==============================================================*/
create table RF_TPROTECT  (
   RF_TPROTECT_ID       INTEGER                         not null,
   RF_TPROTECT_COD      VARCHAR2(1)                     not null,
   RF_TPROTECT_LIB      VARCHAR2(100)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TPROTECT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TPROTECT is
'Type protection';

comment on column RF_TPROTECT.RF_TPROTECT_ID is
'Identifiant du type de protection';

comment on column RF_TPROTECT.RF_TPROTECT_COD is
'Code type protection';

comment on column RF_TPROTECT.RF_TPROTECT_LIB is
'Libelle type protection';

comment on column RF_TPROTECT.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TPROTECT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TPROTECT
   add constraint RF_TPROTECT_PK1_1 primary key (RF_TPROTECT_ID);

/*==============================================================*/
/* Index : RF_TPROTECT_UN1_1                                    */
/*==============================================================*/
create unique index RF_TPROTECT_UN1_1 on RF_TPROTECT (
   RF_TPROTECT_COD ASC
);

grant SELECT on RF_TPROTECT to PUBLIC;

grant REFERENCES on RF_TPROTECT to PUBLIC;

grant REFERENCES on RF_TPROTECT to PUBLIC;

grant SELECT on RF_TPROTECT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TPSHIS                                            */
/*==============================================================*/
create table RF_TPSHIS  (
   RF_TPSHIS_ID         INTEGER                         not null,
   RF_TPSHIS_COD        VARCHAR2(1)                     not null,
   RF_TPSHIS_LIB        VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TPSHIS_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TPSHIS is
'Type de protection d''une servitude historique';

comment on column RF_TPSHIS.RF_TPSHIS_ID is
'Identifiant du type de protection d''une servitude historique';

comment on column RF_TPSHIS.RF_TPSHIS_COD is
'Code du type de protection d''une servitude historique';

comment on column RF_TPSHIS.RF_TPSHIS_LIB is
'Libelle du type de protection d''une servitude historique';

comment on column RF_TPSHIS.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TPSHIS.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TPSHIS
   add constraint RF_TPSHIS_PK1_1 primary key (RF_TPSHIS_ID);

/*==============================================================*/
/* Index : RF_TPSHIS_UN1_1                                      */
/*==============================================================*/
create unique index RF_TPSHIS_UN1_1 on RF_TPSHIS (
   RF_TPSHIS_COD ASC
);

grant SELECT on RF_TPSHIS to PUBLIC;

grant REFERENCES on RF_TPSHIS to PUBLIC;

grant REFERENCES on RF_TPSHIS to PUBLIC;

grant SELECT on RF_TPSHIS to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TPSTRAV                                           */
/*==============================================================*/
create table RF_TPSTRAV  (
   RF_TPSTRAV_ID        INTEGER                         not null,
   RF_TPERS_ID          INTEGER                         not null,
   RF_TPSTRAV_COD       NUMBER(3,2)                     not null,
   RF_TPSTRAV_LIB       VARCHAR2(60),
   RF_TPSTRAV_LIBA      VARCHAR2(5),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TPSTRAV_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TPSTRAV is
'Table concernant la duree du temps de travail. Concerne les PC';

comment on column RF_TPSTRAV.RF_TPSTRAV_ID is
'Identifiant temps de travail';

comment on column RF_TPSTRAV.RF_TPERS_ID is
'Identifiant du type personnel';

comment on column RF_TPSTRAV.RF_TPSTRAV_COD is
'Pourcentage de temps de travail';

comment on column RF_TPSTRAV.RF_TPSTRAV_LIB is
'Libelle du temps de travail.';

comment on column RF_TPSTRAV.RF_TPSTRAV_LIBA is
'Libelle abrege du temps de travail.';

comment on column RF_TPSTRAV.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TPSTRAV.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TPSTRAV
   add constraint RF_TPSTRAV_PK1_1 primary key (RF_TPSTRAV_ID);

/*==============================================================*/
/* Index : RF_TPSTRAV_FK1_1                                     */
/*==============================================================*/
create index RF_TPSTRAV_FK1_1 on RF_TPSTRAV (
   RF_TPERS_ID ASC
);

grant SELECT on RF_TPSTRAV to PUBLIC;

grant REFERENCES on RF_TPSTRAV to PUBLIC;

grant REFERENCES on RF_TPSTRAV to PUBLIC;

grant SELECT on RF_TPSTRAV to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TPYR                                              */
/*==============================================================*/
create table RF_TPYR  (
   RF_TPYR_COD          VARCHAR2(1)                     not null,
   RF_TPYR_LIB          VARCHAR2(30)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TPYR_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TPYR is
'Type de payeur';

comment on column RF_TPYR.RF_TPYR_COD is
'Type de Payeur';

comment on column RF_TPYR.RF_TPYR_LIB is
'Type de Payeur';

comment on column RF_TPYR.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TPYR.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TPYR
   add constraint RF_TPYR_PK1_1 primary key (RF_TPYR_COD);

grant SELECT on RF_TPYR to PUBLIC;

grant REFERENCES on RF_TPYR to PUBLIC;

grant REFERENCES on RF_TPYR to PUBLIC;

grant SELECT on RF_TPYR to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TRAN                                              */
/*==============================================================*/
create table RF_TRAN  (
   RF_TRAN_COD          VARCHAR2(2)                     not null,
   RF_TRAN_LIB          VARCHAR2(30)                    not null,
   RF_TRAN_MIN          NUMBER(10,2),
   RF_TRAN_MAX          NUMBER(10,2),
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TRAN_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TRAN is
'Tranche';

comment on column RF_TRAN.RF_TRAN_COD is
'Code Tranche';

comment on column RF_TRAN.RF_TRAN_LIB is
'Libelle Tranche';

comment on column RF_TRAN.RF_TRAN_MIN is
'Montant Min Tranche';

comment on column RF_TRAN.RF_TRAN_MAX is
'Montant Max Tranche';

comment on column RF_TRAN.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TRAN.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TRAN
   add constraint RF_TRAN_PK1_1 primary key (RF_TRAN_COD);

grant SELECT on RF_TRAN to PUBLIC;

grant REFERENCES on RF_TRAN to PUBLIC;

grant REFERENCES on RF_TRAN to PUBLIC;

grant SELECT on RF_TRAN to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TREG                                              */
/*==============================================================*/
create table RF_TREG  (
   RF_TREG_COD          VARCHAR2(1)                     not null,
   RF_TREG_LIB          VARCHAR2(40),
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TREG_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TREG is
'Type de region';

comment on column RF_TREG.RF_TREG_COD is
'Code type de region';

comment on column RF_TREG.RF_TREG_LIB is
'Libelle type de region';

comment on column RF_TREG.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TREG.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TREG
   add constraint RF_TREG_PK1_1 primary key (RF_TREG_COD);

grant SELECT on RF_TREG to PUBLIC;

grant REFERENCES on RF_TREG to PUBLIC;

grant REFERENCES on RF_TREG to PUBLIC;

grant SELECT on RF_TREG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TSAUP                                             */
/*==============================================================*/
create table RF_TSAUP  (
   RF_TSAUP_ID          INTEGER                         not null,
   RF_TSAUP_COD         VARCHAR2(3)                     not null,
   RF_TSAUP_LIB         VARCHAR2(50)                    not null,
   RF_TSAUP_TGP         VARCHAR2(1)                     not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TSAUP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TSAUP is
'Servitude autre que d''utilite publique
A supprimer avec la suppression de SAGRI';

comment on column RF_TSAUP.RF_TSAUP_ID is
'Identifiant de la servitude autre que d''utilite publique';

comment on column RF_TSAUP.RF_TSAUP_COD is
'Code de la servitude autre que d''utilite publique';

comment on column RF_TSAUP.RF_TSAUP_LIB is
'Libelle de la servitude autre que d''utilite publique';

comment on column RF_TSAUP.RF_TSAUP_TGP is
'Correspondance TGPE SAUP';

comment on column RF_TSAUP.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TSAUP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TSAUP
   add constraint RF_TSAUP_PK1_1 primary key (RF_TSAUP_ID);

/*==============================================================*/
/* Index : RF_TSAUP_UN1_1                                       */
/*==============================================================*/
create unique index RF_TSAUP_UN1_1 on RF_TSAUP (
   RF_TSAUP_COD ASC
);

grant SELECT on RF_TSAUP to PUBLIC;

grant REFERENCES on RF_TSAUP to PUBLIC;

grant REFERENCES on RF_TSAUP to PUBLIC;

grant SELECT on RF_TSAUP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TSAUPP                                            */
/*==============================================================*/
create table RF_TSAUPP  (
   RF_TSAUPP_ID         INTEGER                         not null,
   RF_TSAUPP_COD        VARCHAR2(1)                     not null,
   RF_TSAUPP_LIB        VARCHAR2(50)                    not null,
   RF_TSAUPP_LIBA       VARCHAR2(5)                     not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TSAUPP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TSAUPP is
'Type d''une servitude autre que d''utilite publique au profit';

comment on column RF_TSAUPP.RF_TSAUPP_ID is
'Identifiant de la S.A.U.P.P.';

comment on column RF_TSAUPP.RF_TSAUPP_COD is
'Code de la S.A.U.P.P.';

comment on column RF_TSAUPP.RF_TSAUPP_LIB is
'Libelle de la S.A.U.P.P.';

comment on column RF_TSAUPP.RF_TSAUPP_LIBA is
'Denomination courte de la SAUPP';

comment on column RF_TSAUPP.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TSAUPP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TSAUPP
   add constraint RF_TSAUPP_PK1_1 primary key (RF_TSAUPP_ID);

/*==============================================================*/
/* Index : RF_TSAUPP_UN1_1                                      */
/*==============================================================*/
create unique index RF_TSAUPP_UN1_1 on RF_TSAUPP (
   RF_TSAUPP_COD ASC
);

grant SELECT on RF_TSAUPP to PUBLIC;

grant REFERENCES on RF_TSAUPP to PUBLIC;

grant REFERENCES on RF_TSAUPP to PUBLIC;

grant SELECT on RF_TSAUPP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TSNUP                                             */
/*==============================================================*/
create table RF_TSNUP  (
   RF_TSNUP_ID          INTEGER                         not null,
   RF_TSNUP_COD         VARCHAR2(3)                     not null,
   RF_TSNUP_LIB         VARCHAR2(50)                    not null,
   RF_TSNUP_TGP         VARCHAR2(1)                     not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TSNUP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TSNUP is
'Servitude autre que d''utilite publique';

comment on column RF_TSNUP.RF_TSNUP_ID is
'Identifiant de la servitude autre que d''utilite publique';

comment on column RF_TSNUP.RF_TSNUP_COD is
'Code de la servitude autre que d''utilite publique';

comment on column RF_TSNUP.RF_TSNUP_LIB is
'Libelle de la servitude autre que d''utilite publique';

comment on column RF_TSNUP.RF_TSNUP_TGP is
'Correspondance TGPE SAUP';

comment on column RF_TSNUP.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TSNUP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TSNUP
   add constraint RF_TSNUP_PK1_1 primary key (RF_TSNUP_ID);

/*==============================================================*/
/* Index : RF_TSNUP_UN1_1                                       */
/*==============================================================*/
create unique index RF_TSNUP_UN1_1 on RF_TSNUP (
   RF_TSNUP_COD ASC
);

grant SELECT on RF_TSNUP to PUBLIC;

grant REFERENCES on RF_TSNUP to PUBLIC;

grant REFERENCES on RF_TSNUP to PUBLIC;

grant SELECT on RF_TSNUP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TSOULTE                                           */
/*==============================================================*/
create table RF_TSOULTE  (
   RF_TSOULTE_ID        INTEGER                         not null,
   RF_TSOULTE_COD       VARCHAR2(3)                     not null,
   RF_TSOULTE_LIB       VARCHAR2(50),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TSOULTE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TSOULTE is
'Valeur:
aux depens, au profit, sans soulte';

comment on column RF_TSOULTE.RF_TSOULTE_ID is
'RF_TSOULTE_ID';

comment on column RF_TSOULTE.RF_TSOULTE_COD is
'Code';

comment on column RF_TSOULTE.RF_TSOULTE_LIB is
'Libelle';

comment on column RF_TSOULTE.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TSOULTE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TSOULTE
   add constraint RF_TSOULTE_PK1_1 primary key (RF_TSOULTE_ID);

/*==============================================================*/
/* Index : RF_TSOULTE_UN1_1                                     */
/*==============================================================*/
create unique index RF_TSOULTE_UN1_1 on RF_TSOULTE (
   RF_TSOULTE_COD ASC
);

grant SELECT on RF_TSOULTE to PUBLIC;

grant REFERENCES on RF_TSOULTE to PUBLIC;

grant REFERENCES on RF_TSOULTE to PUBLIC;

grant SELECT on RF_TSOULTE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TSTAT                                             */
/*==============================================================*/
create table RF_TSTAT  (
   RF_TSTAT_COD         VARCHAR2(2)                     not null,
   RF_TSTAT_LIB         VARCHAR2(30)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TSTAT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TSTAT is
'Type statistique';

comment on column RF_TSTAT.RF_TSTAT_COD is
'Type Code Stat';

comment on column RF_TSTAT.RF_TSTAT_LIB is
'Libelle Type Code Statistique';

comment on column RF_TSTAT.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TSTAT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TSTAT
   add constraint RF_TSTAT_PK1_1 primary key (RF_TSTAT_COD);

grant SELECT on RF_TSTAT to PUBLIC;

grant REFERENCES on RF_TSTAT to PUBLIC;

grant REFERENCES on RF_TSTAT to PUBLIC;

grant SELECT on RF_TSTAT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TSUB                                              */
/*==============================================================*/
create table RF_TSUB  (
   RF_TSUB_COD          VARCHAR2(3)                     not null,
   RF_TSUB_LIB          VARCHAR2(50)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TSUB_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TSUB is
'Type de subdelegation';

comment on column RF_TSUB.RF_TSUB_COD is
'Code du type de subdelegation';

comment on column RF_TSUB.RF_TSUB_LIB is
'Clair du type de subdelegation';

comment on column RF_TSUB.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TSUB.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TSUB
   add constraint RF_TSUB_PK1_1 primary key (RF_TSUB_COD);

grant SELECT on RF_TSUB to PUBLIC;

grant REFERENCES on RF_TSUB to PUBLIC;

grant REFERENCES on RF_TSUB to PUBLIC;

grant SELECT on RF_TSUB to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TSUP                                              */
/*==============================================================*/
create table RF_TSUP  (
   RF_TSUP_ID           INTEGER                         not null,
   RF_TSUP_COD          VARCHAR2(3)                     not null,
   RF_TSUP_LIB          VARCHAR2(50)                    not null,
   RF_TSUP_TGP          VARCHAR2(1)                     not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TSUP_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TSUP is
'Type de Servitude d''utilite publique';

comment on column RF_TSUP.RF_TSUP_ID is
'Identifiant de la servitude d''utilite publique';

comment on column RF_TSUP.RF_TSUP_COD is
'Code de la servitude d''utilite publique';

comment on column RF_TSUP.RF_TSUP_LIB is
'Libelle de la servitude d''utilite publique';

comment on column RF_TSUP.RF_TSUP_TGP is
'Correspondance TPGE SUP';

comment on column RF_TSUP.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TSUP.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TSUP
   add constraint RF_TSUP_PK1_1 primary key (RF_TSUP_ID);

/*==============================================================*/
/* Index : RF_TSUP_UN1_1                                        */
/*==============================================================*/
create unique index RF_TSUP_UN1_1 on RF_TSUP (
   RF_TSUP_COD ASC
);

grant SELECT on RF_TSUP to PUBLIC;

grant REFERENCES on RF_TSUP to PUBLIC;

grant REFERENCES on RF_TSUP to PUBLIC;

grant SELECT on RF_TSUP to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TTACHE                                            */
/*==============================================================*/
create table RF_TTACHE  (
   RF_TTACHE_ID         INTEGER                         not null,
   RF_TTACHE_LIB        VARCHAR2(80)                    not null,
   RF_TTACHE_DTDEB_TOP  INTEGER                         not null,
   RF_TTACHE_DTFIN_TOP  INTEGER                         not null,
   RF_TTACHE_MNT_TOP    INTEGER                         not null,
   RF_TTACHE_PREV_TOP   INTEGER                         not null,
   RF_TTACHE_REEL_TOP   INTEGER                         not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TTACHE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TTACHE is
'Table des Types de taches';

comment on column RF_TTACHE.RF_TTACHE_ID is
'Identifiant du type de tache';

comment on column RF_TTACHE.RF_TTACHE_LIB is
'Libelle du type de tache';

comment on column RF_TTACHE.RF_TTACHE_DTDEB_TOP is
'Date de debut';

comment on column RF_TTACHE.RF_TTACHE_DTFIN_TOP is
'Date de fin';

comment on column RF_TTACHE.RF_TTACHE_MNT_TOP is
'Montant';

comment on column RF_TTACHE.RF_TTACHE_PREV_TOP is
'Previsionnelle';

comment on column RF_TTACHE.RF_TTACHE_REEL_TOP is
'Reelle';

comment on column RF_TTACHE.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TTACHE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TTACHE
   add constraint RF_TTACHE_PK1_1 primary key (RF_TTACHE_ID);

/*==============================================================*/
/* Index : RF_TTACHE_UN2_1                                      */
/*==============================================================*/
create unique index RF_TTACHE_UN2_1 on RF_TTACHE (
   RF_TTACHE_LIB ASC,
   RF_XTOPSUP ASC
);

grant SELECT on RF_TTACHE to PUBLIC;

grant REFERENCES on RF_TTACHE to PUBLIC;

grant REFERENCES on RF_TTACHE to PUBLIC;

grant SELECT on RF_TTACHE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TTF                                               */
/*==============================================================*/
create table RF_TTF  (
   RF_TTF_ID            INTEGER                         not null,
   RF_TTF_COD           VARCHAR2(3)                     not null,
   RF_TTF_LIB           VARCHAR2(300)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TTF_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TTF is
'Table contenant les types de tranches fonctionnelles issus du referentiel CHORUS.';

comment on column RF_TTF.RF_TTF_ID is
'Identifiant du type de tranche fonctionnelle';

comment on column RF_TTF.RF_TTF_COD is
'Code du type de tranche fonctionnelle';

comment on column RF_TTF.RF_TTF_LIB is
'Libelle du type de tranche fonctionnelle';

comment on column RF_TTF.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_TTF.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TTF
   add constraint RF_TTF_PK1_1 primary key (RF_TTF_ID);

grant SELECT on RF_TTF to PUBLIC;

grant REFERENCES on RF_TTF to PUBLIC;

grant REFERENCES on RF_TTF to PUBLIC;

grant SELECT on RF_TTF to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TTIE                                              */
/*==============================================================*/
create table RF_TTIE  (
   RF_TTIE_ID           INTEGER                         not null,
   RF_TTIE_TYPE         VARCHAR2(4)                     not null,
   RF_TTIE_TXTSH        VARCHAR2(20),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_TTIE is
'Table des types de tiers CHORUS.';

comment on column RF_TTIE.RF_TTIE_ID is
'ID du type de tiers CHORUS.';

comment on column RF_TTIE.RF_TTIE_TYPE is
'Code du type de tiers CHORUS.';

comment on column RF_TTIE.RF_TTIE_TXTSH is
'Designation du type de tiers CHORUS.';

comment on column RF_TTIE.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_TTIE.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_TTIE
   add constraint RF_TTIE_PK1_1 primary key (RF_TTIE_ID);

alter table RF_TTIE
   add constraint RF_TTIE_UN1_1 unique (RF_TTIE_TYPE);

grant SELECT on RF_TTIE to PUBLIC;

grant REFERENCES on RF_TTIE to PUBLIC;

grant REFERENCES on RF_TTIE to PUBLIC;

grant SELECT on RF_TTIE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TTRAN                                             */
/*==============================================================*/
create table RF_TTRAN  (
   RF_TTRAN_COD         VARCHAR2(1)                     not null,
   RF_TTRAN_LIB         VARCHAR2(25)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TTRAN_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TTRAN is
'Type de tranche d''un marche';

comment on column RF_TTRAN.RF_TTRAN_COD is
'Code du type de tranche d''un marche';

comment on column RF_TTRAN.RF_TTRAN_LIB is
'Clair du type de tranche d''un marche';

comment on column RF_TTRAN.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_TTRAN.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TTRAN
   add constraint RF_TTRAN_PK1_1 primary key (RF_TTRAN_COD);

grant SELECT on RF_TTRAN to PUBLIC;

grant REFERENCES on RF_TTRAN to PUBLIC;

grant REFERENCES on RF_TTRAN to PUBLIC;

grant SELECT on RF_TTRAN to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TVA                                               */
/*==============================================================*/
create table RF_TVA  (
   RF_PAYS_COD          VARCHAR2(5)                     not null,
   RF_TVA_COD           VARCHAR2(2)                     not null,
   RF_TVA_TAUX          NUMBER(5,2)                     not null,
   RF_TVA_LIB           VARCHAR2(40)                    not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TVA_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TVA is
'TVA';

comment on column RF_TVA.RF_PAYS_COD is
'Code du pays';

comment on column RF_TVA.RF_TVA_COD is
'Code TVA';

comment on column RF_TVA.RF_TVA_TAUX is
'Taux TVA';

comment on column RF_TVA.RF_TVA_LIB is
'Clair taux TVA';

comment on column RF_TVA.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_TVA.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TVA
   add constraint RF_TVA_PK2_1 primary key (RF_PAYS_COD, RF_TVA_COD);

/*==============================================================*/
/* Index : RF_TVA_FK1_1                                         */
/*==============================================================*/
create index RF_TVA_FK1_1 on RF_TVA (
   RF_PAYS_COD ASC
);

grant SELECT on RF_TVA to PUBLIC;

grant REFERENCES on RF_TVA to PUBLIC;

grant REFERENCES on RF_TVA to PUBLIC;

grant SELECT on RF_TVA to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TVA_NG                                            */
/*==============================================================*/
create table RF_TVA_NG  (
   RF_TVA_ID            INTEGER                         not null,
   RF_PAYS_ID           INTEGER                         not null,
   RF_TVA_ETAXCODE      VARCHAR2(2)                     not null,
   RF_TVA_ERLTYPCND     VARCHAR2(4)                     not null,
   RF_TVA_ERLTYPTVA     VARCHAR2(1),
   RF_TVA_ETXTLG        VARCHAR2(60),
   RF_TVA_ETXTTPCT      VARCHAR2(60),
   RF_TVA_TXTVA         NUMBER(8,3),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                     not null
);

comment on table RF_TVA_NG is
'Table des codes TVA CHORUS.';

comment on column RF_TVA_NG.RF_TVA_ID is
'ID TVA CHORUS.';

comment on column RF_TVA_NG.RF_PAYS_ID is
'ID code pays CHORUS.';

comment on column RF_TVA_NG.RF_TVA_ETAXCODE is
'Code TVA CHORUS.';

comment on column RF_TVA_NG.RF_TVA_ERLTYPCND is
'Type de condition TVA CHORUS.';

comment on column RF_TVA_NG.RF_TVA_ERLTYPTVA is
'Type de TVA CHORUS.';

comment on column RF_TVA_NG.RF_TVA_ETXTLG is
'Libelle du code TVA CHORUS.';

comment on column RF_TVA_NG.RF_TVA_ETXTTPCT is
'Libelle du type de condition TVA CHORUS.';

comment on column RF_TVA_NG.RF_TVA_TXTVA is
'Taux TVA CHORUS.';

comment on column RF_TVA_NG.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_TVA_NG.RF_XTOPSUP is
'Indicateur de validite de l''occurence.';

alter table RF_TVA_NG
   add constraint RF_TVA_NG_PK1_1 primary key (RF_TVA_ID);

alter table RF_TVA_NG
   add constraint RF_TVA_NG_UN3_1 unique (RF_TVA_ETAXCODE, RF_TVA_ERLTYPCND, RF_PAYS_ID);

/*==============================================================*/
/* Index : RF_TVA_NG_FK1_1                                      */
/*==============================================================*/
create index RF_TVA_NG_FK1_1 on RF_TVA_NG (
   RF_PAYS_ID ASC
);

grant SELECT on RF_TVA_NG to PUBLIC;

grant REFERENCES on RF_TVA_NG to PUBLIC;

grant REFERENCES on RF_TVA_NG to PUBLIC;

grant SELECT on RF_TVA_NG to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_TYPOLOINFRA                                       */
/*==============================================================*/
create table RF_TYPOLOINFRA  (
   RF_TYPOLOINFRA_ID    INTEGER                         not null,
   RF_TYPOLOINFRA_COD   VARCHAR2(10)                    not null,
   RF_TYPOLOINFRA_LIB   VARCHAR2(200)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_TYPOINFRA_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_TYPOLOINFRA is
'Typologies d''infrastructure';

comment on column RF_TYPOLOINFRA.RF_TYPOLOINFRA_ID is
'Identifiant de la typologie d''infrastructure';

comment on column RF_TYPOLOINFRA.RF_TYPOLOINFRA_COD is
'Code de la typologie d''infrastructure';

comment on column RF_TYPOLOINFRA.RF_TYPOLOINFRA_LIB is
'Libelle de la typologie d''infrastructure';

comment on column RF_TYPOLOINFRA.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_TYPOLOINFRA.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_TYPOLOINFRA
   add constraint RF_TYPOLOINFRA_PK1_1 primary key (RF_TYPOLOINFRA_ID);

grant SELECT on RF_TYPOLOINFRA to PUBLIC;

grant SELECT on RF_TYPOLOINFRA to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_UFONC                                             */
/*==============================================================*/
create table RF_UFONC  (
   RF_UFONC_ID          INTEGER                         not null,
   RF_UFONC_COD         VARCHAR2(10),
   RF_UFONC_LIB         VARCHAR2(200),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_UFONC_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_UFONC is
'Unites Fonctionnelles';

comment on column RF_UFONC.RF_UFONC_ID is
'Identifiant de l''unite fonctionnelle';

comment on column RF_UFONC.RF_UFONC_COD is
'Code de l''unite fonctionnelle';

comment on column RF_UFONC.RF_UFONC_LIB is
'Libelle de l''unite fonctionnelle';

comment on column RF_UFONC.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_UFONC.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_UFONC
   add constraint RF_UFONC_PK1_1 primary key (RF_UFONC_ID);

grant SELECT on RF_UFONC to PUBLIC;

grant SELECT on RF_UFONC to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_UO                                                */
/*==============================================================*/
create table RF_UO  (
   RF_UO_ID             INTEGER                         not null,
   RF_CODMIN_ID         INTEGER                         not null,
   RF_UO_CENTREFI       VARCHAR2(15)                    not null,
   RF_UO_COD            VARCHAR2(4)                     not null,
   RF_UO_LIB            VARCHAR2(300)                   not null,
   RF_UO_LIBA           VARCHAR2(100),
   RF_BOP_ID            INTEGER,
   RF_PROG_ID           INTEGER,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_UO_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_UO is
'Table contenant les UO issues du referentiel CHORUS.';

comment on column RF_UO.RF_UO_ID is
'Identifiant de l''UO';

comment on column RF_UO.RF_CODMIN_ID is
'Identifiant du Code Ministere';

comment on column RF_UO.RF_UO_CENTREFI is
'Centre financier';

comment on column RF_UO.RF_UO_COD is
'Code de l''UO';

comment on column RF_UO.RF_UO_LIB is
'Libelle de l''UO';

comment on column RF_UO.RF_UO_LIBA is
'Libelle abrege de l''UO';

comment on column RF_UO.RF_BOP_ID is
'Identifiant du BOP';

comment on column RF_UO.RF_PROG_ID is
'Identifiant du Programme';

comment on column RF_UO.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_UO.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_UO
   add constraint RF_UO_C_PK1_1 primary key (RF_UO_ID);

/*==============================================================*/
/* Index : RF_UO_FK1_4                                          */
/*==============================================================*/
create index RF_UO_FK1_4 on RF_UO (
   RF_BOP_ID ASC
);

/*==============================================================*/
/* Index : RF_UO_FK1_5                                          */
/*==============================================================*/
create index RF_UO_FK1_5 on RF_UO (
   RF_PROG_ID ASC
);

/*==============================================================*/
/* Index : RF_UO_FK1_3                                          */
/*==============================================================*/
create index RF_UO_FK1_3 on RF_UO (
   RF_CODMIN_ID ASC
);

grant SELECT on RF_UO to PUBLIC;

grant REFERENCES on RF_UO to PUBLIC;

grant REFERENCES on RF_UO to PUBLIC;

grant SELECT on RF_UO to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_UTILCL                                            */
/*==============================================================*/
create table RF_UTILCL  (
   RF_UTILCL_ID         INTEGER                         not null,
   RF_UTILCL_COD1       VARCHAR2(2)                     not null,
   RF_UTILCL_COD2       VARCHAR2(3)                     not null,
   RF_UTILCL_LIB        VARCHAR2(40)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_UTILCL_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_UTILCL is
'Utilisation d''un local';

comment on column RF_UTILCL.RF_UTILCL_ID is
'Identifiant de l''utilisation d''un local';

comment on column RF_UTILCL.RF_UTILCL_COD1 is
'Code 1ere partie de l''utilisation d''un local';

comment on column RF_UTILCL.RF_UTILCL_COD2 is
'Code 2eme partie de l''utilisation d''un local';

comment on column RF_UTILCL.RF_UTILCL_LIB is
'Libelle de l''utilisation d''un local';

comment on column RF_UTILCL.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_UTILCL.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_UTILCL
   add constraint RF_UTILCL_PK1_1 primary key (RF_UTILCL_ID);

/*==============================================================*/
/* Index : RF_UTILCL_UN2_1                                      */
/*==============================================================*/
create unique index RF_UTILCL_UN2_1 on RF_UTILCL (
   RF_UTILCL_COD1 ASC,
   RF_UTILCL_COD2 ASC
);

grant SELECT on RF_UTILCL to PUBLIC;

grant REFERENCES on RF_UTILCL to PUBLIC;

grant REFERENCES on RF_UTILCL to PUBLIC;

grant SELECT on RF_UTILCL to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ZD                                                */
/*==============================================================*/
create table RF_ZD  (
   RF_ZD_ID             INTEGER                         not null,
   RF_ZD_COD            VARCHAR2(3)                     not null,
   RF_ZD_LIB            VARCHAR2(150)                   not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ZD_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ZD is
'Zones de Defense';

comment on column RF_ZD.RF_ZD_ID is
'Identifiant de la ZD';

comment on column RF_ZD.RF_ZD_COD is
'Code de la ZD';

comment on column RF_ZD.RF_ZD_LIB is
'Libelle de la ZD';

comment on column RF_ZD.RF_XDMAJ is
'Date de mise a jour de l''occurence.';

comment on column RF_ZD.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ZD
   add constraint RF_ZD_PK1_1 primary key (RF_ZD_ID);

grant SELECT on RF_ZD to PUBLIC;

grant REFERENCES on RF_ZD to PUBLIC;

grant REFERENCES on RF_ZD to PUBLIC;

grant SELECT on RF_ZD to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ZFCT                                              */
/*==============================================================*/
create table RF_ZFCT  (
   RF_ZFCT_ID           INTEGER                         not null,
   RF_ZFCT_COD          VARCHAR2(3),
   RF_ZFCT_LIB          VARCHAR2(50)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ZFCT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ZFCT is
'Table des zones fonctionnelles';

comment on column RF_ZFCT.RF_ZFCT_ID is
'Identifiant de la zone fonctionnelle';

comment on column RF_ZFCT.RF_ZFCT_COD is
'Code de la zone fonctionnelle';

comment on column RF_ZFCT.RF_ZFCT_LIB is
'Libelle de la zone fonctionnelle';

comment on column RF_ZFCT.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_ZFCT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ZFCT
   add constraint RF_ZFCT_PK1_1 primary key (RF_ZFCT_ID);

/*==============================================================*/
/* Index : RF_ZFCT_UN1_1                                        */
/*==============================================================*/
create unique index RF_ZFCT_UN1_1 on RF_ZFCT (
   RF_ZFCT_COD ASC
);

grant SELECT on RF_ZFCT to PUBLIC;

grant REFERENCES on RF_ZFCT to PUBLIC;

grant REFERENCES on RF_ZFCT to PUBLIC;

grant SELECT on RF_ZFCT to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ZONE                                              */
/*==============================================================*/
create table RF_ZONE  (
   RF_ZONE_COD          VARCHAR2(2)                     not null,
   RF_ZONE_LIB          VARCHAR2(10)                    not null,
   RF_ZONE_NBJO         NUMBER(3)                       not null,
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ZONE_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   RF_ZONE_LOC          VARCHAR2(1)
);

comment on table RF_ZONE is
'Zone';

comment on column RF_ZONE.RF_ZONE_COD is
'Code Zone';

comment on column RF_ZONE.RF_ZONE_LIB is
'Libelle Zone';

comment on column RF_ZONE.RF_ZONE_NBJO is
'Nombre Jours Ouvres Zone';

comment on column RF_ZONE.RF_XDMAJ is
'Date de Mise a Jour';

comment on column RF_ZONE.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

comment on column RF_ZONE.RF_ZONE_LOC is
'Localisation';

alter table RF_ZONE
   add constraint RF_ZONE_PK1_1 primary key (RF_ZONE_COD);

grant SELECT on RF_ZONE to PUBLIC;

grant REFERENCES on RF_ZONE to PUBLIC;

grant REFERENCES on RF_ZONE to PUBLIC;

grant SELECT on RF_ZONE to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ZONGRD                                            */
/*==============================================================*/
create table RF_ZONGRD  (
   RF_ZONE_COD          VARCHAR2(2)                     not null,
   RF_GRD_COD           VARCHAR2(6)                     not null,
   RF_ZONGRD_TJN        NUMBER(10,2),
   RF_ZONGRD_TAN        NUMBER(10,2),
   RF_ZONGRD_TJN1       NUMBER(10,2),
   RF_ZONGRD_TAN1       NUMBER(10,2),
   RF_XDMAJ             DATE                            not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ZONGRD_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ZONGRD is
'Cout d''un grade suivant la zone';

comment on column RF_ZONGRD.RF_ZONE_COD is
'Code Zone';

comment on column RF_ZONGRD.RF_GRD_COD is
'Code grade';

comment on column RF_ZONGRD.RF_ZONGRD_TJN is
'Taux journalier annee N';

comment on column RF_ZONGRD.RF_ZONGRD_TAN is
'Taux annuel annee N';

comment on column RF_ZONGRD.RF_ZONGRD_TJN1 is
'Taux journalier annee N+1';

comment on column RF_ZONGRD.RF_ZONGRD_TAN1 is
'Taux annuel annee N+1';

comment on column RF_ZONGRD.RF_XDMAJ is
'Date de mise a jour';

comment on column RF_ZONGRD.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ZONGRD
   add constraint RF_ZONGRD_PK2_1 primary key (RF_ZONE_COD, RF_GRD_COD);

/*==============================================================*/
/* Index : RF_ZONGRD_PK2_1                                      */
/*==============================================================*/
create unique index RF_ZONGRD_PK2_1 on RF_ZONGRD (
   RF_GRD_COD ASC,
   RF_ZONE_COD ASC
);

/*==============================================================*/
/* Index : RF_ZONGRD_FK1_1                                      */
/*==============================================================*/
create index RF_ZONGRD_FK1_1 on RF_ZONGRD (
   RF_ZONE_COD ASC
);

/*==============================================================*/
/* Index : RF_ZONGRD_FK1_2                                      */
/*==============================================================*/
create index RF_ZONGRD_FK1_2 on RF_ZONGRD (
   RF_GRD_COD ASC
);

grant SELECT on RF_ZONGRD to PUBLIC;

grant REFERENCES on RF_ZONGRD to PUBLIC;

grant REFERENCES on RF_ZONGRD to PUBLIC;

grant SELECT on RF_ZONGRD to REF_SEL_A_UTI;

/*==============================================================*/
/* Table : RF_ZONSIT                                            */
/*==============================================================*/
create table RF_ZONSIT  (
   RF_ZONSIT_ID         INTEGER                         not null,
   RF_ZONSIT_COD        VARCHAR2(1)                     not null,
   RF_ZONSIT_LIB        VARCHAR2(25)                    not null,
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_ZONSIT_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M'))
);

comment on table RF_ZONSIT is
'Zone de situation';

comment on column RF_ZONSIT.RF_ZONSIT_ID is
'Identifiant de la zone de situation';

comment on column RF_ZONSIT.RF_ZONSIT_COD is
'Code de la zone de situation';

comment on column RF_ZONSIT.RF_ZONSIT_LIB is
'Libelle de la zone de situation';

comment on column RF_ZONSIT.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_ZONSIT.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

alter table RF_ZONSIT
   add constraint RF_ZONSIT_PK1_1 primary key (RF_ZONSIT_ID);

/*==============================================================*/
/* Index : RF_ZONSIT_UN1_1                                      */
/*==============================================================*/
create unique index RF_ZONSIT_UN1_1 on RF_ZONSIT (
   RF_ZONSIT_COD ASC
);

grant SELECT on RF_ZONSIT to PUBLIC;

grant REFERENCES on RF_ZONSIT to PUBLIC;

grant REFERENCES on RF_ZONSIT to PUBLIC;

grant SELECT on RF_ZONSIT to REF_SEL_A_UTI;

alter table RF_ACTIVITE
   add constraint RF_ACTIVITE_FK1_1 foreign key (RF_CODMIN_ID)
      references RF_CODMIN (RF_CODMIN_ID);

alter table RF_ACTIVITE
   add constraint RF_ACTIVITE_FK1_2 foreign key (RF_PROG_ID)
      references RF_PROG (RF_PROG_ID);

alter table RF_ANT
   add constraint RF_ANT_FK1_1 foreign key (RF_BDD_ID)
      references RF_BDD (RF_BDD_ID);

alter table RF_ARE
   add constraint RF_ARE_FK1_1 foreign key (RF_AFFECT_ID)
      references RF_AFFECT (RF_AFFECT_ID);

alter table RF_ARME
   add constraint RF_ARME_FK1_1 foreign key (RF_ARMEE_ID)
      references RF_ARMEE (RF_ARMEE_ID);

alter table RF_BDD
   add constraint RF_BDD_FK1_1 foreign key (RF_ZD_ID)
      references RF_ZD (RF_ZD_ID);

alter table RF_BDD
   add constraint RF_BDD_FK1_2 foreign key (RF_ORGANISME_ID)
      references RF_ORGANISME (RF_ORGANISME_ID);

alter table RF_BOP
   add constraint RF_BOP_FK2_1 foreign key (RF_TETAD_COD, RF_IMPG_COD)
      references RF_IMPG (RF_TETAD_COD, RF_IMPG_COD);

alter table RF_CA
   add constraint RF_CA_FK1_1 foreign key (RF_TPYR_COD)
      references RF_TPYR (RF_TPYR_COD);

alter table RF_CA
   add constraint RF_CA_FK1_2 foreign key (RF_DEPT_ID)
      references RF_DEPT (RF_DEPT_ID);

alter table RF_CA
   add constraint RF_CA_FK1_3 foreign key (RF_PAYS_COD)
      references RF_PAYS (RF_PAYS_COD);

alter table RF_CCOU
   add constraint RF_CCOUD_FK1_1 foreign key (RF_STE_CHORUS_ID)
      references RF_STE_CHORUS (RF_STE_CHORUS_ID);

alter table RF_CCOU
   add constraint RF_CCOUD_FK1_2 foreign key (RF_DACT_ID)
      references RF_DACT (RF_DACT_ID);

alter table RF_CCOU
   add constraint RF_CCOU_FK1_3 foreign key (RF_CPFT_ID)
      references RF_CPFT (RF_CPFT_ID);

alter table RF_CDSTAT
   add constraint RF_CDSTAT_FK1_1 foreign key (RF_TSTAT_COD)
      references RF_TSTAT (RF_TSTAT_COD);

alter table RF_CDSTAT
   add constraint RF_CDSTAT_FK1_2 foreign key (RF_LIGMER_COD)
      references RF_LIGMER (RF_LIGMER_COD);

alter table RF_CDSTAT
   add constraint RF_CDSTAT_FK1_3 foreign key (RF_FCTN_COD)
      references RF_FCTN (RF_FCTN_COD);

alter table RF_CDSTAT
   add constraint RF_CDSTAT_FK1_4 foreign key (RF_TOPV_COD)
      references RF_TOPV (RF_TOPV_COD);

alter table RF_CFIN
   add constraint RF_CFIN_FK1_1 foreign key (RF_PROG_ID)
      references RF_PROG (RF_PROG_ID);

alter table RF_CFIN
   add constraint RF_CFIN_FK1_2 foreign key (RF_BOP_ID)
      references RF_BOP_CH (RF_BOP_ID);

alter table RF_COEFFENT
   add constraint RF_COEFFENT_FK1_1 foreign key (RF_ETATENT_ID)
      references RF_ETATENT (RF_ETATENT_ID);

alter table RF_COMIMP
   add constraint RF_COMIMP_FK1_1 foreign key (RF_IMMEUBLE_ID)
      references RF_IMMEUBLE (RF_IMMEUBLE_ID);

alter table RF_COMM
   add constraint RF_COMM_FK1_1 foreign key (RF_DEPT_ID)
      references RF_DEPT (RF_DEPT_ID);

alter table RF_COMMCP
   add constraint RF_COMMCP_FK1_1 foreign key (RF_COMM_ID)
      references RF_COMM (RF_COMM_ID);

alter table RF_COMMCP
   add constraint RF_COMMCP_FK1_2 foreign key (RF_CP_ID)
      references RF_CP (RF_CP_ID);

alter table RF_CORGRD
   add constraint RF_CORGRD_FK1_1 foreign key (RF_GRD_COD)
      references RF_GRD (RF_GRD_COD);

alter table RF_CORGRD
   add constraint RF_CORGRD_FK1_2 foreign key (RF_CORPS_ID)
      references RF_CORPS (RF_CORPS_ID);

alter table RF_CORPS
   add constraint RF_CORPS_FK1_1 foreign key (RF_ARMEE_ID)
      references RF_ARMEE (RF_ARMEE_ID);

alter table RF_CPT
   add constraint RF_CPT_FK1_1 foreign key (RF_IMMEUBLE_ID)
      references RF_IMMEUBLE (RF_IMMEUBLE_ID);

alter table RF_CPT
   add constraint RF_CPT_FK1_3 foreign key (RF_COMIMP_ID)
      references RF_COMIMP (RF_COMIMP_ID);

alter table RF_CPTCOM
   add constraint RF_CPTCOM_FK1_1 foreign key (RF_CDMB_COD)
      references RF_CDMB (RF_CDMB_COD);

alter table RF_CPYR
   add constraint RF_CPYR_FK1_1 foreign key (RF_TPERS_ID)
      references RF_TPERS (RF_TPERS_ID);

alter table RF_CTGRD
   add constraint RF_CTGRD_FK1_1 foreign key (RF_CDSTAT_COD)
      references RF_CDSTAT (RF_CDSTAT_COD);

alter table RF_CTSTORCOR
   add constraint RF_CTSTORCOR_FK1_1 foreign key (RF_CTGRD_COD)
      references RF_CTGRD (RF_CTGRD_COD);

alter table RF_CTSTORCOR
   add constraint RF_CTSTORCOR_FK1_2 foreign key (RF_ORDRE_ID)
      references RF_ORDRE (RF_ORDRE_ID);

alter table RF_CTSTORCOR
   add constraint RF_CTSTORCOR_FK1_3 foreign key (RF_STATUT_ID)
      references RF_STATUT (RF_STATUT_ID);

alter table RF_CTSTORCOR
   add constraint RF_CTSTORCOR_FK1_4 foreign key (RF_CORPS_ID)
      references RF_CORPS (RF_CORPS_ID);

alter table RF_CTUTIL
   add constraint RF_CTUTIL_FK1_1 foreign key (RF_IMMCLAUTIL_ID)
      references RF_IMMCLAUTIL (RF_IMMCLAUTIL_ID);

alter table RF_DEPT
   add constraint RF_DEPT_FK1_1 foreign key (RF_CMD_COD)
      references RF_CMD (RF_CMD_COD);

alter table RF_DEPT
   add constraint RF_DEPT_FK1_2 foreign key (RF_REG_RA_ID)
      references RF_REG (RF_REG_ID);

alter table RF_DEPT
   add constraint RF_DEPT_FK1_3 foreign key (RF_REG_RM_ID)
      references RF_REG (RF_REG_ID);

alter table RF_DEPT
   add constraint RF_DEPT_FK1_4 foreign key (RF_REG_GND_ID)
      references RF_REG (RF_REG_ID);

alter table RF_DEPT
   add constraint RF_DEPT_FK1_5 foreign key (RF_REG_RT_ID)
      references RF_REG (RF_REG_ID);

alter table RF_DEPT
   add constraint RF_DEPT_FK1_6 foreign key (RF_REGECO_ID)
      references RF_REGECO (RF_REGECO_ID);

alter table RF_DEVPAY
   add constraint RF_DEVPAY_FK1_1 foreign key (RF_PAYS_COD)
      references RF_PAYS (RF_PAYS_COD);

alter table RF_DEVPAY
   add constraint RF_DEVPAY_FK1_2 foreign key (RF_DEVI_COD)
      references RF_DEVI (RF_DEVI_COD);

alter table RF_DIPHDEF
   add constraint RF_DIPHDEF_FK1_1 foreign key (RF_HOMOLDIP_ID)
      references RF_HOMOLDIP (RF_HOMOLDIP_ID);

alter table RF_DIPTTA
   add constraint RF_DIPTTA_FK1_1 foreign key (RF_HOMOLDIP_ID)
      references RF_HOMOLDIP (RF_HOMOLDIP_ID);

alter table RF_DIVI
   add constraint RF_DIVI_FK1_1 foreign key (RF_OACH_ID)
      references RF_OACH (RF_OACH_ID);

alter table RF_DIVI
   add constraint RF_DIVI_FK1_2 foreign key (RF_STE_CHORUS_ID)
      references RF_STE_CHORUS (RF_STE_CHORUS_ID);

alter table RF_DOMFONC
   add constraint RF_DOMFONC_FK1_1 foreign key (RF_PROG_ID)
      references RF_PROG (RF_PROG_ID);

alter table RF_ENGCENGJ
   add constraint RF_ENGCENGJ_FK1_1 foreign key (RF_TENGC_COD)
      references RF_TENGC (RF_TENGC_COD);

alter table RF_ENGCENGJ
   add constraint RF_ENGCENGJ_FK1_2 foreign key (RF_TMVT_COD)
      references RF_TMVT (RF_TMVT_COD);

alter table RF_FCTRPR
   add constraint RF_FCTRPR_FK1_1 foreign key (RF_TRAN_COD)
      references RF_TRAN (RF_TRAN_COD);

alter table RF_FCTRPR
   add constraint RF_FCTRPR_FK1_2 foreign key (RF_PROD_COD)
      references RF_PROD (RF_PROD_COD);

alter table RF_FCTRPR
   add constraint RF_FCTRPR_FK1_3 foreign key (RF_FCTN_COD)
      references RF_FCTN (RF_FCTN_COD);

alter table RF_FCTSITE
   add constraint RF_FCTSITE_FK1_1 foreign key (RF_CTUTIL_ID)
      references RF_CTUTIL (RF_CTUTIL_ID);

alter table RF_FCTTTA
   add constraint RF_FCTTTA_FK1_1 foreign key (RF_DOMTTA_ID)
      references RF_DOMTTA (RF_DOMTTA_ID);

alter table RF_FCTTTA
   add constraint RF_FCTTTA_FK1_2 foreign key (RF_HOMOLDIP_ID)
      references RF_HOMOLDIP (RF_HOMOLDIP_ID);

alter table RF_FCTTTA
   add constraint RF_FCTTTA_FK1_3 foreign key (RF_ORDRE_ID)
      references RF_ORDRE (RF_ORDRE_ID);

alter table RF_FIMO
   add constraint RF_FIMO_FK1_2 foreign key (RF_CCOU_ID)
      references RF_CCOU (RF_CCOU_ID);

alter table RF_FIMO
   add constraint RF_FIMO_FK1_1 foreign key (RF_CIMO_ID)
      references RF_CIMO (RF_CIMO_ID);

alter table RF_FIMO
   add constraint RF_FIMO_FK1_4 foreign key (RF_DACT_ID)
      references RF_DACT (RF_DACT_ID);

alter table RF_FIMO
   add constraint RF_FIMO_FK1_7 foreign key (RF_FOND_ID)
      references RF_FOND (RF_FOND_ID);

alter table RF_FIMO
   add constraint RF_FIMO_FK1_3 foreign key (RF_CFIN_ID)
      references RF_CFIN (RF_CFIN_ID);

alter table RF_FIMO
   add constraint RF_FIMO_FK1_5 foreign key (RF_DFON_ID)
      references RF_DFON (RF_DFON_ID);

alter table RF_FIMO
   add constraint RF_FIMO_FK1_6 foreign key (RF_EOTP_ID)
      references RF_EOTP (RF_EOTP_ID);

alter table RF_FIMO
   add constraint RF_FIMO_FK1_8 foreign key (RF_STE_CHORUS_ID)
      references RF_STE_CHORUS (RF_STE_CHORUS_ID);

alter table RF_FORM
   add constraint RF_FORM_FK1_1 foreign key (RF_FORM_COD_REF)
      references RF_FORM (RF_FORM_COD);

alter table RF_GCD
   add constraint RF_GCD_FK1_1 foreign key (RF_GCC_COD)
      references RF_GCC (RF_GCC_COD);

alter table RF_GRD
   add constraint RF_GRD_FK1_1 foreign key (RF_CTGRD_COD)
      references RF_CTGRD (RF_CTGRD_COD);

alter table RF_GRDECH
   add constraint RF_GRDECH_FK1_1 foreign key (RF_GRD_COD)
      references RF_GRD (RF_GRD_COD);

alter table RF_GRDECH
   add constraint RF_GRDECH_FK1_2 foreign key (RF_ECHELON_ID)
      references RF_ECHELON (RF_ECHELON_ID);

alter table RF_GRIM
   add constraint RF_GRIM_FK1_1 foreign key (RF_ORGANISME_ID)
      references RF_ORGANISME (RF_ORGANISME_ID);

alter table RF_IMM
   add constraint RF_IMM_FK1_1 foreign key (RF_ORGEN_CODETN)
      references RF_ORGEN (RF_ORGEN_CODETN);

alter table RF_IMM
   add constraint RF_IMM_FK1_2 foreign key (RF_ORGEN_CODETN_COMP)
      references RF_ORGEN (RF_ORGEN_CODETN);

alter table RF_IMM
   add constraint FK_RF_IMM_RF_IMM_FK_RF_IMMIN foreign key (RF_IMMIND_ID)
      references RF_IMMIND (RF_IMMIND_ID);

alter table RF_IMM
   add constraint FK_RF_IMM_RF_IMM_FK_RF_ORGAN foreign key (RF_ORGANISME_ID)
      references RF_ORGANISME (RF_ORGANISME_ID);

alter table RF_IMMEUBLE
   add constraint RF_IMMEUBLE_FK1_1 foreign key (RF_NATVOI_ID)
      references RF_NATVOI (RF_NATVOI_ID);

alter table RF_IMMEUBLE
   add constraint RF_IMMEUBLE_FK1_2 foreign key (RF_ORGANISME_ID)
      references RF_ORGANISME (RF_ORGANISME_ID);

alter table RF_IMMEUBLE
   add constraint RF_IMMEUBLE_FK1_3 foreign key (RF_COMMADR_ID)
      references RF_COMM (RF_COMM_ID);

alter table RF_IMMEUBLE
   add constraint RF_IMMEUBLE_FK1_4 foreign key (RF_COMMGAR_ID)
      references RF_COMM (RF_COMM_ID);

alter table RF_IMPE
   add constraint RF_IMPE_FK2_1 foreign key (RF_TETAD_COD, RF_IMPG_COD)
      references RF_IMPG (RF_TETAD_COD, RF_IMPG_COD);

alter table RF_IMPE_NG
   add constraint RF_IMPE_NG_FK1_1 foreign key (RF_IMPG_ID)
      references RF_IMPG_NG (RF_IMPG_ID);

alter table RF_IMPG
   add constraint RF_IMPG_FK1_1 foreign key (RF_TITR_COD)
      references RF_TITR (RF_TITR_COD);

alter table RF_IMPG
   add constraint RF_IMPG_FK1_2 foreign key (RF_TIMPN_COD)
      references RF_TIMPN (RF_TIMPN_COD);

alter table RF_IMPG
   add constraint RF_IMPG_FK1_3 foreign key (RF_GCC_COD)
      references RF_GCC (RF_GCC_COD);

alter table RF_IMPG
   add constraint RF_IMPG_FK1_4 foreign key (RF_CDMB_COD)
      references RF_CDMB (RF_CDMB_COD);

alter table RF_IMPG
   add constraint RF_IMPG_FK1_5 foreign key (RF_SGC_COD)
      references RF_SGC (RF_SGC_COD);

alter table RF_IMPG
   add constraint RF_IMPG_FK1_6 foreign key (RF_TPYR_COD)
      references RF_TPYR (RF_TPYR_COD);

alter table RF_IMPG
   add constraint RF_IMPG_FK1_7 foreign key (RF_TETAD_COD)
      references RF_TETAD (RF_TETAD_COD);

alter table RF_IMPG
   add constraint RF_IMPG_FK1_8 foreign key (RF_CPTCOM_COD)
      references RF_CPTCOM (RF_CPTCOM_COD);

alter table RF_IMPG_NG
   add constraint RF_IMPG_NG_FK1_1 foreign key (RF_TITR_COD)
      references RF_TITR (RF_TITR_COD);

alter table RF_IMPG_NG
   add constraint RF_IMPG_NG_FK1_2 foreign key (RF_TIMPN_COD)
      references RF_TIMPN (RF_TIMPN_COD);

alter table RF_IMPG_NG
   add constraint RF_IMPG_NG_FK1_3 foreign key (RF_GCC_ID)
      references RF_GCC_NG (RF_GCC_ID);

alter table RF_IMPG_NG
   add constraint RF_IMPG_NG_FK1_4 foreign key (RF_CDMB_COD)
      references RF_CDMB (RF_CDMB_COD);

alter table RF_IMPG_NG
   add constraint RF_IMPG_NG_FK1_5 foreign key (RF_SGC_COD)
      references RF_SGC (RF_SGC_COD);

alter table RF_IMPG_NG
   add constraint RF_IMPG_NG_FK1_6 foreign key (RF_TPYR_COD)
      references RF_TPYR (RF_TPYR_COD);

alter table RF_IMPG_NG
   add constraint RF_IMPG_NG_FK1_7 foreign key (RF_TETAD_COD)
      references RF_TETAD (RF_TETAD_COD);

alter table RF_IMPG_NG
   add constraint RF_IMPG_NG_FK1_8 foreign key (RF_CPTCOM_COD)
      references RF_CPTCOM (RF_CPTCOM_COD);

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key (RF_LCLCATUTIL_ID)
      references RF_LCLCATUTIL (RF_LCLCATUTIL_ID);

alter table RF_LIGMER
   add constraint RF_LIGMER_FK1_1 foreign key (RF_TLIG_COD)
      references RF_TLIG (RF_TLIG_COD);

alter table RF_MACCES
   add constraint RF_MACCES_FK1_1 foreign key (RF_TACCES_ID)
      references RF_TACCES (RF_TACCES_ID);

alter table RF_MACCOR
   add constraint RF_MACCOR_FK1_1 foreign key (RF_MACCES_ID)
      references RF_MACCES (RF_MACCES_ID);

alter table RF_MACCOR
   add constraint RF_MACCOR_FK1_2 foreign key (RF_CORPS_ID)
      references RF_CORPS (RF_CORPS_ID);

alter table RF_MACGRD
   add constraint RF_MACGRD_FK1_1 foreign key (RF_MACCES_ID)
      references RF_MACCES (RF_MACCES_ID);

alter table RF_MACGRD
   add constraint RF_MACGRD_FK1_2 foreign key (RF_GRD_COD)
      references RF_GRD (RF_GRD_COD);

alter table RF_MAJ
   add constraint RF_MAJ_FK1_1 foreign key (RF_RTORG_ID)
      references RF_RTORG (RF_RTORG_ID);

alter table RF_MAJ
   add constraint RF_MAJ_FK1_2 foreign key (RF_GES_ID)
      references RF_GES (RF_GES_ID);

alter table RF_MVTMVT
   add constraint RF_MVTMVT_FK1_1 foreign key (RF_TMVT_COD_COMP)
      references RF_TMVT (RF_TMVT_COD);

alter table RF_MVTMVT
   add constraint RF_MVTMVT_FK1_2 foreign key (RF_TMVT_COD)
      references RF_TMVT (RF_TMVT_COD);

alter table RF_NOMENCPROD
   add constraint RF_NOMENCPROD_FK1_1 foreign key (RF_TACHAT_COD)
      references RF_TACHAT (RF_TACHAT_COD);

alter table RF_NRCTGRD
   add constraint RF_NRCTGRD_FK1_1 foreign key (RF_NIVRESP_ID)
      references RF_NIVRESP (RF_NIVRESP_ID);

alter table RF_NRCTGRD
   add constraint RF_NRCTGRD_FK1_2 foreign key (RF_CTGRD_COD)
      references RF_CTGRD (RF_CTGRD_COD);

alter table RF_NTTR
   add constraint RF_NTTR_FK1_1 foreign key (RF_LIGMER_COD)
      references RF_LIGMER (RF_LIGMER_COD);

alter table RF_NTTR
   add constraint RF_NTTR_FK1_2 foreign key (RF_PROD_COD)
      references RF_PROD (RF_PROD_COD);

alter table RF_NTTR_STGPE
   add constraint RF_NTTR_STGPE_FK1_1 foreign key (RF_NTTR_COD)
      references RF_NTTR (RF_NTTR_COD);

alter table RF_OBI
   add constraint RF_OBI_FK1_2 foreign key (RF_CTOB_COD)
      references RF_CTOB (RF_CTOB_COD);

alter table RF_OBI
   add constraint RF_OBI_FK1_3 foreign key (RF_CNOP_ID)
      references RF_CNOP (RF_CNOP_ID);

alter table RF_OBI
   add constraint RF_OBI_FK2_1 foreign key (RF_TETAD_COD, RF_IMPG_COD)
      references RF_IMPG (RF_TETAD_COD, RF_IMPG_COD);

alter table RF_OBI_NG
   add constraint RF_OBI_NG_FK1_1 foreign key (RF_IMPG_ID)
      references RF_IMPG_NG (RF_IMPG_ID);

alter table RF_OBI_NG
   add constraint RF_OBI_NG_FK1_2 foreign key (RF_CTOB_COD)
      references RF_CTOB (RF_CTOB_COD);

alter table RF_OBI_NG
   add constraint RF_OBI_NG_FK1_3 foreign key (RF_CNOP_ID)
      references RF_CNOP (RF_CNOP_ID);

alter table RF_ORDS
   add constraint RF_ORDS_FK1_1 foreign key (RF_ORGEN_CODETN)
      references RF_ORGEN (RF_ORGEN_CODETN);

alter table RF_ORDS
   add constraint RF_ORDS_FK1_2 foreign key (RF_CA_COD)
      references RF_CA (RF_CA_COD);

alter table RF_ORGANISME
   add constraint RF_ORGANISME_FK1_1 foreign key (RF_ORGANISME_PERE_ID)
      references RF_ORGANISME (RF_ORGANISME_ID);

alter table RF_ORGANISME
   add constraint RF_ORGANISME_FK1_2 foreign key (RF_COMMCP_ID)
      references RF_COMMCP (RF_COMMCP_ID);

alter table RF_ORGANISME
   add constraint RF_ORGANISME_FK1_3 foreign key (RF_TORG_COD)
      references RF_TORG (RF_TORG_COD);

alter table RF_ORGANISMEARMEE
   add constraint RF_ORGANISMEARMEE_FK1_1 foreign key (RF_ORGANISME_ID)
      references RF_ORGANISME (RF_ORGANISME_ID);

alter table RF_ORGANISMEARMEE
   add constraint RF_ORGANISMEARMEE_FK1_2 foreign key (RF_ARMEE_ID)
      references RF_ARMEE (RF_ARMEE_ID);

alter table RF_ORGEN
   add constraint RF_ORGEN_FK1_1 foreign key (RF_ORGEN_CODETN_REF)
      references RF_ORGEN (RF_ORGEN_CODETN);

alter table RF_ORGEN
   add constraint RF_ORGEN_FK1_2 foreign key (RF_FORM_COD)
      references RF_FORM (RF_FORM_COD);

alter table RF_ORGEN
   add constraint RF_ORGEN_FK1_3 foreign key (RF_ZONE_COD)
      references RF_ZONE (RF_ZONE_COD);

alter table RF_ORGEN
   add constraint RF_ORGEN_FK1_4 foreign key (RF_TORG_COD)
      references RF_TORG (RF_TORG_COD);

alter table RF_ORGEN
   add constraint RF_ORGEN_FK1_6 foreign key (RF_CMD_COD)
      references RF_CMD (RF_CMD_COD);

alter table RF_ORGEN
   add constraint RF_ORGEN_FK1_7 foreign key (RF_MAJ_ID)
      references RF_MAJ (RF_MAJ_ID);

alter table RF_ORGEN
   add constraint RF_ORGEN_FK2_5 foreign key (RF_REG_ID)
      references RF_REG (RF_REG_ID);

alter table RF_ORIDRO
   add constraint RF_ORIDRO_FK1_1 foreign key (RF_CATORIDRO_ID)
      references RF_CATORIDRO (RF_CATORIDRO_ID);

alter table RF_PARAG
   add constraint RF_PARAG_FK1_1 foreign key (RF_IMPE_COD)
      references RF_IMPE (RF_IMPE_COD);

alter table RF_POSSTAT
   add constraint RF_POSSTAT_FK1_1 foreign key (RF_TPERS_ID)
      references RF_TPERS (RF_TPERS_ID);

alter table RF_POSTPS
   add constraint RF_POSTPS_FK1_1 foreign key (RF_POSSTAT_ID)
      references RF_POSSTAT (RF_POSSTAT_ID);

alter table RF_POSTPS
   add constraint RF_POSTPS_FK1_2 foreign key (RF_TPSTRAV_ID)
      references RF_TPSTRAV (RF_TPSTRAV_ID);

alter table RF_PROD
   add constraint RF_PROD_FK1_1 foreign key (RF_LIGMER_COD)
      references RF_LIGMER (RF_LIGMER_COD);

alter table RF_PROD
   add constraint RF_PROD_FK1_2 foreign key (RF_ACVT_COD)
      references RF_ACVT (RF_ACVT_COD);

alter table RF_PROPRICPT
   add constraint RF_PROPRICPT_FK1_1 foreign key (RF_TPRO_ID)
      references RF_TPRO (RF_TPRO_ID);

alter table RF_RATFIS
   add constraint RF_RATFIS_FK1_1 foreign key (RF_DEPT_ID)
      references RF_DEPT (RF_DEPT_ID);

alter table RF_REG
   add constraint RF_REG_FK1_1 foreign key (RF_TREG_COD)
      references RF_TREG (RF_TREG_COD);

alter table RF_REGDPT
   add constraint RF_REGDPT_FK1_1 foreign key (RF_DEPT_ID)
      references RF_DEPT (RF_DEPT_ID);

alter table RF_REGDPT
   add constraint RF_REGDPT_FK1_2 foreign key (RF_REG_ID)
      references RF_REG (RF_REG_ID);

alter table RF_REGECO
   add constraint RF_REGECO_FK1_1 foreign key (RF_STE_CHORUS_ID)
      references RF_STE_CHORUS (RF_STE_CHORUS_ID);

alter table RF_REGION
   add constraint RF_REGION_FK1_1 foreign key (RF_PAYS_ID)
      references RF_PAYS_NG (RF_PAYS_ID);

alter table RF_REGSTAT
   add constraint RF_REGSTAT_FK1_1 foreign key (RF_STATUT_ID)
      references RF_STATUT (RF_STATUT_ID);

alter table RF_SB
   add constraint RF_SB_FK1_1 foreign key (RF_ORGRAT_ID)
      references RF_ORGRAT (RF_ORGRAT_ID);

alter table RF_SB
   add constraint RF_SB_FK1_2 foreign key (RF_CODMIN_ID)
      references RF_CODMIN (RF_CODMIN_ID);

alter table RF_SCTUTIL
   add constraint RF_SCTUTIL_FK1_1 foreign key (RF_CTUTIL_ID)
      references RF_CTUTIL (RF_CTUTIL_ID);

alter table RF_SE
   add constraint RF_SE_FK1_1 foreign key (RF_ORGRAT_ID)
      references RF_ORGRAT (RF_ORGRAT_ID);

alter table RF_SE
   add constraint RF_SE_FK1_2 foreign key (RF_CODMIN_ID)
      references RF_CODMIN (RF_CODMIN_ID);

alter table RF_SFCT
   add constraint RF_SFCT_FK1_1 foreign key (RF_ZFCT_ID)
      references RF_ZFCT (RF_ZFCT_ID);

alter table RF_SFCTCLAUTIL
   add constraint RF_SFCTCLAUTIL_FK1_1 foreign key (RF_SFCTCPT_ID)
      references RF_SFCTCPT (RF_SFCTCPT_ID);

alter table RF_SFCTCLAUTIL
   add constraint RF_SFCTCLAUTIL_FK1_2 foreign key (RF_LCLCLAUTIL_ID)
      references RF_LCLCLAUTIL (RF_LCLCLAUTIL_ID);

alter table RF_SFCTCPT
   add constraint RF_SFCTCPT_FK1_1 foreign key (RF_FCTCPT_ID)
      references RF_FCTCPT (RF_FCTCPT_ID);

alter table RF_SOBI
   add constraint RF_SOBI_FK3_1 foreign key (RF_TETAD_COD, RF_IMPG_COD, RF_OBI_COD)
      references RF_OBI (RF_TETAD_COD, RF_IMPG_COD, RF_OBI_COD);

alter table RF_STATRA
   add constraint RF_STATRA_FK1_1 foreign key (RF_CDSTAT_COD)
      references RF_CDSTAT (RF_CDSTAT_COD);

alter table RF_STATRA
   add constraint RF_STATRA_FK1_2 foreign key (RF_NTTR_COD)
      references RF_NTTR (RF_NTTR_COD);

alter table RF_STATUT
   add constraint RF_STATUT_FK1_1 foreign key (RF_TPERS_ID)
      references RF_TPERS (RF_TPERS_ID);

alter table RF_STRC
   add constraint RF_STRC_FK1_1 foreign key (RF_TORG_COD)
      references RF_TORG (RF_TORG_COD);

alter table RF_STRC
   add constraint RF_STRC_FK1_2 foreign key (RF_CODNIV_COD)
      references RF_CODNIV (RF_CODNIV_COD);

alter table RF_STRC
   add constraint RF_STRC_FK1_3 foreign key (RF_TINDIC_ID)
      references RF_TINDIC (RF_TINDIC_ID);

alter table RF_TACHAT
   add constraint RF_TACHAT_FK1_1 foreign key (RF_CTACHAT_COD)
      references RF_CTACHAT (RF_CTACHAT_COD);

alter table RF_TDEL
   add constraint RF_TDEL_FK1_1 foreign key (RF_CTOB_COD)
      references RF_CTOB (RF_CTOB_COD);

alter table RF_TDOCTOPEDOM
   add constraint RF_TDOCTOPEDOM_FK1_1 foreign key (RF_TOPEDOM_ID)
      references RF_TOPEDOM (RF_TOPEDOM_ID);

alter table RF_TDOCTOPEDOM
   add constraint RF_TDOCTOPEDOM_FK1_2 foreign key (RF_TDOC_ID)
      references RF_TDOC (RF_TDOC_ID);

alter table RF_TF
   add constraint RF_TF_FK1_1 foreign key (RF_TTF_ID)
      references RF_TTF (RF_TTF_ID);

alter table RF_TF
   add constraint RF_TF_FK1_2 foreign key (RF_UO_ID)
      references RF_UO (RF_UO_ID);

alter table RF_TFON
   add constraint RF_TFON_FK1_1 foreign key (RF_CFIN_ID)
      references RF_CFIN (RF_CFIN_ID);

alter table RF_TMAN
   add constraint RF_TMAN_FK1_1 foreign key (RF_INDM_COD)
      references RF_INDM (RF_INDM_COD);

alter table RF_TMVT
   add constraint RF_TMVT_FK1_1 foreign key (RF_TMVT_COD_REF2)
      references RF_TMVT (RF_TMVT_COD);

alter table RF_TMVT
   add constraint RF_TMVT_FK1_2 foreign key (RF_INDM_COD)
      references RF_INDM (RF_INDM_COD);

alter table RF_TMVT
   add constraint RF_TMVT_FK1_3 foreign key (RF_TMVT_COD_REF1)
      references RF_TMVT (RF_TMVT_COD);

alter table RF_TOUV
   add constraint RF_TOUV_FK1_1 foreign key (RF_SFCT_ID)
      references RF_SFCT (RF_SFCT_ID);

alter table RF_TOUV
   add constraint RF_TOUV_FK1_2 foreign key (RF_CPTCLAUTIL_ID)
      references RF_CPTCLAUTIL (RF_CPTCLAUTIL_ID);

alter table RF_TPOP
   add constraint RF_TPOP_FK1_1 foreign key (RF_TPERS_ID)
      references RF_TPERS (RF_TPERS_ID);

alter table RF_TPRE
   add constraint RF_TPRE_FK1_1 foreign key (RF_FCTN_COD)
      references RF_FCTN (RF_FCTN_COD);

alter table RF_TPSTRAV
   add constraint RF_TPSTRAV_FK1_1 foreign key (RF_TPERS_ID)
      references RF_TPERS (RF_TPERS_ID);

alter table RF_TVA
   add constraint RF_TVA_FK1_1 foreign key (RF_PAYS_COD)
      references RF_PAYS (RF_PAYS_COD);

alter table RF_TVA_NG
   add constraint RF_TVA_NG_FK1_1 foreign key (RF_PAYS_ID)
      references RF_PAYS_NG (RF_PAYS_ID);

alter table RF_UO
   add constraint RF_UO_FK1_3 foreign key (RF_CODMIN_ID)
      references RF_CODMIN (RF_CODMIN_ID);

alter table RF_UO
   add constraint RF_UO_FK1_4 foreign key (RF_BOP_ID)
      references RF_BOP (RF_BOP_ID);

alter table RF_UO
   add constraint RF_UO_FK1_5 foreign key (RF_PROG_ID)
      references RF_PROG (RF_PROG_ID);

alter table RF_ZONGRD
   add constraint RF_ZONGRD_FK1_1 foreign key (RF_ZONE_COD)
      references RF_ZONE (RF_ZONE_COD);

alter table RF_ZONGRD
   add constraint RF_ZONGRD_FK1_2 foreign key (RF_GRD_COD)
      references RF_GRD (RF_GRD_COD);

/*==============================================================*/
/* Synonyme : RF_ACTI                                           */
/*==============================================================*/
create or replace public synonym RF_ACTI for RF_ACTI;

/*==============================================================*/
/* Synonyme : RF_ACTIVITE                                       */
/*==============================================================*/
create or replace public synonym RF_ACTIVITE for RF_ACTIVITE;

/*==============================================================*/
/* Synonyme : RF_ACVT                                           */
/*==============================================================*/
create or replace public synonym RF_ACVT for RF_ACVT;

/*==============================================================*/
/* Synonyme : RF_AFFAERO                                        */
/*==============================================================*/
create or replace public synonym RF_AFFAERO for RF_AFFAERO;

/*==============================================================*/
/* Synonyme : RF_AFFECT                                         */
/*==============================================================*/
create or replace public synonym RF_AFFECT for RF_AFFECT;

/*==============================================================*/
/* Synonyme : RF_AFFSJCT                                        */
/*==============================================================*/
create or replace public synonym RF_AFFSJCT for RF_AFFSJCT;

/*==============================================================*/
/* Synonyme : RF_ANGE                                           */
/*==============================================================*/
create or replace public synonym RF_ANGE for RF_ANGE;

/*==============================================================*/
/* Synonyme : RF_ANT                                            */
/*==============================================================*/
create or replace public synonym RF_ANT for RF_ANT;

/*==============================================================*/
/* Synonyme : RF_APE                                            */
/*==============================================================*/
create or replace public synonym RF_APE for RF_APE;

/*==============================================================*/
/* Synonyme : RF_ARE                                            */
/*==============================================================*/
create or replace public synonym RF_ARE for RF_ARE;

/*==============================================================*/
/* Synonyme : RF_ARME                                           */
/*==============================================================*/
create or replace public synonym RF_ARME for RF_ARME;

/*==============================================================*/
/* Synonyme : RF_ARMEE                                          */
/*==============================================================*/
create or replace public synonym RF_ARMEE for RF_ARMEE;

/*==============================================================*/
/* Synonyme : RF_AVANC                                          */
/*==============================================================*/
create or replace public synonym RF_AVANC for RF_AVANC;

/*==============================================================*/
/* Synonyme : RF_AXE1                                           */
/*==============================================================*/
create or replace public synonym RF_AXE1 for RF_AXE1;

/*==============================================================*/
/* Synonyme : RF_BASE                                           */
/*==============================================================*/
create or replace public synonym RF_BASE for RF_BASE;

/*==============================================================*/
/* Synonyme : RF_BDD                                            */
/*==============================================================*/
create or replace public synonym RF_BDD for RF_BDD;

/*==============================================================*/
/* Synonyme : RF_BENAMO                                         */
/*==============================================================*/
create or replace public synonym RF_BENAMO for RF_BENAMO;

/*==============================================================*/
/* Synonyme : RF_BOP                                            */
/*==============================================================*/
create or replace public synonym RF_BOP for RF_BOP;

/*==============================================================*/
/* Synonyme : RF_BOP_CH                                         */
/*==============================================================*/
create or replace public synonym RF_BOP_CH for RF_BOP_CH;

/*==============================================================*/
/* Synonyme : RF_CA                                             */
/*==============================================================*/
create or replace public synonym RF_CA for RF_CA;

/*==============================================================*/
/* Synonyme : RF_CAL                                            */
/*==============================================================*/
create or replace public synonym RF_CAL for RF_CAL;

/*==============================================================*/
/* Synonyme : RF_CATDEP                                         */
/*==============================================================*/
create or replace public synonym RF_CATDEP for RF_CATDEP;

/*==============================================================*/
/* Synonyme : RF_CATORIDRO                                      */
/*==============================================================*/
create or replace public synonym RF_CATORIDRO for RF_CATORIDRO;

/*==============================================================*/
/* Synonyme : RF_CBUDD                                          */
/*==============================================================*/
create or replace public synonym RF_CBUDD for RF_CBUD;

/*==============================================================*/
/* Synonyme : RF_CCOU                                           */
/*==============================================================*/
create or replace public synonym RF_CCOU for RF_CCOU;

/*==============================================================*/
/* Synonyme : RF_CDMB                                           */
/*==============================================================*/
create or replace public synonym RF_CDMB for RF_CDMB;

/*==============================================================*/
/* Synonyme : RF_CDSTAT                                         */
/*==============================================================*/
create or replace public synonym RF_CDSTAT for RF_CDSTAT;

/*==============================================================*/
/* Synonyme : RF_CIMO                                           */
/*==============================================================*/
create or replace public synonym RF_CIMO for RF_CIMO;

/*==============================================================*/
/* Synonyme : RF_CLAUTIL                                        */
/*==============================================================*/
create or replace public synonym RF_CLAUTIL for RF_CLAUTIL;

/*==============================================================*/
/* Synonyme : RF_CMD                                            */
/*==============================================================*/
create or replace public synonym RF_CMD for RF_CMD;

/*==============================================================*/
/* Synonyme : RF_CNOP                                           */
/*==============================================================*/
create or replace public synonym RF_CNOP for RF_CNOP;

/*==============================================================*/
/* Synonyme : RF_CODMIN                                         */
/*==============================================================*/
create or replace public synonym RF_CODMIN for RF_CODMIN;

/*==============================================================*/
/* Synonyme : RF_CODNIV                                         */
/*==============================================================*/
create or replace public synonym RF_CODNIV for RF_CODNIV;

/*==============================================================*/
/* Synonyme : RF_COEFFENT                                       */
/*==============================================================*/
create or replace public synonym RF_COEFFENT for RF_COEFFENT;

/*==============================================================*/
/* Synonyme : RF_COMIMP                                         */
/*==============================================================*/
create or replace public synonym RF_COMIMP for RF_COMIMP;

/*==============================================================*/
/* Synonyme : RF_COMM                                           */
/*==============================================================*/
create or replace public synonym RF_COMM for RF_COMM;

/*==============================================================*/
/* Synonyme : RF_COMMCP                                         */
/*==============================================================*/
create or replace public synonym RF_COMMCP for RF_COMMCP;

/*==============================================================*/
/* Synonyme : RF_CONTRAT_TYP                                    */
/*==============================================================*/
create or replace public synonym RF_CONTRAT_TYP for RF_CONTRAT_TYP;

/*==============================================================*/
/* Synonyme : RF_CORCTORD                                       */
/*==============================================================*/
create or replace public synonym RF_CORCTORD for RF_CORCTORD;

/*==============================================================*/
/* Synonyme : RF_CORCTORDSTAT                                   */
/*==============================================================*/
create or replace public synonym RF_CORCTORDSTAT for RF_CORCTORDSTAT;

/*==============================================================*/
/* Synonyme : RF_CORGRD                                         */
/*==============================================================*/
create or replace public synonym RF_CORGRD for RF_CORGRD;

/*==============================================================*/
/* Synonyme : RF_CORPS                                          */
/*==============================================================*/
create or replace public synonym RF_CORPS for RF_CORPS;

/*==============================================================*/
/* Synonyme : RF_CP                                             */
/*==============================================================*/
create or replace public synonym RF_CP for RF_CP;

/*==============================================================*/
/* Synonyme : RF_CPCE                                           */
/*==============================================================*/
create or replace public synonym RF_CPCE for RF_CPCE;

/*==============================================================*/
/* Synonyme : RF_CPCE_NG                                        */
/*==============================================================*/
create or replace public synonym RF_CPCE_NG for RF_CPCE_NG;

/*==============================================================*/
/* Synonyme : RF_CPER                                           */
/*==============================================================*/
create or replace public synonym RF_CPER for RF_CPER;

/*==============================================================*/
/* Synonyme : RF_CPFTD                                          */
/*==============================================================*/
create or replace public synonym RF_CPFTD for RF_CPFT;

/*==============================================================*/
/* Synonyme : RF_CPMTD                                          */
/*==============================================================*/
create or replace public synonym RF_CPMTD for RF_CPMTD;

/*==============================================================*/
/* Synonyme : RF_CPT                                            */
/*==============================================================*/
create or replace public synonym RF_CPT for RF_CPT;

/*==============================================================*/
/* Synonyme : RF_CPTCLAUTIL                                     */
/*==============================================================*/
create or replace public synonym RF_CPTCLAUTIL for RF_CPTCLAUTIL;

/*==============================================================*/
/* Synonyme : RF_CPTCOM                                         */
/*==============================================================*/
create or replace public synonym RF_CPTCOM for RF_CPTCOM;

/*==============================================================*/
/* Synonyme : RF_CPTIND                                         */
/*==============================================================*/
create or replace public synonym RF_CPTIND for RF_CPTIND;

/*==============================================================*/
/* Synonyme : RF_CPYR                                           */
/*==============================================================*/
create or replace public synonym RF_CPYR for RF_CPYR;

/*==============================================================*/
/* Synonyme : RF_CTACHAT                                        */
/*==============================================================*/
create or replace public synonym RF_CTACHAT for RF_CTACHAT;

/*==============================================================*/
/* Synonyme : RF_CTBOP                                          */
/*==============================================================*/
create or replace public synonym RF_CTBOP for RF_CTBOP;

/*==============================================================*/
/* Synonyme : RF_CTENG                                          */
/*==============================================================*/
create or replace public synonym RF_CTENG for RF_CTENG;

/*==============================================================*/
/* Synonyme : RF_CTGRD                                          */
/*==============================================================*/
create or replace public synonym RF_CTGRD for RF_CTGRD;

/*==============================================================*/
/* Synonyme : RF_CTLOP                                          */
/*==============================================================*/
create or replace public synonym RF_CTLOP for RF_CTLOP;

/*==============================================================*/
/* Synonyme : RF_CTOB                                           */
/*==============================================================*/
create or replace public synonym RF_CTOB for RF_CTOB;

/*==============================================================*/
/* Synonyme : RF_CTORD                                          */
/*==============================================================*/
create or replace public synonym RF_CTORD for RF_CTORD;

/*==============================================================*/
/* Synonyme : RF_CTPED                                          */
/*==============================================================*/
create or replace public synonym RF_CTPED for RF_CTPED;

/*==============================================================*/
/* Synonyme : RF_CTSTAT                                         */
/*==============================================================*/
create or replace public synonym RF_CTSTAT for RF_CTSTAT;

/*==============================================================*/
/* Synonyme : RF_CTSTORCOR                                      */
/*==============================================================*/
create or replace public synonym RF_CTSTORCOR for RF_CTSTORCOR;

/*==============================================================*/
/* Synonyme : RF_CTUTIL                                         */
/*==============================================================*/
create or replace public synonym RF_CTUTIL for RF_CTUTIL;

/*==============================================================*/
/* Synonyme : RF_DACTD                                          */
/*==============================================================*/
create or replace public synonym RF_DACTD for RF_DACT;

/*==============================================================*/
/* Synonyme : RF_DEPT                                           */
/*==============================================================*/
create or replace public synonym RF_DEPT for RF_DEPT;

/*==============================================================*/
/* Synonyme : RF_DEVI                                           */
/*==============================================================*/
create or replace public synonym RF_DEVI for RF_DEVI;

/*==============================================================*/
/* Synonyme : RF_DEVI_NG                                        */
/*==============================================================*/
create or replace public synonym RF_DEVI_NG for RF_DEVI_NG;

/*==============================================================*/
/* Synonyme : RF_DEVPAY                                         */
/*==============================================================*/
create or replace public synonym RF_DEVPAY for RF_DEVPAY;

/*==============================================================*/
/* Synonyme : RF_DFOND                                          */
/*==============================================================*/
create or replace public synonym RF_DFOND for RF_DFON;

/*==============================================================*/
/* Synonyme : RF_DIPHDEF                                        */
/*==============================================================*/
create or replace public synonym RF_DIPHDEF for RF_DIPHDEF;

/*==============================================================*/
/* Synonyme : RF_DIPTTA                                         */
/*==============================================================*/
create or replace public synonym RF_DIPTTA for RF_DIPTTA;

/*==============================================================*/
/* Synonyme : RF_DOM                                            */
/*==============================================================*/
create or replace public synonym RF_DOM for RF_DOM;

/*==============================================================*/
/* Synonyme : RF_DOMFONC                                        */
/*==============================================================*/
create or replace public synonym RF_DOMFONC for RF_DOMFONC;

/*==============================================================*/
/* Synonyme : RF_DOMTTA                                         */
/*==============================================================*/
create or replace public synonym RF_DOMTTA for RF_DOMTTA;

/*==============================================================*/
/* Synonyme : RF_DPSA                                           */
/*==============================================================*/
create or replace public synonym RF_DPSA for RF_DPSA;

/*==============================================================*/
/* Synonyme : RF_ECHELON                                        */
/*==============================================================*/
create or replace public synonym RF_ECHELON for RF_ECHELON;

/*==============================================================*/
/* Synonyme : RF_ENGCENGJ                                       */
/*==============================================================*/
create or replace public synonym RF_ENGCENGJ for RF_ENGCENGJ;

/*==============================================================*/
/* Synonyme : RF_EOTP                                           */
/*==============================================================*/
create or replace public synonym RF_EOTP for RF_EOTP;

/*==============================================================*/
/* Synonyme : RF_ETAN                                           */
/*==============================================================*/
create or replace public synonym RF_ETAN for RF_ETAN;

/*==============================================================*/
/* Synonyme : RF_ETATENT                                        */
/*==============================================================*/
create or replace public synonym RF_ETATENT for RF_ETATENT;

/*==============================================================*/
/* Synonyme : RF_ETATOPE                                        */
/*==============================================================*/
create or replace public synonym RF_ETATOPE for RF_ETATOPE;

/*==============================================================*/
/* Synonyme : RF_FCTCPT                                         */
/*==============================================================*/
create or replace public synonym RF_FCTCPT for RF_FCTCPT;

/*==============================================================*/
/* Synonyme : RF_FCTN                                           */
/*==============================================================*/
create or replace public synonym RF_FCTN for RF_FCTN;

/*==============================================================*/
/* Synonyme : RF_FCTRPR                                         */
/*==============================================================*/
create or replace public synonym RF_FCTRPR for RF_FCTRPR;

/*==============================================================*/
/* Synonyme : RF_FCTSITE                                        */
/*==============================================================*/
create or replace public synonym RF_FCTSITE for RF_FCTSITE;

/*==============================================================*/
/* Synonyme : RF_FCTTTA                                         */
/*==============================================================*/
create or replace public synonym RF_FCTTTA for RF_FCTTTA;

/*==============================================================*/
/* Synonyme : RF_FIMO                                           */
/*==============================================================*/
create or replace public synonym RF_FIMO for RF_FIMO;

/*==============================================================*/
/* Synonyme : RF_FJE                                            */
/*==============================================================*/
create or replace public synonym RF_FJE for RF_FJE;

/*==============================================================*/
/* Synonyme : RF_FOND                                           */
/*==============================================================*/
create or replace public synonym RF_FOND for RF_FOND;

/*==============================================================*/
/* Synonyme : RF_FORM                                           */
/*==============================================================*/
create or replace public synonym RF_FORM for RF_FORM;

/*==============================================================*/
/* Synonyme : RF_FORMPRI                                        */
/*==============================================================*/
create or replace public synonym RF_FORMPRI for RF_FORMPRI;

/*==============================================================*/
/* Synonyme : RF_GACH                                           */
/*==============================================================*/
create or replace public synonym RF_GACH for RF_GACH;

/*==============================================================*/
/* Synonyme : RF_GCC                                            */
/*==============================================================*/
create or replace public synonym RF_GCC for RF_GCC;

/*==============================================================*/
/* Synonyme : RF_GCC_NG                                         */
/*==============================================================*/
create or replace public synonym RF_GCC_NG for RF_GCC_NG;

/*==============================================================*/
/* Synonyme : RF_GCD                                            */
/*==============================================================*/
create or replace public synonym RF_GCD for RF_GCD;

/*==============================================================*/
/* Synonyme : RF_GES                                            */
/*==============================================================*/
create or replace public synonym RF_GES for RF_GES;

/*==============================================================*/
/* Synonyme : RF_GMDS                                           */
/*==============================================================*/
create or replace public synonym RF_GMDS for RF_GMDS;

/*==============================================================*/
/* Synonyme : RF_GRD                                            */
/*==============================================================*/
create or replace public synonym RF_GRD for RF_GRD;

/*==============================================================*/
/* Synonyme : RF_GRDCMP                                         */
/*==============================================================*/
create or replace public synonym RF_GRDCMP for RF_GRDCMP;

/*==============================================================*/
/* Synonyme : RF_GRDECH                                         */
/*==============================================================*/
create or replace public synonym RF_GRDECH for RF_GRDECH;

/*==============================================================*/
/* Synonyme : RF_GRIM                                           */
/*==============================================================*/
create or replace public synonym RF_GRIM for RF_GRIM;

/*==============================================================*/
/* Synonyme : RF_HOMOLDIP                                       */
/*==============================================================*/
create or replace public synonym RF_HOMOLDIP for RF_HOMOLDIP;

/*==============================================================*/
/* Synonyme : RF_IMM                                            */
/*==============================================================*/
create or replace public synonym RF_IMM for RF_IMM;

/*==============================================================*/
/* Synonyme : RF_IMMCLAUTIL                                     */
/*==============================================================*/
create or replace public synonym RF_IMMCLAUTIL for RF_IMMCLAUTIL;

/*==============================================================*/
/* Synonyme : RF_IMMEUBLE                                       */
/*==============================================================*/
create or replace public synonym RF_IMMEUBLE for RF_IMMEUBLE;

/*==============================================================*/
/* Synonyme : RF_IMMIND                                         */
/*==============================================================*/
create or replace public synonym RF_IMMIND for RF_IMMIND;

/*==============================================================*/
/* Synonyme : RF_IMPE                                           */
/*==============================================================*/
create or replace public synonym RF_IMPE for RF_IMPE;

/*==============================================================*/
/* Synonyme : RF_IMPE_NG                                        */
/*==============================================================*/
create or replace public synonym RF_IMPE_NG for RF_IMPE_NG;

/*==============================================================*/
/* Synonyme : RF_IMPG                                           */
/*==============================================================*/
create or replace public synonym RF_IMPG for RF_IMPG;

/*==============================================================*/
/* Synonyme : RF_IMPG_NG                                        */
/*==============================================================*/
create or replace public synonym RF_IMPG_NG for RF_IMPG_NG;

/*==============================================================*/
/* Synonyme : RF_INDM                                           */
/*==============================================================*/
create or replace public synonym RF_INDM for RF_INDM;

/*==============================================================*/
/* Synonyme : RF_LCLCATUTIL                                     */
/*==============================================================*/
create or replace public synonym RF_LCLCATUTIL for RF_LCLCATUTIL;

/*==============================================================*/
/* Synonyme : RF_LCLCLAUTIL                                     */
/*==============================================================*/
create or replace public synonym RF_LCLCLAUTIL for RF_LCLCLAUTIL;

/*==============================================================*/
/* Synonyme : RF_LIGMER                                         */
/*==============================================================*/
create or replace public synonym RF_LIGMER for RF_LIGMER;

/*==============================================================*/
/* Synonyme : RF_LOCI                                           */
/*==============================================================*/
create or replace public synonym RF_LOCI for RF_LOCI;

/*==============================================================*/
/* Synonyme : RF_LOCM                                           */
/*==============================================================*/
create or replace public synonym RF_LOCM for RF_LOCM;

/*==============================================================*/
/* Synonyme : RF_MACCES                                         */
/*==============================================================*/
create or replace public synonym RF_MACCES for RF_MACCES;

/*==============================================================*/
/* Synonyme : RF_MACCOR                                         */
/*==============================================================*/
create or replace public synonym RF_MACCOR for RF_MACCOR;

/*==============================================================*/
/* Synonyme : RF_MACGRD                                         */
/*==============================================================*/
create or replace public synonym RF_MACGRD for RF_MACGRD;

/*==============================================================*/
/* Synonyme : RF_MAJ                                            */
/*==============================================================*/
create or replace public synonym RF_MAJ for RF_MAJ;

/*==============================================================*/
/* Synonyme : RF_MDRG                                           */
/*==============================================================*/
create or replace public synonym RF_MDRG for RF_MDRG;

/*==============================================================*/
/* Synonyme : RF_MDVI                                           */
/*==============================================================*/
create or replace public synonym RF_MDVI for RF_MDVI;

/*==============================================================*/
/* Synonyme : RF_MINAFF                                         */
/*==============================================================*/
create or replace public synonym RF_MINAFF for RF_MINAFF;

/*==============================================================*/
/* Synonyme : RF_MOA                                            */
/*==============================================================*/
create or replace public synonym RF_MOA for RF_MOA;

/*==============================================================*/
/* Synonyme : RF_MPMT                                           */
/*==============================================================*/
create or replace public synonym RF_MPMT for RF_MPMT;

/*==============================================================*/
/* Synonyme : RF_MSORT                                          */
/*==============================================================*/
create or replace public synonym RF_MSORT for RF_MSORT;

/*==============================================================*/
/* Synonyme : RF_MVTMVT                                         */
/*==============================================================*/
create or replace public synonym RF_MVTMVT for RF_MVTMVT;

/*==============================================================*/
/* Synonyme : RF_NAT                                            */
/*==============================================================*/
create or replace public synonym RF_NAT for RF_NAT;

/*==============================================================*/
/* Synonyme : RF_NATD                                           */
/*==============================================================*/
create or replace public synonym RF_NATD for RF_NATD;

/*==============================================================*/
/* Synonyme : RF_NATDECPRO                                      */
/*==============================================================*/
create or replace public synonym RF_NATDECPRO for RF_NATDECPRO;

/*==============================================================*/
/* Synonyme : RF_NATDEP                                         */
/*==============================================================*/
create or replace public synonym RF_NATDEP for RF_NATDEP;

/*==============================================================*/
/* Synonyme : RF_NATDRO                                         */
/*==============================================================*/
create or replace public synonym RF_NATDRO for RF_NATDRO;

/*==============================================================*/
/* Synonyme : RF_NATIMM                                         */
/*==============================================================*/
create or replace public synonym RF_NATIMM for RF_NATIMM;

/*==============================================================*/
/* Synonyme : RF_NATTXT                                         */
/*==============================================================*/
create or replace public synonym RF_NATTXT for RF_NATTXT;

/*==============================================================*/
/* Synonyme : RF_NATVOI                                         */
/*==============================================================*/
create or replace public synonym RF_NATVOI for RF_NATVOI;

/*==============================================================*/
/* Synonyme : RF_NBI                                            */
/*==============================================================*/
create or replace public synonym RF_NBI for RF_NBI;

/*==============================================================*/
/* Synonyme : RF_NIVRESP                                        */
/*==============================================================*/
create or replace public synonym RF_NIVRESP for RF_NIVRESP;

/*==============================================================*/
/* Synonyme : RF_NIVSUPP                                        */
/*==============================================================*/
create or replace public synonym RF_NIVSUPP for RF_NIVSUPP;

/*==============================================================*/
/* Synonyme : RF_NOMENCPROD                                     */
/*==============================================================*/
create or replace public synonym RF_NOMENCPROD for RF_NOMENCPROD;

/*==============================================================*/
/* Synonyme : RF_NRCTGRD                                        */
/*==============================================================*/
create or replace public synonym RF_NRCTGRD for RF_NRCTGRD;

/*==============================================================*/
/* Synonyme : RF_NTTR                                           */
/*==============================================================*/
create or replace public synonym RF_NTTR for RF_NTTR;

/*==============================================================*/
/* Synonyme : RF_NTTR_STGPE                                     */
/*==============================================================*/
create or replace public synonym RF_NTTR_STGPE for RF_NTTR_STGPE;

/*==============================================================*/
/* Synonyme : RF_OACH                                           */
/*==============================================================*/
create or replace public synonym RF_OACH for RF_OACH;

/*==============================================================*/
/* Synonyme : RF_OBI                                            */
/*==============================================================*/
create or replace public synonym RF_OBI for RF_OBI;

/*==============================================================*/
/* Synonyme : RF_OBI_NG                                         */
/*==============================================================*/
create or replace public synonym RF_OBI_NG for RF_OBI_NG;

/*==============================================================*/
/* Synonyme : RF_OBJTXT                                         */
/*==============================================================*/
create or replace public synonym RF_OBJTXT for RF_OBJTXT;

/*==============================================================*/
/* Synonyme : RF_OCC                                            */
/*==============================================================*/
create or replace public synonym RF_OCC for RF_OCC;

/*==============================================================*/
/* Synonyme : RF_ORDRE                                          */
/*==============================================================*/
create or replace public synonym RF_ORDRE for RF_ORDRE;

/*==============================================================*/
/* Synonyme : RF_ORDS                                           */
/*==============================================================*/
create or replace public synonym RF_ORDS for RF_ORDS;

/*==============================================================*/
/* Synonyme : RF_ORDS_NG                                        */
/*==============================================================*/
create or replace public synonym RF_ORDS_NG for RF_ORDS_NG;

/*==============================================================*/
/* Synonyme : RF_ORGANISME                                      */
/*==============================================================*/
create or replace public synonym RF_ORGANISME for RF_ORGANISME;

/*==============================================================*/
/* Synonyme : RF_ORGANISMEARMEE                                 */
/*==============================================================*/
create or replace public synonym RF_ORGANISMEARMEE for RF_ORGANISMEARMEE;

/*==============================================================*/
/* Synonyme : RF_ORGEN                                          */
/*==============================================================*/
create or replace public synonym RF_ORGEN for RF_ORGEN;

/*==============================================================*/
/* Synonyme : RF_ORGRAT                                         */
/*==============================================================*/
create or replace public synonym RF_ORGRAT for RF_ORGRAT;

/*==============================================================*/
/* Synonyme : RF_ORIDRO                                         */
/*==============================================================*/
create or replace public synonym RF_ORIDRO for RF_ORIDRO;

/*==============================================================*/
/* Synonyme : RF_ORIGINE                                        */
/*==============================================================*/
create or replace public synonym RF_ORIGINE for RF_ORIGINE;

/*==============================================================*/
/* Synonyme : RF_ORISNUP                                        */
/*==============================================================*/
create or replace public synonym RF_ORISNUP for RF_ORISNUP;

/*==============================================================*/
/* Synonyme : RF_PARAG                                          */
/*==============================================================*/
create or replace public synonym RF_PARAG for RF_PARAG;

/*==============================================================*/
/* Synonyme : RF_PAYS                                           */
/*==============================================================*/
create or replace public synonym RF_PAYS for RF_PAYS;

/*==============================================================*/
/* Synonyme : RF_PAYS_NG                                        */
/*==============================================================*/
create or replace public synonym RF_PAYS_NG for RF_PAYS_NG;

/*==============================================================*/
/* Synonyme : RF_PHASE                                          */
/*==============================================================*/
create or replace public synonym RF_PHASE for RF_PHASE;

/*==============================================================*/
/* Synonyme : RF_POSSTAT                                        */
/*==============================================================*/
create or replace public synonym RF_POSSTAT for RF_POSSTAT;

/*==============================================================*/
/* Synonyme : RF_POSTPS                                         */
/*==============================================================*/
create or replace public synonym RF_POSTPS for RF_POSTPS;

/*==============================================================*/
/* Synonyme : RF_PROD                                           */
/*==============================================================*/
create or replace public synonym RF_PROD for RF_PROD;

/*==============================================================*/
/* Synonyme : RF_PROG                                           */
/*==============================================================*/
create or replace public synonym RF_PROG for RF_PROG;

/*==============================================================*/
/* Synonyme : RF_PROJ                                           */
/*==============================================================*/
create or replace public synonym RF_PROJ for RF_PROJ;

/*==============================================================*/
/* Synonyme : RF_PROPRICPT                                      */
/*==============================================================*/
create or replace public synonym RF_PROPRICPT for RF_PROPRICPT;

/*==============================================================*/
/* Synonyme : RF_RATFIS                                         */
/*==============================================================*/
create or replace public synonym RF_RATFIS for RF_RATFIS;

/*==============================================================*/
/* Synonyme : RF_REG                                            */
/*==============================================================*/
create or replace public synonym RF_REG for RF_REG;

/*==============================================================*/
/* Synonyme : RF_REGDPT                                         */
/*==============================================================*/
create or replace public synonym RF_REGDPT for RF_REGDPT;

/*==============================================================*/
/* Synonyme : RF_REGECO                                         */
/*==============================================================*/
create or replace public synonym RF_REGECO for RF_REGECO;

/*==============================================================*/
/* Synonyme : RF_REGION                                         */
/*==============================================================*/
create or replace public synonym RF_REGION for RF_REGION;

/*==============================================================*/
/* Synonyme : RF_REGSTAT                                        */
/*==============================================================*/
create or replace public synonym RF_REGSTAT for RF_REGSTAT;

/*==============================================================*/
/* Synonyme : RF_RTORG2                                         */
/*==============================================================*/
create or replace public synonym RF_RTORG2 for RF_RTORG2;

/*==============================================================*/
/* Synonyme : RF_SB                                             */
/*==============================================================*/
create or replace public synonym RF_SB for RF_SB;

/*==============================================================*/
/* Synonyme : RF_SCTPAIE                                        */
/*==============================================================*/
create or replace public synonym RF_SCTPAIE for RF_SCTPAIE;

/*==============================================================*/
/* Synonyme : RF_SCTUTIL                                        */
/*==============================================================*/
create or replace public synonym RF_SCTUTIL for RF_SCTUTIL;

/*==============================================================*/
/* Synonyme : RF_SE                                             */
/*==============================================================*/
create or replace public synonym RF_SE for RF_SE;

/*==============================================================*/
/* Synonyme : RF_SEEX                                           */
/*==============================================================*/
create or replace public synonym RF_SEEX for RF_SEEX;

/*==============================================================*/
/* Synonyme : RF_SEGPAT                                         */
/*==============================================================*/
create or replace public synonym RF_SEGPAT for RF_SEGPAT;

/*==============================================================*/
/* Synonyme : RF_SFCT                                           */
/*==============================================================*/
create or replace public synonym RF_SFCT for RF_SFCT;

/*==============================================================*/
/* Synonyme : RF_SFCTCLAUTIL                                    */
/*==============================================================*/
create or replace public synonym RF_SFCTCLAUTIL for RF_SFCTCLAUTIL;

/*==============================================================*/
/* Synonyme : RF_SFCTCPT                                        */
/*==============================================================*/
create or replace public synonym RF_SFCTCPT for RF_SFCTCPT;

/*==============================================================*/
/* Synonyme : RF_SGC                                            */
/*==============================================================*/
create or replace public synonym RF_SGC for RF_SGC;

/*==============================================================*/
/* Synonyme : RF_SITMAR                                         */
/*==============================================================*/
create or replace public synonym RF_SITMAR for RF_SITMAR;

/*==============================================================*/
/* Synonyme : RF_SOBI                                           */
/*==============================================================*/
create or replace public synonym RF_SOBI for RF_SOBI;

/*==============================================================*/
/* Synonyme : RF_STATRA                                         */
/*==============================================================*/
create or replace public synonym RF_STATRA for RF_STATRA;

/*==============================================================*/
/* Synonyme : RF_STATUA                                         */
/*==============================================================*/
create or replace public synonym RF_STATUA for RF_STATUA;

/*==============================================================*/
/* Synonyme : RF_STATUT                                         */
/*==============================================================*/
create or replace public synonym RF_STATUT for RF_STATUT;

/*==============================================================*/
/* Synonyme : RF_STE_CHORUS                                     */
/*==============================================================*/
create or replace public synonym RF_STE_CHORUS for RF_STE_CHORUS;

/*==============================================================*/
/* Synonyme : RF_STE_CHORUS2                                    */
/*==============================================================*/
create or replace public synonym RF_STE_CHORUS2 for RF_STE_CHORUS;

/*==============================================================*/
/* Synonyme : RF_STRC                                           */
/*==============================================================*/
create or replace public synonym RF_STRC for RF_STRC;

/*==============================================================*/
/* Synonyme : RF_TACCES                                         */
/*==============================================================*/
create or replace public synonym RF_TACCES for RF_TACCES;

/*==============================================================*/
/* Synonyme : RF_TACHAT                                         */
/*==============================================================*/
create or replace public synonym RF_TACHAT for RF_TACHAT;

/*==============================================================*/
/* Synonyme : RF_TACHEFCT                                       */
/*==============================================================*/
create or replace public synonym RF_TACHEFCT for RF_TACHEFCT;

/*==============================================================*/
/* Synonyme : RF_TACHENAT                                       */
/*==============================================================*/
create or replace public synonym RF_TACHENAT for RF_TACHENAT;

/*==============================================================*/
/* Synonyme : RF_TAFF                                           */
/*==============================================================*/
create or replace public synonym RF_TAFF for RF_TAFF;

/*==============================================================*/
/* Synonyme : RF_TAMO                                           */
/*==============================================================*/
create or replace public synonym RF_TAMO for RF_TAMO;

/*==============================================================*/
/* Synonyme : RF_TBENECH                                        */
/*==============================================================*/
create or replace public synonym RF_TBENECH for RF_TBENECH;

/*==============================================================*/
/* Synonyme : RF_TCOMPO                                         */
/*==============================================================*/
create or replace public synonym RF_TCOMPO for RF_TCOMPO;

/*==============================================================*/
/* Synonyme : RF_TCONS                                          */
/*==============================================================*/
create or replace public synonym RF_TCONS for RF_TCONS;

/*==============================================================*/
/* Synonyme : RF_TCPT                                           */
/*==============================================================*/
create or replace public synonym RF_TCPT for RF_TCPT;

/*==============================================================*/
/* Synonyme : RF_TDEL                                           */
/*==============================================================*/
create or replace public synonym RF_TDEL for RF_TDEL;

/*==============================================================*/
/* Synonyme : RF_TDOC                                           */
/*==============================================================*/
create or replace public synonym RF_TDOC for RF_TDOC;

/*==============================================================*/
/* Synonyme : RF_TDOCTOPEDOM                                    */
/*==============================================================*/
create or replace public synonym RF_TDOCTOPEDOM for RF_TDOCTOPEDOM;

/*==============================================================*/
/* Synonyme : RF_TDOM                                           */
/*==============================================================*/
create or replace public synonym RF_TDOM for RF_TDOM;

/*==============================================================*/
/* Synonyme : RF_TDUREE                                         */
/*==============================================================*/
create or replace public synonym RF_TDUREE for RF_TDUREE;

/*==============================================================*/
/* Synonyme : RF_TENGC                                          */
/*==============================================================*/
create or replace public synonym RF_TENGC for RF_TENGC;

/*==============================================================*/
/* Synonyme : RF_TETAD                                          */
/*==============================================================*/
create or replace public synonym RF_TETAD for RF_TETAD;

/*==============================================================*/
/* Synonyme : RF_TETAO                                          */
/*==============================================================*/
create or replace public synonym RF_TETAO for RF_TETAO;

/*==============================================================*/
/* Synonyme : RF_TF                                             */
/*==============================================================*/
create or replace public synonym RF_TF for RF_TF;

/*==============================================================*/
/* Synonyme : RF_TFICHIER                                       */
/*==============================================================*/
create or replace public synonym RF_TFICHIER for RF_TFICHIER;

/*==============================================================*/
/* Synonyme : RF_TFON                                           */
/*==============================================================*/
create or replace public synonym RF_TFON for RF_TFON;

/*==============================================================*/
/* Synonyme : RF_TIMP                                           */
/*==============================================================*/
create or replace public synonym RF_TIMP for RF_TIMP;

/*==============================================================*/
/* Synonyme : RF_TIMPN                                          */
/*==============================================================*/
create or replace public synonym RF_TIMPN for RF_TIMPN;

/*==============================================================*/
/* Synonyme : RF_TINDIC                                         */
/*==============================================================*/
create or replace public synonym RF_TINDIC for RF_TINDIC;

/*==============================================================*/
/* Synonyme : RF_TINDMAJ                                        */
/*==============================================================*/
create or replace public synonym RF_TINDMAJ for RF_TINDMAJ;

/*==============================================================*/
/* Synonyme : RF_TINTF                                          */
/*==============================================================*/
create or replace public synonym RF_TINTF for RF_TINTF;

/*==============================================================*/
/* Synonyme : RF_TINTV                                          */
/*==============================================================*/
create or replace public synonym RF_TINTV for RF_TINTV;

/*==============================================================*/
/* Synonyme : RF_TITR                                           */
/*==============================================================*/
create or replace public synonym RF_TITR for RF_TITR;

/*==============================================================*/
/* Synonyme : RF_TLIG                                           */
/*==============================================================*/
create or replace public synonym RF_TLIG for RF_TLIG;

/*==============================================================*/
/* Synonyme : RF_TLOC                                           */
/*==============================================================*/
create or replace public synonym RF_TLOC for RF_TLOC;

/*==============================================================*/
/* Synonyme : RF_TMAJOPE                                        */
/*==============================================================*/
create or replace public synonym RF_TMAJOPE for RF_TMAJOPE;

/*==============================================================*/
/* Synonyme : RF_TMAN                                           */
/*==============================================================*/
create or replace public synonym RF_TMAN for RF_TMAN;

/*==============================================================*/
/* Synonyme : RF_TMAR                                           */
/*==============================================================*/
create or replace public synonym RF_TMAR for RF_TMAR;

/*==============================================================*/
/* Synonyme : RF_TMEMO                                          */
/*==============================================================*/
create or replace public synonym RF_TMEMO for RF_TMEMO;

/*==============================================================*/
/* Synonyme : RF_TMNT                                           */
/*==============================================================*/
create or replace public synonym RF_TMNT for RF_TMNT;

/*==============================================================*/
/* Synonyme : RF_TMVT                                           */
/*==============================================================*/
create or replace public synonym RF_TMVT for RF_TMVT;

/*==============================================================*/
/* Synonyme : RF_TNIV                                           */
/*==============================================================*/
create or replace public synonym RF_TNIV for RF_TNIV;

/*==============================================================*/
/* Synonyme : RF_TOPE                                           */
/*==============================================================*/
create or replace public synonym RF_TOPE for RF_TOPE;

/*==============================================================*/
/* Synonyme : RF_TOPEDOM                                        */
/*==============================================================*/
create or replace public synonym RF_TOPEDOM for RF_TOPEDOM;

/*==============================================================*/
/* Synonyme : RF_TOPLIQ                                         */
/*==============================================================*/
create or replace public synonym RF_TOPLIQ for RF_TOPLIQ;

/*==============================================================*/
/* Synonyme : RF_TOPV                                           */
/*==============================================================*/
create or replace public synonym RF_TOPV for RF_TOPV;

/*==============================================================*/
/* Synonyme : RF_TORG                                           */
/*==============================================================*/
create or replace public synonym RF_TORG for RF_TORG;

/*==============================================================*/
/* Synonyme : RF_TOUV                                           */
/*==============================================================*/
create or replace public synonym RF_TOUV for RF_TOUV;

/*==============================================================*/
/* Synonyme : RF_TPAIDIR                                        */
/*==============================================================*/
create or replace public synonym RF_TPAIDIR for RF_TPAIDIR;

/*==============================================================*/
/* Synonyme : RF_TPERS                                          */
/*==============================================================*/
create or replace public synonym RF_TPERS for RF_TPERS;

/*==============================================================*/
/* Synonyme : RF_TPIE                                           */
/*==============================================================*/
create or replace public synonym RF_TPIE for RF_TPIE;

/*==============================================================*/
/* Synonyme : RF_TPOP                                           */
/*==============================================================*/
create or replace public synonym RF_TPOP for RF_TPOP;

/*==============================================================*/
/* Synonyme : RF_TPOS                                           */
/*==============================================================*/
create or replace public synonym RF_TPOS for RF_TPOS;

/*==============================================================*/
/* Synonyme : RF_TPRE                                           */
/*==============================================================*/
create or replace public synonym RF_TPRE for RF_TPRE;

/*==============================================================*/
/* Synonyme : RF_TPRO                                           */
/*==============================================================*/
create or replace public synonym RF_TPRO for RF_TPRO;

/*==============================================================*/
/* Synonyme : RF_TPROTECT                                       */
/*==============================================================*/
create or replace public synonym RF_TPROTECT for RF_TPROTECT;

/*==============================================================*/
/* Synonyme : RF_TPSHIS                                         */
/*==============================================================*/
create or replace public synonym RF_TPSHIS for RF_TPSHIS;

/*==============================================================*/
/* Synonyme : RF_TPSTRAV                                        */
/*==============================================================*/
create or replace public synonym RF_TPSTRAV for RF_TPSTRAV;

/*==============================================================*/
/* Synonyme : RF_TPYR                                           */
/*==============================================================*/
create or replace public synonym RF_TPYR for RF_TPYR;

/*==============================================================*/
/* Synonyme : RF_TRAN                                           */
/*==============================================================*/
create or replace public synonym RF_TRAN for RF_TRAN;

/*==============================================================*/
/* Synonyme : RF_TREG                                           */
/*==============================================================*/
create or replace public synonym RF_TREG for RF_TREG;

/*==============================================================*/
/* Synonyme : RF_TSAUP                                          */
/*==============================================================*/
create or replace public synonym RF_TSAUP for RF_TSAUP;

/*==============================================================*/
/* Synonyme : RF_TSAUPP                                         */
/*==============================================================*/
create or replace public synonym RF_TSAUPP for RF_TSAUPP;

/*==============================================================*/
/* Synonyme : RF_TSNUP                                          */
/*==============================================================*/
create or replace public synonym RF_TSNUP for RF_TSNUP;

/*==============================================================*/
/* Synonyme : RF_TSOULTE                                        */
/*==============================================================*/
create or replace public synonym RF_TSOULTE for RF_TSOULTE;

/*==============================================================*/
/* Synonyme : RF_TSTAT                                          */
/*==============================================================*/
create or replace public synonym RF_TSTAT for RF_TSTAT;

/*==============================================================*/
/* Synonyme : RF_TSUB                                           */
/*==============================================================*/
create or replace public synonym RF_TSUB for RF_TSUB;

/*==============================================================*/
/* Synonyme : RF_TSUP                                           */
/*==============================================================*/
create or replace public synonym RF_TSUP for RF_TSUP;

/*==============================================================*/
/* Synonyme : RF_TTACHE                                         */
/*==============================================================*/
create or replace public synonym RF_TTACHE for RF_TTACHE;

/*==============================================================*/
/* Synonyme : RF_TTF                                            */
/*==============================================================*/
create or replace public synonym RF_TTF for RF_TTF;

/*==============================================================*/
/* Synonyme : RF_TTIE                                           */
/*==============================================================*/
create or replace public synonym RF_TTIE for RF_TTIE;

/*==============================================================*/
/* Synonyme : RF_TTRAN                                          */
/*==============================================================*/
create or replace public synonym RF_TTRAN for RF_TTRAN;

/*==============================================================*/
/* Synonyme : RF_TVA                                            */
/*==============================================================*/
create or replace public synonym RF_TVA for RF_TVA;

/*==============================================================*/
/* Synonyme : RF_TVA_NG                                         */
/*==============================================================*/
create or replace public synonym RF_TVA_NG for RF_TVA_NG;

/*==============================================================*/
/* Synonyme : RF_UO                                             */
/*==============================================================*/
create or replace public synonym RF_UO for RF_UO;

/*==============================================================*/
/* Synonyme : RF_UTILCL                                         */
/*==============================================================*/
create or replace public synonym RF_UTILCL for RF_UTILCL;

/*==============================================================*/
/* Synonyme : RF_ZD                                             */
/*==============================================================*/
create or replace public synonym RF_ZD for RF_ZD;

/*==============================================================*/
/* Synonyme : RF_ZFCT                                           */
/*==============================================================*/
create or replace public synonym RF_ZFCT for RF_ZFCT;

/*==============================================================*/
/* Synonyme : RF_ZONE                                           */
/*==============================================================*/
create or replace public synonym RF_ZONE for RF_ZONE;

/*==============================================================*/
/* Synonyme : RF_ZONGRD                                         */
/*==============================================================*/
create or replace public synonym RF_ZONGRD for RF_ZONGRD;

/*==============================================================*/
/* Synonyme : RF_ZONSIT                                         */
/*==============================================================*/
create or replace public synonym RF_ZONSIT for RF_ZONSIT;

