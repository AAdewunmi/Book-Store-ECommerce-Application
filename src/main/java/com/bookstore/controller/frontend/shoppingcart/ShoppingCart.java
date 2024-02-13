package com.bookstore.controller.frontend.shoppingcart;

import java.util.HashMap;
import java.util.Map;

import com.bookstore.entity.Book;

public class ShoppingCart {
	
	private Map<Book, Integer> cart = new HashMap<>();
	
	public void addItem(Book book) {
		if (cart.containsKey(book)) {
			Integer quality = cart.get(book) + 1;
			cart.put(book, quality);
		} else {
			cart.put(book, 1);
		}
	}
	
	public void removeItem(Book book) {
		cart.remove(book);
	}
	
	public Map<Book, Integer> getItems(){
		return this.cart;
	}
	
}
