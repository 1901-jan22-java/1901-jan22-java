package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Post;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserRepository {
	static ConnectionUtil util = ConnectionUtil.getInstance();
	

	
	public User get(int id) {
		Session session = util.getSession();
		User u = (User)session.get(User.class, id);
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
		return u;
	}
}
