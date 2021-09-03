package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowHomeServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		 //set response content type
		res.setContentType("text/html");
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//write output to response obj
		pw.println("<h1 style='color:red;text-align:center'> welcome to servlet </h1>");
		//close stream
		pw.close();
	}
	
}
