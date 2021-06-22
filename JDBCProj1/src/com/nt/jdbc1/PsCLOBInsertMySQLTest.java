package com.nt.jdbc1;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*CREATE TABLE `ntaj415db1`.`jobseeker_info` (
		  `jsId` INT NOT NULL AUTO_INCREMENT,
		  `jsname` VARCHAR(25) NULL,
		  `jsaddrs` VARCHAR(25) NULL,
		  `resume` LONGTEXT NULL,
		  `photo` LONGBLOB NULL,
		  PRIMARY KEY (`jsId`),
		  UNIQUE INDEX `jsId_UNIQUE` (`jsId` ASC) VISIBLE);
*/

public class PsCLOBInsertMySQLTest {
   private static final String  INSERT_JOBSEEKER_QUERY="INSERT INTO JOBSEEKER_INFO(JSNAME,JSADDRS,RESUME,PHOTO) VALUES(?,?,?,?)";
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){   //try1
			//read inputs
			String name=null,addrs=null, resumeLocation=null,photoLocation=null;
			if(sc!=null) {
				System.out.println("Enter jobseeker name::");
				name=sc.next();
				System.out.println("Enter jobseeker addrss::");
				addrs=sc.next();
				System.out.println("Enter Resume Location::");
				resumeLocation=sc.next().replace("?","");
				System.out.println("Enter photo Location::");
				photoLocation=sc.next().replace("?","");
			}//if
			//create InputStream pointining photo file
			try(Reader reader=new FileReader(resumeLocation);
					InputStream is=new FileInputStream(photoLocation)){  //try2
				//establish the connection and prepared Statement object
				try(Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj415db1","root", "root");
				    PreparedStatement ps=con.prepareStatement(INSERT_JOBSEEKER_QUERY);	)	{ //try3
				//set values to qyery param
				if(ps!=null) {
					ps.setString(1,name);
					ps.setString(2, addrs);
					ps.setCharacterStream(3, reader);
					ps.setBinaryStream(4, is);
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
