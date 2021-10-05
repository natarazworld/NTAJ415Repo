package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet  extends HttpServlet {
	private  static final String  GET_EMP_BY_ENO="SELECT EMPNO,ENAME,SAL,JOB,DEPTNO FROM EMP WHERE EMPNO=?";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    //get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//get access to ServletContext object
		ServletContext sc=getServletContext();
		System.out.println("EmpSearchSevlet's ServletContext obj hashCode::"+sc.hashCode());
		//read Servlet init param values
		String driver=sc.getInitParameter("driverClass");
		String  url=sc.getInitParameter("url");
		String user=sc.getInitParameter("dbuser");
		String pwd=sc.getInitParameter("dbpwd");
				
		//read form data
		int no=Integer.parseInt(req.getParameter("eno"));
		try {
			Class.forName(driver);
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		//write  JDBC  code
		try(Connection con=DriverManager.getConnection(url,user,pwd);
				PreparedStatement ps=con.prepareStatement(GET_EMP_BY_ENO)){
  			   if(ps!=null)
				   ps.setInt(1, no);
	       try(ResultSet rs=ps.executeQuery()){		   
			    if(rs!=null) {
			    	if(rs.next()) {
			    		pw.println("<h1 style='color:blue;text-align:center'> Employee Details are </h1>");
			    		
			    		pw.println("<p style='text-align:center'><b> Employee number:: "+rs.getInt(1)+"</b> <br>");
			    		pw.println("<b> Employee name:: "+rs.getString(2)+"</b><br>");
			    		pw.println("<b> Employee Desg:: "+rs.getString(4)+"</b><br>");
			    		pw.println("<b> Employee Salary:: "+rs.getFloat(3)+"</b><br>");
			    		pw.println("<b> Employee Dept number:: "+rs.getInt(5)+"</b></p>");
			    	}//if
			    	else {
			    		pw.println("<h1 style='color:red;text-align:center'> Employee Not Found </h1>");
			    	}//else
			    }//if
			    pw.println("<br><br><p style='text-align:center'><a href='search.html'>home </a>");
			    
			    //close stream
			    pw.close();
		  }//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}//doPost(-,-)

}//class
