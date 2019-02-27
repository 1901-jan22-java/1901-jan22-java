package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserRepository {
	
	static ConnectionUtil util = ConnectionUtil.getInstance();

	public User get(int id) {
		Session session = util.getSession();
		Transaction tx = session.beginTransaction();
		User u = (User) session.get(User.class, id);
		session.close();
		return u;
	}

}
