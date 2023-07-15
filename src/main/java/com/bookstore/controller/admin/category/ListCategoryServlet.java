package com.bookstore.controller.admin.category;

import java.io.IOException;

import com.bookstore.controller.admin.BaseServlet;
import com.bookstore.service.CategoryServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/admin/list_category")
public class ListCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListCategoryServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("List Category");
		CategoryServices categoryServices = new CategoryServices(entityManager, request, response);
		categoryServices.listCategory();
	}

}
