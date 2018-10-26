package com.self.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
	
	String url = "jdbc:mysql://localhost:3306/world?useSSL=false";
	String user = "root";
	String pswd = "admin";
	
	@RequestMapping("/")
	public String homepage() {
		
		try {
			
			System.out.println("Trying to connect to COuntry database");
			Connection myConn = 
					DriverManager.getConnection(url, user, pswd);
			System.out.println("Connection successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@RequestMapping("/home")
	public String home(@RequestParam("name") Optional<String> name, Model model) {
		model.addAttribute("name", 
				name.isPresent()?name.get():"world");
		return "homepage";
	}
}
