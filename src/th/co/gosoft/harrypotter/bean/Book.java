package th.co.gosoft.harrypotter.bean;

public class Book {
	private String name;
	private double price = 0.0;
	
	public Book(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	protected void setPrice(double price) {
		this.price = price;
	}
}
