package th.co.gosoft.harrypotter;

import java.util.HashMap;
import java.util.Map;

public class HarryBookStore {
	private Map<String, Integer> shopingCart = new HashMap<String, Integer>();

	public double getTotalPrice() {
		double totalPrice = shopingCart.size()*8;
		return totalPrice;
	}

	public void buy(Book book) {
		int bookCount = 0;
		if (shopingCart.containsKey(book.getName()))
			bookCount = shopingCart.get(book.getName())+1;
		shopingCart.put(book.getName(), bookCount);
	}

}
