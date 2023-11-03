package com.bookstore.controller.admin.book;

import com.bookstore.service.BookServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/update_book")
@MultipartConfig(
		fileSizeThreshold = 1024*10, //10 KB
		maxFileSize = 1024*300,   	//300 KB
		maxRequestSize = 1024*1024 	//1 MB
		)
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateBookServlet() {
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookServices bookServices = new BookServices(request, response);
		bookServices.updateBook();
	}

}
