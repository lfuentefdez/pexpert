package Discount;

public class XForYDiscount implements Discount {
	private int XUnits;
	private int ForYUnits;
	
	
	public XForYDiscount(int XUnits, int ForYUnits) {
		this.XUnits = XUnits;
		this.ForYUnits = ForYUnits;
	}
	
	
	@Override
	public double calculate(int units, double price) {
		// TODO Auto-generated method stub
		return 0;
	}

}
