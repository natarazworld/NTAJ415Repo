package com.nt.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PrintLabelTag extends  TagSupport{
	
	public PrintLabelTag() {
		System.out.println("PrintLabelTag:: 0-param constructor");
	}
	
	@Override
	public int doStartTag() throws JspException {
		System.out.println("PrintLabelTag.doStartTag()");
		JspWriter pw=pageContext.getOut();
		try {
			pw.println("<h1>The Prime Number are </h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return  SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("PrintLabelTag.doEndTag()");
	     return EVAL_PAGE;
	}

}
