package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.User;

@Service
public class UserService {
	
	private static ArrayList<User> users = new ArrayList<User>();
	private static int lastId = 3;
	
	static {
		users.add(new User(1, "John", "123", "Jockey"));
		users.add(new User(2, "Curtis", "123", "Cook"));
		users.add(new User(3, "Alice", "123", "Ace-Fighter-Pilot???"));
	}
	
	public List<User> getAll(){
		return users;
	}
	
	public User getById(int id) {
		return users.stream().filter(u -> u.getId()==id).findFirst().orElse(null);
	}
	
	public User save(User u) {
		u.setId(++lastId);
		users.add(u);
		return u;
	}
	
	public void update(User u) {
		User removed = getById(u.getId());
		users.remove(removed);
		users.add(u);
	}
	
	public User delete(User u) {
		return null;
	}
	
}
