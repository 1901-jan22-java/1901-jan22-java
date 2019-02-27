package com.revature.app;

import com.revature.dao.PostRepository;
import com.revature.dao.UserRepository;
import com.revature.models.Post;
import com.revature.models.User;

public class BlogApp {

	public static void main(String[] args) {
		PostRepository pDao = new PostRepository();
		UserRepository uDao = new UserRepository();
	
		User u = uDao.get(2);
//		Post p = new Post("UnderStanding Hibernate",
//				"This is so cool!", u);
		
	System.out.println(pDao.getByAuthor(u));
	}
}
