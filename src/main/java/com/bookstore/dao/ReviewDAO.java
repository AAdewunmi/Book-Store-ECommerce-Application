package com.bookstore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Review;

public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review> {
	
	@Override
	public Review create(Review review) {
		review.setReviewTime(new Date());
		return super.create(review);
	}

	@Override
	public Review update(Review reviewId) {
		return super.update(reviewId);
	}

	@Override
	public Review get(Object reviewId) {
		return super.find(Review.class, reviewId);
	}

	@Override
	public void delete(Object reviewId) {
		super.delete(Review.class, reviewId);
	}

	@Override
	public List<Review> listAll() {
		return super.findWithNamedQuery("Review.listAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Review.countAll");
	}
	
	public long countByCustomer(int customerId) {
		return super.countWithNamedQuery("Review.countByCustomer", "customerId", customerId);
	}
	
	public Review findByCustomerAndBook(Integer customerId, int bookId) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("customerId", customerId);
		parameters.put("bookId", bookId);
		List<Review> result = super.findWithNamedQuery("Review.findByCustomerAndBook", parameters);
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}
	
	public List<Review> listMostRecent(){
		return super.findWithNamedQuery("Review.listAll", 0, 3);
	}

}
