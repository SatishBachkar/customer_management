package com.customer.customermanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.customer.customermanagement.entity.Customer;
import com.customer.customermanagement.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping("/save")
	String saveCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
		
	}
	
	@GetMapping("/get/{id}")
	Customer getCustomer(@PathVariable (value = "id") int id) {
		return service.getCustomerById(id);
		
	}
	
	@DeleteMapping(path = "/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id)
    {
        boolean delete = service.deleteCustomer(id);
        return "deleted";
    }

    @PutMapping(path = "/update")
 
    public String updateCustomer(@RequestBody Customer customer)
    {
        String id = service.updateCustomer(customer);
        return id;
    }
    
    @GetMapping("/getAll")
	List<Customer> getAllCustomer() {
		return service.getAllCustomers();
		
	}

	/*
	 * @PostMapping("/save") ResponseEntity<String> saveCustomer(@RequestBody
	 * Customer customer) { return new
	 * ResponseEntity<String>(service.addCustomer(customer), HttpStatus.CREATED);
	 * 
	 * }
	 */
	
	/*
	 * @GetMapping("/get{id}") ResponseEntity<Customer> getCustomer(@PathVariable
	 * int id) { return new ResponseEntity<Customer>(service.getCustomerById(id),
	 * HttpStatus.ACCEPTED);
	 * 
	 * }
	 */
	
	/*
	 * @DeleteMapping("/delete/{id}") ResponseEntity<String>
	 * deleteCustomer(@PathVariable int id) { return new
	 * ResponseEntity<String>(service.deleteById(id), HttpStatus.ACCEPTED);
	 * 
	 * }
	 */
	
	/*
	 * @PutMapping("/update") ResponseEntity<String> updateCustomer( Customer
	 * customer) { return new ResponseEntity<String>
	 * (service.updateCustomer(customer), HttpStatus.OK);
	 * 
	 * }
	 */
	
	

}
