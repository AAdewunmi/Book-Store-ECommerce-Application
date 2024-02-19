package com.bookstore.controller.frontend.shoppingcart;

import java.io.IOException;

import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/remove_from_cart")
public class RemoveBookFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveBookFromCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("book_id"));
		Object cartObject = request.getSession().getAttribute("cart");
		ShoppingCart shoppingCart = (ShoppingCart) cartObject;
		shoppingCart.removeItem(new Book(bookId));
		String cartPage = request.getContextPath().concat("/view_cart");
		response.sendRedirect(cartPage);
	}

}
