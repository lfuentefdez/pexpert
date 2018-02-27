package pexpert;

public class WeightableItem extends Item {
	private double amount;
	
	public WeightableItem(Product product, double amount) {
		super(product);
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
		displayedText +=  amount + "kg @ £" + product.displayPrice() + " " + calculatePrice()+"\n";
		return displayedText;
		
	}
}
