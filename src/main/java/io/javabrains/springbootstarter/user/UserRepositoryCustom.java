package io.javabrains.springbootstarter.user;

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
	
	public ResponseEntity<User> createUser(User user) {
		
		User searchedUser = userRepository.findByName(user.getName()).orElse(null);
		
		
		if(searchedUser != null) {
	        return new ResponseEntity<>(
	        		searchedUser, 
	                HttpStatus.UNPROCESSABLE_ENTITY);
		}
		else {
			userRepository.save(user);
			return new ResponseEntity<User>(
					userRepository.save(user), 
	                HttpStatus.CREATED);
		}
		
	}

}
