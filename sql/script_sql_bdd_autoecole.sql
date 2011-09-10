DROP DATABASE IF EXISTS autoecole;

CREATE DATABASE IF NOT EXISTS autoecole;
USE autoecole;
# -----------------------------------------------------------------------------
#       TABLE : QUESTIONS_SYNTHESE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS QUESTIONS_SYNTHESE
 (
   id INTEGER NOT NULL  ,
   LIBELLE_QUESTION_SYNTHESE CHAR(255) NULL  
   , PRIMARY KEY (id) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : CHAMPS
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CHAMPS
 (
   id SMALLINT NOT NULL  ,
   LIBELLE_ETAT_CHAMPS CHAR(255) NULL  
   , PRIMARY KEY (id) 
 ) 
 comment = "";
 
# -----------------------------------------------------------------------------
#       TABLE : FORMATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS FORMATION
 (
   id INTEGER NOT NULL  ,
   LIBELLE_FORMATION CHAR(255) NULL  
   , PRIMARY KEY (id) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : MONITEUR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS MONITEUR
 (
   id INTEGER NOT NULL  ,
   NOM_MONITEUR CHAR(32) NULL  ,
   PRENOM_MONITEUR CHAR(32) NULL  
   , PRIMARY KEY (id) 
 ) 
 comment = "";
 
 
# -----------------------------------------------------------------------------
#       TABLE : ELEVE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ELEVE
 (
   id BIGINT(4) NOT NULL  ,
   idFORMATION INTEGER NOT NULL  ,
   idMONITEUR INTEGER NOT NULL  ,
   NOM_ELEVE CHAR(32) NULL  ,
   PRENOM_ELEVE CHAR(32) NULL  ,
   DATE_DE_NAISS_ELEVE DATE NULL  ,
   MAIL_ELEVE CHAR(255) NULL  ,
   ADRESSE_ELEVE CHAR(255) NULL  ,
   CODE_POSTAL_ELEVE INTEGER NULL  ,
   COMMUNE_ELEVE CHAR(32) NULL  ,
   TELEPHONE_ELEVE CHAR(32) NULL  ,
   PROFESSION_ELEVE CHAR(32) NULL  ,
   DATE_EVAL_ELEVE DATE NULL  ,
   RESULTAT_ELEVE_ORAL INTEGER NULL  ,
   VOLUME_HORAIRE_TH_ELEVE INTEGER NULL  ,
   VOLUME_HORAIRE_PRATIQUE_ELEVE INTEGER NULL  ,
   TEST_VU_ELEVE BOOL NULL  ,
   OBSERVATION_VUE_ELEVE CHAR(255) NULL  ,
   DATE_INSCRIPTION_ELEVE DATE NULL  ,
   DATE_ENREGISTREMENT_ELEVE DATE NULL  
   , PRIMARY KEY (id) 
 ) 
 comment = "";



 
 
# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE ELEVE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_ELEVE_FORMATION
     ON ELEVE (idFORMATION ASC);

CREATE  INDEX I_FK_ELEVE_MONITEUR
     ON ELEVE (idMONITEUR ASC);

# -----------------------------------------------------------------------------
#       TABLE : EVALUATION_CONTROLE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EVALUATION_CONTROLE
 (
   id SMALLINT NOT NULL  ,
   LIBELLE_EVALUATION_CONTROLE CHAR(255) NULL  
   , PRIMARY KEY (id) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : CATEGORIE_I_O
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CATEGORIE_I_O
 (
   id SMALLINT NOT NULL  ,
   LIBELLE_CATEGORIE CHAR(255) NULL  
   , PRIMARY KEY (id) 
 ) 
 comment = "";



# -----------------------------------------------------------------------------
#       TABLE : OBJECTIF
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS OBJECTIF
 (
   id BIGINT(4) NOT NULL  ,
   idCATEGORIE SMALLINT NULL  ,
   idETAPE INTEGER NOT NULL  ,
   LIBELLE_OBJECTIF CHAR(255) NULL  
   , PRIMARY KEY (id) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE OBJECTIF
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_OBJECTIF_CATEGORIE_I_O
     ON OBJECTIF (idCATEGORIE ASC);

CREATE  INDEX I_FK_OBJECTIF_ETAPE
     ON OBJECTIF (idETAPE ASC);

# -----------------------------------------------------------------------------
#       TABLE : SYNTHESE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SYNTHESE
 (
   id BIGINT(4) NOT NULL  ,
   idETAPE INTEGER NOT NULL  ,
   LIBELLE_SYNTHESE CHAR(32) NULL  
   , PRIMARY KEY (id) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE SYNTHESE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_SYNTHESE_ETAPE
     ON SYNTHESE (idETAPE ASC);

# -----------------------------------------------------------------------------
#       TABLE : ETAPE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ETAPE
 (
   id INTEGER NOT NULL  ,
   LIBELLE_ETAPE CHAR(255) NULL  
   , PRIMARY KEY (id) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : COMPTE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COMPTE
 (
   id INTEGER NOT NULL  ,
   id_COMPTE_UTILISATEUR BIGINT(4) NULL  ,
   MOT_DE_PASSE_UTILISATEUR CHAR(32) NULL  
   , PRIMARY KEY (id) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : SE_RAPPORTER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SE_RAPPORTER
 (
   idEVALUATION_CONTROLE SMALLINT NOT NULL  ,
   idETAPE INTEGER NOT NULL  
   , PRIMARY KEY (idEVALUATION_CONTROLE,idETAPE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE SE_RAPPORTER
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_SE_RAPPORTER_EVALUATION_CONTROLE
     ON SE_RAPPORTER (idEVALUATION_CONTROLE ASC);

CREATE  INDEX I_FK_SE_RAPPORTER_ETAPE
     ON SE_RAPPORTER (idETAPE ASC);

# -----------------------------------------------------------------------------
#       TABLE : REALISER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS REALISER
 (
   idELEVE BIGINT(4) NOT NULL  ,
   idOBJECTIF BIGINT(4) NOT NULL  ,
   DATE_REALISATION_OBJECTIF DATE NULL  ,
   OBSERVATION_OBJECTIF CHAR(255) NULL  ,
   ETAT_OBJECTIF SMALLINT NULL  
   , PRIMARY KEY (idELEVE,idOBJECTIF) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE REALISER
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_REALISER_ELEVE
     ON REALISER (idELEVE ASC);

CREATE  INDEX I_FK_REALISER_OBJECTIF
     ON REALISER (idOBJECTIF ASC);

# -----------------------------------------------------------------------------
#       TABLE : SUPERVISER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SUPERVISER
 (
   idMONITEUR INTEGER NOT NULL  ,
   idEVALUATION_CONTROLE SMALLINT NOT NULL  ,
   DATE_PASSAGE DATE NULL  ,
   RESULTAT_PASSAGE BOOL NULL  
   , PRIMARY KEY (idMONITEUR,idEVALUATION_CONTROLE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE SUPERVISER
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_SUPERVISER_MONITEUR
     ON SUPERVISER (idMONITEUR ASC);

CREATE  INDEX I_FK_SUPERVISER_EVALUATION_CONTROLE
     ON SUPERVISER (idEVALUATION_CONTROLE ASC);

# -----------------------------------------------------------------------------
#       TABLE : ASSURER_LECON
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ASSURER_LECON
 (
   idELEVE BIGINT(4) NOT NULL  ,
   idMONITEUR INTEGER NOT NULL  ,
   NUM_LECON INTEGER NULL  ,
   DATE_LECON DATE NULL  ,
   HEURE_LECON INTEGER NULL  ,
   DUREE_LECON INTEGER NULL  ,
   OBSERVATION_LECON CHAR(255) NULL  
   , PRIMARY KEY (idELEVE,idMONITEUR) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE ASSURER_LECON
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_ASSURER_LECON_ELEVE
     ON ASSURER_LECON (idELEVE ASC);

CREATE  INDEX I_FK_ASSURER_LECON_MONITEUR
     ON ASSURER_LECON (idMONITEUR ASC);

# -----------------------------------------------------------------------------
#       TABLE : REPONSE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS REPONSE
 (
   idQUESTIONS_SYNTHESE INTEGER NOT NULL  ,
   idETAT_CHAMPS SMALLINT NOT NULL  ,
   idSYNTHESE BIGINT(4) NOT NULL  ,
   idELEVE BIGINT(4) NOT NULL  ,
   ETAT_REPONSE BOOL NULL  
   , PRIMARY KEY (idQUESTIONS_SYNTHESE,idETAT_CHAMPS,idSYNTHESE,idELEVE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE REPONSE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_REPONSE_QUESTIONS_SYNTHESE
     ON REPONSE (idQUESTIONS_SYNTHESE ASC);

CREATE  INDEX I_FK_REPONSE_CHAMPS
     ON REPONSE (idETAT_CHAMPS ASC);

CREATE  INDEX I_FK_REPONSE_SYNTHESE
     ON REPONSE (idSYNTHESE ASC);

CREATE  INDEX I_FK_REPONSE_ELEVE
     ON REPONSE (idELEVE ASC);

# -----------------------------------------------------------------------------
#       TABLE : CONTENIR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CONTENIR
 (
   idFORMATION INTEGER NOT NULL  ,
   idETAPE INTEGER NOT NULL  
   , PRIMARY KEY (idFORMATION,idETAPE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE CONTENIR
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_CONTENIR_FORMATION
     ON CONTENIR (idFORMATION ASC);

CREATE  INDEX I_FK_CONTENIR_ETAPE
     ON CONTENIR (idETAPE ASC);

# -----------------------------------------------------------------------------
#       TABLE : PASSER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PASSER
 (
   idELEVE BIGINT(4) NOT NULL  ,
   idSYNTHESE BIGINT(4) NOT NULL  ,
   DATE_PASSAGE_SYNTHESE DATE NULL  ,
   NB_H_TH INTEGER NULL  ,
   NB_H_PRATIQUE INTEGER NULL  ,
   RESULTAT INTEGER NULL  
   , PRIMARY KEY (idELEVE,idSYNTHESE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE PASSER
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_PASSER_ELEVE
     ON PASSER (idELEVE ASC);

CREATE  INDEX I_FK_PASSER_SYNTHESE
     ON PASSER (idSYNTHESE ASC);

# -----------------------------------------------------------------------------
#       TABLE : FRANCHIR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS FRANCHIR
 (
   idELEVE BIGINT(4) NOT NULL  ,
   idETAPE INTEGER NOT NULL  ,
   DATE_FRANCHISSEMENT_ETAPE DATE NULL  
   , PRIMARY KEY (idELEVE,idETAPE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE FRANCHIR
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_FRANCHIR_ELEVE
     ON FRANCHIR (idELEVE ASC);

CREATE  INDEX I_FK_FRANCHIR_ETAPE
     ON FRANCHIR (idETAPE ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE ELEVE 
  ADD FOREIGN KEY FK_ELEVE_FORMATION (idFORMATION)
      REFERENCES FORMATION (id) ;


ALTER TABLE ELEVE 
  ADD FOREIGN KEY FK_ELEVE_MONITEUR (idMONITEUR)
      REFERENCES MONITEUR (id) ;


ALTER TABLE OBJECTIF 
  ADD FOREIGN KEY FK_OBJECTIF_CATEGORIE_I_O (idCATEGORIE)
      REFERENCES CATEGORIE_I_O (id) ;


ALTER TABLE OBJECTIF 
  ADD FOREIGN KEY FK_OBJECTIF_ETAPE (idETAPE)
      REFERENCES ETAPE (id) ;


ALTER TABLE SYNTHESE 
  ADD FOREIGN KEY FK_SYNTHESE_ETAPE (idETAPE)
      REFERENCES ETAPE (id) ;


ALTER TABLE SE_RAPPORTER 
  ADD FOREIGN KEY FK_SE_RAPPORTER_EVALUATION_CONTROLE (idEVALUATION_CONTROLE)
      REFERENCES EVALUATION_CONTROLE (id) ;


ALTER TABLE SE_RAPPORTER 
  ADD FOREIGN KEY FK_SE_RAPPORTER_ETAPE (idETAPE)
      REFERENCES ETAPE (id) ;


ALTER TABLE REALISER 
  ADD FOREIGN KEY FK_REALISER_ELEVE (idELEVE)
      REFERENCES ELEVE (id) ;


ALTER TABLE REALISER 
  ADD FOREIGN KEY FK_REALISER_OBJECTIF (idOBJECTIF)
      REFERENCES OBJECTIF (id) ;


ALTER TABLE SUPERVISER 
  ADD FOREIGN KEY FK_SUPERVISER_MONITEUR (idMONITEUR)
      REFERENCES MONITEUR (id) ;


ALTER TABLE SUPERVISER 
  ADD FOREIGN KEY FK_SUPERVISER_EVALUATION_CONTROLE (idEVALUATION_CONTROLE)
      REFERENCES EVALUATION_CONTROLE (id) ;


ALTER TABLE ASSURER_LECON 
  ADD FOREIGN KEY FK_ASSURER_LECON_ELEVE (idELEVE)
      REFERENCES ELEVE (id) ;


ALTER TABLE ASSURER_LECON 
  ADD FOREIGN KEY FK_ASSURER_LECON_MONITEUR (idMONITEUR)
      REFERENCES MONITEUR (id) ;


ALTER TABLE REPONSE 
  ADD FOREIGN KEY FK_REPONSE_QUESTIONS_SYNTHESE (idQUESTIONS_SYNTHESE)
      REFERENCES QUESTIONS_SYNTHESE (id) ;


ALTER TABLE REPONSE 
  ADD FOREIGN KEY FK_REPONSE_CHAMPS (idETAT_CHAMPS)
      REFERENCES CHAMPS (id) ;


ALTER TABLE REPONSE 
  ADD FOREIGN KEY FK_REPONSE_SYNTHESE (idSYNTHESE)
      REFERENCES SYNTHESE (id) ;


ALTER TABLE REPONSE 
  ADD FOREIGN KEY FK_REPONSE_ELEVE (idELEVE)
      REFERENCES ELEVE (id) ;


ALTER TABLE CONTENIR 
  ADD FOREIGN KEY FK_CONTENIR_FORMATION (idFORMATION)
      REFERENCES FORMATION (id) ;


ALTER TABLE CONTENIR 
  ADD FOREIGN KEY FK_CONTENIR_ETAPE (idETAPE)
      REFERENCES ETAPE (id) ;


ALTER TABLE PASSER 
  ADD FOREIGN KEY FK_PASSER_ELEVE (idELEVE)
      REFERENCES ELEVE (id) ;


ALTER TABLE PASSER 
  ADD FOREIGN KEY FK_PASSER_SYNTHESE (idSYNTHESE)
      REFERENCES SYNTHESE (id) ;


ALTER TABLE FRANCHIR 
  ADD FOREIGN KEY FK_FRANCHIR_ELEVE (idELEVE)
      REFERENCES ELEVE (id) ;


ALTER TABLE FRANCHIR 
  ADD FOREIGN KEY FK_FRANCHIR_ETAPE (idETAPE)
      REFERENCES ETAPE (id) ;

