package com.revature.bank.pojos;

public class Account {
	
	/* Instance Variables */
	private Integer accountID;
	private Integer userID;
	private Integer typeID;
	private Double balance;
	
	/* Constructors */

	public Account(Integer accountID, Integer userID, Integer typeID, Double balance) {
		this.accountID = accountID;
		this.userID = userID;
		this.typeID = typeID;
		this.balance = balance;
	}
	/* Overrided Methods */

	@Override
	public String toString() {
		return "Account{" +
				"accountID=" + accountID +
				", userID=" + userID +
				", typeID=" + typeID +
				", balance=" + balance +
				'}';
	}
	/* Getters Setters */

	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getTypeID() {
		return typeID;
	}

	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
