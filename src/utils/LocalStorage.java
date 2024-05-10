package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * LocalStorage is a utility class that simulates a local storage.
 * It provides static methods to save, retrieve, and remove objects using a key-value mapping.
 * This class uses a HashMap to store objects in memory.
 * <p>
 * it helps use to store current user details, etc.
 * <p>
 * Authors: Ziwen Ma
 * Version: 1.0
 * Since: 2024-03-27
 */
public class LocalStorage {
    public static final String DATA = "data";
    public static final String CURRENT_USER = "current_user";
    public static final String INSTRUCTOR_CODE = "123456";
    private final static Map<String, Object> LOCAL_STORAGE = new HashMap<>();

    /**
     * Saves an object to the local storage against a given key.
     * If the key already exists, the value is updated.
     *
     * @param key   the key under which the object is stored.
     * @param value the object to be stored.
     */
    public static void save(String key, Object value) {
        LOCAL_STORAGE.put(key, value);
    }

    /**
     * Retrieves an object from local storage by its key.
     *
     * @param key  the key which is associated with object is to be returned.
     * @param type the Class object of the type stored under the given key.
     * @param <T>  the type of the object to retrieve.
     * @return the object of type T associated with the key, or null if not found.
     */
    public static <T> T get(String key , Class<T> type) {
        return type.cast(LOCAL_STORAGE.get(key));
    }

    /**
     * Removes the object associated with the given key from the local storage.
     * If the key does not exist, the method does nothing.
     *
     * @param key the key which is associated with an object is to be removed.
     */
    public static void remove(String key) {
        LOCAL_STORAGE.remove(key);
    }
}
