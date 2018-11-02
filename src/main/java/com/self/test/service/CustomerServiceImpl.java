package com.self.test.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.self.test.dao.CustomerDAO;
import com.self.test.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO customerDAO;

	public CustomerServiceImpl(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}
	
	@Override
	@Transactional
	public void addCustomer(Customer c) {
		this.customerDAO.addCustomer(c);
	}
	
	@Override
	@Transactional
	public void updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		this.customerDAO.updateCustomer(c);
	}
	
	@Override
	@Transactional
	public List<Customer> listCustomers() {
		return this.customerDAO.listCustomers();
	}
	
	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		return this.customerDAO.getCustomerById(id);
	}
	
	@Override
	public void deleteCustomer(int id) {
		this.customerDAO.deleteCustomer(id);
	}
}
