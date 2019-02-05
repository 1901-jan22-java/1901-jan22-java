package com.project.managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class SignupManager implements Manager { 
	
	final static Logger logger = Logger.getLogger(SignupManager.class);
	
	@Override
	public void takeover(Scanner scan) {
		List<String> account_options = new ArrayList<>(Arrays.asList(
			new String[] {
					"saving",
					"checking",
					"icba",
					"ira", 
					"brokerage"
				}
		));
		String[] data = new String[3];
		String input;
		
		// Username loop - loops user until user enters quit or gives a proper username
		System.out.println("\nPlease create your username.");
		input = scan.nextLine();
		while(true) {
			if(input.toLowerCase().equals("quit")) return;
			else if(Manager.dao.doesUserExist(input)) {
				System.out.println("\nSorry, that username already exists. Try entering a different username.");
				input = scan.nextLine();
			} else {
				data[0] = input;
				break;
			};
		}
		
		// Password loop - loops user until user enters quit or gives a proper password
		System.out.println("\nHello " + data[0] + ", please create your password");
		input = scan.nextLine();
		while(true) {
			if(input.toLowerCase().equals("quit")) return;
			else if(input.isEmpty()) {
				System.out.println("\nYour password is empty. Please try again.");
				input = scan.nextLine();
			} else {
				data[1] = input;
				break;
			};
		}
		
		// Account Type loop - loops user until user enters quit or selects an account
		// User should get a full list of available account types when they enter
		// "ACCOUNT_OPTIONS"
		System.out.println("\nFinally, please select the account you would like to open!"
				+ "\nHere at J&J Banking, we offer CHECKING, SAVING and much more."
				+ "\nPlease enter ACCOUNT_OPTIONS for a full list of account types.");
		input = scan.nextLine();
		while(true) {
			if(input.toLowerCase().equals("quit")) return;
			else if(input.toLowerCase().equals("account_options")) {
				System.out.println("\nJ&J Banking currently offers the following account options:"
						+ "\nSAVING | CHECKING | Interest Bearing Checking Account (IBCA)"
						+ "\nIndividual Retirement Accont (IRA) | BROKERAGE "
						+ "\n\nYou may select your account using the commands below:");
				for(String acct : account_options)
					System.out.println(acct.toUpperCase());
				input = scan.nextLine();
			}
			else if(!account_options.contains(input.toLowerCase())) {
				System.out.println("\nSorry! Your selection is not recognized."
						+ "\nPlease enter ACCOUNT_OPTIONS for a full list of account types.");
				input = scan.nextLine();
			} else {
				data[2] = input;
				break;
			};
		}
		
		System.out.println("Please hold as your account is currently being created...");
		logger.info("Data Array: " + data[0] + " : " + data[1] + " : " + data[2] + 
				" account corresponds to int value " + account_options.indexOf(data[2]));
		Manager.dao.createAccount(data[0], data[1], account_options.indexOf(data[2]));
		System.out.println("Account creation successful!");
		return;
	}

	public static void main(String[] args) {
		new SignupManager().takeover(new Scanner(System.in));
	}
	
}
