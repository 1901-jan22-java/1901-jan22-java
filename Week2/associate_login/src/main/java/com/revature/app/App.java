package com.revature.app;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.jdbc.dao.Associate_repository;
import com.revature.associate.associate;

public class App {
	final static Logger logger = Logger.getLogger(App.class);
	public static associate login(Scanner console, Associate_repository ascRepo) {
		associate asc = null;
		boolean sucsess = false;		
		while(!sucsess) {
			System.out.println("Enter Email");
			String input = console.nextLine();
			asc = ascRepo.getAssociate(input);
			System.out.println("Enter Password: ");
			String password = console.nextLine();
			if(asc.getPassword().equals(password)) {
				sucsess = true;
			}
			else {
				System.out.println("Credentials don't exsits! Try again!");
			}
		}
		System.out.println(asc.getFirstName()+ ", You have logged in!");
		return asc;
	}
	public static void updateGrade(Scanner console, associate asc, Associate_repository ascRepo) {
		System.out.println("What is your new grade?");
		boolean success = false;
		while(!success) {
			if(console.hasNextDouble()) {
				double grade = console.nextDouble();
				asc.setGrade(grade);
				success = true;
			}
			else {
				console.nextLine();
				System.out.println("You did not enter a number try again");
			}
		}
		ascRepo.updateGrades(asc);
		console.nextLine();
		System.out.println("Your grade has been updated\nYour new grade is: " + asc.getGrade());
	}
	public static void updateEmail(Scanner console, associate asc, Associate_repository ascRepo) {
		System.out.println("What is your new Email?");
		boolean success = false;
		while(!success) {
			if(console.hasNextDouble()) {
				double grade = console.nextDouble();
				asc.setGrade(grade);
				success = true;
			}
			else {
				console.nextLine();
				System.out.println("You did not enter a number try again");
			}
		}
		ascRepo.updateGrades(asc);
		console.nextLine();
		System.out.println("Your grade has been updated\nYour new grade is: " + asc.getGrade());
	}
	public static void main(String[] args) {
		Associate_repository ascRepo = new Associate_repository();
		Scanner console = new Scanner(System.in);
		associate asc = null;
		boolean end = false;
		while(!end) {
			if(asc == null) {
				asc = login(console, ascRepo);
			}
			System.out.println("Welcome! Please select an option \nUpdate Grade (U)\nLogout (L)");
			String input = console.nextLine().toLowerCase();
			switch(input) {
			case "u" : updateGrade(console, asc, ascRepo); break;
			case "l" : asc = null; System.out.println("You have logged out"); break;
			default : System.out.println("Please enter an option");
			}
		}
	}
}
