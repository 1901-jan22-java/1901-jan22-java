package com.revature.app;

import java.util.Scanner;

import com.revature.data.AssociateRepository;
import com.revature.pojos.Associate;
import com.revature.service.AssociateService;

public class App {
	static Scanner scan = new Scanner(System.in);
	static AssociateService service = new AssociateService();
	static int invalid = 0;
	
	public static void main(String[] args) {
		welcome();
	}

	static void welcome() {
		System.out.println("What would you like to do?"
				+ "\n1. Create new account"
				+ "\n2. Log in"
				+ "\n3. View Associate Statistics");
		String in = scan.nextLine();
		int op = 0;
		try {
			op = Integer.parseInt(in);
		}
		catch(NumberFormatException e) {
			System.out.println("You must enter a number: either 1, 2, or 3!");
			welcome();
			return;
		}
		switch(op) {
		case 1: createAccount(); break;
		case 2: logIn(); break;
		case 3: getStats(); break;
		default: System.out.println("You must enter a number: either 1, 2, or 3!"); welcome(); break;
		}
	}
	
	static void createAccount() {
		System.out.println("Welcome! Enter your email address");
		String email = scan.nextLine();
		boolean valid = service.isUnique(email);
		while(!valid) {
			System.out.println("Sorry that email address is taken, please enter another");
			email = scan.nextLine();
			valid = service.isUnique(email);
		}
		System.out.println(); /////////////////////// stopped here will continue 
	}
	static void logIn() {
		System.out.println("Welcome back! Please enter your email address");
		String email = scan.nextLine();
		System.out.println("Please enter your password");
		String password = scan.nextLine();
		Associate a = service.logIn(email, password);
		if(a == null) {
			System.out.println("Sorry, you've entered the wrong credentials!");
			welcome();
			return;
		}
		else {
			System.out.println("Hey, " + a.getFirstName() + "! Your current grade is " + a.getGrade());
		}
	}
	static void getStats() {}

}
