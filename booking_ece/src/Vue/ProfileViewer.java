package Vue;
import javax.swing.*;
import java.awt.*;

public class ProfileViewer extends JPanel {
	
	private JLabel label_nom_utilisateur;
	private Font police_ecriture_nom_utilisateur;
	private Color couleur_ECE;
	
	public ProfileViewer( String in_nom_utilisateur ) {
		super();
		this.couleur_ECE = new Color(0,115,123);
		this.police_ecriture_nom_utilisateur = new Font("Cascadia Code",Font.PLAIN,15);
		this.setMinimumSize(new Dimension(960,710));
		this.setMaximumSize( new Dimension(3000,50) );
		
		this.setLayout(new BorderLayout());
		this.setBackground(this.couleur_ECE);
		
		this.label_nom_utilisateur = new JLabel("Bienvenue à Booking.ECE, " + in_nom_utilisateur + " !");
		this.label_nom_utilisateur.setFont(this.police_ecriture_nom_utilisateur);
		this.label_nom_utilisateur.setForeground(Color.WHITE);
		this.add(this.label_nom_utilisateur,BorderLayout.LINE_START);
		
	}
	
	// Méthode pour changer le nom d'utilisateur affiché dans le profile viewer.
	// Ne sera utile qu'après la connexion ou l'enregistrement d'un nouveau utilisateur.
	public void changer_nom_utilisateur( String in_nom ) {
		this.label_nom_utilisateur.setText("Bienvenue à Booking.ECE, " + in_nom + " !");
		this.revalidate();
		this.repaint();
	}
	
	public static void main(String args[]) {
		JFrame frame_test_1 = new JFrame("Demonstration ProfileViewer");
		frame_test_1.setSize(960,710);
		frame_test_1.setLayout(new BoxLayout(frame_test_1.getContentPane(),BoxLayout.PAGE_AXIS));
		ProfileViewer PV1 = new ProfileViewer("Antoine");
		frame_test_1.add(PV1);
		frame_test_1.setVisible(true);
	}
	
}
