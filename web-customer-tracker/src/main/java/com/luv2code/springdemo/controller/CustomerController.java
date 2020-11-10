package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	// @RequestMapping("/list") // use this for all HTTP methods - like GET and POST
	@GetMapping("/list") // use this for only HTTP GET
	public String listCustomers(Model theModel) {
		
		System.out.println("BRAD!!!!!! just inside CustomerController::listCustomers()");
		
		// get customers from the dao
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		// add the retrieved customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	
	}

}
