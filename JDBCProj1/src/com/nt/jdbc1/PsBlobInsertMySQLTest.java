package com.nt.jdbc1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*CREATE TABLE `ntaj415db1`.`artist_info` (
		  `aid` INT NOT NULL AUTO_INCREMENT,
		  `name` VARCHAR(15) NULL,
		  `addrs` VARCHAR(15) NULL,
		  `photo` LONGBLOB NULL,
		  PRIMARY KEY (`aid`),
		  UNIQUE INDEX `aid_UNIQUE` (`aid` ASC) VISIBLE); */

public class PsBlobInsertMySQLTest {
   private static final String  INSERT_ARTIST_QUERY="INSERT INTO ARTIST_INFO(NAME,ADDRS,PHOTO) VALUES(?,?,?)";
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			//read inputs
			String name=null,addrs=null, photoLocation=null;
			if(sc!=null) {
				System.out.println("Enter artist name::");
				name=sc.next();
				System.out.println("Enter Artist addrss::");
				addrs=sc.next();
				System.out.println("Enter Artist photo Location::");
				photoLocation=sc.next().replace("?","");
			}//if
			//create InputStream pointining photo file
			try(InputStream is=new FileInputStream(photoLocation)){
				//establish the connection and prepared Statement object
				try(Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj415db1","root", "root");
				    PreparedStatement ps=con.prepareStatement(INSERT_ARTIST_QUERY);	)	{
				//set values to qyery param
				if(ps!=null) {
					ps.setString(1,name);
					ps.setString(2, addrs);
					ps.setBinaryStream(3, is);
				}
				//execute the query
				int count=0;
				if(ps!=null) 
					count=ps.executeUpdate();
				
				//process the results
				if(count==0)
					  System.out.println("record not inserted");
				else
					System.out.println("Record inserted");
			}//try3
			}//try2
		}//try1
	  catch(SQLException se) {
		  se.printStackTrace();
		  System.out.println("Problem in record insertion");
	  }
       catch(Exception e) {
    	   e.printStackTrace();
       }
		
	}//main
}//class
