package com.self.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PageVisitorDemo {

	public static void main(String[] args) {
		//Session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(PageVisitor.class)
				.buildSessionFactory();

		//Session variable
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			PageVisitor v = new PageVisitor("Raviteja", "test@gmail.com", 
					"8486513155", "Developer", "Trying to build this site");
			
			session.save(v);
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
		
	}

}
