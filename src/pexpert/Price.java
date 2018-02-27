package pexpert;
import java.math.BigDecimal;

import Exceptions.IllegalPriceValue;

public class Price implements Comparable<Object> {
	private BigDecimal price;
	

	public Price(double price) {
		this.price = BigDecimal.valueOf(price);	}

	public void updatePrice(double newPrice) throws IllegalPriceValue {
		if(newPrice <= 0) {
			throw new IllegalPriceValue("Price cannot be negative");
		}
		this.price = BigDecimal.valueOf(newPrice);
	}
	
	public double calculatePrice(double amount) {
		return price.doubleValue() * amount;
	}
	
	@Override
	public String toString() {
		return price.toString();
	}

	@Override
	public int compareTo(Object anotherPrice) throws ClassCastException {
		if(!(anotherPrice instanceof Price)) {
			throw new ClassCastException("Expected a price object");
		}
		
		return this.price.intValueExact() - ((Price) anotherPrice).price.intValueExact();
	}
}
