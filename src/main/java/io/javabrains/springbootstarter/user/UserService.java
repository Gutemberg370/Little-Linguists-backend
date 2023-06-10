package io.javabrains.springbootstarter.user;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRepositoryCustom userRepositoryCustom;
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public Optional<User> getUser(String name) {
		return userRepository.findByNickname(name);
	}
	
	public ResponseEntity<User> addUser(User user) {
		return userRepositoryCustom.createUser(user);
	}
	
	public void updateUser(String name, User user) {
		userRepository.save(user);
	}
	

}
