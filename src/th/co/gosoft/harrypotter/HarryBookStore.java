package th.co.gosoft.harrypotter;

import java.util.HashMap;
import java.util.Map;

public class HarryBookStore {
	private static final double[] DISCOUNT_PERCENT = new double[] { 0, 0, 0.05, 0.10, 0.20, 0.25 };
	private Map<String, Integer> shopingCart = new HashMap<String, Integer>();

	public double getTotalPrice() {
		int bookTypeCount = shopingCart.size();
		double totalPrice = bookTypeCount*8;
		double discountPrice = getTotalDiscount(totalPrice, bookTypeCount);
		return totalPrice-discountPrice;
	}

	public void buy(Book book) {
		int bookCount = 0;
		if (shopingCart.containsKey(book.getName()))
			bookCount = shopingCart.get(book.getName())+1;
		shopingCart.put(book.getName(), bookCount);
	}

	public Map<String, Integer> getShopingCart() {
		return shopingCart;
	}
	
	
	private double getTotalDiscount(double totalPrice, int bookTypeCount) {
		return totalPrice*getDiscountPercent(bookTypeCount);
	}
	
	private double getDiscountPercent(int bookTypeCount) {
		return DISCOUNT_PERCENT[bookTypeCount];
	}
	

}
