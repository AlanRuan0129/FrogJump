package utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ImageBufferUtils {
    public static final String CRY = "cry.png";
    public static final String SMILE = "smile.png";
    public static final String FROG = "frog.png";
    public static final String GRASS = "grass.png";
    public static final String LEAF = "leaf.png";
    public static final String LEAF1 = "leaf1.png";
    public static final String LEAF2 = "leaf2.png";
    public static final String LINE = "line.png";
    public static final String MUSIC = "music.png";
    public static final String RIVER = "river.png";
    public static final String NOTIFICATION = "notification.png";
    public static final String OFF = "off.png";
    public static final String ON = "on.png";
    public static final String RANKING = "ranking.png";
    public static final String SCORE = "score.png";
    public static final String SETTINGS = "settings.png";
    public static final String SOUND = "sound.png";
    public static final String TIME = "time.png";
    public static final String USER = "user.png";

    public static final String[] IMAGES_ARR = {CRY, SMILE, FROG, GRASS, LEAF, LEAF1, LEAF2, LINE, MUSIC, RIVER, NOTIFICATION, OFF, ON, RANKING, SCORE, SETTINGS, SOUND, TIME, USER};

    public static final String PATH = "resources/";

    public static final Map<String, ImageIcon> IMAGES = new HashMap<>();

    static {
        for (String image : IMAGES_ARR) {
            IMAGES.put(image, new ImageIcon(PATH + image));
        }
    }

    public static ImageIcon getImageIcon(String imageName) {
        return IMAGES.get(imageName);

    }

}
