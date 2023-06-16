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
    private final DecryptionType2 decryptionType2;

    private final DataBase dataBase;
    private URL url1;
    private URL url2;

    public Logic(JButton buttonForEncryption, JButton buttonForDecryption, JTextField textFromUser, JLabel textAfterEncryption, JComboBox chooseEncryption) throws MalformedURLException {
        this.buttonForDecryption=buttonForDecryption;
        this.buttonForEncryption=buttonForEncryption;
        this.textFromUser=textFromUser;
        this.textAfterEncryption=textAfterEncryption;
        this.chooseEncryption=chooseEncryption;

        addActionListeners();
        dataBase = new DataBase();
        decryptionType2 = new DecryptionType2(textAfterEncryption);
    }

    public void addActionListeners(){
        buttonForEncryption.addActionListener(this);
        buttonForDecryption.addActionListener(this);
        chooseEncryption.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String encodedValue = URLEncoder.encode(textFromUser.getText());
        String helper;
        String typeOfCypher = URLEncoder.encode((String) chooseEncryption.getSelectedItem());
        HttpURLConnection connection = null;
        int responseCode = 0;
        assert typeOfCypher != null;
        if (e.getSource()==buttonForEncryption){
                try {
                    helper=URLEncoder.encode("Encryption");
                    url2 =new URL("http://localhost:8080/cypher?param1=" + encodedValue + "&param2=" + typeOfCypher + "&param3=" + helper);
                    connection = (HttpURLConnection) url2.openConnection();
                    connection.setRequestMethod("GET");
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String response = in.readLine();
                    textAfterEncryption.setText(response);
                    responseCode = connection.getResponseCode();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

        }
        else if(e.getSource()==buttonForDecryption){
            try {
                helper=URLEncoder.encode("Decryption");
                url1 =new URL("http://localhost:8080/cypher?param1=" + encodedValue + "&param2=" + typeOfCypher + "&param3=" + helper);
                connection = (HttpURLConnection) url1.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String response = in.readLine();
                textAfterEncryption.setText(response);
                responseCode = connection.getResponseCode();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        System.out.println("Response Code: " + responseCode);
    }
}

