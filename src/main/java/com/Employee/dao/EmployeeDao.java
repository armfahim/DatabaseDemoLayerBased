package com.Employee.dao;

import java.util.List;

import com.Employee.model.Employee;

public interface EmployeeDao {
	
	public List<Employee> getAllEmployees();
	
	public Boolean addEmployee(Employee employee);
	
	public Employee getEmployee(int employeeId);
	
	public Boolean updateEmployee(Employee emp);
	
	public Boolean deleteEmployee (int employeeId);
	
	
	
	public Boolean CreateTable(String sql);
	
	// ------For Order------
	
	public List<Employee> innerJoin();
	
	public List<Employee> leftJoin();
	
	public List<Employee> rightJoin();
	
	public List<Employee> fullJoin();
	
	public List<Employee> GroupByQueryCount(String qry);
	
	public List<Employee> GroupByQueryMax(String qry);
	
	public List<Employee> GroupByQuerySum(String qry);


	
	
	

}
