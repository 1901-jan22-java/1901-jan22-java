package com.revature.account;

public class Account {
	private String userName;
	private int actualPassword; 
	private int amount;
	
	public Account(String userName, String password, int amount) {
		this.userName = userName;
		this.actualPassword = generatePassword(password);
		this.amount = amount;
	}
	
	public Account(String userName, String password, String amount) {
		this(userName, password, Integer.parseInt(amount));
	}
	
	private static int generatePassword(String pass) {
		return pass.hashCode();
		
	}
	
	public synchronized boolean withdraw(int moneyOut) {
		if(moneyOut <= amount) {
			this.amount -= moneyOut;
		} else {
			return false;
		}
		
		return true;
	}
	
	public synchronized boolean deposit(int moneyIn) {
		this.amount += moneyIn;
		return true;
	}
	
	public int viewAccount() {
		return this.amount;
	}
	
	public String toString() {
		return userName + "," + actualPassword + "," + amount;
	}
	
	public static boolean checkPass(String pass, String test) {
		if((generatePassword(pass) + "").equals(test)) {
			return true;
		} 
		return false;
	}
	
	public String getName() {
		return this.userName;
	}
}
