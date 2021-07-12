package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Type5DriverSelectTest {
   private static final String  SELECT_STUDENTS_QUERY="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
	public static void main(String[] args) {
		/*	try {
				//Load  JDBc driver class  (optional)
				 Class.forName("com.ddtek.jdbc.oracle.OracleDriver");
			}
			catch(ClassNotFoundException cnf) {
				cnf.printStackTrace();
			}*/
		try(Connection con=DriverManager.getConnection("jdbc:datadirect:oracle://localhost:1521;serviceName=xe",
				                                                                                 "system","manager");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(SELECT_STUDENTS_QUERY);
				){
			   //process the ResultSet object
			      if(rs!=null) {
			    	  while(rs.next()) {
			    		  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
			    	  }//while
			   }//if
			   }//try
		   catch(SQLException se) {
			   se.printStackTrace();
		   }
		   catch(Exception e) {
			 e.printStackTrace();
		   }
	}//main
}//class
