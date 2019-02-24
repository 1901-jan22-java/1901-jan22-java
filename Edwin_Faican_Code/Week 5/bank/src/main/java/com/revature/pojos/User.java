package com.revature.pojos;

public class User {
	private int userId;
	private String firstname;
	private String lastname;
	private String pass;
	private String username;
	
	public User() {};
	
	public User(int userId, String firstname, String lastname, String pass, String username) {
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.pass = pass;
		this.username = username;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return pass;
	}
	public void setPassword(String password) {
		this.pass = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString() {
		return this.username + ": " + this.firstname + " " + this.lastname;
	}
}
