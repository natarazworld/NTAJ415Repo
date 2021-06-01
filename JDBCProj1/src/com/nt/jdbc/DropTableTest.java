//DropTableTest.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTableTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			//Load JDBC dirver class
	    	//Class.forName("oracle.jdbc.driver.OracleDriver");
	    	//establis the connection
	    	
	    	//gather  the results from Db s/w and use them
	    	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
	   
	    	//create JDBC Statement obj
	    	if(con!=null)
	    		st=con.createStatement();
	    	//prepare SQL query
	    	   //drop  table  temp_student
	    	  String query="DROP  TABLE  TEMP_STUDENT";
	    	  System.out.println(query);
	    	  
	    	  //send and execute SQL query in Db s/w
	    	  int count=0;
	    	  if(st!=null)
	    		  count=st.executeUpdate(query);
	    	  System.out.println("count::"+count);
	    	  //process the result
	    	  if(count==0)
	    		  System.out.println("Db table is dropped");
	    	  else
	    		  System.out.println("Db table is not  created");
	    	
		}//try
		   catch(SQLException se) {
		    	se.printStackTrace();
		    	//we can work with error codes
		    	if(se.getErrorCode()==955)
		    		System.out.println("DB table is already created");
		    }
		    catch(Exception e){
		    	e.printStackTrace();
		    }
		    finally {
		    	//close  JDBC objs
		    	
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
