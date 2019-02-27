package com.revature.app;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.dao.PostRepository;
import com.revature.dao.UserRepository;
import com.revature.models.Post;
import com.revature.models.User;

public class BlogApp {
	public static void main(String[] args) {
		PostRepository pdao = new PostRepository();
		pdao.getByAuthor()
		
	}
	

}
