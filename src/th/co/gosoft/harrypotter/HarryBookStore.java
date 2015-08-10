package th.co.gosoft.harrypotter;

import java.util.Map;

public class HarryBookStore {
	private ShoppingCart shopingCart = new ShoppingCart();
	
	boolean isOptimized = false;
	
	public double getTotalPrice() {
		if (isOptimized)
			return getTotalPriceWithOptimized();
		return getTotalPriceOfBookSet(5);
	}

	public double getTotalPriceWithOptimized() {
		double totalPrice = Double.MAX_VALUE;
		for (int maxBookType=1;maxBookType<=5;maxBookType++) {
			totalPrice = Math.min(totalPrice, getTotalPriceOfBookSet(maxBookType));
		}
		return totalPrice;
	}

	public double getTotalPriceOfBookSet(int maxBookType) {
		BookPriceCalculator calculator = new BookPriceCalculator(this.shopingCart);
		return calculator.getTotalPriceOfBookSet(maxBookType);
	}
	
	public void buy(Book book) {
		buy(book, 1);
	}
	
	public void buy(Book book, int bookCount) {
		shopingCart.add(book, bookCount);
	}	

	public Map<String, Integer> getShopingCart() {
		return shopingCart.getShopingCartMap();
	}

	public void setOptimized(boolean isOptimized) {
		this.isOptimized = isOptimized;
	}

}
