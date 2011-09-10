package controleur;
import vue.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EcouteurPrincipale implements ActionListener, MouseListener {
	
	private FenetrePrincipale fenetre;
	int index;
	
	public EcouteurPrincipale(FenetrePrincipale f) {
		fenetre = f;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fenetre.getBoutonFicheE()) {
			fenetre.getFicheEleve().setVisible(true);
			fenetre.getEtape1().setVisible(false);
			fenetre.getEtape2().setVisible(false);
			fenetre.getEtape3().setVisible(false);
			fenetre.getEtape4().setVisible(false);
			fenetre.getIntero().setVisible(false);
			fenetre.getExamB().setVisible(false);
		}
		else if(e.getSource() == fenetre.getBoutonEtape1()) {
			fenetre.getFicheEleve().setVisible(false);
			fenetre.getEtape1().setVisible(true);
			fenetre.getEtape2().setVisible(false);
			fenetre.getEtape3().setVisible(false);
			fenetre.getEtape4().setVisible(false);
			fenetre.getIntero().setVisible(false);
			fenetre.getExamB().setVisible(false);
		}
		else if(e.getSource() == fenetre.getBoutonEtape2()) {
			fenetre.getFicheEleve().setVisible(false);
			fenetre.getEtape1().setVisible(false);
			fenetre.getEtape2().setVisible(true);
			fenetre.getEtape3().setVisible(false);
			fenetre.getEtape4().setVisible(false);
			fenetre.getIntero().setVisible(false);
			fenetre.getExamB().setVisible(false);
		}
		else if(e.getSource() == fenetre.getBoutonEtape3()) {
			fenetre.getFicheEleve().setVisible(false);
			fenetre.getEtape1().setVisible(false);
			fenetre.getEtape2().setVisible(false);
			fenetre.getEtape3().setVisible(true);
			fenetre.getEtape4().setVisible(false);
			fenetre.getIntero().setVisible(false);
			fenetre.getExamB().setVisible(false);
		}
		else if(e.getSource() == fenetre.getBoutonEtape4()) {
			fenetre.getFicheEleve().setVisible(false);
			fenetre.getEtape1().setVisible(false);
			fenetre.getEtape2().setVisible(false);
			fenetre.getEtape3().setVisible(false);
			fenetre.getEtape4().setVisible(true);
			fenetre.getIntero().setVisible(false);
			fenetre.getExamB().setVisible(false);
		}
		else if(e.getSource() == fenetre.getBoutonIntero()) {
			fenetre.getFicheEleve().setVisible(false);
			fenetre.getEtape1().setVisible(false);
			fenetre.getEtape2().setVisible(false);
			fenetre.getEtape3().setVisible(false);
			fenetre.getEtape4().setVisible(false);
			fenetre.getIntero().setVisible(true);
			fenetre.getExamB().setVisible(false);
		}
		else if(e.getSource() == fenetre.getBoutonExamB()) {
			fenetre.getFicheEleve().setVisible(false);
			fenetre.getEtape1().setVisible(false);
			fenetre.getEtape2().setVisible(false);
			fenetre.getEtape3().setVisible(false);
			fenetre.getEtape4().setVisible(false);
			fenetre.getIntero().setVisible(false);
			fenetre.getExamB().setVisible(true);
		}
		else if(e.getSource() == fenetre.getBoutonAnnuler()) {
			fenetre.getFicheEleve().chargerDonnees(index+1);
			
			fenetre.getFicheEleve().setVisible(false);
			fenetre.getEtape1().setVisible(false);
			fenetre.getEtape2().setVisible(false);
			fenetre.getEtape3().setVisible(false);
			fenetre.getEtape4().setVisible(false);
			fenetre.getIntero().setVisible(false);
			fenetre.getExamB().setVisible(false);
			fenetre.getBoutonFicheE().setEnabled(true);
			fenetre.getBoutonEtape1().setEnabled(true);
			fenetre.getBoutonEtape2().setEnabled(true);
			fenetre.getBoutonEtape3().setEnabled(true);
			fenetre.getBoutonEtape4().setEnabled(true);
			fenetre.getBoutonIntero().setEnabled(true);
			fenetre.getBoutonExamB().setEnabled(true);
			fenetre.getBoutonValider().setEnabled(true);
			fenetre.getBoutonAnnuler().setEnabled(true);
		}
		else if(e.getSource() == fenetre.getBoutonValider()) {
			
		}
		else if(e.getSource() == fenetre.getRechercheE()) {
			fenetre.getListeEleves().setListData(fenetre.getTabEleve());
			String val = fenetre.getRechercheE().getText();
			int tailleL = fenetre.getListeEleves().getModel().getSize();
			String tabEleveP[] = new String[tailleL];
			int curs = 0;
			for(int i=0; i<tailleL; i++) {
				String valListe = fenetre.getListeEleves().getModel().getElementAt(i).toString();
				if(valListe.toUpperCase().indexOf(val)!=-1 || valListe.toUpperCase().indexOf(val.toUpperCase())!=-1){
					tabEleveP[curs] = valListe;
					curs++;
				}
			}
			String tabEleve[] = new String[curs];
			for(int i=0; i<curs; i++)
				tabEleve[i] = tabEleveP[i];
			fenetre.getListeEleves().setListData(tabEleve);
		}
		else if(e.getSource() == fenetre.getQuitter()) {
			System.exit(0);

		}
		else if(e.getSource() == fenetre.getGestionM()) {
			FenetreMoniteur fenetreM = new FenetreMoniteur();
            fenetreM.setVisible(true);
		}
		else if(e.getSource() == fenetre.getBoutonAjouterE()) {			
			fenetre.getFicheEleve().chargerDonnees(-1);
			
			fenetre.getFicheEleve().setVisible(true);
			fenetre.getEtape1().setVisible(false);
			fenetre.getEtape2().setVisible(false);
			fenetre.getEtape3().setVisible(false);
			fenetre.getEtape4().setVisible(false);
			fenetre.getIntero().setVisible(false);
			fenetre.getExamB().setVisible(false);
			fenetre.getBoutonFicheE().setEnabled(true);
			fenetre.getBoutonEtape1().setEnabled(true);
			fenetre.getBoutonEtape2().setEnabled(true);
			fenetre.getBoutonEtape3().setEnabled(true);
			fenetre.getBoutonEtape4().setEnabled(true);
			fenetre.getBoutonIntero().setEnabled(true);
			fenetre.getBoutonExamB().setEnabled(true);
			fenetre.getBoutonValider().setEnabled(true);
			fenetre.getBoutonAnnuler().setEnabled(true);
		}
		
	}

	public void mouseClicked(MouseEvent e) {
		
		
	}

	public void mouseEntered(MouseEvent e) {
		
		
	}

	public void mouseExited(MouseEvent e) {
		
		
	}

	public void mousePressed(MouseEvent e) {
		
		
	}

	public void mouseReleased(MouseEvent e) {
		if(e.getSource()==fenetre.getListeEleves() && e.getClickCount()==2) {
			index = fenetre.getListeEleves().getSelectedIndex();
			fenetre.getFicheEleve().setIdEleve(index+1);
			System.out.println(fenetre.getListeEleves().getModel().getElementAt(index));
			fenetre.getFicheEleve().chargerDonnees(index+1);
			
			fenetre.getFicheEleve().setVisible(true);
			fenetre.getEtape1().setVisible(false);
			fenetre.getEtape2().setVisible(false);
			fenetre.getEtape3().setVisible(false);
			fenetre.getEtape4().setVisible(false);
			fenetre.getIntero().setVisible(false);
			fenetre.getExamB().setVisible(false);
			fenetre.getBoutonFicheE().setEnabled(true);
			fenetre.getBoutonEtape1().setEnabled(true);
			fenetre.getBoutonEtape2().setEnabled(true);
			fenetre.getBoutonEtape3().setEnabled(true);
			fenetre.getBoutonEtape4().setEnabled(true);
			fenetre.getBoutonIntero().setEnabled(true);
			fenetre.getBoutonExamB().setEnabled(true);
			fenetre.getBoutonValider().setEnabled(true);
			fenetre.getBoutonAnnuler().setEnabled(true);
		}
	}

	public String dateFormatSQL(String d) {
		String r;
		r = d.substring(6, 10);
		r = r + "-" + d.substring(3, 5);
		r = r + "-" + d.substring(0, 2);
		System.out.println(r);
		return r;
	}
	
}
