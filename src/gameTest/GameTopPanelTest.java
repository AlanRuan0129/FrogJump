package gameTest;

import game.GameTopPanel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class GameTopPanelTest {

    private GameTopPanel gameTopPanel;

    @BeforeEach
    void setUp() {
        gameTopPanel = new GameTopPanel();
        System.out.println("setUp()");
    }

    @AfterEach
    void tearDown() {
        gameTopPanel = null;
        System.out.println("tearDown()");
    }

    @Test
    void setTime() {
        String newTime = "4:59";
        gameTopPanel.setTime(newTime);
        assertEquals(newTime, getLabelText(gameTopPanel, "time"), "The time label was not updated correctly.");
        System.out.println("setTime()");
    }

    @Test
    void setScore() {
        int newScore = 100;
        gameTopPanel.setScore(newScore);
        assertEquals(String.valueOf(newScore), getLabelText(gameTopPanel, "score"), "The score label was not updated correctly.");
        System.out.println("setScore()");
    }

    /**
     * Helper method to extract the text of a JLabel from the GameTopPanel based on its field name.
     * This uses reflection to access the JLabel fields 'time' and 'score' within GameTopPanel.
     *
     * @param panel The GameTopPanel instance
     * @param fieldName The name of the JLabel field ('time' or 'score')
     * @return The text of the JLabel
     */
    private String getLabelText(GameTopPanel panel, String fieldName) {
        try {
            java.lang.reflect.Field field = panel.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            JLabel label = (JLabel) field.get(panel);
            return label.getText();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection to access the " + fieldName + " field failed: " + e.getMessage());
            return "";
        }
    }
}
