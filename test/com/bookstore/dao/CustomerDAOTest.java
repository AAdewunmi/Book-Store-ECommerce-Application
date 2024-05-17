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
		customer.setEmail("customer101@gmail.com");
		customer.setFirstname("Josh");
		customer.setLastname("Bailey");
		customer.setCity("Washington");
		customer.setState("Colombia");
		customer.setCountry("United States");
		customer.setAddressLine1("2000 Gates Avenue");
		customer.setAddressLine2("Clifton Park");
		customer.setPassword("billygoat");
		customer.setPhone("18001900");
		customer.setZipcode("100000");
		Customer savedCustomer = customerDAO.create(customer);
		assertTrue(savedCustomer.getCustomerId() > 0);
	}

	@Test
	public void testGet() {
		Integer customerId = 11;
		Customer customer = customerDAO.get(customerId);
		assertNotNull(customer);
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer customer = customerDAO.get(11);
		String firstName = "Jonathan";
		customer.setFirstname(firstName);
		Customer updatedCustomer = customerDAO.update(customer);
		assertTrue(updatedCustomer.getFirstname().equals(firstName));
	}
	
	@Test
	public void testDeleteCustomer() {
		Integer customerId = 11;
		customerDAO.delete(customerId);
		Customer customer = customerDAO.get(customerId);
		assertNull(customer);
	}
	
	@Test
	public void testListAll() {
		List<Customer> listCustomer = customerDAO.listAll();
		for (Customer customer : listCustomer) {
			System.out.println(customer.getFirstname());
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
