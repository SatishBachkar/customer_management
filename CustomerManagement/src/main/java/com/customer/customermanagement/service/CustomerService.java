package com.customer.customermanagement.service;

import java.util.List;

import com.customer.customermanagement.entity.Customer;

public interface CustomerService {

	public String addCustomer(Customer customer);
	
	public Customer getCustomerById(int id);
	
	public boolean deleteCustomer(int id);
	
	public String updateCustomer(Customer customer);
	
	public List<Customer> getAllCustomers();
}
