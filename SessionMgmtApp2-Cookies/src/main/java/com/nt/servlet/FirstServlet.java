package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
             //get PrintWriter
		    PrintWriter pw=res.getWriter();
		    res.setContentType("text/html");
		    //read form1/request1 data
		    String name=req.getParameter("pname");
		    String fname=req.getParameter("fname");
		    String addrs=req.getParameter("address");
		    String ms=req.getParameter("ms");
		    //create InMemory cookies having form1/req1 data
		    Cookie ck1=new Cookie("name",name);
		    Cookie ck2=new Cookie("fname",fname);
		    Cookie ck3=new Cookie("addrs",addrs);
		    Cookie ck4=new Cookie("ms",ms);
		    //add cookies to the response
		    res.addCookie(ck1);
		    res.addCookie(ck2);
		    res.addCookie(ck3);
		    res.addCookie(ck4);
		    
		    //generate form2  based on marital status value
		    if(ms.equalsIgnoreCase("married")) {
		    	pw.println("<form action='secondurl' method='POST'>");
		    	pw.println("<table align='center' bgcolor='pink'>"); 
		    	pw.println("<tr><td> spouse name :: </td> <td> <input type='text' name='f2t1'></td></tr>");
		    	pw.println("<tr><td> No.of kids :: </td> <td> <input type='text' name='f2t2'></td></tr>");
		    	pw.println("<tr><td><input type='submit' value='register'> </td> <td><input type='reset' value='cancel'> </td></tr>");
		    	pw.println("</table>");
		    	pw.println("</form>");
		    }
		    else {
		    	pw.println("<form action='secondurl' method='POST'>");
		    	pw.println("<table align='center' bgcolor='pink'>"); 
		    	pw.println("<tr><td> Why do u want to marry :: </td> <td> <input type='text' name='f2t1'></td></tr>");
		    	pw.println("<tr><td> When do u want to marry :: </td> <td> <input type='text' name='f2t2'></td></tr>");
		    	pw.println("<tr><td><input type='submit' value='register'> </td> <td><input type='reset' value='cancel'> </td></tr>");
		    	pw.println("</table>");
		     	pw.println("</form>");
		    }
		    
		    //close stream
		   pw.close();
		    
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
     doGet(req,res);
	}//doPost(-,-)
}//class
