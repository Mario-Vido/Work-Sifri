package Encryption;

import javax.swing.*;
import java.util.Arrays;

public class EncryptionType2 implements Encryption{
    private final JLabel TextAfterEncryption;

    public EncryptionType2(JLabel textAfterEncryption) {
        TextAfterEncryption = textAfterEncryption;
    }
    @Override
    public void performEncryption(String text) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (Character.isLetter(currentChar)) {
                int shift = 3;
                char encryptedChar = (char) ((currentChar - 'a' + shift) % 26 + 'a');
                ciphertext.append(encryptedChar);
            } else {
                ciphertext.append(currentChar);
            }
        }
        TextAfterEncryption.setText(ciphertext.toString());
    }
}
