package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Subscriber;
import com.example.demo.domain.SubscriberRepository;

@SpringBootApplication
public class H2demoApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2demoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(SubscriberRepository repository) {
		return args -> {
			repository.save(new Subscriber("Hey there","I am","a subscriber!"));
			System.out.println("I ran!");
		};
	}
	
	@Bean
	CommandLineRunner runner1(SubscriberRepository repository) {
		return args -> {
			repository.save(new Subscriber("Hey there","I am","a subscriber!"));
			System.out.println("I ran!");
		};
	}
	
	@Bean
	CommandLineRunner runner2(SubscriberRepository repository) {
		return args -> {
			repository.save(new Subscriber("Hey there","I am","a subscriber!"));
			System.out.println("I ran!");
		};
	}
	
	@Bean
	CommandLineRunner runner3(SubscriberRepository repository) {
		return args -> {
			repository.save(new Subscriber("Hey there","I am","a subscriber!"));
			System.out.println("I ran!");
		};
	}

}
