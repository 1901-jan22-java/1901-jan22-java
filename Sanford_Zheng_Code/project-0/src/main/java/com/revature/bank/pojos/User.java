package com.revature.bank.pojos;

public class User {

	private String username;
	private String password;
	
	public User() {
		this.username = null;
		this.username = null;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/* Getters and Setters */
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

	/* Overrided Methods */
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
}