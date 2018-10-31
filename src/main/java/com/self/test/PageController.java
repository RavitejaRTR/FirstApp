package com.self.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
	
	@GetMapping("/index")
	public String homepage(Model theModel) {
		PageVisitor thePageVisitor = new PageVisitor();
		
		theModel.addAttribute("pageVisitor", thePageVisitor);
		
		return "index";
	}
	
	@PostMapping("/index")
	public String storeVisitor(@ModelAttribute("pageVisitor") PageVisitor thePageVisitor,
						Model theModel) {
		
		System.out.println(thePageVisitor.getName());
		theModel.addAttribute("name","world");
		return "homepage";
	}
	
	@RequestMapping("/home")
	public String home(@RequestParam("name") Optional<String> name, Model model) {
		model.addAttribute("name", 
				name.isPresent()?name.get():"world");
		return "homepage";
	}
}
