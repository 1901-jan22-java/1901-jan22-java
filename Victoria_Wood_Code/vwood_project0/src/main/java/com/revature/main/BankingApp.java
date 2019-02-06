package com.revature.main;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.AccountRepository;
import com.revature.exception.NoMoneyException;
import com.revature.pojos.Account;
import com.revature.pojos.User;

public class BankingApp {

	static Scanner scan = new Scanner(System.in);
	static boolean active = true;

	public static void main(String[] args) {
		System.out.println("Welcome to VW Bank! \n");
		welcomeMenu();
	}

	// initial startup menu
	static void welcomeMenu() {
		while(active) {
			System.out.println("If you would like to Log-In enter 'l' \n" + 
					"If you would like to create an account enter 'c' \n" +
					"If you would like to exit enter 'e'");
			String choice = scan.nextLine();
			switch (choice) {
			case "l": loggingIn(); break;
			case "c": creatingAccount(); break;
			case "e": active = false; System.out.println("Thank you for Banking with us, Goodbye!"); break;
			default: System.out.println("Please enter a valid input: "); choice = scan.nextLine();
			}
		}
	}


	static void loggingIn() {
		/*
		 * Function to log-in. 

		 * Calls logIn in AccountRepository to check if username password
		 * combination exists in database . Returns User object with user info
		 * from database if username and password match.
		 */
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
		/*
		 * Function to create new user account. Asks user for information:
		 * first name, last name, username and password.
		 * 
		 * Calls isUniqueUsername method from AccountRepository to check
		 * that username fits unique constraint in database.
		 * 
		 * creates new user object that is then passed 
		 */
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
		/*
		 *Once account is created or accessed - main menu for what user can do.
		 *
		 */		
		String choice = "";
		while(active) {
			System.out.println("What would you like today, " + user.getFn() + "?\n" + "\n"
					+ "Enter 'a' to add a Savings or Checking account \n"
					+ "Enter 'v' to view account balances \n" 
					+ "Enter 'd' to make a deposit\n"
					+ "Enter 'w' to make a withdrawl\n"
					+ "Enter 'o' to log-out ");
			choice = scan.next();
			switch(choice) {
			case "a": addingAccount(user); break;
			case "d": makeDeposit(user); break;
			case "w": makeWithdrawl(user); break;
			case "v": viewAccounts(user); break;
			case "o": System.out.println("Thank you for banking with us, Goodbye!"); active = false; break; 
			default: System.out.println("\nPlease enter a valid input: "); break;
			}
		}
	}

	static Account chooseAccount(User user) {
		/*
		 * Function that facilitates user choosing between multiple accounts before
		 * transactions are completed. 
		 * 
		 * Calls getAccounts from AccountRepository that returns a list of
		 * all the user's accounts. User can then choose from the list.
		 * 
		 * Returns chosen account.
		 * 
		 */
		List<Account> useraccts = AccountRepository.getAccounts(user.getId());
		Account toview = null;
		if (useraccts != null && useraccts.size() > 1) {
			System.out.println("Which account would you like to access?");
			int i = 1;
			for (Account a: useraccts) {
				System.out.println("Press " + i + " for " + a.getType() + " " + a.getId());
				i++;
			}
			for(;;) {
				if(!scan.hasNextInt()) {
					System.out.println("Please enter valid input:");
					scan.next();
					continue;
				} else {
					break;
				}
			}
			int choice = scan.nextInt();
			toview = useraccts.get(choice - 1);
		} else {
			toview = useraccts.get(0);
		}
		return toview;
	}


	static void makeDeposit(User user) {
		/*
		 * Function to make deposit. Takes in User object. Calls choose account to 
		 * retrieve account to be manipulated. 
		 * 
		 * Calls deposit from AccountRepository to modify balance in database.
		 * 
		 */
		Account a = chooseAccount(user);
		System.out.println("How much would you like to deposit today, " + user.getFn() + " ? ");
		for(;;) {
			if(!scan.hasNextFloat()) {
				System.out.println("Please enter valid input: ");
				scan.next();
				continue;
			} else {
				break;
			}
		}
		float deposit = scan.nextFloat();
		AccountRepository.deposit(a, deposit);
		System.out.println("Your account balance for "
				+ a.getType() + " " + a.getId() + " is now " + a.getBalance());
	}

	static void makeWithdrawl(User user) {
		/*
		 * Function to make withdrawl. Takes in user object. Calls chooseAccount to retrieve
		 * account to be modified.
		 * 
		 * Calls withdraw method - catches NoMoneyException in case user attempts
		 * to withdraw more money than is present in the account
		 * 
		 */
		Account a = chooseAccount(user);
		System.out.println("How much would you like to withdraw today, " + user.getFn() + " ? ");
		for(;;) {
			if(!scan.hasNextFloat()) {
				System.out.println("Please enter valid input: ");
				scan.next();
				continue;
			} else {
				float withdrawl = scan.nextFloat();
				try {
					AccountRepository.withdraw(a, withdrawl);
					break;
				} catch (NoMoneyException e) {
					System.out.println(e.getMessage());
					System.out.println("Please enter an amount below "  + a.getBalance() + " :");
				}

			}
		}
		System.out.println("\n Your account balance for " + a.getType() 
		+ " " + a.getId() + " is now " + a.getBalance() + "\n");

	}


	static void viewAccounts(User user) {
		/*
		 * Function to view user accounts. Call chooseAccount to retrieve account to be viewed.
		 * Prints out information from account.
		 * 
		 */
		Account a = chooseAccount(user);
		System.out.println("Your " + a.getType() + " Account " + a.getId() 
		+ " has a balance of " + a.getBalance() + "\n");
	}




	static void addingAccount(User user) {
		/*
		 * Function to add additional account for current user. Asks for user input
		 * for type of account and initial deposit amount.
		 * 
		 * Calls addAccount in AccountRepository to add account in database.
		 */		
		boolean noType = true;
		System.out.println("What type of account would you like to create, " + user.getFn() + "?\n"
				+ "For Checking enter 'c'\n" + "For Savings enter 's'\n"); 
		String type = scan.nextLine();
		while(noType) {
			if (type.equals("c")) {
				type = "Checking";
				noType = false;
			} else if (type.equals("s")) {
				type = "Savings";
				noType = false;
			} else {
				System.out.println("Please enter 'c' or 's'.");
				type = scan.nextLine();
			}
		}
		System.out.println("Please enter your initial deposit amount: ");
		for(;;) {
			if(!scan.hasNextFloat()) {
				System.out.println("Please enter valid input: ");
				scan.next();
				continue;
			} else {
				break;
			}
		}
		float deposit = scan.nextFloat();		
		Account a = AccountRepository.addAccount(user.getId(), type, deposit);	
		if (a != null) {
			System.out.println("\n Your account has been successfully created \n");
		} else {
			System.out.println("Your account has not been created.\n" + 
					" You will be redirected to the menu where you can try again. \n");
		}
	}





}





