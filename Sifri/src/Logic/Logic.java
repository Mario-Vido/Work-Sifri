package Logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import java.util.Objects;

import Frames.WindowForLogin;
import Service.LogicService;
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
    @Getter
    private final JButton logout;

    private final  JFrame myFrame;


    public Logic(JFrame myFrame) throws IOException {
        CyphersFromServer cyphersFromServer = new CyphersFromServer();
        this.textFromUser = new JTextField("write text to encrypt");
        this.buttonForDecryption = new JButton("Decryption");
        this.buttonForEncryption = new JButton("Encryption");
        this.textAfterEncryption = new JLabel();
        this.chooseEncryption =  new JComboBox<>(cyphersFromServer.getNames().toArray(new String[0]));
        this.logout = new JButton("Logout");
        this.myFrame = myFrame;
        addActionListeners();
    }

    public void addActionListeners(){
        buttonForEncryption.addActionListener(this);
        buttonForDecryption.addActionListener(this);
        chooseEncryption.addActionListener(this);
        logout.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        LogicService service = new LogicService();
        String encodedValue;
        String typeOfCypher;
        String userName = LogicForLogin.usernameField.getText();
        String baseUrl;

        if (e.getSource() == buttonForEncryption) {

                    encodedValue = URLEncoder.encode(textFromUser.getText());
                    typeOfCypher = URLEncoder.encode(Objects.requireNonNull(chooseEncryption.getSelectedItem()).toString());
                    baseUrl = "http://localhost:8080/cypher";
                    service.getResponseCode(encodedValue, typeOfCypher, baseUrl, textAfterEncryption, userName,myFrame);

        } else if (e.getSource() == buttonForDecryption) {
            String valueAfterCypher = URLEncoder.encode(textAfterEncryption.getText());
            typeOfCypher = URLEncoder.encode(Objects.requireNonNull(chooseEncryption.getSelectedItem()).toString());
            baseUrl = "http://localhost:8080/decipher";
            service.getResponseCode(valueAfterCypher, typeOfCypher, baseUrl, textAfterEncryption, userName,myFrame);
        } else if(e.getSource()== logout){
            myFrame.dispose();
            new WindowForLogin();
        }
    }

}

