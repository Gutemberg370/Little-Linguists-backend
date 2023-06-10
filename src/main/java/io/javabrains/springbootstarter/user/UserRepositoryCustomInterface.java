package io.javabrains.springbootstarter.user;

import org.springframework.http.ResponseEntity;

public interface UserRepositoryCustomInterface{

	public ResponseEntity<User> createUser(User User);
}
