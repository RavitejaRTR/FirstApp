package com.self.test;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
	
	private SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(PageVisitor.class)
			.buildSessionFactory();
	
	private Session session = factory.getCurrentSession();
	
	@RequestMapping("/")
	public String homepage(Model theModel) {
		PageVisitor thePageVisitor = new PageVisitor();
		
		theModel.addAttribute("pageVisitor", thePageVisitor);
		
		return "index";
	}
	
	@RequestMapping("/saveFormdata")
	public String storeVisitor(@ModelAttribute("pageVisitor") PageVisitor thePageVisitor,
						Model theModel) {
		System.out.println("Beginning transaction...");
		session.beginTransaction();
		System.out.println("Saving object...");
		session.save(thePageVisitor);
		System.out.println("Commiting to database...");
		session.getTransaction().commit();
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
