package com.project.main;

import java.util.Scanner;

import com.project.managers.LoginManager;
import com.project.managers.SignupManager;

public class App {

	static void printWelcome() {
		System.out.print("\nWelcome to J&J Banking!\n"
				+ "Please type in QUIT at anytime to quit the application.\n"
				+ "Type LOGIN to be redirected to the login console.\n"
				+ "Otherwise, please type SIGNUP to create a new account.\n\n");
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean flip = true;
		printWelcome();
		
		String cmd = scan.nextLine().toLowerCase();
		while(!cmd.equals("quit")) {
			switch(cmd) {
				case "login": 
					new LoginManager().takeover();
					printWelcome();
					flip = false;
					break;
				case "signup":
					new SignupManager().takeover();
					flip = false;
					printWelcome();
					break;
				default: 
					System.out.println("\nPlease try a different command."); 
					flip = true;
					break;
			};
			if(flip) cmd = scan.nextLine().toLowerCase();
		}
		scan.close();
	}
	
}
