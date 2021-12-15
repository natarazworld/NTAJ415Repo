package com.nt.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PrimeTag extends  TagSupport{
	private int n=20;
	
	public  void setN(int n) {
		System.out.println("PrimeTag.setN(-)");
		this.n=n;
	}
	
	public PrimeTag() {
		System.out.println("PrimeTag:: 0-param constructor");
	}
	
	private  boolean   isPrime(int x) {
		
		 for(int i=2;i<x;++i) {
			    if(x%i==0)
			    	return false;
		 }
		 return true;
		 
	}
	
	
	@Override
	public int doStartTag() throws JspException {
		System.out.println("PrintLabelTag.doStartTag()");
		JspWriter pw=pageContext.getOut();
		try {
			for(int i=1;i<=n;++i)
				  if(isPrime(i))
					  pw.println(i+"&nbsp;&nbsp;");
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
