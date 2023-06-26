package com.bookstore.dao;

import java.util.List;

import com.bookstore.entity.Category;

import jakarta.persistence.EntityManager;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {

	public CategoryDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Category create(Category category) {
		// TODO Auto-generated method stub
		return super.create(category);
	}

	@Override
	public Category update(Category t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
