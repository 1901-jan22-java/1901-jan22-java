package com.revature.servlets.pojos;

@SuppressWarnings("unused")
public class User {
	
	private String username;
	private String password;
	private String data;
	
	public User(String username, String password, String data) {
		super();
		this.username = username;
		this.password = password;
		this.data = data;
	}
	
}
