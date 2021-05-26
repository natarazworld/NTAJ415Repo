//SelectTest4.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest4 {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
      try {
    	  //read inputs
    	   sc=new Scanner(System.in);
    	   int dno=0;
    	   if(sc!=null) {
    		   System.out.println("Enter  dept number ::");
    		   dno=sc.nextInt();  //gives 1
    	   }
    	   //Load  JDBC driver  class
    	      //Class.forName("oracle.jdbc.driver.OracleDriver");
    	   
    	   //establish the connection
    	     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
    	     //create  JDBC Statement obj
    	     if(con!=null)
    	    	 st=con.createStatement();
    	     //prepare SQL query
    	         //select * from dept where deptno=40
    	      String query="SELECT DEPTNO,DNAME,LOC FROM DEPT WHERE DEPTNO="+dno;
    	      System.out.println(query);
    	      
    	      //send execute  the SQL  query
    	    	 if(st!=null)
    	    		 rs=st.executeQuery(query);
    	    	 
    	    	 //process the ResultSet  ( 0 or 1 record)
    	    	 if(rs!=null) {
    	    		 if(rs.next())
    	    			 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3));
    	    		 else
    	    			 System.out.println("No Record found");
    	    	 }//if
      }//try
      catch(SQLException se) {
    	  se.printStackTrace();  
      }
      catch(Exception e) {
    	  e.printStackTrace();
      }
      finally {
    	  //close JDBC objs
    	    try {
    	    	if(rs!=null)
    	    		rs.close();
    	    }//try
    	    catch(SQLException se) {
    	    	se.printStackTrace();
    	    }
    	    
    	    try {
    	    	if(st!=null)
    	    		st.close();
    	    }//try
    	    catch(SQLException se) {
    	    	se.printStackTrace();
    	    }
    	    
    	    try {
    	    	if(con!=null)
    	    		con.close();
    	    }//try
    	    catch(SQLException se) {
    	    	se.printStackTrace();
    	    }
    	    
    	    try {
    	    	if(sc!=null)
    	    		sc.close();
    	    }//try
    	    catch(Exception e) {
    	    	e.printStackTrace();
    	    }
    	    
    	    
      }//finally

	}//main
}//class
