package Vue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class FormulaireEnregistrement extends pageStruct {
		
		private GridBagConstraints GBC1;
		private Color couleur_ECE;
		private Font police_ecriture_1;
		private BufferedImage image1;
	
		private JLabel label_logo_application;
		private JLabel label_introduction;
		
		private JLabel label_saisi_nom_utilisateur;
		private JTextField saisi_nom_utilisateur;
		
		private JLabel label_saisi_mot_de_passe;
		private JPasswordField saisi_mot_de_passe;
		
		private JLabel label_saisi_mot_de_passe_confirmation;
		private JPasswordField saisi_mot_de_passe_confirmation;
		
		private ButtonGroup groupe_de_boutons_1;
		private JRadioButton bouton_radio_categorie_normal;
		private JRadioButton bouton_radio_categorie_administrateur;
		
		private JButton bouton_enregistrement;
		private JButton bouton_vers_connexion;
		
		// Constructeur de la classe FormulaireEnregistrement
		public FormulaireEnregistrement( navigation nav , String name) {
			super(nav , name);
			this.setLayout(new GridBagLayout());
			this.couleur_ECE = new Color(0,115,123);
			this.police_ecriture_1 = new Font("Cascadia Code",Font.PLAIN,30);
			// Lecture de l'image par l'application.

			// Les contraites du gridBagLayout qui seront modifiés pour chaque widget.
			this.GBC1 = new GridBagConstraints();
			this.GBC1.ipadx=10;
			this.GBC1.ipady=10;
			this.GBC1.insets = new Insets(10,10,10,10);
			
			// Le logo de l'application.
			try {
				this.image1 = ImageIO.read( new File("C:/Users/antoi/OneDrive/Bureau/Projet JAVA Booking wtf/LOGO_DE_OUF.png") );
				this.label_logo_application = new JLabel(new ImageIcon(this.image1));
				this.GBC1.gridx = 1;
				this.GBC1.gridy = 1;
				this.GBC1.gridwidth = 2;
				this.GBC1.fill = GridBagConstraints.HORIZONTAL;
				this.add(this.label_logo_application,this.GBC1);
			} catch (IOException IOE1) {
				IOE1.printStackTrace();
			}

			
			// Le label d'introduction pour inviter l'utilisateur à saisir ses informations
			this.label_introduction = new JLabel("Inscrivez-vous à Booking.ECE !");
			this.label_introduction.setFont(this.police_ecriture_1);
			this.label_introduction.setForeground(this.couleur_ECE);
			this.GBC1.gridx = 1;
			this.GBC1.gridy = 2;
			this.GBC1.gridwidth = 2;
			this.GBC1.fill = GridBagConstraints.HORIZONTAL;
			this.add(this.label_introduction,this.GBC1);
			
			// Label pour la saisie du nom d'utilisateur.
			this.label_saisi_nom_utilisateur = new JLabel("Nom d'utilisateur (20 caractères max) : ");
			this.GBC1.gridx = 1;
			this.GBC1.gridy = 3;
			this.GBC1.gridwidth = 1;
			this.GBC1.fill = GridBagConstraints.NONE;
			this.add(this.label_saisi_nom_utilisateur,this.GBC1);
			
			// Champ de texte pour saisir le nom d'utilisateur du nouveau utilisateur.
			this.saisi_nom_utilisateur = new JTextField(20);
			this.GBC1.gridx = 2;
			this.GBC1.gridy = 3;
			this.GBC1.gridwidth = 1;
			this.GBC1.fill = GridBagConstraints.NONE;
			this.add(this.saisi_nom_utilisateur,this.GBC1);
			
			// Label pour la saisie du mot de passe.
			this.label_saisi_mot_de_passe = new JLabel("Mot de passe (30 caractères max) : ");
			this.GBC1.gridx = 1;
			this.GBC1.gridy = 4;
			this.GBC1.gridwidth = 1;
			this.GBC1.fill = GridBagConstraints.NONE;
			this.add(this.label_saisi_mot_de_passe,this.GBC1);
			
			// Champ de texte caché pour saisir le mot de passe
			this.saisi_mot_de_passe = new JPasswordField(30);
			this.GBC1.gridx = 2;
			this.GBC1.gridy = 4;
			this.GBC1.gridwidth = 1;
			this.GBC1.fill = GridBagConstraints.NONE;
			this.add(this.saisi_mot_de_passe,this.GBC1);
			
			// Label pour la saisie du mot de passe de confirmation
			this.label_saisi_mot_de_passe_confirmation = new JLabel("Confirmez votre mot de passe : ");
			this.GBC1.gridx = 1;
			this.GBC1.gridy = 5;
			this.GBC1.gridwidth = 1;
			this.GBC1.fill = GridBagConstraints.NONE;
			this.add(this.label_saisi_mot_de_passe_confirmation ,this.GBC1);
			
			// Champ de texte caché pour la saisie du mot de passe.
			this.saisi_mot_de_passe_confirmation = new JPasswordField(30);
			this.GBC1.gridx = 2;
			this.GBC1.gridy = 5;
			this.GBC1.gridwidth = 1;
			this.GBC1.fill = GridBagConstraints.NONE;
			this.add(this.saisi_mot_de_passe_confirmation,this.GBC1);
			
			// Groupe de boutons radio pour définir la catégorie du nouveau client
			this.bouton_radio_categorie_normal = new JRadioButton("Client normal",true);
			this.bouton_radio_categorie_administrateur = new JRadioButton("Administrateur");
			this.groupe_de_boutons_1 = new ButtonGroup();
			this.groupe_de_boutons_1.add(this.bouton_radio_categorie_normal);
			this.groupe_de_boutons_1.add(this.bouton_radio_categorie_administrateur);
			
			this.GBC1.gridx = 1;
			this.GBC1.gridy = 6;
			this.GBC1.gridwidth = 1;
			this.GBC1.fill = GridBagConstraints.NONE;
			this.add(this.bouton_radio_categorie_normal,this.GBC1);
			
			this.GBC1.gridx = 2;
			this.GBC1.gridy = 6;
			this.GBC1.gridwidth = 1;
			this.GBC1.fill = GridBagConstraints.NONE;
			this.add(this.bouton_radio_categorie_administrateur,this.GBC1);
			
			// Le bouton pour s'enregistrer
			this.bouton_enregistrement = new JButton("S'enregistrer");
			this.GBC1.gridx = 1;
			this.GBC1.gridy = 7;
			this.GBC1.gridwidth = 1;
			this.GBC1.fill = GridBagConstraints.HORIZONTAL;
			this.bouton_enregistrement.setBackground(Color.WHITE);
			this.bouton_enregistrement.setForeground(this.couleur_ECE);
			this.add(this.bouton_enregistrement,this.GBC1);
			
			// Le bouton pour passer vers le formulaire de connexion
			this.bouton_vers_connexion = new JButton("Se connecter");
			this.GBC1.gridx = 2;
			this.GBC1.gridy = 7;
			this.GBC1.gridwidth = 1;
			this.GBC1.fill = GridBagConstraints.HORIZONTAL;
			this.bouton_vers_connexion.setBackground(this.couleur_ECE);
			this.bouton_vers_connexion.setForeground(Color.WHITE);
			this.add(this.bouton_vers_connexion,this.GBC1);
			this.bouton_vers_connexion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO : Ajouter le code pour se connecter à Booking.ece.
					try {
						moveToPage("connexion");
					} catch (PageNotFoundException ex) {
						throw new RuntimeException(ex);
					}
				}
			});
			this.bouton_enregistrement.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO : Ajouter le code pour passer au formulaire d'enregistrement.
					try {
						moveToPage("accueil");
					} catch (PageNotFoundException ex) {
						throw new RuntimeException(ex);
					}
				}
			});
		}
		/*
		public static void main( String args[] ) {
			JFrame frame_test_1 = new JFrame("Démonstration formulaire enregistrement : ");
			frame_test_1.setSize(960,710);
			frame_test_1.setResizable(false);
			FormulaireEnregistrement FE1 = new FormulaireEnregistrement( new navigation() , "enregistrement" );
			frame_test_1.add(FE1);
			frame_test_1.setVisible(true);
		}*/
		
}
