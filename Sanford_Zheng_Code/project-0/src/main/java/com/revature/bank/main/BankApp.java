package com.revature.bank.main;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.bank.app.BankingInterface;
import com.revature.bank.dao.UserRepository;
import com.revature.bank.exceptions.NoSuchBankUserException;
import com.revature.bank.exceptions.UnableToGenerateKeyException;
import com.revature.bank.pojos.Account;

import zheng.sanford.utils.MyUtils;

public class BankApp {

	private static final Logger logger = Logger.getLogger(BankApp.class);
	
	private BankingInterface bi;
	private ArrayList<Account> accounts;
	private Scanner s;

	public BankApp(){
		bi = null;
		s = new Scanner(System.in);
	}

	public static void main(String[] args) {
		BankApp ba = new BankApp();
		ba.banking();
		ba.close();
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
						interfaceSetup();
						session();
					break;
				default:
					exit = true;
			}
		}
	}

	private boolean createNewUser(){
		boolean keepTrying = true;
		boolean validUser = false;
		boolean validPass = false;
		String username = "";
		String password = "";
		while(keepTrying) {
			while(!validUser && keepTrying) {
				System.out.println(BankAppHelper.CREATE_USERNAME_PROMPT);
				username = MyUtils.format(s.nextLine());
				validUser = BankAppHelper.isValidEmail(username);
				keepTrying = !username.equalsIgnoreCase("exit");
				if(!validUser) {
					System.out.println(BankAppHelper.USERNAME_INVALID);
				}
			}
			while(!validPass && keepTrying) {
				System.out.println(BankAppHelper.CREATE_PASSWORD_PROMPT);
				password = s.nextLine();
				validPass = BankAppHelper.isValidPassword(password);
				keepTrying = !password.equalsIgnoreCase("exit");
				if(!validUser)
					System.out.println(BankAppHelper.PASSWORD_INVALID);
			}
			if(validUser && validPass && keepTrying) {
				try {
					UserRepository.createUser(username, password);
					System.out.println(BankAppHelper.CREATE_USER_SUCCESS);
					System.out.println(BankAppHelper.CREATE_USER_EXIT);
					return true;
				} catch(UnableToGenerateKeyException e) {
					logger.error("UnableToGenerateKeyException occurred in creating user!", e);
					System.out.println(BankAppHelper.CREATE_USER_FAILURE);
				}
			}
		}
		System.out.println(BankAppHelper.CREATE_USER_EXIT);
		return false;
	}

	private boolean login() {
		boolean keepTrying = true;
		boolean validUser = false;
		boolean validPass = false;
		String username = "";
		String password = "";
		while(keepTrying){
			while(!validUser && keepTrying) {
				System.out.println(BankAppHelper.LOGIN_USERNAME_PROMPT);
				username = MyUtils.format(s.nextLine());
				validUser = BankAppHelper.isValidEmail(username);
				keepTrying = !username.equalsIgnoreCase("exit");
				if(!validUser) {
					System.out.println(BankAppHelper.USERNAME_INVALID);
				}
			}
			while(!validPass && keepTrying) {
				System.out.println(BankAppHelper.LOGIN_PASSWORD_PROMPT);
				password = s.nextLine();
				validPass = BankAppHelper.isValidPassword(password);
				keepTrying = !password.equalsIgnoreCase("exit");
				if(!validUser)
					System.out.println(BankAppHelper.PASSWORD_INVALID);
			}
			if(validUser && validPass && keepTrying) {
				try {
					if(bi.signIn(username, password)) {
						System.out.println(BankAppHelper.LOGIN_USER_SUCCESS);
						System.out.println(BankAppHelper.LOGIN_USER_EXIT);
						return true;
					}
				} catch(NoSuchBankUserException e) {
					logger.error("UnableToGenerateKeyException occurred in creating user!", e);
					System.out.println(BankAppHelper.LOGIN_USER_FAILURE);
				}
			}
		}
		System.out.println(BankAppHelper.LOGIN_USER_EXIT);
		return false;
	}

	private boolean interfaceSetup(){
		boolean res = bi.setUp();
		accounts = bi.getAccounts();
		return res;
	}

	private void session(){
		boolean exit = false;
		while(!exit){
			System.out.println(BankAppHelper.sessionMenu(bi));
			int selection = s.nextInt();
			s.nextLine();
			switch(selection) {
			case(1):
				break;
			case(2):
			default:
				if(selection > 2 && selection < accounts.size()+3) {
					editAccount(selection - 3);
				} else exit = true;
			}
		}
	}

	private void editAccount(int select) {
		boolean exit = false;
		while(!exit){
			System.out.println(BankAppHelper.sessionMenu(bi));
			int selection = s.nextInt();
			s.nextLine();
			switch(selection) {
			case(1):
				break;
			case(2):
			default:
				if(selection > 2 && selection < accounts.size()+3) {
					editAccount(selection - 3);
				} else exit = true;
			}
		}
	}

	private void close(){
		bi = null;
		s.close();
	}
}
