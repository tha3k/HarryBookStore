package th.co.gosoft.harrypotter.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import th.co.gosoft.harrypotter.Book;
import th.co.gosoft.harrypotter.HarryBookStore;


public class TestHarryBookStore {
	HarryBookStore bookStore = new HarryBookStore();
	
	@Test 
	public void no_book_total_price_should_be_0() {
		assertEquals(0.0, bookStore.getTotalPrice(), 0);
	}

	@Test
	public void buy_1_1st_book_total_price_8EUR() {
		bookStore.addToCart(new Book("1st"));
		assertEquals(8, bookStore.getTotalPrice(), 0);
	}
	
	@Test 
	public void buy_1_1st_book_and_1_2nd_book_should_have_2_book_type() {
		bookStore.addToCart(new Book("1st"));
		bookStore.addToCart(new Book("2nd"));
		assertEquals(2, bookStore.getShopingCart().size());
	}

	@Test
	public void buy_1_1st_book_and_1_2nd_book_should_discount_5_percent() {
		bookStore.addToCart(new Book("1st"));
		bookStore.addToCart(new Book("2nd"));
		assertEquals(15.2, bookStore.getTotalPrice(), 0);
	}
	
	@Test 
	public void buy_1_1st_book_and_1_2nd_book_and_1_3rd_book_should_discount_10_percent() {
		bookStore.addToCart(new Book("1st"));
		bookStore.addToCart(new Book("2nd"));
		bookStore.addToCart(new Book("3rd"));
		assertEquals(21.6, bookStore.getTotalPrice(), 0);
	}
	
	@Test 
	public void buy_1_1st_book_and_1_2nd_book_and_1_3rd_book_and_1_4th_book_should_discount_20_percent() {
		bookStore.addToCart(new Book("1st"));
		bookStore.addToCart(new Book("2nd"));
		bookStore.addToCart(new Book("3rd"));
		bookStore.addToCart(new Book("4th"));
		assertEquals(25.6, bookStore.getTotalPrice(), 0);
	}

	@Test 
	public void buy_1_1st_book_and_1_2nd_book_and_1_3rd_book_and_1_4th_book_and_1_5th_book_should_discount_25_percent() {
		bookStore.addToCart(new Book("1st"));
		bookStore.addToCart(new Book("2nd"));
		bookStore.addToCart(new Book("3rd"));
		bookStore.addToCart(new Book("4th"));
		bookStore.addToCart(new Book("5th"));
		assertEquals(30, bookStore.getTotalPrice(), 0);
	}
	
	@Test 
	public void buy_2_1st_book_and_1_2nd_book() {
		bookStore.addToCart(new Book("1st"), 2);
		bookStore.addToCart(new Book("2nd"));
		assertEquals(23.2, bookStore.getTotalPrice(), 0);
	}
	
	@Test 
	public void buy_2_1st_book_and_2_2nd_book() {
		bookStore.addToCart(new Book("1st"), 2);
		bookStore.addToCart(new Book("2nd"), 2);
		assertEquals(30.4, bookStore.getTotalPrice(), 0);
	}
	
	@Test
	public void buy_2_1st_book_and_2_2nd_book_and_2_3rd_book_and_1_4th_book_and_1_5th_book_should_discount_with_no_optimize() {
		bookStore.addToCart(new Book("1st"), 2);
		bookStore.addToCart(new Book("2nd"), 2);
		bookStore.addToCart(new Book("3rd"), 2);
		bookStore.addToCart(new Book("4th"));
		bookStore.addToCart(new Book("5th"));
		assertEquals(51.6, bookStore.getTotalPrice(), 0);
	}
	
	@Test
	public void buy_2_1st_book_and_2_2nd_book_and_2_3rd_book_and_1_4th_book_and_1_5th_book_should_discount_with_optimize() {
		bookStore.setOptimized(true);
		bookStore.addToCart(new Book("1st"), 2);
		bookStore.addToCart(new Book("2nd"), 2);
		bookStore.addToCart(new Book("3rd"), 2);
		bookStore.addToCart(new Book("4th"));
		bookStore.addToCart(new Book("5th"));
		assertEquals(51.2, bookStore.getTotalPrice(), 0);
	}
	
	
	
}
