package com.revature.app;

import com.revature.util.ConnectionUtil;

public class ExploringHibernate {
	
	static ConnectionUtil util = ConnectionUtil.getInstance();
	
	public static void main(String[] args) {
		
	}
	
	static User save() {
		User u = new User();
		
		Session session = util.getSession();
		return u;
	}
}
