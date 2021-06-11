//PsSelectTest3.java
package com.nt.jdbc1;

/*  Java App to get Employee details based on given intial characters   Employee name  */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PsSelectTest3 {
  private static final String SELECT_EMP_QUERY="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN('CLERK','MANAGER')"; 
	public static void main(String[] args) {
		System.out.println("SelectTest3.main()");
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			
			//register  JDBC driver by loading  JDBC driver class
			        //  Class.forName("oracle.jdbc.drvier.OracleDriver");
			
			//establish the connection
			  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
			  //create Statement object
			  if(con!=null)
				  ps=con.prepareStatement(SELECT_EMP_QUERY);
			 
			    
			    //send and execute SQL query in DB s/w
			    if(ps!=null) 
			    	  rs=ps.executeQuery();
			    
			    //process the ResultSet object
			    
			     if(rs!=null) {
			    	 boolean flag=false;
			    	 while(rs.next()) {
			    		flag=true;
			    		 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3)+"  "+rs.getFloat(4));
			    	 }//while
			    	 
			    	 if(flag==false)
			    		 System.out.println("No Records  found");
			     }//if
			     
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
