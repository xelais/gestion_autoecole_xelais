package vue;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;


public class InteroOrale extends JPanel {

	private JLabel texteTitre = new JLabel();
	
	private String questions[][] = new String[3][38];
	
	public InteroOrale(){

		this.setPreferredSize(new Dimension(900,680));
		
		texteTitre = new JLabel("Interrogation Orale V2 (Exterieur du vehicule)");
		texteTitre.setFont(new Font(null,Font.BOLD,20));
		texteTitre.setPreferredSize(new Dimension(800,50));
		
		this.add(texteTitre);
		
		JTabbedPane onglet = new JTabbedPane();
		JPanel partie1 = new JPanel();
		JPanel partie2 = new JPanel();
		partie1.setPreferredSize(new Dimension(880,600));
		partie2.setPreferredSize(new Dimension(880,600));
		partie1.setBackground(Color.white);
		partie2.setBackground(Color.white);
		onglet.add(partie1, "Questions non-traitees ou avec erreurs");
		onglet.add(partie2, "Questions traitees");
		
		this.add(onglet);
		
		partie1.add(texteTitre);
		
		
		for(int j=0; j<questions[0].length; j++) {
			for(int i=0; i<2; i++) {
				questions[i][j] = null;
			}
			questions[2][j] = "0";
		}
		
		for(int i=0; i<6; i++)
			questions[0][i] = "FEUX ARRIeRE";
		for(int i=6; i<12; i++)
			questions[0][i] = "CLIGNOTANTS";
		for(int i=12; i<15; i++)
			questions[0][i] = "IMMATRICULATION";
		for(int i=12; i<15; i++)
			questions[0][i] = "PNEUMATIQUES";
		for(int i=15; i<22; i++)
			questions[0][i] = "NIVEAUX";
		for(int i=22; i<33; i++)
			questions[0][i] = "BATTERIE";
		for(int i=33; i<38; i++)
			questions[0][i] = "DIVERS";
		
		questions[1][0]="Contrelez l'etat, la proprete et le fonctionnement des feux de stop (avec l'assistance de l'accompagnateur). Quelle est la consequence en cas de panne des feux stop ?";
		questions[1][1]="Contrelez l'etat, la proprete et le fonctionnement des feux de stop (avec l'assistance de l'accompagnateur). Quelle est leur utilite ?";
		questions[1][2]="Contrelez l'etat, la proprete et le fonctionnement du ou des feux de brouillard arriere. Dans quels cas les utilise-t-on ?";
		questions[1][3]="Contrelez l'etat, la proprete et la fonctionnement du ou des feux de brouillard arriere. Peut-on les utiliser par temps de pluie ?";
		questions[1][4]="Contrelez l'etat, la proprete et le fonctionnement du ou des feux de marche arriere. A quoi servent-ils ?";
		questions[1][5]="Montrez l'emplacement oe s'effectue le changement des ampoules sur un des deux feux e l'arriere du vehicule. Quelle est la precaution a prendre pour manipuler une ampoule halogene ?";
		questions[1][6]="Contrelez l'etat, la proprete et le fonctionnement du clignotant droit. y compris les repetiteurs lateraux s'ils existent. Quand les utilise-t-on ?";
		questions[1][7]="Contrelez l'etat, la proprete et le fonctionnement du clignotant droit, y compris les repeteurs lateraux s'ils existent. Quelle est la signification de l'augmentation de la frequence de clignotement au niveau du feu et du voyant au tableau de bord ?";
		questions[1][8]="Contrelez l'etat, la proprete et le fonctionnement du clignotant gauche, y compris les repetiteurs lateraux s'ils existent. Quand les utilise-t-on ?";
		questions[1][9]="Contrelez l'etat, la proprete et le fonctionnement du clignotant gauche, y compris les repetiteurs lateraux s'ils existent. Quelle est la signification de l'augmentation de la frequence de clignotement au niveau du feu et du voyant au tableau de bord ?";
		questions[1][10]="Contrelez l'etat, la proprete et le fonctionnement des feux de detresse, e l'avant et e l'arriere du vehicule. Quand les utilise-t-on ?";
		questions[1][11]="Contrelez l'etat, la proprete et le fonctionnement des feux de detresse, e l'avant et a l'arriere du vehicule. Quelle est la signification de l'augmentation de la frequence de clignotement au niveau du feu et du voyant au tableau de bord ?";
		questions[1][12]="Verifiez l'etat de la proprete des plaques d'immatriculation et des dispositifs reflechissant (catadioptres). Quelle est l'utilite des dispositifs reflechissants ?";
		questions[1][13]="Verifiez l'etat de la proprete des plaques d'immatriculation et des dispositifs reflechissant (catadioptres). Quel dispositif est obligatoire pour rendre la plaque immatriculation arriere lisible, la nuit ?";
		questions[1][14]="Verifiez l'etat de la proprete des plaques d'immatriculation et des dispositifs reflechissant (catadioptres). Une plaque d'immatriculation arriere e fond blanc est-t-elle autorisee ?";
		questions[1][15]="Contrelez le flanc exterieur sur l'un des pneumatiques avant. En regle generale, dans quelle condition devez-vous contreler la pression ?";
		questions[1][16]="Contrelez le flanc exterieur sur l'un des pneumatiques avant. Quelle peut etre la consequence d'un defaut de parallelisme sur les pneumatiques ?";
		questions[1][17]="Contrelez le flanc exterieur sur l'un des pneumatiques avant. Qu'est-ce que l'aquaplanage et quelle peut etre sa consequence ?";
		questions[1][18]="Contrelez le flanc exterieur sur l'un des pneumatiques arriere. Qu'est-ce que l'aquaplanage et quelle peut etre sa consequence ?";
		questions[1][19]="Contrelez le flanc exterieur sur l'un des pneumatiques arriere. A l'aide de la notice d'utilisation ou de la plaque indicative situee sur le vehicule, indiquez les pressions preconisees pour ce vehicule ?";
		questions[1][20]="Montrez une valve de gonflage d'un pneumatique. Quelles sont les verifications e effectuer au niveau des flancs d'un pneumatique ?";
		questions[1][21]="Montrez oe se trouve la roue de secours (ou en son absente la bombe anticrevaison) dans le vehicule. Pourquoi devez-vous verifier regulierement l'etat et la pression des pneumatiques ?";
		questions[1][22]="Montrez l'orifice de remplissage de l'huile du moteur. Quel est le principal risque d'un manque d'huile moteur ?";
		questions[1][23]="Montrez l'orifice de remplissage de l'huile moteur. Avec quel fluide completez-vous le niveau si necessaire ?";
		questions[1][24]="Montrez oe doit s'effectuer le contrele du niveau d'huile moteur. Oe doit se situer le niveau de l'huile ?";
		questions[1][25]="Montrez oe doit s'effectuer le contrele du niveau d'huile moteur. En general, dans quelles conditions effectuez-vous cette operation ?";
		questions[1][26]="Montrez oe doit s'effectuer le contrele du niveau du liquide de frein. Quel est le principal risque d'un defaut d'entretien relatif au liquide de frein ?";
		questions[1][27]="Montrez oe doit s'effectuer le contrele du niveau du liquide de frein. Que faire en cas de baisse importante du niveau de liquide de frein ?";
		questions[1][28]="Montrez oe doit s'effectuer le contrele du niveau du liquide de refroidissement. Quel est le danger si l'on effectue ce contrele avec moteur chaud ?";
		questions[1][29]="Montrez oe doit s'effectuer le contrele du niveau du liquide de refroidissement. Quelle est la principale consequence d'un manque de liquide de refroidissement ?";
		questions[1][30]="Montrez oe doit s'effectuer le contrele du niveau de liquide d'assistance de direction. Quelle est la principale consequence d'un manque de liquide d'assistance de direction ?";
		questions[1][31]="Montrez oe doit s'effectuer le contrele du niveau du liquide d'assistance de direction. Que faire en cas de baisse importante du niveau de liquide d'assistance de direction ?";
		questions[1][32]="Montrez l'orifice de remplissage du produit lave-glace. Pourquoi est-il preferable d'utiliser un liquide special en hiver ?";
		questions[1][33]="Montrez oe se trouve la batterie du vehicule. Qu'est-ce qui peut provoquer la decharge d'une batterie ?";
		questions[1][34]="Montrez oe se trouve la batterie du vehicule. Quelle est la solution en cas de panne de batterie pour demarrer le vehicule sans le deplacer ?";
		questions[1][35]="Indiquez oe se situe la \"securite enfants\" sur l'une des portiere arriere du vehicule. En regle generale, oe doit etre place un passager de moins de 10 ans ?";
		questions[1][36]="Ouvrez la trappe a carburant et/ou verifiez la bonne fermeture du bouchon. Quelles sont les precautions a prendre lors du remplissage du reservoir ?";
		questions[1][37]="Verifiez le contenu du coffre. Lorsque vous transportez un poids important dans le coffre de votre vehicule, quelles sont les precautions a prendre ?";

	}

}              