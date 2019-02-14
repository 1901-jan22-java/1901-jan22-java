package com.revature.pojos;

public class User {
	private String Username;
	private String password;
	private String data;
	public User() {}
	public User(String username, String password, String data) {
		super();
		Username = username;
		this.password = password;
		this.data = data;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
