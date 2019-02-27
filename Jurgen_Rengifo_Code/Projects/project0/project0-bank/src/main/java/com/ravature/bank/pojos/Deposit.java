package com.ravature.bank.pojos;

public class Deposit {
	private int accountId;
	private double amount;
	public Deposit(){}
	public Deposit(int accountId, double amount) {
		super();
		this.accountId = accountId;
		this.amount = amount;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Deposit [accountId=" + accountId + ", amount=" + amount + "]";
	}
}