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
		
		
		UserServices userServices = new UserServices();
		userServices.createUser(request, response);
		userServices.listUser(request, response);		
	}

}
