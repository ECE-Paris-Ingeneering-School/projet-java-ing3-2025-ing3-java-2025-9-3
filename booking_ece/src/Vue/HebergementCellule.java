package Vue;
import java.awt.*;
import javax.swing.*;

public class HebergementCellule extends JPanel {

	protected String titre;
	protected String description;
	protected String categorie;
	protected int rang;
	protected int prix;
	public Font font_titre;
	public Font font_categorie;
	public Font font_description;
	public JButton bouton_revue;
	public Color couleur_ECE;
	
	public HebergementCellule(String in_titre, String in_description, String in_categorie , int in_rang , int in_prix ) {
		super();
		
		this.font_titre = new Font("Cambria",Font.BOLD,20);
		this.font_categorie = new Font("Cambria",Font.ITALIC,16);
		this.font_description = new Font("Cambria",Font.PLAIN,12);
		this.couleur_ECE = new Color(0,115,123);
		
		this.setMinimumSize(this.getPreferredSize());
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(new Color(123,123,123),2));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		this.titre = in_titre;
		this.description = in_description;
		this.categorie = in_categorie;
		this.rang = in_rang;
		this.prix = in_prix;
		
		JLabel titreLabel = new JLabel(this.titre);
		titreLabel.setFont(this.font_titre);
		
		JLabel categorieLabel = new JLabel(this.categorie);
		categorieLabel.setFont(this.font_categorie);
		
		JLabel descriptionLabel = new JLabel(this.description);
		descriptionLabel.setFont(this.font_categorie);
		
		JLabel rangLabel = new JLabel("Rang : "+this.rang);
		JLabel prixLabel = new JLabel("Prix : "+this.prix+" euros/semaine");
		
		this.bouton_revue = new JButton("Consulter");
		this.bouton_revue.setBackground(this.couleur_ECE);
		this.bouton_revue.setForeground(Color.WHITE);
		
		this.add( titreLabel );
		this.add( categorieLabel );
		this.add( descriptionLabel );
		this.add( rangLabel );
		this.add( prixLabel );
		this.add(this.bouton_revue);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(900,150);
	}
	
		public static void main( String args[] ) {
			JFrame frame_test_1 = new JFrame("Démonstration HebergementCellule");
			frame_test_1.setSize(960,710);
			frame_test_1.setLayout(new FlowLayout());
			HebergementCellule HC1 = new HebergementCellule("Hebergement TEST","Ceci est un fameux hébergement youpi.","Appartement",5,1000);
			frame_test_1.add(HC1);
			frame_test_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame_test_1.setVisible(true);
		}
		
	
	
}
