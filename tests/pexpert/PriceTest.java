package pexpert;

import pexpert.Price;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exceptions.IllegalPriceValue;

class PriceTest {
	Price price;

	@BeforeEach
	void SetUp()  throws Exception {
		price = new Price(2.6);
	}


	@Test
	void verifyPrice() {
		//This test verifies that toString displays the correct price. 
		assertEquals(price.toString(), "2.6", "Incorrect price ");
	}

	@Test
	void verifyCalculatePrice() {
		//This test verifies that the price is correct for different amounts 
		
		int amount = 1;
		assertEquals(price.calculatePrice(amount), 2.6,  "Calculate price does not return the correct value");

		amount=2;
		assertEquals(price.calculatePrice(amount), 5.2, 
				"Calculate price does not return the correct price when the amount is 2");

		amount = 0;
		assertEquals(price.calculatePrice(amount), 0.0, 
				"Calculate price does not return 0 when the amount is 0");

		amount = -1;
		assertEquals(price.calculatePrice(amount), -2.6, 
				"Calculate does not return the correct amount for negative amounts");
	}

	@Test
	void verifyValidUpdate() {
		// This test verifies that the price can be updated

		assertEquals(price.toString(), "2.6");
		try {
			price.updatePrice(5.6);
		}catch(Exception e){
			fail("Update price should not throw an exception for negative values");
		}
		assertEquals(price.toString(), "5.6",
				"UpdatePrice does not update the price correctly");
	}

	@Test
	void negativeUpdatePrice() {

		//Asserts that price is 2.6
		assertEquals(price.toString(), "2.6");

		//Attempts to setup price to -1
		assertThrows(IllegalPriceValue.class, ()->{price.updatePrice(-1);}, 
				"Expected IllegalPriceValue for negative prices");
		assertEquals(price.toString(), "2.6", "Price should remain after setting a negative price");

		//Attempts to setup up price to 0
		assertThrows(IllegalPriceValue.class, ()->{price.updatePrice(0);}, 
				"Expected IllegalPriceValue for a price equals to 0");
		assertEquals(price.toString(), "2.6", "Price should remain after setting a price equals to 0");
	}
	
	@Test
	void verifyCompareTo() throws IllegalPriceValue {
		Price price2 = new Price(2.6);
		assertEquals(price.compareTo(price2), 0, "Prices should be the same");
		
		price2.updatePrice(3.6);
		assertEquals(price.compareTo(price2), -1, "Price comparison should return a negative value");
		
		price2.updatePrice(1.6);
		assertEquals(price.compareTo(price2) , 1, "Price comparison should return a positive value");
	
		Product dummy = new Product("Dummy", 1.6);
		assertThrows(ClassCastException.class, ()->{price.compareTo(dummy);}, 
				"Expected ClassCastException when comparing a price with another object");
	}
}
