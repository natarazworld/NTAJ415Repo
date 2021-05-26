//SelectTest5.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest5WithMySQL {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
      try {
    	  
    	   //Load  JDBC driver  class
    	      //Class.forName("com.mysql.cj.jdbc.Driver");
    	   
    	   //establish the connection
    	     con=DriverManager.getConnection("jdbc:mysql:///NTAJ415DB", "root", "root");
    	     
    	     //create  JDBC Statement obj
    	     if(con!=null)
    	    	 st=con.createStatement();
    	     
    	     //prepare SQL query
    	         //select count(*) from student 
    	      String query="SELECT COUNT(*) FROM STUDENT";
    	      System.out.println(query);
    	      
    	      //send execute  the SQL  query
    	    	 if(st!=null)
    	    		 rs=st.executeQuery(query);
    	    	 
    	    	 //process the ResultSet  (  1 record)
    	    	 if(rs!=null) {
    	    		    rs.next();
    	    		    //int count=rs.getInt(1);
    	    		    int count=rs.getInt("COUNT(*)");
    	    		    System.out.println("Records count in Student DB table::"+count);

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
      }//finally

	}//main
}//class
