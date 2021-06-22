package com.nt.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsInsertTestSurrogatePKPostgreSQL {
   private  static final String PRODUCT_INSERT_QUERY="INSERT INTO PRODUCT  VALUES(NEXTVAL('PID_SEQ'),?,?,?,?)"; 
   
	public static void main(String[] args) {
		  try (Scanner	  sc=new Scanner(System.in)){
			  int count=0;
			  if(sc!=null) {
				  System.out.println("enter students count::");
				  count=sc.nextInt();
			  }
			  
		 try(Connection	  con=DriverManager.getConnection("jdbc:postgresql:NTAJ415DB","postgres","tiger");
			  PreparedStatement  ps=con.prepareStatement(PRODUCT_INSERT_QUERY)){
			   //read input values from enduser ,set them to query param values and execute the pre-compiled
			   //SQL query for multiple times
			   if(ps!=null && sc!=null) {
				   for(int i=1;i<=count;++i) {
					   //read each student input values
					   System.out.println("enter "+i+" prodcut details");
					   System.out.println("enter product name::");
					   String name=sc.next();
					   System.out.println("enter product price::");
					   float price=sc.nextFloat();
					   System.out.println("enter  product qty::");
					   float qty=sc.nextFloat();
					   System.out.println("enter  product status::");
					   String status=sc.next();
					   //set each student details as pre-compiled SQL query params
					    ps.setString(1, name); ps.setFloat(2, price); ps.setFloat(3, qty); ps.setString(4, status);
					   //execute pre-compiled SQL query each time
					   int result=ps.executeUpdate();
					   //process execution result of pre-compiled-SQL query
					   if(result==0)
						   System.out.println(i+" product details not inserted");
					   else
						   System.out.println(i+" product details are inserted");
				   }//for
			   }//if
			  
		  }//try2
		  }///try1
		  catch(SQLException se) {
			  se.printStackTrace();
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
	}//main
}//class
