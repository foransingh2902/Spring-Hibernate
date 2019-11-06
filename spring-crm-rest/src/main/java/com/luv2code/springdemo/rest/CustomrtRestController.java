package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomrtRestController {
	// auto wire the CustomerService
	@Autowired
	private CustomerService customerService;

	// add mapping for GET/customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	// add a mapping for GET /customers/{customerId}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		// if customer id is not found in database, .getCustomer returns null
		Customer theCustomer = customerService.getCustomer(customerId);
		// for null objects, Jackson returns empty body
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found-" + customerId);
		}
		return theCustomer;
	}

	// add mapping for POST/customers -add new customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		// also just in case the pass an id in JSON... set id to 0
		// this is force a save of new item.. instead of update
		theCustomer.setId(0);
		// if Id is 0, then DAO will "INSERT" new customer
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}

	// add mapping for PUT/customers - update existing customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}

	// add mapping for DELETE/customers - delete exicting customer
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		Customer tempCustomer = customerService.getCustomer(customerId);
		// throw an exception if null value returned
		customerService.deleteCustomer(customerId);
		if (tempCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found-" + customerId);
		}
		return "Deleted customer id -" + customerId;
	}

}
