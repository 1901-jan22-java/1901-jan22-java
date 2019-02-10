package com.jdbc.main;

import java.util.Scanner;

import com.jdbc.views.UserView;

public class App {

	public static void main(String[] args) {
		System.out.println("Welcome to your Bank");
		homeMenu();
	}
	
	private static void homeMenu(){
		System.out.println("Please choose an option" + "\n"
				+ " Enter 1 to Login" + "\n"
				+ " Enter 2 to Create a New Account" + "\n"
				+ " Enter 3 to Exit");
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		if(scan.hasNextInt()){
			choice = scan.nextInt();
		} else {
			System.out.println("You must enter 1, 2, or 3");
			homeMenu();
		}
		if(choice != 1 && choice != 2 && choice != 3) {
			System.out.println("You must enter 1, 2, or 3");
			homeMenu();
		}
		
		switch(choice){
		case 1:
			UserView.userLogin();
			break;
		case 2:
			UserView.addUser();
			break;
		case 3:
			System.out.println("Have a great day!");
			System.exit(choice);
			break;
		}
		scan.close();
	}
}
