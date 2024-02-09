package src.javafx.datatransfer;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Storage instance;
    public String value;
    private final Map<String, String> data = new HashMap<>();

    private Storage(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        this.value = value;
    }

    public static Storage create(String value) {
        if (instance == null) {
            instance = new Storage(value);
        }

        return instance;
    }

    public void add(String key, String value) {
        this.data.put(key, value);
    }

    public String get(String key) {
        return this.data.get(key);
    }
}
