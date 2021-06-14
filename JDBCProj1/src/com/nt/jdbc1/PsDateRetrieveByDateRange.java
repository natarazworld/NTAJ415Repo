package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/*CREATE TABLE "SYSTEM"."PERSON_INFO_DATES" 
(	"PID" NUMBER(10,0) NOT NULL ENABLE, 
	"PNAME" VARCHAR2(20 BYTE), 
	"DOB" DATE, 
	"DOJ" DATE, 
	"DOM" DATE, 
	 CONSTRAINT "PERSON_INFO_DATES_PK" PRIMARY KEY ("PID")) */

public class PsDateRetrieveByDateRange {
  private static final String RETRIEVE_DATES_QUERY="SELECT PID,PNAME,DOB,DOJ,DOM FROM PERSON_INFO_DATES WHERE DOB>=? AND DOB<=?";
	public static void main(String[] args) {
	 Connection con=null;
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 Scanner sc=null;
		try {
			//read inputs
			 sc=new Scanner(System.in);
			 String sdob=null,edob=null;
			  if(sc!=null) {
				  System.out.println("enter Start range of DOB(dd-MM-yyyy) ");
				  sdob=sc.next();
				  System.out.println("enter end range of DOB(dd-MM-yyyy) ");
				  edob=sc.next();
			  }
			  //convert String date values  java.sql.Util calss objs
			  SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
			  java.sql.Date ssqdob=new java.sql.Date(sdf1.parse(sdob).getTime());
			  java.sql.Date esqdob= new java.sql.Date(sdf1.parse(edob).getTime());
				
					
				//Load JDBC driver class
			        Class.forName("oracle.jdbc.driver.OracleDriver");
                  //establish the connection 
			        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
				  //create  PreparedStaemetn obj
				      if(con!=null)
					   	   ps=con.prepareStatement(RETRIEVE_DATES_QUERY);
				      
				      //set values value query params
				      if(ps!=null) {
				    	  ps.setDate(1, ssqdob);
				    	  ps.setDate(2, esqdob);
				      }
				      
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
				        	  boolean flag=false;
				        	  while(rs.next()) {
				        		  flag=true;
                                 int pid=rs.getInt(1);
                                 String name=rs.getString(2);
                                 java.sql.Date  sqdob=rs.getDate(3);
                                 java.sql.Date  sqdoj=rs.getDate(4);
                                 java.sql.Date  sqdom=rs.getDate(5);
                                 //convert java.sql.Date class objs to  String date values
                                 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                                 String dob=sdf.format(sqdob);
                                 String doj=sdf.format(sqdoj);
                                 String dom=sdf.format(sqdom);
                                 System.out.println(pid+"   "+name+"  "+dob+"  "+doj+"  "+dom);
				        	  }//while
				        	  if(flag==false) 
				        		  System.out.println("No Records are found");
				        	  
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
