package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Hebergement extends DAO_hebergement_skeleton {

	// Tous les attributs d'une instance de la classe Hebergement...
	private int ID;
	private String titre;
	private String description;
	private String categorie;
	private int rang;
	private int prix; // WTF
	private java.util.Date date_debut_location; // WTF
	private java.util.Date date_fin_location;  // WTF
	private int nombre_de_personne;
	private Boolean detail_wifi; // ENSEMBLE
	private Boolean detail_petit_dejeuner; // ENSEMBLE
	private Boolean detail_piscine_interieure; // ENSEMBLE
	private Boolean detail_centre_sportif; // ENSEMBLE
	private int ID_locataire; // WTF
	
	// Les chaines de caractères pour les préparations de requêtes SQL...
	static String string_insert = "INSERT INTO hebergement_table (hebergement_titre,hebergement_description,hebergement_categorie,hebergement_rang,hebergement_prix,hebergement_debut_location,hebergement_fin_location,hebergement_nombre_personne,hebergement_detail_wifi,hebergement_detail_petit_dejeuner,hebergement_detail_piscine_interieure,hebergement_detail_centre_sportif,hebergement_id_locataire) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ;";
	static String string_getAll = "SELECT * FROM hebergement_table ;";
	static String string_getByID = "SELECT * FROM hebergement_table WHERE hebergement_id = ?;";
	static String string_getByTitre = "SELECT * FROM hebergement_table WHERE hebergement_titre = ?";
	static String string_getByCategorie = "SELECT * FROM hebergement_table WHERE hebergement_categorie = ?";
	static String string_getByRang = "SELECT * FROM hebergement_table WHERE hebergement_rang = ?;";
	static String string_getByNombreDePersonne = "SELECT * FROM hebergement_table WHERE hebergement_nombre_personne = ?;";
	static String string_getByDetails = "SELECT * FROM hebergement_table WHERE hebergement_detail_wifi = ? AND hebergement_detail_petit_dejeuner = ? AND hebergement_detail_piscine_interieure = ? AND hebergement_detail_centre_sportif = ? ;";
	static String string_update = "UPDATE hebergement_table SET hebergement_titre = ? , hebergement_description = ? , hebergement_categorie = ? , hebergement_rang = ? , hebergement_prix =  ? , hebergement_debut_location = ? , hebergement_fin_location = ? , hebergement_nombre_personne = ? , hebergement_detail_wifi = ? , hebergement_detail_petit_dejeuner = ? , hebergement_detail_piscine_interieure = ? , hebergement_detail_centre_sportif = ? , hebergement_id_locataire = ? WHERE hebergement_id = ?  ;";
	static String string_delete = "DELETE FROM hebergement_table WHERE hebergement_id = ? ;";
	
	// Constructeur sans paramètres...
	public Hebergement() throws SQLException {
		
		super();
		this.ID = -1;
		this.titre = "Hebergement vide";
		this.description = "Description vide";
		this.categorie = "Sans catégorie";
		this.rang = 1;
		this.prix = 1000;
		this.date_debut_location = new java.util.Date();
		this.date_fin_location = new java.util.Date();
		this.nombre_de_personne = 1;
		this.detail_wifi = false;
		this.detail_petit_dejeuner = false;
		this.detail_piscine_interieure = false;
		this.detail_centre_sportif = false;
		this.ID_locataire = -1;
		
	}
	
	// Constructeur avec paramètres d'une instance de la classe Hebergmement...
	public Hebergement( int in_ID , String in_titre , String in_description , String in_categorie , int in_rang , int in_prix , java.util.Date in_date_debut_location , java.util.Date in_date_fin_location , int in_nombre_de_personne , Boolean in_detail_wifi , Boolean in_detail_petit_dejeuner , Boolean in_detail_piscine_interieure , Boolean in_detail_centre_sportif , int in_ID_locataire ) throws SQLException {
		super();
		this.ID = in_ID;
		this.titre = in_titre;
		this.description = in_description;
		this.categorie = in_categorie;
		this.rang = in_rang;
		this.prix = in_prix;
		this.date_debut_location = in_date_debut_location;
		this.date_fin_location = in_date_fin_location;
		this.nombre_de_personne = in_nombre_de_personne;
		this.detail_wifi = in_detail_wifi;
		this.detail_petit_dejeuner = in_detail_petit_dejeuner;
		this.detail_piscine_interieure = in_detail_piscine_interieure;
		this.detail_centre_sportif = in_detail_centre_sportif;
		this.ID_locataire = in_ID_locataire;
	}
	
	public void setID( int in_ID ) {
		this.ID = in_ID;
	}
	
	public void setTitre( String in_titre ) {
		this.titre = in_titre;
	}
	
	public void setDescription(String in_description) {
		this.description = in_description;
	}
	
	public void setCategorie(String in_categorie) {
		this.categorie = in_categorie;
	}
	
	public void setRang( int in_rang ) {
		this.rang = in_rang;
	}
	
	public void setPrix( int in_prix ) {
		this.prix = in_prix;
	}
	
	public void setNombreDePersonne( int in_nombre_de_personne ) {
		this.nombre_de_personne = in_nombre_de_personne;
	}
	
	public void setDetails( Boolean in_wifi , Boolean in_petit_dejeuner , Boolean in_piscine_interieure , Boolean in_centre_sportif ) {
		this.detail_wifi = in_wifi;
		this.detail_petit_dejeuner = in_petit_dejeuner;
		this.detail_piscine_interieure = in_piscine_interieure;
		this.detail_centre_sportif = in_centre_sportif;
	}
	
	public void setIDLocataire( int in_ID_locataire ) {
		this.ID_locataire = in_ID_locataire;
	}
	
	public void afficher() {
		System.out.println("On affiche un hébergement :");
		System.out.println(" ID : " + this.ID );
		System.out.println(" TITRE : " + this.titre );
		System.out.println(" DESCRIPTION : " + this.description );
		System.out.println(" CATEGORIE : " + this.categorie );
		System.out.println(" RANG : " + this.rang );
		System.out.println(" PRIX : " + this.prix );
		System.out.println(" DATE DEBUT LOCATION : " + this.date_debut_location.toString() );
		System.out.println(" DATE FIN LOCATION : " + this.date_fin_location.toString() );
		System.out.println(" NOMBRE DE PERSONNE : " + this.nombre_de_personne );
		System.out.println(" WIFI : " + this.detail_wifi );
		System.out.println(" PETIT DEJEUNER : " + this.detail_petit_dejeuner );
		System.out.println(" PISCINE INTERIEURE : " + this.detail_piscine_interieure );
		System.out.println(" CENTRE SPORTIF : " + this.detail_centre_sportif );
		System.out.println(" ID DU LOCATAIRE : " + this.ID_locataire );
	}
	
	public Boolean insert() {
		Boolean resultat = false;
		try {
			PreparedStatement PS1 = DAO_hebergement_skeleton.connexion_vers_bdd.prepareStatement(Hebergement.string_insert);
			//PS1.setInt(1,this.ID);
			PS1.setString(1, this.titre);
			PS1.setString(2, this.description);
			PS1.setString(3, this.categorie);
			PS1.setInt(4, this.rang);
			PS1.setInt(5, this.prix);
			PS1.setString(6, this.date_debut_location.toString() );
			PS1.setString(7, this.date_fin_location.toString() );
			PS1.setInt(8, this.nombre_de_personne );
			PS1.setBoolean(9, this.detail_wifi);
			PS1.setBoolean(10, this.detail_petit_dejeuner);
			PS1.setBoolean(11, this.detail_piscine_interieure);
			PS1.setBoolean(12, this.detail_centre_sportif);
			PS1.setInt(13, this.ID_locataire);
			resultat = PS1.execute();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			System.out.println("Hebergement.insert() : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return resultat;
	}
	
	public ArrayList<Hebergement> getAll(){
		ArrayList<Hebergement> liste_vide = new ArrayList<Hebergement>();
		try {
			PreparedStatement PS1 = DAO_hebergement_skeleton.connexion_vers_bdd.prepareStatement(Hebergement.string_getAll);
			ResultSet RS1 = PS1.executeQuery();
			while ( RS1.next() ) {
				System.out.println(">>> ooo <<<" );
				System.out.println(">> ID : " + RS1.getInt(1) );
				System.out.println(">> IDENTIFIANT : " + RS1.getString(2) );
				System.out.println(">> MOT DE PASSE : " + RS1.getString(3) );
				System.out.println(">> DATE INSCRIPTION : " + RS1.getString(4) );
				System.out.println(">> CATEGORIE : " + RS1.getString(5) );
			} ;
			RS1.close();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			System.out.println("Hebergement.getAll() : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return liste_vide;
	}
	
	public Hebergement getByID() {
		Hebergement hebergement_recherche = null;
		try {
			PreparedStatement PS1 = DAO_hebergement_skeleton.connexion_vers_bdd.prepareStatement(Hebergement.string_getByID);
			PS1.setInt(1, this.ID);
			ResultSet RS1 = PS1.executeQuery();
			if ( RS1.getFetchSize() > 1 || RS1.getFetchSize() == 0 ) {
				System.out.println("Client.getByID > Le Fetch Size est inquiétant...");
				return null;
			} else {
				while ( RS1.next() ) {
					hebergement_recherche = new Hebergement( RS1.getInt(1) , RS1.getString(2) , RS1.getString(3) , RS1.getString(4) , RS1.getInt(5) , RS1.getInt(6) , RS1.getDate(7) , RS1.getDate(8) , RS1.getInt(9) , RS1.getBoolean(10) , RS1.getBoolean(11) , RS1.getBoolean(12) , RS1.getBoolean(13) , RS1.getInt(14)  );
				}
			}
			RS1.close();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			System.out.println("Hebergement.getByID() : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return hebergement_recherche;
	}
	
	public ArrayList<Hebergement> getByTitre(){
		ArrayList<Hebergement> liste_vide = new ArrayList<Hebergement>();
		try {
			PreparedStatement PS1 = DAO_hebergement_skeleton.connexion_vers_bdd.prepareStatement(Hebergement.string_getByTitre);
			PS1.setString(1, this.titre );
			ResultSet RS1 = PS1.executeQuery();
			while ( RS1.next() ) {
				System.out.println(">>> ooo <<<" );
				System.out.println(">> ID : " + RS1.getInt(1) );
				System.out.println(">> IDENTIFIANT : " + RS1.getString(2) );
				System.out.println(">> MOT DE PASSE : " + RS1.getString(3) );
				System.out.println(">> DATE INSCRIPTION : " + RS1.getString(4) );
				System.out.println(">> CATEGORIE : " + RS1.getString(5) );
			} ;
			RS1.close();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			System.out.println("Hebergement.getByTitre() : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return liste_vide;
	}
	
	public ArrayList<Hebergement> getByCategorie(){
		ArrayList<Hebergement> liste_vide = new ArrayList<Hebergement>();
		try {
			PreparedStatement PS1 = DAO_hebergement_skeleton.connexion_vers_bdd.prepareStatement(Hebergement.string_getByCategorie);
			PS1.setString(1, this.categorie );
			ResultSet RS1 = PS1.executeQuery();
			while ( RS1.next() ) {
				System.out.println(">>> ooo <<<" );
				System.out.println(">> ID : " + RS1.getInt(1) );
				System.out.println(">> IDENTIFIANT : " + RS1.getString(2) );
				System.out.println(">> MOT DE PASSE : " + RS1.getString(3) );
				System.out.println(">> DATE INSCRIPTION : " + RS1.getString(4) );
				System.out.println(">> CATEGORIE : " + RS1.getString(5) );
			} ;
			RS1.close();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			System.out.println("Hebergement.getByCategorie() : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return liste_vide;
	}
	
	public ArrayList<Hebergement> getByRang(){
		ArrayList<Hebergement> liste_vide = new ArrayList<Hebergement>();
		try {
			PreparedStatement PS1 = DAO_hebergement_skeleton.connexion_vers_bdd.prepareStatement(Hebergement.string_getByRang);
			PS1.setInt(1, this.rang );
			ResultSet RS1 = PS1.executeQuery();
			while ( RS1.next() ) {
				System.out.println(">>> ooo <<<" );
				System.out.println(">> ID : " + RS1.getInt(1) );
				System.out.println(">> IDENTIFIANT : " + RS1.getString(2) );
				System.out.println(">> MOT DE PASSE : " + RS1.getString(3) );
				System.out.println(">> DATE INSCRIPTION : " + RS1.getString(4) );
				System.out.println(">> CATEGORIE : " + RS1.getString(5) );
			} ;
			RS1.close();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			System.out.println("Hebergement.getByRang() : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return liste_vide;
	}
	
	public ArrayList<Hebergement> getByNombreDePersonne(){
		ArrayList<Hebergement> liste_vide = new ArrayList<Hebergement>();
		try {
			PreparedStatement PS1 = DAO_hebergement_skeleton.connexion_vers_bdd.prepareStatement(Hebergement.string_getByNombreDePersonne);
			PS1.setInt(1, this.nombre_de_personne );
			ResultSet RS1 = PS1.executeQuery();
			while ( RS1.next() ) {
				System.out.println(">>> ooo <<<" );
				System.out.println(">> ID : " + RS1.getInt(1) );
				System.out.println(">> IDENTIFIANT : " + RS1.getString(2) );
				System.out.println(">> MOT DE PASSE : " + RS1.getString(3) );
				System.out.println(">> DATE INSCRIPTION : " + RS1.getString(4) );
				System.out.println(">> CATEGORIE : " + RS1.getString(5) );
			} ;
			RS1.close();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			System.out.println("Hebergement.getByNombreDePersonne() : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return liste_vide;
	}
	
	public ArrayList<Hebergement> getByDetails(){
		ArrayList<Hebergement> liste_vide = new ArrayList<Hebergement>();
		try {
			PreparedStatement PS1 = DAO_hebergement_skeleton.connexion_vers_bdd.prepareStatement(Hebergement.string_getByDetails);
			PS1.setBoolean(1, this.detail_wifi );
			PS1.setBoolean(2, this.detail_petit_dejeuner );
			PS1.setBoolean(3, this.detail_piscine_interieure );
			PS1.setBoolean(4, this.detail_centre_sportif );
			ResultSet RS1 = PS1.executeQuery();
			while ( RS1.next() ) {
				System.out.println(">>> ooo <<<" );
				System.out.println(">> ID : " + RS1.getInt(1) );
				System.out.println(">> IDENTIFIANT : " + RS1.getString(2) );
				System.out.println(">> MOT DE PASSE : " + RS1.getString(3) );
				System.out.println(">> DATE INSCRIPTION : " + RS1.getString(4) );
				System.out.println(">> CATEGORIE : " + RS1.getString(5) );
			} ;
			RS1.close();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			System.out.println("Hebergement.getByDetails() : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return liste_vide;
	}
	
	public Boolean update() {
		Boolean resultat = false;
		try {
			PreparedStatement PS1 = DAO_hebergement_skeleton.connexion_vers_bdd.prepareStatement(Hebergement.string_update);
			PS1.setString( 1 , this.titre );
			PS1.setString( 2 , this.description );
			PS1.setString( 3 , this.categorie );
			PS1.setInt( 4 , this.rang );
			PS1.setInt( 5 , this.prix );
			PS1.setString(6, this.date_debut_location.toString() );
			PS1.setString(7, this.date_fin_location.toString() );
			PS1.setInt( 8 , this.nombre_de_personne );
			PS1.setBoolean( 9 , this.detail_wifi );
			PS1.setBoolean( 10 , this.detail_petit_dejeuner );
			PS1.setBoolean( 11 , this.detail_piscine_interieure );
			PS1.setBoolean( 12 , this.detail_centre_sportif );
			PS1.setInt( 13 , this.ID_locataire );
			PS1.setInt(14, this.ID);
			resultat = PS1.execute();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			System.out.println("Hebergement.update() : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return resultat;
	}
	
	public Boolean delete() {
		Boolean resultat = false;
		try {
			PreparedStatement PS1 = DAO_hebergement_skeleton.connexion_vers_bdd.prepareStatement(Hebergement.string_delete);
			PS1.setInt(1,this.ID);
			resultat = PS1.execute();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			System.out.println("Hebergement.delete() : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return resultat;
	}
	
}
