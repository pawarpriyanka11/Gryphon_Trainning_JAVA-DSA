package DAY7;
//step1. import the package
import java.sql.*;

public class JDBCConnection {

	/**
	 * STEPS
	 * 1. import package
	 * 2. load and register driver
	 * 3. connect 
	 * 4. write commands
	 * 5. execute commands
	 * 6. get response
	 * 7. close
	 */
	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/";
		String user="root";
		String pass="root";
		String dbName="SCOE_CS_B";
		
		try{
			// step2. load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step3. connect to database
		    Connection con=DriverManager.getConnection(url,user,pass);
		    
		    //step4. create the sql stmts
		    Statement stmt=con.createStatement();
		    String query="CREATE DATABASE "+dbName;
		    
		    //step5. excute the sql query
		    stmt.executeUpdate(query);
		    
		    //step6. we got result 
		    System.out.print("database created successfull with "+dbName);
		    
		    
		    //step7. close the connection
		    con.close();
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
