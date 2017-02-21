package com.online_shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_shop.model.Customer;
import com.online_shop.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

	public Customer getCustomerById(long id) {
		Customer customer = customerRepository.findByCustomerId(id);
		return customer;
	}

}
