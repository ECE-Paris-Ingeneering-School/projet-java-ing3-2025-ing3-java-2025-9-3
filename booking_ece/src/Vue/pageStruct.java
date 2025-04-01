package Vue;

import javax.swing.*;

// classe mère de toutes les pages qui contient les méthodes de navigation
public class pageStruct extends JPanel {
    navigation nav;
    public pageStruct( navigation nav) {
        this.nav = nav;
    } // constructeur de la classe pageStruct

    // méthode pour naviguer vers une autre page
    public void moveToPage(String pageName) throws PageNotFoundException {
        nav.showCard(pageName);
    }
    // méthode pour revenir à la page précédente
    public void previousPage() {
        nav.nextPage(this);
    }
}
