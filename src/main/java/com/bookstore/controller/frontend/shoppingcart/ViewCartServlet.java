package com.bookstore.controller.frontend.shoppingcart;

import java.io.IOException;

import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/view_cart")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object cartObject = request.getSession().getAttribute("cart");
		if (cartObject == null) {
			ShoppingCart shoppingCart = new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingCart);
			BookDAO bookDAO = new BookDAO();
			Book book1 = bookDAO.get(2);
			Book book2 = bookDAO.get(3);
			Book book3 = bookDAO.get(4);
			shoppingCart.addItem(book1);
			shoppingCart.addItem(book2);
			shoppingCart.addItem(book3);
			shoppingCart.addItem(book3);
		}
		
		String cartPage = "frontend/shopping_cart.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(cartPage);
		dispatcher.forward(request, response);
	}

}
