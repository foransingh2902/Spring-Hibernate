package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// need to inject the customer DAO
	// @Autowired // Spring will scan for a component that implements CustomerDAO
	// interface
	// private CustomerDAO customerDAO;
	// need to inject customer service
	@Autowired
	private CustomerService customerService;

	// we removed this a now the service layer is in between

	// will send us over to list.jsp ......... will handle only incoming GET
	// requests
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
	// get customers from the dao
		// List<Customer> theCustomers = customerDAO.getCustomers();
		// get customers from service
		List<Customer> theCustomers = customerService.getCustomers();
	
	// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		// name="customers" value=theCustomers

		return "list-customers";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// will look for a suitable .jsp page with the name, due to our prefix and
		// suffix mapping
		// inside the 'view' folder
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer theCustomer) {
		// save the customer using our service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}

// the "customerId" is set in <c:url>
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		// get the customer from the service
		Customer theCustomer = customerService.getCustomer(theId);
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		// send over to our form
		return "customer-form";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int theId) {
		// customedId was set in the link on the page from where control is sent to this
		// one
		// delete the customer
		customerService.deleteCustomer(theId);

		return "redirect:/customer/list";

	}
	
	}


