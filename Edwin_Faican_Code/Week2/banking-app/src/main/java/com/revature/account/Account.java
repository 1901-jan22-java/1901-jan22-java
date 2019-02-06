package com.revature.account;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.revature.app.App;

public class Account {
	final static Logger logger = Logger.getLogger(Account.class);
	
	private String type;
	private int acctNumber;
	private BigDecimal balance;

	public Account() {};
	
	public Account(int acctNumber, String type, double amount) {
		this.acctNumber = acctNumber;
		this.type = type;
		this.balance = new BigDecimal(amount + "");
	}
	
	public Account(int acctNumber, String type, String amount) {
		this(acctNumber, type, Double.parseDouble(amount));
	}
	
	public int getAcctNumber() {
		return this.acctNumber;
	}
	
	public void setAcctNumber(int acctNumber) {
		this.acctNumber = acctNumber;
	}
	
	public double getBalance() {
		return balance.doubleValue();
	}

	public void setBalance(double balance) {
		this.balance = new BigDecimal(balance + "");
	}
	
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public synchronized boolean withdraw(BigDecimal moneyOut) {
		if(moneyOut.compareTo(balance) <= 0) {
			this.balance = this.balance.subtract(moneyOut);
		} else {
			return false;
		}
		
		return true;
	}
	
	public synchronized boolean deposit(BigDecimal moneyIn) {
		this.balance = this.balance.add(moneyIn);
		return true;
	}
	
	public double viewAccount() {
		return this.balance.doubleValue();
	}
	
	public String toString() {
		String acctNum = "" + acctNumber;
		acctNum = acctNum.substring(acctNum.length()-5);
		return "Account Number: X-" + acctNum + " -> " + type + ": $" + balance;
	}
}
