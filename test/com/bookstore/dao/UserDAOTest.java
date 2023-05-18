package com.bookstore.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bookstore.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAOTest {

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("james.dyson@dyson.com");
		user1.setFullName("Jame Dyson");
		user1.setPassword("vacuumvacuum");
		
		EntityManagerFactory entityManagerFactory = 
		Persistence.createEntityManagerFactory("Book-Store-ECommerce-Application");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		UserDAO userDAO = new UserDAO(entityManager);
		user1 = userDAO.create(user1);
		
		entityManager.close();
		entityManagerFactory.close();
		
		assertTrue(user1.getUserId() > 0);
	}

}
