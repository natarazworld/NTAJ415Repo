package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishMessageServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  //get PrintWriter 
		PrintWriter pw=res.getWriter();
		// set response content type
		res.setContentType("text/html");
		
		//write b.logic to gernate the Wish Message
		LocalDateTime ldt=LocalDateTime.now(); // give current date and time
		int hour=ldt.getHour();  //gives current hour of the day 0 to 23 
		pw.println("<h1 style='color:red;text-align:center'>"+ldt.toString()+"</h1>");
		if(hour<12)
			pw.println("<h1 style='color:orange;text-align:center'>Good Morning </h1>");
		else  if(hour<16)
			pw.println("<h1 style='color:green;text-align:center'>Good AfterNoon </h1>");
		else if(hour<20)
			pw.println("<h1 style='color:pink;text-align:center'>Good Evening </h1>");
		else 
			pw.println("<h1 style='color:red;text-align:center'>Good night </h1>");
		
		//add home hyperlink
		pw.println("<br> <a href='http://localhost:2020/WishApp/page.html'>home</a>");
		
		//close stream
		pw.close();
	
	}

}
