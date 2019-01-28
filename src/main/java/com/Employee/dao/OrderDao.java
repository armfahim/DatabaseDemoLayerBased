package com.Employee.dao;

import java.util.List;

import com.Employee.model.Employee;
import com.Employee.model.Order;

public interface OrderDao {
	
	public List<Order> getAllOrder();
	
	public Boolean addOrder(Order ord);
	
	public Employee getOrder(int empId);
	
	public Boolean updateOrder(Order ord);
	
	public Boolean deleteOrder(int orderId);

}
