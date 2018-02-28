package pexpert;

import Exceptions.IllegalAmountValue;

public class WeightableItem extends Item {
	private double amount;
	
	public WeightableItem(Product product, double amount) throws IllegalAmountValue {
		super(product);
		
		if(amount <= 0) {
			throw new IllegalAmountValue("Product amount should be positive");
		}
		
		this.amount = amount;
	}
	
	public final double getAmount() {
		return this.amount;
	}
	
	@Override
	protected double calculatePrice() {
		return product.calculatePrice(amount);
	}
	
	@Override
	public String toString() {
		String displayedText = this.product.getName() +"\n";
		displayedText +=  amount + "kg @ £" + product.getPrice().toString() + "\t" + calculatePrice()+"\n";
		return displayedText;
		
	}
}
