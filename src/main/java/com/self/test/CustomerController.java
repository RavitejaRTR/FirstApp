package com.self.test;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.self.test.model.Customer;
import com.self.test.service.CustomerService;
import com.self.test.service.CustomerServiceImpl;


@Controller
public class CustomerController {
	
	
	private CustomerService customerService;
	
	@Autowired(required=true)
	@Qualifier(value = "customerServiceImpl")
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping("/customers")
	public String customersList(Model theModel) {
		theModel.addAttribute("customers", this.customerService.listCustomers());
		System.out.println("Adding to model...");
		return "customers";
	}
	
	@RequestMapping("/customers/createCustomer")
	public String createCustomer(Model theModel) {
		System.out.println("Here");
		theModel.addAttribute("customer", new Customer());
		return "createCustomer";
	}
	
	@RequestMapping(value="/customers/save",method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer, Model theModel ) {
		customerService.addCustomer(theCustomer);
		return "redirect:/customers";
	}
	
}
