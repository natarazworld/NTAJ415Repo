package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginApp {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
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
			//convert input  values  as required for the SQL query
			user="'"+user+"'"; //gives  'raja rao' --'
			pass="'"+pass+"'";  //gives  'rao rao'
			//Load  JDBc driver class  (optional)
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 //establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			 //create  JDBC statement object
			 if(con!=null)
				 st=con.createStatement();
			  //prepare SQL query 
			        //select count(*) from IRCTC_TAB WHERE  uname='raja rao' --' and pwd='rao r';
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
