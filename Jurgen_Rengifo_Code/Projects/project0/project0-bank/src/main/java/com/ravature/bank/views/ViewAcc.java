package com.ravature.bank.views;
import java.util.List;
import java.util.Scanner;
import com.ravature.bank.dao.RepositoryForAccount;
import com.ravature.bank.pojos.Deposit;
import com.ravature.bank.pojos.Withdraw;
import com.ravature.bank.pojos.Account;
import com.ravature.bank.pojos.User;
public class ViewAcc {
	public static void createAccount(User loggedInUser) {
		System.out.println("Account Type");
		System.out.println("[Savings] : 1\n");
		System.out.println("[Checking] : 2\n");
		Scanner scan = new Scanner(System.in);
		String cara = scan.nextLine();
		int option = 0;
		try {
			option = Integer.parseInt(cara);
		}
		catch(NumberFormatException e){
			System.out.println("Please enter a #");
			createAccount(loggedInUser);
		}
		if(option != 1 && option != 2 || cara == null) {
			System.out.println("Please enter 1 or 2!");
			createAccount(loggedInUser);
		}
		String typeOfAccountToMake = "";
		if(option == 1) {
			typeOfAccountToMake = " Create Savings";
		}
		else if(option == 2) {
			typeOfAccountToMake = "Create Checking";
		}
		Account newAccount = new Account();
		newAccount.setAccountType(typeOfAccountToMake);
		RepositoryForAccount.save(option, newAccount, loggedInUser);
		ViewUsers.menu(loggedInUser);
		scan.close();
	}
	public static void initiateDeposit(User currUser){
		Scanner scan = new Scanner(System.in);
		List<Account> accounts = RepositoryForAccount.getAccounts(currUser.getUser_Id());
		System.out.println("Which Account would you like to deposit to?");
		for (Account a : accounts) {
			System.out.println("Account ID: " + a.getAccountId() + ", Account Type: " + a.getAccountType() + ", Your Balance: $" + a.getBalance() + "0\n");
		}
		int depositAccount = scan.nextInt();
		System.out.println("How much would you like to deposit?\n");
		double depositAmount = scan.nextDouble();
		Deposit deposit = new Deposit();
		deposit.setAccountId(depositAccount);
		deposit.setAmount(depositAmount);
		RepositoryForAccount.Deposit(depositAccount, depositAmount);
		System.out.println("Deposited $" + depositAmount + "0");
		ViewUsers.menu(currUser);
		scan.close();
	}
	public static void initiateWithdrawal(User currUser){
		Scanner scan = new Scanner(System.in);
		List<Account> accounts = RepositoryForAccount.getAccounts(currUser.getUser_Id());
		System.out.println("Which Account would you like to withdraw from?");
		for (Account a : accounts) {
			System.out.println("Account ID: " + a.getAccountId() + ", Account Type: " + a.getAccountType() + ", Your Balance: $" + a.getBalance() + "0\n");
		}
		int withdrawAccount = scan.nextInt();
		System.out.println("How much would you like to withdraw?\n");
		double withdrawAmount = scan.nextDouble();
		Withdraw withdraw = new Withdraw();
		withdraw.setAccountId(withdrawAccount);
		withdraw.setAmount(withdrawAmount);
		if(RepositoryForAccount.Withdraw(withdrawAccount, withdrawAmount, currUser)){
			System.out.println("Withdrawn $" + withdrawAmount + "0");
		}
		scan.close(); 
	}
}