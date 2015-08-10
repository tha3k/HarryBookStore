package th.co.gosoft.harrypotter.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import th.co.gosoft.harrypotter.HarryBookStore;
import th.co.gosoft.harrypotter.bean.HarryPotterBook;

public class TestHarryBookStoreDataWithOptimized {
	public static final int TWO_BOOKS = 2;
	public HarryBookStore bookStore = new HarryBookStore();

	@Test
	public void buy_2_1st_book_and_2_2nd_book_and_2_3rd_book_and_1_4th_book_and_1_5th_book_should_discount_with_optimize() {
		bookStore.setOptimized(true);
		bookStore.addToCart(new HarryPotterBook("1st"), TWO_BOOKS);
		bookStore.addToCart(new HarryPotterBook("2nd"), TWO_BOOKS);
		bookStore.addToCart(new HarryPotterBook("3rd"), TWO_BOOKS);
		bookStore.addToCart(new HarryPotterBook("4th"));
		bookStore.addToCart(new HarryPotterBook("5th"));
		assertEquals(51.2, bookStore.getTotalPrice(), 0);
	}
}