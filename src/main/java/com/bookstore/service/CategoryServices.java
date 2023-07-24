package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CategoryServices {
	private EntityManager entityManager;
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CategoryServices(EntityManager entityManager,
			HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		categoryDAO = new CategoryDAO(entityManager);
	}

	public void listCategory(String message) throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();
		request.setAttribute("listCategory", listCategory);
		if (message != null) {
			request.setAttribute("message", message);
		}
		String listPage = "category_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
	
	public void listCategory() throws ServletException, IOException {
		listCategory(null);
	}
	
	public void createCategory() throws ServletException, IOException {
		String name = request.getParameter("name");
		Category existCategory = categoryDAO.findByName(name);
		if (existCategory != null) {
			String message = "Could not create category. "
				+ "A category with name " + name + " already exists!";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		} else {
			Category newCategory = new Category(name);
			categoryDAO.create(newCategory);
			String messageString = "New category created successfully!";
			listCategory(messageString);
		}
		
	}
	
	public void editCategory() throws ServletException, IOException {
		Integer categoryId=Integer.parseInt(request.getParameter("id"));
		Category category=categoryDAO.get(categoryId);
		String editPage="category_form.jsp";
		if(category==null) {
			editPage="message.jsp";
			String errorMessage="Could not find a category with id:"+categoryId;
			request.setAttribute("message", errorMessage);
		}else {
			request.setAttribute("category", category);
		}
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	public void updateCategory() throws ServletException, IOException {
		Integer categoryId=Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("name");
		Category categoryById = categoryDAO.get(categoryId);
		Category categoryByName = categoryDAO.findByName(categoryName);
		if ((categoryByName != null) && (categoryById.getCategoryId() != categoryByName.getCategoryId())) {
			String message = "Could not update category. " + " A category with name " + categoryName + " already exists!.";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		}else {
			categoryById.setName(categoryName);
			categoryDAO.update(categoryById);
			String message = "Category has been updated successfully.";
			listCategory(message);
		}
	}

}
