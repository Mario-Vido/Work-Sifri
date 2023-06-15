package Core;

import javax.swing.*;
import java.sql.*;

public class DataBase {
    public DataBase(){

    }
    public void insertMassage(JTextField textFromUser, JLabel textAfterEncryption, String selectedItem){
        String jdbcURL = "jdbc:postgresql://localhost:5432/Skuska";
        String username = "postgres";
        String password = "123";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connected ti PostgradeSQL server");
            String sql = "INSERT INTO cypherauditlog (input, output,cypher) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,textFromUser.getText());
            statement.setString(2,textAfterEncryption.getText());
            statement.setString(3,selectedItem);
            statement.executeUpdate();


            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in connecting to PostgradeSQL()");
            throw new RuntimeException(e);
        }
    }

}
