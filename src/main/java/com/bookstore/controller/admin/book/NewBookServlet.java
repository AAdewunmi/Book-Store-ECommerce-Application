package com.bookstore.controller.admin.book;

import com.bookstore.service.BookServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/admin/new_book")
public class NewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewBookServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookServices bookServices = new BookServices(request, response);
		bookServices.showBookNewForm();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
