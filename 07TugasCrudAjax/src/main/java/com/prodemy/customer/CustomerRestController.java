package com.prodemy.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		return new ResponseEntity<List<Customer>>(customerService.listAll(), HttpStatus.OK);
	}

	@RequestMapping("/customer/save")
	public ResponseEntity<Void> saveOrUpdateCustomer(@RequestBody Customer customer) {
		customerService.save(customer);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable long id) {
		return new ResponseEntity<Customer>(customerService.get(id), HttpStatus.OK);
	}

	@RequestMapping("/customer/delete/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable long id) {
		customerService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
