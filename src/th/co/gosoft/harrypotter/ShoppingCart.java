package th.co.gosoft.harrypotter;

import java.util.HashMap;
import java.util.Map;


public class ShoppingCart {
	private Map<String, Integer> shopingCart = new HashMap<String, Integer>();
	
	public void add(Book book, int bookCount) {
		if (shopingCart.containsKey(book.getName()))
			bookCount += shopingCart.get(book.getName());
		shopingCart.put(book.getName(), bookCount);
	}

	public Map<String, Integer> getShopingCartMap() {
		return shopingCart;
	}

	
}
