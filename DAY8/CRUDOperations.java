package DAY8;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;

public class CRUDOperations extends JFrame implements ActionListener {

    // GUI Components
    JTextField tfName, tfAge, tfGender, tfCourse, tfYear, tfEmail, tfPhone, tfAddress, tfGPA;
    JButton btnInsert, btnFetch, btnUpdate, btnDelete, btnOrderBy;

    JTable table;
    DefaultTableModel model;

    JTextField tfSearch1, tfSearch2;
    JComboBox<String> cbSearchType;
    JButton btnSearch;

    // JDBC
    Connection con;
    Statement stmt;
    ResultSet rs;

    CRUDOperations() {
        setTitle("Onkar's Team Management System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ---------- Form Panel ----------
        JPanel formPanel = new JPanel(new GridLayout(9, 2, 5, 5));

        tfName = new JTextField();
        tfAge = new JTextField();
        tfGender = new JTextField();
        tfCourse = new JTextField();
        tfYear = new JTextField();
        tfEmail = new JTextField();
        tfPhone = new JTextField();
        tfAddress = new JTextField();
        tfGPA = new JTextField();

        formPanel.add(new JLabel("Name")); formPanel.add(tfName);
        formPanel.add(new JLabel("Age")); formPanel.add(tfAge);
        formPanel.add(new JLabel("Gender")); formPanel.add(tfGender);
        formPanel.add(new JLabel("Course")); formPanel.add(tfCourse);
        formPanel.add(new JLabel("Year")); formPanel.add(tfYear);
        formPanel.add(new JLabel("Email")); formPanel.add(tfEmail);
        formPanel.add(new JLabel("Phone")); formPanel.add(tfPhone);
        formPanel.add(new JLabel("Address")); formPanel.add(tfAddress);
        formPanel.add(new JLabel("GPA")); formPanel.add(tfGPA);

        add(formPanel, BorderLayout.NORTH);

        // ---------- Button Panel ----------
        JPanel buttonPanel = new JPanel();

        btnInsert = new JButton("INSERT");
        btnFetch = new JButton("FETCH");
        btnUpdate = new JButton("UPDATE");
        btnDelete = new JButton("DELETE");
        btnOrderBy = new JButton("ORDER BY");

        buttonPanel.add(btnInsert);
        buttonPanel.add(btnFetch);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnOrderBy);

        add(buttonPanel, BorderLayout.WEST);

        // ---------- Table ----------
        model = new DefaultTableModel();
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // ---------- Search Panel ----------
        JPanel searchPanel = new JPanel();

        cbSearchType = new JComboBox<String>(new String[]{
                "WHERE GPA >",
                "LIKE NAME",
                "BETWEEN GPA"
        });

        tfSearch1 = new JTextField(10);
        tfSearch2 = new JTextField(10);
        btnSearch = new JButton("SEARCH");

        searchPanel.add(new JLabel("Search Type"));
        searchPanel.add(cbSearchType);
        searchPanel.add(tfSearch1);
        searchPanel.add(tfSearch2);
        searchPanel.add(btnSearch);

        add(searchPanel, BorderLayout.SOUTH);

        // ---------- Listeners ----------
        btnInsert.addActionListener(this);
        btnFetch.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnSearch.addActionListener(this);
        btnOrderBy.addActionListener(this);
        btnSearch.addActionListener(this);

        // ---------- Database Connection ----------
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/SCOE_CS_B",
                    "root",
                    "root"
            );
            stmt = con.createStatement();
            JOptionPane.showMessageDialog(this, "Database Connected Successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "DB Error: " + e.getMessage());
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == btnInsert) {

                String query =
                        "INSERT INTO users (name, age, gender, course, year, email, phone, address, gpa) VALUES (" +
                                "'" + tfName.getText() + "'," +
                                tfAge.getText() + "," +
                                "'" + tfGender.getText() + "'," +
                                "'" + tfCourse.getText() + "'," +
                                tfYear.getText() + "," +
                                "'" + tfEmail.getText() + "'," +
                                "'" + tfPhone.getText() + "'," +
                                "'" + tfAddress.getText() + "'," +
                                tfGPA.getText() +
                                ")";

                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Record Inserted Successfully");
            }

            else if (ae.getSource() == btnFetch) {

                rs = stmt.executeQuery("SELECT * FROM users");

                ResultSetMetaData rsmd = rs.getMetaData();
                int cols = rsmd.getColumnCount();

                model.setRowCount(0);
                model.setColumnCount(0);

                for (int i = 1; i <= cols; i++) {
                    model.addColumn(rsmd.getColumnName(i));
                }

                while (rs.next()) {
                    Object[] row = new Object[cols];
                    for (int i = 1; i <= cols; i++) {
                        row[i - 1] = rs.getObject(i);
                    }
                    model.addRow(row);
                }
            }
            else if (ae.getSource() == btnUpdate) 
            {
                String updateQuery ="UPDATE users SET GPA=" + Float.parseFloat(tfGPA.getText())
                		+" WHERE email='" + tfEmail.getText() + "'";
                stmt.executeUpdate(updateQuery);
                JOptionPane.showMessageDialog(this, "GPA Updated Successfully");
            }
            else if (ae.getSource() == btnDelete) 
            {
                String deleteQuery ="DELETE FROM users WHERE name='" + tfName.getText().trim() + "'";
                stmt.executeUpdate(deleteQuery);
                JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
            }
            else if (ae.getSource() == btnOrderBy) 
            {

                String orderByQuery = "SELECT * FROM users ORDER BY GPA DESC";
                rs = stmt.executeQuery(orderByQuery);

                ResultSetMetaData rsmd = rs.getMetaData();
                int cols = rsmd.getColumnCount();

                model.setRowCount(0);
                model.setColumnCount(0);

                for (int i = 1; i <= cols; i++) {
                    model.addColumn(rsmd.getColumnName(i));
                }

                while (rs.next()) {
                    Object[] row = new Object[cols];
                    for (int i = 1; i <= cols; i++) {
                        row[i - 1] = rs.getObject(i);
                    }
                    model.addRow(row);
                }
            }
            else if(ae.getSource()==btnSearch)
            {
            	
            	String type=(String)cbSearchType.getSelectedItem();
            	String q="";
      
            	if(type.equals("WHERE GPA >"))
            	{
            		q="SELECT * FROM users WHERE GPA > "+tfSearch1.getText().trim();
            		
            	}
            	else if(type.equals("LIKE NAME"))
            	{
            		q = "SELECT * FROM users WHERE name LIKE '%"+ tfSearch1.getText().trim() + "%'";
            	}
            	else if (type.equals("BETWEEN GPA")) {

            	    q="SELECT * FROM users WHERE GPA BETWEEN "+ tfSearch1.getText() + " AND " + tfSearch2.getText();
            	}
            	
            	rs=stmt.executeQuery(q);
            	
            	ResultSetMetaData rsmd = rs.getMetaData();
                int cols = rsmd.getColumnCount();

                model.setRowCount(0);
                model.setColumnCount(0);

                for (int i = 1; i <= cols; i++) {
                    model.addColumn(rsmd.getColumnName(i));
                }

                while (rs.next()) {
                    Object[] row = new Object[cols];
                    for (int i = 1; i <= cols; i++) {
                        row[i - 1] = rs.getObject(i);
                    }
                    model.addRow(row);
                }

            	
            }



        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new CRUDOperations();
    }
}
