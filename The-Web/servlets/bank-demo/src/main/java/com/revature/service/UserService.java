package com.revature.service;

import java.util.List;

import com.revature.dao.UserRepository;
import com.revature.pojos.User;

public class UserService {

	UserRepository userDao = new UserRepository();
		
	public List<User> getAllUsers(){
		return userDao.getAll();
	}
	
	public User getById(int id) {
		return userDao.getById(id);
	}
	
	public User getByUsername(String username) {
		return userDao.getByUsername(username);
	}
	
	public User login(String username, String password) {
		User u = userDao.getByUsername(username);
		if(u == null) {
			//no user with this username exists
			return null;
		}
		else if(u.getPassword().equals(password)) {
			return u; //success
		}
		else {
			return null;
		}
	}
	
	public User add(User u) {
		if(getByUsername(u.getUsername())!= null) {
			return null; //user exists by username
		}
		return userDao.addUser(u);
	}
}