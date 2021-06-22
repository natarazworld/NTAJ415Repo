package com.nt.jdbc1;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class PsBLOBPhotoRetrieveOracle {
  private static final String  ARTIST_RETRIEVE_QUERY="SELECT AID,NAME,ADDRS,PHOTO FROM ARTIST_INFO WHERE  AID=?";
	public static void main(String[] args) {
		//read inputs
		try(Scanner sc=new Scanner(System.in)) {
			int aid=0;
			if(sc!=null) {
				System.out.println("Enter Artist Id::");
				aid=sc.nextInt();
			}
			
			//create connection,PreparedStatemetn objects
			try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
					  PreparedStatement ps=con.prepareStatement(ARTIST_RETRIEVE_QUERY);
					){
				//set query param 
				if(ps!=null)
					ps.setInt(1, aid);
				
				//execute Query
				try(ResultSet rs=ps.executeQuery()){
					   //prcess the result
					
					if(rs!=null) {
						 if(rs.next()) {
							  aid=rs.getInt(1);
							 String name=rs.getString(2);
							 String addrs=rs.getString(3);
							 System.out.println(aid+ " " +name+"   "+addrs );
							 //get InputStream pointing to BLOB col value
							 try(InputStream is=rs.getBinaryStream(4);
									  //create Output stream pointing to destination file
									  OutputStream os=new FileOutputStream("retrieve_image.jpg");
									 ){
								     // Copy BLOB col value to  Destination file
								     IOUtils.copy(is,os);
								     System.out.println("BLOB value is retrieved and stored in the file");
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
