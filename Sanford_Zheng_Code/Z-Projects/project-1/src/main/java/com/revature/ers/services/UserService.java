package com.revature.ers.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.ers.services.dto.pojos.User;

public class UserService {
	static List<User> users = new ArrayList<>();

	static {
		
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
