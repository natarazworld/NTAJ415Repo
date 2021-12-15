package com.nt.service;

import com.nt.beans.Employee;

public class PaySlipGeneratorService {
	
	public  void  generatePaySlip(Employee emp) {
		//calculate Gross salary and net salary
		float grossSalary=emp.getBasicSalary()+ emp.getBasicSalary()*0.4f;
		float netSalary=grossSalary-(grossSalary*0.2f);
		//set the generate gross,netSaalry back to Java bean class obj
		emp.setGrossSalary(grossSalary);
		emp.setNetSalary(netSalary);
	}

}
