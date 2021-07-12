package com.nt.jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SensitiveRSTest {
       private static final  String  EMP_SELECT_QUERY="SELECT SNO,SNAME,SADD,AVG FROM STUDENT"; 
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
				Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=st.executeQuery(EMP_SELECT_QUERY);
				){
			
			 if(rs!=null) {
			    System.out.println("RS records top to bottom ");
			    int count=0;
			    while(rs.next()) {
			    
			    	if(count==0)
			    		Thread.sleep(30000);  //during this sleep period modify records of db table from SQL developr/prompt
			    	
			    	rs.refreshRow();
			    	count++;
			    	System.out.println(rs.getRow()+"----->"+rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
			    }
			 }//if
					 
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
