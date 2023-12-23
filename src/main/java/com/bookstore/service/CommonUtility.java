package com.bookstore.service;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CommonUtility {
	
	public static void forwardToPage(String page, String message,
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.setAttribute("message", message);
		request.getRequestDispatcher(page).forward(request, response);		
	}
	
	public static void showMessageFrontend(String message, 
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		forwardToPage("frontend/message.jsp", message, request, response);
	}
	
	public static void showMessageBackend(String message, 
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		forwardToPage("message.jsp", message, request, response);
	}

	public static void forwardToPage(String page,
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.getRequestDispatcher(page).forward(request, response);		
	}	

}
