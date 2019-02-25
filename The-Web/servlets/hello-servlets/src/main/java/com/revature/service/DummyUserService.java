package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.servlets.User;

public class DummyUserService {
	

	static List<User> users = new ArrayList<User>();
	static {
		users.add(new User("gb", "123", "this is a user"));
		users.add(new User("test", "user", "test"));
		users.add(new User("Beyonce", "knowles", "is awesome"));
	}
	
	public List<User> getAllUser(){
		return users;
	}
	
	public void addUser(User u) {
		users.add(u);
	}

	public User getByUsername(String username){
		//want to get user by username that matches 
		//could loop through each user 
		// for(User u : users){
		// 	if(username.equalsIgnoreCase(u.getUsername())){
		// 		return u;
		// 	}
		// }

		return users.stream()
		.filter( user -> user.getUsername().equalsIgnoreCase(username))
		.findFirst()
		.orElse(null);
	}


}