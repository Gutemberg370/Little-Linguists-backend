package io.javabrains.springbootstarter.gamesPoints;

import io.javabrains.springbootstarter.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "gamespoints")
public class GamesPoints {
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//public Long id;
	@Id
	public String nickname;
	
	@Column(name = "cardgamepoints")
	public int cardGamePoints;
	@Column(name = "memorygamepoints")
	public int memoryGamePoints;
	@Column(name = "hangmangamepoints")
	public int hangmanGamePoints;
	@Column(name = "puzzlegamepoints")
	public int puzzleGamePoints;
	
	@Transient
	public int classification;
	

	@OneToOne
    @MapsId
    @JoinColumn()
    private User user;
	
	public GamesPoints() {
		
	}
	
	public GamesPoints(String nickname, int cardGamePoints, int memoryGamePoints, int hangmanGamePoints,
			int puzzleGamePoints, int classification, User user) {
		super();
		this.nickname = nickname;
		this.cardGamePoints = cardGamePoints;
		this.memoryGamePoints = memoryGamePoints;
		this.hangmanGamePoints = hangmanGamePoints;
		this.puzzleGamePoints = puzzleGamePoints;
		this.classification = classification;
		this.user = user;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getCardGamePoints() {
		return cardGamePoints;
	}

	public void setCardGamePoints(int cardGamePoints) {
		this.cardGamePoints = cardGamePoints;
	}

	public int getMemoryGamePoints() {
		return memoryGamePoints;
	}

	public void setMemoryGamePoints(int memoryGamePoints) {
		this.memoryGamePoints = memoryGamePoints;
	}

	public int getHangmanGamePoints() {
		return hangmanGamePoints;
	}

	public void setHangmanGamePoints(int hangmanGamePoints) {
		this.hangmanGamePoints = hangmanGamePoints;
	}

	public int getPuzzleGamePoints() {
		return puzzleGamePoints;
	}

	public void setPuzzleGamePoints(int puzzleGamePoints) {
		this.puzzleGamePoints = puzzleGamePoints;
	}
	
	public int getClassification() {
		return classification;
	}

	public void setClassification(int classification) {
		this.classification = classification;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		this.nickname = user.getNickname();
	}

}


