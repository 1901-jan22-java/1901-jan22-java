package com.revature.client;

public class Client {
	private String firstname;
	private String lastname;
	private String username;
	private int actualPassword; 
	
	public Client(String firstname, String lastname, String username, String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.actualPassword = generatePassword(password);
		
	}
	
	private static int generatePassword(String pass) {
		return pass.hashCode();
		
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
	
	
	public String toString() {
		return firstname + " " + lastname + ", " + username;
	}
	
	public static boolean checkPass(String pass, String test) {
		if((generatePassword(pass) + "").equals(test)) {
			return true;
		} 
		return false;
	}
	
	public String getName() {
		return this.username;
	}
}