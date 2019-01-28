package com.revature.app;

import java.util.Scanner;

import com.revature.account.Account;

public class App {
	public static Account login(Scanner console) {
		boolean memberExists = false;  //Placeholder for determining if member exists once data is persistent. 
		
		System.out.print("Welcome to the bank! Please enter your login credentials.\nUsername: ");
		String userName = console.nextLine();
		System.out.print("Password: ");
		String pass = console.nextLine();
		
		//IMPLEMENT BEHAVIOR FOR STORING ACCOUNTS//
		//STRORING ACCOUNTS WILL STORE MONEY//
		//IMPLEMENT BEHAVIOR TO CHECK IF ACCOUNT EXISTS//
		Account member = new Account(userName, pass, 100); // Initialize with set money for now.
		if(!memberExists) {
			System.out.println("Your credentials do not match an account. Select an option:\n\nCreate new account (c)\nTry Again (Any other key)");
			String answer = console.nextLine().toUpperCase();
			
			if(answer.equals("C")) {
				member = createAccount(console);
			} else {
				member = login(console);
			}
		} 
		return member;
	}
	
	public static Account createAccount(Scanner console) {
		String userName = "";
		String pass = "";
		
		System.out.print("Thank you for considering an account with us!\n\nPlease enter a desired username: ");
		userName = console.nextLine();
		boolean success = false;
		
		while(!success) {
			System.out.print("Please enter a desired password: ");
			pass = console.nextLine();
			System.out.print("Please confirm password: ");
			if(console.nextLine().equals(pass)) {
				success = true;
			} else {
				System.out.println("The two password do not match!\n");
			}
		}
		
		success = false;
		System.out.println("How much would you like to deposit to start the account?");	
		int depositAmount = 0;

		while(!success) {
			if(console.hasNextInt()) {
				depositAmount = console.nextInt();
				success = true;
			} else {
				console.nextLine();
				System.out.println("You did not enter a valid amount. Try again.");
			}
		}
		console.nextLine();
		return new Account(userName, pass, depositAmount);
	}
	
	public static void withdrawInteraction(Scanner console, Account member) {
		System.out.println("How much would you like to withdraw?");
		int withdrawnAmount = 0;
		boolean success = false;
		while(!success) {
			if(console.hasNextInt()) {
				withdrawnAmount = console.nextInt();
				if(!(success = member.withdraw(withdrawnAmount))) {
					System.out.println("You do not have enough funds for this transaction. Try again.");
					console.nextLine();
				} 
			} else {
				console.nextLine();
				System.out.println("You did not enter a valid amount. Try again.");
			}
		}
		System.out.println("You have withdrawn $" + withdrawnAmount + " from your account.");
		viewInteraction(member);
		console.nextLine();
	}
	
	public static void depositInteraction(Scanner console, Account member) {
		System.out.println("How much would you like to deposit?");
		int depositAmount = 0;
		boolean success = false;
		while(!success) {
			if(console.hasNextInt()) {
				depositAmount = console.nextInt();
				success = member.deposit(depositAmount);
			} else {
				console.nextLine();
				System.out.println("You did not enter a valid amount. Try again.");
			}
		}
		System.out.println("You have deposited $" + depositAmount + " to your account.");
		viewInteraction(member);
		console.nextLine();
	}
	
	public static void viewInteraction(Account member) {
		System.out.println("You currently have $" + member.viewAccount() + " in your account.");
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Account member = null;
		boolean end = false;
		boolean loggedIn = false;
		while(!end) {
			
			if(!loggedIn) {
				member = login(console);
				loggedIn = true;
			}
			
			System.out.println("----");
			System.out.println("What would you like to do?\n\nWithdraw (W)\nDeposit (D)\nView Account (V)\nEnd Tranaction (E)\n");
			String option = console.nextLine().toUpperCase();
			
			switch(option) {
				case "W" :  withdrawInteraction(console, member); break;
				case "D" : depositInteraction(console, member); break;
				case "V" : viewInteraction(member); break;
				case "E" : System.out.println("Thank you for using this bank!"); end = true; break;
				default  : System.out.println("Please use one of the options above."); break;
			}
		}
	}
}
