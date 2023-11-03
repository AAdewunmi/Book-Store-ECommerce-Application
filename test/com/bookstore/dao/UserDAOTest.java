package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;

public class UserDAOTest {
	
	private static UserDAO userDAO;

	@BeforeClass
	public static void setUpClass() throws Exception {
		userDAO = new UserDAO();
	}

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("nigel.farage@brexit.uk");
		user1.setFullName("Niger Farage");
		user1.setPassword("politicspolitics");
		user1 = userDAO.create(user1);
		assertTrue(user1.getUserId() > 0);
	}

	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		Users user1 = new Users();
		user1 = userDAO.create(user1);
	}
	
	@Test
	public void testUpdateUsers() {
		Users user = new Users();
		user.setUserId(1);
		user.setEmail("drade@google.com");
		user.setFullName("Dr. Ade Adewunmi");
		user.setPassword("okokobioko");
		
		user = userDAO.update(user);
		String expectedString = "okokobioko";
		String actualString = user.getPassword();
		assertEquals(expectedString, actualString);
	}
	
	@Test
	public void testGetUsersFound() {
		Integer userId = 1;
		Users user = userDAO.get(userId);
		if (user != null) {
			System.out.println(user.getEmail());
		}
		assertNotNull(user);
	}
	
	@Test
	public void testGetUsersNotFound() {
		Integer userId = 99;
		Users user = userDAO.get(userId);
		assertNull(user);
	}
	
	@Test
	public void testDeleteUsers() {
		Integer userId = 7;
		userDAO.delete(userId);
		Users user = userDAO.get(userId);
		assertNull(user);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistUsers() {
		Integer userId = 55;
		userDAO.delete(userId);
	}
	
	@Test
	public void testListAll() {
		List<Users> listUsers = userDAO.listAll();
		for (Users users : listUsers) {
			System.out.println(users.getEmail());
		}
		assertTrue(listUsers.size() > 0);
	}
	
	@Test
	public void testCount() {
		long totalUsers = userDAO.count();
		assertTrue(totalUsers > 0);
	}
	
	@Test
	public void testFindByEmail() {
		String email = "elon.musk@tesla.com";
		Users users = userDAO.findByEmail(email);
		assertNotNull(users);
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email = "sergio.brin@google.com";
		String password = "goog";
		boolean loginResult = userDAO.checkLogin(email, password);
		assertTrue(loginResult);
	}
	
	@Test
	public void testCheckLoginFailed() {
		String email = "nam123";
		String password = "mysecret1";
		boolean loginResult = userDAO.checkLogin(email, password);
		assertFalse(loginResult);
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
		userDAO.close();
	}

}
