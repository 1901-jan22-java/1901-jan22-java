package com.revature.service;

import com.revature.dao.ReimbursementRepository;
import com.revature.pojos.User;

public class UserService {
	
	ReimbursementRepository dao = new ReimbursementRepository();
	
	public User logIn(String username, String password) {
		User u = dao.login(username, password);
		if(u == null) {
			return null;
		} else {
			return u;
		}
	}

}
