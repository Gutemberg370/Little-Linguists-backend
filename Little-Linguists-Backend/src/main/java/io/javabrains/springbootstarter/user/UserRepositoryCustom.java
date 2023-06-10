package io.javabrains.springbootstarter.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryCustom implements UserRepositoryCustomInterface{
	
	@Autowired
	@Lazy
	private UserRepository userRepository;
	
	public ResponseEntity<String> createUser(User user) {
		
		User searchedUser = userRepository.findByName(user.getName()).orElse(null);
		
		
		if(searchedUser != null) {
	        return new ResponseEntity<>(
	                "Name already registered.", 
	                HttpStatus.UNPROCESSABLE_ENTITY);
		}
		else {
			userRepository.save(user);
			return new ResponseEntity<>(
	                "Name created sucessfully.", 
	                HttpStatus.OK);
		}
		
	}

}
