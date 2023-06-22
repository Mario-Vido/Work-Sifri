package Service;

import Core.MyFrame;
import Interface.LogicInterface;
import Login.WindowForLogin;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LogicService implements LogicInterface {

    @Override
    public void getResponseCodeFromUserDataBase(String username, String password, String baseURL, WindowForLogin windowForLogin) throws IOException {
        String response;

        try {
            URL url = new URL(baseURL + "?username=" + username + "&password=" + password);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                }
                response = content.toString();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (response.equals("true")) {
            new MyFrame();
            windowForLogin.dispose();
        } else {
            JOptionPane.showMessageDialog(windowForLogin, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public int getResponseCode(String encodedValue, String typeOfCypher, String baseUrl, JLabel textAfterEncryption, String username) throws IOException {
        URL url = new URL(baseUrl + "?param1=" + encodedValue + "&param2=" + typeOfCypher + "&param3=" + username);
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


