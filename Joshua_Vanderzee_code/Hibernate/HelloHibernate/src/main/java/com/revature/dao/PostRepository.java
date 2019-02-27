package com.revature.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Post;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class PostRepository {
	static ConnectionUtil util = ConnectionUtil.getInstance();
	public Post save(Post p) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(p);
			tx.commit();
			p.setId(id);
		} finally {
			session.close();
		}
		return p;
	}
	
	public static List<Post> getByAuthor(User u) {
		Session session = util.getSession();
		try {
			Query query = session.createQuery("from Post where Author_id = :user");
			query.setParameter("user", u.getId());
			return query.list();
		} finally {
			session.close();
		}
	}
	
	public List<Post> getEmptyPosts(){
		Session session = util.getSession();
		try {
			Query query = session.getNamedQuery("getEmptyPosts");
			return query.list();
		} finally {
			session.close();
		}
	}
}
