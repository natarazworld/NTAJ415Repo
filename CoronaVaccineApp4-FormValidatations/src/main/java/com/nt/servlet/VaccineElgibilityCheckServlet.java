package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
		String tage=req.getParameter("page");
		String addrs=req.getParameter("paddrs");
         String csvStatus=req.getParameter("vflag");
         System.out.println(name+"  "+tage+"  "+addrs+"  "+csvStatus);
         int age=0;
   if(csvStatus.equalsIgnoreCase("no")) {
		//form validation logics  (sever side)
		System.out.println("Server side form validations..");
		List<String> errorsList=new ArrayList();
		if(name==null || name.length()==0 || name.equalsIgnoreCase(""))  //required rule on name
			errorsList.add("Person name is required");
		
		 if(addrs==null || addrs.length()==0 || addrs.equalsIgnoreCase(""))  //required rule on address
			 errorsList.add("Person address is required");
		 else if(addrs.length()<10)  // min length rule in address
			 errorsList.add("Person address must have min of 10 characters");
		
		 if(tage==null || tage.length()==0 || tage.equalsIgnoreCase(""))  //required rule on age
			 errorsList.add("Person age is required");
		 else {
			 try {
				 age=Integer.parseInt(tage);
				 if(age<=0 || age>125)
					 errorsList.add("Person age must be in the range of 1 through 125");  // age range rule
			 }
			 catch(NumberFormatException nfe) {
				 errorsList.add("Person  age must be numberic value");  //  age must be numeric value 
			 }
		 }//else
		 
		 if(errorsList.size()>0) {
			 pw.println(" <ul style='color:red'>");
			 for(String errMsg:errorsList)
				 pw.println("<li>"+ errMsg+"</li>");
			 pw.println("</ul>");
			 return ;  //block control going further
		 }
   }//if
   else
	   age=Integer.parseInt(tage);
		
		
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
