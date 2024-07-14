package com.bookstore.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bookstore.controller.frontend.shoppingcart.ShoppingCart;
import com.bookstore.dao.OrderDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		listAllOrder(null);
	}

	public void listAllOrder(String message) throws ServletException, IOException {
		List<BookOrder> listOrder = orderDAO.listAll();
		request.setAttribute("listOrder", listOrder);
		CommonUtility.forwardToPage("order_list.jsp", message, request, response);
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

	public void showCheckoutForm() throws ServletException, IOException {
		HttpSession session = request.getSession();
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
		
		float tax = shoppingCart.getTotalAmount() * 0.1f;
		float shippingFee = shoppingCart.getTotalQuantity() * 1.0f;
		float total = shoppingCart.getTotalAmount() + tax + shippingFee;
		
		
		session.setAttribute("tax", tax);
		session.setAttribute("shippingFee", shippingFee);
		session.setAttribute("total", total);
		
		CommonUtility.generateCountyList(request);
		
		String checkOutPage = "frontend/checkout.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(checkOutPage);
		dispatcher.forward(request, response);
	}

	public void placeOrder() throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		String paymentMethod = request.getParameter("paymentMethod");
		
		BookOrder order = new BookOrder();
		order.setFirstname(firstname);
		order.setLastname(lastname);
		order.setPhone(phone);
		order.setAddressLine1(address1);
		order.setAddressLine2(address2);
		order.setCity(city);
		order.setState(state);
		order.setZipcode(zipcode);
		order.setCountry(country);
		order.setPaymentMethod(paymentMethod);
		
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		order.setCustomer(customer);
		
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
		Map<Book, Integer> items = shoppingCart.getItems();
		
		Iterator<Book> iterator = items.keySet().iterator();
		
		Set<OrderDetail> orderDetails = new HashSet<>();
		
		while (iterator.hasNext()) {
			Book book = iterator.next();
			Integer quantity = items.get(book);
			float subtotal = quantity * book.getPrice();
			
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setBook(book);
			orderDetail.setBookOrder(order);
			orderDetail.setQuantity(quantity);
			orderDetail.setSubtotal(subtotal);
			
			orderDetails.add(orderDetail);
		}
		
		order.setOrderDetails(orderDetails);
		float tax = (Float) session.getAttribute("tax");
		float shippingFee = (Float) session.getAttribute("shippingFee");
		float total = (Float) session.getAttribute("total");
		
		order.setSubtotal(shoppingCart.getTotalAmount());
		order.setTax(tax);
		order.setShipping_fee(shippingFee);
		order.setTotal(total);
		
		orderDAO.create(order);
		shoppingCart.clear();
		String message = "Thank you. Your order has been received. "
				+ " We will deliver your books within a few days.";
		CommonUtility.showMessageFrontend(message, request, response);
		
	}

	public void listOrderByCustomer() throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		List<BookOrder> listOrders = orderDAO.listByCustomer(customer.getCustomerId());
		request.setAttribute("listOrders", listOrders);
		CommonUtility.forwardToPage("frontend/order_list.jsp", request, response);
	}

	public void showOrderDetailForCustomer() throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		BookOrder order = orderDAO.get(orderId, customer.getCustomerId());
		//BookOrder order = orderDAO.get(orderId);
		request.setAttribute("order", order);
		CommonUtility.forwardToPage("frontend/order_detail.jsp", request, response);
	}

	public void showEditOrderForm() throws ServletException, IOException {
		Integer orderId = Integer.parseInt(request.getParameter("id"));		
		BookOrder order = orderDAO.get(orderId);
		
		if (order == null) {
			String message = "Could not find order with ID " + orderId;
			CommonUtility.showMessageBackend(message, request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		Object isPendingBook = session.getAttribute("NewBookPendingToAddToOrder");
		CommonUtility.generateCountyList(request);
		if (isPendingBook == null) {			
			session.setAttribute("order", order);
		} else {
			session.removeAttribute("NewBookPendingToAddToOrder");
		}
		CommonUtility.forwardToPage("order_form.jsp", request, response);
	}

	public void updateOrder() throws ServletException, IOException {
		HttpSession session = request.getSession();
		BookOrder order = (BookOrder) session.getAttribute("order");
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String zipcode = request.getParameter("zipcode");
		String paymentMethod = request.getParameter("paymentMethod");
		String orderStatus = request.getParameter("orderStatus");
		
		float shippingFee = Float.parseFloat(request.getParameter("shippingFee"));
		float tax = Float.parseFloat(request.getParameter("tax"));
		
		order.setFirstname(firstname);
		order.setPhone(phone);
		order.setAddressLine1(address1);
		order.setAddressLine2(address2);
		order.setCity(city);
		order.setState(state);
		order.setZipcode(zipcode);
		order.setCountry(country);
		order.setShipping_fee(shippingFee);
		order.setTax(tax);
		order.setPaymentMethod(paymentMethod);
		order.setStatus(orderStatus);
		
		String[] arrayBookId = request.getParameterValues("bookId");
		String[] arrayPrice = request.getParameterValues("price");
		String[] arrayQuantity = new String[arrayBookId.length];
		
		for (int i = 1; i <= arrayQuantity.length; i++) {
			arrayQuantity[i - 1] = request.getParameter("quantity" + i);
		}
		
		Set<OrderDetail> orderDetails = order.getOrderDetails();
		orderDetails.clear();
		float totalAmount = 0.0f;
		
		for (int i = 0; i < arrayBookId.length; i++) {
			int bookId = Integer.parseInt(arrayBookId[i]);
			int quantity = Integer.parseInt(arrayQuantity[i]);
			float price = Float.parseFloat(arrayPrice[i]);
			float subtotal = price * quantity;
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setBook(new Book(bookId));
			orderDetail.setQuantity(quantity);
			orderDetail.setSubtotal(subtotal);
			orderDetail.setBookOrder(order);
			orderDetails.add(orderDetail);
			totalAmount += subtotal;
		}
		
		order.setSubtotal(totalAmount);
		totalAmount += shippingFee;
		totalAmount += tax;
		order.setTotal(totalAmount);
		orderDAO.update(order);
		String message = "The order " + order.getOrderId() + " has been updated successfully";
		listAllOrder(message);
		
	}

	public void deleteOrder() throws ServletException, IOException{
		Integer orderId = Integer.parseInt(request.getParameter("id"));
		BookOrder order = orderDAO.get(orderId);
		if (order != null) {		
			orderDAO.delete(orderId);
			String message = "The order ID " + orderId + " has been deleted.";
			listAllOrder(message);
		} else {
			String message = "Could not find order with ID " + orderId +
					", or it might have been deleted by another admin.";
			CommonUtility.showMessageBackend(message, request, response);
		}
	}

}
