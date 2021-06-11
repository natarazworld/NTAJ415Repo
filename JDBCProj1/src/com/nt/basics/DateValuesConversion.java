package com.nt.basics;

import java.text.SimpleDateFormat;

public class DateValuesConversion {

	public static void main(String[] args)throws Exception {
		//Converting String date value to java.util.Date class obj
		String s1="41-22-1990"; //dd-MM-yyyy
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date ud1=sdf.parse(s1);
		System.out.println("String date value ::"+s1);
		System.out.println("util date::"+ud1);
		
		//converting  java.util.Date class obj to java.sql.Date class obj
		long ms=ud1.getTime();  // gives no.of milliseconds that  elapsed b/w 
		                                           //ud1 date and time and  1970 jan 1st mid night 00:00 hrs  (Epoach standard)
		System.out.println("ms::"+ms);
		java.sql.Date sd1=new java.sql.Date(ms);
		System.out.println("util date ::"+ud1);
		System.out.println("sql date ::"+sd1);
		
		// if String date value pattern  is yyyy-MM-dd pattern then it can be converted directly to java.sql.Date class obj
		// with out converting to  java.uti.Date class obj.   
			String s2="1991-17-25" ;   //yyyy-MM-dd
		java.sql.Date sd2=java.sql.Date.valueOf(s2);
		System.out.println("String date value ::"+s2);
		System.out.println("sql date value ::"+sd2);
		
		
		
		
		
		

	}

}
