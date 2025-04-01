package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PageNotFoundException extends Exception {
    public PageNotFoundException(String message) {
        super(message);
        AffPageNotFoundException(message);
    }
    public void AffPageNotFoundException(String message) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel(message, SwingConstants.CENTER);
        JButton button = new JButton("OK");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
