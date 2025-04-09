package Vue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

// Panel contenant le formulaire de connexion.

public class FormulaireConnexion extends pageStruct {
	
	private JLabel label_image_logo;
	private JLabel label_introduction;
	private JLabel label_nom_utilisateur;
	private JLabel label_mot_de_passe;
	private JTextField saisi_nom_utilisateur;
	private JPasswordField saisi_mot_de_passe;
	
	private JButton bouton_connexion;
	private JButton bouton_enregistrement;
	
	private GridBagConstraints contraintes;
	private Color couleur_ECE;
	private Font police_ecriture_1;
	
	private BufferedImage image1;
	
	public FormulaireConnexion( navigation nav , String name ) {
		// Initialisation de la classe Mère et des attributs de base.
		super(nav,name);
		setLayout( new GridBagLayout() );
		this.couleur_ECE = new Color(0,115,123);
		this.police_ecriture_1 = new Font("Cascadia Code",Font.PLAIN,30);
		// Lecture de l'image par l'application.
		// Définition des contraintes de base pour tous les composants du panel.
		this.contraintes = new GridBagConstraints();
		this.contraintes.ipadx=10;
		this.contraintes.ipady=10;
		this.contraintes.insets = new Insets(10,10,10,10);
		// Label contenant le logo de l'application.
		try {
			this.image1 = ImageIO.read( new File("C:/Users/antoi/OneDrive/Bureau/Projet JAVA Booking wtf/LOGO_DE_OUF.png") );
			this.label_image_logo = new JLabel(new ImageIcon(this.image1));
			this.contraintes.fill = GridBagConstraints.HORIZONTAL;
			this.contraintes.gridwidth = 2;
			this.contraintes.gridx = 1;
			this.contraintes.gridy = 1;
			this.add(this.label_image_logo,this.contraintes);
		} catch (IOException IOE1) {
			IOE1.printStackTrace();
		}
		// Label d'introduction. contient un message amène.
		this.label_introduction = new JLabel("Connectez-vous à Booking.ECE !");
		this.label_introduction.setFont(this.police_ecriture_1);
		this.label_introduction.setForeground(this.couleur_ECE);
		this.contraintes.fill = GridBagConstraints.NONE;
		this.contraintes.gridwidth = 2;
		this.contraintes.gridx = 1;
		this.contraintes.gridy = 2;
		this.add(this.label_introduction,this.contraintes);
		
		
		// Ajout du label pour introduire le champ de saisi du nom d'utilisateur à connecter...
		this.label_nom_utilisateur = new JLabel("Nom d'utilisateur : ");
		this.contraintes.gridwidth = 1;
		this.contraintes.gridx = 1;
		this.contraintes.gridy = 3;
		this.add(this.label_nom_utilisateur,this.contraintes);
		
		// Ajout du champ de saisi pour le nom d'utilisateur à connecter.
		this.saisi_nom_utilisateur = new JTextField(10);
		this.contraintes.fill = GridBagConstraints.HORIZONTAL;
		this.contraintes.gridwidth = 1;
		this.contraintes.gridx = 2;
		this.contraintes.gridy = 3;
		this.add(this.saisi_nom_utilisateur,this.contraintes);
		
		// Ajout du label pour introduire le champ de saisi du mot de passe.
		this.label_mot_de_passe = new JLabel("Mot de passe : ");
		this.contraintes.fill = GridBagConstraints.NONE;
		this.contraintes.gridx = 1;
		this.contraintes.gridy = 4;
		this.add(this.label_mot_de_passe,this.contraintes);
		
		// Ajout du champ de saisi pour le mot de passe.
		this.saisi_mot_de_passe = new JPasswordField(10);
		this.contraintes.fill = GridBagConstraints.HORIZONTAL;
		this.contraintes.gridx = 2;
		this.contraintes.gridy = 4;
		this.add(this.saisi_mot_de_passe,this.contraintes);
		
		// Ajout du bouton pour se connecter à Booking.ece
		this.bouton_connexion = new JButton("Connexion");
		this.contraintes.fill = GridBagConstraints.HORIZONTAL;
		this.contraintes.gridwidth = 1;
		this.contraintes.gridx = 2;
		this.contraintes.gridy = 5;
		this.bouton_connexion.setBackground(this.couleur_ECE);
		this.bouton_connexion.setForeground(Color.WHITE);
		this.add(this.bouton_connexion,this.contraintes);
		
		// Ajout du bouton pour passer au formulaire d'enregistrement.
		this.bouton_enregistrement = new JButton("S'enregistrer");
		this.contraintes.fill = GridBagConstraints.HORIZONTAL;
		this.contraintes.gridwidth = 1;
		this.contraintes.gridx = 1;
		this.contraintes.gridy = 5;
		this.bouton_enregistrement.setBackground(Color.WHITE);
		this.bouton_enregistrement.setForeground(this.couleur_ECE);
		this.add(this.bouton_enregistrement,this.contraintes);
		// Ajout d'un écouteur sur le bouton de connexion.
		this.bouton_connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO : Ajouter le code pour se connecter à Booking.ece.
                try {
                    moveToPage("accueil");
                } catch (PageNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
		});
		this.bouton_enregistrement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO : Ajouter le code pour passer au formulaire d'enregistrement.
				try {
					moveToPage("enregistrement");
				} catch (PageNotFoundException ex) {
					throw new RuntimeException(ex);
				}
			}
		});
		//setVisible(true);
	}
	@Override
	public JPanel addNavBar() {
		JPanel navBar = super.addNavBar();
		try {
			// Définir les contraintes pour la barre de navigation
			contraintes.gridx = 0; // Position horizontale
			contraintes.gridy = 0; // Position verticale
			contraintes.gridwidth = GridBagConstraints.REMAINDER; // Occuper toute la largeur
			contraintes.fill = GridBagConstraints.HORIZONTAL; // Étendre horizontalement
			contraintes.insets = new Insets(0, 0, 10, 0); // Marges autour de la barre de navigation
			add(navBar, contraintes);
			System.out.println("Barre de navigation ajoutée avec succès.");
		} catch (Exception e) {
			System.out.println("Erreur avec GridBagConstraints : " + e.getMessage());
			e.printStackTrace();
		}
		return navBar;
	}
	
	// Code pour faire une démo de la vue.
	// Ce code n'est pas lié à un controlleur : aucune interaction est faisable avec les boutons affichés !
	public static void main( String args[] ) {
		JFrame frame_test = new JFrame("Demonstration VUE Formulaire Connexion");
		frame_test.setSize(960,710);
		frame_test.setResizable(false);
		FormulaireConnexion LF1 = new FormulaireConnexion( new navigation(), "Formulaire de Connexion" );
		frame_test.add(LF1);
		frame_test.setVisible(true);
	}
}
