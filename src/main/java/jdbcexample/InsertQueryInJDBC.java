package jdbcexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertQueryInJDBC {
    public static void main(String[] args) {
        try {
            // Load driver
            Class.forName("org.postgresql.Driver");
            // Create a connection
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "prachi20");

            // Create query by using PreparedStatement
            String insert = "INSERT INTO table1(tId, t_Name, tCity) VALUES (?, ?, ?)";
            PreparedStatement s = con.prepareStatement(insert);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the id:");
            int id = Integer.parseInt(br.readLine());

            System.out.println("Enter the name:");
            String name = br.readLine();

            System.out.println("Enter city:");
            String city = br.readLine();

            // Set parameters
            s.setInt(1, id);
            s.setString(2, name);
            s.setString(3, city);

            s.executeUpdate();

            System.out.println("Data inserted successfully.");

            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
