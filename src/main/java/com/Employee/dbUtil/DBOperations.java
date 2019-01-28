package com.Employee.dbUtil;

import java.util.ArrayList;
import java.util.List;

import com.Employee.Service.EmpDaoImpl;
import com.Employee.Service.OrderDaoImpl;
import com.Employee.dao.EmployeeDao;
import com.Employee.dao.OrderDao;
import com.Employee.model.Employee;
import com.Employee.model.Order;

public class DBOperations {
	
	public static void main(String[] args) {

		Employee emp = new Employee();

		EmployeeDao empDao = new EmpDaoImpl();

		emp.setName("Onu");
		emp.setEmployeeId(1);
		emp.setSalary((float) 70000.00);
		emp.setCountry("London");
		emp.setCity("Lords");
		emp.setZipCode(2031);
		//empDao.addEmployee(emp);
		
		//empDao.deleteEmployee(1);
		
		//empDao.updateEmployee("E008");
		
      //  Employee emp2 = empDao.getEmployee(2);
		
		//System.out.println("Employee Detail: \n\nEmployee ID: "+emp2.getEmployeeId()+"\nName: "+emp2.getName()+"\nSalary: "+emp2.getSalary()+"\nCountry: "+emp2.getCountry()+"\nCity: "+emp2.getCity()+"\nZip Code: "+emp2.getZipCode());
		
		
		emp.setEmployeeId(123);
		emp.setSalary(30000);
		//empDao.updateEmployee(emp);
		
		
		emp.setName("Mahadi");
		emp.setEmployeeId(456);
		emp.setSalary((float) 25.00);
		emp.setCountry("Bangladesh");
		emp.setCity("Dhaka");
		emp.setZipCode(1200);
	
		
		//empDao.addEmployee(emp);
		
		
		//empDao.deleteEmployee(456);
		
		
		
		for(Employee emp3 : empDao.getAllEmployees() )
		{
			System.out.println("Employee Detail: \n\nEmployee ID: "+emp3.getEmployeeId()+"\nName: "+emp3.getName()+"\nSalary: "+emp3.getSalary()+"\nCountry: "+emp3.getCountry()+"\nCity: "+emp3.getCity()+"\nZip Code: "+emp3.getZipCode()+"\n\n");
		}
		
		
		
//		String sql = "CREATE TABLE Projects " +
//                "(projectId INTEGER not NULL, " +
//                " pName VARCHAR(50), " + 
//                " emloyeeId INTEGER, " + 
//                " PRIMARY KEY ( projectId ))";
//		
//		empDao.CreateTable(sql);
		
		
		//----------------------------------------------------------------------------
		
		
		Order or = new Order();
		OrderDao proDao= new OrderDaoImpl();
		
		or.setOrderId(101);
		or.setOrderName("Snacks");
		or.setEmployeeId(3);
		
		//proDao.addOrder(or);
		
		
		List<Employee> empList = new ArrayList<Employee>();
		
		empList = empDao.innerJoin();
		
		for(Employee emp4 : empList )
		{
			System.out.println("Inner Join: \n\nEmployee ID: "+emp4.getEmployeeId()+"\nEmployee Name: "+emp4.getName()+"\nOrder ID: "+emp4.getOrderId()+"\nOrder Name: "+emp4.getOrderName()+"\n\n");
		}
		
		for(Employee emp5 : empDao.leftJoin() )
		{
			System.out.println("Left Join: \n\nEmployee ID: "+emp5.getEmployeeId()+"\nEmployee Name: "+emp5.getName()+"\nOrder ID: "+emp5.getOrderId()+"\nProject Name: "+emp5.getOrderName()+"\n\n");
		}
		
		for(Employee emp6 : empDao.rightJoin() )
		{
			System.out.println("Right Join: \n\nEmployee ID: "+emp6.getEmployeeId()+"\nEmployee Name: "+emp6.getName()+"\nOrder ID: "+emp6.getOrderId()+"\nOrder Name: "+emp6.getOrderName()+"\n\n");
		}
		
		for(Employee emp7 : empDao.fullJoin() )
		{
			System.out.println("Full Join: \n\nEmployee ID: "+emp7.getEmployeeId()+"\nEmployee Name: "+emp7.getName()+"\nOrder ID: "+emp7.getOrderId()+"\nOrder Name: "+emp7.getOrderName()+"\n\n");
		}
		
		
		
		System.out.println("Count employees from each cities:\n\n");
		String qry = "SELECT COUNT(ID), City"
				+ " FROM TEmployee"
				+ " GROUP BY City";
		
		System.out.println("Employee Counts\t\tCity Name\n");
		
		for(Employee emp2 : empDao.GroupByQueryCount(qry) )
		{
			System.out.println(emp2.getEmployeeId()+"\t\t\t"+emp2.getCity()+"\n\n");
		}
		
		
		System.out.println("Count[order by ASC] employees from each cities:\n\n");
		String qryy = "SELECT COUNT(ID), City"
				+ " FROM TEmployee"
				+ " GROUP BY City"
				+ " ORDER BY COUNT(ID) ASC";
		
		System.out.println("Employee Counts\t\tCity Name\n");
		
		for(Employee emp2 : empDao.GroupByQueryCount(qryy) )
		{
			System.out.println(emp2.getEmployeeId()+"\t\t\t"+emp2.getCity()+"\n\n");
		}
		
		
		
		
		System.out.println("Count[Having] employees from each cities:\n\n");
		String qryx = "SELECT COUNT(ID), City"
				+ " FROM TEmployee"
				+ " GROUP BY City"
				+ " HAVING COUNT(ID) < 2";
		
		System.out.println("Employee Counts\t\tCity Name\n");
		
		for(Employee emp2 : empDao.GroupByQueryCount(qryx) )
		{
			System.out.println(emp2.getEmployeeId()+"\t\t\t"+emp2.getCity()+"\n\n");
		}
		
		
		
		String qry2 = "SELECT MAX(Salary),Name"
				+ " FROM TEmployee"
				+ " GROUP BY Country";
		
		System.out.println("Max salary from each department:\n\n");
		
		System.out.println("Employee Salary\t\tDepartment Name\n");
		
		for(Employee emp2 : empDao.GroupByQueryMax(qry2) )
		{
			System.out.println(emp2.getSalary()+"\t\t\t"+emp2.getCountry()+"\n\n");
		}
		
		
		
		String qry3 = "SELECT MIN(Salary),ZipCode"
				+ " FROM TEmployee"
				+ " GROUP BY Country";
		
		System.out.println("MIN salary from each department:\n\n");
		
		System.out.println("Employee Salary\t\tDepartment Name\n");
		
		for(Employee emp2 : empDao.GroupByQueryMax(qry3) )
		{
			System.out.println(emp2.getSalary()+"\t\t\t"+emp2.getCountry()+"\n\n");
		}
		 
		
		
		String qry4 = "SELECT SUM(Salary),Name"
				+ " FROM TEmployee"
				+ " GROUP BY Country";
		
		System.out.println("SUM salary department wise:\n\n");
		
		System.out.println("Employee Salary\t\tDepartment Name\n");
		
		for(Employee emp2 : empDao.GroupByQueryMax(qry4) )
		{
			System.out.println(emp2.getSalary()+"\t\t\t"+emp2.getCountry()+"\n\n");
		}
		


}

}
