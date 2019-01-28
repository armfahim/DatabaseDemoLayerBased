package com.Employee.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Employee.dao.EmployeeDao;
import com.Employee.dbUtil.DBConnection;
import com.Employee.model.Employee;


public class EmpDaoImpl implements EmployeeDao {
	
	DBConnection dbConnection = new DBConnection();

	Connection conn = dbConnection.createConnection();
	

	
	public List<Employee> getAllEmployees() {
		DBConnection ds = new DBConnection();
		Connection con = ds.createConnection();
		Statement st = null;
		ResultSet res = null;
		
		try {
			String qry = "SELECT * FROM TEmployee";
			st = con.createStatement();
			res = st.executeQuery(qry);
			Employee emp = new Employee();
			List <Employee> empList = new ArrayList<Employee>();
			
			while(res.next())
			{
			      
				
				emp.setName(res.getString("Name"));
				emp.setEmployeeId(res.getInt("ID"));
				emp.setSalary(res.getFloat("Salary"));
				emp.setCountry(res.getString("Country"));
				emp.setCity(res.getString("City"));
				emp.setZipCode(res.getInt("ZipCode"));
				
				empList.add(emp);
				
			}
			return empList;
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
		
			
	}

	public Boolean addEmployee(Employee employee) {
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
		return true;

		}

		catch(Exception e)

		{

		System.out.println(e);

		}
		return null;

	}
	
	public Boolean deleteEmployee(int zcode) {
		
		Connection con = null;

		Statement st = null;

		String delete = "delete from TEmployee where ID="+zcode;

		try

		{

		DBConnection dc = new DBConnection();

		con = dc.createConnection();

		st = con.createStatement();

		st.execute(delete);

		System.out.println("deleted");
		return true;

		}

		catch(Exception e)

		{

		System.out.println(e);

		}
		return null;
	}


