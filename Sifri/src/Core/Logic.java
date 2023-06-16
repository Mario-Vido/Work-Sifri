package Core;

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
    private final JComboBox<String> chooseEncryption;
    private final String baseUrl = "http://localhost:8080/cypher";


    public Logic(JButton buttonForEncryption, JButton buttonForDecryption, JTextField textFromUser, JLabel textAfterEncryption, JComboBox chooseEncryption) {
        this.buttonForDecryption = buttonForDecryption;
        this.buttonForEncryption = buttonForEncryption;
        this.textFromUser = textFromUser;
        this.textAfterEncryption = textAfterEncryption;
        this.chooseEncryption = chooseEncryption;

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
        String typeOfCypher = URLEncoder.encode(chooseEncryption.getSelectedItem().toString());
        String helper;

        if (e.getSource() == buttonForEncryption) {
            helper = URLEncoder.encode(String.valueOf(0));
        } else if (e.getSource() == buttonForDecryption) {
            helper = URLEncoder.encode(String.valueOf(1));
        } else {
            return;
        }

        try {
            int responseCode = getResponseCode(encodedValue, typeOfCypher, helper);
            System.out.println("Response Code: " + responseCode);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private int getResponseCode(String encodedValue, String typeOfCypher, String helper) throws IOException {
        URL url = new URL(baseUrl + "?param1=" + encodedValue + "&param2=" + typeOfCypher + "&param3=" + helper);

        HttpURLConnection connection = null;
        int responseCode;

        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String response = in.readLine();
                textAfterEncryption.setText(response);
            }

            responseCode = connection.getResponseCode();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return responseCode;
    }
}

