package com.Employee.Service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.Employee.dao.EmployeeDao;
import com.Employee.dao.OrderDao;
import com.Employee.model.Employee;
import com.Employee.model.Order;

public class EmpDaoImplTest {
	
	Employee emp = new Employee();

	EmployeeDao empDao = new EmpDaoImpl();

	@Test
	public void testGetAllEmployees() {
		List<Employee> empList = new ArrayList<Employee>();
		empList = empDao.getAllEmployees();
		
		assertEquals(empList.size(), 3);
	
	}

	@Test
	public void testAddEmployee() {
		emp.setEmployeeId(9);
		emp.setName("sabb");
		emp.setSalary((float) 2000.00);
		emp.setCountry("Bangladesh");
		emp.setCity("Dhaka");
		emp.setZipCode(1200);

		//assertTrue(empDao.addEmployee(emp));
		assertEquals(true, empDao.addEmployee(emp));
	}

	@Test
	public void testDeleteEmployee() {
		assertTrue(empDao.deleteEmployee(9));
	}

	@Test
	public void testUpdateEmployee() {
		emp.setZipCode(1232);
		emp.setSalary((float) 35000.00);

		assertTrue(empDao.updateEmployee(emp));
	}

	@Test
	public void testGetEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateTable() {
		fail("Not yet implemented");
	}

	@Test
	public void testInnerJoin() {
		fail("Not yet implemented");
	}

	@Test
	public void testLeftJoin() {
		fail("Not yet implemented");
	}

	@Test
	public void testRightJoin() {
		fail("Not yet implemented");
	}

	@Test
	public void testFullJoin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGroupByQueryCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGroupByQueryMax() {
		fail("Not yet implemented");
	}

	@Test
	public void testGroupByQuerySum() {
		fail("Not yet implemented");
	}

}
