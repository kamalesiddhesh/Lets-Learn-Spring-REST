package in.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.api.exception.CustomerNotFoundException;

@RestController
public class CustomerRestController {
	
	@GetMapping("/customer/{customerId}")
	public String getCustomer(@PathVariable Integer customerId) throws Exception {
		
		if(customerId >= 100) {
			return "John";
		}
		else {
			throw new CustomerNotFoundException("Invalid Customer ID");
		}
		
	}
	

}
