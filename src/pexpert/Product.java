package pexpert;

import Exceptions.IllegalPriceValue;

public class Product implements Comparable<Object>{
	private String name;
	private Price price;
	
	public Product(String name, double price) {
		this.name = name;
		this.price = new Price(price);
	}
	
	public final String getName() {
		return this.name;
	}
	
	public double calculatePrice(double amount) {
		return price.calculatePrice(amount);
	}
	
	public void updateProductPrice(double newPrice) throws IllegalPriceValue {
		price.updatePrice(newPrice);
	}
	
	public String displayPrice() {
		return price.toString();
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Object anotherProduct) throws ClassCastException {
		if(!(anotherProduct instanceof Product)) {
			throw new ClassCastException("Expected a product object");
		}
		
		Product otherP = (Product) anotherProduct;
		return name.compareTo(otherP.getName()) +  price.compareTo(otherP.price);
	}
}