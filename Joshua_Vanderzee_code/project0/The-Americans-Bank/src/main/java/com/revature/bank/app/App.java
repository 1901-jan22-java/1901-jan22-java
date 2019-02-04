package com.revature.bank.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.bank.jdbc.dao.UserAccountControler;
import com.revature.bank.jdbc.pojos.User;

public class App {

	public static void main(String[] args) {
		while(true) {
			System.out.println("Welcome to American's Bank. \nChoose an option below.");
			boolean active = true;			
			switch (choice("Create an account", "Login to account")) {
			case 1:
				while (active) {
					String UserId, UserName, Password, FirstName, LastName, SecurityQuestion1, SecurityAnswer1, SecurityQuestion2, SecurityAnswer2, SecurityQuestion3, SecurityAnswer3, Addressline1, Addressline2, City, States, Country, PostalCode, HomePhone, CellPhone, Fax, Email, SSN, BirthDate, Maritalstatus;
					UserId = java.sql.
					UserName, 
					Password, 
					FirstName, 
					LastName, 
					SecurityQuestion1, 
					SecurityAnswer1, 
					SecurityQuestion2, 
					SecurityAnswer2, 
					SecurityQuestion3, 
					SecurityAnswer3, 
					Addressline1, 
					Addressline2, 
					City, 
					States, 
					Country, 
					PostalCode, 
					HomePhone,
					CellPhone, 
					Fax, 
					Email, 
					SSN, 
					BirthDate, 
					Maritalstatus
					
					
					
					User user = new User(UserId, UserName, Password, FirstName, LastName, SecurityQuestion1, SecurityAnswer1, SecurityQuestion2, SecurityAnswer2, SecurityQuestion3, SecurityAnswer3, Addressline1, Addressline2, City, States, Country, PostalCode, HomePhone, CellPhone, Fax, Email, SSN, BirthDate, Maritalstatus)
					
					
					UserAccountControler.CreateAccount(user)
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
