package vue;
import KClass.KEleve;
import controleur.*;
import javax.swing.*;

import net.ko.kobject.KListObject;

import modele.bdd;

import java.awt.*;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FenetrePrincipale extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	bdd bdd = new bdd();
	private FicheEleve ficheEleve = new FicheEleve();
	private Etape1 etape1 = new Etape1();
	private Etape2 etape2 = new Etape2();
	private Etape3 etape3 = new Etape3();
	private Etape4 etape4 = new Etape4();
	private InteroOrale intero = new InteroOrale();
	private ExamenBlanc examB = new ExamenBlanc();
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fichier = new JMenu("Fichier");
	private JMenu eleve = new JMenu("Eleves");
	private JMenu moniteur = new JMenu("Moniteurs");
		
	private JMenuItem importerLivret = new JMenuItem("Importer un livret");
	private JMenuItem exporterLivret = new JMenuItem("Exporter le livret actuel");
	private JMenuItem imprimerLivret = new JMenuItem("Imprimer le livret actuel");
	private JMenuItem quitter = new JMenuItem("Quitter");
	private JMenuItem gestionM = new JMenuItem("Gestion");

	
	private JButton BoutonFicheE = new JButton("Fiche Eleve");
	private JButton BoutonEtape1 = new JButton("Etape 1");
	private JButton BoutonEtape2 = new JButton("Etape 2");
	private JButton BoutonEtape3 = new JButton("Etape 3");
	private JButton BoutonEtape4 = new JButton("Etape 4");
	private JButton BoutonIntero = new JButton("Interrogation orale");
	private JButton BoutonExamB = new JButton("Examen Blanc");
	private JButton BoutonValider = new JButton("Valider");
	JButton BoutonAnnuler = new JButton("Annuler");
	

	private JButton boutonAjouterE = new JButton("Ajouter");
	private JTextField rechercheE = new JTextField();
	private String tabEleve[];
	
	
	private JList JlisteEleves;
	private ArrayList<String> listeEleves= new ArrayList<String>();
	
	
	public FenetrePrincipale() {
		
		
		bdd.connexion();
		
		this.setTitle("Auto-Ecole");
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);               
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		setUndecorated(true);
		
		JlisteEleves = new JList(listeEleves.toArray());
		rechargerListeEleve();
		
		fichier.add(importerLivret);
		fichier.add(exporterLivret);
		fichier.add(imprimerLivret);
		fichier.add(quitter);
		moniteur.add(gestionM);
		menuBar.add(fichier);
		menuBar.add(eleve);
		menuBar.add(moniteur);
		setJMenuBar(menuBar);

		
		JPanel containerP = new JPanel();
		JScrollPane scroll = new JScrollPane(containerP);
		JPanel centreFiche = new JPanel();
		JPanel margeDroite = new JPanel();
		JPanel containerBoutons = new JPanel();
		JPanel containerBoutonsConfirm = new JPanel();
		JPanel containerListeEleves = new JPanel();
		JScrollPane scrollListeE = new JScrollPane(JlisteEleves);
		
		containerBoutons.setPreferredSize(new Dimension(200,250));
		containerBoutons.setLayout(new GridLayout(7, 1));
		containerBoutons.add(BoutonFicheE);
		containerBoutons.add(BoutonEtape1);
		containerBoutons.add(BoutonEtape2);
		containerBoutons.add(BoutonEtape3);
		containerBoutons.add(BoutonEtape4);
		containerBoutons.add(BoutonIntero);
		containerBoutons.add(BoutonExamB);

		containerBoutonsConfirm.setPreferredSize(new Dimension(200,50));
		containerBoutonsConfirm.add(BoutonValider);
		containerBoutonsConfirm.add(BoutonAnnuler);
		
		containerListeEleves.setPreferredSize(new Dimension(200,350));
		JLabel texteEleves = new JLabel("ELEVES");
		rechercheE.setPreferredSize(new Dimension(196,20));
		texteEleves.setFont(new Font(null,Font.BOLD,13));
		scrollListeE.setPreferredSize(new Dimension(196,295));
		texteEleves.setPreferredSize(new Dimension(80,20));
		containerListeEleves.add(texteEleves);
		boutonAjouterE.setPreferredSize(new Dimension(80,25));
		containerListeEleves.add(boutonAjouterE);
		containerListeEleves.add(rechercheE);
		containerListeEleves.add(scrollListeE);
		
		
		margeDroite.setPreferredSize(new Dimension(200,650));
		margeDroite.add(containerListeEleves);
		margeDroite.add(containerBoutons);
		margeDroite.add(containerBoutonsConfirm);
		
		etape1.setVisible(false);
		etape2.setVisible(false);
		etape3.setVisible(false);
		ficheEleve.setVisible(true);
		etape4.setVisible(false);
		intero.setVisible(false);
		examB.setVisible(false);
		
		centreFiche.add(ficheEleve);
		centreFiche.add(etape1);
		centreFiche.add(etape2);
		centreFiche.add(etape3);
		centreFiche.add(etape4);
		centreFiche.add(intero);
		centreFiche.add(examB);
		
		containerP.setLayout(new BorderLayout());
		containerP.add(margeDroite, BorderLayout.WEST);
		containerP.add(centreFiche, BorderLayout.CENTER);
		
		EcouteurPrincipale ecouteur = new EcouteurPrincipale(this);
		
		BoutonFicheE.addActionListener(ecouteur);
		BoutonEtape1.addActionListener(ecouteur);
		BoutonEtape2.addActionListener(ecouteur);
		BoutonEtape3.addActionListener(ecouteur);
		BoutonEtape4.addActionListener(ecouteur);
		BoutonIntero.addActionListener(ecouteur);
		BoutonExamB.addActionListener(ecouteur);
		BoutonValider.addActionListener(ecouteur);
		BoutonAnnuler.addActionListener(ecouteur);
		JlisteEleves.addMouseListener(ecouteur);
		rechercheE.addActionListener(ecouteur);
		quitter.addActionListener(ecouteur);
		gestionM.addActionListener(ecouteur);
		boutonAjouterE.addActionListener(ecouteur);
		
		BoutonFicheE.setEnabled(false);
		BoutonEtape1.setEnabled(false);
		BoutonEtape2.setEnabled(false);
		BoutonEtape3.setEnabled(false);
		BoutonEtape4.setEnabled(false);
		BoutonIntero.setEnabled(false);
		BoutonExamB.setEnabled(false);
		BoutonValider.setEnabled(false);
		BoutonAnnuler.setEnabled(false);
		
		this.setContentPane(scroll);
		this.setVisible(true);
	}
	
	public void rechargerListeEleve() {
		KListObject<KEleve>KListe = new KListObject<KEleve>(KEleve.class);
		KListe = ficheEleve.getDatafiche1().recupererListe();
		for (int i = 0; i< KListe.count(); i++){
		listeEleves.add(KListe.get(i).getPRENOM_ELEVE().toLowerCase()+" "+KListe.get(i).getNOM_ELEVE().toUpperCase());
		}
		JlisteEleves.setListData(listeEleves.toArray());
		
	}
	
	public Etape1 getEtape1() {
		return etape1;
	}
	public Etape2 getEtape2() {
		return etape2;
	}
	public Etape3 getEtape3() {
		return etape3;
	}
	public Etape4 getEtape4() {
		return etape4;
	}
	public ExamenBlanc getExamB() {
		return examB;
	}
	public FicheEleve getFicheEleve() {
		return ficheEleve;
	}
	public InteroOrale getIntero() {
		return intero;
	}
	public JButton getBoutonEtape1() {
		return BoutonEtape1;
	}
	public JButton getBoutonEtape2() {
		return BoutonEtape2;
	}
	public JButton getBoutonEtape3() {
		return BoutonEtape3;
	}
	public JButton getBoutonEtape4() {
		return BoutonEtape4;
	}
	public JButton getBoutonExamB() {
		return BoutonExamB;
	}
	public JButton getBoutonFicheE() {
		return BoutonFicheE;
	}
	public JButton getBoutonIntero() {
		return BoutonIntero;
	}
	public JButton getBoutonAnnuler() {
		return BoutonAnnuler;
	}
	public JButton getBoutonValider() {
		return BoutonValider;
	}
	public JList getListeEleves() {
		return JlisteEleves;
	}
	public JTextField getRechercheE() {
		return rechercheE;
	}
	public String[] getTabEleve() {
		return tabEleve;
	}
	public void setListeEleves(JList listeEleves) {
		this.JlisteEleves = listeEleves;
	}
	public JMenuItem getQuitter() {
		return quitter;
	}
	
	public void setFicheEleve(FicheEleve ficheEleve) {
		this.ficheEleve = ficheEleve;
	}
	public JMenuItem getMoniteur() {
		return moniteur;
	}
	public JButton getBoutonAjouterE() {
		return boutonAjouterE;
	}
	public JMenuItem getGestionM() {
		return gestionM;
	}
}