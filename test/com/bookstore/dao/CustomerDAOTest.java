package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Customer;

public class CustomerDAOTest {
	
	private static CustomerDAO customerDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customerDAO = new CustomerDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		customerDAO.close();
	}

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setEmail("tom@gmail.com");
		customer.setFullname("Tom Hilfiger");
		customer.setCity("New York");
		customer.setCountry("United States");
		customer.setAddress("100 North Avenue");
		customer.setPassword("secret");
		customer.setPhone("18001900");
		customer.setZipcode("100000");
		Customer savedCustomer = customerDAO.create(customer);
		assertTrue(savedCustomer.getCustomerId() > 0);
	}

	@Test
	public void testGet() {
		Integer customerId = 1;
		Customer customer = customerDAO.get(customerId);
		assertNotNull(customer);
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer customer = customerDAO.get(1);
		String fullName = "Tommy Hilfiger";
		customer.setFullname(fullName);
		Customer updatedCustomer = customerDAO.update(customer);
		assertTrue(updatedCustomer.getFullname().equals(fullName));
	}
	
	@Test
	public void testDeleteCustomer() {
		Integer customerId = 2;
		customerDAO.delete(customerId);
		Customer customer = customerDAO.get(1);
		assertNull(customer);
	}
	
	@Test
	public void testListAll() {
		List<Customer> listCustomer = customerDAO.listAll();
		for (Customer customer : listCustomer) {
			System.out.println(customer.getFullname());
		}
		assertFalse(listCustomer.isEmpty());
	}
	
	@Test
	public void testCount() {
		long totalCustomer = customerDAO.count();
		assertEquals(1, totalCustomer);
	}
	
	@Test
	public void testFindByEmail() {
		String email = "tom@gmail.com";
		Customer customer = customerDAO.findByEmail(email);
		assertNotNull(customer);
	}

}
