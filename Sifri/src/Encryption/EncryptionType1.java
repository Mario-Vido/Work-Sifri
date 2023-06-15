package Encryption;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class EncryptionType1 implements Encryption {
    private final JLabel TextAfterEncryption;

    public EncryptionType1(JLabel textAfterEncryption) {
        this.TextAfterEncryption = textAfterEncryption;
    }

    @Override
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
