package com.checkout.impl;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
	private Map<String, Item> checkedItems;
	
	private int runningTotal = 0;
	
	public Checkout() {
		checkedItems = new HashMap<>();
	}
	
	public void add(String itemName, int count, int price) {
		if (checkedItems.containsKey(itemName)) {
			checkedItems.get(itemName).count += count; 
			checkedItems.get(itemName).price = Math.min(checkedItems.get(itemName).price, price);
		} else {
			Item item = new Item();
			item.count = count;
			item.price = price;
			checkedItems.put(itemName, item);
		}
	}
	
	public int total() {
		for (String itemName : checkedItems.keySet()) {
			Item item = checkedItems.get(itemName);
			runningTotal += (item.count * item.price);
		}
		
		return runningTotal;
	}
	
	class Item {
		int count;
		int price;
	}
}