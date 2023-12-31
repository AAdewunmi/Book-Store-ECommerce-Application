package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;

public class ReviewDAOTest {
	
	private static ReviewDAO reviewDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reviewDAO = new ReviewDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		reviewDAO.close();
	}

	@Test
	public void testCreateReview() {
		Review review = new Review();
		Book book = new Book();
		book.setBookId(2);
		Customer customer = new Customer();
		customer.setCustomerId(2);
		review.setBook(book);
		review.setCustomer(customer);
		review.setHeadline("This is a very good book");
		review.setRating(5);
		review.setComment("I have just read this book. Very good.");
		Review saveReview = reviewDAO.create(review);
		assertTrue(saveReview.getReviewId() > 0);
	}

	@Test
	public void testUpdateReview() {
		Integer reviewId = 1;
		Review review = reviewDAO.get(reviewId);
		review.setHeadline("Excellent book");
		Review updatedReview = reviewDAO.update(review);
		assertEquals(review.getHeadline(), updatedReview.getHeadline());
	}

	@Test
	public void testGet() {
		Integer reviewId = 1;
		Review review = reviewDAO.get(reviewId);
		assertNotNull(review);
	}

	@Test
	public void testDeleteObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testListAll() {
		List<Review> listReview = reviewDAO.listAll();
		
		for (Review review : listReview) { 
		  System.out.println(review.getReviewId() + " - " + 
		  review.getBook().getTitle() + " - " +		
		  review.getCustomer().getFullname() + " - " + 
		  review.getHeadline() + " - " +
		  review.getRating()); }
		 
		assertTrue(listReview.size() > 0);
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

}
