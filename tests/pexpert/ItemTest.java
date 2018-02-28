package pexpert;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemTest {
	Item item;

	@BeforeEach
	void setUp() throws Exception {
		item = new Item(new Product("Pen", 1.5));
	}

	@Test
	void verifyCreation() {
		//This test verifies that an item is composed of a single product. 
		// It also verifies that an item only contain one product. 
		
		assertEquals(item.getProduct().getName(), "Pen", "Item should contain a pen");
		assertEquals(item.getProduct().getPrice().toString(), "1.5", "The price of an item should be the price of the product");
	}
	
	void verifyToString() {
		//This test verifies that items are displayed correctly
		
		assertEquals(item.toString(), "Pen      1.5");
	}
	
	void verifyCompareTo() {
		//This test verifies that items can be compared
		
		Item item2 = new Item(new Product("Pen", 1.5));
		assertEquals(item.compareTo(item2), 0, "Items should be equal");
		
		Item item3 = new Item(new Product("Pencil", 1.0));
		assertNotEquals(item.compareTo(item3), 0, "Items should not be equal");
		
		Item item4 = new Item(new Product("Pen", 1.0));
		assertNotEquals(item.compareTo(item4), 0, "Items with different prices should not be equal");
		
		Item item5 = new Item(new Product("Pencil", 1.5));
		assertNotEquals(item.compareTo(item5), 0, "Items with different product names should not be equal");

		Price dummy = new Price(1.6);
		assertThrows(ClassCastException.class, ()->{item.compareTo(dummy);}, 
				"Expected ClassCastException when comparing an item with another object");
	}
}
