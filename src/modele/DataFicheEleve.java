package modele;

import java.util.ArrayList;

public class DataFicheEleve {
	int numEleve;
	private String nom = null;
	private String prenom = null;
	private String dateNaiss = null;
	private String adresse = null;
	private String codePostal = null;
	private String communeEleve = null;
	private String telephone = null;
	private String eMail = null;
	private String profession = null;
	private String dateEva = null;
	private String resultatEva = null;
	private String formaTheo = null;
	private String formaPra = null;
	private String inscription = null;
	private String enregistrement = null;
	private String numLivret = null;
	private String responsableForma = null;
	private String formateur = null;
	private boolean testVue = false;
	private String testVueCom = null;
	
	ArrayList<String> tabErreur = new ArrayList<String>();
		
	ArrayList<String> listeFormation[];
	
	public DataFicheEleve(int numEleve, String nom,String prenom,String dateNaissJ,String dateNaissM,String dateNaissA,
			String adresse,String codePostal,String communeEleve,String telephone,String eMail,
			String profession,String dateEvaJ,String dateEvaM,String dateEvaA,String resultatEva,String formaTheo,
			String formaPra,String dateInscriJ,String dateInscriM,String dateInscriA,String dateEnregiJ, 
			String dateEnregiM,String dateEnregiA,String numLivret,String responsableForma,
			String formateur,boolean testVue,String testVueCom,ArrayList[] listeFormation){
		
		this.numEleve = numEleve;
		
		//Tests effectués
		if(lettres(nom) && nom.equals("")==false) this.nom = nom;
		else tabErreur.add("Nom");
		if(lettres(prenom) && prenom.equals("")==false) this.prenom = prenom;
		else tabErreur.add("Prénom");
		/*if(chiffreslettres(adresse))*/ this.adresse = adresse;
		//else tabErreur.add("Adresse");
		if(chiffres(codePostal))this.codePostal = codePostal;
		else tabErreur.add("Code Postal");
		if(lettres(communeEleve))this.communeEleve = communeEleve;
		else tabErreur.add("Commune Eleve");
		if((chiffres(telephone) && telephone.length()==10) || telephone.equals("")) this.telephone = telephone;
		else tabErreur.add("Tel");
		if(email(eMail))this.eMail = eMail;
		else tabErreur.add("E-Mail");
		if(lettres(profession))this.profession = profession;
		else tabErreur.add("Profession");
		
			//Formatage dateNaiss en JJ/MM/AAAA
		dateNaiss = creerDate(dateNaissJ, dateNaissM, dateNaissA);
		//if(!date(dateNaiss)) tabErreur.add("Date de Naissance");              
        dateEva = creerDate(dateEvaJ,dateEvaM,dateEvaA);
        //if(!date(dateEva)) tabErreur.add("Date d'évaluation");
		inscription = creerDate(dateInscriJ,dateInscriM,dateInscriA);
        //if(!date(inscription)) tabErreur.add("Inscription");
		enregistrement = creerDate(dateEnregiJ,dateEnregiM,dateEnregiA);
        //if(!date(enregistrement)) tabErreur.add("Enregistrement");			
		
		//test à faire sur le numéro de livret (n°N.E.P.H) (inconnu pour le moment)
		this.numLivret = numLivret;
				
		//Pas de test à faire
		this.resultatEva = resultatEva;
		this.formaTheo = formaTheo;
		this.formaPra = formaPra;
		this.testVue = testVue;
		this.testVueCom = testVueCom;
		
		//Pas de tests à faire mais liste déroulante à faire
		this.responsableForma = responsableForma;
		this.formateur = formateur;
		
		
		this.listeFormation =  listeFormation;
	}
	
	public DataFicheEleve(String text, String text2, Object selectedItem,
			String selectedItem2, String selectedItem3, String text3,
			String text4, String text5, String text6, String text7,
			String text8, String text9, String selectedItem4,
			String selectedItem5, String selectedItem6, String text10,
			String text11, String text12, String text13, String text14,
			String text15, String text16, String text17, boolean testVue2,
			String text18, String[][] tabFormation2) {
	}

	public boolean verifierSaisieNom() {
		if(nom == null) return false;
		else return true;
	}
	public boolean verifierSaisiePrenom() {
		if(prenom == null) return false;
		else return true;
	}
	public boolean verifierSaisie() {
		if(nom == null) return false;
		else return true;
	}
	
