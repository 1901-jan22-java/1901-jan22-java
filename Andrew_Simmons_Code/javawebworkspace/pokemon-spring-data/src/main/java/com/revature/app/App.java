package com.revature.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Team;
import com.revature.beans.Trainer;
import com.revature.repository.TeamRepository;
import com.revature.repository.TrainerRepository;

public class App {

	public static void main(String[] args) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		TrainerRepository repo = (TrainerRepository)
					context.getBean(TrainerRepository.class);
		
		
	
		List<Trainer> trainers = repo.findAll();	
		System.out.println(trainers);
		
		
		
		ApplicationContext context2 = new ClassPathXmlApplicationContext("beans.xml");
		TeamRepository repo2 = (TeamRepository)
					context2.getBean(TeamRepository.class);
		
		
		List<Team> teams = repo2.findAll();	
		System.out.println(teams);
		
		
	}

}
