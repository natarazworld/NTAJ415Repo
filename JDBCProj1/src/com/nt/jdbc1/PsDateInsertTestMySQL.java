package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/*CREATE TABLE PERSON_INFO_DATES 
   (	PID   INT(5) Primary key auto_increment , 
	PNAME VARCHAR(30), 
	DOB DATE, 
	DOJ DATE, 
	DOM DATE)*/ 
	 

public class PsDateInsertTestMySQL {
  private static final String INSERT_DATE_QUERY="INSERT INTO PERSON_INFO_DATES(PNAME,DOB,DOJ,DOM) VALUES(?,?,?,?)";
	public static void main(String[] args) {
	 Scanner sc=null;
	 Connection con=null;
	 PreparedStatement ps=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			String name=null, sdob=null,sdoj=null,sdom=null;
			 if(sc!=null) {
				 System.out.println("Person name::");
				 name=sc.next();
				 System.out.println("Person DOB(dd-MM-yyyy) ::");
				 sdob=sc.next();
				 System.out.println("Person DOJ(yyyy-MM-dd) ::");
				 sdoj=sc.next();
				 System.out.println("Person DOM(MMM-dd-yyyy) ::");
				 sdom=sc.next();
			 } 
			 //convert  String date values to java.sql.Date class objs
			   //for DOB(dd-MM-yyyy)
			      //convert String date value to java.util.Date class obj
			        SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
			        java.util.Date udob=sdf1.parse(sdob);
			        //coverting java.util.Date class obj to  java.sql.Date class obj
			        long ms=udob.getTime();
			        java.sql.Date sqdob=new java.sql.Date(ms);
			   //for DOJ  (yyyy-MM-dd  -Direct conversion )
				        //coverting String date value  to  java.sql.Date class obj
				         java.sql.Date sqdoj=java.sql.Date.valueOf(sdoj);
		   //for DOM(MMM-dd-yyyy)
					      //convert String date value to java.util.Date class obj
					        SimpleDateFormat sdf2=new SimpleDateFormat("MMM-dd-yyyy");
					        java.util.Date udom=sdf2.parse(sdom);
					        //coverting java.util.Date class obj to  java.sql.Date class obj
					         ms=udom.getTime();
					        java.sql.Date sqdom=new java.sql.Date(ms);
					        
					//Load JDBC driver class
					        Class.forName("com.mysql.cj.jdbc.Driver");
                  //establish the connection 
					        con=DriverManager.getConnection("jdbc:mysql:///NTAJ415DB1", "root","root");
					  //create  PreparedStaemetn obj
					       if(con!=null)
					    	   ps=con.prepareStatement(INSERT_DATE_QUERY);
					    //set values to query params
					       if(ps!=null) {
					    	   ps.setString(1, name);
					    	   ps.setDate(2,sqdob);
					    	   ps.setDate(3,sqdoj);
					    	   ps.setDate(4, sqdom);
					       }
					       //execute  query
					       int count=0;
					       if(ps!=null) 
					    	   count=ps.executeUpdate();
					       //process the results
					       if(count==0)
					    	   System.out.println("Record not inserted");
					       else
					    	   System.out.println("Record inserted");
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
