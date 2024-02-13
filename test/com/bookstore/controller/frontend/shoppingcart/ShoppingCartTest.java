package com.bookstore.controller.frontend.shoppingcart;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bookstore.entity.Book;

public class ShoppingCartTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testAddItem() {
		ShoppingCart cart = new ShoppingCart();
		Book book = new Book();
		book.setBookId(1);
		cart.addItem(book);
		cart.addItem(book);
		Map<Book, Integer> items = cart.getItems(); 
		int quantity = items.get(book);
		assertEquals(2, quantity);
	}

	@After
	public void tearDown() throws Exception {
	}

	

}
