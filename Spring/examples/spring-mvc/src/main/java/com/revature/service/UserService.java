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
		users.add(new User(1, "Genesis", "123", "awesome trainer"));
		users.add(new User(2, "Kevin", "321", "poopface"));
		users.add(new User(3, "Yen sid", "disney", "keyblade"));
	}
	
	public List<User> getAll() {
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
	
	public User update(User u) {
//		User temp = getById(u.getId());
		return null;
	}
	
	public User delete(int id) {
		return null;
	}
}
