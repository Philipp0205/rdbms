package com.databases2.rdbms.model;

public class Customer {
	int id; 
	String name;
	String phone;
	String feedback;
	
	public Customer(int id, String name, String phone, String feedback) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.feedback = feedback;
	}
	
	
	public String getId() {
		return Integer.toString(id);
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	


}
