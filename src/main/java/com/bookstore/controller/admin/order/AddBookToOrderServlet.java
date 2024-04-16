package com.bookstore.controller.admin.order;

import java.io.IOException;

import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.OrderDetail;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin/add_book_to_order")
public class AddBookToOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddBookToOrderServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		BookDAO bookDao = new BookDAO();
		Book book = bookDao.get(bookId);
		
		HttpSession session = request.getSession();
		BookOrder order = (BookOrder) session.getAttribute("order");
		
		float subtotal = quantity * book.getPrice();
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setBook(book);
		orderDetail.setQuantity(quantity);
		orderDetail.setSubtotal(subtotal);
		
		float newTotal = order.getTotal() + subtotal;
		order.setTotal(newTotal);
		
		order.getOrderDetails().add(orderDetail);
		
		request.setAttribute("book", book);
		session.setAttribute("NewBookPendingToAddToOrder", true);
		
		String resultPage = "add_book_result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
		dispatcher.forward(request, response);
	}

}
