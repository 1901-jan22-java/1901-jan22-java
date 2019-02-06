package com.revature.bank.app;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.text.DecimalFormat;

import com.revature.bank.jdbc.dao.UserAccountControler;
import com.revature.bank.jdbc.pojos.Account;
import com.revature.bank.jdbc.pojos.User;

/**
 * @author thejo
 *
 */
public class App {

	private static Scanner c = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("Welcome to American's Bank. \nChoose an option below.");
			boolean active = true;			
			switch (choice("Create an account", "Login to account")) {
			case 1:
				while (active) {
					String UserName, Password, FirstName, LastName, 
					SecurityQuestion1, SecurityAnswer1, SecurityQuestion2, SecurityAnswer2, SecurityQuestion3, SecurityAnswer3, 
					Addressline1, Addressline2, City, States, Country, Email, Maritalstatus;
					long UserId, SSN, PostalCode, HomePhone, CellPhone, Fax; 
					Date BirthDate;
					
					UserId = -1;
					System.out.print("Username: ");
					UserName = getUserInput();
					while (true)
					{
						System.out.print("Password: ");
						String pass = getUserInput();
						System.out.print("Confirm Password: ");
						if (pass.equals(getUserInput())) {
							Password = pass;
							break;
						}
						System.out.println("Password did not match. Please retype.");
					}
					System.out.print("First Name: ");
					FirstName = getUserInput();
					System.out.print("Last Name: ");
					LastName = getUserInput();
					System.out.println("Security Question 1: ");
					SecurityQuestion1 = choice(1, "Mother's Maiden Name", 
							"What was your childhood nickname? ", 
							"What is the name of your favorite childhood friend? ", 
							"What is the middle name of your youngest child?");
					System.out.print("Answer: ");
					SecurityAnswer1 = getUserInput();
					System.out.println("Security Question 2: ");
					SecurityQuestion2 = choice(1, "What is the name of the place your wedding reception was held?", 
							"Where were you when you first heard about 9/11?", 
							"What school did you attend for sixth grade?",
							"What is your oldest cousin's first and last name?");
					System.out.print("Answer: ");
					SecurityAnswer2 = getUserInput();
					System.out.println("Security Question 3: ");
					SecurityQuestion3 = choice(1, "In what city or town was your first job?",
							"What is the name of a college you applied to but didn't attend?",
							"In what city did you meet your spouse/significant other?",
							"Where were you when you had your first kiss? ");
					System.out.print("Answer: ");
					SecurityAnswer3 = getUserInput();
					System.out.print("Address 1: ");
					Addressline1 = getUserInput();
					System.out.print("Address 2 (Optional): ");
					Addressline2 = getUserInput();
					System.out.print("City: ");
					City = getUserInput();
					System.out.print("State: ");
					States = getUserInput();
					System.out.print("Country: ");
					Country = getUserInput();
					System.out.print("Postal Code: ");
					PostalCode = getUserInputLong(true);
					System.out.print("Home Phone: ");
					HomePhone = getUserInputLong(false);
					System.out.print("Cell Phone: ");
					CellPhone = getUserInputLong(false);
					System.out.print("Fax (Optional): ");
					Fax = getUserInputLong(false);
					System.out.print("Email: ");
					Email = getUserInput();
					System.out.print("SSN: ");
					SSN = getUserInputLong(true);
					while (true) {
						System.out.print("Birth Date: ");
						try {
							BirthDate = Date.valueOf(getUserInput());
							break;
						} catch (Exception e) {
							System.out.println("Invalid Date. ");
						}
					}
					System.out.println("Marital Status: ");
					Maritalstatus = choice(1, "Married", "Single", "Devorsed");
					User user = new User(UserId, UserName, Password, FirstName, LastName, 
							SecurityQuestion1, SecurityAnswer1, SecurityQuestion2, SecurityAnswer2, SecurityQuestion3, SecurityAnswer3, 
							Addressline1, Addressline2, City, States, Country, PostalCode, HomePhone, CellPhone, Fax, 
							Email, SSN, BirthDate, Maritalstatus);
					
					UserAccountControler.CreateUser(user);
					break;
				}
			case 2:
				long id = -1;
				List<Account> accounts = null;
				while (active) {
					System.out.println("Username");
					String username = getUserInput();
					System.out.println("Password");
					String pass = getUserInput();
					id = UserAccountControler.Login(username, pass);
					if (id > 0) {
						accounts = UserAccountControler.findAllAccounts(id);
						break;
					}
				}
				while (active) {
					switch (choice("Create New Bank Accout", "View Accounts", "Deposite Money", "Withdraw Money", "Log out")) {
					case 1:
						String accountType = choice(1, "Checking", "Savings");
						long accountNumber = ThreadLocalRandom.current().nextLong(100000000, 999999999);
						long routingNumber = ThreadLocalRandom.current().nextLong(100000000, 999999999);
						long balance = getUserInputLong(false);
						
						Account temp = new Account();
						temp.setAccountType(accountType);
						temp.setAccountNumber(accountNumber);
						temp.setRoutingNumber(routingNumber);
						temp.setBalance(balance);
						accounts.add(temp);
						UserAccountControler.CreateAccount(id, temp);
						break;
					case 2:
						for(Account account : accounts)
						{
							System.out.println("Account: " + account.toString());
						}
						break;
					case 3:
						System.out.print("Choose an account id: ");
						long aID = getUserInputLong(true);
						System.out.print("Enter Amount: ");
						long aAmount = getUserInputLong(true);
						System.out.println(UserAccountControler.Deposite(aID, aAmount));
						break;
					case 4:
						System.out.print("Choose an account id: ");
						long aID2 = getUserInputLong(true);
						System.out.print("Enter Amount: ");
						long aAmount2 = getUserInputLong(true);
						System.out.println(UserAccountControler.Withdraw(aID2, aAmount2));
						break;
					case 5:
						active = false;
						break;
					}
				}
				break;
			default:
				System.out.println("Invalid option. Please choose one of the items available. ");
			}
		}	
	}
	
	private static String getUserInput() {
		while (true) {
			try {
				return c.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Invalid type");
			}
		}
	}
	
	private static long getUserInputLong(boolean required) {
		while (true) {
			try {
				String temp = c.nextLine();
				if (required) {
					if (!temp.equals(""))
						return Long.parseLong(temp);
					System.out.println("This feild is required.");
					continue;
				}
				return 0;
			} catch (Exception e) {
				System.out.println("Invalid input");
			}
		}
	}
	
	private static double getUserInputDouble(boolean required, boolean floor) {
		while (true) {
			try {
				String temp = c.nextLine();
				if (required) {
					if (!temp.equals("")) {
						DecimalFormat format = new DecimalFormat("##.00");
						return floor ? Math.round(Double.parseDouble(temp)) : Double.parseDouble(temp);
					}
					System.out.println("This feild is required.");
					continue;
				}
				return 0;
			} catch (Exception e) {
				System.out.println("Invalid input");
			}
		}
	}
	
	private static int choice(String... str) {
		while (true) {
			int count = 0;
			try {
				for (String string : str) {
					System.out.println(++count + ": " + string);
				}
				return Integer.parseInt(c.nextLine());
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please use a number");
			}
		}
	}
	
	private static String choice(int StartingNumber, String... str) {
		while (true) {
			int count = StartingNumber;
			try {
				for (String string : str) {
					System.out.println(count++ + ": " + string);
				}
				int index = Integer.parseInt(c.nextLine());
				return str[index - StartingNumber];
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please use a number");
			}
		}
	}
}
