package com.customer.customermanagement.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customer.customermanagement.entity.Customer;
import com.customer.customermanagement.exception.CustomerNotFoundException;
import com.customer.customermanagement.repository.CustomerRepository;
import com.customer.customermanagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository repo;
	
	@Override
	public String addCustomer(Customer customer) {
		repo.save(customer);
		return "Customer Added Successfully!";
	}

	@Override
	public Customer getCustomerById(int id) {
		return repo.findById(id).orElseThrow(
				()-> new CustomerNotFoundException("Customer Not Found"));
	
	}
	
	 @Override
	    public boolean deleteCustomer(int id) {
	 
	        if(repo.existsById(id))
	        {
	            repo.deleteById(id);
	        }
	        else
	        {
	            System.out.println("customer id not found");
	        }
	 
	        return true;
	    }

	@Override
	public String updateCustomer(Customer customer) {
		Customer customer1 = new Customer();
		if(repo.existsById(customer.getCustId())) {
			 customer1 = repo.findById(customer.getCustId()).orElseThrow(
					()-> new CustomerNotFoundException("Customer Not Found"));
	    customer1.setCustName(customer.getCustName());
	    customer1.setCustAddress(customer.getCustAddress());
	    customer1.setEmail(customer.getEmail());
	    customer1.setPassword(customer.getPassword());
		customer1.setPhoneNumber(customer.getPhoneNumber());
		
		repo.save(customer1);
		}else {
			System.out.println("Customer Id Doesn't Exist");
		}
		return "Customer updated" ;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

}
