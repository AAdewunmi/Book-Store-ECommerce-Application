package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
	public void testUpdateBookOrderShippingAddress() {
		int orderId = 5;
		BookOrder order = orderDAO.get(orderId);
		order.setShippingAddress("New Port, Connecticut, USA");
		orderDAO.update(order);
		BookOrder updatedOrder = orderDAO.get(orderId);
		assertEquals(order.getShippingAddress(), updatedOrder.getShippingAddress());
		
	}
	
	@Test
	public void testUpdateBookOrderDetail() {
		Integer orderId = 5;
		BookOrder order = orderDAO.get(orderId);
		
		Iterator<OrderDetail> iterator = order.getOrderDetails().iterator();
		
		while (iterator.hasNext()) {
			OrderDetail orderDetail = iterator.next();
			if (orderDetail.getBook().getBookId() == 4) {
				orderDetail.setQuantity(3);
				orderDetail.setSubtotal(81.99f);
			}
		}
			
		orderDAO.update(order);
		
		BookOrder updatedOrder = orderDAO.get(orderId);
		
		iterator = order.getOrderDetails().iterator();
		
		int expectedQuantity = 3;
		float expectedSubtotal = 81.99f;
		int actualQuantity = 3;
		float actualSubtotal = 81.99f;
		
		while (iterator.hasNext()) {
			OrderDetail orderDetail = iterator.next();
			if (orderDetail.getBook().getBookId() == 5) {
				actualQuantity = orderDetail.getQuantity();
				actualSubtotal = orderDetail.getSubtotal();
			}
		}		
		
		assertEquals(expectedQuantity, actualQuantity);
		assertEquals(expectedSubtotal, actualSubtotal, 0.0f);
		
	}	

	@Test
	public void testGet() {
		Integer orderId = 5;
		BookOrder order = orderDAO.get(orderId);
		assertEquals(1, order.getOrderDetails().size());
	}

	@Test
	public void testDeleteOrder() {
		int orderId = 5;
		orderDAO.delete(orderId);
		BookOrder order = orderDAO.get(orderId);
		assertNull(order);
	}

	@Test
	public void testListAll() {
		List<BookOrder> listOrders = orderDAO.listAll();
		for (BookOrder bookOrder : listOrders) {
			System.out.println(bookOrder.getOrderId() + " - " + bookOrder.getCustomer().getFullname()
					+ " - " + bookOrder.getTotal() + " - " + bookOrder.getStatus());
			for (OrderDetail detail : bookOrder.getOrderDetails()) {
				Book book = detail.getBook();
				int quantity = detail.getQuantity();
				float subtotal = detail.getSubtotal();
				System.out.println("\t" + book.getTitle() + " - " + quantity + " - " + subtotal);
			}
		}
		assertTrue(listOrders.size() > 0);
	}

	@Test
	public void testCount() {
		long totalOrders = orderDAO.count();
		assertEquals(1, totalOrders);
	}
	
	@Test
	public void testListByCustomerNoOrders() {
		Integer customerId = 99;
		List<BookOrder> listOrders = orderDAO.listByCustomer(customerId);
		assertTrue(listOrders.isEmpty());
	}
	
	@Test
	public void testListByCustomerHaveOrders() {
		Integer customerId = 2;
		List<BookOrder> listOrders = orderDAO.listByCustomer(customerId);
		assertTrue(listOrders.size() > 0);
	}	

}
