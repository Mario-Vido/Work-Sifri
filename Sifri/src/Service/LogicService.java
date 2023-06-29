package Service;

import Frames.MyFrame;
import Interface.LogicInterface;
import Frames.WindowForLogin;
import exceptions.NoInputArgument;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


public class LogicService implements LogicInterface {

    @Override
    public void getResponseCodeFromUserDataBase(String username, String password, String baseURL, WindowForLogin windowForLogin) {
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
                if(response.equals("false")){
                    throw new NoInputArgument("No username or password");
                }else{
                    new MyFrame();
                    windowForLogin.dispose();
                }
            }
        } catch (NoInputArgument | IOException e) {
            showErrorMassage(windowForLogin,e.getMessage());
        }
    }

    @Override
    public int getResponseCode(String encodedValue, String typeOfCypher, String baseUrl, JLabel textAfterEncryption, String username,JFrame myFrame)  {
        
        String POST_PARAMS = "&encodedValue=" + encodedValue + "&typeOfCypher=" + typeOfCypher + "&username=" + username;
        HttpURLConnection connection;
        int responseCode = 0;
        try {
            if(encodedValue.equals("")){
                throw new NoInputArgument("Empty cypher field");
            }
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

        } catch (NoInputArgument | IOException e) {
            showErrorMassage(myFrame,e.getMessage());
        }

        return responseCode;
    }

    public void showErrorMassage(JFrame windowForLogin, String msg){
        JOptionPane.showMessageDialog(windowForLogin, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}


