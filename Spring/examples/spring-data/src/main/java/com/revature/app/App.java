package com.revature.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.User;
import com.revature.repository.UserRepository;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		UserRepository repo = (UserRepository) context.getBean(UserRepository.class);
		
		List<User> users = repo.findAllByUsernameContainingLike("[Tt]");
		
		System.out.println(users);
	}
}
