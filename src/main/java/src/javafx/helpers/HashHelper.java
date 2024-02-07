package src.javafx.helpers;

public class HashHelper {
    public static String generate(String value) {
        int hash = 7;

        for (int i = 0; i < value.length(); i++) {
            hash = hash * 31 + value.charAt(i);
        }

        return Integer.toString(Math.abs(hash));
    }
}
