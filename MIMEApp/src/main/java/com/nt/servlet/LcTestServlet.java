package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class LcTestServlet extends HttpServlet {
	
	static {
		System.out.println("LcTestServlet:: static block");
	}
	
	public LcTestServlet() {
		System.out.println("LcTestServlet:: 0-param constructor");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	  System.out.println("LcTestServlet:: init(ServletConfig cg)");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		 System.out.println("LcTestServlet.service(req,res)");
		 //destroy();
		 //get PrintWriter
		 PrintWriter pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 //write  message to response object using PrintWriter
		  pw.println("<h1 style='color:red;text-align:center'> Date and Time::"+new java.util.Date()+"</h1>");
		  //close stream
		  pw.close();
	}
	

	
	@Override
	public void destroy() {
	  System.out.println("LcTestServlet::destroy()");
	}
	

}//class
