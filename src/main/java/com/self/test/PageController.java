package com.self.test;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/")
	public String homepage() {
		return "index";
	}
	
	@RequestMapping("/home")
	public String home(@RequestParam("name") Optional<String> name, Model model) {
		model.addAttribute("name", 
				name.isPresent()?name.get():"world");
		return "homepage";
	}
}
