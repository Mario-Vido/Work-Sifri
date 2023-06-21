package Service;

import Core.MyFrame;
import Interface.LogicInterface;
import Login.WindowForLogin;

import javax.swing.*;
import java.io.IOException;

public class LogicService implements LogicInterface {

    @Override
    public void checkUserInDatabase(String username, String password, WindowForLogin windowForLogin) {
        if (username.equals("admin") && password.equals("1234")) {
            // Open the new window
            try {
                new MyFrame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            // Close the login window
            windowForLogin.dispose();
        } else {
            JOptionPane.showMessageDialog(windowForLogin, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

