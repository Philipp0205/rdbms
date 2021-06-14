package com.databases2.rdbms.model;

public class OrderItem {
	int id; 
	int orderId;
	int fooId;
	int quantity;

	public OrderItem(int id, int orderId, int fooId, int quantity) {
		super();
		this.orderId = orderId;
		this.fooId = fooId;
		this.quantity = quantity;
	}

	public String getId() {
		return Integer.toString(id);
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderId() {
		return Integer.toString(orderId);
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getFooId() {
		return Integer.toString(fooId);
	}

	public void setFooId(int fooId) {
		this.fooId = fooId;
	}

	public String getQuantity() {
		return Integer.toString(quantity);
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
