package vue;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Etape1 extends JPanel {

	private JTable tableau;
	private String[] comboData = {"","Aborde", "Traite", "Assimile"};
	private JPanel containerT = new JPanel();
	private JPanel containerT1 = new JPanel();
	private JPanel containerT2 = new JPanel();
	private JPanel container3 = new JPanel();
	private JPanel containerCB1 = new JPanel();
	private JPanel containerCB12 = new JPanel();
	private JPanel containerCB2 = new JPanel();
	private JPanel containerCB22 = new JPanel();
	private JPanel containerE = new JPanel();
	private JPanel containerE1 = new JPanel();
	private JPanel containerE2 = new JPanel();
	private JPanel containerE3 = new JPanel();
	private JLabel texteTitre = new JLabel();
	Object[][] data1;
	
	private JCheckBox tabCheck1[] = new JCheckBox[10];
	private JCheckBox tabCheck12[] = new JCheckBox[10];
	private JCheckBox tabCheck2[] = new JCheckBox[8];
	private JCheckBox tabCheck22[] = new JCheckBox[8];
	
	private JTextArea areaQPosees = new JTextArea();
    private JScrollPane scrollQPosees = new JScrollPane(areaQPosees);
    
    JComboBox dateNaissJ1; JComboBox dateNaissM1; JComboBox dateNaissA1; JComboBox hTheo1; JComboBox hPra1; JComboBox result1;
    JComboBox dateNaissJ2; JComboBox dateNaissM2; JComboBox dateNaissA2; JComboBox hTheo2; JComboBox hPra2; JComboBox result2;
    JComboBox dateNaissJ3; JComboBox dateNaissM3; JComboBox dateNaissA3; JComboBox nomMoniteur; JComboBox result3;
	
	public Etape1(){

		this.setPreferredSize(new Dimension(900,680));
		
		texteTitre = new JLabel("ETAPE 1");
		texteTitre.setFont(new Font(null,Font.BOLD,20));
		texteTitre.setPreferredSize(new Dimension(800,50));
		
		JTabbedPane onglet = new JTabbedPane();
		JPanel partie1 = new JPanel();
		JPanel partie2 = new JPanel();
		partie1.setPreferredSize(new Dimension(880,600));
		partie2.setPreferredSize(new Dimension(880,600));
		partie1.setBackground(Color.white);
		partie2.setBackground(Color.white);
		onglet.add(partie1, "Objectifs");
		onglet.add(partie2, "Synthese");
		
		this.add(onglet);
		
		partie1.add(texteTitre);
		
		data1 = new Object[9][3];
	    for(int i=0; i<9; i++) {
	    	data1[i][1]=comboData[0];
	    	for(int j=2; j<3; j++) {
	    		data1[i][j]="";
	    	}
	    }
	    
	    data1[0][0]="a) Connaitre les principaux organes de la voiture, les principales commandes et le tableau de bord.";
	    data1[1][0]="b) S'installer au poste de conduite.";
	    data1[2][0]="c) Regarder autour de soi.";
	    data1[3][0]="d) Agir sans mettre en danger les autres ni soi-meme.";
	    data1[4][0]="e) Avertir les autres usagers.";
	    data1[5][0]="f) Demarrer et s'arreter.";
	    data1[6][0]="g) Tenir et tourner le volant.";
	    data1[7][0]="h) Utiliser la boite de vitesses.";
	    data1[8][0]="i) Diriger la voiture, en avant et en arriere, en ligne droite et en courbe en adaptant allure et trajectoire.";
	    
		String  title[] = {"Objectifs : ", " ", "Observations"};
		
		JComboBox combo = new JComboBox(comboData);
		
		TableModel zModel = new TableModel(data1, title);
		
		this.tableau = new JTable(zModel);
		this.tableau.getColumn(" ").setCellEditor(new DefaultCellEditor(combo));
		
		TableColumn col;
		col = tableau.getColumnModel().getColumn(0);
		col.setPreferredWidth(300);
		col.setCellEditor(new CellEditorAera());
		col.setCellRenderer(new CellRenderAera());
		col = tableau.getColumnModel().getColumn(1);
		col.setPreferredWidth(1);
		col = tableau.getColumnModel().getColumn(2);
		col.setPreferredWidth(300);
		col.setCellEditor(new CellEditorAera());
		col.setCellRenderer(new CellRenderAera());
		tableau.getTableHeader().setReorderingAllowed(false);
		tableau.getTableHeader().setResizingAllowed(false);
		
		for(int i = 0; i < tableau.getRowCount(); i++){
			tableau.setRowHeight(i, 50);
		}
		
		JScrollPane scrollTableau = new JScrollPane(tableau);
		scrollTableau.setPreferredSize(new Dimension(850, 469));
		partie1.add(scrollTableau);
		
		JLabel texteTitre2 = new JLabel("Fiche d'evaluation de synthese de la premiere etape.");
		texteTitre2.setFont(new Font(null,Font.BOLD,15));
		texteTitre2.setPreferredSize(new Dimension(800,30));
		partie2.add(texteTitre2);
		
		JLabel texteTitre3 = new JLabel("<html>L'eleve va monter en voiturte :<br>" +
				"- il regarde si aucun pneu n'est degonfle.<br>" +
				"Il s'installe au poste de conduite :<br>" +
				"- il regle le siege,<br>" +
				"- il regle les retroviseurs,<br>" +
				"- il boucle la ceinture.<br>" +
				"Il met le moteur en marche :<br>" +
				"- sans hesitation ni erreur<br>" +
				"  (eventuellement : le starter).<br>" +
				"Il demarre :<br>" +
				"- sans caler,<br>" +
				"- sans e-coup.<br>" +
				"Il change de vitesse :<br>" +
				"- sans caler,<br>" +
				"- au moment convenable,<br>" +
				"- sans regarder le levier.</html>");
		texteTitre3.setFont(new Font(null,Font.BOLD,13));
		texteTitre3.setPreferredSize(new Dimension(260,310));
		
		JLabel texteTitre4 = new JLabel("<html>Il roule en ligne droite :<br>" +
				"- sans deviation notable.<br>" +
				"Il tourne :<br>" +
				"- sans s'ecarter du bord de la voie.<br>" +
				"Il fait une marche arriere<br>" +
				"- En ligne droite :<br>" +
				"--- sans deviation importante.<br>" +
				"- En Courbe :<br>" +
				"--- sans deviation importante.<br>" +
				"Il fait un demi-tour :<br>" +
				"- sans hesitation importante,<br>" +
				"- sans erreur.<br>" +
				"Il s'arrete :<br>" +
				"- sans erreur,<br>" +
				"- e l'endroit indique.</html>");
		texteTitre4.setFont(new Font(null,Font.BOLD,13));
		texteTitre4.setPreferredSize(new Dimension(220,310));
		
		containerCB1.setBackground(Color.white);
		containerCB1.setPreferredSize(new Dimension(20,310));
		for(int i=0; i<10; i++) {
			tabCheck1[i] = new JCheckBox("");
			tabCheck1[i].setPreferredSize(new Dimension(20,13));
			tabCheck1[i].setBackground(Color.white);
			containerCB1.add(tabCheck1[i]);
		}
		
		tabCheck1[0].setPreferredSize(new Dimension(20,55));
		tabCheck1[4].setPreferredSize(new Dimension(20,65));
		Insets marge = new Insets(0, 2, 18, 0);
		tabCheck1[6].setPreferredSize(new Dimension(20,31));
		tabCheck1[6].setMargin(marge);
		
		containerCB12.setBackground(Color.white);
		containerCB12.setPreferredSize(new Dimension(20,310));
		for(int i=0; i<10; i++) {
			tabCheck12[i] = new JCheckBox("");
			tabCheck12[i].setPreferredSize(new Dimension(20,13));
			tabCheck12[i].setBackground(Color.white);
			containerCB12.add(tabCheck12[i]);
		}
		
		tabCheck12[0].setPreferredSize(new Dimension(20,55));
		tabCheck12[4].setPreferredSize(new Dimension(20,65));
		marge = new Insets(0, 2, 18, 0);
		tabCheck12[6].setPreferredSize(new Dimension(20,31));
		tabCheck12[6].setMargin(marge);
		
		containerCB2.setBackground(Color.white);
		containerCB2.setPreferredSize(new Dimension(20,310));
		for(int i=0; i<8; i++) {
			tabCheck2[i] = new JCheckBox("");
			tabCheck2[i].setPreferredSize(new Dimension(20,13));
			tabCheck2[i].setBackground(Color.white);
			containerCB2.add(tabCheck2[i]);
		}
		
		marge = new Insets(32, 2, 18, 0);
		tabCheck2[0].setPreferredSize(new Dimension(20,62));
		tabCheck2[0].setMargin(marge);
		marge = new Insets(0, 2, 35, 0);
		tabCheck2[1].setPreferredSize(new Dimension(20,48));
		tabCheck2[1].setMargin(marge);
		marge = new Insets(0, 2, 19, 0);
		tabCheck2[2].setPreferredSize(new Dimension(20,32));
		tabCheck2[2].setMargin(marge);
		tabCheck2[3].setPreferredSize(new Dimension(20,32));
		tabCheck2[3].setMargin(marge);
		tabCheck2[5].setPreferredSize(new Dimension(20,32));
		tabCheck2[5].setMargin(marge);
		
		containerCB22.setBackground(Color.white);
		containerCB22.setPreferredSize(new Dimension(20,310));
		for(int i=0; i<8; i++) {
			tabCheck22[i] = new JCheckBox("");
			tabCheck22[i].setPreferredSize(new Dimension(20,13));
			tabCheck22[i].setBackground(Color.white);
			containerCB22.add(tabCheck22[i]);
		}
		
		marge = new Insets(32, 2, 18, 0);
		tabCheck22[0].setPreferredSize(new Dimension(20,62));
		tabCheck22[0].setMargin(marge);
		marge = new Insets(0, 2, 35, 0);
		tabCheck22[1].setPreferredSize(new Dimension(20,48));
		tabCheck22[1].setMargin(marge);
		marge = new Insets(0, 2, 19, 0);
		tabCheck22[2].setPreferredSize(new Dimension(20,32));
		tabCheck22[2].setMargin(marge);
		tabCheck22[3].setPreferredSize(new Dimension(20,32));
		tabCheck22[3].setMargin(marge);
		tabCheck22[5].setPreferredSize(new Dimension(20,32));
		tabCheck22[5].setMargin(marge);
		
		containerT.setBackground(Color.white);
		containerT.setPreferredSize(new Dimension(800,310));
		
		containerT1.setBackground(Color.white);
		containerT1.setPreferredSize(new Dimension(350,310));
		containerT1.add(texteTitre3);
		containerT1.add(containerCB1);
		containerT1.add(containerCB12);
		
		containerT2.setBackground(Color.white);
		containerT2.setPreferredSize(new Dimension(350,310));
		containerT2.add(texteTitre4);
		containerT2.add(containerCB2);
		containerT2.add(containerCB22);
		
		containerT.add(containerT1);
		containerT.add(containerT2);
		
		container3.setBackground(Color.white);
		container3.setPreferredSize(new Dimension(800,40));
		
		JLabel texteTitre5 = new JLabel("Questions posees : ");
		scrollQPosees.setPreferredSize(new Dimension(380, 35));
		
		container3.add(texteTitre5);
		container3.add(scrollQPosees);
		
		partie2.add(containerT);
		partie2.add(container3);
		
		JLabel texteTitre6 = new JLabel("Résultat de l'évaluation de synthèse.");
		texteTitre6.setFont(new Font(null,Font.BOLD,15));
		texteTitre6.setPreferredSize(new Dimension(800,30));
		partie2.add(texteTitre6);
		
		containerE1.setBackground(Color.white);
		containerE1.setPreferredSize(new Dimension(290,150));
		containerE1.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel texteTitre7 = new JLabel("Premiere evaluation de synthese");
		texteTitre7.setPreferredSize(new Dimension(270,30));
		containerE1.add(texteTitre7);
		JLabel texteTitre72 = new JLabel("Fait le :");
		texteTitre72.setPreferredSize(new Dimension(50,15));
		containerE1.add(texteTitre72);
		
		dateNaissJ1 = new JComboBox();
		for(int i=1; i<10; i++) {
			dateNaissJ1.addItem("0"+i);
		}
		for(int i=10; i<32; i++) {
			dateNaissJ1.addItem(i);
		}
		dateNaissJ1.setPreferredSize(new Dimension(50, 20));
		dateNaissM1 = new JComboBox();
		for(int i=1; i<10; i++) {
			dateNaissM1.addItem("0"+i);
		}
		for(int i=10; i<13; i++) {
			dateNaissM1.addItem(i);
		}
		dateNaissM1.setPreferredSize(new Dimension(50, 20));
		dateNaissA1 = new JComboBox();
		for(int i=1900; i<2010; i++) {
			dateNaissA1.addItem(i);
		}
		dateNaissA1.setPreferredSize(new Dimension(70, 20));
		
		containerE1.add(dateNaissJ1);
		containerE1.add(dateNaissM1);
		containerE1.add(dateNaissA1);
		
		JLabel texteTitre73 = new JLabel("Nombre d'heures theorique :");
		texteTitre73.setPreferredSize(new Dimension(180,15));
		containerE1.add(texteTitre73);
		hTheo1 = new JComboBox();
		for(int i=1; i<=20; i++) {
			hTheo1.addItem(i);
		}
		hTheo1.setPreferredSize(new Dimension(50, 20));
		containerE1.add(hTheo1);
		
		JLabel texteTitre74 = new JLabel("Nombre d'heures pratique :");
		texteTitre74.setPreferredSize(new Dimension(180,15));
		containerE1.add(texteTitre74);
		hPra1 = new JComboBox();
		for(int i=1; i<=20; i++) {
			hPra1.addItem(i);
		}
		hPra1.setPreferredSize(new Dimension(50, 20));
		containerE1.add(hPra1);
		
		JLabel texteTitre75 = new JLabel("RESUTAT :");
		texteTitre75.setPreferredSize(new Dimension(80,25));
		containerE1.add(texteTitre75);
		result1 = new JComboBox();
		result1.addItem("A");
		result1.addItem("B");
		result1.setPreferredSize(new Dimension(50, 20));
		containerE1.add(result1);
		
		
		containerE2.setBackground(Color.white);
		containerE2.setPreferredSize(new Dimension(290,150));
		containerE2.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel texteTitre8 = new JLabel("Deuxieme evaluation de synthese");
		texteTitre8.setPreferredSize(new Dimension(270,30));
		containerE2.add(texteTitre8);
		JLabel texteTitre82 = new JLabel("Fait le :");
		texteTitre82.setPreferredSize(new Dimension(50,15));
		containerE2.add(texteTitre82);
		
		dateNaissJ2 = new JComboBox();
		for(int i=1; i<10; i++) {
			dateNaissJ2.addItem("0"+i);
		}
		for(int i=10; i<32; i++) {
			dateNaissJ2.addItem(i);
		}
		dateNaissJ2.setPreferredSize(new Dimension(50, 20));
		dateNaissM2 = new JComboBox();
		for(int i=1; i<10; i++) {
			dateNaissM2.addItem("0"+i);
		}
		for(int i=10; i<13; i++) {
			dateNaissM2.addItem(i);
		}
		dateNaissM2.setPreferredSize(new Dimension(50, 20));
		dateNaissA2 = new JComboBox();
		for(int i=1900; i<2010; i++) {
			dateNaissA2.addItem(i);
		}
		dateNaissA2.setPreferredSize(new Dimension(70, 20));
		
		containerE2.add(dateNaissJ2);
		containerE2.add(dateNaissM2);
		containerE2.add(dateNaissA2);
		
		JLabel texteTitre83 = new JLabel("Nombre d'heures theorique :");
		texteTitre83.setPreferredSize(new Dimension(180,15));
		containerE2.add(texteTitre83);
		hTheo2 = new JComboBox();
		for(int i=1; i<=20; i++) {
			hTheo2.addItem(i);
		}
		hTheo2.setPreferredSize(new Dimension(50, 20));
		containerE2.add(hTheo2);
		
		JLabel texteTitre84 = new JLabel("Nombre d'heures pratique :");
		texteTitre84.setPreferredSize(new Dimension(180,15));
		containerE2.add(texteTitre84);
		hPra2 = new JComboBox();
		for(int i=1; i<=20; i++) {
			hPra2.addItem(i);
		}
		hPra2.setPreferredSize(new Dimension(50, 20));
		containerE2.add(hPra2);
		
		JLabel texteTitre85 = new JLabel("RESUTAT :");
		texteTitre85.setPreferredSize(new Dimension(80,25));
		containerE2.add(texteTitre85);
		result2 = new JComboBox();
		result2.addItem("A");
		result2.addItem("B");
		result2.setPreferredSize(new Dimension(50, 20));
		containerE2.add(result2);
		
		containerE3.setBackground(Color.white);
		containerE3.setPreferredSize(new Dimension(290,150));
		containerE3.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel texteTitre9 = new JLabel("Evaluation de controle");
		texteTitre9.setPreferredSize(new Dimension(270,30));
		containerE3.add(texteTitre9);
		JLabel texteTitre92 = new JLabel("Fait le :");
		texteTitre92.setPreferredSize(new Dimension(50,15));
		containerE3.add(texteTitre92);
		
		dateNaissJ3 = new JComboBox();
		for(int i=1; i<10; i++) {
			dateNaissJ3.addItem("0"+i);
		}
		for(int i=10; i<32; i++) {
			dateNaissJ3.addItem(i);
		}
		dateNaissJ3.setPreferredSize(new Dimension(50, 20));
		dateNaissM3 = new JComboBox();
		for(int i=1; i<10; i++) {
			dateNaissM3.addItem("0"+i);
		}
		for(int i=10; i<13; i++) {
			dateNaissM3.addItem(i);
		}
		dateNaissM3.setPreferredSize(new Dimension(50, 20));
		dateNaissA3 = new JComboBox();
		for(int i=1900; i<2010; i++) {
			dateNaissA3.addItem(i);
		}
		dateNaissA3.setPreferredSize(new Dimension(70, 20));
		
		containerE3.add(dateNaissJ3);
		containerE3.add(dateNaissM3);
		containerE3.add(dateNaissA3);
		
		JLabel texteTitre93 = new JLabel("Par :");
		texteTitre93.setPreferredSize(new Dimension(40,15));
		containerE3.add(texteTitre93);
		nomMoniteur = new JComboBox();
		nomMoniteur.setPreferredSize(new Dimension(200, 20));
		containerE3.add(nomMoniteur);
		
		JLabel texteTitre95 = new JLabel("RESUTAT :");
		texteTitre95.setPreferredSize(new Dimension(80,35));
		containerE3.add(texteTitre95);
		result3 = new JComboBox();
		result3.addItem("A");
		result3.addItem("B");
		result3.setPreferredSize(new Dimension(50, 20));
		containerE3.add(result3);
		
		containerE.setBackground(Color.white);
		containerE.setPreferredSize(new Dimension(890,200));
		
		containerE.add(containerE1);
		containerE.add(containerE2);
		containerE.add(containerE3);
		
		partie2.add(containerE);
	}
	
}              