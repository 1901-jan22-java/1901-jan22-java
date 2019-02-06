package com.revature.client;

import org.apache.log4j.Logger;

import com.revature.app.App;

public class Client {
	private int clientId;
	private String firstname;
	private String lastname;
	private String username;
	private int actualPassword; 
	
	final static Logger logger = Logger.getLogger(Client.class);
	
	public Client() {};
	
	public Client(int clientId, String firstname, String lastname, String username, String password) {
		this.clientId = clientId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.actualPassword = generatePassword(password);
		
	}
	
	//Passwords are hashed simply. This allows at least some security though not ideal since it is general java hashCode.
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getPassword() {
		return actualPassword;
	}

	public void setPassword(int actualPassword) {
		this.actualPassword = actualPassword;
	}
	
	public void setPassword(String pass) {
		this.actualPassword = generatePassword(pass);
	}
	
	public String toString() {
		return firstname + " " + lastname + ", " + username;
	}
	
	//Check if passwords are identical. Generate a password for any String input. 
	public static boolean checkPass(String pass, int test) {
		if(generatePassword(pass) == test) {
			return true;
		} 
		return false;
	}
}