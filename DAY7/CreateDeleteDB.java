package DAY7;

import java.sql.*;

public class CreateDeleteDB {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String pass = "root";
        String dbName = "DEMO1";

        try {
            // Step 2: Load and register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3: Connect
            Connection con = DriverManager.getConnection(url, user, pass);

            // Step 4: Create statement
            Statement stmt = con.createStatement();

            // Step 5: Create database safely
            String createQuery = "CREATE DATABASE IF NOT EXISTS " + dbName;
            stmt.executeUpdate(createQuery);
            System.out.println("Database created successfully: " + dbName);

            // Step 6: Delete database safely
            String dropQuery = "DROP DATABASE IF EXISTS " + dbName;
            stmt.executeUpdate(dropQuery);
            System.out.println("Database deleted successfully: " + dbName);

            // Step 7: Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
