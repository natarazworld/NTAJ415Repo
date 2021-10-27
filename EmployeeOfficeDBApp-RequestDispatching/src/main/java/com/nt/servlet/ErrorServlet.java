package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/errorurl",name = "err")
public class ErrorServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 System.out.println("ErrorServlet: doGet(-,-) ");
		 //get PrintWriter
		PrintWriter pw=res.getWriter();
		// set response content ype
		 res.setContentType("text/html");
		 //Write error response 
		 pw.println("<h1 style='color:red;text-align:center'> Internal problem -- try again </h1>");
	    //close stream
		 pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ErrorServlet: doPost(-,-) ");
	  doGet(req,res);
	}
 
}//class
