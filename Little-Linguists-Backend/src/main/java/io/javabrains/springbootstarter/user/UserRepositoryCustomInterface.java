package io.javabrains.springbootstarter.user;

import org.springframework.http.ResponseEntity;

public interface UserRepositoryCustomInterface{

	public ResponseEntity<String> createUser(User User);
}
