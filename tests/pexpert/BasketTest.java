package pexpert;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exceptions.IllegalAmountValue;
import Exceptions.ProductNameNotExist;

class BasketTest {
	Basket basket;

	@BeforeEach
	void setUp() throws Exception {
		basket = new Basket();
	}
	
	@Test
	void verifyEmpty() {
		// This test verifies that the basket is empty by default
		assertEquals(basket.getNumberOfItems(), 0, "Basket should be empty by default");
	}
	
	void verifyAdd() {
		// This test verifies that items can be added to the basket
		
		basket.add(new Item(new Product("Pen", 2.5)));
		assertEquals(basket.getNumberOfItems(), 1, "Basket should contain 1 product");
		
		basket.add(new Item(new Product("Pencil", 4.0)));
		assertEquals(basket.getNumberOfItems(), 2, "Basket should contain 2 products");
	}
	
	void verifyAddMixedItems() throws IllegalAmountValue {
		// This test verifies that items and weightable items can be mixed up
		basket.add(new Item(new Product("Pen", 2.5)));
		basket.add(new WeightableItem(new Product("Banana", 2.5), 1.5));
		
		assertEquals(basket.getNumberOfItems(), 2, "Basket should be able to mix different types of products");
	}
	
	
	void verifyMultipleItems() {
		//This test verifies that two purchases of the same product count as two independent items
		
		basket.add(new Item(new Product("Pen", 2.5)));
		basket.add(new Item(new Product("Pen", 2.5)));

		assertEquals(basket.getNumberOfItems(), 2, "Basket should contain two items of the same product");	
	}
	
	
	void verifyCount() {
		//This test verifies that it is possible to obtain the number of purchases of the same product
		
		basket.add(new Item(new Product("Pen", 2.5)));
		basket.add(new Item(new Product("Mouse", 15.5)));
		basket.add(new Item(new Product("Bike", 10.5)));
		basket.add(new Item(new Product("Pen", 2.5)));
		
		assertEquals(basket.getNumItemsByProductName("Pen"), 2, "Expected two pens in the shopping basket");
		assertEquals(basket.getNumItemsByProductName("Mouse"), 1, "Expected 1 mouse in the shopping basket");
		assertEquals(basket.getNumItemsByProductName("Bike"), 1, "Expected 1 bike in the shopping basket");	
	}
	
	
	void verifyRemoveSingleItem() throws ProductNameNotExist {
		//This test verifies that items can be removed from the basket
		
		basket.add(new Item(new Product("Pen", 2.5)));
		assertEquals(basket.getNumberOfItems(), 1);
		basket.delete(new Item(new Product("Pen", 2.5)));
		assertEquals(basket.getNumberOfItems(), 0, "Basket should be empty");
	}
	
	void verifyRemoveLastOccurence() throws ProductNameNotExist {
		//This test verifies that delete from the list, deletes the last ocurrence of the item 
		
		basket.add(new Item(new Product("Pen", 3.5)));
		basket.add(new Item(new Product("Pen", 2.5)));
		basket.add(new Item(new Product("Pen", 1.5)));
		assertEquals(basket.getNumberOfItems(), 3);
		
		basket.delete(new Item(new Product("Pen", 1.5)));
		assertEquals(basket.getNumberOfItems(), 2);
		
		//Verify that the last pen is removed
		assertTrue(basket.toString().endsWith("2.5\n") && 
				!basket.toString().contains("1.5"), 
				"Pen with price 1.5 should not be in the list");
	}
	
	void negativeRemoveNonExistentProduct() {
		// This test verifies that an error is thrown if an item that it is not on the basket is deleted
		
		basket.add(new Item(new Product("Pen", 3.5)));
		
		assertThrows(ProductNameNotExist.class, ()->{basket.delete(new Item(new Product("Cow", 10.2)));}, 
				"Expected IllegalPriceValue for a price equals to 0");
	}
	
	void verifyTotal() throws IllegalAmountValue {
		// This test verifies that the calculation of the cost of all items in the basket
		
		basket.add(new Item(new Product("Pen", 2.5)));
		basket.add(new WeightableItem(new Product("Banana", 2.5), 0.5));
		
		assertEquals(basket.calculateTotal(), 3.75, "Incorrect price for all the elements in the basket");
	}
	
}
