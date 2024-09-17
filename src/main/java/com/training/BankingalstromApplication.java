package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.hello.Loan;

@SpringBootApplication
// same package and child packages
@RestController
@EnableCaching
@EnableDiscoveryClient
public class BankingalstromApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankingalstromApplication.class, args);
	}

	@Autowired
	Orders orders;

	@RequestMapping("/displayOrders") // localhost:9090/displayOrders
	public String orders() {
		System.out.println("orders called");
		return orders.takeOrders();
	}

	@Autowired
	Loan loan;

	@RequestMapping("/loanstatus") // localhost:9090/loanstatus
	public String loan() {
		return loan.applyLoan();
	}

}
