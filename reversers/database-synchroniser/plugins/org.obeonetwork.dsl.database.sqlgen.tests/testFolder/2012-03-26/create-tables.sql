-- ==============================================================
--  Table : AD_ACQ                                    
-- ==============================================================
DROP PUBLIC SYNONYM AD_ACQ;
DROP SEQUENCE G2D.SEQ_AD_ACQ;
CREATE TABLE AD_ACQ(
    AD_ACQ_ID NUMBER(22,0) NOT NULL,
    AD_OPEDOM_ID NUMBER(22,0) NOT NULL,
    AD_ACQ_VENDEUR VARCHAR2(75) NOT NULL,
    AD_ACQ_REFPUBHYPO VARCHAR2(50) NULL,
    AD_ACQ_DTPUBHYPO VARCHAR2(15) NULL,
    AD_XDMAJ VARCHAR2(15) NOT NULL,
    AD_XTOPSUP VARCHAR2(1) default ''0'' NOT NULL
)
storage
(
    initial 10K
    next 10K
    minextents 1
    maxextents unlimited
    pctincrease 50
    freelists 1
    freelist groups 1
    optimal NULL
    buffer_pool default
)
tablespace TS_DATA_G2D;

CREATE PUBLIC SYNONYM AD_ACQ FOR G2D.AD_ACQ;

CREATE SEQUENCE G2D.SEQ_AD_ACQ INCREMENT BY 1 START WITH 1000;

