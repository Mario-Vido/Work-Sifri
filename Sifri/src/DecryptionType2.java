import javax.swing.*;

public class DecryptionType2 {
    private final JLabel textAfterEncryption;
    public DecryptionType2(JLabel textAfterEncryption) {
        this.textAfterEncryption = textAfterEncryption;
    }

    public void performDecryption(String text) {
        String[] words = text.split(" ");
        StringBuilder decryptedString = new StringBuilder();

        for (String word : words) {
            StringBuilder decryptedWord = new StringBuilder(word);
            for (int i = decryptedWord.length() - 1; i > 0; i -= 2) {
                char temp = decryptedWord.charAt(i);
                decryptedWord.setCharAt(i, decryptedWord.charAt((i - 1 + decryptedWord.length()) % decryptedWord.length()));
                decryptedWord.setCharAt((i - 1 + decryptedWord.length()) % decryptedWord.length(), temp);
            }
            decryptedString.append(decryptedWord).append(" ");
        }
        textAfterEncryption.setText(decryptedString.toString().trim());
    }
}
