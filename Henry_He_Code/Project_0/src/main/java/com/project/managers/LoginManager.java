package com.project.managers;

import java.util.Scanner;

public class LoginManager extends Manager{

	@Override
	public void takeover() {
		Scanner scan = new Scanner(System.in);
		String[] data = new String[2];
		String input;
		
		System.out.println("\nPlease enter your username.");
		input = scan.nextLine();
		if(input.toLowerCase().equals("quit")) {
			scan.close();
			return;
		} else data[0] = input;
		
		System.out.println("\nHello " + data[0] + ", please enter your password");
		input = scan.nextLine();
		if(input.toLowerCase().equals("quit")) {
			scan.close();
			return;
		} else data[1] = input;
		
		scan.close();
		return;
	}

}
