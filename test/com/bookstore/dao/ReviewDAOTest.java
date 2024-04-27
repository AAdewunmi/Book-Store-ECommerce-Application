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
		customer.setCustomerId(5);
		review.setBook(book);
		review.setCustomer(customer);
		review.setHeadline("This book is good");
		review.setRating(5);
		review.setComment("I have just read this book. Like it!");
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
	public void testDeleteReview() {
		Integer reviewId=2;
		reviewDAO.delete(reviewId);
		Review review=reviewDAO.get(reviewId);
		assertNull(review);
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
		long totalReviews = reviewDAO.count();
		System.out.println("Total Reviews: " + totalReviews);
		assertTrue(totalReviews > 0);
	}
	
	@Test
	public void testfindByCustomerAndBookNotFound() {
		Integer customerIdInteger = 100;
		Integer bookId = 99;
		Review resultReview = reviewDAO.findByCustomerAndBook(customerIdInteger, bookId);
		assertNull(resultReview);
	}
	
	@Test
	public void testfindByCustomerAndBookFound() {
		Integer customerIdInteger = 10;
		Integer bookId = 2;
		Review resultReview = reviewDAO.findByCustomerAndBook(customerIdInteger, bookId);
		assertNotNull(resultReview);
	}
	
	@Test
	public void testListMostRecent() {
		List<Review> recentReviews = reviewDAO.listMostRecent();
		assertEquals(3, recentReviews.size());
	}

}
