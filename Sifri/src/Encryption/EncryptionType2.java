package Encryption;

import javax.swing.*;
import java.util.Arrays;

public class EncryptionType2 {
    private final JLabel TextAfterEncryption;

    public EncryptionType2(JLabel textAfterEncryption) {
        TextAfterEncryption = textAfterEncryption;
    }

    public void performEncryption(String text) {
        String[] words = text.split(" ");
        StringBuilder shuffledString = new StringBuilder();

        for (String word : words) {
            StringBuilder shuffledWord = new StringBuilder(word);
            for (int i = 1; i < shuffledWord.length(); i += 2) {
                char temp = shuffledWord.charAt(i);
                shuffledWord.setCharAt(i, shuffledWord.charAt((i + 1) % shuffledWord.length()));
                shuffledWord.setCharAt((i + 1) % shuffledWord.length(), temp);
            }
            shuffledString.append(shuffledWord).append(" ");
        }
        TextAfterEncryption.setText(shuffledString.toString().trim());
    }
}
