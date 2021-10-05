package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         //get PrintWriter 
		PrintWriter pw=res.getWriter();
		//get access to SErvletContext object
		ServletContext sc=getServletContext();
		//read Context Init parameter
		pw.println("<br><b> db pwd context param values  ::"+sc.getInitParameter("dbpwd")+"</b>");
		//get Access Servlet Config object
		ServletConfig cg=getServletConfig();
		pw.println("<br><b> db pwd init param values  ::"+cg.getInitParameter("dbpwd")+"</b>");
		pw.println("<br><b> ServletContext object class name  ::"+sc.getClass()+"</b>");
		//close stream 
		pw.close();
	}

}
