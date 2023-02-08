package vTigerCRMappPratice;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class JDBC_Conn
 {
  public static void main(String[] args) throws Throwable
  {
	  //Step 1 : Register or load the Mysql database
	      Driver driverRef = new com.mysql.jdbc.Driver();
	      DriverManager.registerDriver(driverRef);
	
	 //Step 2 : Get connect to the database                                           //db name, un,  pass                  
	       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
	       
	 //Step 3 : Create SQL statement
	       Statement stat = conn.createStatement();
	       String selectQuery = "select * from student_info";
	
	 //Step 4 : Execute statement / Query
	       ResultSet result = stat.executeQuery(selectQuery);
	
	  while (result.next())
	  {
	     System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
	  }
	 //Step 5 : Close the connection from the database
	        conn.close();
  }
}
