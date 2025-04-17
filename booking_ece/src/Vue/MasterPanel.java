package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import Controler.FormulaireConnexion_controler;
import Controler.FormulaireEnregistrement_controler;
import Controler.ListingHebergement_controler;

// classe navigation qui gère la navigation entre les différentes pages de l'application
public class MasterPanel extends JPanel {
	
	final static public String INDICE_CONNEXION = "connexion";
	final static public String INDICE_ENREGISTREMENT = "enregistrement";
	final static public String INDICE_LISTING = "listing";
	
    private CardLayout cardLayout; // gestionnaire de mise en page
    public String SESSION_nom_utilisateur;
    
    public FormulaireConnexion_controler FCC1;
    public FormulaireEnregistrement_controler FEC1;
    public ListingHebergement_controler LHC1;
    
    // Constructeur pour la navigation.
    // Initialise le cardLayout pour ajouter tous les sous-fenêtres de l'application.
    public MasterPanel() {
    	
    	super();
    	
        this.cardLayout = new CardLayout();
        this.setLayout(this.cardLayout);
        this.SESSION_nom_utilisateur = "GUEST 101";
        
        this.FCC1 = new FormulaireConnexion_controler();
        this.FEC1 = new FormulaireEnregistrement_controler();
        this.LHC1 = new ListingHebergement_controler(this.SESSION_nom_utilisateur);
        
        // Ajout des sous-fenêtre...
        this.add(this.FCC1,MasterPanel.INDICE_CONNEXION);
        this.add(this.FEC1,MasterPanel.INDICE_ENREGISTREMENT);
        this.add(this.LHC1,MasterPanel.INDICE_LISTING);
        
        // Le formulaire de connexion sera le point de départ de l'application.
        this.cardLayout.show(this, INDICE_CONNEXION);
        
        
    }
    
    // Programme de démonstration de l'application.
    public static void main( String args[] ) {
    	
    	JFrame frame_test_1 = new JFrame("Demo MasterPanel // Booking.ECE");
    	frame_test_1.setSize(960,710);
    	MasterPanel NAV1 = new MasterPanel();
    	frame_test_1.add(NAV1);
    	frame_test_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame_test_1.setVisible(true);
    	
    }
    
    public void update_nom(String in_nom) {
    	this.LHC1.PV1.changer_nom_utilisateur(in_nom);
    }
    
    
}
