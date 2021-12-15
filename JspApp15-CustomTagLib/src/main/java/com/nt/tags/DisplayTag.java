package com.nt.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DisplayTag extends TagSupport {
	private  int  size=20;
	private  String font;
	
	
	public void setSize(int size) {
		this.size = size;
	}

	public void setFont(String font) {
		this.font = font;
	}

	@Override
	public int doStartTag() throws JspException {
	    //get Out Object
		  JspWriter  out=pageContext.getOut();
		  try {
			  out.println("<span style='font-family:"+font+";font-size:"+size+"px;' >");
			  
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return EVAL_BODY_INCLUDE;
		
	}//doStartTag()
	
	@Override
	public int doEndTag() throws JspException {
		//get Out Object
		  JspWriter  out=pageContext.getOut();
		  try {
			  out.println("</span>");
			  
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return  EVAL_PAGE;
		
	}//doEndTag()

}//class
