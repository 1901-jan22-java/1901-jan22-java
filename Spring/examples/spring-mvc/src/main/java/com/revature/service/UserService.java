package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.User;

/*
 * @Service is a specialization of @Component
 * It can only be applied to classes
 * It is used to mark the class as a service provider
 */
@Service
public class UserService {
	
	/*
	 * This will be a "dummy" user service, 
	 * holding and manipulating in local memory
	 * data in order to explore MVC without 
	 * data persistence
	 */
	
	private static ArrayList<User> users = new ArrayList<User>();
	private static int lastId = 3;
	
	static {
		users.add(new User(1, "Genesis", "123", "awesome trainer!"));
		users.add(new User(2, "testUser", "pass", "testing"));
		users.add(new User(3, "other", "user", "user"));
	}
	
	public List<User> getAll(){
		return users;
	}
	
	public User getById(int id) {
		return users.stream().filter(u -> u.getId()==id).findFirst()
				.orElse(null);
	}
	
	public User save(User u) {
		u.setId(++lastId);
		users.add(u);
		return u;
	}
	
	public User update(User u) {
		return null;
	}
	
	public User delete(int id) {
		return null;
	}
}
