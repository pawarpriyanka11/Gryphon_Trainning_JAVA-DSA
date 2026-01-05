package DAY7;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.sql.ResultSet;
//import java.sql.DriverManager;

import java.sql.*;


public class JDBC2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/SCOE_CS_B";
		String user="root";
		String pass="root";
//		String dbName="SCOE_CS_B";
		
		try{
			// step2. load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");//cj- connector jar
			
			//step3. connect to database
		    Connection con=DriverManager.getConnection(url,user,pass);
		    System.out.println("Database connected sucessfully");
		    
		    //step4. create the sql stmts
		    //create the table
		    Statement stmt=con.createStatement();
		    String createTableQuery="CREATE TABLE IF NOT EXISTS stds_scoe_cs_b ("+"stds_no INT PRIMARY KEY,"+"stds_name varchar(100),"+"stds_stipend DOUBLE)";
		    
		    //step5. excute sql query
		    stmt.executeUpdate(createTableQuery);
		    
		    //step6. result
		    System.out.println("Table stds_scoe_cs_b created sucessfully");
		    
		    // step4. create the sql stmts
		    //insert the data into table
		    String insertQuery="INSERT INTO stds_scoe_cs_b (stds_no,stds_name,stds_stipend) VALUES(?,?,?)";
		   
		    PreparedStatement pst=con.prepareStatement(insertQuery);
		    
		    //step5. excute sql query
		    
		    //insert first students record
		    pst.setInt(1,701);
		    pst.setString(2,"Priyanka");
		    pst.setDouble(3,12090000.85);
		 
		    pst.executeUpdate();
		    
		    //insert second students record
		    pst.setInt(1,702);
		    pst.setString(2,"Sanksruti");
		    pst.setDouble(3,12000.90);
		    
		    pst.executeUpdate();
		    
		    
		    //insert third students record
		    pst.setInt(1,703);
		    pst.setString(2,"Akanksha");
		    pst.setDouble(3,16900.90);
		    
		    pst.executeUpdate();
		    
		    //insert second students record
		    pst.setInt(1,704);
		    pst.setString(2,"Pratiksha");
		    pst.setDouble(3,355000.90);
		    
		    pst.executeUpdate();
		    
		    //insert fourth students record
		    pst.setInt(1,705);
		    pst.setString(2,"Tara");
		    pst.setDouble(3,340900.90);
		    
		    pst.executeUpdate();
		    
		  //insert fifth students record
		    pst.setInt(1,706);
		    pst.setString(2,"Ruhi");
		    pst.setDouble(3,6578798.85);
		 
		    pst.executeUpdate();
		    
		    //insert sixth students record
		    pst.setInt(1,707);
		    pst.setString(2,"OM");
		    pst.setDouble(3,678989.90);
		    
		    pst.executeUpdate();
		    
		    
		    //insert seventh students record
		    pst.setInt(1,708);
		    pst.setString(2,"Akanksha");
		    pst.setDouble(3,57879.90);
		    
		    pst.executeUpdate();
		    
		    //insert eighth students record
		    pst.setInt(1,709);
		    pst.setString(2,"Pratiksha");
		    pst.setDouble(3,879809.90);
		    
		    pst.executeUpdate();
		    
		    //insert nine students record
		    pst.setInt(1,7010);
		    pst.setString(2,"Rutik");
		    pst.setDouble(3,348799.90);
		    
		    pst.executeUpdate();
		    
		    
		    
		  //step6. result
		    System.out.println("Students records inserted sucessfully");
		    
		    
		  //step7. close the connection
		    con.close();
		    	    
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
