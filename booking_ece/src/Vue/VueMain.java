package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// crée un class navigation qui contirendra les méthodes de navigation entre les pages et toures les page


public class VueMain {
    public static void main(String[] args) {
        navigation nav = new navigation();
        FormulaireEnregistrement FE1 = new FormulaireEnregistrement(  nav , "enregistrement" );
        FormulaireConnexion FC1 = new FormulaireConnexion( nav , "connexion" );
        filtre ft = new filtre( nav , "accueil" );
        ft.addToolBar();
        ft.addNavBar();
        nav.showCard("accueil");
        nav.SetVisible(true);
    }
}
