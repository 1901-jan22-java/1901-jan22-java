package com.revature.pojos;

public class User {
	private int id;
	private String username;
	private String password;
	private String fn;
	private String ln;
	private String email;
	private String role;
	
	
	public User() {}
	
	
	public User(int id, String fn, String ln) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
	}

	public User(int id, String fn, String ln, String role) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.role = role;
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
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


	

}
