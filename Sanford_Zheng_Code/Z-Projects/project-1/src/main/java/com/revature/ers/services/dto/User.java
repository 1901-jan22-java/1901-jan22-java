package com.revature.ers.services.dto;

public class User {

	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private String role;

	public User() {
		super();
	}

	public User(String username, String password, String first_name, String last_name, String email, String role) {
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.role = role;
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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", first_name=" + first_name + ", last_name="
				+ last_name + ", email=" + email + ", role=" + role + "]";
	}

	public User clone() {
		return new User(this.username, this.password, this.first_name, this.last_name, this.email, this.role);
	}

	// Feels like dangerous behavior
//	public User(UserData ud, String role) {
//		super();
//		this.username = ud.getUsername();
//		this.password = ud.getPassword();
//		this.first_name = ud.getFirst_name();
//		this.last_name = ud.getLast_name();
//		this.email = ud.getEmail();
//		this.role = role;
//	}

}