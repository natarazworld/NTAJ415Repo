package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PSLoginApp_Type2_OCI {
   private static final String  LOGIN_QUERY="SELECT COUNT(*) FROM IRCTC_TAB WHERE UNAME=? AND PWD=?";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			String user=null,pass=null;
			
			if(sc!=null) {
				System.out.println("enter Login username::");
				user=sc.nextLine();  //gives raja rao' --
				System.out.println("enter Login password::");
				pass=sc.nextLine();  //gives rao rao
			}//if
		
			//Load  JDBc driver class  (optional)
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 //establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:oci8:@xe", "system","manager");
			 //create  JDBC PreparedStatement object
			 if(con!=null)
				 ps=con.prepareStatement(LOGIN_QUERY);
			 
			 //set values to  the params of pre-compiled SQL query
			 if(ps!=null) {
				 ps.setString(1,user);
				 ps.setString(2, pass);
			 }
			   
			   //send and execute the SQL query in Db s/w
			   if(ps!=null)
				   rs=ps.executeQuery();
			   
			   //process the ResultSet object
			   if(rs!=null) {
				  rs.next();  //moves the cursor to  first record from BFR
				  
				  int count=rs.getInt(1);  // get first col value of that first record
				  
				  //process the result 
				  if(count==0)
					  System.out.println("INVALID CREDENTIALS");
				  else
					  System.out.println("VALID CREDENTIALS");
			   }//if
			   }//try
		   catch(SQLException se) {
			   se.printStackTrace();
		   }
		   catch(Exception e) {
			 e.printStackTrace();
		   }
		finally {
			//close jdbc objs
			  try {
				  if(rs!=null)
					  rs.close();
			  }
			  catch(SQLException se) {
				  se.printStackTrace();
			  }
			  try {
				  if(ps!=null)
					  ps.close();
			  }
			  catch(SQLException se) {
				  se.printStackTrace();
			  }
			  try {
				  if(con!=null)
					  con.close();
			  }
			  catch(SQLException se) {
				  se.printStackTrace();
			  }
			  
			  try {
				  if(sc!=null)
					  sc.close();
			  }
			  catch(Exception e) {
				  e.printStackTrace();
			  }
		}//finally

	}//main
}//class
