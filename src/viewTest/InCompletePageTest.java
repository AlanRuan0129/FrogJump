package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class InCompletePageTest {
    private InCompletePage incompletePage;

    @BeforeEach
    void setUp() {
        SwingUtilities.invokeLater(() -> {
            incompletePage = new InCompletePage(100);
            incompletePage.setVisible(true);
        });
    }

    @AfterEach
    void tearDown() {
        if (incompletePage != null) {
            SwingUtilities.invokeLater(incompletePage::dispose);
        }
    }

    @Test
    void testSelectButtonAction() {
        SwingUtilities.invokeLater(() -> {
            JButton selectButton = findButtonByText(incompletePage.getContentPane(), "Level Selection");
            assertNotNull(selectButton, "SelectButton not found");
            selectButton.doClick();
            assertFalse(incompletePage.isDisplayable());
        });
    }

    @Test
    void testHomeButtonAction() {
        SwingUtilities.invokeLater(() -> {
            JButton homeButton = findButtonByText(incompletePage.getContentPane(), "Home Page");
            assertNotNull(homeButton, "HomeButton not found");
            homeButton.doClick();
            assertFalse(incompletePage.isDisplayable());
        });
    }

    private JButton findButtonByText(Container container, String text) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                if (text.equals(button.getText())) {
                    return button;
                }
            } else if (comp instanceof Container) {
                JButton foundButton = findButtonByText((Container) comp, text);
                if (foundButton != null) {
                    return foundButton;
                }
            }
        }
        return null;
    }
}
