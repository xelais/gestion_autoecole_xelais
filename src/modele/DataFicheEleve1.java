package modele;

import java.sql.SQLException;

import sun.nio.cs.KOI8_U;

import net.ko.creator.KernelCreator;
import net.ko.kobject.KListObject;
import net.ko.kobject.KObject;
import net.ko.ksql.KDBMysql;
import KClass.KEleve;
import KClass.KMoniteur;


public class DataFicheEleve1 {

	private KDBMysql db = new KDBMysql("localhost", "admin", "admin","autoecole");

	public DataFicheEleve1() {
		connexion();
	}

	public void connexion() {

		try {
			db.connect();
			KernelCreator knl = new KernelCreator();
			knl.connect(db);
			knl.createClasses();
			knl.saveAs("KClass");
			System.out.println("Connexion à "+db.getBaseName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Echec de la connexion");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Echec de la connexion");
		}
	}

	public KListObject<KEleve> recupererListe() {

		KListObject<KEleve> Kliste = new KListObject<KEleve>(KEleve.class);
		Kliste.loadFromDb(db);

		return Kliste;

	}
	
	public KEleve recupererProfil(int id) {
	
		KEleve Eleve = new KEleve();
		Eleve.setId(id);
	
		try {
			Eleve.loadOne(db);
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
		
		return Eleve;
		
	}
	
	
	
	
	

}