package com.bookstore.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

import jakarta.persistence.EntityNotFoundException;

public class BookDAOTest extends BaseDAOTest{
	private static BookDAO bookDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		bookDAO = new BookDAO(entityManager);
	}
	
	@Test
	public void testUpdateBook() throws ParseException, IOException {
		Book existBook=new Book();
		existBook.setBookId(1);
		Category category=new Category("Spring Boot Java");
		category.setCategoryId(1);
		existBook.setCategory(category);
		existBook.setTitle("Effective Java (3rd Edition)");
		existBook.setAuthor("Joshua Bloch");
		existBook.setDescription("New coverage of generics, enums, annotations, autoboxing");
		existBook.setPrice(40f);
		existBook.setIsbn("0321356683");
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate=dateFormat.parse("05/28/2008");
		existBook.setPublishDate(publishDate);
		String imagePath="/Users/adrianadewunmi/Downloads/books/Effective Java.jpg";
		byte[] imageBytes=Files.readAllBytes(Paths.get(imagePath));
		existBook.setImage(imageBytes);
		Book updatedBook =bookDAO.update(existBook);
		assertEquals(updatedBook.getTitle(), "Effective Java (3rd Edition)");	
	}

	@Test
	public void testCreateBook() throws ParseException, IOException {
		Book book=new Book();
		Category category=new Category("Core Java");
		category.setCategoryId(9);
		book.setCategory(category);
		book.setTitle("Effective Java (2nd Edition)");
		book.setAuthor("Joshua Bloch");
		book.setDescription("New coverage of generics, enums, annotations, autoboxing");
		book.setPrice(38.87f);
		book.setIsbn("0321356683");
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate=dateFormat.parse("05/28/2008");
		book.setPublishDate(publishDate);
		String imagePath="/Users/adrianadewunmi/Downloads/books/Effective Java.jpg";
		byte[] imageBytes=Files.readAllBytes(Paths.get(imagePath));
		book.setImage(imageBytes);
		Book createdBook =bookDAO.create(book);
		assertTrue(createdBook.getBookId()>0);	
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteBookFail() {
		Integer bookId = 100;
		bookDAO.delete(bookId);
	}
	
	@Test
	public void testGetBookFail() {
		Integer bookId = 99;
		Book book = bookDAO.get(bookId);
		assertNull(book);
	}
	
	@Test
	public void testDeleteBookSuccess() {
		Integer bookId = 1;
		bookDAO.delete(bookId);
		assertTrue(true);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

}
