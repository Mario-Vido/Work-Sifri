package Interface;

import Frames.MyFrame;
import Frames.WindowForLogin;
import exceptions.NoInputArgument;

import javax.swing.*;
import java.io.IOException;


public interface LogicInterface {

    void getResponseCodeFromUserDataBase(String username, String password, String baseURL, WindowForLogin windowForLogin) throws IOException;

    int getResponseCode(String encodedValue, String typeOfCypher, String baseUrl, JLabel textAfterEncryption, String username, JFrame myFrame) throws IOException, NoInputArgument;
}
