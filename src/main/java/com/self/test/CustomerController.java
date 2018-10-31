package com.self.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@RequestMapping("")
	public String customersList() {
		return "customers";
	}
	
}
