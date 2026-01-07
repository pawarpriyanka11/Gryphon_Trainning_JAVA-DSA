package DAY8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;

public class SQLOperations extends Frame implements ActionListener{
	
    // JDBC
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    //UI
    TextField empID,empName,managerID,deptID;
    TextArea result;
    Button insert,selfJoin, crossJoin, compositeJoin, multitableJoin;
    
    
    static final String url = "jdbc:mysql://localhost:3306/SCOE_CS_B";
    static final String user = "root";
    static final String pass = "root";
     
    SQLOperations()
    {
    	setTitle("Employee management system");
    	setSize(650,500);
    	setLayout(new FlowLayout());
    	
    	//empID,empName,managerID,deptID
    	add(new Label("Employee ID: "));
    	empID=new TextField();
    	add(empID);
    	
    	add(new Label("Employee Name: "));
    	empName=new TextField();
    	add(empName);
    	
    	add(new Label("Manager ID : "));
    	managerID=new TextField();
    	add(managerID);
    	
    	add(new Label("Department ID : "));
    	deptID=new TextField();
    	add(deptID);
    	
    	
    	//insert,selfJoin, crossJoin, compositeJoin, multitableJoin;
    	insert=new Button("INSERT");
    	selfJoin=new Button("SELF JOIN");
    	crossJoin=new Button("CROSS JOIN");
    	compositeJoin=new Button("COMPOSITE JOIN");
    	multitableJoin=new Button("MUTITABLE JOIN");
    	

    	add(insert);
    	add(selfJoin);
    	add(crossJoin);
    	add(compositeJoin);
    	add(multitableJoin);
    	
    	
    	result=new TextArea(15,75);
    	add(result);
    	
    	insert.addActionListener(this);
    	selfJoin.addActionListener(this);
    	crossJoin.addActionListener(this);
    	compositeJoin.addActionListener(this);
    	multitableJoin.addActionListener(this);
    	
    	setVisible(true);
    	 	
    	 }
    
    public Connection getConnection() throws Exception
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	 return DriverManager.getConnection(url, user, pass);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    	try{
    		
    		Connection con=getConnection();
    		Statement st=con.createStatement();
    		
    		//insert data
    		//insert,selfJoin, crossJoin, compositeJoin, multitableJoin;
    		if(ae.getSource()==insert)
    		{
    			String insertQuery="INSERT INTO employee values ("+empID.getText()+",'"+empName.getText()+"',"+managerID.getText()+","+deptID+")";
    			st.executeUpdate(insertQuery);
    			result.setText("Employee inserted sucessfully!");	
    		}
    		//self join employee-manage
    		//self join
			//concept - self join means joining the table with itself use when data in one row depends on another
			//row of the same table
    		else if(ae.getSource()==selfJoin)
    		{
    			String selfJoinQ="SELECT e.EName,m.EName AS manager "
    		+" FROM employee e LEFT JOIN employee m "
    	    +" ON e.MID=m.EID";
    			ResultSet rs=st.executeQuery(selfJoinQ);
    			
    			result.setText("self join result\n");
    			while(rs.next())
    			{
    				result.append(rs.getString(1)+" -> "+rs.getString(2)+"\n");
    				
    			}
    		}
    		//cross join
    		//cross join returns Cartesian product.
    		//every row of first table * every row of second table.
    		//use in testing, permutations and combinations.
    		
    		
    		
    		else if(ae.getSource()==crossJoin)
    		{
    			String crossJoinQ="SELECT EName,DName FROM employee CROSS JOIN department";
    			
    			ResultSet rs=st.executeQuery(crossJoinQ);
    			result.setText("cross join result\n");
    			while(rs.next())
    			{
    				result.append(rs.getString(1)+" | "+rs.getString(2)+"\n");
    				
    				
    			}
    		}
    		//composite join- join with multiple conditions
    		//composite join uses more than one condition in JOIN clause.
    		
    		else if(ae.getSource()==compositeJoin)
    		{
    			
    			String compositeJoinQ="SELECT EName, DName FROM  employee"+
    			" e JOIN department d ON e.DID=d.DID AND e.EID>0";
    			ResultSet rs=st.executeQuery(compositeJoinQ);
    			
    			result.setText("composite join result\n");
    			while(rs.next())
    			{
    				result.append(rs.getString(1)+" * "+rs.getString(2)+"\n");
    				
    			}
    		}
    		//multitableJoin 
    		//multitableJoin joins more than 2 tables in 1 query.
    		else if(ae.getSource()==multitableJoin)
    		{
    			String multitableJoinQ="SELECT EName, DName, PName FROM employee e "+
    		"JOIN department d ON e.DID=d.DID JOIN project p ON d.DID=p.DID";
    	    			ResultSet rs=st.executeQuery(multitableJoinQ);
    	    			
    	    			result.setText("multitableJoin result\n");
    	    			while(rs.next())
    	    			{
    	    				result.append(rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getString(3)+);
    	    				
    	    			}
    			
    		}
    		
    	}
    	catch(Exception e)
    	{
    		result.setText("Error : "+e);
    	}
    }

	public static void main(String[] args) {
		new SQLOperations();

	}

}
