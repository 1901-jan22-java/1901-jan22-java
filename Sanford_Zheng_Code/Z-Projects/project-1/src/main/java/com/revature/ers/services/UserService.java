package com.revature.ers.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.revature.ers.services.dto.pojos.User;

public class UserService {
	
	private static final Logger log = Logger.getLogger(UserService.class);
	
	private static final HashMap<Integer, String> roles = new HashMap<>();
	
	private static final List<User> users = new ArrayList<>();

	static {
		log.trace("UserService Class Initialized.");
	}

	/*
	 * There is no point in making this an instance object...
	 * unless it's multi-threaded :O
	 */
	public UserService() {
		log.trace("UserService Object Instantiated.");
	}
	
	public static HashMap<Integer, String> getRoles() {
		HashMap<Integer, String> clone = new HashMap<>();
		for (Entry<Integer, String> kv : roles.entrySet())
			clone.put(kv.getKey(), kv.getValue());
		return clone;
	}
	
	public static List<User> getAllUsers() {
		return users;
	}
	
	public static void addUser(User u) {
		users.add(u);
	}
	
	public static User getByUsername(String un) {
		return users.stream()
				.filter(user -> user.getUsername().equalsIgnoreCase(un))
				.findAny()
				.orElse(null);
	}
	
}
