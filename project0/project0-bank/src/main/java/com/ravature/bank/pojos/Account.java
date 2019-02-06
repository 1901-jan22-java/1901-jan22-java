package com.ravature.bank.pojos;

public class Account {
	private Double balance;
	private int account_Id;
	private int user_Id;
	private String account_Type;
	public Account() {
	}
	public Account(int account_Id, int user_Id, String account_Type, double balance) {
		super();
		this.account_Id = account_Id;
		this.user_Id = user_Id;
		this.account_Type = account_Type;
		this.balance = balance;
	}
	public int getAccountId() {
		return account_Id;
	}
	public void setAccountId(int account_Id) {
		this.account_Id = account_Id;
	}
	public int getUserId() {
		return user_Id;
	}
	public void setUserId(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getAccountType() {
		return account_Type;
	}
	public void setAccountType(String account_Type) {
		this.account_Type = account_Type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + account_Id + ", userId=" + user_Id + ", accountType=" + account_Type + ", amount=" + balance + "]";
	}
}