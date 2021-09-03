package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VaccineElgibilityCheckServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VaccineElgibilityCheckServlet.doPost(-,-)");
		// get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response conten type
		res.setContentType("text/html");
		//read form form data  (req parameter vlaues)
		String name=req.getParameter("pname");
		int age=Integer.parseInt(req.getParameter("page"));
		String addrs=req.getParameter("paddrs");
		//write b.logic (request procesing logic)
		 if(age<18)
			 pw.println("<h1 style='color:red;text-align:center'>Mr/Miss/Mirss."+name+"   U r not elgible for Corona Vaccination </h1>");
		 else
			 pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mirss."+name+"   U r  elgible for Corona Vaccination, Make it happen </h1>");
		 
		 //add home hyerlink (graphical  hyperlink)
		 pw.println("<a href='corona_vaccine.html'> <img src='images/home1.png'> </a>");
		 
		 //close stream
		 pw.close();
	}//doGet(-,-)
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VaccineElgibilityCheckServlet.doGet(-,-)");
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		// get System date and time
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		if(hour<12)
			pw.println("<h1 style='color:orange;text-align:center'> Good Morning </h1>");
		else if(hour<16)
			pw.println("<h1 style='color:red;text-align:center'> Good AfterNoon </h1>");
		else if(hour<20)
			pw.println("<h1 style='color:pink;text-align:center'> Good Evening </h1>");
		else
			pw.println("<h1 style='color:green;text-align:center'> Good Night </h1>");
         //close stream
		pw.close();
	}//doGet(-,-)
	
}//class
