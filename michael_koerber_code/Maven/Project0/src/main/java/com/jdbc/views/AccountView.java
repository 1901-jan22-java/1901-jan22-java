package com.jdbc.views;

import java.util.List;
import java.util.Scanner;

import com.jdbc.dao.AccountRepository;
import com.jdbc.pojos.Account;
import com.jdbc.pojos.Deposit;
import com.jdbc.pojos.User;
import com.jdbc.pojos.Withdraw;

public class AccountView {
		
	public static void openAccount(User loggedInUser) {
		System.out.println("What type of account would you like to open?\n" + "Enter 1 to open new savings account\n"
				+ "Enter 2 to open new checking account\n");
		
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		
		int option = 0;
		try {
			option = Integer.parseInt(s);
		}
		catch(NumberFormatException e){
			System.out.println("You must enter 1 or 2!\n");
			openAccount(loggedInUser);
		}

		if(option != 1 && option != 2 || s == null) {
			System.out.println("You must enter 1 or 2!");
			openAccount(loggedInUser);
		}
		
		String typeOfAccountToMake = "";
		
		if(option == 1) {
			typeOfAccountToMake = "savings";
		}
		else if(option == 2) {
			typeOfAccountToMake = "checking";
		}
		
		Account newAccount = new Account();
		newAccount.setAccountType(typeOfAccountToMake);
		
		AccountRepository.save(newAccount, loggedInUser);
		UserView.UserMenu(loggedInUser);
		
		scan.close();
	}
	
	public static void initiateDeposit(User currUser){
		Scanner scan = new Scanner(System.in);
		List<Account> accounts = AccountRepository.findAllUserAccounts(currUser.getUserId());
		System.out.println("Please enter the account number to which you would like to add funds?");
		for (Account a : accounts) {
			System.out.println("Account ID: " + a.getAccountId() + ", Account Type: " 
					+ a.getAccountType() + ", Your Balance: $" + a.getBalance() + "0\n");
		}
		int depositAccount = scan.nextInt();
		
		System.out.println("How much would you like to deposit?\n");
		double depositAmount = scan.nextDouble();
		
		Deposit deposit = new Deposit();
		
		deposit.setAccountId(depositAccount);
		deposit.setAmount(depositAmount);
		
		AccountRepository.Deposit(depositAccount, depositAmount);
		System.out.println("You have deposited $" + depositAmount + "0");
		
		UserView.UserMenu(currUser);
		
		scan.close();
	}
	
	public static void initiateWithdrawal(User currUser){
		Scanner scan = new Scanner(System.in);
		List<Account> accounts = AccountRepository.findAllUserAccounts(currUser.getUserId());
		System.out.println("Please enter the accountId from which you would like to withdraw funds?");
		for (Account a : accounts) {
			System.out.println("Account ID: " + a.getAccountId() + ", Account Type: " 
					+ a.getAccountType() + ", Your Balance: $" + a.getBalance() + "0\n");
		}
		int withdrawAccount = scan.nextInt();
		
		System.out.println("How much would you like to withdraw?\n");
		double withdrawAmount = scan.nextDouble();
		
		Withdraw withdraw = new Withdraw();
		
		withdraw.setAccountId(withdrawAccount);
		withdraw.setAmount(withdrawAmount);
		
		if(AccountRepository.Withdraw(withdrawAccount, withdrawAmount, currUser)){
			System.out.println("You have withdrawn $" + withdrawAmount + "0");
		}
		scan.close(); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
