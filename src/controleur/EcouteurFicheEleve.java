package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

import vue.CellEditorAera;
import vue.CellRenderAera;
import vue.FicheEleve;
import vue.TableModel2;

public class EcouteurFicheEleve implements ActionListener{
	
	FicheEleve f;

	public EcouteurFicheEleve(FicheEleve fiche) {
		f = fiche;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==f.getBoutonAjouter()) {
			f.ajouterLigneJtableVierge();
			f.getzModel().miseAjour(f.getListeFormation());
			f.setzModel(new TableModel2(f.getListeFormation(), f.getTitleTableauJtable()));
			f.getTableau().setModel(f.getzModel());
			f.definirJtableGraphique();
		}
	}

}
