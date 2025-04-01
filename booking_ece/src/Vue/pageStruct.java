package Vue;

import javax.swing.*;

public class pageStruct extends JPanel {
    navigation nav;
    public pageStruct( navigation nav) {
        this.nav = nav;
    }
    public void moveToPage(String pageName) throws PageNotFoundException {
        nav.showCard(pageName);
    }
}
