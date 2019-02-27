package com.ravature.bank.views;
import java.util.List;
import java.util.Scanner;
import com.ravature.bank.dao.RepositoryForAccount;
import com.ravature.bank.dao.RepositoryForUser;
import com.ravature.bank.main.App;
import com.ravature.bank.pojos.Account;
import com.ravature.bank.pojos.User;
public class ViewUsers {
	public static void login() {
		System.out.println("Login\n");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String username = scanner.nextLine();
		System.out.println("Enter Password: ");
		String password = scanner.nextLine();
		User userExists = RepositoryForUser.loginInfo( 0, username, password);	
		if(userExists == null) {
			System.out.println("Login failed! Please try again!");
			login();
		}
		else if(userExists != null) {
			System.out.println("Logging in");
			menu(userExists);
		}
		scanner.close();
	}
	static User currUser = new User();
	static Scanner scan = new Scanner(System.in);
	public static void add() {
		System.out.println("Enter First Name: \n");
		String firstname = scan.nextLine();
		System.out.println("Enter last Name: \n");
		String lastname = scan.nextLine();
		System.out.println("Enter Username: \n");
		String username = scan.nextLine();
		System.out.println("Enter Password: \n");
		String password = scan.nextLine();
		currUser.setFirstName(firstname);
		currUser.setLastName(lastname);
		currUser.setUsername(username);
		currUser.setPassword(password);
		System.out.println(RepositoryForUser.saveUser(currUser));
		User checkedUser = RepositoryForUser.saveUser(currUser);
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
		List<Account> accounts = RepositoryForAccount.getAccounts(currUser.getUser_Id());
		int numAccounts = accounts.size();
		System.out.println("\nGreetings " + currUser.getFirstName());
		if(accounts.size() != 0){
			System.out.println("Your Accounts:");
			for (Account a : accounts) {
				System.out.println("Account #: " + a.getAccountId() + "\n Account Type: " + a.getAccountType() + "\n Balance: " + a.getBalance());
			}
		}
		else {
			System.out.println("Please Create An Account");
		}
		System.out.println("[Deposit] : 1");
		System.out.println("[Withdrawal] : 2");
		System.out.println("[Account] : 3");
		System.out.println("[Log out] : 4");
		Scanner scan = new Scanner(System.in);
		String cara = scan.nextLine();
		int option = scan.nextInt();
		try {
			option = Integer.parseInt(cara);
		}
		catch(NumberFormatException e){
			System.out.println("Character not allowed");
			menu(currUser);
		}
		if(option != 1 && option != 2 && option != 3 && option != 4 || cara == null) {
			System.out.println("Your range is between 1 and 4");
			menu(currUser);
		}
		else if(option == 1)
		{
			if(numAccounts != 0) {
				ViewAcc.initiateDeposit(currUser);
			}
			else if(numAccounts == 0) {
				System.out.println("You have no accounts!");
				menu(currUser);
			}
		}
		else if(option == 2)
		{
			if(numAccounts != 0) {
				ViewAcc.initiateWithdrawal(currUser);
			}
			else if(numAccounts == 0) {
				System.out.println("No accounts");
				menu(currUser);
			}
		}
		else if(option == 3){
			ViewAcc.createAccount(currUser);
		}
		else {
			String[] args = new String[1];
			App.main(args);
		}
		scan.close();
	}

}