package pexpert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Exceptions.ProductNameNotExist;

public class Basket {
	private List<Item> items;
	
	
	public Basket() {
		this.items = new ArrayList<Item>();
	}
	
	public void add(Item item) {
		this.items.add(item);
	}
	
	/**
	 * This method delete the last occurrence of an item. 
	 * @param item
	 */
	public void delete(Item item) throws ProductNameNotExist {
		int itemIndex = this.getItemIndex(item);
		if(itemIndex == - 1) {
			throw new ProductNameNotExist("Product not found");
		}
		
		this.items.remove(itemIndex);
	}
	
	public int getNumberOfItems() {
		return this.items.size();
	}
	
	public int getNumItemsByProductName(String productName) {
		return (int)items.stream().filter(item -> productName.equals(item.product.getName())).count();
	}
	
	
	private int getItemIndex(Item itemToFind) {
		int idx  = -1;
		for(int itemIdx = items.size(); itemIdx >=0; itemIdx--) {
			if(itemToFind.compareTo(items.get(itemIdx)) == 0) {
				idx = itemIdx;
				break;
			}
		}
		return idx;
	}
	
	@Override
	public String toString() {
		return items.stream().map(Object::toString).collect(Collectors.joining("\n"));
	}
	
	public double calculateTotal() {
		return items.stream().mapToDouble(item -> item.calculatePrice()).sum();
	}
}
