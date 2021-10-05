package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         //get PrintWriter 
		PrintWriter pw=res.getWriter();
		//get access to SErvletConfig object
		ServletConfig cg=getServletConfig();
		pw.println("<b> servlet name ::"+cg.getServletName()+"</b>");
		System.out.println("TestSevlet's ServletConfig obj::"+cg.hashCode());
		
		//read Init parameter
		pw.println("<br><b> db user init param values  ::"+cg.getInitParameter("dbuser")+"</b>");
		pw.println("<br><b> ServletConfig object class name  ::"+cg.getClass()+"</b>");
		//close stream 
		pw.close();
	}

}
