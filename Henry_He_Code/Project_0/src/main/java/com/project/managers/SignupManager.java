package com.project.managers;

import java.util.Scanner;

public class SignupManager implements Manager { 
	
	@Override
	public void takeover(Scanner scan) {
		String[] data = new String[2];
		String input;
		
		System.out.println("\nPlease create your username.");
		input = scan.nextLine();
		if(input.toLowerCase().equals("quit")) {
			return;
		} else data[0] = input;
		
		System.out.println("\nHello " + data[0] + ", please create your password");
		input = scan.nextLine();
		if(input.toLowerCase().equals("quit")) {
			return;
		} else data[1] = input;
		
		return;
	}

}
