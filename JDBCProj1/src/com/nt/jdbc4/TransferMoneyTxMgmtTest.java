//ransferMoneyTxMgmtTest
package com.nt.jdbc4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*CREATE TABLE "SYSTEM"."JDBC_ACCOUNT" 
(	"ACNO" NUMBER(10,0) NOT NULL ENABLE, 
	"HOLDER" VARCHAR2(20 BYTE), 
	"BALANCE" FLOAT(126), 
	 CONSTRAINT "JDBC_ACCOUNT_PK" PRIMARY KEY ("ACNO"));
*/
public class TransferMoneyTxMgmtTest {

	public static void main(String[] args) {
	
		long srcAcno=0,destAcno=0;
		double amount=0.0;
		//read inputs
		try(Scanner sc=new Scanner(System.in)){
			   if(sc!=null) {
				   System.out.println("enter soruce account number::");
				   srcAcno=sc.nextLong();
				   System.out.println("Etner dest account number ::");
				   destAcno=sc.nextLong();
				   System.out.println("Enter amount to transfer::");
				   amount=sc.nextDouble();
			   }//if
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				 Statement st=con.createStatement();
				){
			  //Begin Tx
			if(con!=null)
			  con.setAutoCommit(false);
			
			  if(st!=null) {
				  //add queries to the batch  (executing queries in the batch)
				     //for withdraw opeation
				  st.addBatch("update JDBC_ACCOUNT set balance=balance-"+amount+" where acno="+srcAcno);
				     //for deposite opeation
				  st.addBatch("update JDBC_ACCOUNT set balance=balance+"+amount+"where acno="+destAcno);
				  //execut the batch
				  int result[]=st.executeBatch();
				  
				  //process the results from TxMgmt
				  boolean flag=true;
				  for(int i=0;i<result.length;++i) {
					  if(result[i]==0) {
						  flag=false;
						  break;
					  }
				  }
				   if(flag==true) {
					   con.commit();  //commit the Tx 
					   System.out.println("Tx Commited , Money Transffered");
				   }
				   else {
					   con.rollback();  //rollback the Tx
					   System.out.println("Tx rolledback , Money  not Transffered");
				   }
			  }//if
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}//main
}//class
