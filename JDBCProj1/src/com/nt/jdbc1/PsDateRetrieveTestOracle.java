package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/*CREATE TABLE "SYSTEM"."PERSON_INFO_DATES" 
(	"PID" NUMBER(10,0) NOT NULL ENABLE, 
	"PNAME" VARCHAR2(20 BYTE), 
	"DOB" DATE, 
	"DOJ" DATE, 
	"DOM" DATE, 
	 CONSTRAINT "PERSON_INFO_DATES_PK" PRIMARY KEY ("PID")) */

public class PsDateRetrieveTestOracle {
  private static final String RETRIEVE_DATES_QUERY="SELECT PID,PNAME,DOB,DOJ,DOM FROM PERSON_INFO_DATES";
	public static void main(String[] args) {
	 Connection con=null;
	 PreparedStatement ps=null;
	 ResultSet rs=null;
		try {
				//Load JDBC driver class
			        Class.forName("oracle.jdbc.driver.OracleDriver");
                  //establish the connection 
			        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
				  //create  PreparedStaemetn obj
				      if(con!=null)
					   	   ps=con.prepareStatement(RETRIEVE_DATES_QUERY);
				      
					       //execute  query
				         if(ps!=null) 
				        	 rs=ps.executeQuery();
				         
					       //process the ResultSet obj
				   /*       if(rs!=null) {
				        	  while(rs.next()) {
				        		  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"   "+rs.getString(5));
				        	  }//while
				          }//if */
				          System.out.println("----------------------------------");
				          
					       //process the ResultSet obj
				          if(rs!=null) {
				        	  while(rs.next()) {
                                 int pid=rs.getInt(1);
                                 String name=rs.getString(2);
                                 java.sql.Date  sqdob=rs.getDate(3);
                                 java.sql.Date  sqdoj=rs.getDate(4);
                                 java.sql.Date  sqdom=rs.getDate(5);
                                 //convert java.sql.Date class objs to  String date values
                                 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                                 String sdob=sdf.format(sqdob);
                                 String sdoj=sdf.format(sqdoj);
                                 String sdom=sdf.format(sqdom);
                                 System.out.println(pid+"   "+name+"  "+sdob+"  "+sdoj+"  "+sdom);
				        	  }//while
				          }//if


		}//try
		catch(SQLException se) {
			se.printStackTrace();
			System.out.println("Problem in record insertion");
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
			
			
		}//finally
					    	   
	}//main
}//class
