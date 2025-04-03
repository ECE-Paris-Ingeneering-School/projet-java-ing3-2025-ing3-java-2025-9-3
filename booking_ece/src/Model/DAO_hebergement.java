package Model;
import java.sql.*;
import java.util.*;

// Interface publique contenant les prototypes des fonctions
// que l'implémentation doit préciser.
public interface DAO_hebergement {
	Boolean insert();
	ArrayList<Hebergement> getAll();
	Hebergement getByID();
	ArrayList<Hebergement> getByTitre();
	ArrayList<Hebergement> getByCategorie();
	ArrayList<Hebergement> getByRang();
	ArrayList<Hebergement> getByNombreDePersonne();
	ArrayList<Hebergement> getByDetails();
	Boolean update();
	Boolean delete();
}

abstract class DAO_hebergement_skeleton implements DAO_hebergement {
	
	static Connection connexion_vers_bdd;
	
	public DAO_hebergement_skeleton() throws SQLException {
		DAO_hebergement_skeleton.connexion_vers_bdd = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_de_donnee_test_1","root","");
	}
	
	public DAO_hebergement_skeleton(String adresse,String nom_utilisateur,String mot_de_passe) throws SQLException {
		DAO_hebergement_skeleton.connexion_vers_bdd = DriverManager.getConnection(adresse,nom_utilisateur,mot_de_passe);
	}
	
	public abstract Boolean insert();
	public abstract ArrayList<Hebergement> getAll();
	public abstract Hebergement getByID();
	public abstract ArrayList<Hebergement> getByTitre();
	public abstract ArrayList<Hebergement> getByCategorie();
	public abstract ArrayList<Hebergement> getByRang();
	public abstract ArrayList<Hebergement> getByNombreDePersonne();
	public abstract ArrayList<Hebergement> getByDetails();
	public abstract Boolean update();
	public abstract Boolean delete();
	
}
