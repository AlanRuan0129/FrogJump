package utils;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.nio.file.Files;

public class MusicUtils {
    public static Player musicPlayer;
    public static boolean isMusicPlaying = true;
    public static Player soundPlayer;
    public static Player notificationPlayer;

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

    public static void playSound(String sound) {
        try {
            File soundFile = new File("resources/" + sound + ".mp3");
            soundPlayer = new Player(Files.newInputStream(soundFile.toPath()));
            soundPlayer.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void stopMusic() {
        isMusicPlaying = false;
        musicPlayer.close();
    }

}
