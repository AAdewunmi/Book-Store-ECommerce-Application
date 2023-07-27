package com.bookstore.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;
	
	@Override
	public void init() throws ServletException {
		entityManagerFactory = Persistence.createEntityManagerFactory("Book-Store-ECommerce-Application");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@Override
	public void destroy() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
