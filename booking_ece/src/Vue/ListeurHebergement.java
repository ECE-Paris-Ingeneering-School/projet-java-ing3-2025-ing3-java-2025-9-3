package Vue;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import Modele.Hebergement;
import Vue.HebergementCellule;

public class ListeurHebergement extends JPanel {
	
	public JScrollPane JSP1;
	public JPanel contentPanel;
	
	// Constructeur sans paramètre.
	public ListeurHebergement() {
		
		super();
		
        this.setLayout(new BorderLayout());

        this.contentPanel = new JPanel();
        this.contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        this.contentPanel.setBackground(Color.LIGHT_GRAY);

        this.JSP1 = new JScrollPane(contentPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(this.JSP1, BorderLayout.CENTER);
        
	}
	
	// Programme main pour la démonstration du listeur d'hébergements SANS controleur.
	public static void main(String args[]) {
		
		JFrame frame_test_1 = new JFrame("Demonstration ListeurHebergement");
		frame_test_1.setSize(960,310);
		
		ListeurHebergement LH1 = new ListeurHebergement();
		frame_test_1.add(LH1.JSP1);
		
		frame_test_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_test_1.setVisible(true);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(700,600);
	}
	
	// Méthode pour ajouter tous les hébergements dans le listeur sous forme de cellules d'hébergement.
	public void ajouterHebergementCellules( ArrayList<Hebergement> liste_in ) {
		contentPanel.removeAll();
        for (Hebergement h : liste_in) {
            HebergementCellule cellule = new HebergementCellule(h.titre, h.description, h.categorie, h.rang, h.prix);
            cellule.setAlignmentX(Component.LEFT_ALIGNMENT);
            contentPanel.add(cellule);
        }
        contentPanel.revalidate();
        contentPanel.repaint();

        SwingUtilities.invokeLater(() -> {
            JScrollBar verticalBar = JSP1.getVerticalScrollBar();
            verticalBar.setValue(verticalBar.getMaximum());
        });	
	}
	
	
}
