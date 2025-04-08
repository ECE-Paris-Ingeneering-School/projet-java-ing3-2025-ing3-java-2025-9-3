package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Classe navigation qui gère la navigation entre les différentes pages de l'application
public class navigation {
    private JFrame frame = new JFrame("Booking.ECE");
    private CardLayout cardLayout; // gestionnaire de mise en page
    private JPanel mainPanel; // panneau principal qui contiendra toutes les pages

    public navigation() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        cardLayout = new CardLayout();
        mainPanel = new JPanel();
        mainPanel.setLayout(cardLayout);
        frame.add(mainPanel);
    }

    public void erreur404() {
        // Méthode pour afficher une erreur 404
        JPanel panel = new JPanel();
        panel.setName("Erreur");
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("Page non trouvée", SwingConstants.CENTER);
        JButton button = new JButton("OK");
        button.addActionListener(e -> nextPage());
        panel.add(label, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);
        mainPanel.add(panel, "Erreur");
        cardLayout.show(mainPanel, "Erreur");
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // Méthode pour ajouter une page au panneau principal
    public void addpage(pageStruct page, String cardName) {
        mainPanel.add(page, cardName);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // Méthode pour supprimer une page du panneau principal (pas encore testé)
    public void removePage(String cardName) {
        Component[] components = mainPanel.getComponents();
        for (Component component : components) {
            if (component.getName() != null && component.getName().equals(cardName)) {
                mainPanel.remove(component);
                break;
            }
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // Méthode pour afficher une page en fonction de son nom
    public void showCard(String cardName) {
        cardLayout.show(mainPanel, cardName);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // Méthode pour revenir à la page précédente
    public void nextPage() {
        cardLayout.next(mainPanel);
    }

    // Méthode pour afficher la fenêtre principale
    public void SetVisible(boolean b) {
        frame.setVisible(b);
    }
}
