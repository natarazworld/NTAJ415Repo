//XmlServlet.java
package com.nt.servlet;
 
 import javax.servlet.*;
 import javax.servlet.http.*;
 import java.io.*;

 public class XmlServlet extends  HttpServlet
 {
	 
	 static {
			System.out.println("XmlServlet:: static block");
		}
		
		public XmlServlet() {
			System.out.println("XmlServlet:: 0-param constructor");
		}
		
		@Override
		public void init(ServletConfig config) throws ServletException {
		  System.out.println("XmlServlet:: init(ServletConfig cg)");
		}
	 
	 protected  void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		  System.out.println("XmlServlet.service()");
		 //set response content type
		  res.setContentType("text/xml");
		  //get PrintWriter Stream
		  PrintWriter pw=res.getWriter();
		  //write output content to browser
		  pw.println("<table border='1' align='center' >");
          pw.println("<tr> <th>Player name  </th>  <th> Medal </th>    <th> category </th>  </tr>");
		  pw.println("<tr> <td> Neeraj chopra </td> <td>Gold </td>  <td>Javaline throw </td> </tr>");
 		  pw.println("<tr> <td> Meera Bhai chanu </td> <td>Silver </td>  <td>Weight lifting </td> </tr>");
  		  pw.println("<tr> <td> RaviKumar Dhahiya </td> <td>Silver </td>  <td>Wresling </td> </tr>");
   		  pw.println("<tr> <td> p.v sindhu </td> <td>bronze </td>  <td>batminton </td> </tr>");
   		  pw.println("<tr> <td> Lovlina </td> <td>bronze </td>  <td>boxing </td> </tr>");
   		  pw.println("<tr> <td> Hokey </td> <td>Bronze </td>  <td>Mens Hockey </td> </tr>");
   		  pw.println("<tr> <td> Bajarang </td> <td>Bronze </td>  <td>wresling </td> </tr>");
		  pw.println("</table>");
         //close stream
		 pw.close();
	 }//serivce(-,-)
 }//class



