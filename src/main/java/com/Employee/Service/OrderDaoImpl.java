package com.Employee.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Employee.dao.OrderDao;
import com.Employee.dbUtil.DBConnection;
import com.Employee.model.Employee;
import com.Employee.model.Order;


public class OrderDaoImpl implements OrderDao {

	public List<Order> getAllOrder() {
		DBConnection ds = new DBConnection();
		Connection con = ds.createConnection();
		Statement st = null;
		ResultSet res = null;
		
		try {
			String qry = "SELECT * FROM TOrder";
			st = con.createStatement();
			res = st.executeQuery(qry);
			Order or = new Order();
			List <Order> orList = new ArrayList<Order>();
			
			while(res.next())
			{
				or.setOrderId(res.getInt("OrderId"));
				or.setEmployeeId(res.getInt("EmployeeId"));
				or.setOrderName(res.getString("orderName"));
				
				
				orList.add(or);
				
				
			}
			return orList;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	public Boolean addOrder(Order ord) {
		Connection con = null;

		Statement st = null;

		String insert = "insert into TOrder values('"+ord.getOrderId()+"', '"+ord.getOrderName()+"', '"+ord.getEmployeeId()+"')";

		try

		{

		DBConnection dc = new DBConnection();

		con = dc.createConnection();

		st = con.createStatement();

		st.execute(insert);

		System.out.println("Inserted into Order");
		return true;

		}

		catch(Exception e)

		{

		System.out.println(e);

		}
		return null;
	}

	public Employee getOrder(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean updateOrder(Order ord) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
