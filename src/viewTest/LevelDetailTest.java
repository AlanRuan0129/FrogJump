package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LevelDetailTest {
    private LevelDetail levelDetail;

    @BeforeEach
    void setUp() {
        levelDetail = new LevelDetail(1);
    }

    @AfterEach
    void tearDown() {
        levelDetail.dispose();
    }

    @Test
    void main() {
        assertDoesNotThrow(() -> LevelDetail.main(new String[0]));
        System.out.println("Test for main passed.");
    }
}