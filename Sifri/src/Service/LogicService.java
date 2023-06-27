package Service;

import Core.MyFrame;
import Interface.LogicInterface;
import Login.WindowForLogin;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


public class LogicService implements LogicInterface {

    @Override
    public void getResponseCodeFromUserDataBase(String username, String password, String baseURL, WindowForLogin windowForLogin) throws IOException {
        String response;
        String POST_PARAMS = "login="+username+"&password="+password;
        try {
            HttpURLConnection connection = SetConnectionToServerService.getInstance().getConnection(baseURL);
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(POST_PARAMS);
            out.flush();
            out.close();

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
        String POST_PARAMS = "&encodedValue=" + encodedValue + "&typeOfCypher=" + typeOfCypher + "&username=" + username;
        HttpURLConnection connection;
        int responseCode;
        try {
            connection = SetConnectionToServerService.getInstance().getConnection(String.valueOf(baseUrl));
            connection.setRequestMethod("POST");

            connection.setDoOutput(true);

            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(POST_PARAMS);
            out.flush();
            out.close();
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


