package com.self.test.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.self.test.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	private SessionFactory sessionFactory;
	
	public CustomerDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addCustomer(Customer c) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(c);
		System.out.println("Customer saved successfully");
	}
	
	@Override
	public void updateCustomer(Customer c) {
		Session session = sessionFactory.getCurrentSession();
		session.update(c);
		System.out.println("Customer updated successfully");
		return;
	}
	
	@Override
	public List<Customer> listCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Customer> customersList = session.createQuery("from Customer").list();
		System.out.println("customersList received");
		return customersList;
	}
	
	@Override
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer c = session.load(Customer.class, id);
		System.out.println("Customer details received for id : "+id);
		return c;
	}
	
	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer c = session.load(Customer.class, id);
		if(null != c)
			session.delete(c);
		return;
	}
	
}
