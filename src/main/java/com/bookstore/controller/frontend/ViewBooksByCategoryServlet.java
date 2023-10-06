package com.bookstore.controller.frontend;

import com.bookstore.controller.BaseServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/view_category")
public class ViewBooksByCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public ViewBooksByCategoryServlet() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("List Books By Category - Served at: ").append(request.getContextPath());
	}

}