	public Boolean updateEmployee(Employee emp) {
		Connection con = null;
		Statement st = null;
		
		String sql = "UPDATE TEmployee SET salary="+"'"+emp.getSalary()+"'"+"WHERE employeeId="+emp.getEmployeeId();
		
		try {
			DBConnection ds = new DBConnection();
			con = ds.createConnection();
			st = con.createStatement();
			st.execute(sql);
			System.out.println("Information updated for Employee ID: "+emp.getEmployeeId());
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}



	public Employee getEmployee(int employeeId) {
		DBConnection ds = new DBConnection();
		Connection con = ds.createConnection();
		Statement st = null;
		ResultSet res = null;
		
		try {
			String qry = "SELECT * FROM Employee WHERE employeeId="+employeeId;
			st = con.createStatement();
			res = st.executeQuery(qry);
			Employee emp = new Employee();
			while(res.next())
			{
				emp.setName(res.getString("Name"));
				emp.setEmployeeId(res.getInt("ID"));
				emp.setSalary(res.getFloat("Salary"));
				emp.setCountry(res.getString("Country"));
				emp.setCity(res.getString("City"));
				emp.setZipCode(res.getInt("ZipCode"));
				
				return emp;
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}
	
	
	///Joining
	

	public Boolean CreateTable(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> innerJoin() {
		DBConnection ds = new DBConnection();
		Connection con = ds.createConnection();
		Statement st = null;
		ResultSet res = null;
		
		try {
			String qry ="SELECT TOrder.OrderId, TOrder.OrderName,TEmployee.ID, TEmployee.Name" + 
						" FROM TOrder"+ 
						" INNER JOIN TEmployee ON TOrder.EmployeeId=TEmployee.ID ";
			
			
			st = con.createStatement();
			res = st.executeQuery(qry);
			
			List <Employee> empList2 = new ArrayList<Employee>();
			
			while(res.next())
			{
				Employee emp = new Employee();
				emp.setEmployeeId(res.getInt("ID"));
				emp.setName(res.getString("Name"));
				emp.setOrderId(res.getInt("OrderId"));
				emp.setOrderName(res.getString("OrderName"));
				
				
				empList2.add(emp);
				
				
			}
			return empList2;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}

	public List<Employee> leftJoin() {
		DBConnection ds = new DBConnection();
		Connection con = ds.createConnection();
		Statement st = null;
		ResultSet res = null;
		
		try {
			String qry ="SELECT TOrder.OrderId, TOrder.OrderName, TEmployee.ID, TEmployee.Name" + 
					" FROM TEmployee" + 
					" LEFT JOIN TOrder ON TOrder.EmployeeId = TEmployee.ID;";
			
			
			st = con.createStatement();
			res = st.executeQuery(qry);
			
			List <Employee> empList = new ArrayList<Employee>();
			
			while(res.next())
			{
				Employee emp = new Employee();
				emp.setEmployeeId(res.getInt("ID"));
				emp.setName(res.getString("Name"));
				emp.setOrderId(res.getInt("OrderId"));
				emp.setOrderName(res.getString("OrderName"));
				
				
				empList.add(emp);
				
				
			}
			return empList;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}

	public List<Employee> rightJoin() {
		DBConnection ds = new DBConnection();
		Connection con = ds.createConnection();
		Statement st = null;
		ResultSet res = null;
		
		try {
			String qry ="SELECT TOrder.OrderId, TOrder.OrderName, TEmployee.ID, TEmployee.Name" + 
					" FROM TEmployee" + 
					" RIGHT JOIN TOrder ON TOrder.EmployeeId = TEmployee.ID;";
			
			
			st = con.createStatement();
			res = st.executeQuery(qry);
			
			List <Employee> empList = new ArrayList<Employee>();
			
			while(res.next())
			{
				Employee emp = new Employee();
				emp.setEmployeeId(res.getInt("ID"));
				emp.setName(res.getString("Name"));
				emp.setOrderId(res.getInt("orderId"));
				emp.setOrderName(res.getString("OrderName"));
				
				
				empList.add(emp);
				
				
			}
			return empList;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}

	public List<Employee> fullJoin() {
		DBConnection ds = new DBConnection();
		Connection con = ds.createConnection();
		Statement st = null;
		ResultSet res = null;
		
		try {
			String qry ="SELECT TOrder.OrderId, TOrder.orderName, TEmployee.ID, TEmployee.Name" + 
					" FROM TEmployee" + 
					" FULL OUTER JOIN TOrder ON TEmployee.ID = TOrder.EmployeeId;";
			
			
			st = con.createStatement();
			res = st.executeQuery(qry);
			
			List <Employee> empList = new ArrayList<Employee>();
			Employee emp = new Employee();
			while(res.next())
			{
				
				emp.setEmployeeId(res.getInt("ID"));
				emp.setName(res.getString("Name"));
				emp.setOrderId(res.getInt("OrderId"));
				emp.setOrderName(res.getString("OrderName"));
				
				empList.add(emp);
				
				
			}
			
			return empList;
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}
	
	
	
public List<Employee> GroupByQueryCount(String qry) {
		
		
		DBConnection ds = new DBConnection();
		Connection con = ds.createConnection();
		Statement st = null;
		ResultSet res = null;
		
		try {
			
			
			st = con.createStatement();
			res = st.executeQuery(qry);
			
			List <Employee> empList = new ArrayList<Employee>();
			
			while(res.next())
			{
				Employee emp = new Employee();
				emp.setEmployeeId(res.getInt(1));
				emp.setCity(res.getString("City"));
								
				
				empList.add(emp);
				
				
			}
			return empList;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
		
	}
	
	public List<Employee> GroupByQueryMax(String qry) {
		
		
		DBConnection ds = new DBConnection();
		Connection con = ds.createConnection();
		Statement st = null;
		ResultSet res = null;
		
		try {
			
			
			st = con.createStatement();
			res = st.executeQuery(qry);
			
			List <Employee> empList = new ArrayList<Employee>();
			
			while(res.next())
			{
				Employee emp = new Employee();
				emp.setSalary(res.getInt(1));
				emp.setCountry(res.getString("Country"));
				//emp.setName(res.getString("name"));
								
				
				empList.add(emp);
				
				
			}
			return empList;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
		
	}

	public List<Employee> GroupByQuerySum(String qry) {
		Statement st = null;
		ResultSet res = null;
		
		try {
			
			
			st = conn.createStatement();
			res = st.executeQuery(qry);
			
			List <Employee> empList = new ArrayList<Employee>();
			
			while(res.next())
			{
				
				Employee emp = new Employee();
				emp.setZipCode(res.getInt(1));
				
				emp.setCountry(res.getString("country"));				
				
				empList.add(emp);
				
				
			}
			return empList;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}
	

	
	
	
	
	
	
	
	

}
