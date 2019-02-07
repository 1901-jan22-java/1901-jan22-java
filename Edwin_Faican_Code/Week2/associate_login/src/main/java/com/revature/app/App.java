package com.revature.app;

import java.util.Scanner;

import org.apache.log4j.Logger;
import com.jdbc.dao.AssociateRepository;
import com.revature.associate.Associate;

public class App {
	final static Logger logger = Logger.getLogger(App.class);
	
	public static Associate login(Scanner console, AssociateRepository ascRepo) {
		boolean success = false;
		Associate asc = null;
		
		while(!success) {
			System.out.print("Enter email: ");
			String input = console.nextLine();
			asc = ascRepo.getAssociate(input);
			
			System.out.print("Enter password: ");
			String password = console.nextLine();
			
			if(asc.getPassword().equals(password)) {
				success = true;
			} else {
				System.out.println("Your credentials do not exist. Try again.");
			}
		}
		System.out.println(asc.getFirstname() + ", you have logged in!");
		return asc;
	}
	
	public static void updateGrade(Scanner console, Associate asc, AssociateRepository ascRepo) {
		System.out.println("What is your new grade: ");
		boolean success = false;
		
		while(!success) {
			if(console.hasNextDouble()) {
				double grade = console.nextDouble();
				asc.setGrade(grade);
				success = true;
			} else {
				console.nextLine();
				System.out.println("You did enter a number! Try again. ");
			}
		}
		console.nextLine();
		ascRepo.updateGrades(asc);
		System.out.println("Your grade has been updated. Your new grade is : " + asc.getGrade());
	}
	
	public static void main(String[] args) {
		AssociateRepository ascRepo = new AssociateRepository();
		Scanner console = new Scanner(System.in);
		Associate asc = null;
		boolean end = false;
		
		while(!end) {
			if(asc == null) {
				asc = login(console, ascRepo);
			}
			System.out.println("Welcome! Please select an option:\nUpdate grade (U)\nLogout (L)\n");
			String input = console.nextLine().toLowerCase();
			
			switch(input) {
				case "u" : updateGrade(console, asc, ascRepo); break;
				case "l" : asc = null; System.out.println("You have logged out");break;
				default : System.out.println("You did not enter an option from above.");
			}
			
		}
		
		
		

	}
}
