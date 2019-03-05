package com.revature.app;

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
import com.revature.util.ConnectionUtil;

public class ExploringHibernate {

	static ConnectionUtil util = ConnectionUtil.getInstance();
	final static Logger logger = Logger.getLogger(ExploringHibernate.class);

	public static void main(String[] args) {

		savePokemon("Pikachu");
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
		User u = new User("Pooh Bear", "hibernates");

		Session session = util.getSession();
		try {
			logger.info("Just opened session");
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(u); //CALLING SAVE METHOD
			logger.info("Just called session.save()");
			//USER U IS NOW IN THE PERSISTENT STATE
			u.setPassword("test");
			u.setUsername("again");
			u.setPassword("more changes");
			u.setUsername("Tigger2"); //THIS WILL BE PERSISTED
			/*
			 * Hibernate leverages transactional write-behind
			 * and waits until the end of the session (session.close())
			 * to persist data once brought into the persistent state
			 */
			logger.info("about to commit");
			tx.commit();
			u.setId(id);
		}
		finally{
			logger.info("about to close session");
			session.close(); /*
			SESSION CLOSED, ALL OBJECTS ASSOCIATED WITH 
			THIS SESSION ARE NOW DETACHED
			 */
		}
		return u;
	}
	
	static void savePokemon(String name) {
		TestMapping poke = new TestMapping(name);
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(poke);
			tx.commit();
		}
		finally {
			session.close();
		}
	}

	/*
	 * The persist method is intended for adding a new entity 
	 * instance to the persistence context
	 * Close behavior to save(), except if we attempt to call 
	 * persist on a detached object, an exception will be thrown
	 */

	/* 
	 * Exception in thread "main" org.hibernate.PersistentObjectException: 
	 * detached entity passed to persist: com.revature.models.User
	 */
	static void saveVSpersist() {
		User u = new User("test123456", "user");
		u.setId(2); //testing this id;
		Session session = util.getSession();
		Transaction tx = session.beginTransaction();
		session.persist(u);
		tx.commit();
	}

	/*
	 * Session.get(id)
	 * - returns persisted object with specified identifier
	 * - if the object does not exist, the method will return null
	 * - method hits the database immediately, regardless of whether
	 * or not any methods are called on the object in the persistent state
	 * - use this method to retrieve data that we are not sure exists
	 */
	static User getDemo(int id) {
		Session session = util.getSession();
		Transaction tx = session.beginTransaction();
		logger.info("about to call get() method");
		User u = (User) session.get(User.class, id);
		logger.info("called get method, going to call method on User object");
		u.setPassword("CHANGED PASSWORD");
		tx.commit();
		session.close();
		return u;
	}
	static User get(int id) {
		Session session = util.getSession();
		Transaction tx = session.beginTransaction();
		User u = (User) session.get(User.class, id);
		session.close();
		return u;
	}


	/*
	 * Session.load(id)
	 * - retrieves a persisted instance by id. 
	 * - load will throw an ObjectNotFoundException if it attempts 
	 * to load a nonexistent row 
	 * - this method returns a PROXY of the object and does not 
	 * hit the database until a method of the object is called
	 * while the session is still open
	 * - If a method is called on a proxy, we see a LazyInitializationException
	 * - a proxy is a hibernate object that allows for lazy loading
	 * of data; it is basically a shell of an object that holds the 
	 * ID of it without any actual data from DB. Gets data when it 
	 * has a method called on it 
	 */
	static User load(int id) {
		Session session = util.getSession();
		User u = (User) session.load(User.class, id);
		logger.info("just called session.load(), about to call toString()");
		System.out.println(u.getId());
		session.close();
		return u;
	}

	/*
	 * session.update(Object)
	 * - acts upon method passed in (void return type)
	 * - transitions the object passed in as param from detached to persistent 
	 * - throws an exception if you pass it a transient entity
	 * - org.hibernate.StaleStateException: 
	 */
	static void update(User u) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(u);
			tx.commit();
		}finally {
			session.close();
		}
	}

	/*
	 * session.merge(Object)
	 * - main purpose of this method is to update a 
	 * persistent entity instance with new 
	 * fields from a detached entity instance 
	 * - if the entity is detached, it is copied upon an
	 * existing persistent entity (in practice, it's updated
	 * and brought into the persistent state)
	 * - if the entity is transient, the values are 
	 * copied to a newly persistent entity 
	 */
	static void merge(User u) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.merge(u);
			tx.commit();
		}finally {
			session.close();
		}
	}

	/*
	 * QUERY
	 * Write sql queries using HQL
	 */
	static User findByUsername(String username) {
		User u = null;
		Session session = util.getSession();
		Query query = session
				.createQuery("from User where lower(username) = :param");
		query.setParameter("param", username.toLowerCase());
		u = (User) query.uniqueResult();
		return u;
	}

	static List<User> findAll(){
		Session session = util.getSession();
		try {
			Query query = session.createQuery("from User");
			return query.list();
		}
		finally {
			logger.info("in finally block");
			session.close();
		}
	}
	
	static List<User> findAllCriteria(){
		Session session = util.getSession();
		try {
			Criteria criteria = session.createCriteria(User.class)
					.addOrder(Order.asc("username"))
					.add(Restrictions.ge("id", 4));
			
			return criteria.list();
		}
		finally {
			session.close();
		}
	}


}
