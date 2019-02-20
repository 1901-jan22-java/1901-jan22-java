package com.revature.service;

import java.util.List;

import com.revature.dao.UserRepository;
import com.revature.pojos.User;

public class UserService {

	UserRepository userDao = new UserRepository();
		
	public List<User> getAllUsers(){
		return userDao.getAll();
	}
}
