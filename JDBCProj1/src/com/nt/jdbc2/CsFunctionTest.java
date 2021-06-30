package com.nt.jdbc2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*CREATE OR REPLACE FUNCTION FX_GET_STUDENT_DETAILS_BY_NO 
(
  NO IN NUMBER 
, NAME OUT VARCHAR2 
, ADDRS OUT VARCHAR2 
) RETURN FLOAT AS 
  PERCENTAGE FLOAT;
BEGIN
   
   SELECT SNAME,SADD,AVG INTO NAME,ADDRS,PERCENTAGE FROM STUDENT WHERE SNO=NO;
  
  RETURN  PERCENTAGE;
END FX_GET_STUDENT_DETAILS_BY_NO;
*/
public class CsFunctionTest {
   private static final String CALL_FX_QUERY="{?=call FX_GET_STUDENT_DETAILS_BY_NO(?,?,?) }";
	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in)){
			   //read inputs
			int no=0; 
			if(sc!=null) {
				System.out.println("Enter Student number::");
				no=sc.nextInt();
			}
			try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
					  CallableStatement cs=con.prepareCall(CALL_FX_QUERY);
					){
				   //register return,OUT params with JDBC types
				  if(cs!=null) {
					  cs.registerOutParameter(1,Types.FLOAT); //return param
					  cs.registerOutParameter(3,Types.VARCHAR); //outparameter (index 3)
					  cs.registerOutParameter(4,Types.VARCHAR); //outparameter (index 4)
				  }
				  //set values to  IN params
				  if(cs!=null) 
					  cs.setInt(2, no);
				  //call/execute PL/SQL function
				  if(cs!=null)
					  cs.execute();
				  // gather results from return,OUT params
				  if(cs!=null) {
					  System.out.println("student name:: "+cs.getString(3));  //out param
					  System.out.println("Student addrs::"+cs.getString(4));  //out param
					  System.out.println("Student avg::"+cs.getFloat(1));  //return param
				  }
			}//try2
		}//try1
		catch(SQLException se) {
			System.out.println("Records not found");
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main
}//class
