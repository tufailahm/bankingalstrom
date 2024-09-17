package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Orders {

	@Autowired
	Customer customer;
	
	
	public String takeOrders() {
		
		return "Orders status :"+
		customer.payBill(9000)+ " "
				+ " :: Success";
	}
	
}