	//Methode-Test 1 : champs nom, prenom, communeEleve, profession
	//Methode-Test1 : champs nom, prénom, communeEleve, profession
	public boolean lettres(String ch) {
		if (ch.equals("")) return true;
		boolean b = false;
		String tab = "azertyuiopqsdfghjklmwxcvbnéàè'-èç";
		for(int i=0; i<ch.length(); i++) {
			for(int j=0; j<tab.length(); j++) {
				if(ch.charAt(i)==tab.charAt(j)) b = true;
				else if(ch.charAt(i)==tab.toUpperCase().charAt(j)) 
						b = true;
			}
			if(b==false) {
				return b;
			}
			b=false;
		}
		return true;
	}
	//Methode-Test 2 : champs email
	//Methode-Test2 : champs email
	public boolean email(String ch) {
		if (ch.equals("")) return true;
		boolean b = false;
		String tab = "azertyuiopqsdfghjklmwxcvbn@.";
		for(int i=0; i<ch.length(); i++) {
			for(int j=0; j<tab.length(); j++) {
				if(ch.charAt(i)==tab.charAt(j)) b = true;
				else if(ch.charAt(i)==tab.toUpperCase().charAt(j)) 
						b = true;
			}
			if(b==false) {
				return b;
			}
			b=false;
		}
		return true;
	}
	//Methode-Test 3 : champs codepostal, telephoneF, telephoneM
	//Methode-Test3 : champs code postal, telephoneF, telephoneM
	public boolean chiffres(String ch) {
		if (ch.equals("")) return true;
		try {
			//int i = Integer.parseInt(ch);
			return true;
			}
		catch (Exception e) {
			return false;
		}
	}
	//Methode-Test 4 : champs adresse
	//Methode-Test4 : champs adresse
	public boolean chiffreslettres(String ch) {
		if (ch.equals("")) return true;
		boolean b = false;
		String tab = "azertyuiopqsdfghjklmwxcvbnéàè'-èç0123456789";
		for(int i=0; i<ch.length(); i++) {
			for(int j=0; j<tab.length(); j++) {
				if(ch.charAt(i)==tab.charAt(j)) b = true;
				else if(ch.charAt(i)==tab.toUpperCase().charAt(j)) 
						b = true;
			}
			if(b==false) {
				return b;
			}
			b=false;
		}
		return true;
	}
	//Methode-Test 5 : vérifie validité d'une date au format JJ/MM/AAAA
	//Methode-Test5 : champs dateNaiss
	public boolean date(String ch) {
     	boolean bool = false;
         String date_finale;
         String jour;
         String mois;
         String annee;
         jour = ch.substring(0, 1) + ch.substring(1, 2);
         mois = ch.substring(3, 4) + ch.substring(4, 5);
         annee = ch.substring(6, 7) + ch.substring(7, 8) + ch.substring(8, 9) + ch.substring(9, 10);
  
         date_finale = jour + "/" + mois + "/" + annee;
         String DatePattern = "^(?:(31)(\\D)(0?[13578]|1[02])\\2|(29|30)(\\D)(0?[13-9]|1[0-2])\\5|(0?[1-9]|1\\d|2[0-8])(\\D)(0?[1-9]|1[0-2])\\8)((?:1[6-9]|[2-9]\\d)?\\d{2})$|^(29)(\\D)(0?2)\\12((?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:16|[2468][048]|[3579][26])00)$";
         if(date_finale.matches(DatePattern)) bool = true;
         return bool;
     }
	
	
	public ArrayList<String> getTabErreur() {
		return tabErreur;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public int getNumEleve() {
		return numEleve;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public String getCommuneEleve() {
		return communeEleve;
	}
	public String getDateEva() {
		return dateEva;
	}
	public String getDateNaiss() {
		return dateNaiss;
	}
	public String geteMail() {
		return eMail;
	}
	public String getEnregistrement() {
		return enregistrement;
	}
	public String getFormaPra() {
		return formaPra;
	}
	public String getFormateur() {
		return formateur;
	}
	public String getFormaTheo() {
		return formaTheo;
	}
	public String getInscription() {
		return inscription;
	}
	public ArrayList[] getListeFormation() {
		return listeFormation;
	}
	public String getNumLivret() {
		return numLivret;
	}
	public String getProfession() {
		return profession;
	}
	public String getResponsableForma() {
		return responsableForma;
	}
	public String getResultatEva() {
		return resultatEva;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getTestVueCom() {
		return testVueCom;
	}
	public boolean isTestVue() {
		return testVue;
	}
	
	//Methode-Affichage
	public void afficher() {
		System.out.println(nom+"-- "+prenom+"-- "+dateNaiss+"-- "+adresse+"-- "+codePostal+"-- "+communeEleve+"-- "+
				telephone+"-- "+eMail+"-- "+profession+"-- "+dateEva+"-- "+resultatEva+"-- "+formaTheo+"-- "+formaPra+"-- "+inscription+"-- "+
				enregistrement+"-- "+numLivret+"-- "+responsableForma+"-- "+formateur+"-- "+testVue+"-- "+testVueCom);
		System.out.println("");
		for(int i=0; i<listeFormation[0].size(); i++)
			System.out.println(listeFormation[0].get(i));
	}
	
	public String creerDate(String j, String m, String a) {
		if(j.length()==1) j = "0"+j;
		if(m.length()==1) m = "0"+m;
		
		String date = j+"/"+m+"/"+a;
		if(date.length()==10)
			return date;
		else
			return null;
	}

}
