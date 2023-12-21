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
		customer.setEmail("bill@gates.com");
		customer.setFullname("Bill Gates");
		customer.setCity("Washington");
		customer.setCountry("United States");
		customer.setAddress("2000 Gates Avenue");
		customer.setPassword("milinda");
		customer.setPhone("18001900");
		customer.setZipcode("100000");
		Customer savedCustomer = customerDAO.create(customer);
		assertTrue(savedCustomer.getCustomerId() > 0);
	}

	@Test
	public void testGet() {
		Integer customerId = 9;
		Customer customer = customerDAO.get(customerId);
		assertNotNull(customer);
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer customer = customerDAO.get(5);
		String fullName = "Koboko Dey Teach";
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
		assertEquals(7, totalCustomer);
	}
	
	@Test
	public void testFindByEmail() {
		String email = "tommy@gmail.com";
		Customer customer = customerDAO.findByEmail(email);
		assertNotNull(customer);
	}
	
	@Test
	public void testCheckLogInSuccess() {
		String email = "tommy@gmail.com";
		String password = "secret";
		Customer customer = customerDAO.checkLogin(email, password);
		assertNotNull(customer);
	}
	
	@Test
	public void testCheckLogInFail() {
		String email = "abc@gmail.com";
		String password = "secret";
		Customer customer = customerDAO.checkLogin(email, password);
		assertNull(customer);
	}

}
