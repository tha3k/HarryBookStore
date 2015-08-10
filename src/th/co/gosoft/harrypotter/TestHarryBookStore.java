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
	
	
}
