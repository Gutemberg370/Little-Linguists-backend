package io.javabrains.springbootstarter.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>{
	
	public Optional<User> findByNickname(String nickname);
	

}

