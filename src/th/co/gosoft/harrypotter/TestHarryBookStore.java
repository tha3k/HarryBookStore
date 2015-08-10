package th.co.gosoft.harrypotter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestHarryBookStore {
	HarryBookStore bookStore = new HarryBookStore();
	
	@Test 
	public void buy_0_book_total_price_0() {
		assertEquals(0.0, bookStore.getTotalPrice(), 0);
	}

	@Test
	public void buy_1_1st_book_total_price_8EUR() {
		bookStore.buy(new Book("1st"));
		assertEquals(8, bookStore.getTotalPrice(), 0);
	}
	
	@Test 
	public void buy_1_1st_book_and_1_2nd_book_should_have_2_book_type() {
		bookStore.buy(new Book("1st"));
		bookStore.buy(new Book("2nd"));
		assertEquals(2, bookStore.getShopingCart().size());
	}

	@Test
	public void buy_1_1st_book_and_1_2nd_book_should_discount_5_percent() {
		bookStore.buy(new Book("1st"));
		bookStore.buy(new Book("2nd"));
		assertEquals(15.2, bookStore.getTotalPrice(), 0);
	}
	
	@Test 
	public void buy_1_1st_book_and_1_2nd_book_and_1_3rd_book_should_discount_10_percent() {
		bookStore.buy(new Book("1st"));
		bookStore.buy(new Book("2nd"));
		bookStore.buy(new Book("3rd"));
		assertEquals(21.6, bookStore.getTotalPrice(), 0);
	}
	
	@Test 
	public void buy_1_1st_book_and_1_2nd_book_and_1_3rd_book_and_1_4th_book_should_discount_20_percent() {
		bookStore.buy(new Book("1st"));
		bookStore.buy(new Book("2nd"));
		bookStore.buy(new Book("3rd"));
		bookStore.buy(new Book("4th"));
		assertEquals(25.6, bookStore.getTotalPrice(), 0);
	}

	@Test 
	public void buy_1_1st_book_and_1_2nd_book_and_1_3rd_book_and_1_4th_book_and_1_5th_book_should_discount_25_percent() {
		bookStore.buy(new Book("1st"));
		bookStore.buy(new Book("2nd"));
		bookStore.buy(new Book("3rd"));
		bookStore.buy(new Book("4th"));
		bookStore.buy(new Book("5th"));
		assertEquals(30, bookStore.getTotalPrice(), 0);
	}
	
	@Test 
	public void buy_2_1st_book_and_1_2nd_book() {
		bookStore.buy(new Book("1st"), 2);
		bookStore.buy(new Book("2nd"));
		assertEquals(23.2, bookStore.getTotalPrice(),0);
	}
	
	
	
}
