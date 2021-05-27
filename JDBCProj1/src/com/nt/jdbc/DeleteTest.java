//DeleteTest.java
package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			String city=null;
			if(sc!=null) {
				System.out.println("Enter  student address (city name)::");
				city=sc.next(); //gives  hyd
			}
			city="'"+city+"'";  //gives 'hyd'
			
			//register  JDBC driver by loading  JDBC driver class
	        //  Class.forName("oracle.jdbc.drvier.OracleDriver");
	
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
			//create Statement object
			if(con!=null)
				st=con.createStatement();
			//prepare SQL query
			     //delete from student where  sadd='hyd'
			String query="DELETE FROM STUDENT WHERE  SADD="+city;
			System.out.println(query);
			
			//send and execute SQL query in Db s/w
			int count=0;
			if(st!=null)
				count=st.executeUpdate(query);
			
			//process the result
			if(count==0)
				System.out.println("No records found to delete");
			else
				System.out.println("no.of records that are effected ::"+count);
		}//try
		catch (SQLException se) {
			if(se.getErrorCode()>=900 && se.getErrorCode()<=999)
				System.out.println("Invalid col names or table names or SQL keywords");
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
