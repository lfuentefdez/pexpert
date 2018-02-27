package pexpert;
import java.math.BigDecimal;

public class Price {
	private BigDecimal price;
	

	public Price(double price) {
		this.price = BigDecimal.valueOf(price);	}

	public void updatePrice(double newPrice) {
		this.price = BigDecimal.valueOf(newPrice);
	}
	
	public double calculatePrice(double amount) {
		return price.doubleValue() * amount;
	}
	
	@Override
	public String toString() {
		return price.toString();
	}
}
