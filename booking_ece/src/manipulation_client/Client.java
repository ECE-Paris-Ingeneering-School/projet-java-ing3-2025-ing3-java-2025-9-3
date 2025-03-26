package manipulation_client;
import java.util.ArrayList;
import java.sql.*;

class DAO_client {
	
	static Connection connexion_vers_BDD;
	static String requete_readByName = "SELECT * FROM client_table WHERE client_identifiant = ? ;";
	static String requete_readById = "SELECT * FROM client_table WHERE client_id = ? ;";
	static String requete_create = "INSERT INTO client_table (client_identifiant,client_motdepasse,client_dateinscription,client_categorie) VALUES (?,?,?,?) ;";
	static String requete_update = "UPDATE client_table SET client_identifiant = ? , client_motdepasse = ? , client_dateinscription = ? , client_categorie = ? WHERE client_id = ? ;";
	static String requete_delete = "DELETE FROM client_table WHERE client_id = ? ;";
	
	public DAO_client() {
		//DAO_client.connexion_vers_BDD = connexion_cible;
		try {
			connexion_vers_BDD = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_de_donnee_test_1","root","");
			System.out.println("AAAA");
		} catch ( SQLException SQLE1 ) {
			SQLE1.printStackTrace();
		}
		
	}
	
	static ArrayList<Client> LireTout(){
		ArrayList<Client> resultat = new ArrayList<Client>();
		try {
			Statement stat = DAO_client.connexion_vers_BDD.createStatement();
			ResultSet RS1 = stat.executeQuery("SELECT * FROM client_table");
			while ( RS1.next() ) {
				//System.out.println("ID : " + RS1.getInt(1) + " IDENTIFIANT : " + RS1.getString(2) + " MOT DE PASSE : " + RS1.getString(3) + " DATE INSCRIPTION : " + RS1.getString(4) );
				resultat.add( new Client( RS1.getString(2) ,RS1.getString(3) , RS1.getString(4) , RS1.getString(5) ) );
			} ;
			RS1.close();
		} catch ( SQLException SQLE1 ) {
			SQLE1.printStackTrace();
		}
		return resultat;
	}
	
	static ArrayList<Client> LireParIdentifiant( String identifiant_cible ){
		ArrayList<Client> resultat = new ArrayList<Client>();
		try {
			PreparedStatement PS1 = DAO_client.connexion_vers_BDD.prepareStatement(DAO_client.requete_readByName);
			PS1.setString(1, identifiant_cible );
			ResultSet RS1 = PS1.executeQuery();
			while ( RS1.next() ) {
				//System.out.println("ID : " + RS1.getInt(1) + " IDENTIFIANT : " + RS1.getString(2) + " MOT DE PASSE : " + RS1.getString(3) + " DATE INSCRIPTION : " + RS1.getString(4) );
				resultat.add( new Client( RS1.getString(2) ,RS1.getString(3) , RS1.getString(4) , RS1.getString(5) ) );
			} ;
			RS1.close();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			SQLE1.printStackTrace();
		}
		return resultat;
	}
	
	static ArrayList<Client> LireParId( int id_cible ){
		ArrayList<Client> resultat = new ArrayList<Client>();
		try {
			PreparedStatement PS1 = DAO_client.connexion_vers_BDD.prepareStatement(DAO_client.requete_readById);
			PS1.setInt(1, id_cible);
			ResultSet RS1 = PS1.executeQuery();
			System.out.println("TAILLE : " + RS1.getFetchSize() );
			while ( RS1.next() ) {
				//System.out.println("ID : " + RS1.getInt(1) + " IDENTIFIANT : " + RS1.getString(2) + " MOT DE PASSE : " + RS1.getString(3) + " DATE INSCRIPTION : " + RS1.getString(4)  );
				resultat.add( new Client( RS1.getString(2) ,RS1.getString(3) , RS1.getString(4) ,  RS1.getString(5) ) );			
			}
			RS1.close();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			SQLE1.printStackTrace();
		}
		return resultat;
	}
	
	static Boolean delete( int index_cible ) {
		Boolean resultat = false;
		try {
			PreparedStatement PS1 = DAO_client.connexion_vers_BDD.prepareStatement(DAO_client.requete_delete);
			PS1.setInt(1,index_cible);
			resultat = PS1.execute();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			SQLE1.printStackTrace();
		}
		return resultat;
	}
	
}

public class Client extends DAO_client {
	
	private String identifiant;
	public String motDePasse;
	private String dateInscription;
	private String administrateur;
	
	public Client( String ident , String mdp , String dateIn , String admin ) {
		super();
		this.identifiant = ident;
		this.motDePasse = mdp;
		this.dateInscription = dateIn;
		this.administrateur = admin;
	}
	
	// Méthode d'une instance de la classe Client pour insérer une nouvelle entrée avec ses
	// propres attributs pour valeur dans la base des clients.
	// IN : Rien!
	// OUT : resultat : Boolean -> l'indicateur du succès ou échec de l'opération.
	public Boolean create(){
		Boolean resultat = false;
		try {
			PreparedStatement PS1 = DAO_client.connexion_vers_BDD.prepareStatement(DAO_client.requete_create);
			PS1.setString(1, this.identifiant);
			PS1.setString(2, this.motDePasse);
			PS1.setString(3, this.dateInscription);
			PS1.setString(4, this.administrateur );
			resultat = PS1.execute();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			SQLE1.printStackTrace();
		}
		return resultat;
	}
	
	// Méthode de Client pour modifier une entrée déjà comprise dans la table des clients.
	// IN : index_cible : int -> l'id du client que l'on veut modifier
	// OUT : resultat : Boolean -> l'indicateur du succès ou échec de l'opération.
	// NOTE : le client ciblé par cette méthode prendra les valeurs des attributs du Client
	// d'où est lancé cet appel de méthode.
	public Boolean update(int index_cible){
		Boolean resultat = false;
		try {
			PreparedStatement PS1 = DAO_client.connexion_vers_BDD.prepareStatement(DAO_client.requete_update);
			PS1.setString(1, this.identifiant);
			PS1.setString(2, this.motDePasse);
			PS1.setString(3, this.dateInscription);
			PS1.setInt(4,index_cible);
			resultat = PS1.execute();
			PS1.close();
		} catch ( SQLException SQLE1 ) {
			SQLE1.printStackTrace();
		}
		return resultat;
	}
	
	public void display() {
		System.out.println("IDENTIFIANT : " + this.identifiant );
		System.out.println("MOTDEPASSE : " + this.motDePasse );
		System.out.println("DATEINSCRIPTION : " + this.dateInscription);
		System.out.println("CATEGORIE : " + this.administrateur);
	}
	
}