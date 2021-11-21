package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.wrapper.CustomRequest;
import com.nt.wrapper.CustomResponse;

@WebFilter("/loginurl")
public class LoginFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//create CustomRequest object
		CustomRequest  creq=new CustomRequest(req);
		//create CustomResponse obj
		CustomResponse  cres=new CustomResponse(res);
		
		chain.doFilter(creq, cres);  //calls next filter or destination comp
		// collect content from custom response obj
		String output=cres.toString();
		//modify the content
		output=output+"<br> <b>Naresh IT</b>";
		//get PrinterWirter  pointing to container created response obj
		PrintWriter pw=res.getWriter();
		pw.println(output); //writes container created response obj ---> container --> server ---> browser window
		
		//close stream
		pw.close();
	
	}
}
