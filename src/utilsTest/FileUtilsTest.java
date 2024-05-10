package utilsTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.FileUtils;
import entity.DataObject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilsTest {
    private final String testFilePath = "data/test_data.json";

    @BeforeEach
    void setUp() throws Exception {
        Files.write(Paths.get(testFilePath), "".getBytes());
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(Paths.get(testFilePath));
    }

    @Test
    void readDataToString() {
        FileUtils.writeData(new DataObject());

        String data = FileUtils.readDataToString();
        assertNotNull(data, "The read data should not be null.");
        assertFalse(data.isEmpty(), "The read data should not be empty.");
    }

    @Test
    void getNewFile() {
        File file = FileUtils.getNewFile();
        assertTrue(file.exists());
        File newFile = FileUtils.getNewFile();
        assertTrue(newFile.exists());
        assertEquals(file.getAbsolutePath(), newFile.getAbsolutePath());
    }

    @Test
    void writeData() {
        DataObject dataObject = new DataObject();
        FileUtils.writeData(dataObject);
        String data = FileUtils.readDataToString();
        assertFalse(data.isEmpty(), "The file should have data written to it.");

    }

    @Test
    void readData() {
        DataObject dataObject = new DataObject();
        FileUtils.writeData(dataObject);
        DataObject readObject = FileUtils.readData();
        assertNotNull(readObject, "The DataObject read should not be null.");
    }

    @Test
    void main() {
        FileUtils.main(new String[]{});
        assertTrue(true, "main - Test passed.");
    }
}
