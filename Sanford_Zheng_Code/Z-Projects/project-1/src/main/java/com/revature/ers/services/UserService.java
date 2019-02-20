package com.revature.ers.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.ers.dao.UserRepository;
import com.revature.ers.dao.UserRoleRepository;
import com.revature.ers.dao.dto.User;
import com.revature.ers.dao.pojos.UserData;
import com.revature.ers.dao.pojos.UserRoleData;

public class UserService {
	
	private static final Logger log = Logger.getLogger(UserService.class);
	
	private static final UserRepository userRepo = new UserRepository();
	private static final UserRoleRepository roleRepo = new UserRoleRepository();
	
	private static final List<User> usersDTOs = new ArrayList<>();
	
	private static final HashMap<Integer, UserData> rawData = new HashMap<>();
	private static final HashMap<Integer, String > roles = new HashMap<>();
	
	static {
		loadDataImage();
		log.trace("UserService Class Initialized.");
	}

	public UserService() {
		loadDataImage();
		log.trace("UserService Object Instantiated.");
	}
	
	public static void loadDataImage() {
		for(UserData ud: userRepo.readAll())
			rawData.put(ud.getUser_id(), ud);
		for(UserRoleData urd: roleRepo.readAll())
			roles.put(urd.getRole_id(), urd.getUser_role());
	}
	
	public static HashMap<Integer, String> getRoles() {
		return roles;
	}
	
	public static List<User> getAllUsers() {
		return usersDTOs;
	}
	
	public static void addUser(User u) {
		usersDTOs.add(u);
	}
	
	public static User getByUsername(String un) {
		return usersDTOs.stream()
				.filter(user -> user.getUsername().equalsIgnoreCase(un))
				.findAny()
				.orElse(null);
	}
	
}
