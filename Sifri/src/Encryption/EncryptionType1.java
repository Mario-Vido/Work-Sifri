package Encryption;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class EncryptionType1 {
    private static final Map<Character, Character> encryptionMap;
    static {
        encryptionMap = new HashMap<>();
        encryptionMap.put('a', 'x');
        encryptionMap.put('b', 'm');
        encryptionMap.put('c', 'z');
    }
    private final JLabel TextAfterEncryption;

    public EncryptionType1(JLabel textAfterEncryption) {
        TextAfterEncryption = textAfterEncryption;
    }

    public void performEncryption(String text) {
        HashMap<Character, Character> letterMap = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            char replacement = (char) ('z' - (c - 'a'));
            letterMap.put(c, replacement);
        }

        StringBuilder replacedString = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char replacement = letterMap.get(Character.toLowerCase(c));
                replacedString.append(Character.isUpperCase(c) ? Character.toUpperCase(replacement) : replacement);
            } else {
                replacedString.append(c);
            }
        }
        TextAfterEncryption.setText(replacedString.toString());
    }
}
