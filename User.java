package com.jdbc.pojos;


public class User {
	
	private int userID;
	private String fn;
	private String ln;
	private String username;
	private String pwd;
	
	public User() {}
	
	public User(int userID, String fn, String ln, String username) {
		super();
		this.userID = userID;
		this.fn = fn;
		this.ln = ln;
		this.username = username;

	}

	public int getUserId() {
		return userID;
	}

	public void setUserId(int userId) {
		this.userID= userId;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLastName(String ln) {
		this.ln = ln;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPassword(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User [userId=" + userID + ", firstName=" + fn + ", lastName=" + ln + 
				", username=" + username + ", password=" + pwd + "]";
	}

}