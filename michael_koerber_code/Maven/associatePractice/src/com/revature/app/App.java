package com.revature.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.app.App;
import com.revature.dao.AssociateRepository;
import com.revature.exceptions.UserNotFound;
import com.revature.pojo.Associate;

public class App {

	public static void main(String[] args) {
		System.out.println("How can I help\n");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter 1: Login\n" + "Enter 2: Create Associate\n" + "Enter 3: Exit");
		
		while(!scan.hasNextInt()){
			System.out.println("Please enter 1, 2, or 3");
			scan.next();
		}
		int result = scan.nextInt();
		AssociateRepository repo = new AssociateRepository();
		
		
		switch(result){
		case 1: 
		{	
			System.out.println("Enter email");
			String email = scan.next();
			System.out.println("Enter password");
			String password = scan.next();
			Associate a = null;
			try {
				a = repo.logIn(email, password);
				System.out.println("Successful Login");
			} catch (UserNotFound e) {
				e.printStackTrace();
			}
			AssociateMenu(a);
			break;
		}
		case 2:
		{
			System.out.println("Create Account\n" + "Please enter your firstname\n");
			String firstname = scan.next();
			System.out.println("Please enter your lastname\n");
			String lastname = scan.next();
			System.out.println("Please enter your email\n");
			String email = scan.next();
			while(!repo.validateEmail(email)){
				System.out.println("Email already taken, choose again");
				email = scan.next();
			}
			System.out.println("Please enter your password\n");
			String password = scan.next();
			Associate a = new Associate(firstname, lastname, email, password, 0);
			repo.createAssociate(a);
			try {
//				repo.logIn(email, password);
				AssociateMenu(a);
				System.out.println("Successful Login");				
			} catch(Exception e){
				
			}
		}
		case 3: 
		{
//			closeApp(result);
			System.exit(result);
		}
		}
		
		scan.close();
	}
	
	public static void AssociateMenu(Associate currAssociate){
		ArrayList<String> updateList = new ArrayList<String>();
		updateList.add(currAssociate.getFirstname());
		updateList.add(currAssociate.getLastname());
		updateList.add(currAssociate.getEmail());
		updateList.add(currAssociate.getPassword());
		
		AssociateRepository repo = new AssociateRepository();
		System.out.println("What would you like to do next?\n"
				+ "Enter 1 to update information\n" + "Enter 2 to Logout");
		Scanner scan = new Scanner(System.in);
		while(!scan.hasNextInt()){
			System.out.println("Please enter 1 or 2");
			scan.next();
		}
		int result = scan.nextInt();
		
		switch(result){
		case 1:
		{
			System.out.println("Firstname: " + updateList.get(0) + "\nLastname: " + updateList.get(1)
					+ "\nEmail: " + updateList.get(2));
			System.out.println("What would you like to update?\n"
					+ "Enter 1 for First name\n"
					+ "Enter 2 for Last Name\n"
					+ "Enter 3 for Email\n"
					+ "Enter 4 for Password\n"
					+ "Enter 5 to exit");
			
			while(!scan.hasNextInt()){
				System.out.println("Please enter 1, 2, 3, 4, or 5");
				scan.next();
			}
			int choice = scan.nextInt();
			if(choice == 1){
				System.out.println("What is your new first name?");
				String firstname = scan.next();
				repo.updateAssociateInfo(updateList, firstname, 0);
			} else if(choice == 2){
				System.out.println("What is your new last name?");
				String lastname = scan.next();
				repo.updateAssociateInfo(updateList, lastname, 1);
			} else if(choice == 3){
				System.out.println("What is your new email?");
				String email = scan.next();
				repo.updateAssociateInfo(updateList, email, 2);
			} else if(choice == 4){
				System.out.println("What is your new password?");
				String password = scan.next();
				repo.updateAssociateInfo(updateList, password, 3);
			} else if(choice == 5){
				String[] args = new String[0];
				App.main(args);
			} else {
				System.out.println("Please enter a choice between 1 and 4");
				AssociateMenu(currAssociate);
			}
			break;
		}
		case 2: 
		{
			String[] args = new String[1];
			App.main(args);
			break;
		}
		}
		AssociateMenu(currAssociate);
		scan.close();
	}
}
