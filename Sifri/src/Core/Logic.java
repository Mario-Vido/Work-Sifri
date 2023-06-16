package Core;

import Decryption.DecryptionType1;
import Decryption.DecryptionType2;
import Encryption.EncryptionType1;
import Encryption.EncryptionType2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

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

    private final DataBase dataBase;
    private URL url;

    public Logic(JButton buttonForEncryption, JButton buttonForDecryption, JTextField textFromUser, JLabel textAfterEncryption, JComboBox chooseEncryption) throws MalformedURLException {
        this.buttonForDecryption=buttonForDecryption;
        this.buttonForEncryption=buttonForEncryption;
        this.textFromUser=textFromUser;
        this.textAfterEncryption=textAfterEncryption;
        this.chooseEncryption=chooseEncryption;

        addActionListeners();
        dataBase = new DataBase();
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
            if(selectedType.equals("Encryption type 1")) {
                encryptionType1.performEncryption(textFromUser.getText());
                dataBase.insertMassage(textFromUser, textAfterEncryption, (String) chooseEncryption.getSelectedItem());
                HttpURLConnection connection = null;
                int responseCode = 0;
                try {
                    String parameterValue=textFromUser.getText();
                    String encodedValue = URLEncoder.encode(parameterValue);

                    url =new URL("http://localhost:8080/cypher?param=" + encodedValue);
                    connection = (HttpURLConnection) url.openConnection();
                    System.out.println("Connected to URL");

                    connection.setRequestMethod("GET");
                    System.out.println("Get method");

                    responseCode = connection.getResponseCode();
                    System.out.println("Got response");

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Response Code: " + responseCode);
            }
            else if(selectedType.equals("Encryption type 2")){
                encryptionType2.performEncryption(textFromUser.getText());
                dataBase.insertMassage(textFromUser,textAfterEncryption,(String) chooseEncryption.getSelectedItem());
            }
        }
    }
}
