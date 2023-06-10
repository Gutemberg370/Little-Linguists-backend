package io.javabrains.springbootstarter.user;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping("/users/{name}")
	public Optional<User> getUser(@PathVariable String name) {
		return userService.getUser(name);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/users")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/users/{name}")
	public void updateUser(@RequestBody User user, @PathVariable String name) {
		userService.updateUser(name, user);
	}
	
}
