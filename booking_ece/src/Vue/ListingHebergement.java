package Vue;
import java.awt.*;
import javax.swing.*;

import Vue.HebergementCellule;
import Vue.ProfileViewer;

import java.util.*;

public class ListingHebergement extends JPanel {
	
	protected ProfileViewer PV1;
	public FiltreurHebergement FH1;
	public ListeurHebergement LH1;
	protected JScrollPane JSP1;
	
	// Le constructeur prend en paramètre le nom d'utilisateur du client qui vient de se connecter.
	public ListingHebergement( String in_nom_utilisateur ) {
		
		super();
		this.setLayout(new BorderLayout());
	
		this.PV1 = new ProfileViewer(in_nom_utilisateur);
		this.add(this.PV1,BorderLayout.NORTH);
		
		this.FH1 = new FiltreurHebergement();
		this.add(this.FH1,BorderLayout.WEST);
		
		this.LH1 = new ListeurHebergement();
		this.add(this.LH1,BorderLayout.CENTER);
		
	}
	
	// Programme main pour la démonstration du composant listinghebergement SANS controleur.
	public static void main(String args[]) {
		JFrame frame_test_1 = new JFrame("Demonstration ListingHebergement");
		frame_test_1.setSize(960,710);
		ListingHebergement LH1 = new ListingHebergement("AntoinePOIRIER");
		frame_test_1.add(LH1);
		frame_test_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_test_1.setVisible(true);
	}
	
}
