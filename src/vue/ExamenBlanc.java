package vue;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExamenBlanc extends JPanel implements ActionListener {

	// declaration des variables.

	    private JPanel containerDate = new JPanel();
	    private JLabel texteDate = new JLabel();
	    
	    private JPanel containerNom = new JPanel();
	    private JLabel texteNomE = new JLabel();
	    private JLabel texteNomM = new JLabel();
	    private JComboBox nomEleve = new JComboBox();
	    private JComboBox nomMoniteur = new JComboBox();
	    
	    private JPanel containerResultat = new JPanel();
	    private JLabel texteResultat = new JLabel();
	    private JRadioButton resultatF = new JRadioButton("Favorable");
        private JRadioButton resultatI = new JRadioButton("Insuffisant");
        private JRadioButton resultatN = new JRadioButton("Examen non mene e son terme");
        private ButtonGroup groupResultat = new ButtonGroup();
	    
	    private JPanel containerMaitrise = new JPanel();
	    
	    private JPanel containerLecon = new JPanel();
	    private JLabel texteNbrLecon = new JLabel();
	    private JComboBox nbrLecon = new JComboBox();
	    private JLabel texteCommentaire = new JLabel();
        private JTextArea areaCommentaire = new JTextArea();
        private JScrollPane scrollCommentaire = new JScrollPane(areaCommentaire);
	    private JLabel texteSignature = new JLabel();
        private JTextArea areaSignature = new JTextArea();
        private JScrollPane scrollSignature = new JScrollPane(areaSignature);
	    
	    private JPanel containerObserver1 = new JPanel();
	    private JPanel containerObserver2 = new JPanel();
	    private JPanel containerAdapter1 = new JPanel();
	    private JPanel containerAdapter2 = new JPanel();
	    private JPanel containerManoeuvre1 = new JPanel();
	    private JPanel containerManoeuvre2 = new JPanel();
	    
	    private JPanel containerCode= new JPanel();
	    private JLabel texteTitreCode = new JLabel();
	    private JLabel texteCode1 = new JLabel();
	    private JLabel texteCode2 = new JLabel();
	    private JLabel texteCode3 = new JLabel();
	    
	    private JPanel containerBoutons= new JPanel();
	    
	    private JButton valider = new JButton("Valider");
		private JButton annuler = new JButton("Annuler");
	    
	    private JLabel texteTitre = new JLabel();
	    
	    
        public ExamenBlanc(){
        	
			this.setBackground(Color.white);
			this.setPreferredSize(new Dimension(900,1100));
			this.setBorder(BorderFactory.createTitledBorder(""));
			
			texteTitre = new JLabel("Examen Blanc de Conduite");
			texteTitre.setFont(new Font(null,Font.BOLD,20));
			texteTitre.setPreferredSize(new Dimension(500,50));

			containerDate.setPreferredSize(new Dimension(300,50));
			containerNom.setPreferredSize(new Dimension(400,60));
			containerResultat.setPreferredSize(new Dimension(400,60));
			containerMaitrise.setPreferredSize(new Dimension(400,160));
			containerLecon.setPreferredSize(new Dimension(400,160));
			containerObserver1.setPreferredSize(new Dimension(400,100));
			containerObserver2.setPreferredSize(new Dimension(400,100));
			containerAdapter1.setPreferredSize(new Dimension(400,200));
			containerAdapter2.setPreferredSize(new Dimension(400,200));
			containerManoeuvre1.setPreferredSize(new Dimension(400,100));
			containerManoeuvre2.setPreferredSize(new Dimension(400,100));
			containerCode.setPreferredSize(new Dimension(890,350));
			containerBoutons.setPreferredSize(new Dimension(800,50));
			
			containerDate.setBackground(Color.white);
			containerNom.setBackground(Color.white);
			containerResultat.setBackground(Color.white);
			containerMaitrise.setBackground(Color.green);
			containerLecon.setBackground(Color.white);
			containerObserver1.setBackground(Color.red);
			containerObserver2.setBackground(Color.green);
			containerAdapter1.setBackground(Color.blue);
			containerAdapter2.setBackground(Color.red);
			containerManoeuvre1.setBackground(Color.green);
			containerManoeuvre2.setBackground(Color.blue);
			containerCode.setBackground(Color.white);
			containerBoutons.setBackground(Color.white);

			containerLecon.setBorder(BorderFactory.createTitledBorder(""));
			containerCode.setBorder(BorderFactory.createTitledBorder(""));
			
			this.add(texteTitre);
			this.add(containerDate);
			this.add(containerNom);
			this.add(containerResultat);
			this.add(containerMaitrise);
			this.add(containerLecon);
			this.add(containerObserver1);
			this.add(containerObserver2);
			this.add(containerAdapter1);
			this.add(containerAdapter2);
			this.add(containerManoeuvre1);
			this.add(containerManoeuvre2);
			this.add(containerCode);
			this.add(containerBoutons);
			
			Date date = new Date();
			SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy"); 
			texteDate = new JLabel("Date : "+dateStandard.format(date));
			texteDate.setFont(new Font(null,Font.BOLD,13));
			containerDate.add(texteDate);
			
			texteNomE = new JLabel("Eleve : ");
			texteNomE.setFont(new Font(null,Font.BOLD,13));
			texteNomE.setPreferredSize(new Dimension(80, 20));
			nomEleve = new JComboBox();
			nomEleve.setPreferredSize(new Dimension(300, 20));
			texteNomM = new JLabel("Moniteur : ");
			texteNomM.setFont(new Font(null,Font.BOLD,13));
			texteNomM.setPreferredSize(new Dimension(80, 20));
			nomMoniteur = new JComboBox();
			nomMoniteur.setPreferredSize(new Dimension(300, 20));
			containerNom.add(texteNomE);
			containerNom.add(nomEleve);
			containerNom.add(texteNomM);
			containerNom.add(nomMoniteur);
			
			texteResultat = new JLabel("Resultat de l'examen blanc :");
			texteResultat.setFont(new Font(null,Font.BOLD,13));
			texteResultat.setPreferredSize(new Dimension(350, 20));
			resultatF.addActionListener(new StateListener());
			resultatI.addActionListener(new StateListener());
			resultatN.addActionListener(new StateListener());
			resultatF.setBackground(Color.white);
			resultatI.setBackground(Color.white);
			resultatN.setBackground(Color.white);
	        groupResultat.add(resultatF);
	        groupResultat.add(resultatI);
	        groupResultat.add(resultatN);
			containerResultat.add(texteResultat);
			containerResultat.add(resultatF);
			containerResultat.add(resultatI);
			containerResultat.add(resultatN);
			
			texteNbrLecon = new JLabel("Nombre de leeons recommandees : ");
			texteNbrLecon.setFont(new Font(null,Font.BOLD,13));
			texteNbrLecon.setPreferredSize(new Dimension(240, 20));
			nbrLecon = new JComboBox();
			nbrLecon.setPreferredSize(new Dimension(50, 20));
			for(int i=0; i<=50; i++)
				nbrLecon.addItem(i);
			texteCommentaire = new JLabel("Commentaires : ");
			texteCommentaire.setFont(new Font(null,Font.BOLD,13));
			texteCommentaire.setPreferredSize(new Dimension(350, 20));
			scrollCommentaire.setPreferredSize(new Dimension(354, 50));
			texteSignature = new JLabel("Signature de l'eleve : ");
			texteSignature.setFont(new Font(null,Font.BOLD,13));
			texteSignature.setPreferredSize(new Dimension(150, 20));
			scrollSignature.setPreferredSize(new Dimension(200, 35));
			containerLecon.add(texteNbrLecon);
			containerLecon.add(nbrLecon);
			containerLecon.add(texteCommentaire);
			containerLecon.add(scrollCommentaire);
			containerLecon.add(texteSignature);
			containerLecon.add(scrollSignature);
			
			texteTitreCode = new JLabel("Code : Situation correspondante");
			texteTitreCode.setFont(new Font(null,Font.BOLD,16));
			texteTitreCode.setPreferredSize(new Dimension(750, 20));
			texteCode1 = new JLabel("<html>DEPART<br>" +
					"D1 : Demarrage en circulation ou pour s'inserer dans la circulation.<br>" +
					"D2 : Demarrage en declivite.<hr>" +
					"ARRET<br>" +
					"A : Arret en circulation ou pour en sortir.<hr>" +
					"LIGNE DROITE<br>" +
					"L1 : Agglomeration.<br>" +
					"L2 : Route.<br>" +
					"L3 : Autoroute, route e chaussees separees (2x2 voies, etc.).<hr>" +
					"INTERSECTION<br>" +
					"I1 : Feu tricolore.<br>" +
					"I2 : Stop.<br>" +
					"I3 : \"Cedez le passage\".<br>" +
					"I4 : Priorite e droite.<br>" +
					"I5 : Intersection oe le candidat n'est pas tenu de ceder le passage.</html>");
			texteCode1.setFont(new Font(null,Font.BOLD,11));
			texteCode1.setPreferredSize(new Dimension(285, 300));
			texteCode2 = new JLabel("<html>SENS GIRATOIRE<br>" +
					"G : Sens giratoire.<hr>" +
					"CHANGEMENT DE DIRECTION<br>" +
					"C1 : A droite ou e gauche.<br>" +
					"C2 : Preselection (changement de voie).<br>" +
					"C3 : Voie d'insertion ou de deceleration.<hr>" +
					"VIRAGE<br>" +
					"V : Virage.<hr>" +
					"DEPASSEMENT<br>" +
					"DP1 : Depassement.<br>" +
					"DP2 : Depassement d'un deux roues ou d'un pieton.<br>" +
					"DP3 : Etre depasse.<hr>" +
					"CROISEMENT<br>" +
					"CR : Croisement<br><br><br></html>");
			texteCode2.setFont(new Font(null,Font.BOLD,11));
			texteCode2.setPreferredSize(new Dimension(285, 300));
			texteCode3 = new JLabel("<html>DECLIVITE<br>" +
					"DC : Circulation en montee ou en descente.<hr>" +
					"SITUATIONS PARTICULIERES<br>" +
					"S1 : Pieton (passage pour pietons, etc.).<br>" +
					"S2 : Tramway ou autobus (arret, depassement, etc.).<br>" +
					"S3 : Voie reservee (bande d'urgence, etc.).<br>" +
					"S4 : Signalisation de prescription (sens interdit, limitation de tonnage ou de gabarit, obligation de tourner e droite, etc.).<br>" +
					"S5 : Circulation sur un \"parking\".<br>" +
					"S6 : Passage e niveau.<br>" +
					"S7 : Ouvrage d'art, tunnel, pont.<br>" +
					"S8 : Zone de travaux.<br>" +
					"S9 : Vehicule prioritaire - Agent de la circulation.<br>" +
					"S10 : Conditions de visibilite et/ou d'adherence reduites.<br>" +
					"Sx : Autre (se rapporter e la case \"Commentaire\").</html>");
			texteCode3.setFont(new Font(null,Font.BOLD,11));
			texteCode3.setPreferredSize(new Dimension(285, 300));
			containerCode.add(texteTitreCode);
			containerCode.add(texteCode1);
			containerCode.add(texteCode2);
			containerCode.add(texteCode3);
			
			containerBoutons.add(valider);
			containerBoutons.add(annuler);
			
			valider.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {				
					
				}			
			});
			
			annuler.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
				
				}			
			});
             
             // Visibilite de la fenetre.
             this.setVisible(true);
    	}
        
        class StateListener implements ActionListener{
        	 
            public void actionPerformed(ActionEvent e) {
                    System.out.println("source : " + ((JRadioButton)e.getSource()).getText() + " - etat : " + ((JRadioButton)e.getSource()).isSelected());
            }
        }


        // permet de rafraichir la fenetre e chaque action "bouger"
        public void actionPerformed(ActionEvent arg0) {
        	
        }
        
        public class MyJTable extends JTable {
        	public MyJTable(Object[][] a, String  t[]) {
        		super(a,t);
        	}
	        public boolean isCellEditable(int row, int column) {
	        	if(column==0)
	        		return false;
	        	else
	        		return true;
	        }
        }

        
}              