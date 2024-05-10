package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MusicUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        if (MusicUtils.musicPlayer != null) {
            MusicUtils.stopMusic();
        }
    }

    @Test
    void playMusicLoop() {
        assertDoesNotThrow(() -> MusicUtils.playMusicLoop());
        System.out.println("playMusicLoop - Test passed.");
    }

    @Test
    void playSound() {
        assertDoesNotThrow(() -> MusicUtils.playSound("sound"));
        System.out.println("playSound - Test passed.");
    }

    @Test
    void stopMusic() {
        assertDoesNotThrow(() -> {
            if (MusicUtils.musicPlayer != null) {
                MusicUtils.stopMusic();
            }
        }, "stopMusic should not throw an exception.");
        System.out.println("stopMusic - Test passed.");
    }
}
