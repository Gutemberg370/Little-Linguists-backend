package io.javabrains.springbootstarter.gamesPoints;

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
public class GamesPointsController {
	
	@Autowired
	private GamesPointsService gamesPointsService;
	
	@RequestMapping("/games")
	public List<GamesPoints> getAllGamesPoints() {
		return gamesPointsService.getAllGamesPoints();
	}
	
	@RequestMapping("/games/{gameName}/{username}")
	public List<GamesPoints> get3BestUsers(@PathVariable String gameName, @PathVariable String username) {
		return gamesPointsService.getAllGamesPointsByGame(gameName, username );
	}
	
	@RequestMapping("/games/{name}")
	public Optional<GamesPoints> getGamesPoints(@PathVariable String name) {
		return gamesPointsService.getGamesPoints(name);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/games")
	public GamesPoints addGamesPoints(@RequestBody GamesPoints gamesPoints) {
		return gamesPointsService.addGamesPoints(gamesPoints);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/games/{name}")
	public void updateGamesPoints(@RequestBody GamesPoints gamesPoints, @PathVariable String name) {
		gamesPointsService.updateGamesPoints(name, gamesPoints);
	}

}





