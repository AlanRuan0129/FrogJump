package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CompletePageTest {
    private CompletePage completePage;

    @BeforeEach
    void setUp() {
        SwingUtilities.invokeLater(() -> {
            completePage = new CompletePage(100);
            completePage.setVisible(true);
        });
    }

    @AfterEach
    void tearDown() {
        if (completePage != null) {
            SwingUtilities.invokeLater(completePage::dispose);
        }
    }

    @Test
    void testSelectButtonAction() {
        SwingUtilities.invokeLater(() -> {
            JButton selectButton = findButtonByText(completePage.getContentPane(), "Level Selection");
            assertNotNull(selectButton, "SelectButton not found");
            selectButton.doClick();
            assertFalse(completePage.isDisplayable());
        });
    }

    @Test
    void testHomeButtonAction() {
        SwingUtilities.invokeLater(() -> {
            JButton homeButton = findButtonByText(completePage.getContentPane(), "Home Page");
            assertNotNull(homeButton, "HomeButton not found");
            homeButton.doClick();
            assertFalse(completePage.isDisplayable());
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
