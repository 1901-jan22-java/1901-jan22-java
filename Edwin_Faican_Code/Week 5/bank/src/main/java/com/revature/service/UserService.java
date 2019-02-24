package com.revature.service;

import java.util.List;

import com.jdbc.dao.UserRepository;
import com.revature.pojos.User;

public class UserService {
	
	UserRepository userDao = new UserRepository();
	
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	public User findById(int id) {
		return userDao.findByID(id);
	}
	
	public User findByUN(String username) {
		return userDao.findUserByUN(username);
	}
	
	public User login(String username, String pass) {
		User u = userDao.findUserByUN(username);
		if(u.getFirstname() == null) {
			return null;
		} else if(u.getPassword().equals(pass)) {
			return u;
		} else {
			return null;
		}
	}
	
	public User saveUser(User user) {
		return userDao.newUser(user);
	}
}
