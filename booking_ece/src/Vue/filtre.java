package Vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Page "filtre" intégrant la barre d'outils de filtres, la barre de navigation
 * et l'affichage dynamique des annonces dans la zone centrale.
 */
public class filtre extends pageStruct {

    JPanel filterPanel = new JPanel();

    public filtre(navigation nav, String name) {
        super(nav, name);
        initPage(name);
        // Ajout de l'affichage dynamique des annonces dans la zone centrale
        addAnnoncesPanel();
    }

    @Override
    public JToolBar addToolBar() {
        // Création de la barre d'outils verticale pour les filtres de recherche
        JToolBar toolBar = new JToolBar();
        toolBar.setOrientation(SwingConstants.VERTICAL);
        toolBar.add(new JLabel("Filtres de recherche"));
        // Ajout des cases à cocher avec un espacement
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

        // Encastrer la barre dans un JScrollPane afin de permettre le scroll si besoin
        JScrollPane scrollPane = new JScrollPane(toolBar);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(200, 600));

        // Style de la barre de défilement
        UIManager.put("ScrollBar.thumb", new Color(0, 115, 123));
        UIManager.put("ScrollBar.track", Color.LIGHT_GRAY);
        UIManager.put("ScrollBar.width", 7);
        SwingUtilities.updateComponentTreeUI(scrollPane);

        // Positionnement de la barre de filtres à gauche
        add(scrollPane, BorderLayout.WEST);

