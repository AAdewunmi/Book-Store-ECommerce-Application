package com.bookstore.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class BookServices {
	
	private EntityManager entityManager;
	private BookDAO bookDAO;
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public BookServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		bookDAO = new BookDAO(entityManager);
		categoryDAO = new CategoryDAO(entityManager);
	}

	public void listBooks() throws ServletException, IOException {
		listBooks(null);
	}
	
	public void listBooks(String message) throws ServletException, IOException {
		List<Book> listBooks = bookDAO.listAll();
		request.setAttribute("listBooks", listBooks);
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		
		String listPage = "book_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
	
	public void showBookNewForm() throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();
		request.setAttribute("listCategory", listCategory);
		String newPage = "book_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(newPage);
		requestDispatcher.forward(request, response);
	}

	public void createBook() throws  ServletException, IOException{
		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		
		Book existBook = bookDAO.findByTitle(title);
		if (existBook != null) {
			String message = "Could not create new book because the title "
					+ title + " already exists.";
			listBooks(message);
			return;
		}
		
		String author = request.getParameter("author");
		String description = request.getParameter("description");
		String isbn = request.getParameter("isbn"); 
		float price = Float.parseFloat(request.getParameter("price"));
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = null;
		try {
			publishDate = dateFormat.parse(request.getParameter("publishDate"));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ServletException("Error parsing publish date (format is MM/dd/yyyy)");
		}
		System.out.println("Category ID: " + categoryId);
		System.out.println("Title : " + title);
		System.out.println("Author : " + author);
		System.out.println("Description : " + description);
		System.out.println("ISBN : " + isbn);
		System.out.println("Price : " + price);
		System.out.println("Publication Date : " + publishDate);
		
		Book newBook = new Book();
		newBook.setTitle(title);
		newBook.setAuthor(author);
		newBook.setDescription(description);
		newBook.setIsbn(isbn);
		newBook.setPublishDate(publishDate);
		Category category = categoryDAO.get(categoryId);
		newBook.setCategory(category);
		newBook.setPrice(price);
		
		Part part = request.getPart("bookImage");
		if (part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageBytes = new byte[(int) size];
			
			InputStream inputStream = part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			
			newBook.setImage(imageBytes);
		}
		
		Book createdBook = bookDAO.create(newBook);
		
		if (createdBook.getBookId() > 0) {
			String message = "A new book has been created successfully.";
			request.setAttribute("message", message);
			listBooks(message);
		}
	}

	public void editBook() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		Book book = bookDAO.get(bookId);
		List<Category> listCategory = categoryDAO.listAll();
		request.setAttribute("book", book);
		request.setAttribute("listCategory", listCategory);
		String editPage = "book_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

}
