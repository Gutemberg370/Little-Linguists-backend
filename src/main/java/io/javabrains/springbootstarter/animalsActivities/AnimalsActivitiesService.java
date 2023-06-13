package io.javabrains.springbootstarter.animalsActivities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.user.UserRepository;

@Service
public class AnimalsActivitiesService {
	
	@Autowired
	private AnimalsActivitiesRepository animalsActivitiesRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<AnimalsActivities> getAllAnimalsActivities(){
		List<AnimalsActivities> animalsActivities = new ArrayList<>();
		animalsActivitiesRepository.findAll().forEach(animalsActivities::add);
		return animalsActivities;
	}
	
	
	public Optional<AnimalsActivities> getAnimalsActivities(String nickname) {
		return animalsActivitiesRepository.findByNickname(nickname);
	}
	
	public AnimalsActivities addAnimalsActivities(AnimalsActivities animalsActivities) {
		return animalsActivitiesRepository.save(animalsActivities);
	}
	
	public AnimalsActivities updateAnimalsActivities(String nickname, AnimalsActivities animalsActivities) {
		animalsActivities.setUser(userRepository.findByNickname(nickname).orElse(null));
		animalsActivities = seeFieldsToSave(animalsActivities);
		return animalsActivitiesRepository.save(animalsActivities);
	}
	
	public AnimalsActivities seeFieldsToSave(AnimalsActivities objectToSave) {
		
		AnimalsActivities objectInBank = animalsActivitiesRepository.findByNickname(objectToSave.getUser().getNickname()).orElse(null);
		
		if(objectToSave.getLatestActivityUnlocked() < objectInBank.getLatestActivityUnlocked()) {
			objectToSave.setLatestActivityUnlocked(objectInBank.getLatestActivityUnlocked());
		}
		
		if(objectToSave.getTotalStars() < objectInBank.getTotalStars()) {
			objectToSave.setTotalStars(objectInBank.getTotalStars());
		}
		
		if(objectToSave.getStarsInFirstActivity() < objectInBank.getStarsInFirstActivity()) {
			objectToSave.setStarsInFirstActivity(objectInBank.getStarsInFirstActivity());
		}
		
		if(objectToSave.getStarsInSecondActivity() < objectInBank.getStarsInSecondActivity()) {
			objectToSave.setStarsInSecondActivity(objectInBank.getStarsInSecondActivity());
		}
		
		if(objectToSave.getStarsInThirdActivity() < objectInBank.getStarsInThirdActivity()) {
			objectToSave.setStarsInThirdActivity(objectInBank.getStarsInThirdActivity());
		}
		
		return objectToSave;
		
   }

}



