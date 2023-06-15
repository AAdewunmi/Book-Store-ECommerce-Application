package com.bookstore.controller.admin;

import java.io.IOException;

import com.bookstore.service.UserServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/admin/create_user")
public class CreateUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public CreateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		response.getWriter().println("Email: " + email);
		
		String password = request.getParameter("password");
		response.getWriter().println("Password: " + password);
		
		String fullname = request.getParameter("fullname");
		response.getWriter().println("Fullname: " + fullname);
		
		UserServices userServices = new UserServices();
		userServices.createUser(email, password, fullname);
				
	}

}
