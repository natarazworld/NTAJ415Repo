//SelectTestTWRWithPostgreSQL.java
package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTestTWRWithPostgreSQL {

	public static void main(String[] args) {
		System.out.println("SelectTest3.main()");
		
		/*try {
			//load jdbc driver class  (optional)
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}*/
		
		try(
				//establish the connection
			// Connection con=DriverManager.getConnection("jdbc:postgresql:NTAJ415DB","postgres", "tiger");
				 Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/NTAJ415DB","postgres", "tiger");
				 //create Statement obj
			Statement  st=con.createStatement();
				//send and execute SQL query in Db s/w
			 ResultSet rs=st.executeQuery("SELECT PID,PNAME,PRICE,QTY,STATUS FROM PRODUCT");        ){
			
			    //process the ResultSet object
			     if(rs!=null) {
			    	 boolean flag=false;
			    	 while(rs.next()) {
			    		flag=true;
			    		 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3)+"  "+rs.getFloat(4)+"  "+rs.getString(5));
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
