/*==============================================================*/
/* Nom de la base :  BASE_DE_DONNEES                            */
/* Nom de SGBD :  ORACLE Version 8i (8.1.5) (Deprecated)        */
/* Date de création :  07/12/2011 09:43:56                      */
/*==============================================================*/


drop public synonym AD_ACTIONCONT;

drop public synonym AD_ACTIONCPT;

drop public synonym AD_ACTIONPARC;

drop public synonym AD_ACTIONSITE;

drop public synonym AD_COMPTEURS;

drop public synonym AD_EXCLUSUB;

drop public synonym AD_JOURNRE;

drop public synonym AD_METACHORUS;

drop public synonym AD_VALRECONT;

drop public synonym AD_VALRECPT;

drop public synonym AD_VALREPARC;

drop public synonym AD_VALRESITE;

alter table AD_ACQ
   drop constraint AD_ACQ_FK1_1;

alter table AD_ACTIONCONT
   drop constraint AD_ACTIONCONT_FK1_1;

alter table AD_ACTIONCPT
   drop constraint AD_ACTIONCPT_FK1_1;

alter table AD_ACTIONPARC
   drop constraint AD_ACTIONPARC_FK1_1;

alter table AD_ACTIONSITE
   drop constraint AD_ACTIONSITE_FK1_1;

alter table AD_AFAE
   drop constraint AD_AFAE_FK1_1;

alter table AD_AFC
   drop constraint AD_AFC_FK1_1;

alter table AD_AFF
   drop constraint AD_AFF_FK1_1;

alter table AD_AFF
   drop constraint AD_AFF_FK1_2;

alter table AD_AREAFAE
   drop constraint FK_AD_AREAF_AD_AREAFA_RF_ARE;

alter table AD_AREAFAE
   drop constraint FK_AD_AREAF_AD_AREAFA_AD_AFAE;

alter table AD_AUT
   drop constraint AD_AUT_FK1_1;

alter table AD_AUT
   drop constraint AD_AUT_FK1_2;

alter table AD_AVAFAE
   drop constraint FK_AD_AVAFA_AD_AVAFAE_AD_AFAE;

alter table AD_BAIL
   drop constraint AD_BAIL_FK1_1;

alter table AD_BAIL
   drop constraint AD_BAIL_FK1_2;

alter table AD_BIBLIOEDT
   drop constraint AD_BIBLIOEDT_FK1_1;

alter table AD_CAD
   drop constraint AD_CAD_FK1_1;

alter table AD_COMIMP
   drop constraint AD_COMIMP_FK1_1;

alter table AD_COMIMP
   drop constraint AD_COMIMP_FK1_2;

alter table AD_COMSUPP
   drop constraint AD_COMSUPP_FK1_1;

alter table AD_COMSUPP
   drop constraint AD_COMSUPP_FK1_2;

alter table AD_COMURB
   drop constraint AD_COMMURB_FK1_1;

alter table AD_CPT
   drop constraint AD_CPT_FK1_1;

alter table AD_CPT
   drop constraint AD_CPT_FK1_2;

alter table AD_CPT
   drop constraint AD_CPT_FK1_3;

alter table AD_CPT
   drop constraint AD_CPT_FK1_4;

alter table AD_CPTBATI
   drop constraint AD_CPTBATI_FK1_1;

alter table AD_CPTBATI
   drop constraint AD_CPTBATI_FK1_2;

alter table AD_CPTBATI
   drop constraint AD_CPTBATI_FK1_3;

alter table AD_CPTBATI
   drop constraint AD_CPTBATI_FK1_4;

alter table AD_CPTCOHER
   drop constraint AD_CPTCOHER_FK1_1;

alter table AD_CPTETU
   drop constraint AD_CPTETU_FK1_1;

alter table AD_CPTETU
   drop constraint AD_CPTETU_FK1_2;

alter table AD_CPTHISTO
   drop constraint AD_CPTHISTO_FK1_1;

alter table AD_CPTNBATI
   drop constraint AD_CPTNBATI_FK1_1;

alter table AD_CPTNIV
   drop constraint AD_CPTNIV_FK1_1;

alter table AD_CPTNIV
   drop constraint AD_CPTNIV_FK1_2;

alter table AD_CPT_OLD
   drop constraint AD_CPT_OLD_FK1_1;

alter table AD_CRITERESEDT
   drop constraint AD_CRITERESEDT_FK1_1;

alter table AD_DECDPA
   drop constraint AD_DECDPA_FK1_1;

alter table AD_DECDPU
   drop constraint AD_DECDPU_FK1_1;

alter table AD_DECDPU
   drop constraint AD_DECDPU_FK1_2;

alter table AD_DECMIN
   drop constraint FK_AD_DECMI_AD_DECMIN_AD_ORIEN;

alter table AD_DECMIN
   drop constraint AD_DECMIN_FK1_3;

alter table AD_DECMIN
   drop constraint AD_DECMIN_FK1_4;

alter table AD_DECMINARE
   drop constraint AD_DECMINARE_FK1_1;

alter table AD_DECMINARE
   drop constraint AD_DECMINARE_FK1_2;

alter table AD_DECNDPA
   drop constraint AD_DECNPDA_FK1_1;

alter table AD_ECHCOMP
   drop constraint AD_ECHCOMP_FK1_1;

alter table AD_ECHCOMP
   drop constraint AD_ECHCOMP_FK1_2;

alter table AD_ECHCOMP
   drop constraint FK_AD_ECHCO_AD_ECHCOM_RF_AFFEC;

alter table AD_ECHSIMP
   drop constraint AD_ECHSIMP_FK1_1;

alter table AD_ECHSIMP
   drop constraint AD_ECHSIMP_FK1_2;

alter table AD_EXCLUSUB
   drop constraint AD_EXCLUSUB_FK1_1;

alter table AD_GESTEDT
   drop constraint AD_GESTEDT_FK1_1;

alter table AD_GESTEDT
   drop constraint AD_GESTEDT_FK1_2;

alter table AD_IMM
   drop constraint AD_IMM_FK1_1;

alter table AD_IMM
   drop constraint AD_IMM_FK1_10;

alter table AD_IMM
   drop constraint AD_IMM_FK1_11;

alter table AD_IMM
   drop constraint AD_IMM_FK1_12;

alter table AD_IMM
   drop constraint AD_IMM_FK1_13;

alter table AD_IMM
   drop constraint AD_IMM_FK1_14;

alter table AD_IMM
   drop constraint AD_IMM_FK1_2;

alter table AD_IMM
   drop constraint AD_IMM_FK1_3;

alter table AD_IMM
   drop constraint AD_IMM_FK1_4;

alter table AD_IMM
   drop constraint AD_IMM_FK1_5;

alter table AD_IMM
   drop constraint AD_IMM_FK1_6;

alter table AD_IMM
   drop constraint AD_IMM_FK1_7;

alter table AD_IMM
   drop constraint AD_IMM_FK1_8;

alter table AD_IMM
   drop constraint AD_IMM_FK1_9;

alter table AD_IMMADR
   drop constraint AD_IMMADR_FK1_1;

alter table AD_IMMADR
   drop constraint AD_IMMADR_FK1_2;

alter table AD_IMMADR
   drop constraint AD_IMMADR_FK1_3;

alter table AD_IMMARE
   drop constraint AD_IMMARE_FK1_1;

alter table AD_IMMARE
   drop constraint AD_IMMARE_FK1_2;

alter table AD_IMMCOHER
   drop constraint AD_IMMCOHER_FK1_1;

alter table AD_IMMOCC
   drop constraint AD_IMMOCC_FK1_1;

alter table AD_IMMOCC
   drop constraint AD_IMMOCC_FK1_2;

alter table AD_IMMOPEDOM
   drop constraint AD_IMMOPEDOM_FK1_1;

alter table AD_IMMOPEDOM
   drop constraint AD_IMMOPEDOM_FK1_2;

alter table AD_IMMSAUPP
   drop constraint AD_IMMSAUPP_FK1_1;

alter table AD_IMMSAUPP
   drop constraint AD_IMMSAUPP_FK1_2;

alter table AD_IMMSUPP
   drop constraint AD_IMMSUPP_FK1_1;

alter table AD_IMMSUPP
   drop constraint AD_IMMSUPP_FK1_2;

alter table AD_IMMSURF
   drop constraint AD_IMMSURF_FK1_1;

alter table AD_IMMURB
   drop constraint AD_IMMURB_FK1_1;

alter table AD_IMMVACCES
   drop constraint AD_IMMVACCES_FK1_1;

alter table AD_LCL
   drop constraint AD_LCL_FK1_1;

alter table AD_LCL
   drop constraint AD_LCL_FK1_2;

alter table AD_LCL
   drop constraint AD_LCL_FK1_3;

alter table AD_LCL
   drop constraint AD_LCL_FK1_4;

alter table AD_LCL
   drop constraint AD_LCL_FK1_5;

alter table AD_MAD
   drop constraint AD_MAD_FK1_1;

alter table AD_MAD
   drop constraint AD_MAD_FK1_2;

alter table AD_MAD
   drop constraint AD_MAD_FK1_3;

alter table AD_NBATIOCCPT
   drop constraint AD_NBATIOCCPT_FK1_1;

alter table AD_NBATIOCCPT
   drop constraint AD_NBATIOCCPT_FK1_2;

alter table AD_NBATIOCCPT
   drop constraint AD_NBATIOCCPT_FK1_3;

alter table AD_OPEDOM
   drop constraint AD_OPEDOM_FK1_1;

alter table AD_OPEDOM
   drop constraint AD_OPEDOM_FK1_2;

alter table AD_OPEDOM
   drop constraint AD_OPEDOM_FK1_3;

alter table AD_OPEDOM
   drop constraint AD_OPEDOM_FK1_4;

alter table AD_OPEDOM
   drop constraint AD_OPEDOM_FK1_5;

alter table AD_RAL
   drop constraint AD_RAL_FK1_1;

alter table AD_RAL
   drop constraint AD_RAL_FK1_3;

alter table AD_REPGES
   drop constraint AD_REPGES_FK1_1;

alter table AD_REPOCC
   drop constraint AD_REPOCC_FK1_1;

alter table AD_REPOCC
   drop constraint AD_REPOCC_FK1_2;

alter table AD_REPOCC
   drop constraint AD_REPOCC_FK1_3;

alter table AD_SAUPP
   drop constraint AD_SAUPP_FK1_1;

alter table AD_SMAJ
   drop constraint AD_SMAJ_FK1_1;

alter table AD_SMAJDOM
   drop constraint AD_SMAJDOM_FK1_1;

alter table AD_SMAJDOM
   drop constraint AD_SMAJDOM_FK1_2;

alter table AD_SMAJSU
   drop constraint AD_SMAJSU_FK1_1;

alter table AD_SMAJSU
   drop constraint AD_SMAJSU_FK1_2;

alter table AD_SNUP
   drop constraint AD_SNUP_FK1_1;

alter table AD_SNUP
   drop constraint AD_SNUP_FK1_2;

alter table AD_SNUP
   drop constraint AD_SNUP_FK1_3;

alter table AD_SUIVI_HIS
   drop constraint AD_SUIVI_HIS_FK1_1;

alter table AD_SUPD
   drop constraint AD_SUPD_FK1_1;

alter table AD_SUPD
   drop constraint AD_SUPD_FK1_2;

alter table AD_SUPD
   drop constraint AD_SUPD_FK1_3;

alter table AD_SUPP
   drop constraint AD_SUPP_FK1_1;

alter table AD_SUPP
   drop constraint AD_SUPP_FK1_2;

alter table AD_SUPP
   drop constraint AD_SUPP_FK1_3;

alter table AD_SUPP
   drop constraint AD_SUPP_FK1_4;

alter table AD_SUPP
   drop constraint AD_SUPP_FK1_5;

alter table AD_TMP_ORGA4RENUM
   drop constraint AD_TMP_ORGA4RENUM_FK1_1;

alter table AD_TOCCPROV
   drop constraint AD_TOCCPROV_FK1_1;

alter table AD_TOCCPROV
   drop constraint AD_TOCCPROV_FK1_2;

alter table AD_TRA
   drop constraint AD_TRA_FK1_1;

alter table AD_TRA
   drop constraint AD_TRA_FK1_2;

alter table AD_TRA
   drop constraint AD_TRA_FK1_3;

alter table AD_TXTSUPP
   drop constraint AD_TXTSUPP_FK1_1;

alter table AD_TXTSUPP
   drop constraint AD_TXTSUPP_FK1_2;

alter table AD_UA
   drop constraint AD_UA_FK1_1;

alter table AD_UA
   drop constraint AD_UA_FK1_2;

alter table AD_UA
   drop constraint AD_UA_FK1_3;

alter table AD_UA
   drop constraint AD_UA_FK1_4;

alter table AD_UA
   drop constraint AD_UA_FK1_5;

alter table AD_UA
   drop constraint AD_UA_FK1_6;

alter table AD_UACAD
   drop constraint AD_UACAD_FK1_1;

alter table AD_UACAD
   drop constraint AD_UACAD_FK1_2;

alter table AD_UADRO
   drop constraint AD_UADRO_FK1_1;

alter table AD_UADRO
   drop constraint AD_UADRO_FK1_2;

alter table AD_UADRO
   drop constraint AD_UADRO_FK1_3;

alter table AD_UANATDECPRO
   drop constraint AD_UANATDECPRO_FK1_1;

alter table AD_UANATDECPRO
   drop constraint AD_UANATDECPRO_FK1_2;

alter table AD_UASAUPP
   drop constraint AD_UASAUPP_FK1_1;

alter table AD_UASAUPP
   drop constraint AD_UASAUPP_FK1_2;

alter table AD_UFRUIT
   drop constraint AD_UFRUIT_FK1_1;

alter table AD_USER
   drop constraint AD_USER_FK1_1;

alter table AD_USER
   drop constraint AD_USER_FK1_2;

alter table AD_USER
   drop constraint AD_USER_FK1_3;

alter table AD_USER
   drop constraint AD_USER_FK1_4;

alter table AD_VALRECONT
   drop constraint AD_VALRECONT_FK1_1;

alter table AD_VALRECPT
   drop constraint AD_VALRECPT_FK1_1;

alter table AD_VALREPARC
   drop constraint AD_VALREPARC_FK1_1;

alter table AD_VALRESITE
   drop constraint AD_VALRESITE_FK1_1;

alter table AD_VIEDM
   drop constraint AD_VIEDM_FK1_1;

alter table AD_VIEDM
   drop constraint AD_VIEDM_FK1_2;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

alter table RF_LCLCLAUTIL
   drop constraint RF_LCLCLAUTIL_FK1_1;

drop index AD_ACQ_UN1_1;

drop index AD_ACQ_FK1_1;

drop table AD_ACQ cascade constraints;

drop index AD_ACTIONCONT_FK1_4;

drop index AD_ACTIONCONT_FK1_1;

drop index AD_ACTIONCONT_FK1_2;

drop index AD_ACTIONCONT_FK1_3;

drop table AD_ACTIONCONT cascade constraints;

drop index AD_ACTIONCPT_FK1_1;

drop index AD_ACTIONCPT_FK1_2;

drop index AD_ACTIONCPT_FK1_3;

drop table AD_ACTIONCPT cascade constraints;

drop index AD_ACTIONPARC_FK1_5;

drop index AD_ACTIONPARC_FK1_4;

drop index AD_ACTIONPARC_FK1_1;

drop index AD_ACTIONPARC_FK1_3;

drop index AD_ACTIONPARC_FK1_2;

drop table AD_ACTIONPARC cascade constraints;

drop index AD_ACTIONSITE_FK1_1;

drop index AD_ACTIONSITE_FK1_2;

drop table AD_ACTIONSITE cascade constraints;

drop index AD_AFAE_FK1_1;

drop table AD_AFAE cascade constraints;

drop index AD_AFC_FK1_1;

drop table AD_AFC cascade constraints;

drop index AD_AFF_FK1_2;

drop index AD_AFF_FK1_1;

drop table AD_AFF cascade constraints;

drop index AD_AREAFAE_FK1_2;

drop index AD_AREAFAE_FK1_1;

drop table AD_AREAFAE cascade constraints;

drop index AD_AUT_UN1_1;

drop index AD_AUT_FK1_2;

drop index AD_AUT_FK1_1;

drop table AD_AUT cascade constraints;

drop index AD_AVAFAE_FK1_1;

drop table AD_AVAFAE cascade constraints;

drop index AD_BAIL_FK1_2;

drop index AD_BAIL_FK1_1;

drop table AD_BAIL cascade constraints;

drop index AD_BIBLIOEDT_FK1_1;

drop table AD_BIBLIOEDT cascade constraints;

drop index AD_CAD_FK1_1;

drop index AD_CAD_UN4_1;

drop table AD_CAD cascade constraints;

drop index AD_COMIMP_UN2_1;

drop index AD_COMIMP_FK1_2;

drop index AD_COMIMP_FK1_1;

drop table AD_COMIMP cascade constraints;

drop index AD_COMPTEURS_PK1;

drop table AD_COMPTEURS cascade constraints;

drop index AD_COMSUPP_UN2_1;

drop index AD_COMSUPP_FK1_2;

drop index AD_COMSUPP_FK1_1;

drop table AD_COMSUPP cascade constraints;

drop index AD_COMURB_FK1_1;

drop table AD_COMURB cascade constraints;

drop index AD_CPT_FK1_4;

drop index AD_CPT_FK1_3;

drop index AD_CPT_UN2_1;

drop index AD_CPT_FK1_2;

drop index AD_CPT_FK1_1;

drop table AD_CPT cascade constraints;

drop index AD_CPTBATI_FK1_4;

drop index AD_CPTBATI_FK1_3;

drop index AD_CPTBATI_FK1_2;

drop index AD_CPTBATI_FK1_1;

drop table AD_CPTBATI cascade constraints;

drop index AD_CPTCOHER_FK1_1;

drop table AD_CPTCOHER cascade constraints;

drop index AD_CPTETU_FK1_2;

drop index AD_CPTETU_FK1_1;

drop table AD_CPTETU cascade constraints;

drop index AD_CPTHISTO_UN2_1;

drop index AD_CPTHISTO_FK1_1;

drop table AD_CPTHISTO cascade constraints;

drop index AD_CPTNBATI_FK1_1;

drop table AD_CPTNBATI cascade constraints;

drop index AD_CPTNIV_FK1_2;

drop index AD_CPTNIV_UN2_1;

drop index AD_CPTNIV_FK1_1;

drop table AD_CPTNIV cascade constraints;

drop index AD_CPT_OLD_NUMSAGRI_IDX;

drop table AD_CPT_OLD cascade constraints;

drop index AD_CRITERESEDT_FK1_1;

drop table AD_CRITERESEDT cascade constraints;

drop index AD_DECDPA_FK1_1;

drop table AD_DECDPA cascade constraints;

drop index AD_DECDPU_UN1_1;

drop index AD_DECDPU_FK1_2;

drop index AD_DECDPU_FK1_1;

drop table AD_DECDPU cascade constraints;

drop index AD_DECMIN_FK1_4;

drop index AD_DECMIN_FK1_3;

drop index AD_DECMIN_FK1_2;

drop index AD_DECMIN_UN2_1;

drop table AD_DECMIN cascade constraints;

drop index AD_DECMINARE_UN2_1;

drop index AD_DECMINARE_FK1_2;

drop index AD_DECMINARE_FK1_1;

drop table AD_DECMINARE cascade constraints;

drop index AD_DECNPDA_FK1_1;

drop table AD_DECNDPA cascade constraints;

drop table AD_DOMAINE cascade constraints;

drop index AD_ECHCOMP_FK1_3;

drop index AD_ECHCOMP_FK1_2;

drop index AD_ECHCOMP_FK1_1;

drop table AD_ECHCOMP cascade constraints;

drop index AD_ECHSIMP_FK1_2;

drop index AD_ECHSIMP_FK1_1;

drop table AD_ECHSIMP cascade constraints;

drop table AD_EIM cascade constraints;

drop index AD_EXCLUSUB_FK1_1;

drop table AD_EXCLUSUB cascade constraints;

drop index AD_GESTEDT_FK1_2;

drop index AD_GESTEDT_UN2_1;

drop index AD_GESTEDT_FK1_1;

drop table AD_GESTEDT cascade constraints;

drop index AD_IMM_FK1_14;

drop index AD_IMM_FK1_13;

drop index AD_IMM_FK1_11;

drop index AD_IMM_UN1_1;

drop index AD_IMM_FK1_12;

drop index AD_IMM_FK1_10;

drop index AD_IMM_FK1_9;

drop index AD_IMM_FK1_8;

drop index AD_IMM_FK1_7;

drop index AD_IMM_FK1_6;

drop index AD_IMM_FK1_5;

drop index AD_IMM_FK1_4;

drop index AD_IMM_FK1_3;

drop index AD_IMM_FK1_2;

drop index AD_IMM_FK1_1;

drop table AD_IMM cascade constraints;

drop index AD_IMMADR_FK1_3;

drop index AD_IMMADR_FK1_1;

drop index AD_IMMADR_FK1_2;

drop table AD_IMMADR cascade constraints;

drop index AD_IMMARE_FK1_2;

drop index AD_IMMARE_FK1_1;

drop table AD_IMMARE cascade constraints;

drop index AD_IMMCOHER_FK1_1;

drop table AD_IMMCOHER cascade constraints;

drop index AD_IMMOCC_UN2_1;

drop index AD_IMMOCC_FK1_2;

drop index AD_IMMOCC_FK1_1;

drop table AD_IMMOCC cascade constraints;

drop index AD_IMMOPEDOM_FK1_2;

drop index AD_IMMOPEDOM_FK1_1;

drop table AD_IMMOPEDOM cascade constraints;

drop index AD_IMMSAUPP_UN2_1;

drop index AD_IMMSAUPP_FK1_2;

drop index AD_IMMSAUPP_FK1_1;

drop table AD_IMMSAUPP cascade constraints;

drop index AD_IMMSUPP_UN2_1;

drop index AD_IMMSUPP_FK1_2;

drop index AD_IMMSUPP_FK1_1;

drop table AD_IMMSUPP cascade constraints;

drop index AD_IMMSURF_FK1_1;

drop table AD_IMMSURF cascade constraints;

drop index AD_IMMURB_FK1_1;

drop table AD_IMMURB cascade constraints;

drop index AD_IMMVACCES_FK1_1;

drop table AD_IMMVACCES cascade constraints;

drop table AD_JOURNRE cascade constraints;

drop index AD_LCL_UN1_2;

drop index AD_LCL_FK1_5;

drop index AD_LCL_UN3_1;

drop index AD_LCL_FK1_4;

drop index AD_LCL_FK1_2;

drop index AD_LCL_FK1_3;

drop index AD_LCL_FK1_1;

drop table AD_LCL cascade constraints;

drop index AD_MAD_FK1_3;

drop index AD_MAD_FK1_2;

drop index AD_MAD_FK1_1;

drop table AD_MAD cascade constraints;

drop table AD_METACHORUS cascade constraints;

drop table AD_NATDM cascade constraints;

drop index AD_NBATIOCCPT_UN3_1;

drop index AD_NBATIOCCPT_FK1_3;

drop index AD_NBATIOCCPT_FK1_2;

drop index AD_NBATIOCCPT_FK1_1;

drop table AD_NBATIOCCPT cascade constraints;

drop table AD_NIVDEC cascade constraints;

drop index AD_OCCPROV_UN1_1;

drop table AD_OCCPROV cascade constraints;

drop index AD_OPEDOM_FK1_5;

drop index AD_OPEDOM_FK1_4;

drop index AD_OPEDOM_FK1_3;

drop index AD_OPEDOM_FK1_2;

drop index AD_OPEDOM_FK1_1;

drop table AD_OPEDOM cascade constraints;

drop table AD_ORIENFIN cascade constraints;

drop index AD_RAL_FK1_2;

drop index AD_RAL_FK1_1;

drop table AD_RAL cascade constraints;

drop index AD_REPGES_FK1_1;

drop table AD_REPGES cascade constraints;

drop index AD_REPOCC_FK1_3;

drop index AD_REPOCC_FK1_2;

drop index AD_REPOCC_UN1_1;

drop index AD_REPOCC_FK1_1;

drop table AD_REPOCC cascade constraints;

drop table AD.AD_RGPP cascade constraints;

drop table AD_ROLE cascade constraints;

drop index AD_SAUPP_FK1_1;

drop table AD_SAUPP cascade constraints;

drop index AD_SMAJ_FK1_1;

drop table AD_SMAJ cascade constraints;

drop index AD_SMAJDOM_UN1_1;

drop index AD_SMAJDOM_FK1_2;

drop index AD_SMAJDOM_FK1_1;

drop table AD_SMAJDOM cascade constraints;

drop index AD_SMAJSU_UN1_1;

drop table AD_SMAJSU cascade constraints;

drop index AD_SNUP_FK1_3;

drop index AD_SNUP_FK1_2;

drop index AD_SNUP_FK1_1;

drop table AD_SNUP cascade constraints;

drop table AD_STATUTDM cascade constraints;

drop index AD_SUIVI_HIS_FK1_1;

drop table AD_SUIVI_HIS cascade constraints;

drop index AD_SUPD_FK1_3;

drop index AD_SUPD_FK1_1;

drop index AD_SUPD_FK1_2;

drop table AD_SUPD cascade constraints;

drop index AD_SUPP_FK1_5;

drop index AD_SUPP_FK1_4;

drop index AD_SUPP_FK1_3;

drop index AD_SUPP_FK1_2;

drop index AD_SUPP_UN1_1;

drop index AD_SUPP_FK1_1;

drop table AD_SUPP cascade constraints;

drop table AD_TEDT cascade constraints;

drop table AD_TETATEDT cascade constraints;

drop table AD_TMP_CPT cascade constraints;

drop index AD_TMP_ORGA4RENUM_FK1_1;

drop table AD_TMP_ORGA4RENUM cascade constraints;

drop table AD_TOCC cascade constraints;

drop index AD_TOCCPROV_UN2_1;

drop index AD_TOCCPROV_FK1_2;

drop index AD_TOCCPROV_FK1_1;

drop table AD_TOCCPROV cascade constraints;

drop index AD_TRA_FK1_3;

drop index AD_TRA_FK1_2;

drop index AD_TRA_FK1_1;

drop table AD_TRA cascade constraints;

drop index AD_TXTSUPP_FK1_2;

drop index AD_TXTSUPP_FK1_1;

drop table AD_TXTSUPP cascade constraints;

drop index AD_UA_FK1_6;

drop index AD_UA_FK1_1;

drop index AD_UA_FK1_5;

drop index AD_UA_FK1_4;

drop index AD_UA_UN1_1;

drop index AD_UA_FK1_3;

drop index AD_UA_FK1_2;

drop table AD_UA cascade constraints;

drop index AD_UACAD_UN2_1;

drop index AD_UACAD_FK1_2;

drop index AD_UACAD_FK1_1;

drop table AD_UACAD cascade constraints;

drop index AD_UADRO_UN4_1;

drop index AD_UADRO_FK1_3;

drop index AD_UADRO_FK1_2;

drop index AD_UADRO_FK1_1;

drop table AD_UADRO cascade constraints;

drop index AD_UANATDECPRO_UN3_1;

drop index AD_UANATDECPRO_FK1_2;

drop index AD_UANATDECPRO_FK1_1;

drop table AD_UANATDECPRO cascade constraints;

drop index AD_UASAUPP_UN2_1;

drop index AD_UASAUPP_FK1_2;

drop index AD_UASAUPP_FK1_1;

drop table AD_UASAUPP cascade constraints;

drop index AD_UFRUIT_FK1_1;

drop table AD_UFRUIT cascade constraints;

drop index AD_USER_FK1_4;

drop index AD_USER_FK1_3;

drop index AD_USER_FK1_2;

drop index AD_USER_FK1_1;

drop table AD_USER cascade constraints;

drop index AD_VALRECONT_FK1_1;

drop table AD_VALRECONT cascade constraints;

drop index AD_VALRECPT_FK1_1;

drop table AD_VALRECPT cascade constraints;

drop index AD_VALREPARC_FK1_1;

drop table AD_VALREPARC cascade constraints;

drop index AD_VALRESITE_FK1_1;

drop table AD_VALRESITE cascade constraints;

drop index AD_VIEDM_FK1_2;

drop index AD_VIEDM_FK1_1;

drop table AD_VIEDM cascade constraints;

drop index REF2.RF_LCLCATUTIL_UN1_1;

drop index REF2.RF_LCLCATUTIL_PK1_1;

drop table REF2.RF_LCLCATUTIL cascade constraints;

drop index REF2.RF_LCLCLAUTIL_UN2_1;

drop index REF2.RF_LCLCLAUTIL_FK1_1;

drop table RF_LCLCLAUTIL cascade constraints;

drop user AD;

drop user AD_SEL_A_UTI;

drop user IC_ETOILE;

drop user IC_FINAL;

drop user MN;

drop user REF;

drop user REF2;

drop user REF_SEL_A_UTI;

drop tablespace TS_DATA_AD including contents cascade constraints;

drop tablespace TS_INDEX_AD including contents cascade constraints;

/*==============================================================*/
/* Base de donnée : BASE_DE_DONNEES                             */
/*==============================================================*/
create database BASE_DE_DONNEES;

create tablespace TS_DATA_AD;

create tablespace TS_INDEX_AD;

/*==============================================================*/
/* Utilisateur : AD                                             */
/*==============================================================*/
create user AD identified by '';

/*==============================================================*/
/* Utilisateur : AD_SEL_A_UTI                                   */
/*==============================================================*/
create user AD_SEL_A_UTI identified by '';

/*==============================================================*/
/* Utilisateur : IC_ETOILE                                      */
/*==============================================================*/
create user IC_ETOILE identified by '';

/*==============================================================*/
/* Utilisateur : IC_FINAL                                       */
/*==============================================================*/
create user IC_FINAL identified by '';

/*==============================================================*/
/* Utilisateur : MN                                             */
/*==============================================================*/
create user MN identified by '';

/*==============================================================*/
/* Utilisateur : REF                                            */
/*==============================================================*/
create user REF identified by '';

/*==============================================================*/
/* Utilisateur : REF2                                           */
/*==============================================================*/
create user REF2 identified by '';

/*==============================================================*/
/* Utilisateur : REF_SEL_A_UTI                                  */
/*==============================================================*/
create user REF_SEL_A_UTI identified by '';

