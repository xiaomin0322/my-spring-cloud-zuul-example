package org.exampledriven.zuul.eureka.customer.shared.server.server.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.exampledriven.zuul.eureka.customer.shared.server.server.domain.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController()
public class CustomerController {
	private static Logger logger_ = LogManager.getLogger(CustomerController.class);
	private List<Customer> customers;

	public CustomerController() {
		customers = new LinkedList<>();
		customers.add(new Customer(1, "Peter", "Test"));
		customers.add(new Customer(2, "Peter", "Test2"));
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = "application/json")
	public Customer getCustomer(@PathVariable int id) {
		logger_.info("tracer.id {}",123);
		Optional<Customer> customer = customers.stream().filter(customer1 -> customer1.getId() == id).findFirst();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer.get();

	}

}