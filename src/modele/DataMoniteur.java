package modele;

import java.sql.SQLException;

import net.ko.creator.KernelCreator;
import net.ko.kobject.KListObject;
import net.ko.ksql.KDBMysql;
import KClass.KMoniteur;

public class DataMoniteur {

	private KDBMysql db = new KDBMysql("localhost","admin","admin","autoecole");
	
	public DataMoniteur(){
	   
		connexion();
	}
	
public void connexion(){
		
		
		try {
			db.connect();
			KernelCreator knl = new KernelCreator();
			knl.connect(db);
			knl.createClasses();
			knl.saveAs("KClass");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("ça marche pas");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("ça marche pas");
		}
	}
	
public KListObject<KMoniteur> recupererListe() {
		
		KListObject<KMoniteur> Kliste = new KListObject<KMoniteur>(KMoniteur.class);
		Kliste.loadFromDb(db);
		
		return Kliste;
		
	}

public KMoniteur recupererProfilMoniteur (int id){
	
	KMoniteur moniteur = new KMoniteur();
	moniteur.setId(id);
	try {
		moniteur.loadOne(db);
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchFieldException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return moniteur;
}
	
	public KMoniteur ajouterMoniteur (String nom, String Prenom, int id) {
		
		KMoniteur moniteur = new KMoniteur();
		moniteur.setId(id);
		moniteur.setPRENOM_MONITEUR(Prenom);
		moniteur.setNOM_MONITEUR(nom);
		moniteur.add(db);
		
		return moniteur;
		
	}
	
	public void supprimerMoniteur(Object id) {
		
		KMoniteur moniteur = new KMoniteur();
		moniteur.setId(id);
	
		try {
			moniteur.loadOne(db);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(moniteur);
		moniteur.delete(db);
		
		
		
	}



	public KMoniteur majMoniteur(String nom,String prenom, Object id) {
		
		KMoniteur moniteur = new KMoniteur();
		moniteur.setId(id);
	
		try {
			moniteur.loadOne(db);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moniteur.setNOM_MONITEUR(nom);
		moniteur.setPRENOM_MONITEUR(prenom);
		moniteur.update(db);
		
		return moniteur;
		
	}
	
}              