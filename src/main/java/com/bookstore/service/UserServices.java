package com.bookstore.service;

import java.util.List;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.IOException;
import java.util.List;

public class UserServices {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private UserDAO userDAO;

	public UserServices() {
		super();
		entityManagerFactory = Persistence.createEntityManagerFactory("Book-Store-ECommerce-Application");
		entityManager = entityManagerFactory.createEntityManager();
		this.userDAO = new UserDAO(entityManager);
	}
	
	public List<Users> listUser() {
		List<Users> listUsers = userDAO.listAll();
		return listUsers;
	}

}
