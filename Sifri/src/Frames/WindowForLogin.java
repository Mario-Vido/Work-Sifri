package Frames;

import Logic.LogicForLogin;

import javax.swing.*;
import java.awt.*;

public class WindowForLogin extends JFrame {


    public WindowForLogin() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 150);
        JPanel loginFrame = new JPanel();
        loginFrame.setLayout(new GridLayout(3, 2));

        LogicForLogin login = new LogicForLogin(this);

        loginFrame.add(login.getUsernameLabel());
        loginFrame.add(login.getUsernameField());
        loginFrame.add(login.getPasswordLabel());
        loginFrame.add(login.getPasswordField());
        loginFrame.add(login.getLoginButton());

        this.add(loginFrame);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
