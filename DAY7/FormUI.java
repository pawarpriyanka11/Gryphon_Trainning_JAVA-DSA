package DAY7;
//UI
import java.awt.*;
import javax.swing.*;

//Event
import java.awt.event.*;

//JDBC
import java.sql.*;


public class FormUI extends JFrame implements ActionListener
{
	//UI
	JLabel l1,l2,l3;
	JTextField tf1,tf2,tf3;
	JButton b1,b2,b3,b4;
	
	//JDBC
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	FormUI()
	{
		setLayout(null);
		
		//Labels
		l1=new JLabel("Student number:  ");
		l2=new JLabel("Student name:    ");
		l3=new JLabel("Student stipend: ");
		
		
		//TextFiled
		tf1=new JTextField(20);
		tf2=new JTextField(20);
		tf3=new JTextField(20);
		
		//Buttons
		b1=new JButton("First");
		b2=new JButton("Next");
		b3=new JButton("Prev");
		b4=new JButton("Last");
		
		//setbounds
		l1.setBounds(100, 100, 100, 30);
		tf1.setBounds(220, 100, 100, 30);
		
		l2.setBounds(100, 140, 100, 30);
		tf2.setBounds(220, 140, 100, 30);
		
		l3.setBounds(100, 180, 100, 30);
		tf3.setBounds(220, 180, 100, 30);
		
		
		b1.setBounds(100, 220, 100, 30);
		b2.setBounds(220, 220, 100, 30);
		b3.setBounds(100, 260, 100, 30);
		b4.setBounds(220, 260, 100, 30);

		
		add(l1);
		add(l2);
		add(l3);
		add(tf1);
		add(tf2);
		add(tf3);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		String url = "jdbc:mysql://localhost:3306/SCOE_CS_B";
        String user = "root";
        String pass = "root";
        
		try{
			
			// Step 2: Load and register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3: Connect
            Connection con = DriverManager.getConnection(url, user, pass);
            
            //step 4: create SQL statement
            //create a scrollable ResultSet
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String selectQuery="SELECT * FROM stds_scoe_cs_b ";
            
          //step5. excute sql query
            rs=stmt.executeQuery(selectQuery);
            
          //skip step 6
            
          if(rs.next())
          {
        	  tf1.setText(rs.getString(1));
        	  tf2.setText(rs.getString(2));
        	  tf3.setText(rs.getString(3));
          }
            
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try{
			JButton B=(JButton)ae.getSource();
			if(B==b1)
			{
			rs.first();	
			}
			else if(B==b2)
			{
				if(!rs.isLast())
				{
					rs.next();
				}
			}
			else if(B==b3)
			{
				if(!rs.isFirst())
				{
					rs.previous();
				}
			}
			else if(B==b4)
			{
				rs.last();
			}
			
			
		//properly set
		  tf1.setText(rs.getString(1));
       	  tf2.setText(rs.getString(2));
       	  tf3.setText(rs.getString(3));
	  }
		catch (Exception e) {
          e.printStackTrace();
      }
	}

	
	
	
	public static void main(String[] args) {
		
		
		
		FormUI op=new FormUI();
		op.setVisible(true);
		op.setSize(600,600);
		
		op.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
				
			}
		});
		
	}

}
