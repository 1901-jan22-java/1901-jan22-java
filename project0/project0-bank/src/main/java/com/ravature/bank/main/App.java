package com.ravature.bank.main;
import java.util.Scanner;
import com.ravature.bank.views.ViewUsers;
public class App {
	public static void main(String[] args) {
		System.out.println("Revature Bank");
		menu();
	}
	private static void menu(){
		System.out.println("[Login] : (1)");
		System.out.println("[New Account] : (2)");
		System.out.println("[Close] : (3)");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();;
		if(input == 1)
		{
			ViewUsers.login();
		}
		else if(input == 2)
		{
			ViewUsers.add();
		}
		else {
			closeApp(input);
		}
		scan.close();
	}
	public static void closeApp(int option) {
		System.out.println("Thank You! Have a nice day!");
		System.exit(option);
	}
}