package com.databases2.rdbms.model;

public class OrderModel {
	int id; 
	int customerId;
	String orderType;

	public OrderModel(int id, String orderType, int customerId) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.orderType = orderType;
	}

	public String getId() {
		return Integer.toString(id);
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerId() {
		return Integer.toString(customerId);
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	

}
