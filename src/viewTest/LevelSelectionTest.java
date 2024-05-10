package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LevelSelectionTest {
    private LevelSelection levelSelection;

    @BeforeEach
    void setUp() {
        levelSelection = new LevelSelection();
    }

    @AfterEach
    void tearDown() {
        levelSelection.dispose();
    }

    @Test
    void main() {
        assertDoesNotThrow(() -> LevelSelection.main(new String[0]));
        System.out.println("main - Test passed.");
    }

    @Test
    void actionPerformed() {
    }
}