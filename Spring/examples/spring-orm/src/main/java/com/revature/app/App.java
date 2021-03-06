package com.revature.app;

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
		
		User u = repo.getById(2);
		System.out.println(u);
	}

}
