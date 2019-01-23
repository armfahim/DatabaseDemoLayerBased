package com.Employee.dao;

import java.util.List;

import com.Employee.model.Employee;

public interface EmployeeDao {
	
	public List<Employee> getAllEmployees();
	
	public void addEmployee(Employee employee);
	
	public Employee getEmployee(int employeeId);
	
	public void updateEmployee(String employeeId);
	
	public void deleteEmployee (String employeeId);

	
	
	

}
