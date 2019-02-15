package com.revature.bank.app;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.bank.dao.AccountRepository;
import com.revature.bank.dao.UserRepository;
import com.revature.bank.exceptions.NoSuchBankUserException;
import com.revature.bank.exceptions.UnableToGenerateKeyException;
import com.revature.bank.exceptions.UserAlreadyExistsException;
import com.revature.bank.main.BankingInterface;
import com.revature.bank.pojos.Account;
import com.revature.bank.pojos.User;
import com.revature.utils.MyUtils;

public class BankApp {

	private static final Logger logger = Logger.getLogger(BankApp.class);
	
	private BankingInterface bi;
//	private ArrayList<Account> accounts;
	private Scanner s;

	public BankApp(){
		bi = null;
		s = new Scanner(System.in);
	}

	public static void main(String[] args) {
		BankApp ba = new BankApp();
		ba.banking();
	}

	public void banking(){
		boolean exit = false;
		while(!exit) {
			System.out.println();
			System.out.print(BankAppHelper.MAIN_MENU);
			int selection = s.nextInt();
			s.nextLine();
			switch(selection) {
				case(1):
					System.out.println();
					createNewUser();
					break;
				case(2):
					System.out.println();
					if(login()) {
						System.out.println();
						session();
					}
					break;
				default:
					exit = true;
			}
		}
		System.out.println();
		System.out.println(BankAppHelper.MAIN_MENU_EXIT);
		close();
	}

	private boolean createNewUser(){
		boolean keepTrying = true;
		boolean validUser = false;
		boolean validPass = false;
		String username = "";
		String password = "";
		while(keepTrying) {
			while(!validUser && keepTrying) {
				System.out.print(BankAppHelper.CREATE_USERNAME_PROMPT);
				username = s.nextLine();

				validUser = MyUtils.isValidEmail(username);
				keepTrying = !username.equalsIgnoreCase("exit");

				if(!validUser && keepTrying)
					System.out.println(BankAppHelper.USERNAME_INVALID);
			}
			while(!validPass && keepTrying) {
				System.out.print(BankAppHelper.CREATE_PASSWORD_PROMPT);
				password = s.nextLine();

				keepTrying = !password.equalsIgnoreCase("exit");
				validPass = MyUtils.isValidPassword(password);

				if(!validPass && keepTrying)
					System.out.println(BankAppHelper.PASSWORD_INVALID);
			}
			if(validUser && validPass && keepTrying) {
				try {
					UserRepository.createUser(username, password);
					System.out.println(BankAppHelper.CREATE_USER_SUCCESS);
					System.out.println(BankAppHelper.CREATE_USER_EXIT);

					return true;
				} catch (UserAlreadyExistsException | UnableToGenerateKeyException e) {
					logger.error("An Exception has occurred in BankApp.createNewUser()!", e);
					System.out.println(BankAppHelper.createUserFailure(username, MyUtils.obfuscate(password, 3)));
					validUser = false;
					validPass = false;
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
		while(keepTrying) {
			System.out.println(BankAppHelper.LOGIN_PROMPT);
			while(!validUser && keepTrying) {
				System.out.print(BankAppHelper.LOGIN_USERNAME_PROMPT);
				username = s.nextLine();
				
				validUser = MyUtils.isValidEmail(username);
				keepTrying = !username.equalsIgnoreCase("exit");
				
				if(!validUser && keepTrying) System.out.println(BankAppHelper.USERNAME_INVALID);
			}
			
			while(!validPass && keepTrying) {
				System.out.print(BankAppHelper.LOGIN_PASSWORD_PROMPT);
				password = s.nextLine();

				validPass = MyUtils.isValidPassword(password);
				keepTrying = !password.equalsIgnoreCase("exit");

				if(!validUser && keepTrying)
					System.out.println(BankAppHelper.PASSWORD_INVALID);
			}
			
			if(validUser && validPass && keepTrying) {
				try {
					bi = new BankingInterface(new User(username, password));
					System.out.println(BankAppHelper.LOGIN_USER_SUCCESS);
					return true;
				} catch (NoSuchBankUserException e) {
					logger.error("NoSuchBankUserException occurred while signing in!", e);
					System.out.println(BankAppHelper.LOGIN_USER_FAILURE);
					validUser = false;
					validPass = false;
				}
			}
		}
		System.out.println(BankAppHelper.LOGIN_USER_EXIT);
		return false;
	}


	private void session(){
		boolean exit = false;
		while(!exit){
			System.out.print(BankAppHelper.sessionMenu(bi));
			int selection = s.nextInt();
			s.nextLine();
			switch(selection) {
			case(1):
				createNewAccount();
				break;
			case(2):
				exit = true;
				break;
			default:
				if(selection > 2 && selection < bi.getAccounts().size()+3) {
					editAccount(selection - 3);
				} else {
					System.out.println(BankAppHelper.SESSION_INVALID_ACCOUNT_INDEX);
				}
			}
		}
		System.out.println(BankAppHelper.SESSION_LOGOUT);
	}
	
	private void createNewAccount() {
		boolean exit = false;
		while(!exit) {
			System.out.print(BankAppHelper.sessionAccountTypePrompt());
			Integer select = s.nextInt();
			s.nextLine();
			
			try {
				if(select >= 0 && select < BankingInterface.ACCOUNT_TYPES.size()) {
					AccountRepository.addAccount(bi.getUser().getUserID(), select, 0.0);
					exit = true;
				} else {
					System.out.println(BankAppHelper.SESSION_CREATE_ACCOUNT_TYPE_INVALID);
					exit = s.nextLine().equalsIgnoreCase("exit");
				}
			} catch (UnableToGenerateKeyException e) {
				logger.error("UnableToGenerateKeyException occurred while creating an account.", e);
			}
		}
		return;
	}

	private void editAccount(int select) {
		boolean exit = false;
		while(!exit){
			Account acc = bi.getAccounts().get(select);

			System.out.print(BankAppHelper.sessionAccountPrompt(bi, select));
			int selection = s.nextInt();
			s.nextLine();

			System.out.print(BankAppHelper.SESSION_AMOUNT_PROMPT);
			Double amt = s.nextDouble();
			s.nextLine();

			switch(selection) {
			case(1):
				bi.withdraw(acc, amt);
				break;
			case(2):
				bi.deposit(acc, amt);
				break;
			default:
				exit = true;
			}
		}
	}

	private void close(){
		bi = null;
		s.close();
	}
}
