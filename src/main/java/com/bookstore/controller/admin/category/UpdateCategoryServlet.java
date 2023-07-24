package com.bookstore.controller.admin.category;

import com.bookstore.controller.admin.BaseServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/admin/update_category")
public class UpdateCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    
    public UpdateCategoryServlet() {
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
