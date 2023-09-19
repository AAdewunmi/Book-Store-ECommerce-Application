package com.bookstore.controller.admin.book;

import com.bookstore.controller.BaseServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/edit_book")
public class EditBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public EditBookServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
