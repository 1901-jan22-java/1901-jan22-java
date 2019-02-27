package com.revature.dao;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserRepository {
	
	static ConnectionUtil util = ConnectionUtil.getInstance();
	final static Logger logger = Logger.getLogger(UserRepository.class);

	public User get(int id) {
		Session session = util.getSession();
		Transaction tx = session.beginTransaction();
		User u = (User) session.get(User.class, id);
		session.close();
		return u;
	}
	
	public void follow(User user, User following) {
		Session session = util.getSession();
		Transaction tx = session.beginTransaction();
		Set<User> follows = user.getFollowing();
		follows.add(following);
		session.merge(user); //but what if this was update!?
		tx.commit();
		session.close();
	}
	
	public void unfollow(User user, User unfollow) {
		Session session = util.getSession();
		Transaction tx = session.beginTransaction();
//		for(User f : follows) {
//			if(f.getId() == unfollow.getId()){
//				follows.remove(f);
//			}
//		}
		user.getFollowing().remove(unfollow);
		session.merge(user); //but what if this was update!?
		tx.commit();
		session.close();
	}
	
	public Set<User> getFollowers(User user){
		Session session = util.getSession();
		user = (User) session.get(User.class, user.getId());
		Set<User> followers = user.getFollowers();
		return followers;
	}

}
