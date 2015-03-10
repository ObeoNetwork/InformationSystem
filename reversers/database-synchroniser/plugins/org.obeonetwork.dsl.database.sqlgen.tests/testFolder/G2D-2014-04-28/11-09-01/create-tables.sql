-- ==============================================================
--  Table : AD_ACQ                                    
-- ==============================================================
DROP PUBLIC SYNONYM AD_ACQ;

DROP TABLE AD_ACQ;
CREATE TABLE AD_ACQ(
    AD_ACQ_ID NUMBER(22,) NOT NULL,
    AD_OPEDOM_ID NUMBER(22,) NOT NULL,
    AD_ACQ_VENDEUR VARCHAR2(75) NOT NULL,
    AD_ACQ_REFPUBHYPO VARCHAR2(50) NULL,
    AD_ACQ_DTPUBHYPO VARCHAR2(15) NULL,
    AD_XDMAJ VARCHAR2(15) NOT NULL,
    AD_XTOPSUP VARCHAR2(1) default '0' NOT NULL
)
;

CREATE PUBLIC SYNONYM AD_ACQ FOR G2D.AD_ACQ;

