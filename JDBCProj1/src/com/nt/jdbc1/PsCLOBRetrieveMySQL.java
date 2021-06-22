package com.nt.jdbc1;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class PsCLOBRetrieveMySQL {
  private static final String  JS_RETRIEVE_QUERY="SELECT JSID,JSNAME,JSADDRS,RESUME,PHOTO FROM JOBSEEKER_INFO WHERE JSID=?";
	public static void main(String[] args) {
		//read inputs
		try(Scanner sc=new Scanner(System.in)) {  //try1
			int jsid=0;
			if(sc!=null) {
				System.out.println("Enter Job Id::");
			jsid=sc.nextInt();
				//Load jdbc driver class
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			
			//create connection,PreparedStatemetn objects
			try(Connection con=DriverManager.getConnection("jdbc:mysql:///ntaj415db1", "root", "root");
					  PreparedStatement ps=con.prepareStatement(JS_RETRIEVE_QUERY);
					){  //try2
				//set query param 
				if(ps!=null)
					ps.setInt(1, jsid);
				
				//execute Query
				try(ResultSet rs=ps.executeQuery()){  //try3
					   //prcess the result
					
					if(rs!=null) {
						 if(rs.next()) {
							  jsid=rs.getInt(1);
							 String name=rs.getString(2);
							 String addrs=rs.getString(3);
							 System.out.println(jsid+ " " +name+"   "+addrs );
							 //get Reader Stream pointing to CLOB col value
							 try(Reader reader=rs.getCharacterStream(4);
									 InputStream is=rs.getBinaryStream(5); 
									  //create Output stream pointing to destination file
									  OutputStream os=new FileOutputStream("retrieve_image.jpg");
									  Writer writer=new FileWriter("retrieve_resume.txt")){  //try4
								     // Copy BLOB col value to  Destination file
								     IOUtils.copy(is,os);  //takes images  writung
								     IOUtils.copy(reader,writer);
								     System.out.println("CLOB,BLOB values are  retrieved and stored in the file");
							 }//try4
						 }//if
						 else {
							 System.out.println("Recrod not found");
					 }//else
					   }//if
					}//try3  related rs
				}//try2  //ps ,con
			}//try1  //  sc
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main
}//class
