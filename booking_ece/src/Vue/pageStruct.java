package Vue;

import javax.swing.*;
import java.awt.*;

// Classe mère de toutes les pages qui contient les méthodes de navigation
public class pageStruct extends JPanel {
    navigation nav;

    public pageStruct(navigation nav, String name) {
        this.nav = nav;
        nav.addpage(this, name);

    }
    // Méthode qui initialise une default page
    public void initPage( String name) {
        setLayout(new BorderLayout());
        setSize(600, 600);
        setName(name);
        setBackground(Color.LIGHT_GRAY);
        JLabel label = new JLabel(name, SwingConstants.CENTER);
        label.setFont(new Font("Cascadia Code",Font.PLAIN, 24));
        add(label, BorderLayout.CENTER);
    }

    // Méthode pour ajouter une navbar à la page
    public JPanel addNavBar() {

        JPanel navBar = new JPanel();
        navBar.setLayout(new FlowLayout());
        JButton homeButton = new JButton("Accueil");
        homeButton.setPreferredSize(new Dimension(100, 30));
        Color couleur_ECE = new Color(0,115,123);
        homeButton.setBackground(couleur_ECE);
        homeButton.setForeground(Color.WHITE);
        homeButton.setFont(new Font("Cascadia Code",Font.PLAIN,14));
        homeButton.addActionListener(e -> {
            try {
                moveToPage("accueil");
            } catch (PageNotFoundException ex) {
                nav.erreur404();
            }
        });
        navBar.add(homeButton);
        boolean added = false;
        try {
            add(navBar, BorderLayout.NORTH);
            added = true;
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de la barre de navigation : " + e.getMessage());
            e.printStackTrace();
        }/*
        if (!added) {
            try {
                add(navBar);
            } catch (Exception e) {
                System.out.println("Erreur avec GridBagConstraints : " + e.getMessage());
                e.printStackTrace();
            }
        }*/
        return navBar;
    }

    // Méthode pour ajouter une toolbar à la page
    public JToolBar addToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setOrientation(SwingConstants.VERTICAL);
        JCheckBox checkBox = new JCheckBox();
        JTextArea textArea = new JTextArea(1, 20);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(200, 50));
        textArea.setMaximumSize(new Dimension(200, 25));
        textArea.setText("Filtre de recherche");
        checkBox.setText("Filtre");
        checkBox.setSelected(false);
        checkBox.addActionListener(e -> {
            if (checkBox.isSelected()) {
                System.out.println("Filtre activé");
            } else {
                System.out.println("Filtre désactivé");
            }
        });
        toolBar.add(textArea, BorderLayout.CENTER);
        toolBar.add(checkBox, BorderLayout.SOUTH);
        boolean added = false;
        try {
            add(toolBar, BorderLayout.WEST);
            added = true;
        }
        catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de la barre d'outils : " + e.getMessage());
            e.printStackTrace();
        }
        if (!added) {
            try {
                add(toolBar, new GridBagConstraints());
            } catch (Exception e) {
                System.out.println("Erreur avec GridBagConstraints : " + e.getMessage());
                e.printStackTrace();
            }
            finally {
                add(toolBar);
            }
        }
        return toolBar;
    }

    // Méthode pour naviguer vers une autre page
    public void moveToPage(String pageName) throws PageNotFoundException {
        try {
            nav.showCard(pageName);
        } catch (Exception e) {
            throw new PageNotFoundException("Page not found: " + pageName);
        }
    }

    // Méthode pour revenir à la page précédente
    public void previousPage() {
        nav.nextPage();
    }
}
