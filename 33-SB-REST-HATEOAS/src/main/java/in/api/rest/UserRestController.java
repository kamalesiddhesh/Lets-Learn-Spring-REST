package in.api.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import in.api.binding.User;

@RestController
public class UserRestController {
	
	@GetMapping("/user")
	public ResponseEntity<User> getUser(){
		
		User user = new User(101,"John","john@gmail.com");
		
		user.add(linkTo(methodOn(UserRestController.class).getUser()).withSelfRel());
		
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}

}
