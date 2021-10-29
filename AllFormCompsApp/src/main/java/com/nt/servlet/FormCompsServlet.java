package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formurl")
public class FormCompsServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    //get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		 //read form data
		String name=req.getParameter("pname");
		String addrs=req.getParameter("paddrs");
		int age=Integer.parseInt(req.getParameter("page"));
		String gender=req.getParameter("gender");
		String ms=req.getParameter("ms");
		ms=(ms==null)?"single":ms;
		String qlfy=req.getParameter("qlfy");
		String languages[]=req.getParameterValues("languages");
          if(languages==null)
        	     languages=new String[] {" no languaes are selected"};
          
		String hobies[]=req.getParameterValues("hb");
		 if(hobies==null)
			  hobies=new String[] {" no hobies are selected"};
		 
		String  dob=req.getParameter("dob");
		String tob=req.getParameter("tob");
		String month=req.getParameter("mob");
		String wdb=req.getParameter("wdb");
		int favNumber=Integer.parseInt(req.getParameter("favNumber"));
		long  mobileNo=Long.parseLong(req.getParameter("mobileNo"));
		String mail=req.getParameter("mail");
		String favColor=req.getParameter("favColor");
		int income=Integer.parseInt(req.getParameter("income"));
		String url=req.getParameter("fburl");
		String favSS=req.getParameter("favSearch");
		//write b..logic
		if(gender.equalsIgnoreCase("M")) {
			 if(age<5)
				 pw.println("<h1 style='color:blue;text-align:center'>Master::"+name+" u r a baby boy </h1>");
			 else if(age<13)
				 pw.println("<h1 style='color:blue;text-align:center'>Master::"+name+" u r a small boy </h1>");
			 else if(age<19)
				 pw.println("<h1 style='color:blue;text-align:center'>Mr::"+name+" u r a teenagel boy </h1>");
			 else if(age<35)
				 pw.println("<h1 style='color:blue;text-align:center'>Mr::"+name+" u r a youn man </h1>");
			 else if(age<50)
				 pw.println("<h1 style='color:blue;text-align:center'>Mr::"+name+" u r a middle-aged man </h1>");
			 else
				 pw.println("<h1 style='color:blue;text-align:center'>Mr::"+name+" u r a budda </h1>");
		}
		else {
			 if(age<5)
				 pw.println("<h1 style='color:blue;text-align:center'>Master::"+name+" u r a baby girl </h1>");
			 else if(age<13)
				 pw.println("<h1 style='color:blue;text-align:center'>Master::"+name+" u r a small girl </h1>");
			 else if(age<19) {
				  if(ms.equalsIgnoreCase("married"))
				     pw.println("<h1 style='color:blue;text-align:center'>Mrs::"+name+" u r a teenage married girl </h1>");
				  else
					  pw.println("<h1 style='color:blue;text-align:center'>Miss::"+name+" u r a teenage  girl </h1>");
			 }
			 else if(age<35) {
				 if(ms.equalsIgnoreCase("married"))
				     pw.println("<h1 style='color:blue;text-align:center'>Mrs::"+name+" u r a young married girl </h1>");
				  else
					  pw.println("<h1 style='color:blue;text-align:center'>Miss::"+name+" u r a young  girl </h1>");
			 }
			 else if(age<50) {
				 if(ms.equalsIgnoreCase("married"))
				     pw.println("<h1 style='color:blue;text-align:center'>Mrs::"+name+" u r a middle-aged woman </h1>");
				  else
					  pw.println("<h1 style='color:blue;text-align:center'>Miss::"+name+" u r a middle-aged womain </h1>");
			 }
			 else {
				 if(ms.equalsIgnoreCase("married"))
				     pw.println("<h1 style='color:blue;text-align:center'>Mrs::"+name+" u r a old woman </h1>");
				  else
					  pw.println("<h1 style='color:blue;text-align:center'>Miss::"+name+" u r a old woman </h1>");
			 }
			 
		}//else
		 //display form data
		pw.println("<br><br><b> from data :: </b> <br>");
		pw.println("<br><b> name::  </b>"+name);
		pw.println("<br><b> age::  </b>"+age);
		pw.println("<br><b> Address::  </b>"+addrs);
		pw.println("<br><b> Gender::  </b>"+gender);
		pw.println("<br><b> Marital Status::  </b>"+ms);
		pw.println("<br><b> Qualification ::  </b>"+qlfy);
		pw.println("<br><b> know Lanauages ::  </b>"+Arrays.toString(languages));
		pw.println("<br><b> hobies ::  </b>"+Arrays.toString(hobies));
		pw.println("<br><b> DOB ::  </b>"+dob);
		pw.println("<br><b> TOB ::  </b>"+tob);
		pw.println("<br><b> Month of Birth ::  </b>"+month);
		pw.println("<br><b> Week of Birth ::  </b>"+wdb);
		pw.println("<br><b> Fav Color::  </b>"+favColor);
		pw.println("<br><b> Search Strng::  </b>"+favSS);
		pw.println("<br><b> income::  </b>"+income);
		pw.println("<br><b> mobileNo::  </b>"+mobileNo);
		pw.println("<br><b> Email::  </b>"+mail);
		pw.println("<br><b> Fav number::  </b>"+favNumber);
		pw.println("<br><b> FB url::  </b>"+url);
		
		//add home hyperlink
		pw.println("<br><br> <a href='all_comps_form.html'>home </a>");
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
