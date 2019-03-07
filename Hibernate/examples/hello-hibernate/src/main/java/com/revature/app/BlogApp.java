package com.revature.app;

import java.util.Set;

import com.revature.dao.PostRepository;
import com.revature.dao.UserRepository;
import com.revature.models.User;

public class BlogApp {

	public static void main(String[] args) {
		PostRepository pDao = new PostRepository();
		UserRepository uDao = new UserRepository();
		
		User me = uDao.get(2);
		System.out.println(pDao.getByAuthor(me));
	}


}
