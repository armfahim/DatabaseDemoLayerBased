package com.Employee.Service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.Employee.dao.OrderDao;
import com.Employee.model.Order;

public class OrderDaoImplTest {
	
	Order or = new Order();

	OrderDao ordao = new OrderDaoImpl();

	@Test
	public void testGetAllOrder() {
		List<Order> oList = new ArrayList<Order>();
		oList = ordao.getAllOrder();
		
		assertEquals(oList.size(), 2);
	}

	@Test
	public void testAddOrder() {
		or.setOrderId(12);
		or.setOrderName("sad");
		or.setEmployeeId(1);
		

		assertTrue(ordao.addOrder(or));
	}

	@Test
	public void testGetOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateOrder() {
		or.setOrderName("Happy");
		or.setOrderId(4566);

		assertTrue(ordao.updateOrder(or));
	}

	@Test
	public void testDeleteOrder() {
		assertTrue(ordao.deleteOrder(4566));
	}

}
