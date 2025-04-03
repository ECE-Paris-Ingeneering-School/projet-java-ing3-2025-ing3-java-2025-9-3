package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// crée un class navigation qui contirendra les méthodes de navigation entre les pages et toures les page


public class VueMain {
    public static void main(String[] args) {
        navigation nav = new navigation();
        pageStruct panel = new pageStruct(nav, "Page 1");
        panel.addNavBar(); // ajoute une barre de navigation à la page
        panel.addToolBar(); // ajoute une barre d'outils à la page
        nav.showCard("Page 1"); // affiche la page 1
        nav.SetVisible(true);
    }
}
