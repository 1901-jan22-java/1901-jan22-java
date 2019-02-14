package com.revature.servlets;

import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.User;

public class DummyUserService {
	static List<User> users = new ArrayList<User>();
	static {
		users.add(new User("bob", "as", "This is bob's data"));
		users.add(new User("steve", "as", "This is steve's data"));
	}
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public User getByUsername(String username) {
		return users.stream()
				.filter(user -> user.getUsername().equalsIgnoreCase(username)).findAny().orElse(null);
	}
	
	public void AddUser(User u) {
		users.add(u);
	}
}
