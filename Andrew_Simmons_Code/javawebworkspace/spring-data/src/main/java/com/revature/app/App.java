package com.revature.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.User;
import com.revature.repository.UserRepository;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		UserRepository repo = (UserRepository)
					context.getBean(UserRepository.class);
		
//		Shows all our users
//		List<User> users = repo.findAll();
		
//		System.out.println(users);
		
	
//		User u = new User("Spring Data!" , "testing");
//		u = repo.save(u);
//		Above is a way for us to add a user and password
		
		
		
		
		

	}

}