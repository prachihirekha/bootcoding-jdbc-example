package jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class SecondDayJDBC {
    public static void main(String[] args)  {
        try {
            // load driver
            Class.forName("org.postgresql.Driver");
            // connection
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "prachi20");
            // create query
            String create = "create table table1(tId SERIAL PRIMARY KEY,t_Name varchar(30) not null,tCity varchar(200))";
            // create statement
            Statement st = connection.createStatement();
            int res =st.executeUpdate(create);
            System.out.println(res+"create table....");
            //always connection close is imp
            connection.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
