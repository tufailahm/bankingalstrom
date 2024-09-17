package com.training;

import org.springframework.stereotype.Component;

@Component			//bean		Customer customer = new Customer();
public class Customer {
	private int amount;
	public Customer() {
		amount=999;
	}
	public Customer(int amount) {
		this.amount=amount;
	}
	public String payBill(int amount) {
		this.amount  = amount;
		return "Customer pays the bill amount :"+amount;
	}
	
	
	public void checkout() {
		System.out.println("Customer checkout with final bill  :"+amount);
	}
	
	
}
