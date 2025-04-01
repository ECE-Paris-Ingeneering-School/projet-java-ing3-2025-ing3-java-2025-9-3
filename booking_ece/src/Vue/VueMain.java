package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// crée un class navigation qui contirendra les méthodes de navigation entre les pages et toures les page


public class VueMain {
    public static void main(String[] args) {
        navigation nav = new navigation();
        pageStruct panel = new pageStruct(nav);
        panel.setName("Page1");
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("Page 1"), BorderLayout.CENTER);
        JButton nextButton = new JButton("Next");
        panel.add(nextButton, BorderLayout.SOUTH);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    panel.moveToPage("Page2");
                } catch (PageNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        pageStruct panel2 = new pageStruct(nav);
        panel2.setName("Page2");
        panel2.setLayout(new BorderLayout());
        panel2.add(new JLabel("Page 2"), BorderLayout.CENTER);
        JButton prevButton = new JButton("Previous");
        panel2.add(prevButton, BorderLayout.SOUTH);
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    panel2.moveToPage("Page3");
                } catch (PageNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        nav.addpage(panel, "Page1");
        nav.addpage(panel2, "Page2");
        // set panel to page 1
    }
}
