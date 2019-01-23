package com.Employee.Service;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import com.Employee.dao.EmployeeDao;
import com.Employee.dbUtil.DBConnection;
import com.Employee.model.Employee;

public class EmpDaoImpl implements EmployeeDao {
	
	DBConnection dbConnection = new DBConnection();

	Connection conn = dbConnection.createConnection();
	

	
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}


	public void addEmployee(Employee employee) {
		Connection con = null;

		Statement st = null;

		String insert = "insert into TEmployee values('"+employee.getName()+"', '"+employee.getEmployeeId()+"', '"+employee.getSalary()+"', '"+employee.getCountry()+"', '"+employee.getCity()+"', '"+employee.getZipCode()+"')";

		try

		{

		DBConnection dc = new DBConnection();

		con = dc.createConnection();

		st = con.createStatement();

		st.execute(insert);

		System.out.println("Inserted");

		}

		catch(Exception e)

		{

		System.out.println(e);

		}

		}


	
	public Employee getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void updateEmployee(String employeeId) {
		Connection con = null;

		Statement st = null;

		String update = "UPDATE TEmployee SET Name = 'Alfred Schmidt', ID= 'AL01' WHERE ID ='E008'";

		try

		{

		DBConnection dc = new DBConnection();

		con = dc.createConnection();

		st = con.createStatement();

		st.execute(update);

		System.out.println("updated");

		}

		catch(Exception e)

		{

		System.out.println(e);

		}
		
	}

	
	public void deleteEmployee(String employeeId) {
		
		Connection con = null;

		Statement st = null;

		String delete = "delete from TEmployee where ID='E006'";

		try

		{

		DBConnection dc = new DBConnection();

		con = dc.createConnection();

		st = con.createStatement();

		st.execute(delete);

		System.out.println("deleted");

		}

		catch(Exception e)

		{

		System.out.println(e);

		}
	}
	
	
	
	
	
	

}
