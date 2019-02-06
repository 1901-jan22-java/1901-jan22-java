package com.jdbc.views;

import java.util.List;
import java.util.Scanner;

import com.jdbc.dao.AccountRepository;
import com.jdbc.dao.UserRepository;
import com.jdbc.main.App;
import com.jdbc.pojos.Account;
import com.jdbc.pojos.User;

public class UserView {

	public static void userLogin() {
		System.out.println("Login\n");
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter your username: ");
		String username = scanner.nextLine();
		System.out.println("Please enter your password: ");
		String password = scanner.nextLine();

		User foundUser = UserRepository.findLoginInfo(username, password);
				
		if(foundUser == null) {
			System.out.println("Login failed. Please try again.");
			userLogin();
		}
		else if(foundUser != null) {
			System.out.println("Login successful!");
			UserMenu(foundUser);
		}
		scanner.close();
	}
	
	// userMenu
	
	static User currUser = new User();
	static Scanner scan = new Scanner(System.in);
	
	public static void addUser() {

		System.out.println("Please enter your first name: ");
		String fname = scan.nextLine();

		System.out.println("Please enter your last name: ");
		String lname = scan.nextLine();

		System.out.println("Please enter your desired username: ");
		String username = scan.nextLine();

		System.out.println("Please enter a password: ");
		String password = scan.nextLine();

		currUser.setFirstName(fname);
		currUser.setLastName(lname);
		currUser.setUsername(username);
		currUser.setPassword(password);

		System.out.println(UserRepository.save(currUser));
		User checkedUser = UserRepository.save(currUser);
		
		if(checkedUser == null) {
			System.out.println("Username already used, please try again: ");
			addUser();
		}
		else if(checkedUser != null) {
			System.out.println("Account created!\n");
			userLogin();
		}
	}
	
	public static void UserMenu(User currUser) {
		
		List<Account> accounts = AccountRepository.findAllUserAccounts(currUser.getUserId());
		int numAccounts = accounts.size();
		
		System.out.println("\nHello " + currUser.getFirstName());
		if(accounts.size() != 0){
			System.out.println("Your Accounts:");
			for (Account a : accounts) {
				System.out.println("Account Number: " + a.getAccountId() + ", Account Type: " 
						+ a.getAccountType() + ", Balance: $" + a.getBalance() + "0");
			}
		}
		else {
			System.out.println("You do not have any accounts, please open one");
		}
		
		System.out.println("\nHow can I assist you?\n" + "Enter 1 to make a deposit\n"
				+ "Enter 2 to make a withdrawal\n" + "Enter 3 to open a new account\n" + "Enter 4 to log out\n");
		
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		int option = 0;
		try {
			option = Integer.parseInt(s);
		}
		catch(NumberFormatException e){
			System.out.println("Enter a number between 1 and 4!\n");
			UserMenu(currUser);
		}

		if(option != 1 && option != 2 && option != 3 && option != 4 || s == null) {
			System.out.println("Enter a number between 1 and 4!");
			UserMenu(currUser);
		}

		switch (option) {
		case 1:
			if(numAccounts != 0) {
				AccountView.initiateDeposit(currUser);
			}
			else if(numAccounts == 0) {
				System.out.println("You have no accounts!");
				UserMenu(currUser);
			}
			break;
		case 2:
			if(numAccounts != 0) {
				AccountView.initiateWithdrawal(currUser);
			}
			else if(numAccounts == 0) {
				System.out.println("You have no accounts!");
				UserMenu(currUser);
			}
			break;
		case 3:
			AccountView.openAccount(currUser);
			break;
		case 4:
			String[] args = new String[1];
			App.main(args);
			break;
		}
		scan.close();
	}

}
