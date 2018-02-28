package pexpert;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exceptions.IllegalAmountValue;

class WeightableItemTest {
	WeightableItem item;

	@BeforeEach
	void setUp() throws Exception {
		item = new WeightableItem(new Product("Banana", 2.0), 0.5);
	}

	@Test
	void verifyCreation() {
		// This test verify that WeightableItem instances can be created
		assertEquals(item.getProduct().getName(), "Banana", "Item should contain bananas");
		assertEquals(item.getProduct().getPrice().toString(), "2.0", "The bananas in the item should cost 2.0");
	}
	
	void verifyCreationNegative() {
		//Verify that Items with a zero or a negative weight cannot be created
		
		assertThrows(IllegalAmountValue.class, ()->{new WeightableItem(new Product("Banana", 2.0), 0.0);}, 
				"Expected IllegalAmountValue for an item containing a product with no weight");
		
		assertThrows(IllegalAmountValue.class, ()->{new WeightableItem(new Product("Banana", 2.0), -1.0);}, 
				"Expected IllegalAmountValue for an item containing a product with negative weight");
	}
	
	
	@Test 
	void verifyPrice(){
		// This test verify that the price of a weightableItem can be computed based on the weight
		
		assertEquals(item.getAmount(), 0.5, "Item should contain 0.5 kg of bananas");
		assertEquals(item.calculatePrice(), 1.0, "The price of 0.5 kg of bananas should be 1.0");
	}
	
	@Test
	void verifyToString() {
		//This test verifies that WeightableItems are displayed correctly
	
		assertTrue(item.toString().contains("Banana\n"));
		assertTrue(item.toString().contains("0.5 kg @ 2.0   1.0\n"));
		
	}
}
