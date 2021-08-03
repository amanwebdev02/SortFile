package com.example.testing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.testing.*"})
public class TestApplication implements CommandLineRunner {


//Customer,
	//Product ,{ ProductType {GIFTCARD}, Seller}
	//SELLER { name}
	// Commision { UNITS{flatdiscount, percentage} , int  }
	//DiscountEngine { Seller , Discount}
	//Cart {List<Product>}

	public static void main(String[] args) {

		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//fileSortService.run();
	}
}
