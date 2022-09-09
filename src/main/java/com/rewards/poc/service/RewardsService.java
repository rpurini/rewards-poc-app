package com.rewards.poc.service;

import com.rewards.poc.domain.Customer;
import com.rewards.poc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardsService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public Customer fetchCustomer(Integer customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}
	public List<Customer> fetchAllCustomerRecords() {
		return customerRepository.findAll();
	}
}
