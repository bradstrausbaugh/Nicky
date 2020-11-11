package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
    // inject our customer service
	@Autowired
	private CustomerService customerService;
	
	// @RequestMapping("/list") // use this for all HTTP methods - like GET and POST
	@GetMapping("/list") // use this for only HTTP GET
	public String listCustomers(Model theModel) {
		
		System.out.println("BRAD!!!!!! just inside CustomerController::listCustomers()");
		
		// get customers from the dao - now using a CustomerService instead of CustomerDAO
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add the retrieved customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	
	}
	
	@GetMapping("/showFormForAdd") // matches the OnClick for our Add Custumor button
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
		
	}

}
