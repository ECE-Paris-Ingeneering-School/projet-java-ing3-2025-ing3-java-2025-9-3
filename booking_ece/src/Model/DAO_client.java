package dao;
import java.sql.*;
import java.util.*;

public interface DAO_client {
	Boolean insert();
	ArrayList<Client> getAll();
	Client getByID();
	Client getByIdentifiant();
	ArrayList<Client> getByMotDePasse();
	Boolean update();
	Boolean delete();
}

abstract class DAO_client_skeleton implements DAO_client {
	
	static Connection connexion_vers_bdd;
	
	public DAO_client_skeleton() throws SQLException {
		DAO_client_skeleton.connexion_vers_bdd = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_de_donnee_test_1","root","");
	}
	
	public DAO_client_skeleton(String adresse,String nom_utilisateur,String mot_de_passe) throws SQLException {
		DAO_client_skeleton.connexion_vers_bdd = DriverManager.getConnection(adresse,nom_utilisateur,mot_de_passe);
	}
	
	public abstract Boolean insert();
	public abstract ArrayList<Client> getAll();
	public abstract Client getByID();
	public abstract Client getByIdentifiant();
	public abstract ArrayList<Client> getByMotDePasse();
	public abstract Boolean update();
	public abstract Boolean delete();
	
}



