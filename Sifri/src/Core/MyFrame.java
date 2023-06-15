package Core;

import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame {

    public MyFrame() {
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(500,150);
       String[] encryptionType ={"Encryption type 1","Encryption type 2"};
       JPanel frame = new JPanel();
       frame.setLayout(new BorderLayout(3,1));

        JTextField textFromUser = new JTextField("write text to encrypt");
        JButton buttonForDecryption = new JButton("Decryption");
        JButton buttonForEncryption = new JButton("Encryption");
        JLabel textAfterEncryption = new JLabel();
        JComboBox chooseEncryption = new JComboBox(encryptionType);


       frame.add(textFromUser,BorderLayout.PAGE_START);
       frame.add(buttonForEncryption,BorderLayout.LINE_START);
       frame.add(chooseEncryption,BorderLayout.CENTER);
       frame.add(buttonForDecryption,BorderLayout.LINE_END);
       frame.add(textAfterEncryption,BorderLayout.PAGE_END);



       Logic logic = new Logic(buttonForEncryption, buttonForDecryption, textFromUser, textAfterEncryption, chooseEncryption);
       this.add(frame);
       this.setLocationRelativeTo(null);
       this.setVisible(true);
    }
}
