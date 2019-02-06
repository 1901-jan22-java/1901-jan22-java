package com.jdbc.views;

import java.util.List;
import java.util.Scanner;

import com.jdbc.dao.AccountRepository;
import com.jdbc.pojos.Account;
import com.jdbc.pojos.Deposit;
import com.jdbc.pojos.User;
import com.jdbc.pojos.Withdraw;

public class AccountView {
		
	public static void openAccount(User currUser) {
		System.out.println("What type of account would you like to open?\n" + "Enter 1 to open new savings account\n"
				+ "Enter 2 to open new checking account\n");
		
		Scanner scan = new Scanner(System.in);

		int choice = 0;
		if(scan.hasNextInt()){
			choice = scan.nextInt();
		} else {
			System.out.println("You must enter 1 or 2");
			openAccount(currUser);
		}
		if(choice != 1 && choice != 2) {
			System.out.println("You must enter 1 or 2");
			openAccount(currUser);
		}
		
		String typeOfAccountToMake = "";
		
		if(choice == 1) {
			typeOfAccountToMake = "Savings";
		}
		else if(choice == 2) {
			typeOfAccountToMake = "Checking";
		}
		
		Account newAccount = new Account();
		newAccount.setAccountType(typeOfAccountToMake);
		
		AccountRepository.save(newAccount, currUser);
		UserView.UserMenu(currUser);
		
		scan.close();
	}
	
	public static void initiateDeposit(User currUser){
		Scanner scan = new Scanner(System.in);
		List<Account> accounts = AccountRepository.findAllUserAccounts(currUser.getUserId());
		System.out.println("Please enter the account number to which you would like to add funds");
		for (Account a : accounts) {
			System.out.println("Account ID: " + a.getAccountId() + ", Account Type: " 
					+ a.getAccountType() + ", Your Balance: $" + a.getBalance() + "0\n");
		}
		int depositAccount = scan.nextInt();
		
		System.out.println("How much would you like to deposit?\n");
		double depositAmount = 0;
		if(scan.hasNextDouble()){
			depositAmount = scan.nextDouble();
		} else {
			System.out.println("Enter a number in the format $0.00");
			initiateDeposit(currUser);
		}
		
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
		System.out.println("Please enter the accountId from which you would like to withdraw funds");
		for (Account a : accounts) {
			System.out.println("Account ID: " + a.getAccountId() + ", Account Type: " 
					+ a.getAccountType() + ", Your Balance: $" + a.getBalance() + "0\n");
		}
		int withdrawAccount = scan.nextInt();
		double withdrawAmount = 0;
		System.out.println("How much would you like to withdraw?\n");
		if(scan.hasNextDouble()){
			withdrawAmount = scan.nextDouble();
		} else {
			System.out.println("Enter a number in the format $0.00");
			initiateWithdrawal(currUser);
		}
		
		Withdraw withdraw = new Withdraw();
		
		withdraw.setAccountId(withdrawAccount);
		withdraw.setAmount(withdrawAmount);
		
		if(AccountRepository.Withdraw(withdrawAccount, withdrawAmount, currUser)){
			System.out.println("You have withdrawn $" + withdrawAmount + "0");
		}
		
		UserView.UserMenu(currUser);
		 
		scan.close(); 
	}	
}
