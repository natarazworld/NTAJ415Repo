//SelectTest.java
package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTestTWR {

	public static void main(String[] args) {
		System.out.println("SelectTest3.main()");
		try(
				//establish the connection
			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
				 //create Statement obj
			Statement  st=con.createStatement();
				//send and execute SQL query in Db s/w
			 ResultSet rs=st.executeQuery("SELECT SNO,SNAME,SADD,AVG FROM STUDENT");        ){
			
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
		}//try   //all jdbc objs will be closed
		catch (SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//main
}//class
