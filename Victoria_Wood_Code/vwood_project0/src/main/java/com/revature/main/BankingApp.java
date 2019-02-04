package com.revature.main;

import java.util.Scanner;

public class BankingApp {
	
	public static void main(String[] args) {
		System.out.println("Welcome to VW Bank /n");
		accessAccount();
	}
	
	static void accessAccount() {
		Scanner scan = new Scanner(System.in);
		int attempts = 0;
		while (attempts < 4) {
			System.out.println("If you would like to Log-In press 'l' \n" + 
					"If you would like to creat an account press 'c'");
			if(scan.nextLine().equals("l")) {
				System.out.println("Username: ");
				System.out.println("Password: ");
			}
		}
	}

}
