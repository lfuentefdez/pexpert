package Discount;

public class XForPriceYDiscount implements Discount {
	private int discountUnits;
	private double discountPrice;
	
	public XForPriceYDiscount(int units, double price) {
		this.discountUnits = units;
		this.discountPrice = price;
	}

	@Override
	public double calculate(int totalUnits, double price) {
		// TODO Auto-generated method stub
		return 0;
	}

}
