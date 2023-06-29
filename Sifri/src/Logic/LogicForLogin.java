package Logic;

import Frames.WindowForLogin;
import Service.LogicService;
import lombok.Getter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LogicForLogin implements ActionListener {
    @Getter
    public static JTextField usernameField;
    @Getter
    private final JPasswordField passwordField;
    @Getter
    private final JLabel usernameLabel;
    @Getter
    private final JLabel passwordLabel;
    @Getter
    private final JButton loginButton;
    private final WindowForLogin windowForLogin;

    public LogicForLogin(WindowForLogin windowForLogin) {
        this.windowForLogin = windowForLogin;
        usernameField = new JTextField();
        this.passwordField = new JPasswordField();
        this.loginButton = new JButton("Login");
        this.passwordLabel = new JLabel("Password");
        this.usernameLabel = new JLabel("Username");
        addActionListeners();
    }

    private void addActionListeners() {
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String baseUrl = "http://localhost:8080/login-from-client";
        LogicService logicService = new LogicService();
        String username = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
            logicService.getResponseCodeFromUserDataBase(username, password, baseUrl,windowForLogin);
    }
}
