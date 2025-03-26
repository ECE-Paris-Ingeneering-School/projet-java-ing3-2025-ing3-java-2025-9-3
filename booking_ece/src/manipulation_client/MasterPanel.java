package manipulation_client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MasterPanel extends JPanel {
	
	public CardLayout card_layout;
	private ConnexionForm connection_form;
	private InscriptionForm inscription_form;
	private ListeurHebergement HL1;
	
	public MasterPanel() {
		
		super();
		this.card_layout = new CardLayout();
		this.connection_form = new ConnexionForm();
		this.inscription_form = new InscriptionForm();
		this.HL1 = new ListeurHebergement();
		
		setLayout(this.card_layout);
		setSize(600,600);
		
		this.add(this.connection_form,"CONNEXION");
		this.add(this.inscription_form,"INSCRIPTION");
		this.add(this.HL1,"LISTEUR_HEBERGEMENT");
	
	}
	
}
