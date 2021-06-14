package com.databases2.rdbms.model;

public class FoodItem {
	String id; 
	String name;
	String price;
	int amount;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAmount() {
		return Integer.toString(amount);
	}
	public void setAmount(String amount) {
		this.amount = Integer.parseInt(amount);
	}


}