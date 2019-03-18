package com.revature.app;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class FirstLevelCache {
	
	static ConnectionUtil util = ConnectionUtil.getInstance();
	final static Logger logger = Logger.getLogger(FirstLevelCache.class);
	
	public static void main(String[] args) {
		
//		exploringL1();
		
	//	newSession();
		
		remove();
		
	}

	
	
	static void exploringL1() {
		
		//open our session
		Session session = util.getSession();
		Transaction tx = session.beginTransaction();
		//retrieve data
		
		User u = (User) session.get(User.class,  2);
		logger.info("Just retrieve user " + u.toString());
		
		//retrieve sam data. does Hibernate hit DB again?
		
		u = (User) session.get(User.class, 2);
		
		
		u.setUsername("Level 1 cache");
		session.update(u);
		logger.info("just updated our user.");
		
		u = (User) session.get(User.class, 2);
		
		
		tx.commit();
		session.close();
		
		
		
		
		
	}
	
	
	
	static void newSession() {
		
		Session session = util.getSession();
		Transaction tx = session.beginTransaction();
		
		//open multiple sessions
		Session s1 = util.getSession();
		Session s2 = util.getSession();
		
		//retrieve data
		User u = (User) s1.get(User.class, 2);
		
		logger.info("SESSION ONE: Just retrieve user " + u.toString());
		
		
		 u = (User) s2.get(User.class, 2);
		
		logger.info("SESSION 2: Just retrieve user " + u.toString());
		//session close
		tx.commit();
		session.close();
		
	}
	
	
	
	static void remove() {
		Session session = util.getSession();
		Transaction tx = session.beginTransaction();
		logger.info("about to retrieve user");
		User u = (User) session.get(User.class, 2);
		
		//remove object from session cache
		session.evict(u);
		logger.info("just evicted user from session cache. let's try retrieving it again");
		u = (User) session.get(User.class, 2);
		
		
		u.setUsername("is this object persistent still?");
		
		tx.commit();
		session.clear();
		u.setUsername("our object should be gone");
		
		
		
		session.close();
	}
	
}
