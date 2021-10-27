package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headurl")
public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter 
		 PrintWriter pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 // write header content
		  pw.println("<marquee><h1 style='color:blue'>N A R E S H  Technologies  </h1></marquee>");
		  
		  // do not close stream
		    //pw.close();
	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          doGet(req,res);
	}

}
