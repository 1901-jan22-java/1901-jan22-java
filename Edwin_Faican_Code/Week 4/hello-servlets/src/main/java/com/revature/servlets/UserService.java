package com.revature.servlets;

import java.util.ArrayList;
import java.util.List;

class UserService{
	static List<User> users = new ArrayList<User>();
	static {
		users.add(new User("gb", "123", "this is a user"));
		users.add(new User("test", "user", "test"));
		users.add(new User("Beyonce", "Knowles", "is awesome"));
	}
	
	public List<User> getAllUsers() {
		return users;
	}
	
	public void addUser(User u) {
		this.users.add(u);
	}

	public User getByUsername(String username) {
		for(User u : users) {
			if(username.equalsIgnoreCase(u.getUsername())) {
				return u;
			}
		}
		
		return users.stream().filter(user -> user.getUsername().equalsIgnoreCase(username)).findAny().orElse(null);
		
	}
}