package Discount;

import java.util.HashMap;

public class DiscountManager {

	HashMap<String,Discount> discounts;
	
	private DiscountManager() {
		this.discounts = new HashMap<String, Discount>();
	}
}
