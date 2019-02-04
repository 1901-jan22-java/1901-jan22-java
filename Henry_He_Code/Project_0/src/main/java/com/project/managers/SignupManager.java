package com.project.managers;

import java.util.Scanner;

public class SignupManager extends Manager{

	@Override
	public
	void takeover() {
		Scanner scan = new Scanner(System.in);
		String input;
		
		System.out.println("Enter your username:");
		input = scan.nextLine();
		if(input.toLowerCase().equals("quit")) {
			scan.close();
			return;
		} else {
			
		};
		
		System.out.println("Enter your password");
		input = scan.nextLine();
		if(input.toLowerCase().equals("quit")) {
			scan.close();
			return;
		} else {
			
		};
		
		scan.close();
		return;
	}

}
