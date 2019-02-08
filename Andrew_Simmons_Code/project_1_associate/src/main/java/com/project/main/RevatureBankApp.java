package com.project.main;

import java.util.Scanner;

import com.jdbc.util.DataFactory;

public class RevatureBankApp {
	static Scanner scan = new Scanner(System.in);
	static DataFactory service = new DataFactory();
	static int invalid = 0;

	public static void main(String[] args) {

		welcome();
	}

	static void welcome() {
		while (true) {
			System.out.println("==============================");
			System.out.println("|    Revature Bank           |");
			System.out.println("==============================");
			System.out.println("|       Options              |");
			System.out.println("|    1. Create Account       |");
			System.out.println("|    2. Log Into your Account|");
			System.out.println("|    3. Quit                 |");
			System.out.println("==============================");
			String in = scan.nextLine();
			int op = 0;
			try {
				op = Integer.parseInt(in);
			} catch (NumberFormatException e) {
				System.out.println("You must enter a number: either 1, 2, or 3!");  //User must select these numbers or it will be prompt to ask you again.
				welcome();
				return;
			}
			switch (op) {
			case 1:
				createAccount(); /// Create a new user to be entered into the database
				break;

			case 2:
				logIn(); //Log into the account menu with email and password registered in the database
				break;
			case 3:
				System.exit(0); //Stops Application

			default:
				System.out.println("You must enter a number: either 1, 2, or 3!");
				welcome();
				break;
			}

		}
	}

	public static void logIn() {
		System.out.println("Enter your email: ");
		String email = scan.nextLine();
		System.out.println("Enter your password: ");
		String password = scan.nextLine();
		try {
			service.login(email, password);
			System.out.println("Log in Successful");
			acctPage(email);

		} catch (Exception e) {
			System.out.println("Either the email or the password wrong, try again...");
			welcome();
		}
		return;
	}

	public static void acctPage(String email) {

		String temp = email; // stores the user into a var for checking purposes 

		while (true) {
			System.out.println("Welcome current user: " + email + "!\n");
			System.out.println("==============================");
			System.out.println("|     Account Menu           |");
			System.out.println("==============================");
			System.out.println("| Options:                   |");
			System.out.println("|    1. Create Checking      |");
			System.out.println("|    2. Create Saving        |");
			System.out.println("|    3. Withdraw (Checking)  |");
			System.out.println("|    4. Deposit   (Checking) |");
			System.out.println("|    5. Withdraw (Saving  )  |");
			System.out.println("|    6. Deposit   (Saving)   |");
			System.out.println("|    7. View Amount Details  |");
			System.out.println("|    8. Log out              |");
			System.out.println("==============================");
			String in = scan.nextLine();
			int op = 0;
			try {
				op = Integer.parseInt(in);
			} catch (NumberFormatException e) {
				System.out.println("You must enter a numbers: 1, 2, 3, 4, 5, 6, or 7!");
				acctPage(temp);
				return;
			}
			switch (op) {
			case 1:
				service.createCheckingAccount(temp); //Creates the account type Checkings for the user that is log in
				break;
			case 2:
				service.createSavingAccount(temp);  //Create the account type Saving for the user that is log in
				break;
			case 3:
				CheckingWithdrawMoney(temp); // Allows user to be able to withdraw money from the checking account
				break;
			case 4:
				CheckingDepoistMoney(temp); // Allows user to be able to Deposit money from the checking account
				break;
			case 5:
				SavingWithdrawMoney(temp); // Allows user to be able to withdraw money from the Saving account
				break;
			case 6:
				SavingDepoistMoney(temp); // Allows user to be able to withdraw money from the Saving account
				break;
			case 7:
				ViewCurrentAmountOnAccounts(temp); // Allows user to be able to see their amount in their account types
			case 8:
				System.exit(0);

			default:
				System.out.println("You must enter a numbers: 1, 2, 3, 4, 5, 6, or 7!");
				acctPage(temp);
				break;
			}
		}
	}

	private static void ViewCurrentAmountOnAccounts(String temp) {

		service.getAllBankUsers(temp);
		

	}

	private static void SavingDepoistMoney(String email) {
		double amount = service.getAmount(email);
		System.out.println("Enter the amount you wish to Deposit: ");
		double Saving = scan.nextDouble();

		System.out.println(amount + Saving);

		amount = amount + Saving;

		service.updateDepositSaving(email, amount);

	}

	private static void SavingWithdrawMoney(String email) {
		
	
		double amount = service.getAmount(email);
	
			System.out.println("Enter the amount you wish to Withdraw:");
			double Withdraw = scan.nextDouble();

		

				System.out.println(amount - Withdraw);

				amount = amount - Withdraw;
				

				service.updateDepositSaving(email, amount);
			
		
	}

	private static void CheckingWithdrawMoney(String email) {
		double amount = service.getAmount(email);
		System.out.println("Enter the amount you wish to Withdraw: ");
		double Withdraw = scan.nextDouble();

		System.out.println(amount - Withdraw);

		amount = amount - Withdraw;

		service.updateDepositChecking(email, amount);

	}

	public static void CheckingDepoistMoney(String email) {

		double amount = service.getAmount(email);
		System.out.println("Enter the amount you wish to Deposit: ");
		double Deposit = scan.nextDouble();

		System.out.println(amount + Deposit);

		amount = amount + Deposit;

		service.updateDepositChecking(email, amount);

	}

	/**
	 * 
	 * Creates an account
	 * 
	 **/
	public static void createAccount() {
		System.out.println("Enter your first name: ");
		String firstName = scan.nextLine();
		System.out.println("Enter your last name: ");
		String lastName = scan.nextLine();
		System.out.println("Enter your email: ");
		String email = scan.nextLine();
		System.out.println("Create a password: ");
		String password = scan.nextLine();
		service.createUser(firstName, lastName, password, email);
	}

}
