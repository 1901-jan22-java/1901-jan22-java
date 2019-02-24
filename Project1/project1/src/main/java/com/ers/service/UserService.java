package com.ers.service;

import java.util.List;

import com.jdbc.dao.UserRepository;
import com.jdbc.pojos.Users;

public class UserService {

UserRepository userDao = new UserRepository();
	
	
	public Users getByUsername(String username) {
		return userDao.getByUsername(username);
	}
	
	public Users login(String username, String password) {
		Users u = userDao.getByUsername(username);
		if(u == null) {
			return null;
		}
		else if(u.getPassword().equals(password)) {
			return u;
		} else {
			return null;
		}
	}
	
}
