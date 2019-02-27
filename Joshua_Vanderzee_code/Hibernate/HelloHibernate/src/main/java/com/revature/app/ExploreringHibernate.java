package com.revature.app;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.revature.models.TestMapping;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class ExploreringHibernate {
	static ConnectionUtil util = ConnectionUtil.getInstance();
	static Logger log = Logger.getLogger(ConnectionUtil.class);
	
	
	public static void main(String[] args) {
		List<User> u = findAllCriteria();
		u.stream().forEach(user -> System.out.println(user));
		pokeSave();
		
	}
	
	static User save() {
		User u = new User("Steve", "dbhgd");
		Session session = util.getSession();
		try {
			log.info("Opening session");
			Transaction tx = session.beginTransaction();
			int id = (Integer)session.save(u);
			log.info("About to commit");
			tx.commit();
			u.setId(id);
		} finally {
			log.info("About to close session");
			session.close();
			
		}
		return u;
	}
	
	static TestMapping pokeSave() {
		TestMapping poke = new TestMapping("Pikachu");
		Session session = util.getSession();
		try {
			log.info("Opening session");
			Transaction tx = session.beginTransaction();
			int id = (Integer)session.save(poke);
			log.info("About to commit");
			tx.commit();
			poke.setId(id);
		} finally {
			log.info("About to close session");
			session.close();
			
		}
		return poke;
	}
	
	public static void saveVSPersists() {
		User u = new User("djdfg", "ddfhdfhfdbhgd");
		u.setId(19851);
		Session session = util.getSession();
		Transaction tx = session.beginTransaction();
		session.persist(u);
		tx.commit();
	}
	
	static User get(int id) {
		Session session = util.getSession();
		User u = (User)session.get(User.class, id);
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
		return u;
	}
	
	static User getdemo(int id) {
		Session session = util.getSession();
		log.info("About to call get method");
		User u = (User)session.get(User.class, id);
		log.info("called get");
		u.setPassword("password");
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
		return u;
	}
	
	static User load(int id) {
		Session session = util.getSession();
		log.info("About to call get method");
		User u = (User)session.load(User.class, id);
		log.info("Just called session.load, about to call toString()");
		System.out.println(u.getId());
		session.close();
		return u;
	}
	
	static void update(User u) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(u);
			tx.commit();
		} finally {
			session.close();
		}
	}
	
	static void merge(User u) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.merge(u);
			tx.commit();
		} finally {
			session.close();
		}
		
	}
	
	public static User getUsername(String username) {
		User u = new User();
		Session session = util.getSession();
		Query query = session.createQuery("from User where lower(username) = :param");
		query.setParameter("param", username.toLowerCase());
		u = (User)query.uniqueResult();
		return u;
	}
	
	public static List<User> getAllUsernames() {
		Session session = util.getSession();
		try {
			Query query = session.createQuery("from User");
			return query.list();
		} finally {
			
		}
	}
	
	static List<User> findAllCriteria() {
		Session session = util.getSession();
		try {
			Criteria cr = session.createCriteria(User.class)
					.addOrder(Order.asc("username"))
					.add(Restrictions.ge("id", 60));
			
			return cr.list();
		} finally {
			session.close();		}
	}
}
