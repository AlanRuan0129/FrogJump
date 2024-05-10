package utilsTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ImageBufferUtils;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class ImageBufferUtilsTest {

    @BeforeEach
    void setUp() {
        System.out.println("setUp()");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown()");
    }

    @Test
    void getImageIconValidName() {
        System.out.println("Testing getImageIcon with a valid name");
        ImageIcon icon = ImageBufferUtils.getImageIcon(ImageBufferUtils.CRY);
        assertNotNull(icon, "The icon should not be null for a valid image name");
    }

    @Test
    void getImageIconInvalidName() {
        System.out.println("Testing getImageIcon with an invalid name");
        ImageIcon icon = ImageBufferUtils.getImageIcon("invalid_name.png");
        assertNull(icon, "The icon should be null for an invalid image name");
    }
}
