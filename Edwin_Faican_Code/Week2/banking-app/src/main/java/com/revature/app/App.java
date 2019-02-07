package com.revature.app;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.revature.account.Account;
import com.revature.client.Client;
import com.revature.exceptions.UsernameException;
import com.jdbc.dao.ClientRepository;
import com.jdbc.dao.AccountRepository;

public class App {
	final static Logger logger = Logger.getLogger(App.class);
	
	//Login interaction. Checks whether the client wants to login or create a new user account. 
	public static Client login(Scanner console, ClientRepository cliRepo) {
		boolean memberExists = false;  //Placeholder for determining if member exists once data is persistent. 
		
		System.out.println("Welcome to the bank! Would you like to login or create a user account?\nLogin (L)\nCreate Account (C)\n");
		String option;
		while(!memberExists) {
			option = console.nextLine();
			if(option.equalsIgnoreCase("C")) {
				return createUserAccount(console,cliRepo);
			} else if(option.equalsIgnoreCase("L")){
				System.out.print("Please enter your login credentials.\nUsername: ");
				String username = console.nextLine();
				System.out.print("Password: ");
				String pass = console.nextLine();
				
				Client check = cliRepo.findClient(username);
				if(Client.checkPass(pass, check.getPassword())) {
					return check;
				} else {
					System.out.println("Your credentials do not match an account. Try again (L) or create an account (C)");
				}
			} else {
				System.out.println("Please select an option from the following by letter:\nLogin (L)\nCreate Account (C)\n");
			}
		}
		return null;
	}
	
	//Create user accounts for a client to be able to log in. Save the username, password and personal information 
	//To the database. 
	public static Client createUserAccount(Scanner console, ClientRepository cliRepo)  {
		String username = "";
		String pass = "";
		boolean success = false;
		
		//Ensure that the username is unique.
		System.out.print("Thank you for considering an account with us!\n\nPlease enter a desired username: ");
		while(!success) {
			username = console.nextLine();
			logger.debug(username);
			try {
				if(cliRepo.findClient(username).getFirstname() != null) {
					logger.debug("The username you have chosen is already taken.\nTry again with a different username: ");
					throw new UsernameException(username);
				} else {
					success = true;
				}
			} catch (UsernameException e) {

			}

		}
		
		success = false;
		
		//Ensure that passwords are identical. 
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
		
		//Obtain personal information. 
		System.out.print("Creating a user account requires some personal information for security purposes.\nPlease enter your first name: ");
		String firstname = console.nextLine();
		System.out.print("Please enter your last name: ");
		String lastname = console.nextLine();
		
		System.out.println("Thank you for your consideration in the bank! We welcome your business!");
		
		//Save client data to database and return the client. 
		Client temp = new Client();
		temp.setPassword(pass);
		return cliRepo.newClient(firstname, lastname, username, temp.getPassword());
	}
	
	//Allows the client to choose an account from a list of all accounts associated with that client. 
	//Returns this account back to the main menu. 
	public static Account selectAccount(Scanner console, Client client, AccountRepository accRepo) {
		List<Account> accounts = accRepo.findAccounts(client.getClientId());
		
		//Create an account if none exists. 
		if(accounts.size() == 0) {
			System.out.println("\nIt appears you do not have an account with the bank. Redirecting to account creating portal:\n\n");
			return createAccount(console, client, accRepo);
		}
		
		//List of accounts. 
		System.out.println("\nThese are your accounts: ");
		for(int i=0; i<accounts.size(); i++) {
			System.out.println((i+1) + ". " + accounts.get(i).toString());
		}
		System.out.println((accounts.size() + 1) + ". Create a new account");
		
		System.out.println("Select an account by associated number.\n");
		
		int selection = -1;
		boolean success = false;
		
		//Ensure selection is within bounds. 
		while(!success) {
			if(console.hasNextInt()) {
				selection = console.nextInt();
				if(selection > 0 &&  selection <= accounts.size()) {
					selection--;
					console.nextLine();
					success = true;
				} else if(selection == (accounts.size() + 1)) {
					return createAccount(console,client,accRepo);
				} else {
					System.out.println("You did not choose and option from above. Try again.\n");
				}
			} else {
				console.nextLine();
				System.out.print("You did choose an option from above. Try again.\n");
			}
		}

		return accounts.get(selection);
	}
	
