package jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBasicEx {
    public static void main(String[] args) {
        // load and register the driver
        try {
            Class.forName("org.postgresql.Driver");
            //establish the connection
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "prachi20");
            //create statement object
            Statement statement = connection.createStatement();
            //execute the query;
            String s = "insert into student values(23,'Shivani','nagpur')";

            int res = statement.executeUpdate(s);
            System.out.println(res + "row inserted");
            if (connection != null) {
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException p) {
            throw new RuntimeException(p);
        }
    }
}


