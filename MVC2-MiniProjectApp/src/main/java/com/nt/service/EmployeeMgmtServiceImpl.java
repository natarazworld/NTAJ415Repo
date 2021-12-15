package com.nt.service;

import java.util.List;

import com.nt.dao.EmployeeDAOImpl;
import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	   private  IEmployeeDAO   empDAO;
	   
	   public EmployeeMgmtServiceImpl() {
		   empDAO=new EmployeeDAOImpl();
	}

	@Override
	public List<Employee> fetchEmpsByDesg(String desg) throws Exception {
		//use  DAO
		List<Employee> list=empDAO.getEmpsByDesg(desg);
		list.forEach(emp->{
			emp.setGrossSalary(emp.getSalary()+ (emp.getSalary()*0.3f));
			emp.setNetSalary(emp.getGrossSalary()-(emp.getGrossSalary()*0.2f));
		});
		return list;
	}

}
