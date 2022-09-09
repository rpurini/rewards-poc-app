package com.rewards.poc.controller;


import com.rewards.poc.domain.Customer;
import com.rewards.poc.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RewardsController {
	
	@Autowired
	private RewardsService rewardsService;

	@GetMapping("/customers")
	public List<Customer> findCustomerAll() {
		return rewardsService.fetchAllCustomerRecords();
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
		Customer customer = rewardsService.fetchCustomer(id);
		if (customer == null) return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	
}
