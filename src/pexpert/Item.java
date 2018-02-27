package pexpert;

public class Item implements Comparable<Object> {
	protected Product product;
	
	public Item(Product product) {
		this.product = product;
	}

	protected double calculatePrice() {
		return product.calculatePrice(1);
	}

	public final Product getProduct() {
		return this.product;
	}
	
	@Override
	public String toString() {
		return product.getName() + "\t\t" + calculatePrice();
	}

	@Override
	public int compareTo(Object anotherItem) throws ClassCastException {
		if (!(anotherItem instanceof Item)) {
			 throw new ClassCastException("Expected an Item object");
		}

		return product.compareTo(((Item) anotherItem).product);
	}
}