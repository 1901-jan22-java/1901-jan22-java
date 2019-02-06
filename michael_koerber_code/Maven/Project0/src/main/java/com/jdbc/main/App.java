package com.jdbc.main;

import java.util.List;
import java.util.Scanner;

import com.jdbc.dao.RoleRepository;
import com.jdbc.pojos.Role;
import com.jdbc.views.AccountView;
import com.jdbc.views.UserView;

public class App {

	public static void main(String[] args) {
//		RoleRepository roleRepo = new RoleRepository();
//		List<Role> roles = roleRepo.findAll();
		
//		System.out.println(roles);
//		System.out.println(roleRepo.getById(1));
		
//		Role r = roleRepo.save("Salesforce Director");
//		List<Role> roles = roleRepo.findAll();
//		System.out.println(roles);
		
//		Role r = new Role(3, "Housing Coordinator");
//		roleRepo.update(r);
//		List<Role> roles = roleRepo.findAll();
		System.out.println("Welcome to your Bank");
		homeMenu();
	}
	
	private static void homeMenu(){
		System.out.println("Please choose an option" + "\n"
				+ " Enter 1 to Login" + "\n"
				+ " Enter 2 to Create a New Account" + "\n"
				+ " Enter 3 to Exit");
		Scanner scan = new Scanner(System.in);
		int option = 0;
		if(scan.hasNextInt()){
			option = scan.nextInt();
		} else {
			System.out.println("You must enter 1, 2, or 3");
			homeMenu();
		}
		
		switch(option){
		case 1:
			UserView.userLogin();
			break;
		case 2:
			UserView.addUser();
			break;
		case 3:
			closeApp(option);
			break;
		}
		scan.close();
	}
	
	public static void closeApp(int option) {
		System.out.println("Have a great day!");
		System.exit(option);
	}
}
