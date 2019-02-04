package com.revature.bank.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.bank.jdbc.dao.UserAccountControler;
import com.revature.bank.jdbc.pojos.User;

/**
 * @author thejo
 *
 */
public class App {

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
					int UserId, SSN, PostalCode, HomePhone, CellPhone, Fax; 
					Date BirthDate;
					
					UserId = -1;
					System.out.print("Username: ");
					UserName = getUserInput();
					System.out.print("Username: ");
					Password = getUserInput();
					System.out.print("Username: ");
					FirstName = getUserInput();
					System.out.print("Username: ");
					LastName = getUserInput();
					System.out.print("Username: ");
					SecurityQuestion1 = getUserInput();
					System.out.print("Username: ");
					SecurityAnswer1 = getUserInput();
					System.out.print("Username: ");
					SecurityQuestion2 = getUserInput();
					System.out.print("Username: ");
					SecurityAnswer2 = getUserInput();
					System.out.print("Username: ");
					SecurityQuestion3 = getUserInput();
					System.out.print("Username: ");
					SecurityAnswer3 = getUserInput();
					System.out.print("Username: ");
					Addressline1 = getUserInput();
					System.out.print("Username: ");
					Addressline2 = getUserInput();
					System.out.print("Username: ");
					City = getUserInput();
					System.out.print("Username: ");
					States = getUserInput();
					System.out.print("Username: ");
					Country = getUserInput();
					System.out.print("Username: ");
					PostalCode = getUserInputInt();
					System.out.print("Username: ");
					HomePhone = getUserInputInt();
					System.out.print("Username: ");
					CellPhone = getUserInputInt();
					System.out.print("Username: ");
					Fax = getUserInputInt();
					System.out.print("Username: ");
					Email = getUserInput();
					System.out.print("Username: ");
					SSN = Integer.parseInt(getUserInput());
					SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
					while (true) {
						System.out.print("Username: ");
						try {
							BirthDate = sdf.parse(getUserInput());
							break;
						} catch (ParseException e) {
							System.out.println("Invalid Date. ");
						}
					}
					System.out.print("Username: ");
					Maritalstatus = getUserInput();
					
					User user = new User(UserId, UserName, Password, FirstName, LastName, 
							SecurityQuestion1, SecurityAnswer1, SecurityQuestion2, SecurityAnswer2, SecurityQuestion3, SecurityAnswer3, 
							Addressline1, Addressline2, City, States, Country, PostalCode, HomePhone, CellPhone, Fax, 
							Email, SSN, BirthDate, Maritalstatus);
					
					
					UserAccountControler.CreateAccount(user);
				}
				break;
			case 2:				
				while (active) {
					UserAccountControler.Login("bob", "grgsdg");					
				}
				break;
			default:
				System.out.println("Invalid option. Please choose one of the items available. ");
			}
		}	
	}
	
	private static String getUserInput() {
		while (true) {
			try (Scanner c = new Scanner(System.in)){
				return c.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Invalid type");
			}
		}
	}
	
	private static int getUserInputInt() {
		while (true) {
			try (Scanner c = new Scanner(System.in)){
				return Integer.parseInt(c.nextLine());
			} catch (InputMismatchException e) {
				System.out.println("Invalid input");
			}
		}
	}
	
	private static int choice(String... str) {
		while (true) {
			int count = 0;
			try (Scanner c = new Scanner(System.in)){
				for (String string : str) {
					System.out.println(++count + ": " + string);
				}
				return Integer.parseInt(c.nextLine());
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please use a number");
			}
		}
	}
}
