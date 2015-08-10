package th.co.gosoft.harrypotter;

import java.util.HashMap;
import java.util.Map;

import th.co.gosoft.harrypotter.bean.Book;


public class ShoppingCart {
	private Map<String, ShopingBook> shopingCart = new HashMap<String, ShopingBook>();
	
	public void add(Book book, int bookCount) {
		if (!shopingCart.containsKey(book.getName()))
			shopingCart.put(book.getName(), new ShopingBook(book, 0));

		bookCount += shopingCart.get(book.getName()).getCount();
		shopingCart.get(book.getName()).setCount(bookCount);
	}

	public Map<String, ShopingBook> getShopingCartMap() {
		return shopingCart;
	}

	
}
