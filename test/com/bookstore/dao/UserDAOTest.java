package com.bookstore.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class UserDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;

	@BeforeClass
	public static void setUpClass() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("Book-Store-ECommerce-Application");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
	}

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("mike.bloomberg@bloomberg.com");
		user1.setFullName("Mike Bloomberg");
		user1.setPassword("moneymoneymoney");
		user1 = userDAO.create(user1);
		assertTrue(user1.getUserId() > 0);
	}

	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		Users user1 = new Users();
		user1 = userDAO.create(user1);
	}
	
	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
