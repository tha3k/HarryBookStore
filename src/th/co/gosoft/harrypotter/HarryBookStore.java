package th.co.gosoft.harrypotter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HarryBookStore {
	private static final double[] DISCOUNT_PERCENT = new double[] { 0, 0, 0.05, 0.10, 0.20, 0.25 };
	private Map<String, Integer> shopingCart = new HashMap<String, Integer>();

	public double getTotalPrice() {
		int bookTypeCount = shopingCart.size();
		double totalPrice = 0.0;

		while (bookTypeCount>0) {
			double eachTotalPrice = bookTypeCount*8;
			double eachTotalDiscount = getTotalDiscount(eachTotalPrice, bookTypeCount);
			totalPrice += (eachTotalPrice-eachTotalDiscount);
			
			removeBookFromShopingCart();
			bookTypeCount = shopingCart.size();
		}
		
		return totalPrice;
	}

	public void buy(Book book) {
		buy(book, 1);
	}
	
	public void buy(Book book, int bookCount) {
		if (shopingCart.containsKey(book.getName()))
			bookCount += shopingCart.get(book.getName());
		shopingCart.put(book.getName(), bookCount);
	}

	public Map<String, Integer> getShopingCart() {
		return shopingCart;
	}
	
	private void removeBookFromShopingCart() {
		Map<String, Integer> updatedShopingCart = new HashMap<String, Integer>();
		Iterator<String> iteAllBook = shopingCart.keySet().iterator();
		while (iteAllBook.hasNext()) {
			String bookName = iteAllBook.next();
			int newBookCount = ((int)shopingCart.get(bookName))-1;
			if (newBookCount>0)
				updatedShopingCart.put(bookName, newBookCount);
		}
		shopingCart = updatedShopingCart;
	}
	
	private double getTotalDiscount(double totalPrice, int bookTypeCount) {
		return totalPrice*getDiscountPercent(bookTypeCount);
	}
	
	private double getDiscountPercent(int bookTypeCount) {
		return DISCOUNT_PERCENT[bookTypeCount];
	}
	

}
