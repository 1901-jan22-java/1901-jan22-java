package com.ravature.bank.pojos;

public class Withdraw {
	private int accountId;
	private double amount;
	public Withdraw(){}
	public Withdraw(int accountId, double amount) {
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
		return "Withdraw [accountId=" + accountId + ", amount=" + amount + "]";
	}
}