package Vue;

import javax.swing.*;
import java.awt.*;

public class filtre extends pageStruct {

    public filtre(navigation nav, String name) {
        super(nav, name);
    }

    @Override
    public void addToolBar() {
        // Appeler la méthode de la classe parente pour configurer la barre d'outils de base
        super.addToolBar();

        // Créer un panneau pour les filtres avec GridLayout
        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new GridLayout(14, 1)); // 14 lignes, 1 colonne

        // Ajouter des options de filtrage avec des bordures pour l'espacement
        filterPanel.add(createCheckBoxWithBorder("Moins de 3 km"));
        filterPanel.add(createCheckBoxWithBorder("Moins de 5 km"));
        filterPanel.add(createCheckBoxWithBorder("Paiement en ligne"));
        filterPanel.add(createCheckBoxWithBorder("PayPal"));
        filterPanel.add(createCheckBoxWithBorder("Pour passer un bon moment"));
        filterPanel.add(createCheckBoxWithBorder("Parcours de golf (à moins de 3 km)"));
        filterPanel.add(createCheckBoxWithBorder("Restaurant"));
        filterPanel.add(createCheckBoxWithBorder("Équitation"));
        filterPanel.add(createCheckBoxWithBorder("Plage"));
        filterPanel.add(createCheckBoxWithBorder("Vue"));
        filterPanel.add(createCheckBoxWithBorder("Les animaux sont les bienvenus"));
        filterPanel.add(createCheckBoxWithBorder("Toutes les offres"));
        filterPanel.add(createCheckBoxWithBorder("Réception 24h/24"));
        filterPanel.add(createCheckBoxWithBorder("Ménage quotidien 24h/24"));



        // Ajouter le panneau de filtres à la barre d'outils
        JToolBar toolBar = new JToolBar();
        toolBar.setOrientation(SwingConstants.VERTICAL);
        toolBar.add(new JLabel("Filtres de recherche"));
        toolBar.add(filterPanel);

        // Ajouter la barre d'outils à la partie OUEST du BorderLayout
        add(toolBar, BorderLayout.WEST);
    }

    private JCheckBox createCheckBoxWithBorder(String label) {
        JCheckBox checkBox = new JCheckBox(label);
        checkBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Ajouter un espacement de 5 pixels autour
        return checkBox;
    }
}
