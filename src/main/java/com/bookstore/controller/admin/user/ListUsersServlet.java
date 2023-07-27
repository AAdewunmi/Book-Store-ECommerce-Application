package com.bookstore.controller.admin.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.UserServices;

@WebServlet("/admin/list_users")
public class ListUsersServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;  
    
	public ListUsersServlet() {
        super();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServices userServices = new UserServices(entityManager,
				request, response);
		userServices.listUser();	
	}


}
