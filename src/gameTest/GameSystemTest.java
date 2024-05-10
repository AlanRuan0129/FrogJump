package game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameSystemTest {
    private GameSystem gameSystem;

    @BeforeEach
    void setUp() {
        gameSystem = new GameSystem(2, 1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void increaseScore() {
        int initialScore = gameSystem.getScore();
        gameSystem.increaseScore(10);
        assertEquals(initialScore + 10, gameSystem.getScore());
    }

    @Test
    void getScore() {
        assertEquals(0, gameSystem.getScore());
    }

    @Test
    void getLevel() {
        assertEquals(1, gameSystem.getLevel());
    }

    @Test
    void getHardLevel() {
        assertEquals(2, gameSystem.getHardLevel());
    }

    @Test
    void getTimeSystem() {
        assertNotNull(gameSystem.getTimeSystem());
        System.out.println("getTimeSystem - Test passed.");
    }

    @Test
    void startGame() {
        assertDoesNotThrow(() -> gameSystem.startGame());
        System.out.println("startGame - Test passed.");
    }

    @Test
    void isWin() {
        assertFalse(gameSystem.isWin());
        System.out.println("isWin - Test passed.");
    }

    @Test
    void setWin() {
        gameSystem.setWin(true);
        assertTrue(gameSystem.isWin());
        System.out.println("setWin - Test passed.");
    }
}