        return toolBar;
    }

    @Override
    public JPanel addNavBar() {
        JPanel navBar = super.addNavBar();
        JButton connexion = new JButton("Connexion");
        connexion.setBackground(new Color(0, 115, 123));
        connexion.setForeground(Color.WHITE);
        connexion.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
        connexion.addActionListener(e -> {
            try {
                moveToPage("connexion");
            } catch (PageNotFoundException ex) {
                nav.erreur404();
            }
        });
        navBar.add(connexion);
        navBar.setVisible(true);
        return navBar;
    }

    /**
     * Création d'une case à cocher avec un espacement interne.
     */
    private JCheckBox createCheckBoxWithBorder(String label) {
        JCheckBox checkBox = new JCheckBox(label);
        checkBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return checkBox;
    }

    /**
     * Ajoute le panneau d'annonces au centre de la page.
     * Ce panneau est constitué d'un JPanel à layout vertical, encastré dans un JScrollPane.
     */
    private void addAnnoncesPanel() {
        // Panneau contenant toutes les annonces
        JPanel annoncesPanel = new JPanel();
        annoncesPanel.setLayout(new BoxLayout(annoncesPanel, BoxLayout.Y_AXIS));
        annoncesPanel.setBackground(Color.WHITE);

        // Récupération simulée des données d'annonces (remplacer par la lecture de votre base)
        List<Annonce> annonces = getAnnoncesFromDatabase();

        // Pour chaque annonce, crée un panneau d'annonce stylisé
        for (Annonce annonce : annonces) {
            AnnouncementPanel announcementPanel = new AnnouncementPanel(annonce);
            // Encadrement et marges pour une meilleure lisibilité
            announcementPanel.setBorder(new CompoundBorder(
                    new LineBorder(new Color(200, 200, 200), 1, true),
                    new EmptyBorder(10, 10, 10, 10)
            ));
            annoncesPanel.add(announcementPanel);
            annoncesPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // Encapsuler le panneau d'annonces dans un JScrollPane pour gérer le défilement vertical
        JScrollPane annoncesScroll = new JScrollPane(annoncesPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        annoncesScroll.getVerticalScrollBar().setUnitIncrement(16);
        annoncesScroll.setBorder(null);
        UIManager.put("ScrollBar.thumb", new Color(0, 115, 123));
        UIManager.put("ScrollBar.track", Color.LIGHT_GRAY);
        UIManager.put("ScrollBar.width", 7);
        SwingUtilities.updateComponentTreeUI( annoncesScroll);

        add(annoncesScroll, BorderLayout.CENTER);
    }

    /**
     * Simulation de récupération d'annonces depuis une base de données.
     */
    private List<Annonce> getAnnoncesFromDatabase() {
    //TODO : Remplacer par la récupération réelle des données
        List<Annonce> data = new ArrayList<>();
        data.add(new Annonce("Hôtel Arconte **** - Situation géographique 9,3 - Prix : 1761 €", "hotel1.png"));
        data.add(new Annonce("SLS Barcelone ***** - Vue mer, Piscine sur le toit - Prix : 1847 €", null));
        data.add(new Annonce("Petit appartement cosy en plein centre - Prix : 120 €", "appartement.png"));
        data.add(new Annonce("Villa avec jardin privatif - Piscine - Prix : 350 €", null));
        data.add(new Annonce("Auberge de jeunesse - Dortoir 6 lits - Prix : 25 €", "auberge.png"));
        data.add(new Annonce("Appartement familial - 3 chambres - Prix : 200 €", null));
        data.add(new Annonce("Chambre d'hôte charmante - Prix : 90 €", "chambre.png"));
        return data;
    }

    public static void main(String[] args) {
        navigation nav = new navigation();
        filtre ft = new filtre(nav, "Filtre");
        ft.addToolBar();
        ft.addNavBar();
        nav.SetVisible(true);
    }
}

/**
 * Classe représentant les données d'une annonce.
 */
class Annonce {
    private String titre;
    private String imagePath; // Chemin vers l'image associée (peut être null)

    public Annonce(String titre, String imagePath) {
        this.titre = titre;
        this.imagePath = imagePath;
    }

    public String getTitre() {
        return titre;
    }

    public String getImagePath() {
        return imagePath;
    }
}

/**
 * Panneau personnalisé pour l'affichage d'une annonce.
 * Chaque panneau possède une taille minimale et maximale pour éviter d'occuper toute la page.
 * Si aucune image n'est fournie, une image par défaut est utilisée.
 */
class AnnouncementPanel extends JPanel {

    // Définition des dimensions minimales, préférées et maximales
    private static final Dimension MIN_SIZE = new Dimension(400, 150);
    private static final Dimension PREF_SIZE = new Dimension(900, 150);
    private static final Dimension MAX_SIZE = new Dimension(900, 150);

    // Chemin de l'image par défaut
    private static final String DEFAULT_IMAGE_PATH = "booking_ece/Images/default.png";

    private Annonce annonce;

    public AnnouncementPanel(Annonce annonce) {
        this.annonce = annonce;
        initUI();
    }

    /**
     * Initialise l'interface du panneau d'annonce.
     */
    private void initUI() {
        // Fixation des dimensions de l'annonce
        setMinimumSize(MIN_SIZE);
        setPreferredSize(PREF_SIZE);
        setMaximumSize(MAX_SIZE);
        setBackground(Color.WHITE);
        setLayout(new BorderLayout(10, 10));

        // Chargement de l'image (si introuvable, l'image par défaut est utilisée)
        ImageIcon icon = createImageIcon(annonce.getImagePath());
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setPreferredSize(new Dimension(120, 120));
        imageLabel.setBorder(new LineBorder(Color.LIGHT_GRAY));

        // Création d'un panel central pour le contenu textuel et le bouton
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setOpaque(false);

        // Titre de l'annonce avec style
        JLabel lblTitre = new JLabel(annonce.getTitre());
        lblTitre.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblTitre.setForeground(new Color(50, 50, 50));

        // Bouton d'action (par exemple, pour voir les détails)
        JButton btnDetails = new JButton("Voir détails");
        btnDetails.setBackground(new Color(66, 133, 244));
        btnDetails.setForeground(Color.WHITE);
        btnDetails.setFocusPainted(false);

        // Ajout du titre dans un panel pour un meilleur alignement
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setOpaque(false);
        titlePanel.add(lblTitre);

        centerPanel.add(titlePanel, BorderLayout.CENTER);
        centerPanel.add(btnDetails, BorderLayout.EAST);

        // Placement de l'image et du contenu dans le panneau principal de l'annonce
        add(imageLabel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * Méthode utilitaire de création d'un ImageIcon.
     * Si le chemin fourni est null ou si l'image n'est pas trouvée,
     * l'image par défaut est chargée.
     */
    private ImageIcon createImageIcon(String path) {
        ImageIcon icon = null;
        if (path != null) {
            icon = new ImageIcon(path);
            // Vérifie que l'image a été correctement chargée
            if (icon.getIconWidth() <= 0) {
                icon = null;
            }
        }
        if (icon == null) {
            icon = new ImageIcon(DEFAULT_IMAGE_PATH);
        }
        // Redimensionnement de l'image pour qu'elle tienne dans le panneau (120x120 pixels)
        Image image = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}
