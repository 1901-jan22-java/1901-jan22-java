package com.revature.bank.main;

import com.revature.bank.app.BankingInterface;

import java.util.Scanner;

public class BankApp {

	private BankingInterface bi;
	private Scanner s;

	public BankApp(){
		bi = null;
		s = new Scanner(System.in);
		banking();
	}

	public static void main(String[] args) {
		BankApp ba = new BankApp();
	}

	private void banking(){
		boolean exit = false;
		while(!exit) {
			System.out.print(BankAppHelper.MAIN_MENU);
			int selection = s.nextInt();
			s.nextLine();
			switch(selection) {
				case(1):
					createNewUser();
					break;
				case(2):
					if(login())
						session();
					break;
				default:
					exit = true;
			}
		}
		close();
	}

	private boolean createNewUser(){
		boolean keepTrying = true;
		while(keepTrying) {

		}
		return false;
	}
	private boolean login() {
		boolean keepTrying = true;
		while(keepTrying){
		}
		return false;
	}

	private boolean interfaceSetup(){
		return bi.setUp();
	}

	private void session(){
		boolean exit = false;
		while(!exit){
			System.out.println(BankAppHelper.sessionMenu(bi));
		}
	}


	private void close(){
		bi = null;
		s.close();
	}
}
