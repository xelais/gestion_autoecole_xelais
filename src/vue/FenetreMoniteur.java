package vue;
import javax.swing.*;

import modele.DataMoniteur;
import net.ko.kobject.KListObject;

import KClass.KMoniteur;

import java.awt.*;
import java.util.ArrayList;
import controleur.*;

public class FenetreMoniteur extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nom = new JTextField();
	private JTextField prenom = new JTextField();
	private JButton ajouter = new JButton("Ajouter");
	private JButton effacer = new JButton("Supprimer");
	private JButton maj = new JButton("Mettre à jour");
	private JButton reinitialiser = new JButton("Reinitialiser");
	JLabel textAjout = new JLabel ("Ajout d'un nouveau Moniteur");	
	JLabel textlisteMoni = new JLabel("Liste actuelle des Moniteurs :");
	
	ArrayList<String> listeMemMoni = new ArrayList<String>();
	JList listeMoni = new JList(listeMemMoni.toArray());
	JScrollPane listScroller = new JScrollPane(listeMoni);
	
	KListObject<KMoniteur> KListe = new KListObject<KMoniteur>(KMoniteur.class);
	
	DataMoniteur moniteur = new DataMoniteur();

	public FenetreMoniteur() {		
		
		//====================================================>modele_memoire
		KListe =moniteur.recupererListe();
		for (int i = 0; i< KListe.count(); i++){
		listeMemMoni.add(KListe.get(i).getPRENOM_MONITEUR().toLowerCase()+" "+KListe.get(i).getNOM_MONITEUR().toUpperCase());
		}
		listeMoni.setListData(listeMemMoni.toArray());
		
		//=====================================================> graphique
		
		this.setTitle("Ajout / modification Moniteurs");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		effacer.setEnabled(false);
		maj.setEnabled(false);
		ajouter.setEnabled(false);
		
		listScroller.setPreferredSize(new Dimension(200, 200));
		textAjout.setPreferredSize(new Dimension(175,25));
		
		JLabel texteNom = new JLabel("Nom :      ");
		nom.setPreferredSize(new Dimension(100,20));
		
		JLabel textePrenom = new JLabel("Prenom :");
		prenom.setPreferredSize(new Dimension(100,20));
				
		JPanel saisieNom = new JPanel();
		saisieNom.setPreferredSize(new Dimension(600,25));
		saisieNom.add(texteNom);
		saisieNom.add(nom);
		
		JPanel saisiePrenom = new JPanel();
		saisiePrenom.setPreferredSize(new Dimension(600,40));
		saisiePrenom.add(textePrenom);
		saisiePrenom.add(prenom);
		
		JPanel LecturList = new JPanel();
		LecturList.setPreferredSize(new Dimension(600,600));
		LecturList.add(textlisteMoni);
		LecturList.add(listScroller);
		
		JPanel c = new JPanel();
		c.add(textAjout);
		c.add(saisieNom);
		c.add(saisiePrenom);
		c.add(reinitialiser);
		c.add(maj);
		c.add(ajouter);
		c.add(effacer);
		c.add(LecturList);
				
		EcouteurMoniteur ecouteur = new EcouteurMoniteur(this);
		textAjout.addMouseListener(ecouteur);
		prenom.addActionListener(ecouteur);
		nom.addActionListener(ecouteur);
		prenom.getDocument().addDocumentListener(ecouteur);
		prenom.getDocument().putProperty("name", "textfield");
		nom.getDocument().addDocumentListener(ecouteur);
		prenom.getDocument().putProperty("name", "textfield");
		ajouter.addActionListener(ecouteur);
		effacer.addActionListener(ecouteur);
		maj.addActionListener(ecouteur);
		reinitialiser.addActionListener(ecouteur);
		listeMoni.addMouseListener(ecouteur);
		this.addMouseListener(ecouteur);
		
		this.setContentPane(c);
	}
	
	public JTextField getNom() {
		return nom;
	}
	public JTextField getPrenom() {
		return prenom;
	}
	public JList getListeMoni() {
		return listeMoni;
	}
	public ArrayList<String> getListeMemMoni() {
		return listeMemMoni;
	}
	public JButton getAjouter() {
		return ajouter;
	}
	public JButton getMaj() {
		return maj;
	}
	public JButton getEffacer() {
		return effacer;
	}
	public JLabel getTextAjout() {

		return textAjout;
	}	
	public KListObject<KMoniteur> getKListe() {
		return KListe;
	}

	public void setKListe(KListObject<KMoniteur> kListe) {
		KListe = kListe;
	}

	public JButton getReinitialiser() {
		return reinitialiser;
	}

	public void setReinitialiser(JButton reinitialiser) {
		this.reinitialiser = reinitialiser;
	}
}