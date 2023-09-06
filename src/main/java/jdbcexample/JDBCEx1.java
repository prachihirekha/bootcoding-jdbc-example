package jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class JDBCEx1 {
    public static void main(String[] args) {
        try {
            //loadDriver
            Class.forName("org.postgresql.Driver");
            //connection with db
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "prachi20");
            if(connection.isClosed()){
                System.out.println("connection is closer");
            }
            else{
                System.out.println("connection is created....." );
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
