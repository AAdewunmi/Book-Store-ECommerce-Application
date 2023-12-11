package com.bookstore.controller.admin.customer;

import java.io.IOException;

import com.bookstore.service.CustomerServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/admin/delete_customer")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteCustomerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServices customerServices = new CustomerServices(request, response);
		customerServices.deleteCustomer();
	}

}
