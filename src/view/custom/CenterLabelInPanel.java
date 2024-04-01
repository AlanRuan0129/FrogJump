package view.custom;

import javax.swing.*;
import java.awt.*;

public class CenterLabelInPanel extends JPanel {
    public CenterLabelInPanel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, fontSize));
        setPreferredSize(new Dimension(500, 30));
        add(label);
        setBackground(Color.WHITE);
    }

}
