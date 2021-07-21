//WebRowSetDemo.java
package com.nt.jdbc4;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import oracle.jdbc.rowset.OracleWebRowSet;

public class WebRowSetDemo {
	public static void main(String[] args) {
		try(OracleWebRowSet wrowset=new OracleWebRowSet()){
			wrowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			wrowset.setUsername("system");
			wrowset.setPassword("manager");
			wrowset.setCommand("SELECT * FROM STUDENT");
			wrowset.execute();
			while(wrowset.next()) {
				System.out.println(wrowset.getInt(1)+"  "+wrowset.getString(2)+" "+wrowset.getString(3)+" "+wrowset.getString(4));
			}//while
			System.out.println("---------------------------");
			//wrting  Db table records as xml content to file
			OutputStream os=new FileOutputStream("student.xml");
			wrowset.writeXml(os);
			System.out.println("----------------------------------");
			//wrting  Db table records as xml content to console
			wrowset.writeXml(System.out);
						
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//main
}//class
