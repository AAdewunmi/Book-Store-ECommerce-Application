package com.bookstore.controller.admin.order;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import com.bookstore.entity.BookOrder;
import com.bookstore.entity.OrderDetail;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/admin/remove_book_from_order")
public class RemoveBookFromOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveBookFromOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		BookOrder order = (BookOrder) session.getAttribute("order");

		Set<OrderDetail> orderDetails = order.getOrderDetails();
		Iterator<OrderDetail> iterator = orderDetails.iterator();
		
		while (iterator.hasNext()) {
			OrderDetail orderDetail = iterator.next();
			
			if (orderDetail.getBook().getBookId() == bookId) {
				float newTotal = order.getTotal() - orderDetail.getSubtotal();
				order.setTotal(newTotal);
				iterator.remove();
			}			
		}
		
		String editOrderFormPage = "order_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editOrderFormPage);
		dispatcher.forward(request, response);
	}

}
