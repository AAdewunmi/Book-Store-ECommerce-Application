package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;
import com.bookstore.entity.OrderDetailId;

public class OrderDAOTest {
	
	private static OrderDAO orderDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		orderDAO = new OrderDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		orderDAO.close();
	}

	@Test
	public void testCreateBookOrder() {
		
		  BookOrder order = new BookOrder(); 
		  Customer customer = new Customer();
		  customer.setCustomerId(2);
		  
		  order.setCustomer(customer); 
		  order.setPaymentMethod("Debit Card");
		  order.setRecipientName("Tommy Hilfiger");
		  order.setRecipientPhone("18001900");
		  order.setShippingAddress("300 Zjinwan Avenue, Changai, China");
		  
		  Set<OrderDetail> orderDetails = new HashSet<>(); 
		  OrderDetail orderDetail = new OrderDetail();
		  
		  Book book = new Book(4); 
		  orderDetail.setBook(book);
		  orderDetail.setQuantity(1); 
		  orderDetail.setSubtotal(24.33f);
		  orderDetail.setBookOrder(order); 
		  orderDetails.add(orderDetail);
		  order.setOrderDetails(orderDetails); 
		  orderDAO.create(order);
		  assertTrue(order.getOrderId() > 0);
		 
	}

	@Test
	public void testUpdateBookOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testListAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

}
