package com.revature.app;

import com.revature.dao.PostRepository;
import com.revature.dao.UserRepository;
import com.revature.models.Post;
import com.revature.models.User;

public class BlogApp {

	public static void main(String[] args) {
		PostRepository pDao = new PostRepository();
		UserRepository uDao = new UserRepository();
	
//		User u = uDao.get(1);
//		Post p = new Post("UnderStanding Hibernate",
//				"This is so cool!", u);
		
//	System.out.println(pDao.getByAuthor(u));
	
//	
//	    adding a follower
//		User me = uDao.get(2);
//		User other = uDao.get(3);
//        	uDao.follow(other, me);
        	
		
		//removing a follower
//    		User me = uDao.get(1);
//    		User other = uDao.get(3);
//            	uDao.unfollow(other, me);
		
		
		
		//find all followers
		
		//problem not returning all the followers just one
		User me = uDao.get(2);
		
		System.out.println(uDao.getFollowers(me));
		
		
		
		
	
		
	
	}
		
}