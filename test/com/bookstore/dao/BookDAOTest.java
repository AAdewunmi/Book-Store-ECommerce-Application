package com.bookstore.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

import jakarta.persistence.EntityNotFoundException;

public class BookDAOTest {
	private static BookDAO bookDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookDAO = new BookDAO();
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
	
	@Test
	public void testCreateSecondBook() throws ParseException, IOException {
		Book book=new Book();
		Category category=new Category("Core Java");
		category.setCategoryId(9);
		book.setCategory(category);
		book.setTitle("Java 8 in Action");
		book.setAuthor("Alan Mycroft");
		book.setDescription("Java 8 in Action is a clearly written guide to the new features of Java 8");
		book.setPrice(36.72f);
		book.setIsbn("1617291994");
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate=dateFormat.parse("08/28/2014");
		book.setPublishDate(publishDate);
		String imagePath="/Users/adrianadewunmi/Downloads/books/Java 8 in Action.jpg";
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
	public void testGetBookSuccess() {
		Integer bookId = 1;
		Book book = bookDAO.get(bookId);
		assertNotNull(book);
	}
	
	@Test
	public void testDeleteBookSuccess() {
		Integer bookId = 1;
		bookDAO.delete(bookId);
		assertTrue(true);
	}
	
	@Test
	public void testSearchBookByTitle() {
		String keyword = "Java";
		List<Book> result = bookDAO.search(keyword);
		for (Book book : result) {
			System.out.println(book.getTitle());
		}
		assertEquals(4, result.size());
	}
	
	@Test
	public void testSearchBookByAuthor() {
		String keyword = "Kathy";
		List<Book> result = bookDAO.search(keyword);
		for (Book book : result) {
			System.out.println(book.getAuthor());
		}
		assertEquals(1, result.size());
	}
	
	@Test
	public void testSearchBookByDescription() {
		String keyword = "Java";
		List<Book> result = bookDAO.search(keyword);
		for (Book book : result) {
			System.out.println(book.getDescription());
		}
		assertEquals(4, result.size());
	}
	
	@Test
	public void testListAll() {
		List<Book> listBooks = bookDAO.listAll();
		for (Book book : listBooks) {
			System.out.println(book.getTitle() + " - " + book.getAuthor());
		}
		assertFalse(listBooks.isEmpty());
	}
	
	@Test
	public void testFindByTitleNotExist() {
		String title = "Thinking in Java";
		Book book = bookDAO.findByTitle(title);
		assertNotNull(book);
	}
	
	@Test
	public void testFindByTitleExist() {
		String title = "Effective Java (2nd Edition)";
		Book book = bookDAO.findByTitle(title);
		System.out.println(book.getAuthor());
		System.out.println(book.getPrice());
		assertNotNull(book);
	}
	
	@Test
	public void testCount() {
		long totalBooks = bookDAO.count();
		assertEquals(2, totalBooks);
	}
	
	@Test
	public void testListByCategory() {
		int categoryId = 1;
		List<Book> listBooks = bookDAO.listByCategory(categoryId);
		assertTrue(listBooks.size() > 0);
	}
	
	@Test
	public void testListNewBooks() {
		List<Book> listNewBooks = bookDAO.listNewBooks();
		for (Book book : listNewBooks) {
			System.out.println(book.getTitle() + " - " + book.getPublishDate());
		}
		assertEquals(4, listNewBooks.size());
	}
	
	@Test
	public void testCountByCategory() {
		int categoryId = 1;
		long numOfBooks = bookDAO.countByCategory(categoryId);
		assertTrue(numOfBooks == 1);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bookDAO.close();
	}

}
