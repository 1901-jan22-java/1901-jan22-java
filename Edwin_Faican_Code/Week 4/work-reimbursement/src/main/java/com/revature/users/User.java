package com.revature.users;

public class User {
	private int userId;
	private String username;
	private String pass;
	private int aPassword;
	private String firstname;
	private String lastname;
	private String email;
	private String role;

	public User() {}

	public User(int userId, String username, String pass, String firstname, String lastname, String email, String role) {
		this.userId = userId;
		this.username = username;
		this.aPassword = generatePassword(pass);
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
	public String toString() {
		return "User: " + firstname + " "  + lastname;
	}

	public int getaPassword() {
		return aPassword;
	}

	public void setaPassword(int aPassword) {
		this.aPassword = aPassword;
	}
	
	public void setaPassword(String pass) {
		this.aPassword = generatePassword(pass);
	}

	
}
