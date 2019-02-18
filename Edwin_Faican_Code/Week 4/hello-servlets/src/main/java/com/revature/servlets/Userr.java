package com.revature.servlets;

public class Userr {
	private String username;
	private String password;
	private String data;

	
	
	public Userr(String username, String password, String data) {
		super();
		this.username = username;
		this.password = password;
		this.data = data;
	}
	
	public Userr() {};
	

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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
