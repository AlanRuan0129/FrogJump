package utils;

import java.util.HashMap;
import java.util.Map;

public class LocalStorage {
    public static final String DATA = "data";
    public static final String CURRENT_USER = "current_user";
    public static final String INSTRUCTOR_CODE = "123456";
    private final static Map<String, Object> LOCAL_STORAGE = new HashMap<>();
    public static void save(String key, Object value) {
        LOCAL_STORAGE.put(key, value);
    }

    public static <T> T get(String key , Class<T> type) {
        return type.cast(LOCAL_STORAGE.get(key));
    }

    public static void remove(String key) {
        LOCAL_STORAGE.remove(key);
    }
}