	//Create a banking account, establish account type and determine initial deposit. 
	public static Account createAccount(Scanner console, Client client, AccountRepository accRepo) {
		System.out.println("Thank you for opening an account at the bank! To begin, what type of account would you like?\nSelect by associated number.\n");
		
		//Query  database for all account types. 
		List<String> types = accRepo.accountTypes();
		
		for(int i=0; i<types.size(); i++) {
			System.out.println((i+1) + ". " + types.get(i));
		}
		int selection = -1;
		boolean success = false;
		
		//Ensure selection is within bounds. 
		while(!success) {
			if(console.hasNextInt()) {
				selection = console.nextInt();
				if(selection > 0 && selection < types.size()+1) {
					console.nextLine();
					success = true;
				} else {
					System.out.println("You did not choose an option from above. Try again\n");
				}
			} else {
				console.nextLine();
				System.out.print("You did choose an option from above. Try again.\n");
			}
		}
		success = false;
		
		//Determine initial deposit. 
		System.out.print("How much would you like to deposit to start the account?\n$");	
		BigDecimal depositAmount = null;
		String deposit = "";

		while(!success) {
			if(console.hasNextDouble()) {
				deposit = console.nextLine();
				if(((deposit.contains(".") && deposit.substring(deposit.indexOf(".")).length() == 3) || !deposit.contains(".")) && !deposit.contains("-")) {
					if(deposit.contains(",")) {
						deposit = deposit.substring(0,deposit.indexOf(",")) + deposit.substring(deposit.indexOf(",")+1, deposit.length());
					}
					depositAmount = new BigDecimal(deposit);
					success = true;
				} else {
					System.out.print("You did not enter a valid amount. Try again.\n$");
				}
			} else {
				console.nextLine();
				System.out.print("You did not enter a valid amount. Try again.\n$");
			}
		}
		//Return the newly created account while also saving it to the database. 
		logger.debug(depositAmount);
		return accRepo.openAccount(selection, client.getClientId(), depositAmount.doubleValue());
	}
	
	//Withdraws money from an account. Ensure amount is valid. Return newly adjusted account. 
	public static void withdrawInteraction(Scanner console, Account acc, AccountRepository accRepo) {
		System.out.print("How much would you like to withdraw?\n$");
		BigDecimal withdrawnAmount = null;
		String withdraw = "";
		boolean success = false;
		
		//Ensure amount is a valid monetary value. 
		while(!success) {
			if(console.hasNextDouble()) {
				withdraw = console.nextLine();
				if(((withdraw.contains(".") && withdraw.substring(withdraw.indexOf(".")).length() == 3) || !withdraw.contains(".")) && !withdraw.contains("-")) {
					if(withdraw.contains(",")) {
						withdraw = withdraw.substring(0,withdraw.indexOf(",")) + withdraw.substring(withdraw.indexOf(",")+1, withdraw.length());
					}
					withdrawnAmount = new BigDecimal(withdraw);
					if(!(success = acc.withdraw(withdrawnAmount))) {
						System.out.print("You do not have enough funds for this transaction. Try again.\n$");
					} 
				} else {
					System.out.print("You did not enter a valid amount. Try again.\n$");
				}

			} else {
				console.nextLine();
				System.out.print("You did not enter a valid amount. Try again.\n$");
			}
		}
		
		//Update account balance and save to database. 
		accRepo.updateBalance(acc);
		System.out.println("You have withdrawn $" + withdrawnAmount + " from your account.");
		viewInteraction(acc);
	}
	
	//Deposit interaction for the client. Verify that deposit amount is a monetary value. 
	public static void depositInteraction(Scanner console, Account acc, AccountRepository accRepo) {
		System.out.print("How much would you like to deposit?\n$");
		String deposit = "";
		BigDecimal depositAmount = null;
		
		//Ensure monetary value is valid. 
		boolean success = false;
		while(!success) {
			if(console.hasNextDouble()) {
				deposit = console.nextLine();
				if(((deposit.contains(".") && deposit.substring(deposit.indexOf(".")).length() == 3) || !deposit.contains(".")) && !deposit.contains("-")) {
					if(deposit.contains(",")) {
						deposit = deposit.substring(0,deposit.indexOf(",")) + deposit.substring(deposit.indexOf(",")+1, deposit.length());
					}
					depositAmount = new BigDecimal(deposit);
					success = acc.deposit(depositAmount);
				} else {
					System.out.print("You did not enter a valid amount. Try again.\n$");
				}
			} else {
				console.nextLine();
				System.out.print("You did not enter a valid amount. Try again.\n$");
			}
		}
		//Update account balance and save to database. 
		accRepo.updateBalance(acc);
		System.out.println("You have deposited $" + depositAmount + " to your account.");
		viewInteraction(acc);
	}
	
	//Simple view of account and how much money is in the account. 
	public static void viewInteraction(Account acc) {
		System.out.println("You currently have $" + acc.viewAccount() + " in your account.");
	}
	
