//SelectNonSelectTest
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonSelectTest {

	public static void main(String[] args) {
		//read inputs
		Connection con=null;
		Scanner sc=null;
		Statement st=null;
		ResultSet rs=null;
	    try {
	    	 sc=new Scanner(System.in);
	    	int no=0;
	    	String query=null;
	    	if(sc!=null) {
	    		System.out.println("enter SQL query(select or non-select ::");
	    	   query=sc.nextLine();	
	    	}//read inputs
	    	
	    	//Load JDBC dirver class
	    	//Class.forName("oracle.jdbc.driver.OracleDriver");
	    	//establis the connection
	    	
	    	//gather  the results from Db s/w and use them
	    	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
	   
	    	//create JDBC Statement obj
	    	if(con!=null)
	    		st=con.createStatement();
	    	//send and execute SQL query in Db s/w
	    	if(st!=null) {
	    		boolean flag=st.execute(query);
	    		System.out.println(flag);
	    		  if(flag==true) {
	    			  System.out.println("SELECT SQL Query executed");
	    			   //gather and process the ResultSet
	    			   rs=st.getResultSet();
	    			   //process the ResultSet obj
	    			  if(rs!=null) {
	    				  while(rs.next()) {
	    					  System.out.println(rs.getString(1)+"  "+rs.getString(2)+"   "+rs.getString(3));
	    				  }//while
	    			  }//if
	    			  
	    		  }//if
	    		  else {
	    			  System.out.println("Non-SELECT SQL Query executed");
	    			  //gather result
	    			  int count=st.getUpdateCount();  //  long count=st.getLargeUpdateCount();
	    			  System.out.println("no.of records that are effected::"+count);
	    		  }//else
	    	}//if
	    }//try
	    catch(SQLException se) {
	    	se.printStackTrace();
	    	//we can work with error codes
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    finally {
	    	//close  JDBC objs
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
