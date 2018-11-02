package com.self.test.service;

import java.util.List;

import com.self.test.model.Customer;

public interface CustomerService {
	public void addCustomer(Customer c);
	public void updateCustomer(Customer c);
	public List<Customer> listCustomers();
	public void deleteCustomer(int id);
	public Customer getCustomerById(int id);
}
