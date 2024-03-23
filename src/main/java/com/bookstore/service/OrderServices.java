package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import com.bookstore.dao.OrderDAO;
import com.bookstore.entity.BookOrder;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderServices {
	private OrderDAO orderDAO;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public OrderServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.orderDAO = new OrderDAO();
	}

	public void listAllOrder() throws ServletException, IOException {
		List<BookOrder> listOrder = orderDAO.listAll();
		request.setAttribute("listOrder", listOrder);
		String listPage = "order_list.jsp"; 
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}

	public void viewOrderDetailsForAdmin() throws ServletException, IOException {
		/*
		 * int orderId = Integer.parseInt(request.getParameter("id")); BookOrder order =
		 * orderDAO.get(orderId); request.setAttribute("order", order); String
		 * detailPage = "order_detail.jsp"; RequestDispatcher dispatcher =
		 * request.getRequestDispatcher(detailPage); dispatcher.forward(request,
		 * response);
		 */
		int orderId = Integer.parseInt(request.getParameter("id"));
		BookOrder order = orderDAO.get(orderId);
		if (order != null) {
			request.setAttribute("order", order);
			CommonUtility.forwardToPage("order_detail.jsp", request, response);
		} else {
			String message = "Could not find order with ID " + orderId;
			CommonUtility.showMessageBackend(message, request, response);
		}
	}

}
