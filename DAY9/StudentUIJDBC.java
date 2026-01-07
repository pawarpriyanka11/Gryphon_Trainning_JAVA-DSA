package DAY9;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentUIJDBC extends Frame implements ActionListener {
    Button b1, b2, b3, b4, b5;
    TextArea ta;
    Connection con;

    StudentUIJDBC() {

        setTitle("Student Management System (Analytics)");
        setSize(950, 520);
        setLayout(null);

        b1 = new Button("Latest Student per Dept");
        b2 = new Button("Top Marks per Dept");
        b3 = new Button("Above Dept Avg Marks");
        b4 = new Button("Marks Trend");
        b5 = new Button("Marks Contribution %");

        b1.setBounds(30, 60, 230, 30);
        b2.setBounds(30, 100, 230, 30);
        b3.setBounds(30, 140, 230, 30);
        b4.setBounds(30, 180, 230, 30);
        b5.setBounds(30, 220, 230, 30);

        ta = new TextArea();
        ta.setBounds(300, 60, 620, 380);
        ta.setEditable(false);

        add(b1); add(b2); add(b3); add(b4); add(b5);
        add(ta);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try { if (con != null) con.close(); } catch (Exception ex) {}
                dispose();
            }
        });

        connectDB();
        setVisible(true);
    }

    void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/SCOE_CS_B",
                "root",
                "root"
            );
            ta.setText("Database Connected Successfully\n");
        } catch (Exception e) {
            ta.setText("Database Connection Failed\n" + e);
        }
    }

    void executeQuery(String sql, String heading) {
        try {
            ta.setText(heading + "\n============;========================\n");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            ResultSetMetaData md = rs.getMetaData();
            int cols = md.getColumnCount();

            // Print column names
            for (int i = 1; i <= cols; i++) {
                ta.append(md.getColumnName(i) + "\t");
            }
            ta.append("\n------------------------------------\n");

            // Print rows
            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                    ta.append(rs.getString(i) + "\t");
                }
                ta.append("\n");
            }
        } catch (Exception e) {
            ta.setText("Error:\n" + e);
        }
    }

    public void actionPerformed(ActionEvent ae) {

        // Latest joined student per department
        if (ae.getSource() == b1) {
            executeQuery(
                "SELECT student_name, dept, join_date " +
                "FROM (SELECT *, ROW_NUMBER() OVER (PARTITION BY dept ORDER BY join_date DESC) rn " +
                "FROM stud) x WHERE rn = 1",
                "Latest Student per Department"
            );
        }

        // Top marks per department
        else if (ae.getSource() == b2) {
            executeQuery(
                "SELECT student_name, dept, marks " +
                "FROM (SELECT *, RANK() OVER (PARTITION BY dept ORDER BY marks DESC) rnk " +
                "FROM stud) x WHERE rnk = 1",
                "Top Marks per Department"
            );
            
        }

        // Students above department average marks
        else if (ae.getSource() == b3) {
            executeQuery(
                "SELECT student_name, dept, marks " +
                "FROM (SELECT *, AVG(marks) OVER (PARTITION BY dept) avg_marks " +
                "FROM stud) x WHERE marks > avg_marks",
                "Students Above Department Average Marks"
            );
        }

        // Marks trend based on join date
        else if (ae.getSource() == b4) {
            executeQuery(
                "SELECT student_name, join_date, " +
                "CASE " +
                "WHEN marks > LAG(marks) OVER (ORDER BY join_date) THEN 'UP' " +
                "WHEN marks < LAG(marks) OVER (ORDER BY join_date) THEN 'DOWN' " +
                "ELSE 'SAME' END AS trend " +
                "FROM stud",
                "Marks Trend"
            );
        }

        // Percentage contribution of marks in department
        else if (ae.getSource() == b5) {
            executeQuery(
                "SELECT student_name, dept, " +
                "marks * 100 / SUM(marks) OVER (PARTITION BY dept) AS contribution " +
                "FROM stud",
                "Marks Contribution Percentage"
            );
        }
    }

    public static void main(String[] args) {
        new StudentUIJDBC();
    }
}
