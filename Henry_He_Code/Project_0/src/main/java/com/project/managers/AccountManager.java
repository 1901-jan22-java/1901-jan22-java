package com.project.managers;

public class AccountManager extends Manager{
	
	String[] acct_type = {
			"saving",
			"checking",
			"icba",
			"ira", 
			"brokerage"
	};
	
	String[] userdata;
	
	static void printBalance(String balance) {
		System.out.println("\nYour current balance is: " + balance
				+ "\nPlease enter DEPOSIT, WITHDRAW, or QUIT.");
	};
	
	static boolean isNumeric(String str){
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
	
	class InputException extends Exception {
		InputException(String str) {super(str);}
	}
	
	void validate(String input) throws InputException {
		if( !isNumeric(input) ) {
			input = "0";
			throw new InputException("Input is not numeric!");
		}
		else return;
	}
	
	void validate(int balance, int withdrawnAmount) throws InputException {
		if( balance-withdrawnAmount < 0 ) {
			withdrawnAmount = 0;
			throw new InputException("Withdrawn amount exceeds current balance.");
		}
		else return;
	}
	
	void takeover(String userid){
		
		
		userdata = Manager.dao.getUserData(userid);
		
		System.out.println("\nWelcome to your " + acct_type[Integer.parseInt(userdata[3])].toUpperCase() + ", " + userdata[1] 
				+ "! Your current balance is: " + userdata[2]
				+ "\nWould you like to DEPOSIT or WITHDRAW funds?");
		boolean validated = false;
		String cmd = scan.nextLine().toLowerCase();
		String input;
		
		while(!cmd.equals("quit")) {
			
			switch(cmd) {
			
				case "withdraw":
					System.out.println("\nEnter the amount you wish to withdraw:");
					input = scan.nextLine();
					try {
						validate(input);
						validate(Integer.parseInt(userdata[2]),Integer.parseInt(input));
						validated = true;
					} catch (InputException e) {
						System.out.println("\nInvalid input: "
								+ "You may have entered a number exceeding your current balance, "
								+ "or did not enter a number.");
					}
					if(validated) 
						userdata[2] = Integer.toString((Integer.parseInt(userdata[2]) - Integer.parseInt(input)));
					validated = false;
					cmd = "loop_back";
					continue;
				
				case "deposit":
					System.out.println("\nEnter the amount you wish to deposit:");
					input = scan.nextLine();
					try {
						validate(input);
						validated = true;
					} catch (InputException e) {
						System.out.println("\nInvalid input: you did not enter a number.");
					}
					if(validated) 
						userdata[2] = Integer.toString((Integer.parseInt(userdata[2]) + Integer.parseInt(input)));
					validated = false;
					cmd = "loop_back";
					continue;
				
				case "loop_back":
					printBalance(userdata[2]);
					break;
				
				default: 
					System.out.println("\nPlease try a different command."); 
					break;
			
			}
			
			cmd = scan.nextLine().toLowerCase();
			
		}
		Manager.dao.updateAccount(userdata[2],userdata[0]);
		return;
	
	}
}
