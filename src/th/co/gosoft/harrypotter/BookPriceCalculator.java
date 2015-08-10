package th.co.gosoft.harrypotter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BookPriceCalculator {
	private static final double[] DISCOUNT_PERCENT = new double[] { 0, 0, 0.05, 0.10, 0.20, 0.25 };
	private ShoppingCart shopingCart = null;
	
	public BookPriceCalculator(ShoppingCart shopingCart) {
		this.shopingCart = shopingCart;
	}

	public double getTotalPriceWithOptimized() {
		double totalPrice = Double.MAX_VALUE;
		for (int maxBookType=1;maxBookType<=5;maxBookType++) {
			totalPrice = Math.min(totalPrice, getTotalPriceOfBookSet(maxBookType));
		}
		return totalPrice;
	}

	public double getTotalPriceOfBookSet(int maxBookType) {
		Map<String, Integer> eachShopingCart = shopingCart.getShopingCartMap();
		double totalPrice = 0.0;
		int allBookTypeCount = eachShopingCart.size();
		while (allBookTypeCount>0) {
			int bookTypeCount = (allBookTypeCount>maxBookType)?maxBookType:allBookTypeCount;
			double eachTotalPrice = bookTypeCount*8;
			double eachTotalDiscount = getTotalDiscount(bookTypeCount, eachTotalPrice);
			totalPrice += (eachTotalPrice-eachTotalDiscount);
			
			eachShopingCart = removeBookFromShopingCart(eachShopingCart, bookTypeCount);
			allBookTypeCount = eachShopingCart.size();
		}
		
		return totalPrice;
	}

	private Map<String, Integer> removeBookFromShopingCart(Map<String, Integer> eachShopingCart, int maxBookType) {
		Map<String, Integer> updatedShopingCart = new HashMap<String, Integer>();
		Iterator<String> iteAllBook = eachShopingCart.keySet().iterator();
		int bookType = 0;
		while (iteAllBook.hasNext()) {
			String bookName = iteAllBook.next();
			
			int newBookCount = eachShopingCart.get(bookName);
			if (bookType<maxBookType)
				newBookCount--;
			
			if (newBookCount>0)
				updatedShopingCart.put(bookName, newBookCount);
			
			bookType++;
		}
		return updatedShopingCart;
	}
	

	private double getTotalDiscount(int bookTypeCount, double totalPrice) {
		return totalPrice*DISCOUNT_PERCENT[bookTypeCount];
	}

}
