package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Category;

public class CategoryDAOTest {
	
	private static CategoryDAO categoryDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		categoryDAO = new CategoryDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		categoryDAO.close();
	}

	@Test
	public void testCreateCategory() {
		Category newCategory = new Category("Advanced Java");
		Category category = categoryDAO.create(newCategory);
		assertTrue(category != null && category.getCategoryId() > 0);
	}

	@Test
	public void testUpdateCategory() {
		Category newCategory = new Category("Spring Java");
		newCategory.setCategoryId(1);
		Category category = categoryDAO.update(newCategory);
		assertEquals(newCategory.getName(), category.getName());
	}

	@Test
	public void testGet() {
		Integer categoryId = 2;
		Category category = categoryDAO.get(categoryId);
		assertNotNull(category);
	}

	@Test
	public void testDeleteCategory() {
		Integer categoryId = 11;
		categoryDAO.delete(categoryId);
		Category category = categoryDAO.get(categoryId);
		assertNull(category);
	}

	@Test
	public void testListAll() {
		List<Category> listCategoryCategories = categoryDAO.listAll();
		listCategoryCategories.forEach(c -> System.out.println(c.getName()));
		assertTrue(listCategoryCategories.size() > 0);
	}

	@Test
	public void testCount() {
		long totalCategories = categoryDAO.count();
		assertTrue(totalCategories > 0);
	}
	
	@Test
	public void testFindByName() {
		String nameString = "Java";
		Category category = categoryDAO.findByName(nameString);
		assertNotNull(category);
	}
	
	@Test
	public void testFindByNameNotFound() {
		String nameString = "Hibernate Java";
		Category category = categoryDAO.findByName(nameString);
		assertNull(category);
	}

}
