package view.custom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CenterLabelInPanelTest {

    private CenterLabelInPanel panel;

    @BeforeEach
    void setUp() {
        panel = new CenterLabelInPanel("Test Label", 20);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testLabelProperties() {
        assertEquals("Test Label", ((JLabel) panel.getComponent(0)).getText());

        assertEquals(20, ((JLabel) panel.getComponent(0)).getFont().getSize());

        assertEquals(Color.WHITE, panel.getBackground());

        assertEquals(new Dimension(500, 30), panel.getPreferredSize());

        System.out.println("testLabelProperties - Test passed.");
    }
}