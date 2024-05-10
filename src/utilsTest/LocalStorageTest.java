package utilsTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.LocalStorage;

import static org.junit.jupiter.api.Assertions.*;

class LocalStorageTest {

    @BeforeEach
    void setUp() {
        LocalStorage.remove(LocalStorage.DATA);
        LocalStorage.remove(LocalStorage.CURRENT_USER);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        String testKey = LocalStorage.DATA;
        String testValue = "Test";
        LocalStorage.save(testKey, testValue);
        String retrievedValue = LocalStorage.get(testKey, String.class);
        assertEquals(testValue, retrievedValue, "Retrieved value should match the saved value.");
    }

    @Test
    void get() {
        String testKey = "testNumber";
        Integer testValue = 42;
        LocalStorage.save(testKey, testValue);
        Integer retrievedValue = LocalStorage.get(testKey, Integer.class);
        assertEquals(testValue, retrievedValue, "Retrieved value should match.");
    }

    @Test
    void remove() {
        String testKey = LocalStorage.CURRENT_USER;
        String testValue = "UserForTest";
        LocalStorage.save(testKey, testValue);
        assertNotNull(LocalStorage.get(testKey, String.class), "Value should exist before removal.");
        LocalStorage.remove(testKey);
        assertNull(LocalStorage.get(testKey, String.class), "Value should be null after removal.");
    }
}