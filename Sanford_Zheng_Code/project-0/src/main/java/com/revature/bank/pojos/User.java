package com.revature.bank.pojos;

public class User {

	private Integer userID;
	private String username;
	private String password;

	/* Constructors */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public User(Integer userID, String username, String password) {
		this.userID = userID;
		this.username = username;
		this.password = password;
	}
	/* Overrided Methods */
	@Override
	public String toString() {
		return "User{" +
				"userID=" + userID +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}

	/* Getters and Setters */
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
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

}
