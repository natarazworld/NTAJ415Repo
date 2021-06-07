package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsInsertTestSurrogatePKMySQL {
   private  static final String STUDENT_INSERT_QUERY="INSERT INTO STUDENT(SNAME,SADD,AVG) VALUES(?,?,?)"; 
   
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		  try {
			  //read inputs
			  sc=new Scanner(System.in);
			  int count=0;
			  if(sc!=null) {
				  System.out.println("enter students count::");
				  count=sc.nextInt();
			  }
			  //register JDBC driver
			    Class.forName("com.mysql.cj.jdbc.Driver");
			  
			  //establish the connection
			  con=DriverManager.getConnection("jdbc:mysql:///ntaj415DB","root","root");
			  
			  //create PreparedStatement object having pre-compiled SQL query
			  if(con!=null)
			     ps=con.prepareStatement(STUDENT_INSERT_QUERY);
			  
			   //read input values from enduser ,set them to query param values and execute the pre-compiled
			   //SQL query for multiple times
			   if(ps!=null && sc!=null) {
				   for(int i=1;i<=count;++i) {
					   //read each student input values
					   System.out.println("enter "+i+" student details");
					   System.out.println("enter student name::");
					   String name=sc.next();
					   System.out.println("enter student address::");
					   String addrs=sc.next();
					   System.out.println("enter student avg::");
					   float avg=sc.nextFloat();
					   //set each student details as pre-compiled SQL query params
					    ps.setString(1, name); ps.setString(2, addrs); ps.setFloat(3, avg);
					   //execute pre-compiled SQL query each time
					   int result=ps.executeUpdate();
					   //process execution result of pre-compiled-SQL query
					   if(result==0)
						   System.out.println(i+" student details not inserted");
					   else
						   System.out.println(i+" student details are inserted");
				   }//for
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