	//Update user name/password of a user. Ensures that user name is unique but validates the same user name if used again. 
	public static void updateAccount(Scanner console, Client client, ClientRepository cliRepo) {
		boolean success = false;
		System.out.print("Please select new username. If unchanged, type your current username.\n");
		String username = "";
		//Ensure username is unique.
		while(!success) {
			username = console.nextLine();
			if(username.equalsIgnoreCase(client.getUsername()) || cliRepo.findClient(username).getFirstname() == null) {
				success = true;
			} else {
				System.out.print("The username you have chosen is already taken.\nTry again with a different username: ");
			} 
		}
		
		success = false;
		
		String pass = "";
		
		//Confirm identical passwords. 
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
		client.setUsername(username);
		client.setPassword(pass);
		
		//Return updated client and save to database. 
		cliRepo.updateUser(client);
		System.out.println("Username/password have been updated. Returning to settings menu.\n");
	}
	
	//Interaction for closing account. Ensure money goes somewhere! 
	public static void closeAccount(Scanner console, Account acc, Client client, AccountRepository accRepo) {
		System.out.println("You are about to close this account.\nYou can withdraw all money for this account or transfer it to another account.");
		boolean success = false;
		BigDecimal balance = new BigDecimal(acc.getBalance() + "");
		String option = null;
		
		//If only one account exists, the application becomes sad that the client is closing the only account and automatically sets to withdraw. 
		if(accRepo.findAccounts(client.getClientId()).size() == 1) {
			   System.out.println("You cannot transfer because you only have one account");
			   option = "W";
		}
		
		//Either withdraw all money before closing account or transfer to another account. 
		while(!success) {
			if(option == null) {
				System.out.println("Withdraw (W)\nTransfer (T)\n");
				option = console.nextLine().toUpperCase();
			}
			
			//Manages selection of the client. Either money is withdrawn or money is transfered and updated to another account. 
			switch(option) {
				case "W" : acc.setBalance(0); accRepo.updateBalance(acc); accRepo.closeAccount(acc); System.out.println("You have withdrawn $" + balance); success = true; break;
				case "T" : Account transferInto = acc;
						   while(transferInto.getAcctNumber() == acc.getAcctNumber()) {
							    transferInto = selectAccount(console, client, accRepo);
							    
							    if(transferInto.getAcctNumber() == acc.getAcctNumber()) {
									System.out.println("You cannot trasfer into the account you are closing. Choose another account.");
							    }
						   };
						   transferInto.deposit(balance);
						   acc.setBalance(0);
						   accRepo.updateBalance(transferInto);
						   accRepo.updateBalance(acc);
						   accRepo.closeAccount(acc);
						   
						   System.out.println("You have transfered $" + balance + " into X-" + (acc.getAcctNumber() + "").substring((acc.getAcctNumber() + "").length()-5) + "\n");
						   System.out.println("Please Select another account to proceed with.\n");
						   success = true;
						   break;
				default  : System.out.println("Please select from above statement by associated letter."); option = null; break;
			}
		}
		
	}
	
	//Account settings menu.
	public static void accountSettings(Scanner console, Account acc, Client client, ClientRepository cliRepo, AccountRepository accRepo) {
		boolean back = false;		
		while(!back) {
			System.out.println("----");
			System.out.println("Please select a setting.\n\nUpdate Username/Password (U)\nClose an Account (C)\nBack to main menu (B)\n");

			String option = console.nextLine().toUpperCase();
			
			switch(option) {
				case "U" : updateAccount(console, client, cliRepo); break;
				case "C" : closeAccount(console, acc, client, accRepo); back = true; break;
				case "B" : System.out.println("Returning to main menu."); back = true; break;
			}
		}
	}
	
	//Main method contains the main menu options for client. 
	public static void main(String[] args) {
		ClientRepository cliRepo = new ClientRepository();
		AccountRepository accRepo = new AccountRepository();
		Scanner console = new Scanner(System.in);
		Client client = null;
		Account acc = null;
		boolean end = false;
		boolean loggedIn = false;
		boolean accountLogged = false;
		
		//Until the client chooses to terminate program, main menu is reached after every interaction. 
		while(!end) {
			if(!loggedIn) {
				client = login(console, cliRepo);
				loggedIn = true;
			}
			if(!accountLogged) {
				acc = selectAccount(console, client, accRepo);
				accountLogged = true;
			}
			System.out.println("----");
			System.out.println("Welcome, " + client.getFirstname() + "!");
			System.out.println("What would you like to do?\n\nWithdraw (W)\nDeposit (D)\nView Account Balance (V)\nChoose Another Account (A)\nAccount Settings (S)\nLogout (L)\nTerminate Application (T)\n");
			String option = console.nextLine().toUpperCase();
			
			switch(option) {
				case "W" : withdrawInteraction(console, acc, accRepo); break;
				case "D" : depositInteraction(console, acc, accRepo); break;
				case "V" : viewInteraction(acc); break;
				case "L" : loggedIn = false; accountLogged = false; break;
				case "A" : accountLogged = false; break;
				case "S" : accountSettings(console, acc, client, cliRepo, accRepo); accountLogged = false; break;
				case "T" : System.out.println("Thank you for using this bank!"); end = true; break;
				default  : System.out.println("Please use one of the options above."); break;
			}
		}
	}
}
