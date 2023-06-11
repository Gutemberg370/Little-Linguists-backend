package io.javabrains.springbootstarter.user;

import io.javabrains.springbootstarter.gamesPoints.GamesPoints;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "profile")
public class User {


	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//public Long id;
	@Id
	public String nickname;
	public String avatar;
	
	
    //@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    //@PrimaryKeyJoinColumn
    //private GamesPoints gamesPoints;
	
	public User() {
		
	}
	
	public User(String nickname, String avatar, GamesPoints gamesPoints) {
	    super();
		this.nickname = nickname;	
		this.avatar = avatar;
		//this.gamesPoints = gamesPoints;
	}
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	

	//public GamesPoints getGamesPoints() {
		//return gamesPoints;
	//}

	//public void setGamesPoints(GamesPoints gamesPoints) {
		//this.gamesPoints = gamesPoints;
		//this.gamesPoints.setUser(this);
	//}
	

}

