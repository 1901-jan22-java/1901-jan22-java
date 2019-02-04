package com.revature.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.account.Account;

public class App {
	public static Account login(Scanner console) {
		boolean memberExists = false;  //Placeholder for determining if member exists once data is persistent. 
		
		System.out.print("Welcome to the bank! Please enter your login credentials.\nUsername: ");
		String userName = console.nextLine();
		System.out.print("Password: ");
		String pass = console.nextLine();
		File f = new File("accounts.txt");
		
		//Creates an accounts file if none exists.
		if(!f.exists()) {
			try(BufferedWriter bw = new BufferedWriter(new FileWriter("accounts.txt"))) {
				bw.write("");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Loads accounts.
		ArrayList<String> accounts = readAcctFile();
		
		//IMPLEMENT BEHAVIOR FOR STORING ACCOUNTS//
		//STRORING ACCOUNTS WILL STORE MONEY//
		//IMPLEMENT BEHAVIOR TO CHECK IF ACCOUNT EXISTS//
		Account member = null;
		
		if(accounts.size() != 0) {
			for(String s : accounts) {
				String[] line = s.split(",");
				if(line[0].equalsIgnoreCase(userName) && Account.checkPass(pass, line[1])) {
					member = new Account(line[0], pass, line[2]);
					memberExists = true;
				}
			}
		}
		
		
		if(!memberExists) {
			System.out.println("Your credentials do not match an account. Select an option:\n\nCreate new account (c)\nTry Again (Any other key)");
			String answer = console.nextLine().toUpperCase();
			
			if(answer.equals("C")) {
				member = createAccount(console, accounts);
			} else {
				member = login(console);
			}
		} 
		return member;
	}
	
	//TO-DO: Implement way of checking whether user-name already exists.
	//CONTINUE HERE DUPLICATE NAMES NOT SAVING
	public static Account createAccount(Scanner console, ArrayList<String> accounts) {
		String userName = "";
		String pass = "";
		boolean success = false;
		
		System.out.print("Thank you for considering an account with us!\n\nPlease enter a desired username: ");
		while(!success) {
			userName = console.nextLine();
			for(String s : accounts) {
				String[] line = s.split(",");
				if(!line[0].equalsIgnoreCase(userName)) {
					success = true;
				} else {
					success = false;
					break;
				}
			}
			if(!success) {
				System.out.print("The username you have chosen is already taken.\nTry again with a different username: ");
			}
		}

		success = false;
		
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
		System.out.print("How much would you like to deposit to start the account?\n$");	
		int depositAmount = 0;

		while(!success) {
			if(console.hasNextDouble()) {
				depositAmount = (int) console.nextDouble();
				success = true;
			} else {
				console.nextLine();
				System.out.print("You did not enter a valid amount. Try again.\n$");
			}
		}
		console.nextLine();
		Account newAcct = new Account(userName, pass, depositAmount);
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("accounts.txt", true))) {
			bw.write(newAcct.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newAcct;
	}
	
	public static ArrayList<String> readAcctFile() {
		ArrayList<String> accounts = new ArrayList<String>();
		
		try(BufferedReader br = new BufferedReader(new FileReader("accounts.txt"))) {
			String currLine = null;
			while((currLine = br.readLine()) != null) {
				accounts.add(currLine);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return accounts;
	}
	
	public static void updateFile(Account member) {
		ArrayList<String> accounts = readAcctFile();
		if(accounts.size() != 0) {
			for(int i=0; i < accounts.size(); i++) {
				String[] line = accounts.get(i).split(",");
				if(line[0].equalsIgnoreCase(member.getName())) {
					accounts.remove(i);
					accounts.add(i,member.toString());
				}
			}
		}
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("accounts.txt"))) {
			for(String s : accounts) {
				bw.write(s.toString() + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void withdrawInteraction(Scanner console, Account member) {
		System.out.print("How much would you like to withdraw?\n$");
		int withdrawnAmount = 0;
		boolean success = false;
		while(!success) {
			if(console.hasNextDouble()) {
				withdrawnAmount = (int)console.nextDouble();
				if(!(success = member.withdraw(withdrawnAmount))) {
					System.out.print("You do not have enough funds for this transaction. Try again.\n$");
					console.nextLine();
				} 
			} else {
				console.nextLine();
				System.out.print("You did not enter a valid amount. Try again.\n$");
			}
		}
		System.out.println("You have withdrawn $" + withdrawnAmount + " from your account.");
		viewInteraction(member);
		updateFile(member);
		console.nextLine();
	}
	
	public static void depositInteraction(Scanner console, Account member) {
		System.out.print("How much would you like to deposit?\n$");
		int depositAmount = 0;
		boolean success = false;
		while(!success) {
			if(console.hasNextDouble()) {
				depositAmount = (int) console.nextDouble();
				success = member.deposit(depositAmount);
			} else {
				console.nextLine();
				System.out.print("You did not enter a valid amount. Try again.\n$");
			}
		}
		System.out.println("You have deposited $" + depositAmount + " to your account.");
		viewInteraction(member);
		updateFile(member);
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
			System.out.println("What would you like to do?\n\nWithdraw (W)\nDeposit (D)\nView Account (V)\nLogout (L)\nTerminate Application (T)\n");
			String option = console.nextLine().toUpperCase();
			
			switch(option) {
				case "W" :  withdrawInteraction(console, member); break;
				case "D" : depositInteraction(console, member); break;
				case "V" : viewInteraction(member); break;
				case "L" : loggedIn = false; break;
				case "T" : System.out.println("Thank you for using this bank!"); end = true; break;
				default  : System.out.println("Please use one of the options above."); break;
			}
		}
	}
}
