package com.Employee.dbUtil;

import com.Employee.Service.EmpDaoImpl;
import com.Employee.dao.EmployeeDao;
import com.Employee.model.Employee;

public class DBOperations {
	
	public static void main(String[] args) {

		Employee emp = new Employee();

		EmployeeDao empDao = new EmpDaoImpl();

		emp.setName("Abu");
		emp.setEmployeeId("E007");
		emp.setSalary(50000.00);
		emp.setCountry("America");
		emp.setCity("Florida");
		emp.setZipCode(121);

		//empDao.addEmployee(emp);
		//empDao.deleteEmployee("E006");
		empDao.updateEmployee("E008");

}

}
