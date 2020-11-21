package com.luv2code.springdemo.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRESTController {

	//Autowire the customer service
	@Autowired
	private CustomerService customerService;
	
	//add mapping for GET /customers
	@GetMapping("/customers")
	private List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	//add mapping for GET /api/customer/{customerId}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if(theCustomer == null) {
			throw new CustomerNotFoundExeption("Customer with id - "+customerId+" not found!");
		}
		return theCustomer;
	}
	
	//add mapping for POST /api/customers
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		//also just incase they pass an id in JSON ..., set id to 0
		//this is for saving a new item instead of an update
		customer.setId(0);
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	//add mapping for PUT /api/customers
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		//update customer through the customer service
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	//add mapping for DELETE /api/customers/{customerId}
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		//add check to see if customer exits
		Customer customer = customerService.getCustomer(customerId);
		
		if(customer == null) {
			throw new CustomerNotFoundExeption("Customer with id - "+customerId+" not found!");
		}
		
		//delete customer using the customerDAO service
		customerService.deleteCustomer(customerId);
		
		return "Customer deleted - "+customerId;
	}
}

















