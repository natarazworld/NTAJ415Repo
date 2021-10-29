package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s4url")
public class Servlet4 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		    // get PrintWriter
		     PrintWriter pw=res.getWriter();
		     //set response content type
		     res.setContentType("text/html");
		     //read and display request attribute values
		     pw.println("<b>Servlet4::  attr1 (req) value ::"+req.getAttribute("attr1")+"</b>");
		     
		     //read and display ses attribute values
		     HttpSession ses=req.getSession();
		     pw.println("<br><b>Servlet4::  attr2 (ses) value ::"+ses.getAttribute("attr2")+"</b>");
		     
		     //read and display ServletContext attribute values
		     ServletContext sc=getServletContext();
		     pw.println("<br><b>Servlet4::  attr3 (sc) value ::"+sc.getAttribute("attr3")+"</b>");
		     
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
           doGet(req,res);
	}//doPost(-,-)
	

}//class
