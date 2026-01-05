package DAY7;

import java.sql.*;

public class JDBC2_Bank {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/SCOE_CS_B";
        String user = "root";
        String pass = "root";

        try {
            // Step 2: Load and register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3: Connect to database
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Database connected successfully");

            // Step 4: Create SQL statement
            Statement stmt = con.createStatement();

            // Create bank table
            String createTableQuery =
                    "CREATE TABLE IF NOT EXISTS bank_accounts (" +
                    "acc_no INT PRIMARY KEY," +
                    "acc_name VARCHAR(100)," +
                    "balance DOUBLE)";

            // Step 5: Execute query
            stmt.executeUpdate(createTableQuery);
            System.out.println("Table bank_accounts created successfully");

            // Insert records
            String insertQuery =
                    "INSERT INTO bank_accounts (acc_no, acc_name, balance) VALUES (?,?,?)";

            PreparedStatement pst = con.prepareStatement(insertQuery);

            // 1st Account
            pst.setInt(1, 101);
            pst.setString(2, "Priyanka");
            pst.setDouble(3, 50000.75);
            pst.executeUpdate();

            // 2nd Account
            pst.setInt(1, 102);
            pst.setString(2, "Sankruti");
            pst.setDouble(3, 75000.50);
            pst.executeUpdate();

            // 3rd Account
            pst.setInt(1, 103);
            pst.setString(2, "Akanksha");
            pst.setDouble(3, 32000.00);
            pst.executeUpdate();

            // 4th Account
            pst.setInt(1, 104);
            pst.setString(2, "Pratiksha");
            pst.setDouble(3, 98000.90);
            pst.executeUpdate();

            // 5th Account
            pst.setInt(1, 105);
            pst.setString(2, "Om");
            pst.setDouble(3, 15000.25);
            pst.executeUpdate();

            // Step 6: Result
            System.out.println("Bank account records inserted successfully");

            // Step 7: Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
