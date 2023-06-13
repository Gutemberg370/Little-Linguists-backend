package io.javabrains.springbootstarter.gamesPoints;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesPointsRepository extends JpaRepository<GamesPoints, String>{

	public Optional<GamesPoints> findByNickname(String nickname);
	
    public List<GamesPoints> findByOrderByCardGamePointsDesc();
}