package com.revature.app;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class ExploringHibernate {
	
	static ConnectionUtil util = ConnectionUtil.getInstance();
	final static Logger logger = Logger.getLogger(ExploringHibernate.class);
	
	public static void main(String[] args) {
		System.out.println(get(3));
		User u = new User("This is transsient", "t");
		merge(u);
		
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
	
	/*
	 * The persist method is intended for adding a new entity 
	 * instance to the persistence context
	 * Close behavior to save(), except if we attempt to call 
	 * persist on a detached object, an exception will be thrown
	 */
	
	//Exception in thread "main" org.hibernate.PersistentObjectException: detached entity passed to persist: com.revature.models.User
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
	static User get(int id) {
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
	
	
	/*
	 * Session.load(id)
	 * - retrieves a persisted instance by id. 
	 * - load will throw an ObjectNotFoundException if it attempts 
	 * to load a nonexistent row 
	 * - this method returns a PROXY of the object and does not 
	 * hit the database until a method of the object is called
	 * while the session is still open
	 * - a proxy is a hibernate object that allows for lazy loading
	 * of data; it is basically a shell of an object that holds the 
	 * ID of it without any actual data from DB. Gets data when it 
	 * has a method called on it 
	 */
	static User load(int id) {
		Session session = util.getSession();
		User u = (User) session.load(User.class, id);
		logger.info("just called session.load(), about to call toString");
		System.out.println(u.getId());
		session.close();
		return u;
	}
	/*
	 * session.update(Object)
	 * -acts upon mthod passed in (void retrun type)
	 * -transitions the object passed in as param from detached tp per
	 * throws an exception if you pass it a transient entitiy
	 * 
	 * session merge(Objec)
	 * -main purpose of this method is to update a 
	 * persistent entity 
	 * fields from a detacehd, it is coppied upon an 
	 * exsisting persistent entiy (in practice, its updated and brought into the persistent state)
	 * -if entity is transsietn, the vaules are coppied to a newley persistent entity
	 */
	static void update(User u) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(u);
			tx.commit();
		} 
		finally {
			session.close();		}
		}
	static void merge(User u) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.merge(u);
			tx.commit();
		} 
		finally {
			session.close();		}
		}

}
