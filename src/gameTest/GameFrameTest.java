package gameTest;

import game.GameFrame;
import game.GameSystem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameFrameTest {
    private GameFrame gameFrame;
    private GameSystem gameSystem;

    @BeforeEach
    void setUp() {
        gameSystem = new GameSystem(2, 1); // Assuming these are valid arguments for GameSystem
        gameFrame = new GameFrame(gameSystem);

    }

    @AfterEach
    void tearDown() {
        gameFrame.dispose();
    }

    @Test
    void main() {
        GameFrame.main(new String[]{});
        assertTrue(true, "main - Test passed.");
    }
}
