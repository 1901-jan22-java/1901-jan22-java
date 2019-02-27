package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Post;
import com.revature.util.ConnectionUtil;

public class PostRepository {
	
	static ConnectionUtil util = ConnectionUtil.getInstance();

	
	public Post save(Post p) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(p);
			tx.commit();
			p.setId(id);
		}
		finally {
			session.close();
		}
		return p;
	}
}
