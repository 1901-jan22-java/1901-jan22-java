package com.revature.service;

import com.revature.data.AssociateRepository;
import com.revature.pojos.Associate;

public class AssociateService {
	
	static AssociateRepository repo = new AssociateRepository();
	
	public Associate logIn(String email, String pw) {
		Associate a = new Associate();
		a = repo.getByEmail(email);
		if(a == null) return null;
		else {
			if(a.getPassword().equals(pw)) {
				return a;
			}
		}
		return null;
	}

}
