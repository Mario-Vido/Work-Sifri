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
        HashMap<Character, Character> letterMap = new HashMap<>();
        for (char c = 'z'; c >= 'a'; c--) {
            char replacement = (char) ('a' + ('z' - c));
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
        textAfterEncryption.setText(replacedString.toString());
    }
}
