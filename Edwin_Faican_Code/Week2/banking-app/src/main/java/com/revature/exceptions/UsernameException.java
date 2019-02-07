package com.revature.exceptions;

public class UsernameException extends Exception{
	public UsernameException(String name) {
		System.out.println("The chosen username: " + name + " is already taken. Try again.");
	}
}
