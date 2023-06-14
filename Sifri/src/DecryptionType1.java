import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class DecryptionType1 {
    private static final Map<Character, Character> encryptionMap;
    static {
        encryptionMap = new HashMap<>();
        encryptionMap.put('x', 'a');
        encryptionMap.put('m', 'b');
        encryptionMap.put('z', 'c');
        encryptionMap.put('n', 'd');
    }
    private final JLabel textAfterEncryption;
    public DecryptionType1(JLabel textAfterEncryption) {
        this.textAfterEncryption = textAfterEncryption;
    }
    public void performDecryption(String text){
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : text.toCharArray()) {
            char encryptedChar = encryptionMap.getOrDefault(Character.toLowerCase(c), c);
            encryptedMessage.append(encryptedChar);
        }
        textAfterEncryption.setText(encryptedMessage.toString());
    }
}
