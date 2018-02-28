/**
 * 
 */
package pexpert;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exceptions.IllegalPriceValue;

/**
 * @author Luis Fuente
 *
 */
class ProductTest {
	
	Product product;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.product = new Product("Banana", 1.5);
	}

	@Test
	void verifyProductCreation() {
		//Verify that it is possible to create a product and
		//that is created with the correct values
		assertEquals(product.getName(), "Banana", "Expected a product called banana");
		assertNotNull(product.getPrice(), "Product price should not be null");
		assertEquals(product.getPrice().toString(), "1.5", "Expected a price of 1.5");	
	}
	
	void verifyCalculatePrice() {
		int amount = 1;
		assertEquals(product.calculatePrice(amount), 1.5, 
				"Calculating the price of a product does not return the correct value");

		amount=2;
		assertEquals(product.calculatePrice(amount), 3.0, 
				"Calculating the price of a product does not return the correct value when the amount is 2");

		amount = 0;
		assertEquals(product.calculatePrice(amount), 0.0, 
				"Calculate price of a product does not return 0 when the amount is 0");

		amount = -1;
		assertEquals(product.calculatePrice(amount), -1.5, 
				"Calculating the price of a product does not return the correct value for negative amounts");
	}
	
	@Test
	void verifyValidUpdate() {
		// This test verifies that the product's price can be updated

		assertEquals(product.getPrice().toString(), "1.5");
		try {
			product.updateProductPrice(3.0);
		}catch(Exception e){
			fail("Update price should not throw an exception for positive values");
		}
		assertEquals(product.getPrice().toString(), "3.0",
				"UpdatePrice does not update the price correctly");
	}

	@Test
	void negativeUpdatePrice() {
		// This test verifies that updateProductPrice throws an error when the price
		// equals or lower than 0
		
		//Asserts that price is 2.6
		assertEquals(product.getPrice().toString(), "1.5");

		//Attempts to setup price to -1
		assertThrows(IllegalPriceValue.class, ()->{product.updateProductPrice(-1);}, 
				"Expected IllegalPriceValue for negative prices");
		assertEquals(product.getPrice().toString(), "1.5", "Price should remain after setting a negative price");

		//Attempts to setup up price to 0
		assertThrows(IllegalPriceValue.class, ()->{product.updateProductPrice(0);}, 
				"Expected IllegalPriceValue for a price equals to 0");
		assertEquals(product.getPrice().toString(), "1.5", "Price should remain after setting a price equals to 0");
	}
	
	@Test
	void verifyCompareTo() throws IllegalPriceValue {
		//This test verifies that two products can be compared
		
		Product product2 = new Product("Banana", 1.5);
		assertEquals(product.compareTo(product2), 0, "Products should be the same");
		
		product2.updateProductPrice(3.0);
		assertNotEquals(product.compareTo(product), 0, "Products with different prices should be different");
		
		Product product3 = new Product("Pen", 1.3);
		assertEquals(product.compareTo(product3) , 0, "Products with different names should be different");
	
		Price dummy = new Price( 1.6);
		assertThrows(ClassCastException.class, ()->{product.compareTo(dummy);}, 
				"Expected ClassCastException when comparing a product with another object");
	}
}
