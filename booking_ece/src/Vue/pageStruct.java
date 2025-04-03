package Vue;

import javax.swing.*;
import java.awt.*;

// classe mère de toutes les pages qui contient les méthodes de navigation
public class pageStruct extends JPanel {
    navigation nav;
    public pageStruct( navigation nav , String name) {
        this.nav = nav;
        nav.addpage(this, name);
        setLayout(new BorderLayout());
        setSize(600, 600);
        setName(name);
        setVisible(true);
        setBackground(Color.LIGHT_GRAY);
        JLabel label = new JLabel(name, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);
    } // constructeur de la classe pageStruct

    // méthode pour ajouter une navbar à la page
    public void addNavBar() {
        JPanel navBar = new JPanel();
        navBar.setLayout(new FlowLayout());
        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(e -> {
            try {
                moveToPage("Home");
            } catch (PageNotFoundException ex) {

                throw new RuntimeException(ex);
            }
        });
        navBar.add(homeButton);
        add(navBar, BorderLayout.NORTH);
    }
    // méthode pour ajouter une toolbar à la page
    public void addToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setOrientation(SwingConstants.VERTICAL);
        JCheckBox checkBox = new JCheckBox();
        // met un texte de présentation sur le checkbox
        JTextArea textArea = new JTextArea(1, 20);
        // set la taille de la zone de texte
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
        add(toolBar, BorderLayout.WEST);
    }
    // méthode pour naviguer vers une autre page
    public void moveToPage(String pageName) throws PageNotFoundException {
        try {
            nav.showCard(pageName);
        } catch (Exception e) {
            throw new PageNotFoundException("Page not found: " + pageName);
        }finally {
            moveToPage("Erreur");
        }
    }
    // méthode pour revenir à la page précédente
    public void previousPage() {
        nav.nextPage();
    }
}
