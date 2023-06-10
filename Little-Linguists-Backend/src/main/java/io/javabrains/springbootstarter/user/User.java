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
	public String name;
	
	public User() {
		
	}
	
	public User(String name) {
	    super();
		this.name = name;	
	}
	
	public User(Long id, String name) {
		super();
		//this.id = id;
		this.name = name;
	}
	
	
	//public Long getId() {
	//	return id;
	//}


	//public void setId(Long id) {
	//	this.id = id;
	//}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

	
	

}

