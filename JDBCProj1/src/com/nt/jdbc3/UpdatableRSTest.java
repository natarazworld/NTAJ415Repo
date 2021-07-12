package com.nt.jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatableRSTest {
       private static final  String  EMP_SELECT_QUERY="SELECT SNO,SNAME,SADD,AVG FROM STUDENT"; 
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
				Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=st.executeQuery(EMP_SELECT_QUERY);
				){
			
			 if(rs!=null) {
			    System.out.println("RS records top to bottom ");
			    int count=0;
			    while(rs.next()) {
			    	System.out.println(rs.getRow()+"----->"+rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
			    }
			    
			    //insert operation
				/* rs.moveToInsertRow();
				rs.updateInt(1,3455);
				rs.updateString(2,"mahesh");
				rs.updateString(3,"hyd");
				rs.updateFloat(4,54.55f);
				rs.insertRow();
				System.out.println("Record inserted");*/
			    
				/*    //update operation
				rs.absolute(4);
				rs.updateFloat(4,99.9f);
				rs.updateRow();*/
			    
			    //delete operation
			    rs.absolute(3);
			    rs.deleteRow();
			    
			    
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
