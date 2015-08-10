package th.co.gosoft.harrypotter;

import java.util.HashMap;
import java.util.Map;

public class HarryBookStore {
	private Map<String, Integer> shopingCart = new HashMap<String, Integer>();

	public double getTotalPrice() {
		int bookTypeCount = shopingCart.size();
		double totalPrice = bookTypeCount*8;
		double discountPrice = totalPrice*getDiscountPercent(bookTypeCount);
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
	
	private double getDiscountPercent(int bookTypeCount) {
		if (bookTypeCount==2)
			return 0.05;
		else if (bookTypeCount==3)
			return 0.10;
		else if (bookTypeCount==4)
			return 0.20;
		else if (bookTypeCount==5)
			return 0.25;
		
		return 0;
	}
	

}
