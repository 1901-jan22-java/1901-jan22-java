package com.revature.users;

public class User {
	private int userId;
	private String username;
	private int password;
	private String firstname;
	private String lastname;
	private String email;
	private int role;

	public User() {}

	public User(int userId, String username, String password, String firstname, String lastname, String email, int role) {
		this.userId = userId;
		this.username = username;
		this.password = generatePassword(password);
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
	}

	private static int generatePassword(String password) {
		return password.hashCode();
	}

	//Check if passwords are identical. Generate a password for any String input. 
	public static boolean checkPass(String pass, int test) {
		if(generatePassword(pass) == test) {
			return true;
		} 
		return false;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	};
	
	public String toString() {
		return "User: " + firstname + " "  + lastname;
	}

}
