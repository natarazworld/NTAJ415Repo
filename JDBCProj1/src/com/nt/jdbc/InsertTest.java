//InsertTest.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			int  no=0;
			String name=null,addrs=null;
			float avg=0.0f;
			if(sc!=null) {
				System.out.println("enter student number::");
				no=sc.nextInt(); //gives 1001
				System.out.println("enter student name::");
				name=sc.next(); //gives rakesh
				System.out.println("enter student address::");
				addrs=sc.next(); //gives hyd
				System.out.println("enter student avg::");
				avg=sc.nextFloat(); //gives 56.77
			}
			//convert input values as required for  the SQL query
			  name="'"+name+"'"; //gives  'rakesh'
			  addrs="'"+addrs+"'"; //gives  'hyd'
			  
			    //  Class.forName("oracle.jdbc.drvier.OracleDriver");
				
				//establish the connection
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
				//create Statement object
				if(con!=null)
					st=con.createStatement();
				
				//preprae SQL query
				    //insert into student values(567,'ramesh','hyd',67.88)
				String query="insert into student values("+no+","+name+","+addrs+","+avg+")";
				System.out.println(query);
				
				//send execute SQL query in Db s/w
				int count=0;
				if(st!=null)
					count=st.executeUpdate(query);
				
				//process the Result
				if(count==0)
					System.out.println("Record not inserted");
				else
					System.out.println("Record inserted");
		}//try
		catch (SQLException se) {
			if(se.getErrorCode()==1)
				System.out.println("Duplicates can not inserted to PK column");
			if(se.getErrorCode()==1400)
				System.out.println("NULL can not inserted to PK column");
			if(se.getErrorCode()>=900 && se.getErrorCode()<=999)
				System.out.println("Invalid col names or table names or SQL keywords");
			else  if(se.getErrorCode()==12899)
				System.out.println("Do not insert more than col size data to sname,sadd cols");
			
			System.out.println("Problem in record insertion......");
				
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
			
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
