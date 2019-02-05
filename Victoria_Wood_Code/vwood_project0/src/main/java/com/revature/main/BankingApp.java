package com.revature.main;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.AccountRepository;
import com.revature.exception.NoMoneyException;
import com.revature.pojos.Account;
import com.revature.pojos.User;

public class BankingApp {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to VW Bank! \n");
		welcomeMenu();
	}

	static void welcomeMenu() {
		boolean active = true;
		while(active) {
			System.out.println("If you would like to Log-In press 'l' \n" + 
					"If you would like to create an account press 'c' \n" +
					"If you would like to exit 'e'");
			String choice = scan.nextLine();
			switch (choice) {
			default: System.out.println("Please enter a valid input: "); choice = scan.nextLine();
			case "l": loggingIn(); break;
			case "c": creatingAccount(); break;
			case "e": active = false; System.out.println("Thank you for Banking with us, Goodbye!"); break;
			}
		}
	}

	static void loggingIn() {
		System.out.println("Username: ");
		String u = scan.nextLine();
		System.out.println("Password: ");
		String p = scan.nextLine();
		User user = AccountRepository.logIn(u,p);
		while(user == null) {
			System.out.println("Username and password do not match. Please try again.");
			System.out.println("Username: "); u = scan.nextLine();
			System.out.println("Password: "); p = scan.nextLine();
			user = AccountRepository.logIn(u,p);
		}
		accountMenu(user);
	}


	static void creatingAccount() {
		System.out.println("Please enter the following information \n");
		System.out.println("First Name: "); String fn = scan.nextLine();
		System.out.println("Last Name: "); String ln = scan.nextLine();
		System.out.println("Username: "); String u = scan.nextLine();
		while (!AccountRepository.isUniqueUsername(u)) {
			System.out.println("This username has already been taken.\n"+
					"Please enter another username: ");
			u = scan.nextLine();
		}
		System.out.println("Password: "); String p = scan.nextLine();
		User user = AccountRepository.createNewAccount(fn, ln, u, p);
		addingAccount(user);
		accountMenu(user);
	}


	static void accountMenu(User user) {
		System.out.println("What would you like today, " + user.getFn() + "?\n"
				+ "Enter 'a' to add a Savings or Checking account \n"
				+ "Enter 'v' to view account balances \n" 
				+ "Enter 'd' to make a deposit\n"
				+ "Enter 'w' to make a withdrawl\n"
				+ "Enter 'o' to log-out ");
		String choice = scan.nextLine();
		switch(choice) {
		default: System.out.println("Please enter a valid input: "); //choice = scan.nextLine();
		case "v": viewAccounts(user); break;
		case "a": addingAccount(user); break;
		case "d": makeDeposit(user); break;
		case "w": makeWithdrawl(user); break;
		case "o": System.out.println("Thank you for banking with us, Goodbye!"); break;
		}
	}

	static Account chooseAccount(User user) {
		List<Account> useraccts = AccountRepository.getAccounts(user.getId());
		Account toview = null;
		if (useraccts != null && useraccts.size() > 1) {
			System.out.println("Which account would you like to access?");
			int i = 1;
			for (Account a: useraccts) {
				System.out.println("Press" + i + "for" + a.getType() + a.getId());
				i++;
			}
			int choice = scan.nextInt();
			toview = useraccts.get(choice - 1);
		} else {
			toview = useraccts.get(0);
		}
		return toview;
	}
	
	
	static void makeDeposit(User user) {
		Account a = chooseAccount(user);
		System.out.println("How much would you like to deposit today, " + user.getFn() + " ? ");
		float deposit = scan.nextFloat();
		AccountRepository.deposit(a, deposit);
		System.out.println("Your account balance for "
			+ a.getType() + " " + a.getId() + " is now " + a.getBalance());
		accountMenu(user);
	}
	
	static void makeWithdrawl(User user) {
		Account a = chooseAccount(user);
		System.out.println("How much would you like to withdraw today, " + user.getFn() + " ? ");
		float withdrawl = scan.nextFloat();
		try {
			AccountRepository.withdraw(a, withdrawl);
		} catch (NoMoneyException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Your account balance for " + a.getType() 
			+ " " + a.getId() + " is now " + a.getBalance());
		accountMenu(user);
		
	}


	static void viewAccounts(User user) {
		Account a = chooseAccount(user);
		System.out.println("Your " + a.getType() + " Account " + a.getId() 
		+ " has a balance of " + a.getBalance());
		accountMenu(user);
	}




	static void addingAccount(User user) {
		boolean noType = true;
		boolean noDeposit = true;
		System.out.println("What type of account would you like to create, " + user.getFn() + "?\n"
				+ "For Checking enter 'c'\n" + "For Savings enter 's'\n"); 
		String type = "";
		Float deposit = (float) 0.00;
		while(noType) {
			if (scan.nextLine().equals("c")) {
				type = "Checking";
				noType = false;
			} else if (scan.nextLine().equals("s")) {
				type = "Savings";
				noType = false;
			} else {
				System.out.println("Please enter 'c' or 's'.");
			}
		}
		while (noDeposit) {
			System.out.println("Please enter initial deposit amount: ");
			if(!scan.hasNextFloat()) {
				System.out.println("Invalid entry. Please enter a valid amount.");
			} else {
				deposit = scan.nextFloat();
				noDeposit = false;
			}
		}
		Account a = AccountRepository.addAccount(user.getId(), type, deposit);	
		if (a != null) {
			System.out.println("Your account has been successfully created");
		} else {
			System.out.println("Your account has not been created.\n" + 
		" You will be redirected to the menu where you can try again.");
		}
		accountMenu(user);
	}





}





