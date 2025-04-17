package Vue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import Controler.FormulaireConnexion_controler;

// Panel contenant le formulaire de connexion.

public class FormulaireConnexion extends JPanel {
	
	private JLabel label_image_logo;
	private JLabel label_introduction;
	private JLabel label_nom_utilisateur;
	private JLabel label_mot_de_passe;
	protected JTextField saisi_nom_utilisateur;
	protected JPasswordField saisi_mot_de_passe;
	
	protected JButton bouton_connexion;
	protected JButton bouton_enregistrement;
	
	private GridBagConstraints contraintes;
	private Color couleur_ECE;
	private Font police_ecriture_1;
	
	private BufferedImage image1;
	
	public FormulaireConnexion() {
		
		// Initialisation de la classe Mère et des attributs de base.
		super();
		setLayout( new GridBagLayout() );
		this.couleur_ECE = new Color(0,115,123);
		this.police_ecriture_1 = new Font("Cascadia Code",Font.PLAIN,30);
		// Lecture de l'image par l'application.
		try {
			this.image1 = ImageIO.read( new File("C:/Users/antoi/OneDrive/Bureau/Projet JAVA Booking wtf/LOGO_DE_OUF.png") );
		} catch (IOException IOE1) {
			IOE1.printStackTrace();
		}
		
		
		// Définition des contraintes de base pour tous les composants du panel.
		this.contraintes = new GridBagConstraints();
		this.contraintes.ipadx=10;
		this.contraintes.ipady=10;
		this.contraintes.insets = new Insets(10,10,10,10);
		
		// Label contenant le logo de l'application.
		this.label_image_logo = new JLabel(new ImageIcon(this.image1));
		this.contraintes.fill = GridBagConstraints.HORIZONTAL;
		this.contraintes.gridwidth = 2;
		this.contraintes.gridx = 1;
		this.contraintes.gridy = 1;
		this.add(this.label_image_logo,this.contraintes);
		
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
		
		
		setVisible(true);
	}
	
	// Code pour faire une démo de la vue.
	// Ce code n'est pas lié à un controlleur : aucune interaction est faisable avec les boutons affichés !
	public static void main( String args[] ) {
		JFrame frame_test = new JFrame("Demonstration VUE Formulaire Connexion");
		frame_test.setSize(960,710);
		frame_test.setResizable(false);
		FormulaireConnexion LF1 = new FormulaireConnexion();
		frame_test.add(LF1);
		frame_test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_test.setVisible(true);
	}
	
}
