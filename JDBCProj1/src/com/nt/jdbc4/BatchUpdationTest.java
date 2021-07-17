package com.nt.jdbc4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdationTest {

	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				 Statement st=con.createStatement()){
			//add queries to batch ..these queries can belong to same db table or different db tables but must be non-select Queries
			  st.addBatch("INSERT INTO STUDENT VALUES(6189,'animesh','delhi',78.99)");
			  st.addBatch("UPDATE  STUDENT SET AVG=AVG-40 WHERE SNO>=10000");
			  st.addBatch("DELETE FROM STUDENT WHERE SNO<=10");
			  //execute the batch
			  int result[]=st.executeBatch();
			  //find sum of  the records that are effected
			  int sum=0;
			   for(int i=0;i<result.length;++i)
				   sum=sum+result[i];
			   
			   System.out.println("Total no.of records that effected::"+sum);
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
                 

	}

}
