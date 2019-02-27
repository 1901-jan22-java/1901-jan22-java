package com.revature.service;

import java.util.List;

import com.revature.dao.UserRepo;
import com.revature.pojos.User;

public class UserService {
	
	UserRepo userDao = new UserRepo();
	
	public List<User> getAllUsers(){
		return userDao.getAll();
	}

	public User getById(int id) {
		User u = userDao.getById(id);
		if(u == null || u.getId()<1 ) return null;
		return u;
	}
	
	public User getByUsername(String username) {
		User u = userDao.getByUsername(username);
		if(u == null || u.getId()<1 ) return null;
		return u;
	}
	
	public User login(String username, String password) {
		
		return null;
	}
}
