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

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            //  Get PrintWriter 
		   PrintWriter pw=res.getWriter();
		   // set response content type
		   res.setContentType("text/html");
		   //Create cookies
		     Cookie ck1=new Cookie("ap","NoCapital");
		     Cookie ck2=new Cookie("TS","hyd");
		     
		     Cookie ck3=new Cookie("MH","Mumbai");
		     Cookie ck4=new Cookie("Odisha","BBSR");
		     ck3.setMaxAge(2*60);
		     ck4.setMaxAge(1*60);
		     
		     //add cookies to the reponse
		     res.addCookie(ck1); res.addCookie(ck2);  // InMemory cookies 
		     res.addCookie(ck3); res.addCookie(ck4); //Persistence cookies
		     
		     pw.println("<h1 style='color:red;text-align:center'>Cookies are added successfully </h1>");
		     
		     //close streams
		     pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
