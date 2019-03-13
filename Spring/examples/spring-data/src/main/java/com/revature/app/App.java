package com.revature.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.User;
import com.revature.repository.UserRepository;

public class App {

	public static void main(String[] args) {
		ApplicationContext context 
			= new ClassPathXmlApplicationContext("beans.xml");
		
		UserRepository repo = (UserRepository)
				context.getBean(UserRepository.class);
		
		List<User> users = repo.lengthQuery(5, 15);
		System.out.println(users);
		
	
//		System.out.println(repo.findByUsernameLikeIgnoreCase("test12345"));
//	
//		User u = new User("springData!", "testing");
//		
//		u = repo.save(u);
//		System.out.println(u);
	}

}
