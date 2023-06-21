package Core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Objects;
import lombok.Getter;

public class Logic implements ActionListener {

    @Getter
    private final JButton buttonForEncryption;
    @Getter
    private final JButton buttonForDecryption;
    @Getter
    private final JTextField textFromUser;
    @Getter
    private final JLabel textAfterEncryption;
    @Getter
    private final JComboBox chooseEncryption;


    public Logic(JFrame myFrame) throws IOException {
        CyphersFromServer cyphersFromServer = new CyphersFromServer();
        this.textFromUser = new JTextField("write text to encrypt");
        this.buttonForDecryption = new JButton("Decryption");
        this.buttonForEncryption = new JButton("Encryption");
        this.textAfterEncryption = new JLabel();
        this.chooseEncryption =  new JComboBox<>(cyphersFromServer.getNames().toArray(new String[0]));

        addActionListeners();
    }

    public void addActionListeners(){
        buttonForEncryption.addActionListener(this);
        buttonForDecryption.addActionListener(this);
        chooseEncryption.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String encodedValue = URLEncoder.encode(textFromUser.getText());
        String typeOfCypher = URLEncoder.encode(Objects.requireNonNull(chooseEncryption.getSelectedItem()).toString());

        String baseUrl;
        if (e.getSource() == buttonForEncryption) {
            baseUrl ="http://localhost:8080/cypher";
            try {
                int response = getResponseCode(encodedValue, typeOfCypher, baseUrl);
                System.out.println(response);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == buttonForDecryption) {
            baseUrl = "http://localhost:8080/decypher";
            String valueAfterCypher= URLEncoder.encode(textAfterEncryption.getText());
            try {
                int response = getResponseCode(valueAfterCypher, typeOfCypher, baseUrl);
                System.out.println(response);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    private int getResponseCode(String encodedValue, String typeOfCypher, String baseUrl) throws IOException {
        URL url = new URL(baseUrl + "?param1=" + encodedValue + "&param2=" + typeOfCypher);
        HttpURLConnection connection;
        int responseCode;

        try {

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String response = in.readLine();
                textAfterEncryption.setText(response);
            }

            responseCode = connection.getResponseCode();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return responseCode;
    }
}

