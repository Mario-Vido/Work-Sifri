package Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    public DataBase(){
        String jdbcURL = "jdbc:postgresql://localhost:5432/Skuska";
        String username = "postgres";
        String password = "123";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connected ti PostgradeSQL server");
            String sql = "INSERT INTO cypherAuditLog (input, output,cypher, timestamp)" + " VALUES ('Ravi', 'Kumar', 'ravi.kumar@gmail.com')";

            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            if(rows > 0){
                System.out.println("A new contact has been inserted");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in connecting to PostgradeSQL()");
            throw new RuntimeException(e);
        }
    }
}
