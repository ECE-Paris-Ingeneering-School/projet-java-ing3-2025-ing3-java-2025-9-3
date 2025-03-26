package manipulation_client;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class ConnexionForm extends JPanel {
	
	private JButton goto_inscription;
	private JButton connexion;
	private ConnexionListener CL1;
	private TransitionListener transition1;
	private TextFieldPlus TFP_identifiant;
	private TextFieldPlus TFP_motdepasse;
	private Client client_medium;
	
	public ConnexionForm() {
		
		super();
		
		this.goto_inscription = new JButton("Je ne suis pas un membre de Booking.ece");
		this.connexion = new JButton("Se connecter");
		this.CL1 = new ConnexionListener( this );
		this.connexion.addActionListener(this.CL1);
		this.transition1 = new TransitionListener("INSCRIPTION",this);
		this.goto_inscription.addActionListener(this.transition1);
		this.TFP_identifiant = new TextFieldPlus("Identifiant",30);
		this.TFP_motdepasse = new TextFieldPlus("Mot de passe",30);
		this.client_medium = new Client( null , null , null , null );
		
		setLayout( new BoxLayout( this , BoxLayout.PAGE_AXIS ) );
		
		this.add(this.TFP_identifiant);
		this.add(this.TFP_motdepasse);
		this.add(this.goto_inscription);
		this.add(this.connexion);
		setSize(600,600);
		setBackground(Color.RED);
		
	}
	
	public void connecter_client() {
		System.out.println("Connexion en cours");
		String identifiant_recherche = this.TFP_identifiant.textfield_a_remplir.getText();
		String motdepasse_ecrit = this.TFP_motdepasse.textfield_a_remplir.getText();
		ArrayList<Client> liste1 = Client.LireParIdentifiant( identifiant_recherche );
		if ( liste1.size() == 1 ) {
			System.out.println( motdepasse_ecrit + " == " + liste1.get(0).motDePasse );
			if ( motdepasse_ecrit.equals(liste1.get(0).motDePasse) ) {
				JOptionPane.showMessageDialog( this.connexion , "Connexion réussie.");
				MasterPanel MP_medium = (MasterPanel)this.getParent();
				MP_medium.card_layout.show( MP_medium , "LISTEUR_HEBERGEMENT" );
			} else {
				JOptionPane.showMessageDialog( this.connexion , "Connexion échouée.");
			}
		} else {
			JOptionPane.showMessageDialog( this.connexion , "Connexion échouée.");
		}
	}
	
}

class InscriptionForm extends JPanel {
	
	private JButton goto_connexion;
	private JButton inscription;
	private TransitionListener transition1;
	private TextFieldPlus TFP_identifiant;
	private TextFieldPlus TFP_motdepasse;
	private TextFieldPlus TFP_motdepasse_confirmation;
	private GroupOfRadioButtons GORB_categorie;
	private InscriptionListener IL1;
	private Client client_medium;
	
	public InscriptionForm() {
		
		super();
		
		this.goto_connexion = new JButton("Je me suis déjà inscrit");
		this.inscription = new JButton("Inscription");
		this.IL1 = new InscriptionListener( this );
		this.inscription.addActionListener(this.IL1);
		this.transition1 = new TransitionListener("CONNEXION",this);
		this.goto_connexion.addActionListener(this.transition1);
		this.TFP_identifiant = new TextFieldPlus("Identifiant",30);
		this.TFP_motdepasse = new TextFieldPlus("Mot de passe",40);
		this.TFP_motdepasse_confirmation = new TextFieldPlus("Mot de passe (Confirmation)",40);
		this.GORB_categorie = new GroupOfRadioButtons( new String[]{"Client","Administrateur"} );
		//this.client_medium = new Client(null,null,null,null);
	
		setLayout( new BoxLayout(this,BoxLayout.PAGE_AXIS) );
		
		this.add(this.TFP_identifiant);
		this.add(this.TFP_motdepasse);
		this.add(this.TFP_motdepasse_confirmation);
		this.add(this.GORB_categorie);
		this.add(this.goto_connexion);
		this.add(this.inscription);
		setSize(600,600);
		setBackground(Color.BLUE);
	}
	
	public void enregister_nouveau_client() {
		String nouveau_identifiant = this.TFP_identifiant.textfield_a_remplir.getText();
		String nouveau_motdepasse = this.TFP_motdepasse.textfield_a_remplir.getText();
		java.util.Date nouvelle_dateinscription = new java.util.Date();
		String nouvelle_categorie = this.GORB_categorie.getValue();
		this.client_medium = new Client( nouveau_identifiant , nouveau_motdepasse , nouvelle_dateinscription.toString() , nouvelle_categorie  );
		ArrayList<Client> liste_verification = Client.LireParIdentifiant(nouveau_identifiant);
		if ( liste_verification.size() >= 1 ) {
			JOptionPane.showMessageDialog( this.inscription , "Un client est deja inscrit sous cet identifiant.");
		} else {
			this.client_medium.create();
			JOptionPane.showMessageDialog( this.inscription , "Inscription réussie.");
			MasterPanel MP_medium = (MasterPanel)this.getParent();
			MP_medium.card_layout.show( MP_medium , "LISTEUR_HEBERGEMENT" );
		}
	}
	
}

class TransitionListener implements ActionListener {
	
	private String string_destination;
	private JPanel possesseur;
	
	public TransitionListener ( String destination , JPanel possesseur ) {
		this.string_destination = destination;
		this.possesseur = possesseur;
	}
	
	public void actionPerformed(ActionEvent AE1) {
		MasterPanel MP_medium = (MasterPanel)this.possesseur.getParent();
		MP_medium.card_layout.show( MP_medium , this.string_destination );
	}
	
}

class InscriptionListener implements ActionListener {
	
	private InscriptionForm possesseur;
	
	public InscriptionListener( InscriptionForm possesseur ) {
		this.possesseur = possesseur;
	}
	
	public void actionPerformed( ActionEvent AE1 ) {
		this.possesseur.enregister_nouveau_client();
	}
	
}

class ConnexionListener implements ActionListener {
	
	private ConnexionForm possesseur;
	
	public ConnexionListener( ConnexionForm possesseur ) {
		this.possesseur = possesseur;
	}
	
	public void actionPerformed( ActionEvent AE1 ) {
		this.possesseur.connecter_client();
	}
	
}

class ListeurHebergement extends JPanel {
	
	public ListeurHebergement() {
		setSize(600,600);
		setBackground(Color.GREEN);
		setLayout( new BoxLayout(this,BoxLayout.PAGE_AXIS) );
	}
	
}
