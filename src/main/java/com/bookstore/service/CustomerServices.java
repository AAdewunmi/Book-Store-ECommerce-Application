package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import com.bookstore.dao.CustomerDAO;
import com.bookstore.entity.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomerServices {
	private CustomerDAO customerDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CustomerServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.customerDAO = new CustomerDAO();
	}
	
	public void listCustomers(String message) throws ServletException, IOException {
		//CustomerDAO customerDAO = new CustomerDAO();
		List<Customer> listCustomer = customerDAO.listAll();
		if (message != null) {
			request.setAttribute("message", message);
		}
		request.setAttribute("listCustomer", listCustomer);
		String listPage = "customer_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
	
	public void listCustomers() throws ServletException, IOException {
		listCustomers(null);
	}
	
	public void createCustomer() {
		String email = request.getParameter("email");
		
	}

}
