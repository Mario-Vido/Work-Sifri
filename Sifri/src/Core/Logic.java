package Core;

import Decryption.DecryptionType1;
import Decryption.DecryptionType2;
import Encryption.EncryptionType1;
import Encryption.EncryptionType2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logic implements ActionListener {

    private final JButton buttonForEncryption;
    private final JButton buttonForDecryption;
    private final JTextField textFromUser;
    private final JLabel textAfterEncryption;
    private final JComboBox chooseEncryption;
    private final EncryptionType1 encryptionType1;
    private final EncryptionType2 encryptionType2;
    private final DecryptionType1 decryptionType1;
    private final DecryptionType2 decryptionType2;

    public Logic(JButton buttonForEncryption, JButton buttonForDecryption, JTextField textFromUser, JLabel textAfterEncryption, JComboBox chooseEncryption) {
        this.buttonForDecryption=buttonForDecryption;
        this.buttonForEncryption=buttonForEncryption;
        this.textFromUser=textFromUser;
        this.textAfterEncryption=textAfterEncryption;
        this.chooseEncryption=chooseEncryption;

        addActionListeners();
        encryptionType1 = new EncryptionType1(textAfterEncryption);
        encryptionType2 = new EncryptionType2(textAfterEncryption);
        decryptionType1 = new DecryptionType1(textAfterEncryption);
        decryptionType2 = new DecryptionType2(textAfterEncryption);
    }

    public void addActionListeners(){
        buttonForEncryption.addActionListener(this);
        buttonForDecryption.addActionListener(this);
        chooseEncryption.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedType = (String) chooseEncryption.getSelectedItem();
        assert selectedType != null;
        if(e.getSource()==buttonForDecryption){
            if(selectedType.equals("Encryption type 1")){
                decryptionType1.performDecryption(textAfterEncryption.getText());
            }
            else if(selectedType.equals("Encryption type 2")){
                decryptionType2.performDecryption(textAfterEncryption.getText());
            }
        }
        else if (e.getSource()==buttonForEncryption){
            if(selectedType.equals("Encryption type 1")){
                encryptionType1.performEncryption(textFromUser.getText());
            }
            else if(selectedType.equals("Encryption type 2")){
                encryptionType2.performEncryption(textFromUser.getText());
            }
        }
    }
}

