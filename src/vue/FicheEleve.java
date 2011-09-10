package vue;
import javax.swing.*;
import javax.swing.table.*;

import controleur.EcouteurFicheEleve;

import net.ko.kobject.KListObject;

import KClass.KEleve;
import KClass.KMoniteur;



import modele.DataFicheEleve;
import modele.DataFicheEleve1;
import modele.DataMoniteur;
import modele.RDVMoniteurEleve;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FicheEleve extends JPanel {

	
	
		private DataFicheEleve1 dataFiche1 = new DataFicheEleve1();
		private int idEleve;
		
	    private JPanel containerSous1 = new JPanel();
	    private JPanel containerSous2 = new JPanel();
	    private JPanel containerEvaluaD = new JPanel();
	    private JPanel containerIdEleve = new JPanel();
	    private JPanel containerIdEleveS1 = new JPanel();
	    private JPanel containerIdEleveS2 = new JPanel();
	    private JPanel containerDate = new JPanel();
	    private JPanel containerTestVue = new JPanel();
	    private JPanel containerNumLivret = new JPanel();
	    private JPanel containerResponsable = new JPanel();
	    private JPanel containerTabForma = new JPanel();
	    
	    private JLabel texteTitre = new JLabel();
	    
	    private JTextField nom = new JTextField();
	    private JTextField prenom = new JTextField();
	    private JTextField adresse = new JTextField();
	    private JTextField codePostal = new JTextField();
	    private JTextField communeEleve = new JTextField();
	    private JTextField telephone = new JTextField();
	    private JTextField eMail = new JTextField();
	    private JTextField profession = new JTextField();
		private JTextField numLivret = new JTextField();
		private JComboBox dateNaissJ; 
		private JComboBox dateNaissM; 
		private JComboBox dateNaissA;
		private JComboBox dateEvaJ; 
		private JComboBox dateEvaM; 
		private JComboBox dateEvaA;
		private JComboBox resultatEva = new JComboBox();
		private JComboBox formaTheo = new JComboBox();
		private JComboBox formaPra = new JComboBox();
		private JComboBox dateInscriJ; 
		private JComboBox dateInscriM; 
		private JComboBox dateInscriA;
		private JComboBox dateEnregiJ; 
		private JComboBox dateEnregiM; 
		private JComboBox dateEnregiA;
		private JComboBox responsableForma = new JComboBox();
		private JComboBox formateur;
		private JLabel labelPhoto;
		 private Icon icon = null;
		private String chemin = new String();
		private JRadioButton testVueO = new JRadioButton("Oui");
        private JRadioButton testVueN = new JRadioButton("Non");
        private ButtonGroup groupTestVue = new ButtonGroup();
        private JTextArea areaTestVue = new JTextArea();
        private JScrollPane scrollTestVue = new JScrollPane(areaTestVue);
        
		private DataMoniteur moniteur = new DataMoniteur();
		private String[]ListeMoniteur  ;
		
		private JTable tableau;
        private ArrayList<String> comboData ;
        private ArrayList<String> listeFormation[] = new ArrayList[6];
        private TableModel2 zModel ;
        private String  titleTableauJtable[] = {"Leçon","Date", "Horaire", "Duree", "Moniteur", "Observation"};
        
        private JButton boutonAjouter = new JButton("Ajouter");//bouton de l'onglet contenant la Jtable.
		
        private RDVMoniteurEleve rdv;
       
      
        public FicheEleve(){
        	ListeMoniteur = new String[moniteur.recupererListe().count()];
        	recupererListeMoniteur();
        	initElementGraphique();
			
            this.setVisible(true);
    	}
        
        public void initElementGraphique() {
        	this.setPreferredSize(new Dimension(900,670));
			
			texteTitre = new JLabel("Fiche de suivi PERMIS B");
			texteTitre.setFont(new Font(null,Font.BOLD,20));
			
			containerEvaluaD.setBorder(BorderFactory.createTitledBorder(""));
			containerIdEleve.setBorder(BorderFactory.createTitledBorder(""));
			
			this.parametrerJPanel(containerEvaluaD, 250, 200, Color.white);
			this.parametrerJPanel(containerIdEleve, 600, 320, Color.white);
			this.parametrerJPanel(containerDate, 250, 130, Color.white);
			this.parametrerJPanel(containerTestVue, 400, 130, Color.white);
			this.parametrerJPanel(containerNumLivret, 460, 60, Color.white);
			this.parametrerJPanel(containerResponsable, 460, 80, Color.white);
			this.parametrerJPanel(containerTabForma, 898, 450, Color.white);
			this.parametrerJPanel(containerSous1, 250, 330, Color.white);
			this.parametrerJPanel(containerSous2, 460, 140, Color.white);
			this.parametrerJPanel(containerIdEleveS1, 380, 289, Color.white);
			this.parametrerJPanel(containerIdEleveS2, 200, 289, Color.white);
			
			texteTitre.setPreferredSize(new Dimension(800,50));
			

			JTabbedPane onglet = new JTabbedPane();
			JPanel partie1 = new JPanel();
			JPanel partie2 = new JPanel();
			this.parametrerJPanel(partie1, 880, 590, Color.white);
			this.parametrerJPanel(partie2, 880, 470, Color.white);
			partie1.add(texteTitre);
			partie1.add(containerSous1);
			partie1.add(containerIdEleve);
			partie1.add(containerTestVue);
			partie1.add(containerSous2);
			partie2.add(containerTabForma);
			
			onglet.add(partie1, "Donnees Personnelles");
			onglet.add(partie2, "Tableau des leçons");
			this.add(onglet);
			
			containerSous1.add(containerEvaluaD);
			containerSous1.add(containerDate);

			containerSous2.add(containerNumLivret);
			containerSous2.add(containerResponsable);
			
			Font f = new Font(null,Font.BOLD,13);
			
			JLabel labelNom = new JLabel("Nom : ");
			this.parametrerJLabelEtJTextField(labelNom, f, nom, 300, 20);
			JLabel labelPrenom = new JLabel("Prenom :");
			this.parametrerJLabelEtJTextField(labelPrenom, f, prenom, 280, 20);			
			
			JLabel labelDateNaiss = new JLabel("Date de naissance :");
			labelDateNaiss.setFont(f);
			labelDateNaiss.setPreferredSize(new Dimension(150, 20));
			dateNaissJ = new JComboBox();
			dateNaissM = new JComboBox();
			dateNaissA = new JComboBox();
			parametrerJComboBoxDate(dateNaissJ, dateNaissM, dateNaissA);			
			
			JLabel labelEMail = new JLabel("E-Mail :");
			this.parametrerJLabelEtJTextField(labelEMail, f, eMail, 290, 20);
			
			JLabel labelTelephoneM = new JLabel("Numero de Telephone :");
			this.parametrerJLabelEtJTextField(labelTelephoneM, f, telephone, 180, 20);
			
			JLabel labelAdresse = new JLabel("Adresse :");
			this.parametrerJLabelEtJTextField(labelAdresse, f, adresse, 283, 20);
			
			JLabel labelCodePostal = new JLabel("Code Postal :");
			this.parametrerJLabelEtJTextField(labelCodePostal, f, codePostal, 40, 20);
			
			JLabel labelCommune = new JLabel("Commune :");
			this.parametrerJLabelEtJTextField(labelCommune, f, communeEleve, 135, 20);
			
			JLabel labelProfession = new JLabel("Profession :");
			this.parametrerJLabelEtJTextField(labelProfession, f, profession, 268, 20);
			
			containerIdEleve.add(containerIdEleveS1);
			containerIdEleve.add(containerIdEleveS2);
			
			containerIdEleveS1.setLayout(new FlowLayout(1, 5, 15));
			
			containerIdEleveS1.add(labelNom);
			containerIdEleveS1.add(nom);
			containerIdEleveS1.add(labelPrenom);
			containerIdEleveS1.add(prenom);
			containerIdEleveS1.add(labelDateNaiss);
			containerIdEleveS1.add(dateNaissJ);
			containerIdEleveS1.add(dateNaissM);
			containerIdEleveS1.add(dateNaissA);
			containerIdEleveS1.add(labelEMail);
			containerIdEleveS1.add(eMail);
			containerIdEleveS1.add(labelTelephoneM);
			containerIdEleveS1.add(telephone);
			containerIdEleveS1.add(labelAdresse);
			containerIdEleveS1.add(adresse);
			containerIdEleveS1.add(labelCodePostal);
			containerIdEleveS1.add(codePostal);
			containerIdEleveS1.add(labelCommune);
			containerIdEleveS1.add(communeEleve);
			containerIdEleveS1.add(labelProfession);
			containerIdEleveS1.add(profession);
			
			labelPhoto = new JLabel("");
			
			
			
			labelPhoto.setBorder(BorderFactory.createTitledBorder(""));
			labelPhoto.setPreferredSize(new Dimension(140, 180));
			
			
			JButton parcourir = new JButton("Parcourir");
			//parcourir.setEnabled(false);// grise le bouton
			parcourir.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {				
					JFileChooser chooser = new JFileChooser();
					JFrame test= new JFrame();
			        int returnVal = chooser.showOpenDialog(test);
			        if(returnVal == JFileChooser.APPROVE_OPTION) {
			           System.out.println(chooser.getSelectedFile().getPath());
			           chemin = chooser.getSelectedFile().getPath();
			           Icon icon = new ImageIcon(chemin);
				       labelPhoto.setIcon(icon);
				       System.out.println(chemin);
				       
			        }
				}			
			});
			
			containerIdEleveS2.add(labelPhoto);
			containerIdEleveS2.add(parcourir);
			
			JLabel labelTitreEvalua = new JLabel("Evaluation de depart");
			labelTitreEvalua.setFont(f);
			labelTitreEvalua.setPreferredSize(new Dimension(210, 40));
			
			Date date = new Date();
			SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy");
			
			JLabel labelDate = new JLabel("Date :");
			dateEvaJ = new JComboBox();
			dateEvaM = new JComboBox();
			dateEvaA = new JComboBox();
			parametrerJComboBoxDate(dateEvaJ, dateEvaM, dateEvaA);
			
			JLabel labelResultat = new JLabel("Resultat :");
			labelResultat.setFont(f);
			resultatEva = new JComboBox();
			for(int i=0; i<=30; i++) {
				resultatEva.addItem(i);
			}
			
			JLabel labelVoluF= new JLabel("Volume de formation prevu :");
			labelVoluF.setFont(f);
			labelVoluF.setPreferredSize(new Dimension(210, 20));
			
			JLabel labelFormaTheo = new JLabel("Theorique :");
			labelFormaTheo.setFont(f);
			formaTheo = new JComboBox();
			for(int i=0; i<=50; i++) {
				formaTheo.addItem(i);
			}
			labelFormaTheo.setPreferredSize(new Dimension(100, 20));
			
			JLabel labelFormaPra = new JLabel("Pratique :");
			labelFormaPra.setFont(f);
			formaPra = new JComboBox();
			for(int i=0; i<=50; i++) {
				formaPra.addItem(i);
			}
			labelFormaPra.setPreferredSize(new Dimension(100, 20));
						
			containerEvaluaD.add(labelTitreEvalua);
			containerEvaluaD.add(labelDate);
			containerEvaluaD.add(dateEvaJ);
			containerEvaluaD.add(dateEvaM);
			containerEvaluaD.add(dateEvaA);
			containerEvaluaD.add(labelResultat);
			containerEvaluaD.add(resultatEva);
			containerEvaluaD.add(labelVoluF);
			containerEvaluaD.add(labelFormaTheo);
			containerEvaluaD.add(formaTheo);
			containerEvaluaD.add(labelFormaPra);
			containerEvaluaD.add(formaPra);
			
			
			JLabel labelInscription = new JLabel("Inscription");
			labelInscription.setFont(f);
			labelInscription.setPreferredSize(new Dimension(200, 20));
			dateInscriJ = new JComboBox();
			dateInscriM = new JComboBox();
			dateInscriA = new JComboBox();
			parametrerJComboBoxDate(dateInscriJ, dateInscriM, dateInscriA);
			
			JLabel labelEnregistrement = new JLabel("Enregistrement");
			labelEnregistrement.setFont(f);
			labelEnregistrement.setPreferredSize(new Dimension(200, 20));
			dateEnregiJ = new JComboBox();
			dateEnregiM = new JComboBox();
			dateEnregiA = new JComboBox();
			parametrerJComboBoxDate(dateEnregiJ, dateEnregiM, dateEnregiA);
			
			containerDate.add(labelInscription);
			containerDate.add(dateInscriJ);
			containerDate.add(dateInscriM);
			containerDate.add(dateInscriA);
			containerDate.add(labelEnregistrement);
			containerDate.add(dateEnregiJ);
			containerDate.add(dateEnregiM);
			containerDate.add(dateEnregiA);
			
			JLabel labelTestVue = new JLabel("Test de la vue :");
			labelTestVue.setFont(f);
			
			scrollTestVue.setPreferredSize(new Dimension(380, 90));
			
			testVueO.addActionListener(new StateListener());
	        testVueN.addActionListener(new StateListener());
	        testVueN.setSelected(true);
	        testVueO.setBackground(Color.white);
	        testVueN.setBackground(Color.white);
	        
	        groupTestVue.add(testVueO);
	        groupTestVue.add(testVueN);
			
			containerTestVue.add(labelTestVue);
			containerTestVue.add(testVueO);
			containerTestVue.add(testVueN);
			containerTestVue.add(scrollTestVue);
			
			JLabel labelNumLivret = new JLabel("Livret d'apprentissage ne N.E.P.H");
			this.parametrerJLabelEtJTextField(labelNumLivret, f, numLivret, 250, 20);
			
			containerNumLivret.add(labelNumLivret);
			containerNumLivret.add(numLivret);
			
			JLabel labelResponsableForma = new JLabel("Responsable de la formation :");
			labelResponsableForma.setFont(f);
			labelResponsableForma.setPreferredSize(new Dimension(200, 20));
			responsableForma.addItem("JOLLY Didier");
			responsableForma.setPreferredSize(new Dimension(200, 20));
			
			JLabel labelFormateur = new JLabel("Formateur :");
			labelFormateur.setFont(f);
			labelFormateur.setPreferredSize(new Dimension(200, 20));
			formateur.setPreferredSize(new Dimension(200, 20));
			
			containerResponsable.add(labelResponsableForma);
			containerResponsable.add(responsableForma);
			containerResponsable.add(labelFormateur);
			containerResponsable.add(formateur);
			
			JLabel labelFormaPratique = new JLabel("Formation Pratique");
			labelFormaPratique.setFont(new Font(null,Font.BOLD,20));
			labelFormaPratique.setPreferredSize(new Dimension(780, 40));

			containerTabForma.add(labelFormaPratique );
			
			
			
			JPanel containerAjouter = new JPanel();
			containerAjouter.setPreferredSize(new Dimension(400,40));
			containerAjouter.setBackground(Color.white);
			boutonAjouter.setPreferredSize(new Dimension(80,20));
			EcouteurFicheEleve ecouteur = new EcouteurFicheEleve(this);
			boutonAjouter.addActionListener(ecouteur);
			containerAjouter.add(boutonAjouter);
			partie2.add(containerAjouter);
			
			dateNaissJ.setBackground(Color.white);
			dateNaissM.setBackground(Color.white);
			dateNaissA.setBackground(Color.white);
			dateEvaJ.setBackground(Color.white);
			dateEvaM.setBackground(Color.white);
			dateEvaA.setBackground(Color.white);
			dateInscriJ.setBackground(Color.white);
			dateInscriM.setBackground(Color.white);
			dateInscriA.setBackground(Color.white);
			dateEnregiJ.setBackground(Color.white);
			dateEnregiM.setBackground(Color.white);
			dateEnregiA.setBackground(Color.white);
			responsableForma.setBackground(Color.white);
			formateur.setBackground(Color.white);
			resultatEva.setBackground(Color.white);
			formaTheo.setBackground(Color.white);
			formaPra.setBackground(Color.white);
        }
        
        public void creationJtable(){
        	//tableau de liste.
        	//declaration des colonnes.
        	for (int i = 0; i < listeFormation.length; i++){
				listeFormation[i] = new ArrayList<String>();
			}
        	
        	ajouterLigneJtable();
        	zModel = new TableModel2(listeFormation,  titleTableauJtable);
        	
			tableau = new JTable();
			tableau.setModel(zModel);
	
			definirJtableGraphique();
			JScrollPane scrollTableau = new JScrollPane(tableau);
			scrollTableau.setPreferredSize(new Dimension(800, 400));
			containerTabForma.add(scrollTableau);
      
        }
        
        public void definirJtableGraphique(){
        	for (int i = 0; i<tableau.getColumnCount(); i++){
        		
        		switch(i){
        		case 0 : tableau.getColumnModel().getColumn(i).setMaxWidth(50);break;
        		case 5 : tableau.getColumnModel().getColumn(i).setMaxWidth(350);
        				 tableau.getColumnModel().getColumn(i).setCellEditor(new CellEditorAera());
        				 tableau.getColumnModel().getColumn(i).setCellRenderer(new CellRenderAera());break;
        		default :tableau.getColumnModel().getColumn(i).setMaxWidth(100);break;		 
        		}
        		
        	}
        	
        	
			
			for(int i = 0; i < tableau.getRowCount(); i++){
				tableau.setRowHeight(i, 17);
			}
			tableau.getTableHeader().setReorderingAllowed(false);
			tableau.getTableHeader().setResizingAllowed(false);
			//tableau.setBackground(new Color(2));
			
			
			
        }

        public void ajouterLigneJtable() {
        	for (int i = 0; i < listeFormation.length; i++){
	        	
        		switch (i){
        		
        		case 0 :for(int j = 0; j<rdv.getListeAssurerLecon().count();j++){
    						listeFormation[i].add(""+rdv.getListeAssurerLecon().get(j).getNUM_LECON());
    					}break;	
        		case 1 :for(int j = 0; j<rdv.getListeAssurerLecon().count();j++){
	        				listeFormation[i].add(""+rdv.getListeAssurerLecon().get(j).getDATE_LECON());
	        			}break;
        		case 2 :for(int j = 0; j<rdv.getListeAssurerLecon().count();j++){
    						listeFormation[i].add(""+rdv.getListeAssurerLecon().get(j).getHEURE_LECON());
    					}break;
        		case 3 :for(int j = 0; j<rdv.getListeAssurerLecon().count();j++){
    						listeFormation[i].add(""+rdv.getListeAssurerLecon().get(j).getDUREE_LECON());
    					}break;
        		case 4 :for(int j = 0; j<rdv.getListeAssurerLecon().count();j++){
    						listeFormation[i].add(""+rdv.getListeAssurerLecon().get(j).getIdMONITEUR());
    					}break;
        		case 5 :for(int j = 0; j<rdv.getListeAssurerLecon().count();j++){
    						listeFormation[i].add(""+rdv.getListeAssurerLecon().get(j).getOBSERVATION_LECON());
    					}break;
        		}
        		
        	}
        }
        
		public void ajouterLigneJtableVierge() {
			int numero = listeFormation[0].size()+1;
        	for (int i = 0; i < listeFormation.length; i++){
	        	if(i==0){listeFormation[i].add(""+numero);}
	        	else{listeFormation[i].add("");}
        	}	
        	
			//une liste représente une colonne. ICi 6 colonnes donc on met les des champs vides.
        }
        
        
		public void recupererListeMoniteur() {
			for (int i =0; i<ListeMoniteur.length; i++){
        			ListeMoniteur[i] = "";
        	}
        	KListObject<KMoniteur>KListe = new KListObject<KMoniteur>(KMoniteur.class);
        	KListe = moniteur.recupererListe();
        	for (int i =0; i<KListe.count(); i++){
        		ListeMoniteur[i] = KListe.get(i).getPRENOM_MONITEUR().toLowerCase()+" "+KListe.get(i).getNOM_MONITEUR().toUpperCase();
        	}
        	
        	
        	formateur =   new JComboBox(ListeMoniteur);
		}

		public void chargerDonnees(int id){
        	KEleve Eleve = new KEleve();
        	Eleve = dataFiche1.recupererProfil(id);
        	System.out.println(Eleve);
        	
        	nom.setText(Eleve.getNOM_ELEVE());
        	prenom.setText(Eleve.getPRENOM_ELEVE());
        	adresse.setText(Eleve.getADRESSE_ELEVE());
        	codePostal.setText(""+Eleve.getCODE_POSTAL_ELEVE());
    		communeEleve.setText(Eleve.getCOMMUNE_ELEVE()); 
    		telephone.setText(""+Eleve.getTELEPHONE_ELEVE());
    		eMail.setText(Eleve.getMAIL_ELEVE());
    		profession.setText(Eleve.getPROFESSION_ELEVE());
    		resultatEva.setSelectedIndex(recupererIndexHeures(0, Eleve.getRESULTAT_ELEVE_ORAL()));
    		formaTheo.setSelectedIndex(recupererIndexHeures(0, Eleve.getVOLUME_HORAIRE_TH_ELEVE()));
    		formaPra.setSelectedIndex(recupererIndexHeures(0, Eleve.getVOLUME_HORAIRE_PRATIQUE_ELEVE()));
    		numLivret.setText("A INCLURE");
    		responsableForma.setSelectedIndex(0);
    		
    		// Besoin de récupérer le nom du moniteur à partir de la clé etrangere sur l'eleve.
    		KMoniteur monit = new KMoniteur();
    		DataMoniteur DataMoniteur = new DataMoniteur();
    		monit = DataMoniteur.recupererProfilMoniteur(Eleve.getIdMONITEUR());
    		formateur.setSelectedIndex((Integer) monit.getId()-1);
    		
    		//chargement des dates.
    		Date date = new Date();
    		date = Eleve.getDATE_DE_NAISS_ELEVE();
    		//System.out.println(date);
    		SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy");
    		/*System.out.println("Date : "+dateStandard.format(date).substring(0,2));
    		System.out.println("Date : "+dateStandard.format(date).substring(3,5));
			System.out.println("Date : "+dateStandard.format(date).substring(6,10));
			*/
    		System.out.println(date);
    		dateNaissA.setSelectedIndex(recupererIndexHeures(1900, Integer.parseInt(dateStandard.format(date).substring(6,10))));
    		dateNaissM.setSelectedIndex(recupererIndexHeures(1, Integer.parseInt(dateStandard.format(date).substring(3,5))));
    		dateNaissJ.setSelectedIndex(recupererIndexHeures(1, Integer.parseInt(dateStandard.format(date).substring(0,2))));
    		
    		date = Eleve.getDATE_EVAL_ELEVE();
    		System.out.println(date);
    		dateEvaJ.setSelectedIndex(recupererIndexHeures(1, Integer.parseInt(dateStandard.format(date).substring(0,2))));
			dateEvaM.setSelectedIndex(recupererIndexHeures(1, Integer.parseInt(dateStandard.format(date).substring(3,5))));
			dateEvaA.setSelectedIndex(recupererIndexHeures(1900, Integer.parseInt(dateStandard.format(date).substring(6,10))));
    		
			date = Eleve.getDATE_ENREGISTREMENT_ELEVE();
			System.out.println(date);
			dateEnregiA.setSelectedIndex(recupererIndexHeures(1900, Integer.parseInt(dateStandard.format(date).substring(6,10))));
			dateEnregiM.setSelectedIndex(recupererIndexHeures(1, Integer.parseInt(dateStandard.format(date).substring(3,5))));
			dateEnregiJ.setSelectedIndex(recupererIndexHeures(1, Integer.parseInt(dateStandard.format(date).substring(0,2))));
			
			date = Eleve.getDATE_INSCRIPTION_ELEVE();
			System.out.println(date);
			dateInscriA.setSelectedIndex(recupererIndexHeures(1900, Integer.parseInt(dateStandard.format(date).substring(6,10))));
			dateInscriM.setSelectedIndex(recupererIndexHeures(1, Integer.parseInt(dateStandard.format(date).substring(3,5))));
			dateInscriJ.setSelectedIndex(recupererIndexHeures(1, Integer.parseInt(dateStandard.format(date).substring(0,2))));
       
			if (Eleve.getTEST_VU_ELEVE()){
				testVueO.setSelected(true);
			}
			else{testVueN.setSelected(true);}
			
			areaTestVue.setText(Eleve.getOBSERVATION_VUE_ELEVE());
			
			icon = new ImageIcon(Eleve.getPHOTO_ELEVE());
		    labelPhoto.setIcon(icon);
		    
		   
		    MajJtable();
		    creationJtable();
		
		}	
		
		public void MajJtable(){
			rdv = new RDVMoniteurEleve();
			rdv.setListeAssurerLecon(rdv.recupererListeEleve(idEleve));
			
			    
		}

		public int recupererIndexHeures ( int depart, int nombre ) {
        	int i = 0;
        	while (depart != nombre){
        		i++;
        		depart++;
        	}
        	return i;
        }
	
         class StateListener implements ActionListener{
        	 
            public void actionPerformed(ActionEvent e) {
                    System.out.println("source : " + ((JRadioButton)e.getSource()).getText() + " - etat : " + ((JRadioButton)e.getSource()).isSelected());
            }
        }
        
        private void parametrerJPanel(JPanel p, int l, int h, Color c) {
        	p.setBackground(c);
        	p.setPreferredSize(new Dimension(l,h));
        }

        private void parametrerJLabelEtJTextField(JLabel la, Font f, JTextField tf, int h, int l) {
			la.setFont(f);
			tf.setPreferredSize(new Dimension(h, l));
        }
        
        private void parametrerJComboBoxDate(JComboBox j, JComboBox m, JComboBox a) {
        	Date date = new Date();
			SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy");
			
			for(int i=1; i<32; i++) {
				j.addItem(i);
				
				if(dateStandard.format(date).substring(0,2).equals(""+i+""))
					j.setSelectedIndex(i-1);
			}
			j.setPreferredSize(new Dimension(50, 20));
			for(int i=1; i<13; i++) {
				m.addItem(i);
					if((dateStandard.format(date).substring(3,5).equals("0"+i+""))||(dateStandard.format(date).substring(3,5).equals(""+i+"")))
					m.setSelectedIndex(i-1);
			}
			m.setPreferredSize(new Dimension(50, 20));
			for(int i=1900; i<=2011; i++) {
				a.addItem(i);
				if(dateStandard.format(date).substring(6,10).equals(""+i+""))
					a.setSelectedIndex(i-1900);
					
			}
			a.setPreferredSize(new Dimension(60, 20));
			
        }
        
       
        
      public DataFicheEleve1 getDatafiche1() {
    	  return dataFiche1;
      }
        
        public JButton getBoutonAjouter() {
			return boutonAjouter;
		}
        public JTable getTableau() {
			return tableau;
		}
        public ArrayList<String>[] getListeFormation() {
			return listeFormation;
		}
        public ArrayList<String> getComboData() {
			return comboData;
		}
       
        public DataFicheEleve1 getDataFiche1() {
			return dataFiche1;
		}        
        
        public TableModel2 getzModel() {
			return zModel;
		}

		public void setzModel(TableModel2 zModel) {
			this.zModel = zModel;
		}
		
		  public String[] getTitleTableauJtable() {
				return titleTableauJtable;
			}

			public void setTitleTableauJtable(String[] titleTableauJtable) {
				this.titleTableauJtable = titleTableauJtable;
			}

			public int getIdEleve() {
				return idEleve;
			}

			public void setIdEleve(int idEleve) {
				this.idEleve = idEleve;
			}
}  