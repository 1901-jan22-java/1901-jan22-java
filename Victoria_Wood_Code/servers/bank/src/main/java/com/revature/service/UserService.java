package com.revature.service;

import java.util.List;

import com.revature.dao.UserRepository;
import com.revature.pojos.User;

public class UserService {
	
	UserRepository userDao = new UserRepository();
	
	public List<User> getAllUsers(){
		return userDao.getAll();
	}
	
	public User getByUsername(String username) {
		return userDao.getByUsername(username);
	}
	
	public User getById(int id) {
		return userDao.getById(id);
	}
	
	public User login(String username, String password) {
		User u = userDao.getByUsername(username);
		if(u == null) {
			return null;
		} else if (u.getPassword().equals(password)) {
			return u;
		} else {
			return null;
		}
	}
	
	public User add(User u) {
		if(getByUsername(u.getusername())!= null) {
			return null; // user already exists
		}
		return userDao.addUser(u);
	}
}
