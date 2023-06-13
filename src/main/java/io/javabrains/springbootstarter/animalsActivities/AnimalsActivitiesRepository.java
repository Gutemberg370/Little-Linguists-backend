package io.javabrains.springbootstarter.animalsActivities;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface AnimalsActivitiesRepository extends JpaRepository<AnimalsActivities, String>{
	
	public Optional<AnimalsActivities> findByNickname(String nickname);

}
