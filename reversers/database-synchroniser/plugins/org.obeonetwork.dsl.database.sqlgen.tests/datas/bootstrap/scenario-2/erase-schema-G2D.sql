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


