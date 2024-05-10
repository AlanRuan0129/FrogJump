package utils;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.nio.file.Files;

/**
 * This class provides tools for music playback, including looping background music, playing a single sound effect, and stopping music playback.
 * It uses the Player class in the JavaZoom library to process MP3 files.
 * <p>
 * Music files should be placed in the resource directory.
 * </p>
 *
 * @author Pengyuan Wei
 * @version 1.0
 * @since 2024/3/29
 */
public class MusicUtils {
    public static Player musicPlayer;//Background music player
    public static boolean isMusicPlaying = true;//Mark whether music is playing
    public static Player soundPlayer;//Sound player
    public static Player notificationPlayer;//Notification sound player

    /**
     * Play background music on a loop.
     * <p>
     * This method starts a new thread that loops the music,
     * To avoid blocking the main thread. The loop continues until isMusicPlaying becomes false.
     * </p>
     */
    public static void playMusicLoop() {
        isMusicPlaying = true;
        try {
            File musicFile = new File("resources/music.mp3");
            musicPlayer = new Player(Files.newInputStream(musicFile.toPath()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            try {
                while (isMusicPlaying) {
                    musicPlayer.play();
                }
            } catch (JavaLayerException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    /**
     * Play a sound.
     *
     * @param sound The file name of the sound effect (excluding the.mp3 extension)
     */
    public static void playSound(String sound) {
        try {
            File soundFile = new File("resources/" + sound + ".mp3");
            soundPlayer = new Player(Files.newInputStream(soundFile.toPath()));
            soundPlayer.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Stop the background music and close the player.
     */
    public static void stopMusic() {
        isMusicPlaying = false;
        musicPlayer.close();
    }

}
