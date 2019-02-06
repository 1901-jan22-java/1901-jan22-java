package com.revature.bank.main;

import com.revature.bank.app.BankingInterface;

import java.util.Scanner;

public class BankApp {

	private BankingInterface bi;
	private Scanner s;

	public BankApp(){
		bi = new BankingInterface();
		s = new Scanner(System.in);
	}

	public static void main(String[] args) {
		BankApp ba = new BankApp();
		ba.banking();
	}

	public void banking(){
		boolean exit = false;
		while(!exit) {
			System.out.print(BankAppHelper.CREATE_LOGIN_MENU);
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

	private boolean login(){
		boolean keepTrying = true;
		while(keepTrying){

		}
		return false;
	}

	private void session(){
		System.out.println("Session");
	}

	private boolean createNewUser(){
		System.out.println("Create New!");
		return false;
	}

	private void close(){
		System.out.println("Outta here!");
	}
}
