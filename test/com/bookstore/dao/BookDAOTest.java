package com.bookstore.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BookDAOTest extends BaseDAOTest{
	private static BookDAO bookDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		bookDAO = new BookDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCreateBook() {
		fail("Not yet implemented");
	}

}
