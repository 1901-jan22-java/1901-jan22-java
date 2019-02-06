package com.ravature.bank.views;
import java.util.List;
import java.util.Scanner;
import com.ravature.bank.dao.AccountRepository;
import com.ravature.bank.dao.UserRepository;
import com.ravature.bank.main.App;
import com.ravature.bank.pojos.Account;
import com.ravature.bank.pojos.User;
public class UserView {
	public static void login() {
		System.out.println("Login\n");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String username = scanner.nextLine();
		System.out.println("Enter Password: ");
		String password = scanner.nextLine();
		User foundUser = UserRepository.findLoginInfo(username, password);	
		if(foundUser == null) {
			System.out.println("Login failed! Please try again!");
			login();
		}
		else if(foundUser != null) {
			System.out.println("Logging in");
			menu(foundUser);
		}
		scanner.close();
	}
	static User currUser = new User();
	static Scanner scan = new Scanner(System.in);
	public static void add() {
		System.out.println("Enter First Name: ");
		String fname = scan.nextLine();
		System.out.println("Enter last Name: ");
		String lname = scan.nextLine();
		System.out.println("Enter Username: ");
		String username = scan.nextLine();
		System.out.println("Enter Password: ");
		String password = scan.nextLine();
		currUser.setFirstName(fname);
		currUser.setLastName(lname);
		currUser.setUsername(username);
		currUser.setPassword(password);
		System.out.println(UserRepository.save(currUser));
		User checkedUser = UserRepository.save(currUser);
		if(checkedUser == null) {
			System.out.println("Username taken ");
			add();
		}
		else if(checkedUser != null) {
			System.out.println("Account created!\n");
			login();
		}
	}
	public static void menu(User currUser) {
		List<Account> accounts = AccountRepository.getAccounts(currUser.getUsername());
		int numAccounts = accounts.size();
		System.out.println("\nHello " + currUser.getFirstName());
		if(accounts.size() != 0){
			System.out.println("Your Accounts:");
			for (Account a : accounts) {
				System.out.println("Account Number: " + a.getAccountId() + ", Account Type: " + a.getAccountType() + ", Balance: $" + a.getBalance() + "0");
			}
		}
		else {
			System.out.println("Please create an account");
		}
		System.out.println("Enter 1 to make a deposit\n" + "Enter 2 to make a withdrawal\n" + "Enter 3 to open a new account\n" + "Enter 4 to log out\n");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		int option = 0;
		try {
			option = Integer.parseInt(s);
		}
		catch(NumberFormatException e){
			System.out.println("Enter a number between 1 and 4!\n");
			menu(currUser);
		}
		if(option != 1 && option != 2 && option != 3 && option != 4 || s == null) {
			System.out.println("Enter a number between 1 and 4!");
			menu(currUser);
		}
		switch (option) {
		case 1:
			if(numAccounts != 0) {
				AccountView.initiateDeposit(currUser);
			}
			else if(numAccounts == 0) {
				System.out.println("You have no accounts!");
				menu(currUser);
			}
			break;
		case 2:
			if(numAccounts != 0) {
				AccountView.initiateWithdrawal(currUser);
			}
			else if(numAccounts == 0) {
				System.out.println("You have no accounts!");
				menu(currUser);
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