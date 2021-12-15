package com.nt.beans;

import java.io.Serializable;

public class StudentInfo implements Serializable {
	//bean propeties
	private int sno;
	private String sname;
	private String sadd;
	private  float avg;
	
	public StudentInfo() {
		System.out.println("StudentInfo:: 0-param constuctor");
	}
	
	//setter and getters   (ctrl+shift+s, r -->select all --> ok)
	public int getSno() {
		System.out.println("StudentInfo.getSno()");
		return sno;
	}
	public void setSno(int sno) {
		System.out.println("StudentInfo.setSno()");
		this.sno = sno;
	}
	public String getSname() {
		System.out.println("StudentInfo.getSname()");
		return sname;
	}
	public void setSname(String sname) {
		System.out.println("StudentInfo.setSname()");
		this.sname = sname;
	}
	public String getSadd() {
		System.out.println("StudentInfo.getSadd()");
		return sadd;
	}
	public void setSadd(String sadd) {
		System.out.println("StudentInfo.setSadd()");
		this.sadd = sadd;
	}
	public float getAvg() {
		System.out.println("StudentInfo.getAvg()");
		return avg;
	}
	public void setAvg(float avg) {
		System.out.println("StudentInfo.setAvg()");
		this.avg = avg;
	}
	
	
	

}
