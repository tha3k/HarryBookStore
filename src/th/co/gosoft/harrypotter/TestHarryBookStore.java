package th.co.gosoft.harrypotter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestHarryBookStore {
	
	@Test 
	public void buy_0_book_total_price_0() {
		HarryBookStore bookStore = new HarryBookStore();
		assertEquals(0.0, bookStore.getTotalPrice(), 0);
	}

	@Test
	public void buy_1_1st_book_total_price_8EUR() {
		HarryBookStore bookStore = new HarryBookStore();
		bookStore.buy(new Book("1st"));
		assertEquals(8, bookStore.getTotalPrice(), 0);
	}
	
	@Test 
	public void buy_1_1st_book_and_1_2nd_book_should_have_2_book_type() {
		HarryBookStore bookStore = new HarryBookStore();
		bookStore.buy(new Book("1st"));
		bookStore.buy(new Book("2nd"));
		assertEquals(2, bookStore.getShopingCart().size());
	}

	@Test
	public void buy_1_1st_book_and_1_2nd_book_should_discount_5_percent() {
		HarryBookStore bookStore = new HarryBookStore();
		bookStore.buy(new Book("1st"));
		bookStore.buy(new Book("2nd"));
		assertEquals(15.2, bookStore.getTotalPrice(), 0);
	}
	
	
	
}
