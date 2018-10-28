package com.self.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateTest {

	public static void main(String[] args) {
		
		//Session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Visitor.class)
										.buildSessionFactory();
		
		//Session variable
		Session session = factory.getCurrentSession();
		
		try {
			//create Visitor object
			Visitor visitor = new Visitor("Raviteja Reddy", "tejareddy1004@gmail.com");
			
			session.beginTransaction();
			
			session.save(visitor);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
