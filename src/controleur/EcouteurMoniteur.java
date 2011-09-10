package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import modele.DataMoniteur;
import vue.*;

public class EcouteurMoniteur implements MouseListener, ActionListener,DocumentListener {

	 private FenetreMoniteur f;
	int index = -1;
	//boolean modif = false;
	private DataMoniteur moniteur = new DataMoniteur();
	
	public EcouteurMoniteur(FenetreMoniteur f) {
		this.f = f;
	}

	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
	}
			
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		if(e.getSource() == f.getListeMoni() && e.getClickCount()==2) {
			index = f.getListeMoni().getSelectedIndex();
			String s = f.getListeMoni().getModel().getElementAt(index).toString();
			String nom, prenom;
			int i = 0;
			while ( i < s.length() && s.charAt(i)!=' ') {
				i++;
			}
			if(i == s.length()) {
				nom = s;
				prenom = "";
			}
			else {
				nom = s.substring(0, i);
				prenom = s.substring(i+1, s.length());
			}
			f.getNom().setText(nom);
			f.getPrenom().setText(prenom);
			//f.getTextAjout().setText("Ajout / Modification d'un Moniteur");
			//f.getAjouter().setText("Ok");
			//f.getEffacer().setText("Supprimer Moniteur");
			//System.out.println(index);
			f.getAjouter().setEnabled(false);
			f.getEffacer().setEnabled(true);
			f.getMaj().setEnabled(true);
			
			//modif = true;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == f.getEffacer()) {
			moniteur.supprimerMoniteur(f.getKListe().get( f.getListeMoni().getSelectedIndex()).getId());
			for (int i = 0; i< f.getKListe().count(); i++){
				f.getKListe().remove(f.getKListe().get(i));
			}
			f.setKListe(moniteur.recupererListe());
			f.getListeMemMoni().removeAll(f.getListeMemMoni());
			for (int i = 0; i< f.getKListe().count(); i++){
			f.getListeMemMoni().add(f.getKListe().get(i).getPRENOM_MONITEUR().toLowerCase()+" "+f.getKListe().get(i).getNOM_MONITEUR().toUpperCase());
			}
			f.getListeMoni().setListData(f.getListeMemMoni().toArray());
			
		}else if(e.getSource() == f.getAjouter()) {
			
			if((f.getNom().getText().equals(""))||(f.getPrenom().getText().equals("") )){new JOptionPane().showMessageDialog(null, "Un champ blanc ne peut être inséré", "Erreur",JOptionPane.ERROR_MESSAGE); }
			
			else{
				moniteur.ajouterMoniteur(f.getNom().getText(), f.getPrenom().getText(), f.getKListe().count()+1);
				}
				for (int i = 0; i< f.getKListe().count(); i++){
					f.getKListe().remove(f.getKListe().get(i));
					}
				f.setKListe(moniteur.recupererListe());
				f.getListeMemMoni().removeAll(f.getListeMemMoni());
				for (int i = 0; i< f.getKListe().count(); i++){
				f.getListeMemMoni().add(f.getKListe().get(i).getPRENOM_MONITEUR().toLowerCase()+" "+f.getKListe().get(i).getNOM_MONITEUR().toUpperCase());
				f.getListeMoni().setListData(f.getListeMemMoni().toArray());
			}	
			
			
		}else if(e.getSource() == f.getMaj()) {
			
			moniteur.majMoniteur(f.getNom().getText(), f.getPrenom().getText(), f.getKListe().get( f.getListeMoni().getSelectedIndex()).getId());
			for (int i = 0; i< f.getKListe().count(); i++){
				f.getKListe().remove(f.getKListe().get(i));
			}
			f.setKListe(moniteur.recupererListe());
			f.getListeMemMoni().removeAll(f.getListeMemMoni());
			for (int i = 0; i< f.getKListe().count(); i++){
			f.getListeMemMoni().add(f.getKListe().get(i).getPRENOM_MONITEUR().toLowerCase()+" "+f.getKListe().get(i).getNOM_MONITEUR().toUpperCase());
			}
			f.getListeMoni().setListData(f.getListeMemMoni().toArray());
		}
		
		else if(e.getSource() == f.getReinitialiser()){
			f.getNom().setText("");
			f.getPrenom().setText("");
			f.getAjouter().setEnabled(false);
			f.getEffacer().setEnabled(false);
			f.getMaj().setEnabled(false);
		}
		
	}

	//méthode automatiquement généré par DocumentListener.
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		f.getAjouter().setEnabled(true);
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		handleTextField(arg0);
		
	}
	
	public boolean handleTextField (DocumentEvent e){
		if ((e.getDocument().getLength()<=0)){
			f.getAjouter().setEnabled(false);
			return true;
		}
		return false;
		
	}
	
	public void changeUpdate (DocumentEvent e){
		if(!handleTextField(e)){f.getAjouter().setEnabled(true);}
	}
	
}