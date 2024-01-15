package com.bookstore.entity;
import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class BookRatingTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testAverageRating1() {
		Book book = new Book();
		Set<Review> reviews = new HashSet<>();
		Review review1 = new Review();
		review1.setRating(5);
		reviews.add(review1);
		book.setReviews(reviews);
		float averageRating = book.getAverageRating();
		assertEquals(5.0, averageRating, 0.0);
	}

}