package io.javabrains.springbootstarter.animalsActivities;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AnimalsActivitiesController {
	
	@Autowired
	private AnimalsActivitiesService animalsActivitiesService;
	
	@RequestMapping("/animals")
	public List<AnimalsActivities> getAllAnimalsActivities() {
		return animalsActivitiesService.getAllAnimalsActivities();
	}
	
	@RequestMapping("/animals/{name}")
	public Optional<AnimalsActivities> getAnimalsActivities(@PathVariable String name) {
		return animalsActivitiesService.getAnimalsActivities(name);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/animals")
	public AnimalsActivities addAnimalsActivities(@RequestBody AnimalsActivities animalsActivities) {
		return animalsActivitiesService.addAnimalsActivities(animalsActivities);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/animals/{name}")
	public void updateAnimalsActivities(@RequestBody AnimalsActivities animalsActivities, @PathVariable String name) {
		animalsActivitiesService.updateAnimalsActivities(name, animalsActivities);
	}

}


