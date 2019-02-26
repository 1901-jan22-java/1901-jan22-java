package com.revature.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class ExploringHibernate {
	
	static ConnectionUtil util = ConnectionUtil.getInstance();
	
	public static void main(String[] args) {
		save();
	}
	
	/*
	 * SAVE
	 * - adds instance to db
	 * - persists transient instance, returns whatever Serializable
	 * identifier is used for the instance 
	 * - saving a persisted instance does nothing 
	 * - saving a detached instance creates a new persistant instance
	 * and assigns it a new identifier, which results in a duplicate
	 * record. do not do!
	 */
	static User save() {
		//currently in TRANSIENT state
		User u = new User("hibernateUser", "iLikeBears");
		
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(u);
			tx.commit();
			u.setId(id);
		}
		finally{
			session.close();
		}
		return u;
	}

}
