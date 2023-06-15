package Decryption;

import javax.swing.*;

public class DecryptionType2 implements Decryption {

    private final JLabel textAfterEncryption;
    public DecryptionType2(JLabel textAfterEncryption) {
        this.textAfterEncryption = textAfterEncryption;
    }

    @Override
    public void performDecryption(String text) {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (Character.isLetter(currentChar)) {
                int shift=3;
                char decryptedChar = (char) ((currentChar - 'a' - shift + 26) % 26 + 'a');
                plaintext.append(decryptedChar);
            } else {
                plaintext.append(currentChar);
            }
        }
        textAfterEncryption.setText(plaintext.toString());
    }
}
