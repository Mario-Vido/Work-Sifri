package Login;


import Core.MyFrame;
import Service.LogicService;
import lombok.Getter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class LogicForLogin implements ActionListener {
    @Getter
    private final JTextField usernameField;
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
        this.usernameField = new JTextField();
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
        String baseUrl = "http://localhost:8080/check-user-servlet";
        LogicService logicService = new LogicService();
        String username = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        try {
            logicService.getResponseCodeFromUserDataBase(username, password, baseUrl,windowForLogin);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
