package Interface;

import Login.WindowForLogin;

import java.io.IOException;

public interface LogicInterface {

    void checkUserInDatabase(String username, String password, WindowForLogin windowForLogin);
}
