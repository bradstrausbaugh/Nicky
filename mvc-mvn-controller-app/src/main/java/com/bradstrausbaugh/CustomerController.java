package com.bradstrausbaugh;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		System.out.println("CustomerController::showForm(...)");
		theModel.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) {
		
		System.out.println("CustomerController::processForm(..)");
		System.out.println("- Customer Last Name: [" + theCustomer.getLastName() + "]");
		if (theBindingResult.hasErrors())
			return "customer-form";
		else {
			return "customer-confirmation";
		}
	}
	
	// advanced Spring to pre-process all incoming Strings
	// - here, to make all-whitespace Strings null so as to be invalide which they really are
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {
		
		// from the Spring API - "true" means down to null
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		// apply this to all incoming form Strings
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
	}
}
