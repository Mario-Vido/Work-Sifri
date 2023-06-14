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
        encryptionMap.put('d', 'n');
    }
    private final JLabel TextAfterEncryption;

    public EncryptionType1(JLabel textAfterEncryption) {
        TextAfterEncryption = textAfterEncryption;
    }

    public void performEncryption(String text) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : text.toCharArray()) {
            char encryptedChar = encryptionMap.getOrDefault(Character.toLowerCase(c), c);
            encryptedMessage.append(encryptedChar);
        }
        TextAfterEncryption.setText(encryptedMessage.toString());
    }
}
