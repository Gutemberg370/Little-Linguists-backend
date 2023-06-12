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
			int[] classifications = {1,2,3,4};
			GamesPoints user = gamesPointsRepository.findByNickname(nickname).orElse(null);
			
			classifications[3] = findUserClassification(columnName, user);
			
			first3ElementsList.add(user);
			
			matchClassification(first3ElementsList, classifications);
			
			return first3ElementsList;
		}
		
		for(int i = 0; i < gamesPoints.size(); i++) {
			gamesPoints.get(i).setClassification(i+1);
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
		gamesPoints = seeFieldsToSave(gamesPoints);
		return gamesPointsRepository.save(gamesPoints);
	}
	
	public GamesPoints seeFieldsToSave(GamesPoints objectToSave) {
		
		GamesPoints objectInBank = gamesPointsRepository.findByNickname(objectToSave.getUser().getNickname()).orElse(null);
		
		if(objectToSave.getCardGamePoints() < objectInBank.getCardGamePoints()) {
			objectToSave.setCardGamePoints(objectInBank.getCardGamePoints());
		}
		
		if(objectToSave.getHangmanGamePoints() < objectInBank.getHangmanGamePoints()) {
			objectToSave.setHangmanGamePoints(objectInBank.getHangmanGamePoints());
		}
		
		if(objectToSave.getMemoryGamePoints() < objectInBank.getMemoryGamePoints()) {
			objectToSave.setMemoryGamePoints(objectInBank.getMemoryGamePoints());
		}
		
		if(objectToSave.getPuzzleGamePoints() < objectInBank.getPuzzleGamePoints()) {
			objectToSave.setPuzzleGamePoints(objectInBank.getPuzzleGamePoints());
		}
		
		return objectToSave;
		
   }
	
	public int findUserClassification(String columnName, GamesPoints userPontuation) {
		
		List<GamesPoints> allPontuations = gamesPointsRepository.findAll(Sort.by(Sort.Direction.DESC, columnName));		
		GamesPoints individualPontuation = allPontuations.get(0);		
		int classification = 1;
		
		
		while(individualPontuation.getUser().getNickname() != userPontuation.getUser().getNickname()) {
			classification = classification + 1;
			individualPontuation = allPontuations.get(classification-1);
		}
		
		return classification;
	}
	
	public void matchClassification(List<GamesPoints> listOfPontuations, int[] listOfClassifications) {
		
		for(int i = 0; i < listOfClassifications.length; i++) {
			listOfPontuations.get(i).setClassification(listOfClassifications[i]);
		}
		
	}

}