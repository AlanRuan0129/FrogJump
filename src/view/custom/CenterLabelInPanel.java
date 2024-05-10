package view.custom;

import javax.swing.*;
import java.awt.*;

/**
 * The CenterLabelInPanel class provides a panel that contains a centered text label.
 * This custom panel is dedicated to displaying text and can specify the font size.
 * The background of the panel is set to white by default, and the size is fixed width and height.
 *
 * @author Pengyuan Wei
 * @version 1.0
 * @since 2024/3/29
 */
public class CenterLabelInPanel extends JPanel {

    /**
     * Creates a new CenterLabelInPanel instance with the center aligned labels.
     * @param text The string of text to display in the tag
     * @param fontSize The font size of the label text
     */
    public CenterLabelInPanel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, fontSize));
        setPreferredSize(new Dimension(500, 30));
        add(label);
        setBackground(Color.WHITE);
    }

}
