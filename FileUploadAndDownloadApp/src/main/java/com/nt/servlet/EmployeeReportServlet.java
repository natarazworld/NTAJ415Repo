package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reporturl")
public class EmployeeReportServlet extends HttpServlet {
	private static final String  GET_ALL_EMPS_QUERY="SELECT EID,ENAME,EADD,RESUME_PATH,PHOTO_PATH FROM UPLOAD_EMPLOYEE ";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
             //get PrintWriter
		   PrintWriter pw=res.getWriter();
		   //set response content type
		   res.setContentType("text/html");
		   //load the clas jdbc ddriver class
		   try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		   }
		   catch(ClassNotFoundException cnf) {
			   cnf.printStackTrace();
		   }
		   //write  jdbc code to get Db table records as report content
		   try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				   PreparedStatement ps=con.prepareStatement(GET_ALL_EMPS_QUERY);
				   ResultSet rs=ps.executeQuery();
				   ){
			       //process the ResultSet and display the content as html table content
			      pw.println("<table border='1' align='center'  bgcolor='cyan'>");
			      pw.println("<tr><th> empno </th> <th> ename </th> <th> Eadd </th> <th> resume </th> <th> photo </th></tr>");
			      while(rs.next()) {
			    	  pw.println("<tr>");
			    	  pw.println("<td>"+rs.getInt(1)+"</td>");
			    	  pw.println("<td>"+rs.getString(2)+"</td>");
			    	  pw.println("<td>"+rs.getString(3)+"</td>");
			    	  pw.println("<td><a href='downloadurl?resumeId="+rs.getInt(1)+"'> download resume</a></td>");
			    	  pw.println("<td><a href='downloadurl?photoId="+rs.getInt(1)+"'> download photo</a></td>");
			    	  pw.println("</tr>");
			      }
			      pw.println("</table>");
			      
			      // add home hyperlink
			      pw.println("<br> <a href='index.html'>home </a>");
			      //close stream 
			      pw.close();
		   }
		   catch(SQLException se) {
			   se.printStackTrace();
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
             doGet(req,res);
	}//doPost(-,-)

}//class
