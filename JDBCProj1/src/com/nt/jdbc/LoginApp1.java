package com.nt.jdbc;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginApp1 {

	public static void main(String[] args) {
		
		Connection con=null;
		Console cons=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//read inputs
		   cons=System.console();   //java.util.Console does not work Eclipse IDE
			String user=null,pass=null;
			if(cons!=null) {
				System.out.println("enter Login username::");
				user=cons.readLine();  //gives  raja rao
				System.out.println("enter Login password::");
				pass=new String(cons.readPassword());  //gives rao rao
			}//if
			//convert input  values  as required for the SQL query
			user="'"+user+"'"; //gives  'raja rao'
			pass="'"+pass+"'";  //gives  'rao rao'
			//Load  JDBc driver class  (optional)
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 //establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			 //create  JDBC statement object
			 if(con!=null)
				 st=con.createStatement();
			  //prepare SQL query 
			        //select count(*) from IRCTC_TAB WHERE  uname='raja' and pwd='rani';
			   String query="SELECT COUNT(*) FROM IRCTC_TAB WHERE  UNAME="+user+" AND PWD="+pass;
			   System.out.println(query);
			   
			   //send and execute the SQL query in Db s/w
			   if(st!=null)
				   rs=st.executeQuery(query);
			   
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
				  if(st!=null)
					  st.close();
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
		}//finally

	}//main
}//class
