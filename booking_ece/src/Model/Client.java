package dao;
import java.util.*;
import java.sql.*;

public class Client extends DAO_client_skeleton {
	
	// Les attributs que chaque instance de la classe Client aura...
	private int ID;					// Clé primaire dans la table client_table.
	private String identifiant;		// VARCHAR(20) dans la table client_table.
	private String motDePasse;		// VARCHAR(30) dans la table client_table.
	private String dateInscription;	// VARCHAR(15) dans la table client_table.
	private String categorie;		// VARCHAR(15) dans la table client_table.
	
	// Les chaines de caractères pour les préparations de requêtes SQL...
	static String string_insert = "INSERT INTO client_table ( client_identifiant , client_motdepasse , client_dateinscription , client_categorie ) VALUES (?,?,?,?); ";
	static String string_getAll = "SELECT * FROM client_table";
	static String string_getByID = "SELECT * FROM client_table WHERE client_id = ? ;";
	static String string_getByIdentifiant = "SELECT * FROM client_table WHERE client_identifiant = ? ;";
	static String string_getByMotDePasse = "SELECT * FROM client_table WHERE client_motdepasse = ? ;";
	static String string_update = "UPDATE client_table SET client_identifiant = ? , client_motdepasse = ? , client_dateinscription = ? , client_categorie = ? WHERE client_id = ? ;";
	static String string_delete = "DELETE FROM client_table WHERE client_id = ? ;";
	
	// Le constructeur par défaut de classe Client.
	public Client() throws SQLException {
		super();
		this.ID = -1;
		this.identifiant = "John Doe";
		this.motDePasse = "ThisIsAPassword";
		this.dateInscription = new java.util.Date().toString();
		this.categorie = "normal";
	}
	
	// Le constructeur avec paramètres de la classe Client.
	public Client( int in_ID , String in_identifiant , String in_motdepasse , String in_dateinscription , String in_categorie ) throws SQLException {
		super();
		this.ID = in_ID;
		this.identifiant = in_identifiant;
		this.motDePasse = in_motdepasse;
		this.dateInscription = in_dateinscription.toString();
		this.categorie = in_categorie;
	}
	
	// Setters de la classe Client...
	public void setID(int in_ID) {
		this.ID = in_ID;
	}
	
	public void setIdentifiant( String in_identifiant ) {
		this.identifiant = in_identifiant;
	}
	
	public void setMotDePasse( String in_motdepasse ) {
		this.motDePasse = in_motdepasse;
	}
	
	public void setCategorie( String in_categorie ) {
		this.categorie = in_categorie;
	}
	
	// Méthode pour afficher le client avec la fonction System.out.println
	@Override
	public String toString() {
		return "Client n°"+this.ID+" // Identifiant : " + this.identifiant + " // Mot de passe : " + this.motDePasse + " // Date d'inscription : " + this.dateInscription.toString() + " // categorie : " + this.categorie;
	}
	
	// Méthode pour afficher le client et ses attributs.
	public void afficher() {
		System.out.println("<<CLIENT>>");
		System.out.println("> ID : " + this.ID );
		System.out.println("> IDENTIFIANT : " + this.identifiant );
		System.out.println("> MOT DE PASSE : " + this.motDePasse );
		System.out.println("> DATE D'INSCRIPTION : " + this.dateInscription );
		System.out.println("> CATEGORIE : " + this.categorie );
	}
	
	// Méthode pour insérer le client appelé dans la table client_table...
	public Boolean insert() {
		Boolean resultat = false;
		try {
			PreparedStatement PS1 = DAO_client_skeleton.connexion_vers_bdd.prepareStatement(Client.string_insert);
			//PS1.setInt(1,this.ID);
			PS1.setString(1, this.identifiant);
			PS1.setString(2, this.motDePasse);
			PS1.setString(3, this.dateInscription.toString() );
			PS1.setString(4, this.categorie);
			resultat = PS1.execute();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			System.out.println("Client.insert() : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return resultat;
	}
	
	// Méthode pour lire tous les clients de la table client_table...
	public ArrayList<Client> getAll(){
		ArrayList<Client> liste_vide = new ArrayList<Client>();
		try {
			PreparedStatement PS1 = DAO_client_skeleton.connexion_vers_bdd.prepareStatement(Client.string_getAll);
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
			System.out.println("Client.getAll() : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return liste_vide;
	}
	
	// Méthode pour lire le client ayant un ID donné en paramètre...
	public Client getByID() {
		Client client_recherche = null;
		try {
			PreparedStatement PS1 = DAO_client_skeleton.connexion_vers_bdd.prepareStatement(Client.string_getByID);
			PS1.setInt(1, this.ID);
			ResultSet RS1 = PS1.executeQuery();
			if ( RS1.getFetchSize() > 1 || RS1.getFetchSize() == 0 ) {
				System.out.println("Client.getByID > Le Fetch Size est inquiétant...");
				return null;
			} else {
				while ( RS1.next() ) {
					client_recherche = new Client( RS1.getInt(1) , RS1.getString(2) , RS1.getString(3) , RS1.getString(4) , RS1.getString(5) );
				}
			}
			RS1.close();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			System.out.println("Client.getByID( int in_ID ) : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return client_recherche;
	}
	
	// Méthode pour lire le client ayant l'identifiant donné en paramètre :
	public Client getByIdentifiant() {
		Client client_recherche = null;
		try {
			PreparedStatement PS1 = DAO_client_skeleton.connexion_vers_bdd.prepareStatement(Client.string_getByIdentifiant);
			PS1.setString(1, this.identifiant);
			ResultSet RS1 = PS1.executeQuery();
			if ( RS1.getFetchSize() > 1 || RS1.getFetchSize() == 0 ) {
				System.out.println("Client.getByID > Le Fetch Size est inquiétant...");
				return null;
			} else {
				while ( RS1.next() ) {
					client_recherche = new Client( RS1.getInt(1) , RS1.getString(2) , RS1.getString(3) , RS1.getString(4) , RS1.getString(5) );
				}
			}
			RS1.close();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			System.out.println("Client.getByID( int in_ID ) : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return client_recherche;
	}
	
	// Méthode pour lire les clients avec le mot de passe donné en paramètre :
	public ArrayList<Client> getByMotDePasse(){
		ArrayList<Client> liste_vide = new ArrayList<Client>();
		try {
			PreparedStatement PS1 = DAO_client_skeleton.connexion_vers_bdd.prepareStatement(Client.string_getByMotDePasse);
			PS1.setString(1, this.motDePasse);
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
			System.out.println("Client.getAll() : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return liste_vide;
	}
	
	// Méthode pour mettre à jour un client
	public Boolean update() {
		Boolean resultat = false;
		try {
			PreparedStatement PS1 = DAO_client_skeleton.connexion_vers_bdd.prepareStatement(Client.string_update);
			PS1.setString( 1 , this.identifiant );
			PS1.setString( 2 , this.motDePasse );
			PS1.setString( 3 , this.dateInscription );
			PS1.setString( 4 , this.categorie );
			PS1.setInt( 5 , this.ID );
			resultat = PS1.execute();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			System.out.println("Client.update() : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return resultat;
	}
	
	// Méthode pour supprimer un client...
	public Boolean delete() {
		Boolean resultat = false;
		try {
			PreparedStatement PS1 = DAO_client_skeleton.connexion_vers_bdd.prepareStatement(Client.string_delete);
			PS1.setInt(1,this.ID);
			resultat = PS1.execute();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			System.out.println("Client.insert() : Erreur SQL :( ");
			SQLE1.printStackTrace();
		}
		return resultat;
	}
	
}