/*==============================================================*/
/* Table : AD_ACQ                                               */
/*==============================================================*/
drop public synonym AD_ACQ;
create table AD_ACQ  (
   AD_ACQ_ID            INTEGER                         not null,
   AD_OPEDOM_ID         INTEGER                         not null,
   AD_ACQ_VENDEUR       VARCHAR2(75)                    not null,
   AD_ACQ_REFPUBHYPO    VARCHAR2(50),
   AD_ACQ_DTPUBHYPO     VARCHAR2(15),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_ACQ_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_ACQ_PK1_1 primary key (AD_ACQ_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_ACQ is
'Acte d''acquisition';

comment on column AD_ACQ.AD_ACQ_ID is
'Identifiant de l''acte d''acquisition';

comment on column AD_ACQ.AD_OPEDOM_ID is
'Identifiant de l''opération domaniale';

comment on column AD_ACQ.AD_ACQ_VENDEUR is
'Vendeur acte acquisition';

comment on column AD_ACQ.AD_ACQ_REFPUBHYPO is
'Référence publication aux hypothèques';

comment on column AD_ACQ.AD_ACQ_DTPUBHYPO is
'Date publication aux hypothèques';

comment on column AD_ACQ.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_ACQ.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_ACQ for AD.AD_ACQ;
GRANT SELECT ON  AD_ACQ TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_ACQ_FK1_1                                         */
/*==============================================================*/
create index AD_ACQ_FK1_1 on AD_ACQ (
   AD_OPEDOM_ID ASC
);

/*==============================================================*/
/* Index : AD_ACQ_UN1_1                                         */
/*==============================================================*/
create unique index AD_ACQ_UN1_1 on AD_ACQ (
   AD_OPEDOM_ID ASC
);

/*==============================================================*/
/* Table : AD_ACTIONCONT                                        */
/*==============================================================*/
create table AD_ACTIONCONT  (
   AD_ACTIONCONT_ID     INTEGER                         not null,
   AD_IMM_COD           VARCHAR2(10)                    not null,
   AD_CPT_COD           INTEGER                         not null,
   RF_ARE_COD           VARCHAR2(5)                     not null,
   AD_METACHORUS_ID     INTEGER                         not null,
   AD_ACTIONCONT_LIB    VARCHAR2(10)                    not null,
   AD_ACTIONCONT_OPERG2D VARCHAR2(50)                    not null,
   AD_ACTIONCONT_DTMVTG2D VARCHAR2(15)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_ACTIONCONT_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   AD_ACTIONCONT_OLDVAL VARCHAR2(255)                   not null,
   constraint AD_ACTIONCONT_PK1_1 primary key (AD_ACTIONCONT_ID)
);

comment on table AD_ACTIONCONT is
'Action G2D impactant un contrat';

comment on column AD_ACTIONCONT.AD_ACTIONCONT_ID is
'Identifiant de Action Contrat';

comment on column AD_ACTIONCONT.AD_METACHORUS_ID is
'Identifiant des méta données Chorus';

comment on column AD_ACTIONCONT.AD_ACTIONCONT_LIB is
'Libellé de Action Contrat';

comment on column AD_ACTIONCONT.AD_ACTIONCONT_OPERG2D is
'Opérateur G2D';

comment on column AD_ACTIONCONT.AD_ACTIONCONT_DTMVTG2D is
'Date du mouvement dans G2D';

comment on column AD_ACTIONCONT.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_ACTIONCONT.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

comment on column AD_ACTIONCONT.AD_ACTIONCONT_OLDVAL is
'ancienne valeur G2D';

/*==============================================================*/
/* Index : AD_ACTIONCONT_FK1_3                                  */
/*==============================================================*/
create index AD_ACTIONCONT_FK1_3 on AD_ACTIONCONT (
   AD_IMM_COD ASC
);

/*==============================================================*/
/* Index : AD_ACTIONCONT_FK1_2                                  */
/*==============================================================*/
create index AD_ACTIONCONT_FK1_2 on AD_ACTIONCONT (
   AD_CPT_COD ASC
);

/*==============================================================*/
/* Index : AD_ACTIONCONT_FK1_1                                  */
/*==============================================================*/
create index AD_ACTIONCONT_FK1_1 on AD_ACTIONCONT (
   AD_METACHORUS_ID ASC
);

/*==============================================================*/
/* Index : AD_ACTIONCONT_FK1_4                                  */
/*==============================================================*/
create index AD_ACTIONCONT_FK1_4 on AD_ACTIONCONT (
   RF_ARE_COD ASC
);

/*==============================================================*/
/* Table : AD_ACTIONCPT                                         */
/*==============================================================*/
create table AD_ACTIONCPT  (
   AD_ACTIONCPT_ID      INTEGER                         not null,
   AD_IMM_COD           VARCHAR2(10)                    not null,
   AD_CPT_COD           INTEGER                         not null,
   AD_METACHORUS_ID     INTEGER                         not null,
   AD_ACTIONCPT_LIB     VARCHAR2(10)                    not null,
   AD_ACTIONCPT_DTMVTG2D VARCHAR2(15)                    not null,
   AD_ACTIONCPT_OPERG2D VARCHAR2(50)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_ACTIONCPT_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   AD_ACTIONCPT_OLDVAL  VARCHAR2(255)                   not null,
   constraint AD_ACTIONCPT_PK1_1 primary key (AD_ACTIONCPT_ID)
);

comment on table AD_ACTIONCPT is
'Action G2D impactant un composant';

comment on column AD_ACTIONCPT.AD_ACTIONCPT_ID is
'Identifiant de Action composant';

comment on column AD_ACTIONCPT.AD_METACHORUS_ID is
'Identifiant des méta données Chorus';

comment on column AD_ACTIONCPT.AD_ACTIONCPT_LIB is
'Libellé de Action composant';

comment on column AD_ACTIONCPT.AD_ACTIONCPT_DTMVTG2D is
'Date du mouvement dans G2D';

comment on column AD_ACTIONCPT.AD_ACTIONCPT_OPERG2D is
'Opérateur G2D';

comment on column AD_ACTIONCPT.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_ACTIONCPT.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

comment on column AD_ACTIONCPT.AD_ACTIONCPT_OLDVAL is
'ancienne valeur G2D';

/*==============================================================*/
/* Index : AD_ACTIONCPT_FK1_3                                   */
/*==============================================================*/
create index AD_ACTIONCPT_FK1_3 on AD_ACTIONCPT (
   AD_IMM_COD ASC
);

/*==============================================================*/
/* Index : AD_ACTIONCPT_FK1_2                                   */
/*==============================================================*/
create index AD_ACTIONCPT_FK1_2 on AD_ACTIONCPT (
   AD_CPT_COD ASC
);

/*==============================================================*/
/* Index : AD_ACTIONCPT_FK1_1                                   */
/*==============================================================*/
create index AD_ACTIONCPT_FK1_1 on AD_ACTIONCPT (
   AD_METACHORUS_ID ASC
);

/*==============================================================*/
/* Table : AD_ACTIONPARC                                        */
/*==============================================================*/
create table AD_ACTIONPARC  (
   AD_ACTIONPARC_ID     INTEGER                         not null,
   AD_IMM_COD           VARCHAR2(10)                    not null,
   AD_CAD_PREF          VARCHAR2(3)                     not null,
   AD_CAD_SEC           VARCHAR2(2)                     not null,
   AD_CAD_NUM           VARCHAR2(4)                     not null,
   AD_METACHORUS_ID     INTEGER                         not null,
   AD_ACTIONPARC_LIB    VARCHAR2(10)                    not null,
   RF_COMM_COD          VARCHAR2(3)                     not null,
   RF_DEPT_COD          VARCHAR2(3)                     not null,
   AD_ACTIONPARC_OPERG2D VARCHAR2(50)                    not null,
   AD_ACTIONPARC_DTMVTG2D VARCHAR2(15)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_ACTIONPARC_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   AD_ACTIONPARC_OLDVAL VARCHAR2(255)                   not null,
   constraint AD_ACTIONPARC_PK1_1 primary key (AD_ACTIONPARC_ID)
);

comment on table AD_ACTIONPARC is
'Action G2D impactant une parcelle';

comment on column AD_ACTIONPARC.AD_ACTIONPARC_ID is
'Identifiant de Action parcelle';

comment on column AD_ACTIONPARC.AD_METACHORUS_ID is
'Identifiant des méta données Chorus';

comment on column AD_ACTIONPARC.AD_ACTIONPARC_LIB is
'Libellé de Action Parcelle';

comment on column AD_ACTIONPARC.RF_COMM_COD is
'Code de la commune';

comment on column AD_ACTIONPARC.RF_DEPT_COD is
'Code du département';

comment on column AD_ACTIONPARC.AD_ACTIONPARC_OPERG2D is
'Opérateur G2D';

comment on column AD_ACTIONPARC.AD_ACTIONPARC_DTMVTG2D is
'Date du mouvement dans G2D';

comment on column AD_ACTIONPARC.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_ACTIONPARC.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

comment on column AD_ACTIONPARC.AD_ACTIONPARC_OLDVAL is
'ancienne valeur G2D';

create or replace public synonym AD_ACTIONPARC for AD.AD_ACTIONPARC;
GRANT SELECT ON  AD_ACTIONPARC TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_ACTIONPARC_FK1_2                                  */
/*==============================================================*/
create index AD_ACTIONPARC_FK1_2 on AD_ACTIONPARC (
   AD_CAD_PREF ASC
);

/*==============================================================*/
/* Index : AD_ACTIONPARC_FK1_3                                  */
/*==============================================================*/
create index AD_ACTIONPARC_FK1_3 on AD_ACTIONPARC (
   AD_IMM_COD ASC
);

/*==============================================================*/
/* Index : AD_ACTIONPARC_FK1_1                                  */
/*==============================================================*/
create index AD_ACTIONPARC_FK1_1 on AD_ACTIONPARC (
   AD_METACHORUS_ID ASC
);

/*==============================================================*/
/* Index : AD_ACTIONPARC_FK1_4                                  */
/*==============================================================*/
create index AD_ACTIONPARC_FK1_4 on AD_ACTIONPARC (
   AD_CAD_SEC ASC
);

/*==============================================================*/
/* Index : AD_ACTIONPARC_FK1_5                                  */
/*==============================================================*/
create index AD_ACTIONPARC_FK1_5 on AD_ACTIONPARC (
   AD_CAD_NUM ASC
);

/*==============================================================*/
/* Table : AD_ACTIONSITE                                        */
/*==============================================================*/
create table AD_ACTIONSITE  (
   AD_ACTIONSITE_ID     INTEGER                         not null,
   AD_IMM_COD           VARCHAR2(10)                    not null,
   AD_METACHORUS_ID     INTEGER                         not null,
   AD_ACTIONSITE_LIB    VARCHAR2(10)                    not null,
   AD_ACTIONSITE_OPERG2D VARCHAR2(50)                    not null,
   AD_ACTIONSITE_DTMVTG2D VARCHAR2(15)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_ACTIONSITE_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   AD_ACTIONSITE_OLDVAL VARCHAR2(255)                   not null,
   constraint AD_ACTIONSITE_PK1_1 primary key (AD_ACTIONSITE_ID)
);

comment on table AD_ACTIONSITE is
'Action G2D impactant un site';

comment on column AD_ACTIONSITE.AD_ACTIONSITE_ID is
'Identifiant de Action G2D impactant un site';

comment on column AD_ACTIONSITE.AD_METACHORUS_ID is
'Identifiant des méta données Chorus';

comment on column AD_ACTIONSITE.AD_ACTIONSITE_LIB is
'Libellé de l''Action Site';

comment on column AD_ACTIONSITE.AD_ACTIONSITE_OPERG2D is
'Opérateur G2D';

comment on column AD_ACTIONSITE.AD_ACTIONSITE_DTMVTG2D is
'Date du mouvement dans G2D';

comment on column AD_ACTIONSITE.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_ACTIONSITE.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

comment on column AD_ACTIONSITE.AD_ACTIONSITE_OLDVAL is
'ancienne valeur G2D';

/*==============================================================*/
/* Index : AD_ACTIONSITE_FK1_2                                  */
/*==============================================================*/
create index AD_ACTIONSITE_FK1_2 on AD_ACTIONSITE (
   AD_IMM_COD ASC
);

/*==============================================================*/
/* Index : AD_ACTIONSITE_FK1_1                                  */
/*==============================================================*/
create index AD_ACTIONSITE_FK1_1 on AD_ACTIONSITE (
   AD_METACHORUS_ID ASC
);

/*==============================================================*/
/* Table : AD_AFAE                                              */
/*==============================================================*/
drop public synonym AD_AFAE;
create table AD_AFAE  (
   AD_AFAE_ID           INTEGER                         not null,
   RF_NATTXT_ID         INTEGER                         not null,
   AD_AFAE_REFAVISCSINA VARCHAR2(15),
   AD_AFAE_DTAVISCSINA  VARCHAR2(15),
   AD_AFAE_REFTXTAFAE   VARCHAR2(50),
   AD_AFAE_DTTXTAFAE    VARCHAR2(15),
   AD_AFAE_DTDERAPPM    VARCHAR2(15),
   AD_AFAE_STOT         NUMBER(9),
   AD_AFAE_SBAT         NUMBER(9),
   AD_AFAE_SUTI         NUMBER(9),
   AD_AFAE_SHOD         NUMBER(9),
   AD_AFAE_SAME         NUMBER(9),
   AD_AFAE_SNCO         NUMBER(9),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_AFAE_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_AFAE_PK1_1 primary key (AD_AFAE_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_AFAE is
'Affectation aéronautique';

comment on column AD_AFAE.AD_AFAE_ID is
'Identifaint de l''affectation aéronautique';

comment on column AD_AFAE.RF_NATTXT_ID is
'Identifiant de la nature de texte';

comment on column AD_AFAE.AD_AFAE_REFAVISCSINA is
'Référence avis CSINA';

comment on column AD_AFAE.AD_AFAE_DTAVISCSINA is
'Date avis CSINA';

comment on column AD_AFAE.AD_AFAE_REFTXTAFAE is
'Référence texte affectation AE';

comment on column AD_AFAE.AD_AFAE_DTTXTAFAE is
'Date texte affectation AE';

comment on column AD_AFAE.AD_AFAE_DTDERAPPM is
'Date du dernier APPM';

comment on column AD_AFAE.AD_AFAE_STOT is
'Emprise AE';

comment on column AD_AFAE.AD_AFAE_SBAT is
'Emprise bâtie AE';

comment on column AD_AFAE.AD_AFAE_SUTI is
'Surface utile AE';

comment on column AD_AFAE.AD_AFAE_SHOD is
'SHOD AE';

comment on column AD_AFAE.AD_AFAE_SAME is
'Surface aire aménagée AE';

comment on column AD_AFAE.AD_AFAE_SNCO is
'Surface aire non construite AE';

comment on column AD_AFAE.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_AFAE.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_AFAE for AD.AD_AFAE;
GRANT SELECT ON  AD_AFAE TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_AFAE_FK1_1                                        */
/*==============================================================*/
create index AD_AFAE_FK1_1 on AD_AFAE (
   RF_NATTXT_ID ASC
);

/*==============================================================*/
/* Table : AD_AFC                                               */
/*==============================================================*/
drop public synonym AD_AFC;
create table AD_AFC  (
   AD_AFC_ID            INTEGER                         not null,
   AD_OPEDOM_ID         INTEGER                         not null,
   AD_AFC_REFPUBHYPO    VARCHAR2(50),
   AD_AFC_DTPUBHYPO     VARCHAR2(15),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_AFC_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_AFC_PK1_1 primary key (AD_AFC_ID)
);

comment on table AD_AFC is
'Apport foncier';

comment on column AD_AFC.AD_AFC_ID is
'Identifiant de l''apport foncier';

comment on column AD_AFC.AD_OPEDOM_ID is
'Identifiant de l''opération domaniale';

comment on column AD_AFC.AD_AFC_REFPUBHYPO is
'Référence de la publication de l''hypothèque';

comment on column AD_AFC.AD_AFC_DTPUBHYPO is
'Date de la publication de l''hypothèque';

comment on column AD_AFC.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_AFC.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_AFC for AD.AD_AFC;
GRANT SELECT ON  AD_AFC TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_AFC_FK1_1                                         */
/*==============================================================*/
create index AD_AFC_FK1_1 on AD_AFC (
   AD_OPEDOM_ID ASC
);

/*==============================================================*/
/* Table : AD_AFF                                               */
/*==============================================================*/
drop public synonym AD_AFF;
create table AD_AFF  (
   AD_AFF_ID            INTEGER                         not null,
   AD_OPEDOM_ID         INTEGER                         not null,
   RF_AFFECT_ID         INTEGER                         not null,
   AD_AFF_DTNOUVAFF     VARCHAR2(15)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_AFF_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_AFF_PK1_1 primary key (AD_AFF_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_AFF is
'Changement affectation';

comment on column AD_AFF.AD_AFF_ID is
'Identifiant du changement d''affectation';

comment on column AD_AFF.AD_OPEDOM_ID is
'Identifiant de l''opération domaniale';

comment on column AD_AFF.RF_AFFECT_ID is
'Identifiant affectataire';

comment on column AD_AFF.AD_AFF_DTNOUVAFF is
'Date de remise au nouvel affectataire chgt aff';

comment on column AD_AFF.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_AFF.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_AFF for AD.AD_AFF;
GRANT SELECT ON  AD_AFF TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_AFF_FK1_1                                         */
/*==============================================================*/
create index AD_AFF_FK1_1 on AD_AFF (
   AD_OPEDOM_ID ASC
);

/*==============================================================*/
/* Index : AD_AFF_FK1_2                                         */
/*==============================================================*/
create unique index AD_AFF_FK1_2 on AD_AFF (
   AD_OPEDOM_ID ASC
);

/*==============================================================*/
/* Table : AD_AREAFAE                                           */
/*==============================================================*/
drop public synonym AD_AREAFAE;
create table AD_AREAFAE  (
   AD_AREAFAE_ID        INTEGER                         not null,
   RF_ARE_ID            INTEGER,
   AD_AFAE_ID           INTEGER,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint CKC_AD_XTOPSUP_AD_AREAF check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint PK_AD_AREAFAE primary key (AD_AREAFAE_ID)
);

comment on column AD_AREAFAE.RF_ARE_ID is
'Identifiant de l''attributaire';

comment on column AD_AREAFAE.AD_AFAE_ID is
'Identifaint de l''affectation aéronautique';

create public synonym AD_AREAFAE for AD.AD_AREAFAE;
GRANT SELECT ON  AD_AREAFAE TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_AREAFAE_FK1_1                                     */
/*==============================================================*/
create index AD_AREAFAE_FK1_1 on AD_AREAFAE (
   RF_ARE_ID ASC
);

/*==============================================================*/
/* Index : AD_AREAFAE_FK1_2                                     */
/*==============================================================*/
create index AD_AREAFAE_FK1_2 on AD_AREAFAE (
   AD_AFAE_ID ASC
);

/*==============================================================*/
/* Table : AD_AUT                                               */
/*==============================================================*/
drop public synonym AD_AUT;
create table AD_AUT  (
   AD_AUT_ID            INTEGER                         not null,
   AD_OPEDOM_ID         INTEGER                         not null,
   RF_MSORT_ID          INTEGER                         not null,
   AD_AUT_BENEF         VARCHAR2(75)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_AUT_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_AUT_PK1_1 primary key (AD_AUT_ID)
)
tablespace TS_DATA_AD;

comment on table AD_AUT is
'Autre modes de cession';

comment on column AD_AUT.AD_AUT_ID is
'Identifiant du mode de cession';

comment on column AD_AUT.AD_OPEDOM_ID is
'Opé_Identifiant de l''opération domaniale';

comment on column AD_AUT.RF_MSORT_ID is
'Identifiant du motif de sortie';

comment on column AD_AUT.AD_AUT_BENEF is
'Beneficiaire AM';

comment on column AD_AUT.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_AUT.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_AUT for AD.AD_AUT;
GRANT SELECT ON  AD_AUT TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_AUT_FK1_1                                         */
/*==============================================================*/
create index AD_AUT_FK1_1 on AD_AUT (
   AD_OPEDOM_ID ASC
);

/*==============================================================*/
/* Index : AD_AUT_FK1_2                                         */
/*==============================================================*/
create index AD_AUT_FK1_2 on AD_AUT (
   RF_MSORT_ID ASC
);

/*==============================================================*/
/* Index : AD_AUT_UN1_1                                         */
/*==============================================================*/
create unique index AD_AUT_UN1_1 on AD_AUT (
   AD_OPEDOM_ID ASC
);

/*==============================================================*/
/* Table : AD_AVAFAE                                            */
/*==============================================================*/
drop public synonym AD_AVAFAE;
create table AD_AVAFAE  (
   AD_AVAFAE_ID         INTEGER                         not null,
   AD_AFAE_ID           INTEGER                         not null,
   AD_AVAFAE_NUM        NUMBER(4)                       not null,
   AD_AVAFAE_DT         VARCHAR2(15)                    not null,
   AD_AVAFAE_ES         VARCHAR2(1)                     not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_AVAFAE_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_AVAFAE_PK1_1 primary key (AD_AVAFAE_ID)
);

comment on table AD_AVAFAE is
'Avenant affectation aéronautique';

comment on column AD_AVAFAE.AD_AVAFAE_ID is
'Identifiant de l''avenant affectation aéronautique';

comment on column AD_AVAFAE.AD_AFAE_ID is
'Identifaint de l''affectation aéronautique';

comment on column AD_AVAFAE.AD_AVAFAE_NUM is
'Numéro d''ordre';

comment on column AD_AVAFAE.AD_AVAFAE_DT is
'Date de l''avenant';

comment on column AD_AVAFAE.AD_AVAFAE_ES is
'Entrée sortie';

comment on column AD_AVAFAE.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_AVAFAE.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_AVAFAE for AD.AD_AVAFAE;
GRANT SELECT ON  AD_AVAFAE TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_AVAFAE_FK1_1                                      */
/*==============================================================*/
create index AD_AVAFAE_FK1_1 on AD_AVAFAE (
   AD_AFAE_ID ASC
);

/*==============================================================*/
/* Table : AD_BAIL                                              */
/*==============================================================*/
drop public synonym AD_BAIL;
create table AD_BAIL  (
   AD_BAIL_ID           INTEGER                         not null,
   AD_OPEDOM_ID         INTEGER                         not null,
   RF_TLOC_ID           INTEGER                         not null,
   AD_BAIL_OBJ          VARCHAR2(50)                    not null,
   AD_BAIL_BAILLEUR     VARCHAR2(20)                    not null,
   AD_BAIL_DTDEBLOC     VARCHAR2(15)                    not null,
   AD_BAIL_DTFINLOC     VARCHAR2(15),
   AD_BAIL_SANSLIMIT    VARCHAR2(5),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_BAIL_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_BAIL_PK1_1 primary key (AD_BAIL_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_BAIL is
'Prise à bail';

comment on column AD_BAIL.AD_BAIL_ID is
'Identifiant de la prise à bail';

comment on column AD_BAIL.AD_OPEDOM_ID is
'Identifiant de l''opération domaniale';

comment on column AD_BAIL.RF_TLOC_ID is
'Identifiant du type de location';

comment on column AD_BAIL.AD_BAIL_OBJ is
'Objet de la location';

comment on column AD_BAIL.AD_BAIL_BAILLEUR is
'Bailleur location';

comment on column AD_BAIL.AD_BAIL_DTDEBLOC is
'Date début location';

comment on column AD_BAIL.AD_BAIL_DTFINLOC is
'Date fin location';

comment on column AD_BAIL.AD_BAIL_SANSLIMIT is
'Top sans limitation de durée';

comment on column AD_BAIL.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_BAIL.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_BAIL for AD.AD_BAIL;
GRANT SELECT ON  AD_BAIL TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_BAIL_FK1_1                                        */
/*==============================================================*/
create index AD_BAIL_FK1_1 on AD_BAIL (
   RF_TLOC_ID ASC
);

/*==============================================================*/
/* Index : AD_BAIL_FK1_2                                        */
/*==============================================================*/
create unique index AD_BAIL_FK1_2 on AD_BAIL (
   AD_OPEDOM_ID ASC
);

/*==============================================================*/
/* Table : AD_BIBLIOEDT                                         */
/*==============================================================*/
drop public synonym AD_BIBLIOEDT;
create table AD_BIBLIOEDT  (
   AD_BIBLIOEDT_ID      INTEGER                         not null,
   RF_TFICHIER_ID       INTEGER                         not null,
   AD_BIBLIOEDT_NOMFIC  VARCHAR2(100)                   not null,
   AD_BIBLIOEDT_TAILLEFIC INTEGER                         not null,
   AD_BIBLIOEDT_DTCREAFIC VARCHAR2(15)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_BIBLIOEDT_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_BIBLIOEDT_PK1_1 primary key (AD_BIBLIOEDT_ID)
);

comment on table AD_BIBLIOEDT is
'Bibliothèque des éditions';

comment on column AD_BIBLIOEDT.AD_BIBLIOEDT_ID is
'Identifiant de la bibliothèque';

comment on column AD_BIBLIOEDT.RF_TFICHIER_ID is
'Identifiant du type de fichier';

comment on column AD_BIBLIOEDT.AD_BIBLIOEDT_NOMFIC is
'Nom du fichier';

comment on column AD_BIBLIOEDT.AD_BIBLIOEDT_TAILLEFIC is
'Taille du fichier';

comment on column AD_BIBLIOEDT.AD_BIBLIOEDT_DTCREAFIC is
'Date de création du fichier';

comment on column AD_BIBLIOEDT.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_BIBLIOEDT.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_BIBLIOEDT for AD.AD_BIBLIOEDT;
GRANT SELECT ON  AD_BIBLIOEDT TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_BIBLIOEDT_FK1_1                                   */
/*==============================================================*/
create index AD_BIBLIOEDT_FK1_1 on AD_BIBLIOEDT (
   RF_TFICHIER_ID ASC
);

/*==============================================================*/
/* Table : AD_CAD                                               */
/*==============================================================*/
drop public synonym AD_CAD;
create table AD_CAD  (
   AD_CAD_ID            INTEGER                         not null,
   RF_COMM_ID           INTEGER                         not null,
   AD_CAD_PREF          VARCHAR2(3)                     not null,
   AD_CAD_SEC           VARCHAR2(2)                     not null,
   AD_CAD_NUM           VARCHAR2(4)                     not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_CAD_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   AD_CAD_OBS           VARCHAR2(50),
   AD_CAD_PARTIEL       VARCHAR2(5),
   constraint AD_CAD_PK1_1 primary key (AD_CAD_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_CAD is
'Parcelle cadastrale';

comment on column AD_CAD.AD_CAD_ID is
'Identifiant de la parcelle cadastrale';

comment on column AD_CAD.RF_COMM_ID is
'Identifiant de la commune';

comment on column AD_CAD.AD_CAD_PREF is
'Préfixe parcelle cadastrale';

comment on column AD_CAD.AD_CAD_SEC is
'Section parcelle cadastrale';

comment on column AD_CAD.AD_CAD_NUM is
'Numéro parcelle cadastrale';

comment on column AD_CAD.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_CAD.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

comment on column AD_CAD.AD_CAD_OBS is
'Observations';

create public synonym AD_CAD for AD.AD_CAD;
GRANT SELECT ON  AD_CAD TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_CAD_UN4_1                                         */
/*==============================================================*/
create unique index AD_CAD_UN4_1 on AD_CAD (
   AD_CAD_PREF ASC,
   AD_CAD_SEC ASC,
   AD_CAD_NUM ASC,
   RF_COMM_ID ASC
);

/*==============================================================*/
/* Index : AD_CAD_FK1_1                                         */
/*==============================================================*/
create index AD_CAD_FK1_1 on AD_CAD (
   RF_COMM_ID ASC
);

/*==============================================================*/
/* Table : AD_COMIMP                                            */
/*==============================================================*/
drop public synonym AD_COMIMP;
create table AD_COMIMP  (
   AD_COMIMP_ID         INTEGER                         not null,
   AD_IMM_ID            INTEGER                         not null,
   RF_COMM_ID           INTEGER                         not null,
   AD_COMIMP_STOT       NUMBER(9)                       not null,
   AD_COMIMP_SONF       NUMBER(9),
   AD_COMIMP_SIGESA     NUMBER(9),
   AD_COMIMP_INDCOMCPT  INTEGER,
   AD_COMIMP_CTOT       NUMBER(9)                       not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_COMIMP_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_COMIMP_PK1_1 primary key (AD_COMIMP_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_COMIMP is
'Indicateur com/cpt initialisé à 1 à la création du lien';

comment on column AD_COMIMP.AD_COMIMP_ID is
'Identifiant de la commune d''implantation';

comment on column AD_COMIMP.AD_IMM_ID is
'Identifiant de l''immeuble';

comment on column AD_COMIMP.RF_COMM_ID is
'Identifiant de la commune';

comment on column AD_COMIMP.AD_COMIMP_STOT is
'Emprise sur la commune implantation comm';

comment on column AD_COMIMP.AD_COMIMP_SONF is
'Emprise gérée par ONF';

comment on column AD_COMIMP.AD_COMIMP_SIGESA is
'Emprise gérée IGESA';

comment on column AD_COMIMP.AD_COMIMP_INDCOMCPT is
'Indicateur com/cpt';

comment on column AD_COMIMP.AD_COMIMP_CTOT is
'CTOT comimp';

comment on column AD_COMIMP.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_COMIMP.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_COMIMP for AD.AD_COMIMP;
GRANT SELECT ON  AD_COMIMP TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_COMIMP_FK1_1                                      */
/*==============================================================*/
create index AD_COMIMP_FK1_1 on AD_COMIMP (
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Index : AD_COMIMP_FK1_2                                      */
/*==============================================================*/
create index AD_COMIMP_FK1_2 on AD_COMIMP (
   RF_COMM_ID ASC
);

/*==============================================================*/
/* Index : AD_COMIMP_UN2_1                                      */
/*==============================================================*/
create unique index AD_COMIMP_UN2_1 on AD_COMIMP (
   AD_IMM_ID ASC,
   RF_COMM_ID ASC
);

/*==============================================================*/
/* Table : AD_COMPTEURS                                         */
/*==============================================================*/
create table AD_COMPTEURS  (
   AD_COMPTEURS_ID      INTEGER                         not null,
   AD_COMPTEURS_DES     VARCHAR2(30)                    not null,
   AD_COMPTEURS_VAL     INTEGER                         not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                     not null,
   constraint AD_COMPTEURS_PK1 primary key (AD_COMPTEURS_ID)
);

/*==============================================================*/
/* Index : AD_COMPTEURS_PK1                                     */
/*==============================================================*/
create unique index AD_COMPTEURS_PK1 on AD_COMPTEURS (
   AD_COMPTEURS_ID ASC
);

/*==============================================================*/
/* Table : AD_COMSUPP                                           */
/*==============================================================*/
drop public synonym AD_COMSUPP;
create table AD_COMSUPP  (
   AD_COMSUPP_ID        INTEGER                         not null,
   AD_SUPP_ID           INTEGER                         not null,
   RF_COMM_ID           INTEGER                         not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_COMSUPP_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_COMSUPP_PK1_1 primary key (AD_COMSUPP_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_COMSUPP is
'Avoir pour SUPP';

comment on column AD_COMSUPP.AD_COMSUPP_ID is
'Identifiant de SUPP - COMM';

comment on column AD_COMSUPP.AD_SUPP_ID is
'Identifiant de la servitude d''utilité publique au profit';

comment on column AD_COMSUPP.RF_COMM_ID is
'Identifiant de la commune';

comment on column AD_COMSUPP.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_COMSUPP.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_COMSUPP for AD.AD_COMSUPP;
GRANT SELECT ON  AD_COMSUPP TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_COMSUPP_FK1_1                                     */
/*==============================================================*/
create index AD_COMSUPP_FK1_1 on AD_COMSUPP (
   AD_SUPP_ID ASC
);

/*==============================================================*/
/* Index : AD_COMSUPP_FK1_2                                     */
/*==============================================================*/
create index AD_COMSUPP_FK1_2 on AD_COMSUPP (
   RF_COMM_ID ASC
);

/*==============================================================*/
/* Index : AD_COMSUPP_UN2_1                                     */
/*==============================================================*/
create unique index AD_COMSUPP_UN2_1 on AD_COMSUPP (
   AD_SUPP_ID ASC,
   RF_COMM_ID ASC
);

/*==============================================================*/
/* Table : AD_COMURB                                            */
/*==============================================================*/
drop public synonym AD_COMURB;
create table AD_COMURB  (
   AD_COMURB_ID         INTEGER                         not null,
   RF_COMM_ID           INTEGER                         not null,
   AD_COMURB_CARTECOMM  VARCHAR2(5)                     not null,
   AD_COMURB_POSPLU     VARCHAR2(5)                     not null,
   AD_COMURB_SCOT       VARCHAR2(5)                     not null,
   AD_COMURB_DTA        VARCHAR2(5)                     not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_COMURB_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_COMURB_PK1_1 primary key (AD_COMURB_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_COMURB is
'Urbanisme - commune';

comment on column AD_COMURB.AD_COMURB_ID is
'Identifiant de urbanisme-commune';

comment on column AD_COMURB.RF_COMM_ID is
'Identifiant de la commune';

comment on column AD_COMURB.AD_COMURB_CARTECOMM is
'Carte communale';

comment on column AD_COMURB.AD_COMURB_POSPLU is
'POS/PLU';

comment on column AD_COMURB.AD_COMURB_SCOT is
'SCOT';

comment on column AD_COMURB.AD_COMURB_DTA is
'DTA';

comment on column AD_COMURB.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_COMURB.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_COMURB for AD.AD_COMURB;
GRANT SELECT ON  AD_COMURB TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_COMURB_FK1_1                                      */
/*==============================================================*/
create index AD_COMURB_FK1_1 on AD_COMURB (
   RF_COMM_ID ASC
);

/*==============================================================*/
/* Table : AD_CPT                                               */
/*==============================================================*/
drop public synonym AD_CPT;
create table AD_CPT  (
   AD_CPT_ID            INTEGER                         not null,
   AD_CPT_COD           INTEGER                         not null,
   AD_IMM_ID            INTEGER                         not null,
   AD_COMIMP_ID         INTEGER                         not null,
   RF_TCOMPO_ID         INTEGER                         not null,
   RF_TOUV_ID           INTEGER                         not null,
   AD_CPT_DEN           VARCHAR2(50)                    not null,
   AD_CPT_ANREHAB       INTEGER,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_CPT_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   AD_CPT_NUM_CHORUS    VARCHAR2(6),
   constraint AD_CPT_PK1_1 primary key (AD_CPT_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_CPT is
'Composant';

comment on column AD_CPT.AD_CPT_ID is
'Identifiant du composant';

comment on column AD_CPT.AD_CPT_COD is
'Code composant';

comment on column AD_CPT.AD_IMM_ID is
'Identifiant de l''immeuble';

comment on column AD_CPT.AD_COMIMP_ID is
'Identifiant de la commune d''implantation';

comment on column AD_CPT.RF_TCOMPO_ID is
'Identifiant du type de composant';

comment on column AD_CPT.RF_TOUV_ID is
'Identifiant du type d''ouvrage';

comment on column AD_CPT.AD_CPT_DEN is
'Dénomination composant';

comment on column AD_CPT.AD_CPT_ANREHAB is
'Année de réhabilitation BATI';

comment on column AD_CPT.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_CPT.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

comment on column AD_CPT.AD_CPT_NUM_CHORUS is
'N° composant  CHORUS';

create public synonym AD_CPT for AD.AD_CPT;
GRANT SELECT ON  AD_CPT TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_CPT_FK1_1                                         */
/*==============================================================*/
create index AD_CPT_FK1_1 on AD_CPT (
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Index : AD_CPT_FK1_2                                         */
/*==============================================================*/
create index AD_CPT_FK1_2 on AD_CPT (
   RF_TCOMPO_ID ASC
);

/*==============================================================*/
/* Index : AD_CPT_UN2_1                                         */
/*==============================================================*/
create unique index AD_CPT_UN2_1 on AD_CPT (
   AD_CPT_COD ASC,
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Index : AD_CPT_FK1_3                                         */
/*==============================================================*/
create index AD_CPT_FK1_3 on AD_CPT (
   AD_COMIMP_ID ASC
);

/*==============================================================*/
/* Index : AD_CPT_FK1_4                                         */
/*==============================================================*/
create index AD_CPT_FK1_4 on AD_CPT (
   RF_TOUV_ID ASC
);

/*==============================================================*/
/* Table : AD_CPTBATI                                           */
/*==============================================================*/
drop public synonym AD_CPTBATI;
create table AD_CPTBATI  (
   AD_CPTBATI_ID        INTEGER                         not null,
   AD_CPT_ID            INTEGER                         not null,
   RF_ETATENT_ID        INTEGER                         not null,
   RF_TCONS_ID          INTEGER                         not null,
   RF_CPTIND_ID         INTEGER,
   AD_CPTBATI_ANCONST   INTEGER                         not null,
   AD_CPTBATI_NBNIV     INTEGER                         not null,
   AD_CPTBATI_NBSSOL    INTEGER                         not null,
   AD_CPTBATI_SHOD      NUMBER(9)                       not null,
   AD_CPTBATI_SHON      NUMBER(9)                       not null,
   AD_CPTBATI_SUTI      NUMBER(9)                       not null,
   AD_CPTBATI_NBLOG     INTEGER,
   AD_CPTBATI_NBLOGNAS  INTEGER,
   AD_CPTBATI_NBLOGUS   INTEGER,
   AD_CPTBATI_INDSAISISHON VARCHAR2(1)                     not null,
   AD_CPTBATI_CUTI      NUMBER(9)                       not null,
   AD_CPTBATI_SBAT      NUMBER(9),
   AD_CPTBATI_TOPTREFOND VARCHAR2(5),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_CPTBATI_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_CPTBATI_PK1_1 primary key (AD_CPTBATI_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_CPTBATI is
'Composant bâti souterrain et composant bâti aérien';

comment on column AD_CPTBATI.AD_CPTBATI_ID is
'Identifiant du composant bâti';

comment on column AD_CPTBATI.AD_CPT_ID is
'Identifiant du composant';

comment on column AD_CPTBATI.RF_ETATENT_ID is
'RF_ETATENT_ID';

comment on column AD_CPTBATI.RF_TCONS_ID is
'Identifiant du type de construction';

comment on column AD_CPTBATI.AD_CPTBATI_ANCONST is
'Année de construction BATI';

comment on column AD_CPTBATI.AD_CPTBATI_NBNIV is
'Nombre de niveaux BATI';

comment on column AD_CPTBATI.AD_CPTBATI_NBSSOL is
'Nombre de sous sol BATI';

comment on column AD_CPTBATI.AD_CPTBATI_SHOD is
'SHOD BATI';

comment on column AD_CPTBATI.AD_CPTBATI_SHON is
'SHON BATI';

comment on column AD_CPTBATI.AD_CPTBATI_SUTI is
'Surface utile BATI';

comment on column AD_CPTBATI.AD_CPTBATI_NBLOG is
'Nombre de logements BATI';

comment on column AD_CPTBATI.AD_CPTBATI_NBLOGNAS is
'Nombre de logements NAS BATI';

comment on column AD_CPTBATI.AD_CPTBATI_NBLOGUS is
'Nombre de logements US BATI';

comment on column AD_CPTBATI.AD_CPTBATI_INDSAISISHON is
'Indicateur saisi SHON';

comment on column AD_CPTBATI.AD_CPTBATI_CUTI is
'CUTI cptbati';

comment on column AD_CPTBATI.AD_CPTBATI_SBAT is
'Surface bâtie BAA';

comment on column AD_CPTBATI.AD_CPTBATI_TOPTREFOND is
'TREFOND';

comment on column AD_CPTBATI.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_CPTBATI.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_CPTBATI for AD.AD_CPTBATI;
GRANT SELECT ON  AD_CPTBATI TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_CPTBATI_FK1_1                                     */
/*==============================================================*/
create index AD_CPTBATI_FK1_1 on AD_CPTBATI (
   RF_ETATENT_ID ASC
);

/*==============================================================*/
/* Index : AD_CPTBATI_FK1_2                                     */
/*==============================================================*/
create unique index AD_CPTBATI_FK1_2 on AD_CPTBATI (
   AD_CPT_ID ASC
);

/*==============================================================*/
/* Index : AD_CPTBATI_FK1_3                                     */
/*==============================================================*/
create index AD_CPTBATI_FK1_3 on AD_CPTBATI (
   RF_TCONS_ID ASC
);

/*==============================================================*/
/* Index : AD_CPTBATI_FK1_4                                     */
/*==============================================================*/
create index AD_CPTBATI_FK1_4 on AD_CPTBATI (
   RF_CPTIND_ID ASC
);

/*==============================================================*/
/* Table : AD_CPTCOHER                                          */
/*==============================================================*/
drop public synonym AD_CPTCOHER;
create table AD_CPTCOHER  (
   AD_CPTCOHER_ID       INTEGER                         not null,
   AD_CPT_ID            INTEGER                         not null,
   AD_CPTCOHER_DECOMP   INTEGER                         not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_CPTCOHER_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_CPTCOHER_PK1_1 primary key (AD_CPTCOHER_ID)
)
tablespace TS_DATA_AD;

comment on table AD_CPTCOHER is
'Les indicateurs peuvent prendre les valeurs 0 ou 1 ou 2';

comment on column AD_CPTCOHER.AD_CPTCOHER_ID is
'Identifiant de l''indicateur de cohérence CPT';

comment on column AD_CPTCOHER.AD_CPT_ID is
'Identifiant du composant';

comment on column AD_CPTCOHER.AD_CPTCOHER_DECOMP is
'Décomposition physique';

comment on column AD_CPTCOHER.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_CPTCOHER.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_CPTCOHER for AD.AD_CPTCOHER;
GRANT SELECT ON  AD_CPTCOHER TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_CPTCOHER_FK1_1                                    */
/*==============================================================*/
create unique index AD_CPTCOHER_FK1_1 on AD_CPTCOHER (
   AD_CPT_ID ASC
);

/*==============================================================*/
/* Table : AD_CPTETU                                            */
/*==============================================================*/
create table AD_CPTETU  (
   AD_CPTETU_ID         INTEGER                         not null,
   AD_CPTETU_COD        INTEGER                         not null,
   AD_CPTETU_DEN        VARCHAR2(50)                    not null,
   RF_TOUV_ID           INTEGER                         not null,
   AD_IMM_ID            INTEGER                         not null,
   AD_CPTETU_OBS        VARCHAR2(250)                   not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                     not null,
   constraint AD_CPTETU_PK1_1 primary key (AD_CPTETU_ID)
);

comment on table AD_CPTETU is
'Composant à l''étude';

comment on column AD_CPTETU.AD_CPTETU_ID is
'Id du composant à l''étude';

comment on column AD_CPTETU.AD_CPTETU_COD is
'Numéro du composant à l''étude';

comment on column AD_CPTETU.AD_CPTETU_DEN is
'Dénomination du du composant à l''étude';

comment on column AD_CPTETU.RF_TOUV_ID is
'Type d''ouvrage ';

comment on column AD_CPTETU.AD_IMM_ID is
'Identifiant de l''immeuble';

comment on column AD_CPTETU.AD_CPTETU_OBS is
'Observations';

comment on column AD_CPTETU.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_CPTETU.AD_XTOPSUP is
'Indicateur de validité';

/*==============================================================*/
/* Index : AD_CPTETU_FK1_1                                      */
/*==============================================================*/
create index AD_CPTETU_FK1_1 on AD_CPTETU (
   RF_TOUV_ID ASC
);

/*==============================================================*/
/* Index : AD_CPTETU_FK1_2                                      */
/*==============================================================*/
create index AD_CPTETU_FK1_2 on AD_CPTETU (
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Table : AD_CPTHISTO                                          */
/*==============================================================*/
drop public synonym AD_CPTHISTO;
create table AD_CPTHISTO  (
   AD_CPTHISTO_ID       INTEGER                         not null,
   AD_CPTHISTO_COD      INTEGER                         not null,
   AD_IMM_ID            INTEGER                         not null,
   AD_CPTHISTO_DEN      VARCHAR2(50)                    not null,
   AD_CPTHISTO_TCOMPO_LIB VARCHAR2(3)                     not null,
   AD_CPTHISTO_ANDECONST INTEGER                         not null,
   AD_CPTHISTO_SBAT     NUMBER(9)                       not null,
   AD_CPTHISTO_SHOD     NUMBER(9)                       not null,
   AD_CPTHISTO_SHON     NUMBER(9)                       not null,
   AD_CPTHISTO_SAME     NUMBER(9)                       not null,
   AD_CPTHISTO_SUTI     NUMBER(9)                       not null,
   AD_CPTHISTO_NUMCHORUS VARCHAR2(6),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_CPTHISTO_TOUV_LIB VARCHAR2(100)                   not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_CPTHISTO_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_CPTHISTO_PK1_1 primary key (AD_CPTHISTO_ID)
);

comment on table AD_CPTHISTO is
'Composant historisé';

comment on column AD_CPTHISTO.AD_CPTHISTO_ID is
'Identifiant';

comment on column AD_CPTHISTO.AD_CPTHISTO_COD is
'Code composant';

comment on column AD_CPTHISTO.AD_IMM_ID is
'Identifiant de l''immeuble';

comment on column AD_CPTHISTO.AD_CPTHISTO_DEN is
'Dénomination composant arch';

comment on column AD_CPTHISTO.AD_CPTHISTO_TCOMPO_LIB is
'Type composant arch';

comment on column AD_CPTHISTO.AD_CPTHISTO_ANDECONST is
'Année déconstruction composant arch';

comment on column AD_CPTHISTO.AD_CPTHISTO_SBAT is
'SBATcomposant arch';

comment on column AD_CPTHISTO.AD_CPTHISTO_SHOD is
'SHOD composant arch';

comment on column AD_CPTHISTO.AD_CPTHISTO_SHON is
'SHON composant arch';

comment on column AD_CPTHISTO.AD_CPTHISTO_SAME is
'SAME composant arch';

comment on column AD_CPTHISTO.AD_CPTHISTO_SUTI is
'SUTI composant arch';

comment on column AD_CPTHISTO.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_CPTHISTO.AD_CPTHISTO_TOUV_LIB is
'Libellé classe fonctionnelle';

comment on column AD_CPTHISTO.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_CPTHISTO for AD.AD_CPTHISTO;
GRANT SELECT ON  AD_CPTHISTO TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_CPTHISTO_FK1_1                                    */
/*==============================================================*/
create index AD_CPTHISTO_FK1_1 on AD_CPTHISTO (
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Index : AD_CPTHISTO_UN2_1                                    */
/*==============================================================*/
create unique index AD_CPTHISTO_UN2_1 on AD_CPTHISTO (
   AD_CPTHISTO_COD ASC,
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Table : AD_CPTNBATI                                          */
/*==============================================================*/
drop public synonym AD_CPTNBATI;
create table AD_CPTNBATI  (
   AD_CPTNBATI_ID       INTEGER                         not null,
   AD_CPT_ID            INTEGER                         not null,
   AD_CPTNBATI_SURF     NUMBER(9)                       not null,
   AD_CPTNBATI_CUM      NUMBER(9)                       not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_CPTNBATI_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_CPTNBATI_PK1_1 primary key (AD_CPTNBATI_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_CPTNBATI is
'Composant aménagé et compossant non construit';

comment on column AD_CPTNBATI.AD_CPTNBATI_ID is
'Identifiant du composant non bâti';

comment on column AD_CPTNBATI.AD_CPT_ID is
'Identifiant du composant';

comment on column AD_CPTNBATI.AD_CPTNBATI_SURF is
'Surface composant non bâti';

comment on column AD_CPTNBATI.AD_CPTNBATI_CUM is
'Cumul surface composant non bâti';

comment on column AD_CPTNBATI.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_CPTNBATI.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_CPTNBATI for AD.AD_CPTNBATI;
GRANT SELECT ON  AD_CPTNBATI TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_CPTNBATI_FK1_1                                    */
/*==============================================================*/
create unique index AD_CPTNBATI_FK1_1 on AD_CPTNBATI (
   AD_CPT_ID ASC
);

/*==============================================================*/
/* Table : AD_CPTNIV                                            */
/*==============================================================*/
drop public synonym AD_CPTNIV;
create table AD_CPTNIV  (
   AD_CPTNIV_ID         INTEGER                         not null,
   AD_CPTBATI_ID        INTEGER                         not null,
   RF_TNIV_ID           INTEGER                        default 0 not null,
   AD_CPTNIV_NUM        INTEGER                         not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_CPTNIV_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_CPTNIV_PK1_1 primary key (AD_CPTNIV_ID)
);

comment on table AD_CPTNIV is
'Table contenant les niveaux des composants';

comment on column AD_CPTNIV.AD_CPTNIV_ID is
'identifiant du niveau du composant';

comment on column AD_CPTNIV.AD_CPTBATI_ID is
'Identifiant du composant bâti';

comment on column AD_CPTNIV.RF_TNIV_ID is
'Identifiant du type de niveau';

comment on column AD_CPTNIV.AD_CPTNIV_NUM is
'numéro du niveau';

comment on column AD_CPTNIV.AD_XDMAJ is
'date de maj';

comment on column AD_CPTNIV.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_CPTNIV for AD.AD_CPTNIV;
GRANT SELECT ON  AD_CPTNIV TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_CPTNIV_FK1_1                                      */
/*==============================================================*/
create index AD_CPTNIV_FK1_1 on AD_CPTNIV (
   AD_CPTBATI_ID ASC
);

/*==============================================================*/
/* Index : AD_CPTNIV_UN2_1                                      */
/*==============================================================*/
create unique index AD_CPTNIV_UN2_1 on AD_CPTNIV (
   AD_CPTBATI_ID ASC,
   AD_CPTNIV_NUM ASC
);

/*==============================================================*/
/* Index : AD_CPTNIV_FK1_2                                      */
/*==============================================================*/
create index AD_CPTNIV_FK1_2 on AD_CPTNIV (
   RF_TNIV_ID ASC
);

/*==============================================================*/
/* Table : AD_CPT_OLD                                           */
/*==============================================================*/
drop public synonym AD_CPT_OLD;
create table AD_CPT_OLD  (
   AD_CPT_OLD_ID        INTEGER                         not null,
   AD_CPT_ID            INTEGER                         not null,
   AD_CPT_NUMSAGRI      VARCHAR2(4),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_CPT_OLD_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_CPT_OLD_PK1_1 primary key (AD_CPT_OLD_ID)
);

comment on table AD_CPT_OLD is
'Composant Sagri
Cette table stocke l''ancien composant sagri.';

comment on column AD_CPT_OLD.AD_CPT_OLD_ID is
'Identifiant du composant';

comment on column AD_CPT_OLD.AD_CPT_ID is
'Identifiant du composant';

comment on column AD_CPT_OLD.AD_CPT_NUMSAGRI is
'Ancien code sagri';

comment on column AD_CPT_OLD.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_CPT_OLD.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_CPT_OLD for AD.AD_CPT_OLD;
GRANT SELECT ON  AD_CPT_OLD TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_CPT_OLD_NUMSAGRI_IDX                              */
/*==============================================================*/
create index AD_CPT_OLD_NUMSAGRI_IDX on AD_CPT_OLD (
   AD_CPT_NUMSAGRI ASC
);

/*==============================================================*/
/* Table : AD_CRITERESEDT                                       */
/*==============================================================*/
drop public synonym AD_CRITERESEDT;
create table AD_CRITERESEDT  (
   AD_CRITERESEDT_ID    INTEGER                         not null,
   AD_BIBLIOEDT_ID      INTEGER                         not null,
   AD_CRITERESEDT_NOM   VARCHAR2(100)                   not null,
   AD_CRITERESEDT_VAL   VARCHAR2(100)                   not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_CRITERESEDT_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_CRITERESEDT_PK1_1 primary key (AD_CRITERESEDT_ID)
);

comment on table AD_CRITERESEDT is
'Critères de sélection des éditions';

comment on column AD_CRITERESEDT.AD_CRITERESEDT_ID is
'Identifiant du critère';

comment on column AD_CRITERESEDT.AD_BIBLIOEDT_ID is
'Identifiant de la bibliothèque';

comment on column AD_CRITERESEDT.AD_CRITERESEDT_NOM is
'Nom du critère';

comment on column AD_CRITERESEDT.AD_CRITERESEDT_VAL is
'Valeur du critère';

comment on column AD_CRITERESEDT.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_CRITERESEDT.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_CRITERESEDT for AD.AD_CRITERESEDT;
GRANT SELECT ON  AD_CRITERESEDT TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_CRITERESEDT_FK1_1                                 */
/*==============================================================*/
create index AD_CRITERESEDT_FK1_1 on AD_CRITERESEDT (
   AD_BIBLIOEDT_ID ASC
);

/*==============================================================*/
/* Table : AD_DECDPA                                            */
/*==============================================================*/
drop public synonym AD_DECDPA;
create table AD_DECDPA  (
   AD_DECDPA_ID         INTEGER                         not null,
   AD_DECDPU_ID         INTEGER                         not null,
   AD_DECDPA_REFAVISCSINA VARCHAR2(15)                    not null,
   AD_DECDPA_DTAVISCSINA VARCHAR2(15),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_DECDPA_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_DECDPA_PK1_1 primary key (AD_DECDPA_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_DECDPA is
'Aéronautique';

comment on column AD_DECDPA.AD_DECDPA_ID is
'Identifiant de Aéronautique';

comment on column AD_DECDPA.AD_DECDPU_ID is
'Identifiant du déclassement domaine public';

comment on column AD_DECDPA.AD_DECDPA_REFAVISCSINA is
'Référence avis CSINA déclassement DP';

comment on column AD_DECDPA.AD_DECDPA_DTAVISCSINA is
'Date avis CSINA déclassement DP';

comment on column AD_DECDPA.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_DECDPA.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_DECDPA for AD.AD_DECDPA;
GRANT SELECT ON  AD_DECDPA TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_DECDPA_FK1_1                                      */
/*==============================================================*/
create unique index AD_DECDPA_FK1_1 on AD_DECDPA (
   AD_DECDPU_ID ASC
);

/*==============================================================*/
/* Table : AD_DECDPU                                            */
/*==============================================================*/
drop public synonym AD_DECDPU;
create table AD_DECDPU  (
   AD_DECDPU_ID         INTEGER                         not null,
   AD_IMM_ID            INTEGER                         not null,
   RF_NATTXT_ID         INTEGER                         not null,
   AD_DECDPU_NUM        INTEGER                         not null,
   AD_DECDPU_DTTXT      VARCHAR2(15)                    not null,
   AD_CPTNBATI_SURF     NUMBER(9)                       not null,
   AD_CPTNBATI_CUM      NUMBER(9)                       not null,
   AD_DECDPU_STOT       NUMBER(9)                       not null,
   AD_DECDPU_SBAT       NUMBER(9)                       not null,
   AD_DECDPU_SUTI       NUMBER(9)                       not null,
   AD_DECDPU_SHOD       NUMBER(9)                       not null,
   AD_DECDPU_SHON       NUMBER(9)                       not null,
   AD_DECDPU_SAME       NUMBER(9)                       not null,
   AD_DECDPU_SNCO       NUMBER(9)                       not null,
   AD_DECDPU_INDSAISISHON VARCHAR2(1)                     not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_DECDPU_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_DECDPU_PK1_1 primary key (AD_DECDPU_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_DECDPU is
'(Dé)classement domaine public';

comment on column AD_DECDPU.AD_DECDPU_ID is
'Identifiant du déclassement domaine public';

comment on column AD_DECDPU.AD_IMM_ID is
'Identifiant de l''immeuble';

comment on column AD_DECDPU.RF_NATTXT_ID is
'Identifiant de la nature de texte';

comment on column AD_DECDPU.AD_DECDPU_NUM is
'Numéro ordre déclassement DP';

comment on column AD_DECDPU.AD_DECDPU_DTTXT is
'Date texte déclassement DP';

comment on column AD_DECDPU.AD_CPTNBATI_SURF is
'Surface composant non bâti';

comment on column AD_DECDPU.AD_CPTNBATI_CUM is
'Cumul surface composant non bâti';

comment on column AD_DECDPU.AD_DECDPU_STOT is
'Emprise déclassement DP';

comment on column AD_DECDPU.AD_DECDPU_SBAT is
'Emprise bâtie déclassement DP';

comment on column AD_DECDPU.AD_DECDPU_SUTI is
'Surface utile déclassement DP';

comment on column AD_DECDPU.AD_DECDPU_SHOD is
'SHOD déclassement DP';

comment on column AD_DECDPU.AD_DECDPU_SHON is
'SHON déclassement DP';

comment on column AD_DECDPU.AD_DECDPU_SAME is
'Surface aire aménagée déclassement DP';

comment on column AD_DECDPU.AD_DECDPU_SNCO is
'Surface aire non construite déclassement DP';

comment on column AD_DECDPU.AD_DECDPU_INDSAISISHON is
'Indicateur saisi SHON';

comment on column AD_DECDPU.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_DECDPU.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_DECDPU for AD.AD_DECDPU;
GRANT SELECT ON  AD_DECDPU TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_DECDPU_FK1_1                                      */
/*==============================================================*/
create index AD_DECDPU_FK1_1 on AD_DECDPU (
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Index : AD_DECDPU_FK1_2                                      */
/*==============================================================*/
create index AD_DECDPU_FK1_2 on AD_DECDPU (
   RF_NATTXT_ID ASC
);

/*==============================================================*/
/* Index : AD_DECDPU_UN1_1                                      */
/*==============================================================*/
create unique index AD_DECDPU_UN1_1 on AD_DECDPU (
   AD_DECDPU_NUM ASC
);

/*==============================================================*/
/* Table : AD_DECMIN                                            */
/*==============================================================*/
drop public synonym AD_DECMIN;
create table AD_DECMIN  (
   AD_DECMIN_ID         INTEGER                         not null,
   AD_ORIENFIN_ID       INTEGER                         not null,
   AD_NIVDEC_ID         INTEGER                         not null,
   AD_STATUTDM_ID       INTEGER                         not null,
   AD_DECMIN_REF        VARCHAR2(50)                    not null,
   AD_DECMIN_DT         VARCHAR2(15)                    not null,
   AD_DECMIN_MNT        NUMBER(9)                       not null,
   AD_DECMIN_MEMO       VARCHAR2(150),
   AD_DECMIN_ETAT       NUMBER(1)                       not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_DECMIN_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_DECMIN_PK1_1 primary key (AD_DECMIN_ID)
);

comment on table AD_DECMIN is
'Décision ministérielle';

comment on column AD_DECMIN.AD_DECMIN_ID is
'Identifiant Décision Ministérielle';

comment on column AD_DECMIN.AD_ORIENFIN_ID is
'Identifiant de l''orientation financière';

comment on column AD_DECMIN.AD_NIVDEC_ID is
'Identifiant du niveau de décision';

comment on column AD_DECMIN.AD_STATUTDM_ID is
'Identifiant du statut de la DM';

comment on column AD_DECMIN.AD_DECMIN_REF is
'Réference DM';

comment on column AD_DECMIN.AD_DECMIN_DT is
'Date DM';

comment on column AD_DECMIN.AD_DECMIN_MNT is
'Montant DM';

comment on column AD_DECMIN.AD_DECMIN_MEMO is
'Commentaire sur la DM';

comment on column AD_DECMIN.AD_DECMIN_ETAT is
'Etat de saisie de la DM. Permet de savoir à quel niveau de saisie la DM se situe (et par conséquent quels sont les onglets à rendre actifs).';

comment on column AD_DECMIN.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_DECMIN.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_DECMIN for AD.AD_DECMIN;
GRANT SELECT ON  AD_DECMIN TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_DECMIN_UN2_1                                      */
/*==============================================================*/
create unique index AD_DECMIN_UN2_1 on AD_DECMIN (
   AD_DECMIN_REF ASC,
   AD_DECMIN_DT ASC
);

/*==============================================================*/
/* Index : AD_DECMIN_FK1_2                                      */
/*==============================================================*/
create index AD_DECMIN_FK1_2 on AD_DECMIN (
   AD_ORIENFIN_ID ASC
);

/*==============================================================*/
/* Index : AD_DECMIN_FK1_3                                      */
/*==============================================================*/
create index AD_DECMIN_FK1_3 on AD_DECMIN (
   AD_NIVDEC_ID ASC
);

/*==============================================================*/
/* Index : AD_DECMIN_FK1_4                                      */
/*==============================================================*/
create index AD_DECMIN_FK1_4 on AD_DECMIN (
   AD_STATUTDM_ID ASC
);

/*==============================================================*/
/* Table : AD_DECMINARE                                         */
/*==============================================================*/
drop public synonym AD_DECMINARE;
create table AD_DECMINARE  (
   AD_DECMINARE_ID      INTEGER                         not null,
   AD_DECMIN_ID         INTEGER                         not null,
   RF_ARE_ID            INTEGER                         not null,
   AD_DECMINARE_MNT     NUMBER(9)                      default 0,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_DECMINARE_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_DECMINARE_PK1_1 primary key (AD_DECMINARE_ID)
);

comment on table AD_DECMINARE is
'Table de jointure entre RF_ARE et AD_DECMIN';

comment on column AD_DECMINARE.AD_DECMINARE_ID is
'Identifiant de AD_DECMINARE';

comment on column AD_DECMINARE.AD_DECMIN_ID is
'Identifiant de Décision Ministérielle';

comment on column AD_DECMINARE.RF_ARE_ID is
'Identifiant de l''attributaire';

comment on column AD_DECMINARE.AD_DECMINARE_MNT is
'Montant par attributaire';

comment on column AD_DECMINARE.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_DECMINARE.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_DECMINARE for AD.AD_DECMINARE;
GRANT SELECT ON  AD_DECMINARE TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_DECMINARE_FK1_1                                   */
/*==============================================================*/
create index AD_DECMINARE_FK1_1 on AD_DECMINARE (
   AD_DECMIN_ID ASC
);

/*==============================================================*/
/* Index : AD_DECMINARE_FK1_2                                   */
/*==============================================================*/
create index AD_DECMINARE_FK1_2 on AD_DECMINARE (
   RF_ARE_ID ASC
);

/*==============================================================*/
/* Index : AD_DECMINARE_UN2_1                                   */
/*==============================================================*/
create unique index AD_DECMINARE_UN2_1 on AD_DECMINARE (
   AD_DECMIN_ID ASC,
   RF_ARE_ID ASC
);

/*==============================================================*/
/* Table : AD_DECNDPA                                           */
/*==============================================================*/
drop public synonym AD_DECNDPA;
create table AD_DECNDPA  (
   AD_DECNPDA_ID        INTEGER                         not null,
   AD_DECDPU_ID         INTEGER                         not null,
   AD_DECNPDA_REFDECMIN VARCHAR2(15)                    not null,
   AD_DECNPDA_DTDEC     VARCHAR2(15)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_DECNDPA_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_DECNPDA_PK1_1 primary key (AD_DECNPDA_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_DECNDPA is
'Pas aéronatique';

comment on column AD_DECNDPA.AD_DECNPDA_ID is
'Identifiant de pas aéronautique';

comment on column AD_DECNDPA.AD_DECDPU_ID is
'Identifiant du déclassement domaine public';

comment on column AD_DECNDPA.AD_DECNPDA_REFDECMIN is
'Référence décision ministre déclassement DP';

comment on column AD_DECNDPA.AD_DECNPDA_DTDEC is
'Date décision déclassement DP';

comment on column AD_DECNDPA.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_DECNDPA.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_DECNDPA for AD.AD_DECNDPA;
GRANT SELECT ON  AD_DECNDPA TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_DECNPDA_FK1_1                                     */
/*==============================================================*/
create unique index AD_DECNPDA_FK1_1 on AD_DECNDPA (
   AD_DECDPU_ID ASC
);

/*==============================================================*/
/* Table : AD_DOMAINE                                           */
/*==============================================================*/
drop public synonym AD_DOMAINE;
create table AD_DOMAINE  (
   AD_DOMAINE_ID        INTEGER                         not null,
   AD_DOMAINE_COD       VARCHAR2(5)                     not null,
   AD_DOMAINE_LIB       VARCHAR2(50)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_DOMAINE_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_DOMAINE_PK1_1 primary key (AD_DOMAINE_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_DOMAINE is
'Domaine';

comment on column AD_DOMAINE.AD_DOMAINE_ID is
'Identifaint du DOMAINE';

comment on column AD_DOMAINE.AD_DOMAINE_LIB is
'Libellé domaine ';

comment on column AD_DOMAINE.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_DOMAINE.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_DOMAINE for AD.AD_DOMAINE;
GRANT SELECT ON  AD_DOMAINE TO AD_SEL_A_UTI;

/*==============================================================*/
/* Table : AD_ECHCOMP                                           */
/*==============================================================*/
drop public synonym AD_ECHCOMP;
create table AD_ECHCOMP  (
   AD_ECHCOMP_ID        INTEGER                         not null,
   AD_OPEDOM_ID         INTEGER                         not null,
   RF_TBENECH_ID        INTEGER                         not null,
   RF_AFFECT_ID         INTEGER                         not null,
   AD_ECHCOMP_BENEF     VARCHAR2(75)                    not null,
   AD_ECHCOMP_VV1       NUMBER(9)                      default 0 not null,
   AD_ECHCOMP_VV2       NUMBER(9)                      default 0 not null,
   AD_ECHCOMP_DIFFVV1_VV2 NUMBER(9)                      default 0 not null,
   AD_ECHCOMP_PCC       NUMBER(9)                      default 0 not null,
   AD_ECHCOMP_INDEMNITE NUMBER(9)                      default 0 not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_ECHCOMP_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_ECHCOMP_PK1_1 primary key (AD_ECHCOMP_ID)
);

comment on table AD_ECHCOMP is
'Echange compensé';

comment on column AD_ECHCOMP.AD_ECHCOMP_ID is
'Identifiant Echange compensé';

comment on column AD_ECHCOMP.AD_OPEDOM_ID is
'Identifiant de l''opération domaniale';

comment on column AD_ECHCOMP.RF_TBENECH_ID is
'Identifiant du type de bénéficiaire';

comment on column AD_ECHCOMP.RF_AFFECT_ID is
'Identifiant affectataire';

comment on column AD_ECHCOMP.AD_ECHCOMP_BENEF is
'Bénéficiaire EC';

comment on column AD_ECHCOMP.AD_ECHCOMP_VV1 is
'Valeur vénale de l''immeuble en sortie';

comment on column AD_ECHCOMP.AD_ECHCOMP_VV2 is
'Valeur vénale de l''immeuble en entrée';

comment on column AD_ECHCOMP.AD_ECHCOMP_DIFFVV1_VV2 is
'Différence de valeur sortie - entrée';

comment on column AD_ECHCOMP.AD_ECHCOMP_PCC is
'Participation constitutive complémentaire';

comment on column AD_ECHCOMP.AD_ECHCOMP_INDEMNITE is
'Indemnité';

comment on column AD_ECHCOMP.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_ECHCOMP.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_ECHCOMP for AD.AD_ECHCOMP;
GRANT SELECT ON  AD_ECHCOMP TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_ECHCOMP_FK1_1                                     */
/*==============================================================*/
create index AD_ECHCOMP_FK1_1 on AD_ECHCOMP (
   RF_TBENECH_ID ASC
);

/*==============================================================*/
/* Index : AD_ECHCOMP_FK1_2                                     */
/*==============================================================*/
create unique index AD_ECHCOMP_FK1_2 on AD_ECHCOMP (
   AD_OPEDOM_ID ASC
);

/*==============================================================*/
/* Index : AD_ECHCOMP_FK1_3                                     */
/*==============================================================*/
create index AD_ECHCOMP_FK1_3 on AD_ECHCOMP (
   RF_AFFECT_ID ASC
);

/*==============================================================*/
/* Table : AD_ECHSIMP                                           */
/*==============================================================*/
drop public synonym AD_ECHSIMP;
create table AD_ECHSIMP  (
   AD_ECHSIMP_ID        INTEGER                         not null,
   RF_TSOULTE_ID        INTEGER                         not null,
   AD_OPEDOM_ID         INTEGER                         not null,
   AD_ECHSIMP_ECHANGISTE VARCHAR2(75)                    not null,
   AD_ECHSIMP_REFPUBHYPO VARCHAR2(50),
   AD_ECHSIMP_DTPUBHYPO VARCHAR2(15),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_ECHSIMP_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_ECH_PK1_1 primary key (AD_ECHSIMP_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_ECHSIMP is
'Echange simple avec ou sans soulte';

comment on column AD_ECHSIMP.AD_ECHSIMP_ID is
'Identifiant de l''échange simple';

comment on column AD_ECHSIMP.RF_TSOULTE_ID is
'RF_TSOULTE_ID';

comment on column AD_ECHSIMP.AD_OPEDOM_ID is
'Identifiant de l''opération domaniale';

comment on column AD_ECHSIMP.AD_ECHSIMP_ECHANGISTE is
'Echangiste';

comment on column AD_ECHSIMP.AD_ECHSIMP_REFPUBHYPO is
'Référence de publication aux hypothèques';

comment on column AD_ECHSIMP.AD_ECHSIMP_DTPUBHYPO is
'Date de la publication aux hypothèques';

comment on column AD_ECHSIMP.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_ECHSIMP.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_ECHSIMP for AD.AD_ECHSIMP;
GRANT SELECT ON  AD_ECHSIMP TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_ECHSIMP_FK1_1                                     */
/*==============================================================*/
create index AD_ECHSIMP_FK1_1 on AD_ECHSIMP (
   RF_TSOULTE_ID ASC
);

/*==============================================================*/
/* Index : AD_ECHSIMP_FK1_2                                     */
/*==============================================================*/
create unique index AD_ECHSIMP_FK1_2 on AD_ECHSIMP (
   AD_OPEDOM_ID ASC
);

/*==============================================================*/
/* Table : AD_EIM                                               */
/*==============================================================*/
drop public synonym AD_EIM;
create table AD_EIM  (
   AD_EIM_ID            INTEGER                         not null,
   AD_EIM_LIB           VARCHAR2(40)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_EIM_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_EIM_PK1_1 primary key (AD_EIM_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_EIM is
'EIM';

comment on column AD_EIM.AD_EIM_ID is
'Identifiant de l''EIM';

comment on column AD_EIM.AD_EIM_LIB is
'Libellé EIM';

comment on column AD_EIM.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_EIM.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_EIM for AD.AD_EIM;
GRANT SELECT ON  AD_EIM TO AD_SEL_A_UTI;

/*==============================================================*/
/* Table : AD_EXCLUSUB                                          */
/*==============================================================*/
drop public synonym AD_EXCLUSUB;
create table AD_EXCLUSUB  (
   AD_EXCLUSUB_ID       INTEGER                         not null,
   RF_LCLCLAUTIL_ID     INTEGER,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_EXCLUSUB_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_EXCLUSUB_PK1_1 primary key (AD_EXCLUSUB_ID)
);

comment on table AD_EXCLUSUB is
'exclusion';

comment on column AD_EXCLUSUB.AD_EXCLUSUB_ID is
'Identifiant du journal des MAJ Chorus';

comment on column AD_EXCLUSUB.RF_LCLCLAUTIL_ID is
'RF_CLUTLOC_ID';

comment on column AD_EXCLUSUB.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_EXCLUSUB.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_EXCLUSUB for AD.AD_EXCLUSUB;
GRANT SELECT ON  AD_EXCLUSUB TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_EXCLUSUB_FK1_1                                    */
/*==============================================================*/
create index AD_EXCLUSUB_FK1_1 on AD_EXCLUSUB (
   RF_LCLCLAUTIL_ID ASC
);

/*==============================================================*/
/* Table : AD_GESTEDT                                           */
/*==============================================================*/
drop public synonym AD_GESTEDT;
create table AD_GESTEDT  (
   AD_GESTEDT_ID        INTEGER                         not null,
   AD_TEDT_ID           INTEGER                         not null,
   AD_TETATEDT_ID       INTEGER                         not null,
   AD_GESTEDT_DEMANDEUR VARCHAR2(100)                   not null,
   AD_GESTEDT_REF       VARCHAR2(100)                   not null,
   AD_GESTEDT_LIBERREUR VARCHAR2(2048),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_GESTEDT_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_GESTEDT_PK1_1 primary key (AD_GESTEDT_ID)
);

comment on table AD_GESTEDT is
'Gestion des éditions';

comment on column AD_GESTEDT.AD_GESTEDT_ID is
'Identifiant de la gestion des éditions';

comment on column AD_GESTEDT.AD_TEDT_ID is
'Identifiant du type d''édition';

comment on column AD_GESTEDT.AD_TETATEDT_ID is
'identifiant de l''état de l''édition';

comment on column AD_GESTEDT.AD_GESTEDT_DEMANDEUR is
'Demandeur de l''édition';

comment on column AD_GESTEDT.AD_GESTEDT_REF is
'Référence de l''édition';

comment on column AD_GESTEDT.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_GESTEDT.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_GESTEDT for AD.AD_GESTEDT;
GRANT SELECT ON  AD_GESTEDT TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_GESTEDT_FK1_1                                     */
/*==============================================================*/
create index AD_GESTEDT_FK1_1 on AD_GESTEDT (
   AD_TEDT_ID ASC
);

/*==============================================================*/
/* Index : AD_GESTEDT_UN2_1                                     */
/*==============================================================*/
create unique index AD_GESTEDT_UN2_1 on AD_GESTEDT (
   AD_GESTEDT_REF ASC,
   AD_TETATEDT_ID ASC
);

/*==============================================================*/
/* Index : AD_GESTEDT_FK1_2                                     */
/*==============================================================*/
create index AD_GESTEDT_FK1_2 on AD_GESTEDT (
   AD_TETATEDT_ID ASC
);

/*==============================================================*/
/* Table : AD_IMM                                               */
/*==============================================================*/
drop public synonym AD_IMM;
create table AD_IMM  (
   AD_IMM_ID            INTEGER                         not null,
   AD_IMM_COD           VARCHAR2(10)                    not null,
   AD_EIM_ID            INTEGER                         not null,
   RF_GRDCMP_ID         INTEGER                         not null,
   RF_BASE_ID           INTEGER                         not null,
   RF_RATFIS_ID         INTEGER                         not null,
   RF_COMMGAR_ID        INTEGER                         not null,
   AD_AFAE_ID           INTEGER                         not null,
   RF_IMMIND_ID         INTEGER                         not null,
   RF_SEGPAT_ID         INTEGER                         not null,
   RF_AFFSJCT_ID        INTEGER                         not null,
   RF_SCTUTIL_ID        INTEGER                         not null,
   AD_REPOCC_ID         INTEGER                         not null,
   RF_AFFAERO_ID        INTEGER                         not null,
   AD_SMAJ_ID           INTEGER                         not null,
   RF_BDD_ID            INTEGER                         not null,
   RF_COMM_ID           INTEGER,
   AD_IMM_DEN           VARCHAR2(40)                    not null,
   AD_IMM_ALTI_NEG      INTEGER,
   AD_IMM_NATCONST      VARCHAR2(35),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_IMM_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   AD_IMM_SITECHORUS    VARCHAR2(6),
   AD_IMM_ELIGIBLECHORUS VARCHAR2(5)                    default 'FALSE' not null
      constraint AD_IMM_ELIGIBLECH_CK1_2 check (AD_IMM_ELIGIBLECHORUS in ('TRUE','FALSE')),
   AD_IMM_MAJCHORUS     VARCHAR2(5)                    default 'FALSE' not null
      constraint AD_IMM_CK1_3 check (AD_IMM_MAJCHORUS in ('TRUE','FALSE')),
   constraint AD_IMM_PK1_1 primary key (AD_IMM_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_IMM is
'Immeuble';

comment on column AD_IMM.AD_IMM_ID is
'Identifiant de l''immeuble';

comment on column AD_IMM.AD_IMM_COD is
'Code immeuble';

comment on column AD_IMM.AD_EIM_ID is
'Identifiant de l''EIM';

comment on column AD_IMM.RF_GRDCMP_ID is
'Identifiant du grand camp national';

comment on column AD_IMM.RF_BASE_ID is
'Identifiant de la base aérienne';

comment on column AD_IMM.RF_RATFIS_ID is
'Identifiant du rattachement fiscal';

comment on column AD_IMM.RF_COMMGAR_ID is
'Identifiant de la commune';

comment on column AD_IMM.AD_AFAE_ID is
'Identifaint de l''affectation aéronautique';

comment on column AD_IMM.RF_IMMIND_ID is
'Identifiant de l''indicateur immeuble';

comment on column AD_IMM.RF_SEGPAT_ID is
'Identifiant de la segmentation du patrimoine';

comment on column AD_IMM.RF_AFFSJCT_ID is
'Identifiant de l''affectataire sous jacent';

comment on column AD_IMM.RF_SCTUTIL_ID is
'Identifiant de la sous catégorie';

comment on column AD_IMM.AD_REPOCC_ID is
'Identifiant';

comment on column AD_IMM.RF_AFFAERO_ID is
'Identifiant de l''affectation aéronautique';

comment on column AD_IMM.AD_SMAJ_ID is
'Identifiant du service de mise à jour';

comment on column AD_IMM.RF_BDD_ID is
'Identifiant de la Base de Défense';

comment on column AD_IMM.RF_COMM_ID is
'Identifiant de la commune';

comment on column AD_IMM.AD_IMM_DEN is
'Dénomination immeuble';

comment on column AD_IMM.AD_IMM_ALTI_NEG is
'Altitude (cette info peut être négative)';

comment on column AD_IMM.AD_IMM_NATCONST is
'Nature et constitution du terrain';

comment on column AD_IMM.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_IMM.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

comment on column AD_IMM.AD_IMM_SITECHORUS is
'Numéro site Chorus';

comment on column AD_IMM.AD_IMM_ELIGIBLECHORUS is
'Eligible CHORUS ';

comment on column AD_IMM.AD_IMM_MAJCHORUS is
'Maj CHORUS en attente';

create public synonym AD_IMM for AD.AD_IMM;
GRANT SELECT ON  AD_IMM TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_IMM_FK1_1                                         */
/*==============================================================*/
create index AD_IMM_FK1_1 on AD_IMM (
   AD_EIM_ID ASC
);

/*==============================================================*/
/* Index : AD_IMM_FK1_2                                         */
/*==============================================================*/
create index AD_IMM_FK1_2 on AD_IMM (
   AD_SMAJ_ID ASC
);

/*==============================================================*/
/* Index : AD_IMM_FK1_3                                         */
/*==============================================================*/
create index AD_IMM_FK1_3 on AD_IMM (
   RF_SEGPAT_ID ASC
);

/*==============================================================*/
/* Index : AD_IMM_FK1_4                                         */
/*==============================================================*/
create index AD_IMM_FK1_4 on AD_IMM (
   AD_AFAE_ID ASC
);

/*==============================================================*/
/* Index : AD_IMM_FK1_5                                         */
/*==============================================================*/
create index AD_IMM_FK1_5 on AD_IMM (
   RF_RATFIS_ID ASC
);

/*==============================================================*/
/* Index : AD_IMM_FK1_6                                         */
/*==============================================================*/
create index AD_IMM_FK1_6 on AD_IMM (
   RF_IMMIND_ID ASC
);

/*==============================================================*/
/* Index : AD_IMM_FK1_7                                         */
/*==============================================================*/
create index AD_IMM_FK1_7 on AD_IMM (
   AD_REPOCC_ID ASC
);

/*==============================================================*/
/* Index : AD_IMM_FK1_8                                         */
/*==============================================================*/
create index AD_IMM_FK1_8 on AD_IMM (
   RF_SCTUTIL_ID ASC
);

/*==============================================================*/
/* Index : AD_IMM_FK1_9                                         */
/*==============================================================*/
create index AD_IMM_FK1_9 on AD_IMM (
   RF_BASE_ID ASC
);

/*==============================================================*/
/* Index : AD_IMM_FK1_10                                        */
/*==============================================================*/
create index AD_IMM_FK1_10 on AD_IMM (
   RF_GRDCMP_ID ASC
);

/*==============================================================*/
/* Index : AD_IMM_FK1_12                                        */
/*==============================================================*/
create index AD_IMM_FK1_12 on AD_IMM (
   RF_COMM_ID ASC
);

/*==============================================================*/
/* Index : AD_IMM_UN1_1                                         */
/*==============================================================*/
create unique index AD_IMM_UN1_1 on AD_IMM (
   AD_IMM_COD ASC
);

/*==============================================================*/
/* Index : AD_IMM_FK1_11                                        */
/*==============================================================*/
create index AD_IMM_FK1_11 on AD_IMM (
   RF_AFFAERO_ID ASC
);

/*==============================================================*/
/* Index : AD_IMM_FK1_13                                        */
/*==============================================================*/
create index AD_IMM_FK1_13 on AD_IMM (
   RF_AFFSJCT_ID ASC
);

/*==============================================================*/
/* Index : AD_IMM_FK1_14                                        */
/*==============================================================*/
create index AD_IMM_FK1_14 on AD_IMM (
   RF_BDD_ID ASC
);

/*==============================================================*/
/* Table : AD_IMMADR                                            */
/*==============================================================*/
drop public synonym AD_IMMADR;
create table AD_IMMADR  (
   AD_IMMADR_ID         INTEGER                         not null,
   AD_IMM_ID            INTEGER                         not null,
   RF_COMM_ID           INTEGER                         not null,
   RF_NATVOI_ID         INTEGER                         not null,
   AD_IMMADR_INFL       VARCHAR2(5),
   AD_IMMADR_INFN       INTEGER,
   AD_IMMADR_SUPN       INTEGER,
   AD_IMMADR_SUPL       VARCHAR2(5),
   AD_IMMADR_DES        VARCHAR2(200)                   not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_IMMADR_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_IMMADR_PK1_1 primary key (AD_IMMADR_ID)
)
tablespace TS_DATA_AD;

comment on table AD_IMMADR is
'Adresse géographique';

comment on column AD_IMMADR.AD_IMMADR_ID is
'Identifiant de l''adresse géographique';

comment on column AD_IMMADR.AD_IMM_ID is
'Identifiant de l''immeuble';

comment on column AD_IMMADR.RF_COMM_ID is
'Identifiant de la commune';

comment on column AD_IMMADR.RF_NATVOI_ID is
'Identifiant de la nature de la voie';

comment on column AD_IMMADR.AD_IMMADR_INFL is
'Lettre inférieur';

comment on column AD_IMMADR.AD_IMMADR_INFN is
'Numéro inférieur';

comment on column AD_IMMADR.AD_IMMADR_SUPN is
'Numéro supérieur';

comment on column AD_IMMADR.AD_IMMADR_SUPL is
'Lettre supérieur';

comment on column AD_IMMADR.AD_IMMADR_DES is
'Désignation voie ou lieu dit';

comment on column AD_IMMADR.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_IMMADR.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_IMMADR for AD.AD_IMMADR;
GRANT SELECT ON  AD_IMMADR TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_IMMADR_FK1_2                                      */
/*==============================================================*/
create index AD_IMMADR_FK1_2 on AD_IMMADR (
   RF_COMM_ID ASC
);

/*==============================================================*/
/* Index : AD_IMMADR_FK1_1                                      */
/*==============================================================*/
create index AD_IMMADR_FK1_1 on AD_IMMADR (
   RF_NATVOI_ID ASC
);

/*==============================================================*/
/* Index : AD_IMMADR_FK1_3                                      */
/*==============================================================*/
create unique index AD_IMMADR_FK1_3 on AD_IMMADR (
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Table : AD_IMMARE                                            */
/*==============================================================*/
drop public synonym AD_IMMARE;
create table AD_IMMARE  (
   AD_IMMARE_ID         INTEGER                         not null,
   AD_IMM_ID            INTEGER                         not null,
   RF_ARE_ID            INTEGER                         not null,
   AD_IMMARE_STOT       NUMBER(9)                       not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_IMMARE_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_IMMARE_PK1_1 primary key (AD_IMMARE_ID)
)
tablespace TS_DATA_AD;

comment on table AD_IMMARE is
'avoir pour attributaires sur immeuble ';

comment on column AD_IMMARE.AD_IMMARE_ID is
'Identifiant de l''attributaires sur immeuble';

comment on column AD_IMMARE.AD_IMM_ID is
'Identifiant de l''immeuble';

comment on column AD_IMMARE.RF_ARE_ID is
'Identifiant de l''attributaire';

comment on column AD_IMMARE.AD_IMMARE_STOT is
'Emprise de l''are sur immeuble ';

comment on column AD_IMMARE.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_IMMARE.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_IMMARE for AD.AD_IMMARE;
GRANT SELECT ON  AD_IMMARE TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_IMMARE_FK1_1                                      */
/*==============================================================*/
create index AD_IMMARE_FK1_1 on AD_IMMARE (
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Index : AD_IMMARE_FK1_2                                      */
/*==============================================================*/
create index AD_IMMARE_FK1_2 on AD_IMMARE (
   RF_ARE_ID ASC
);

/*==============================================================*/
/* Table : AD_IMMCOHER                                          */
/*==============================================================*/
drop public synonym AD_IMMCOHER;
create table AD_IMMCOHER  (
   AD_IMMCOHER_ID       INTEGER                         not null,
   AD_IMM_ID            INTEGER                         not null,
   AD_IMMCOHER_B3       INTEGER                         not null,
   AD_IMMCOHER_B4       INTEGER                         not null,
   AD_IMMCOHER_B5       INTEGER                         not null,
   AD_IMMCOHER_B7       INTEGER                         not null,
   AD_IMMCOHER_B8       INTEGER                         not null,
   AD_IMMCOHER_B4BIS    INTEGER                         not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_IMMCOHER_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_IMMCOHER_PK1_1 primary key (AD_IMMCOHER_ID)
)
tablespace TS_DATA_AD;

comment on table AD_IMMCOHER is
'Niveau immeuble = opex ou immeuble avec décomposition physique ou immeuble sans décompostion physique

Les indicateurs peuvent prendre les valeurs 0 ou 1 ou 2 ';

comment on column AD_IMMCOHER.AD_IMMCOHER_ID is
'Identifiant de l''indicateur de cohérence de l''immeuble';

comment on column AD_IMMCOHER.AD_IMM_ID is
'Identifiant de l''immeuble';

comment on column AD_IMMCOHER.AD_IMMCOHER_B3 is
'Indicateur B3';

comment on column AD_IMMCOHER.AD_IMMCOHER_B4 is
'Indicateur B4';

comment on column AD_IMMCOHER.AD_IMMCOHER_B5 is
'Indicateur B5';

comment on column AD_IMMCOHER.AD_IMMCOHER_B7 is
'Indicateur B7';

comment on column AD_IMMCOHER.AD_IMMCOHER_B8 is
'Décomposition physique';

comment on column AD_IMMCOHER.AD_IMMCOHER_B4BIS is
'indicateur B4bis';

comment on column AD_IMMCOHER.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_IMMCOHER.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_IMMCOHER for AD.AD_IMMCOHER;
GRANT SELECT ON  AD_IMMCOHER TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_IMMCOHER_FK1_1                                    */
/*==============================================================*/
create unique index AD_IMMCOHER_FK1_1 on AD_IMMCOHER (
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Table : AD_IMMOCC                                            */
/*==============================================================*/
drop public synonym AD_IMMOCC;
create table AD_IMMOCC  (
   AD_IMMOCC_ID         INTEGER                         not null,
   AD_IMM_ID            INTEGER                         not null,
   AD_REPOCC_ID         INTEGER                         not null,
   AD_IMMOCC_CUTI       NUMBER(9)                       not null,
   AD_IMMOCC_CAME       NUMBER(9)                       not null,
   AD_IMMOCC_CNCO       NUMBER(9)                       not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_IMMOCC_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_IMMOCC_PK1_1 primary key (AD_IMMOCC_ID)
);

comment on table AD_IMMOCC is
'Table de dénormalisation.
Contient tous les occupants sur un immeuble, déduit des liens cpt/occ';

comment on column AD_IMMOCC.AD_IMMOCC_ID is
'Identifiant de IMM-OCC';

comment on column AD_IMMOCC.AD_IMM_ID is
'Identifiant de l''immeuble';

comment on column AD_IMMOCC.AD_REPOCC_ID is
'Identifiant';

comment on column AD_IMMOCC.AD_IMMOCC_CUTI is
'CUTI';

comment on column AD_IMMOCC.AD_IMMOCC_CAME is
'CAME
';

comment on column AD_IMMOCC.AD_IMMOCC_CNCO is
'CNCO ';

comment on column AD_IMMOCC.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_IMMOCC.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_IMMOCC for AD.AD_IMMOCC;
GRANT SELECT ON  AD_IMMOCC TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_IMMOCC_FK1_1                                      */
/*==============================================================*/
create index AD_IMMOCC_FK1_1 on AD_IMMOCC (
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Index : AD_IMMOCC_FK1_2                                      */
/*==============================================================*/
create index AD_IMMOCC_FK1_2 on AD_IMMOCC (
   AD_REPOCC_ID ASC
);

/*==============================================================*/
/* Index : AD_IMMOCC_UN2_1                                      */
/*==============================================================*/
create unique index AD_IMMOCC_UN2_1 on AD_IMMOCC (
   AD_IMM_ID ASC,
   AD_REPOCC_ID ASC
);

/*==============================================================*/
/* Table : AD_IMMOPEDOM                                         */
/*==============================================================*/
drop public synonym AD_IMMOPEDOM;
create table AD_IMMOPEDOM  (
   AD_IMMOPEDOM_ID      INTEGER                         not null,
   AD_OPEDOM_ID         INTEGER                         not null,
   AD_IMM_ID            INTEGER                         not null,
   AD_IMMOPEDOM_STOT    NUMBER(9)                       not null,
   AD_IMMOPEDOM_SHOD    NUMBER(9)                       not null,
   AD_IMMOPEDOM_SBAT    NUMBER(9)                       not null,
   AD_IMMOPEDOM_SAME    NUMBER(9)                       not null,
   AD_IMMOPEDOM_SNCO    NUMBER(9)                       not null,
   AD_IMMOPEDOM_SUTI    NUMBER(9)                       not null,
   AD_IMMOPEDOM_MNT     NUMBER(9)                       not null,
   AD_IMMOPEDOM_ES      VARCHAR2(2)                    
      constraint AD_IMMOPEDOM_CK1_2 check (AD_IMMOPEDOM_ES is null or (AD_IMMOPEDOM_ES in ('E','S',null))),
   AD_IMMOPEDOM_CONC    VARCHAR2(5)                    
      constraint AD_IMMOPEDOM_CK1_3 check (AD_IMMOPEDOM_CONC is null or (AD_IMMOPEDOM_CONC in ('NCONC','CONC'))),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_IMMOPEDOM_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_IMMOPEDOM_PK1_1 primary key (AD_IMMOPEDOM_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_IMMOPEDOM is
'Concerner';

comment on column AD_IMMOPEDOM.AD_IMMOPEDOM_ID is
'Identifiant de OPEDOM - IMM';

comment on column AD_IMMOPEDOM.AD_OPEDOM_ID is
'Identifiant de l''opération domaniale';

comment on column AD_IMMOPEDOM.AD_IMM_ID is
'Identifiant de l''immeuble';

comment on column AD_IMMOPEDOM.AD_IMMOPEDOM_STOT is
'Emprise immeuble sur acte';

comment on column AD_IMMOPEDOM.AD_IMMOPEDOM_SHOD is
'SHOD op. dom.';

comment on column AD_IMMOPEDOM.AD_IMMOPEDOM_SBAT is
'Surface bâtie op. dom.';

comment on column AD_IMMOPEDOM.AD_IMMOPEDOM_SAME is
'Surface aire aménagée op. dom.';

comment on column AD_IMMOPEDOM.AD_IMMOPEDOM_SNCO is
'Surface aire non construite op. dom.';

comment on column AD_IMMOPEDOM.AD_IMMOPEDOM_SUTI is
'Surface utile op. dom.';

comment on column AD_IMMOPEDOM.AD_IMMOPEDOM_MNT is
'Montant op. dom.';

comment on column AD_IMMOPEDOM.AD_IMMOPEDOM_ES is
'Surface en entrée ou sortie';

comment on column AD_IMMOPEDOM.AD_IMMOPEDOM_CONC is
'Concomitant à une REM ';

comment on column AD_IMMOPEDOM.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_IMMOPEDOM.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_IMMOPEDOM for AD.AD_IMMOPEDOM;
GRANT SELECT ON  AD_IMMOPEDOM TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_IMMOPEDOM_FK1_1                                   */
/*==============================================================*/
create index AD_IMMOPEDOM_FK1_1 on AD_IMMOPEDOM (
   AD_OPEDOM_ID ASC
);

/*==============================================================*/
/* Index : AD_IMMOPEDOM_FK1_2                                   */
/*==============================================================*/
create index AD_IMMOPEDOM_FK1_2 on AD_IMMOPEDOM (
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Table : AD_IMMSAUPP                                          */
/*==============================================================*/
drop public synonym AD_IMMSAUPP;
create table AD_IMMSAUPP  (
   AD_IMMSAUPP_ID       INTEGER                         not null,
   AD_IMM_ID            INTEGER                         not null,
   AD_SAUPP_ID          INTEGER                         not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_IMMSAUPP_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_IMMSAUPP_PK1_1 primary key (AD_IMMSAUPP_ID)
);

comment on table AD_IMMSAUPP is
'Avoir pour servitude autre que utilité publique au profit';

comment on column AD_IMMSAUPP.AD_IMMSAUPP_ID is
'Identifiant de IMM - SAUPP';

comment on column AD_IMMSAUPP.AD_IMM_ID is
'Identifiant de l''immeuble';

comment on column AD_IMMSAUPP.AD_SAUPP_ID is
'Identifiant de la servitude autre que d''utilité publique au profit';

comment on column AD_IMMSAUPP.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_IMMSAUPP.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_IMMSAUPP for AD.AD_IMMSAUPP;
GRANT SELECT ON  AD_IMMSAUPP TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_IMMSAUPP_FK1_1                                    */
/*==============================================================*/
create index AD_IMMSAUPP_FK1_1 on AD_IMMSAUPP (
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Index : AD_IMMSAUPP_FK1_2                                    */
/*==============================================================*/
create index AD_IMMSAUPP_FK1_2 on AD_IMMSAUPP (
   AD_SAUPP_ID ASC
);

/*==============================================================*/
/* Index : AD_IMMSAUPP_UN2_1                                    */
/*==============================================================*/
create unique index AD_IMMSAUPP_UN2_1 on AD_IMMSAUPP (
   AD_IMM_ID ASC,
   AD_SAUPP_ID ASC
);

/*==============================================================*/
/* Table : AD_IMMSUPP                                           */
/*==============================================================*/
drop public synonym AD_IMMSUPP;
create table AD_IMMSUPP  (
   AD_IMMSUPP_ID        INTEGER                         not null,
   AD_IMM_ID            INTEGER                         not null,
   AD_SUPP_ID           INTEGER                         not null,
   AD_IMMSUPP_ANFR      VARCHAR2(10),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_IMMSUPP_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_IMMSUPF_PK1_1 primary key (AD_IMMSUPP_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_IMMSUPP is
'Avoir pour SUPP de niv imm';

comment on column AD_IMMSUPP.AD_IMMSUPP_ID is
'Identifant';

comment on column AD_IMMSUPP.AD_IMM_ID is
'Identifiant de l''immeuble';

comment on column AD_IMMSUPP.AD_SUPP_ID is
'Identifiant de la servitude d''utilité publique au profit';

comment on column AD_IMMSUPP.AD_IMMSUPP_ANFR is
'Code ANFR';

comment on column AD_IMMSUPP.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_IMMSUPP.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_IMMSUPP for AD.AD_IMMSUPP;
GRANT SELECT ON  AD_IMMSUPP TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_IMMSUPP_FK1_1                                     */
/*==============================================================*/
create index AD_IMMSUPP_FK1_1 on AD_IMMSUPP (
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Index : AD_IMMSUPP_FK1_2                                     */
/*==============================================================*/
create index AD_IMMSUPP_FK1_2 on AD_IMMSUPP (
   AD_SUPP_ID ASC
);

/*==============================================================*/
/* Index : AD_IMMSUPP_UN2_1                                     */
/*==============================================================*/
create unique index AD_IMMSUPP_UN2_1 on AD_IMMSUPP (
   AD_IMM_ID ASC,
   AD_SUPP_ID ASC
);

/*==============================================================*/
/* Table : AD_IMMSURF                                           */
/*==============================================================*/
drop public synonym AD_IMMSURF;
create table AD_IMMSURF  (
   AD_IMMSURF_ID        INTEGER                         not null,
   AD_IMM_ID            INTEGER                         not null,
   AD_IMMSURF_STOT      NUMBER(9)                       not null,
   AD_IMMSURF_SHOD      NUMBER(9)                       not null,
   AD_IMMSURF_SDPU      NUMBER(9)                       not null,
   AD_IMMSURF_SDPR      NUMBER(9)                       not null,
   AD_IMMSURF_SNDO      NUMBER(9)                       not null,
   AD_IMMSURF_SDPA      NUMBER(9)                       not null,
   AD_IMMSURF_SDPM      NUMBER(9)                       not null,
   AD_IMMSURF_SAME      NUMBER(9)                       not null,
   AD_IMMSURF_SBAT      NUMBER(9)                       not null,
   AD_IMMSURF_SNCO      NUMBER(9)                       not null,
   AD_IMMSURF_SONF      NUMBER(9),
   AD_IMMSURF_DTCONVONF VARCHAR2(15),
   AD_IMMSURF_SIGESA    NUMBER(9),
   AD_IMMSURF_DTPVREMIGESA VARCHAR2(15),
   AD_IMMSURF_CAFF      NUMBER(9)                       not null,
   AD_IMMSURF_CHOD      NUMBER(9)                       not null,
   AD_IMMSURF_CHONC     NUMBER(9)                       not null,
   AD_IMMSURF_CHONS     NUMBER(9)                       not null,
   AD_IMMSURF_CUTI      NUMBER(9)                       not null,
   AD_IMMSURF_CREM      NUMBER(9)                       not null,
   AD_IMMSURF_CBAT      NUMBER(9)                       not null,
   AD_IMMSURF_CAME      NUMBER(9)                       not null,
   AD_IMMSURF_CNCO      NUMBER(9)                       not null,
   AD_IMMSURF_CTOT      NUMBER(9)                       not null,
   AD_IMMSURF_CONF      NUMBER(9)                       not null,
   AD_IMMSURF_CIGESA    NUMBER(9)                       not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_IMMSURF_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_IMMSURF_PK1_1 primary key (AD_IMMSURF_ID)
)
tablespace TS_DATA_AD;

comment on table AD_IMMSURF is
'Surfaces immeuble';

comment on column AD_IMMSURF.AD_IMMSURF_ID is
'Identifiant des surfaces immeuble';

comment on column AD_IMMSURF.AD_IMM_ID is
'Identifiant de l''immeuble';

comment on column AD_IMMSURF.AD_IMMSURF_STOT is
'Emprise immeuble';

comment on column AD_IMMSURF.AD_IMMSURF_SHOD is
'SHOD BAA';

comment on column AD_IMMSURF.AD_IMMSURF_SDPU is
'Emprise domaine public immeuble';

comment on column AD_IMMSURF.AD_IMMSURF_SDPR is
'Emprise domaine privé immeuble';

comment on column AD_IMMSURF.AD_IMMSURF_SNDO is
'Emprise non domaniale immeuble';

comment on column AD_IMMSURF.AD_IMMSURF_SDPA is
'Emprise domaine public aéronautique immeuble';

comment on column AD_IMMSURF.AD_IMMSURF_SDPM is
'Emprise domaine public maritime immeuble';

comment on column AD_IMMSURF.AD_IMMSURF_SAME is
'Emprise aménagée immeuble';

comment on column AD_IMMSURF.AD_IMMSURF_SBAT is
'Emprise batie immeuble';

comment on column AD_IMMSURF.AD_IMMSURF_SNCO is
'Emprise non construite immeuble';

comment on column AD_IMMSURF.AD_IMMSURF_SONF is
'Emprise gestion ONF immeuble';

comment on column AD_IMMSURF.AD_IMMSURF_DTCONVONF is
'Date convention ONF immeuble';

comment on column AD_IMMSURF.AD_IMMSURF_SIGESA is
'Emprise IGESA immeuble';

comment on column AD_IMMSURF.AD_IMMSURF_DTPVREMIGESA is
'Date pv de remise à IGESA immeuble';

comment on column AD_IMMSURF.AD_IMMSURF_CAFF is
'Emprise affectée';

comment on column AD_IMMSURF.AD_IMMSURF_CHOD is
'CHOD imm';

comment on column AD_IMMSURF.AD_IMMSURF_CHONC is
'CHON calculée imm';

comment on column AD_IMMSURF.AD_IMMSURF_CHONS is
'CHON saisie imm';

comment on column AD_IMMSURF.AD_IMMSURF_CUTI is
'CUTI';

comment on column AD_IMMSURF.AD_IMMSURF_CREM is
'CREM imm';

comment on column AD_IMMSURF.AD_IMMSURF_CBAT is
'CBAT imm';

comment on column AD_IMMSURF.AD_IMMSURF_CAME is
'CAME imm';

comment on column AD_IMMSURF.AD_IMMSURF_CNCO is
'CNCO imm';

comment on column AD_IMMSURF.AD_IMMSURF_CTOT is
'CTOT imm';

comment on column AD_IMMSURF.AD_IMMSURF_CONF is
'CONF imm';

comment on column AD_IMMSURF.AD_IMMSURF_CIGESA is
'CIGESA imm';

comment on column AD_IMMSURF.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_IMMSURF.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_IMMSURF for AD.AD_IMMSURF;
GRANT SELECT ON  AD_IMMSURF TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_IMMSURF_FK1_1                                     */
/*==============================================================*/
create unique index AD_IMMSURF_FK1_1 on AD_IMMSURF (
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Table : AD_IMMURB                                            */
/*==============================================================*/
drop public synonym AD_IMMURB;
create table AD_IMMURB  (
   AD_IMMURB_ID         INTEGER                         not null,
   AD_IMM_ID            INTEGER                         not null,
   AD_IMMURB_PPR        VARCHAR2(5)                     not null,
   AD_IMMURB_PPRT       VARCHAR2(5)                     not null,
   AD_IMMURB_PSMV       VARCHAR2(5)                     not null,
   AD_IMMURB_PEB        VARCHAR2(5)                     not null,
   AD_IMMURB_ZPPAUP     VARCHAR2(5)                     not null,
   AD_IMMURB_LOIMONT    VARCHAR2(5)                     not null,
   AD_IMMURB_LOILITT    VARCHAR2(5)                     not null,
   AD_IMMURB_SITINS1930 VARCHAR2(5)                     not null,
   AD_IMMURB_SITCLAS1930 VARCHAR2(5)                     not null,
   AD_IMMURB_PERMH      VARCHAR2(5)                     not null,
   AD_IMMURB_IMMCLASMH  VARCHAR2(5)                     not null,
   AD_IMMURB_IMMINSMH   VARCHAR2(5)                     not null,
   AD_IMMURB_ESPSENSNAT VARCHAR2(5)                     not null,
   AD_IMMURB_ZNIEFF     VARCHAR2(5)                     not null,
   AD_IMMURB_NAT2000    VARCHAR2(5)                     not null,
   AD_IMMURB_PREFBIOTOPE VARCHAR2(5)                     not null,
   AD_IMMURB_PARCNAT    VARCHAR2(5)                     not null,
   AD_IMMURB_PARCNATREG VARCHAR2(5)                     not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_IMMURB_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_IMMURB_PK1_1 primary key (AD_IMMURB_ID)
)
tablespace TS_DATA_AD;

comment on table AD_IMMURB is
'Urbanisme - immeuble';

comment on column AD_IMMURB.AD_IMMURB_ID is
'Identifiant de Urbanime-Immeuble';

comment on column AD_IMMURB.AD_IMM_ID is
'Identifiant de l''immeuble';

comment on column AD_IMMURB.AD_IMMURB_PPR is
'PPR';

comment on column AD_IMMURB.AD_IMMURB_PPRT is
'PPRT';

comment on column AD_IMMURB.AD_IMMURB_PSMV is
'PSMV';

comment on column AD_IMMURB.AD_IMMURB_PEB is
'PEB';

comment on column AD_IMMURB.AD_IMMURB_ZPPAUP is
'ZPPAUP';

comment on column AD_IMMURB.AD_IMMURB_LOIMONT is
'Loi montagne';

comment on column AD_IMMURB.AD_IMMURB_LOILITT is
'Loi littoral';

comment on column AD_IMMURB.AD_IMMURB_SITINS1930 is
'Site inscrit 1930';

comment on column AD_IMMURB.AD_IMMURB_SITCLAS1930 is
'Site classé 1930';

comment on column AD_IMMURB.AD_IMMURB_PERMH is
'Périmètre MH';

comment on column AD_IMMURB.AD_IMMURB_IMMCLASMH is
'Immeuble classé MH';

comment on column AD_IMMURB.AD_IMMURB_IMMINSMH is
'Immeuble inscrit MH';

comment on column AD_IMMURB.AD_IMMURB_ESPSENSNAT is
'Espace sensible naturel';

comment on column AD_IMMURB.AD_IMMURB_ZNIEFF is
'ZNIEFF';

comment on column AD_IMMURB.AD_IMMURB_NAT2000 is
'Natura 2000';

comment on column AD_IMMURB.AD_IMMURB_PREFBIOTOPE is
'Arreté préfectoral biotope';

comment on column AD_IMMURB.AD_IMMURB_PARCNAT is
'Parc national';

comment on column AD_IMMURB.AD_IMMURB_PARCNATREG is
'Parc naturel régional';

comment on column AD_IMMURB.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_IMMURB.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_IMMURB for AD.AD_IMMURB;
GRANT SELECT ON  AD_IMMURB TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_IMMURB_FK1_1                                      */
/*==============================================================*/
create unique index AD_IMMURB_FK1_1 on AD_IMMURB (
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Table : AD_IMMVACCES                                         */
/*==============================================================*/
drop public synonym AD_IMMVACCES;
create table AD_IMMVACCES  (
   AD_IMMVACCES_ID      INTEGER                         not null,
   AD_IMM_ID            INTEGER                         not null,
   AD_IMMVACCES_AEDEN   VARCHAR2(35)                    not null,
   AD_IMMVACCES_AEDIS   INTEGER                         not null,
   AD_IMMVACCES_PODEN   VARCHAR2(35)                    not null,
   AD_IMMVACCES_RODEN   VARCHAR2(35)                    not null,
   AD_IMMVACCES_GADEN   VARCHAR2(35)                    not null,
   AD_IMMVACCES_RODIS   INTEGER                         not null,
   AD_IMMVACCES_GADIS   INTEGER                         not null,
   AD_IMMVACCES_PODIS   INTEGER                         not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_IMMVACCES_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_IMMVACCES_PK1_1 primary key (AD_IMMVACCES_ID)
)
tablespace TS_DATA_AD;

comment on table AD_IMMVACCES is
'Voie d''acces';

comment on column AD_IMMVACCES.AD_IMMVACCES_ID is
'Identifiant de la voie d''acces';

comment on column AD_IMMVACCES.AD_IMM_ID is
'Identifiant de l''immeuble';

comment on column AD_IMMVACCES.AD_IMMVACCES_AEDEN is
'Dénomination - localisation aérodrome plus proche';

comment on column AD_IMMVACCES.AD_IMMVACCES_AEDIS is
'Distance aérodrome plus proche';

comment on column AD_IMMVACCES.AD_IMMVACCES_PODEN is
'Dénomination - localisation port plus proche';

comment on column AD_IMMVACCES.AD_IMMVACCES_RODEN is
'Dénomination - localisation route a grande circulation plus proche';

comment on column AD_IMMVACCES.AD_IMMVACCES_GADEN is
'Dénomination - localisation gare plus proche';

comment on column AD_IMMVACCES.AD_IMMVACCES_RODIS is
'Distance route à grande circulation plus proche';

comment on column AD_IMMVACCES.AD_IMMVACCES_GADIS is
'Distance gare plus proche';

comment on column AD_IMMVACCES.AD_IMMVACCES_PODIS is
'Distance port plus proche';

comment on column AD_IMMVACCES.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_IMMVACCES.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_IMMVACCES for AD.AD_IMMVACCES;
GRANT SELECT ON  AD_IMMVACCES TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_IMMVACCES_FK1_1                                   */
/*==============================================================*/
create unique index AD_IMMVACCES_FK1_1 on AD_IMMVACCES (
   AD_IMM_ID ASC
);

/*==============================================================*/
/* Table : AD_JOURNRE                                           */
/*==============================================================*/
drop public synonym AD_JOURNRE;
create table AD_JOURNRE  (
   AD_JOURNRE_ID        INTEGER                         not null,
   AD_METACHORUS_COD    VARCHAR2(25)                    not null,
   AD_ACTION_LIB        VARCHAR2(10)                    not null,
   AD_IMM_COD           VARCHAR2(10)                    not null,
   AD_IMM_DEN           VARCHAR2(40)                    not null,
   AD_IMM_NUMCHORUS     VARCHAR2(6)                     not null,
   RF_ORGANISME_LIBA    VARCHAR2(30)                    not null,
   AD_CPT_COD           VARCHAR2(10),
   AD_CPT_DEN           VARCHAR2(50),
   AD_CPT_NUMCHORUS     VARCHAR2(6),
   AD_JOURNRE_VAL       VARCHAR2(255),
   AD_JOURNRE_OBS       VARCHAR2(50),
   AD_JOURNRE_DTEXPORT  VARCHAR2(15)                    not null,
   AD_JOURNRE_DTMAJ     VARCHAR2(15)                    not null,
   AD_JOURNRE_OPERG2D   VARCHAR2(50)                    not null,
   AD_JOURNRE_DTMVTG2D  VARCHAR2(15)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_JOURNRE_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   AD_JOURNRE_OLDVAL    VARCHAR2(255)                   not null,
   constraint AD_JOURNRE_PK1_1 primary key (AD_JOURNRE_ID)
);

comment on table AD_JOURNRE is
'Journal des mises à jour effectuées par le niveau intermédiaire';

comment on column AD_JOURNRE.AD_JOURNRE_ID is
'Identifiant du journal des MAJ Chorus';

comment on column AD_JOURNRE.AD_METACHORUS_COD is
'Métadonnée Chorus code';

comment on column AD_JOURNRE.AD_ACTION_LIB is
'Action';

comment on column AD_JOURNRE.AD_IMM_COD is
'Code immeuble';

comment on column AD_JOURNRE.AD_IMM_DEN is
'Dénomination immeuble';

comment on column AD_JOURNRE.AD_IMM_NUMCHORUS is
'Numéro site Chorus';

comment on column AD_JOURNRE.RF_ORGANISME_LIBA is
'Service de mise à jour';

comment on column AD_JOURNRE.AD_CPT_COD is
'Code composant G2D';

comment on column AD_JOURNRE.AD_CPT_DEN is
'Dénomination composant';

comment on column AD_JOURNRE.AD_CPT_NUMCHORUS is
'Numéro composant Chorus';

comment on column AD_JOURNRE.AD_JOURNRE_VAL is
'Valeur';

comment on column AD_JOURNRE.AD_JOURNRE_OBS is
'Observation';

comment on column AD_JOURNRE.AD_JOURNRE_DTEXPORT is
'Date exportation';

comment on column AD_JOURNRE.AD_JOURNRE_DTMAJ is
'Date mise à jour';

comment on column AD_JOURNRE.AD_JOURNRE_OPERG2D is
'Opérateur G2D';

comment on column AD_JOURNRE.AD_JOURNRE_DTMVTG2D is
'Date du mouvement dans G2D';

comment on column AD_JOURNRE.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_JOURNRE.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

comment on column AD_JOURNRE.AD_JOURNRE_OLDVAL is
'ancienne valeur G2D';

create public synonym AD_JOURNRE for AD.AD_JOURNRE;
GRANT SELECT ON  AD_JOURNRE TO AD_SEL_A_UTI;

/*==============================================================*/
/* Table : AD_LCL                                               */
/*==============================================================*/
drop public synonym AD_LCL;
create table AD_LCL  (
   AD_LCL_ID            INTEGER                         not null,
   AD_LCL_NUM           INTEGER                         not null,
   AD_CPTBATI_ID        INTEGER                         not null,
   AD_UA_ID             INTEGER                         not null,
   AD_IMMOCC_ID         INTEGER                         not null,
   RF_LCLCLAUTIL_ID     INTEGER                         not null,
   AD_CPTNIV_ID         INTEGER                         not null,
   AD_LCL_DEN           VARCHAR2(50)                    not null,
   AD_LCL_SUTI          NUMBER(9)                       not null,
   AD_LCL_NUMPLAN       VARCHAR2(5)                     not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_LCL_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_LCL_PK1_1 primary key (AD_LCL_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_LCL is
'Local';

comment on column AD_LCL.AD_LCL_ID is
'Identifiant du local';

comment on column AD_LCL.AD_LCL_NUM is
'Numéro de local';

comment on column AD_LCL.AD_CPTBATI_ID is
'Identifiant du composant bâti souterrain';

comment on column AD_LCL.AD_UA_ID is
'Identifiant de l''UA';

comment on column AD_LCL.AD_IMMOCC_ID is
'Identifiant de IMM-OCC';

comment on column AD_LCL.RF_LCLCLAUTIL_ID is
'RF_CLUTLOC_ID';

comment on column AD_LCL.AD_CPTNIV_ID is
'identifiant du niveau du composant';

comment on column AD_LCL.AD_LCL_DEN is
'Dénomination du local';

comment on column AD_LCL.AD_LCL_SUTI is
'Surface utile du local';

comment on column AD_LCL.AD_LCL_NUMPLAN is
'Numéro sur le plan (ex Numéro SAGRI)';

comment on column AD_LCL.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_LCL.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_LCL for AD.AD_LCL;
GRANT SELECT ON  AD_LCL TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_LCL_FK1_1                                         */
/*==============================================================*/
create index AD_LCL_FK1_1 on AD_LCL (
   AD_IMMOCC_ID ASC
);

/*==============================================================*/
/* Index : AD_LCL_FK1_3                                         */
/*==============================================================*/
create index AD_LCL_FK1_3 on AD_LCL (
   RF_LCLCLAUTIL_ID ASC
);

/*==============================================================*/
/* Index : AD_LCL_FK1_2                                         */
/*==============================================================*/
create index AD_LCL_FK1_2 on AD_LCL (
   AD_UA_ID ASC
);

/*==============================================================*/
/* Index : AD_LCL_FK1_4                                         */
/*==============================================================*/
create index AD_LCL_FK1_4 on AD_LCL (
   AD_CPTBATI_ID ASC
);

/*==============================================================*/
/* Index : AD_LCL_UN3_1                                         */
/*==============================================================*/
create unique index AD_LCL_UN3_1 on AD_LCL (
   AD_CPTBATI_ID ASC,
   AD_CPTNIV_ID ASC,
   AD_LCL_NUM ASC
);

/*==============================================================*/
/* Index : AD_LCL_FK1_5                                         */
/*==============================================================*/
create index AD_LCL_FK1_5 on AD_LCL (
   AD_CPTNIV_ID ASC
);

/*==============================================================*/
/* Index : AD_LCL_UN1_2                                         */
/*==============================================================*/
create unique index AD_LCL_UN1_2 on AD_LCL (
   AD_LCL_NUMPLAN ASC,
   AD_LCL_NUM ASC,
   AD_CPTBATI_ID ASC,
   AD_CPTNIV_ID ASC
);

/*==============================================================*/
/* Table : AD_MAD                                               */
/*==============================================================*/
drop public synonym AD_MAD;
create table AD_MAD  (
   AD_MAD_ID            INTEGER                         not null,
   RF_BENAMO_ID         INTEGER                         not null,
   RF_TAMO_ID           INTEGER                         not null,
   AD_OPEDOM_ID         INTEGER                         not null,
   AD_MAD_BENEF         VARCHAR2(50)                    not null,
   AD_MAD_DTDEB         VARCHAR2(15)                    not null,
   AD_MAD_DTFIN         VARCHAR2(15),
   AD_MAD_SANSLIMIT     VARCHAR2(5)                     not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_MAD_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_MAD_PK1_1 primary key (AD_MAD_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_MAD is
'Mise à disposition';

comment on column AD_MAD.AD_MAD_ID is
'Identifiant de la mise à disposition';

comment on column AD_MAD.RF_BENAMO_ID is
'Identifiant de la catégorie de bénéficiaire';

comment on column AD_MAD.RF_TAMO_ID is
'Identifiant du type d''amodiation';

comment on column AD_MAD.AD_OPEDOM_ID is
'Identifiant de l''opération domaniale';

comment on column AD_MAD.AD_MAD_BENEF is
'Bénéficaire de mise à dispo';

comment on column AD_MAD.AD_MAD_DTDEB is
'Date de début mise à dispo';

comment on column AD_MAD.AD_MAD_DTFIN is
'Date de fin de mise à dispo';

comment on column AD_MAD.AD_MAD_SANSLIMIT is
'Top sans limitation de durée';

comment on column AD_MAD.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_MAD.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_MAD for AD.AD_MAD;
GRANT SELECT ON  AD_MAD TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_MAD_FK1_1                                         */
/*==============================================================*/
create unique index AD_MAD_FK1_1 on AD_MAD (
   AD_OPEDOM_ID ASC
);

/*==============================================================*/
/* Index : AD_MAD_FK1_2                                         */
/*==============================================================*/
create index AD_MAD_FK1_2 on AD_MAD (
   RF_TAMO_ID ASC
);

/*==============================================================*/
/* Index : AD_MAD_FK1_3                                         */
/*==============================================================*/
create index AD_MAD_FK1_3 on AD_MAD (
   RF_BENAMO_ID ASC
);

/*==============================================================*/
/* Table : AD_METACHORUS                                        */
/*==============================================================*/
create table AD_METACHORUS  (
   AD_METACHORUS_ID     INTEGER                         not null,
   AD_METACHORUS_LIB    VARCHAR2(80)                    not null,
   AD_METACHORUS_COD    VARCHAR2(25)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_METACHORUS_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_METACHORUS_PK1_1 primary key (AD_METACHORUS_ID)
);

comment on table AD_METACHORUS is
'Table des méta données Chorus';

comment on column AD_METACHORUS.AD_METACHORUS_ID is
'Identifiant des méta données Chorus';

comment on column AD_METACHORUS.AD_METACHORUS_LIB is
'désignation de la métadonnée';

comment on column AD_METACHORUS.AD_METACHORUS_COD is
'code de la métadonnée';

comment on column AD_METACHORUS.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_METACHORUS.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

/*==============================================================*/
/* Table : AD_NATDM                                             */
/*==============================================================*/
drop public synonym AD_NATDM;
create table AD_NATDM  (
   AD_NATDM_ID          INTEGER                         not null,
   AD_NATDM_COD         VARCHAR2(5)                     not null,
   AD_NATDM_LIB         VARCHAR2(30)                    not null,
   AD_NATDM_ETIQ        VARCHAR2(40)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_NATDM_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_NATDM_PK1_1 primary key (AD_NATDM_ID)
);

comment on table AD_NATDM is
'Valeurs:
- initial
- annule et remplace
- remplace
- modifie';

comment on column AD_NATDM.AD_NATDM_ID is
'Identifiant';

comment on column AD_NATDM.AD_NATDM_COD is
'Code pour le motif de nature';

comment on column AD_NATDM.AD_NATDM_LIB is
'Libellé';

comment on column AD_NATDM.AD_NATDM_ETIQ is
'Etiquette pour affichage IHM';

comment on column AD_NATDM.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_NATDM.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_NATDM for AD.AD_NATDM;
GRANT SELECT ON  AD_NATDM TO AD_SEL_A_UTI;

/*==============================================================*/
/* Table : AD_NBATIOCCPT                                        */
/*==============================================================*/
drop public synonym AD_NBATIOCCPT;
create table AD_NBATIOCCPT  (
   AD_NBATIOCCPT_ID     INTEGER                         not null,
   AD_CPTNBATI_ID       INTEGER                         not null,
   AD_UA_ID             INTEGER                         not null,
   AD_IMMOCC_ID         INTEGER                         not null,
   AD_NBATIOCCPT_SURF   NUMBER(9)                       not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_NBATIOCCPT_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_NBATIOCCPT_PK1_1 primary key (AD_NBATIOCCPT_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_NBATIOCCPT is
'Occuper AME ou Occuper NCO';

comment on column AD_NBATIOCCPT.AD_NBATIOCCPT_ID is
'Identifiant de l''occupant AME';

comment on column AD_NBATIOCCPT.AD_CPTNBATI_ID is
'Identifiant du composant non bâti';

comment on column AD_NBATIOCCPT.AD_UA_ID is
'Identifiant de l''UA';

comment on column AD_NBATIOCCPT.AD_IMMOCC_ID is
'Identifiant de IMM-OCC';

comment on column AD_NBATIOCCPT.AD_NBATIOCCPT_SURF is
'Surface composant non bâti occupée';

comment on column AD_NBATIOCCPT.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_NBATIOCCPT.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_NBATIOCCPT for AD.AD_NBATIOCCPT;
GRANT SELECT ON  AD_NBATIOCCPT TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_NBATIOCCPT_FK1_1                                  */
/*==============================================================*/
create index AD_NBATIOCCPT_FK1_1 on AD_NBATIOCCPT (
   AD_CPTNBATI_ID ASC
);

/*==============================================================*/
/* Index : AD_NBATIOCCPT_FK1_2                                  */
/*==============================================================*/
create index AD_NBATIOCCPT_FK1_2 on AD_NBATIOCCPT (
   AD_IMMOCC_ID ASC
);

/*==============================================================*/
/* Index : AD_NBATIOCCPT_FK1_3                                  */
/*==============================================================*/
create index AD_NBATIOCCPT_FK1_3 on AD_NBATIOCCPT (
   AD_UA_ID ASC
);

/*==============================================================*/
/* Index : AD_NBATIOCCPT_UN3_1                                  */
/*==============================================================*/
create unique index AD_NBATIOCCPT_UN3_1 on AD_NBATIOCCPT (
   AD_CPTNBATI_ID ASC,
   AD_UA_ID ASC,
   AD_IMMOCC_ID ASC
);

/*==============================================================*/
/* Table : AD_NIVDEC                                            */
/*==============================================================*/
drop public synonym AD_NIVDEC;
create table AD_NIVDEC  (
   AD_NIVDEC_ID         INTEGER                         not null,
   AD_NIVDEC_COD        VARCHAR2(5)                     not null,
   AD_NIVDEC_LIB        VARCHAR2(25)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_NIVDEC_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_NIVDEC_PK1_1 primary key (AD_NIVDEC_ID)
);

comment on table AD_NIVDEC is
'Niveau de décision';

comment on column AD_NIVDEC.AD_NIVDEC_ID is
'Identifiant du niveau de décision';

comment on column AD_NIVDEC.AD_NIVDEC_COD is
'Code du niveau de décision';

comment on column AD_NIVDEC.AD_NIVDEC_LIB is
'Libellé du niveau de décision';

comment on column AD_NIVDEC.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_NIVDEC.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_NIVDEC for AD.AD_NIVDEC;
GRANT SELECT ON  AD_NIVDEC TO AD_SEL_A_UTI;

/*==============================================================*/
/* Table : AD_OCCPROV                                           */
/*==============================================================*/
drop public synonym AD_OCCPROV;
create table AD_OCCPROV  (
   AD_OCCPROV_ID        INTEGER                         not null,
   AD_OCCPROV_COD       VARCHAR2(2)                     not null,
   AD_OCCPROV_LIB       VARCHAR2(40)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_OCCPROV_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_OCCPROV_PK1_1 primary key (AD_OCCPROV_ID)
);

comment on table AD_OCCPROV is
'Provenance de l''occupant';

comment on column AD_OCCPROV.AD_OCCPROV_ID is
'Identifiant de la provenance';

comment on column AD_OCCPROV.AD_OCCPROV_COD is
'Code de la provenance';

comment on column AD_OCCPROV.AD_OCCPROV_LIB is
'Libellé de la provenance';

comment on column AD_OCCPROV.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_OCCPROV.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_OCCPROV for AD.AD_OCCPROV;
GRANT SELECT ON  AD_OCCPROV TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_OCCPROV_UN1_1                                     */
/*==============================================================*/
create unique index AD_OCCPROV_UN1_1 on AD_OCCPROV (
   AD_OCCPROV_COD ASC
);

/*==============================================================*/
/* Table : AD_OPEDOM                                            */
/*==============================================================*/
drop public synonym AD_OPEDOM;
create table AD_OPEDOM  (
   AD_OPEDOM_ID         INTEGER                         not null,
   AD_OPEDOM_MERE_ID    INTEGER,
   AD_DECMIN_ID         INTEGER                         not null,
   RF_TDOCTOPEDOM_ID    INTEGER                         not null,
   AD_SMAJ_ID           INTEGER,
   RF_ARE_ID            INTEGER                         not null,
   AD_OPEDOM_NUM        NUMBER(5)                       not null,
   AD_OPEDOM_DTDOC      VARCHAR2(15),
   AD_OPEDOM_DTSAIS     VARCHAR2(15),
   AD_OPEDOM_MNT        NUMBER(9),
   AD_OPEDOM_MEMO       VARCHAR2(150),
   AD_OPEDOM_NBIMM      NUMBER(5)                       not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_OPEDOM_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_OPEDOM_PK1_1 primary key (AD_OPEDOM_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_OPEDOM is
'Opérations domaniale';

comment on column AD_OPEDOM.AD_OPEDOM_ID is
'Identifiant de l''opération domaniale';

comment on column AD_OPEDOM.AD_OPEDOM_MERE_ID is
'Identifiant de l''opération domaniale';

comment on column AD_OPEDOM.AD_DECMIN_ID is
'Identifiant Décision Ministérielle';

comment on column AD_OPEDOM.RF_TDOCTOPEDOM_ID is
'identifiant ';

comment on column AD_OPEDOM.AD_SMAJ_ID is
'Identifaint du service de mise à jour';

comment on column AD_OPEDOM.RF_ARE_ID is
'Identifiant de l''attributaire';

comment on column AD_OPEDOM.AD_OPEDOM_NUM is
'Numéro d''ordre dans la DM';

comment on column AD_OPEDOM.AD_OPEDOM_DTDOC is
'Date du document d''operation';

comment on column AD_OPEDOM.AD_OPEDOM_DTSAIS is
'Date de Saisie G2D';

comment on column AD_OPEDOM.AD_OPEDOM_MNT is
'Montant';

comment on column AD_OPEDOM.AD_OPEDOM_MEMO is
'Mémo';

comment on column AD_OPEDOM.AD_OPEDOM_NBIMM is
'Nombre d''immeubles liés';

comment on column AD_OPEDOM.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_OPEDOM.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_OPEDOM for AD.AD_OPEDOM;
GRANT SELECT ON  AD_OPEDOM TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_OPEDOM_FK1_1                                      */
/*==============================================================*/
create index AD_OPEDOM_FK1_1 on AD_OPEDOM (
   RF_TDOCTOPEDOM_ID ASC
);

/*==============================================================*/
/* Index : AD_OPEDOM_FK1_2                                      */
/*==============================================================*/
create index AD_OPEDOM_FK1_2 on AD_OPEDOM (
   AD_OPEDOM_MERE_ID ASC
);

/*==============================================================*/
/* Index : AD_OPEDOM_FK1_3                                      */
/*==============================================================*/
create index AD_OPEDOM_FK1_3 on AD_OPEDOM (
   AD_DECMIN_ID ASC
);

/*==============================================================*/
/* Index : AD_OPEDOM_FK1_4                                      */
/*==============================================================*/
create index AD_OPEDOM_FK1_4 on AD_OPEDOM (
   AD_SMAJ_ID ASC
);

/*==============================================================*/
/* Index : AD_OPEDOM_FK1_5                                      */
/*==============================================================*/
create index AD_OPEDOM_FK1_5 on AD_OPEDOM (
   RF_ARE_ID ASC
);

/*==============================================================*/
/* Table : AD_ORIENFIN                                          */
/*==============================================================*/
drop public synonym AD_ORIENFIN;
create table AD_ORIENFIN  (
   AD_ORIENFIN_ID       INTEGER                         not null,
   AD_ORIENFIN_COD      VARCHAR2(5)                     not null,
   AD_ORIENFIN_LIB      VARCHAR2(25)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_ORIENFIN_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_ORIENFIN_PK1_1 primary key (AD_ORIENFIN_ID)
);

comment on table AD_ORIENFIN is
'Orientation financière';

comment on column AD_ORIENFIN.AD_ORIENFIN_ID is
'Identifiant de l''orientation financière';

comment on column AD_ORIENFIN.AD_ORIENFIN_COD is
'Code de l''orientation financière';

comment on column AD_ORIENFIN.AD_ORIENFIN_LIB is
'Libellé de l''orientation financière';

comment on column AD_ORIENFIN.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_ORIENFIN.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_ORIENFIN for AD.AD_ORIENFIN;
GRANT SELECT ON  AD_ORIENFIN TO AD_SEL_A_UTI;

/*==============================================================*/
/* Table : AD_RAL                                               */
/*==============================================================*/
drop public synonym AD_RAL;
create table AD_RAL  (
   AD_RAL_ID            INTEGER                         not null,
   AD_OPEDOM_ID         INTEGER                         not null,
   RF_MSORT_ID          INTEGER                         not null,
   AD_RAL_DTREMBENEF    VARCHAR2(15)                    not null,
   AD_RAL_BENEF         VARCHAR2(75),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_RAL_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_RAL_PK1_1 primary key (AD_RAL_ID)
)
tablespace TS_DATA_AD;

comment on table AD_RAL is
'Aliénation précédée remise aux domaines';

comment on column AD_RAL.AD_RAL_ID is
'Identifiant de l''aliénation';

comment on column AD_RAL.AD_OPEDOM_ID is
'Identifiant de l''opération domaniale';

comment on column AD_RAL.RF_MSORT_ID is
'Identifiant du motif de sortie';

comment on column AD_RAL.AD_RAL_DTREMBENEF is
'Date de remise bénéficiaire AL';

comment on column AD_RAL.AD_RAL_BENEF is
'Bénéficiaire AL';

comment on column AD_RAL.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_RAL.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_RAL for AD.AD_RAL;
GRANT SELECT ON  AD_RAL TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_RAL_FK1_1                                         */
/*==============================================================*/
create index AD_RAL_FK1_1 on AD_RAL (
   RF_MSORT_ID ASC
);

/*==============================================================*/
/* Index : AD_RAL_FK1_2                                         */
/*==============================================================*/
create unique index AD_RAL_FK1_2 on AD_RAL (
   AD_OPEDOM_ID ASC
);

/*==============================================================*/
/* Table : AD_REPGES                                            */
/*==============================================================*/
drop public synonym AD_REPGES;
create table AD_REPGES  (
   AD_REPGES_ID         INTEGER                         not null,
   RF_ORGANISME_ID      INTEGER                         not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_REPGES_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_REPGES_PK1_1 primary key (AD_REPGES_ID)
);

comment on table AD_REPGES is
'Repertoire des gestionnaires';

comment on column AD_REPGES.AD_REPGES_ID is
'Identifiant du répertoire';

comment on column AD_REPGES.RF_ORGANISME_ID is
'Identifiant de l''organisme';

comment on column AD_REPGES.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_REPGES.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_REPGES for AD.AD_REPGES;
GRANT SELECT ON  AD_REPGES TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_REPGES_FK1_1                                      */
/*==============================================================*/
create index AD_REPGES_FK1_1 on AD_REPGES (
   RF_ORGANISME_ID ASC
);

/*==============================================================*/
/* Table : AD_REPOCC                                            */
/*==============================================================*/
drop public synonym AD_REPOCC;
create table AD_REPOCC  (
   AD_REPOCC_ID         INTEGER                         not null,
   RF_ARE_ID            INTEGER                         not null,
   AD_TOCCPROV_ID       INTEGER                         not null,
   RF_COMM_ID           INTEGER,
   AD_REPOCC_COD        VARCHAR2(7)                     not null,
   AD_REPOCC_LIB        VARCHAR2(100)                   not null,
   AD_REPOCC_LIBA       VARCHAR2(50)                    not null,
   AD_REPOCC_ISLOCAL    VARCHAR2(5)                     not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_REPOCC_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_REPOCC_PK1_1 primary key (AD_REPOCC_ID)
);

comment on table AD_REPOCC is
'Table des occupants utilisés dans G2D. Cette table contient les occupants défense et hors défense. Les occupants défense sont mis à jour à partir de la table de référence des occupants (RF_OCC), les occupants non défense seront saisis dans G2D par l''administrateur G2D.
Valeurs à créer pour type occupant
Inoccupé, Non défense, divers, Air, Terre, Marine, Gendarmerie, Autre défense';

comment on column AD_REPOCC.AD_REPOCC_ID is
'Identifiant des occupants';

comment on column AD_REPOCC.RF_ARE_ID is
'Identifiant de l''attributaire';

comment on column AD_REPOCC.AD_TOCCPROV_ID is
'Identifiant';

comment on column AD_REPOCC.RF_COMM_ID is
'Identifiant de la commune';

comment on column AD_REPOCC.AD_REPOCC_COD is
'Code occupant';

comment on column AD_REPOCC.AD_REPOCC_LIB is
'Libellé long occupant';

comment on column AD_REPOCC.AD_REPOCC_LIBA is
'Libellé court de l''occupant';

comment on column AD_REPOCC.AD_REPOCC_ISLOCAL is
'Booléen indiquent si la saisie a été faite dans G2D';

comment on column AD_REPOCC.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_REPOCC.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_REPOCC for AD.AD_REPOCC;
GRANT SELECT ON  AD_REPOCC TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_REPOCC_FK1_1                                      */
/*==============================================================*/
create index AD_REPOCC_FK1_1 on AD_REPOCC (
   RF_ARE_ID ASC
);

/*==============================================================*/
/* Index : AD_REPOCC_UN1_1                                      */
/*==============================================================*/
create unique index AD_REPOCC_UN1_1 on AD_REPOCC (
   AD_REPOCC_COD ASC
);

/*==============================================================*/
/* Index : AD_REPOCC_FK1_2                                      */
/*==============================================================*/
create index AD_REPOCC_FK1_2 on AD_REPOCC (
   RF_COMM_ID ASC
);

/*==============================================================*/
/* Index : AD_REPOCC_FK1_3                                      */
/*==============================================================*/
create index AD_REPOCC_FK1_3 on AD_REPOCC (
   AD_TOCCPROV_ID ASC
);

/*==============================================================*/
/* Table : AD_RGPP                                              */
/*==============================================================*/
create table AD.AD_RGPP  (
   AD_RGPP_ID           INTEGER                         not null,
   AD_IMM_COD           VARCHAR2(10),
   AD_IMM_DEN           VARCHAR2(100),
   RF_COMM_LIB          VARCHAR2(50),
   RF_IMMIND_LIB        VARCHAR2(100),
   AD_RGPP_FLAG         VARCHAR2(50),
   RF_ARE_COD           VARCHAR2(5),
   RF_ARE_LIB           VARCHAR2(200),
   AD_RGPP_IMM_SHOD     NUMBER(9),
   AD_RGPP_CPT_SHOD     NUMBER(9),
   constraint AD_RGPP_PK1_1 primary key (AD_RGPP_ID)
         using index
       tablespace TS_INDEX_AD
)
storage
(
    initial 10K
    next 10K
    minextents 1
    maxextents ?
    maxextents unlimited
    pctincrease 50
    freelists 1
    freelist groups 1
    optimal ?
    optimal NULL
    buffer_pool default
)
tablespace TS_DATA_AD;

comment on table AD.AD_RGPP is
'Table nécessaire pour les RGPP';

comment on column AD.AD_RGPP.AD_IMM_COD is
'Code immeuble';

comment on column AD.AD_RGPP.AD_IMM_DEN is
'Dénomination immeuble';

/*==============================================================*/
/* Table : AD_ROLE                                              */
/*==============================================================*/
drop public synonym AD_ROLE;
create table AD_ROLE  (
   AD_ROLE_ID           INTEGER                         not null,
   AD_ROLE_LIB          VARCHAR2(50)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_ROLE_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_ROLE_PK1_1 primary key (AD_ROLE_ID)
);

comment on table AD_ROLE is
'Table des roles';

comment on column AD_ROLE.AD_ROLE_ID is
'Identifiant de la table des Roles';

comment on column AD_ROLE.AD_ROLE_LIB is
'Libellé du role';

comment on column AD_ROLE.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_ROLE.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_ROLE for AD.AD_ROLE;
GRANT SELECT ON  AD_ROLE TO AD_SEL_A_UTI;

/*==============================================================*/
/* Table : AD_SAUPP                                             */
/*==============================================================*/
drop public synonym AD_SAUPP;
create table AD_SAUPP  (
   AD_SAUPP_ID          INTEGER                         not null,
   RF_TSAUPP_ID         INTEGER                         not null,
   AD_SAUPP_REFTXT      VARCHAR2(25)                    not null,
   AD_SAUPP_DTTXT       VARCHAR2(15)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_SAUPP_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_SAUPP_PK1_1 primary key (AD_SAUPP_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_SAUPP is
'Servitude autre que utilité publique au profit';

comment on column AD_SAUPP.AD_SAUPP_ID is
'Identifiant de la servitude autre que d''utilité publique au profit';

comment on column AD_SAUPP.RF_TSAUPP_ID is
'Identifiant de la S.A.U.P.P.';

comment on column AD_SAUPP.AD_SAUPP_REFTXT is
'Référence texte';

comment on column AD_SAUPP.AD_SAUPP_DTTXT is
'Date texte';

comment on column AD_SAUPP.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_SAUPP.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_SAUPP for AD.AD_SAUPP;
GRANT SELECT ON  AD_SAUPP TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_SAUPP_FK1_1                                       */
/*==============================================================*/
create index AD_SAUPP_FK1_1 on AD_SAUPP (
   RF_TSAUPP_ID ASC
);

/*==============================================================*/
/* Table : AD_SMAJ                                              */
/*==============================================================*/
drop public synonym AD_SMAJ;
create table AD_SMAJ  (
   AD_SMAJ_ID           INTEGER                         not null,
   RF_ORGANISME_ID      INTEGER                         not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_SMAJ_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_SMAJ_PK1_1 primary key (AD_SMAJ_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_SMAJ is
'Services de mise à jour';

comment on column AD_SMAJ.AD_SMAJ_ID is
'Identifaint du service de mise à jour';

comment on column AD_SMAJ.RF_ORGANISME_ID is
'Identifiant de l''organisme';

comment on column AD_SMAJ.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_SMAJ.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_SMAJ for AD.AD_SMAJ;
GRANT SELECT ON  AD_SMAJ TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_SMAJ_FK1_1                                        */
/*==============================================================*/
create unique index AD_SMAJ_FK1_1 on AD_SMAJ (
   RF_ORGANISME_ID ASC
);

/*==============================================================*/
/* Table : AD_SMAJDOM                                           */
/*==============================================================*/
drop public synonym AD_SMAJDOM;
create table AD_SMAJDOM  (
   AD_SMAJDOM_ID        INTEGER                         not null,
   AD_SMAJ_ID           INTEGER                         not null,
   AD_DOMAINE_ID        INTEGER                         not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_SMAJDOM_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_SMAJDOM_PK1_1 primary key (AD_SMAJDOM_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_SMAJDOM is
'Se compose';

comment on column AD_SMAJDOM.AD_SMAJDOM_ID is
'Identifaint du SMAJDOM';

comment on column AD_SMAJDOM.AD_SMAJ_ID is
'Identifaint du service de mise à jour';

comment on column AD_SMAJDOM.AD_DOMAINE_ID is
'Identifaint du DOMAINE';

comment on column AD_SMAJDOM.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_SMAJDOM.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_SMAJDOM for AD.AD_SMAJDOM;
GRANT SELECT ON  AD_SMAJDOM TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_SMAJDOM_FK1_1                                     */
/*==============================================================*/
create index AD_SMAJDOM_FK1_1 on AD_SMAJDOM (
   AD_SMAJ_ID ASC
);

/*==============================================================*/
/* Index : AD_SMAJDOM_FK1_2                                     */
/*==============================================================*/
create index AD_SMAJDOM_FK1_2 on AD_SMAJDOM (
   AD_DOMAINE_ID ASC
);

/*==============================================================*/
/* Index : AD_SMAJDOM_UN1_1                                     */
/*==============================================================*/
create unique index AD_SMAJDOM_UN1_1 on AD_SMAJDOM (
   AD_SMAJ_ID ASC,
   AD_DOMAINE_ID ASC
);

/*==============================================================*/
/* Table : AD_SMAJSU                                            */
/*==============================================================*/
drop public synonym AD_SMAJSU;
create table AD_SMAJSU  (
   AD_SMAJSU_ID         INTEGER                         not null,
   AD_USER_ID           INTEGER                         not null,
   AD_SMAJ_ID           INTEGER                         not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_SMAJSU_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_SMAJSU_PK1_1 primary key (AD_SMAJSU_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_SMAJSU is
'Gestion du Super utilisateur';

comment on column AD_SMAJSU.AD_SMAJSU_ID is
'Identifaint du service de mise à jour';

comment on column AD_SMAJSU.AD_USER_ID is
'Identifiant de la table de liaison entre Mn_Pers et Rf_Organisme';

comment on column AD_SMAJSU.AD_SMAJ_ID is
'Identifaint du service de mise à jour';

comment on column AD_SMAJSU.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_SMAJSU.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_SMAJSU for AD.AD_SMAJSU;
GRANT SELECT ON  AD_SMAJSU TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_SMAJSU_UN1_1                                      */
/*==============================================================*/
create unique index AD_SMAJSU_UN1_1 on AD_SMAJSU (
   AD_USER_ID ASC,
   AD_SMAJ_ID ASC
);

/*==============================================================*/
/* Table : AD_SNUP                                              */
/*==============================================================*/
drop public synonym AD_SNUP;
create table AD_SNUP  (
   AD_SNUP_ID           INTEGER                         not null,
   AD_SAUPP_ID          INTEGER                         not null,
   RF_ORISNUP_ID        INTEGER                         not null,
   RF_TSNUP_ID          INTEGER,
   AD_SNUP_BENEF        VARCHAR2(25),
   AD_SNUP_OBS          VARCHAR2(250),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_SNUP_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_SNUP_PK1_1 primary key (AD_SNUP_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_SNUP is
'Servitude non utilité publique';

comment on column AD_SNUP.AD_SNUP_ID is
'Identifiant de la servitude non utilité publique';

comment on column AD_SNUP.AD_SAUPP_ID is
'Identifiant de la servitude autre que d''utilité publique au profit';

comment on column AD_SNUP.RF_ORISNUP_ID is
'Identifiant de l''origine d''une S.N.U.P.';

comment on column AD_SNUP.RF_TSNUP_ID is
'Identifiant de la servitude autre que d''utilité publique';

comment on column AD_SNUP.AD_SNUP_BENEF is
'Bénéficiaire SNUPD';

comment on column AD_SNUP.AD_SNUP_OBS is
'Observations';

comment on column AD_SNUP.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_SNUP.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_SNUP for AD.AD_SNUP;
GRANT SELECT ON  AD_SNUP TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_SNUP_FK1_1                                        */
/*==============================================================*/
create index AD_SNUP_FK1_1 on AD_SNUP (
   RF_ORISNUP_ID ASC
);

/*==============================================================*/
/* Index : AD_SNUP_FK1_2                                        */
/*==============================================================*/
create index AD_SNUP_FK1_2 on AD_SNUP (
   RF_TSNUP_ID ASC
);

/*==============================================================*/
/* Index : AD_SNUP_FK1_3                                        */
/*==============================================================*/
create unique index AD_SNUP_FK1_3 on AD_SNUP (
   AD_SAUPP_ID ASC
);

/*==============================================================*/
/* Table : AD_STATUTDM                                          */
/*==============================================================*/
drop public synonym AD_STATUTDM;
create table AD_STATUTDM  (
   AD_STATUTDM_ID       INTEGER                         not null,
   AD_STATUTDM_COD      VARCHAR2(5)                     not null,
   AD_STATUTDM_LIB      VARCHAR2(25)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_STATUTDM_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_STATUTDM_PK1_1 primary key (AD_STATUTDM_ID)
);

comment on table AD_STATUTDM is
'Statut de la DM';

comment on column AD_STATUTDM.AD_STATUTDM_ID is
'Identifiant du statut de la DM';

comment on column AD_STATUTDM.AD_STATUTDM_COD is
'Code du statut de la DM';

comment on column AD_STATUTDM.AD_STATUTDM_LIB is
'Libellé du statut de la DM';

comment on column AD_STATUTDM.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_STATUTDM.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_STATUTDM for AD.AD_STATUTDM;
GRANT SELECT ON  AD_STATUTDM TO AD_SEL_A_UTI;

/*==============================================================*/
/* Table : AD_SUIVI_HIS                                         */
/*==============================================================*/
drop public synonym AD_SUIVI_HIS;
create table AD_SUIVI_HIS  (
   AD_SUIVI_HIS_ID      INTEGER                         not null,
   AD_DECMIN_ID         INTEGER                         not null,
   AD_SUIVI_HIS_COD     VARCHAR2(5)                     not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_SUIVI_HIS_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_SUIVI_HIS_PK1_1 primary key (AD_SUIVI_HIS_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_SUIVI_HIS is
'Suivi historique';

comment on column AD_SUIVI_HIS.AD_SUIVI_HIS_ID is
'Identifiant du suivi histo';

comment on column AD_SUIVI_HIS.AD_DECMIN_ID is
'Identifiant Decmin';

comment on column AD_SUIVI_HIS.AD_SUIVI_HIS_COD is
'Code du suivi historique';

comment on column AD_SUIVI_HIS.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_SUIVI_HIS.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_SUIVI_HIS for AD.AD_SUIVI_HIS;
GRANT SELECT ON  AD_SUIVI_HIS TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_SUIVI_HIS_FK1_1                                   */
/*==============================================================*/
create unique index AD_SUIVI_HIS_FK1_1 on AD_SUIVI_HIS (
   AD_DECMIN_ID ASC
);

/*==============================================================*/
/* Table : AD_SUPD                                              */
/*==============================================================*/
drop public synonym AD_SUPD;
create table AD_SUPD  (
   AD_SUPD_ID           INTEGER                         not null,
   AD_SAUPP_ID          INTEGER                         not null,
   RF_TPROTECT_ID       INTEGER                         not null,
   RF_TSUP_ID           INTEGER                         not null,
   AD_SUPD_COD          VARCHAR2(11)                    not null,
   AD_SUPD_BENEF        VARCHAR2(25),
   AD_SUPD_OBS          VARCHAR2(250),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_SUPD_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_SUPD_PK1_1 primary key (AD_SUPD_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_SUPD is
'Servitude utilité publique aux dépens';

comment on column AD_SUPD.AD_SUPD_ID is
'Identifiant de la servitude utilité publique aux dépens';

comment on column AD_SUPD.AD_SAUPP_ID is
'Identifiant de la servitude autre que d''utilité publique au profit';

comment on column AD_SUPD.RF_TPROTECT_ID is
'Identifiant du type de protection';

comment on column AD_SUPD.RF_TSUP_ID is
'Identifiant de la servitude d''utilité publique';

comment on column AD_SUPD.AD_SUPD_COD is
'Numéro servitude UP';

comment on column AD_SUPD.AD_SUPD_BENEF is
'Bénéficiaire servitude aux depens';

comment on column AD_SUPD.AD_SUPD_OBS is
'Observations';

comment on column AD_SUPD.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_SUPD.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_SUPD for AD.AD_SUPD;
GRANT SELECT ON  AD_SUPD TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_SUPD_FK1_2                                        */
/*==============================================================*/
create unique index AD_SUPD_FK1_2 on AD_SUPD (
   AD_SAUPP_ID ASC
);

/*==============================================================*/
/* Index : AD_SUPD_FK1_1                                        */
/*==============================================================*/
create index AD_SUPD_FK1_1 on AD_SUPD (
   RF_TPROTECT_ID ASC
);

/*==============================================================*/
/* Index : AD_SUPD_FK1_3                                        */
/*==============================================================*/
create index AD_SUPD_FK1_3 on AD_SUPD (
   RF_TSUP_ID ASC
);

/*==============================================================*/
/* Table : AD_SUPP                                              */
/*==============================================================*/
drop public synonym AD_SUPP;
create table AD_SUPP  (
   AD_SUPP_ID           INTEGER                         not null,
   AD_SUPP_COD          VARCHAR2(11)                    not null,
   RF_ARE_ID            INTEGER                         not null,
   RF_NIVSUPP_ID        INTEGER                         not null,
   RF_TSUP_ID           INTEGER                         not null,
   AD_REPGES_ID         INTEGER                         not null,
   AD_SMAJ_ID           INTEGER                         not null,
   AD_SUPP_OBS          VARCHAR2(75),
   AD_SUPP_ETAT         VARCHAR2(5)                     not null,
   AD_SUPP_CONT         VARCHAR2(75)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_SUPP_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_SUPP_PK1_1 primary key (AD_SUPP_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_SUPP is
'Servitude utilité publique au profit';

comment on column AD_SUPP.AD_SUPP_ID is
'Identifiant de la servitude d''utilité publique au profit';

comment on column AD_SUPP.AD_SUPP_COD is
'Numéro servitude SUPP';

comment on column AD_SUPP.RF_ARE_ID is
'Identifiant de l''attributaire';

comment on column AD_SUPP.RF_NIVSUPP_ID is
'Identifiant du niveau d''élaboration ';

comment on column AD_SUPP.RF_TSUP_ID is
'Identifiant de la servitude d''utilité publique';

comment on column AD_SUPP.AD_REPGES_ID is
'Identifiant du répertoire';

comment on column AD_SUPP.AD_SMAJ_ID is
'Identifaint du service de mise à jour';

comment on column AD_SUPP.AD_SUPP_OBS is
'Observations SUPP';

comment on column AD_SUPP.AD_SUPP_ETAT is
'Indicateur pour définir l''etat d''avancement';

comment on column AD_SUPP.AD_SUPP_CONT is
'Contrainte de la servitude';

comment on column AD_SUPP.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_SUPP.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_SUPP for AD.AD_SUPP;
GRANT SELECT ON  AD_SUPP TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_SUPP_FK1_1                                        */
/*==============================================================*/
create index AD_SUPP_FK1_1 on AD_SUPP (
   AD_REPGES_ID ASC
);

/*==============================================================*/
/* Index : AD_SUPP_UN1_1                                        */
/*==============================================================*/
create unique index AD_SUPP_UN1_1 on AD_SUPP (
   AD_SUPP_COD ASC
);

/*==============================================================*/
/* Index : AD_SUPP_FK1_2                                        */
/*==============================================================*/
create index AD_SUPP_FK1_2 on AD_SUPP (
   RF_TSUP_ID ASC
);

/*==============================================================*/
/* Index : AD_SUPP_FK1_3                                        */
/*==============================================================*/
create index AD_SUPP_FK1_3 on AD_SUPP (
   RF_ARE_ID ASC
);

/*==============================================================*/
/* Index : AD_SUPP_FK1_4                                        */
/*==============================================================*/
create index AD_SUPP_FK1_4 on AD_SUPP (
   RF_NIVSUPP_ID ASC
);

/*==============================================================*/
/* Index : AD_SUPP_FK1_5                                        */
/*==============================================================*/
create index AD_SUPP_FK1_5 on AD_SUPP (
   AD_SMAJ_ID ASC
);

/*==============================================================*/
/* Table : AD_TEDT                                              */
/*==============================================================*/
drop public synonym AD_TEDT;
create table AD_TEDT  (
   AD_TEDT_ID           INTEGER                         not null,
   AD_TEDT_COD          VARCHAR2(5)                     not null,
   AD_TEDT_LIB          VARCHAR2(50)                    not null,
   AD_TEDT_LIBA         VARCHAR2(20)                    not null,
   AD_TEDT_CLASSE       VARCHAR2(100)                   not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_TEDT_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_TEDT_PK1_1 primary key (AD_TEDT_ID)
);

comment on table AD_TEDT is
'Types d''éditions';

comment on column AD_TEDT.AD_TEDT_ID is
'Identifiant du type d''édition';

comment on column AD_TEDT.AD_TEDT_COD is
'Code du type d''édition';

comment on column AD_TEDT.AD_TEDT_LIB is
'Libellé du type d''édition';

comment on column AD_TEDT.AD_TEDT_LIBA is
'Libellé abrégé du type d''édition';

comment on column AD_TEDT.AD_TEDT_CLASSE is
'Classe du type d''édition';

comment on column AD_TEDT.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_TEDT.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_TEDT for AD.AD_TEDT;
GRANT SELECT ON  AD_TEDT TO AD_SEL_A_UTI;

/*==============================================================*/
/* Table : AD_TETATEDT                                          */
/*==============================================================*/
drop public synonym AD_TETATEDT;
create table AD_TETATEDT  (
   AD_TETATEDT_ID       INTEGER                         not null,
   AD_TETATEDT_COD      VARCHAR2(1)                     not null,
   AD_TETATEDT_LIB      VARCHAR2(50)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_TETATEDT_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_TETATEDT_PK1_1 primary key (AD_TETATEDT_ID)
);

comment on table AD_TETATEDT is
'Type d''états de l''édition';

comment on column AD_TETATEDT.AD_TETATEDT_ID is
'Identifiant de l''état de l''édition';

comment on column AD_TETATEDT.AD_TETATEDT_COD is
'Code de l''état de l''édition';

comment on column AD_TETATEDT.AD_TETATEDT_LIB is
'Libellé de l''état de l''édition';

comment on column AD_TETATEDT.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_TETATEDT.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_TETATEDT for AD.AD_TETATEDT;
GRANT SELECT ON  AD_TETATEDT TO AD_SEL_A_UTI;

/*==============================================================*/
/* Table : AD_TMP_CPT                                           */
/*==============================================================*/
drop public synonym AD_TMP_CPT;
create table AD_TMP_CPT  (
   AD_TMP_CPT_ID        INTEGER                         not null,
   AD_IMM_COD           VARCHAR2(10),
   AD_CPT_COD           INTEGER,
   AD_TMP_CPT_NEWCOD    VARCHAR2(5),
   AD_XDMAJ             VARCHAR2(15),
   AD_XTOPSUP           VARCHAR2(1)                    default '0'
      constraint CKC_AD_XTOPSUP_AD_TMP_C check (AD_XTOPSUP is null or (AD_XTOPSUP in ('0','1','2','3','4','9','M'))),
   constraint AD_TMP_CPT primary key (AD_TMP_CPT_ID)
);

create public synonym AD_TMP_CPT for AD.AD_TMP_CPT;
GRANT SELECT ON  AD_TMP_CPT TO AD_SEL_A_UTI;

/*==============================================================*/
/* Table : AD_TMP_ORGA4RENUM                                    */
/*==============================================================*/
drop public synonym AD_TMP_ORGA4RENUM;
create table AD_TMP_ORGA4RENUM  (
   AD_TMP_ORGA4RENUM_ID INTEGER                         not null,
   RF_ORGANISME_ID      INTEGER                         not null,
   AD_XDMAJ             VARCHAR2(15),
   AD_XTOPSUP           VARCHAR2(1)                    default '0'
      constraint CKC_AD_XTOPSUP_AD_TMP_O check (AD_XTOPSUP is null or (AD_XTOPSUP in ('0','1','2','3','4','9','M'))),
   constraint AD_TMP_ORGA4RENUM primary key (AD_TMP_ORGA4RENUM_ID)
);

create public synonym AD_TMP_ORGA4RENUM for AD.AD_TMP_ORGA4RENUM;
GRANT SELECT ON  AD_TMP_ORGA4RENUM TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_TMP_ORGA4RENUM_FK1_1                              */
/*==============================================================*/
create unique index AD_TMP_ORGA4RENUM_FK1_1 on AD_TMP_ORGA4RENUM (
   RF_ORGANISME_ID ASC
);

/*==============================================================*/
/* Table : AD_TOCC                                              */
/*==============================================================*/
drop public synonym AD_TOCC;
create table AD_TOCC  (
   AD_TOCC_ID           INTEGER                         not null,
   AD_TOCC_COD          VARCHAR2(2)                     not null,
   AD_TOCC_LIB          VARCHAR2(40)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_TOCC_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_TOCC_PK1_1 primary key (AD_TOCC_ID)
);

comment on table AD_TOCC is
'contient le type de l’occupant (Occupé ou Inoccupé)';

comment on column AD_TOCC.AD_TOCC_ID is
'Identifiant du type de l''occupant';

comment on column AD_TOCC.AD_TOCC_COD is
'Code du type de l''occupant
';

comment on column AD_TOCC.AD_TOCC_LIB is
'Libellé du type de l''occupant';

comment on column AD_TOCC.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_TOCC.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_TOCC for AD.AD_TOCC;
GRANT SELECT ON  AD_TOCC TO AD_SEL_A_UTI;

/*==============================================================*/
/* Table : AD_TOCCPROV                                          */
/*==============================================================*/
drop public synonym AD_TOCCPROV;
create table AD_TOCCPROV  (
   AD_TOCCPROV_ID       INTEGER                         not null,
   AD_OCCPROV_ID        INTEGER                         not null,
   AD_TOCC_ID           INTEGER                         not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_TOCCPROV_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_TOCCPROV_PK1_1 primary key (AD_TOCCPROV_ID)
);

comment on table AD_TOCCPROV is
'AD_TOCCPROV';

comment on column AD_TOCCPROV.AD_TOCCPROV_ID is
'Identifiant';

comment on column AD_TOCCPROV.AD_OCCPROV_ID is
'Identifiant de la provenance';

comment on column AD_TOCCPROV.AD_TOCC_ID is
'Identifiant du type de l''occupant';

comment on column AD_TOCCPROV.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_TOCCPROV.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_TOCCPROV for AD.AD_TOCCPROV;
GRANT SELECT ON  AD_TOCCPROV TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_TOCCPROV_FK1_1                                    */
/*==============================================================*/
create index AD_TOCCPROV_FK1_1 on AD_TOCCPROV (
   AD_TOCC_ID ASC
);

/*==============================================================*/
/* Index : AD_TOCCPROV_FK1_2                                    */
/*==============================================================*/
create index AD_TOCCPROV_FK1_2 on AD_TOCCPROV (
   AD_OCCPROV_ID ASC
);

/*==============================================================*/
/* Index : AD_TOCCPROV_UN2_1                                    */
/*==============================================================*/
create unique index AD_TOCCPROV_UN2_1 on AD_TOCCPROV (
   AD_OCCPROV_ID ASC,
   AD_TOCC_ID ASC
);

/*==============================================================*/
/* Table : AD_TRA                                               */
/*==============================================================*/
drop public synonym AD_TRA;
create table AD_TRA  (
   AD_TRA_ID            INTEGER                         not null,
   AD_OPEDOM_ID         INTEGER                         not null,
   RF_AFFECT_ID         INTEGER                         not null,
   RF_TBENECH_ID        INTEGER                         not null,
   AD_TRA_BENEF         VARCHAR2(75),
   AD_TRA_DTREMBENEF    VARCHAR2(15),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_TRA_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_TRA_PK1_1 primary key (AD_TRA_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_TRA is
'Transfert de gestion';

comment on column AD_TRA.AD_TRA_ID is
'Identifiant du transfert de gestion';

comment on column AD_TRA.AD_OPEDOM_ID is
'Identifiant de l''opération domaniale';

comment on column AD_TRA.RF_AFFECT_ID is
'Identifiant affectataire';

comment on column AD_TRA.RF_TBENECH_ID is
'Identifiant du type de bénéficiaire';

comment on column AD_TRA.AD_TRA_BENEF is
'Bénéficiaire TG';

comment on column AD_TRA.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_TRA.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_TRA for AD.AD_TRA;
GRANT SELECT ON  AD_TRA TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_TRA_FK1_1                                         */
/*==============================================================*/
create unique index AD_TRA_FK1_1 on AD_TRA (
   AD_OPEDOM_ID ASC
);

/*==============================================================*/
/* Index : AD_TRA_FK1_2                                         */
/*==============================================================*/
create index AD_TRA_FK1_2 on AD_TRA (
   RF_AFFECT_ID ASC
);

/*==============================================================*/
/* Index : AD_TRA_FK1_3                                         */
/*==============================================================*/
create index AD_TRA_FK1_3 on AD_TRA (
   RF_TBENECH_ID ASC
);

/*==============================================================*/
/* Table : AD_TXTSUPP                                           */
/*==============================================================*/
drop public synonym AD_TXTSUPP;
create table AD_TXTSUPP  (
   AD_TXTSUPP_ID        INTEGER                         not null,
   AD_SUPP_ID           INTEGER                         not null,
   RF_OBJTXT_ID         INTEGER                         not null,
   AD_TXTSUPP_NUMTXTREF VARCHAR2(2)                     not null,
   AD_TXTSUPP_REFTXT    VARCHAR2(15)                    not null,
   AD_TXTSUPP_DTTXT     VARCHAR2(15)                    not null,
   AD_TXTSUPP_DTPUBJO   VARCHAR2(15),
   AD_TXTSUPP_NUMCOMSIS VARCHAR2(6),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_TXTSUPP_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_TXTSUPP_PK1_1 primary key (AD_TXTSUPP_ID)
)
tablespace TS_DATA_AD;

comment on table AD_TXTSUPP is
'Numéro comsis et anfr remplace coresta et cct.
Numéro de texte de réference: compteur de texte dans la SUPP';

comment on column AD_TXTSUPP.AD_TXTSUPP_ID is
'Identifiant du texte SUPP';

comment on column AD_TXTSUPP.AD_SUPP_ID is
'Identifiant de la servitude d''utilité publique au profit';

comment on column AD_TXTSUPP.RF_OBJTXT_ID is
'Identifiant de l''objet du texte de référence';

comment on column AD_TXTSUPP.AD_TXTSUPP_NUMTXTREF is
'Numéro texte référence SUPP';

comment on column AD_TXTSUPP.AD_TXTSUPP_REFTXT is
'Référence texte SUPP';

comment on column AD_TXTSUPP.AD_TXTSUPP_DTTXT is
'Date texte SUPP';

comment on column AD_TXTSUPP.AD_TXTSUPP_DTPUBJO is
'Date publication au JO';

comment on column AD_TXTSUPP.AD_TXTSUPP_NUMCOMSIS is
'Numéro COMSIS';

comment on column AD_TXTSUPP.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_TXTSUPP.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_TXTSUPP for AD.AD_TXTSUPP;
GRANT SELECT ON  AD_TXTSUPP TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_TXTSUPP_FK1_1                                     */
/*==============================================================*/
create index AD_TXTSUPP_FK1_1 on AD_TXTSUPP (
   AD_SUPP_ID ASC
);

/*==============================================================*/
/* Index : AD_TXTSUPP_FK1_2                                     */
/*==============================================================*/
create index AD_TXTSUPP_FK1_2 on AD_TXTSUPP (
   RF_OBJTXT_ID ASC
);

/*==============================================================*/
/* Table : AD_UA                                                */
/*==============================================================*/
drop public synonym AD_UA;
create table AD_UA  (
   AD_UA_ID             INTEGER                         not null,
   AD_UA_MERE_ID        INTEGER,
   AD_COMIMP_ID         INTEGER                         not null,
   RF_TPRO_ID           INTEGER                         not null,
   RF_ARE_ID            INTEGER                         not null,
   RF_STATUA_ID         INTEGER                         not null,
   RF_COMM_ID           INTEGER                         not null,
   AD_UA_COD            VARCHAR2(19)                    not null,
   AD_UA_NUMORDRE       INTEGER                         not null,
   AD_UA_TITRE          INTEGER                         not null
      constraint UA_TITRE_CK1_2 check (AD_UA_TITRE in (1,2)),
   AD_UA_UI             VARCHAR2(8)                     not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_UA_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_UA_PK1_1 primary key (AD_UA_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_UA is
'Unité administrative';

comment on column AD_UA.AD_UA_ID is
'Identifiant de l''UA';

comment on column AD_UA.AD_UA_MERE_ID is
'Code de l''UA titre 2';

comment on column AD_UA.AD_COMIMP_ID is
'Identifiant de la commune d''implantation';

comment on column AD_UA.RF_TPRO_ID is
'Identifiant du type de proriétaire';

comment on column AD_UA.RF_ARE_ID is
'Identifiant de l''attributaire';

comment on column AD_UA.RF_STATUA_ID is
'Identifiant du code statut UA';

comment on column AD_UA.RF_COMM_ID is
'Identifiant de la commune';

comment on column AD_UA.AD_UA_COD is
'Code de l''UA';

comment on column AD_UA.AD_UA_NUMORDRE is
'Numéro d''ordre';

comment on column AD_UA.AD_UA_TITRE is
'Titre de l''UA';

comment on column AD_UA.AD_UA_UI is
'Unité Immobiliere';

comment on column AD_UA.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_UA.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_UA for AD.AD_UA;
GRANT SELECT ON  AD_UA TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_UA_FK1_2                                          */
/*==============================================================*/
create index AD_UA_FK1_2 on AD_UA (
   RF_STATUA_ID ASC
);

/*==============================================================*/
/* Index : AD_UA_FK1_3                                          */
/*==============================================================*/
create index AD_UA_FK1_3 on AD_UA (
   RF_ARE_ID ASC
);

/*==============================================================*/
/* Index : AD_UA_UN1_1                                          */
/*==============================================================*/
create unique index AD_UA_UN1_1 on AD_UA (
   AD_UA_COD ASC
);

/*==============================================================*/
/* Index : AD_UA_FK1_4                                          */
/*==============================================================*/
create index AD_UA_FK1_4 on AD_UA (
   AD_UA_MERE_ID ASC
);

/*==============================================================*/
/* Index : AD_UA_FK1_5                                          */
/*==============================================================*/
create index AD_UA_FK1_5 on AD_UA (
   AD_COMIMP_ID ASC
);

/*==============================================================*/
/* Index : AD_UA_FK1_1                                          */
/*==============================================================*/
create index AD_UA_FK1_1 on AD_UA (
   RF_TPRO_ID ASC
);

/*==============================================================*/
/* Index : AD_UA_FK1_6                                          */
/*==============================================================*/
create index AD_UA_FK1_6 on AD_UA (
   RF_COMM_ID ASC
);

/*==============================================================*/
/* Table : AD_UACAD                                             */
/*==============================================================*/
drop public synonym AD_UACAD;
create table AD_UACAD  (
   AD_UACAD_ID          INTEGER                         not null,
   AD_CAD_ID            INTEGER                         not null,
   AD_UA_ID             INTEGER                         not null,
   AD_UACAD_STOT        NUMBER(9),
   AD_UACAD_OBS         VARCHAR2(50),
   AD_UACAD_PARTIEL     VARCHAR2(5),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_UACAD_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_UACAD_PK1_1 primary key (AD_UACAD_ID)
);

comment on table AD_UACAD is
'Décomposer';

comment on column AD_UACAD.AD_UACAD_ID is
'Identifiant de UA - Parcelle cadastrale';

comment on column AD_UACAD.AD_CAD_ID is
'Identifiant de la parcelle cadastrale';

comment on column AD_UACAD.AD_UA_ID is
'Identifiant de l''UA';

comment on column AD_UACAD.AD_UACAD_STOT is
'Superficie parcelle cadastre';

comment on column AD_UACAD.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_UACAD.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_UACAD for AD.AD_UACAD;
GRANT SELECT ON  AD_UACAD TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_UACAD_FK1_1                                       */
/*==============================================================*/
create index AD_UACAD_FK1_1 on AD_UACAD (
   AD_CAD_ID ASC
);

/*==============================================================*/
/* Index : AD_UACAD_FK1_2                                       */
/*==============================================================*/
create index AD_UACAD_FK1_2 on AD_UACAD (
   AD_UA_ID ASC
);

/*==============================================================*/
/* Index : AD_UACAD_UN2_1                                       */
/*==============================================================*/
create unique index AD_UACAD_UN2_1 on AD_UACAD (
   AD_CAD_ID ASC,
   AD_UA_ID ASC
);

/*==============================================================*/
/* Table : AD_UADRO                                             */
/*==============================================================*/
drop public synonym AD_UADRO;
create table AD_UADRO  (
   AD_UADRO_ID          INTEGER                         not null,
   AD_UA_ID             INTEGER                         not null,
   RF_NATDRO_ID         INTEGER                         not null,
   RF_ORIDRO_ID         INTEGER                         not null,
   AD_UADRO_DTACT       VARCHAR2(15)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_UADRO_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_UADRO_PK1_1 primary key (AD_UADRO_ID)
);

comment on table AD_UADRO is
'Avoir pour nature et origine des droits';

comment on column AD_UADRO.AD_UADRO_ID is
'Identifiant de UA - NATDRO - ORIDRO';

comment on column AD_UADRO.AD_UA_ID is
'Identifiant de l''UA';

comment on column AD_UADRO.RF_NATDRO_ID is
'Identifiant de l''origine des droits';

comment on column AD_UADRO.RF_ORIDRO_ID is
'Identifiant de l''origine des droits';

comment on column AD_UADRO.AD_UADRO_DTACT is
'Date acte';

comment on column AD_UADRO.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_UADRO.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_UADRO for AD.AD_UADRO;
GRANT SELECT ON  AD_UADRO TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_UADRO_FK1_1                                       */
/*==============================================================*/
create index AD_UADRO_FK1_1 on AD_UADRO (
   AD_UA_ID ASC
);

/*==============================================================*/
/* Index : AD_UADRO_FK1_2                                       */
/*==============================================================*/
create index AD_UADRO_FK1_2 on AD_UADRO (
   RF_ORIDRO_ID ASC
);

/*==============================================================*/
/* Index : AD_UADRO_FK1_3                                       */
/*==============================================================*/
create index AD_UADRO_FK1_3 on AD_UADRO (
   RF_NATDRO_ID ASC
);

/*==============================================================*/
/* Index : AD_UADRO_UN4_1                                       */
/*==============================================================*/
create unique index AD_UADRO_UN4_1 on AD_UADRO (
   AD_UA_ID ASC,
   RF_NATDRO_ID ASC,
   RF_ORIDRO_ID ASC,
   AD_UADRO_DTACT ASC
);

/*==============================================================*/
/* Table : AD_UANATDECPRO                                       */
/*==============================================================*/
drop public synonym AD_UANATDECPRO;
create table AD_UANATDECPRO  (
   AD_UANATDECPRO_ID    INTEGER                         not null,
   AD_UA_ID             INTEGER                         not null,
   RF_NATDECPRO_ID      INTEGER                         not null,
   REFERENCE_A_LA_DM    VARCHAR2(50),
   AD_UANATDECPRO_DTDECPROFATT VARCHAR2(15)                    not null,
   AD_UANATDECPRO_DTFINCONV VARCHAR2(15),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_UANATDECPRO_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_UANATDECPRO_PK1_1 primary key (AD_UANATDECPRO_ID)
);

comment on table AD_UANATDECPRO is
'Avoir pour nature decision au profit attributaire';

comment on column AD_UANATDECPRO.AD_UANATDECPRO_ID is
'Identifiant de UA - NATDEC';

comment on column AD_UANATDECPRO.AD_UA_ID is
'Identifiant de l''UA';

comment on column AD_UANATDECPRO.RF_NATDECPRO_ID is
'Identifiant de la nature de décisio';

comment on column AD_UANATDECPRO.REFERENCE_A_LA_DM is
'Référence à la DM';

comment on column AD_UANATDECPRO.AD_UANATDECPRO_DTDECPROFATT is
'Date décision au profit attributaire';

comment on column AD_UANATDECPRO.AD_UANATDECPRO_DTFINCONV is
'Date de fin convention';

comment on column AD_UANATDECPRO.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_UANATDECPRO.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_UANATDECPRO for AD.AD_UANATDECPRO;
GRANT SELECT ON  AD_UANATDECPRO TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_UANATDECPRO_FK1_1                                 */
/*==============================================================*/
create index AD_UANATDECPRO_FK1_1 on AD_UANATDECPRO (
   AD_UA_ID ASC
);

/*==============================================================*/
/* Index : AD_UANATDECPRO_FK1_2                                 */
/*==============================================================*/
create index AD_UANATDECPRO_FK1_2 on AD_UANATDECPRO (
   RF_NATDECPRO_ID ASC
);

/*==============================================================*/
/* Index : AD_UANATDECPRO_UN3_1                                 */
/*==============================================================*/
create unique index AD_UANATDECPRO_UN3_1 on AD_UANATDECPRO (
   AD_UA_ID ASC,
   RF_NATDECPRO_ID ASC,
   AD_UANATDECPRO_DTDECPROFATT ASC
);

/*==============================================================*/
/* Table : AD_UASAUPP                                           */
/*==============================================================*/
drop public synonym AD_UASAUPP;
create table AD_UASAUPP  (
   AD_UASAUPP_ID        INTEGER                         not null,
   AD_SAUPP_ID          INTEGER                         not null,
   AD_UA_ID             INTEGER                         not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_UASAUPP_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_UASAUPP_PK1_1 primary key (AD_UASAUPP_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_UASAUPP is
'Avoir pour UA';

comment on column AD_UASAUPP.AD_UASAUPP_ID is
'Identifiant de la table UA - SAUPP';

comment on column AD_UASAUPP.AD_SAUPP_ID is
'Identifiant de la servitude autre que d''utilité publique au profit';

comment on column AD_UASAUPP.AD_UA_ID is
'Identifiant de l''UA';

comment on column AD_UASAUPP.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_UASAUPP.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_UASAUPP for AD.AD_UASAUPP;
GRANT SELECT ON  AD_UASAUPP TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_UASAUPP_FK1_1                                     */
/*==============================================================*/
create index AD_UASAUPP_FK1_1 on AD_UASAUPP (
   AD_SAUPP_ID ASC
);

/*==============================================================*/
/* Index : AD_UASAUPP_FK1_2                                     */
/*==============================================================*/
create index AD_UASAUPP_FK1_2 on AD_UASAUPP (
   AD_UA_ID ASC
);

/*==============================================================*/
/* Index : AD_UASAUPP_UN2_1                                     */
/*==============================================================*/
create unique index AD_UASAUPP_UN2_1 on AD_UASAUPP (
   AD_SAUPP_ID ASC,
   AD_UA_ID ASC
);

/*==============================================================*/
/* Table : AD_UFRUIT                                            */
/*==============================================================*/
drop public synonym AD_UFRUIT;
create table AD_UFRUIT  (
   AD_UFRUIT_ID         INTEGER                         not null,
   AD_OPEDOM_ID         INTEGER                         not null,
   AD_UFRUIT_BENEF      VARCHAR2(75),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_UFRUIT_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_UFRUIT_PK1_1 primary key (AD_UFRUIT_ID)
         using index
       tablespace TS_INDEX_AD
)
tablespace TS_DATA_AD;

comment on table AD_UFRUIT is
'Remise usufruit';

comment on column AD_UFRUIT.AD_UFRUIT_ID is
'Identifiant de la remise usufruit';

comment on column AD_UFRUIT.AD_OPEDOM_ID is
'Identifiant de l''opération domaniale';

comment on column AD_UFRUIT.AD_UFRUIT_BENEF is
'Bénéficiaire US';

comment on column AD_UFRUIT.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_UFRUIT.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_UFRUIT for AD.AD_UFRUIT;
GRANT SELECT ON  AD_UFRUIT TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_UFRUIT_FK1_1                                      */
/*==============================================================*/
create unique index AD_UFRUIT_FK1_1 on AD_UFRUIT (
   AD_OPEDOM_ID ASC
);

/*==============================================================*/
/* Table : AD_USER                                              */
/*==============================================================*/
drop public synonym AD_USER;
create table AD_USER  (
   AD_USER_ID           INTEGER                         not null,
   MN_PERS_ID           VARCHAR2(15)                    not null,
   AD_ROLE_ID           INTEGER                         not null,
   AD_SMAJ_ID           INTEGER                         not null,
   AD_DOMAINE_ID        INTEGER                         not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_USER_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_USER_PK1_1 primary key (AD_USER_ID)
);

comment on table AD_USER is
'Lien entre MN_PERS et RF_ORGANISME';

comment on column AD_USER.AD_USER_ID is
'Identifiant de la table de liaison entre Mn_Pers et Rf_Organisme';

comment on column AD_USER.MN_PERS_ID is
'Identifiant de la personne';

comment on column AD_USER.AD_ROLE_ID is
'Identifiant de la table des Roles';

comment on column AD_USER.AD_SMAJ_ID is
'Identifaint du service de mise à jour';

comment on column AD_USER.AD_DOMAINE_ID is
'Identifaint du DOMAINE';

comment on column AD_USER.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_USER.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_USER for AD.AD_USER;
GRANT SELECT ON  AD_USER TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_USER_FK1_1                                        */
/*==============================================================*/
create unique index AD_USER_FK1_1 on AD_USER (
   MN_PERS_ID ASC
);

/*==============================================================*/
/* Index : AD_USER_FK1_2                                        */
/*==============================================================*/
create index AD_USER_FK1_2 on AD_USER (
   AD_ROLE_ID ASC
);

/*==============================================================*/
/* Index : AD_USER_FK1_3                                        */
/*==============================================================*/
create index AD_USER_FK1_3 on AD_USER (
   AD_SMAJ_ID ASC
);

/*==============================================================*/
/* Index : AD_USER_FK1_4                                        */
/*==============================================================*/
create index AD_USER_FK1_4 on AD_USER (
   AD_DOMAINE_ID ASC
);

/*==============================================================*/
/* Table : AD_VALRECONT                                         */
/*==============================================================*/
create table AD_VALRECONT  (
   AD_VALRECONT_ID      INTEGER                         not null,
   AD_METACHORUS_ID     INTEGER                         not null,
   AD_VALRECONT_VAL     VARCHAR2(255)                   not null,
   AD_VALRECONT_DTEXPORT VARCHAR2(15)                    not null,
   AD_VALRECONT_OBS     VARCHAR2(50),
   AD_ACTIONCONT_LIB    VARCHAR2(10)                    not null,
   AD_IMM_COD           VARCHAR2(10)                    not null,
   AD_CPT_COD           INTEGER                         not null,
   RF_ARE_COD           VARCHAR2(5)                     not null,
   AD_IMM_DEN           VARCHAR2(40)                    not null,
   AD_IMM_NUMCHORUS     VARCHAR2(6)                     not null,
   AD_CPT_DEN           VARCHAR2(50)                    not null,
   AD_CPT_NUMCHORUS     VARCHAR2(6)                     not null,
   RF_ORGANISME_LIBA    VARCHAR2(30)                    not null,
   AD_VALRECONT_OPERG2D VARCHAR2(50)                    not null,
   AD_VALRECONT_DTMVTG2D VARCHAR2(15)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_VALRECONT_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   AD_VALRECONT_OLDVAL  VARCHAR2(255)                   not null,
   constraint AD_VALRECONT_PK1_1 primary key (AD_VALRECONT_ID)
);

comment on table AD_VALRECONT is
'Valeurs des contrats en cours de mises à jour au niveau intermédiaire';

comment on column AD_VALRECONT.AD_VALRECONT_ID is
'Identifiant Donnée parcelle Chorus';

comment on column AD_VALRECONT.AD_METACHORUS_ID is
'Identifiant des méta données Chorus';

comment on column AD_VALRECONT.AD_VALRECONT_VAL is
'Valeur';

comment on column AD_VALRECONT.AD_VALRECONT_DTEXPORT is
'Date exportation';

comment on column AD_VALRECONT.AD_VALRECONT_OBS is
'Observation';

comment on column AD_VALRECONT.AD_IMM_COD is
'Ad_imm_cod';

comment on column AD_VALRECONT.AD_CPT_COD is
'ad_cpt_cod';

comment on column AD_VALRECONT.AD_VALRECONT_OPERG2D is
'Opérateur G2D';

comment on column AD_VALRECONT.AD_VALRECONT_DTMVTG2D is
'Date du mouvement dans G2D';

comment on column AD_VALRECONT.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_VALRECONT.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

comment on column AD_VALRECONT.AD_VALRECONT_OLDVAL is
'ancienne valeur G2D';

/*==============================================================*/
/* Index : AD_VALRECONT_FK1_1                                   */
/*==============================================================*/
create index AD_VALRECONT_FK1_1 on AD_VALRECONT (
   AD_METACHORUS_ID ASC
);

/*==============================================================*/
/* Table : AD_VALRECPT                                          */
/*==============================================================*/
create table AD_VALRECPT  (
   AD_VALRECPT_ID       INTEGER                         not null,
   AD_METACHORUS_ID     INTEGER                         not null,
   AD_VALRECPT_VAL      VARCHAR2(255)                   not null,
   AD_VALRECPT_DTEXPORT VARCHAR2(15)                    not null,
   AD_VALRECPT_OBS      VARCHAR2(50),
   AD_ACTIONCPT_LIB     VARCHAR2(10)                    not null,
   AD_IMM_COD           VARCHAR2(10)                    not null,
   AD_IMM_DEN           VARCHAR2(40)                    not null,
   AD_IMM_NUMCHORUS     VARCHAR2(6)                     not null,
   AD_CPT_COD           INTEGER                         not null,
   AD_CPT_DEN           VARCHAR2(50)                    not null,
   AD_CPT_NUMCHORUS     VARCHAR2(6)                     not null,
   RF_ORGANISME_LIBA    VARCHAR2(30)                    not null,
   AD_VALRECPT_OPERG2D  VARCHAR2(50)                    not null,
   AD_VALRECPT_DTMVTG2D VARCHAR2(15)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_VALRECPT_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   AD_VALRECPT_OLDVAL   VARCHAR2(255)                   not null,
   constraint AD_VALRECPT_PK1_1 primary key (AD_VALRECPT_ID)
);

comment on table AD_VALRECPT is
'Valeurs des composants en cours de mise à jour au niveau intermédiaire';

comment on column AD_VALRECPT.AD_VALRECPT_ID is
'Identifiant Donnée Composant Chorus';

comment on column AD_VALRECPT.AD_METACHORUS_ID is
'Identifiant des méta données Chorus';

comment on column AD_VALRECPT.AD_VALRECPT_VAL is
'Valeur';

comment on column AD_VALRECPT.AD_VALRECPT_DTEXPORT is
'Date exportation';

comment on column AD_VALRECPT.AD_VALRECPT_OBS is
'Observation';

comment on column AD_VALRECPT.AD_IMM_COD is
'Ad_imm_cod';

comment on column AD_VALRECPT.AD_CPT_COD is
'Ad_cpt_cod';

comment on column AD_VALRECPT.AD_VALRECPT_OPERG2D is
'Opérateur G2D';

comment on column AD_VALRECPT.AD_VALRECPT_DTMVTG2D is
'Date du mouvement dans G2D';

comment on column AD_VALRECPT.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_VALRECPT.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

comment on column AD_VALRECPT.AD_VALRECPT_OLDVAL is
'ancienne valeur G2D';

/*==============================================================*/
/* Index : AD_VALRECPT_FK1_1                                    */
/*==============================================================*/
create index AD_VALRECPT_FK1_1 on AD_VALRECPT (
   AD_METACHORUS_ID ASC
);

/*==============================================================*/
/* Table : AD_VALREPARC                                         */
/*==============================================================*/
create table AD_VALREPARC  (
   AD_VALREPARC_ID      INTEGER                         not null,
   AD_METACHORUS_ID     INTEGER                         not null,
   AD_VALREPARC_VAL     VARCHAR2(255)                   not null,
   AD_VALREPARC_DTEXPORT VARCHAR2(15)                    not null,
   AD_VALREPARC_OBS     VARCHAR2(50),
   AD_ACTIONPARC_LIB    VARCHAR2(10)                    not null,
   AD_IMM_COD           VARCHAR2(10)                    not null,
   AD_CAD_PREF          VARCHAR2(3)                     not null,
   AD_CAD_SEC           VARCHAR2(3)                     not null,
   AD_CAD_NUM           VARCHAR2(10)                    not null,
   RF_COMM_COD          VARCHAR2(3)                     not null,
   RF_DEPT_COD          VARCHAR2(3)                     not null,
   AD_IMM_DEN           VARCHAR2(40)                    not null,
   AD_IMM_NUMCHORUS     VARCHAR2(6)                     not null,
   RF_ORGANISME_LIBA    VARCHAR2(30)                    not null,
   AD_VALREPARC_OPERG2D VARCHAR2(50)                    not null,
   AD_VALREPARC_DTMVTG2D VARCHAR2(15)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_VALREPARC_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   AD_VALREPARC_OLDVAL  VARCHAR2(255)                   not null,
   constraint AD_VALREPARC_PK1_1 primary key (AD_VALREPARC_ID)
);

comment on table AD_VALREPARC is
'Valeurs des parcelles en cours de mises à jour au niveau intermédiaire';

comment on column AD_VALREPARC.AD_VALREPARC_ID is
'Identifiant Donnée parcelle Chorus';

comment on column AD_VALREPARC.AD_METACHORUS_ID is
'Identifiant des méta données Chorus';

comment on column AD_VALREPARC.AD_VALREPARC_VAL is
'Valeur';

comment on column AD_VALREPARC.AD_VALREPARC_DTEXPORT is
'Date exportation';

comment on column AD_VALREPARC.AD_VALREPARC_OBS is
'Observation';

comment on column AD_VALREPARC.AD_IMM_COD is
'Ad_imm_cod';

comment on column AD_VALREPARC.AD_CAD_PREF is
'Ad_cad_pref';

comment on column AD_VALREPARC.AD_CAD_SEC is
'Ad_cad_sec';

comment on column AD_VALREPARC.AD_CAD_NUM is
'Ad_cad_num';

comment on column AD_VALREPARC.RF_COMM_COD is
'Code de la commune';

comment on column AD_VALREPARC.RF_DEPT_COD is
'Code du département';

comment on column AD_VALREPARC.AD_VALREPARC_OPERG2D is
'Opérateur G2D';

comment on column AD_VALREPARC.AD_VALREPARC_DTMVTG2D is
'Date du mouvement dans G2D';

comment on column AD_VALREPARC.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_VALREPARC.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

comment on column AD_VALREPARC.AD_VALREPARC_OLDVAL is
'ancienne valeur G2D';

create or replace public synonym AD_VALREPARC for AD.AD_VALREPARC;
GRANT SELECT ON  AD_VALREPARC TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_VALREPARC_FK1_1                                   */
/*==============================================================*/
create index AD_VALREPARC_FK1_1 on AD_VALREPARC (
   AD_METACHORUS_ID ASC
);

/*==============================================================*/
/* Table : AD_VALRESITE                                         */
/*==============================================================*/
create table AD_VALRESITE  (
   AD_VALRESITE_ID      INTEGER                         not null,
   AD_METACHORUS_ID     INTEGER                         not null,
   AD_VALRESITE_VAL     VARCHAR2(255)                   not null,
   AD_VALRESITE_DTEXPORT VARCHAR2(15)                    not null,
   AD_VALRESITE_OBS     VARCHAR2(50),
   AD_ACTIONSITE_LIB    VARCHAR2(10)                    not null,
   AD_IMM_COD           VARCHAR2(10)                    not null,
   AD_IMM_DEN           VARCHAR2(40)                    not null,
   AD_IMM_NUMCHORUS     VARCHAR2(6)                     not null,
   RF_ORGANISME_LIBA    VARCHAR2(30)                    not null,
   AD_VALRESITE_OPERG2D VARCHAR2(50)                    not null,
   AD_VALRESITE_DTMVTG2D VARCHAR2(15)                    not null,
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_VALRESITE_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   AD_VALRESITE_OLDVAL  VARCHAR2(255)                   not null,
   constraint AD_VALRESITE_PK1_1 primary key (AD_VALRESITE_ID)
);

comment on table AD_VALRESITE is
'Valeurs des sites en cours de mise à jour au niveau intermédiaire';

comment on column AD_VALRESITE.AD_VALRESITE_ID is
'Identifiant Donnée Site Chorus';

comment on column AD_VALRESITE.AD_METACHORUS_ID is
'Identifiant des méta données Chorus';

comment on column AD_VALRESITE.AD_VALRESITE_VAL is
'Valeur';

comment on column AD_VALRESITE.AD_VALRESITE_DTEXPORT is
'Date exportation';

comment on column AD_VALRESITE.AD_VALRESITE_OBS is
'Observation';

comment on column AD_VALRESITE.AD_IMM_COD is
'Ad_imm_cod';

comment on column AD_VALRESITE.AD_VALRESITE_OPERG2D is
'Opérateur G2D';

comment on column AD_VALRESITE.AD_VALRESITE_DTMVTG2D is
'Date du mouvement dans G2D';

comment on column AD_VALRESITE.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_VALRESITE.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

comment on column AD_VALRESITE.AD_VALRESITE_OLDVAL is
'ancienne valeur G2D';

/*==============================================================*/
/* Index : AD_VALRESITE_FK1_1                                   */
/*==============================================================*/
create index AD_VALRESITE_FK1_1 on AD_VALRESITE (
   AD_METACHORUS_ID ASC
);

/*==============================================================*/
/* Table : AD_VIEDM                                             */
/*==============================================================*/
drop public synonym AD_VIEDM;
create table AD_VIEDM  (
   AD_VIEDM_ID          INTEGER                         not null,
   AD_DECMIN_ID         INTEGER                         not null,
   AD_NATDM_ID          INTEGER                         not null,
   AD_VIEDM_REF         VARCHAR2(50)                    not null,
   AD_VIEDM_DT          VARCHAR2(15)                    not null,
   AD_VIEDM_NOTE        VARCHAR2(150),
   AD_XDMAJ             VARCHAR2(15)                    not null,
   AD_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint AD_VIEDM_CK1_1 check (AD_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint AD_VIEDM_PK1_1 primary key (AD_VIEDM_ID)
);

comment on table AD_VIEDM is
'Vie de la DM';

comment on column AD_VIEDM.AD_VIEDM_ID is
'Identifiant de la vie de la DM';

comment on column AD_VIEDM.AD_DECMIN_ID is
'Identifiant Décision Ministérielle';

comment on column AD_VIEDM.AD_NATDM_ID is
'Identifiant';

comment on column AD_VIEDM.AD_VIEDM_REF is
'Référence de la DM';

comment on column AD_VIEDM.AD_VIEDM_DT is
'Date de la DM';

comment on column AD_VIEDM.AD_VIEDM_NOTE is
'Note de la DM';

comment on column AD_VIEDM.AD_XDMAJ is
'Date de mise à jour';

comment on column AD_VIEDM.AD_XTOPSUP is
'Indicateur pour savoir si l''enregistrement est valide';

create public synonym AD_VIEDM for AD.AD_VIEDM;
GRANT SELECT ON  AD_VIEDM TO AD_SEL_A_UTI;

/*==============================================================*/
/* Index : AD_VIEDM_FK1_1                                       */
/*==============================================================*/
create index AD_VIEDM_FK1_1 on AD_VIEDM (
   AD_DECMIN_ID ASC
);

/*==============================================================*/
/* Index : AD_VIEDM_FK1_2                                       */
/*==============================================================*/
create index AD_VIEDM_FK1_2 on AD_VIEDM (
   AD_NATDM_ID ASC
);

/*==============================================================*/
/* Table : RF_LCLCATUTIL                                        */
/*==============================================================*/
drop public synonym RF_LCLCATUTIL;
create table REF2.RF_LCLCATUTIL  (
   RF_LCLCATUTIL_ID     INTEGER                         not null,
   RF_LCLCATUTIL_COD    VARCHAR2(2)                     not null,
   RF_LCLCATUTIL_LIB    VARCHAR2(100),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_LCLCATUTIL_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint RF_LCLCATUTIL_PK1_1 primary key ()
);

comment on table REF2.RF_LCLCATUTIL is
'Catégorie classe utilisation local';

comment on column REF2.RF_LCLCATUTIL.RF_LCLCATUTIL_ID is
'RF_LCLCATUTIL_ID';

comment on column REF2.RF_LCLCATUTIL.RF_LCLCATUTIL_COD is
'Code';

comment on column REF2.RF_LCLCATUTIL.RF_LCLCATUTIL_LIB is
'Libellé';

comment on column REF2.RF_LCLCATUTIL.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column REF2.RF_LCLCATUTIL.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

create public synonym RF_LCLCATUTIL for REF.RF_LCLCATUTIL;
grant select, references on RF_LCLCATUTIL to PUBLIC;

/*==============================================================*/
/* Index : RF_LCLCATUTIL_PK1_1                                  */
/*==============================================================*/
create unique index REF2.RF_LCLCATUTIL_PK1_1 on REF2.RF_LCLCATUTIL (
    ASC
);

/*==============================================================*/
/* Index : RF_LCLCATUTIL_UN1_1                                  */
/*==============================================================*/
create unique index REF2.RF_LCLCATUTIL_UN1_1 on REF2.RF_LCLCATUTIL (
    ASC
);

/*==============================================================*/
/* Table : RF_LCLCLAUTIL                                        */
/*==============================================================*/
drop public synonym RF_LCLCLAUTIL;
create table RF_LCLCLAUTIL  (
   RF_LCLCLAUTIL_ID     INTEGER                         not null,
   RF_LCLCATUTIL_ID     INTEGER                         not null,
   RF_LCLCLAUTIL_COD    VARCHAR2(3)                     not null,
   RF_LCLCLAUTIL_LIB    VARCHAR2(100),
   RF_XDMAJ             VARCHAR2(15)                    not null,
   RF_XTOPSUP           VARCHAR2(1)                    default '0' not null
      constraint RF_LCLCLAUTIL_CK1_1 check (RF_XTOPSUP in ('0','1','2','3','4','9','M')),
   constraint RF_LCLCLAUTIL_PK1_1 primary key (RF_LCLCLAUTIL_ID)
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
'Libellé';

comment on column RF_LCLCLAUTIL.RF_XDMAJ is
'Date de mise a jour de l''enregistrement';

comment on column RF_LCLCLAUTIL.RF_XTOPSUP is
'Indicateur pour savoir si enregistrement valide ou non';

create public synonym RF_LCLCLAUTIL for REF.RF_LCLCLAUTIL;
grant select, references on RF_LCLCLAUTIL to PUBLIC;

/*==============================================================*/
/* Index : RF_LCLCLAUTIL_FK1_1                                  */
/*==============================================================*/
create index REF2.RF_LCLCLAUTIL_FK1_1 on RF_LCLCLAUTIL (
   
);

/*==============================================================*/
/* Index : RF_LCLCLAUTIL_UN2_1                                  */
/*==============================================================*/
create unique index REF2.RF_LCLCLAUTIL_UN2_1 on RF_LCLCLAUTIL (
   RF_LCLCATUTIL_ID ASC,
   RF_LCLCLAUTIL_COD ASC
);

alter table AD_ACQ
   add constraint AD_ACQ_FK1_1 foreign key (AD_OPEDOM_ID)
      references AD_OPEDOM (AD_OPEDOM_ID);

alter table AD_ACTIONCONT
   add constraint AD_ACTIONCONT_FK1_1 foreign key (AD_METACHORUS_ID)
      references AD_METACHORUS (AD_METACHORUS_ID);

alter table AD_ACTIONCPT
   add constraint AD_ACTIONCPT_FK1_1 foreign key (AD_METACHORUS_ID)
      references AD_METACHORUS (AD_METACHORUS_ID);

alter table AD_ACTIONPARC
   add constraint AD_ACTIONPARC_FK1_1 foreign key (AD_METACHORUS_ID)
      references AD_METACHORUS (AD_METACHORUS_ID);

alter table AD_ACTIONSITE
   add constraint AD_ACTIONSITE_FK1_1 foreign key (AD_METACHORUS_ID)
      references AD_METACHORUS (AD_METACHORUS_ID);

alter table AD_AFAE
   add constraint AD_AFAE_FK1_1 foreign key (RF_NATTXT_ID)
      references RF_NATTXT (RF_NATTXT_ID);

alter table AD_AFC
   add constraint AD_AFC_FK1_1 foreign key (AD_OPEDOM_ID)
      references AD_OPEDOM (AD_OPEDOM_ID);

alter table AD_AFF
   add constraint AD_AFF_FK1_1 foreign key (AD_OPEDOM_ID)
      references AD_OPEDOM (AD_OPEDOM_ID);

alter table AD_AFF
   add constraint AD_AFF_FK1_2 foreign key (RF_AFFECT_ID)
      references RF_AFFECT (RF_AFFECT_ID);

alter table AD_AREAFAE
   add constraint FK_AD_AREAF_AD_AREAFA_RF_ARE foreign key (RF_ARE_ID)
      references RF_ARE (RF_ARE_ID);

alter table AD_AREAFAE
   add constraint FK_AD_AREAF_AD_AREAFA_AD_AFAE foreign key (AD_AFAE_ID)
      references AD_AFAE (AD_AFAE_ID);

alter table AD_AUT
   add constraint AD_AUT_FK1_1 foreign key (AD_OPEDOM_ID)
      references AD_OPEDOM (AD_OPEDOM_ID);

alter table AD_AUT
   add constraint AD_AUT_FK1_2 foreign key (RF_MSORT_ID)
      references RF_MSORT (RF_MSORT_ID);

alter table AD_AVAFAE
   add constraint FK_AD_AVAFA_AD_AVAFAE_AD_AFAE foreign key (AD_AFAE_ID)
      references AD_AFAE (AD_AFAE_ID);

alter table AD_BAIL
   add constraint AD_BAIL_FK1_1 foreign key (RF_TLOC_ID)
      references RF_TLOC (RF_TLOC_ID);

alter table AD_BAIL
   add constraint AD_BAIL_FK1_2 foreign key (AD_OPEDOM_ID)
      references AD_OPEDOM (AD_OPEDOM_ID);

alter table AD_BIBLIOEDT
   add constraint AD_BIBLIOEDT_FK1_1 foreign key (RF_TFICHIER_ID)
      references RF_TFICHIER (RF_TFICHIER_ID);

alter table AD_CAD
   add constraint AD_CAD_FK1_1 foreign key (RF_COMM_ID)
      references RF_COMM (RF_COMM_ID);

alter table AD_COMIMP
   add constraint AD_COMIMP_FK1_1 foreign key (AD_IMM_ID)
      references AD_IMM (AD_IMM_ID);

alter table AD_COMIMP
   add constraint AD_COMIMP_FK1_2 foreign key (RF_COMM_ID)
      references RF_COMM (RF_COMM_ID);

alter table AD_COMSUPP
   add constraint AD_COMSUPP_FK1_1 foreign key (AD_SUPP_ID)
      references AD_SUPP (AD_SUPP_ID);

alter table AD_COMSUPP
   add constraint AD_COMSUPP_FK1_2 foreign key (RF_COMM_ID)
      references RF_COMM (RF_COMM_ID);

alter table AD_COMURB
   add constraint AD_COMMURB_FK1_1 foreign key (RF_COMM_ID)
      references RF_COMM (RF_COMM_ID);

alter table AD_CPT
   add constraint AD_CPT_FK1_1 foreign key (AD_IMM_ID)
      references AD_IMM (AD_IMM_ID);

alter table AD_CPT
   add constraint AD_CPT_FK1_2 foreign key (RF_TCOMPO_ID)
      references RF_TCOMPO (RF_TCOMPO_ID);

alter table AD_CPT
   add constraint AD_CPT_FK1_3 foreign key (AD_COMIMP_ID)
      references AD_COMIMP (AD_COMIMP_ID);

alter table AD_CPT
   add constraint AD_CPT_FK1_4 foreign key (RF_TOUV_ID)
      references RF_TOUV (RF_TOUV_ID);

alter table AD_CPTBATI
   add constraint AD_CPTBATI_FK1_1 foreign key (RF_ETATENT_ID)
      references RF_ETATENT (RF_ETATENT_ID);

alter table AD_CPTBATI
   add constraint AD_CPTBATI_FK1_2 foreign key (AD_CPT_ID)
      references AD_CPT (AD_CPT_ID);

alter table AD_CPTBATI
   add constraint AD_CPTBATI_FK1_3 foreign key (RF_TCONS_ID)
      references RF_TCONS (RF_TCONS_ID);

alter table AD_CPTBATI
   add constraint AD_CPTBATI_FK1_4 foreign key (RF_CPTIND_ID)
      references RF_CPTIND (RF_CPTIND_ID);

alter table AD_CPTCOHER
   add constraint AD_CPTCOHER_FK1_1 foreign key (AD_CPT_ID)
      references AD_CPT (AD_CPT_ID);

alter table AD_CPTETU
   add constraint AD_CPTETU_FK1_1 foreign key (RF_TOUV_ID)
      references RF_TOUV (RF_TOUV_ID);

alter table AD_CPTETU
   add constraint AD_CPTETU_FK1_2 foreign key (AD_IMM_ID)
      references AD_IMM (AD_IMM_ID);

alter table AD_CPTHISTO
   add constraint AD_CPTHISTO_FK1_1 foreign key (AD_IMM_ID)
      references AD_IMM (AD_IMM_ID);

alter table AD_CPTNBATI
   add constraint AD_CPTNBATI_FK1_1 foreign key (AD_CPT_ID)
      references AD_CPT (AD_CPT_ID);

alter table AD_CPTNIV
   add constraint AD_CPTNIV_FK1_1 foreign key (AD_CPTBATI_ID)
      references AD_CPTBATI (AD_CPTBATI_ID);

alter table AD_CPTNIV
   add constraint AD_CPTNIV_FK1_2 foreign key (RF_TNIV_ID)
      references RF_TNIV (RF_TNIV_ID);

alter table AD_CPT_OLD
   add constraint AD_CPT_OLD_FK1_1 foreign key (AD_CPT_ID)
      references AD_CPT (AD_CPT_ID);

alter table AD_CRITERESEDT
   add constraint AD_CRITERESEDT_FK1_1 foreign key (AD_BIBLIOEDT_ID)
      references AD_BIBLIOEDT (AD_BIBLIOEDT_ID);

alter table AD_DECDPA
   add constraint AD_DECDPA_FK1_1 foreign key (AD_DECDPU_ID)
      references AD_DECDPU (AD_DECDPU_ID);

alter table AD_DECDPU
   add constraint AD_DECDPU_FK1_1 foreign key (AD_IMM_ID)
      references AD_IMM (AD_IMM_ID);

alter table AD_DECDPU
   add constraint AD_DECDPU_FK1_2 foreign key (RF_NATTXT_ID)
      references RF_NATTXT (RF_NATTXT_ID);

alter table AD_DECMIN
   add constraint FK_AD_DECMI_AD_DECMIN_AD_ORIEN foreign key (AD_ORIENFIN_ID)
      references AD_ORIENFIN (AD_ORIENFIN_ID);

alter table AD_DECMIN
   add constraint AD_DECMIN_FK1_3 foreign key (AD_NIVDEC_ID)
      references AD_NIVDEC (AD_NIVDEC_ID);

alter table AD_DECMIN
   add constraint AD_DECMIN_FK1_4 foreign key (AD_STATUTDM_ID)
      references AD_STATUTDM (AD_STATUTDM_ID);

alter table AD_DECMINARE
   add constraint AD_DECMINARE_FK1_1 foreign key (AD_DECMIN_ID)
      references AD_DECMIN (AD_DECMIN_ID);

alter table AD_DECMINARE
   add constraint AD_DECMINARE_FK1_2 foreign key (RF_ARE_ID)
      references RF_ARE (RF_ARE_ID);

alter table AD_DECNDPA
   add constraint AD_DECNPDA_FK1_1 foreign key (AD_DECDPU_ID)
      references AD_DECDPU (AD_DECDPU_ID);

alter table AD_ECHCOMP
   add constraint AD_ECHCOMP_FK1_1 foreign key (RF_TBENECH_ID)
      references RF_TBENECH (RF_TBENECH_ID);

alter table AD_ECHCOMP
   add constraint AD_ECHCOMP_FK1_2 foreign key (AD_OPEDOM_ID)
      references AD_OPEDOM (AD_OPEDOM_ID);

alter table AD_ECHCOMP
   add constraint FK_AD_ECHCO_AD_ECHCOM_RF_AFFEC foreign key (RF_AFFECT_ID)
      references RF_AFFECT (RF_AFFECT_ID);

alter table AD_ECHSIMP
   add constraint AD_ECHSIMP_FK1_1 foreign key (RF_TSOULTE_ID)
      references RF_TSOULTE (RF_TSOULTE_ID);

alter table AD_ECHSIMP
   add constraint AD_ECHSIMP_FK1_2 foreign key (AD_OPEDOM_ID)
      references AD_OPEDOM (AD_OPEDOM_ID);

alter table AD_EXCLUSUB
   add constraint AD_EXCLUSUB_FK1_1 foreign key (RF_LCLCLAUTIL_ID)
      references RF_LCLCLAUTIL (RF_LCLCLAUTIL_ID);

alter table AD_GESTEDT
   add constraint AD_GESTEDT_FK1_1 foreign key (AD_TEDT_ID)
      references AD_TEDT (AD_TEDT_ID);

alter table AD_GESTEDT
   add constraint AD_GESTEDT_FK1_2 foreign key (AD_TETATEDT_ID)
      references AD_TETATEDT (AD_TETATEDT_ID);

alter table AD_IMM
   add constraint AD_IMM_FK1_1 foreign key (AD_EIM_ID)
      references AD_EIM (AD_EIM_ID);

alter table AD_IMM
   add constraint AD_IMM_FK1_10 foreign key (RF_GRDCMP_ID)
      references RF_GRDCMP (RF_GRDCMP_ID);

alter table AD_IMM
   add constraint AD_IMM_FK1_11 foreign key (RF_AFFAERO_ID)
      references RF_AFFAERO (RF_AFFAERO_ID);

alter table AD_IMM
   add constraint AD_IMM_FK1_12 foreign key (RF_COMM_ID)
      references RF_COMM (RF_COMM_ID);

alter table AD_IMM
   add constraint AD_IMM_FK1_13 foreign key (RF_AFFSJCT_ID)
      references RF_AFFSJCT (RF_AFFSJCT_ID);

alter table AD_IMM
   add constraint AD_IMM_FK1_14 foreign key (RF_BDD_ID)
      references REF.RF_BDD (RF_BDD_ID);

alter table AD_IMM
   add constraint AD_IMM_FK1_2 foreign key (AD_SMAJ_ID)
      references AD_SMAJ (AD_SMAJ_ID);

alter table AD_IMM
   add constraint AD_IMM_FK1_3 foreign key (RF_SEGPAT_ID)
      references RF_SEGPAT (RF_SEGPAT_ID);

alter table AD_IMM
   add constraint AD_IMM_FK1_4 foreign key (AD_AFAE_ID)
      references AD_AFAE (AD_AFAE_ID);

alter table AD_IMM
   add constraint AD_IMM_FK1_5 foreign key (RF_RATFIS_ID)
      references RF_RATFIS (RF_RATFIS_ID);

alter table AD_IMM
   add constraint AD_IMM_FK1_6 foreign key (RF_IMMIND_ID)
      references RF_IMMIND (RF_IMMIND_ID);

alter table AD_IMM
   add constraint AD_IMM_FK1_7 foreign key (AD_REPOCC_ID)
      references AD_REPOCC (AD_REPOCC_ID);

alter table AD_IMM
   add constraint AD_IMM_FK1_8 foreign key (RF_SCTUTIL_ID)
      references RF_SCTUTIL (RF_SCTUTIL_ID);

alter table AD_IMM
   add constraint AD_IMM_FK1_9 foreign key (RF_BASE_ID)
      references RF_BASE (RF_BASE_ID);

alter table AD_IMMADR
   add constraint AD_IMMADR_FK1_1 foreign key (RF_NATVOI_ID)
      references RF_NATVOI (RF_NATVOI_ID);

alter table AD_IMMADR
   add constraint AD_IMMADR_FK1_2 foreign key (RF_COMM_ID)
      references RF_COMM (RF_COMM_ID);

alter table AD_IMMADR
   add constraint AD_IMMADR_FK1_3 foreign key (AD_IMM_ID)
      references AD_IMM (AD_IMM_ID);

alter table AD_IMMARE
   add constraint AD_IMMARE_FK1_1 foreign key (AD_IMM_ID)
      references AD_IMM (AD_IMM_ID);

alter table AD_IMMARE
   add constraint AD_IMMARE_FK1_2 foreign key (RF_ARE_ID)
      references RF_ARE (RF_ARE_ID);

alter table AD_IMMCOHER
   add constraint AD_IMMCOHER_FK1_1 foreign key (AD_IMM_ID)
      references AD_IMM (AD_IMM_ID);

alter table AD_IMMOCC
   add constraint AD_IMMOCC_FK1_1 foreign key (AD_IMM_ID)
      references AD_IMM (AD_IMM_ID);

alter table AD_IMMOCC
   add constraint AD_IMMOCC_FK1_2 foreign key (AD_REPOCC_ID)
      references AD_REPOCC (AD_REPOCC_ID);

alter table AD_IMMOPEDOM
   add constraint AD_IMMOPEDOM_FK1_1 foreign key (AD_OPEDOM_ID)
      references AD_OPEDOM (AD_OPEDOM_ID);

alter table AD_IMMOPEDOM
   add constraint AD_IMMOPEDOM_FK1_2 foreign key (AD_IMM_ID)
      references AD_IMM (AD_IMM_ID);

alter table AD_IMMSAUPP
   add constraint AD_IMMSAUPP_FK1_1 foreign key (AD_IMM_ID)
      references AD_IMM (AD_IMM_ID);

alter table AD_IMMSAUPP
   add constraint AD_IMMSAUPP_FK1_2 foreign key (AD_SAUPP_ID)
      references AD_SAUPP (AD_SAUPP_ID);

alter table AD_IMMSUPP
   add constraint AD_IMMSUPP_FK1_1 foreign key (AD_IMM_ID)
      references AD_IMM (AD_IMM_ID);

alter table AD_IMMSUPP
   add constraint AD_IMMSUPP_FK1_2 foreign key (AD_SUPP_ID)
      references AD_SUPP (AD_SUPP_ID);

alter table AD_IMMSURF
   add constraint AD_IMMSURF_FK1_1 foreign key (AD_IMM_ID)
      references AD_IMM (AD_IMM_ID);

alter table AD_IMMURB
   add constraint AD_IMMURB_FK1_1 foreign key (AD_IMM_ID)
      references AD_IMM (AD_IMM_ID);

alter table AD_IMMVACCES
   add constraint AD_IMMVACCES_FK1_1 foreign key (AD_IMM_ID)
      references AD_IMM (AD_IMM_ID);

alter table AD_LCL
   add constraint AD_LCL_FK1_1 foreign key (AD_IMMOCC_ID)
      references AD_IMMOCC (AD_IMMOCC_ID);

alter table AD_LCL
   add constraint AD_LCL_FK1_2 foreign key (AD_UA_ID)
      references AD_UA (AD_UA_ID);

alter table AD_LCL
   add constraint AD_LCL_FK1_3 foreign key (RF_LCLCLAUTIL_ID)
      references RF_LCLCLAUTIL (RF_LCLCLAUTIL_ID);

alter table AD_LCL
   add constraint AD_LCL_FK1_4 foreign key (AD_CPTBATI_ID)
      references AD_CPTBATI (AD_CPTBATI_ID);

alter table AD_LCL
   add constraint AD_LCL_FK1_5 foreign key (AD_CPTNIV_ID)
      references AD_CPTNIV (AD_CPTNIV_ID);

alter table AD_MAD
   add constraint AD_MAD_FK1_1 foreign key (AD_OPEDOM_ID)
      references AD_OPEDOM (AD_OPEDOM_ID);

alter table AD_MAD
   add constraint AD_MAD_FK1_2 foreign key (RF_TAMO_ID)
      references RF_TAMO (RF_TAMO_ID);

alter table AD_MAD
   add constraint AD_MAD_FK1_3 foreign key (RF_BENAMO_ID)
      references RF_BENAMO (RF_BENAMO_ID);

alter table AD_NBATIOCCPT
   add constraint AD_NBATIOCCPT_FK1_1 foreign key (AD_CPTNBATI_ID)
      references AD_CPTNBATI (AD_CPTNBATI_ID);

alter table AD_NBATIOCCPT
   add constraint AD_NBATIOCCPT_FK1_2 foreign key (AD_IMMOCC_ID)
      references AD_IMMOCC (AD_IMMOCC_ID);

alter table AD_NBATIOCCPT
   add constraint AD_NBATIOCCPT_FK1_3 foreign key (AD_UA_ID)
      references AD_UA (AD_UA_ID);

alter table AD_OPEDOM
   add constraint AD_OPEDOM_FK1_1 foreign key (RF_TDOCTOPEDOM_ID)
      references RF_TDOCTOPEDOM (RF_TDOCTOPEDOM_ID);

alter table AD_OPEDOM
   add constraint AD_OPEDOM_FK1_2 foreign key (AD_OPEDOM_MERE_ID)
      references AD_OPEDOM (AD_OPEDOM_ID);

alter table AD_OPEDOM
   add constraint AD_OPEDOM_FK1_3 foreign key (AD_DECMIN_ID)
      references AD_DECMIN (AD_DECMIN_ID);

alter table AD_OPEDOM
   add constraint AD_OPEDOM_FK1_4 foreign key (AD_SMAJ_ID)
      references AD_SMAJ (AD_SMAJ_ID);

alter table AD_OPEDOM
   add constraint AD_OPEDOM_FK1_5 foreign key (RF_ARE_ID)
      references RF_ARE (RF_ARE_ID);

alter table AD_RAL
   add constraint AD_RAL_FK1_1 foreign key (RF_MSORT_ID)
      references RF_MSORT (RF_MSORT_ID);

alter table AD_RAL
   add constraint AD_RAL_FK1_3 foreign key (AD_OPEDOM_ID)
      references AD_OPEDOM (AD_OPEDOM_ID);

alter table AD_REPGES
   add constraint AD_REPGES_FK1_1 foreign key (RF_ORGANISME_ID)
      references RF_ORGANISME (RF_ORGANISME_ID);

alter table AD_REPOCC
   add constraint AD_REPOCC_FK1_1 foreign key (RF_ARE_ID)
      references RF_ARE (RF_ARE_ID);

alter table AD_REPOCC
   add constraint AD_REPOCC_FK1_2 foreign key (RF_COMM_ID)
      references RF_COMM (RF_COMM_ID);

alter table AD_REPOCC
   add constraint AD_REPOCC_FK1_3 foreign key (AD_TOCCPROV_ID)
      references AD_TOCCPROV (AD_TOCCPROV_ID);

alter table AD_SAUPP
   add constraint AD_SAUPP_FK1_1 foreign key (RF_TSAUPP_ID)
      references RF_TSAUPP (RF_TSAUPP_ID);

alter table AD_SMAJ
   add constraint AD_SMAJ_FK1_1 foreign key (RF_ORGANISME_ID)
      references RF_ORGANISME (RF_ORGANISME_ID);

alter table AD_SMAJDOM
   add constraint AD_SMAJDOM_FK1_1 foreign key (AD_SMAJ_ID)
      references AD_SMAJ (AD_SMAJ_ID);

alter table AD_SMAJDOM
   add constraint AD_SMAJDOM_FK1_2 foreign key (AD_DOMAINE_ID)
      references AD_DOMAINE (AD_DOMAINE_ID);

alter table AD_SMAJSU
   add constraint AD_SMAJSU_FK1_1 foreign key (AD_SMAJ_ID)
      references AD_SMAJ (AD_SMAJ_ID);

alter table AD_SMAJSU
   add constraint AD_SMAJSU_FK1_2 foreign key (AD_USER_ID)
      references AD_USER (AD_USER_ID);

alter table AD_SNUP
   add constraint AD_SNUP_FK1_1 foreign key (RF_ORISNUP_ID)
      references RF_ORISNUP (RF_ORISNUP_ID);

alter table AD_SNUP
   add constraint AD_SNUP_FK1_2 foreign key (RF_TSNUP_ID)
      references RF_TSNUP (RF_TSNUP_ID);

alter table AD_SNUP
   add constraint AD_SNUP_FK1_3 foreign key (AD_SAUPP_ID)
      references AD_SAUPP (AD_SAUPP_ID);

alter table AD_SUIVI_HIS
   add constraint AD_SUIVI_HIS_FK1_1 foreign key (AD_DECMIN_ID)
      references AD_DECMIN (AD_DECMIN_ID);

alter table AD_SUPD
   add constraint AD_SUPD_FK1_1 foreign key (RF_TPROTECT_ID)
      references RF_TPROTECT (RF_TPROTECT_ID);

alter table AD_SUPD
   add constraint AD_SUPD_FK1_2 foreign key (AD_SAUPP_ID)
      references AD_SAUPP (AD_SAUPP_ID);

alter table AD_SUPD
   add constraint AD_SUPD_FK1_3 foreign key (RF_TSUP_ID)
      references RF_TSUP (RF_TSUP_ID);

alter table AD_SUPP
   add constraint AD_SUPP_FK1_1 foreign key (AD_REPGES_ID)
      references AD_REPGES (AD_REPGES_ID);

alter table AD_SUPP
   add constraint AD_SUPP_FK1_2 foreign key (RF_TSUP_ID)
      references RF_TSUP (RF_TSUP_ID);

alter table AD_SUPP
   add constraint AD_SUPP_FK1_3 foreign key (RF_ARE_ID)
      references RF_ARE (RF_ARE_ID);

alter table AD_SUPP
   add constraint AD_SUPP_FK1_4 foreign key (RF_NIVSUPP_ID)
      references RF_NIVSUPP (RF_NIVSUPP_ID);

alter table AD_SUPP
   add constraint AD_SUPP_FK1_5 foreign key (AD_SMAJ_ID)
      references AD_SMAJ (AD_SMAJ_ID);

alter table AD_TMP_ORGA4RENUM
   add constraint AD_TMP_ORGA4RENUM_FK1_1 foreign key (RF_ORGANISME_ID)
      references RF_ORGANISME (RF_ORGANISME_ID);

alter table AD_TOCCPROV
   add constraint AD_TOCCPROV_FK1_1 foreign key (AD_TOCC_ID)
      references AD_TOCC (AD_TOCC_ID);

alter table AD_TOCCPROV
   add constraint AD_TOCCPROV_FK1_2 foreign key (AD_OCCPROV_ID)
      references AD_OCCPROV (AD_OCCPROV_ID);

alter table AD_TRA
   add constraint AD_TRA_FK1_1 foreign key (AD_OPEDOM_ID)
      references AD_OPEDOM (AD_OPEDOM_ID);

alter table AD_TRA
   add constraint AD_TRA_FK1_2 foreign key (RF_AFFECT_ID)
      references RF_AFFECT (RF_AFFECT_ID);

alter table AD_TRA
   add constraint AD_TRA_FK1_3 foreign key (RF_TBENECH_ID)
      references RF_TBENECH (RF_TBENECH_ID);

alter table AD_TXTSUPP
   add constraint AD_TXTSUPP_FK1_1 foreign key (AD_SUPP_ID)
      references AD_SUPP (AD_SUPP_ID);

alter table AD_TXTSUPP
   add constraint AD_TXTSUPP_FK1_2 foreign key (RF_OBJTXT_ID)
      references RF_OBJTXT (RF_OBJTXT_ID);

alter table AD_UA
   add constraint AD_UA_FK1_1 foreign key (RF_TPRO_ID)
      references RF_TPRO (RF_TPRO_ID);

alter table AD_UA
   add constraint AD_UA_FK1_2 foreign key (RF_STATUA_ID)
      references RF_STATUA (RF_STATUA_ID);

alter table AD_UA
   add constraint AD_UA_FK1_3 foreign key (RF_ARE_ID)
      references RF_ARE (RF_ARE_ID);

alter table AD_UA
   add constraint AD_UA_FK1_4 foreign key (AD_UA_MERE_ID)
      references AD_UA (AD_UA_ID);

alter table AD_UA
   add constraint AD_UA_FK1_5 foreign key (AD_COMIMP_ID)
      references AD_COMIMP (AD_COMIMP_ID);

alter table AD_UA
   add constraint AD_UA_FK1_6 foreign key (RF_COMM_ID)
      references RF_COMM (RF_COMM_ID);

alter table AD_UACAD
   add constraint AD_UACAD_FK1_1 foreign key (AD_CAD_ID)
      references AD_CAD (AD_CAD_ID);

alter table AD_UACAD
   add constraint AD_UACAD_FK1_2 foreign key (AD_UA_ID)
      references AD_UA (AD_UA_ID);

alter table AD_UADRO
   add constraint AD_UADRO_FK1_1 foreign key (AD_UA_ID)
      references AD_UA (AD_UA_ID);

alter table AD_UADRO
   add constraint AD_UADRO_FK1_2 foreign key (RF_ORIDRO_ID)
      references RF_ORIDRO (RF_ORIDRO_ID);

alter table AD_UADRO
   add constraint AD_UADRO_FK1_3 foreign key (RF_NATDRO_ID)
      references RF_NATDRO (RF_NATDRO_ID);

alter table AD_UANATDECPRO
   add constraint AD_UANATDECPRO_FK1_1 foreign key (AD_UA_ID)
      references AD_UA (AD_UA_ID);

alter table AD_UANATDECPRO
   add constraint AD_UANATDECPRO_FK1_2 foreign key (RF_NATDECPRO_ID)
      references RF_NATDECPRO (RF_NATDECPRO_ID);

alter table AD_UASAUPP
   add constraint AD_UASAUPP_FK1_1 foreign key (AD_SAUPP_ID)
      references AD_SAUPP (AD_SAUPP_ID);

alter table AD_UASAUPP
   add constraint AD_UASAUPP_FK1_2 foreign key (AD_UA_ID)
      references AD_UA (AD_UA_ID);

alter table AD_UFRUIT
   add constraint AD_UFRUIT_FK1_1 foreign key (AD_OPEDOM_ID)
      references AD_OPEDOM (AD_OPEDOM_ID);

alter table AD_USER
   add constraint AD_USER_FK1_1 foreign key ()
      references MN_PERS;

alter table AD_USER
   add constraint AD_USER_FK1_2 foreign key (AD_ROLE_ID)
      references AD_ROLE (AD_ROLE_ID);

alter table AD_USER
   add constraint AD_USER_FK1_3 foreign key (AD_SMAJ_ID)
      references AD_SMAJ (AD_SMAJ_ID);

alter table AD_USER
   add constraint AD_USER_FK1_4 foreign key (AD_DOMAINE_ID)
      references AD_DOMAINE (AD_DOMAINE_ID);

alter table AD_VALRECONT
   add constraint AD_VALRECONT_FK1_1 foreign key (AD_METACHORUS_ID)
      references AD_METACHORUS (AD_METACHORUS_ID);

alter table AD_VALRECPT
   add constraint AD_VALRECPT_FK1_1 foreign key (AD_METACHORUS_ID)
      references AD_METACHORUS (AD_METACHORUS_ID);

alter table AD_VALREPARC
   add constraint AD_VALREPARC_FK1_1 foreign key (AD_METACHORUS_ID)
      references AD_METACHORUS (AD_METACHORUS_ID);

alter table AD_VALRESITE
   add constraint AD_VALRESITE_FK1_1 foreign key (AD_METACHORUS_ID)
      references AD_METACHORUS (AD_METACHORUS_ID);

alter table AD_VIEDM
   add constraint AD_VIEDM_FK1_1 foreign key (AD_DECMIN_ID)
      references AD_DECMIN (AD_DECMIN_ID);

alter table AD_VIEDM
   add constraint AD_VIEDM_FK1_2 foreign key (AD_NATDM_ID)
      references AD_NATDM (AD_NATDM_ID);

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

alter table RF_LCLCLAUTIL
   add constraint RF_LCLCLAUTIL_FK1_1 foreign key ()
      references REF2.RF_LCLCATUTIL;

/*==============================================================*/
/* Synonyme : AD_ACTIONCONT                                     */
/*==============================================================*/
create public synonym AD_ACTIONCONT for AD_ACTIONCONT;

/*==============================================================*/
/* Synonyme : AD_ACTIONCPT                                      */
/*==============================================================*/
create public synonym AD_ACTIONCPT for AD_ACTIONCPT;

/*==============================================================*/
/* Synonyme : AD_ACTIONPARC                                     */
/*==============================================================*/
create public synonym AD_ACTIONPARC for AD_ACTIONPARC;

/*==============================================================*/
/* Synonyme : AD_ACTIONSITE                                     */
/*==============================================================*/
create public synonym AD_ACTIONSITE for AD_ACTIONSITE;

/*==============================================================*/
/* Synonyme : AD_COMPTEURS                                      */
/*==============================================================*/
create public synonym AD_COMPTEURS for AD_COMPTEURS;

/*==============================================================*/
/* Synonyme : AD_EXCLUSUB                                       */
/*==============================================================*/
create public synonym AD_EXCLUSUB for AD_EXCLUSUB;

/*==============================================================*/
/* Synonyme : AD_JOURNRE                                        */
/*==============================================================*/
create public synonym AD_JOURNRE for AD_JOURNRE;

/*==============================================================*/
/* Synonyme : AD_METACHORUS                                     */
/*==============================================================*/
create public synonym AD_METACHORUS for AD_METACHORUS;

/*==============================================================*/
/* Synonyme : AD_VALRECONT                                      */
/*==============================================================*/
create public synonym AD_VALRECONT for AD_VALRECONT;

/*==============================================================*/
/* Synonyme : AD_VALRECPT                                       */
/*==============================================================*/
create public synonym AD_VALRECPT for AD_VALRECPT;

/*==============================================================*/
/* Synonyme : AD_VALREPARC                                      */
/*==============================================================*/
create public synonym AD_VALREPARC for AD_VALREPARC;

/*==============================================================*/
/* Synonyme : AD_VALRESITE                                      */
/*==============================================================*/
create public synonym AD_VALRESITE for AD_VALRESITE;

