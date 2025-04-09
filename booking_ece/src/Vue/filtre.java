package Vue;

import javax.swing.*;
import java.awt.*;

public class filtre extends pageStruct {

    public filtre(navigation nav, String name) {
        super(nav, name);
        initPage(name);
    }
    JPanel filterPanel = new JPanel();
    @Override
    public JToolBar addToolBar() {
        // Créer la barre d'outils
        JToolBar toolBar = new JToolBar();
        toolBar.setOrientation(SwingConstants.VERTICAL);
        toolBar.add(new JLabel("Filtres de recherche"));

        // Ajouter des composants à la barre d'outils
        toolBar.add(createCheckBoxWithBorder("Moins de 3 km"));
        toolBar.add(createCheckBoxWithBorder("Moins de 5 km"));
        toolBar.add(createCheckBoxWithBorder("Paiement en ligne"));
        toolBar.add(createCheckBoxWithBorder("PayPal"));
        toolBar.add(createCheckBoxWithBorder("Pour passer un bon moment"));
        toolBar.add(createCheckBoxWithBorder("Parcours de golf (à moins de 3 km)"));
        toolBar.add(createCheckBoxWithBorder("Restaurant"));
        toolBar.add(createCheckBoxWithBorder("Équitation"));
        toolBar.add(createCheckBoxWithBorder("Plage"));
        toolBar.add(createCheckBoxWithBorder("Vue"));
        toolBar.add(createCheckBoxWithBorder("Les animaux sont les bienvenus"));
        toolBar.add(createCheckBoxWithBorder("Toutes les offres"));
        toolBar.add(createCheckBoxWithBorder("Réception 24h/24"));
        toolBar.add(createCheckBoxWithBorder("Ménage quotidien 24h/24"));

        // Ajouter un JScrollPane pour permettre le défilement
        JScrollPane scrollPane = new JScrollPane(toolBar);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // configurer la taille du JScrollPane
        scrollPane.setPreferredSize(new Dimension(200, 600));
        UIManager.put("ScrollBar.thumb", new Color(0, 115, 123)); // Couleur de la poignée
        UIManager.put("ScrollBar.track", Color.LIGHT_GRAY);       // Couleur de la piste
        UIManager.put("ScrollBar.width", 3);                    // Largeur de la barre
        SwingUtilities.updateComponentTreeUI(scrollPane);
        // Ajouter le JScrollPane au conteneur principal
        add(scrollPane, BorderLayout.WEST);

        return toolBar;
    }

    @Override
    public JPanel addNavBar() {
        JPanel navBar = super.addNavBar();
        JButton Connexion = new JButton("Connexion");
        Connexion.setBackground(new Color(0,115,123));
        Connexion.setForeground(Color.WHITE);
        Connexion.setFont(new Font("Cascadia Code",Font.PLAIN,14));
        Connexion.addActionListener(e -> {
            try {
                moveToPage("connexion");
            } catch (PageNotFoundException ex) {
                nav.erreur404();
            }
        });
        navBar.add(Connexion);
        navBar.setVisible(true);
        return navBar;
    }

    private JCheckBox createCheckBoxWithBorder(String label) {
        JCheckBox checkBox = new JCheckBox(label);
        checkBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Ajouter un espacement de 5 pixels autour
        return checkBox;
    }
}
