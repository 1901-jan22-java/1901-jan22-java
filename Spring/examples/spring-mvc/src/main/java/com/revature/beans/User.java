package com.revature.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
/*
 * Exploring JSR-303 (Bean validation)
 * - the specification of the Java API for JavaBean validation
 * - it provides an easy way of ensuring that the properties of 
 * your beans have the right values in them
 * 
 */
@Component
public class User {

	@Min(value=0)
	private int id;
	
	@NotNull(message="username is necessary")
	@Pattern(regexp="[a-z-A-Z]*", message="only include letters")
	private String username;
	
	private String password;
	
	@Size(min=5, max=300)
	private String bio;
	
	public User() {}
	
	public User(int id, String username, String password, String bio) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.bio = bio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", bio=" + bio + "]";
	}
}
