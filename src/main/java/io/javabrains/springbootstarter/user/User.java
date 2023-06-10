package io.javabrains.springbootstarter.user;

import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profile")
public class User {
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//public Long id;
	@Id
	public String nickname;
	public String avatar;
	
	public User() {
		
	}
	
	public User(String nickname, String avatar) {
	    super();
		this.nickname = nickname;	
		this.avatar = avatar;
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
	

	
	

}

