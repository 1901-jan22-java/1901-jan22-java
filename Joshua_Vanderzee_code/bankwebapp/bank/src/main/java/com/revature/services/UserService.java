package com.revature.services;

import java.util.List;

import com.revature.dao.UserRepository;
import com.revature.pojos.User;

public class UserService {
	UserRepository userDao = new UserRepository();
	
	public List<User> getAllUsers(){
		return userDao.getALL();
	}
	
	public User getUserByUserId(int id){
		return userDao.getById(id);
	}
	
	public User getUserByUsername(String username){
		return userDao.getByUsername(username);
	}
	
	public User login(String username, String password) {
		User u = userDao.getByUsername(username);
		if (u == null) {
			return null;
		}
		else if (password.equals(u.getPassword())) {
			return u;
		}
		else {
			return null;
		}
	}
	
	public User Add(User u) {
		if (getUserByUsername(u.getUsername()) != null) {
			return null;
		}
		return userDao.saveUser(u.getUsername(), u.getPassword(), u.getFirstname(), u.getLastname());
	}
}
