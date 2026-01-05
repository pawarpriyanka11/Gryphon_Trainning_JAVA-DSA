package DAY7;

// UI
import java.awt.*;
import javax.swing.*;

// Event
import java.awt.event.*;

// JDBC
import java.sql.*;

public class QuestionOnDB extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField tf1, tf2, tf3;
    JButton b1, b2, b3;

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    QuestionOnDB() {

        setLayout(null);
        setTitle("Simple Bank System");

        l1 = new JLabel("Account Number:");
        l2 = new JLabel("Account Holder:");
        l3 = new JLabel("Balance:");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();

        b1 = new JButton("Search");
        b2 = new JButton("Deposit");
        

        l1.setBounds(80, 80, 120, 30);
        tf1.setBounds(220, 80, 150, 30);

        l2.setBounds(80, 120, 120, 30);
        tf2.setBounds(220, 120, 150, 30);

        l3.setBounds(80, 160, 120, 30);
        tf3.setBounds(220, 160, 150, 30);

        b1.setBounds(80, 220, 100, 30);
        b2.setBounds(200, 220, 100, 30);
       

        add(l1); add(tf1);
        add(l2); add(tf2);
        add(l3); add(tf3);
        add(b1); add(b2); 

        b1.addActionListener(this);
        b2.addActionListener(this);
       

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SCOE_CS_B","root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(500, 350);
//        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        try {
            int accNo = Integer.parseInt(tf1.getText());

            // SEARCH
            if (ae.getSource() == b1) {
                ps = con.prepareStatement("SELECT * FROM bank_accounts WHERE acc_no=?");
                ps.setInt(1, accNo);
                rs = ps.executeQuery();

                if (rs.next()) {
                    tf2.setText(rs.getString("acc_name"));
                    tf3.setText(rs.getString("balance"));
                } else 
                {
                    JOptionPane.showMessageDialog(this, "Account not found");
                }
            }

            // DEPOSIT
            if (ae.getSource() == b2) {
                double amt = Double.parseDouble(JOptionPane.showInputDialog("Enter amount"));
                double newBal =Double.parseDouble(tf3.getText()) + amt;

                ps = con.prepareStatement("UPDATE bank_accounts SET balance=? WHERE acc_no=?");
                ps.setDouble(1, newBal);
                ps.setInt(2, accNo);
                ps.executeUpdate();

                tf3.setText(String.valueOf(newBal));
                JOptionPane.showMessageDialog(this, "Amount Deposited");
            }

            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new QuestionOnDB();
    }
}
