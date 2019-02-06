package com.ravature.bank.pojos;

public class User {
	
	private int user_Id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public User(){}
	
	public User(int user_Id, String firstName, String lastName, String username,String password) {
		super();
		this.user_Id = user_Id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUserId(int userId) {
		this.user_Id = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	@Override
	public String toString() {
		return "User [userId=" + user_Id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password=" + password + "]";
	}

}