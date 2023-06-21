package Interface;

import Login.WindowForLogin;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;

public interface LogicInterface {

    void getResponseCodeFromUserDataBase(String username, String password, String baseURL, WindowForLogin windowForLogin) throws IOException;

    int getResponseCode(String encodedValue, String typeOfCypher, String baseUrl, JLabel textAfterEncryption) throws IOException;
}
