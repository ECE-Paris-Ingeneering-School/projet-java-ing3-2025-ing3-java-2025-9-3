package Vue;

import javax.swing.*;
import java.awt.*;


public class navigation {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    public navigation() {
        JFrame frame = new JFrame("Booking.ECE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    public void addpage(pageStruct page, String cardName) {
        mainPanel.add(page, cardName);
    }
    public void removePage(String cardName) {
        Component[] components = mainPanel.getComponents();
        for (Component component : components) {
            if (component.getName() != null && component.getName().equals(cardName)) {
                mainPanel.remove(component);
                break;
            }
        }
    }
    public void showCard(String cardName) {
        cardLayout.show(mainPanel, cardName);
    }
    public void nextPage(pageStruct panel) {
        cardLayout.next(mainPanel);
    }
    public void setpage(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }
}
