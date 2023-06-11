package io.javabrains.springbootstarter.gamesPoints;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.user.User;
import io.javabrains.springbootstarter.user.UserRepository;

@Service
public class GamesPointsService {
	
	@Autowired
	private GamesPointsRepository gamesPointsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<GamesPoints> getAllGamesPoints(){
		List<GamesPoints> gamesPoints = new ArrayList<>();
		gamesPointsRepository.findAll().forEach(gamesPoints::add);
		return gamesPoints;
	}
	
	public List<GamesPoints> getAllGamesPointsByGame(String columnName, String nickname){
		List<GamesPoints> gamesPoints = new ArrayList<>();
		gamesPointsRepository.findAll(Sort.by(Sort.Direction.DESC, columnName)).forEach(gamesPoints::add);
		if(gamesPoints.size() > 2) {
			List<GamesPoints> first3ElementsList = gamesPoints.stream().limit(3).collect(Collectors.toList());
			first3ElementsList.add(gamesPointsRepository.findByNickname(nickname).orElse(null));
			return first3ElementsList;
		}
		return gamesPoints;
	}
	
	public Optional<GamesPoints> getGamesPoints(String nickname) {
		return gamesPointsRepository.findByNickname(nickname);
	}
	
	public GamesPoints addGamesPoints(GamesPoints gamesPoints) {
		return gamesPointsRepository.save(gamesPoints);
	}
	
	public GamesPoints updateGamesPoints(String nickname, GamesPoints gamesPoints) {
		gamesPoints.setUser(userRepository.findByNickname(nickname).orElse(null));
		return gamesPointsRepository.save(gamesPoints);
	}

}