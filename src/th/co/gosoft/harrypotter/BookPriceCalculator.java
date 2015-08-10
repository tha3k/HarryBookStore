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
		Map<String, ShopingBook> eachShopingCart = shopingCart.getShopingCartMap();
		double totalPrice = 0.0;
		int allBookTypeCount = eachShopingCart.size();
		while (allBookTypeCount>0) {
			int bookTypeCount = (allBookTypeCount>maxBookType)?maxBookType:allBookTypeCount;
			double eachTotalPrice = getTotalPriceNormal(eachShopingCart, bookTypeCount);
			double eachTotalDiscount = getTotalDiscount(bookTypeCount, eachTotalPrice);
			totalPrice += (eachTotalPrice-eachTotalDiscount);
			
			eachShopingCart = removeBookFromShopingCart(eachShopingCart, bookTypeCount);
			allBookTypeCount = eachShopingCart.size();
		}
		
		return totalPrice;
	}

	
	private double getTotalPriceNormal(Map<String, ShopingBook> eachShopingCart, int maxBookType) {
		Iterator<String> iteAllBook = eachShopingCart.keySet().iterator();
		double totalPrice = 0;
		int bookType = 0;
		while (iteAllBook.hasNext()) {
			String bookName = iteAllBook.next();
			if (bookType<maxBookType)
				totalPrice += eachShopingCart.get(bookName).getBook().getPrice();
			bookType++;
		}
		return totalPrice;
	}
	
	private Map<String, ShopingBook> removeBookFromShopingCart(Map<String, ShopingBook> eachShopingCart, int maxBookType) {
		Map<String, ShopingBook> updatedShopingCart = new HashMap<String, ShopingBook>();
		Iterator<String> iteAllBook = eachShopingCart.keySet().iterator();
		int bookType = 0;
		while (iteAllBook.hasNext()) {
			String bookName = iteAllBook.next();
			
			int newBookCount = eachShopingCart.get(bookName).getCount();
			if (bookType<maxBookType)
				newBookCount--;
			
			if (newBookCount>0)
				updatedShopingCart.put(bookName, new ShopingBook(eachShopingCart.get(bookName).getBook(), newBookCount));
			
			bookType++;
		}
		return updatedShopingCart;
	}
	
	private double getTotalDiscount(int bookTypeCount, double totalPrice) {
		return totalPrice*DISCOUNT_PERCENT[bookTypeCount];
	}

}
