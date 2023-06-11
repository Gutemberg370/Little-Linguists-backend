package io.javabrains.springbootstarter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import io.javabrains.springbootstarter.gamesPoints.GamesPoints;
import io.javabrains.springbootstarter.gamesPoints.GamesPointsRepository;

@Repository
public class UserRepositoryCustom implements UserRepositoryCustomInterface{
	
	@Autowired
	@Lazy
	private UserRepository userRepository;
	
	@Autowired
	@Lazy
	private GamesPointsRepository gamesPointsRepository;
	
	public ResponseEntity<User> createUser(User user) {
		
		User searchedUser = userRepository.findByNickname(user.getNickname()).orElse(null);
		
		
		if(searchedUser != null) {
	        return new ResponseEntity<>(
	        		searchedUser, 
	                HttpStatus.UNPROCESSABLE_ENTITY);
		}
		else {
			GamesPoints gamesPointsRegister = new GamesPoints();
			userRepository.save(user);
			gamesPointsRegister.setUser(user);
			gamesPointsRepository.save(gamesPointsRegister);
			return new ResponseEntity<User>(
					userRepository.save(user), 
	                HttpStatus.CREATED);
		}
		
	}

}
