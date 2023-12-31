package com.bookstore.dao;

import java.util.Date;
import java.util.List;

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
	public void delete(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Review> listAll() {
		return super.findWithNamedQuery("Review.listAll");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
