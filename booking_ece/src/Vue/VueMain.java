package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// crée un class navigation qui contirendra les méthodes de navigation entre les pages et toures les page


public class VueMain {
    public static void main(String[] args) {
        navigation nav = new navigation();
        filtre ft = new filtre(nav, "accueil");
        ft.addNavBar();
        ft.addToolBar();
        nav.SetVisible(true);


    }
}
