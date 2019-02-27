package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;


import com.revature.models.Post;
import com.revature.util.ConnectionUtil;

public class PostRepository {
	static ConnectionUtil Util = ConnectionUtil.getInstance();
	
	public Post save(Post p) {
		Session session = Util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(p);
		}
		finally{
			
		}
		return p;
	}
	
}
