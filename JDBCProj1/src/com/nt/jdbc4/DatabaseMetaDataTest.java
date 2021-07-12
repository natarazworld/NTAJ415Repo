package com.nt.jdbc4;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetaDataTest {
	
	public static void main(String[] args) {
		
		try(//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager")
				Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj415db1","root", "root")
				){
			  //create DatabaseMetaData obj
			DatabaseMetaData dbmd=con.getMetaData();
			if(dbmd!=null) {
				System.out.println("db s/w name ::"+dbmd.getDatabaseProductName());
				System.out.println("DB s/w version::"+dbmd.getDatabaseProductVersion());
				System.out.println("jdbc driver name::"+dbmd.getDriverName());
				System.out.println("jdbc driver version::"+dbmd.getDriverVersion());
				System.out.println("All SQL keywords ::"+dbmd.getSQLKeywords());
				System.out.println("ALL numeric functions::"+dbmd.getNumericFunctions());
				System.out.println("All system functions ::"+dbmd.getSystemFunctions());
				System.out.println("All String functions ::"+dbmd.getStringFunctions());
				System.out.println(" Max chars in table name :: "+dbmd.getMaxTableNameLength());
				System.out.println("Max tables in a select Query:: "+dbmd.getMaxTablesInSelect());
				System.out.println(" Max row size:: "+dbmd.getMaxRowSize());
				System.out.println(" Supports PL/SQL procedures ?:: "+dbmd.supportsStoredProcedures());
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
