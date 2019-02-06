package com.ravature.bank.main;
import java.util.Scanner;
import com.ravature.bank.views.UserView;
public class App {
	public static void main(String[] args) {
		System.out.println("Revature Bank");
		menu();
	}
	private static void menu(){
		System.out.println(" [Login] (1)");
		System.out.println(" [New Account] (2)");
		System.out.println(" [Close] (3)");
		Scanner scan = new Scanner(System.in);
		int option = scan.nextInt();;
		if(option == 1)
		{
			UserView.login();
		}
		else if(option == 2)
		{
			UserView.add();
		}
		else {
			closeApp(option);
		}
		scan.close();
	}
	public static void closeApp(int option) {
		System.out.println("Thank You! Have a nice day!");
		System.exit(option);
	}
}