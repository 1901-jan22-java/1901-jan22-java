package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.services.pojos.User;

public class UserService {
	static List<User> users = new ArrayList<>();

	static {
		users.add(new User("gb1", "123", "this is a user"));
		users.add(new User("gb2", "123", "this is a user"));
		users.add(new User("gb3", "123", "this is a user"));
	}
	
	public List<User> getAllUsers() {
		return users;
	}
	
	public void addUser(User u) {
		users.add(u);
	}
	
	public User getByUsername(String un) {
		return users.stream()
				.filter(user -> user.getUsername().equalsIgnoreCase(un))
				.findAny()
				.orElse(null);
	}
	
}
