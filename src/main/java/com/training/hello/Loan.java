package com.training.hello;

import org.springframework.stereotype.Component;

@Component
public class Loan {
	public String applyLoan() {
		return "Your loan status has been approved";
	}
}
