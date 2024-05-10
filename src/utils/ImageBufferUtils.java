
package utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code ImageBufferUtils} class provides a centralized mechanism for loading and
 * retrieving {@link ImageIcon} objects from a specified path. It preloads a defined set
 * of images at the initialization of the class, making them readily available for use
 * throughout the application.
 * <p>
 * This utility class helps in reducing the overhead of loading images from disk every
 * time an image is needed, by maintaining a static cache ({@code IMAGES}) of preloaded
 * {@link ImageIcon} objects.
 * </p>
 * @author Jingpeng Ruan
 * @version 1.0
 * @since 2024/3/31
 */

public class ImageBufferUtils {
    // Definition of constants for image file names.
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

    /**
     * An array containing all predefined image file names to be loaded into the cache.
     */
    public static final String[] IMAGES_ARR = {CRY, SMILE, FROG, GRASS, LEAF, LEAF1, LEAF2, LINE, MUSIC, RIVER, NOTIFICATION, OFF, ON, RANKING, SCORE, SETTINGS, SOUND, TIME, USER};

    /**
     * The relative path to the directory containing the image resources.
     */
    public static final String PATH = "resources/";

    /**
     * A cache of {@link ImageIcon} objects, each mapped from its corresponding file name.
     * This cache is populated at class initialization and provides quick access to the images.
     */
    public static final Map<String, ImageIcon> IMAGES = new HashMap<>();
    // Static initializer block to load images into the cache.
    static {
        for (String image : IMAGES_ARR) {
            IMAGES.put(image, new ImageIcon(PATH + image));
        }
    }

    /**
     * Retrieves an {@link ImageIcon} object from the cache based on the provided image name.
     *
     * @param imageName The name of the image file to retrieve. This name should correspond to
     *                  one of the constants defined in this class.
     * @return An {@link ImageIcon} object if the image exists in the cache; {@code null} otherwise.
     */
    public static ImageIcon getImageIcon(String imageName) {
        return IMAGES.get(imageName);

    }

}
